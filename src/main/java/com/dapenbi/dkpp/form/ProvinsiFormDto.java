package com.dapenbi.dkpp.form;


import java.util.Map;

public class ProvinsiFormDto {

    private Long id;
    private String namaProvinsi;
    private Map active;

    public ProvinsiFormDto(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaProvinsi() {
        return namaProvinsi;
    }

    public void setNamaProvinsi(String namaProvinsi) {
        this.namaProvinsi = namaProvinsi;
    }

    public Map getActive() {
        return active;
    }

    public void setActive(Map active) {
        this.active = active;
    }
}
