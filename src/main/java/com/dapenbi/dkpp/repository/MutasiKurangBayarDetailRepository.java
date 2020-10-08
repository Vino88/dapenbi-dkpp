package com.dapenbi.dkpp.repository;

import com.dapenbi.dkpp.model.KurangBayarDetail;
import org.springframework.data.jpa.repository.Query;

public interface MutasiKurangBayarDetailRepository extends BaseRepository<KurangBayarDetail, Long> {

    @Query(
            value = "select * from tbl_t_kurang_bayar_detail where nip=?1 and periode_mutasi=?2",
            nativeQuery = true
    )
    Iterable<KurangBayarDetail> findByNipAndPeriodeMutasi(String nip, String periodeMutasi);
}
