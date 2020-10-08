package com.dapenbi.dkpp.form;

import java.util.Map;

public class PredikatPemberhentianFormDto {

    private Long id;
    private String namaPemberhentian;
    private Map active;

    public PredikatPemberhentianFormDto(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaPemberhentian() {
        return namaPemberhentian;
    }

    public void setNamaPemberhentian(String namaPemberhentian) {
        this.namaPemberhentian = namaPemberhentian;
    }

    public Map getActive() {
        return active;
    }

    public void setActive(Map active) {
        this.active = active;
    }
}
