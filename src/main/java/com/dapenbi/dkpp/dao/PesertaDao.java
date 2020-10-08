package com.dapenbi.dkpp.dao;

import com.dapenbi.dkpp.dto.PesertaDto;
import com.dapenbi.dkpp.model.Peserta;
import org.springframework.data.domain.Pageable;

public interface PesertaDao extends BaseDao<Peserta, PesertaDto, String> {
    Iterable<Peserta> findNotExistsOnMutasiTransaction(String searchParam, Pageable pageable);

    Iterable<Peserta> findDataPelepasanPeserta(String searchParam, Pageable pageable);

    Peserta findByNip(String nip);
}
