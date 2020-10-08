package com.dapenbi.dkpp.dao.impl;


import com.dapenbi.dkpp.dao.PmbyPiutangHistoryDao;
import com.dapenbi.dkpp.dto.PmbyPiutangHistoryDto;
import com.dapenbi.dkpp.model.PmbyPiutangHistory;
import com.dapenbi.dkpp.repository.PmbyPiutangHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PmbyPiutangHistoryDaoImpl extends BaseDaoImpl<PmbyPiutangHistory, PmbyPiutangHistoryDto, Long> implements PmbyPiutangHistoryDao {

	private PmbyPiutangHistoryRepository pmbyPiutangHistoryRepository;

	@Autowired
	public PmbyPiutangHistoryDaoImpl(PmbyPiutangHistoryRepository pmbyPiutangHistoryRepository){
		super(pmbyPiutangHistoryRepository);
		this.pmbyPiutangHistoryRepository = pmbyPiutangHistoryRepository;
}


	@Override
	public Page<PmbyPiutangHistory> findAllByNip(String nip, Pageable pageable) {
		return pmbyPiutangHistoryRepository.findAllByNip(nip,pageable);
	}
}