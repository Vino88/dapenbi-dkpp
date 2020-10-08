package com.dapenbi.dkpp.form;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class CuspPembayaranMpNfPtrPlainDto {
    private String parCompName;
    private String parUserName;
    private String parIdPembayaran;
    private String parMutasiBayar;
    private String parNominal;
    private String parStatusEksekusi;
    private String parMsg;

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

    public void setParIdPembayaran(String parIdPembayaran){
        this.parIdPembayaran = parIdPembayaran;
    }

    public String getParIdPembayaran(){
        return this.parIdPembayaran;
    }

    public void setParMutasiBayar(String parMutasiBayar){
        this.parMutasiBayar = parMutasiBayar;
    }

    public String getParMutasiBayar(){
        return this.parMutasiBayar;
    }

    public void setParNominal(String parNominal){
        this.parNominal = parNominal;
    }

    public String getParNominal(){
        return this.parNominal;
    }


}