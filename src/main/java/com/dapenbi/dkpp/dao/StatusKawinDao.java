package com.dapenbi.dkpp.dao;

import com.dapenbi.dkpp.dto.StatusKawinDto;
import com.dapenbi.dkpp.model.StatusKawin;

public interface StatusKawinDao extends BaseDao<StatusKawin, StatusKawinDto, Long> {


    StatusKawin findFirstById(Long valueOf);
}
