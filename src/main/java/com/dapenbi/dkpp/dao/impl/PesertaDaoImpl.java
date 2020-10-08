package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.PesertaDao;
import com.dapenbi.dkpp.dto.PesertaDto;
import com.dapenbi.dkpp.model.Peserta;
import com.dapenbi.dkpp.repository.PesertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PesertaDaoImpl extends BaseDaoImpl<Peserta, PesertaDto, String> implements PesertaDao {

    private PesertaRepository pesertaRepository;

    @Autowired
    public PesertaDaoImpl(PesertaRepository pesertaRepository){
        super(pesertaRepository);
        this.pesertaRepository = pesertaRepository;
    }

    @Override
    public Iterable<Peserta> findNotExistsOnMutasiTransaction(String searchParam, Pageable pageable) {
        return pesertaRepository.findNotExistsOnMutasiTransaction(searchParam, pageable);
    }

    @Override
    public Iterable<Peserta> findDataPelepasanPeserta(String searchParam, Pageable pageable) {
        return pesertaRepository.findPesertaPelepasan(searchParam, pageable);
    }

    @Override
    public Peserta findByNip(String nip) {
        return pesertaRepository.findFirstByNip(nip);
    }
}
