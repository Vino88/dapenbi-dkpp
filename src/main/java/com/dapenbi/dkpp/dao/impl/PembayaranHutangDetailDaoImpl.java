package com.dapenbi.dkpp.dao.impl;


import com.dapenbi.dkpp.dao.PembayaranHutangDetailDao;


import com.dapenbi.dkpp.dto.PembayaranHutangDetailDto;
import com.dapenbi.dkpp.model.PembayaranHutangDetail;
import com.dapenbi.dkpp.repository.PembayaranHutangDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PembayaranHutangDetailDaoImpl extends BaseDaoImpl<PembayaranHutangDetail, PembayaranHutangDetailDto, Long> implements PembayaranHutangDetailDao {
	private PembayaranHutangDetailRepository pembayaranHutangDetailRepository;

@Autowired
	public PembayaranHutangDetailDaoImpl(PembayaranHutangDetailRepository pembayaranHutangDetailRepository){
		super(pembayaranHutangDetailRepository);
		this.pembayaranHutangDetailRepository = pembayaranHutangDetailRepository;
}


	@Override
	public Page<PembayaranHutangDetail> findByPembayaranId(Long idPembayaran, Pageable pageable) {
		return this.pembayaranHutangDetailRepository.findAllByIdBayar(idPembayaran, pageable);
	}
}