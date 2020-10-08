package com.dapenbi.dkpp.form;

import java.util.Map;

public class NegaraFormDto {

    private Long id;

    private String namaNegara;

    private Map active;

    private String userStamp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaNegara() {
        return namaNegara;
    }

    public void setNamaNegara(String namaNegara) {
        this.namaNegara = namaNegara;
    }

    public Map getActive() {
        return active;
    }

    public void setActive(Map active) {
        this.active = active;
    }

    public String getUserStamp() {
        return userStamp;
    }

    public void setUserStamp(String userStamp) {
        this.userStamp = userStamp;
    }
}
