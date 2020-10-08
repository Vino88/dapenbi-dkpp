package com.dapenbi.dkpp.form;

import com.dapenbi.dkpp.model.CompositeId.AktuariaFprPK;
import com.dapenbi.dkpp.model.FaktorFPR;

import java.util.Map;

public class AktuariaFprFormDto {

    private AktuariaFprPK id;
    private Long idfaktorfpr;
    private String usia;
    private String nilaifpr;
    private Map active;

    public AktuariaFprPK getId() {
        return new AktuariaFprPK(this.usia, new FaktorFPR(this.idfaktorfpr));
    }

    public void setId(AktuariaFprPK id) {
        this.id = id;
    }

    public Long getIdfaktorfpr() {
        return idfaktorfpr;
    }

    public void setIdfaktorfpr(Long idfaktorfpr) {
        this.idfaktorfpr = idfaktorfpr;
    }

    public String getUsia() {
        return usia;
    }

    public void setUsia(String usia) {
        this.usia = usia;
    }

    public String getNilaifpr() {
        return nilaifpr;
    }

    public void setNilaifpr(String nilaifpr) {
        this.nilaifpr = nilaifpr;
    }

    public Map getActive() {
        return active;
    }

    public void setActive(Map active) {
        this.active = active;
    }
}
