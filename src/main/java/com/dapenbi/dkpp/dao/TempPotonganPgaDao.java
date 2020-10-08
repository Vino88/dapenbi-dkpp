package com.dapenbi.dkpp.dao;

import com.dapenbi.dkpp.dto.TempPotonganPgaDto;
import com.dapenbi.dkpp.form.UploadPotonganSummaryDto;
import com.dapenbi.dkpp.model.TempPotonganPga;

public interface TempPotonganPgaDao extends BaseDao<TempPotonganPga, TempPotonganPgaDto, Long> {

    void deleteAll();

    UploadPotonganSummaryDto getSummary();

}