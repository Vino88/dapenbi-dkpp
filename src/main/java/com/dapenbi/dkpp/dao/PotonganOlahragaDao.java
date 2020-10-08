package com.dapenbi.dkpp.dao;


import com.dapenbi.dkpp.dto.PotonganOlahragaDto;
import com.dapenbi.dkpp.model.CompositeId.PotonganOlahragaPK;
import com.dapenbi.dkpp.model.PotonganOlahraga;
import com.dapenbi.dkpp.model.PotonganPga;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PotonganOlahragaDao extends BaseDao<PotonganOlahraga, PotonganOlahragaDto, PotonganOlahragaPK> {
    Page<PotonganOlahraga> findAllByPeriodeMutasiAndUserStamp(String periodeMutasiPart, String userStampPart, Pageable pageable);
}
