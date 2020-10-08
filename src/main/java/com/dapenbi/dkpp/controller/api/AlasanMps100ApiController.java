package com.dapenbi.dkpp.controller.api;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.AlasanMps100Dao;
import com.dapenbi.dkpp.dao.BaseDao;
import com.dapenbi.dkpp.dto.AlasanMps100Dto;
import com.dapenbi.dkpp.dto.component.Select2Default;
import com.dapenbi.dkpp.form.AlasanMps100FormDto;
import com.dapenbi.dkpp.model.AlasanMps100;
import com.dapenbi.dkpp.model.MPensiun;
import com.dapenbi.dkpp.util.DkppUserStamp;
import com.dapenbi.dkpp.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(PathPrefix.API + PathPrefix.ALASAN_MPS_100)
public class AlasanMps100ApiController extends DropdownApiController{

    private AlasanMps100Dao alasanMps100Dao;

    @Autowired
    public AlasanMps100ApiController(AlasanMps100Dao alasanMps100Dao) {
        super(alasanMps100Dao);
        this.alasanMps100Dao = alasanMps100Dao;
    }

    @GetMapping
    public Page<AlasanMps100Dto> index(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam) {
        Page<AlasanMps100> aIt = (Page<AlasanMps100>) alasanMps100Dao.findAll(new String[] {"namaAlasanMps100"}, "%" + searchParam + "%", pageRequest);

        Page<AlasanMps100Dto> alasanMps100Dto = aIt.map(u -> u.toDto());

        return alasanMps100Dto;
    }

    @GetMapping("/drpd")
    public Object dropdown(){
        return alasanMps100Dao.findAll();
    }

    @PostMapping
    public ResponseEntity<MessageUtil> addAlasanMps100(@ModelAttribute AlasanMps100FormDto alasanMps100FormDto){
        AlasanMps100 alasanMps100 = new AlasanMps100();
        alasanMps100.setNamaAlasanMps100(alasanMps100FormDto.getNamaAlasanMps100());
        alasanMps100.setActive(alasanMps100FormDto.getActive() != null && alasanMps100FormDto.getActive().size() > 0);
        alasanMps100.setUserStamp(DkppUserStamp.postModeUserStamp());
        AlasanMps100Dto dto = alasanMps100Dao.save(alasanMps100).toDto();
        MessageUtil messageUtil;
        if(dto != null){
            messageUtil = new MessageUtil("success", "Data berhasil ditambahkan");
        } else {
            messageUtil = new MessageUtil("failed", "Data gagal disimpan");
        }
        return new ResponseEntity<MessageUtil>(messageUtil, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<MessageUtil> updateAlasanMps100(@ModelAttribute AlasanMps100FormDto alasanMps100FormDto) {
        AlasanMps100 alasanMps100 = alasanMps100Dao.findById(alasanMps100FormDto.getIdAlasanMps100());

        alasanMps100.setNamaAlasanMps100(alasanMps100FormDto.getNamaAlasanMps100());
        alasanMps100.setActive(alasanMps100FormDto.getActive() != null && alasanMps100FormDto.getActive().size() > 0);
        alasanMps100FormDto.setUserStamp(DkppUserStamp.postModeUserStamp());

        AlasanMps100Dto dto = alasanMps100Dao.save(alasanMps100).toDto();
        MessageUtil messageUtil;
        if(dto != null){
            messageUtil = new MessageUtil("success", "Data berhasil ditambahkan");
        } else {
            messageUtil = new MessageUtil("failed", "Data gagal disimpan");
        }
        return new ResponseEntity<MessageUtil>(messageUtil, HttpStatus.OK);
    }

    @GetMapping("/dropdownManual")
    public List<Select2Default> dropDownCustome(Pageable pageable, @RequestParam(name = "searchParam", required = false) String q) {
        Iterable<AlasanMps100> it = alasanMps100Dao.getListAlasanMps100TidakSamaDengan5Param("%" + q + "%", pageable);
        if(q == null){
            it = alasanMps100Dao.getListAlasanMps100TidakSamaDengan5(pageable);
        }
        List<Select2Default> listSelect2 = new ArrayList<Select2Default>();
        it.forEach((k) -> {
            AlasanMps100Dto alasanMps100Dto = k.toDto();

            listSelect2.add(new Select2Default(String.valueOf(k.getIdAlasanMps100()),k.getNamaAlasanMps100(),alasanMps100Dto));
        });
        return listSelect2;

    }

}
