package com.dapenbi.dkpp.dto;

import com.dapenbi.dkpp.model.HerRegistrasiMpNFDetail;

import java.util.List;

public class HerRegistrasiMpNFHeaderDto {

    private String tahunHer;
    private String statusHer;
    private Long totalHer;
    private String userStamp;
    private List<HerRegistrasiMpNFDetailDto> herRegistrasiMpNFDetailDto;

    public List<HerRegistrasiMpNFDetailDto> getHerRegistrasiMpNFDetailDto() {
        return herRegistrasiMpNFDetailDto;
    }

    public void setHerRegistrasiMpNFDetailDto(List<HerRegistrasiMpNFDetailDto> herRegistrasiMpNFDetailDto) {
        this.herRegistrasiMpNFDetailDto = herRegistrasiMpNFDetailDto;
    }

    public String getTahunHer() {
        return tahunHer;
    }

    public void setTahunHer(String tahunHer) {
        this.tahunHer = tahunHer;
    }

    public String getStatusHer() {
        return statusHer;
    }

    public void setStatusHer(String statusHer) {
        this.statusHer = statusHer;
    }

    public Long getTotalHer() {
        return totalHer;
    }

    public void setTotalHer(Long totalHer) {
        this.totalHer = totalHer;
    }

    public String getUserStamp() {
        return userStamp;
    }

    public void setUserStamp(String userStamp) {
        this.userStamp = userStamp;
    }
}
