package com.dapenbi.dkpp.dto;

import java.util.Date;

public class PmbyAngsuranLebihBayarHeadDto extends BaseDto {
    private Long id;
    private String periodeMutasi;
    private Date tglPembayaran;
    private String nip;
    private String namaPeserta;
    private String idPenerimaMp;
    private String namaPenerimaMp;
    private KantorBayarDto kantorBayar;
    private String namaKantorBayar;
    private Long totalAngsuran;
    private Long totalSaldoAwal;
    private Long totalSaldoAkhir;
    private String userStamp;
    private String userValidator;
    private Boolean isActive;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPeriodeMutasi() {
        return periodeMutasi;
    }

    public void setPeriodeMutasi(String periodeMutasi) {
        this.periodeMutasi = periodeMutasi;
    }

    public Date getTglPembayaran() {
        return tglPembayaran;
    }

    public void setTglPembayaran(Date tglPembayaran) {
        this.tglPembayaran = tglPembayaran;
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

    public KantorBayarDto getKantorBayar() {
        return kantorBayar;
    }

    public void setKantorBayar(KantorBayarDto kantorBayar) {
        this.kantorBayar = kantorBayar;
    }

    public String getNamaKantorBayar() {
        return namaKantorBayar;
    }

    public void setNamaKantorBayar(String namaKantorBayar) {
        this.namaKantorBayar = namaKantorBayar;
    }

    public Long getTotalAngsuran() {
        return totalAngsuran;
    }

    public void setTotalAngsuran(Long totalAngsuran) {
        this.totalAngsuran = totalAngsuran;
    }

    public Long getTotalSaldoAwal() {
        return totalSaldoAwal;
    }

    public void setTotalSaldoAwal(Long totalSaldoAwal) {
        this.totalSaldoAwal = totalSaldoAwal;
    }

    public Long getTotalSaldoAkhir() {
        return totalSaldoAkhir;
    }

    public void setTotalSaldoAkhir(Long totalSaldoAkhir) {
        this.totalSaldoAkhir = totalSaldoAkhir;
    }

    public String getUserStamp() {
        return userStamp;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public void setUserStamp(String userStamp) {
        this.userStamp = userStamp;
    }

    public String getUserValidator() {
        return userValidator;
    }

    public void setUserValidator(String userValidator) {
        this.userValidator = userValidator;
    }
}
