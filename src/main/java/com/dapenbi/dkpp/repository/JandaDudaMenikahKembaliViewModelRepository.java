package com.dapenbi.dkpp.repository;


import com.dapenbi.dkpp.model.JandaDudaMenikahKembaliViewModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface JandaDudaMenikahKembaliViewModelRepository extends BaseRepository<JandaDudaMenikahKembaliViewModel, Long> {
    JandaDudaMenikahKembaliViewModel findFirstByNip(String nip);
    JandaDudaMenikahKembaliViewModel findFirstByIdMutasiPensiunAndNip(Long idMutasiPensiun, String nip);

    @Query(value = "SELECT \n" +
            "  kel.id_kelurahan as id_kelurahan,\n" +
            "  kel.nama_kelurahan as nama_kelurahan, \n" +
            "  kel.kode_pos as kode_pos,\n" +
            "  kec.id_kecamatan as id_kecamatan,\n" +
            "  kec.nama_kecamatan as nama_kecamatan,\n" +
            "  kot.id_kota as id_kota,\n" +
            "  kot.nama_kota as nama_kota,\n" +
            "  prov.id_provinsi as id_provinsi,\n" +
            "  prov.nama_provinsi as nama_provinsi\n" +
            "FROM tbl_m_kelurahan kel\n" +
            "LEFT JOIN tbl_m_kecamatan kec ON kel.id_kecamatan = kec.id_kecamatan\n" +
            "LEFT JOIN tbl_m_kota kot ON kec.id_kota = kot.id_kota\n" +
            "LEFT JOIN tbl_m_provinsi prov ON kot.id_provinsi = prov.id_provinsi\n" +
            "WHERE kel.id_kelurahan = :idKelurahan", nativeQuery = true, name = "findAlamatByKelurahan")
    List<Object[]> findAlamatByKelurahan(@Param("idKelurahan") String idKelurahan);


    @Query(value = "SELECT * FROM TABLE ( cufn_mp_menikah_simulation(:nip,:periodeMutasi,:tglMenikah,:idStatusBayarBaru ) )", nativeQuery = true)
    Map cufnMenikahSimulation(@Param("nip") String nip, @Param("periodeMutasi") String periodeMutasi, @Param("tglMenikah") String tglMenikah, @Param("idStatusBayarBaru") Long idStatusBayarBaru);

    @Query(value = "SELECT mp FROM JandaDudaMenikahKembaliViewModel mp where mp.namaValidasi = 'Belum Validasi' and (lower(mp.nip) like lower(?1) or lower(mp.namaPeserta) like lower(?1) )")
    Page<JandaDudaMenikahKembaliViewModel> indexBelumValidasi(String searchParam, Pageable pageable);

}

