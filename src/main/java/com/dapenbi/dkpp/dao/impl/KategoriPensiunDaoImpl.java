package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.KategoriPensiunDao;
import com.dapenbi.dkpp.dto.KategoriPensiunDto;
import com.dapenbi.dkpp.model.KategoriPensiun;
import com.dapenbi.dkpp.repository.KategoriPensiunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KategoriPensiunDaoImpl extends BaseDaoImpl<KategoriPensiun, KategoriPensiunDto, String> implements KategoriPensiunDao {

    private KategoriPensiunRepository kategoriPensiunRepository;

    @Autowired
    public KategoriPensiunDaoImpl(KategoriPensiunRepository kategoriPensiunRepository){
        super(kategoriPensiunRepository);
        this.kategoriPensiunRepository = kategoriPensiunRepository;
    }
}
