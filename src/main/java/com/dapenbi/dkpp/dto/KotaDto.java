package com.dapenbi.dkpp.dto;


public class KotaDto extends BaseDto {

    private Long id;
    private String namaKota;
    private ProvinsiDto provinsi;
    private boolean isActive;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaKota() {
        return namaKota;
    }

    public void setNamaKota(String namaKota) {
        this.namaKota = namaKota;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public ProvinsiDto getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(ProvinsiDto provinsi) {
        this.provinsi = provinsi;
    }
}
