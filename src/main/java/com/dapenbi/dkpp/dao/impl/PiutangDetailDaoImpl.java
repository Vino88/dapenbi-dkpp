package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.PiutangDetailDao;
import com.dapenbi.dkpp.dto.PiutangDetailDto;
import com.dapenbi.dkpp.model.MPensiun;
import com.dapenbi.dkpp.model.PiutangDetail;
import com.dapenbi.dkpp.repository.BaseRepository;
import com.dapenbi.dkpp.repository.PiutangDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PiutangDetailDaoImpl extends BaseDaoImpl<PiutangDetail, PiutangDetailDto,Long> implements PiutangDetailDao {

    private PiutangDetailRepository piutangDetailRepository;

    @Autowired
    public PiutangDetailDaoImpl(PiutangDetailRepository piutangDetailRepository) {
        super(piutangDetailRepository);
        this.piutangDetailRepository = piutangDetailRepository;
    }


    @Override
    public Page<PiutangDetail> findAllByNip(MPensiun mPensiun, Pageable pageable) {
        return piutangDetailRepository.findAllByNip(mPensiun,pageable);
    }
}
