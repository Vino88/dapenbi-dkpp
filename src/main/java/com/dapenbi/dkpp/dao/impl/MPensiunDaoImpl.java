package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.MPensiunDao;
import com.dapenbi.dkpp.dto.MPensiunDto;
import com.dapenbi.dkpp.model.MPensiun;
import com.dapenbi.dkpp.repository.BaseRepository;
import com.dapenbi.dkpp.repository.MPensiunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MPensiunDaoImpl extends BaseDaoImpl<MPensiun, MPensiunDto, String> implements MPensiunDao {
    private MPensiunRepository mPensiunRepository;

    @Autowired
    public MPensiunDaoImpl(MPensiunRepository mPensiunRepository) {
        super(mPensiunRepository);
        this.mPensiunRepository = mPensiunRepository;
    }

    @Override
    public MPensiun findByNip(String nip) {
        return (MPensiun) this.mPensiunRepository.findFirstByNip(nip);
    }

    @Override
    public MPensiun findByNip(MPensiun mPensiun) {
        return null;
    }

    @Override
    public Page<MPensiun> findAllPensiunTundaJatuhTempo(String searchParam, Pageable pageable) {
        return mPensiunRepository.findAllPensiunTundaJatuhTempo(searchParam, pageable);
    }

    @Override
    public Page<MPensiun> findAllPensiunTundaJatuhTempoDiBayar(String searchParam, Pageable pageable) {
        return mPensiunRepository.findAllPensiunTundaJatuhTempoDiBayar(searchParam, pageable);
    }

    @Override
    public Page<MPensiun> findAllPensiunStatusBayar1(String searchParam, Pageable pageable) {
        return mPensiunRepository.findAllPensiunStatusBayar1(searchParam, pageable);
    }

    @Override
    public Page<MPensiun> findAllPensiunStatusBayarSamaDengan1(Pageable pageable) {
        return mPensiunRepository.findAllPensiunStatusBayarSamaDengan1(pageable);
    }

    @Override
    public Page<MPensiun> findAllByJenisMps(String idJenisMps, String searchParam, Pageable pageable) {
        return mPensiunRepository.findAllByJenisMps(idJenisMps,searchParam,pageable);
    }

    @Override
    public List<MPensiun> findAllList() {
        return mPensiunRepository.findAllList();
    }

    @Override
    public Page<MPensiun> findAllPensiunByKategoriPenerimaIsJandaDuda(String searchParam, Pageable pageable) {
        return mPensiunRepository.findAllPensiunByKategoriPenerimaIsJandaDuda(searchParam, pageable);
    }

    @Override
    public Page<MPensiun> findByIsNotPeserta(String searchParam, Pageable pageable) {
        return mPensiunRepository.findAllNotPeserta(searchParam, pageable);
    }

    @Override
    public Page<MPensiun> findAllPenerimaMp(String searchParam, Pageable pageable) {
        return mPensiunRepository.findAllPenerimaMp(searchParam,pageable);
    }
}
