package com.dapenbi.dkpp.dao;

import com.dapenbi.dkpp.dto.PmbyAngsuranLebihBayarHeadDto;
import com.dapenbi.dkpp.model.PmbyAngsuranLebihBayarHead;
import org.springframework.stereotype.Service;

import java.util.Map;

public interface PmbyAngsuranLebihBayarHeadDao extends BaseDao<PmbyAngsuranLebihBayarHead, PmbyAngsuranLebihBayarHeadDto,Long> {

    Map processPmbyLebihBayar(
            Long role,
            String compName,
            String userName,
            String periodeLebihBayar
    );
}
