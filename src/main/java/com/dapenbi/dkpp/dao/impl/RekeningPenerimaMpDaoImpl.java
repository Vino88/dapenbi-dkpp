package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.RekeningPenerimaMpDao;
import com.dapenbi.dkpp.dto.RekeningPenerimaMpDto;
import com.dapenbi.dkpp.model.RekeningPenerimaMp;
import com.dapenbi.dkpp.repository.RekeningPenerimaMpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RekeningPenerimaMpDaoImpl extends BaseDaoImpl<RekeningPenerimaMp, RekeningPenerimaMpDto, Long> implements RekeningPenerimaMpDao {

    private RekeningPenerimaMpRepository rekeningPenerimaMpRepository;

    @Autowired
    public RekeningPenerimaMpDaoImpl(RekeningPenerimaMpRepository rekeningPenerimaMpRepository){
        super(rekeningPenerimaMpRepository);
        this.rekeningPenerimaMpRepository = rekeningPenerimaMpRepository;
    }

    @Override
    public RekeningPenerimaMp findByNip(String nip) {
        return rekeningPenerimaMpRepository.findByNip(nip);
    }
}
