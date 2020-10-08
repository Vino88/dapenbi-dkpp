package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.JenisMpsDao;
import com.dapenbi.dkpp.dao.JenisMutasiDao;
import com.dapenbi.dkpp.dto.JenisMpsDto;
import com.dapenbi.dkpp.dto.JenisMutasiDto;
import com.dapenbi.dkpp.model.JenisMps;
import com.dapenbi.dkpp.model.JenisMutasi;
import com.dapenbi.dkpp.repository.BaseRepository;
import com.dapenbi.dkpp.repository.JenisMpsRepository;
import com.dapenbi.dkpp.repository.JenisMutasiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JenisMutasiDaoImpl extends BaseDaoImpl<JenisMutasi, JenisMutasiDto, String> implements JenisMutasiDao {
    private JenisMutasiRepository jenisMutasiRepository;

    @Autowired
    public JenisMutasiDaoImpl(JenisMutasiRepository jenisMutasiRepository) {
        super(jenisMutasiRepository);
        this.jenisMutasiRepository = jenisMutasiRepository;
    }

    @Override
    public JenisMutasi findByKode(String id) {
        return this.jenisMutasiRepository.findOneByKodeMutasi(id);
    }
}
