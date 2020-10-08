package com.dapenbi.dkpp.dao;

import com.dapenbi.dkpp.dto.PiutangDto;
import com.dapenbi.dkpp.model.Piutang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PiutangDao extends BaseDao<Piutang, PiutangDto, String> {

    Page<Piutang> findAllBySisaPiutang(String searchParam, Pageable pageable);
}
