package com.dapenbi.dkpp.form;

public class CuspReportDataBerkalaOjkFormDto extends BaseFormDto {

    String compName;

    String userName;

    String periode;


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

    public String getPeriode() {
        return periode;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
    }

    public void fromPlainText(CuspReportDataBerkalaOjkFormDto plainDto) {
        this.setCompName( plainDto.getCompName());
        this.setUserName( plainDto.getUserName());
        this.setPeriode( plainDto.getPeriode());
    }
}
