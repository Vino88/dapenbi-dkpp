package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dto.MPensiunDto;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TBL_M_PENSIUN")
public class MPensiun extends BaseModel<MPensiunDto> {

    @Id
    private String nip;

    @Column(name = "NAMA_PESERTA", length = 50)
    private String namaPeserta;

    @Column(name = "JENIS_KELAMIN_PESERTA")
    private Character jenisKelaminPeserta;

    @Column(name = "TGL_LAHIR_PESERTA")
    private Date tglLahirPeserta;

    @Column(name = "TGL_KERJA_PESERTA")
    private Date tglKerjaPeserta;

    @Column(name = "TGL_DPTHT_PESERTA")
    private Date tglDhptPeserta;

    @Column(name = "TGL_HENTI_KERJA_PESERTA")
    private Date tglHentiKerjaPeserta;

    @Column(name = "TEMPAT_MENINGGAL_PESERTA")
    private String tempatMeninggalPeserta;

    @Column(name = "TGL_MENINGGAL_PESERTA")
    private Date tglMeninggalPeserta;

    @Column(name = "TEMPAT_LAHIR_PESERTA")
    private String tempatLahirPeserta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_GOLONGAN")
    private Golongan golongan;

    @Column(name = "GOLONGAN_PANGKAT", length = 50)
    private String golonganPangkat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_AGAMA")
    private Agama agama;

    @Column(name = "NAMA_AGAMA", length = 20)
    private String namaAgama;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_KANTOR_BAYAR")
    private KantorBayar kantorBayar;

    @Column(name = "NAMA_KANTOR_BAYAR")
    private String namaKantorBayar;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PREDIKAT")
    private PredikatPemberhentian predikatPemberhentian;

    @Column(name = "NAMA_PREDIKAT")
    private String namaPredikat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_HENTI")
    private AlasanHenti alasanHenti;

    @Column(name = "KETERANGAN_HENTI", length = 50)
    private String keteranganHenti;

    @Column(name = "TGL_SP_BI")
    private Date tglSpBi;

    @Column(name = "NO_SP_BI")
    private String noSpBi;

    @Column(name = "TGL_SK_BI")
    private Date tglSkBi;

    @Column(name = "NO_SK_BI")
    private String noSkBi;

    @Column(name = "PHDP", length = 15)
    private BigDecimal phdp;

    @Column(name = "UPAH_VETERAN")
    private BigDecimal upahVeteran;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_JENIS_MPS")
    private JenisMps jenisMps;

    @Column(name = "NAMA_MPS", length = 50)
    private String namaMps;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_KATEGORI_PENSIUN")
    private KategoriPensiun kategoriPensiun;

    @Column(name = "NAMA_KATEGORI_PENSIUN")
    private String namaKategoriPensiun;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USIA_BAYAR")
    private UsiaBayar usiaBayar;

    @Column(name = "NAMA_USIA_BAYAR")
    private String namaUsiaBayar;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_STATUS_BAYAR")
    private StatusBayar statusBayar;

    @Column(name = "STATUS_BAYAR")
    private String namaStatusBayar;

    @Column(name = "TGL_TUNDA_JATUH_TEMPO")
    private Date tglTundaJatuhTempo;

    @Column(name = "TGL_AWAL_BAYAR")
    private Date tglAwalBayar;

    @Column(name = "TGL_MP_BULAN_KE13")
    private Date tglMpBulananKe13;

    @Column(name = "TGL_HENTI_BAYAR")
    private Date tglHentiBayar;

    @Column(name = "ID_PENERIMA_MP", nullable = false)
    private String idPenerimaMP;

    @Column(name = "NAMA_PENERIMA_MP", length = 50)
    private String namaPenerimaMp;

    @Temporal(TemporalType.DATE)
    @Column(name = "TGL_LAHIR_PENERIMA_MP")
    private Date tglLahirPenerimaMp;

    @Column(name = "JENIS_KELAMIN_PENERIMA_MP")
    private Character jenisKelaminPenerimaMp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_KATEGORI_PENERIMA_MP")
    private KategoriPenerima kategoriPenerima;

    @Column(name = "NAMA_KATEGORI_PENERIMA_MP")
    private String namaKategoriPenerimaMp;

    @Column(name = "TGL_SK_DAPENBI")
    private Date tglSkDapenbi;

    @Column(name = "NO_SK_DAPENBI")
    private String noSkDapenbi;

    @Column(name = "ALAMAT_IS_DALAM_NEGERI")
    private Boolean alamatIsDalamNegeri;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PROVINSI")
    private Provinsi provinsi;

    @Column(name = "NAMA_PROVINSI", length = 50)
    private String namaProvinsi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_KOTA_KAB")
    private Kota kota;

    @Column(name = "NAMA_KOTA_KAB", length = 50)
    private String namaKota;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_KECAMATAN")
    private Kecamatan kecamatan;

    @Column(name = "NAMA_KECAMATAN", length = 50)
    private String namaKecamatan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_KELURAHAN")
    private Kelurahan kelurahan;

    @Column(name = "NAMA_KELURAHAN", length = 50)
    private String namaKelurahan;

    @Column(name = "KODE_POS", length = 10)
    private String kodePos;

    @Column(name = "ALAMAT_LENGKAP", length = 100)
    private String alamatLengkap;

    @Column(name = "RT")
    private String rt;

    @Column(name = "RW")
    private String rw;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_NEGARA")
    private Negara negara;

    @Column(name = "NAMA_NEGARA", length = 50)
    private String namaNegara;

    @Column(name = "USIA_SAAT_HENTI", length = 6)
    private String usiaSaatHenti;

    @Column(name = "USIA_SAAT_HENTI_BULAT", length = 4)
    private String usiaSaatHentiBulat;

    @Column(name = "USIA_PENERIMA_BAYAR", length = 6)
    private String usiaPenerimaBayar;

    @Column(name = "USIA_PENERIMA_BAYAR_BULAT", length = 4)
    private String usiaPenerimaBayarBulat;

    @Column(name = "MASA_KERJA_TAMBAHAN", length = 6)
    private String masaKerjaTambahan;

    @Column(name = "MASA_KERJA_TAMBAHAN_BULAT", length = 4)
    private String masaKerjaTambahanBulat;

    @Column(name = "MASA_KERJA_VETERAN", length = 6)
    private String masaKerjaVeteran;

    @Column(name = "MASA_KERJA_VETERAN_BULAT", length = 4)
    private String masaKerjaVeteranBulat;

    @Column(name = "TOTAL_MASA_KERJA", length = 6)
    private String totalMasaKerja;

    @Column(name = "TOTAL_MASA_KERJA_BULAT", length = 6)
    private String totalMasaKerjaBulat;

    @Column(name = "MASA_KERJA_MP", length = 4)
    private String masaKerjaMp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_FAKTOR_FPR")
    private FaktorFPR faktorFPR;

    @Column(name = "NAMA_FAKTOR_FPR", length = 20)
    private String namaFaktorFpr;

    @Column(name = "NILAI_FPR", scale = 8, precision = 10)
    private BigDecimal nilaiFpr;

    @Column(name = "ID_FAKTOR_FS")
    private Long faktorFs;

    @Column(name = "NAMA_FAKTOR_FS", length = 20)
    private String namaFaktorFs;

    @Column(name = "NILAI_FS", scale = 8, precision = 10)
    private BigDecimal nilaiFs;

    @Column(name = "MPS_20PERSEN", scale = 2, precision = 20)
    private BigDecimal mps20persen;

    @Column(name = "MPS_10JUTA", scale = 2, precision = 20)
    private BigDecimal mps10juta;

    @Column(name = "MPS_100PERSEN", scale = 2, precision = 20)
    private BigDecimal mps100persen;

    @Column(name = "MP_PERBULAN_RUMUS", scale = 2, precision = 20)
    private BigDecimal mpPerbulanRumus;

    @Column(name = "MP_PERBULAN_20PERSEN", scale = 2, precision = 20)
    private BigDecimal mpPerbulan20persen;

    @Column(name = "MP_PERBULAN_10JUTA", scale = 2, precision = 20)
    private BigDecimal mpPerbulan10juta;

    @Column(scale = 2, precision = 20)
    private BigDecimal mpyd;

    @Column(name = "MP_BULAN13", scale = 2, precision = 20)
    private BigDecimal mpBulan13;

    @Column(name = "TOTAL_MASA_KERJA_ADJ")
    private String totalMasaKerjaAdj;

    @Column(name = "TOTAL_MASA_KERJA_ADJ_BULAT")
    private String totalMasaKerjaAdjBulat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_SUSKEL")
    private Suskel suskel;

    @Column(name = "NAMA_SUSKEL")
    private String namaSuskel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_STATUS_KAWIN_PENERIMA_MP")
    private StatusKawin statusKawin;

    @Column(name = "NAMA_STATUS_KAWIN_PENERIMA_MP")
    private String namaStatusKawinPenerimaMp;

    @Column(name = "NO_HP", length = 20)
    private String noHp;

    @Column(length = 25)
    private String email;

    @Column(name = "KETERANGAN_OTOMATIS", length = 500)
    private String keteranganOtomatis;

    @Column(name = "MASA_KERJA_HENTI", length = 6)
    private String masaKerjaHenti;

    @Column(name = "MASA_KERJA_HENTI_BULAT", length = 4)
    private String masaKerjaHentiBulat;

    @Column(name = "REF_ID_MUTASI")
    private Long refIdMutasi;

    @Temporal(TemporalType.DATE)
    @Column(name = "TGL_USIA_25T_PENERIMA_MP")
    private Date tglUsia25tPenerimaMp;

    @Column(name = "MPS_100PERSEN_BULAT")
    private BigDecimal mps100persenBulat;

    @Column(name = "FAKTOR_FS", length = 20)
    private String refFaktorFs;

    @Column(name = "NO_TLP")
    private String noTelp;

    @Column(name = "PERIODE_MUTASI")
    private String bukaPeriode;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pensiun")
    private List<KeluargaPensiun> keluargaPensiun;

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

    public Date getTglDhptPeserta() {
        return tglDhptPeserta;
    }

    public void setTglDhptPeserta(Date tglDhptPeserta) {
        this.tglDhptPeserta = tglDhptPeserta;
    }

    public Date getTglHentiKerjaPeserta() {
        return tglHentiKerjaPeserta;
    }

    public void setTglHentiKerjaPeserta(Date tglHentiKerjaPeserta) {
        this.tglHentiKerjaPeserta = tglHentiKerjaPeserta;
    }

    public String getTempatMeninggalPeserta() {
        return tempatMeninggalPeserta;
    }

    public void setTempatMeninggalPeserta(String tempatMeninggalPeserta) {
        this.tempatMeninggalPeserta = tempatMeninggalPeserta;
    }

    public Date getTglMeninggalPeserta() {
        return tglMeninggalPeserta;
    }

    public void setTglMeninggalPeserta(Date tglMeninggalPeserta) {
        this.tglMeninggalPeserta = tglMeninggalPeserta;
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

    public Date getTglSpBi() {
        return tglSpBi;
    }

    public void setTglSpBi(Date tglSpBi) {
        this.tglSpBi = tglSpBi;
    }

    public String getNoSpBi() {
        return noSpBi;
    }

    public void setNoSpBi(String noSpBi) {
        this.noSpBi = noSpBi;
    }

    public Date getTglSkBi() {
        return tglSkBi;
    }

    public void setTglSkBi(Date tglSkBi) {
        this.tglSkBi = tglSkBi;
    }

    public String getNoSkBi() {
        return noSkBi;
    }

    public void setNoSkBi(String noSkBi) {
        this.noSkBi = noSkBi;
    }

    public BigDecimal getPhdp() {
        return phdp;
    }

    public void setPhdp(BigDecimal phdp) {
        this.phdp = phdp;
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

    public String getNamaMps() {
        return namaMps;
    }

    public void setNamaMps(String namaMps) {
        this.namaMps = namaMps;
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

    public UsiaBayar getUsiaBayar() {
        return usiaBayar;
    }

    public void setUsiaBayar(UsiaBayar usiaBayar) {
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

    public Date getTglMpBulananKe13() {
        return tglMpBulananKe13;
    }

    public void setTglMpBulananKe13(Date tglMpBulananKe13) {
        this.tglMpBulananKe13 = tglMpBulananKe13;
    }

    public Date getTglHentiBayar() {
        return tglHentiBayar;
    }

    public void setTglHentiBayar(Date tglHentiBayar) {
        this.tglHentiBayar = tglHentiBayar;
    }

    public String getIdPenerimaMP() {
        return idPenerimaMP;
    }

    public void setIdPenerimaMP(String idPenerimaMP) {
        this.idPenerimaMP = idPenerimaMP;
    }

    public String getNamaPenerimaMp() {
        return namaPenerimaMp;
    }

    public void setNamaPenerimaMp(String namaPenerimaMp) {
        this.namaPenerimaMp = namaPenerimaMp;
    }

    public Date getTglLahirPenerimaMp() {
        return tglLahirPenerimaMp;
    }

    public void setTglLahirPenerimaMp(Date tglLahirPenerimaMp) {
        this.tglLahirPenerimaMp = tglLahirPenerimaMp;
    }

    public Character getJenisKelaminPenerimaMp() {
        return jenisKelaminPenerimaMp;
    }

    public void setJenisKelaminPenerimaMp(Character jenisKelaminPenerimaMp) {
        this.jenisKelaminPenerimaMp = jenisKelaminPenerimaMp;
    }

    public KategoriPenerima getKategoriPenerima() {
        return kategoriPenerima;
    }

    public void setKategoriPenerima(KategoriPenerima kategoriPenerima) {
        this.kategoriPenerima = kategoriPenerima;
    }

    public String getNamaKategoriPenerimaMp() {
        return namaKategoriPenerimaMp;
    }

    public void setNamaKategoriPenerimaMp(String namaKategoriPenerimaMp) {
        this.namaKategoriPenerimaMp = namaKategoriPenerimaMp;
    }

    public Date getTglSkDapenbi() {
        return tglSkDapenbi;
    }

    public void setTglSkDapenbi(Date tglSkDapenbi) {
        this.tglSkDapenbi = tglSkDapenbi;
    }

    public String getNoSkDapenbi() {
        return noSkDapenbi;
    }

    public void setNoSkDapenbi(String noSkDapenbi) {
        this.noSkDapenbi = noSkDapenbi;
    }

    public Boolean getAlamatIsDalamNegeri() {
        return alamatIsDalamNegeri;
    }

    public void setAlamatIsDalamNegeri(Boolean alamatIsDalamNegeri) {
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

    public Negara getNegara() {
        return negara;
    }

    public void setNegara(Negara negara) {
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

    public String getMasaKerjaMp() {
        return masaKerjaMp;
    }

    public void setMasaKerjaMp(String masaKerjaMp) {
        this.masaKerjaMp = masaKerjaMp;
    }

    public FaktorFPR getFaktorFPR() {
        return faktorFPR;
    }

    public void setFaktorFPR(FaktorFPR faktorFPR) {
        this.faktorFPR = faktorFPR;
    }

    public String getNamaFaktorFpr() {
        return namaFaktorFpr;
    }

    public void setNamaFaktorFpr(String namaFaktorFpr) {
        this.namaFaktorFpr = namaFaktorFpr;
    }

    public BigDecimal getNilaiFpr() {
        return nilaiFpr;
    }

    public void setNilaiFpr(BigDecimal nilaiFpr) {
        this.nilaiFpr = nilaiFpr;
    }

    public Long getFaktorFs() {
        return faktorFs;
    }

    public void setFaktorFs(Long faktorFs) {
        this.faktorFs = faktorFs;
    }

    public String getNamaFaktorFs() {
        return namaFaktorFs;
    }

    public void setNamaFaktorFs(String namaFaktorFs) {
        this.namaFaktorFs = namaFaktorFs;
    }

    public BigDecimal getNilaiFs() {
        return nilaiFs;
    }

    public void setNilaiFs(BigDecimal nilaiFs) {
        this.nilaiFs = nilaiFs;
    }

    public BigDecimal getMps20persen() {
        return mps20persen;
    }

    public void setMps20persen(BigDecimal mps20persen) {
        this.mps20persen = mps20persen;
    }

    public BigDecimal getMps10juta() {
        return mps10juta;
    }

    public void setMps10juta(BigDecimal mps10juta) {
        this.mps10juta = mps10juta;
    }

    public BigDecimal getMps100persen() {
        return mps100persen;
    }

    public void setMps100persen(BigDecimal mps100persen) {
        this.mps100persen = mps100persen;
    }

    public BigDecimal getMpPerbulanRumus() {
        return mpPerbulanRumus;
    }

    public void setMpPerbulanRumus(BigDecimal mpPerbulanRumus) {
        this.mpPerbulanRumus = mpPerbulanRumus;
    }

    public BigDecimal getMpPerbulan20persen() {
        return mpPerbulan20persen;
    }

    public void setMpPerbulan20persen(BigDecimal mpPerbulan20persen) {
        this.mpPerbulan20persen = mpPerbulan20persen;
    }

    public BigDecimal getMpPerbulan10juta() {
        return mpPerbulan10juta;
    }

    public void setMpPerbulan10juta(BigDecimal mpPerbulan10juta) {
        this.mpPerbulan10juta = mpPerbulan10juta;
    }

    public BigDecimal getMpyd() {
        return mpyd;
    }

    public void setMpyd(BigDecimal mpyd) {
        this.mpyd = mpyd;
    }

    public BigDecimal getMpBulan13() {
        return mpBulan13;
    }

    public void setMpBulan13(BigDecimal mpBulan13) {
        this.mpBulan13 = mpBulan13;
    }

    public String getTotalMasaKerjaAdj() {
        return totalMasaKerjaAdj;
    }

    public void setTotalMasaKerjaAdj(String totalMasaKerjaAdj) {
        this.totalMasaKerjaAdj = totalMasaKerjaAdj;
    }

    public String getTotalMasaKerjaAdjBulat() {
        return totalMasaKerjaAdjBulat;
    }

    public void setTotalMasaKerjaAdjBulat(String totalMasaKerjaAdjBulat) {
        this.totalMasaKerjaAdjBulat = totalMasaKerjaAdjBulat;
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

    public StatusKawin getStatusKawin() {
        return statusKawin;
    }

    public void setStatusKawin(StatusKawin statusKawin) {
        this.statusKawin = statusKawin;
    }

    public String getNamaStatusKawinPenerimaMp() {
        return namaStatusKawinPenerimaMp;
    }

    public void setNamaStatusKawinPenerimaMp(String namaStatusKawinPenerimaMp) {
        this.namaStatusKawinPenerimaMp = namaStatusKawinPenerimaMp;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
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

    public Long getRefIdMutasi() {
        return refIdMutasi;
    }

    public void setRefIdMutasi(Long refIdMutasi) {
        this.refIdMutasi = refIdMutasi;
    }

    public Date getTglUsia25tPenerimaMp() {
        return tglUsia25tPenerimaMp;
    }

    public void setTglUsia25tPenerimaMp(Date tglUsia25tPenerimaMp) {
        this.tglUsia25tPenerimaMp = tglUsia25tPenerimaMp;
    }

    public BigDecimal getMps100persenBulat() {
        return mps100persenBulat;
    }

    public void setMps100persenBulat(BigDecimal mps100persenBulat) {
        this.mps100persenBulat = mps100persenBulat;
    }

    public String getRefFaktorFs() {
        return refFaktorFs;
    }

    public void setRefFaktorFs(String refFaktorFs) {
        this.refFaktorFs = refFaktorFs;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public String getBukaPeriode() {
        return bukaPeriode;
    }

    public void setBukaPeriode(String bukaPeriode) {
        this.bukaPeriode = bukaPeriode;
    }

    public List<KeluargaPensiun> getKeluargaPensiun() {
        return keluargaPensiun;
    }

    public void setKeluargaPensiun(List<KeluargaPensiun> keluargaPensiun) {
        this.keluargaPensiun = keluargaPensiun;
    }

    @Override
    public void fromDto(MPensiunDto dto) {
        this.setNip(dto.getNip());
        this.setNamaPeserta(dto.getNamaPeserta());
        this.setJenisKelaminPeserta(dto.getJenisKelaminPeserta());
        this.setTglLahirPeserta(dto.getTglLahirPeserta());
        this.setTglKerjaPeserta(dto.getTglKerjaPeserta());
        this.setTglDhptPeserta(dto.getTglDhptPeserta());
        this.setTglHentiKerjaPeserta(dto.getTglHentiKerjaPeserta());
        this.setTempatMeninggalPeserta(dto.getTempatMeninggalPeserta());
        this.setTglMeninggalPeserta(dto.getTglMeninggalPeserta());
        this.setTempatLahirPeserta(dto.getTempatLahirPeserta());
        this.setGolonganPangkat(dto.getGolonganPangkat());
        this.setNamaAgama(dto.getNamaAgama());
        this.setNamaKantorBayar(dto.getNamaKantorBayar());
        this.setNamaPredikat(dto.getNamaPredikat());
        this.setKeteranganHenti(dto.getKeteranganHenti());
        this.setTglSpBi(dto.getTglSpBi());
        this.setNoSpBi(dto.getNoSpBi());
        this.setTglSkBi(dto.getTglSkBi());
        this.setNoSkBi(dto.getNoSkBi());
        this.setPhdp(dto.getPhdp());
        this.setUpahVeteran(dto.getUpahVeteran());
        this.setNamaMps(dto.getNamaMps());
        this.setNamaKategoriPensiun(dto.getNamaKategoriPensiun());
        this.setNamaUsiaBayar(dto.getNamaUsiaBayar());
        this.setTglTundaJatuhTempo(dto.getTglTundaJatuhTempo());
        this.setTglAwalBayar(dto.getTglAwalBayar());
        this.setTglMpBulananKe13(dto.getTglMpBulananKe13());
        this.setTglHentiBayar(dto.getTglHentiBayar());
        this.setNamaPenerimaMp(dto.getNamaPenerimaMp());
        this.setTglLahirPenerimaMp(dto.getTglLahirPenerimaMp());
        this.setJenisKelaminPenerimaMp(dto.getJenisKelaminPenerimaMp());
        this.setNamaKategoriPenerimaMp(dto.getNamaKategoriPenerimaMp());
        this.setTglSkDapenbi(dto.getTglSkDapenbi());
        this.setNoSkDapenbi(dto.getNoSkDapenbi());
        this.setAlamatIsDalamNegeri(dto.isAlamatIsDalamNegeri());
        this.setNamaProvinsi(dto.getNamaProvinsi());
        this.setNamaKota(dto.getNamaKota());
        this.setNamaKecamatan(dto.getNamaKecamatan());
        this.setNamaKelurahan(dto.getNamaKelurahan());
        this.setKodePos(dto.getKodePos());
        this.setAlamatLengkap(dto.getAlamatLengkap());
        this.setRt(dto.getRt());
        this.setRw(dto.getRw());
        this.setNamaNegara(dto.getNamaNegara());
        this.setUsiaSaatHenti(dto.getUsiaSaatHenti());
        this.setUsiaSaatHentiBulat(dto.getUsiaSaatHentiBulat());
        this.setUsiaPenerimaBayar(dto.getUsiaPenerimaBayar());
        this.setUsiaPenerimaBayarBulat(dto.getUsiaPenerimaBayarBulat());
        this.setMasaKerjaTambahan(dto.getMasaKerjaTambahan());
        this.setMasaKerjaTambahanBulat(dto.getMasaKerjaTambahanBulat());
        this.setMasaKerjaVeteran(dto.getMasaKerjaVeteran());
        this.setMasaKerjaVeteranBulat(dto.getMasaKerjaVeteranBulat());
        this.setTotalMasaKerja(dto.getTotalMasaKerja());
        this.setTotalMasaKerjaBulat(dto.getTotalMasaKerjaBulat());
        this.setMasaKerjaMp(dto.getMasaKerjaMp());
        this.setNamaFaktorFpr(dto.getNamaFaktorFpr());
        this.setNilaiFpr(dto.getNilaiFpr());
        this.setNamaFaktorFs(dto.getNamaFaktorFs());
        this.setNilaiFs(dto.getNilaiFs());
        this.setMps20persen(dto.getMps20persen());
        this.setMps10juta(dto.getMps10juta());
        this.setMps100persen(dto.getMps100persen());
        this.setMpPerbulanRumus(dto.getMpPerbulanRumus());
        this.setMpPerbulan20persen(dto.getMpPerbulan20persen());
        this.setMpPerbulan10juta(dto.getMpPerbulan10juta());
        this.setMpyd(dto.getMpyd());
        this.setMpBulan13(dto.getMpBulan13());
        this.setTotalMasaKerjaAdj(dto.getTotalMasaKerjaAdj());
        this.setTotalMasaKerjaAdjBulat(dto.getTotalMasaKerjaAdjBulat());
        this.setNamaSuskel(dto.getNamaSuskel());
        this.setNamaStatusKawinPenerimaMp(dto.getNamaStatusKawinPenerimaMp());
        this.setNoHp(dto.getNoHp());
        this.setEmail(dto.getEmail());
        this.setKeteranganOtomatis(dto.getKeteranganOtomatis());
        this.setMasaKerjaHenti(dto.getMasaKerjaHenti());
        this.setMasaKerjaHentiBulat(dto.getMasaKerjaHentiBulat());
        this.setRefIdMutasi(dto.getRefIdMutasi());
        this.setTglUsia25tPenerimaMp(dto.getTglUsia25tPenerimaMp());
        this.setMps100persenBulat(dto.getMps100persenBulat());
        this.setNoTelp(dto.getNoTelp());
        this.setActive(dto.isActive());
        this.setIdPenerimaMP(dto.getIdPenerimaMP());
        this.setRefFaktorFs(dto.getFaktorFsRef());
        this.setFaktorFs(dto.getFaktorFs());
        this.setBukaPeriode(dto.getBukaPeriode());
    }

    @Override
    public MPensiunDto toDto() {
        MPensiunDto dto = new MPensiunDto();
        dto.setNip(this.getNip());
        dto.setNamaPeserta(this.getNamaPeserta());
        dto.setJenisKelaminPeserta(this.getJenisKelaminPeserta());
        dto.setTglLahirPeserta(this.getTglLahirPeserta());
        dto.setTglKerjaPeserta(this.getTglKerjaPeserta());
        dto.setTglDhptPeserta(this.getTglDhptPeserta());
        dto.setTglHentiKerjaPeserta(this.getTglHentiKerjaPeserta());
        dto.setTempatMeninggalPeserta(this.getTempatMeninggalPeserta());
        dto.setTglMeninggalPeserta(this.getTglMeninggalPeserta());
        dto.setTempatLahirPeserta(this.getTempatLahirPeserta());
        dto.setGolonganPangkat(this.getGolonganPangkat());
        dto.setNamaAgama(this.getNamaAgama());
        dto.setNamaKantorBayar(this.getNamaKantorBayar());
        dto.setNamaPredikat(this.getNamaPredikat());
        dto.setKeteranganHenti(this.getKeteranganHenti());
        dto.setTglSpBi(this.getTglSpBi());
        dto.setNoSpBi(this.getNoSpBi());
        dto.setTglSkBi(this.getTglSkBi());
        dto.setNoSkBi(this.getNoSkBi());
        dto.setPhdp(this.getPhdp());
        dto.setUpahVeteran(this.getUpahVeteran());
        dto.setNamaMps(this.getNamaMps());
        dto.setNamaKategoriPensiun(this.getNamaKategoriPensiun());
        dto.setNamaUsiaBayar(this.getNamaUsiaBayar());
        dto.setTglTundaJatuhTempo(this.getTglTundaJatuhTempo());
        dto.setTglAwalBayar(this.getTglAwalBayar());
        dto.setTglMpBulananKe13(this.getTglMpBulananKe13());
        dto.setTglHentiBayar(this.getTglHentiBayar());
        dto.setNamaPenerimaMp(this.getNamaPenerimaMp());
        dto.setTglLahirPenerimaMp(this.getTglLahirPenerimaMp());
        dto.setJenisKelaminPenerimaMp(this.getJenisKelaminPenerimaMp());
        dto.setNamaKategoriPenerimaMp(this.getNamaKategoriPenerimaMp());
        dto.setTglSkDapenbi(this.getTglSkDapenbi());
        dto.setNoSkDapenbi(this.getNoSkDapenbi());
        dto.setAlamatIsDalamNegeri(this.getAlamatIsDalamNegeri());
        dto.setNamaProvinsi(this.getNamaProvinsi());
        dto.setNamaKota(this.getNamaKota());
        dto.setNamaKecamatan(this.getNamaKecamatan());
        dto.setNamaKelurahan(this.getNamaKelurahan());
        dto.setKodePos(this.getKodePos());
        dto.setAlamatLengkap(this.getAlamatLengkap());
        dto.setRt(this.getRt());
        dto.setRw(this.getRw());
        dto.setNamaNegara(this.getNamaNegara());
        dto.setUsiaSaatHenti(this.getUsiaSaatHenti());
        dto.setUsiaSaatHentiBulat(this.getUsiaSaatHentiBulat());
        dto.setUsiaPenerimaBayar(this.getUsiaPenerimaBayar());
        dto.setUsiaPenerimaBayarBulat(this.getUsiaPenerimaBayarBulat());
        dto.setMasaKerjaTambahan(this.getMasaKerjaTambahan());
        dto.setMasaKerjaTambahanBulat(this.getMasaKerjaTambahanBulat());
        dto.setMasaKerjaVeteran(this.getMasaKerjaVeteran());
        dto.setMasaKerjaVeteranBulat(this.getMasaKerjaVeteranBulat());
        dto.setTotalMasaKerja(this.getTotalMasaKerja());
        dto.setTotalMasaKerjaBulat(this.getTotalMasaKerjaBulat());
        dto.setMasaKerjaMp(this.getMasaKerjaMp());
        dto.setNamaFaktorFpr(this.getNamaFaktorFpr());
        dto.setNilaiFpr(this.getNilaiFpr());
        dto.setNamaFaktorFs(this.getNamaFaktorFs());
        dto.setNilaiFs(this.getNilaiFs());
        dto.setMps20persen(this.getMps20persen());
        dto.setMps10juta(this.getMps10juta());
        dto.setMps100persen(this.getMps100persen());
        dto.setMpPerbulanRumus(this.getMpPerbulanRumus());
        dto.setMpPerbulan20persen(this.getMpPerbulan20persen());
        dto.setMpPerbulan10juta(this.getMpPerbulan10juta());
        dto.setMpyd(this.getMpyd());
        dto.setMpBulan13(this.getMpBulan13());
        dto.setTotalMasaKerjaAdj(this.getTotalMasaKerjaAdj());
        dto.setTotalMasaKerjaAdjBulat(this.getTotalMasaKerjaAdjBulat());
        dto.setNamaSuskel(this.getNamaSuskel());
        dto.setNamaStatusKawinPenerimaMp(this.getNamaStatusKawinPenerimaMp());
        dto.setNoHp(this.getNoHp());
        dto.setEmail(this.getEmail());
        dto.setKeteranganOtomatis(this.getKeteranganOtomatis());
        dto.setMasaKerjaHenti(this.getMasaKerjaHenti());
        dto.setMasaKerjaHentiBulat(this.getMasaKerjaHentiBulat());
        dto.setRefIdMutasi(this.getRefIdMutasi());
        dto.setTglUsia25tPenerimaMp(this.getTglUsia25tPenerimaMp());
        dto.setMps100persenBulat(this.getMps100persenBulat());
        dto.setNoTelp(this.getNoTelp());
        dto.setActive(this.isActive());
        dto.setFaktorFsRef(this.getRefFaktorFs());
        dto.setIdPenerimaMP(this.getIdPenerimaMP());
        dto.setBukaPeriode(this.getBukaPeriode());
        dto.setFaktorFs(this.getFaktorFs());
        // DO NOT ADD ANY .toDTO() FUNCTION HERE - OR ANY MODEL CLASS!!! do it on the Controller or DAO
        return dto;
    }
}
