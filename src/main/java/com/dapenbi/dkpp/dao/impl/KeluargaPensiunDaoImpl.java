package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.KeluargaPensiunDao;
import com.dapenbi.dkpp.dto.KeluargaPensiunDto;
import com.dapenbi.dkpp.model.KeluargaPensiun;
import com.dapenbi.dkpp.repository.KeluargaPensiunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class KeluargaPensiunDaoImpl extends BaseDaoImpl<KeluargaPensiun, KeluargaPensiunDto, String> implements KeluargaPensiunDao {
    private KeluargaPensiunRepository keluargaPensiunRepository;

    @Autowired
    public KeluargaPensiunDaoImpl(KeluargaPensiunRepository keluargaPensiunRepository){
        super(keluargaPensiunRepository);
        this.keluargaPensiunRepository = keluargaPensiunRepository;
    }

    @Override
    @Transactional
    public void deleteByNip(String nip) {
        keluargaPensiunRepository.deleteAllByNip(nip);
    }

    @Override
    public Iterable<KeluargaPensiun> findAllByNip(String nip) {
        return keluargaPensiunRepository.findAllByNip(nip);
    }


}
