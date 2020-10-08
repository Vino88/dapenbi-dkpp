package com.dapenbi.dkpp.form;

import java.util.Map;

public class StatusValidasiFormDto {
    private Long id;
    private String namaValidasi;
    private Map active;

    public StatusValidasiFormDto(){

    }

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

    public Map getActive() {
        return active;
    }

    public void setActive(Map active) {
        this.active = active;
    }
}
