package com.dapenbi.dkpp.form;

import java.util.Date;
import java.util.Map;

public class FaktorFPRFormDto {

    private Long id;
    private Date tglawal;
    private Date tglakhir;
    private String namafaktor;
    private String keteranganfaktor;
    private Map active;

    public FaktorFPRFormDto(){

    }

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

    public Map getActive() {
        return active;
    }

    public void setActive(Map active) {
        this.active = active;
    }
}
