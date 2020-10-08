package com.dapenbi.dkpp.dao;

import com.dapenbi.dkpp.dto.PiutangDetailDto;
import com.dapenbi.dkpp.model.MPensiun;
import com.dapenbi.dkpp.model.PiutangDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PiutangDetailDao extends BaseDao<PiutangDetail, PiutangDetailDto,Long> {

    Page<PiutangDetail> findAllByNip(MPensiun mPensiun, Pageable pageable);
}
