package com.dapenbi.dkpp.dao.impl;


import com.dapenbi.dkpp.dao.PotonganOlahragaDao;
import com.dapenbi.dkpp.dao.PotonganPgaDao;
import com.dapenbi.dkpp.dto.PotonganOlahragaDto;
import com.dapenbi.dkpp.dto.PotonganPgaDto;
import com.dapenbi.dkpp.model.CompositeId.PotonganPgaPK;
import com.dapenbi.dkpp.model.PotonganOlahraga;
import com.dapenbi.dkpp.model.PotonganPga;
import com.dapenbi.dkpp.repository.PotonganOlahragaRepository;
import com.dapenbi.dkpp.repository.PotonganPgaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PotonganPgaDaoImpl extends BaseDaoImpl<PotonganPga, PotonganPgaDto, PotonganPgaPK> implements PotonganPgaDao {
    private PotonganPgaRepository potonganPgaRepository;

    @Autowired
    public PotonganPgaDaoImpl(PotonganPgaRepository potonganPgaRepository) {
        super(potonganPgaRepository);
        this.potonganPgaRepository = potonganPgaRepository;
    }

    public Page<PotonganPga> findAllByPeriodeMutasiAndUserStamp(String periodeMutasiPart, String userStampPart, Pageable pageable){
        return this.potonganPgaRepository.findAllByPeriodeMutasiAndUserStamp(periodeMutasiPart, userStampPart, pageable);
    }

}
