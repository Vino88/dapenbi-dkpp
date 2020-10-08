package com.dapenbi.dkpp.controller.api;


import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.KategoriMutasiDao;
import com.dapenbi.dkpp.dto.KategoriMutasiDto;
import com.dapenbi.dkpp.form.KategoriMutasiFormDto;
import com.dapenbi.dkpp.model.KategoriMutasi;
import com.dapenbi.dkpp.util.DkppUserStamp;
import com.dapenbi.dkpp.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(PathPrefix.API + PathPrefix.KATEGORIMUTASI)
public class KategoriMutasiApiController {

    @Autowired
    KategoriMutasiDao kategoriMutasiDao;

    @GetMapping
    public Page<KategoriMutasiDto> index(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam){
        Page<KategoriMutasi> pIt = (Page<KategoriMutasi>) kategoriMutasiDao.findAll(new String[]{"id","namaKategoriMutasi"}, "%" + searchParam + "%", pageRequest);

        Page<KategoriMutasiDto> kategoriMutasiDto = pIt.map(p ->p.toDto() );
        return kategoriMutasiDto;
    }

    @PostMapping
    public ResponseEntity<MessageUtil> addJenisMutasi(@ModelAttribute KategoriMutasiFormDto kategoriMutasiFormDto){
        KategoriMutasi kategoriMutasi = new KategoriMutasi();
        kategoriMutasi.setId(kategoriMutasiFormDto.getId());
        kategoriMutasi.setNamaKategoriMutasi(kategoriMutasiFormDto.getNamaKategoriMutasi());
        kategoriMutasi.setUserStamp(DkppUserStamp.postModeUserStamp());
        KategoriMutasiDto dto = kategoriMutasiDao.save(kategoriMutasi).toDto();
        MessageUtil msg;
        if (dto != null){
            msg = new MessageUtil("success","Data Berhasil Ditambahkan");
        }else {
            msg = new MessageUtil("failed","Data Gagal Ditambahkan");
        }
        return new ResponseEntity<MessageUtil>(msg, HttpStatus.OK);

    }

    @PutMapping
    public ResponseEntity<MessageUtil> updateJenisMutasi(@ModelAttribute KategoriMutasiFormDto kategoriMutasiFormDto){
        KategoriMutasi kategoriMutasi = kategoriMutasiDao.findById(kategoriMutasiFormDto.getId());

        kategoriMutasi.setNamaKategoriMutasi(kategoriMutasiFormDto.getNamaKategoriMutasi());
        kategoriMutasi.setActive(kategoriMutasiFormDto.getActive() !=null && kategoriMutasiFormDto.getActive().size() > 0);
        kategoriMutasi.setUserStamp(DkppUserStamp.putModeUserStamp());
        KategoriMutasiDto dto = kategoriMutasiDao.save(kategoriMutasi).toDto();
        MessageUtil msg;

        if(dto != null){
            msg = new MessageUtil("success", "Data Berhasil Dirubah");
        } else {
            msg = new MessageUtil("failed", "Data Gagal Dirubah");
        }
        return new ResponseEntity<MessageUtil>(msg, HttpStatus.OK);
    }
}
