package com.dapenbi.dkpp.form;


import java.util.Map;

public class KotaFormDto {

    private Long id;
    private String namaKota;
    private Long idprovinsi;
    private Map active;

    public KotaFormDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaKota() {
        return namaKota;
    }

    public void setNamaKota(String namaKota) {
        this.namaKota = namaKota;
    }

    public Long getIdprovinsi() {
        return idprovinsi;
    }

    public void setIdprovinsi(Long idprovinsi) {
        this.idprovinsi = idprovinsi;
    }

    public Map getActive() {
        return active;
    }

    public void setActive(Map active) {
        this.active = active;
    }

}
