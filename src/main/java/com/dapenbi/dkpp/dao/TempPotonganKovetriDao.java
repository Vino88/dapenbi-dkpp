package com.dapenbi.dkpp.dao;

import com.dapenbi.dkpp.dto.TempPotonganKovetriDto;
import com.dapenbi.dkpp.form.UploadPotonganSummaryDto;
import com.dapenbi.dkpp.model.TempPotonganKovetri;

public interface TempPotonganKovetriDao extends BaseDao<TempPotonganKovetri, TempPotonganKovetriDto, Long> {
    void deleteAll();

    UploadPotonganSummaryDto getSummary();
}