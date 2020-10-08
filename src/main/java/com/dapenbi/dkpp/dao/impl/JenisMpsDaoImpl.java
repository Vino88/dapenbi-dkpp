package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.JenisMpsDao;
import com.dapenbi.dkpp.dto.JenisMpsDto;
import com.dapenbi.dkpp.model.JenisMps;
import com.dapenbi.dkpp.repository.BaseRepository;
import com.dapenbi.dkpp.repository.JenisMpsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JenisMpsDaoImpl extends BaseDaoImpl<JenisMps, JenisMpsDto, Long> implements JenisMpsDao {
    private JenisMpsRepository jenisMpsRepository;

    @Autowired
    public JenisMpsDaoImpl(JenisMpsRepository jenisMpsRepository) {
        super(jenisMpsRepository);
        this.jenisMpsRepository = jenisMpsRepository;
    }
}
