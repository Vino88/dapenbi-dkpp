package com.dapenbi.dkpp.dao;

import com.dapenbi.dkpp.dto.JenisMutasiDto;
import com.dapenbi.dkpp.model.JenisMutasi;

public interface JenisMutasiDao extends BaseDao<JenisMutasi, JenisMutasiDto, String> {
    JenisMutasi findByKode(String id);
}
