package com.dapenbi.dkpp.dao.impl;


import com.dapenbi.dkpp.dao.PotonganOlahragaDao;
import com.dapenbi.dkpp.dto.PotonganOlahragaDto;
import com.dapenbi.dkpp.model.CompositeId.PotonganOlahragaPK;
import com.dapenbi.dkpp.model.PotonganOlahraga;
import com.dapenbi.dkpp.model.PotonganPga;
import com.dapenbi.dkpp.repository.PotonganOlahragaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PotonganOlahragaDaoImpl extends BaseDaoImpl<PotonganOlahraga, PotonganOlahragaDto, PotonganOlahragaPK> implements PotonganOlahragaDao {
    private PotonganOlahragaRepository potonganOlahragaRepository;


    public PotonganOlahragaDaoImpl(PotonganOlahragaRepository potonganOlahragaRepository) {
        super(potonganOlahragaRepository);
        this.potonganOlahragaRepository = potonganOlahragaRepository;
    }

    public Page<PotonganOlahraga> findAllByPeriodeMutasiAndUserStamp(String periodeMutasiPart, String userStampPart, Pageable pageable){
        return this.potonganOlahragaRepository.findAllByPeriodeMutasiAndUserStamp(periodeMutasiPart, userStampPart, pageable);
    }
}
