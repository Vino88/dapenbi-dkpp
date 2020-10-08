package com.dapenbi.dkpp.form;

import java.util.Map;

public class UsiaBayarFormDto {
    private Long id;
    private String namaUsiaBayar;
    private Map active;

    public UsiaBayarFormDto(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaUsiaBayar() {
        return namaUsiaBayar;
    }

    public void setNamaUsiaBayar(String namaUsiaBayar) {
        this.namaUsiaBayar = namaUsiaBayar;
    }

    public Map getActive() {
        return active;
    }

    public void setActive(Map active) {
        this.active = active;
    }
}
