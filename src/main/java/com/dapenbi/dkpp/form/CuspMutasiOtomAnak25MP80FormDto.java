package com.dapenbi.dkpp.form;

import java.util.Date;

public class CuspMutasiOtomAnak25MP80FormDto extends BaseFormDto{
    private String compName;
    private String userName;
    private String parPeriodeMutasi;
    private Date parTglMutasi;

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getParPeriodeMutasi() {
        return parPeriodeMutasi;
    }

    public void setParPeriodeMutasi(String parPeriodeMutasi) {
        this.parPeriodeMutasi = parPeriodeMutasi;
    }

    public Date getParTglMutasi() {
        return parTglMutasi;
    }

    public void setParTglMutasi(Date parTglMutasi) {
        this.parTglMutasi = parTglMutasi;
    }
}
