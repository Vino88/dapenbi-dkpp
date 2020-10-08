package com.dapenbi.dkpp.dao;

import com.dapenbi.dkpp.dto.KurangBayarDto;
import com.dapenbi.dkpp.model.KurangBayar;
import com.dapenbi.dkpp.model.CompositeId.KurangBayarPK;
import com.dapenbi.dkpp.model.LebihBayar;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MutasiKurangBayarDao extends BaseDao<KurangBayar, KurangBayarDto, KurangBayarPK>{
    Page<KurangBayar> findAllByPeriodeMutasi(String periodeMutasi, Pageable pageable);

}
