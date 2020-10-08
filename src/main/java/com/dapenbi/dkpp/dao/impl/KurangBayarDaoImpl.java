package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.KurangBayarDao;
import com.dapenbi.dkpp.dto.KurangBayarDto;
import com.dapenbi.dkpp.model.CompositeId.KurangBayarPK;
import com.dapenbi.dkpp.model.KurangBayar;
import com.dapenbi.dkpp.repository.KurangBayarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KurangBayarDaoImpl extends BaseDaoImpl<KurangBayar, KurangBayarDto, KurangBayarPK> implements KurangBayarDao {
    private KurangBayarRepository kurangBayarRepository;

    @Autowired
    public KurangBayarDaoImpl(KurangBayarRepository kurangBayarRepository){
        super(kurangBayarRepository);
        this.kurangBayarRepository = kurangBayarRepository;
    }
}
