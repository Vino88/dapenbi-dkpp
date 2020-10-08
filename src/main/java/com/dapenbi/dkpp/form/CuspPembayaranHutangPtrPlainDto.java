package com.dapenbi.dkpp.form;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class CuspPembayaranHutangPtrPlainDto {
    private String parCompName;
    private String parUserName;
    private String parIdBayar;
    private String parPeriodeBayar;
    private String parNominal;

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

    public void setParIdBayar(String parIdBayar){
        this.parIdBayar = parIdBayar;
    }

    public String getParIdBayar(){
        return this.parIdBayar;
    }

    public void setParPeriodeBayar(String parPeriodeBayar){
        this.parPeriodeBayar = parPeriodeBayar;
    }

    public String getParPeriodeBayar(){
        return this.parPeriodeBayar;
    }

    public void setParNominal(String parNominal){
        this.parNominal = parNominal;
    }

    public String getParNominal(){
        return this.parNominal;
    }

}