package com.dapenbi.dkpp.repository;

import com.dapenbi.dkpp.model.JenisMutasi;

public interface JenisMutasiRepository extends BaseRepository<JenisMutasi, Long> {
    //buat find by kode/id
    JenisMutasi findOneByKodeMutasi(String kodemutasi);
}
