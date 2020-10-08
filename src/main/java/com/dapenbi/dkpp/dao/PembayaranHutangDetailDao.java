package com.dapenbi.dkpp.dao;


import com.dapenbi.dkpp.dto.PembayaranHutangDetailDto;
import com.dapenbi.dkpp.model.PembayaranHutangDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PembayaranHutangDetailDao extends BaseDao<PembayaranHutangDetail, PembayaranHutangDetailDto, Long> {
    Page<PembayaranHutangDetail> findByPembayaranId(Long idPembayaran, Pageable pageable);

}