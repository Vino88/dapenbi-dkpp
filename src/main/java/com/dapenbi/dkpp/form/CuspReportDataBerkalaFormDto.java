package com.dapenbi.dkpp.form;

public class CuspReportDataBerkalaFormDto extends BaseFormDto{
    String compName;

    String userName;

    String periode;

    String requestBy;

    Long jenisReport;

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

    public String getRequestBy() {
        return requestBy;
    }

    public void setRequestBy(String requestBy) {
        this.requestBy = requestBy;
    }

    public Long getJenisReport() {
        return jenisReport;
    }

    public void setJenisReport(Long jenisReport) {
        this.jenisReport = jenisReport;
    }

    public void fromPlainText(CuspReportDataBerkalaFormDto plainDto){
        this.setCompName( plainDto.getCompName());
        this.setUserName( plainDto.getUserName());
        this.setPeriode( plainDto.getPeriode());
        this.setRequestBy(plainDto.getRequestBy());
        this.setJenisReport(plainDto.getJenisReport());
    }


}
