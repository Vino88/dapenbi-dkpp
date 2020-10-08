package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.KeluargaPesertaDao;
import com.dapenbi.dkpp.dto.KeluargaPesertaDto;
import com.dapenbi.dkpp.model.KeluargaPeserta;
import com.dapenbi.dkpp.repository.KeluargaPesertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeluargaPesertaDaoImpl extends BaseDaoImpl<KeluargaPeserta, KeluargaPesertaDto, String> implements KeluargaPesertaDao {
    private KeluargaPesertaRepository keluargaPesertaRepository;

    @Autowired
    public KeluargaPesertaDaoImpl(KeluargaPesertaRepository keluargaPesertaRepository){
        super(keluargaPesertaRepository);
        this.keluargaPesertaRepository = keluargaPesertaRepository;
    }

    @Override
    public Iterable<KeluargaPeserta> findByNip(String nip) {
        return keluargaPesertaRepository.findAllByNip(nip);
    }
}
