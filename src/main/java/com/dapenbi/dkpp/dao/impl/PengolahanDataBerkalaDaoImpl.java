package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.PengolahanDataBerkalaDao;
import com.dapenbi.dkpp.dto.PengolahanDataBerkalaDto;
import com.dapenbi.dkpp.form.CuspReportDataBerkalaFormDto;
import com.dapenbi.dkpp.model.PengolahanDataBerkala;
import com.dapenbi.dkpp.repository.PengolahanDataBerkalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PengolahanDataBerkalaDaoImpl extends BaseDaoImpl<PengolahanDataBerkala, PengolahanDataBerkalaDto, Long> implements PengolahanDataBerkalaDao {


    private PengolahanDataBerkalaRepository pengolahanDataBerkalaRepository;

    @Autowired
    public PengolahanDataBerkalaDaoImpl (PengolahanDataBerkalaRepository pengolahanDataBerkalaRepository){
        super(pengolahanDataBerkalaRepository);
        this.pengolahanDataBerkalaRepository = pengolahanDataBerkalaRepository;
    }

    @Override
    public Map cuspReportDataBerkala(CuspReportDataBerkalaFormDto spDto) {
        Map<String, Object> pensiunSPParam = new HashMap();
        pensiunSPParam.put("PAR_COMP_NAME", spDto.getCompName());
        pensiunSPParam.put("PAR_USER_NAME", spDto.getUserName());
        pensiunSPParam.put("PAR_PERIODE", spDto.getPeriode());
        pensiunSPParam.put("PAR_REQUEST_BY", spDto.getRequestBy());
        pensiunSPParam.put("PAR_JENIS_REPORT", spDto.getJenisReport());

        List<String> pensiunOutSPParam = new ArrayList<>();
        pensiunOutSPParam.add("PAR_STATUS_EKSEKUSI");
        pensiunOutSPParam.add("PAR_MSG");

        return this.pengolahanDataBerkalaRepository.callStoredProcedure("PengolahanDataBerkala.cuspReportDataBerkala", pensiunSPParam, pensiunOutSPParam);
    }


}
