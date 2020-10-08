package com.dapenbi.dkpp.repository;

import com.dapenbi.dkpp.model.LebihBayarDetail;

public interface MutasiLebihBayarDetailRepository extends BaseRepository<LebihBayarDetail, Long> {
    Iterable<LebihBayarDetail> findByNipAndPeriodeMutasi(String nip, String periodeMutasi);


}
