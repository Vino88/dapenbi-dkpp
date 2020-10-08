package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.PembayaranMpDetailMpDao;
import com.dapenbi.dkpp.dto.PembayaranMpDetailMpDto;
import com.dapenbi.dkpp.model.PembayaranMp;
import com.dapenbi.dkpp.model.PembayaranMpDetailMp;
import com.dapenbi.dkpp.repository.BaseRepository;
import com.dapenbi.dkpp.repository.PembayaranMpDetailMpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PembayaranMpDetailMpDaoImpl extends BaseDaoImpl<PembayaranMpDetailMp, PembayaranMpDetailMpDto,Long> implements PembayaranMpDetailMpDao {

    @Autowired
    PembayaranMpDetailMpRepository pembayaranMpDetailMpRepository;


    public PembayaranMpDetailMpDaoImpl(PembayaranMpDetailMpRepository pembayaranMpDetailMpRepository) {
        super(pembayaranMpDetailMpRepository);
        this.pembayaranMpDetailMpRepository = pembayaranMpDetailMpRepository;
    }


    @Override
    public Page<PembayaranMpDetailMp> findAllByIdPembayaranSearch(Long idPembayaran, String searchParam, Pageable pageable) {
        return pembayaranMpDetailMpRepository.findAllByIdPembayaranSearch(idPembayaran,searchParam,pageable);
    }

    @Override
    public Page<PembayaranMpDetailMp> findAllByIdPembayaranSearchNull(Long idPembayaran, Pageable pageable) {
        return pembayaranMpDetailMpRepository.findAllByIdPembayaranSearchNull(idPembayaran,pageable);
    }
}
