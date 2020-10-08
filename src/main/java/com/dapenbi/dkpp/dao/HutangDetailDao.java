package com.dapenbi.dkpp.dao;


import com.dapenbi.dkpp.dto.HutangDetailDto;
import com.dapenbi.dkpp.model.HutangDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface HutangDetailDao extends BaseDao<HutangDetail, HutangDetailDto, Long> {
    Page<HutangDetail> findByNipAndPeriodeMutasi(String nip, String periodeMutasi, Pageable pageable);
    Page<HutangDetail> findAllByHutangId(Long id, Pageable pageable);
}