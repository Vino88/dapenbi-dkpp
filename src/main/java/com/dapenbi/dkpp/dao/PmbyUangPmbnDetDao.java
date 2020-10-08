package com.dapenbi.dkpp.dao;


import com.dapenbi.dkpp.dto.PmbyUangPmbnDetDto;
import com.dapenbi.dkpp.form.CuspPmbyUangPembinaanDetSpDto;
import com.dapenbi.dkpp.form.CuspPmbyUangPmbnPtrSPDto;
import com.dapenbi.dkpp.model.PmbyUangPmbnDet;
import com.dapenbi.dkpp.model.PmbyUangPmbnH;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface PmbyUangPmbnDetDao extends BaseDao<PmbyUangPmbnDet, PmbyUangPmbnDetDto, Long> {
//    Iterable<PmbyUangPmbnDet> findByIdUangPembinaanH(PmbyUangPmbnH pmbyUangPmbnH);

    Page<PmbyUangPmbnDet> findAllByIdUangPembinaanH(Long idUangPembinaanH,String searchParam, Pageable pageable);

    Map processCuspPmbyUangPembinaanD(CuspPmbyUangPembinaanDetSpDto spDto);

    Map processCuspPmbyUangPmbnPtr(CuspPmbyUangPmbnPtrSPDto spDto);


}