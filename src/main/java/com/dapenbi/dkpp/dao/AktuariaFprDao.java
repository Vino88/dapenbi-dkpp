package com.dapenbi.dkpp.dao;

import com.dapenbi.dkpp.dto.AktuariaFprDto;
import com.dapenbi.dkpp.model.AktuariaFpr;
import com.dapenbi.dkpp.model.CompositeId.AktuariaFprPK;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AktuariaFprDao extends BaseDao<AktuariaFpr, AktuariaFprDto, AktuariaFprPK> {

    Page<AktuariaFpr> findAllByUserStamp(String userStamp, Pageable pageable);

    Page<AktuariaFpr>findAllByIdFAndFaktorFprWithSearch(Long idFaktorfpr, String searchParam, Pageable pageable);
}
