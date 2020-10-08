package com.dapenbi.dkpp.form;

import java.util.Date;
import java.util.Map;

public class KeluargaPesertaFormDto {
    private String id;
    private Long idKategoriPenerima;
    private String namaKategoriPenerima;
    private String jenisKelamin;
    private String namaKeluarga;
    private String nip;
    private Date tanggalCerai;
    private Date tanggalLahir;
    private Date tanggalMenikah;
    private Date tanggalWafat;
    private String tempatLahir;
    private Date tanggalUsia25;
    private String tempatMenikah;
    private String tempatWafat;
    private Long statusKawin;
    private Map active;

    public KeluargaPesertaFormDto(){}

    public Map getActive() {
        return active;
    }

    public void setActive(Map active) {
        this.active = active;
    }

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

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public Date getTanggalCerai() {
        return tanggalCerai;
    }

    public void setTanggalCerai(Date tanggalCerai) {
        this.tanggalCerai = tanggalCerai;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(java.util.Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public Date getTanggalMenikah() {
        return tanggalMenikah;
    }

    public void setTanggalMenikah(Date tanggalMenikah) {
        this.tanggalMenikah = tanggalMenikah;
    }

    public Date getTanggalWafat() {
        return tanggalWafat;
    }

    public void setTanggalWafat(Date tanggalWafat) {
        this.tanggalWafat = tanggalWafat;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public Date getTanggalUsia25() {
        return tanggalUsia25;
    }

    public void setTanggalUsia25(Date tanggalUsia25) {
        this.tanggalUsia25 = tanggalUsia25;
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

    public Long getStatusKawin() {
        return statusKawin;
    }

    public void setStatusKawin(Long statusKawin) {
        this.statusKawin = statusKawin;
    }

}
