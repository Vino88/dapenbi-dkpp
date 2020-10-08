package com.dapenbi.dkpp.repository;

import com.dapenbi.dkpp.model.PembayaranHutang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface PembayaranHutangRepository extends BaseRepository<PembayaranHutang, Long> {
    @Query(
            value = "select ph from PembayaranHutang ph where ph.isHutangMp = ?1 and lower(ph.namaPeserta) like lower(?2)"
    )
    Page<PembayaranHutang> findAllByIsHutangMp(String isHutangMp, String searchParam, Pageable pageable);

    @Query(
            value = "select ph from PembayaranHutang ph where ph.isHutangPembinaan = ?1 and lower(ph.namaPeserta) like lower(?2)"
    )
    Page<PembayaranHutang> findAllByIsHutangPembinaan(String isHutangPembinaan, String searchParam, Pageable pageable);

}