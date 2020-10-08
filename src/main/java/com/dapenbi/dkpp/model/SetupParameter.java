package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dto.SetupParameterDto;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="TBL_T_SETUP_PARAMETER")
public class SetupParameter extends BaseModel<SetupParameterDto>{

    @Id
    @Column(name = "PERIODE",unique = true, nullable = false)
    private String periode;

    @Column(name="IS_ADA_KENAIKAN_MP")
    private boolean isAdaKenaikanMp;

    @Column(name="IS_ADA_PERUBAHAN_FPR_FS")
    private boolean isAdaPerubahanFprFs;

    @Column(name="IS_ADA_POT_KEWAJIBAN")
    private boolean isAdaPotKewajiban;

    @Column(name="IS_BUKA_PERIODE")
    private boolean isBukaPeriode;

    @Temporal(TemporalType.DATE)
    @Column(name="TGL_AWAL_BAYAR")
    private Date tglAwalBayar;


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

    @Override
    public void fromDto(SetupParameterDto dto) {
        this.setPeriode(dto.getPeriode());
        this.setTglAwalBayar(dto.getTglAwalBayar());
        this.setAdaPotKewajiban(dto.isAdaPotKewajiban());
        this.setAdaPerubahanFprFs(dto.isAdaPerubahanFprFs());
        this.setAdaKenaikanMp(dto.isAdaKenaikanMp());
        this.setBukaPeriode(dto.isBukaPeriode());
        this.setActive(dto.isActive());

    }

    @Override
    public SetupParameterDto toDto() {
        SetupParameterDto dto = new SetupParameterDto();
        dto.setPeriode(this.getPeriode());
        dto.setTglAwalBayar(this.getTglAwalBayar());
        dto.setAdaPotKewajiban(this.isAdaPotKewajiban());
        dto.setAdaPerubahanFprFs(this.isAdaPerubahanFprFs());
        dto.setAdaKenaikanMp(this.isAdaKenaikanMp());
        dto.setBukaPeriode(this.isBukaPeriode());
        dto.setActive(this.isActive());

        return dto;
    }
}
