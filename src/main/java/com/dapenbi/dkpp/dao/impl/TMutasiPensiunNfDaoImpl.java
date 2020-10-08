package com.dapenbi.dkpp.dao.impl;


import com.dapenbi.dkpp.dao.TMutasiPensiunNfDao;


import com.dapenbi.dkpp.dto.TMutasiPensiunNfDto;
import com.dapenbi.dkpp.form.CuspMutasiHapusPensiunNfSPDto;
import com.dapenbi.dkpp.model.TMutasiPensiunNf;
import com.dapenbi.dkpp.repository.TMutasiPensiunNfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TMutasiPensiunNfDaoImpl extends BaseDaoImpl<TMutasiPensiunNf, TMutasiPensiunNfDto, String> implements TMutasiPensiunNfDao {
	private TMutasiPensiunNfRepository tMutasiPensiunNfRepository;

	@Autowired
	public TMutasiPensiunNfDaoImpl(TMutasiPensiunNfRepository tMutasiPensiunNfRepository){
			super(tMutasiPensiunNfRepository);
			this.tMutasiPensiunNfRepository = tMutasiPensiunNfRepository;
	}

	@Override
	public Map processCuspMutasiHapusPensiunNf(CuspMutasiHapusPensiunNfSPDto spDto) {
		Map<String, Object> mutasiPensiunSPParam = new HashMap();
		mutasiPensiunSPParam.put("PAR_ROLE_ID", spDto.getParRoleId());
		mutasiPensiunSPParam.put("PAR_COMP_NAME", spDto.getParCompName());
		mutasiPensiunSPParam.put("PAR_USER_NAME", spDto.getParUserName());
		mutasiPensiunSPParam.put("PAR_PERIODE_MUTASI", spDto.getParPeriodeMutasi());
		mutasiPensiunSPParam.put("PAR_TGL_MUTASI", spDto.getParTglMutasi());
		mutasiPensiunSPParam.put("PAR_ID_MUTASI", spDto.getParIdMutasi());
		mutasiPensiunSPParam.put("PAR_NIP", spDto.getParNip());
		mutasiPensiunSPParam.put("PAR_NAMA_PESERTA", spDto.getParNamaPeserta());
		mutasiPensiunSPParam.put("PAR_ID_PENERIMA_MP", spDto.getParIdPenerimaMp());
		mutasiPensiunSPParam.put("PAR_NAMA_PENERIMA_MP", spDto.getParNamaPenerimaMp());
		mutasiPensiunSPParam.put("PAR_TGL_MENINGGAL", spDto.getParTglMeninggal());
		mutasiPensiunSPParam.put("PAR_KETERANGAN", spDto.getParKeterangan());
		mutasiPensiunSPParam.put("PAR_ID_VALIDASI", spDto.getParIdValidasi());
		mutasiPensiunSPParam.put("PAR_ID_STATUS_BAYAR", spDto.getParIdStatusBayar());
		mutasiPensiunSPParam.put("PAR_NAMA_VALIDASI", spDto.getParNamaValidasi());
		List<String> mutasiPensiunOutSPParam = new ArrayList<>();
		mutasiPensiunOutSPParam.add("PAR_STATUS_EKSEKUSI");
		mutasiPensiunOutSPParam.add("PAR_MSG");

		return this.tMutasiPensiunNfRepository.callStoredProcedure("MutasiPensiun.processCuspMutasiHapusPensiunNf", mutasiPensiunSPParam, mutasiPensiunOutSPParam);
	}
}