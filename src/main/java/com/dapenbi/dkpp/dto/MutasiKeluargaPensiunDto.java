package com.dapenbi.dkpp.dto;

import java.util.Date;

public class MutasiKeluargaPensiunDto {

    private String id;

    private KategoriPenerimaDto kategoriPenerima;
    private Long idKategoriPenerima;
    private String namaKategoriPenerima;

    private StatusKawinDto statusKawin;
    private Long idStatusKawinPenerimaMp;
    private String namaStatusKawinPenerimaMp;

    private MutasiPensiunDto mutasiPensiun;

    private String isPenerimaMp;

    private Character jenisKelamin;

    private String namaKeluarga;

    private String nip;

    private String tempatLahir;

    private String tempatMenikah;

    private String tempatWafat;

    private Date tglCerai;

    private Date tglLahir;

    private Date tglMenikah;

    private Date tglUsia25;

    private Date tglWafat;

    private boolean isActive;

    private String userStamp;

    public MutasiPensiunDto getMutasiPensiun() {
        return mutasiPensiun;
    }

    public void setMutasiPensiun(MutasiPensiunDto mutasiPensiun) {
        this.mutasiPensiun = mutasiPensiun;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public KategoriPenerimaDto getKategoriPenerima() {
        return kategoriPenerima;
    }

    public void setKategoriPenerima(KategoriPenerimaDto kategoriPenerima) {
        this.kategoriPenerima = kategoriPenerima;
    }

    public Long getIdKategoriPenerima() {
        return idKategoriPenerima;
    }

    public void setIdKategoriPenerima(Long idKategoriPenerima) {
        this.idKategoriPenerima = idKategoriPenerima;
    }

    public String getNamaKategoriPenerima() {
        return namaKategoriPenerima;
    }

    public void setNamaKategoriPenerima(String namaKategoriPenerima) {
        this.namaKategoriPenerima = namaKategoriPenerima;
    }

    public StatusKawinDto getStatusKawin() {
        return statusKawin;
    }

    public void setStatusKawin(StatusKawinDto statusKawin) {
        this.statusKawin = statusKawin;
    }

    public Long getIdStatusKawinPenerimaMp() {
        return idStatusKawinPenerimaMp;
    }

    public void setIdStatusKawinPenerimaMp(Long idStatusKawinPenerimaMp) {
        this.idStatusKawinPenerimaMp = idStatusKawinPenerimaMp;
    }

    public String getNamaStatusKawinPenerimaMp() {
        return namaStatusKawinPenerimaMp;
    }

    public void setNamaStatusKawinPenerimaMp(String namaStatusKawinPenerimaMp) {
        this.namaStatusKawinPenerimaMp = namaStatusKawinPenerimaMp;
    }

    public String getIsPenerimaMp() {
        return isPenerimaMp;
    }

    public void setPenerimaMp(String isPenerimaMp) {
        this.isPenerimaMp = isPenerimaMp;
    }

    public Character getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(Character jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getNamaKeluarga() {
        return namaKeluarga;
    }

    public void setNamaKeluarga(String namaKeluarga) {
        this.namaKeluarga = namaKeluarga;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public String getTempatMenikah() {
        return tempatMenikah;
    }

    public void setTempatMenikah(String tempatMenikah) {
        this.tempatMenikah = tempatMenikah;
    }

    public String getTempatWafat() {
        return tempatWafat;
    }

    public void setTempatWafat(String tempatWafat) {
        this.tempatWafat = tempatWafat;
    }

    public Date getTglCerai() {
        return tglCerai;
    }

    public void setTglCerai(Date tglCerai) {
        this.tglCerai = tglCerai;
    }

    public Date getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(Date tglLahir) {
        this.tglLahir = tglLahir;
    }

    public Date getTglMenikah() {
        return tglMenikah;
    }

    public void setTglMenikah(Date tglMenikah) {
        this.tglMenikah = tglMenikah;
    }

    public Date getTglUsia25() {
        return tglUsia25;
    }

    public void setTglUsia25(Date tglUsia25) {
        this.tglUsia25 = tglUsia25;
    }

    public Date getTglWafat() {
        return tglWafat;
    }

    public void setTglWafat(Date tglWafat) {
        this.tglWafat = tglWafat;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getUserStamp() {
        return userStamp;
    }

    public void setUserStamp(String userStamp) {
        this.userStamp = userStamp;
    }
}
