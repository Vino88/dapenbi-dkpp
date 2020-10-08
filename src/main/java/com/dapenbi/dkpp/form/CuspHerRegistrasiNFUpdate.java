package com.dapenbi.dkpp.form;

import java.util.Date;

public class CuspHerRegistrasiNFUpdate extends BaseFormDto{

   private String parCompName;
   private String parUserName;
   private String parNip;
   private Date parTglHer;
   private String parIsSudahHer;
   private String parSudahHer;

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

    public String getParNip() {
        return parNip;
    }

    public void setParNip(String parNip) {
        this.parNip = parNip;
    }

    public Date getParTglHer() {
        return parTglHer;
    }

    public void setParTglHer(Date parTglHer) {
        this.parTglHer = parTglHer;
    }

    public String getParIsSudahHer() {
        return parIsSudahHer;
    }

    public void setParIsSudahHer(String parIsSudahHer) {
        this.parIsSudahHer = parIsSudahHer;
    }

    public String getParSudahHer() {
        return parSudahHer;
    }

    public void setParSudahHer(String parSudahHer) {
        this.parSudahHer = parSudahHer;
    }

    public void fromPlainText(CuspHerRegistrasiNFUpdate plainDto){
        this.setParCompName( plainDto.getParCompName());
        this.setParUserName( plainDto.getParUserName());
        this.setParNip( plainDto.getParNip());
        this.setParTglHer( plainDto.getParTglHer());
        this.setParIsSudahHer( plainDto.getParIsSudahHer());
        this.setParSudahHer(plainDto.getParSudahHer());
    }
}
