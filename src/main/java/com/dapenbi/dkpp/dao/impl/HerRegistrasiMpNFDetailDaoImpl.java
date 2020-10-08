package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.HerRegistrasiMpNFDetailDao;
import com.dapenbi.dkpp.dto.HerRegistrasiMpNFDetailDto;
import com.dapenbi.dkpp.model.HerRegistrasiMpNFDetail;
import com.dapenbi.dkpp.model.HerRegistrasiMpNFHeader;
import com.dapenbi.dkpp.repository.HerRegistrasiMpNFDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class HerRegistrasiMpNFDetailDaoImpl extends BaseDaoImpl<HerRegistrasiMpNFDetail, HerRegistrasiMpNFDetailDto, String> implements HerRegistrasiMpNFDetailDao {

    private HerRegistrasiMpNFDetailRepository herRegistrasiMpNFDetailRepository;

    @Autowired
    public HerRegistrasiMpNFDetailDaoImpl(HerRegistrasiMpNFDetailRepository herRegistrasiMpNFDetailRepository){
        super(herRegistrasiMpNFDetailRepository);
        this.herRegistrasiMpNFDetailRepository = herRegistrasiMpNFDetailRepository;
    }

    @Override
    public Iterable<HerRegistrasiMpNFDetail> findByTahunHer(String tahunHer) {
        return herRegistrasiMpNFDetailRepository.findByTahunHer(tahunHer);
    }
}
