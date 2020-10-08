package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.KecamatanDao;
import com.dapenbi.dkpp.dto.KecamatanDto;
import com.dapenbi.dkpp.model.Kecamatan;
import com.dapenbi.dkpp.repository.BaseRepository;
import com.dapenbi.dkpp.repository.KecamatanRepository;
import org.springframework.stereotype.Service;

@Service
public class KecamatanDaoImpl extends BaseDaoImpl<Kecamatan, KecamatanDto, Long> implements KecamatanDao {
    private KecamatanRepository kecamatanRepository;


    public KecamatanDaoImpl(KecamatanRepository kecamatanRepository) {
        super(kecamatanRepository);
        this.kecamatanRepository = kecamatanRepository;
    }
}
