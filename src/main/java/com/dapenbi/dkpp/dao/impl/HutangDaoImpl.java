package com.dapenbi.dkpp.dao.impl;


import com.dapenbi.dkpp.dao.HutangDao;


import com.dapenbi.dkpp.dto.HutangDto;
import com.dapenbi.dkpp.form.CuspPembayaranHutangPtrSPDto;
import com.dapenbi.dkpp.form.CuspPembayaranHutangSPDto;
import com.dapenbi.dkpp.model.Hutang;
import com.dapenbi.dkpp.model.HutangDetail;
import com.dapenbi.dkpp.repository.HutangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HutangDaoImpl extends BaseDaoImpl<Hutang, HutangDto, Long> implements HutangDao {
	private HutangRepository hutangRepository;

	@Autowired
		public HutangDaoImpl(HutangRepository hutangRepository){
			super(hutangRepository);
			this.hutangRepository = hutangRepository;
	}


	@Override
	public Page<Hutang> findAllByType(String type[], Pageable pageable) {
		return this.hutangRepository.findAllByType(type, pageable);
	}

	@Override
	public Page<Hutang> findAllByType(String type[], String searchParam, Pageable pageable) {
		return this.hutangRepository.findAllByType(type, searchParam, pageable);
	}

	@Override
	public Map processCuspPembayaranHutang(CuspPembayaranHutangSPDto spDto) {
		Map<String, Object> mutasiPensiunSPParam = new HashMap();
		mutasiPensiunSPParam.put("PAR_COMP_NAME", spDto.getParCompName());
		mutasiPensiunSPParam.put("PAR_USER_NAME", spDto.getParUserName());
		mutasiPensiunSPParam.put("PAR_NIP", spDto.getParNip());
		mutasiPensiunSPParam.put("PAR_PERIODE_HUTANG", spDto.getParPeriodeHutang());
		mutasiPensiunSPParam.put("PAR_TYPE", spDto.getParType());
		List<String> mutasiPensiunOutSPParam = new ArrayList<>();
		mutasiPensiunOutSPParam.add("PAR_STATUS_EKSEKUSI");
		mutasiPensiunOutSPParam.add("PAR_MSG");

		return this.hutangRepository.callStoredProcedure("MutasiPensiun.processCuspPembayaranHutang", mutasiPensiunSPParam, mutasiPensiunOutSPParam);
	}

	@Override
	public Map processCuspPembayaranHutangPtr(CuspPembayaranHutangPtrSPDto spDto) {
		Map<String, Object> mutasiPensiunSPParam = new HashMap();
		mutasiPensiunSPParam.put("PAR_COMP_NAME", spDto.getParCompName());
		mutasiPensiunSPParam.put("PAR_USER_NAME", spDto.getParUserName());
		mutasiPensiunSPParam.put("PAR_ID_BAYAR", spDto.getParIdBayar());
		mutasiPensiunSPParam.put("PAR_PERIODE_BAYAR", spDto.getParPeriodeBayar());
		mutasiPensiunSPParam.put("PAR_NOMINAL", spDto.getParNominal());
		List<String> mutasiPensiunOutSPParam = new ArrayList<>();
		mutasiPensiunOutSPParam.add("PAR_STATUS_EKSEKUSI");
		mutasiPensiunOutSPParam.add("PAR_MSG");

		return this.hutangRepository.callStoredProcedure("MutasiPensiun.processCuspPembayaranHutangPtr", mutasiPensiunSPParam, mutasiPensiunOutSPParam);
	}

}