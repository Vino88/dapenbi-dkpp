package com.dapenbi.dkpp.dao;

import com.dapenbi.dkpp.dto.PembayaranMpDto;
import com.dapenbi.dkpp.form.CuspPembayaranSPDto;
import com.dapenbi.dkpp.form.CuspPembayaranSendToPtrSPDto;
import com.dapenbi.dkpp.model.PembayaranMp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface PembayaranMpDao extends BaseDao<PembayaranMp, PembayaranMpDto, Long> {
    Map processCuspPembayaran(CuspPembayaranSPDto spDto);

    Map processCuspPembayaranSentToPtr(CuspPembayaranSendToPtrSPDto spDto);
}
