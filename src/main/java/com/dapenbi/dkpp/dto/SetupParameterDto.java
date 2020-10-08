package com.dapenbi.dkpp.dto;

import java.util.Date;

public class SetupParameterDto extends BaseDto {

    private String periode;
    private Date tglAwalBayar;
    private boolean isAdaPotKewajiban;
    private boolean isAdaPerubahanFprFs;
    private boolean isAdaKenaikanMp;
    private boolean isBukaPeriode;
    private boolean isActive;


    public String getPeriode() {
        return periode;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
    }

    public Date getTglAwalBayar() {
        return tglAwalBayar;
    }

    public void setTglAwalBayar(Date tglAwalBayar) {
        this.tglAwalBayar = tglAwalBayar;
    }

    public boolean isAdaPotKewajiban() {
        return isAdaPotKewajiban;
    }

    public void setAdaPotKewajiban(boolean adaPotKewajiban) {
        isAdaPotKewajiban = adaPotKewajiban;
    }

    public boolean isAdaPerubahanFprFs() {
        return isAdaPerubahanFprFs;
    }

    public void setAdaPerubahanFprFs(boolean adaPerubahanFprFs) {
        isAdaPerubahanFprFs = adaPerubahanFprFs;
    }

    public boolean isAdaKenaikanMp() {
        return isAdaKenaikanMp;
    }

    public void setAdaKenaikanMp(boolean adaKenaikanMp) {
        isAdaKenaikanMp = adaKenaikanMp;
    }

    public boolean isBukaPeriode() {
        return isBukaPeriode;
    }

    public void setBukaPeriode(boolean bukaPeriode) {
        isBukaPeriode = bukaPeriode;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
