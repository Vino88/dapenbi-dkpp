package com.dapenbi.dkpp.form;

import java.util.Map;

public class StatusKawinFormDto {

    private Long Id;
    private String statusKawin;
    private Map active;

    public StatusKawinFormDto(){

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getStatusKawin() {
        return statusKawin;
    }

    public void setStatusKawin(String statusKawin) {
        this.statusKawin = statusKawin;
    }

    public Map getActive() {
        return active;
    }

    public void setActive(Map active) {
        this.active = active;
    }
}
