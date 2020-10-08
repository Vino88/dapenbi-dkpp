package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.AgamaDao;
import com.dapenbi.dkpp.dto.AgamaDto;
import com.dapenbi.dkpp.model.Agama;
import com.dapenbi.dkpp.repository.AgamaRepository;
import com.dapenbi.dkpp.repository.BaseRepository;
import com.dapenbi.dkpp.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgamaDaoImpl extends BaseDaoImpl<Agama, AgamaDto, Long> implements AgamaDao {

    private AgamaRepository agamaRepository;

    @Autowired
    public AgamaDaoImpl(AgamaRepository agamaRepository) {
        super(agamaRepository);
        this.agamaRepository = agamaRepository;

    }

    @Override
    public Agama findBynamaAgama(String namaAgama){
        return agamaRepository.findBynamaAgama(namaAgama);
    }
}
