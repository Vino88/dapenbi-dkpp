package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dto.HistoryStatusMutasiDto;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "TBL_T_HISTORY_STATUS_MUTASI")
public class HistoryStatusMutasi extends BaseModel<HistoryStatusMutasiDto> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HISTORY_MUTASI_SEQ")
    @SequenceGenerator(sequenceName = "historyMutasi_seq", allocationSize = 1, name = "HISTORY_MUTASI_SEQ")
    @Column(name = "id_history_mutasi")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_mutasi_pensiun")
    private MutasiPensiun mutasiPensiun;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_validasi")
    private StatusValidasi statusValidasi;

    @Column(name = "nama_validasi", length = 50)
    private String namaValidasi;

    @Column(name = "kode_mutasi", length = 5)
    private String kodeMutasi;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_kategori_mutasi")
    private KategoriMutasi kategoriMutasi;

    @Column(name = "periode_mutasi", length = 6)
    private String periodeMutasi;

    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_mutasi")
    private Date tglMutasi;

    @Column(length = 10)
    private String nip;

    @Column(name = "nama_peserta", length = 50)
    private String namaPeserta;

    @Column(name = "jenis_kelamin_peserta")
    private Character jenisKelaminPeserta;

    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_lahir_peserta")
    private Date tglLahirPeserta;

    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_kerja_peserta")
    private Date tglKerjaPeserta;

    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_dptht_peserta")
    private Date tglDPHTPeserta;

    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_henti_kerja_peserta")
    private Date tglHentiKerjaPeserta;

    @Column(name = "tempat_meninggal_peserta", length = 50)
    private String tempatMeniggalPeserta;

    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_meninggal_peserta")
    private Date tglMeniggalPeserta;

    @Column(name = "tempat_lahir_peserta", length = 50)
    private String tempatLahirPeserta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_golongan")
    private Golongan golongan;

    @Column(name = "golongan_pangkat", length = 100)
    private String golonganPangkat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_agama")
    private Agama agama;

    @Column(name = "nama_agama", length = 20)
    private String namaAgama;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_kantor_bayar")
    private KantorBayar kantorBayar;

    @Column(name = "nama_kantor_bayar", length = 50)
    private String namaKantorBayar;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_predikat")
    private PredikatPemberhentian predikatPemberhentian;

    @Column(name = "nama_predikat", length = 50)
    private String namaPredikat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_henti")
    private AlasanHenti alasanHenti;

    @Column(name = "keterangan_henti", length = 50)
    private String keteranganHenti;

    @Column(name = "no_sp_bi",  length = 50)
    private String noSPBI;

    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_sp_bi")
    private Date tglSPBI;

    @Column(name = "no_sk_bi",  length = 50)
    private String noSKBI;

    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_sk_bi")
    private Date tglSKBI;

    @Column(name = "phdp_lama", precision = 20,  scale = 6)
    private BigDecimal phdpLama;

    @Column(name = "upah_veteran", precision = 20,  scale = 2)
    private BigDecimal upahVeteran;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_jenis_mps")
    private JenisMps jenisMps;

    @Column(name = "nama_mps", length = 50)
    private String namaMPS;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_kategori_pensiun")
    private KategoriPensiun kategoriPensiun;

    @Column(name = "nama_kategori_pensiun", length = 50)
    private String namaKategoriPensiun;

    @Column(name = "id_usia_bayar")
    private Long usiaBayar;

    @Column(name = "nama_usia_bayar", length = 50)
    private String namaUsiaBayar;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_status_bayar")
    private StatusBayar statusBayar;

    @Column(name = "status_bayar", length = 50)
    private String namaStatusBayar;

    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_tunda_jatuh_tempo")
    private Date tglTundaJatuhTempo;

    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_awal_bayar")
    private Date tglAwalBayar;

    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_mp_bulan_ke13")
    private Date tglMpBulanKe13;

    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_henti_bayar")
    private Date tglHentiBayar;

    @Column(name = "id_penerima_mp")
    private Long penerimaMP;

    @Column(name = "nama_penerima_mp", length = 50)
    private String namaPenerimaMP;

    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_lahir_penerima_mp")
    private Date tglLahirPenerimaMP;

    @Column(name = "jenis_kelamin_penerima_mp")
    private Character jenisKelaminPenerimaMP;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_kategori_penerima_mp")
    private KategoriPenerima kategoriPenerima;

    @Column(name = "nama_kategori_penerima_mp", length = 50)
    private String namaKategoriPenerimaMP;

    @Column(name = "no_sk_dapenbi",  length = 50)
    private String noSKDAPENBI;

    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_sk_dapenbi")
    private Date tglSKDAPENBI;

    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_meninggal_penerima_mp")
    private Date tglMeniggalPenerimaMP;

    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_menikahlagi_penerima_mp")
    private Date tglMenikahLagiPenerimaMP;

    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_usia_25t_penerima_mp")
    private Date tglUsia25PenerimaMP;

    @Column(name = "alamat_is_dalam_negeri")
    private boolean alamatIsDalamNegeri;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_provinsi")
    private Provinsi provinsi;

    @Column(name = "nama_provinsi",  length = 50)
    private String namaProvinsi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_kota_kab")
    private Kota kota;

    @Column(name = "nama_kota_kab",  length = 50)
    private String namaKota;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_kecamatan")
    private Kecamatan kecamatan;

    @Column(name = "nama_kecamatan",  length = 50)
    private String namaKecamatan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_kelurahan")
    private Kelurahan kelurahan;

    @Column(name = "nama_kelurahan",  length = 50)
    private String namaKelurahan;

    @Column(name = "kode_pos",  length = 10)
    private String kodePos;

    @Column(name = "alamat_lengkap",  length = 500)
    private String alamatLengkap;

    @Column(name = "rt",  length = 5)
    private String rt;

    @Column(name = "rw",  length = 5)
    private String rw;

    @Column(name = "id_negara",  length = 5)
    private Long negara;

    @Column(name = "nama_negara",  length = 50)
    private String namaNegara;

    @Column(name = "usia_saat_henti" , length = 6)
    private String usiaSaatHenti;

    @Column(name = "usia_saat_henti_bulat" , length = 4)
    private String usiaSaatHentiBulat;

    @Column(name = "usia_penerima_bayar" , length = 6)
    private String usiaPenerimaBayar;

    @Column(name = "usia_penerima_bayar_bulat" , length = 4)
    private String usiaPenerimaBayarBulat;

    @Column(name = "masa_kerja_henti" , length = 6)
    private String masaKerjaHenti;

    @Column(name = "masa_kerja_henti_bulat" , length = 4)
    private String masaKerjaHentiBulat;

    @Column(name = "masa_kerja_tambahan" , length = 6)
    private String masaKerjaTambahan;

    @Column(name = "masa_kerja_tambahan_bulat" , length = 4)
    private String masaKerjaTambahanBulat;

    @Column(name = "masa_kerja_veteran" , length = 6)
    private String masaKerjaVeteran;

    @Column(name = "masa_kerja_veteran_bulat" , length = 4)
    private String masaKerjaVeteranBulat;

    @Column(name = "total_masa_kerja" , length = 6)
    private String totalMasaKerja;

    @Column(name = "total_masa_kerja_bulat" , length = 4)
    private String totalMasaKerjaBulat;

    @Column(name = "masa_kerja_mp" , length = 4)
    private String masaKerjaMP;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_faktor_fpr")
    private FaktorFPR faktorFPR;

    @Column(name = "nama_faktor_fpr" , length = 10)
    private String namaFaktorFPR;

    @Column(name = "nilai_fpr" , precision = 10, scale = 8)
    private BigDecimal nilaiFPR;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_faktor_fs")
    private FaktorFs faktorFS;

    @Column(name = "nama_faktor_fs" , length = 10)
    private String namaFaktorFS;

    @Column(name = "faktor_fs" , length = 20)
    private String faktorFs;

    @Column(name = "nilai_fs" , precision = 10, scale = 8)
    private BigDecimal nilaiFS;

    @Column(name = "mps_20persen_lama" , precision = 20, scale = 6)
    private BigDecimal mps20PersenLama;

    @Column(name = "mps_10juta_lama" , precision = 20, scale = 6)
    private BigDecimal mps10JutaLama;

    @Column(name = "mps_100persen_lama" , precision = 15, scale = 6)
    private BigDecimal mps100PersenLama;

    @Column(name = "mp_perbulan_rumus_lama" , precision = 15, scale = 6)
    private BigDecimal mpPerbulanRumusLama;

    @Column(name = "mp_perbulan_20persen_lama" , precision = 15, scale = 6)
    private BigDecimal mpPerbulan20PersenLama;

    @Column(name = "mp_perbulan_10juta_lama" , precision = 15, scale = 6)
    private Long mpPerbulan10JutaLama;

    @Column(name = "mpyd_lama" , precision = 15, scale = 6)
    private BigDecimal mpydLama;

    @Column(name = "mp_bulan13" , precision = 15, scale = 6)
    private BigDecimal mpBulan13;

    @Column(name = "mps_100persen_bulat_lama" , precision = 20, scale = 6)
    private BigDecimal mps100PersenBulatLama;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_suskel")
    private Suskel suskel;

    @Column(name = "nama_suskel" , length = 50)
    private String namaSuskel;

    @Column(name = "phdp_baru" , precision = 15, scale = 6)
    private BigDecimal phdpBaru;

    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_mulai_berlaku_phdp_baru")
    private Date tglMulaiBerlakuPHDPBaru;

    @Column(name = "kurang_bayar_mpyd" , precision = 15, scale = 6)
    private BigDecimal kurangBayarMPYD;

    @Column(name = "mps_20persen_baru" , precision = 20, scale = 6)
    private BigDecimal mps20PersenBaru;

    @Column(name = "mps_10juta_baru" , precision = 20, scale = 6)
    private BigDecimal mps10JutaBaru;

    @Column(name = "mps_100persen_baru" , precision = 15, scale = 6)
    private BigDecimal mps100PersenBaru;

    @Column(name = "mp_perbulan_rumus_baru" , precision = 15, scale = 6)
    private BigDecimal mpPerbulanRumusBaru;

    @Column(name = "mp_perbulan_20persen_baru" , precision = 15, scale = 6)
    private BigDecimal mpPerbulan20PersenBaru;

    @Column(name = "mp_perbulan_10juta_baru" , precision = 20, scale = 6)
    private BigDecimal mpPerbulan10JutaBaru;

    @Column(name = "mps_100persen_bulat_baru" , precision = 15, scale = 6)
    private BigDecimal mps100PersenBulatBaru;

    @Column(name = "mpyd_baru" , precision = 15, scale = 6)
    private BigDecimal mpydBaru;

    @Column(name = "kurang_bayar_mps20persen", precision = 15, scale = 6)
    private BigDecimal kurangBayarMPS20Persen;

    @Column(name = "kurang_bayar_mps10juta", precision = 15, scale = 6)
    private BigDecimal kurangBayarMPS10Juta;

    @Column(name = "kurang_bayar_mps100persen", precision = 15, scale = 6)
    private BigDecimal kurangBayarMPS100Persen;

    @Column(name = "kurang_bayar_mp_rumus", precision = 15, scale = 6)
    private BigDecimal kurangBayarMPRumus;

    @Column(name = "is_jadi_hutang")
    private Boolean isJadiHutang;

    @Column(name = "lebih_bayar_mps20persen", precision = 15, scale = 6)
    private BigDecimal lebihBayarMPS20Persen;

    @Column(name = "lebih_bayar_mps10juta", precision = 15, scale = 6)
    private BigDecimal lebihBayarMPS10Juta;

    @Column(name = "lebih_bayar_mps100persen", precision = 15, scale = 6)
    private BigDecimal lebihBayarMPS100Persen;

    @Column(name = "lebih_bayar_mp_rumus", precision = 15, scale = 6)
    private BigDecimal lebihBayarMPRumus;

    @Column(name = "lebih_bayar_mpyd", precision = 15, scale = 6)
    private BigDecimal lebihBayarMPYD;

    @Column(name = "is_jadi_piutang")
    private Boolean isJadiPiutang;

    @Column(name = "id_kategori_catatan")
    private Long kategoryCatatan;

    @Column(name = "keterangan" , length = 500)
    private String keterangan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_status_kawin_penerima_mp")
    private StatusKawin statusKawin;

    @Column(name = "nama_status_kawin_penerima_mp" , length = 50)
    private String namaStatusKawinPenerimaMP;

    @Column(name = "is_rekening_dapenbi")
    private Boolean isRekeningDAPENBI;

    @Column(name = "id_bank")
    private Long bank;

    @Column(name = "jenis_bank" , length = 20)
    private String jenisBank;

    @Column(name = "nama_cabang_bank" , length = 50)
    private String namaCabangBank;

    @Column(name = "nama_pada_rek_bank" , length = 50)
    private String namaPadaRekBank;

    @Column(name = "nomor_rekening" , length = 50)
    private String nomorRekening;

    @Column(name = "no_hp" , length = 50)
    private String noHP;

    @Column(name = "email" , length = 50)
    private String email;

    @Column(name = "keterangan_otomatis" , length = 500)
    private String keteranganOtomatis;

    @Column(name = "user_validasi" , length = 100)
    private String userValidasi;

    @Column(name = "total_masa_kerja_adj" , length = 6)
    private String totalMasaKerjaAdj;

    @Column(name = "total_masa_kerja_bulat_adj" , length = 4)
    private String totalMasaKerjaBulatAdj;

    @Column(name = "mp_bulan13_baru", precision = 20, scale = 2)
    private BigDecimal mpBulan13Baru;

    @Column(name = "rapel_mpyd_kurang", precision = 20, scale = 2)
    private BigDecimal rapelMPYDKurang;

    @Column(name = "rapel_mpyd_lebih", precision = 20, scale = 2)
    private BigDecimal rapelMPYDLebih;

    @Column(name = "no_tlp" , length = 20)
    private String noTlp;

    @Column(name = "id_penerima_mp_baru" , length = 100)
    private String idPenerimaMPBaru;

    @Column(name = "nama_penerima_mp_baru" , length = 100)
    private String namaPenerimaMPBaru;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_kategori_penerima_mp_baru")
    private KategoriPenerima kategoriPenerimaBaru;

    @Column(name = "nama_kategori_penerima_mp_baru", length = 50)
    private String namaKategoriPenerimaMPBaru;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_suskel_baru")
    private Suskel suskelBaru;

    @Column(name = "nama_suskel_baru" , length = 50)
    private String namaSuskelBaru;

    @Column(name = "lebih_bayar_jml_bulan" , scale = 20, precision = 2)
    private BigDecimal lebihBayarJmlBulan;

    @Column(name = "lebih_bayar_nominal" , scale = 20, precision = 2)
    private BigDecimal lebihBayarNominal;

    @Column(name = "nominal_terbayar" , scale = 20, precision = 2)
    private BigDecimal nominalTerbayar;

    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_inf_wft_penerimamp_lama")
    private Date tglInfWftPenerimaMPLama;

    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_lahir_penerima_mp_baru")
    private Date tglLahirPenerimaMPBaru;

    @Column(name = "jenis_kelamin_penerima_mp_baru")
    private Character jenisKelaminPenerimaMPBaru;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_kawin_penerimamp_baru")
    private StatusKawin kawinPenerimaMPBaru;

    @Column(name = "nama_kawin_penerimamp_baru", length = 20)
    private String namaKawinPenerimaMPBaru;

    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_inf_nikah_penerimamp_lama")
    private Date tglInfNikashPenerimaMPLama;

    @Column(name = "lebih_bayar_jml_bulan_13")
    private Long lebihBayarJmlBulan13;

    @Column(name = "lebih_bayar_nominal_13", scale = 20, precision = 2)
    private Long lebihBayarNominal13;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_kantor_bayar_baru")
    private KantorBayar kantorBayarBaru;

    @Column(name = "nama_kantor_bayar_baru", length = 50)
    private String namaKantorBayarBaru;

    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_usia_25t_penerima_mp_baru")
    private Date getTglUsia25TPenerimaMPBaru;

    @Column(name = "TGL_PERMOHONAN_MPS100", length = 20)
    private String tglPermohonanMPS100;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alasan_mps_100")
    private AlasanMps100 alasanMps100;

    @Column(name = "nama_alasan_mps_100", length = 500)
    private String namaAlasanMps100;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MutasiPensiun getMutasiPensiun() {
        return mutasiPensiun;
    }

    public void setMutasiPensiun(MutasiPensiun mutasiPensiun) {
        this.mutasiPensiun = mutasiPensiun;
    }

    public StatusValidasi getStatusValidasi() {
        return statusValidasi;
    }

    public void setStatusValidasi(StatusValidasi statusValidasi) {
        this.statusValidasi = statusValidasi;
    }

    public String getNamaValidasi() {
        return namaValidasi;
    }

    public void setNamaValidasi(String namaValidasi) {
        this.namaValidasi = namaValidasi;
    }

    public String getKodeMutasi() {
        return kodeMutasi;
    }

    public void setKodeMutasi(String kodeMutasi) {
        this.kodeMutasi = kodeMutasi;
    }

    public KategoriMutasi getKategoriMutasi() {
        return kategoriMutasi;
    }

    public void setKategoriMutasi(KategoriMutasi kategoriMutasi) {
        this.kategoriMutasi = kategoriMutasi;
    }

    public String getPeriodeMutasi() {
        return periodeMutasi;
    }

    public void setPeriodeMutasi(String periodeMutasi) {
        this.periodeMutasi = periodeMutasi;
    }

    public Date getTglMutasi() {
        return tglMutasi;
    }

    public void setTglMutasi(Date tglMutasi) {
        this.tglMutasi = tglMutasi;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNamaPeserta() {
        return namaPeserta;
    }

    public void setNamaPeserta(String namaPeserta) {
        this.namaPeserta = namaPeserta;
    }

    public Character getJenisKelaminPeserta() {
        return jenisKelaminPeserta;
    }

    public void setJenisKelaminPeserta(Character jenisKelaminPeserta) {
        this.jenisKelaminPeserta = jenisKelaminPeserta;
    }

    public Date getTglLahirPeserta() {
        return tglLahirPeserta;
    }

    public void setTglLahirPeserta(Date tglLahirPeserta) {
        this.tglLahirPeserta = tglLahirPeserta;
    }

    public Date getTglKerjaPeserta() {
        return tglKerjaPeserta;
    }

    public void setTglKerjaPeserta(Date tglKerjaPeserta) {
        this.tglKerjaPeserta = tglKerjaPeserta;
    }

    public Date getTglDPHTPeserta() {
        return tglDPHTPeserta;
    }

    public void setTglDPHTPeserta(Date tglDPHTPeserta) {
        this.tglDPHTPeserta = tglDPHTPeserta;
    }

    public Date getTglHentiKerjaPeserta() {
        return tglHentiKerjaPeserta;
    }

    public void setTglHentiKerjaPeserta(Date tglHentiKerjaPeserta) {
        this.tglHentiKerjaPeserta = tglHentiKerjaPeserta;
    }

    public String getTempatMeniggalPeserta() {
        return tempatMeniggalPeserta;
    }

    public void setTempatMeniggalPeserta(String tempatMeniggalPeserta) {
        this.tempatMeniggalPeserta = tempatMeniggalPeserta;
    }

    public Date getTglMeniggalPeserta() {
        return tglMeniggalPeserta;
    }

    public void setTglMeniggalPeserta(Date tglMeniggalPeserta) {
        this.tglMeniggalPeserta = tglMeniggalPeserta;
    }

    public String getTempatLahirPeserta() {
        return tempatLahirPeserta;
    }

    public void setTempatLahirPeserta(String tempatLahirPeserta) {
        this.tempatLahirPeserta = tempatLahirPeserta;
    }

    public Golongan getGolongan() {
        return golongan;
    }

    public void setGolongan(Golongan golongan) {
        this.golongan = golongan;
    }

    public String getGolonganPangkat() {
        return golonganPangkat;
    }

    public void setGolonganPangkat(String golonganPangkat) {
        this.golonganPangkat = golonganPangkat;
    }

    public Agama getAgama() {
        return agama;
    }

    public void setAgama(Agama agama) {
        this.agama = agama;
    }

    public String getNamaAgama() {
        return namaAgama;
    }

    public void setNamaAgama(String namaAgama) {
        this.namaAgama = namaAgama;
    }

    public KantorBayar getKantorBayar() {
        return kantorBayar;
    }

    public void setKantorBayar(KantorBayar kantorBayar) {
        this.kantorBayar = kantorBayar;
    }

    public String getNamaKantorBayar() {
        return namaKantorBayar;
    }

    public void setNamaKantorBayar(String namaKantorBayar) {
        this.namaKantorBayar = namaKantorBayar;
    }

    public PredikatPemberhentian getPredikatPemberhentian() {
        return predikatPemberhentian;
    }

    public void setPredikatPemberhentian(PredikatPemberhentian predikatPemberhentian) {
        this.predikatPemberhentian = predikatPemberhentian;
    }

    public String getNamaPredikat() {
        return namaPredikat;
    }

    public void setNamaPredikat(String namaPredikat) {
        this.namaPredikat = namaPredikat;
    }

    public AlasanHenti getAlasanHenti() {
        return alasanHenti;
    }

    public void setAlasanHenti(AlasanHenti alasanHenti) {
        this.alasanHenti = alasanHenti;
    }

    public String getKeteranganHenti() {
        return keteranganHenti;
    }

    public void setKeteranganHenti(String keteranganHenti) {
        this.keteranganHenti = keteranganHenti;
    }

    public String getNoSPBI() {
        return noSPBI;
    }

    public void setNoSPBI(String noSPBI) {
        this.noSPBI = noSPBI;
    }

    public Date getTglSPBI() {
        return tglSPBI;
    }

    public void setTglSPBI(Date tglSPBI) {
        this.tglSPBI = tglSPBI;
    }

    public String getNoSKBI() {
        return noSKBI;
    }

    public void setNoSKBI(String noSKBI) {
        this.noSKBI = noSKBI;
    }

    public Date getTglSKBI() {
        return tglSKBI;
    }

    public void setTglSKBI(Date tglSKBI) {
        this.tglSKBI = tglSKBI;
    }

    public BigDecimal getPhdpLama() {
        return phdpLama;
    }

    public void setPhdpLama(BigDecimal phdpLama) {
        this.phdpLama = phdpLama;
    }

    public BigDecimal getUpahVeteran() {
        return upahVeteran;
    }

    public void setUpahVeteran(BigDecimal upahVeteran) {
        this.upahVeteran = upahVeteran;
    }

    public JenisMps getJenisMps() {
        return jenisMps;
    }

    public void setJenisMps(JenisMps jenisMps) {
        this.jenisMps = jenisMps;
    }

    public String getNamaMPS() {
        return namaMPS;
    }

    public void setNamaMPS(String namaMPS) {
        this.namaMPS = namaMPS;
    }

    public KategoriPensiun getKategoriPensiun() {
        return kategoriPensiun;
    }

    public void setKategoriPensiun(KategoriPensiun kategoriPensiun) {
        this.kategoriPensiun = kategoriPensiun;
    }

    public String getNamaKategoriPensiun() {
        return namaKategoriPensiun;
    }

    public void setNamaKategoriPensiun(String namaKategoriPensiun) {
        this.namaKategoriPensiun = namaKategoriPensiun;
    }

    public Long getUsiaBayar() {
        return usiaBayar;
    }

    public void setUsiaBayar(Long usiaBayar) {
        this.usiaBayar = usiaBayar;
    }

    public String getNamaUsiaBayar() {
        return namaUsiaBayar;
    }

    public void setNamaUsiaBayar(String namaUsiaBayar) {
        this.namaUsiaBayar = namaUsiaBayar;
    }

    public StatusBayar getStatusBayar() {
        return statusBayar;
    }

    public void setStatusBayar(StatusBayar statusBayar) {
        this.statusBayar = statusBayar;
    }

    public String getNamaStatusBayar() {
        return namaStatusBayar;
    }

    public void setNamaStatusBayar(String namaStatusBayar) {
        this.namaStatusBayar = namaStatusBayar;
    }

    public Date getTglTundaJatuhTempo() {
        return tglTundaJatuhTempo;
    }

    public void setTglTundaJatuhTempo(Date tglTundaJatuhTempo) {
        this.tglTundaJatuhTempo = tglTundaJatuhTempo;
    }

    public Date getTglAwalBayar() {
        return tglAwalBayar;
    }

    public void setTglAwalBayar(Date tglAwalBayar) {
        this.tglAwalBayar = tglAwalBayar;
    }

    public Date getTglMpBulanKe13() {
        return tglMpBulanKe13;
    }

    public void setTglMpBulanKe13(Date tglMpBulanKe13) {
        this.tglMpBulanKe13 = tglMpBulanKe13;
    }

    public Date getTglHentiBayar() {
        return tglHentiBayar;
    }

    public void setTglHentiBayar(Date tglHentiBayar) {
        this.tglHentiBayar = tglHentiBayar;
    }

    public Long getPenerimaMP() {
        return penerimaMP;
    }

    public void setPenerimaMP(Long penerimaMP) {
        this.penerimaMP = penerimaMP;
    }

    public String getNamaPenerimaMP() {
        return namaPenerimaMP;
    }

    public void setNamaPenerimaMP(String namaPenerimaMP) {
        this.namaPenerimaMP = namaPenerimaMP;
    }

    public Date getTglLahirPenerimaMP() {
        return tglLahirPenerimaMP;
    }

    public void setTglLahirPenerimaMP(Date tglLahirPenerimaMP) {
        this.tglLahirPenerimaMP = tglLahirPenerimaMP;
    }

    public Character getJenisKelaminPenerimaMP() {
        return jenisKelaminPenerimaMP;
    }

    public void setJenisKelaminPenerimaMP(Character jenisKelaminPenerimaMP) {
        this.jenisKelaminPenerimaMP = jenisKelaminPenerimaMP;
    }

    public KategoriPenerima getKategoriPenerima() {
        return kategoriPenerima;
    }

    public void setKategoriPenerima(KategoriPenerima kategoriPenerima) {
        this.kategoriPenerima = kategoriPenerima;
    }

    public String getNamaKategoriPenerimaMP() {
        return namaKategoriPenerimaMP;
    }

    public void setNamaKategoriPenerimaMP(String namaKategoriPenerimaMP) {
        this.namaKategoriPenerimaMP = namaKategoriPenerimaMP;
    }

    public String getNoSKDAPENBI() {
        return noSKDAPENBI;
    }

    public void setNoSKDAPENBI(String noSKDAPENBI) {
        this.noSKDAPENBI = noSKDAPENBI;
    }

    public Date getTglSKDAPENBI() {
        return tglSKDAPENBI;
    }

    public void setTglSKDAPENBI(Date tglSKDAPENBI) {
        this.tglSKDAPENBI = tglSKDAPENBI;
    }

    public Date getTglMeniggalPenerimaMP() {
        return tglMeniggalPenerimaMP;
    }

    public void setTglMeniggalPenerimaMP(Date tglMeniggalPenerimaMP) {
        this.tglMeniggalPenerimaMP = tglMeniggalPenerimaMP;
    }

    public Date getTglMenikahLagiPenerimaMP() {
        return tglMenikahLagiPenerimaMP;
    }

    public void setTglMenikahLagiPenerimaMP(Date tglMenikahLagiPenerimaMP) {
        this.tglMenikahLagiPenerimaMP = tglMenikahLagiPenerimaMP;
    }

    public Date getTglUsia25PenerimaMP() {
        return tglUsia25PenerimaMP;
    }

    public void setTglUsia25PenerimaMP(Date tglUsia25PenerimaMP) {
        this.tglUsia25PenerimaMP = tglUsia25PenerimaMP;
    }

    public boolean isAlamatIsDalamNegeri() {
        return alamatIsDalamNegeri;
    }

    public void setAlamatIsDalamNegeri(boolean alamatIsDalamNegeri) {
        this.alamatIsDalamNegeri = alamatIsDalamNegeri;
    }

    public Provinsi getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(Provinsi provinsi) {
        this.provinsi = provinsi;
    }

    public String getNamaProvinsi() {
        return namaProvinsi;
    }

    public void setNamaProvinsi(String namaProvinsi) {
        this.namaProvinsi = namaProvinsi;
    }

    public Kota getKota() {
        return kota;
    }

    public void setKota(Kota kota) {
        this.kota = kota;
    }

    public String getNamaKota() {
        return namaKota;
    }

    public void setNamaKota(String namaKota) {
        this.namaKota = namaKota;
    }

    public Kecamatan getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(Kecamatan kecamatan) {
        this.kecamatan = kecamatan;
    }

    public String getNamaKecamatan() {
        return namaKecamatan;
    }

    public void setNamaKecamatan(String namaKecamatan) {
        this.namaKecamatan = namaKecamatan;
    }

    public Kelurahan getKelurahan() {
        return kelurahan;
    }

    public void setKelurahan(Kelurahan kelurahan) {
        this.kelurahan = kelurahan;
    }

    public String getNamaKelurahan() {
        return namaKelurahan;
    }

    public void setNamaKelurahan(String namaKelurahan) {
        this.namaKelurahan = namaKelurahan;
    }

    public String getKodePos() {
        return kodePos;
    }

    public void setKodePos(String kodePos) {
        this.kodePos = kodePos;
    }

    public String getAlamatLengkap() {
        return alamatLengkap;
    }

    public void setAlamatLengkap(String alamatLengkap) {
        this.alamatLengkap = alamatLengkap;
    }

    public String getRt() {
        return rt;
    }

    public void setRt(String rt) {
        this.rt = rt;
    }

    public String getRw() {
        return rw;
    }

    public void setRw(String rw) {
        this.rw = rw;
    }

    public Long getNegara() {
        return negara;
    }

    public void setNegara(Long negara) {
        this.negara = negara;
    }

    public String getNamaNegara() {
        return namaNegara;
    }

    public void setNamaNegara(String namaNegara) {
        this.namaNegara = namaNegara;
    }

    public String getUsiaSaatHenti() {
        return usiaSaatHenti;
    }

    public void setUsiaSaatHenti(String usiaSaatHenti) {
        this.usiaSaatHenti = usiaSaatHenti;
    }

    public String getUsiaSaatHentiBulat() {
        return usiaSaatHentiBulat;
    }

    public void setUsiaSaatHentiBulat(String usiaSaatHentiBulat) {
        this.usiaSaatHentiBulat = usiaSaatHentiBulat;
    }

    public String getUsiaPenerimaBayar() {
        return usiaPenerimaBayar;
    }

    public void setUsiaPenerimaBayar(String usiaPenerimaBayar) {
        this.usiaPenerimaBayar = usiaPenerimaBayar;
    }

    public String getUsiaPenerimaBayarBulat() {
        return usiaPenerimaBayarBulat;
    }

    public void setUsiaPenerimaBayarBulat(String usiaPenerimaBayarBulat) {
        this.usiaPenerimaBayarBulat = usiaPenerimaBayarBulat;
    }

    public String getMasaKerjaHenti() {
        return masaKerjaHenti;
    }

    public void setMasaKerjaHenti(String masaKerjaHenti) {
        this.masaKerjaHenti = masaKerjaHenti;
    }

    public String getMasaKerjaHentiBulat() {
        return masaKerjaHentiBulat;
    }

    public void setMasaKerjaHentiBulat(String masaKerjaHentiBulat) {
        this.masaKerjaHentiBulat = masaKerjaHentiBulat;
    }

    public String getMasaKerjaTambahan() {
        return masaKerjaTambahan;
    }

    public void setMasaKerjaTambahan(String masaKerjaTambahan) {
        this.masaKerjaTambahan = masaKerjaTambahan;
    }

    public String getMasaKerjaTambahanBulat() {
        return masaKerjaTambahanBulat;
    }

    public void setMasaKerjaTambahanBulat(String masaKerjaTambahanBulat) {
        this.masaKerjaTambahanBulat = masaKerjaTambahanBulat;
    }

    public String getMasaKerjaVeteran() {
        return masaKerjaVeteran;
    }

    public void setMasaKerjaVeteran(String masaKerjaVeteran) {
        this.masaKerjaVeteran = masaKerjaVeteran;
    }

    public String getMasaKerjaVeteranBulat() {
        return masaKerjaVeteranBulat;
    }

    public void setMasaKerjaVeteranBulat(String masaKerjaVeteranBulat) {
        this.masaKerjaVeteranBulat = masaKerjaVeteranBulat;
    }

    public String getTotalMasaKerja() {
        return totalMasaKerja;
    }

    public void setTotalMasaKerja(String totalMasaKerja) {
        this.totalMasaKerja = totalMasaKerja;
    }

    public String getTotalMasaKerjaBulat() {
        return totalMasaKerjaBulat;
    }

    public void setTotalMasaKerjaBulat(String totalMasaKerjaBulat) {
        this.totalMasaKerjaBulat = totalMasaKerjaBulat;
    }

    public String getMasaKerjaMP() {
        return masaKerjaMP;
    }

    public void setMasaKerjaMP(String masaKerjaMP) {
        this.masaKerjaMP = masaKerjaMP;
    }

    public FaktorFPR getFaktorFPR() {
        return faktorFPR;
    }

    public void setFaktorFPR(FaktorFPR faktorFPR) {
        this.faktorFPR = faktorFPR;
    }

    public String getNamaFaktorFPR() {
        return namaFaktorFPR;
    }

    public void setNamaFaktorFPR(String namaFaktorFPR) {
        this.namaFaktorFPR = namaFaktorFPR;
    }

    public BigDecimal getNilaiFPR() {
        return nilaiFPR;
    }

    public void setNilaiFPR(BigDecimal nilaiFPR) {
        this.nilaiFPR = nilaiFPR;
    }

    public FaktorFs getFaktorFS() {
        return faktorFS;
    }

    public void setFaktorFS(FaktorFs faktorFS) {
        this.faktorFS = faktorFS;
    }

    public String getNamaFaktorFS() {
        return namaFaktorFS;
    }

    public void setNamaFaktorFS(String namaFaktorFS) {
        this.namaFaktorFS = namaFaktorFS;
    }

    public String getFaktorFs() {
        return faktorFs;
    }

    public void setFaktorFs(String faktorFs) {
        this.faktorFs = faktorFs;
    }

    public BigDecimal getNilaiFS() {
        return nilaiFS;
    }

    public void setNilaiFS(BigDecimal nilaiFS) {
        this.nilaiFS = nilaiFS;
    }

    public BigDecimal getMps20PersenLama() {
        return mps20PersenLama;
    }

    public void setMps20PersenLama(BigDecimal mps20PersenLama) {
        this.mps20PersenLama = mps20PersenLama;
    }

    public BigDecimal getMps10JutaLama() {
        return mps10JutaLama;
    }

    public void setMps10JutaLama(BigDecimal mps10JutaLama) {
        this.mps10JutaLama = mps10JutaLama;
    }

    public BigDecimal getMps100PersenLama() {
        return mps100PersenLama;
    }

    public void setMps100PersenLama(BigDecimal mps100PersenLama) {
        this.mps100PersenLama = mps100PersenLama;
    }

    public BigDecimal getMpPerbulanRumusLama() {
        return mpPerbulanRumusLama;
    }

    public void setMpPerbulanRumusLama(BigDecimal mpPerbulanRumusLama) {
        this.mpPerbulanRumusLama = mpPerbulanRumusLama;
    }

    public BigDecimal getMpPerbulan20PersenLama() {
        return mpPerbulan20PersenLama;
    }

    public void setMpPerbulan20PersenLama(BigDecimal mpPerbulan20PersenLama) {
        this.mpPerbulan20PersenLama = mpPerbulan20PersenLama;
    }

    public Long getMpPerbulan10JutaLama() {
        return mpPerbulan10JutaLama;
    }

    public void setMpPerbulan10JutaLama(Long mpPerbulan10JutaLama) {
        this.mpPerbulan10JutaLama = mpPerbulan10JutaLama;
    }

    public BigDecimal getMpydLama() {
        return mpydLama;
    }

    public void setMpydLama(BigDecimal mpydLama) {
        this.mpydLama = mpydLama;
    }

    public BigDecimal getMpBulan13() {
        return mpBulan13;
    }

    public void setMpBulan13(BigDecimal mpBulan13) {
        this.mpBulan13 = mpBulan13;
    }

    public BigDecimal getMps100PersenBulatLama() {
        return mps100PersenBulatLama;
    }

    public void setMps100PersenBulatLama(BigDecimal mps100PersenBulatLama) {
        this.mps100PersenBulatLama = mps100PersenBulatLama;
    }

    public Suskel getSuskel() {
        return suskel;
    }

    public void setSuskel(Suskel suskel) {
        this.suskel = suskel;
    }

    public String getNamaSuskel() {
        return namaSuskel;
    }

    public void setNamaSuskel(String namaSuskel) {
        this.namaSuskel = namaSuskel;
    }

    public BigDecimal getPhdpBaru() {
        return phdpBaru;
    }

    public void setPhdpBaru(BigDecimal phdpBaru) {
        this.phdpBaru = phdpBaru;
    }

    public Date getTglMulaiBerlakuPHDPBaru() {
        return tglMulaiBerlakuPHDPBaru;
    }

    public void setTglMulaiBerlakuPHDPBaru(Date tglMulaiBerlakuPHDPBaru) {
        this.tglMulaiBerlakuPHDPBaru = tglMulaiBerlakuPHDPBaru;
    }

    public BigDecimal getKurangBayarMPYD() {
        return kurangBayarMPYD;
    }

    public void setKurangBayarMPYD(BigDecimal kurangBayarMPYD) {
        this.kurangBayarMPYD = kurangBayarMPYD;
    }

    public BigDecimal getMps20PersenBaru() {
        return mps20PersenBaru;
    }

    public void setMps20PersenBaru(BigDecimal mps20PersenBaru) {
        this.mps20PersenBaru = mps20PersenBaru;
    }

    public BigDecimal getMps10JutaBaru() {
        return mps10JutaBaru;
    }

    public void setMps10JutaBaru(BigDecimal mps10JutaBaru) {
        this.mps10JutaBaru = mps10JutaBaru;
    }

    public BigDecimal getMps100PersenBaru() {
        return mps100PersenBaru;
    }

    public void setMps100PersenBaru(BigDecimal mps100PersenBaru) {
        this.mps100PersenBaru = mps100PersenBaru;
    }

    public BigDecimal getMpPerbulanRumusBaru() {
        return mpPerbulanRumusBaru;
    }

    public void setMpPerbulanRumusBaru(BigDecimal mpPerbulanRumusBaru) {
        this.mpPerbulanRumusBaru = mpPerbulanRumusBaru;
    }

    public BigDecimal getMpPerbulan20PersenBaru() {
        return mpPerbulan20PersenBaru;
    }

    public void setMpPerbulan20PersenBaru(BigDecimal mpPerbulan20PersenBaru) {
        this.mpPerbulan20PersenBaru = mpPerbulan20PersenBaru;
    }

    public BigDecimal getMpPerbulan10JutaBaru() {
        return mpPerbulan10JutaBaru;
    }

    public void setMpPerbulan10JutaBaru(BigDecimal mpPerbulan10JutaBaru) {
        this.mpPerbulan10JutaBaru = mpPerbulan10JutaBaru;
    }

    public BigDecimal getMps100PersenBulatBaru() {
        return mps100PersenBulatBaru;
    }

    public void setMps100PersenBulatBaru(BigDecimal mps100PersenBulatBaru) {
        this.mps100PersenBulatBaru = mps100PersenBulatBaru;
    }

    public BigDecimal getMpydBaru() {
        return mpydBaru;
    }

    public void setMpydBaru(BigDecimal mpydBaru) {
        this.mpydBaru = mpydBaru;
    }

    public BigDecimal getKurangBayarMPS20Persen() {
        return kurangBayarMPS20Persen;
    }

    public void setKurangBayarMPS20Persen(BigDecimal kurangBayarMPS20Persen) {
        this.kurangBayarMPS20Persen = kurangBayarMPS20Persen;
    }

    public BigDecimal getKurangBayarMPS10Juta() {
        return kurangBayarMPS10Juta;
    }

    public void setKurangBayarMPS10Juta(BigDecimal kurangBayarMPS10Juta) {
        this.kurangBayarMPS10Juta = kurangBayarMPS10Juta;
    }

    public BigDecimal getKurangBayarMPS100Persen() {
        return kurangBayarMPS100Persen;
    }

    public void setKurangBayarMPS100Persen(BigDecimal kurangBayarMPS100Persen) {
        this.kurangBayarMPS100Persen = kurangBayarMPS100Persen;
    }

    public BigDecimal getKurangBayarMPRumus() {
        return kurangBayarMPRumus;
    }

    public void setKurangBayarMPRumus(BigDecimal kurangBayarMPRumus) {
        this.kurangBayarMPRumus = kurangBayarMPRumus;
    }

    public Boolean getJadiHutang() {
        return isJadiHutang;
    }

    public void setJadiHutang(Boolean jadiHutang) {
        isJadiHutang = jadiHutang;
    }

    public BigDecimal getLebihBayarMPS20Persen() {
        return lebihBayarMPS20Persen;
    }

    public void setLebihBayarMPS20Persen(BigDecimal lebihBayarMPS20Persen) {
        this.lebihBayarMPS20Persen = lebihBayarMPS20Persen;
    }

    public BigDecimal getLebihBayarMPS10Juta() {
        return lebihBayarMPS10Juta;
    }

    public void setLebihBayarMPS10Juta(BigDecimal lebihBayarMPS10Juta) {
        this.lebihBayarMPS10Juta = lebihBayarMPS10Juta;
    }

    public BigDecimal getLebihBayarMPS100Persen() {
        return lebihBayarMPS100Persen;
    }

    public void setLebihBayarMPS100Persen(BigDecimal lebihBayarMPS100Persen) {
        this.lebihBayarMPS100Persen = lebihBayarMPS100Persen;
    }

    public BigDecimal getLebihBayarMPRumus() {
        return lebihBayarMPRumus;
    }

    public void setLebihBayarMPRumus(BigDecimal lebihBayarMPRumus) {
        this.lebihBayarMPRumus = lebihBayarMPRumus;
    }

    public BigDecimal getLebihBayarMPYD() {
        return lebihBayarMPYD;
    }

    public void setLebihBayarMPYD(BigDecimal lebihBayarMPYD) {
        this.lebihBayarMPYD = lebihBayarMPYD;
    }

    public Boolean getJadiPiutang() {
        return isJadiPiutang;
    }

    public void setJadiPiutang(Boolean jadiPiutang) {
        isJadiPiutang = jadiPiutang;
    }

    public Long getKategoryCatatan() {
        return kategoryCatatan;
    }

    public void setKategoryCatatan(Long kategoryCatatan) {
        this.kategoryCatatan = kategoryCatatan;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public StatusKawin getStatusKawin() {
        return statusKawin;
    }

    public void setStatusKawin(StatusKawin statusKawin) {
        this.statusKawin = statusKawin;
    }

    public String getNamaStatusKawinPenerimaMP() {
        return namaStatusKawinPenerimaMP;
    }

    public void setNamaStatusKawinPenerimaMP(String namaStatusKawinPenerimaMP) {
        this.namaStatusKawinPenerimaMP = namaStatusKawinPenerimaMP;
    }

    public Boolean getRekeningDAPENBI() {
        return isRekeningDAPENBI;
    }

    public void setRekeningDAPENBI(Boolean rekeningDAPENBI) {
        isRekeningDAPENBI = rekeningDAPENBI;
    }

    public Long getBank() {
        return bank;
    }

    public void setBank(Long bank) {
        this.bank = bank;
    }

    public String getJenisBank() {
        return jenisBank;
    }

    public void setJenisBank(String jenisBank) {
        this.jenisBank = jenisBank;
    }

    public String getNamaCabangBank() {
        return namaCabangBank;
    }

    public void setNamaCabangBank(String namaCabangBank) {
        this.namaCabangBank = namaCabangBank;
    }

    public String getNamaPadaRekBank() {
        return namaPadaRekBank;
    }

    public void setNamaPadaRekBank(String namaPadaRekBank) {
        this.namaPadaRekBank = namaPadaRekBank;
    }

    public String getNomorRekening() {
        return nomorRekening;
    }

    public void setNomorRekening(String nomorRekening) {
        this.nomorRekening = nomorRekening;
    }

    public String getNoHP() {
        return noHP;
    }

    public void setNoHP(String noHP) {
        this.noHP = noHP;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKeteranganOtomatis() {
        return keteranganOtomatis;
    }

    public void setKeteranganOtomatis(String keteranganOtomatis) {
        this.keteranganOtomatis = keteranganOtomatis;
    }

    public String getTotalMasaKerjaAdj() {
        return totalMasaKerjaAdj;
    }

    public void setTotalMasaKerjaAdj(String totalMasaKerjaAdj) {
        this.totalMasaKerjaAdj = totalMasaKerjaAdj;
    }

    public String getTotalMasaKerjaBulatAdj() {
        return totalMasaKerjaBulatAdj;
    }

    public void setTotalMasaKerjaBulatAdj(String totalMasaKerjaBulatAdj) {
        this.totalMasaKerjaBulatAdj = totalMasaKerjaBulatAdj;
    }

    public BigDecimal getMpBulan13Baru() {
        return mpBulan13Baru;
    }

    public void setMpBulan13Baru(BigDecimal mpBulan13Baru) {
        this.mpBulan13Baru = mpBulan13Baru;
    }

    public BigDecimal getRapelMPYDKurang() {
        return rapelMPYDKurang;
    }

    public void setRapelMPYDKurang(BigDecimal rapelMPYDKurang) {
        this.rapelMPYDKurang = rapelMPYDKurang;
    }

    public BigDecimal getRapelMPYDLebih() {
        return rapelMPYDLebih;
    }

    public void setRapelMPYDLebih(BigDecimal rapelMPYDLebih) {
        this.rapelMPYDLebih = rapelMPYDLebih;
    }

    public String getNoTlp() {
        return noTlp;
    }

    public void setNoTlp(String noTlp) {
        this.noTlp = noTlp;
    }

    public String getIdPenerimaMPBaru() {
        return idPenerimaMPBaru;
    }

    public void setIdPenerimaMPBaru(String idPenerimaMPBaru) {
        this.idPenerimaMPBaru = idPenerimaMPBaru;
    }

    public String getNamaPenerimaMPBaru() {
        return namaPenerimaMPBaru;
    }

    public void setNamaPenerimaMPBaru(String namaPenerimaMPBaru) {
        this.namaPenerimaMPBaru = namaPenerimaMPBaru;
    }

    public KategoriPenerima getKategoriPenerimaBaru() {
        return kategoriPenerimaBaru;
    }

    public void setKategoriPenerimaBaru(KategoriPenerima kategoriPenerimaBaru) {
        this.kategoriPenerimaBaru = kategoriPenerimaBaru;
    }

    public String getNamaKategoriPenerimaMPBaru() {
        return namaKategoriPenerimaMPBaru;
    }

    public void setNamaKategoriPenerimaMPBaru(String namaKategoriPenerimaMPBaru) {
        this.namaKategoriPenerimaMPBaru = namaKategoriPenerimaMPBaru;
    }

    public Suskel getSuskelBaru() {
        return suskelBaru;
    }

    public void setSuskelBaru(Suskel suskelBaru) {
        this.suskelBaru = suskelBaru;
    }

    public String getNamaSuskelBaru() {
        return namaSuskelBaru;
    }

    public void setNamaSuskelBaru(String namaSuskelBaru) {
        this.namaSuskelBaru = namaSuskelBaru;
    }

    public BigDecimal getLebihBayarJmlBulan() {
        return lebihBayarJmlBulan;
    }

    public void setLebihBayarJmlBulan(BigDecimal lebihBayarJmlBulan) {
        this.lebihBayarJmlBulan = lebihBayarJmlBulan;
    }

    public BigDecimal getLebihBayarNominal() {
        return lebihBayarNominal;
    }

    public void setLebihBayarNominal(BigDecimal lebihBayarNominal) {
        this.lebihBayarNominal = lebihBayarNominal;
    }

    public BigDecimal getNominalTerbayar() {
        return nominalTerbayar;
    }

    public void setNominalTerbayar(BigDecimal nominalTerbayar) {
        this.nominalTerbayar = nominalTerbayar;
    }

    public Date getTglInfWftPenerimaMPLama() {
        return tglInfWftPenerimaMPLama;
    }

    public void setTglInfWftPenerimaMPLama(Date tglInfWftPenerimaMPLama) {
        this.tglInfWftPenerimaMPLama = tglInfWftPenerimaMPLama;
    }

    public Date getTglLahirPenerimaMPBaru() {
        return tglLahirPenerimaMPBaru;
    }

    public void setTglLahirPenerimaMPBaru(Date tglLahirPenerimaMPBaru) {
        this.tglLahirPenerimaMPBaru = tglLahirPenerimaMPBaru;
    }

    public Character getJenisKelaminPenerimaMPBaru() {
        return jenisKelaminPenerimaMPBaru;
    }

    public void setJenisKelaminPenerimaMPBaru(Character jenisKelaminPenerimaMPBaru) {
        this.jenisKelaminPenerimaMPBaru = jenisKelaminPenerimaMPBaru;
    }

    public StatusKawin getKawinPenerimaMPBaru() {
        return kawinPenerimaMPBaru;
    }

    public void setKawinPenerimaMPBaru(StatusKawin kawinPenerimaMPBaru) {
        this.kawinPenerimaMPBaru = kawinPenerimaMPBaru;
    }

    public String getNamaKawinPenerimaMPBaru() {
        return namaKawinPenerimaMPBaru;
    }

    public void setNamaKawinPenerimaMPBaru(String namaKawinPenerimaMPBaru) {
        this.namaKawinPenerimaMPBaru = namaKawinPenerimaMPBaru;
    }

    public Date getTglInfNikashPenerimaMPLama() {
        return tglInfNikashPenerimaMPLama;
    }

    public void setTglInfNikashPenerimaMPLama(Date tglInfNikashPenerimaMPLama) {
        this.tglInfNikashPenerimaMPLama = tglInfNikashPenerimaMPLama;
    }

    public Long getLebihBayarJmlBulan13() {
        return lebihBayarJmlBulan13;
    }

    public void setLebihBayarJmlBulan13(Long lebihBayarJmlBulan13) {
        this.lebihBayarJmlBulan13 = lebihBayarJmlBulan13;
    }

    public Long getLebihBayarNominal13() {
        return lebihBayarNominal13;
    }

    public void setLebihBayarNominal13(Long lebihBayarNominal13) {
        this.lebihBayarNominal13 = lebihBayarNominal13;
    }

    public KantorBayar getKantorBayarBaru() {
        return kantorBayarBaru;
    }

    public void setKantorBayarBaru(KantorBayar kantorBayarBaru) {
        this.kantorBayarBaru = kantorBayarBaru;
    }

    public String getNamaKantorBayarBaru() {
        return namaKantorBayarBaru;
    }

    public void setNamaKantorBayarBaru(String namaKantorBayarBaru) {
        this.namaKantorBayarBaru = namaKantorBayarBaru;
    }

    public Date getGetTglUsia25TPenerimaMPBaru() {
        return getTglUsia25TPenerimaMPBaru;
    }

    public void setGetTglUsia25TPenerimaMPBaru(Date getTglUsia25TPenerimaMPBaru) {
        this.getTglUsia25TPenerimaMPBaru = getTglUsia25TPenerimaMPBaru;
    }

    public String getTglPermohonanMPS100() {
        return tglPermohonanMPS100;
    }

    public void setTglPermohonanMPS100(String tglPermohonanMPS100) {
        this.tglPermohonanMPS100 = tglPermohonanMPS100;
    }

    public AlasanMps100 getAlasanMps100() {
        return alasanMps100;
    }

    public void setAlasanMps100(AlasanMps100 alasanMps100) {
        this.alasanMps100 = alasanMps100;
    }

    public String getNamaAlasanMps100() {
        return namaAlasanMps100;
    }

    public void setNamaAlasanMps100(String namaAlasanMps100) {
        this.namaAlasanMps100 = namaAlasanMps100;
    }

    @Override
    public void fromDto(HistoryStatusMutasiDto dto) {

    }

    @Override
    public HistoryStatusMutasiDto toDto() {
        return null;
    }
}
