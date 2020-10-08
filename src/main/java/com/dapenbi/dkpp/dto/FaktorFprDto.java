package com.dapenbi.dkpp.dto;


import java.util.Date;

public class FaktorFprDto extends BaseDto {
    private Long id;
    private Date tglawal;
    private Date tglakhir;
    private String namafaktor;
    private String keteranganfaktor;
    private boolean isActive;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTglawal() {
        return tglawal;
    }

    public void setTglawal(Date tglawal) {
        this.tglawal = tglawal;
    }

    public Date getTglakhir() {
        return tglakhir;
    }

    public void setTglakhir(Date tglakhir) {
        this.tglakhir = tglakhir;
    }

    public String getNamafaktor() {
        return namafaktor;
    }

    public void setNamafaktor(String namafaktor) {
        this.namafaktor = namafaktor;
    }

    public String getKeteranganfaktor() {
        return keteranganfaktor;
    }

    public void setKeteranganfaktor(String keteranganfaktor) {
        this.keteranganfaktor = keteranganfaktor;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
