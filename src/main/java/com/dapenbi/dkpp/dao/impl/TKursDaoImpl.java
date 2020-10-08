package com.dapenbi.dkpp.dao.impl;


import com.dapenbi.dkpp.dao.TKursDao;


import com.dapenbi.dkpp.dto.TKursDto;
import com.dapenbi.dkpp.form.CuspKursSPDto;
import com.dapenbi.dkpp.model.TKurs;
import com.dapenbi.dkpp.repository.TKursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TKursDaoImpl extends BaseDaoImpl<TKurs, TKursDto, String> implements TKursDao {
	private TKursRepository tKursRepository;

	@Autowired
	public TKursDaoImpl(TKursRepository tKursRepository){
			super(tKursRepository);
			this.tKursRepository = tKursRepository;
	}

	@Override
	public Map processCuspKurs(CuspKursSPDto spDto) {
		Map<String, Object> mutasiPensiunSPParam = new HashMap();
		mutasiPensiunSPParam.put("PAR_COMP_NAME", spDto.getParCompName());
		mutasiPensiunSPParam.put("PAR_COMP_NAME", spDto.getParCompName());
		mutasiPensiunSPParam.put("PAR_USER_NAME", spDto.getParUserName());
		mutasiPensiunSPParam.put("PAR_USER_NAME", spDto.getParUserName());
		mutasiPensiunSPParam.put("PAR_PERIODE_MUTASI", spDto.getParPeriodeMutasi());
		mutasiPensiunSPParam.put("PAR_PERIODE_MUTASI", spDto.getParPeriodeMutasi());
		mutasiPensiunSPParam.put("PAR_KURS_EURO", spDto.getParKursEuro());
		mutasiPensiunSPParam.put("PAR_KURS_EURO", spDto.getParKursEuro());
		mutasiPensiunSPParam.put("PAR_KURS_RUPIAH", spDto.getParKursRupiah());
		mutasiPensiunSPParam.put("PAR_KURS_RUPIAH", spDto.getParKursRupiah());
		List<String> mutasiPensiunOutSPParam = new ArrayList<>();
		mutasiPensiunOutSPParam.add("PAR_STATUS_EKSEKUSI");
		mutasiPensiunOutSPParam.add("PAR_MSG");

		return this.tKursRepository.callStoredProcedure("MutasiPensiun.processCuspKurs", mutasiPensiunSPParam, mutasiPensiunOutSPParam);
	}

}