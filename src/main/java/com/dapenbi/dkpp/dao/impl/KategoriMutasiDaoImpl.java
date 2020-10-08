package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.KategoriMutasiDao;
import com.dapenbi.dkpp.dto.KategoriMutasiDto;
import com.dapenbi.dkpp.model.KategoriMutasi;
import com.dapenbi.dkpp.repository.BaseRepository;
import com.dapenbi.dkpp.repository.KategoriMutasiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KategoriMutasiDaoImpl extends BaseDaoImpl<KategoriMutasi, KategoriMutasiDto, String> implements KategoriMutasiDao {
    private KategoriMutasiRepository kategoriMutasiRepository;

    @Autowired
    public KategoriMutasiDaoImpl(KategoriMutasiRepository kategoriMutasiRepository) {
        super(kategoriMutasiRepository);
        this.kategoriMutasiRepository = kategoriMutasiRepository;
    }
}
