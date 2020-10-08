package com.dapenbi.dkpp.form;

import java.util.Map;

public class JenisMpsFormDto {

    private Long id;
    private String namamps;
    private Map active;

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

    public Map getActive() {
        return active;
    }

    public void setActive(Map active) {
        this.active = active;
    }
}
