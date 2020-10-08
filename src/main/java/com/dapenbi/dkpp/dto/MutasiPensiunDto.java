package com.dapenbi.dkpp.dto;

import com.dapenbi.dkpp.model.*;

import java.math.BigDecimal;
import java.util.Date;

public class MutasiPensiunDto extends BaseDto {

    private Long id;

    private String kodeMutasi;

    private KategoriMutasiDto kategoriMutasi;

    private String periodeMutasi;

    private Date tglMutasi;

    private String nip;

    private String namaPeserta;

    private Character jenisKelaminPeserta;

    private Date tglLahirPeserta;

    private Date tglKerjaPeserta;

    private Date tglDPHTPeserta;

    private Date tglHentiKerjaPeserta;

    private String tempatMeniggalPeserta;

    private Date tglMeniggalPeserta;

    private String tempatLahirPeserta;

    private GolonganDto golongan;

    private String golonganPangkat;

    private AgamaDto agama;

    private String namaAgama;

    private KantorBayarDto kantorBayar;

    private KantorBayarDto kantorBayarBaru;

    private String namaKantorBayar;

    private String namaKantorBayarBaru;

    private PredikatPemberhentianDto predikatPemberhentian;

    private String namaPredikat;

    private AlasanHentiDto alasanHenti;

    private String keteranganHenti;

    private String noSPBI;

    private Date tglSPBI;

    private String noSKBI;

    private Date tglSKBI;

    private BigDecimal phdpLama;

    private BigDecimal upahVeteran;

    private JenisMpsDto jenisMps;

    private String namaMPS;

    private KategoriPensiunDto kategoriPensiun;

    private String namaKategoriPensiun;

    private Long usiaBayar;

    private String namaUsiaBayar;

    private StatusBayarDto statusBayar;

    private String namaStatusBayar;

    private Date tglTundaJatuhTempo;

    private Date tglAwalBayar;

    private Date tglMpBulanKe13;

    private Date tglHentiBayar;

    private String penerimaMP;

    private String idPenerimaMP;

    private String namaPenerimaMP;

    private Date tglLahirPenerimaMP;

    private Character jenisKelaminPenerimaMP;

    private KategoriPenerimaDto kategoriPenerima;

    private String namaKategoriPenerimaMP;

    private String noSKDAPENBI;

    private Date tglSKDAPENBI;

    private Date tglMeniggalPenerimaMP;

    private Date tglMenikahLagiPenerimaMP;

    private Date tglUsia25PenerimaMP;

    private Boolean alamatIsDalamNegeri;

    private ProvinsiDto provinsi;

    private String namaProvinsi;

    private KotaDto kota;

    private String namaKota;

    private KecamatanDto kecamatan;

    private String namaKecamatan;

    private KelurahanDto kelurahan;

    private String namaKelurahan;

    private String kodePos;

    private String alamatLengkap;

    private String rt;

    private String rw;

    private Long negara;

    private String namaNegara;

    private String usiaSaatHenti;

    private String usiaSaatHentiBulat;

    private String usiaPenerimaBayar;

    private String usiaPenerimaBayarBulat;

    private String masaKerjaHenti;

    private String masaKerjaHentiBulat;

    private String masaKerjaTambahan;

    private String masaKerjaTambahanBulat;

    private String masaKerjaVeteran;

    private String masaKerjaVeteranBulat;

    private String totalMasaKerja;

    private String totalMasaKerjaBulat;

    private String masaKerjaMP;

    private FaktorFPR faktorFPR;

    private String namaFaktorFPR;

    private BigDecimal nilaiFPR;

    private FaktorFsDto faktorFS;

    private String namaFaktorFS;

    private String faktorFs;

    private BigDecimal nilaiFS;

    private BigDecimal mps20PersenLama;

    private BigDecimal mps10JutaLama;

    private BigDecimal mps100PersenLama;

    private BigDecimal mpPerbulanRumusLama;

    private BigDecimal mpPerbulan20PersenLama;

    private Long mpPerbulan10JutaLama;

    private BigDecimal mpydLama;

    private BigDecimal mpBulan13;

    private BigDecimal mps100PersenBulatLama;

    private SuskelDto suskel;

    private String namaSuskel;

    private BigDecimal phdpBaru;

    private Date tglMulaiBerlakuPHDPBaru;

    private BigDecimal kurangBayarMPYD;

    private BigDecimal mps20PersenBaru;

    private BigDecimal mps10JutaBaru;

    private BigDecimal mps100PersenBaru;

    private BigDecimal mpPerbulanRumusBaru;

    private BigDecimal mpPerbulan20PersenBaru;

    private BigDecimal mpPerbulan10JutaBaru;

    private BigDecimal mps100PersenBulatBaru;

    private BigDecimal mpydBaru;

    private BigDecimal kurangBayarMPS20Persen;

    private BigDecimal kurangBayarMPS10Juta;

    private BigDecimal kurangBayarMPS100Persen;

    private BigDecimal kurangBayarMPRumus;

    private Boolean isJadiHutang;

    private BigDecimal lebihBayarMPS20Persen;

    private BigDecimal lebihBayarMPS10Juta;

    private BigDecimal lebihBayarMPS100Persen;

    private BigDecimal lebihBayarMPRumus;

    private BigDecimal lebihBayarMPYD;

    private Boolean isJadiPiutang;

    private KategoriCatatanDto kategoryCatatan;

    private String keterangan;

    private StatusKawinDto statusKawin;

    private String namaStatusKawinPenerimaMP;

    private Boolean isRekeningDAPENBI;

    private Long bank;

    private String jenisBank;

    private String namaCabangBank;

    private String namaPadaRekBank;

    private String nomorRekening;

    private String noHP;

    private String email;

    private StatusValidasiDto statusValidasi;

    private String keteranganOtomatis;

    private String userValidasi;

    private String namaValidasi;

    private String totalMasaKerjaAdj;

    private String totalMasaKerjaBulatAdj;

    private BigDecimal mpBulan13Baru;

    private BigDecimal rapelMPYDKurang;

    private BigDecimal rapelMPYDLebih;

    private String noTlp;

    private Boolean isActive;

    private String userStamp;

    private String penerimaMPBaru;

    private String namaPenerimaMPBaru;

    private KategoriPenerimaDto kategoriPenerimaBaru;

    private String namaKategoriPenerimaMPBaru;

    private SuskelDto suskelBaru;

    private String namaSuskelBaru;

    private BigDecimal lebihBayarJmlBulan;

    private BigDecimal lebihBayarNominal;

    private BigDecimal nominalTerbayar;

    private Date tglInfWftPenerimaMpLama;

    private Date tglLahirPenerimaMpBaru;

    private Character jenisKelaminPenerimaMPBaru;

    private StatusKawinDto statusKawinBaru;

    private String namaStatusKawinPenerimaMPBaru;

    private Date tglInfNikahPenerimaMpLama;

    private BigDecimal lebihBayarJmlBln13;

    private BigDecimal lebihBayarNominal13;


    private Date tglUsia25PenerimaMPBaru;

    private Date tglPermohonanMps100;

    private Long idAlasanMps100;

    private String namaAlasanMps100;

    private KategoriCatatanDto kategoriCatatan;

    private String idJenisMps;

    private String idKategoriMutasi;

    private String idKategoriPensiun;

    private String idKategoriPenerimaMp;


    public KategoriCatatanDto getKategoriCatatan() {
        return kategoriCatatan;
    }

    public void setKategoriCatatan(KategoriCatatanDto kategoriCatatan) {
        this.kategoriCatatan = kategoriCatatan;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKodeMutasi() {
        return kodeMutasi;
    }

    public void setKodeMutasi(String kodeMutasi) {
        this.kodeMutasi = kodeMutasi;
    }

    public KategoriMutasiDto getKategoriMutasi() {
        return kategoriMutasi;
    }

    public void setKategoriMutasi(KategoriMutasiDto kategoriMutasi) {
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

    public GolonganDto getGolongan() {
        return golongan;
    }

    public void setGolongan(GolonganDto golongan) {
        this.golongan = golongan;
    }

    public String getGolonganPangkat() {
        return golonganPangkat;
    }

    public void setGolonganPangkat(String golonganPangkat) {
        this.golonganPangkat = golonganPangkat;
    }

    public AgamaDto getAgama() {
        return agama;
    }

    public void setAgama(AgamaDto agama) {
        this.agama = agama;
    }

    public String getNamaAgama() {
        return namaAgama;
    }

    public void setNamaAgama(String namaAgama) {
        this.namaAgama = namaAgama;
    }

    public KantorBayarDto getKantorBayar() {
        return kantorBayar;
    }

    public void setKantorBayar(KantorBayarDto kantorBayar) {
        this.kantorBayar = kantorBayar;
    }

    public String getNamaKantorBayar() {
        return namaKantorBayar;
    }

    public void setNamaKantorBayar(String namaKantorBayar) {
        this.namaKantorBayar = namaKantorBayar;
    }

    public PredikatPemberhentianDto getPredikatPemberhentian() {
        return predikatPemberhentian;
    }

    public void setPredikatPemberhentian(PredikatPemberhentianDto predikatPemberhentian) {
        this.predikatPemberhentian = predikatPemberhentian;
    }

    public String getNamaPredikat() {
        return namaPredikat;
    }

    public void setNamaPredikat(String namaPredikat) {
        this.namaPredikat = namaPredikat;
    }

    public AlasanHentiDto getAlasanHenti() {
        return alasanHenti;
    }

    public void setAlasanHenti(AlasanHentiDto alasanHenti) {
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

    public JenisMpsDto getJenisMps() {
        return jenisMps;
    }

    public void setJenisMps(JenisMpsDto jenisMps) {
        this.jenisMps = jenisMps;
    }

    public String getNamaMPS() {
        return namaMPS;
    }

    public void setNamaMPS(String namaMPS) {
        this.namaMPS = namaMPS;
    }

    public KategoriPensiunDto getKategoriPensiun() {
        return kategoriPensiun;
    }

    public void setKategoriPensiun(KategoriPensiunDto kategoriPensiun) {
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

    public StatusBayarDto getStatusBayar() {
        return statusBayar;
    }

    public void setStatusBayar(StatusBayarDto statusBayar) {
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

    public String getPenerimaMP() {
        return penerimaMP;
    }

    public void setPenerimaMP(String penerimaMP) {
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

    public KategoriPenerimaDto getKategoriPenerima() {
        return kategoriPenerima;
    }

    public void setKategoriPenerima(KategoriPenerimaDto kategoriPenerima) {
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

    public Boolean isAlamatIsDalamNegeri() {
        return alamatIsDalamNegeri;
    }

    public void setAlamatIsDalamNegeri(Boolean alamatIsDalamNegeri) {
        this.alamatIsDalamNegeri = alamatIsDalamNegeri;
    }

    public ProvinsiDto getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(ProvinsiDto provinsi) {
        this.provinsi = provinsi;
    }

    public String getNamaProvinsi() {
        return namaProvinsi;
    }

    public void setNamaProvinsi(String namaProvinsi) {
        this.namaProvinsi = namaProvinsi;
    }

    public KotaDto getKota() {
        return kota;
    }

    public void setKota(KotaDto kota) {
        this.kota = kota;
    }

    public String getNamaKota() {
        return namaKota;
    }

    public void setNamaKota(String namaKota) {
        this.namaKota = namaKota;
    }

    public KecamatanDto getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(KecamatanDto kecamatan) {
        this.kecamatan = kecamatan;
    }

    public String getNamaKecamatan() {
        return namaKecamatan;
    }

    public void setNamaKecamatan(String namaKecamatan) {
        this.namaKecamatan = namaKecamatan;
    }

    public KelurahanDto getKelurahan() {
        return kelurahan;
    }

    public void setKelurahan(KelurahanDto kelurahan) {
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

    public FaktorFsDto getFaktorFS() {
        return faktorFS;
    }

    public void setFaktorFS(FaktorFsDto faktorFS) {
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

    public SuskelDto getSuskel() {
        return suskel;
    }

    public void setSuskel(SuskelDto suskel) {
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

    public Boolean getAlamatIsDalamNegeri() {
        return alamatIsDalamNegeri;
    }


    public KategoriCatatanDto getKategoryCatatan() {
        return kategoryCatatan;
    }

    public void setKategoryCatatan(KategoriCatatanDto kategoryCatatan) {
        this.kategoryCatatan = kategoryCatatan;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public StatusKawinDto getStatusKawin() {
        return statusKawin;
    }

    public void setStatusKawin(StatusKawinDto statusKawin) {
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

    public StatusValidasiDto getStatusValidasi() {
        return statusValidasi;
    }

    public void setStatusValidasi(StatusValidasiDto statusValidasi) {
        this.statusValidasi = statusValidasi;
    }

    public String getKeteranganOtomatis() {
        return keteranganOtomatis;
    }

    public void setKeteranganOtomatis(String keteranganOtomatis) {
        this.keteranganOtomatis = keteranganOtomatis;
    }

    public String getUserValidasi() {
        return userValidasi;
    }

    public void setUserValidasi(String userValidasi) {
        this.userValidasi = userValidasi;
    }

    public String getNamaValidasi() {
        return namaValidasi;
    }

    public void setNamaValidasi(String namaValidasi) {
        this.namaValidasi = namaValidasi;
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

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getUserStamp() {
        return userStamp;
    }

    public void setUserStamp(String userStamp) {
        this.userStamp = userStamp;
    }

    public String getPenerimaMPBaru() {
        return penerimaMPBaru;
    }

    public void setPenerimaMPBaru(String penerimaMPBaru) {
        this.penerimaMPBaru = penerimaMPBaru;
    }

    public String getNamaPenerimaMPBaru() {
        return namaPenerimaMPBaru;
    }

    public void setNamaPenerimaMPBaru(String namaPenerimaMPBaru) {
        this.namaPenerimaMPBaru = namaPenerimaMPBaru;
    }

    public KategoriPenerimaDto getKategoriPenerimaBaru() {
        return kategoriPenerimaBaru;
    }

    public void setKategoriPenerimaBaru(KategoriPenerimaDto kategoriPenerimaBaru) {
        this.kategoriPenerimaBaru = kategoriPenerimaBaru;
    }

    public String getNamaKategoriPenerimaMPBaru() {
        return namaKategoriPenerimaMPBaru;
    }

    public void setNamaKategoriPenerimaMPBaru(String namaKategoriPenerimaMPBaru) {
        this.namaKategoriPenerimaMPBaru = namaKategoriPenerimaMPBaru;
    }

    public SuskelDto getSuskelBaru() {
        return suskelBaru;
    }

    public void setSuskelBaru(SuskelDto suskelBaru) {
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

    public Date getTglInfWftPenerimaMpLama() {
        return tglInfWftPenerimaMpLama;
    }

    public void setTglInfWftPenerimaMpLama(Date tglInfWftPenerimaMpLama) {
        this.tglInfWftPenerimaMpLama = tglInfWftPenerimaMpLama;
    }

    public Date getTglLahirPenerimaMpBaru() {
        return tglLahirPenerimaMpBaru;
    }

    public void setTglLahirPenerimaMpBaru(Date tglLahirPenerimaMpBaru) {
        this.tglLahirPenerimaMpBaru = tglLahirPenerimaMpBaru;
    }

    public Character getJenisKelaminPenerimaMPBaru() {
        return jenisKelaminPenerimaMPBaru;
    }

    public void setJenisKelaminPenerimaMPBaru(Character jenisKelaminPenerimaMPBaru) {
        this.jenisKelaminPenerimaMPBaru = jenisKelaminPenerimaMPBaru;
    }

    public StatusKawinDto getStatusKawinBaru() {
        return statusKawinBaru;
    }

    public void setStatusKawinBaru(StatusKawinDto statusKawinBaru) {
        this.statusKawinBaru = statusKawinBaru;
    }

    public String getNamaStatusKawinPenerimaMPBaru() {
        return namaStatusKawinPenerimaMPBaru;
    }

    public void setNamaStatusKawinPenerimaMPBaru(String namaStatusKawinPenerimaMPBaru) {
        this.namaStatusKawinPenerimaMPBaru = namaStatusKawinPenerimaMPBaru;
    }

    public Date getTglInfNikahPenerimaMpLama() {
        return tglInfNikahPenerimaMpLama;
    }

    public void setTglInfNikahPenerimaMpLama(Date tglInfNikahPenerimaMpLama) {
        this.tglInfNikahPenerimaMpLama = tglInfNikahPenerimaMpLama;
    }

    public BigDecimal getLebihBayarJmlBln13() {
        return lebihBayarJmlBln13;
    }

    public void setLebihBayarJmlBln13(BigDecimal lebihBayarJmlBln13) {
        this.lebihBayarJmlBln13 = lebihBayarJmlBln13;
    }

    public BigDecimal getLebihBayarNominal13() {
        return lebihBayarNominal13;
    }

    public void setLebihBayarNominal13(BigDecimal lebihBayarNominal13) {
        this.lebihBayarNominal13 = lebihBayarNominal13;
    }

    public String getNamaKantorBayarBaru() {
        return namaKantorBayarBaru;
    }

    public void setNamaKantorBayarBaru(String namaKantorBayarBaru) {
        this.namaKantorBayarBaru = namaKantorBayarBaru;
    }

    public KantorBayarDto getKantorBayarBaru() {
        return kantorBayarBaru;
    }

    public void setKantorBayarBaru(KantorBayarDto kantorBayarBaru) {
        this.kantorBayarBaru = kantorBayarBaru;
    }

    public Date getTglUsia25PenerimaMPBaru() {
        return tglUsia25PenerimaMPBaru;
    }

    public void setTglUsia25PenerimaMPBaru(Date tglUsia25PenerimaMPBaru) {
        this.tglUsia25PenerimaMPBaru = tglUsia25PenerimaMPBaru;
    }

    public Date getTglPermohonanMps100() {
        return tglPermohonanMps100;
    }

    public void setTglPermohonanMps100(Date tglPermohonanMps100) {
        this.tglPermohonanMps100 = tglPermohonanMps100;
    }

    public Long getIdAlasanMps100() {
        return idAlasanMps100;
    }

    public void setIdAlasanMps100(Long idAlasanMps100) {
        this.idAlasanMps100 = idAlasanMps100;
    }

    public String getNamaAlasanMps100() {
        return namaAlasanMps100;
    }

    public void setNamaAlasanMps100(String namaAlasanMps100) {
        this.namaAlasanMps100 = namaAlasanMps100;
    }

    public String getIdPenerimaMP() {
        return idPenerimaMP;
    }

    public void setIdPenerimaMP(String idPenerimaMP) {
        this.idPenerimaMP = idPenerimaMP;
    }

    public String getIdJenisMps() {
        return idJenisMps;
    }

    public void setIdJenisMps(String idJenisMps) {
        this.idJenisMps = idJenisMps;
    }

    public String getIdKategoriMutasi() {
        return idKategoriMutasi;
    }

    public void setIdKategoriMutasi(String idKategoriMutasi) {
        this.idKategoriMutasi = idKategoriMutasi;
    }

    public String getIdKategoriPensiun() {
        return idKategoriPensiun;
    }

    public void setIdKategoriPensiun(String idKategoriPensiun) {
        this.idKategoriPensiun = idKategoriPensiun;
    }

    public String getIdKategoriPenerimaMp() {
        return idKategoriPenerimaMp;
    }

    public void setIdKategoriPenerimaMp(String idKategoriPenerimaMp) {
        this.idKategoriPenerimaMp = idKategoriPenerimaMp;
    }
}