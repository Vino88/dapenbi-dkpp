package com.dapenbi.dkpp.repository;

import com.dapenbi.dkpp.model.Kelurahan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface KelurahanRepository extends BaseRepository<Kelurahan, Long> {

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
            "WHERE kel.kode_pos = :kodePos", nativeQuery = true, name = "findAlamatByKodePos")
    List<Object[]> findAlamatByKodePos(@Param("kodePos") String kodePos);
}
