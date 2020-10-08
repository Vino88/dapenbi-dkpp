package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.AlasanHentiDao;
import com.dapenbi.dkpp.dto.AlasanHentiDto;
import com.dapenbi.dkpp.model.AlasanHenti;
import com.dapenbi.dkpp.repository.AlasanHentiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlasanHentiDaoImpl extends BaseDaoImpl<AlasanHenti, AlasanHentiDto, String> implements AlasanHentiDao {
    private AlasanHentiRepository alasanHentiRepository;

    @Autowired
    public AlasanHentiDaoImpl(AlasanHentiRepository alasanHentiRepository){
        super(alasanHentiRepository);
        this.alasanHentiRepository = alasanHentiRepository;
    }
}
