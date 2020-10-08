package com.dapenbi.dkpp.form;

import com.dapenbi.dkpp.util.DateUtil;

import java.util.Date;

public class CuspMutasiPengembalianMpSPDto extends BaseFormDto  {
    private Long parRoleId;
    private String parCompName;
    private String parUserName;
    private Long parIdPengembalianMp;
    private String parPeriodeMutasi;
    private Date parTglMutasi;
    private String parNip;
    private String parNamaPeserta;
    private String parIdPenerimaMp;
    private String parNamaPenerimaMp;
    private String parKatPengembalianMp;
    private Date parTglTransfer;
    private Long parNominalTransfer;
    private String parIdKategoriCatatan;
    private String parNamaKategoriCatatan;
    private String parKeterangan;
    private Long parIdValidasi;
    private String parNamaValidasi;

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

    public void setParIdPengembalianMp(Long parIdPengembalianMp){
        this.parIdPengembalianMp = parIdPengembalianMp;
    }

    public Long getParIdPengembalianMp(){
        return this.parIdPengembalianMp;
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

    public void setParIdPenerimaMp(String parIdPenerimaMp){
        this.parIdPenerimaMp = parIdPenerimaMp;
    }

    public String getParIdPenerimaMp(){
        return this.parIdPenerimaMp;
    }

    public void setParNamaPenerimaMp(String parNamaPenerimaMp){
        this.parNamaPenerimaMp = parNamaPenerimaMp;
    }

    public String getParNamaPenerimaMp(){
        return this.parNamaPenerimaMp;
    }

    public void setParKatPengembalianMp(String parKatPengembalianMp){
        this.parKatPengembalianMp = parKatPengembalianMp;
    }

    public String getParKatPengembalianMp(){
        return this.parKatPengembalianMp;
    }

    public void setParTglTransfer(Date parTglTransfer){
        this.parTglTransfer = parTglTransfer;
    }

    public Date getParTglTransfer(){
        return this.parTglTransfer;
    }

    public void setParNominalTransfer(Long parNominalTransfer){
        this.parNominalTransfer = parNominalTransfer;
    }

    public Long getParNominalTransfer(){
        return this.parNominalTransfer;
    }

    public void setParIdKategoriCatatan(String parIdKategoriCatatan){
        this.parIdKategoriCatatan = parIdKategoriCatatan;
    }

    public String getParIdKategoriCatatan(){
        return this.parIdKategoriCatatan;
    }

    public void setParNamaKategoriCatatan(String parNamaKategoriCatatan){
        this.parNamaKategoriCatatan = parNamaKategoriCatatan;
    }

    public String getParNamaKategoriCatatan(){
        return this.parNamaKategoriCatatan;
    }

    public void setParKeterangan(String parKeterangan){
        this.parKeterangan = parKeterangan;
    }

    public String getParKeterangan(){
        return this.parKeterangan;
    }

    public void setParIdValidasi(Long parIdValidasi){
        this.parIdValidasi = parIdValidasi;
    }

    public Long getParIdValidasi(){
        return this.parIdValidasi;
    }

    public void setParNamaValidasi(String parNamaValidasi){
        this.parNamaValidasi = parNamaValidasi;
    }

    public String getParNamaValidasi(){
        return this.parNamaValidasi;
    }


    public void fromPlainText(CuspMutasiPengembalianMpPlainDto plainDto){
        this.setParCompName( plainDto.getCompName());
        this.setParUserName( plainDto.getUserName());
        if (plainDto.getIdPengembalianMp() != null) {
            this.setParIdPengembalianMp(Long.valueOf(plainDto.getIdPengembalianMp()));
        }
        //this.setParIdPengembalianMp(plainDto.getIdPengembalianMp().equals(null)? null:Long.valueOf(plainDto.getIdPengembalianMp()));
        this.setParPeriodeMutasi( plainDto.getPeriodeMutasi());
        this.setParTglMutasi(DateUtil.stringToDate( plainDto.getTglMutasi(),"dd/MM/yyyy"));
        this.setParNip( plainDto.getNip());
        this.setParNamaPeserta( plainDto.getNamaPeserta());
        this.setParIdPenerimaMp( plainDto.getIdPenerimaMp());
        this.setParNamaPenerimaMp( plainDto.getNamaPenerimaMp());
        this.setParKatPengembalianMp( plainDto.getKatPengembalianMp());
        this.setParTglTransfer(DateUtil.stringToDate(plainDto.getTglTransfer(),"dd/MM/yyyy"));
        this.setParNominalTransfer(plainDto.getNominalTransfer().equals("")? null:Long.valueOf(plainDto.getNominalTransfer()));
        this.setParIdKategoriCatatan( plainDto.getIdKategoriCatatan());
        this.setParNamaKategoriCatatan( plainDto.getNamaKategoriCatatan());
        this.setParKeterangan( plainDto.getKeterangan());
        this.setParIdValidasi(plainDto.getIdValidasi()== null?null:Long.valueOf(plainDto.getIdValidasi()));
        this.setParNamaValidasi(plainDto.getNamaValidasi());
    }

}
