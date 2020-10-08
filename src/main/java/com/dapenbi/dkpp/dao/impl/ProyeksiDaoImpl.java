package com.dapenbi.dkpp.dao.impl;


import com.dapenbi.dkpp.dao.ProyeksiDao;


import com.dapenbi.dkpp.dto.ProyeksiDto;
import com.dapenbi.dkpp.model.Proyeksi;
import com.dapenbi.dkpp.repository.ProyeksiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProyeksiDaoImpl extends BaseDaoImpl<Proyeksi, ProyeksiDto, Long> implements ProyeksiDao {
	private ProyeksiRepository proyeksiRepository;

@Autowired
	public ProyeksiDaoImpl(ProyeksiRepository proyeksiRepository){
		super(proyeksiRepository);
		this.proyeksiRepository = proyeksiRepository;
}


    @Override
    public Map processMasterProyeksi(String parCompName, String parUserName, Long parIdProyeksi, Date parTglInput, Long parJmlThnProyeksi, String parBatasGolIIV, String parBatasGolVII, Long parJmlSimulasi, Long parIdJenisKenaikanMp, Long parPersentaseKenaikanMp1, Long parPersentaseKenaikanMp2, Long parPersentaseKenaikanMp3, Long parMinimalKenaikanMp1, Long parMinimalKenaikanMp2, Long parMinimalKenaikanMp3, Long parPersentaseKenaikanPhdp, Long parPersentaseKenaikanPhdp2, Long parPersentaseKenaikanPhdp3, Character parAction, String parUserStamp) {
        Map<String, Object> SPParamIn = new HashMap();

        SPParamIn.put("PAR_COMP_NAME", parCompName);
        SPParamIn.put("PAR_USER_NAME", parUserName);
        SPParamIn.put("PAR_ID_PROYEKSI", parIdProyeksi);
        SPParamIn.put("PAR_TGL_INPUT", parTglInput);
        SPParamIn.put("PAR_JUMLAH_TAHUN_PROYEKSI", parJmlThnProyeksi);
        SPParamIn.put("PAR_BATAS_GOL_I_VI", parBatasGolIIV);
        SPParamIn.put("PAR_BATAS_GOL_VII_VIII", parBatasGolVII);
        SPParamIn.put("PAR_JUMLAH_SIMULASI", parJmlSimulasi);
        SPParamIn.put("PAR_ID_JENIS_KENAIKAN_MP", parIdJenisKenaikanMp);
        SPParamIn.put("PAR_PERSENTASE_KENAIKAN_MP1", parPersentaseKenaikanMp1);
        SPParamIn.put("PAR_PERSENTASE_KENAIKAN_MP2", parPersentaseKenaikanMp2);
        SPParamIn.put("PAR_PERSENTASE_KENAIKAN_MP3", parPersentaseKenaikanMp3);
        SPParamIn.put("PAR_MINIMAL_KENAIKAN_MP1", parMinimalKenaikanMp1);
        SPParamIn.put("PAR_MINIMAL_KENAIKAN_MP2", parMinimalKenaikanMp2);
        SPParamIn.put("PAR_MINIMAL_KENAIKAN_MP3", parMinimalKenaikanMp3);
        SPParamIn.put("PAR_PERSENTASE_KENAIKAN_PHDP", parPersentaseKenaikanPhdp);
        SPParamIn.put("PAR_PERSENTASE_KENAIKAN_PHDP2", parPersentaseKenaikanPhdp2);
        SPParamIn.put("PAR_PERSENTASE_KENAIKAN_PHDP3", parPersentaseKenaikanPhdp3);
        SPParamIn.put("PAR_ACTION", parAction);
        SPParamIn.put("PAR_USER_STAMP", parUserStamp);

        List<String> SPParamOut = new ArrayList<>();
        SPParamOut.add("PAR_STATUS_EKSEKUSI");
        SPParamOut.add("PAR_MSG");
        return proyeksiRepository.callStoredProcedure("Proyeksi.processMasterProyeksi",SPParamIn, SPParamOut);
    }

    @Override
    public Map processProyeksiPensiunBaru(String parCompName, String parUserName, String parTahunProyeksi, Character parUntukProyeksi, String parUserStamp) {
        Map<String, Object> SPParamIn = new HashMap();

        SPParamIn.put("PAR_COMP_NAME", parCompName);
        SPParamIn.put("PAR_USER_NAME", parUserName);
        SPParamIn.put("PAR_TAHUN_PROYEKSI", parTahunProyeksi);
        SPParamIn.put("PAR_UNTUK_PROYEKSI", parUntukProyeksi);
        SPParamIn.put("PAR_USER_STAMP", parUserStamp);

        List<String> SPParamOut = new ArrayList<>();
        SPParamOut.add("PAR_STATUS_EKSEKUSI");
        SPParamOut.add("PAR_MSG");
        return proyeksiRepository.callStoredProcedure("Proyeksi.processProyeksiPensBaru",SPParamIn, SPParamOut);
    }
}