package com.dapenbi.dkpp.repository;

import com.dapenbi.dkpp.model.TempAktuariaFpr;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

	
public interface TempAktuariaFprRepository extends BaseRepository<TempAktuariaFpr, Long> {

    @Modifying
    @Query(value = "DELETE FROM tbl_temp_aktuaria_fpr", nativeQuery = true)

    void deleteAll();

    @Query(value = "SELECT Count(*) AS TOTAL FROM tbl_temp_aktuaria_fpr", nativeQuery = true)
    int getCount();


}