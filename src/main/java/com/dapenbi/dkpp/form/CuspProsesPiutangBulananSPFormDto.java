package com.dapenbi.dkpp.form;

import com.dapenbi.dkpp.util.DateUtil;

import java.util.Date;

public class CuspProsesPiutangBulananSPFormDto extends BaseFormDto{
    private String parCompName;
    private String parUserName;
    private String parPeriodeMutasi;
    private Date parTglProses;

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

    public void setParTglProses(Date parTglProses){
        this.parTglProses = parTglProses;
    }

    public Date getParTglProses(){
        return this.parTglProses;
    }


    public void fromPlainText(CuspProsesPiutangBulananPlainDto plainDto){
        this.setParCompName( plainDto.getParCompName());
        this.setParUserName( plainDto.getParUserName());
        this.setParPeriodeMutasi( plainDto.getParPeriodeMutasi());
        this.setParTglProses(DateUtil.stringToDate(plainDto.getParTglProses(),"dd-MM-yyyy") );

    }
}
