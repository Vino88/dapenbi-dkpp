package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.AlasanMps100Dao;
import com.dapenbi.dkpp.dao.BankDao;
import com.dapenbi.dkpp.dto.AlasanMps100Dto;
import com.dapenbi.dkpp.dto.BankDto;
import com.dapenbi.dkpp.model.AlasanMps100;
import com.dapenbi.dkpp.model.BankNF;
import com.dapenbi.dkpp.model.BaseModel;
import com.dapenbi.dkpp.repository.AlasanMps100Repository;
import com.dapenbi.dkpp.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AlasanMps100DaoImpl extends BaseDaoImpl<AlasanMps100, AlasanMps100Dto, Long> implements AlasanMps100Dao {

    private AlasanMps100Repository alasanMps100Repository;

    @Autowired
    public AlasanMps100DaoImpl(AlasanMps100Repository alasanMps100Repository) {
        super(alasanMps100Repository);
        this.alasanMps100Repository = alasanMps100Repository;
    }

    @Override
    public AlasanMps100 findByid(Long Id) {
        return alasanMps100Repository.findByIdAlasanMps100(Id);
    }

    @Override
    public AlasanMps100 findByNamaAlasanMps100(String nama) {
        return alasanMps100Repository.findOneByNamaAlasanMps100(nama);
    }

    @Override
    public List<AlasanMps100> getListAlasanMps100MutasiMpSekaligus() {
        return alasanMps100Repository.getListAlasanMps100MutasiMpSekaligus();
    }

    @Override
    public Page<AlasanMps100> getListAlasanMps100TidakSamaDengan5(Pageable pageable) {
        return alasanMps100Repository.getListAlasanMps100TidakSamaDengan5(pageable);
    }

    @Override
    public Page<AlasanMps100> getListAlasanMps100TidakSamaDengan5Param(String searchParam, Pageable pageable) {
        return alasanMps100Repository.getListAlasanMps100TidakSamaDengan5Param(searchParam, pageable);
    }
}
