package com.dapenbi.dkpp.repository;

import com.dapenbi.dkpp.model.TempPotonganOlahraga;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TempPotonganOlahragaRepository extends BaseRepository<TempPotonganOlahraga, Long> {

    @Modifying
    @Query(value = "DELETE FROM tbl_temp_potongan_olahraga", nativeQuery = true)
    void deleteAll();

    @Query(value = "SELECT Count(*) AS TOTAL FROM tbl_temp_potongan_olahraga", nativeQuery = true)
    int getCount();

    @Query(value = "SELECT SUM (potongan) AS jumlah FROM tbl_temp_potongan_olahraga", nativeQuery = true)
    Long getJumlah();

    TempPotonganOlahraga getFirstByPeriodeMutasiIsNotNull();

}
