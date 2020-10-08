package com.dapenbi.dkpp.dto;

public class KategoriMutasiDto extends BaseDto {

    private String id;
    private String namaKategoriMutasi;
    private boolean isActive;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamaKategoriMutasi() {
        return namaKategoriMutasi;
    }

    public void setNamaKategoriMutasi(String namaKategoriMutasi) {
        this.namaKategoriMutasi = namaKategoriMutasi;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
