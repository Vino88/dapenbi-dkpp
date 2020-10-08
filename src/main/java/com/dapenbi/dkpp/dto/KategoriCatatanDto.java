package com.dapenbi.dkpp.dto;

public class KategoriCatatanDto extends BaseDto {
    private Long id;
    private KategoriMutasiDto kategoriMutasi;
    private String namaKategoriCatatan;
    private boolean isActive;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public KategoriMutasiDto getKategoriMutasi() {
        return kategoriMutasi;
    }

    public void setKategoriMutasi(KategoriMutasiDto kategoriMutasi) {
        this.kategoriMutasi = kategoriMutasi;
    }

    public String getNamaKategoriCatatan() {
        return namaKategoriCatatan;
    }

    public void setNamaKategoriCatatan(String namaKategoriCatatan) {
        this.namaKategoriCatatan = namaKategoriCatatan;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
