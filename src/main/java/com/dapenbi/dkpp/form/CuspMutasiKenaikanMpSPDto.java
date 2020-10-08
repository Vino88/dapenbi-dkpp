package com.dapenbi.dkpp.form;

import com.dapenbi.dkpp.util.DateUtil;

import java.util.Date;

public class CuspMutasiKenaikanMpSPDto extends BaseFormDto  {
    private Long parRoleId;

    private String parCompName;

    private String parUserName;

    private String parPeriodeMutasi;

    private Date parTglMutasi;


    public void setParRoleId(Long parRoleId){
        this.parRoleId = parRoleId;
    }

    public Long getParRoleId(){
        return this.parRoleId;
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



    public void setParPeriodeMutasi(String parPeriodeMutasi){
        this.parPeriodeMutasi = parPeriodeMutasi;
    }

    public String getParPeriodeMutasi(){
        return this.parPeriodeMutasi;
    }



    public void setParTglMutasi(Date parTglMutasi){
        this.parTglMutasi = parTglMutasi;
    }

    public Date getParTglMutasi(){
        return this.parTglMutasi;
    }


    public void fromPlainText(CuspMutasiKenaikanMpPlainDto plainDto){

        this.setParCompName( plainDto.getParCompName());

        this.setParUserName( plainDto.getParUserName());

        this.setParPeriodeMutasi( plainDto.getParPeriodeMutasi());

        this.setParTglMutasi(plainDto.getParTglMutasi()!=null?DateUtil.stringToDate(plainDto.getParTglMutasi(),"dd-MM-yyyy"):null);

    }

}
