package com.dapenbi.dkpp.dao;

import com.dapenbi.dkpp.dto.PengolahanDataBerkalaDto;
import com.dapenbi.dkpp.form.CuspReportDataBerkalaFormDto;
import com.dapenbi.dkpp.model.PengolahanDataBerkala;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Map;

public interface PengolahanDataBerkalaDao extends BaseDao<PengolahanDataBerkala, PengolahanDataBerkalaDto, Long>{

    Map cuspReportDataBerkala(CuspReportDataBerkalaFormDto cuspReportDataBerkalaFormDto);
}
