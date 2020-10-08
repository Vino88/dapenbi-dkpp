package com.dapenbi.dkpp.dao;


import com.dapenbi.dkpp.dto.ProyeksiPembayaranPensiunLamaDto;
import com.dapenbi.dkpp.form.CuspProyeksiPembayaranPensiunLama;
import com.dapenbi.dkpp.model.ProyeksiPembayaranPensiunLama;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface ProyeksiPembayaranPensiunLamaDao extends BaseDao<ProyeksiPembayaranPensiunLama, ProyeksiPembayaranPensiunLamaDto, Long> {
    Map processCuspProyeksiPensiunLama(CuspProyeksiPembayaranPensiunLama spDto);

    Page<ProyeksiPembayaranPensiunLama>findAllTanpaParam(String searchParam, Pageable pageable);
}