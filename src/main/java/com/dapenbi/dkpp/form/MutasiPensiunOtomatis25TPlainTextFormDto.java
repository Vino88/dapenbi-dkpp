package com.dapenbi.dkpp.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MutasiPensiunOtomatis25TPlainTextFormDto extends BaseFormDto {
    private String parCompName;
    private String parUserName;
    private String parIdMutasiPensiun;
    private String parIdKategoriCatatan;
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

    public String getParIdKategoriCatatan() {
        return parIdKategoriCatatan;
    }

    public void setParIdKategoriCatatan(String parIdKategoriCatatan) {
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

}
