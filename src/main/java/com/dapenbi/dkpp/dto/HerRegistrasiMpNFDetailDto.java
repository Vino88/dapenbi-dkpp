package com.dapenbi.dkpp.dto;

import java.util.Date;

public class HerRegistrasiMpNFDetailDto {

    private String tahunHer;

    private String nip;

    private String namaPeserta;

    private String idPenerimaMp;

    private String namaPenerimaMp;

    private String userStamp;

    private Date tglHerRegis;

    private Character isSudahHer;

    private String sudahHerDesc;


    public String getTahunHer() {
        return tahunHer;
    }

    public void setTahunHer(String tahunHer) {
        this.tahunHer = tahunHer;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNamaPeserta() {
        return namaPeserta;
    }

    public void setNamaPeserta(String namaPeserta) {
        this.namaPeserta = namaPeserta;
    }

    public String getIdPenerimaMp() {
        return idPenerimaMp;
    }

    public void setIdPenerimaMp(String idPenerimaMp) {
        this.idPenerimaMp = idPenerimaMp;
    }

    public String getNamaPenerimaMp() {
        return namaPenerimaMp;
    }

    public void setNamaPenerimaMp(String namaPenerimaMp) {
        this.namaPenerimaMp = namaPenerimaMp;
    }

    public String getUserStamp() {
        return userStamp;
    }

    public void setUserStamp(String userStamp) {
        this.userStamp = userStamp;
    }

    public Date getTglHerRegis() {
        return tglHerRegis;
    }

    public void setTglHerRegis(Date tglHerRegis) {
        this.tglHerRegis = tglHerRegis;
    }

    public Character getIsSudahHer() {
        return isSudahHer;
    }

    public void setIsSudahHer(Character isSudahHer) {
        this.isSudahHer = isSudahHer;
    }

    public String getSudahHerDesc() {
        return sudahHerDesc;
    }

    public void setSudahHerDesc(String sudahHerDesc) {
        this.sudahHerDesc = sudahHerDesc;
    }
}
