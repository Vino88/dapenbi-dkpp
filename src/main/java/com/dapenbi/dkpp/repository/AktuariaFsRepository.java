package com.dapenbi.dkpp.repository;

import com.dapenbi.dkpp.model.AktuariaFs;
import com.dapenbi.dkpp.model.CompositeId.AktuariaFsPK;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AktuariaFsRepository extends BaseRepository<AktuariaFs, AktuariaFsPK> {

    Page<AktuariaFs> findAllByUserStamp(String userStamp, Pageable pageable);

    @Query(
            value = "select * from tbl_r_aktuaria_fs d where d.ID_FAKTOR_FS = ?1 and (d.USIA_FS like ?2 or d.FS_PRIAANAK like  ?2 )",
            nativeQuery = true
    )
    Page<AktuariaFs>findAllByIdFAndFaktorFsWithSearch(Long idFaktorFs, String searchParam, Pageable pageable);
}
