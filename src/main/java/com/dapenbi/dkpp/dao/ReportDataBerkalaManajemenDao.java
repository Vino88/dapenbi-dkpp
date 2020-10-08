package com.dapenbi.dkpp.dao;

import com.dapenbi.dkpp.dto.ReportDataBerkalaManajemenDto;
import com.dapenbi.dkpp.form.CuspReportDataBerkalaManajemenFormDto;
import com.dapenbi.dkpp.model.ReportDataBerkalaManajemen;

import java.util.Map;

public interface ReportDataBerkalaManajemenDao extends BaseDao<ReportDataBerkalaManajemen, ReportDataBerkalaManajemenDto, Long> {

    Map cuspReportManajemen(CuspReportDataBerkalaManajemenFormDto cuspReportDataBerkalaManajemenFormDto);
}
