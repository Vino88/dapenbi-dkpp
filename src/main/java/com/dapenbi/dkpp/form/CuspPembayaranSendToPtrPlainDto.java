package com.dapenbi.dkpp.form;

public class CuspPembayaranSendToPtrPlainDto {
    private String parCompName;
    private String parUserName;
    private String parPeriode;
    private String parTglDiproses;
    private String parIdPembayaran;

    public void setParCompName(String parCompName){
        this.parCompName = parCompName;
    }

    public String getParCompName(){
        return this.parCompName;
    }

    public void setParUserName(String parUserName){
        this.parUserName = parUserName;
    }

    public String getParUserName(){
        return this.parUserName;
    }

    public void setParPeriode(String parPeriode){
        this.parPeriode = parPeriode;
    }

    public String getParPeriode(){
        return this.parPeriode;
    }

    public void setParTglDiproses(String parTglDiproses){
        this.parTglDiproses = parTglDiproses;
    }

    public String getParTglDiproses(){
        return this.parTglDiproses;
    }

    public void setParIdPembayaran(String parIdPembayaran){
        this.parIdPembayaran = parIdPembayaran;
    }

    public String getParIdPembayaran(){
        return this.parIdPembayaran;
    }



}
