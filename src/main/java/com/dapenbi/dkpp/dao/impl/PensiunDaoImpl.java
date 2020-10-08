package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.PensiunDao;
import com.dapenbi.dkpp.dto.PensiunDto;
import com.dapenbi.dkpp.model.Pensiun;
import com.dapenbi.dkpp.repository.PensiunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PensiunDaoImpl extends BaseDaoImpl<Pensiun, PensiunDto, Long> implements PensiunDao {

    private PensiunRepository pensiunRepository;

    @Autowired
    public PensiunDaoImpl(PensiunRepository pensiunRepository) {
        super(pensiunRepository);
        this.pensiunRepository = pensiunRepository;
    }
}
