package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.GolonganDao;
import com.dapenbi.dkpp.dto.GolonganDto;
import com.dapenbi.dkpp.model.Golongan;
import com.dapenbi.dkpp.repository.GolonganRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GolonganDaoImpl extends BaseDaoImpl<Golongan, GolonganDto, Long> implements GolonganDao {

   private GolonganRepository golonganRepository;


    @Autowired
    public GolonganDaoImpl(GolonganRepository golonganRepository) {
        super(golonganRepository);
        this.golonganRepository = golonganRepository;
    }
}
