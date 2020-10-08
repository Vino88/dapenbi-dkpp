package com.dapenbi.dkpp.dao;

import com.dapenbi.dkpp.dto.ProyeksiPembayaranPensiunBaruDto;
import com.dapenbi.dkpp.form.CuspProyeksiPembayaranPensiunBaruSPDto;
import com.dapenbi.dkpp.model.ProyeksiPembayaranPensiunBaru;

import java.util.Map;

public interface ProyeksiPembayaranPensiunBaruDao extends BaseDao<ProyeksiPembayaranPensiunBaru, ProyeksiPembayaranPensiunBaruDto, Long> {

    Map processCuspProyeksiPensiunBaru(CuspProyeksiPembayaranPensiunBaruSPDto spDto);
}
