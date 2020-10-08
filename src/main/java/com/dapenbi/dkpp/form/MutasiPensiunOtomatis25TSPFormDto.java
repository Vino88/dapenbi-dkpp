package com.dapenbi.dkpp.form;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MutasiPensiunOtomatis25TSPFormDto extends BaseFormDto {
    private String parCompName;
    private String parUserName;
    private String parIdMutasiPensiun;
    private Long parIdKategoriCatatan;
    private String parKeterangan;
    private String parIdValidasi;
    private String parNamaValidasi;

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

    public String getParIdMutasiPensiun() {
        return parIdMutasiPensiun;
    }

    public void setParIdMutasiPensiun(String parIdMutasiPensiun) {
        this.parIdMutasiPensiun = parIdMutasiPensiun;
    }

    public Long getParIdKategoriCatatan() {
        return parIdKategoriCatatan;
    }

    public void setParIdKategoriCatatan(Long parIdKategoriCatatan) {
        this.parIdKategoriCatatan = parIdKategoriCatatan;
    }

    public String getParKeterangan() {
        return parKeterangan;
    }

    public void setParKeterangan(String parKeterangan) {
        this.parKeterangan = parKeterangan;
    }

    public String getParIdValidasi() {
        return parIdValidasi;
    }

    public void setParIdValidasi(String parIdValidasi) {
        this.parIdValidasi = parIdValidasi;
    }

    public String getParNamaValidasi() {
        return parNamaValidasi;
    }

    public void setParNamaValidasi(String parNamaValidasi) {
        this.parNamaValidasi = parNamaValidasi;
    }

    public void fromPlainText(MutasiPensiunOtomatis25TPlainTextFormDto plainDto){
        this.setParCompName(plainDto.getParCompName());
        this.setParUserName(plainDto.getParUserName());
        this.setParIdMutasiPensiun(plainDto.getParIdMutasiPensiun());
        this.setParIdKategoriCatatan(plainDto.getParIdKategoriCatatan().equals("")?null:Long.valueOf(plainDto.getParIdKategoriCatatan()));
        this.setParKeterangan(plainDto.getParKeterangan());
        this.setParIdValidasi(plainDto.getParIdValidasi());
        this.setParNamaValidasi(plainDto.getParNamaValidasi());
    }

    private Date stringToDate(String dateInString){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        try {

            Date date = formatter.parse(dateInString);
            return date;

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
