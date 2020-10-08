package com.dapenbi.dkpp.form;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class CuspPembayaranHutangPlainDto {
    private String parCompName;
    private String parUserName;
    private String parNip;
    private String parPeriodeHutang;
    private String parType;

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

    public void setParNip(String parNip){
        this.parNip = parNip;
    }

    public String getParNip(){
        return this.parNip;
    }

    public void setParPeriodeHutang(String parPeriodeHutang){
        this.parPeriodeHutang = parPeriodeHutang;
    }

    public String getParPeriodeHutang(){
        return this.parPeriodeHutang;
    }

    public void setParType(String parType){
        this.parType = parType;
    }

    public String getParType(){
        return this.parType;
    }

}