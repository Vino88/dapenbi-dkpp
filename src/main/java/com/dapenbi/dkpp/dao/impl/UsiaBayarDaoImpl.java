package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.UsiaBayarDao;
import com.dapenbi.dkpp.dto.UsiaBayarDto;
import com.dapenbi.dkpp.model.UsiaBayar;
import com.dapenbi.dkpp.repository.BaseRepository;
import com.dapenbi.dkpp.repository.UsiaBayarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsiaBayarDaoImpl extends BaseDaoImpl<UsiaBayar, UsiaBayarDto, Long> implements UsiaBayarDao {
    private UsiaBayarRepository usiaBayarRepository;

    @Autowired
    public UsiaBayarDaoImpl(UsiaBayarRepository usiaBayarRepository) {
        super(usiaBayarRepository);
        this.usiaBayarRepository = usiaBayarRepository;
    }
}
