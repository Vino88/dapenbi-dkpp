package com.dapenbi.dkpp.controller.api;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.PredikatPemberhentianDao;
import com.dapenbi.dkpp.dto.PredikatPemberhentianDto;
import com.dapenbi.dkpp.form.PredikatPemberhentianFormDto;
import com.dapenbi.dkpp.model.PredikatPemberhentian;
import com.dapenbi.dkpp.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(PathPrefix.API + PathPrefix.PREDIKAT_PEMBERHENTIAN)
public class PredikatPemberhentianApiController extends DropdownApiController {

    @Autowired
    public PredikatPemberhentianApiController(PredikatPemberhentianDao predikatPemberhentianDao) {
        super(predikatPemberhentianDao);
    }

    @GetMapping
    public Page<PredikatPemberhentianDto> index(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam){
        PredikatPemberhentianDao predikatPemberhentianDao = (PredikatPemberhentianDao) super.baseDao;

        Page<PredikatPemberhentian> pIt = (Page<PredikatPemberhentian>) predikatPemberhentianDao.findAll(new String[] {"namaPemberhentian"},"%" + searchParam + "%",pageRequest);

        return pIt.map(PredikatPemberhentian::toDto);
    }

    @PostMapping
    public ResponseEntity<MessageUtil> addPredikatPemberhentian(@ModelAttribute PredikatPemberhentianFormDto predikatPemberhentianFormDto){
        PredikatPemberhentianDao predikatPemberhentianDao = (PredikatPemberhentianDao) super.baseDao;

        PredikatPemberhentian predikatPemberhentian = new PredikatPemberhentian();

        predikatPemberhentian.setNamaPemberhentian(predikatPemberhentianFormDto.getNamaPemberhentian());

        PredikatPemberhentianDto dto = predikatPemberhentianDao.save(predikatPemberhentian).toDto();

        MessageUtil msg;
        if(dto != null){
            msg = new MessageUtil("success", "Data berhasil ditambahkan");
        } else {
            msg = new MessageUtil("failed", "Data gagal disimpan");
        }
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<MessageUtil> updatepredikat(@ModelAttribute PredikatPemberhentianFormDto predikatPemberhentianFormDto){
        PredikatPemberhentianDao predikatPemberhentianDao = (PredikatPemberhentianDao) super.baseDao;
        PredikatPemberhentian predikatPemberhentian = (PredikatPemberhentian) super.baseDao.findById(predikatPemberhentianFormDto.getId());

        predikatPemberhentian.setNamaPemberhentian(predikatPemberhentianFormDto.getNamaPemberhentian());
        predikatPemberhentian.setActive(predikatPemberhentianFormDto.getActive() !=null && predikatPemberhentianFormDto.getActive().size() > 0);

        PredikatPemberhentianDto dto = predikatPemberhentianDao.save(predikatPemberhentian).toDto();
        MessageUtil msg;
        if (dto != null){
            msg = new MessageUtil("success", "Data Berhasil Dirubah");
        }else {
            msg = new MessageUtil("failed", "Data Gagal Dirubah");
        }
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }
}
