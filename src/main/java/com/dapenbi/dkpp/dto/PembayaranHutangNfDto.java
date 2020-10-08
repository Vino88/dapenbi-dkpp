package com.dapenbi.dkpp.dto;

import java.util.Date;

public class PembayaranHutangNfDto {

    private Long idBayarHutNf;

    private String periodeBayar;

    private Date tglBayar;

    private String nip;

    private String namaPeserta;

    private String idPenerimaMp;

    private String namaPenerimaMp;

    private Long nominalPembayaran;

    private Character sudahDiKirimPtr;

    private Long idKategoriCatatan;

    private String keterangan;

    private String userStamp;

    private Character isSentToPtr;

    private Long idSentToPtr;

    public Long getIdBayarHutNf() {
        return idBayarHutNf;
    }

    public void setIdBayarHutNf(Long idBayarHutNf) {
        this.idBayarHutNf = idBayarHutNf;
    }

    public String getPeriodeBayar() {
        return periodeBayar;
    }

    public void setPeriodeBayar(String periodeBayar) {
        this.periodeBayar = periodeBayar;
    }

    public Date getTglBayar() {
        return tglBayar;
    }

    public void setTglBayar(Date tglBayar) {
        this.tglBayar = tglBayar;
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

    public Long getNominalPembayaran() {
        return nominalPembayaran;
    }

    public void setNominalPembayaran(Long nominalPembayaran) {
        this.nominalPembayaran = nominalPembayaran;
    }

    public Character getSudahDiKirimPtr() {
        return sudahDiKirimPtr;
    }

    public void setSudahDiKirimPtr(Character sudahDiKirimPtr) {
        this.sudahDiKirimPtr = sudahDiKirimPtr;
    }

    public Long getIdKategoriCatatan() {
        return idKategoriCatatan;
    }

    public void setIdKategoriCatatan(Long idKategoriCatatan) {
        this.idKategoriCatatan = idKategoriCatatan;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getUserStamp() {
        return userStamp;
    }

    public void setUserStamp(String userStamp) {
        this.userStamp = userStamp;
    }

    public Character getIsSentToPtr() {
        return isSentToPtr;
    }

    public void setIsSentToPtr(Character isSentToPtr) {
        this.isSentToPtr = isSentToPtr;
    }

    public Long getIdSentToPtr() {
        return idSentToPtr;
    }

    public void setIdSentToPtr(Long idSentToPtr) {
        this.idSentToPtr = idSentToPtr;
    }
}
