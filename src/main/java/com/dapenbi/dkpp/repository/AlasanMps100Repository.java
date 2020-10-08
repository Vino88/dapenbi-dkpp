package com.dapenbi.dkpp.repository;

import com.dapenbi.dkpp.model.AlasanMps100;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AlasanMps100Repository extends BaseRepository<AlasanMps100, Long> {

    AlasanMps100 findByIdAlasanMps100(Long id);

    AlasanMps100 findOneByNamaAlasanMps100(String namaAlasanMps);

    @Query(
            value = "select amp100 from AlasanMps100 amp100"
    )
    List<AlasanMps100> getListAlasanMps100MutasiMpSekaligus();

    @Query(
            value = "select amp100 from AlasanMps100 amp100 where amp100.idAlasanMps100 <> 5"
    )
    Page<AlasanMps100> getListAlasanMps100TidakSamaDengan5(Pageable pageable);

    @Query(
            value = "select amp100 from AlasanMps100 amp100 where amp100.idAlasanMps100 <> 5 and ( lower(amp100.namaAlasanMps100) like lower(?1))"
    )
    Page<AlasanMps100> getListAlasanMps100TidakSamaDengan5Param(String searchParam, Pageable pageable);
}
