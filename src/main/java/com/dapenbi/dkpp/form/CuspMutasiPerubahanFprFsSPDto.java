package com.dapenbi.dkpp.form;

import com.dapenbi.dkpp.util.DateUtil;

import java.util.Date;

public class CuspMutasiPerubahanFprFsSPDto extends BaseFormDto  {
    private Long parRoleId;
    private String parCompName;
    private String parUserName;
    private Date parTglMutasi;
    private String parPeriodeMutasi;

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

    public void setParTglMutasi(Date parTglMutasi){
        this.parTglMutasi = parTglMutasi;
    }

    public Date getParTglMutasi(){
        return this.parTglMutasi;
    }

    public void setParPeriodeMutasi(String parPeriodeMutasi){
        this.parPeriodeMutasi = parPeriodeMutasi;
    }

    public String getParPeriodeMutasi(){
        return this.parPeriodeMutasi;
    }


    public void fromPlainText(CuspMutasiPerubahanFprFsPlainDto plainDto){
        this.setParCompName( plainDto.getParCompName());
        this.setParUserName( plainDto.getParUserName());
        this.setParTglMutasi(DateUtil.stringToDate( plainDto.getParTglMutasi(),"dd-MM-yyyy"));
        this.setParPeriodeMutasi( plainDto.getParPeriodeMutasi());
    }

}
