package com.dapenbi.dkpp.repository;

import com.dapenbi.dkpp.model.Kurs;

public interface KursRepository extends BaseRepository<Kurs, Long> {

    Kurs findFirstByPeriodeMutasi(String periodeMutasi);

}
