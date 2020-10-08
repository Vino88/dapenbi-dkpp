package com.dapenbi.dkpp.dao;

import com.dapenbi.dkpp.dto.PengembalianMpDto;
import com.dapenbi.dkpp.form.CuspMutasiPengembalianMpSPDto;
import com.dapenbi.dkpp.model.PengembalianMp;

import java.util.Map;

public interface PengembalianMpDao extends BaseDao<PengembalianMp, PengembalianMpDto,Long>{

    Map processCuspMutasiPengembalianMp(CuspMutasiPengembalianMpSPDto spDto);
}
