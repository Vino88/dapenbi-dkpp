package com.dapenbi.dkpp.repository;

import com.dapenbi.dkpp.model.TMutasiRekening;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;


public interface TMutasiRekeningRepository extends BaseRepository<TMutasiRekening, String> {

    @Query(
            value = "select mr from TMutasiRekening mr where ( mr.periodeMutasi = :periode and mr.tglInput between :startDate and :endDate ) and (mr.namaPeserta like :searchParam OR mr.namaPenerimaMp like :searchParam or mr.nip = :searchParam)"
    )
    Page<TMutasiRekening> findAllByFilterForm(@Param("periode") String periode, @Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("searchParam") String searchParam, Pageable page);

}