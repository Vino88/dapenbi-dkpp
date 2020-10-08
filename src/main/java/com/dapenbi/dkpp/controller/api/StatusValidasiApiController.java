package com.dapenbi.dkpp.controller.api;


import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.ProvinsiDao;
import com.dapenbi.dkpp.dao.StatusValidasiDao;
import com.dapenbi.dkpp.dao.UsiaBayarDao;
import com.dapenbi.dkpp.dto.ProvinsiDto;
import com.dapenbi.dkpp.dto.StatusValidasiDto;
import com.dapenbi.dkpp.dto.UsiaBayarDto;
import com.dapenbi.dkpp.form.ProvinsiFormDto;
import com.dapenbi.dkpp.form.StatusValidasiFormDto;
import com.dapenbi.dkpp.form.UsiaBayarFormDto;
import com.dapenbi.dkpp.model.Provinsi;
import com.dapenbi.dkpp.model.StatusValidasi;
import com.dapenbi.dkpp.model.UsiaBayar;
import com.dapenbi.dkpp.util.DkppUserStamp;
import com.dapenbi.dkpp.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(PathPrefix.API + PathPrefix.STATUSVALIDASI)
public class StatusValidasiApiController {

    @Autowired
    StatusValidasiDao statusValidasiDao;

    @GetMapping
    public Page<StatusValidasiDto> index(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam){
        Page<StatusValidasi> pIt = (Page<StatusValidasi>) statusValidasiDao.findAll(new String[]{"namaValidasi"}, "%" + searchParam + "%", pageRequest);

        Page<StatusValidasiDto> statusValidasiDto = pIt.map(p ->p.toDto() );
        return statusValidasiDto;
    }

    @PostMapping
    public ResponseEntity<MessageUtil> addStatusValidasi(@ModelAttribute StatusValidasiFormDto statusValidasiFormDto){
        StatusValidasi statusValidasi = new StatusValidasi();
        statusValidasi.setNamaValidasi(statusValidasiFormDto.getNamaValidasi());
        statusValidasi.setUserStamp(DkppUserStamp.postModeUserStamp());
        StatusValidasiDto dto = statusValidasiDao.save(statusValidasi).toDto();
        MessageUtil msg;
        if (dto != null){
            msg = new MessageUtil("success","Data Berhasil Ditambahkan");
        }else {
            msg = new MessageUtil("failed","Data Gagal Ditambahkan");
        }
        return new ResponseEntity<MessageUtil>(msg, HttpStatus.OK);

    }

    @PutMapping
    public ResponseEntity<MessageUtil> updateStatusValidasi(@ModelAttribute StatusValidasiFormDto statusValidasiFormDto){
        StatusValidasi statusValidasi = statusValidasiDao.findById(statusValidasiFormDto.getId());

        statusValidasi.setNamaValidasi(statusValidasiFormDto.getNamaValidasi());
        statusValidasi.setActive(statusValidasiFormDto.getActive() !=null && statusValidasiFormDto.getActive().size() > 0);
        statusValidasi.setUserStamp(DkppUserStamp.putModeUserStamp());
        StatusValidasiDto dto = statusValidasiDao.save(statusValidasi).toDto();
        MessageUtil msg;

        if(dto != null){
            msg = new MessageUtil("success", "Data Berhasil Dirubah");
        } else {
            msg = new MessageUtil("failed", "Data Gagal Dirubah");
        }
        return new ResponseEntity<MessageUtil>(msg, HttpStatus.OK);
    }
}
