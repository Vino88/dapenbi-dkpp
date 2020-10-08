package com.dapenbi.dkpp.model.CompositeId;

import com.dapenbi.dkpp.model.FaktorFPR;

import java.io.Serializable;

public class AktuariaFprPK implements Serializable {

    protected String usia;

    protected Long faktorFPR;

    public AktuariaFprPK() {
    }

    public AktuariaFprPK(String usia, FaktorFPR faktorFPR) {
        this.usia = usia;
        this.faktorFPR = faktorFPR.getId();
    }

    public String getUsia() {
        return usia;
    }

    public void setUsia(String usia) {
        this.usia = usia;
    }

    public Long getFaktorFPR() {
        return faktorFPR;
    }

    public void setFaktorFPR(Long faktorFPR) {
        this.faktorFPR = faktorFPR;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}

