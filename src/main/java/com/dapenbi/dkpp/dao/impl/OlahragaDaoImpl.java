package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.OlahragaDao;
import com.dapenbi.dkpp.dto.OlahragaDto;
import com.dapenbi.dkpp.model.Olahraga;
import com.dapenbi.dkpp.repository.OlahragaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OlahragaDaoImpl extends BaseDaoImpl<Olahraga, OlahragaDto, Long> implements OlahragaDao {

    private OlahragaRepository olahragaRepository;

    @Autowired
    public OlahragaDaoImpl(OlahragaRepository olahragaRepository){
        super(olahragaRepository);
        this.olahragaRepository = olahragaRepository;
    }


}
