package com.dapenbi.dkpp.form;

import java.util.Map;

public class AlasanHentiFormDto {
    public AlasanHentiFormDto(){}

    private Long id;
    private String keterangan;
    private int urutan;
    private Map active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public int getUrutan() {
        return urutan;
    }

    public void setUrutan(int urutan) {
        this.urutan = urutan;
    }

    public Map getActive() {
        return active;
    }

    public void setActive(Map active) {
        this.active = active;
    }

    public String toString(){
        return "{" +
                "id : '" + this.getId() + "'," +
                "keterangan: '" + this.getKeterangan() + "'," +
                "urutan: '" + this.getUrutan() + "'" +
                "}";
    }
}
