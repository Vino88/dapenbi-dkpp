package com.dapenbi.dkpp.dto;

import java.util.Date;

public class PotonganOlahragaDto {
    private String periodeMutasi;

    private Date tglUpload;

    private String nip;

    private String namaPeserta;

    private Long idOlahraga;

    private String namaOlahraga;

    private Double potongan;

    private String userStamp;

    private Boolean isActive;

    public String getPeriodeMutasi() {
        return periodeMutasi;
    }

    public void setPeriodeMutasi(String periodeMutasi) {
        this.periodeMutasi = periodeMutasi;
    }

    public Date getTglUpload() {
        return tglUpload;
    }

    public void setTglUpload(Date tglUpload) {
        this.tglUpload = tglUpload;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNamaPeserta() {
        return namaPeserta;
    }

    public void setNamaPeserta(String namaPeserta) {
        this.namaPeserta = namaPeserta;
    }

    public Long getIdOlahraga() {
        return idOlahraga;
    }

    public void setIdOlahraga(Long idOlahraga) {
        this.idOlahraga = idOlahraga;
    }

    public String getNamaOlahraga() {
        return namaOlahraga;
    }

    public void setNamaOlahraga(String namaOlahraga) {
        this.namaOlahraga = namaOlahraga;
    }

    public Double getPotongan() {
        return potongan;
    }

    public void setPotongan(Double potongan) {
        this.potongan = potongan;
    }

    public String getUserStamp() {
        return userStamp;
    }

    public void setUserStamp(String userStamp) {
        this.userStamp = userStamp;
    }

    public Boolean isActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
