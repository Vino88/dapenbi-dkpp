package com.dapenbi.dkpp.controller.api;


import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.KategoriPenerimaDao;
import com.dapenbi.dkpp.dao.KeluargaPesertaDao;
import com.dapenbi.dkpp.dao.StatusKawinDao;
import com.dapenbi.dkpp.dto.KeluargaPesertaDto;
import com.dapenbi.dkpp.form.KeluargaPesertaFormDto;
import com.dapenbi.dkpp.model.KeluargaPeserta;
import com.dapenbi.dkpp.util.DkppUserStamp;
import com.dapenbi.dkpp.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(PathPrefix.API + PathPrefix.KELUARGA_PESERTA)
public class KeluargaPesertaApiController {
    @Autowired
    KeluargaPesertaDao keluargaPesertaDao;

    @Autowired
    KategoriPenerimaDao kategoriPenerimaDao;

    @Autowired
    StatusKawinDao statusKawinDao;

    @GetMapping
    public Page<KeluargaPesertaDto> index(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam) {
        Page<KeluargaPeserta> aIt = (Page<KeluargaPeserta>) keluargaPesertaDao.findAll(new String[] {"namaKeluarga",""}, "%" + searchParam + "%", pageRequest);

        Page<KeluargaPesertaDto> keluargaPesertaDto = aIt.map(u -> u.toDto());

        return keluargaPesertaDto;
    }

    @PostMapping
    public ResponseEntity<MessageUtil> addKelaurgapeserta(@ModelAttribute KeluargaPesertaFormDto keluargaPesertaFormDto){
        KeluargaPeserta keluargaPeserta = new KeluargaPeserta();
        keluargaPeserta.setId(keluargaPesertaFormDto.getId());
        keluargaPeserta.setNip(keluargaPesertaFormDto.getNip());
        keluargaPeserta.setNamaKeluarga(keluargaPesertaFormDto.getNamaKeluarga());
        keluargaPeserta.setTempatLahir(keluargaPesertaFormDto.getTempatLahir());
        keluargaPeserta.setTglLahir(keluargaPesertaFormDto.getTanggalLahir());
        keluargaPeserta.setTglUsia25(keluargaPesertaFormDto.getTanggalUsia25());
        keluargaPeserta.setTglMenikah(keluargaPesertaFormDto.getTanggalMenikah());
        keluargaPeserta.setTglCerai(keluargaPesertaFormDto.getTanggalCerai());
        keluargaPeserta.setTglWafat(keluargaPesertaFormDto.getTanggalWafat());
        keluargaPeserta.setKategoriPenerima( kategoriPenerimaDao.findById( Long.valueOf(keluargaPesertaFormDto.getIdKategoriPenerima()) ) );
        keluargaPeserta.setStatusKawin(statusKawinDao.findById(keluargaPesertaFormDto.getStatusKawin()));
        keluargaPeserta.setJenisKelamin(keluargaPesertaFormDto.getJenisKelamin());
        keluargaPeserta.setNip(keluargaPesertaFormDto.getNip());
        keluargaPeserta.setActive(keluargaPesertaFormDto.getActive() != null && keluargaPesertaFormDto.getActive().size() > 0);
        keluargaPeserta.setUserStamp(DkppUserStamp.postModeUserStamp());
        System.out.println("Here we are : ");
        System.out.println(keluargaPeserta.getId());
        KeluargaPesertaDto dto = keluargaPesertaDao.save(keluargaPeserta).toDto();
        MessageUtil messageUtil;
        if(dto != null){
            messageUtil = new MessageUtil("success", "Data berhasil ditambahkan");
        } else {
            messageUtil = new MessageUtil("failed", "Data gagal disimpan");
        }
        return new ResponseEntity<MessageUtil>(messageUtil, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<MessageUtil> updateKeluargaPeserta(@ModelAttribute KeluargaPesertaFormDto keluargaPesertaFormDto){
        KeluargaPeserta keluargaPeserta = keluargaPesertaDao.findById(keluargaPesertaFormDto.getId());
        keluargaPeserta.setKategoriPenerima( kategoriPenerimaDao.findById( Long.valueOf(keluargaPesertaFormDto.getIdKategoriPenerima()) ) );
        keluargaPeserta.setNip(keluargaPesertaFormDto.getNip());
        keluargaPeserta.setNamaKeluarga(keluargaPesertaFormDto.getNamaKeluarga());
        keluargaPeserta.setTempatLahir(keluargaPesertaFormDto.getTempatLahir());
        keluargaPeserta.setTglLahir(keluargaPesertaFormDto.getTanggalLahir());
        keluargaPeserta.setTglUsia25(keluargaPesertaFormDto.getTanggalUsia25());
        keluargaPeserta.setTglMenikah(keluargaPesertaFormDto.getTanggalMenikah());
        keluargaPeserta.setTglCerai(keluargaPesertaFormDto.getTanggalCerai());
        keluargaPeserta.setTglWafat(keluargaPesertaFormDto.getTanggalWafat());
        keluargaPeserta.setJenisKelamin(keluargaPesertaFormDto.getJenisKelamin());
        keluargaPeserta.setNip(keluargaPesertaFormDto.getNip());
        keluargaPeserta.setActive(keluargaPesertaFormDto.getActive() != null && keluargaPesertaFormDto.getActive().size() > 0);
        keluargaPeserta.setUserStamp(DkppUserStamp.putModeUserStamp());

        KeluargaPesertaDto dto = keluargaPesertaDao.save(keluargaPeserta).toDto();
        MessageUtil messageUtil;
        if(dto != null){
            messageUtil = new MessageUtil("success", "Data berhasil disimpan");
        } else {
            messageUtil = new MessageUtil("failed", "Data gagal disimpan");
        }
        return new ResponseEntity<MessageUtil>(messageUtil, HttpStatus.OK);
    }

}
