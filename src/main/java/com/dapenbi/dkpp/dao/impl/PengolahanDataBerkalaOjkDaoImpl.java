package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.PengolahanDataBerkalaOjkDao;
import com.dapenbi.dkpp.dto.PengolahanDataBerkalaOjkDto;
import com.dapenbi.dkpp.form.CuspReportDataBerkalaFormDto;
import com.dapenbi.dkpp.form.CuspReportDataBerkalaOjkFormDto;
import com.dapenbi.dkpp.model.PengolahanDataBerkalaOJK;
import com.dapenbi.dkpp.repository.PengolahanDataBerkalaOjkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PengolahanDataBerkalaOjkDaoImpl extends BaseDaoImpl<PengolahanDataBerkalaOJK, PengolahanDataBerkalaOjkDto, Long> implements PengolahanDataBerkalaOjkDao {

    private PengolahanDataBerkalaOjkRepository pengolahanDataBerkalaOjkRepository;

    @Autowired
    public PengolahanDataBerkalaOjkDaoImpl( PengolahanDataBerkalaOjkRepository pengolahanDataBerkalaOjkRepository){
        super(pengolahanDataBerkalaOjkRepository);
        this.pengolahanDataBerkalaOjkRepository = pengolahanDataBerkalaOjkRepository;

    }

    @Override
    public Map CuspReportDataBerkalaOjk(CuspReportDataBerkalaOjkFormDto spDto) {
        Map<String, Object> SPParam = new HashMap();
        SPParam.put("PAR_COMP_NAME", spDto.getCompName());
        SPParam.put("PAR_USER_NAME", spDto.getUserName());
        SPParam.put("PAR_PERIODE", spDto.getPeriode());

        List<String> pensiunOutSPParam = new ArrayList<>();
        pensiunOutSPParam.add("PAR_STATUS_EKSEKUSI");
        pensiunOutSPParam.add("PAR_MSG");

        return this.pengolahanDataBerkalaOjkRepository.callStoredProcedure("PengolahanDataBerkalaOJK.cuspReportDataBerkalaOjk", SPParam, pensiunOutSPParam);
    }
}
