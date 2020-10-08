package com.dapenbi.dkpp.dao;


import com.dapenbi.dkpp.dto.TempAktuariaFprDto;
import com.dapenbi.dkpp.dto.UploadHeaderSummaryDto;
import com.dapenbi.dkpp.model.TempAktuariaFpr;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TempAktuariaFprDao extends BaseDao<TempAktuariaFpr, TempAktuariaFprDto, Long> {

    void deleteAll();

    UploadHeaderSummaryDto getSummary();
}