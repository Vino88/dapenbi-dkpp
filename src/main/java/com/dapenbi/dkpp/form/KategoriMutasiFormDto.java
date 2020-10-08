package com.dapenbi.dkpp.form;

import com.dapenbi.dkpp.model.KategoriMutasi;

import java.util.Map;

public class KategoriMutasiFormDto {

    private String id;
    private String namaKategoriMutasi;
    private Map active;

    public KategoriMutasiFormDto() {
    }

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

    public Map getActive() {
        return active;
    }

    public void setActive(Map active) {
        this.active = active;
    }
}