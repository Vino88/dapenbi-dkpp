package com.dapenbi.dkpp.form;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class CuspPembayaranMpNfSPDto extends BaseFormDto  {
    private Long parRoleId;
    private String parCompName;
    private String parUserName;
    private String parPeriodeMutasi;
    private Long parIdPembayaran;
    private String parNip;
    private String parStatusHer;
    private Long parIdKategoriCatatan;
    private String parKeterangan;
    private Long parIdValidasi;
    private String parNamaValidasi;
    private Character parStatusEksekusi;
    private String parMsg;
    private Long parIdPembayaranVal;

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

    public void setParIdPembayaran(Long parIdPembayaran){
        this.parIdPembayaran = parIdPembayaran;
    }

    public Long getParIdPembayaran(){
        return this.parIdPembayaran;
    }

    public void setParNip(String parNip){
        this.parNip = parNip;
    }

    public String getParNip(){
        return this.parNip;
    }

    public void setParStatusHer(String parStatusHer){
        this.parStatusHer = parStatusHer;
    }

    public String getParStatusHer(){
        return this.parStatusHer;
    }

    public void setParIdKategoriCatatan(Long parIdKategoriCatatan){
        this.parIdKategoriCatatan = parIdKategoriCatatan;
    }

    public Long getParIdKategoriCatatan(){
        return this.parIdKategoriCatatan;
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

    public void setParStatusEksekusi(Character parStatusEksekusi){
        this.parStatusEksekusi = parStatusEksekusi;
    }

    public Character getParStatusEksekusi(){
        return this.parStatusEksekusi;
    }

    public void setParMsg(String parMsg){
        this.parMsg = parMsg;
    }

    public String getParMsg(){
        return this.parMsg;
    }

    public void setParIdPembayaranVal(Long parIdPembayaranVal){
        this.parIdPembayaranVal = parIdPembayaranVal;
    }

    public Long getParIdPembayaranVal(){
        return this.parIdPembayaranVal;
    }

    public void fromPlainText(CuspPembayaranMpNfPlainDto plainDto){
        if(plainDto.getParRoleId() != null && !plainDto.getParRoleId().equals(""))
            this.setParRoleId(Long.valueOf( plainDto.getParRoleId()));
        this.setParCompName( plainDto.getParCompName());
        this.setParUserName( plainDto.getParUserName());
        this.setParPeriodeMutasi( plainDto.getParPeriodeMutasi());
        if(plainDto.getParIdPembayaran() != null && !plainDto.getParIdPembayaran().equals(""))
            this.setParIdPembayaran( Long.valueOf( plainDto.getParIdPembayaran() ) ) ;
        this.setParNip( plainDto.getParNip());
        this.setParStatusHer( plainDto.getParStatusHer());
        if(plainDto.getParIdKategoriCatatan() != null && !plainDto.getParIdKategoriCatatan().equals(""))
            this.setParIdKategoriCatatan( Long.valueOf( plainDto.getParIdKategoriCatatan() ) );
        this.setParKeterangan( plainDto.getParKeterangan());

        if(plainDto.getParIdValidasi() != null && !plainDto.getParIdValidasi().equals(""))
            this.setParIdValidasi( Long.valueOf( plainDto.getParIdValidasi()));
        this.setParNamaValidasi( plainDto.getParNamaValidasi());

        if(plainDto.getParStatusEksekusi() != null && !plainDto.getParStatusEksekusi().equals(""))
            this.setParStatusEksekusi( plainDto.getParStatusEksekusi().charAt(0));
        this.setParMsg( plainDto.getParMsg());
        if(plainDto.getParIdPembayaranVal() != null && !plainDto.getParIdPembayaranVal().equals(""))
        this.setParIdPembayaranVal(Long.valueOf( plainDto.getParIdPembayaranVal()));
    }

}