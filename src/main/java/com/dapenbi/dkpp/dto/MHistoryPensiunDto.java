package com.dapenbi.dkpp.dto;

import com.dapenbi.dkpp.model.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

public class MHistoryPensiunDto {

    private Long id;

    private String nip;

    private String namaPeserta;

    private Character jenisKelaminPeserta;

    private Date tglLahirPeserta;

    private Date tglKerjaPeserta;

    private Date tglDpthtPeserta;

    private Date tglHentiKerjaPeserta;

    private String tempatMeninggalPeserta;

    private Date tglMeninggalPeserta;

    private String tempatLahirPeserta;

    private Golongan golongan;

    private String golonganPangkat;

    private Agama agama;

    private String namaAgama;

    private KantorBayar kantorBayar;

    private String namaKantorBayar;

    private PredikatPemberhentian predikatPemberhentian;

    private String namaPredikat;

    private AlasanHenti alasanHenti;

    private String keteranganHenti;
    private Date tglSpBi;
    private String noSpBi;

    private Date tglSkBi;

    private String noSkBi;

    private BigDecimal phdp;

    private BigDecimal upahVeteran;

    private JenisMps jenisMps;

    private String namaMps;

    private KategoriPensiun kategoriPensiun;

    private String namaKategoriPensiun;

    private UsiaBayar usiaBayar;

    private String namaUsiaBayar;

    private StatusBayar statusBayar;

    private String namaStatusBayar;

    private Date tglTundaJatuhTempo;

    private Date tglAwalBayar;

    private Date tglMpBulanKe13;

    private Date tglHentiBayar;

    private String idPenerimaMp;

    private String namaPenerimaMp;

    private Date tglLahirPenerimaMp;

    private Character jenisKelaminPenerimaMp;

    private KategoriPenerima kategoriPenerima;

    private String namaKategoriPenerimaMp;

    private Date tglSkDapenbi;

    private String noSkDapenbi;

    private Boolean alamatIsDalamNegeri;

    private Provinsi provinsi;

    private String namaProvinsi;

    private Kota kota;

    private String namaKota;

    private Kecamatan kecamatan;

    private String namaKecamatan;

    private Kelurahan kelurahan;

    private String namaKelurahan;

    private String kodePos;

    private String alamatLengkap;

    private String rt;

    private String rw;

    private Negara negara;

    private String namaNegara;

    private String usiaSaatHenti;

    private String usiaSaatHentiBulat;

    private String usiaPenerimaBayar;

    private String usiaPenerimaBayarBulat;

    private String masaKerjaTambahan;

    private String masaKerjaTambahanBulat;

    private String masaKerjaVeteran;

    private String masaKerjaVeteranBulat;

    private String totalMasaKerja;

    private String totalMasaKerjaBulat;

    private String masaKerjaMp;

    private FaktorFPR faktorFPR;

    private String namaFaktorFpr;

    private BigDecimal nilaiFpr;

    private Long idFaktorFs;

    private String namaFaktorFs;

    private BigDecimal nilaiFs;

    private BigDecimal mps20persen;

    private BigDecimal mps10juta;

    private BigDecimal mps100persen;

    private BigDecimal mpPerbulanRumus;

    private BigDecimal mpPerbulan20persen;

    private BigDecimal mpPerbulan10juta;

    private BigDecimal mpyd;

    private BigDecimal mpBulan13;

    private String totalMasaKerjaAdj;

    private String totalMasaKerjaAdjBulat;

    private Suskel suskel;

    private String namaSuskel;

    private StatusKawin statusKawin;

    private String namaStatusKawinPenerimaMp;

    private String noHp;

    private String email;

    private String keteranganOtomatis;

    private boolean isActive;

    private String masaKerjaHenti;

    private String masaKerjaHentiBulat;

    private Long refIdMutasi;

    private Long refHistoryByIdMutasi;


    private Date tglUsia25tPenerimaMp;

    private BigDecimal mps100persenBulat;

    private String faktorFs;

    private String noTlp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getTglDpthtPeserta() {
        return tglDpthtPeserta;
    }

    public void setTglDpthtPeserta(Date tglDpthtPeserta) {
        this.tglDpthtPeserta = tglDpthtPeserta;
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

    public String getIdPenerimaMp() {
        return idPenerimaMp;
    }

    public void setIdPenerimaMp(String idPenerimaMp) {
        this.idPenerimaMp = idPenerimaMp;
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

    public Long getIdFaktorFs() {
        return idFaktorFs;
    }

    public void setIdFaktorFs(Long idFaktorFs) {
        this.idFaktorFs = idFaktorFs;
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
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

    public Long getRefHistoryByIdMutasi() {
        return refHistoryByIdMutasi;
    }

    public void setRefHistoryByIdMutasi(Long refHistoryByIdMutasi) {
        this.refHistoryByIdMutasi = refHistoryByIdMutasi;
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

    public String getFaktorFs() {
        return faktorFs;
    }

    public void setFaktorFs(String faktorFs) {
        this.faktorFs = faktorFs;
    }

    public String getNoTlp() {
        return noTlp;
    }

    public void setNoTlp(String noTlp) {
        this.noTlp = noTlp;
    }
}
