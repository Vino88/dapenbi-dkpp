package com.dapenbi.dkpp.dto;

import java.util.Date;

public class KeluargaPensiunDto extends BaseDto {

    private String id;
    private boolean isActive;
    private String isPenerimaMp;
    private String jenisKelamin;
    private KategoriPenerimaDto kategoriPenerima;
    private Long idKategoriPenerima;
    private String namaKategoriPenerima;
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
    private StatusKawinDto statusKawin;
    private Long idStatusKawin;
    private String namaStatusKawin;
    private String userStamp;
    private String flag;

    public KeluargaPensiunDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String isPenerimaMp() {
        return isPenerimaMp;
    }

    public String getIsPenerimaMp(){
        return isPenerimaMp;
    }

    public void setPenerimaMp(String isPenerimaMp) {
        this.isPenerimaMp = isPenerimaMp;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
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

    public String getUserStamp() {
        return userStamp;
    }

    public void setUserStamp(String userStamp) {
        this.userStamp = userStamp;
    }

    public KategoriPenerimaDto getKategoriPenerima() {
        return kategoriPenerima;
    }

    public void setKategoriPenerima(KategoriPenerimaDto kategoriPenerima) {
        this.kategoriPenerima = kategoriPenerima;
    }

    public StatusKawinDto getStatusKawin() {
        return statusKawin;
    }

    public void setStatusKawin(StatusKawinDto statusKawin) {
        this.statusKawin = statusKawin;
    }

    public Long getIdStatusKawin() {
        return idStatusKawin;
    }

    public void setIdStatusKawin(Long idStatusKawin) {
        this.idStatusKawin = idStatusKawin;
    }

    public String getNamaStatusKawin() {
        return namaStatusKawin;
    }

    public void setNamaStatusKawin(String namaStatusKawin) {
        this.namaStatusKawin = namaStatusKawin;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
