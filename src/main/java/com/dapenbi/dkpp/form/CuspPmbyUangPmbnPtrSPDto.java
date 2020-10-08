package com.dapenbi.dkpp.form;

public class CuspPmbyUangPmbnPtrSPDto extends BaseFormDto  {
    private String parCompName;
    private String parUserName;
    private Long parIdUangPembinaanH;

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

    public void setParIdUangPembinaanH(Long parIdUangPembinaanH){
        this.parIdUangPembinaanH = parIdUangPembinaanH;
    }

    public Long getParIdUangPembinaanH(){
        return this.parIdUangPembinaanH;
    }


    public void fromPlainText(CuspPmbyUangPmbnPtrPlainDto plainDto){
        this.setParCompName( plainDto.getParCompName());
        this.setParUserName( plainDto.getParUserName());
        this.setParIdUangPembinaanH(Long.valueOf(plainDto.getParIdUangPembinaanH()));

    }

}
