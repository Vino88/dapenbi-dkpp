package com.dapenbi.dkpp.form;

import com.dapenbi.dkpp.util.DateUtil;

import java.util.Date;

public class CuspKenaikanMpSPDto extends BaseFormDto  {
    private String parCompName;
    private String parUserName;
    private Long parIdKenaikanMp;
    private Date parTglInput;
    private Long parIdJenisKenaikanMp;
    private String parNamaJenisKenaikanMp;
    private String parOperator;
    private Date parTglAwalBayar;
    private Long parPersentase;
    private Long parMinNominal;
    private String parPeriodeMutasiDiproses;


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

    public void setParIdKenaikanMp(Long parIdKenaikanMp){
        this.parIdKenaikanMp = parIdKenaikanMp;
    }

    public Long getParIdKenaikanMp(){
        return this.parIdKenaikanMp;
    }

    public void setParTglInput(Date parTglInput){
        this.parTglInput = parTglInput;
    }

    public Date getParTglInput(){
        return this.parTglInput;
    }

    public void setParIdJenisKenaikanMp(Long parIdJenisKenaikanMp){
        this.parIdJenisKenaikanMp = parIdJenisKenaikanMp;
    }

    public Long getParIdJenisKenaikanMp(){
        return this.parIdJenisKenaikanMp;
    }

    public void setParNamaJenisKenaikanMp(String parNamaJenisKenaikanMp){
        this.parNamaJenisKenaikanMp = parNamaJenisKenaikanMp;
    }

    public String getParNamaJenisKenaikanMp(){
        return this.parNamaJenisKenaikanMp;
    }

    public void setParOperator(String parOperator){
        this.parOperator = parOperator;
    }

    public String getParOperator(){
        return this.parOperator;
    }

    public void setParTglAwalBayar(Date parTglAwalBayar){
        this.parTglAwalBayar = parTglAwalBayar;
    }

    public Date getParTglAwalBayar(){
        return this.parTglAwalBayar;
    }

    public void setParPersentase(Long parPersentase){
        this.parPersentase = parPersentase;
    }

    public Long getParPersentase(){
        return this.parPersentase;
    }

    public void setParMinNominal(Long parMinNominal){
        this.parMinNominal = parMinNominal;
    }

    public Long getParMinNominal(){
        return this.parMinNominal;
    }

    public void setParPeriodeMutasiDiproses(String parPeriodeMutasiDiproses){
        this.parPeriodeMutasiDiproses = parPeriodeMutasiDiproses;
    }

    public String getParPeriodeMutasiDiproses(){
        return this.parPeriodeMutasiDiproses;
    }



    public void fromPlainText(CuspKenaikanMpPlainDto plainDto){
        this.setParCompName( plainDto.getParCompName());
        this.setParUserName( plainDto.getParUserName());
        this.setParIdKenaikanMp( plainDto.getParIdKenaikanMp()!=null? Long.valueOf(plainDto.getParIdKenaikanMp()):null);
        this.setParTglInput( plainDto.getParTglInput()!=null? DateUtil.stringToDate(plainDto.getParTglInput(),"dd-MM-yyyy"):null);
        this.setParIdJenisKenaikanMp( plainDto.getParIdJenisKenaikanMp()!=null?Long.valueOf(plainDto.getParIdJenisKenaikanMp()):null);
        this.setParNamaJenisKenaikanMp( plainDto.getParNamaJenisKenaikanMp());
        this.setParOperator( plainDto.getParOperator());
        this.setParTglAwalBayar( plainDto.getParTglAwalBayar()!=null?DateUtil.stringToDate(plainDto.getParTglAwalBayar(),"dd/MM/yyyy"):null);
        this.setParPersentase( plainDto.getParPersentase()!=null?Long.valueOf(plainDto.getParPersentase()):null);
        this.setParMinNominal( plainDto.getParMinNominal()!=null?Long.valueOf(plainDto.getParMinNominal()):null);
        this.setParPeriodeMutasiDiproses( plainDto.getParPeriodeMutasiDiproses());

    }

}
