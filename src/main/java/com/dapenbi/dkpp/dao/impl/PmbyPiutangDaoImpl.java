package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.PmbyPiutangDao;
import com.dapenbi.dkpp.dto.PmbyPiutangDto;
import com.dapenbi.dkpp.form.CuspProsesPiutangBulananSPFormDto;
import com.dapenbi.dkpp.form.CuspUpdatePiutangBulananSPDto;
import com.dapenbi.dkpp.model.PmbyPiutang;
import com.dapenbi.dkpp.repository.BaseRepository;
import com.dapenbi.dkpp.repository.PmbyPiutangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PmbyPiutangDaoImpl extends BaseDaoImpl<PmbyPiutang,PmbyPiutangDto,Long> implements PmbyPiutangDao {
    private PmbyPiutangRepository pmbyPiutangRepository;

    @Autowired
    public PmbyPiutangDaoImpl(PmbyPiutangRepository pmbyPiutangRepository) {
        super(pmbyPiutangRepository);
        this.pmbyPiutangRepository = pmbyPiutangRepository;
    }

    @Override
    public Map processCuspProsesPiutangBulanan(CuspProsesPiutangBulananSPFormDto spDto) {
        Map<String, Object> mutasiPensiunSPParam = new HashMap();
        mutasiPensiunSPParam.put("PAR_COMP_NAME", spDto.getParCompName());
        mutasiPensiunSPParam.put("PAR_USER_NAME", spDto.getParUserName());
        mutasiPensiunSPParam.put("PAR_PERIODE_MUTASI", spDto.getParPeriodeMutasi());
        mutasiPensiunSPParam.put("PAR_TGL_PROSES", spDto.getParTglProses());
        List<String> mutasiPensiunOutSPParam = new ArrayList<>();
        mutasiPensiunOutSPParam.add("PAR_STATUS_EKSEKUSI");
        mutasiPensiunOutSPParam.add("PAR_MSG");

        return this.pmbyPiutangRepository.callStoredProcedure("PmbyPiutang.processCuspProsesPiutangBulanan", mutasiPensiunSPParam, mutasiPensiunOutSPParam);
    }

    @Override
    public Map cuspUpdatePiutangBulananSPDto(CuspUpdatePiutangBulananSPDto spDto) {
        Map<String, Object> mutasiPensiunSPParam = new HashMap();
        mutasiPensiunSPParam.put("PAR_ROLE_ID", spDto.getParRoleId());
        mutasiPensiunSPParam.put("PAR_COMP_NAME", spDto.getParCompName());
        mutasiPensiunSPParam.put("PAR_USER_NAME", spDto.getParUserName());
        mutasiPensiunSPParam.put("PAR_ID_BAYAR_PIUTANG", spDto.getParIdBayarPiutang());
        mutasiPensiunSPParam.put("PAR_KETERANGAN", spDto.getParKeterangan());
        mutasiPensiunSPParam.put("PAR_ID_VALIDASI", spDto.getParIdValidasi());
        mutasiPensiunSPParam.put("PAR_NAMA_VALIDASI", spDto.getParNamaValidasi());

        List<String> mutasiPensiunOutSPParam = new ArrayList<>();
        mutasiPensiunOutSPParam.add("PAR_STATUS_EKSEKUSI");
        mutasiPensiunOutSPParam.add("PAR_MSG");

        return this.pmbyPiutangRepository.callStoredProcedure("PmbyPiutang.processCuspUpdatePiutangBulanan", mutasiPensiunSPParam, mutasiPensiunOutSPParam);
    }
}
