package com.dapenbi.dkpp.controller.api;


import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.*;
import com.dapenbi.dkpp.dto.OlahragaDto;
import com.dapenbi.dkpp.dto.RekeningPenerimaMpDto;
import com.dapenbi.dkpp.form.OlahragaFormDto;
import com.dapenbi.dkpp.form.RekeningPenerimaMpFormDto;
import com.dapenbi.dkpp.model.Olahraga;
import com.dapenbi.dkpp.model.RekeningPenerimaMp;
import com.dapenbi.dkpp.util.DkppUserStamp;
import com.dapenbi.dkpp.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(PathPrefix.API + PathPrefix.OLAHRAGA)
public class OlahragaApiController {
    @Autowired
    OlahragaDao olahragaDao;


    @GetMapping
    public Page<OlahragaDto> index(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam) {
        Page<Olahraga> aIt = (Page<Olahraga>) olahragaDao.findAll(new String[] {"namaOlahraga"}, "%" + searchParam + "%", pageRequest);

        Page<OlahragaDto> olahragaDto = aIt.map(u -> u.toDto());

        return olahragaDto;
    }

    @PostMapping
    public ResponseEntity<MessageUtil> addOlahraga(@ModelAttribute OlahragaFormDto olahragaFormDto){
        Olahraga olahraga = new Olahraga();
        olahraga.setNamaOlahraga(olahragaFormDto.getNamaOlahraga());
        olahraga.setActive(olahragaFormDto.getActive() != null && olahragaFormDto.getActive().size() > 0);
        olahraga.setUserStamp(DkppUserStamp.postModeUserStamp());
        olahraga.setActive(true);
        OlahragaDto dto = olahragaDao.save(olahraga).toDto();
        MessageUtil messageUtil;
        if(dto != null){
            messageUtil = new MessageUtil("success", "Data berhasil ditambahkan");
        } else {
            messageUtil = new MessageUtil("failed", "Data gagal disimpan");
        }
        return new ResponseEntity<MessageUtil>(messageUtil, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<MessageUtil> updateOlahraga(@ModelAttribute OlahragaFormDto olahragaFormDto){
        Olahraga olahraga = olahragaDao.findById(olahragaFormDto.getId());
        olahraga.setNamaOlahraga( olahragaFormDto.getNamaOlahraga() );
        olahraga.setActive(olahragaFormDto.getActive() != null && olahragaFormDto.getActive().size() > 0);
        olahraga.setUserStamp(DkppUserStamp.putModeUserStamp());

        OlahragaDto dto = olahragaDao.save(olahraga).toDto();
        MessageUtil messageUtil;
        if(dto != null){
            messageUtil = new MessageUtil("success", "Data berhasil disimpan");
        } else {
            messageUtil = new MessageUtil("failed", "Data gagal disimpan");
        }
        return new ResponseEntity<MessageUtil>(messageUtil, HttpStatus.OK);
    }

}
