package com.dapenbi.dkpp.repository;

import com.dapenbi.dkpp.model.CompositeId.PotonganOlahragaPK;
import com.dapenbi.dkpp.model.PotonganOlahraga;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PotonganOlahragaRepository extends BaseRepository<PotonganOlahraga, PotonganOlahragaPK> {

    Page<PotonganOlahraga> findAllByPeriodeMutasiAndUserStamp(String periodeMutasi, String userStamp, Pageable pageable);

}
