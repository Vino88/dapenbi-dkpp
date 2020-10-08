package com.dapenbi.dkpp.dao.impl;


import com.dapenbi.dkpp.dao.PmbyUangPmbnDetDao;


import com.dapenbi.dkpp.dto.PmbyUangPmbnDetDto;
import com.dapenbi.dkpp.form.CuspPmbyUangPembinaanDetSpDto;
import com.dapenbi.dkpp.form.CuspPmbyUangPmbnPtrSPDto;
import com.dapenbi.dkpp.model.PmbyUangPmbnDet;
import com.dapenbi.dkpp.model.PmbyUangPmbnH;
import com.dapenbi.dkpp.repository.PmbyUangPmbnDetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PmbyUangPmbnDetDaoImpl extends BaseDaoImpl<PmbyUangPmbnDet, PmbyUangPmbnDetDto, Long> implements PmbyUangPmbnDetDao {
	private PmbyUangPmbnDetRepository pmbyUangPmbnDetRepository;

	@Autowired
	public PmbyUangPmbnDetDaoImpl(PmbyUangPmbnDetRepository pmbyUangPmbnDetRepository){
		super(pmbyUangPmbnDetRepository);
		this.pmbyUangPmbnDetRepository = pmbyUangPmbnDetRepository;
	}


//	@Override
//	public Iterable<PmbyUangPmbnDet> findByIdUangPembinaanH(PmbyUangPmbnH pmbyUangPmbnH) {
//		return pmbyUangPmbnDetRepository.findByIdUangPembinaanH(pmbyUangPmbnH);
//	}

	@Override
	public Page<PmbyUangPmbnDet> findAllByIdUangPembinaanH(Long idUangPembinaanH,String searchParam, Pageable pageable) {
		return pmbyUangPmbnDetRepository.findAllByIdUangPembinaanH(idUangPembinaanH, searchParam,pageable);
	}

	@Override
	public Map processCuspPmbyUangPembinaanD(CuspPmbyUangPembinaanDetSpDto spDto) {
		Map<String, Object> mutasiPensiunSPParam = new HashMap();
		mutasiPensiunSPParam.put("PAR_ROLE_ID", spDto.getParRoleId());
		mutasiPensiunSPParam.put("PAR_COMP_NAME", spDto.getParCompName());
		mutasiPensiunSPParam.put("PAR_USER_NAME", spDto.getParUserName());
		mutasiPensiunSPParam.put("PAR_ID_UANG_PEMBINAAN_D", spDto.getParIdUangPembinaanD());
		mutasiPensiunSPParam.put("PAR_ID_UANG_PEMBINAAN_H", spDto.getParIdUangPembinaanH());
		mutasiPensiunSPParam.put("PAR_PERIODE_BAYAR", spDto.getParPeriodeBayar());
		mutasiPensiunSPParam.put("PAR_NOMINAL", spDto.getParNominal());
		mutasiPensiunSPParam.put("PAR_NIP", spDto.getParNip());
		mutasiPensiunSPParam.put("PAR_NAMA_PESERTA", spDto.getParNamaPeserta());
		mutasiPensiunSPParam.put("PAR_ACTION", spDto.getParAction());
		List<String> mutasiPensiunOutSPParam = new ArrayList<>();
		mutasiPensiunOutSPParam.add("PAR_STATUS_EKSEKUSI");
		mutasiPensiunOutSPParam.add("PAR_MSG");

		return this.pmbyUangPmbnDetRepository.callStoredProcedure("PmbyUangPmbnDet.processCuspPmbyUangPembinaanD", mutasiPensiunSPParam, mutasiPensiunOutSPParam);
	}

	@Override
	public Map processCuspPmbyUangPmbnPtr(CuspPmbyUangPmbnPtrSPDto spDto) {
		Map<String, Object> mutasiPensiunSPParam = new HashMap();
		mutasiPensiunSPParam.put("PAR_COMP_NAME", spDto.getParCompName());
		mutasiPensiunSPParam.put("PAR_USER_NAME", spDto.getParUserName());
		mutasiPensiunSPParam.put("PAR_ID_UANG_PEMBINAAN_H", spDto.getParIdUangPembinaanH());
		List<String> mutasiPensiunOutSPParam = new ArrayList<>();
		mutasiPensiunOutSPParam.add("PAR_STATUS_EKSEKUSI");
		mutasiPensiunOutSPParam.add("PAR_MSG");

		return this.pmbyUangPmbnDetRepository.callStoredProcedure("PmbyUangPmbnDet.processCuspPmbyUangPmbnPtr", mutasiPensiunSPParam, mutasiPensiunOutSPParam);
	}
}