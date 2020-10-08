package com.dapenbi.dkpp.dto;

public class PredikatPemberhentianDto extends BaseDto {

    private Long id;

    private String namaPemberhentian;

    private boolean isActive;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaPemberhentian() {
        return namaPemberhentian;
    }

    public void setNamaPemberhentian(String namaPemberhentian) {
        this.namaPemberhentian = namaPemberhentian;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

}
