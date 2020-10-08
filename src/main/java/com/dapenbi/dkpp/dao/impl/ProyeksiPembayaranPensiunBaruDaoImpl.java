package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.ProyeksiPembayaranPensiunBaruDao;
import com.dapenbi.dkpp.dto.ProyeksiPembayaranPensiunBaruDto;
import com.dapenbi.dkpp.form.CuspProyeksiPembayaranPensiunBaruSPDto;
import com.dapenbi.dkpp.model.ProyeksiPembayaranPensiunBaru;
import com.dapenbi.dkpp.repository.BaseRepository;
import com.dapenbi.dkpp.repository.ProyeksiPembayaranPensiunBaruRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProyeksiPembayaranPensiunBaruDaoImpl extends BaseDaoImpl<ProyeksiPembayaranPensiunBaru, ProyeksiPembayaranPensiunBaruDto, Long> implements ProyeksiPembayaranPensiunBaruDao {

    private ProyeksiPembayaranPensiunBaruRepository proyeksiPembayaranPensiunBaruRepository;

    @Autowired
    public ProyeksiPembayaranPensiunBaruDaoImpl(ProyeksiPembayaranPensiunBaruRepository proyeksiPembayaranPensiunBaruRepository) {
        super(proyeksiPembayaranPensiunBaruRepository);
        this.proyeksiPembayaranPensiunBaruRepository = proyeksiPembayaranPensiunBaruRepository;
    }

    @Override
    public Map processCuspProyeksiPensiunBaru(CuspProyeksiPembayaranPensiunBaruSPDto spDto) {
        Map<String, Object> mutasiPensiunSPParam = new HashMap();
        mutasiPensiunSPParam.put("PAR_COMP_NAME", spDto.getParCompName());
        mutasiPensiunSPParam.put("PAR_USER_NAME", spDto.getParUserName());
        mutasiPensiunSPParam.put("PAR_TAHUN_PROYEKSI", spDto.getParTahunProyeksi());
        mutasiPensiunSPParam.put("PAR_UNTUK_PROYEKSI", spDto.getParUntukProyeksi());
        mutasiPensiunSPParam.put("PAR_USER_STAMP", spDto.getParUserStamp());
        List<String> mutasiPensiunOutSPParam = new ArrayList<>();
        mutasiPensiunOutSPParam.add("PAR_STATUS_EKSEKUSI");
        mutasiPensiunOutSPParam.add("PAR_MSG");

        return this.proyeksiPembayaranPensiunBaruRepository.callStoredProcedure("MutasiPensiun.processCuspProyeksiPensiunBaru", mutasiPensiunSPParam, mutasiPensiunOutSPParam);
    }
}
