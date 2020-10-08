package com.dapenbi.dkpp.repository;

import com.dapenbi.dkpp.model.SetupParameter;
import org.springframework.data.jpa.repository.Query;

public interface SetupParameterRepository extends BaseRepository<SetupParameter, String> {

    SetupParameter findFirstByPeriode(String id);

    SetupParameter findFirstByIsBukaPeriodeIsTrue();

    SetupParameter findFirstByIsBukaPeriodeIsFalse();

    @Query(value = "SELECT TO_CHAR(SYSDATE, 'DD-MM-YYYY') AS database_date FROM DUAL", nativeQuery = true)
    String getDatabaseDate();
}
