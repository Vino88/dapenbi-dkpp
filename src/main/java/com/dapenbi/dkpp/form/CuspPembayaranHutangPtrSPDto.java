package com.dapenbi.dkpp.form;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class CuspPembayaranHutangPtrSPDto extends BaseFormDto  {
    private String parCompName;
    private String parUserName;
    private Long parIdBayar;
    private String parPeriodeBayar;
    private BigDecimal parNominal;

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

    public void setParIdBayar(Long parIdBayar){
        this.parIdBayar = parIdBayar;
    }

    public Long getParIdBayar(){
        return this.parIdBayar;
    }

    public void setParPeriodeBayar(String parPeriodeBayar){
        this.parPeriodeBayar = parPeriodeBayar;
    }

    public String getParPeriodeBayar(){
        return this.parPeriodeBayar;
    }

    public void setParNominal(BigDecimal parNominal){
        this.parNominal = parNominal;
    }

    public BigDecimal getParNominal(){
        return this.parNominal;
    }



    public void fromPlainText(CuspPembayaranHutangPtrPlainDto plainDto){
        this.setParCompName( plainDto.getParCompName());
        this.setParUserName( plainDto.getParUserName());
        this.setParIdBayar( Long.valueOf( plainDto.getParIdBayar()));
        this.setParPeriodeBayar( plainDto.getParPeriodeBayar());
        this.setParNominal( BigDecimal.valueOf( Double.valueOf( plainDto.getParNominal() )));
    }

}