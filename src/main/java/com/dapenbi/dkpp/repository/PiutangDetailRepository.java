package com.dapenbi.dkpp.repository;

import com.dapenbi.dkpp.model.MPensiun;
import com.dapenbi.dkpp.model.PiutangDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PiutangDetailRepository extends BaseRepository<PiutangDetail,Long> {

    Page<PiutangDetail> findAllByNip(MPensiun mPensiun, Pageable pageable);
}
