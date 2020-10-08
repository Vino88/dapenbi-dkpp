package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.PengolahanDataBerkalaKelDao;
import com.dapenbi.dkpp.dto.PengolahanDataBerkalaKelDto;
import com.dapenbi.dkpp.model.PengolahanDataBerkalaKel;
import com.dapenbi.dkpp.repository.PengolahanDataBerkalaKelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PengolahanDataBerkalaKelDaoImpl extends BaseDaoImpl<PengolahanDataBerkalaKel, PengolahanDataBerkalaKelDto, Long> implements PengolahanDataBerkalaKelDao {

    @Autowired
    PengolahanDataBerkalaKelRepository pengolahanDataBerkalaKelRepository;

    public PengolahanDataBerkalaKelDaoImpl(PengolahanDataBerkalaKelRepository pengolahanDataBerkalaKelRepository){
        super(pengolahanDataBerkalaKelRepository);
        this.pengolahanDataBerkalaKelRepository = pengolahanDataBerkalaKelRepository;
    }
}
