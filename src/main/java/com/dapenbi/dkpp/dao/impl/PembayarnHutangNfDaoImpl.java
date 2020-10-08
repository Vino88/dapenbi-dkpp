package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.PembayaranHutangNfDao;
import com.dapenbi.dkpp.dto.PembayaranHutangNfDto;
import com.dapenbi.dkpp.form.CuspPembayaranHutangNf;
import com.dapenbi.dkpp.form.CuspPembayaranHutangNfPtr;
import com.dapenbi.dkpp.model.PembayaranHutangNf;
import com.dapenbi.dkpp.repository.PembayaranHutangNfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PembayarnHutangNfDaoImpl extends BaseDaoImpl<PembayaranHutangNf, PembayaranHutangNfDto, Long> implements PembayaranHutangNfDao {

    PembayaranHutangNfRepository pembayaranHutangNfRepository;

    @Autowired
    public PembayarnHutangNfDaoImpl(PembayaranHutangNfRepository pembayaranHutangNfRepository){
        super(pembayaranHutangNfRepository);
        this.pembayaranHutangNfRepository = pembayaranHutangNfRepository;
    }


    @Override
    public Map CuspPembayaranHutangNf(CuspPembayaranHutangNf spDto) {
        Map<String, Object> SPParam = new HashMap();
        SPParam.put("PAR_COMP_NAME", spDto.getParCompName());
        SPParam.put("PAR_USER_NAME", spDto.getParUserName());
        SPParam.put("PAR_PERIODE_BAYAR", spDto.getParPeriodeBayar());
        SPParam.put("PAR_ROLE_ID", spDto.getParRoleId());
        SPParam.put("PAR_ID_BAYAR_NF", spDto.getParIdBayarNf());
        SPParam.put("PAR_NIP", spDto.getParNip());
        SPParam.put("PAR_NAMA_PESERTA", spDto.getParNamaPeserta());
        SPParam.put("PAR_NAMA_PENERIMA_MP", spDto.getParNamaPenerimaMp());
        SPParam.put("PAR_NOMINAL_PEMBAYARAN", spDto.getParNominalPembayaran());
        SPParam.put("PAR_KETERANGAN", spDto.getParKeterangan());
        SPParam.put("PAR_ID_PENERIMA_MP", spDto.getParIdPenerimaMp());

        List<String> mutasiPensiunOutSPParam = new ArrayList<>();
        mutasiPensiunOutSPParam.add("PAR_STATUS_EKSEKUSI");
        mutasiPensiunOutSPParam.add("PAR_MSG");
        return this.pembayaranHutangNfRepository.callStoredProcedure("PembayaranHutangNf.cuspPembayaranHutangNf", SPParam, mutasiPensiunOutSPParam);
    }

    @Override
    public Map CuspPembayaranHutangNfPtr(CuspPembayaranHutangNfPtr spDtoPtr) {
        Map<String, Object> SPParam = new HashMap();
        SPParam.put("PAR_COMP_NAME", spDtoPtr.getParCompName());
        SPParam.put("PAR_USER_NAME", spDtoPtr.getParUserName());
        SPParam.put("PAR_ID_BAYAR_HUTANG_NF", spDtoPtr.getParIdBayarHutangNf());
        SPParam.put("PAR_MUTASI_BAYAR", spDtoPtr.getParMutasiBayar());
        SPParam.put("PAR_NOMINAL", spDtoPtr.getParNominal());
        List<String> mutasiPensiunOutSPParam = new ArrayList<>();
        mutasiPensiunOutSPParam.add("PAR_STATUS_EKSEKUSI");
        mutasiPensiunOutSPParam.add("PAR_MSG");
        
        return this.pembayaranHutangNfRepository.callStoredProcedure("PembayaranHutangNf.cuspPembayaranHutangNfPtr", SPParam, mutasiPensiunOutSPParam);
    }
}
