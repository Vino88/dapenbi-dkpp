package com.dapenbi.dkpp.dao.impl;


import com.dapenbi.dkpp.dao.PmbyUangPmbnHDao;


import com.dapenbi.dkpp.dto.PmbyUangPmbnHDto;
import com.dapenbi.dkpp.form.CuspPmbyUangPembinaanHeadSPDto;
import com.dapenbi.dkpp.model.PmbyUangPmbnH;
import com.dapenbi.dkpp.repository.PmbyUangPmbnHRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PmbyUangPmbnHDaoImpl extends BaseDaoImpl<PmbyUangPmbnH, PmbyUangPmbnHDto, Long> implements PmbyUangPmbnHDao {
	private PmbyUangPmbnHRepository pmbyUangPmbnHRepository;

    @Autowired
	public PmbyUangPmbnHDaoImpl(PmbyUangPmbnHRepository pmbyUangPmbnHRepository){
		super(pmbyUangPmbnHRepository);
		this.pmbyUangPmbnHRepository = pmbyUangPmbnHRepository;
}


	@Override
	public Map processCuspPmbyUangPembinaan(CuspPmbyUangPembinaanHeadSPDto spDto) {
		Map<String, Object> mutasiPensiunSPParam = new HashMap();
		mutasiPensiunSPParam.put("PAR_ROLE_ID", spDto.getParRoleId());
		mutasiPensiunSPParam.put("PAR_COMP_NAME", spDto.getParCompName());
		mutasiPensiunSPParam.put("PAR_USER_NAME", spDto.getParUserName());
		mutasiPensiunSPParam.put("PAR_ID_UANG_PEMBINAAN_H", spDto.getParIdUangPembinaanH());
		mutasiPensiunSPParam.put("PAR_PERIODE_BAYAR", spDto.getParPeriodeBayar());
		mutasiPensiunSPParam.put("PAR_NOMINAL_PER_NIP", spDto.getParNominalPerNip());
		mutasiPensiunSPParam.put("PAR_KETERANGAN", spDto.getParKeterangan());
		mutasiPensiunSPParam.put("PAR_ID_VALIDASI", spDto.getParIdValidasi());
		mutasiPensiunSPParam.put("PAR_NAMA_VALIDASI", spDto.getParNamaValidasi());
		List<String> mutasiPensiunOutSPParam = new ArrayList<>();
		mutasiPensiunOutSPParam.add("PAR_STATUS_EKSEKUSI");
		mutasiPensiunOutSPParam.add("PAR_MSG");

		return this.pmbyUangPmbnHRepository.callStoredProcedure("PmbyUangPmbnH.processCuspPmbyUangPembinaan", mutasiPensiunSPParam, mutasiPensiunOutSPParam);
	}
}