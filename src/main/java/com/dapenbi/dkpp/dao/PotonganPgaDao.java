package com.dapenbi.dkpp.dao;

import com.dapenbi.dkpp.dto.PotonganPgaDto;
import com.dapenbi.dkpp.model.CompositeId.PotonganPgaPK;
import com.dapenbi.dkpp.model.PotonganPga;
import com.dapenbi.dkpp.util.StringUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PotonganPgaDao extends BaseDao<PotonganPga, PotonganPgaDto, PotonganPgaPK> {
    Page<PotonganPga> findAllByPeriodeMutasiAndUserStamp(String periodeMutasiPart, String userStampPart, Pageable pageable);
}
