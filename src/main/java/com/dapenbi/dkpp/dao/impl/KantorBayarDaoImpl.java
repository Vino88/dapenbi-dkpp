package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.AlasanHentiDao;
import com.dapenbi.dkpp.dao.KantorBayarDao;
import com.dapenbi.dkpp.dto.AlasanHentiDto;
import com.dapenbi.dkpp.dto.KantorBayarDto;
import com.dapenbi.dkpp.model.AlasanHenti;
import com.dapenbi.dkpp.model.KantorBayar;
import com.dapenbi.dkpp.repository.AlasanHentiRepository;
import com.dapenbi.dkpp.repository.KantorBayarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class KantorBayarDaoImpl extends BaseDaoImpl<KantorBayar, KantorBayarDto, String> implements KantorBayarDao {
    private KantorBayarRepository kantorBayarRepository;

    @Autowired
    public KantorBayarDaoImpl(KantorBayarRepository kantorBayarRepository){
        super(kantorBayarRepository);
        this.kantorBayarRepository = kantorBayarRepository;
    }


    @Override
    public Page<KantorBayar> findAllKantorBayar(String searchParam, Pageable pageable) {
        return kantorBayarRepository.findSortKantorBayar(searchParam, pageable);
    }

    @Override
    public Page<KantorBayar> findByOrderAsc(String searchParam, Pageable pageable) {
        return kantorBayarRepository.findSortAsc(searchParam, pageable);
    }
}
