package com.dapenbi.dkpp.model.CompositeId;

import java.io.Serializable;

public class RekonsiliasiRekeningPK implements Serializable {

    protected String periode;

    protected String nip;

    public String getPeriode() {
        return periode;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
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
