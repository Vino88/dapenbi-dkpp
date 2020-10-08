package com.dapenbi.dkpp.controller.api;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.*;
import com.dapenbi.dkpp.dto.PensiunDto;
import com.dapenbi.dkpp.form.PensiunFormDto;
import com.dapenbi.dkpp.model.Pensiun;
import com.dapenbi.dkpp.util.DateUtil;
import com.dapenbi.dkpp.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(PathPrefix.API + PathPrefix.PENSIUN)
public class PensiunApiController {

    PensiunDao pensiunDao;

    GolonganDao golonganDao;

    AgamaDao agamaDao;

    PredikatPemberhentianDao predikatPemberhentianDao;

    AlasanHentiDao alasanHentiDao;

    @Autowired
    public PensiunApiController (PensiunDao pensiunDao, GolonganDao golonganDao, AgamaDao agamaDao, PredikatPemberhentianDao predikatPemberhentianDao, AlasanHentiDao alasanHentiDao) {
        this.pensiunDao = pensiunDao;
        this.golonganDao = golonganDao;
        this.agamaDao = agamaDao;
        this.predikatPemberhentianDao = predikatPemberhentianDao;
        this.alasanHentiDao = alasanHentiDao;
    }

    @GetMapping
    public Page<PensiunDto> index(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam) {
        Page<Pensiun> uIt = (Page<Pensiun>) pensiunDao.findAll(new String[] {"nip", "namaPeserta"}, "%" + searchParam + "%", pageRequest);

        return uIt.map(u -> {
            PensiunDto dto = u.toDto();
            if (u.getGolongan() != null) dto.setGolongan(u.getGolongan().toDto());
            if (u.getAgama() != null) dto.setAgama(u.getAgama().toDto());
            if (u.getAlasanHenti() != null) dto.setAlasanHenti(u.getAlasanHenti().toDto());
            if (u.getPredikatPemberhentian() != null) dto.setPredikatPemberhentian(u.getPredikatPemberhentian().toDto());
            return dto;
        });
    }

    @PostMapping
    public ResponseEntity<MessageUtil> addPensiun(@ModelAttribute PensiunFormDto pensiunFormDto) {
        Pensiun pensiun = new Pensiun();

        if (getPensiunDto(pensiunFormDto, pensiun) != null) {
            return new ResponseEntity<>(new MessageUtil("success","Data Berhasil Ditambahkan"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new MessageUtil("failed","Data Gagal Ditambahkan"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<MessageUtil> updatePensiun(@ModelAttribute PensiunFormDto pensiunFormDto) {
        Pensiun pensiun = pensiunDao.findById(pensiunFormDto.getId());

        if (getPensiunDto(pensiunFormDto, pensiun) != null) {
            return new ResponseEntity<>(new MessageUtil("success","Data Berhasil Dirubah"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new MessageUtil("failed","Data Gagal Dirubah"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private PensiunDto getPensiunDto(PensiunFormDto pensiunFormDto, Pensiun pensiun) {
        pensiun.setNip(pensiunFormDto.getNip());
        pensiun.setNamaPeserta(pensiunFormDto.getNamaPeserta());
        pensiun.setJenisKelamin(pensiunFormDto.getJenisKelamin());
        pensiun.setTglLahir(DateUtil.stringToDate(pensiunFormDto.getTglLahir()));
        pensiun.setTglKerja(DateUtil.stringToDate(pensiunFormDto.getTglKerja()));
        pensiun.setTglDPHTPeserta(DateUtil.stringToDate(pensiunFormDto.getTglDPHTPeserta()));
        pensiun.setTglHenti(DateUtil.stringToDate(pensiunFormDto.getTglHenti()));
        pensiun.setTempatMeninggal(pensiunFormDto.getTempatMeninggal());
        pensiun.setTglMeninggal(DateUtil.stringToDate(pensiunFormDto.getTglMeninggal()));
        pensiun.setNpwp(pensiunFormDto.getNpwp());
        pensiun.setGapok(pensiunFormDto.getGapok());
        pensiun.setUpahVeteran(pensiunFormDto.getUpahVeteran());
        pensiun.setMkVeteran(pensiunFormDto.getMkVeteran());
        pensiun.setTglWafat(DateUtil.stringToDate(pensiunFormDto.getTglWafat()));
        pensiun.setNoSKBI(pensiunFormDto.getNoSKBI());
        pensiun.setTglSKBI(DateUtil.stringToDate(pensiunFormDto.getTglSKBI()));
        pensiun.setAlamat(pensiunFormDto.getAlamat());
        pensiun.setGolongan(golonganDao.findById(pensiunFormDto.getGolongan()));
        pensiun.setAgama(agamaDao.findById(pensiunFormDto.getAgama()));
        pensiun.setPredikatPemberhentian(predikatPemberhentianDao.findById(pensiunFormDto.getPredikatPemberhentian()));
        pensiun.setAlasanHenti(alasanHentiDao.findById(pensiunFormDto.getAlasanHenti()));
        pensiun.setActive(pensiunFormDto.getActive() != null && pensiunFormDto.getActive().size() > 0);

        return pensiunDao.save(pensiun).toDto();
    }
}