package com.dapenbi.dkpp.form;

import com.dapenbi.dkpp.util.DateUtil;

import java.util.Date;

public class CuspPembayaranSPDto extends BaseFormDto  {
    private String parPeriodePembayaran;
    private Date parTglDiproses;
    private String parDiprosesOleh;
    private String parCompName;
    private String parUserName;

    public void setParPeriodePembayaran(String parPeriodePembayaran){
        this.parPeriodePembayaran = parPeriodePembayaran;
    }

    public String getParPeriodePembayaran(){
        return this.parPeriodePembayaran;
    }

    public void setParTglDiproses(Date parTglDiproses){
        this.parTglDiproses = parTglDiproses;
    }

    public Date getParTglDiproses(){
        return this.parTglDiproses;
    }

    public void setParDiprosesOleh(String parDiprosesOleh){
        this.parDiprosesOleh = parDiprosesOleh;
    }

    public String getParDiprosesOleh(){
        return this.parDiprosesOleh;
    }

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


    public void fromPlainText(CuspPembayaranPlainDto plainDto){
        this.setParPeriodePembayaran( plainDto.getParPeriodePembayaran());
        this.setParTglDiproses(DateUtil.stringToDate(plainDto.getParTglDiproses(),"dd-MM-yyyy") );
        this.setParDiprosesOleh( plainDto.getParDiprosesOleh());
        this.setParCompName( plainDto.getParCompName());
        this.setParUserName( plainDto.getParUserName());
    }

}