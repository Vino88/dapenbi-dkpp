package com.dapenbi.dkpp.dto;

public class JenisMpsDto extends BaseDto {

    private Long id;
    private String namamps;
    private boolean isActive;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamamps() {
        return namamps;
    }

    public void setNamamps(String namamps) {
        this.namamps = namamps;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
