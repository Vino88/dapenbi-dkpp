package com.dapenbi.dkpp.form;

import java.util.Map;

public class AgamaFormDto {

    private Long id;
    private String namaAgama;
    private Map active;

    public AgamaFormDto(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaAgama() {
        return namaAgama;
    }

    public void setNamaAgama(String namaAgama) {
        this.namaAgama = namaAgama;
    }

    public Map getActive() {
        return active;
    }

    public void setActive(Map active) {
        this.active = active;
    }
}
