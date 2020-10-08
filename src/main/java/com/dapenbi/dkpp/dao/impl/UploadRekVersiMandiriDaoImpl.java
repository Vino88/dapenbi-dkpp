package com.dapenbi.dkpp.dao.impl;


import com.dapenbi.dkpp.dao.UploadRekVersiMandiriDao;


import com.dapenbi.dkpp.dto.UploadRekVersiMandiriDto;
import com.dapenbi.dkpp.model.UploadRekVersiMandiri;
import com.dapenbi.dkpp.repository.UploadRekVersiMandiriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UploadRekVersiMandiriDaoImpl extends BaseDaoImpl<UploadRekVersiMandiri, UploadRekVersiMandiriDto, String> implements UploadRekVersiMandiriDao {
	private UploadRekVersiMandiriRepository uploadRekVersiMandiriRepository;

	@Autowired
	public UploadRekVersiMandiriDaoImpl(UploadRekVersiMandiriRepository uploadRekVersiMandiriRepository){
		super(uploadRekVersiMandiriRepository);
		this.uploadRekVersiMandiriRepository = uploadRekVersiMandiriRepository;
	}


	@Override
	public void deleteAll() {
		this.uploadRekVersiMandiriRepository.deleteAll();
	}
}