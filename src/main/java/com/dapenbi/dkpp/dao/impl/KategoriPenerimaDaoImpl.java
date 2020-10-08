package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.KategoriPenerimaDao;
import com.dapenbi.dkpp.dto.KategoriPenerimaDto;
import com.dapenbi.dkpp.model.KategoriPenerima;
import com.dapenbi.dkpp.repository.KategoriPenerimaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KategoriPenerimaDaoImpl extends BaseDaoImpl<KategoriPenerima, KategoriPenerimaDto, Long> implements KategoriPenerimaDao {
    private KategoriPenerimaRepository kategoriPenerimaRepository;

    @Autowired
    public KategoriPenerimaDaoImpl(KategoriPenerimaRepository kategoriPenerimaRepository){
        super(kategoriPenerimaRepository);
        this.kategoriPenerimaRepository = kategoriPenerimaRepository;
    }

    @Override
    public KategoriPenerima findFirstById(Long id) {
        return kategoriPenerimaRepository.findFirstById(id);
    }
}
