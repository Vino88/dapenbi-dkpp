package com.dapenbi.dkpp.repository;

import com.dapenbi.dkpp.model.BankNF;

public interface BankRepository extends BaseRepository<BankNF, Long> {

    BankNF findOneByNamaBankNF(String NamaBankNF);
}
