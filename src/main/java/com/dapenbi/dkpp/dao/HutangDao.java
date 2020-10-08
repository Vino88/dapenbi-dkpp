package com.dapenbi.dkpp.dao;


import com.dapenbi.dkpp.dto.HutangDto;
import com.dapenbi.dkpp.form.CuspPembayaranHutangPtrSPDto;
import com.dapenbi.dkpp.form.CuspPembayaranHutangSPDto;
import com.dapenbi.dkpp.model.Hutang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface HutangDao extends BaseDao<Hutang, HutangDto, Long> {
    Page<Hutang> findAllByType(String[] type, Pageable pageable);
    Map processCuspPembayaranHutang(CuspPembayaranHutangSPDto spDto);
    Map processCuspPembayaranHutangPtr(CuspPembayaranHutangPtrSPDto spDto);
    Page<Hutang> findAllByType(String[] type, String searchParam, Pageable pageable);
}