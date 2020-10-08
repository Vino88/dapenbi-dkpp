package com.dapenbi.dkpp.form;

import java.util.Map;

public class KategoriCatatanFormDto {
    private Long id;
    private String kategoriMutasi;
    private String namaKategoriCatatan;
    private Map active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKategoriMutasi() {
        return kategoriMutasi;
    }

    public void setKategoriMutasi(String kategoriMutasi) {
        this.kategoriMutasi = kategoriMutasi;
    }

    public String getNamaKategoriCatatan() {
        return namaKategoriCatatan;
    }

    public void setNamaKategoriCatatan(String namaKategoriCatatan) {
        this.namaKategoriCatatan = namaKategoriCatatan;
    }

    public Map getActive() {
        return active;
    }

    public void setActive(Map active) {
        this.active = active;
    }
}
