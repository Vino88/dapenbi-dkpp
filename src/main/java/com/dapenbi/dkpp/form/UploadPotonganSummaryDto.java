package com.dapenbi.dkpp.form;

public class UploadPotonganSummaryDto extends BaseFormDto {

    String totalRow;
    String jumlah;
    String jenisPotongan;
    String tglUpload;
    String periodeMutasi;


    public String getTotalRow() {
        return totalRow;
    }

    public void setTotalRow(String totalRow) {
        this.totalRow = totalRow;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public String getJenisPotongan() {
        return jenisPotongan;
    }

    public void setJenisPotongan(String jenisPotongan) {
        this.jenisPotongan = jenisPotongan;
    }

    public String getTglUpload() {
        return tglUpload;
    }

    public void setTglUpload(String tglUpload) {
        this.tglUpload = tglUpload;
    }

    public String getPeriodeMutasi() {
        return periodeMutasi;
    }

    public void setPeriodeMutasi(String periodeMutasi) {
        this.periodeMutasi = periodeMutasi;
    }
}
