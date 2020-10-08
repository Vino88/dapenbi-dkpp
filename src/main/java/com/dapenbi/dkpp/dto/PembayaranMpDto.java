package com.dapenbi.dkpp.dto;

import java.util.Date;

public class PembayaranMpDto extends BaseDto{

    private Long id;
    private String periodePembayaran;
    private Date tglDiproses;
    private String diprosesOleh;
    private Character isStatusBerhasil;
    private String keterangan;
    private String namaStatusBerhasil;
    private Character isSendToPtr;
    private String userStamp;
    private Boolean isActive;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPeriodePembayaran() {
        return periodePembayaran;
    }

    public void setPeriodePembayaran(String periodePembayaran) {
        this.periodePembayaran = periodePembayaran;
    }

    public Date getTglDiproses() {
        return tglDiproses;
    }

    public void setTglDiproses(Date tglDiproses) {
        this.tglDiproses = tglDiproses;
    }

    public String getDiprosesOleh() {
        return diprosesOleh;
    }

    public void setDiprosesOleh(String diprosesOleh) {
        this.diprosesOleh = diprosesOleh;
    }

    public Character getIsStatusBerhasil() {
        return isStatusBerhasil;
    }

    public void setIsStatusBerhasil(Character isStatusBerhasil) {
        this.isStatusBerhasil = isStatusBerhasil;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getNamaStatusBerhasil() {
        return namaStatusBerhasil;
    }

    public void setNamaStatusBerhasil(String namaStatusBerhasil) {
        this.namaStatusBerhasil = namaStatusBerhasil;
    }

    public String getUserStamp() {
        return userStamp;
    }

    public void setUserStamp(String userStamp) {
        this.userStamp = userStamp;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Character getIsSendToPtr() {
        return isSendToPtr;
    }

    public void setIsSendToPtr(Character isSendToPtr) {
        this.isSendToPtr = isSendToPtr;
    }
}
