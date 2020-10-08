package com.dapenbi.dkpp.repository;

import com.dapenbi.dkpp.model.MutasiKeluargaPensiun;
import com.dapenbi.dkpp.model.MutasiPensiun;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface MutasiKeluargaPensiunRepository extends BaseRepository<MutasiKeluargaPensiun, String> {

    MutasiKeluargaPensiun findFirstByNip(String nip);

    List<MutasiKeluargaPensiun> findAllByMutasiPensiun(MutasiPensiun mutasi);

    void deleteAllByMutasiPensiun(MutasiPensiun mutasi);

    @Query(
            value = "delete from TBL_T_MUTASI_KELUARGA_PENSIUN WHERE ID_MUTASI_PENSIUN = ?1",
            nativeQuery = true
    )
    void deleteAllByIdMutasi(Long idMutasi);

    @Query(
            value = "call CUFN_DELETE_MUTASI_KELUARGA(?1)",
            nativeQuery = true
    )
    Map cufnDeleteMutasiKeluarga(
            String idMutasi
    );

}
