package com.dapenbi.dkpp.dto;

public class AlamatDto {
    private String kodePos;
    private String idKelurahan;
    private String namaKelurahan;
    private String idKecamatan;
    private String namaKecamatan;
    private String idKota;
    private String namaKota;
    private String idProvinsi;
    private String namaProvinsi;

    public AlamatDto(String idKelurahan, String namaKelurahan, String kodePos, String idKecamatan, String namaKecamatan, String idKota, String namaKota, String idProvinsi, String namaProvinsi){
        this.idKelurahan = idKelurahan;
        this.namaKelurahan = namaKelurahan;
        this.kodePos = kodePos;
        this.idKecamatan = idKecamatan;
        this.namaKecamatan = namaKecamatan;
        this.idKota = idKota;
        this.namaKota = namaKota;
        this.idProvinsi = idProvinsi;
        this.namaProvinsi = namaProvinsi;
    }

    public String getKodePos() {
        return kodePos;
    }

    public void setKodePos(String kodePos) {
        this.kodePos = kodePos;
    }

    public String getIdKelurahan() {
        return idKelurahan;
    }

    public void setIdKelurahan(String idKelurahan) {
        this.idKelurahan = idKelurahan;
    }

    public String getNamaKelurahan() {
        return namaKelurahan;
    }

    public void setNamaKelurahan(String namaKelurahan) {
        this.namaKelurahan = namaKelurahan;
    }

    public String getIdKecamatan() {
        return idKecamatan;
    }

    public void setIdKecamatan(String idKecamatan) {
        this.idKecamatan = idKecamatan;
    }

    public String getNamaKecamatan() {
        return namaKecamatan;
    }

    public void setNamaKecamatan(String namaKecamatan) {
        this.namaKecamatan = namaKecamatan;
    }

    public String getIdKota() {
        return idKota;
    }

    public void setIdKota(String idKota) {
        this.idKota = idKota;
    }

    public String getNamaKota() {
        return namaKota;
    }

    public void setNamaKota(String namaKota) {
        this.namaKota = namaKota;
    }

    public String getIdProvinsi() {
        return idProvinsi;
    }

    public void setIdProvinsi(String idProvinsi) {
        this.idProvinsi = idProvinsi;
    }

    public String getNamaProvinsi() {
        return namaProvinsi;
    }

    public void setNamaProvinsi(String namaProvinsi) {
        this.namaProvinsi = namaProvinsi;
    }
}
