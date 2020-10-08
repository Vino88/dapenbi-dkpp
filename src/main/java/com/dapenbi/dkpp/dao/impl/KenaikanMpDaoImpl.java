package com.dapenbi.dkpp.dao.impl;


import com.dapenbi.dkpp.dao.KenaikanMpDao;


import com.dapenbi.dkpp.dto.KenaikanMpDto;
import com.dapenbi.dkpp.form.CuspKenaikanMpSPDto;
import com.dapenbi.dkpp.model.KenaikanMp;
import com.dapenbi.dkpp.repository.KenaikanMpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class KenaikanMpDaoImpl extends BaseDaoImpl<KenaikanMp, KenaikanMpDto, Long> implements KenaikanMpDao {
	private KenaikanMpRepository kenaikanMpRepository;

@Autowired
	public KenaikanMpDaoImpl(KenaikanMpRepository kenaikanMpRepository){
		super(kenaikanMpRepository);
		this.kenaikanMpRepository = kenaikanMpRepository;
}


	@Override
	public Map processCuspKenaikanMp(CuspKenaikanMpSPDto spDto) {
		Map<String, Object> mutasiPensiunSPParam = new HashMap();
		mutasiPensiunSPParam.put("PAR_COMP_NAME", spDto.getParCompName());
		mutasiPensiunSPParam.put("PAR_USER_NAME", spDto.getParUserName());
		mutasiPensiunSPParam.put("PAR_ID_KENAIKAN_MP", spDto.getParIdKenaikanMp());
		mutasiPensiunSPParam.put("PAR_TGL_INPUT", spDto.getParTglInput());
		mutasiPensiunSPParam.put("PAR_ID_JENIS_KENAIKAN_MP", spDto.getParIdJenisKenaikanMp());
		mutasiPensiunSPParam.put("PAR_NAMA_JENIS_KENAIKAN_MP", spDto.getParNamaJenisKenaikanMp());
		mutasiPensiunSPParam.put("PAR_OPERATOR", spDto.getParOperator());
		mutasiPensiunSPParam.put("PAR_TGL_AWAL_BAYAR", spDto.getParTglAwalBayar());
		mutasiPensiunSPParam.put("PAR_PERSENTASE", spDto.getParPersentase());
		mutasiPensiunSPParam.put("PAR_MIN_NOMINAL", spDto.getParMinNominal());
		mutasiPensiunSPParam.put("PAR_PERIODE_MUTASI_DIPROSES", spDto.getParPeriodeMutasiDiproses());

		List<String> mutasiPensiunOutSPParam = new ArrayList<>();
		mutasiPensiunOutSPParam.add("PAR_STATUS_EKSEKUSI");
		mutasiPensiunOutSPParam.add("PAR_MSG");

		return this.kenaikanMpRepository.callStoredProcedure("KenaikanMp.processCuspKenaikanMp", mutasiPensiunSPParam, mutasiPensiunOutSPParam);
	}
}