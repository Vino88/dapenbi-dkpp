package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.AktuariaFsDao;
import com.dapenbi.dkpp.dto.AktuariaFsDto;
import com.dapenbi.dkpp.model.AktuariaFs;
import com.dapenbi.dkpp.model.CompositeId.AktuariaFsPK;
import com.dapenbi.dkpp.repository.AktuariaFsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AktuariaFsDaoImpl extends BaseDaoImpl<AktuariaFs, AktuariaFsDto, AktuariaFsPK> implements AktuariaFsDao {

    private AktuariaFsRepository aktuariaFsRepository;

    @Autowired
    public AktuariaFsDaoImpl(AktuariaFsRepository aktuariaFsRepository){
        super(aktuariaFsRepository);
        this.aktuariaFsRepository = aktuariaFsRepository;
    }

    @Override
    public Page<AktuariaFs> findAllByUserStamp(String userStamp, Pageable pageable) {
        return aktuariaFsRepository.findAllByUserStamp(userStamp,pageable);
    }

    @Override
    public Page<AktuariaFs> findAllByIdFAndFaktorFsWithSearch(Long idFaktorFs, String searchParam, Pageable pageable) {
        return aktuariaFsRepository.findAllByIdFAndFaktorFsWithSearch(idFaktorFs,searchParam,pageable);
    }
}
