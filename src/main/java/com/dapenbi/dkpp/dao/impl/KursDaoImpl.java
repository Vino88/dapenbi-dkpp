package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.KursDao;
import com.dapenbi.dkpp.dto.KursDto;
import com.dapenbi.dkpp.model.Kurs;
import com.dapenbi.dkpp.repository.BaseRepository;
import com.dapenbi.dkpp.repository.KursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KursDaoImpl extends BaseDaoImpl<Kurs, KursDto, String> implements KursDao {
    private KursRepository kursRepository;

    @Autowired
    public KursDaoImpl(KursRepository kursRepository) {
        super(kursRepository);
        this.kursRepository = kursRepository;
    }

    @Override
    public Kurs findFirstByPeriodeMutasi(String id) {
        return (Kurs) this.kursRepository.findFirstByPeriodeMutasi(id);
    }
}
