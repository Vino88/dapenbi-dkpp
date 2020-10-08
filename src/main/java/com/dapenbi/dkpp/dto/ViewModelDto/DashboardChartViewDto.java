package com.dapenbi.dkpp.dto.ViewModelDto;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

public class DashboardChartViewDto {

    private Long jumlahPenerima;

    private String namaKantorBayar;

    private String periodeMutasi;

    private Character userStamp;

    private Date createdAt;

    private Date updatedAt;

    public Long getJumlahPenerima() {
        return jumlahPenerima;
    }

    public void setJumlahPenerima(Long jumlahPenerima) {
        this.jumlahPenerima = jumlahPenerima;
    }

    public String getNamaKantorBayar() {
        return namaKantorBayar;
    }

    public void setNamaKantorBayar(String namaKantorBayar) {
        this.namaKantorBayar = namaKantorBayar;
    }

    public String getPeriodeMutasi() {
        return periodeMutasi;
    }

    public void setPeriodeMutasi(String periodeMutasi) {
        this.periodeMutasi = periodeMutasi;
    }

    public Character getUserStamp() {
        return userStamp;
    }

    public void setUserStamp(Character userStamp) {
        this.userStamp = userStamp;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
