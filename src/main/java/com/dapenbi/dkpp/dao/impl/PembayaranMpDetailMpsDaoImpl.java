package com.dapenbi.dkpp.dao.impl;


import com.dapenbi.dkpp.dao.PembayaranMpDetailMpsDao;


import com.dapenbi.dkpp.dto.PembayaranMpDetailMpsDto;
import com.dapenbi.dkpp.model.PembayaranMp;
import com.dapenbi.dkpp.model.PembayaranMpDetailMps;
import com.dapenbi.dkpp.repository.PembayaranMpDetailMpsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PembayaranMpDetailMpsDaoImpl extends BaseDaoImpl<PembayaranMpDetailMps, PembayaranMpDetailMpsDto, Long> implements PembayaranMpDetailMpsDao {
	private PembayaranMpDetailMpsRepository pembayaranMpDetailMpsRepository;

@Autowired
	public PembayaranMpDetailMpsDaoImpl(PembayaranMpDetailMpsRepository pembayaranMpDetailMpsRepository){
		super(pembayaranMpDetailMpsRepository);
		this.pembayaranMpDetailMpsRepository = pembayaranMpDetailMpsRepository;
}


//	@Override
//	public Iterable<PembayaranMpDetailMps> findAllByIdPembayaran(String[] column, String searchParam, Pageable pageable, PembayaranMp pembayaranMp) {
//		return pembayaranMpDetailMpsRepository.findAllByIdPembayaran(column,searchParam,pageable,pembayaranMp);
//	}

	@Override
	public Page<PembayaranMpDetailMps> findAllByIdPembayaranWithSearch(Long idPembayaran,String searchParam, Pageable pageable) {
		return pembayaranMpDetailMpsRepository.findAllByIdPembayaranWithSearch(idPembayaran,searchParam,pageable);
	}
}