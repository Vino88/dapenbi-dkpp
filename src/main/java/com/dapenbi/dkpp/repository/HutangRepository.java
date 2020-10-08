package com.dapenbi.dkpp.repository;

import com.dapenbi.dkpp.dto.HutangDto;
import com.dapenbi.dkpp.model.Hutang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

	
public interface HutangRepository extends BaseRepository<Hutang, String> {
    Hutang findFirstByNipAndPeriodeMutasi(String nip, String periodeMutasi);

    @Query(
            value = "select h from Hutang h where h.type in (?1)"
    )
    Page<Hutang> findAllByType(String type[], Pageable pageable);

    @Query(
            value = "select h from Hutang h where h.type in (?1) and lower(h.namaPeserta) like lower(?2)"
    )
    Page<Hutang> findAllByType(String type[], String searchParam, Pageable pageable);
}