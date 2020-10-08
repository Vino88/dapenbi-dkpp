package com.dapenbi.dkpp.dao;


import com.dapenbi.dkpp.dto.PmbyPiutangHistoryDto;
import com.dapenbi.dkpp.model.PmbyPiutangHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PmbyPiutangHistoryDao extends BaseDao<PmbyPiutangHistory, PmbyPiutangHistoryDto, Long> {
    Page<PmbyPiutangHistory> findAllByNip(String nip, Pageable pageable);
}