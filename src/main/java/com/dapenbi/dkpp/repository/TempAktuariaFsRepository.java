package com.dapenbi.dkpp.repository;

import com.dapenbi.dkpp.model.TempAktuariaFs;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TempAktuariaFsRepository extends BaseRepository<TempAktuariaFs, Long>{

    @Modifying
    @Query(value = "DELETE FROM tbl_temp_aktuaria_fs", nativeQuery = true)

    void deleteAll();

    @Query(value = "SELECT Count(*) AS TOTAL FROM tbl_temp_aktuaria_fs", nativeQuery = true)
    int getCount();

//    @Query(value = "SELECT SUM (potongan) AS jumlah FROM tbl_temp_aktuaria_fs", nativeQuery = true)
//    Long getJumlah();
}
