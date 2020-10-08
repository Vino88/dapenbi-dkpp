package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.StatusKawinDao;
import com.dapenbi.dkpp.dto.StatusKawinDto;
import com.dapenbi.dkpp.model.StatusKawin;
import com.dapenbi.dkpp.repository.StatusKawinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusKawinDaoImpl extends BaseDaoImpl<StatusKawin, StatusKawinDto, Long> implements StatusKawinDao {
    private StatusKawinRepository statusKawinRepository;

    @Autowired
    public StatusKawinDaoImpl(StatusKawinRepository statusKawinRepository){
        super(statusKawinRepository);
        this.statusKawinRepository = statusKawinRepository;
    }

    @Override
    public StatusKawin findFirstById(Long id) {
        return statusKawinRepository.findFirstById(id);
    }
}
