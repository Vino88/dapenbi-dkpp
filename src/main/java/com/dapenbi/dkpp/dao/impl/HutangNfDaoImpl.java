package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.HutangNfDao;
import com.dapenbi.dkpp.dto.HutangNfDto;
import com.dapenbi.dkpp.model.HutangNF;
import com.dapenbi.dkpp.repository.HutangNfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HutangNfDaoImpl extends BaseDaoImpl<HutangNF, HutangNfDto, Long> implements HutangNfDao {

    private HutangNfRepository hutangNfRepository;

    @Autowired
    public HutangNfDaoImpl(HutangNfRepository hutangNfRepository){
        super(hutangNfRepository);
        this.hutangNfRepository = hutangNfRepository;
    }
}
