package com.dapenbi.dkpp.model.CompositeId;

import java.io.Serializable;

public class PotonganPgaPK implements Serializable {

    protected String periodeMutasi;

    protected String nip;

    protected String code;

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

    public void setCode(String code){
        this.code = code;
    }

    public String getCode(){
        return this.getCode();
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
