package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.StatusBayarDao;
import com.dapenbi.dkpp.dto.StatusBayarDto;
import com.dapenbi.dkpp.model.StatusBayar;
import com.dapenbi.dkpp.repository.StatusBayarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusBayarDaoImpl extends BaseDaoImpl<StatusBayar, StatusBayarDto, Long> implements StatusBayarDao {
    private StatusBayarRepository statusBayarRepository;

    @Autowired
    public StatusBayarDaoImpl(StatusBayarRepository statusBayarRepository){
        super(statusBayarRepository);
        this.statusBayarRepository = statusBayarRepository;
    }



}
