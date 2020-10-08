package com.dapenbi.dkpp.dto.ViewModelDto;

import java.math.BigDecimal;

public class HistoryPmbyMpMiViewModelDto {

    private Long id;
    private String periodePembayaran;
    private String nip;
    private BigDecimal mpBulanan;
    private BigDecimal kurangBayarMpBulanan;
    private BigDecimal lebihBayarMpBulanan;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPeriodePembayaran() {
        return periodePembayaran;
    }

    public void setPeriodePembayaran(String periodePembayaran) {
        this.periodePembayaran = periodePembayaran;
    }

    public BigDecimal getMpBulanan() {
        return mpBulanan;
    }

    public void setMpBulanan(BigDecimal mpBulanan) {
        this.mpBulanan = mpBulanan;
    }

    public BigDecimal getKurangBayarMpBulanan() {
        return kurangBayarMpBulanan;
    }

    public void setKurangBayarMpBulanan(BigDecimal kurangBayarMpBulanan) {
        this.kurangBayarMpBulanan = kurangBayarMpBulanan;
    }

    public BigDecimal getLebihBayarMpBulanan() {
        return lebihBayarMpBulanan;
    }

    public void setLebihBayarMpBulanan(BigDecimal lebihBayarMpBulanan) {
        this.lebihBayarMpBulanan = lebihBayarMpBulanan;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }
}
