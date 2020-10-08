package com.dapenbi.dkpp.repository;

import com.dapenbi.dkpp.model.KantorBayar;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface KantorBayarRepository extends BaseRepository<KantorBayar, Long> {

    @Query(
            value = "select kb from KantorBayar kb where ( lower(kb.namaKantorBayar) like lower(?1)) ORDER BY kb.namaKantorBayar ASC "
    )
    Page<KantorBayar> findSortKantorBayar(String searchParam, Pageable pageable);

    @Query(
            value = "select kb from KantorBayar kb ORDER BY kb.namaKantorBayar ASC"
    )
    Page<KantorBayar> findSortAsc(String searchParam, Pageable pageable);
}
