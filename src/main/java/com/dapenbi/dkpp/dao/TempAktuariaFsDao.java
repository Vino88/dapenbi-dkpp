package com.dapenbi.dkpp.dao;

import com.dapenbi.dkpp.dto.TempAktuariaFsDto;
import com.dapenbi.dkpp.dto.UploadHeaderSummaryDto;
import com.dapenbi.dkpp.model.TempAktuariaFs;

public interface TempAktuariaFsDao extends BaseDao<TempAktuariaFs, TempAktuariaFsDto,Long>{

    void deleteAll();

    UploadHeaderSummaryDto getSummary();

}
