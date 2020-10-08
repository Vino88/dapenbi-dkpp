package com.dapenbi.dkpp.dto;

import java.util.Date;

public class KeluargaPesertaDto extends BaseDto {

    private String id;

    private Long idKategoriPenerima;

    private String jenisKelamin;

    private String namaKeluarga;

    private String NIP;

    private Date tglCerai;

    private Date tglLahir;

    private Date tglMenikah;

    private Date tglWafat;

    private String tempatLahir;

    private Date tglUsia25;

    private String tempatWafat;

    private String tempatMenikah;

    private KategoriPenerimaDto kategoriPenerima;

    private StatusKawinDto statusKawin;

    private String namaKategoriPenerima;

    private String namaStatusKawin;

    private boolean active;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getIdKategoriPenerima() {
        return idKategoriPenerima;
    }

    public void setIdKategoriPenerima(Long idKategoriPenerima) {
        this.idKategoriPenerima = idKategoriPenerima;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getNamaKeluarga() {
        return namaKeluarga;
    }

    public void setNamaKeluarga(String namaKeluarga) {
        this.namaKeluarga = namaKeluarga;
    }

    public String getNIP() {
        return NIP;
    }

    public void setNIP(String NIP) {
        this.NIP = NIP;
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

    public Date getTglWafat() {
        return tglWafat;
    }

    public void setTglWafat(Date tglWafat) {
        this.tglWafat = tglWafat;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public KategoriPenerimaDto getKategoriPenerima() {
        return kategoriPenerima;
    }

    public void setKategoriPenerima(KategoriPenerimaDto kategoriPenerima) {
        this.kategoriPenerima = kategoriPenerima;
    }

    public Date getTglUsia25() {
        return tglUsia25;
    }

    public void setTglUsia25(Date tglUsia25) {
        this.tglUsia25 = tglUsia25;
    }

    public String getTempatWafat() {
        return tempatWafat;
    }

    public void setTempatWafat(String tempatWafat) {
        this.tempatWafat = tempatWafat;
    }

    public String getTempatMenikah() {
        return tempatMenikah;
    }

    public void setTempatMenikah(String tempatMenikah) {
        this.tempatMenikah = tempatMenikah;
    }

    public StatusKawinDto getStatusKawin() {
        return statusKawin;
    }

    public void setStatusKawin(StatusKawinDto statusKawin) {
        this.statusKawin = statusKawin;
    }

    public String getNamaKategoriPenerima() {
        return namaKategoriPenerima;
    }

    public void setNamaKategoriPenerima(String namaKategoriPenerima) {
        this.namaKategoriPenerima = namaKategoriPenerima;
    }

    public String getNamaStatusKawin() {
        return namaStatusKawin;
    }

    public void setNamaStatusKawin(String namaStatusKawin) {
        this.namaStatusKawin = namaStatusKawin;
    }
}
