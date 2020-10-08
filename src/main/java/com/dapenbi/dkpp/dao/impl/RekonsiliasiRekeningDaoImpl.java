package com.dapenbi.dkpp.dao.impl;


import com.dapenbi.dkpp.dao.RekonsiliasiRekeningDao;


import com.dapenbi.dkpp.dto.RekonsiliasiRekeningDto;
import com.dapenbi.dkpp.form.CuspProsesRekonRekeningSPDto;
import com.dapenbi.dkpp.form.CuspValidasiRekonRekeningSPDto;
import com.dapenbi.dkpp.model.RekonsiliasiRekening;
import com.dapenbi.dkpp.repository.RekonsiliasiRekeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RekonsiliasiRekeningDaoImpl extends BaseDaoImpl<RekonsiliasiRekening, RekonsiliasiRekeningDto, String> implements RekonsiliasiRekeningDao {
	private RekonsiliasiRekeningRepository rekonsiliasiRekeningRepository;

	@Autowired
		public RekonsiliasiRekeningDaoImpl(RekonsiliasiRekeningRepository rekonsiliasiRekeningRepository){
			super(rekonsiliasiRekeningRepository);
			this.rekonsiliasiRekeningRepository = rekonsiliasiRekeningRepository;
	}

	@Override
	public Map processCuspProsesRekonRekening(CuspProsesRekonRekeningSPDto spDto) {
		Map<String, Object> mutasiPensiunSPParam = new HashMap();
		mutasiPensiunSPParam.put("PAR_ROLE_ID", spDto.getParRoleId());
		mutasiPensiunSPParam.put("PAR_COMP_NAME", spDto.getParCompName());
		mutasiPensiunSPParam.put("PAR_USER_NAME", spDto.getParUserName());
		mutasiPensiunSPParam.put("PAR_PERIODE", spDto.getParPeriode());
		List<String> mutasiPensiunOutSPParam = new ArrayList<>();
		mutasiPensiunOutSPParam.add("PAR_STATUS_EKSEKUSI");
		mutasiPensiunOutSPParam.add("PAR_MSG");

		return this.rekonsiliasiRekeningRepository.callStoredProcedure("MutasiPensiun.processCuspProsesRekonRekening", mutasiPensiunSPParam, mutasiPensiunOutSPParam);
	}

	@Override
	public Map processCuspValidasiRekonRekening(CuspValidasiRekonRekeningSPDto spDto) {
		Map<String, Object> mutasiPensiunSPParam = new HashMap();
		mutasiPensiunSPParam.put("PAR_ROLE_ID", spDto.getParRoleId());
		mutasiPensiunSPParam.put("PAR_COMP_NAME", spDto.getParCompName());
		mutasiPensiunSPParam.put("PAR_USER_NAME", spDto.getParUserName());
		mutasiPensiunSPParam.put("PAR_PERIODE", spDto.getParPeriode());
		mutasiPensiunSPParam.put("PAR_NIP", spDto.getParNip());
		mutasiPensiunSPParam.put("PAR_ID_VALIDASI", spDto.getParIdValidasi());
		mutasiPensiunSPParam.put("PAR_NAMA_VALIDASI", spDto.getParNamaValidasi());
		List<String> mutasiPensiunOutSPParam = new ArrayList<>();
		mutasiPensiunOutSPParam.add("PAR_STATUS_EKSEKUSI");
		mutasiPensiunOutSPParam.add("PAR_MSG");

		return this.rekonsiliasiRekeningRepository.callStoredProcedure("MutasiPensiun.processCuspValidasiRekonRekening", mutasiPensiunSPParam, mutasiPensiunOutSPParam);
	}

	@Override
	public Long getCount() {
		return rekonsiliasiRekeningRepository.count();
	}

}