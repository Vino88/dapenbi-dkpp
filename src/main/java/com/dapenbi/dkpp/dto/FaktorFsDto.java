package com.dapenbi.dkpp.dto;

import java.util.Date;

public class FaktorFsDto extends BaseDto {

    private Long id;
    private boolean isActive;
    private String namaFaktorFs;
    private String keteranganFaktorFs;
    private Date tglAwal;
    private Date tglAkhir;

    public FaktorFsDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
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
}
