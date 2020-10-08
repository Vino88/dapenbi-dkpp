package com.dapenbi.dkpp.form;

public class CuspReportDataBerkalaManajemenFormDto extends BaseFormDto{

    String compName;

    String userName;

    String periodeMutasi;

    String kantorBayar;

    Long nominal;

    String jenisReport;

    Long kriteria;

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

    public String getPeriodeMutasi() {
        return periodeMutasi;
    }

    public void setPeriodeMutasi(String periodeMutasi) {
        this.periodeMutasi = periodeMutasi;
    }

    public String getKantorBayar() {
        return kantorBayar;
    }

    public void setKantorBayar(String kantorBayar) {
        this.kantorBayar = kantorBayar;
    }

    public Long getNominal() {
        return nominal;
    }

    public void setNominal(Long nominal) {
        this.nominal = nominal;
    }

    public String getJenisReport() {
        return jenisReport;
    }

    public void setJenisReport(String jenisReport) {
        this.jenisReport = jenisReport;
    }

    public Long getKriteria() {
        return kriteria;
    }

    public void setKriteria(Long kriteria) {
        this.kriteria = kriteria;
    }

    public void fromPlainText(CuspReportDataBerkalaManajemenFormDto plainDto){
        this.setCompName( plainDto.getCompName());
        this.setUserName( plainDto.getUserName());
        this.setPeriodeMutasi( plainDto.getPeriodeMutasi());
        this.setKantorBayar(plainDto.getKantorBayar());
        this.setNominal(plainDto.getNominal());
        this.setJenisReport(plainDto.getJenisReport());
        this.setKriteria(plainDto.getKriteria());
    }
}
