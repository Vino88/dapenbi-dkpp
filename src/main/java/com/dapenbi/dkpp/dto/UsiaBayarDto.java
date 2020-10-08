package com.dapenbi.dkpp.dto;

public class UsiaBayarDto extends BaseDto {

    private Long id;

    private String namaUsiaBayar;

    private Boolean isActive;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaUsiaBayar() {
        return namaUsiaBayar;
    }

    public void setNamaUsiaBayar(String namaUsiaBayar) {
        this.namaUsiaBayar = namaUsiaBayar;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
