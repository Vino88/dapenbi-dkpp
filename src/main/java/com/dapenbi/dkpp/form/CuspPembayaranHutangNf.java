package com.dapenbi.dkpp.form;


public class CuspPembayaranHutangNf extends BaseFormDto{

    private Long parRoleId;

    private String parCompName;

    private String parUserName;

    private String parPeriodeBayar;

    private Long parIdBayarNf;

    private String parNip;

    private String parNamaPeserta;

    private String parIdPenerimaMp;

    private String parNamaPenerimaMp;

    private Long parNominalPembayaran;

    private String parKeterangan;

    public Long getParRoleId() {
        return parRoleId;
    }

    public void setParRoleId(Long parRoleId) {
        this.parRoleId = parRoleId;
    }

    public String getParCompName() {
        return parCompName;
    }

    public void setParCompName(String parCompName) {
        this.parCompName = parCompName;
    }

    public String getParUserName() {
        return parUserName;
    }

    public void setParUserName(String parUserName) {
        this.parUserName = parUserName;
    }

    public String getParPeriodeBayar() {
        return parPeriodeBayar;
    }

    public void setParPeriodeBayar(String parPeriodeBayar) {
        this.parPeriodeBayar = parPeriodeBayar;
    }

    public Long getParIdBayarNf() {
        return parIdBayarNf;
    }

    public void setParIdBayarNf(Long parIdBayarNf) {
        this.parIdBayarNf = parIdBayarNf;
    }

    public String getParNip() {
        return parNip;
    }

    public void setParNip(String parNip) {
        this.parNip = parNip;
    }

    public String getParNamaPeserta() {
        return parNamaPeserta;
    }

    public void setParNamaPeserta(String parNamaPeserta) {
        this.parNamaPeserta = parNamaPeserta;
    }

    public String getParIdPenerimaMp() {
        return parIdPenerimaMp;
    }

    public void setParIdPenerimaMp(String parIdPenerimaMp) {
        this.parIdPenerimaMp = parIdPenerimaMp;
    }

    public String getParNamaPenerimaMp() {
        return parNamaPenerimaMp;
    }

    public void setParNamaPenerimaMp(String parNamaPenerimaMp) {
        this.parNamaPenerimaMp = parNamaPenerimaMp;
    }

    public Long getParNominalPembayaran() {
        return parNominalPembayaran;
    }

    public void setParNominalPembayaran(Long parNominalPembayaran) {
        this.parNominalPembayaran = parNominalPembayaran;
    }

    public String getParKeterangan() {
        return parKeterangan;
    }

    public void setParKeterangan(String parKeterangan) {
        this.parKeterangan = parKeterangan;
    }

    public void fromPlainText(CuspPembayaranHutangNf plainDto){
        this.setParCompName( plainDto.getParCompName());
        this.setParUserName( plainDto.getParUserName());
        this.setParPeriodeBayar( plainDto.getParPeriodeBayar());
        this.setParNip( plainDto.getParNip());
        this.setParNamaPeserta( plainDto.getParNamaPeserta());
        this.setParNamaPenerimaMp(plainDto.getParNamaPenerimaMp());
        this.setParIdBayarNf(plainDto.getParIdBayarNf());
        this.setParIdPenerimaMp(plainDto.getParIdPenerimaMp());
        this.setParNominalPembayaran(plainDto.getParNominalPembayaran());
        this.setParRoleId(plainDto.getParRoleId());
        this.setParKeterangan(plainDto.getParKeterangan());
    }
}
