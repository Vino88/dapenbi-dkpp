package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.BankDao;
import com.dapenbi.dkpp.dto.BankDto;
import com.dapenbi.dkpp.model.BankNF;
import com.dapenbi.dkpp.model.BaseModel;
import com.dapenbi.dkpp.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BankDaoImpl extends BaseDaoImpl<BankNF, BankDto, Long> implements BankDao {

    private BankRepository bankRepository;

    @Autowired
    public BankDaoImpl(BankRepository bankRepository) {
        super(bankRepository);
        this.bankRepository = bankRepository;
    }

    @Override
    public BankNF findByBank(String namaBankNF){
        return bankRepository.findOneByNamaBankNF(namaBankNF);
    }

}
