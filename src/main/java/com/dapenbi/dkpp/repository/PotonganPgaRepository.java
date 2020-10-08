package com.dapenbi.dkpp.repository;

import com.dapenbi.dkpp.model.CompositeId.PotonganPgaPK;
import com.dapenbi.dkpp.model.PotonganPga;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PotonganPgaRepository extends BaseRepository<PotonganPga, PotonganPgaPK> {

    Page<PotonganPga> findAllByPeriodeMutasiAndUserStamp(String periodeMutasi, String userStamp, Pageable pageable);

}
