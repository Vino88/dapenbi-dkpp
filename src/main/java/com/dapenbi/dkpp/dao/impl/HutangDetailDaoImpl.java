package com.dapenbi.dkpp.dao.impl;


import com.dapenbi.dkpp.dao.HutangDetailDao;


import com.dapenbi.dkpp.dto.HutangDetailDto;
import com.dapenbi.dkpp.model.HutangDetail;
import com.dapenbi.dkpp.repository.HutangDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class HutangDetailDaoImpl extends BaseDaoImpl<HutangDetail, HutangDetailDto, Long> implements HutangDetailDao {
	private HutangDetailRepository hutangDetailRepository;

	@Autowired
	public HutangDetailDaoImpl(HutangDetailRepository hutangDetailRepository){
		super(hutangDetailRepository);
		this.hutangDetailRepository = hutangDetailRepository;
	}


	@Override
	public Page<HutangDetail> findByNipAndPeriodeMutasi(String nip, String periodeMutasi, Pageable pageable) {
		return this.hutangDetailRepository.findByNipAndPeriodeMutasi(nip, periodeMutasi, pageable);
	}

	@Override
	public Page<HutangDetail> findAllByHutangId(Long id, Pageable pageable) {
		return this.hutangDetailRepository.findAllByIdHutang(id, pageable);
	}

}