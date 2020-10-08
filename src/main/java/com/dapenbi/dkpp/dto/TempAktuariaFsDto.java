package com.dapenbi.dkpp.dto;

public class TempAktuariaFsDto {
    private Long id;
    private String userStamp;
    private String anakL;
    private String anakP;
    private String bulan;
    private String priaK;
    private String priaL;
    private String tahun;
    private String wanitaK;
    private String wanitaL;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserStamp(String userStamp) {
        this.userStamp = userStamp;
    }

    public String getUserStamp() {
        return this.userStamp;
    }

    public void setAnakL(String anakL) {
        this.anakL = anakL;
    }

    public String getAnakL() {
        return this.anakL;
    }

    public void setAnakP(String anakP) {
        this.anakP = anakP;
    }

    public String getAnakP() {
        return this.anakP;
    }

    public void setBulan(String bulan) {
        this.bulan = bulan;
    }

    public String getBulan() {
        return this.bulan;
    }

    public void setPriaK(String priaK) {
        this.priaK = priaK;
    }

    public String getPriaK() {
        return this.priaK;
    }

    public void setPriaL(String priaL) {
        this.priaL = priaL;
    }

    public String getPriaL() {
        return this.priaL;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    public String getTahun() {
        return this.tahun;
    }

    public void setWanitaK(String wanitaK) {
        this.wanitaK = wanitaK;
    }

    public String getWanitaK() {
        return this.wanitaK;
    }

    public void setWanitaL(String wanitaL) {
        this.wanitaL = wanitaL;
    }

    public String getWanitaL() {
        return this.wanitaL;
    }
}

