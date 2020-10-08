package com.dapenbi.dkpp.form;

import com.dapenbi.dkpp.util.DateUtil;

import java.util.Date;

public class CuspPmbyUangPembinaanDetSpDto extends BaseFormDto {
    private Long parRoleId;
    private String parCompName;
    private String parUserName;
    private Long parIdUangPembinaanD;
    private Long parIdUangPembinaanH;
    private String parPeriodeBayar;
    private Long parNominal;
    private String parNip;
    private String parNamaPeserta;
    private String parAction;

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

    public void setParIdUangPembinaanD(Long parIdUangPembinaanD){
        this.parIdUangPembinaanD = parIdUangPembinaanD;
    }

    public Long getParIdUangPembinaanD(){
        return this.parIdUangPembinaanD;
    }

    public void setParIdUangPembinaanH(Long parIdUangPembinaanH){
        this.parIdUangPembinaanH = parIdUangPembinaanH;
    }

    public Long getParIdUangPembinaanH(){
        return this.parIdUangPembinaanH;
    }

    public String getParPeriodeBayar() {
        return parPeriodeBayar;
    }

    public void setParPeriodeBayar(String parPeriodeBayar) {
        this.parPeriodeBayar = parPeriodeBayar;
    }

    public void setParNominal(Long parNominal){
        this.parNominal = parNominal;
    }

    public Long getParNominal(){
        return this.parNominal;
    }

    public void setParNip(String parNip){
        this.parNip = parNip;
    }

    public String getParNip(){
        return this.parNip;
    }

    public void setParNamaPeserta(String parNamaPeserta){
        this.parNamaPeserta = parNamaPeserta;
    }

    public String getParNamaPeserta(){
        return this.parNamaPeserta;
    }

    public void setParAction(String parAction){
        this.parAction = parAction;
    }

    public String getParAction(){
        return this.parAction;
    }


    public void fromPlainText(CuspPmbyUangPembinaanDetPlainDto plainDto){
        this.setParCompName( plainDto.getParCompName());
        this.setParUserName( plainDto.getParUserName());
        this.setParIdUangPembinaanD(plainDto.getParIdUangPembinaanD() != null?Long.valueOf( plainDto.getParIdUangPembinaanD()):null);
        this.setParIdUangPembinaanH(plainDto.getParIdUangPembinaanH()!= null?Long.valueOf( plainDto.getParIdUangPembinaanH()):null);
        this.setParPeriodeBayar( plainDto.getParPeriodeBayar());
        this.setParNominal(Long.valueOf( plainDto.getParNominal()));
        this.setParNip( plainDto.getParNip());
        this.setParNamaPeserta( plainDto.getParNamaPeserta());
    }
}
