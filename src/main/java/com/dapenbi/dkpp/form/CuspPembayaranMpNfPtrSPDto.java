package com.dapenbi.dkpp.form;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class CuspPembayaranMpNfPtrSPDto extends BaseFormDto  {
    private String parCompName;
    private String parUserName;
    private Long parIdPembayaran;
    private String parMutasiBayar;
    private Double parNominal;
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

    public void setParIdPembayaran(Long parIdPembayaran){
        this.parIdPembayaran = parIdPembayaran;
    }

    public Long getParIdPembayaran(){
        return this.parIdPembayaran;
    }

    public void setParMutasiBayar(String parMutasiBayar){
        this.parMutasiBayar = parMutasiBayar;
    }

    public String getParMutasiBayar(){
        return this.parMutasiBayar;
    }

    public void setParNominal(Double parNominal){
        this.parNominal = parNominal;
    }

    public Double getParNominal(){
        return this.parNominal;
    }

    public void setParStatusEksekusi(String parStatusEksekusi){
        this.parStatusEksekusi = parStatusEksekusi;
    }

    public String getParStatusEksekusi(){
        return this.parStatusEksekusi;
    }

    public void setParMsg(String parMsg){
        this.parMsg = parMsg;
    }

    public String getParMsg(){
        return this.parMsg;
    }

    public void fromPlainText(CuspPembayaranMpNfPtrPlainDto plainDto){
        this.setParCompName( plainDto.getParCompName());
        this.setParUserName( plainDto.getParUserName());
        if(plainDto.getParIdPembayaran() != null && !plainDto.getParIdPembayaran().equals(""))
            this.setParIdPembayaran(Long.valueOf( plainDto.getParIdPembayaran()));
        this.setParMutasiBayar( plainDto.getParMutasiBayar());

        if(plainDto.getParNominal() != null && !plainDto.getParNominal().equals(""))
            this.setParNominal( Double.valueOf( plainDto.getParNominal() ));
    }

}