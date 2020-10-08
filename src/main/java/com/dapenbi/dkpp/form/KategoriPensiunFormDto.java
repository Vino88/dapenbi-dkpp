package com.dapenbi.dkpp.form;

import java.util.Map;

public class KategoriPensiunFormDto {
    private String Id;
    private String namaKategoriPensiun;
    private Map active;

    public KategoriPensiunFormDto(){

    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getNamaKategoriPensiun() {
        return namaKategoriPensiun;
    }

    public void setNamaKategoriPensiun(String namaKategoriPensiun) {
        this.namaKategoriPensiun = namaKategoriPensiun;
    }

    public Map getActive() {
        return active;
    }

    public void setActive(Map active) {
        this.active = active;
    }
}
