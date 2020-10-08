package com.dapenbi.dkpp.repository;

import com.dapenbi.dkpp.model.HerRegistrasi;
import org.springframework.data.jpa.repository.Query;

import java.util.Map;

public interface HerRegistrasiRepository extends BaseRepository<HerRegistrasi, Long> {

    @Query(
            value = "select * from table(cusp_create_master_her_regis( ?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9, ?10, ?11, ?12, ?13, ?14))",
            nativeQuery = true
    )
    Map cuspCreateMasterHerRegis(String roleId, String compName, String userName, String parTahun,
                                 Integer parJenisHer, String parJenisHerDesc, String parPeriodeTerdaftarPeserta, Integer parIdValidasi,
                                 String parNamaValidasi, String parIdCatatan, String parKategoriCatatan, String parKeterangan,
                                 String parStatusEksekusi, String parMsg);

    HerRegistrasi findByTahunHer(String tahunHer);
}
