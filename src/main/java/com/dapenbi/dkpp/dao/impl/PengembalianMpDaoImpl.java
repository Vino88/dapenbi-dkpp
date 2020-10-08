package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.PengembalianMpDao;
import com.dapenbi.dkpp.dto.PengembalianMpDto;
import com.dapenbi.dkpp.form.CuspMutasiPengembalianMpSPDto;
import com.dapenbi.dkpp.model.PengembalianMp;
import com.dapenbi.dkpp.repository.BaseRepository;
import com.dapenbi.dkpp.repository.PengembalianMpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PengembalianMpDaoImpl extends BaseDaoImpl<PengembalianMp, PengembalianMpDto,Long>implements PengembalianMpDao {

    private PengembalianMpRepository pengembalianMpRepository;

    @Autowired
    public PengembalianMpDaoImpl(PengembalianMpRepository pengembalianMpRepository) {
        super(pengembalianMpRepository);
        this.pengembalianMpRepository = pengembalianMpRepository;
    }

    @Override
    public Map processCuspMutasiPengembalianMp(CuspMutasiPengembalianMpSPDto spDto) {
        Map<String, Object> mutasiPensiunSPParam = new HashMap();
        mutasiPensiunSPParam.put("PAR_ROLE_ID", spDto.getParRoleId());
        mutasiPensiunSPParam.put("PAR_COMP_NAME", spDto.getParCompName());
        mutasiPensiunSPParam.put("PAR_USER_NAME", spDto.getParUserName());
        mutasiPensiunSPParam.put("PAR_ID_PENGEMBALIAN_MP", spDto.getParIdPengembalianMp());
        mutasiPensiunSPParam.put("PAR_PERIODE_MUTASI", spDto.getParPeriodeMutasi());
        mutasiPensiunSPParam.put("PAR_TGL_MUTASI", spDto.getParTglMutasi());
        mutasiPensiunSPParam.put("PAR_NIP", spDto.getParNip());
        mutasiPensiunSPParam.put("PAR_NAMA_PESERTA", spDto.getParNamaPeserta());
        mutasiPensiunSPParam.put("PAR_ID_PENERIMA_MP", spDto.getParIdPenerimaMp());
        mutasiPensiunSPParam.put("PAR_NAMA_PENERIMA_MP", spDto.getParNamaPenerimaMp());
        mutasiPensiunSPParam.put("PAR_KAT_PENGEMBALIAN_MP", spDto.getParKatPengembalianMp());
        mutasiPensiunSPParam.put("PAR_TGL_TRANSFER", spDto.getParTglTransfer());
        mutasiPensiunSPParam.put("PAR_NOMINAL_TRANSFER", spDto.getParNominalTransfer());
        mutasiPensiunSPParam.put("PAR_ID_KATEGORI_CATATAN", spDto.getParIdKategoriCatatan());
        mutasiPensiunSPParam.put("PAR_NAMA_KATEGORI_CATATAN", spDto.getParNamaKategoriCatatan());
        mutasiPensiunSPParam.put("PAR_KETERANGAN", spDto.getParKeterangan());
        mutasiPensiunSPParam.put("PAR_ID_VALIDASI", spDto.getParIdValidasi());
        mutasiPensiunSPParam.put("PAR_NAMA_VALIDASI", spDto.getParNamaValidasi());

        List<String> mutasiPensiunOutSPParam = new ArrayList<>();
        mutasiPensiunOutSPParam.add("PAR_STATUS_EKSEKUSI");
        mutasiPensiunOutSPParam.add("PAR_MSG");
        return this.pengembalianMpRepository.callStoredProcedure("PengembalianMp.processCuspMutasiPengembalianMp", mutasiPensiunSPParam, mutasiPensiunOutSPParam);
    }
}
