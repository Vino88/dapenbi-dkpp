package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.FaktorFPRDao;
import com.dapenbi.dkpp.dto.FaktorFprDto;
import com.dapenbi.dkpp.model.FaktorFPR;
import com.dapenbi.dkpp.repository.BaseRepository;
import com.dapenbi.dkpp.repository.FaktorFPRRepository;
import org.springframework.stereotype.Service;

@Service
public class FaktorFPRDaoImpl extends BaseDaoImpl<FaktorFPR, FaktorFprDto, Long> implements FaktorFPRDao {
    private FaktorFPRRepository faktorFPRRepository;

    public FaktorFPRDaoImpl(FaktorFPRRepository faktorFPRRepository) {
        super(faktorFPRRepository);
        this.faktorFPRRepository = faktorFPRRepository;
    }
}
