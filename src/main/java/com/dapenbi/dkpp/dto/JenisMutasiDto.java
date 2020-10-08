package com.dapenbi.dkpp.dto;

public class JenisMutasiDto extends BaseDto {

    private String kodeMutasi;
    private String namaMutasi;
    private boolean isActive;

    public String getKodeMutasi() {
        return kodeMutasi;
    }

    public void setKodeMutasi(String kodeMutasi) {
        this.kodeMutasi = kodeMutasi;
    }

    public String getNamaMutasi() {
        return namaMutasi;
    }

    public void setNamaMutasi(String namaMutasi) {
        this.namaMutasi = namaMutasi;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
