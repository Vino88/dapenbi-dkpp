package com.dapenbi.dkpp.dao;


import com.dapenbi.dkpp.dto.PembayaranMpDetailMpsDto;
import com.dapenbi.dkpp.model.PembayaranMp;
import com.dapenbi.dkpp.model.PembayaranMpDetailMps;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PembayaranMpDetailMpsDao extends BaseDao<PembayaranMpDetailMps, PembayaranMpDetailMpsDto, Long> {
//    Iterable<PembayaranMpDetailMps> findAllByIdPembayaran(String[] column, String value, Pageable pageable, PembayaranMp pembayaranMp);
    Page<PembayaranMpDetailMps> findAllByIdPembayaranWithSearch(Long idPembayaran,String searchParam, Pageable pageable);
}