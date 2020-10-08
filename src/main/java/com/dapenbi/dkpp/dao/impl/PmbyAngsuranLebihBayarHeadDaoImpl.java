package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.PmbyAngsuranLebihBayarHeadDao;
import com.dapenbi.dkpp.dto.PmbyAngsuranLebihBayarHeadDto;
import com.dapenbi.dkpp.model.PmbyAngsuranLebihBayarHead;
import com.dapenbi.dkpp.repository.PmbyAngsuranLebihBayarHeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PmbyAngsuranLebihBayarHeadDaoImpl extends BaseDaoImpl<PmbyAngsuranLebihBayarHead,PmbyAngsuranLebihBayarHeadDto,Long> implements PmbyAngsuranLebihBayarHeadDao {
    private PmbyAngsuranLebihBayarHeadRepository pmbyAngsuranLebihBayarHeadRepository;

    @Autowired
    public PmbyAngsuranLebihBayarHeadDaoImpl(PmbyAngsuranLebihBayarHeadRepository pmbyAngsuranLebihBayarHeadRepository){
        super(pmbyAngsuranLebihBayarHeadRepository);
        this.pmbyAngsuranLebihBayarHeadRepository = pmbyAngsuranLebihBayarHeadRepository;
    }

    @Override
    public Map processPmbyLebihBayar(
            Long role,
            String compName,
            String userName,
            String periodeLebihBayar) {
        Map<String,Object>pmbyAngasuranLebihBayarHeadSPParam = new HashMap<>();
        pmbyAngasuranLebihBayarHeadSPParam.put("PAR_ROLE_ID", role);
        pmbyAngasuranLebihBayarHeadSPParam.put("PAR_COMP_NAME",compName);
        pmbyAngasuranLebihBayarHeadSPParam.put("PAR_USER_NAME",userName);
        pmbyAngasuranLebihBayarHeadSPParam.put("PAR_PERIODE_BAYAR",periodeLebihBayar);

        List<String> pmbyAngasuranLebihBayarHeadOutSPParam = new ArrayList<>();
        pmbyAngasuranLebihBayarHeadOutSPParam.add("PAR_STATUS_EKSEKUSI");
        pmbyAngasuranLebihBayarHeadOutSPParam.add("PAR_MSG");
        return pmbyAngsuranLebihBayarHeadRepository.callStoredProcedure("PmbyAngasuranLebihBayarHead.processPmbyLebihBayar",pmbyAngasuranLebihBayarHeadSPParam,pmbyAngasuranLebihBayarHeadOutSPParam);
    }

}
