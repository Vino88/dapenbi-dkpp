package com.dapenbi.dkpp.form;

import java.util.Map;

public class StatusBayarFormDto {

    private Long Id;
    private String statusBayar;
    private Map active;

    public StatusBayarFormDto(){

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getStatusBayar() {
        return statusBayar;
    }

    public void setStatusBayar(String statusBayar) {
        this.statusBayar = statusBayar;
    }

    public Map getActive() {
        return active;
    }

    public void setActive(Map active) {
        this.active = active;
    }
}
