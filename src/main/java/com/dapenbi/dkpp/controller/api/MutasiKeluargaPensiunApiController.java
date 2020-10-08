package com.dapenbi.dkpp.controller.api;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.*;
import com.dapenbi.dkpp.dto.MutasiKeluargaPensiunDto;
import com.dapenbi.dkpp.form.MutasiKeluargaPensiunFormDto;
import com.dapenbi.dkpp.model.KategoriPenerima;
import com.dapenbi.dkpp.model.MutasiKeluargaPensiun;
import com.dapenbi.dkpp.util.DateUtil;
import com.dapenbi.dkpp.util.DkppUserStamp;
import com.dapenbi.dkpp.util.MessageUtil;
import com.dapenbi.dkpp.util.ResponseUtil;
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
@RequestMapping(PathPrefix.API + PathPrefix.MUTASI_KELUARGA_PENSIUN)
public class MutasiKeluargaPensiunApiController {

    MutasiKeluargaPensiunDao mutasiKeluargaPensiunDao;

    KategoriPenerimaDao kategoriPenerimaDao;

    StatusKawinDao statusKawinDao;

    @Autowired
    public MutasiKeluargaPensiunApiController (MutasiKeluargaPensiunDao mutasiKeluargaPensiunDao, KategoriPenerimaDao kategoriPenerimaDao, StatusKawinDao statusKawinDao) {
        this.mutasiKeluargaPensiunDao = mutasiKeluargaPensiunDao;
        this.kategoriPenerimaDao = kategoriPenerimaDao;
        this.statusKawinDao = statusKawinDao;
    }

    @GetMapping
    public Page<MutasiKeluargaPensiunDto> index(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam) {
        Page<MutasiKeluargaPensiun> uIt = (Page<MutasiKeluargaPensiun>) mutasiKeluargaPensiunDao.findAll(new String[] {"nip", "namaKeluarga"}, "%" + searchParam + "%", pageRequest);

        return uIt.map(u -> {
            MutasiKeluargaPensiunDto dto = u.toDto();
            if (u.getKategoriPenerima() != null) dto.setKategoriPenerima(u.getKategoriPenerima().toDto());
            if (u.getStatusKawin() != null) dto.setStatusKawin(u.getStatusKawin().toDto());
            return dto;
        });
    }

    @PostMapping
    public ResponseEntity<MessageUtil> addMutasiKeluargaPensiun(@ModelAttribute MutasiKeluargaPensiunFormDto mutasiKeluargaPensiunFormDto) {
        MutasiKeluargaPensiun mutasiKeluargaPensiun = new MutasiKeluargaPensiun();

        if (getMutasiKeluargaPensiunDto(mutasiKeluargaPensiunFormDto, mutasiKeluargaPensiun) != null) {
            return new ResponseEntity<>(new MessageUtil("success","Data Berhasil Ditambahkan"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new MessageUtil("failed","Data Gagal Ditambahkan"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<MessageUtil> updatePensiun(@ModelAttribute MutasiKeluargaPensiunFormDto mutasiKeluargaPensiunFormDto) {
        MutasiKeluargaPensiun mutasiKeluargaPensiun = mutasiKeluargaPensiunDao.findById(mutasiKeluargaPensiunFormDto.getIdKeluarga());

        if (getMutasiKeluargaPensiunDto(mutasiKeluargaPensiunFormDto, mutasiKeluargaPensiun) != null) {
            return new ResponseEntity<>(new MessageUtil("success","Data Berhasil Dirubah"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new MessageUtil("failed","Data Gagal Dirubah"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private MutasiKeluargaPensiunDto getMutasiKeluargaPensiunDto(MutasiKeluargaPensiunFormDto mutasiKeluargaPensiunFormDto, MutasiKeluargaPensiun mutasiKeluargaPensiun) {
        KategoriPenerima idKategoriPenerima = kategoriPenerimaDao.findById(mutasiKeluargaPensiunFormDto.getKategoriPenerima());
        mutasiKeluargaPensiun.setId(mutasiKeluargaPensiunFormDto.getNip()+"-"+idKategoriPenerima.getId());
        mutasiKeluargaPensiun.setNip(mutasiKeluargaPensiunFormDto.getNip());
        mutasiKeluargaPensiun.setNamaKeluarga(mutasiKeluargaPensiunFormDto.getNamaKeluarga());
        mutasiKeluargaPensiun.setJenisKelamin(mutasiKeluargaPensiunFormDto.getJenisKelamin());
        mutasiKeluargaPensiun.setTempatLahir(mutasiKeluargaPensiunFormDto.getTempatLahir());
        mutasiKeluargaPensiun.setTglLahir(DateUtil.stringToDate(mutasiKeluargaPensiunFormDto.getTglLahir()));
        mutasiKeluargaPensiun.setTempatMenikah(mutasiKeluargaPensiunFormDto.getTempatMenikah());
        mutasiKeluargaPensiun.setTglMenikah(DateUtil.stringToDate(mutasiKeluargaPensiunFormDto.getTglMenikah()));
        mutasiKeluargaPensiun.setTglCerai(DateUtil.stringToDate(mutasiKeluargaPensiunFormDto.getTglCerai()));
        mutasiKeluargaPensiun.setTglUsia25(DateUtil.stringToDate(mutasiKeluargaPensiunFormDto.getTglUsia25()));
        mutasiKeluargaPensiun.setTempatWafat(mutasiKeluargaPensiunFormDto.getTempatWafat());
        mutasiKeluargaPensiun.setTglWafat(DateUtil.stringToDate(mutasiKeluargaPensiunFormDto.getTglWafat()));
        mutasiKeluargaPensiun.setKategoriPenerima(kategoriPenerimaDao.findById(mutasiKeluargaPensiunFormDto.getKategoriPenerima()));
        mutasiKeluargaPensiun.setStatusKawin(statusKawinDao.findById(mutasiKeluargaPensiunFormDto.getStatusKawin()));
        mutasiKeluargaPensiun.setPenerimaMp((mutasiKeluargaPensiunFormDto.getIsPenerimaMp() != null && mutasiKeluargaPensiunFormDto.getIsPenerimaMp().size() > 0 )?"1":"0");
        mutasiKeluargaPensiun.setActive(mutasiKeluargaPensiunFormDto.getActive() != null && mutasiKeluargaPensiunFormDto.getActive().size() > 0);
        mutasiKeluargaPensiun.setUserStamp(DkppUserStamp.postModeUserStamp());

        return mutasiKeluargaPensiunDao.save(mutasiKeluargaPensiun).toDto();
    }

    @PostMapping ("/delete/{idMutasi}")
    public ResponseEntity<MessageUtil> deleteMutasiKeluargaByIdMutasi(@PathVariable Long idMutasi){
        boolean result = mutasiKeluargaPensiunDao.deleteAllByIdMutasi(idMutasi);
        MessageUtil messageUtil;
        HttpStatus httpStatus;
            messageUtil = new MessageUtil("success","Data Behasil Dihapus");
            httpStatus = HttpStatus.OK;

        return new ResponseEntity<MessageUtil>(messageUtil,httpStatus);
    }

    @GetMapping("/cufn-delete-mkp")
    public Object deleteMutasiKeluargaPensiun(@RequestParam(name = "idMutasi") String idMutasi){
        return mutasiKeluargaPensiunDao.cufnDeleteMutasiKeluarga(idMutasi);
    }

    @GetMapping("/{idMutasi}/get")
    public Map getByidMutasi(Pageable pageRequest, @RequestParam(name = "searchParam",required = false) String searchParam, @PathVariable Long idMutasi){
        Iterable<MutasiKeluargaPensiun> aIt = (Iterable<MutasiKeluargaPensiun>) mutasiKeluargaPensiunDao.findByIdMutasi(idMutasi);

        List<MutasiKeluargaPensiunDto> mutasiKeluargaPensiunDto = new ArrayList<>();
        aIt.forEach(u->{
            MutasiKeluargaPensiunDto dto = u.toDto();
            if(u.getKategoriPenerima() != null)
                dto.setKategoriPenerima(u.getKategoriPenerima().toDto());

            if(u.getStatusKawin() != null)
                dto.setStatusKawin(u.getStatusKawin().toDto());
            mutasiKeluargaPensiunDto.add(dto);
        });

        Map out = new HashMap();
        out.put("data", mutasiKeluargaPensiunDto);
        return out;
    }

}
