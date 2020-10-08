package com.dapenbi.dkpp.controller.api;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.AgamaDao;
import com.dapenbi.dkpp.dao.BaseDao;
import com.dapenbi.dkpp.dao.GolonganDao;
import com.dapenbi.dkpp.dto.GolonganDto;
import com.dapenbi.dkpp.dto.component.Select2Default;
import com.dapenbi.dkpp.form.GolonganFormDto;
import com.dapenbi.dkpp.model.Golongan;
import com.dapenbi.dkpp.util.DkppUserStamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(PathPrefix.API + PathPrefix.GOLONGAN)
public class GolonganApiController extends DropdownApiController {

    @Autowired
    public GolonganApiController(GolonganDao golonganDao) {
        super(golonganDao);
    }

    @GetMapping
    public Page<GolonganDto> index(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam) {
        GolonganDao golonganDao = (GolonganDao) super.baseDao;
        Page<Golongan> uIt = (Page<Golongan>) golonganDao.findAll(new String[] {"namaGolongan"}, "%" + searchParam + "%", pageRequest);

        return uIt.map(Golongan::toDto);
    }

    @PostMapping
    public GolonganDto addGolongan(@ModelAttribute GolonganFormDto golonganForm){
        GolonganDao golonganDao = (GolonganDao) super.baseDao;

        Golongan golongan = new Golongan();

        golongan.setNoGolongan(golonganForm.getNoGolongan());
        golongan.setNamaGolongan(golonganForm.getNamaGolongan());
        golongan.setNamaGolonganLama(golonganForm.getNamaGolonganLama());
        golongan.setPangkat(golonganForm.getPangkat());
        golongan.setJabatan(golonganForm.getJabatan());
        golongan.setEselon(golonganForm.getEselon());
        golongan.setActive(golonganForm.getActive() != null && golonganForm.getActive().size() > 0);
        golongan.setUserStamp(DkppUserStamp.postModeUserStamp());
        return golonganDao.save(golongan).toDto();

    }

    @PutMapping
    public GolonganDto updateGolongan(@ModelAttribute GolonganFormDto golonganForm) {
        GolonganDao golonganDao = (GolonganDao) super.baseDao;

        Golongan golongan = (Golongan) baseDao.findById(golonganForm.getId());

        golongan.setNoGolongan(golonganForm.getNoGolongan());
        golongan.setNamaGolongan(golonganForm.getNamaGolongan());
        golongan.setNamaGolonganLama(golonganForm.getNamaGolonganLama());
        golongan.setPangkat(golonganForm.getPangkat());
        golongan.setJabatan(golonganForm.getJabatan());
        golongan.setEselon(golonganForm.getEselon());
        golongan.setActive(golonganForm.getActive() != null && golonganForm.getActive().size() > 0);
        golongan.setUserStamp(DkppUserStamp.postModeUserStamp());
        return golonganDao.save(golongan).toDto();
    }
}
