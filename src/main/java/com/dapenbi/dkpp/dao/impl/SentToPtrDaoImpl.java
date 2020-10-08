package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.SentToPtrDao;
import com.dapenbi.dkpp.dto.SentToPtrDto;
import com.dapenbi.dkpp.model.SentToPtr;
import com.dapenbi.dkpp.repository.SentToPtrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SentToPtrDaoImpl extends BaseDaoImpl<SentToPtr, SentToPtrDto, Long> implements SentToPtrDao {
    private SentToPtrRepository sentToPtrRepository;

    @Autowired
    public SentToPtrDaoImpl(SentToPtrRepository sentToPtrRepository){
        super(sentToPtrRepository);
        this.sentToPtrRepository = sentToPtrRepository;
    }


}