package com.dapenbi.dkpp.dao.impl;


import com.dapenbi.dkpp.dao.ProyeksiPembayaranPensiunLamaDao;


import com.dapenbi.dkpp.dto.ProyeksiPembayaranPensiunLamaDto;
import com.dapenbi.dkpp.form.CuspProyeksiPembayaranPensiunLama;
import com.dapenbi.dkpp.model.ProyeksiPembayaranPensiunLama;
import com.dapenbi.dkpp.repository.ProyeksiPembayaranPensiunLamaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProyeksiPembayaranPensiunLamaDaoImpl extends BaseDaoImpl<ProyeksiPembayaranPensiunLama, ProyeksiPembayaranPensiunLamaDto, Long> implements ProyeksiPembayaranPensiunLamaDao {
	private ProyeksiPembayaranPensiunLamaRepository proyeksiPembayaranPensiunLamaRepository;

@Autowired
	public ProyeksiPembayaranPensiunLamaDaoImpl(ProyeksiPembayaranPensiunLamaRepository proyeksiPembayaranPensiunLamaRepository){
		super(proyeksiPembayaranPensiunLamaRepository);
		this.proyeksiPembayaranPensiunLamaRepository = proyeksiPembayaranPensiunLamaRepository;
}


	@Override
	public Map processCuspProyeksiPensiunLama(CuspProyeksiPembayaranPensiunLama spDto) {
		Map<String, Object> mutasiPensiunSPParam = new HashMap();
		mutasiPensiunSPParam.put("PAR_COMP_NAME", spDto.getParCompName());
		mutasiPensiunSPParam.put("PAR_USER_NAME", spDto.getParUserName());
		mutasiPensiunSPParam.put("PAR_TAHUN_PROYEKSI", spDto.getParTahunProyeksi());
		mutasiPensiunSPParam.put("PAR_UNTUK_PROYEKSI", spDto.getParUntukProyeksi());
		mutasiPensiunSPParam.put("PAR_USER_STAMP", spDto.getParUserStamp());

		List<String> mutasiPensiunOutSPParam = new ArrayList<>();
		mutasiPensiunOutSPParam.add("PAR_STATUS_EKSEKUSI");
		mutasiPensiunOutSPParam.add("PAR_MSG");

		return this.proyeksiPembayaranPensiunLamaRepository.callStoredProcedure("MutasiPensiun.processCuspProyeksiPensiunLama", mutasiPensiunSPParam, mutasiPensiunOutSPParam);
	}

	@Override
	public Page<ProyeksiPembayaranPensiunLama> findAllTanpaParam( String searchParam, Pageable pageable) {
		return proyeksiPembayaranPensiunLamaRepository.findAllTanpaParam(searchParam,pageable);
	}
}