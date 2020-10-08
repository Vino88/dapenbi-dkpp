package com.dapenbi.dkpp.controller.api;


import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.JenisMpsDao;
import com.dapenbi.dkpp.dao.ProvinsiDao;
import com.dapenbi.dkpp.dto.JenisBankDto;
import com.dapenbi.dkpp.dto.JenisMpsDto;
import com.dapenbi.dkpp.dto.ProvinsiDto;
import com.dapenbi.dkpp.form.JenisMpsFormDto;
import com.dapenbi.dkpp.form.ProvinsiFormDto;
import com.dapenbi.dkpp.model.JenisMps;
import com.dapenbi.dkpp.model.Provinsi;
import com.dapenbi.dkpp.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(PathPrefix.API + PathPrefix.JENISMPS)
public class JenisMpsApiController {

    @Autowired
    JenisMpsDao jenisMpsDao;

    @GetMapping
    public Page<JenisMpsDto> index(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam){
        Page<JenisMps> pIt = (Page<JenisMps>) jenisMpsDao.findAll(new String[]{"namamps"}, "%" + searchParam + "%", pageRequest);

        Page<JenisMpsDto> mpsDto = pIt.map(p ->p.toDto() );
        return mpsDto;
    }

    @PostMapping
    public ResponseEntity<MessageUtil> addJenisMps(@ModelAttribute JenisMpsFormDto jenisMpsFormDto){
        JenisMps jenisMps = new JenisMps();
        jenisMps.setNamamps(jenisMpsFormDto.getNamamps());
        JenisMpsDto dto = jenisMpsDao.save(jenisMps).toDto();
        MessageUtil msg;
        if (dto != null){
            msg = new MessageUtil("success","Data Berhasil Ditambahkan");
        }else {
            msg = new MessageUtil("failed","Data Gagal Ditambahkan");
        }
        return new ResponseEntity<MessageUtil>(msg, HttpStatus.OK);

    }

    @PutMapping
    public ResponseEntity<MessageUtil> updateJenisMps(@ModelAttribute JenisMpsFormDto jenisMpsFormDto){
        JenisMps jenisMps = jenisMpsDao.findById(jenisMpsFormDto.getId());

        jenisMps.setNamamps(jenisMpsFormDto.getNamamps());
        jenisMps.setActive(jenisMpsFormDto.getActive() !=null && jenisMpsFormDto.getActive().size() > 0);
        JenisMpsDto dto = jenisMpsDao.save(jenisMps).toDto();
        MessageUtil msg;

        if(dto != null){
            msg = new MessageUtil("success", "Data Berhasil Dirubah");
        } else {
            msg = new MessageUtil("failed", "Data Gagal Dirubah");
        }
        return new ResponseEntity<MessageUtil>(msg, HttpStatus.OK);
    }
}
