package com.dapenbi.dkpp.form;

public class PmbyAngsuranLebihBayarHeadFormDto extends BaseFormDto {

    private String compName;
    private String userName;
    private String periodeLebihBayar;

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

    public String getPeriodeLebihBayar() {
        return periodeLebihBayar;
    }

    public void setPeriodeLebihBayar(String periodeLebihBayar) {
        this.periodeLebihBayar = periodeLebihBayar;
    }
}
