package com.dapenbi.dkpp.form;

import com.dapenbi.dkpp.util.DateUtil;

import java.util.Date;

public class CuspPembayaranSendToPtrSPDto extends BaseFormDto  {
    private String parCompName;
    private String parUserName;
    private String parPeriode;
    private Date parTglDiproses;
    private Long parIdPembayaran;


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

    public void setParTglDiproses(Date parTglDiproses){
        this.parTglDiproses = parTglDiproses;
    }

    public Date getParTglDiproses(){
        return this.parTglDiproses;
    }

    public void setParIdPembayaran(Long parIdPembayaran){
        this.parIdPembayaran = parIdPembayaran;
    }

    public Long getParIdPembayaran(){
        return this.parIdPembayaran;
    }


    public void fromPlainText(CuspPembayaranSendToPtrPlainDto plainDto){
        this.setParCompName( plainDto.getParCompName());
        this.setParUserName( plainDto.getParUserName());
        this.setParPeriode( plainDto.getParPeriode());
        this.setParTglDiproses( plainDto.getParTglDiproses()==null?null: DateUtil.stringToDate(plainDto.getParTglDiproses(),"dd-MM-yyyy"));
        this.setParIdPembayaran( plainDto.getParIdPembayaran()==null? null:Long.valueOf(plainDto.getParIdPembayaran()));

    }

}
