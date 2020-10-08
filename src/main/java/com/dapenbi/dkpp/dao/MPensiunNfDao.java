package com.dapenbi.dkpp.dao;


import com.dapenbi.dkpp.dto.MPensiunNfDto;
import com.dapenbi.dkpp.form.CuspMutasiPensiunNfSPDto;
import com.dapenbi.dkpp.form.CuspPembayaranMpNfSPDto;
import com.dapenbi.dkpp.model.MPensiunNf;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface MPensiunNfDao extends BaseDao<MPensiunNf, MPensiunNfDto, String> {
    Map processCuspMutasiPensiunNf(CuspMutasiPensiunNfSPDto spDto);
    Map processCuspPembayaranMpNf(CuspPembayaranMpNfSPDto spDto);
}