package com.dapenbi.dkpp.repository;

import com.dapenbi.dkpp.model.CompositeId.LebihBayarPK;
import com.dapenbi.dkpp.model.LebihBayar;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MutasiLebihBayarRepository extends BaseRepository<LebihBayar, LebihBayarPK> {

    Page<LebihBayar> findAllByPeriodeMutasi(String periodeMutasi, Pageable pageable);



}
