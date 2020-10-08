package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.FaktorFsDao;
import com.dapenbi.dkpp.dto.FaktorFsDto;
import com.dapenbi.dkpp.model.FaktorFs;
import com.dapenbi.dkpp.repository.FaktorFsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FaktorFsDaoImpl extends BaseDaoImpl<FaktorFs, FaktorFsDto, Long> implements FaktorFsDao {

    private FaktorFsRepository faktorFsRepository;

    @Autowired
    public FaktorFsDaoImpl(FaktorFsRepository faktorFsRepository){
        super(faktorFsRepository);
        this.faktorFsRepository = faktorFsRepository;
    }
}
