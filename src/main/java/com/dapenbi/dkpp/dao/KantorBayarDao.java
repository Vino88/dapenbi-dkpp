package com.dapenbi.dkpp.dao;

import com.dapenbi.dkpp.dto.KantorBayarDto;
import com.dapenbi.dkpp.model.KantorBayar;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface KantorBayarDao extends BaseDao<KantorBayar, KantorBayarDto, String> {

        Page<KantorBayar> findAllKantorBayar(String searchParam, Pageable pageable);

        Page<KantorBayar> findByOrderAsc(String searchParam, Pageable pageable);
}