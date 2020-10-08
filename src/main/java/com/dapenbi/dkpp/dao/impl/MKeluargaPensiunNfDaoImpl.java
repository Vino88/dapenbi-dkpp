package com.dapenbi.dkpp.dao.impl;


import com.dapenbi.dkpp.dao.MKeluargaPensiunNfDao;


import com.dapenbi.dkpp.dto.MKeluargaPensiunNfDto;
import com.dapenbi.dkpp.model.MKeluargaPensiunNf;
import com.dapenbi.dkpp.repository.MKeluargaPensiunNfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MKeluargaPensiunNfDaoImpl extends BaseDaoImpl<MKeluargaPensiunNf, MKeluargaPensiunNfDto, Long> implements MKeluargaPensiunNfDao {
	private MKeluargaPensiunNfRepository mKeluargaPensiunNfRepository;

@Autowired
	public MKeluargaPensiunNfDaoImpl(MKeluargaPensiunNfRepository mKeluargaPensiunNfRepository){
		super(mKeluargaPensiunNfRepository);
		this.mKeluargaPensiunNfRepository = mKeluargaPensiunNfRepository;
}

	@Override
	public Iterable<MKeluargaPensiunNf> findByNip(String nip) {
		return mKeluargaPensiunNfRepository.findAllByNip(nip);
	}

	@Override
	public void delete(MKeluargaPensiunNf mKeluargaPensiunNf){
		this.mKeluargaPensiunNfRepository.delete(mKeluargaPensiunNf);
	}

}