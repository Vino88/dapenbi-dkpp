package com.dapenbi.dkpp.dao;

import com.dapenbi.dkpp.dto.PengolahanDataBerkalaOjkDto;
import com.dapenbi.dkpp.form.CuspReportDataBerkalaFormDto;
import com.dapenbi.dkpp.form.CuspReportDataBerkalaOjkFormDto;
import com.dapenbi.dkpp.model.PengolahanDataBerkalaOJK;
import java.util.Map;

public interface PengolahanDataBerkalaOjkDao extends BaseDao<PengolahanDataBerkalaOJK, PengolahanDataBerkalaOjkDto, Long> {

    Map CuspReportDataBerkalaOjk(CuspReportDataBerkalaOjkFormDto cuspReportDataBerkalaOjkFormDto);
}
