package com.dapenbi.dkpp.dao;

import com.dapenbi.dkpp.dto.SetupParameterDto;
import com.dapenbi.dkpp.model.SetupParameter;

public interface SetupParameterDao extends BaseDao<SetupParameter, SetupParameterDto, Long>{
    SetupParameter findByPeriode(String id);

    SetupParameter findByBukaPeriode();
    SetupParameter findByTutupPeriode();

    String getSystemDate();
}
