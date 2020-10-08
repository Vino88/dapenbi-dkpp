package com.dapenbi.dkpp.dto;

public class AlasanMps100Dto extends BaseDto {
    private Long idAlasanMps100;
    private String namaAlasanMps100;
    private boolean isActive;
    private String userStamp;

    public Long getIdAlasanMps100() {
        return idAlasanMps100;
    }

    public void setIdAlasanMps100(Long idAlasanMps100) {
        this.idAlasanMps100 = idAlasanMps100;
    }

    public String getNamaAlasanMps100() {
        return namaAlasanMps100;
    }

    public void setNamaAlasanMps100(String namaAlasanMps100) {
        this.namaAlasanMps100 = namaAlasanMps100;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getUserStamp() {
        return userStamp;
    }

    public void setUserStamp(String userStamp) {
        this.userStamp = userStamp;
    }
}
