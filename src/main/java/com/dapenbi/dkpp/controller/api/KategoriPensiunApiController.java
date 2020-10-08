package com.dapenbi.dkpp.controller.api;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.KategoriPensiunDao;
import com.dapenbi.dkpp.dto.KategoriPensiunDto;
import com.dapenbi.dkpp.form.KategoriPensiunFormDto;
import com.dapenbi.dkpp.model.KategoriPensiun;
import com.dapenbi.dkpp.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;


@RestController
@RequestMapping(PathPrefix.API + PathPrefix.KATEGORI_PENSIUN)
public class KategoriPensiunApiController extends DropdownApiController {

    @Autowired
    public KategoriPensiunApiController(KategoriPensiunDao kategoriPensiunDao) {
        super(kategoriPensiunDao);
    }

    @GetMapping
    public Page<KategoriPensiunDto> index(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam){
        KategoriPensiunDao kategoriPensiunDao = (KategoriPensiunDao) this.baseDao;

        Page<KategoriPensiun> kIt = (Page<KategoriPensiun>) kategoriPensiunDao.findAll(new String[] {"id","namaKategoriPensiun"},"%" + searchParam + "%", pageRequest);

        Page<KategoriPensiunDto> kategoriPensiunDto = kIt.map(k -> k.toDto());

        return kategoriPensiunDto;
    }

    @GetMapping("/{id}")
    public KategoriPensiunDto detail(@PathVariable("id") String id) {
        KategoriPensiunDao kategoriPensiunDao = (KategoriPensiunDao) this.baseDao;

        return kategoriPensiunDao.findById(id).toDto();
    }

    @PostMapping
    public ResponseEntity<MessageUtil> addKategoriPensiun(@ModelAttribute KategoriPensiunFormDto kategoriPensiunFormDto){
        KategoriPensiunDao kategoriPensiunDao = (KategoriPensiunDao) this.baseDao;

        KategoriPensiun kategoriPensiun = new KategoriPensiun();
        kategoriPensiun.setId(kategoriPensiunFormDto.getId());
        kategoriPensiun.setNamaKategoriPensiun(kategoriPensiunFormDto.getNamaKategoriPensiun());
        KategoriPensiunDto dto = kategoriPensiunDao.save(kategoriPensiun).toDto();
        MessageUtil msg;

        if(dto != null){
            msg = new MessageUtil("success", "Data berhasil ditambahkan");
        } else {
            msg = new MessageUtil("failed", "Data gagal disimpan");
        }

        return new ResponseEntity<>(msg,HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<MessageUtil> updateKategoriPensiun(@ModelAttribute KategoriPensiunFormDto kategoriPensiunFormDto){
        KategoriPensiunDao kategoriPensiunDao = (KategoriPensiunDao) this.baseDao;

        KategoriPensiun kategoriPensiun = kategoriPensiunDao.findById(kategoriPensiunFormDto.getId());

        kategoriPensiun.setNamaKategoriPensiun(kategoriPensiunFormDto.getNamaKategoriPensiun());
        kategoriPensiun.setActive(kategoriPensiunFormDto.getActive() !=null && kategoriPensiunFormDto.getActive().size() > 0);
        KategoriPensiunDto dto = kategoriPensiunDao.save(kategoriPensiun).toDto();
        MessageUtil msg;

        if (dto != null){
            msg = new MessageUtil("success", "Data Berhasil Dirubah");
        }else {
            msg = new MessageUtil("failed", "Data Gagal Dirubah");
        }
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }
}
