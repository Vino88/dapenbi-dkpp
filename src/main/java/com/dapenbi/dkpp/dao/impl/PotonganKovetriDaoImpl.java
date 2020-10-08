package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.PotonganKovetriDao;
import com.dapenbi.dkpp.dto.PotonganKovetriDto;
import com.dapenbi.dkpp.model.CompositeId.PotonganKovetriPK;
import com.dapenbi.dkpp.model.PotonganKovetri;
import com.dapenbi.dkpp.model.PotonganPga;
import com.dapenbi.dkpp.repository.PotonganKovetriRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PotonganKovetriDaoImpl extends BaseDaoImpl<PotonganKovetri, PotonganKovetriDto, PotonganKovetriPK> implements PotonganKovetriDao {
    private PotonganKovetriRepository potonganKovetriRepository;

    public PotonganKovetriDaoImpl(PotonganKovetriRepository potonganKovetriRepository) {
        super(potonganKovetriRepository);
        this.potonganKovetriRepository = potonganKovetriRepository;
    }

    @Override
    public int countByPeriodeMutasiAndTglUpload(String periodeMutasi, Date tglUpload) {
        return potonganKovetriRepository.countByPeriodeMutasiAndTglUpload(periodeMutasi, tglUpload);
    }

    public Page<PotonganKovetri> findAllByPeriodeMutasiAndUserStamp(String periodeMutasiPart, String userStampPart, Pageable pageable){
        return this.potonganKovetriRepository.findAllByPeriodeMutasiAndUserStamp(periodeMutasiPart, userStampPart, pageable);
    }
}
