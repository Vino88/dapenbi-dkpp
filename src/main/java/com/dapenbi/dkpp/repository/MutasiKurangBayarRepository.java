package com.dapenbi.dkpp.repository;

import com.dapenbi.dkpp.model.KurangBayar;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MutasiKurangBayarRepository extends BaseRepository<KurangBayar, Long> {
    Page<KurangBayar> findAllByPeriodeMutasi(String periodeMutasi, Pageable pageable);
}
