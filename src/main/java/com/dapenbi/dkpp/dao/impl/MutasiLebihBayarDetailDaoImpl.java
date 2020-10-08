package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.MutasiLebihBayarDetailDao;
import com.dapenbi.dkpp.dto.LebihBayarDetailDto;
import com.dapenbi.dkpp.model.LebihBayarDetail;
import com.dapenbi.dkpp.repository.MutasiLebihBayarDetailRepository;
import com.dapenbi.dkpp.repository.MutasiLebihBayarRepository;
import org.springframework.stereotype.Service;

@Service
public class MutasiLebihBayarDetailDaoImpl extends BaseDaoImpl<LebihBayarDetail, LebihBayarDetailDto, Long> implements MutasiLebihBayarDetailDao {
    private MutasiLebihBayarDetailRepository repository;

    public MutasiLebihBayarDetailDaoImpl(MutasiLebihBayarDetailRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public Iterable<LebihBayarDetail> findByNipAndPeriode(String nip, String periode) {
        return repository.findByNipAndPeriodeMutasi(nip, periode);
    }

}
