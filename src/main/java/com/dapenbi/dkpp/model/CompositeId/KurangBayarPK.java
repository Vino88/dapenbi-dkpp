package com.dapenbi.dkpp.model.CompositeId;

import java.io.Serializable;

public class KurangBayarPK implements Serializable {

    private String periodeMutasi;

    private String nip;

    public KurangBayarPK() {
    }

    public KurangBayarPK(String periodeMutasi, String nip) {
        this.periodeMutasi = periodeMutasi;
        this.nip = nip;
    }

    public String getPeriodeMutasi() {
        return periodeMutasi;
    }

    public void setPeriodeMutasi(String periodeMutasi) {
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