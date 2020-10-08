package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.PiutangDao;
import com.dapenbi.dkpp.dto.PiutangDto;
import com.dapenbi.dkpp.model.Piutang;
import com.dapenbi.dkpp.repository.BaseRepository;
import com.dapenbi.dkpp.repository.PiutangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PiutangDaoImpl extends BaseDaoImpl<Piutang, PiutangDto, String> implements PiutangDao {

   private PiutangRepository piutangRepository;

    @Autowired
    public PiutangDaoImpl(PiutangRepository piutangRepository) {
        super(piutangRepository);
        this.piutangRepository = piutangRepository;
    }

    @Override
    public Page<Piutang> findAllBySisaPiutang(String searchParam, Pageable pageable) {
        return piutangRepository.findAllBySisaPiutang(searchParam,pageable);
    }
}
