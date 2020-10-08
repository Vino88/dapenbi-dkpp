package com.dapenbi.dkpp.model.CompositeId;

import java.io.Serializable;

public class HutangPK implements Serializable {

    protected String periodeMutasi;

    protected String nip;

    public String getPeriode() {
        return periodeMutasi;
    }

    public void setPeriode(String periodeMutasi) {
        this.periodeMutasi = periodeMutasi;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
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
