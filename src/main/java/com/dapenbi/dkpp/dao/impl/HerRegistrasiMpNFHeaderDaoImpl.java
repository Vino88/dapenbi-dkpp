package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.HerRegistrasiMpNFHeaderDao;
import com.dapenbi.dkpp.dao.impl.BaseDaoImpl;
import com.dapenbi.dkpp.dto.HerRegistrasiMpNFHeaderDto;
import com.dapenbi.dkpp.form.CuspHerRegistrasiNFProses;
import com.dapenbi.dkpp.form.CuspHerRegistrasiNFUpdate;
import com.dapenbi.dkpp.form.CuspPembayaranHutangPtrSPDto;
import com.dapenbi.dkpp.form.CuspPembayaranHutangSPDto;
import com.dapenbi.dkpp.model.HerRegistrasiMpNFHeader;
import com.dapenbi.dkpp.repository.HerRegistrasiMpNFHeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HerRegistrasiMpNFHeaderDaoImpl extends BaseDaoImpl<HerRegistrasiMpNFHeader, HerRegistrasiMpNFHeaderDto, String> implements HerRegistrasiMpNFHeaderDao {

    private HerRegistrasiMpNFHeaderRepository herRegistrasiMpNFHeaderRepository;

    @Autowired
    public HerRegistrasiMpNFHeaderDaoImpl(HerRegistrasiMpNFHeaderRepository herRegistrasiMpNFHeaderRepository){
        super(herRegistrasiMpNFHeaderRepository);
        this.herRegistrasiMpNFHeaderRepository = herRegistrasiMpNFHeaderRepository;
    }

    @Override
    public Map CuspHerRegistrasiNFProses(CuspHerRegistrasiNFProses spDtoProses) {

        Map<String, Object> SPParam = new HashMap();
        SPParam.put("PAR_COMP_NAME", spDtoProses.getParCompName());
        SPParam.put("PAR_USER_NAME", spDtoProses.getParUserName());
        SPParam.put("PAR_TAHUN_HER", spDtoProses.getParTahunHer());
        SPParam.put("PAR_STATUS_HER", spDtoProses.getParStatusHer());
        SPParam.put("PAR_ACTION", spDtoProses.getParAction());
        List<String> mutasiPensiunOutSPParam = new ArrayList<>();
        mutasiPensiunOutSPParam.add("PAR_STATUS_EKSEKUSI");
        mutasiPensiunOutSPParam.add("PAR_MSG");
        return this.herRegistrasiMpNFHeaderRepository.callStoredProcedure("HerRegistrasiMpNFHeader.CuspHerRegistrasiNFProses", SPParam, mutasiPensiunOutSPParam);
    }

    @Override
    public Map CuspHerRegistrasiNFUpdate(CuspHerRegistrasiNFUpdate spDtoUpdate) {
        Map<String, Object> paramUpdate = new HashMap();
        paramUpdate.put("PAR_COMP_NAME", spDtoUpdate.getParCompName());
        paramUpdate.put("PAR_USER_NAME", spDtoUpdate.getParUserName());
        paramUpdate.put("PAR_NIP", spDtoUpdate.getParNip());
        paramUpdate.put("PAR_TGL_HER_REGIS", spDtoUpdate.getParTglHer());
        paramUpdate.put("PAR_IS_SUDAH_HER", spDtoUpdate.getParIsSudahHer());
        paramUpdate.put("PAR_SUDAH_HER_DESC", spDtoUpdate.getParSudahHer());
        List<String> mutasiPensiunOutSPParam = new ArrayList<>();
        mutasiPensiunOutSPParam.add("PAR_STATUS_EKSEKUSI");
        mutasiPensiunOutSPParam.add("PAR_MSG");

        return this.herRegistrasiMpNFHeaderRepository.callStoredProcedure("HerRegistrasiMpNFHeader.CuspHerRegistrasiNFUpdate", paramUpdate, mutasiPensiunOutSPParam);
    }

    @Override
    public HerRegistrasiMpNFHeader findFirstByTahunHer(String tahun){
        return this.herRegistrasiMpNFHeaderRepository.findFirstByTahunHer(tahun);
    }
}
