package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.StatusValidasiDao;
import com.dapenbi.dkpp.dto.StatusValidasiDto;
import com.dapenbi.dkpp.model.StatusValidasi;
import com.dapenbi.dkpp.repository.BaseRepository;
import com.dapenbi.dkpp.repository.StatusValidasiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusValidasiDaoImpl extends BaseDaoImpl<StatusValidasi, StatusValidasiDto, Long> implements StatusValidasiDao {
    private StatusValidasiRepository statusValidasiRepository;

    @Autowired
    public StatusValidasiDaoImpl(StatusValidasiRepository statusValidasiRepository) {
        super(statusValidasiRepository);
        this.statusValidasiRepository = statusValidasiRepository;
    }
}
