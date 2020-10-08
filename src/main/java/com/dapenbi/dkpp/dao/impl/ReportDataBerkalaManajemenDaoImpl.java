package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.ReportDataBerkalaManajemenDao;
import com.dapenbi.dkpp.dto.ReportDataBerkalaManajemenDto;
import com.dapenbi.dkpp.form.CuspReportDataBerkalaManajemenFormDto;
import com.dapenbi.dkpp.model.ReportDataBerkalaManajemen;
import com.dapenbi.dkpp.repository.ReportDataBerkalaManajemenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportDataBerkalaManajemenDaoImpl extends BaseDaoImpl<ReportDataBerkalaManajemen, ReportDataBerkalaManajemenDto, Long> implements ReportDataBerkalaManajemenDao {

    private ReportDataBerkalaManajemenRepository reportDataBerkalaManajemenRepository;

    @Autowired
    public ReportDataBerkalaManajemenDaoImpl(ReportDataBerkalaManajemenRepository reportDataBerkalaManajemenRepository){
        super(reportDataBerkalaManajemenRepository);
        this.reportDataBerkalaManajemenRepository = reportDataBerkalaManajemenRepository;
    }


    @Override
    public Map cuspReportManajemen(CuspReportDataBerkalaManajemenFormDto spDto) {
        Map<String, Object> spParam = new HashMap<>();
        spParam.put("PAR_COMP_NAME", spDto.getCompName());
        spParam.put("PAR_USER_NAME", spDto.getUserName());
        spParam.put("PAR_PERIODE_MUTASI", spDto.getPeriodeMutasi());
        spParam.put("PAR_KANTOR_BAYAR", spDto.getKantorBayar());
        spParam.put("PAR_NOMINAL", spDto.getNominal());
        spParam.put("PAR_JENIS_REPORT", spDto.getJenisReport());
        spParam.put("PAR_KRITERIA", spDto.getKriteria());

        List<String> pensiunOutSPParam = new ArrayList<>();
        pensiunOutSPParam.add("PAR_STATUS_EKSEKUSI");
        pensiunOutSPParam.add("PAR_MSG");

        return this.reportDataBerkalaManajemenRepository.callStoredProcedure("ReportDataBerkalaManajemen.cuspReportManajemen", spParam, pensiunOutSPParam);
    }
}
