package com.dapenbi.dkpp.repository;

import com.dapenbi.dkpp.model.TempPotonganKovetri;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TempPotonganKovetriRepository extends BaseRepository<TempPotonganKovetri, Long> {

    @Modifying
    @Query(value = "DELETE FROM tbl_temp_potongan_kovetri", nativeQuery = true)
    void deleteAll();

    @Query(value = "SELECT Count(*) AS TOTAL FROM tbl_temp_potongan_kovetri", nativeQuery = true)
    int getCount();

    @Query(value = "SELECT SUM (potongan) AS jumlah FROM tbl_temp_potongan_kovetri", nativeQuery = true)
    Long getJumlah();

    TempPotonganKovetri getFirstByPeriodeMutasiIsNotNull();
}
