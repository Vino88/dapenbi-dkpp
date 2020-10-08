package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.JenisBankDao;
import com.dapenbi.dkpp.dto.JenisBankDto;
import com.dapenbi.dkpp.model.JenisBank;
import com.dapenbi.dkpp.repository.JenisBankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JenisBankDaoImpl extends BaseDaoImpl<JenisBank, JenisBankDto, Long> implements JenisBankDao {

    private JenisBankRepository jenisBankRepository;

    @Autowired
    public JenisBankDaoImpl(JenisBankRepository jenisBankRepository) {
        super(jenisBankRepository);
        this.jenisBankRepository = jenisBankRepository;
    }
}
