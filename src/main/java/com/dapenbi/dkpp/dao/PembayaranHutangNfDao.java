package com.dapenbi.dkpp.dao;

import com.dapenbi.dkpp.dto.PembayaranHutangNfDto;
import com.dapenbi.dkpp.form.CuspPembayaranHutangNf;
import com.dapenbi.dkpp.form.CuspPembayaranHutangNfPtr;
import com.dapenbi.dkpp.model.PembayaranHutangNf;

import java.util.Map;

public interface PembayaranHutangNfDao extends BaseDao<PembayaranHutangNf, PembayaranHutangNfDto, Long> {

    Map CuspPembayaranHutangNf(CuspPembayaranHutangNf spDto);

    Map CuspPembayaranHutangNfPtr(CuspPembayaranHutangNfPtr spDtoPtr);
}
