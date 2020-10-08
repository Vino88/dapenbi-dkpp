package com.dapenbi.dkpp.model.CompositeId;

import java.io.Serializable;

public class RekeningVersiMandiriPK implements Serializable {

    protected String periode;

    protected String nip;

    public String getPeriodeMutasi() {
        return periode;
    }

    public void setPeriodeMutasi(String periode) {
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
