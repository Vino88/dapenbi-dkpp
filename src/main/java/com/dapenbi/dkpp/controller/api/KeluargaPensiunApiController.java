package com.dapenbi.dkpp.controller.api;


import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.KategoriPenerimaDao;
import com.dapenbi.dkpp.dao.KeluargaPensiunDao;
import com.dapenbi.dkpp.dto.KeluargaPensiunDto;
import com.dapenbi.dkpp.form.KeluargaPensiunFormDto;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(PathPrefix.API + PathPrefix.KELUARGA_PENSIUN)
public class KeluargaPensiunApiController {
    @Autowired
    KeluargaPensiunDao keluargaPensiunDao;

    @Autowired
    KategoriPenerimaDao kategoriPenerimaDao;

    @GetMapping
    public Page<KeluargaPensiunDto> index(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam) {
        Page<KeluargaPensiun> aIt = (Page<KeluargaPensiun>) keluargaPensiunDao.findAll(new String[]{"namaKeluarga"}, "%" + searchParam + "%", pageRequest);

        Page<KeluargaPensiunDto> keluargaPensiunDto = aIt.map(u -> {
            KeluargaPensiunDto dto = u.toDto();
            dto.setIdKategoriPenerima(u.getKategoriPenerima().getId());
            return dto;
        });

        return keluargaPensiunDto;
    }

    @GetMapping("/{nip}/by-nip")
    public Map getByNip(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam, @PathVariable String nip) {
        Iterable<KeluargaPensiun> aIt = (Iterable<KeluargaPensiun>) keluargaPensiunDao.findAllByNip(nip);

        List<KeluargaPensiunDto> keluargaPensiunDto = new ArrayList<>();
        aIt.forEach(u -> {
            KeluargaPensiunDto dto = u.toDto();
            //Samapai sini
            dto.setIdKategoriPenerima(u.getKategoriPenerima().getId());
            dto.setIdStatusKawin(u.getStatusKawin().getId());
            if (u.getKategoriPenerima() != null){dto.setKategoriPenerima(u.getKategoriPenerima().toDto());}
            if (u.getStatusKawin()!=null){dto.setStatusKawin(u.getStatusKawin().toDto());}
            dto.setFlag("0");
            keluargaPensiunDto.add(dto);
        });
        Map out = new HashMap();
        out.put("data", keluargaPensiunDto);
        return out;
    }

    @PostMapping
    public ResponseEntity<MessageUtil> addKelaurgapeserta(@ModelAttribute KeluargaPensiunFormDto keluargaPensiunFormDto) {
        KeluargaPensiun keluargaPensiun = new KeluargaPensiun();
        keluargaPensiun.setId(keluargaPensiunFormDto.getId());
        KategoriPenerima katPenerima = kategoriPenerimaDao.findById(keluargaPensiunFormDto.getIdKategoriPenerima());
        keluargaPensiun.setKategoriPenerima(katPenerima);
        keluargaPensiun.setNamaKategoriPenerima(katPenerima.getNamaKategoriPenerima());
        keluargaPensiun.setNip(keluargaPensiunFormDto.getNip());
        keluargaPensiun.setNamaKeluarga(keluargaPensiunFormDto.getNamaKeluarga());
        keluargaPensiun.setJenisKelamin(keluargaPensiunFormDto.getJenisKelamin());
        keluargaPensiun.setTempatLahir(keluargaPensiunFormDto.getTempatLahir());
        keluargaPensiun.setTglLahir(keluargaPensiunFormDto.getTglLahir());
        keluargaPensiun.setTglMenikah(keluargaPensiunFormDto.getTglMenikah());
        keluargaPensiun.setTglCerai(keluargaPensiunFormDto.getTglCerai());
        keluargaPensiun.setTglUsia25(keluargaPensiunFormDto.getTglUsia25());
        keluargaPensiun.setTglWafat(keluargaPensiunFormDto.getTglWafat());
        keluargaPensiun.setTempatMenikah(keluargaPensiunFormDto.getTempatMenikah());
        keluargaPensiun.setTempatWafat(keluargaPensiunFormDto.getTempatWafat());
        keluargaPensiun.setPenerimaMp((keluargaPensiunFormDto.getIsPenerimaMp() != null && keluargaPensiunFormDto.getIsPenerimaMp().size() > 0) ? "1" : "0");
        keluargaPensiun.setUserStamp(DkppUserStamp.postModeUserStamp());
        keluargaPensiun.setActive(true);
        KeluargaPensiunDto dto = keluargaPensiunDao.save(keluargaPensiun).toDto();
        MessageUtil messageUtil;
        if (dto != null) {
            messageUtil = new MessageUtil("success", "Data berhasil ditambahkan");
        } else {
            messageUtil = new MessageUtil("failed", "Data gagal disimpan");
        }
        return new ResponseEntity<>(messageUtil, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<MessageUtil> updateKeluargaPensiun(@ModelAttribute KeluargaPensiunFormDto keluargaPensiunFormDto) {
        KeluargaPensiun keluargaPensiun = keluargaPensiunDao.findById(keluargaPensiunFormDto.getId());
        KategoriPenerima katPenerima = kategoriPenerimaDao.findById(keluargaPensiunFormDto.getIdKategoriPenerima());
        keluargaPensiun.setKategoriPenerima(katPenerima);
        keluargaPensiun.setNip(keluargaPensiunFormDto.getNip());
        keluargaPensiun.setNamaKeluarga(keluargaPensiunFormDto.getNamaKeluarga());
        keluargaPensiun.setJenisKelamin(keluargaPensiunFormDto.getJenisKelamin());
        keluargaPensiun.setTempatLahir(keluargaPensiunFormDto.getTempatLahir());
        keluargaPensiun.setTglLahir(keluargaPensiunFormDto.getTglLahir());
        keluargaPensiun.setTglMenikah(keluargaPensiunFormDto.getTglMenikah());
        keluargaPensiun.setTglCerai(keluargaPensiunFormDto.getTglCerai());
        keluargaPensiun.setTglUsia25(keluargaPensiunFormDto.getTglUsia25());
        keluargaPensiun.setTglWafat(keluargaPensiunFormDto.getTglWafat());
        keluargaPensiun.setTempatMenikah(keluargaPensiunFormDto.getTempatMenikah());
        keluargaPensiun.setTempatWafat(keluargaPensiunFormDto.getTempatWafat());
        keluargaPensiun.setPenerimaMp((keluargaPensiunFormDto.getIsPenerimaMp() != null && keluargaPensiunFormDto.getIsPenerimaMp().size() > 0) ? "1" : "0");
        keluargaPensiun.setActive(keluargaPensiunFormDto.getActive() != null && keluargaPensiunFormDto.getActive().size() > 0);
        keluargaPensiun.setUserStamp(DkppUserStamp.putModeUserStamp());

        KeluargaPensiunDto dto = keluargaPensiunDao.save(keluargaPensiun).toDto();
        MessageUtil messageUtil;
        if (dto != null) {
            messageUtil = new MessageUtil("success", "Data berhasil disimpan");
        } else {
            messageUtil = new MessageUtil("failed", "Data gagal disimpan");
        }
        return new ResponseEntity<>(messageUtil, HttpStatus.OK);
    }

}
