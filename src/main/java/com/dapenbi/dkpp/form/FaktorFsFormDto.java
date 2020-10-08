package com.dapenbi.dkpp.form;

import java.util.Date;
import java.util.Map;

public class FaktorFsFormDto {

    private Long id;
    private String namaFaktorFs;
    private String keteranganFaktorFs;
    private Date tglAwal;
    private Date tglAkhir;
    private Map active;

    public FaktorFsFormDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public void setActive(boolean active) {
    }

    public String getNamaFaktorFs() {
        return namaFaktorFs;
    }

    public void setNamaFaktorFs(String namaFaktorFs) {
        this.namaFaktorFs = namaFaktorFs;
    }

    public String getKeteranganFaktorFs() {
        return keteranganFaktorFs;
    }

    public void setKeteranganFaktorFs(String keteranganFaktorFs) {
        this.keteranganFaktorFs = keteranganFaktorFs;
    }

    public Date getTglAwal() {
        return tglAwal;
    }

    public void setTglAwal(Date tglAwal) {
        this.tglAwal = tglAwal;
    }

    public Date getTglAkhir() {
        return tglAkhir;
    }

    public void setTglAkhir(Date tglAkhir) {
        this.tglAkhir = tglAkhir;
    }

    public Map getActive() {
        return active;
    }

    public void setActive(Map active) {
        this.active = active;
    }


}
