package com.dapenbi.dkpp.dao;

import com.dapenbi.dkpp.dto.TempPotonganOlahragaDto;
import com.dapenbi.dkpp.form.UploadPotonganSummaryDto;
import com.dapenbi.dkpp.model.TempPotonganOlahraga;

public interface TempPotonganOlahragaDao extends BaseDao<TempPotonganOlahraga, TempPotonganOlahragaDto, Long> {
    void deleteAll();

    UploadPotonganSummaryDto getSummary();
}