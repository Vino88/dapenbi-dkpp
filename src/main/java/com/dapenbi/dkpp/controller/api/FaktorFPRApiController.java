package com.dapenbi.dkpp.controller.api;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.BaseDao;
import com.dapenbi.dkpp.dao.FaktorFPRDao;
import com.dapenbi.dkpp.dto.FaktorFprDto;
import com.dapenbi.dkpp.form.FaktorFPRFormDto;
import com.dapenbi.dkpp.model.FaktorFPR;
import com.dapenbi.dkpp.util.DkppUserStamp;
import com.dapenbi.dkpp.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(PathPrefix.API + PathPrefix.FAKTORFPR)
public class FaktorFPRApiController extends DropdownApiController {

    @Autowired
    public FaktorFPRApiController(FaktorFPRDao faktorFPRDao) {
        super(faktorFPRDao);
    }

    @GetMapping
    public Page <FaktorFprDto> index(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam){
        FaktorFPRDao faktorFPRDao = (FaktorFPRDao) this.baseDao;
        Page<FaktorFPR> fIt = (Page<FaktorFPR>) faktorFPRDao.findAll(new String[]{"namafaktor"},"%" + searchParam + "%",pageRequest);
        Page<FaktorFprDto> faktorFprDto = fIt.map(f ->f.toDto() );
        return faktorFprDto;
    }

    @PostMapping
    public ResponseEntity<MessageUtil> addFaktor(@ModelAttribute FaktorFPRFormDto faktorFPRFormDto){
        FaktorFPRDao faktorFPRDao = (FaktorFPRDao) this.baseDao;
        FaktorFPR faktorFPR = new FaktorFPR();
        faktorFPR.setNamafaktor(faktorFPRFormDto.getNamafaktor());
        faktorFPR.setTglawal(faktorFPRFormDto.getTglawal());
        faktorFPR.setTglakhir(faktorFPRFormDto.getTglakhir());
        faktorFPR.setKeteranganfaktor(faktorFPRFormDto.getKeteranganfaktor());
        faktorFPR.setUserStamp(DkppUserStamp.postModeUserStamp());
        FaktorFprDto dto = faktorFPRDao.save(faktorFPR).toDto();
        MessageUtil msg;
        if(dto != null){
            msg = new MessageUtil("success", "Data berhasil ditambahkan");
        } else {
            msg = new MessageUtil("failed", "Data gagal disimpan");
        }
        return new ResponseEntity<MessageUtil>(msg, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<MessageUtil> putFaktor(@ModelAttribute FaktorFPRFormDto faktorFPRFormDto){
        FaktorFPRDao faktorFPRDao = (FaktorFPRDao) this.baseDao;
        FaktorFPR faktorFPR = faktorFPRDao.findById(faktorFPRFormDto.getId());
        faktorFPR.setNamafaktor(faktorFPRFormDto.getNamafaktor());
        faktorFPR.setTglawal(faktorFPRFormDto.getTglawal());
        faktorFPR.setTglakhir(faktorFPRFormDto.getTglakhir());
        faktorFPR.setKeteranganfaktor(faktorFPRFormDto.getKeteranganfaktor());
        faktorFPR.setActive(faktorFPRFormDto.getActive() !=null && faktorFPRFormDto.getActive().size() > 0);
        faktorFPR.setUserStamp(DkppUserStamp.putModeUserStamp());
        FaktorFprDto dto = faktorFPRDao.save(faktorFPR).toDto();
        MessageUtil msg;
            if (dto != null){
            msg = new MessageUtil("success", "Data Berhasil Dirubah");
        }else {
            msg = new MessageUtil("failed", "Data Gagal Dirubah");
        }
        return new ResponseEntity<MessageUtil>(msg, HttpStatus.OK);
    }

}
