package com.dapenbi.dkpp.dao.impl;


import com.dapenbi.dkpp.dao.TMutasiRekeningDao;


import com.dapenbi.dkpp.dto.TMutasiRekeningDto;
import com.dapenbi.dkpp.form.CuspMutasiRekeningSPDto;
import com.dapenbi.dkpp.model.TMutasiRekening;
import com.dapenbi.dkpp.repository.TMutasiRekeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TMutasiRekeningDaoImpl extends BaseDaoImpl<TMutasiRekening, TMutasiRekeningDto, String> implements TMutasiRekeningDao {
	private TMutasiRekeningRepository tMutasiRekeningRepository;

	@Autowired
		public TMutasiRekeningDaoImpl(TMutasiRekeningRepository tMutasiRekeningRepository){
			super(tMutasiRekeningRepository);
			this.tMutasiRekeningRepository = tMutasiRekeningRepository;
	}

	@Override
	public Map processCuspMutasiRekening(CuspMutasiRekeningSPDto spDto) {
		Map<String, Object> mutasiPensiunSPParam = new HashMap();
		mutasiPensiunSPParam.put("PAR_ROLE_ID", spDto.getParRoleId());
		mutasiPensiunSPParam.put("PAR_COMP_NAME", spDto.getParCompName());
		mutasiPensiunSPParam.put("PAR_USER_NAME", spDto.getParUserName());
		mutasiPensiunSPParam.put("PAR_PERIODE_MUTASI", spDto.getParPeriodeMutasi());
		mutasiPensiunSPParam.put("PAR_TGL_INPUT", spDto.getParTglInput());
		mutasiPensiunSPParam.put("PAR_ID_MUTASI_REKENING", spDto.getParIdMutasiRekening());
		mutasiPensiunSPParam.put("PAR_NIP", spDto.getParNip());
		mutasiPensiunSPParam.put("PAR_NAMA_PESERTA", spDto.getParNamaPeserta());
		mutasiPensiunSPParam.put("PAR_ID_PENERIMA_MP", spDto.getParIdPenerimaMp());
		mutasiPensiunSPParam.put("PAR_NAMA_PENERIMA_MP", spDto.getParNamaPenerimaMp());
		mutasiPensiunSPParam.put("PAR_NO_REKENING_LAMA", spDto.getParNoRekeningLama());
		mutasiPensiunSPParam.put("PAR_NAMA_REKENING_LAMA", spDto.getParNamaRekeningLama());
		mutasiPensiunSPParam.put("PAR_NAMA_KET_PERUBAHAN_REK", spDto.getParNamaKetPerubahanRek());
		mutasiPensiunSPParam.put("PAR_NO_REKENING_BARU", spDto.getParNoRekeningBaru());
		mutasiPensiunSPParam.put("PAR_NAMA_REKENING_BARU", spDto.getParNamaRekeningBaru());
		mutasiPensiunSPParam.put("PAR_ID_JENIS_BANK", spDto.getParIdJenisBank());
		mutasiPensiunSPParam.put("PAR_JENIS_BANK", spDto.getParJenisBank());
		mutasiPensiunSPParam.put("PAR_NAMA_CABANG_BANK", spDto.getParNamaCabangBank());
		mutasiPensiunSPParam.put("PAR_ID_VALIDASI", spDto.getParIdValidasi());
		mutasiPensiunSPParam.put("PAR_NAMA_VALIDASI", spDto.getParNamaValidasi());
		List<String> mutasiPensiunOutSPParam = new ArrayList<>();
		mutasiPensiunOutSPParam.add("PAR_STATUS_EKSEKUSI");
		mutasiPensiunOutSPParam.add("PAR_MSG");

		return this.tMutasiRekeningRepository.callStoredProcedure("MutasiPensiun.processCuspMutasiRekening", mutasiPensiunSPParam, mutasiPensiunOutSPParam);
	}

	@Override
	public Page<TMutasiRekening> findAllByFilterForm(String periode, Date startDate, Date endDate, String searchParam, Pageable page){
		return this.tMutasiRekeningRepository.findAllByFilterForm(periode, startDate, endDate, searchParam, page);
	}


}