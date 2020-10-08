package com.dapenbi.dkpp.repository;

import com.dapenbi.dkpp.dto.PiutangDto;
import com.dapenbi.dkpp.model.Piutang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

public interface PiutangRepository extends BaseRepository<Piutang,String> {

    @Query(
            value = "SELECT mp FROM Piutang mp WHERE mp.sisaPiutang <> 0 and  (mp.nip like ?1 or lower(mp.namaPeserta) like lower(?1))"
    )
    Page<Piutang> findAllBySisaPiutang(String searchParam, Pageable pageable);

}
