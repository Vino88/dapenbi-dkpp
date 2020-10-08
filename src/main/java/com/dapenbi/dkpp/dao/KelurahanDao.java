package com.dapenbi.dkpp.dao;

import com.dapenbi.dkpp.dto.KelurahanDto;
import com.dapenbi.dkpp.model.Kelurahan;

public interface KelurahanDao extends BaseDao< Kelurahan, KelurahanDto, Long> {
    Object findAlamatByKodePos(String kodePos);
}
