package com.dapenbi.dkpp.dto;

import javax.persistence.Column;
import java.util.Date;

public class SentToPtrNfDto extends BaseDto {

    private Long idPtrNf;

    private Date tglTransaksi;

    private String periodeTransaksi;

    private Long idRef;

    private Long nominal;

    private String keterangan;

    private String sumber;

    private String userStamp;

    public Long getIdPtrNf() {
        return idPtrNf;
    }

    public void setIdPtrNf(Long idPtrNf) {
        this.idPtrNf = idPtrNf;
    }

    public Date getTglTransaksi() {
        return tglTransaksi;
    }

    public void setTglTransaksi(Date tglTransaksi) {
        this.tglTransaksi = tglTransaksi;
    }

    public String getPeriodeTransaksi() {
        return periodeTransaksi;
    }

    public void setPeriodeTransaksi(String periodeTransaksi) {
        this.periodeTransaksi = periodeTransaksi;
    }

    public Long getIdRef() {
        return idRef;
    }

    public void setIdRef(Long idRef) {
        this.idRef = idRef;
    }

    public Long getNominal() {
        return nominal;
    }

    public void setNominal(Long nominal) {
        this.nominal = nominal;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getSumber() {
        return sumber;
    }

    public void setSumber(String sumber) {
        this.sumber = sumber;
    }

    public String getUserStamp() {
        return userStamp;
    }

    public void setUserStamp(String userStamp) {
        this.userStamp = userStamp;
    }
}
