package com.dapenbi.dkpp.controller.api;


import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.*;
import com.dapenbi.dkpp.dto.PesertaDto;
import com.dapenbi.dkpp.form.PesertaFormDto;
import com.dapenbi.dkpp.model.Peserta;
import com.dapenbi.dkpp.util.DkppUserStamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;

@RestController
@RequestMapping(PathPrefix.API + PathPrefix.PESERTA)
public class PesertaApiController {

    PesertaDao pesertaDao;
    AgamaDao agamaDao;
    GolonganDao golonganDao;
    AlasanHentiDao alasanHentiDao;
    PredikatPemberhentianDao predikatPemberhentianDao;
    private HashMap model;

    @Autowired
    public PesertaApiController (PesertaDao pesertaDao, AgamaDao agamaDao, GolonganDao golonganDao, AlasanHentiDao alasanHentiDao, PredikatPemberhentianDao predikatPemberhentianDao) {
        this.pesertaDao = pesertaDao;
        this.agamaDao = agamaDao;
        this.golonganDao = golonganDao;
        this.alasanHentiDao = alasanHentiDao;
        this.predikatPemberhentianDao = predikatPemberhentianDao;
    }


    @GetMapping
    public Page<PesertaDto> index(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam) {
        Page<Peserta> uIt = (Page<Peserta>) pesertaDao.findAll(new String[] {"nip", "namaPeserta"}, "%" + searchParam + "%", pageRequest);

        Page<PesertaDto> pesertaDto = uIt.map(u -> {
            PesertaDto dto = u.toDto();
            if (u.getGolongan() != null) dto.setGolongan(u.getGolongan().toDto());
            if (u.getAgama() != null) dto.setAgama(u.getAgama().toDto());
            if (u.getAlasanHenti() != null) dto.setAlasanHenti(u.getAlasanHenti().toDto());
            if (u.getPredikatPemberhentian() != null) dto.setPredikatPemberhentian(u.getPredikatPemberhentian().toDto());
            return dto;
        });

        return pesertaDto;
    }

    @PostMapping
    public PesertaDto addPeserta(@ModelAttribute PesertaFormDto pesertaForm){
        Peserta peserta = new Peserta();

        return getPesertaDto(pesertaForm, peserta);

    }

    @PutMapping
    public PesertaDto updatePeserta(@ModelAttribute PesertaFormDto pesertaForm){
        Peserta peserta = pesertaDao.findByNip(pesertaForm.getNip());

        return getPesertaDto(pesertaForm, peserta);
    }

    private PesertaDto getPesertaDto(PesertaFormDto pesertaForm, Peserta peserta) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            peserta.setNip(pesertaForm.getNip());
            peserta.setNamaPeserta(pesertaForm.getNamaPeserta());
            peserta.setJenisKelamin(pesertaForm.getJenisKelamin());
            peserta.setTglLahir(dateFormat.parse(pesertaForm.getTglLahir()));
            peserta.setTglKerja(dateFormat.parse(pesertaForm.getTglKerja()));
            peserta.setTglPeserta(dateFormat.parse(pesertaForm.getTglPeserta()));
            peserta.setTglHenti(dateFormat.parse(pesertaForm.getTglHenti()));
            peserta.setNpwp(pesertaForm.getNpwp());
            peserta.setGapok(pesertaForm.getGapok());
            peserta.setUpahVeteran(pesertaForm.getUpahVeteran());
            peserta.setMkVeteran(pesertaForm.getMkVeteran());
            peserta.setTglWafat(pesertaForm.getTglWafat()!= null?dateFormat.parse(pesertaForm.getTglWafat()):null);
            peserta.setNoSKBI(pesertaForm.getNoSKBI());
            peserta.setTglSKBI(dateFormat.parse(pesertaForm.getTglSKBI()));
            peserta.setAlamat(pesertaForm.getAlamat());
            peserta.setGolongan(golonganDao.findById(pesertaForm.getGolongan()));
            peserta.setAgama(agamaDao.findById(pesertaForm.getAgama()));
            peserta.setPredikatPemberhentian(predikatPemberhentianDao.findById(pesertaForm.getPredikatPemberhentian()));
            peserta.setAlasanHenti(alasanHentiDao.findById(pesertaForm.getAlasanHenti()));
            peserta.setActive(pesertaForm.getActive() != null && pesertaForm.getActive().size() > 0);
            peserta.setUserStamp(DkppUserStamp.postModeUserStamp());

            return pesertaDao.save(peserta).toDto();
        } catch (ParseException e) {
            return null;
        }
    }
}
