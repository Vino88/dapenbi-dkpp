package com.dapenbi.dkpp.dto.ViewModelDto;

import java.util.Date;

public class MutasiOtomatis25MP80ViewModelDto {
    private Long id;
    private Date tglProses;
    private String periodeMutasi;
    private String namaKategoriMutasi;
    private Long totalData;
    private Long belumValidasi;
    private Long sudahValidasi;
    private Long batalValidasi;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTglProses() {
        return tglProses;
    }

    public void setTglProses(Date tglProses) {
        this.tglProses = tglProses;
    }

    public String getPeriodeMutasi() {
        return periodeMutasi;
    }

    public void setPeriodeMutasi(String periodeMutasi) {
        this.periodeMutasi = periodeMutasi;
    }

    public String getNamaKategoriMutasi() {
        return namaKategoriMutasi;
    }

    public void setNamaKategoriMutasi(String namaKategoriMutasi) {
        this.namaKategoriMutasi = namaKategoriMutasi;
    }

    public Long getTotalData() {
        return totalData;
    }

    public void setTotalData(Long totalData) {
        this.totalData = totalData;
    }

    public Long getBelumValidasi() {
        return belumValidasi;
    }

    public void setBelumValidasi(Long belumValidasi) {
        this.belumValidasi = belumValidasi;
    }

    public Long getSudahValidasi() {
        return sudahValidasi;
    }

    public void setSudahValidasi(Long sudahValidasi) {
        this.sudahValidasi = sudahValidasi;
    }

    public Long getBatalValidasi() {
        return batalValidasi;
    }

    public void setBatalValidasi(Long batalValidasi) {
        this.batalValidasi = batalValidasi;
    }
}
