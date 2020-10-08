package com.dapenbi.dkpp.form;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class CuspKursPlainDto {
    private String parCompName;
    private String parUserName;
    private String parPeriodeMutasi;
    private String parKursEuro;
    private String parKursRupiah;

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

    public void setParPeriodeMutasi(String parPeriodeMutasi){
        this.parPeriodeMutasi = parPeriodeMutasi;
    }

    public String getParPeriodeMutasi(){
        return this.parPeriodeMutasi;
    }

    public void setParKursEuro(String parKursEuro){
        this.parKursEuro = parKursEuro;
    }

    public String getParKursEuro(){
        return this.parKursEuro;
    }

    public void setParKursRupiah(String parKursRupiah){
        this.parKursRupiah = parKursRupiah;
    }

    public String getParKursRupiah(){
        return this.parKursRupiah;
    }
}