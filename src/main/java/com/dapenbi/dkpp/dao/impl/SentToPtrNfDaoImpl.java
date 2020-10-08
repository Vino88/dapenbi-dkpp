package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.BaseDao;
import com.dapenbi.dkpp.dao.SentToPtrNfDao;
import com.dapenbi.dkpp.dto.SentToPtrNfDto;
import com.dapenbi.dkpp.model.SentToPtrNf;
import com.dapenbi.dkpp.repository.SentToPtrNfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SentToPtrNfDaoImpl extends BaseDaoImpl<SentToPtrNf, SentToPtrNfDto, Long> implements SentToPtrNfDao {

    SentToPtrNfRepository sentToPtrNfRepository;

    @Autowired
    public SentToPtrNfDaoImpl(SentToPtrNfRepository sentToPtrNfRepository){
        super(sentToPtrNfRepository);
        this.sentToPtrNfRepository = sentToPtrNfRepository;
    }
}
