package com.dapenbi.dkpp.dto;


public class AktuariaFprDto extends BaseDto {

    private FaktorFprDto idfaktorfpr;
    private String usia;
    private String namafaktorfpr;
    private Double nilaifpr;
    private boolean isActive;
    private String userStamp;

    public FaktorFprDto getIdfaktorfpr() {
        return idfaktorfpr;
    }

    public void setIdfaktorfpr(FaktorFprDto idfaktorfpr) {
        this.idfaktorfpr = idfaktorfpr;
    }

    public String getNamafaktorfpr() {
        return namafaktorfpr;
    }

    public void setNamafaktorfpr(String namafaktorfpr) {
        this.namafaktorfpr = namafaktorfpr;
    }

    public String getUsia() {
        return usia;
    }

    public void setUsia(String usia) {
        this.usia = usia;
    }

    public Double getNilaifpr() {
        return nilaifpr;
    }

    public void setNilaifpr(Double nilaifpr) {
        this.nilaifpr = nilaifpr;
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
