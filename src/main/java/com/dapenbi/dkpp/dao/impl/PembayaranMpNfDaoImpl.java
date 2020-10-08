package com.dapenbi.dkpp.dao.impl;


import com.dapenbi.dkpp.dao.PembayaranMpNfDao;


import com.dapenbi.dkpp.dto.PembayaranMpNfDto;
import com.dapenbi.dkpp.form.CuspPembayaranMpNfPtrSPDto;
import com.dapenbi.dkpp.model.PembayaranMpNf;
import com.dapenbi.dkpp.repository.PembayaranMpNfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PembayaranMpNfDaoImpl extends BaseDaoImpl<PembayaranMpNf, PembayaranMpNfDto, String> implements PembayaranMpNfDao {
	private PembayaranMpNfRepository pembayaranMpNfRepository;

	@Autowired
	public PembayaranMpNfDaoImpl(PembayaranMpNfRepository pembayaranMpNfRepository){
		super(pembayaranMpNfRepository);
		this.pembayaranMpNfRepository = pembayaranMpNfRepository;
}

	@Override
	public Map processCuspPembayaranMpNfPtr(CuspPembayaranMpNfPtrSPDto spDto) {
		Map<String, Object> mutasiPensiunSPParam = new HashMap();
		mutasiPensiunSPParam.put("PAR_COMP_NAME", spDto.getParCompName());
		mutasiPensiunSPParam.put("PAR_USER_NAME", spDto.getParUserName());
		mutasiPensiunSPParam.put("PAR_ID_PEMBAYARAN", spDto.getParIdPembayaran());
		mutasiPensiunSPParam.put("PAR_MUTASI_BAYAR", spDto.getParMutasiBayar());
		mutasiPensiunSPParam.put("PAR_NOMINAL", spDto.getParNominal());
		List<String> mutasiPensiunOutSPParam = new ArrayList<>();
		mutasiPensiunOutSPParam.add("PAR_STATUS_EKSEKUSI");
		mutasiPensiunOutSPParam.add("PAR_MSG");

		return this.pembayaranMpNfRepository.callStoredProcedure("MutasiPensiun.processCuspPembayaranMpNfPtr", mutasiPensiunSPParam, mutasiPensiunOutSPParam);
	}

}