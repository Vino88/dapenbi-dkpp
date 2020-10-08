package com.dapenbi.dkpp.form;

import java.util.Date;
import java.util.Map;

public class SetupParameterFormDto {
    private String periode;
    private Date tglAwalBayar;
    private Map adaPotKewajiban;
    private Map adaPerubahanFprFs;
    private Map adaKenaikanMp;
    private Map bukaPeriode;
    private Map active;

    public SetupParameterFormDto(){

    }

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

    public Map getAdaPotKewajiban() {
        return adaPotKewajiban;
    }

    public void setAdaPotKewajiban(Map adaPotKewajiban) {
        this.adaPotKewajiban = adaPotKewajiban;
    }

    public Map getAdaPerubahanFprFs() {
        return adaPerubahanFprFs;
    }

    public void setAdaPerubahanFprFs(Map adaPerubahanFprFs) {
        this.adaPerubahanFprFs = adaPerubahanFprFs;
    }

    public Map getAdaKenaikanMp() {
        return adaKenaikanMp;
    }

    public void setAdaKenaikanMp(Map adaKenaikanMp) {
        this.adaKenaikanMp = adaKenaikanMp;
    }

    public Map getBukaPeriode() {
        return bukaPeriode;
    }

    public void setBukaPeriode(Map bukaPeriode) {
        this.bukaPeriode = bukaPeriode;
    }

    public Map getActive() {
        return active;
    }

    public void setActive(Map active) {
        this.active = active;
    }
}
