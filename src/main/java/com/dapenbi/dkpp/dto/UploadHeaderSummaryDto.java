package com.dapenbi.dkpp.dto;

import com.dapenbi.dkpp.form.BaseFormDto;

public class UploadHeaderSummaryDto extends BaseFormDto {

    String totalRow;
    String tglMulaiBerlaku;
    String jenisFaktor;
    String tglUpload;
    String periodeMulai;
    String compName;
    String userName;
    String keterangan;
    String namaFaktor;



    public String getTotalRow() {
        return totalRow;
    }

    public void setTotalRow(String totalRow) {
        this.totalRow = totalRow;
    }

    public String getJenisFaktor() {
        return jenisFaktor;
    }

    public void setJenisFaktor(String jenisFaktor) {
        this.jenisFaktor = jenisFaktor;
    }

    public String getTglUpload() {
        return tglUpload;
    }

    public void setTglUpload(String tglUpload) {
        this.tglUpload = tglUpload;
    }

    public String getPeriodeMulai() {
        return periodeMulai;
    }

    public void setPeriodeMulai(String periodeMulai) {
        this.periodeMulai = periodeMulai;
    }

    public String getTglMulaiBerlaku() {
        return tglMulaiBerlaku;
    }

    public void setTglMulaiBerlaku(String tglMulaiBerlaku) {
        this.tglMulaiBerlaku = tglMulaiBerlaku;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getNamaFaktor() {
        return namaFaktor;
    }

    public void setNamaFaktor(String namaFaktor) {
        this.namaFaktor = namaFaktor;
    }
}
