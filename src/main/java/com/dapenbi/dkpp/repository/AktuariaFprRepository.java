package com.dapenbi.dkpp.repository;

import com.dapenbi.dkpp.model.AktuariaFpr;
import com.dapenbi.dkpp.model.CompositeId.AktuariaFprPK;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

public interface AktuariaFprRepository extends BaseRepository<AktuariaFpr, AktuariaFprPK> {

    Page<AktuariaFpr> findAllByUserStamp(String userStamp, Pageable pageable);

    @Query(
            value = "select * from tbl_r_aktuaria_fpr d where d.id_faktor_fpr = ?1 and (d.usia_fpr like ?2 )",
            nativeQuery = true
    )
    Page<AktuariaFpr>findAllByIdFAndFaktorFprWithSearch(Long idFaktorfpr, String searchParam, Pageable pageable);
}
