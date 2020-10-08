package com.dapenbi.dkpp.dto;

public class SuskelDto extends BaseDto {

    private Long id;

    private String namaSuskel;

    private String kodeSuskel;

    private String status;

    private Boolean isActive;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaSuskel() {
        return namaSuskel;
    }

    public void setNamaSuskel(String namaSuskel) {
        this.namaSuskel = namaSuskel;
    }

    public String getKodeSuskel() {
        return kodeSuskel;
    }

    public void setKodeSuskel(String kodeSuskel) {
        this.kodeSuskel = kodeSuskel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
