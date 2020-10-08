package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.AktuariaFprDao;
import com.dapenbi.dkpp.dto.AktuariaFprDto;
import com.dapenbi.dkpp.model.AktuariaFpr;
import com.dapenbi.dkpp.model.CompositeId.AktuariaFprPK;
import com.dapenbi.dkpp.repository.AktuariaFprRepository;
import com.dapenbi.dkpp.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AktuariaFprDaoImpl extends BaseDaoImpl<AktuariaFpr, AktuariaFprDto, AktuariaFprPK> implements AktuariaFprDao {
    private AktuariaFprRepository aktuariaFprRepository;

    @Autowired
    public AktuariaFprDaoImpl(AktuariaFprRepository aktuariaFprRepository) {
        super(aktuariaFprRepository);
        this.aktuariaFprRepository = aktuariaFprRepository;
    }

    @Override
    public Page<AktuariaFpr> findAllByUserStamp(String userStamp, Pageable pageable) {
        return aktuariaFprRepository.findAllByUserStamp(userStamp,pageable);
    }

    @Override
    public Page<AktuariaFpr> findAllByIdFAndFaktorFprWithSearch(Long idFaktorfpr, String searchParam, Pageable pageable) {
        return aktuariaFprRepository.findAllByIdFAndFaktorFprWithSearch(idFaktorfpr,searchParam,pageable);
    }
}
