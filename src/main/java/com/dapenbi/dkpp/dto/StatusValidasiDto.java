package com.dapenbi.dkpp.dto;

public class StatusValidasiDto extends BaseDto {

    private Long id;

    private String namaValidasi;

    private boolean isActive;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaValidasi() {
        return namaValidasi;
    }

    public void setNamaValidasi(String namaValidasi) {
        this.namaValidasi = namaValidasi;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
