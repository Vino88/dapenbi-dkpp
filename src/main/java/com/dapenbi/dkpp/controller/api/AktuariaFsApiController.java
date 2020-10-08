package com.dapenbi.dkpp.controller.api;


import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.AktuariaFsDao;
import com.dapenbi.dkpp.dao.FaktorFsDao;
import com.dapenbi.dkpp.dto.AktuariaFprDto;
import com.dapenbi.dkpp.dto.AktuariaFsDto;
import com.dapenbi.dkpp.dto.FaktorFsDto;
import com.dapenbi.dkpp.form.AktuariaFsFormDto;
import com.dapenbi.dkpp.form.FaktorFsFormDto;
import com.dapenbi.dkpp.model.AktuariaFs;
import com.dapenbi.dkpp.model.FaktorFs;
import com.dapenbi.dkpp.util.DkppUserStamp;
import com.dapenbi.dkpp.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(PathPrefix.API + PathPrefix.AKTUARIA_FS)
public class AktuariaFsApiController {
    @Autowired
    AktuariaFsDao aktuariaFsDao;

    @Autowired
    FaktorFsDao faktorFsDao;


    @GetMapping
    public Page<AktuariaFsDto> index(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam) {
        Page<AktuariaFs> aIt = (Page<AktuariaFs>) aktuariaFsDao.findAll(new String[] {"usiaFs"}, "%"+searchParam+"%", pageRequest);

        Page<AktuariaFsDto> aktuariaFsDto = aIt.map(u -> {
            AktuariaFsDto dto = u.toDto();
            if (u.getFaktorFs()!=null) dto.setIdFaktorFs(u.getFaktorFs().toDto());
            return dto;
        });

        return aktuariaFsDto;
    }

    @PostMapping
    public ResponseEntity<MessageUtil> addAktuariaFs(@ModelAttribute AktuariaFsFormDto aktuariaFsFormDto){
        AktuariaFs aktuariaFs = new AktuariaFs();
        aktuariaFs.setFaktorFs(faktorFsDao.findById(aktuariaFsFormDto.getIdFaktorFs()));
        aktuariaFs.setUsiaFs(aktuariaFsFormDto.getUsiaFs());
        aktuariaFs.setFsPriaanak(Double.valueOf(aktuariaFsFormDto.getFsPriaanak()));
        aktuariaFs.setFsPrialajang(Double.valueOf(aktuariaFsFormDto.getFsPrialajang()));
        aktuariaFs.setFsPriakawin(Double.valueOf(aktuariaFsFormDto.getFsPriakawin()));
        aktuariaFs.setFsWanitaanak(Double.valueOf(aktuariaFsFormDto.getFsWanitaanak()));
        aktuariaFs.setFsWanitalajang(Double.valueOf(aktuariaFsFormDto.getFsWanitalajang()));
        aktuariaFs.setFsWanitakawin(Double.valueOf(aktuariaFsFormDto.getFsWanitakawin()));
        aktuariaFs.setUserStamp(DkppUserStamp.postModeUserStamp());
        aktuariaFs.setActive(true);
        AktuariaFsDto dto = aktuariaFsDao.save(aktuariaFs).toDto();
        MessageUtil messageUtil;
        if(dto != null){
            messageUtil = new MessageUtil("success", "Data berhasil ditambahkan");
        } else {
            messageUtil = new MessageUtil("failed", "Data gagal disimpan");
        }
        return new ResponseEntity<MessageUtil>(messageUtil, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<MessageUtil> updateAktuariaFs(@ModelAttribute AktuariaFsFormDto aktuariaFsFormDto){
        AktuariaFs aktuariaFs= aktuariaFsDao.findById(aktuariaFsFormDto.getId());
        aktuariaFs.setFaktorFs(faktorFsDao.findById(aktuariaFsFormDto.getIdFaktorFs()));
        aktuariaFs.setUsiaFs(aktuariaFsFormDto.getUsiaFs());
        aktuariaFs.setFsPriaanak(Double.valueOf(aktuariaFsFormDto.getFsPriaanak()));
        aktuariaFs.setFsPrialajang(Double.valueOf(aktuariaFsFormDto.getFsPrialajang()));
        aktuariaFs.setFsPriakawin(Double.valueOf(aktuariaFsFormDto.getFsPriakawin()));
        aktuariaFs.setFsWanitaanak(Double.valueOf(aktuariaFsFormDto.getFsWanitaanak()));
        aktuariaFs.setFsWanitalajang(Double.valueOf(aktuariaFsFormDto.getFsWanitalajang()));
        aktuariaFs.setFsWanitakawin(Double.valueOf(aktuariaFsFormDto.getFsWanitakawin()));
        aktuariaFs.setActive(aktuariaFsFormDto.getActive() != null && aktuariaFsFormDto.getActive().size() > 0);
        aktuariaFs.setUserStamp(DkppUserStamp.putModeUserStamp());

        AktuariaFsDto dto = aktuariaFsDao.save(aktuariaFs).toDto();
        MessageUtil messageUtil;
        if(dto != null){
            messageUtil = new MessageUtil("success", "Data berhasil disimpan");
        } else {
            messageUtil = new MessageUtil("failed", "Data gagal disimpan");
        }
        return new ResponseEntity<MessageUtil>(messageUtil, HttpStatus.OK);
    }

}
