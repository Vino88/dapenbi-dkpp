package com.dapenbi.dkpp.dao.impl;

import org.springframework.stereotype.Service;

import com.dapenbi.dkpp.dao.HerRegistrasiDetailDao;
import com.dapenbi.dkpp.dto.HerRegistrasiDetailDto;
import com.dapenbi.dkpp.model.HerRegistrasiDetail;
import com.dapenbi.dkpp.model.CompositeId.HerRegistrasiDetailPK;
import com.dapenbi.dkpp.repository.HerRegistrasiDetailRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


@Service
public class HerRegistrasiDetailDaoImpl extends BaseDaoImpl<HerRegistrasiDetail, HerRegistrasiDetailDto, HerRegistrasiDetailPK> implements HerRegistrasiDetailDao{

	private HerRegistrasiDetailRepository herDetailRepository;
	
	public HerRegistrasiDetailDaoImpl(HerRegistrasiDetailRepository herDetailRepository) {
		super(herDetailRepository);
		this.herDetailRepository = herDetailRepository;
	}
	
	@Override
	public HerRegistrasiDetail findByTahunHerAndNip(String tahunHer, String nip) {
		return herDetailRepository.findByTahunHerAndNip(tahunHer, nip);
	}

    @Override
    public Page<HerRegistrasiDetail> findByTahunHer(String tahunHer, String searchParam, Pageable pageable) {
		return herDetailRepository.findByTahunHer(tahunHer, searchParam,pageable);
    }

    @Override
    public List<HerRegistrasiDetail> findAllByTahunHer(String tahunHer) {
        return herDetailRepository.findAllByTahunHer(tahunHer);
    }

    @Override
    public String generateNoHer(String tahunHer) {
        return herDetailRepository.generateNoReg(tahunHer);
    }

    @Override
    public HerRegistrasiDetail findByBlmHer() {
        return herDetailRepository.findByBlmRegistrasi();
    }

}
