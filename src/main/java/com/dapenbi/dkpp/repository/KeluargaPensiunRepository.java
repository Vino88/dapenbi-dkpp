package com.dapenbi.dkpp.repository;

import com.dapenbi.dkpp.model.KeluargaPensiun;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface KeluargaPensiunRepository extends BaseRepository<KeluargaPensiun, String> {
    void deleteAllByNip(String nip);

    @Query("select kp from KeluargaPensiun kp where kp.nip = ?1 order by kp.id")
    Iterable<KeluargaPensiun> findAllByNip(String nip);
}
