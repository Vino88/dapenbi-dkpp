package com.dapenbi.dkpp.repository;

import com.dapenbi.dkpp.model.PembayaranHutangDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

	
public interface PembayaranHutangDetailRepository extends BaseRepository<PembayaranHutangDetail, Long> {
    Page<PembayaranHutangDetail> findAllByIdBayar(Long idBayar, Pageable pageable);
}