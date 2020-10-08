package com.dapenbi.dkpp.repository;

import com.dapenbi.dkpp.model.KeluargaPeserta;
import org.springframework.stereotype.Repository;

@Repository
public interface KeluargaPesertaRepository extends BaseRepository<KeluargaPeserta, String> {
    Iterable<KeluargaPeserta> findAllByNip(String nip);
}
