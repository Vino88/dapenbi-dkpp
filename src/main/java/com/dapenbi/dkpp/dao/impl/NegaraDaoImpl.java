package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.NegaraDao;
import com.dapenbi.dkpp.dto.NegaraDto;
import com.dapenbi.dkpp.model.Negara;
import com.dapenbi.dkpp.repository.NegaraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NegaraDaoImpl extends BaseDaoImpl<Negara, NegaraDto, Long> implements NegaraDao {
    private NegaraRepository negaraRepository;

    @Autowired
    public NegaraDaoImpl(NegaraRepository negaraRepository) {
        super(negaraRepository);
        this.negaraRepository = negaraRepository;
    }
}
