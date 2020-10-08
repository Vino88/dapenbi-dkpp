package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.ProvinsiDao;
import com.dapenbi.dkpp.dto.ProvinsiDto;
import com.dapenbi.dkpp.form.ProvinsiFormDto;
import com.dapenbi.dkpp.model.Provinsi;
import com.dapenbi.dkpp.repository.BaseRepository;
import com.dapenbi.dkpp.repository.ProvinsiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProvinsiDaoImpl extends BaseDaoImpl<Provinsi, ProvinsiDto, Long> implements ProvinsiDao {
    private ProvinsiRepository provinsiRepository;

    @Autowired
    public ProvinsiDaoImpl(ProvinsiRepository provinsiRepository) {
        super(provinsiRepository);
        this.provinsiRepository = provinsiRepository;
    }
}
