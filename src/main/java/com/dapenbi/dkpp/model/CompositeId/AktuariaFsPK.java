package com.dapenbi.dkpp.model.CompositeId;

import com.dapenbi.dkpp.model.FaktorFs;

import java.io.Serializable;

public class AktuariaFsPK implements Serializable {

    protected String usiaFs;

    protected Long faktorFs;

    public AktuariaFsPK() {
    }

    public AktuariaFsPK(String usiaFs, FaktorFs faktorFs) {
        this.usiaFs = usiaFs;
        this.faktorFs = faktorFs.getId();
    }

    public String getUsiaFs() {
        return usiaFs;
    }

    public void setUsiaFs(String usiaFs) {
        this.usiaFs = usiaFs;
    }

    public Long getFaktorFs() {
        return faktorFs;
    }

    public void setFaktorFs(Long faktorFs) {
        this.faktorFs = faktorFs;
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

