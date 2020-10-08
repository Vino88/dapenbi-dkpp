package com.dapenbi.dkpp.repository;

import com.dapenbi.dkpp.model.KategoriMutasi;
import com.dapenbi.dkpp.model.MutasiPensiun;
import org.hibernate.annotations.Parameter;
import com.dapenbi.dkpp.model.ViewModel.PensiunLamaMeninggalView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.text.StringCharacterIterator;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface MutasiPensiunRepository extends BaseRepository<MutasiPensiun, Long> {

    MutasiPensiun findFirstByNip(String nip);

    @Query("select mp from MutasiPensiun mp where mp.kategoriMutasi = ?1 and (lower(mp.nip) like lower(?2) or lower(mp.namaPeserta) like lower(?2))")
    Page<MutasiPensiun> findAllByKategoriMutasi(KategoriMutasi kategoriMutasi, String search, Pageable pageable);

    Page<MutasiPensiun> findAllByKategoriMutasiAndPeriodeMutasi(KategoriMutasi kategoriMutasi, String periodeMutasi, Pageable pageable);

    @Query(
            value = "select mp from MutasiPensiun mp where mp.kategoriMutasi = ?1 and mp.periodeMutasi=?2 and mp.nip like ?3"
    )
    Page<MutasiPensiun> findAllByKategoriMutasiAndPeriodeMutasiByNip(KategoriMutasi kategoriMutasi, String periodeMutasi, String Nip, Pageable pageable);

    @Query(
            value = "select mp from MutasiPensiun mp where mp.kategoriMutasi = ?1 and mp.periodeMutasi=?2 and mp.namaValidasi = 'Belum Validasi'"
    )
    Page<MutasiPensiun> findAllByKategoriMutasiAndPeriodeMutasiBelumValidasi(KategoriMutasi kategoriMutasi, String periodeMutasi, Pageable pageable);

    @Query(
            value = "select mp from MutasiPensiun mp where mp.kategoriMutasi = ?1 and mp.periodeMutasi=?2 and mp.namaValidasi = 'Belum Validasi' and mp.nip like ?3"
    )
    Page<MutasiPensiun> findAllByKategoriMutasiAndPeriodeMutasiByNipBelumValidasi(KategoriMutasi kategoriMutasi, String periodeMutasi, String Nip, Pageable pageable);


    @Query(
            value = "select * from table(cufn_cek_mps100persen_valid(?1, ?2, ?3, ?4, ?5, ?6, ?7))",
            nativeQuery = true
    )
    Map checkMps100PersenValid(
            Date tglLahirPeserta,
            Date tglKerjaPeserta,
            Date tglHentiPeserta,
            Date tglAwalBayarMP,
            Date tglLahirPenerima,
            String idKategoryPensiun,
            BigDecimal phdp
    );

    @Query(
            value = "select * from table(cufn_gen_sukselanak_otomatis(?1, ?2, ?3, ?4, ?5, ?6, ?7))",
            nativeQuery = true
    )
    Map genSukselanakOtomatis(
            String Nip,
            String IdPenerimaMPBaru,
            Date TglAwalBayar,
            Date TglAwalBayarbefore,
            Date tglLahirPenerima,
            Integer TypeSukel,
            Integer TypeMutasiOtomatis
    );

    @Query(
            value = "select * from table(cufn_cek_mps100persen_tunda(:nip, :tglMutasi, :periodeMutasi, :tglAwalBayarMP, :idKategoryPensiun, :isJatuhTempoBayar, :tglMeninggal))",
            nativeQuery = true
    )
    Map checkMps100PersenTunda(
            @Param("nip") String nip,
            @Param("tglMutasi") Date tglMutasi,
            @Param("periodeMutasi") String periodeMutasi,
            @Param("tglAwalBayarMP") Date tglAwalBayarMP,
            @Param("idKategoryPensiun") String idKategoryPensiun,
            @Param("isJatuhTempoBayar") Boolean isJatuhTempoBayar,
            @Param("tglMeninggal") Date tglMeninggalPeserta
    );

    @Query(
            value = "select * from table(cufn_cek_mps100persen_tunda(:nip, :tglMutasi, :periodeMutasi, :tglAwalBayarMP, :idKategoryPensiun, :isJatuhTempoBayar, null))",
            nativeQuery = true
    )
    Map checkMps100PersenTunda(
            @Param("nip") String nip,
            @Param("tglMutasi") Date tglMutasi,
            @Param("periodeMutasi") String periodeMutasi,
            @Param("tglAwalBayarMP") Date tglAwalBayarMP,
            @Param("idKategoryPensiun") String idKategoryPensiun,
            @Param("isJatuhTempoBayar") Boolean isJatuhTempoBayar
    );

    @Query(
            value = "select * from table(cufn_mp_simulation_2(?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9, ?10, ?11, ?12, ?13, ?14))",
            nativeQuery = true
    )
    Map mpSimulation(
            Date tglLahirPeserta,
            Date tglKerjaPeserta,
            Date tglHentiPeserta,
            Date tglDPHTPeserta,
            Long idKategoriPenerima,
            Date tglLahirPenerima,
            Date tglAwalBayarMP,
            String idKatergoryPensiun,
            Long idJenisMPS,
            Long idStatusKawin,
            Long idUsiaBayar,
            BigDecimal phdp,
            Date tglMutasi,
            String periodeMutasi
    );

    @Query(
            value = "CALL CUSP_MUTASI_KANTOR_BAYAR(?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9, ?10, ?11, ?12, ?13, ?14, ?15, ?16, ?17, ?18)",
            nativeQuery = true
    )
    Map processMutasiKantorBayar(Long role, String compName, String userName, String idMutasiPensiun, String kodeMutasi,
                                 String idKategoriMutasi, String periodeMutasi, Date tglMutasi, String nip, String namaPeserta,
                                 String idKantorBayar, String namaKantorBayar, String idKantorBayarBaru, String namaKantorBayarBaru,
                                 Long idKategoriCatatan, String keterangan, String idValidasi, String namaValidasi
    );

    @Query(
            value = "select * from table(cufn_mi_simulation(?1, ?2, ?3, ?4, ?5))",
            nativeQuery = true
    )
    Map cufnMiSimulation(
            String nip,
            BigDecimal phDPBaru,
            String tglBerlakuPhDPBaru,
            String tglMutasi,
            String periodeMutasi
    );

    //Penerima MP Meninggal Dunia
    @Query(
            value = "SELECT * FROM VW_MUTASI_PENS_LAMA_MENINGGAL mp where mp.periode_mutasi=?1 AND (mp.nip like ?2 OR mp.KODE_MUTASI like ?2 OR mp.PERIODE_MUTASI like ?2 OR mp.NAMA_PESERTA like ?2)",
            nativeQuery = true
    )
    List<PensiunLamaMeninggalView> findAllMutasiPensiunMeninggalDunia(String periodeMutasi, String searchParam);

    @Query(
            value = "select * from table(CUFN_MP_WAFAT_SIMULATION(?1, ?2, ?3, ?4))",
            nativeQuery = true
    )
    Map cufnMpWftSimulation(
            String nip,
            String periodeMutasi,
            String tglMeninggal,
            Long idStatusBayar
    );
    //--END Penerima MP Meninggal Dunia

    @Query(
            value = "select * from VW_MUTASI_PENSIUN_BARU mp where (mp.NIP like ?1 or lower(mp.NAMA_PESERTA) like lower(?1) or lower(mp.NAMA_PENERIMA_MP) like lower(?1))",
            nativeQuery = true
    )
    Page<MutasiPensiun> findAllMutasiPensiunBaru(String searchParam, Pageable pageable);

    @Query(
            value = "select * from VW_MUTASI_PENSIUN_BARU mp where mp.NAMA_VALIDASI = 'Belum Validasi' and (mp.NIP like ?1 or lower(mp.NAMA_PESERTA) like lower(?1) or lower(mp.NAMA_PENERIMA_MP) like lower(?1))",
            nativeQuery = true
    )
    Page<MutasiPensiun> findAllMutasiPensiunBaruBelumValidasi(String searchParam, Pageable pageable);

    @Query(
            value = "select * from VW_MUTASI_PENSIUN_TUNDA mp where (mp.NIP like ?1 or lower(mp.NAMA_PESERTA) like lower(?1) or lower(mp.NAMA_PENERIMA_MP) like lower(?1))",
            nativeQuery = true
    )
    Page<MutasiPensiun> findAllMutasiPensiunTunda(String searchParam, Pageable pageable);

    @Query(
            value = "select * from VW_MUTASI_PENSIUN_TUNDA mp where mp.NAMA_VALIDASI = 'Belum Validasi' and (mp.NIP like ?1 or lower(mp.NAMA_PESERTA) like lower(?1) or lower(mp.NAMA_PENERIMA_MP) like lower(?1))",
            nativeQuery = true
    )
    Page<MutasiPensiun> findAllMutasiPensiunTundaBelumValidasi(String searchParam, Pageable pageable);

    @Query(
            value = "select * from VW_MUTASI_PENSIUN_TUNDA mp where ID_VALIDASI = 2 AND (mp.NIP like ?1 or lower(mp.NAMA_PESERTA) like lower(?1) or lower(mp.NAMA_PENERIMA_MP) like lower(?1))",
            nativeQuery = true
    )
    Page<MutasiPensiun> findAllMutasiPensiunTundaDibayar(String searchParam, Pageable pageable);

    @Query(value="select mp from MutasiPensiun mp where ( mp.kategoriMutasi in ('06', '07') and (mp.nip like :searchParam or mp.namaPeserta like :searchParam or mp.kota like :searchParam or mp.alamatLengkap like :searchParam or mp.periodeMutasi like :searchParam or mp.namaPenerimaMP like :searchParam) )")
    Page<MutasiPensiun> findAllMutasiJandaDudaMenikahKembali(@Param("searchParam") String searchParam, Pageable pageable);


    @Query(
            value = "select * from table(CUFN_HITUNG_MPS100(?1,?2))",
            nativeQuery = true
    )
    Map cufnHitungMps100(
            String nip,
            String periodeMutasi
    );
}

