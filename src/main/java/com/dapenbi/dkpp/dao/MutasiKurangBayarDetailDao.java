package com.dapenbi.dkpp.dao;

import org.springframework.data.domain.Page;

import com.dapenbi.dkpp.dto.KurangBayarDetailDto;
import com.dapenbi.dkpp.model.KurangBayarDetail;

public interface MutasiKurangBayarDetailDao extends BaseDao<KurangBayarDetail, KurangBayarDetailDto, Long>{
	Iterable<KurangBayarDetail> findByNipAndPeriode(String nip, String periode);
}
