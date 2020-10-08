package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.PmbyAngsuranLebihBayarDetDao;
import com.dapenbi.dkpp.dto.PmbyAngsuranLebihBayarDetDto;
import com.dapenbi.dkpp.model.PmbyAngsuranLebihBayarDet;
import com.dapenbi.dkpp.model.PmbyAngsuranLebihBayarHead;
import com.dapenbi.dkpp.repository.PmbyAngsuranLebihBayarDetRepository;
import org.springframework.stereotype.Service;

@Service
public class PmbyAngsuranLebihBayarDetDaoImpl extends BaseDaoImpl<PmbyAngsuranLebihBayarDet, PmbyAngsuranLebihBayarDetDto, Long> implements PmbyAngsuranLebihBayarDetDao {

    private PmbyAngsuranLebihBayarDetRepository repository;

    public PmbyAngsuranLebihBayarDetDaoImpl(PmbyAngsuranLebihBayarDetRepository repository){
        super(repository);
        this.repository = repository;
    }

    @Override
    public Iterable<PmbyAngsuranLebihBayarDet> findAllByPmbyAngsuranLebihBayarHead(PmbyAngsuranLebihBayarHead pmbyAngsuranLebihBayarHead) {
        return repository.findAllByPmbyAngsuranLebihBayarHead(pmbyAngsuranLebihBayarHead);
    }
}
