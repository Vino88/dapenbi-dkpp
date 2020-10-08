package com.dapenbi.dkpp.repository;

import com.dapenbi.dkpp.model.CompositeId.PotonganKovetriPK;
import com.dapenbi.dkpp.model.PotonganKovetri;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface PotonganKovetriRepository extends BaseRepository<PotonganKovetri, PotonganKovetriPK> {

    @Query(
            value = "SELECT COUNT(*) FROM TBL_T_POTONGAN_KOVETRI WHERE PERIODE_MUTASI = ? AND TGL_UPLOAD = ?",
            nativeQuery = true
    )
    int countByPeriodeMutasiAndTglUpload(String periodeMutasi, Date tglUpload);

    Page<PotonganKovetri> findAllByPeriodeMutasiAndUserStamp(String periodeMutasi, String userStamp, Pageable pageable);
}
