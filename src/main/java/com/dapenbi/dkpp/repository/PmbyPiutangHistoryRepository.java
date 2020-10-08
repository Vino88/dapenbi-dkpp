package com.dapenbi.dkpp.repository;

import com.dapenbi.dkpp.model.PmbyPiutangHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

	
public interface PmbyPiutangHistoryRepository extends BaseRepository<PmbyPiutangHistory, Long> {
    Page<PmbyPiutangHistory> findAllByNip(String nip, Pageable pageable);
}