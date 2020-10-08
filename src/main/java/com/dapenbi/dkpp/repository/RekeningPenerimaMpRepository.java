package com.dapenbi.dkpp.repository;

import com.dapenbi.dkpp.model.RekeningPenerimaMp;
import org.springframework.stereotype.Repository;

@Repository
public interface RekeningPenerimaMpRepository extends BaseRepository<RekeningPenerimaMp, Long> {

    RekeningPenerimaMp findByNip(String nip);
}
