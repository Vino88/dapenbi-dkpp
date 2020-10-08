package com.dapenbi.dkpp.dto;

import java.util.Date;

public class AktuariaFsDto extends BaseDto {

    private String usiaFs;

    private Double fsPriaanak;

    private Double fsPriakawin;

    private Double fsPrialajang;

    private Double fsWanitaanak;

    private Double fsWanitakawin;

    private Double fsWanitalajang;

    private FaktorFsDto idFaktorFs;

    private boolean active;

    private String userStamp;



    public AktuariaFsDto() {
    }

    public String getUsiaFs() {
        return usiaFs;
    }

    public void setUsiaFs(String usiaFs) {
        this.usiaFs = usiaFs;
    }

    public Double getFsPriaanak() {
        return fsPriaanak;
    }

    public void setFsPriaanak(Double fsPriaanak) {
        this.fsPriaanak = fsPriaanak;
    }

    public Double getFsPriakawin() {
        return fsPriakawin;
    }

    public void setFsPriakawin(Double fsPriakawin) {
        this.fsPriakawin = fsPriakawin;
    }

    public Double getFsPrialajang() {
        return fsPrialajang;
    }

    public void setFsPrialajang(Double fsPrialajang) {
        this.fsPrialajang = fsPrialajang;
    }

    public Double getFsWanitaanak() {
        return fsWanitaanak;
    }

    public void setFsWanitaanak(Double fsWanitaanak) {
        this.fsWanitaanak = fsWanitaanak;
    }

    public Double getFsWanitakawin() {
        return fsWanitakawin;
    }

    public void setFsWanitakawin(Double fsWanitakawin) {
        this.fsWanitakawin = fsWanitakawin;
    }

    public Double getFsWanitalajang() {
        return fsWanitalajang;
    }

    public void setFsWanitalajang(Double fsWanitalajang) {
        this.fsWanitalajang = fsWanitalajang;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public FaktorFsDto getIdFaktorFs() {
        return idFaktorFs;
    }

    public void setIdFaktorFs(FaktorFsDto idFaktorFs) {
        this.idFaktorFs = idFaktorFs;
    }

    public String getUserStamp() {
        return userStamp;
    }

    public void setUserStamp(String userStamp) {
        this.userStamp = userStamp;
    }
}
