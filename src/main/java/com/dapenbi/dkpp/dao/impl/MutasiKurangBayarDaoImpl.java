package com.dapenbi.dkpp.dao.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dapenbi.dkpp.dao.MutasiKurangBayarDao;
import com.dapenbi.dkpp.dto.KurangBayarDto;
import com.dapenbi.dkpp.model.KurangBayar;
import com.dapenbi.dkpp.model.CompositeId.KurangBayarPK;
import com.dapenbi.dkpp.repository.MutasiKurangBayarRepository;

@Service
public class MutasiKurangBayarDaoImpl  extends BaseDaoImpl<KurangBayar, KurangBayarDto, KurangBayarPK> implements MutasiKurangBayarDao{
	private MutasiKurangBayarRepository repository;
	
	public MutasiKurangBayarDaoImpl(MutasiKurangBayarRepository repository) {
		super(repository);
		this.repository = repository;
	}

    @Override
    public Page<KurangBayar> findAllByPeriodeMutasi(String periodeMutasi, Pageable pageable) {
        return repository.findAllByPeriodeMutasi(periodeMutasi, pageable);
    }
}
