package com.dapenbi.dkpp.dao;

import com.dapenbi.dkpp.dto.AlasanMps100Dto;
import com.dapenbi.dkpp.model.AlasanMps100;
import com.dapenbi.dkpp.model.BankNF;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AlasanMps100Dao extends BaseDao<AlasanMps100, AlasanMps100Dto, Long> {

    AlasanMps100 findByid(Long Id);
    AlasanMps100 findByNamaAlasanMps100(String nama);
    List<AlasanMps100> getListAlasanMps100MutasiMpSekaligus();
    Page<AlasanMps100> getListAlasanMps100TidakSamaDengan5(Pageable pageable);
    Page<AlasanMps100> getListAlasanMps100TidakSamaDengan5Param(String searchParam, Pageable pageable);
}
