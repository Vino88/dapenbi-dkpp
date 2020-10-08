package com.dapenbi.dkpp.controller.api;


import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.FaktorFsDao;
import com.dapenbi.dkpp.dao.KategoriPenerimaDao;
import com.dapenbi.dkpp.dao.KeluargaPensiunDao;
import com.dapenbi.dkpp.dto.FaktorFsDto;
import com.dapenbi.dkpp.dto.KeluargaPensiunDto;
import com.dapenbi.dkpp.form.FaktorFsFormDto;
import com.dapenbi.dkpp.form.KeluargaPensiunFormDto;
import com.dapenbi.dkpp.model.FaktorFs;
import com.dapenbi.dkpp.model.KategoriPenerima;
import com.dapenbi.dkpp.model.KeluargaPensiun;
import com.dapenbi.dkpp.util.DkppUserStamp;
import com.dapenbi.dkpp.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(PathPrefix.API + PathPrefix.FAKTOR_FS)
public class FaktorFsApiController {
    @Autowired
    FaktorFsDao faktorFsDao;

    @GetMapping
    public Page<FaktorFsDto> index(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam) {
        Page<FaktorFs> aIt = (Page<FaktorFs>) faktorFsDao.findAll(new String[] {"namaFaktorFs"}, "%" + searchParam + "%", pageRequest);

        Page<FaktorFsDto> faktorFsDto = aIt.map(u -> u.toDto());

        return faktorFsDto;
    }

    @PostMapping
    public ResponseEntity<MessageUtil> addFaktorFs(@ModelAttribute FaktorFsFormDto faktorFsFormDto){
        FaktorFs faktorFs = new FaktorFs();
        faktorFs.setNamaFaktorFs(faktorFsFormDto.getNamaFaktorFs());
        faktorFs.setKeteranganFaktorFs(faktorFsFormDto.getKeteranganFaktorFs());
        faktorFs.setTglAwal(faktorFsFormDto.getTglAwal());
        faktorFs.setTglAkhir(faktorFsFormDto.getTglAkhir());
        faktorFs.setUserStamp(DkppUserStamp.postModeUserStamp());
        faktorFs.setActive(true);
        FaktorFsDto dto = faktorFsDao.save(faktorFs).toDto();
        MessageUtil messageUtil;
        if(dto != null){
            messageUtil = new MessageUtil("success", "Data berhasil ditambahkan");
        } else {
            messageUtil = new MessageUtil("failed", "Data gagal disimpan");
        }
        return new ResponseEntity<MessageUtil>(messageUtil, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<MessageUtil> updateFaktorFs(@ModelAttribute FaktorFsFormDto faktorFsFormDto){
        FaktorFs faktorFs= faktorFsDao.findById(faktorFsFormDto.getId());
        faktorFs.setTglAwal(faktorFsFormDto.getTglAwal());
        faktorFs.setTglAkhir(faktorFsFormDto.getTglAkhir());
        faktorFs.setNamaFaktorFs(faktorFsFormDto.getNamaFaktorFs());
        faktorFs.setKeteranganFaktorFs(faktorFsFormDto.getKeteranganFaktorFs());
        faktorFs.setActive(faktorFsFormDto.getActive() != null && faktorFsFormDto.getActive().size() > 0);
        faktorFs.setUserStamp(DkppUserStamp.putModeUserStamp());

        FaktorFsDto dto = faktorFsDao.save(faktorFs).toDto();
        MessageUtil messageUtil;
        if(dto != null){
            messageUtil = new MessageUtil("success", "Data berhasil disimpan");
        } else {
            messageUtil = new MessageUtil("failed", "Data gagal disimpan");
        }
        return new ResponseEntity<MessageUtil>(messageUtil, HttpStatus.OK);
    }

}
