package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.KotaDao;
import com.dapenbi.dkpp.dto.KotaDto;
import com.dapenbi.dkpp.model.Kota;
import com.dapenbi.dkpp.repository.KotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KotaDaoImpl extends BaseDaoImpl<Kota, KotaDto, Long> implements KotaDao {
    private KotaRepository kotaRepository;

    @Autowired
    public KotaDaoImpl(KotaRepository kotaRepository) {
        super(kotaRepository);
        this.kotaRepository = kotaRepository;
    }
}
