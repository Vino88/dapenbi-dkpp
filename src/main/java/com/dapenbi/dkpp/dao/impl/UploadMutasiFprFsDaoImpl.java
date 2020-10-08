package com.dapenbi.dkpp.dao.impl;


import com.dapenbi.dkpp.dao.UploadMutasiFprFsDao;


import com.dapenbi.dkpp.dto.UploadMutasiFprFsDto;
import com.dapenbi.dkpp.form.CuspInsertFaktorFprFsSPDto;
import com.dapenbi.dkpp.model.UploadMutasiFprFs;
import com.dapenbi.dkpp.repository.UploadMutasiFprFsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UploadMutasiFprFsDaoImpl extends BaseDaoImpl<UploadMutasiFprFs, UploadMutasiFprFsDto, Long> implements UploadMutasiFprFsDao {

	private UploadMutasiFprFsRepository uploadMutasiFprFsRepository;

@Autowired
	public UploadMutasiFprFsDaoImpl(UploadMutasiFprFsRepository uploadMutasiFprFsRepository){
		super(uploadMutasiFprFsRepository);
		this.uploadMutasiFprFsRepository = uploadMutasiFprFsRepository;
}


	@Override
	public Map processCuspInsertFaktorFprFs(CuspInsertFaktorFprFsSPDto spDto) {
		Map<String, Object> mutasiPensiunSPParam = new HashMap();
		mutasiPensiunSPParam.put("PAR_ROLE_ID", spDto.getParRoleId());
		mutasiPensiunSPParam.put("PAR_COMP_NAME", spDto.getParCompName());
		mutasiPensiunSPParam.put("PAR_USER_NAME", spDto.getParUserName());
		mutasiPensiunSPParam.put("PAR_NAMA_FAKTOR", spDto.getParNamaFaktor());
		mutasiPensiunSPParam.put("PAR_TGL_AWAL", spDto.getParTglAwal());
		mutasiPensiunSPParam.put("PAR_TGL_AKHIR", spDto.getParTglAkhir());
		mutasiPensiunSPParam.put("PAR_KETERANGAN_FAKTOR", spDto.getParKeteranganFaktor());
		mutasiPensiunSPParam.put("PAR_FAKTOR", spDto.getParFaktor());

		List<String> mutasiPensiunOutSPParam = new ArrayList<>();
		mutasiPensiunOutSPParam.add("PAR_STATUS_EKSEKUSI");
		mutasiPensiunOutSPParam.add("PAR_MSG");
		mutasiPensiunOutSPParam.add("PAR_ID_FAKTOR");
		return this.uploadMutasiFprFsRepository.callStoredProcedure("MutasiPensiun.processCuspInsertFaktorFprFs", mutasiPensiunSPParam, mutasiPensiunOutSPParam);
	}
}