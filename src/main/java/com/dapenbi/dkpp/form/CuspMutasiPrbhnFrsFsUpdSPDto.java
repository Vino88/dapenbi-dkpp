package com.dapenbi.dkpp.form;

import com.dapenbi.dkpp.util.DateUtil;

import java.util.Date;

public class CuspMutasiPrbhnFrsFsUpdSPDto extends BaseFormDto {
    private Long parRoleId;
    private String parUserName;
    private String parCompName;
    private Long parIdMutasi;
    private String parPeriodeMutasi;
    private Date parTglMutasi;
    private String parKeterangan;
    private Long parIdKategoriCatatan;
    private String parNamaKategoriCatatan;
    private Long parIdValidasi;
    private String parNamaValidasi;

    public void setParRoleId(Long parRoleId){
        this.parRoleId = parRoleId;
    }

    public Long getParRoleId(){
        return this.parRoleId;
    }

    public void setParUserName(String parUserName){
        this.parUserName = parUserName;
    }

    public String getParUserName(){
        return this.parUserName;
    }

    public void setParCompName(String parCompName){
        this.parCompName = parCompName;
    }

    public String getParCompName(){
        return this.parCompName;
    }

    public void setParIdMutasi(Long parIdMutasi){
        this.parIdMutasi = parIdMutasi;
    }

    public Long getParIdMutasi(){
        return this.parIdMutasi;
    }

    public void setParKeterangan(String parKeterangan){
        this.parKeterangan = parKeterangan;
    }

    public String getParKeterangan(){
        return this.parKeterangan;
    }

    public void setParIdKategoriCatatan(Long parIdKategoriCatatan){
        this.parIdKategoriCatatan = parIdKategoriCatatan;
    }

    public Long getParIdKategoriCatatan(){
        return this.parIdKategoriCatatan;
    }

    public void setParNamaKategoriCatatan(String parNamaKategoriCatatan){
        this.parNamaKategoriCatatan = parNamaKategoriCatatan;
    }

    public String getParNamaKategoriCatatan(){
        return this.parNamaKategoriCatatan;
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

    public String getParPeriodeMutasi() {
        return parPeriodeMutasi;
    }

    public void setParPeriodeMutasi(String parPeriodeMutasi) {
        this.parPeriodeMutasi = parPeriodeMutasi;
    }

    public Date getParTglMutasi() {
        return parTglMutasi;
    }

    public void setParTglMutasi(Date parTglMutasi) {
        this.parTglMutasi = parTglMutasi;
    }

    public void fromPlainText(CuspMutasiPrbhnFrsFsUpdPlainDto plainDto){
        this.setParUserName( plainDto.getParUserName());
        this.setParCompName( plainDto.getParCompName());
        this.setParIdMutasi( Long.valueOf(plainDto.getParIdMutasi()));
        this.setParPeriodeMutasi(plainDto.getParPeriodeMutasi());
        this.setParTglMutasi(DateUtil.stringToDate(plainDto.getParTglMutasi(),"dd/MM/yyyy"));
        this.setParKeterangan( plainDto.getParKeterangan());
        this.setParIdKategoriCatatan( Long.valueOf(plainDto.getParIdKategoriCatatan()));
        this.setParNamaKategoriCatatan( plainDto.getParNamaKategoriCatatan());
        this.setParIdValidasi( Long.valueOf(plainDto.getParIdValidasi()));
        this.setParNamaValidasi( plainDto.getParNamaValidasi());
    }
}
