package com.dapenbi.dkpp.form;

public class MutasiPensiunBaruReportFormDto {
    private String nip;
    private String idKategoriMutasi;
    private String idKategoriPensiun;
    private String idJenisMps;
    private String periodeMutasi;

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getIdKategoriMutasi() {
        return idKategoriMutasi;
    }

    public void setIdKategoriMutasi(String idKategoriMutasi) {
        this.idKategoriMutasi = idKategoriMutasi;
    }

    public String getIdKategoriPensiun() {
        return idKategoriPensiun;
    }

    public void setIdKategoriPensiun(String idKategoriPensiun) {
        this.idKategoriPensiun = idKategoriPensiun;
    }

    public String getIdJenisMps() {
        return idJenisMps;
    }

    public void setIdJenisMps(String idJenisMps) {
        this.idJenisMps = idJenisMps;
    }

    public String getPeriodeMutasi() {
        return periodeMutasi;
    }

    public void setPeriodeMutasi(String periodeMutasi) {
        this.periodeMutasi = periodeMutasi;
    }
}
