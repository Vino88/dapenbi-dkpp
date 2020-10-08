package com.dapenbi.dkpp.dao;

import com.dapenbi.dkpp.dto.AktuariaFsDto;
import com.dapenbi.dkpp.model.AktuariaFs;
import com.dapenbi.dkpp.model.CompositeId.AktuariaFsPK;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AktuariaFsDao extends BaseDao<AktuariaFs, AktuariaFsDto, AktuariaFsPK> {


    Page<AktuariaFs> findAllByUserStamp(String userStamp, Pageable pageable);

    Page<AktuariaFs>findAllByIdFAndFaktorFsWithSearch(Long idFaktorFs, String searchParam, Pageable pageable);
}