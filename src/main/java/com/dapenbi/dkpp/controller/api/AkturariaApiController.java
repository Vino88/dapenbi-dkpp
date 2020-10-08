package com.dapenbi.dkpp.controller.api;


import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.AktuariaFprDao;
import com.dapenbi.dkpp.dao.FaktorFPRDao;
import com.dapenbi.dkpp.dto.AktuariaFprDto;
import com.dapenbi.dkpp.form.AktuariaFprFormDto;
import com.dapenbi.dkpp.model.AktuariaFpr;
import com.dapenbi.dkpp.util.DkppUserStamp;
import com.dapenbi.dkpp.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(PathPrefix.API + PathPrefix.AKTUARIAFPR)
public class AkturariaApiController {

    @Autowired
    AktuariaFprDao aktuariaFprDao;

    @Autowired
    FaktorFPRDao faktorFPRDao;

    @GetMapping
    public Page<AktuariaFprDto> index(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam){
        Page<AktuariaFpr> aIt = (Page<AktuariaFpr>) aktuariaFprDao.findAll(new String[]{"usia"}, "%" + searchParam +"%", pageRequest);
        Page<AktuariaFprDto> aktuariaFprDto = aIt.map(a ->{
            AktuariaFprDto dto = a.toDto();
            if (a.getFaktorFPR()!=null) dto.setIdfaktorfpr(a.getFaktorFPR().toDto());
            return dto;
        });

        return aktuariaFprDto;
    }

    @PostMapping
    public ResponseEntity<MessageUtil> addAktuariaFpr(@ModelAttribute AktuariaFprFormDto aktuariaFprFormDto){
        AktuariaFpr aktuariaFpr = new AktuariaFpr();
        aktuariaFpr.setUsia(aktuariaFprFormDto.getUsia());
        aktuariaFpr.setNilaifpr(Double.valueOf(aktuariaFprFormDto.getNilaifpr()));
        aktuariaFpr.setFaktorFPR(faktorFPRDao.findById(Long.valueOf(aktuariaFprFormDto.getIdfaktorfpr())));
        aktuariaFpr.setUserStamp(DkppUserStamp.postModeUserStamp());
        AktuariaFprDto dto = aktuariaFprDao.save(aktuariaFpr).toDto();
        MessageUtil msg;
        if(dto != null){
            msg = new MessageUtil("success", "Data berhasil ditambahkan");
        } else {
            msg = new MessageUtil("failed", "Data gagal disimpan");
        }
        return new ResponseEntity<MessageUtil>(msg, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<MessageUtil> putAktuaria(@ModelAttribute AktuariaFprFormDto aktuariaFprFormDto){
        AktuariaFpr aktuariaFpr = aktuariaFprDao.findById(aktuariaFprFormDto.getId());

        aktuariaFpr.setUsia(aktuariaFprFormDto.getUsia());
        aktuariaFpr.setNilaifpr(Double.valueOf(aktuariaFprFormDto.getNilaifpr()));
        aktuariaFpr.setFaktorFPR(faktorFPRDao.findById(Long.valueOf(aktuariaFprFormDto.getIdfaktorfpr())));
        aktuariaFpr.setActive(aktuariaFprFormDto.getActive() !=null && aktuariaFprFormDto.getActive().size() > 0);
        aktuariaFpr.setUserStamp(DkppUserStamp.putModeUserStamp());
        AktuariaFprDto dto = aktuariaFprDao.save(aktuariaFpr).toDto();
        MessageUtil msg;

        if (dto != null){
            msg = new MessageUtil("success", "Data Berhasil Dirubah");
        }else {
            msg = new MessageUtil("failed", "Data Gagal Dirubah");
        }
        return new ResponseEntity<MessageUtil>(msg, HttpStatus.OK);
    }

}
