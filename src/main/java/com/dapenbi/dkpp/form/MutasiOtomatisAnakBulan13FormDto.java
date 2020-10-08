package com.dapenbi.dkpp.form;

import java.math.BigDecimal;

public class MutasiOtomatisAnakBulan13FormDto extends BaseFormDto {

    private Long parRoleId;
    private String parCompName;
    private String parUserName;
    private String parPeriodeMutasi;
    private Long parIdMutasi;
    private String parNip;
    private BigDecimal parMpydBaru;
    private Long parIdKategoriCatatan;
    private String parNamaKategoriCatatan;
    private String parKeterangan;
    private Long parIdValidasi;
    private String parNamaValidasi;

    public Long getParRoleId() {
        return parRoleId;
    }

    public void setParRoleId(Long parRoleId) {
        this.parRoleId = parRoleId;
    }

    public String getParCompName() {
        return parCompName;
    }

    public void setParCompName(String parCompName) {
        this.parCompName = parCompName;
    }

    public String getParUserName() {
        return parUserName;
    }

    public void setParUserName(String parUserName) {
        this.parUserName = parUserName;
    }

    public String getParPeriodeMutasi() {
        return parPeriodeMutasi;
    }

    public void setParPeriodeMutasi(String parPeriodeMutasi) {
        this.parPeriodeMutasi = parPeriodeMutasi;
    }

    public Long getParIdMutasi() {
        return parIdMutasi;
    }

    public void setParIdMutasi(Long parIdMutasi) {
        this.parIdMutasi = parIdMutasi;
    }

    public String getParNip() {
        return parNip;
    }

    public void setParNip(String parNip) {
        this.parNip = parNip;
    }

    public BigDecimal getParMpydBaru() {
        return parMpydBaru;
    }

    public void setParMpydBaru(BigDecimal parMpydBaru) {
        this.parMpydBaru = parMpydBaru;
    }

    public Long getParIdKategoriCatatan() {
        return parIdKategoriCatatan;
    }

    public void setParIdKategoriCatatan(Long parIdKategoriCatatan) {
        this.parIdKategoriCatatan = parIdKategoriCatatan;
    }

    public String getParNamaKategoriCatatan() {
        return parNamaKategoriCatatan;
    }

    public void setParNamaKategoriCatatan(String parNamaKategoriCatatan) {
        this.parNamaKategoriCatatan = parNamaKategoriCatatan;
    }

    public String getParKeterangan() {
        return parKeterangan;
    }

    public void setParKeterangan(String parKeterangan) {
        this.parKeterangan = parKeterangan;
    }

    public Long getParIdValidasi() {
        return parIdValidasi;
    }

    public void setParIdValidasi(Long parIdValidasi) {
        this.parIdValidasi = parIdValidasi;
    }

    public String getParNamaValidasi() {
        return parNamaValidasi;
    }

    public void setParNamaValidasi(String parNamaValidasi) {
        this.parNamaValidasi = parNamaValidasi;
    }

    public void fromPlainText(MutasiOtomatisAnakBulan13PlainTextFormDto plainDto){
        this.setParCompName(plainDto.getParCompName());
        this.setParUserName(plainDto.getParUserName());
        this.setParPeriodeMutasi(plainDto.getParPeriodeMutasi());
        this.setParIdMutasi(plainDto.getParIdMutasi().equals("")?null:Long.valueOf(plainDto.getParIdMutasi()));
        this.setParNip(plainDto.getParNip());
        this.setParMpydBaru(plainDto.getParMpydBaru().equals("")?null:new BigDecimal(plainDto.getParMpydBaru()));
        this.setParIdKategoriCatatan(plainDto.getParIdKategoriCatatan().equals("")?null:Long.valueOf(plainDto.getParIdKategoriCatatan()));
        this.setParNamaKategoriCatatan(plainDto.getParNamaKategoriCatatan());
        this.setParKeterangan(plainDto.getParKeterangan());
        this.setParIdValidasi(plainDto.getParIdValidasi().equals("")?null:Long.valueOf(plainDto.getParIdValidasi()));
        this.setParNamaValidasi(plainDto.getParNamaValidasi());

    }
}
