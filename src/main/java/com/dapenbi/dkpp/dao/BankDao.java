package com.dapenbi.dkpp.dao;

import com.dapenbi.dkpp.dto.BankDto;
import com.dapenbi.dkpp.model.BankNF;
import com.dapenbi.dkpp.model.BaseModel;

public interface BankDao extends BaseDao<BankNF, BankDto, Long> {

    BankNF findByBank(String namaBankNF);
}
