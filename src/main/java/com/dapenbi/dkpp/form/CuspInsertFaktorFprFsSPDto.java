package com.dapenbi.dkpp.form;

import com.dapenbi.dkpp.dto.UploadHeaderSummaryDto;
import com.dapenbi.dkpp.util.DateUtil;

import java.util.Date;

public class CuspInsertFaktorFprFsSPDto extends BaseFormDto  {
    private Long parRoleId;
    private String parCompName;
    private String parUserName;
    private String parNamaFaktor;
    private Date parTglAwal;
    private Date parTglAkhir;
    private String parKeteranganFaktor;
    private String parFaktor;
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


    public void setParNamaFaktor(String parNamaFaktor){
        this.parNamaFaktor = parNamaFaktor;
    }

    public String getParNamaFaktor(){
        return this.parNamaFaktor;
    }

    public void setParTglAwal(Date parTglAwal){
        this.parTglAwal = parTglAwal;
    }

    public Date getParTglAwal(){
        return this.parTglAwal;
    }

    public void setParTglAkhir(Date parTglAkhir){
        this.parTglAkhir = parTglAkhir;
    }

    public Date getParTglAkhir(){
        return this.parTglAkhir;
    }

    public void setParKeteranganFaktor(String parKeteranganFaktor){
        this.parKeteranganFaktor = parKeteranganFaktor;
    }

    public String getParKeteranganFaktor(){
        return this.parKeteranganFaktor;
    }

    public void setParFaktor(String parFaktor){
        this.parFaktor = parFaktor;
    }

    public String getParFaktor(){
        return this.parFaktor;
    }

    public void setParAction(String parAction){
        this.parAction = parAction;
    }

    public String getParAction(){
        return this.parAction;
    }


    public void fromPlainText(UploadHeaderSummaryDto plainDto){
        this.setParCompName( plainDto.getCompName());
        this.setParUserName( plainDto.getUserName());
        this.setParNamaFaktor( plainDto.getNamaFaktor());
        this.setParTglAwal(DateUtil.stringToDate(plainDto.getTglMulaiBerlaku(),"dd/MM/yyyy"));
        this.setParTglAkhir(DateUtil.stringToDate("31/12/2999","dd/MM/yyyy"));
        this.setParKeteranganFaktor( plainDto.getKeterangan());
        this.setParFaktor( plainDto.getJenisFaktor());

    }

}

