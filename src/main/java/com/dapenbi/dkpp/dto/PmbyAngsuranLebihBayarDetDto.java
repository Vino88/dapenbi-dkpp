package com.dapenbi.dkpp.dto;

public class PmbyAngsuranLebihBayarDetDto extends BaseDto {

    private Long id;
    private AngsuranLebihBayarDto angsuranLebihBayar;
    private String periodePembayaran;
    private Long lebihBayarMp;
    private Long angsuran;
    private Long saldoAwal;
    private Long saldoAkhir;
    private PmbyAngsuranLebihBayarHeadDto pmbyAngsuranLebihBayarHead;
    private String userStamp;
    private Boolean isActive;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AngsuranLebihBayarDto getAngsuranLebihBayar() {
        return angsuranLebihBayar;
    }

    public void setAngsuranLebihBayar(AngsuranLebihBayarDto angsuranLebihBayar) {
        this.angsuranLebihBayar = angsuranLebihBayar;
    }

    public String getPeriodePembayaran() {
        return periodePembayaran;
    }

    public void setPeriodePembayaran(String periodePembayaran) {
        this.periodePembayaran = periodePembayaran;
    }

    public Long getLebihBayarMp() {
        return lebihBayarMp;
    }

    public void setLebihBayarMp(Long lebihBayarMp) {
        this.lebihBayarMp = lebihBayarMp;
    }

    public Long getAngsuran() {
        return angsuran;
    }

    public void setAngsuran(Long angsuran) {
        this.angsuran = angsuran;
    }

    public Long getSaldoAwal() {
        return saldoAwal;
    }

    public void setSaldoAwal(Long saldoAwal) {
        this.saldoAwal = saldoAwal;
    }

    public Long getSaldoAkhir() {
        return saldoAkhir;
    }

    public void setSaldoAkhir(Long saldoAkhir) {
        this.saldoAkhir = saldoAkhir;
    }

    public PmbyAngsuranLebihBayarHeadDto getPmbyAngsuranLebihBayarHead() {
        return pmbyAngsuranLebihBayarHead;
    }

    public void setPmbyAngsuranLebihBayarHead(PmbyAngsuranLebihBayarHeadDto pmbyAngsuranLebihBayarHead) {
        this.pmbyAngsuranLebihBayarHead = pmbyAngsuranLebihBayarHead;
    }

    public String getUserStamp() {
        return userStamp;
    }

    public void setUserStamp(String userStamp) {
        this.userStamp = userStamp;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
