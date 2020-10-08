package com.dapenbi.dkpp.dao.impl;


import com.dapenbi.dkpp.dao.MutasiKenaikanMpDao;


import com.dapenbi.dkpp.dto.MutasiKenaikanMpDto;
import com.dapenbi.dkpp.form.CuspKenaikanMpValidSPDto;
import com.dapenbi.dkpp.form.CuspMutasiKenaikanMpSPDto;
import com.dapenbi.dkpp.model.MutasiKenaikanMp;
import com.dapenbi.dkpp.repository.MutasiKenaikanMpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MutasiKenaikanMpDaoImpl extends BaseDaoImpl<MutasiKenaikanMp, MutasiKenaikanMpDto, Long> implements MutasiKenaikanMpDao {
	private MutasiKenaikanMpRepository mutasiKenaikanMpRepository;

@Autowired
	public MutasiKenaikanMpDaoImpl(MutasiKenaikanMpRepository mutasiKenaikanMpRepository){
		super(mutasiKenaikanMpRepository);
		this.mutasiKenaikanMpRepository = mutasiKenaikanMpRepository;
}


	@Override
	public Map processCuspMutasiKenaikanMp(CuspMutasiKenaikanMpSPDto spDto) {
		Map<String, Object> mutasiPensiunSPParam = new HashMap();
		mutasiPensiunSPParam.put("PAR_ROLE_ID", spDto.getParRoleId());

		mutasiPensiunSPParam.put("PAR_COMP_NAME", spDto.getParCompName());

		mutasiPensiunSPParam.put("PAR_USER_NAME", spDto.getParUserName());

		mutasiPensiunSPParam.put("PAR_PERIODE_MUTASI", spDto.getParPeriodeMutasi());

		mutasiPensiunSPParam.put("PAR_TGL_MUTASI", spDto.getParTglMutasi());


		List<String> mutasiPensiunOutSPParam = new ArrayList<>();
		mutasiPensiunOutSPParam.add("PAR_STATUS_EKSEKUSI");
		mutasiPensiunOutSPParam.add("PAR_MSG");

		return this.mutasiKenaikanMpRepository.callStoredProcedure("MutasiPensiun.processCuspMutasiKenaikanMp", mutasiPensiunSPParam, mutasiPensiunOutSPParam);
	}

	@Override
	public Map processCuspMutasiKenaikanMpValid(CuspKenaikanMpValidSPDto spDto) {
		Map<String, Object> mutasiPensiunSPParam = new HashMap();
		mutasiPensiunSPParam.put("PAR_COMP_NAME", spDto.getParCompName());
		mutasiPensiunSPParam.put("PAR_USER_NAME", spDto.getParUserName());
		mutasiPensiunSPParam.put("PAR_ID_MUTASI", spDto.getParIdMutasi());
		mutasiPensiunSPParam.put("PAR_ID_KATEGORI_CATATAN", spDto.getParIdKategoriCatatan());
		mutasiPensiunSPParam.put("PAR_NAMA_KATEGORI_CATATAN", spDto.getParNamaKategoriCatatan());
		mutasiPensiunSPParam.put("PAR_KETERANGAN", spDto.getParKeterangan());
		mutasiPensiunSPParam.put("PAR_ID_VALIDASI", spDto.getParIdValidasi());
		mutasiPensiunSPParam.put("PAR_NAMA_VALIDASI", spDto.getParNamaValidasi());

		List<String> mutasiPensiunOutSPParam = new ArrayList<>();
		mutasiPensiunOutSPParam.add("PAR_STATUS_EKSEKUSI");
		mutasiPensiunOutSPParam.add("PAR_MSG");

		return this.mutasiKenaikanMpRepository.callStoredProcedure("MutasiPensiun.processCuspMutasiKenaikanMpValid", mutasiPensiunSPParam, mutasiPensiunOutSPParam);
	}
}