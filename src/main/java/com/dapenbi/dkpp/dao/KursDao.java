package com.dapenbi.dkpp.dao;

import com.dapenbi.dkpp.dto.KursDto;
import com.dapenbi.dkpp.model.Kurs;

public interface KursDao extends BaseDao<Kurs, KursDto, String> {

    Kurs findFirstByPeriodeMutasi(String id);
}
