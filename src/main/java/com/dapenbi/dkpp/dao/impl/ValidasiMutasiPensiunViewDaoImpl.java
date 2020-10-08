package com.dapenbi.dkpp.dao.impl;


import com.dapenbi.dkpp.dao.ValidasiMutasiPensiunViewDao;


import com.dapenbi.dkpp.dto.ValidasiMutasiPensiunViewDto;
import com.dapenbi.dkpp.model.ValidasiMutasiPensiunView;
import com.dapenbi.dkpp.repository.ValidasiMutasiPensiunViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ValidasiMutasiPensiunViewDaoImpl extends BaseDaoImpl<ValidasiMutasiPensiunView, ValidasiMutasiPensiunViewDto, String> implements ValidasiMutasiPensiunViewDao {
	private ValidasiMutasiPensiunViewRepository validasiMutasiPensiunViewRepository;

@Autowired
	public ValidasiMutasiPensiunViewDaoImpl(ValidasiMutasiPensiunViewRepository validasiMutasiPensiunViewRepository){
		super(validasiMutasiPensiunViewRepository);
		this.validasiMutasiPensiunViewRepository = validasiMutasiPensiunViewRepository;
}


}