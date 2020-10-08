package com.dapenbi.dkpp.dao.impl;


import com.dapenbi.dkpp.dao.TempAktuariaFprDao;


import com.dapenbi.dkpp.dto.TempAktuariaFprDto;
import com.dapenbi.dkpp.dto.UploadHeaderSummaryDto;
import com.dapenbi.dkpp.model.TempAktuariaFpr;
import com.dapenbi.dkpp.repository.TempAktuariaFprRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TempAktuariaFprDaoImpl extends BaseDaoImpl<TempAktuariaFpr, TempAktuariaFprDto, Long> implements TempAktuariaFprDao {

	private TempAktuariaFprRepository tempAktuariaFprRepository;

	private static SessionFactory factory;

	private Session session;

@Autowired
	public TempAktuariaFprDaoImpl(TempAktuariaFprRepository tempAktuariaFprRepository){
		super(tempAktuariaFprRepository);
		this.tempAktuariaFprRepository = tempAktuariaFprRepository;
}


	@Override
	public void deleteAll() {
		this.tempAktuariaFprRepository.deleteAll();
	}

	@Override
	public UploadHeaderSummaryDto getSummary() {
		UploadHeaderSummaryDto dto = new UploadHeaderSummaryDto();
		dto.setTotalRow( String.valueOf(tempAktuariaFprRepository.getCount()) );
		return dto;
	}

}