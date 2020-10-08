package com.dapenbi.dkpp.dao;


import com.dapenbi.dkpp.dto.PembayaranHutangDto;
import com.dapenbi.dkpp.model.PembayaranHutang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PembayaranHutangDao extends BaseDao<PembayaranHutang, PembayaranHutangDto, Long> {
    Page<PembayaranHutang> findAllByIsHutangMp(String isHutangMp, String searchParam, Pageable pageable);
    Page<PembayaranHutang> findAllByIsHutangPembinaan(String isHutangPembinaan, String searchParam, Pageable pageable);
}