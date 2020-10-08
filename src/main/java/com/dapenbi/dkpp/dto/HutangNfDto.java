package com.dapenbi.dkpp.dto;

import java.util.Date;

public class HutangNfDto extends BaseDto {
    private Long idHutang;

    private String periodeMutasi;

    private Date tglMutasi;

    private String  nip;

    private String namaPeserta;

    private String idPenerimaMp;

    private String namaPenerimaMp;

    private Long refIdPembayaran;

    private Long saldoHutang;

    private String userStamp;

    public Long getIdHutang() {
        return idHutang;
    }

    public void setIdHutang(Long idHutang) {
        this.idHutang = idHutang;
    }

    public String getPeriodeMutasi() {
        return periodeMutasi;
    }

    public void setPeriodeMutasi(String periodeMutasi) {
        this.periodeMutasi = periodeMutasi;
    }

    public Date getTglMutasi() {
        return tglMutasi;
    }

    public void setTglMutasi(Date tglMutasi) {
        this.tglMutasi = tglMutasi;
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

    public Long getRefIdPembayaran() {
        return refIdPembayaran;
    }

    public void setRefIdPembayaran(Long refIdPembayaran) {
        this.refIdPembayaran = refIdPembayaran;
    }

    public Long getSaldoHutang() {
        return saldoHutang;
    }

    public void setSaldoHutang(Long saldoHutang) {
        this.saldoHutang = saldoHutang;
    }

    public String getUserStamp() {
        return userStamp;
    }

    public void setUserStamp(String userStamp) {
        this.userStamp = userStamp;
    }
}
