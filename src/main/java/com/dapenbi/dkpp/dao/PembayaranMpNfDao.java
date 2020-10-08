package com.dapenbi.dkpp.dao;


import com.dapenbi.dkpp.dto.PembayaranMpNfDto;
import com.dapenbi.dkpp.form.CuspPembayaranMpNfPtrSPDto;
import com.dapenbi.dkpp.model.PembayaranMpNf;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface PembayaranMpNfDao extends BaseDao<PembayaranMpNf, PembayaranMpNfDto, String> {
    Map processCuspPembayaranMpNfPtr(CuspPembayaranMpNfPtrSPDto spDto);
}