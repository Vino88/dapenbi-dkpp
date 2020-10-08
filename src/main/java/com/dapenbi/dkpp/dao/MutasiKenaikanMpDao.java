package com.dapenbi.dkpp.dao;


import com.dapenbi.dkpp.dto.MutasiKenaikanMpDto;
import com.dapenbi.dkpp.form.CuspKenaikanMpValidSPDto;
import com.dapenbi.dkpp.form.CuspMutasiKenaikanMpSPDto;
import com.dapenbi.dkpp.model.MutasiKenaikanMp;

import java.util.Map;

public interface MutasiKenaikanMpDao extends BaseDao<MutasiKenaikanMp, MutasiKenaikanMpDto, Long> {
    Map processCuspMutasiKenaikanMp(CuspMutasiKenaikanMpSPDto spDto);
    Map processCuspMutasiKenaikanMpValid(CuspKenaikanMpValidSPDto spDto);

}