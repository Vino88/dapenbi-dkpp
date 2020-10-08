package com.dapenbi.dkpp.repository;

import com.dapenbi.dkpp.model.HutangDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

	
public interface HutangDetailRepository extends BaseRepository<HutangDetail, Long> {

    Page<HutangDetail> findByNipAndPeriodeMutasi(String nip, String periodeMutasi, Pageable pageable);

    Page<HutangDetail> findAllByNipAndPeriodeMutasi(String nip, String periodeMutasi, Pageable pageable);

    Page<HutangDetail> findAllByIdHutang(Long id, Pageable pageable);
}