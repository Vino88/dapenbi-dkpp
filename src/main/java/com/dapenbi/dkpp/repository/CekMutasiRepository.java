package com.dapenbi.dkpp.repository;

import com.dapenbi.dkpp.model.KategoriMutasi;
import com.dapenbi.dkpp.model.MutasiPensiun;
import com.dapenbi.dkpp.model.ViewModel.PensiunLamaMeninggalView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface CekMutasiRepository extends BaseRepository<MutasiPensiun, Long> {

    @Query(
            value = "select CUFN_CHECK_EXSIST_MUTASI(?1) FROM DUAL",
            nativeQuery = true
    )
    String CufnCheckExistMutasi(String nip);
}

