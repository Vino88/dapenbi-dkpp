package com.dapenbi.dkpp.form;

import java.util.Map;

public class JenisMutasiFormDto {

    private String kodemutasi;
    private String namamutasi;
    private Map active;

    public JenisMutasiFormDto(){

    }

    public String getKodemutasi() {
        return kodemutasi;
    }

    public void setKodemutasi(String kodemutasi) {
        this.kodemutasi = kodemutasi;
    }

    public String getNamamutasi() {
        return namamutasi;
    }

    public void setNamamutasi(String namamutasi) {
        this.namamutasi = namamutasi;
    }

    public Map getActive() {
        return active;
    }

    public void setActive(Map active) {
        this.active = active;
    }
}
