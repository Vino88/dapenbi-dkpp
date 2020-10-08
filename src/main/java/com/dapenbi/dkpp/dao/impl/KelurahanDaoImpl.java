package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.KecamatanDao;
import com.dapenbi.dkpp.dao.KelurahanDao;
import com.dapenbi.dkpp.dto.KecamatanDto;
import com.dapenbi.dkpp.dto.KelurahanDto;
import com.dapenbi.dkpp.model.Kecamatan;
import com.dapenbi.dkpp.model.Kelurahan;
import com.dapenbi.dkpp.repository.BaseRepository;
import com.dapenbi.dkpp.repository.KecamatanRepository;
import com.dapenbi.dkpp.repository.KelurahanRepository;
import org.springframework.stereotype.Service;

@Service
public class KelurahanDaoImpl extends BaseDaoImpl<Kelurahan, KelurahanDto, Long> implements KelurahanDao {
    private KelurahanRepository kelurahanRepository;


    public KelurahanDaoImpl(KelurahanRepository kelurahanRepository) {
        super(kelurahanRepository);
        this.kelurahanRepository = kelurahanRepository;
    }


    @Override
    public Object findAlamatByKodePos(String kodePos) {
        return kelurahanRepository.findAlamatByKodePos(kodePos);
    }
}
