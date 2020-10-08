package com.dapenbi.dkpp.dao;


import com.dapenbi.dkpp.dto.PmbyUangPmbnHDto;
import com.dapenbi.dkpp.form.CuspPmbyUangPembinaanHeadSPDto;
import com.dapenbi.dkpp.model.PmbyUangPmbnH;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface PmbyUangPmbnHDao extends BaseDao<PmbyUangPmbnH, PmbyUangPmbnHDto, Long> {
    Map processCuspPmbyUangPembinaan(CuspPmbyUangPembinaanHeadSPDto cuspPmbyUangPembinaanHeadSPDto);
}