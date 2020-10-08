package com.dapenbi.dkpp.dao.impl;


import com.dapenbi.dkpp.dao.PembayaranHutangDao;


import com.dapenbi.dkpp.dto.PembayaranHutangDto;
import com.dapenbi.dkpp.model.PembayaranHutang;
import com.dapenbi.dkpp.repository.PembayaranHutangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PembayaranHutangDaoImpl extends BaseDaoImpl<PembayaranHutang, PembayaranHutangDto, Long> implements PembayaranHutangDao {
	private PembayaranHutangRepository pembayaranHutangRepository;

	@Autowired
	public PembayaranHutangDaoImpl(PembayaranHutangRepository pembayaranHutangRepository){
		super(pembayaranHutangRepository);
		this.pembayaranHutangRepository = pembayaranHutangRepository;
	}


	@Override
	public Page<PembayaranHutang> findAllByIsHutangMp(String isHutangMp, String searchParam, Pageable pageable) {
		return this.pembayaranHutangRepository.findAllByIsHutangMp(isHutangMp, searchParam, pageable);
	}

	@Override
	public Page<PembayaranHutang> findAllByIsHutangPembinaan(String isHutangMp, String searchParam, Pageable pageable) {
		return this.pembayaranHutangRepository.findAllByIsHutangPembinaan(isHutangMp, searchParam, pageable);
	}
}