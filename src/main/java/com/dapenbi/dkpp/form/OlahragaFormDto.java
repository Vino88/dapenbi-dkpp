package com.dapenbi.dkpp.form;

import java.util.Map;

public class OlahragaFormDto {

    Map active;

    private long id;

    private String namaOlahraga;


    public OlahragaFormDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNamaOlahraga() {
        return namaOlahraga;
    }

    public void setNamaOlahraga(String namaOlahraga) {
        this.namaOlahraga = namaOlahraga;
    }

    public void setActive(Map active) {
        this.active = active;
    }

    public Map getActive() {
        return active;
    }
}
