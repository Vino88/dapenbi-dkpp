package com.dapenbi.dkpp.dao;

import com.dapenbi.dkpp.dto.HerRegistrasiDetailDto;
import com.dapenbi.dkpp.model.HerRegistrasiDetail;
import com.dapenbi.dkpp.model.CompositeId.HerRegistrasiDetailPK;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface HerRegistrasiDetailDao extends BaseDao<HerRegistrasiDetail, HerRegistrasiDetailDto, HerRegistrasiDetailPK>{
	HerRegistrasiDetail findByTahunHerAndNip(String tahunHer, String nip);
	Page<HerRegistrasiDetail> findByTahunHer(String tahunHer, String searchParam, Pageable pageable);
	List<HerRegistrasiDetail> findAllByTahunHer(String tahunHer);

	String generateNoHer(String tahunHer);

	HerRegistrasiDetail findByBlmHer();
}
