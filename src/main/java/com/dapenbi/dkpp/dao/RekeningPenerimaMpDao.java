package com.dapenbi.dkpp.dao;

import com.dapenbi.dkpp.dto.RekeningPenerimaMpDto;
import com.dapenbi.dkpp.model.RekeningPenerimaMp;

public interface RekeningPenerimaMpDao extends BaseDao<RekeningPenerimaMp, RekeningPenerimaMpDto, Long> {

    RekeningPenerimaMp findByNip(String nip);
}