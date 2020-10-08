	package com.dapenbi.dkpp.dao.impl;


import com.dapenbi.dkpp.dao.MutasiPerubahanFprFsDao;


import com.dapenbi.dkpp.dto.MutasiPerubahanFprFsDto;
import com.dapenbi.dkpp.form.CuspMutasiPerubahanFprFsSPDto;
import com.dapenbi.dkpp.form.CuspMutasiPrbhnFrsFsUpdSPDto;
import com.dapenbi.dkpp.model.MutasiPerubahanFprFs;
import com.dapenbi.dkpp.repository.MutasiPerubahanFprFsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

	@Service
public class MutasiPerubahanFprFsDaoImpl extends BaseDaoImpl<MutasiPerubahanFprFs, MutasiPerubahanFprFsDto, Long> implements MutasiPerubahanFprFsDao {
	private MutasiPerubahanFprFsRepository mutasiPerubahanFprFsRepository;

@Autowired
	public MutasiPerubahanFprFsDaoImpl(MutasiPerubahanFprFsRepository mutasiPerubahanFprFsRepository){
		super(mutasiPerubahanFprFsRepository);
		this.mutasiPerubahanFprFsRepository = mutasiPerubahanFprFsRepository;
}


		@Override
		public Map processCuspMutasiPerubahanFprFs(CuspMutasiPerubahanFprFsSPDto spDto) {
			Map<String, Object> mutasiPensiunSPParam = new HashMap();
			mutasiPensiunSPParam.put("PAR_ROLE_ID", spDto.getParRoleId());
			mutasiPensiunSPParam.put("PAR_COMP_NAME", spDto.getParCompName());
			mutasiPensiunSPParam.put("PAR_USER_NAME", spDto.getParUserName());
			mutasiPensiunSPParam.put("PAR_TGL_MUTASI", spDto.getParTglMutasi());
			mutasiPensiunSPParam.put("PAR_PERIODE_MUTASI", spDto.getParPeriodeMutasi());
			List<String> mutasiPensiunOutSPParam = new ArrayList<>();
			mutasiPensiunOutSPParam.add("PAR_STATUS_EKSEKUSI");
			mutasiPensiunOutSPParam.add("PAR_MSG");

			return this.mutasiPerubahanFprFsRepository.callStoredProcedure("MutasiPensiun.processCuspMutasiPerubahanFprFs", mutasiPensiunSPParam, mutasiPensiunOutSPParam);
		}

		@Override
		public Map processCuspMutasiPrbhnFprFsUpd(CuspMutasiPrbhnFrsFsUpdSPDto spDto) {
			Map<String, Object> mutasiPensiunSPParam = new HashMap();
			mutasiPensiunSPParam.put("PAR_ROLE_ID", spDto.getParRoleId());
			mutasiPensiunSPParam.put("PAR_USER_NAME", spDto.getParUserName());
			mutasiPensiunSPParam.put("PAR_COMP_NAME", spDto.getParCompName());
			mutasiPensiunSPParam.put("PAR_ID_MUTASI", spDto.getParIdMutasi());
			mutasiPensiunSPParam.put("PAR_PERIODE_MUTASI", spDto.getParPeriodeMutasi());
			mutasiPensiunSPParam.put("PAR_TGL_MUTASI", spDto.getParTglMutasi());
			mutasiPensiunSPParam.put("PAR_KETERANGAN", spDto.getParKeterangan());
			mutasiPensiunSPParam.put("PAR_ID_KATEGORI_CATATAN", spDto.getParIdKategoriCatatan());
			mutasiPensiunSPParam.put("PAR_NAMA_KATEGORI_CATATAN", spDto.getParNamaKategoriCatatan());
			mutasiPensiunSPParam.put("PAR_ID_VALIDASI", spDto.getParIdValidasi());
			mutasiPensiunSPParam.put("PAR_NAMA_VALIDASI", spDto.getParNamaValidasi());
			List<String> mutasiPensiunOutSPParam = new ArrayList<>();
			mutasiPensiunOutSPParam.add("PAR_STATUS_EKSEKUSI");
			mutasiPensiunOutSPParam.add("PAR_MSG");

			return this.mutasiPerubahanFprFsRepository.callStoredProcedure("MutasiPensiun.processCuspMutasiPrbhnFprFsUpd", mutasiPensiunSPParam, mutasiPensiunOutSPParam);
		}
	}