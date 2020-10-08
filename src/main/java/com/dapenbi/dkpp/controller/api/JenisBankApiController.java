package com.dapenbi.dkpp.controller.api;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.JenisBankDao;
import com.dapenbi.dkpp.dto.JenisBankDto;
import com.dapenbi.dkpp.form.JenisBankFormDto;
import com.dapenbi.dkpp.model.Golongan;
import com.dapenbi.dkpp.model.JenisBank;
import com.dapenbi.dkpp.util.DkppUserStamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(PathPrefix.API + PathPrefix.JENIS_BANK)
public class JenisBankApiController {

    @Autowired
    JenisBankDao jenisBankDao;

    @GetMapping
    public Page<JenisBankDto> index(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam) {
        Page<JenisBank> uIt = (Page<JenisBank>) jenisBankDao.findAll(new String[] {"jenisBank"}, "%" + searchParam + "%", pageRequest);

        Page<JenisBankDto> jenisBankDto = uIt.map(u -> u.toDto());

        return jenisBankDto;
    }

    @PostMapping
    public JenisBankDto addJenisBank(@ModelAttribute JenisBankFormDto jenisBankForm){
        JenisBank jenisBank = new JenisBank();

        jenisBank.setJenisBank(jenisBankForm.getJenisBank());
        jenisBank.setActive(jenisBankForm.getActive() != null && jenisBankForm.getActive().size() > 0);
        jenisBank.setUserStamp(DkppUserStamp.postModeUserStamp());
        return jenisBankDao.save(jenisBank).toDto();
    }

    @PutMapping
    public JenisBankDto updateJenisBank(@ModelAttribute JenisBankFormDto jenisBankForm) {
        JenisBank jenisBank = jenisBankDao.findById(jenisBankForm.getId());

        jenisBank.setJenisBank(jenisBankForm.getJenisBank());
        jenisBank.setActive(jenisBankForm.getActive() != null && jenisBankForm.getActive().size() > 0);
        jenisBank.setUserStamp(DkppUserStamp.postModeUserStamp());
        return jenisBankDao.save(jenisBank).toDto();

    }
}
