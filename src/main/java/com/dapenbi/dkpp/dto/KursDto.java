package com.dapenbi.dkpp.dto;

import java.math.BigDecimal;

public class KursDto extends BaseDto {

    private String periodeMutasi;
    private BigDecimal kursEuro;
    private BigDecimal kursRupiah;
    private boolean isActive;

    public String getPeriodeMutasi() {
        return periodeMutasi;
    }

    public void setPeriodeMutasi(String periodeMutasi) {
        this.periodeMutasi = periodeMutasi;
    }

    public BigDecimal getKursEuro() {
        return kursEuro;
    }

    public void setKursEuro(BigDecimal kursEuro) {
        this.kursEuro = kursEuro;
    }

    public BigDecimal getKursRupiah() {
        return kursRupiah;
    }

    public void setKursRupiah(BigDecimal kursRupiah) {
        this.kursRupiah = kursRupiah;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
