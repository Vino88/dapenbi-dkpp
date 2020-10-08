package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.PembayaranMpDao;
import com.dapenbi.dkpp.dto.PembayaranMpDto;
import com.dapenbi.dkpp.form.CuspPembayaranSPDto;
import com.dapenbi.dkpp.form.CuspPembayaranSendToPtrSPDto;
import com.dapenbi.dkpp.model.PembayaranMp;
import com.dapenbi.dkpp.repository.BaseRepository;
import com.dapenbi.dkpp.repository.PembayaranMpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PembayaranMpDaoImpl extends BaseDaoImpl<PembayaranMp, PembayaranMpDto,Long> implements PembayaranMpDao {


    private PembayaranMpRepository pembayaranMpRepository;

    @Autowired
    public PembayaranMpDaoImpl(PembayaranMpRepository pembayaranMpRepository) {
        super(pembayaranMpRepository);
        this.pembayaranMpRepository = pembayaranMpRepository;
    }

    public Map processCuspPembayaran(CuspPembayaranSPDto spDto) {
        Map<String, Object> mutasiPensiunSPParam = new HashMap();
        mutasiPensiunSPParam.put("PAR_PERIODE_PEMBAYARAN", spDto.getParPeriodePembayaran());
        mutasiPensiunSPParam.put("PAR_TGL_DIPROSES", spDto.getParTglDiproses());
        mutasiPensiunSPParam.put("PAR_DIPROSES_OLEH", spDto.getParDiprosesOleh());
        mutasiPensiunSPParam.put("PAR_COMP_NAME", spDto.getParCompName());
        mutasiPensiunSPParam.put("PAR_USER_NAME", spDto.getParUserName());
        List<String> mutasiPensiunOutSPParam = new ArrayList<>();
        mutasiPensiunOutSPParam.add("PAR_ID_PEMBAYARAN");
        mutasiPensiunOutSPParam.add("PAR_STATUS_EKSEKUSI");
        mutasiPensiunOutSPParam.add("PAR_MSG");

        return this.pembayaranMpRepository.callStoredProcedure("PembayaranMp.processCuspPembayaran", mutasiPensiunSPParam, mutasiPensiunOutSPParam);
    }

    @Override
    public Map processCuspPembayaranSentToPtr(CuspPembayaranSendToPtrSPDto spDto) {
        Map<String, Object> mutasiPensiunSPParam = new HashMap();
        mutasiPensiunSPParam.put("PAR_COMP_NAME", spDto.getParCompName());
        mutasiPensiunSPParam.put("PAR_USER_NAME", spDto.getParUserName());
        mutasiPensiunSPParam.put("PAR_PERIODE", spDto.getParPeriode());
        mutasiPensiunSPParam.put("PAR_TGL_DIPROSES", spDto.getParTglDiproses());
        mutasiPensiunSPParam.put("PAR_ID_PEMBAYARAN", spDto.getParIdPembayaran());
        List<String> mutasiPensiunOutSPParam = new ArrayList<>();
        mutasiPensiunOutSPParam.add("PAR_STATUS_EKSEKUSI");
        mutasiPensiunOutSPParam.add("PAR_MSG");

        return this.pembayaranMpRepository.callStoredProcedure("PembayaranMp.processCuspPembayaranSentToPtr", mutasiPensiunSPParam, mutasiPensiunOutSPParam);
    }

}
