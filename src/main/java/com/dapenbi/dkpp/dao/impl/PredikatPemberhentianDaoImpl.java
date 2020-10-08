package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.PredikatPemberhentianDao;
import com.dapenbi.dkpp.dto.PredikatPemberhentianDto;
import com.dapenbi.dkpp.form.KategoriPensiunFormDto;
import com.dapenbi.dkpp.model.PredikatPemberhentian;
import com.dapenbi.dkpp.repository.BaseRepository;
import com.dapenbi.dkpp.repository.PredikatPemberhentianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PredikatPemberhentianDaoImpl extends BaseDaoImpl<PredikatPemberhentian, PredikatPemberhentianDto, Long> implements PredikatPemberhentianDao {

    private PredikatPemberhentianRepository predikatPemberhentianRepository;

    @Autowired
    public PredikatPemberhentianDaoImpl(PredikatPemberhentianRepository predikatPemberhentianRepository) {
        super(predikatPemberhentianRepository);
        this.predikatPemberhentianRepository = predikatPemberhentianRepository;
    }
}
