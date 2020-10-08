package com.dapenbi.dkpp.dto;

public class AlasanKurangLebihBayarDto extends BaseDto {

    private Long id;

    private String namaAlasanKurangLebih;

    private Boolean isActive;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaAlasanKurangLebih() {
        return namaAlasanKurangLebih;
    }

    public void setNamaAlasanKurangLebih(String namaAlasanKurangLebih) {
        this.namaAlasanKurangLebih = namaAlasanKurangLebih;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
