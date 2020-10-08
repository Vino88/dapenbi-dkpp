package com.dapenbi.dkpp.controller.api;


import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.KotaDao;
import com.dapenbi.dkpp.dao.ProvinsiDao;
import com.dapenbi.dkpp.dto.KotaDto;
import com.dapenbi.dkpp.form.KotaFormDto;
import com.dapenbi.dkpp.model.Kota;
import com.dapenbi.dkpp.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.dapenbi.dkpp.util.DkppUserStamp;

@RestController
@RequestMapping(PathPrefix.API + PathPrefix.KOTA)
public class KotaApiController extends DropdownApiController {

    ProvinsiDao provinsiDao;

    @Autowired
    public KotaApiController(KotaDao kotaDao, ProvinsiDao provinsiDao) {
        super(kotaDao);
        this.provinsiDao = provinsiDao;
    }

    @GetMapping
    public Page<KotaDto> index(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam){
        KotaDao kotaDao = (KotaDao) this.baseDao;

        Page<Kota> pIt = (Page<Kota>) kotaDao.findAll(new String[]{"namaKota"}, "%" + searchParam + "%", pageRequest);
        Page<KotaDto> kotaDto = pIt.map(p ->{
            KotaDto dto = p.toDto();
            if (p.getProvinsi() !=null) dto.setProvinsi(p.getProvinsi().toDto());
            return dto;
        });
        return kotaDto;
    }

    @PostMapping
    public ResponseEntity<MessageUtil> addKota(@ModelAttribute KotaFormDto kotaFormDto){
        KotaDao kotaDao = (KotaDao) this.baseDao;

        Kota kota = new Kota();
        kota.setNamaKota(kotaFormDto.getNamaKota());
        kota.setProvinsi( provinsiDao.findById(kotaFormDto.getIdprovinsi()));
        kota.setUserStamp(DkppUserStamp.postModeUserStamp());
        KotaDto dto = kotaDao.save(kota).toDto();
        MessageUtil msg;
        if(dto != null){
            msg = new MessageUtil("success", "Data berhasil ditambahkan");
        } else {
            msg = new MessageUtil("failed", "Data gagal disimpan");
        }
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<MessageUtil> updateKota(@ModelAttribute KotaFormDto kotaFormDto){
        KotaDao kotaDao = (KotaDao) this.baseDao;

        Kota kota = kotaDao.findById(kotaFormDto.getId());
        kota.setNamaKota(kotaFormDto.getNamaKota());
        kota.setProvinsi( provinsiDao.findById(kotaFormDto.getIdprovinsi()));
        kota.setActive(kotaFormDto.getActive() !=null && kotaFormDto.getActive().size() > 0);
        kota.setUserStamp(DkppUserStamp.putModeUserStamp());
        KotaDto dto = kotaDao.save(kota).toDto();
        MessageUtil msg;
        if (dto != null){
            msg = new MessageUtil("success", "Data Berhasil Dirubah");
        }else {
            msg = new MessageUtil("failed", "Data Gagal Dirubah");
        }
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }
}
