package com.dapenbi.dkpp.dao;

import com.dapenbi.dkpp.dto.PmbyPiutangDto;
import com.dapenbi.dkpp.form.CuspProsesPiutangBulananSPFormDto;
import com.dapenbi.dkpp.form.CuspUpdatePiutangBulananSPDto;
import com.dapenbi.dkpp.model.PmbyPiutang;

import java.util.Map;

public interface PmbyPiutangDao extends BaseDao<PmbyPiutang, PmbyPiutangDto, Long> {

    Map processCuspProsesPiutangBulanan(CuspProsesPiutangBulananSPFormDto cuspProsesPiutangBulananSPFormDto);
    Map cuspUpdatePiutangBulananSPDto(CuspUpdatePiutangBulananSPDto cuspUpdatePiutangBulananSPDto);


}
