package com.dapenbi.dkpp.form;

import java.math.BigDecimal;
import java.util.Map;

public class KursFormDto {

    private String periodeMutasi;
    private BigDecimal kursEuro;
    private BigDecimal kursRupiah;
    private Map active;

    public KursFormDto(){

    }

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

    public Map getActive() {
        return active;
    }

    public void setActive(Map active) {
        this.active = active;
    }
}
