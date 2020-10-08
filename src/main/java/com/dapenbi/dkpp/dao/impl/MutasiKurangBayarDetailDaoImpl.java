package com.dapenbi.dkpp.dao.impl;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.dapenbi.dkpp.dao.MutasiKurangBayarDetailDao;
import com.dapenbi.dkpp.dto.KurangBayarDetailDto;
import com.dapenbi.dkpp.model.KurangBayarDetail;
import com.dapenbi.dkpp.repository.MutasiKurangBayarDetailRepository;

@Service
public class MutasiKurangBayarDetailDaoImpl extends BaseDaoImpl<KurangBayarDetail, KurangBayarDetailDto, Long> implements MutasiKurangBayarDetailDao{
	private MutasiKurangBayarDetailRepository repository;
	
	public MutasiKurangBayarDetailDaoImpl(MutasiKurangBayarDetailRepository repository) {
		super(repository);
		this.repository = repository;
	}

	@Override
	public Iterable<KurangBayarDetail> findByNipAndPeriode(String nip, String periode) {
		return repository.findByNipAndPeriodeMutasi(nip, periode);
	}

}
