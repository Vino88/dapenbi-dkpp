package com.dapenbi.dkpp.dao;

import com.dapenbi.dkpp.dto.PotonganKovetriDto;
import com.dapenbi.dkpp.model.CompositeId.PotonganKovetriPK;
import com.dapenbi.dkpp.model.PotonganKovetri;
import com.dapenbi.dkpp.model.PotonganPga;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;

public interface PotonganKovetriDao extends BaseDao<PotonganKovetri, PotonganKovetriDto, PotonganKovetriPK> {
    int countByPeriodeMutasiAndTglUpload(String periodeMutasi, Date tglUpload);

    Page<PotonganKovetri> findAllByPeriodeMutasiAndUserStamp(String periodeMutasiPart, String userStampPart, Pageable pageable);
}
