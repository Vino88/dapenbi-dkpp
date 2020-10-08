package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.UploadPotonganDao;
import com.dapenbi.dkpp.dto.UploadPotonganDto;
import com.dapenbi.dkpp.model.UploadPotongan;
import com.dapenbi.dkpp.repository.UploadPotonganRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UploadPotonganDaoImpl extends BaseDaoImpl<UploadPotongan, UploadPotonganDto, Long> implements UploadPotonganDao {

    private UploadPotonganRepository uploadPotonganRepository;

    @Autowired
    public UploadPotonganDaoImpl(UploadPotonganRepository uploadPotonganRepository){
        super(uploadPotonganRepository);
        this.uploadPotonganRepository = uploadPotonganRepository;
    }


}
