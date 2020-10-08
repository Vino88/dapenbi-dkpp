package com.dapenbi.dkpp.form;

import com.dapenbi.dkpp.dto.JenisBankDto;

import java.util.Map;

public class JenisBankFormDto {
    private Long id;

    private String jenisBank;

    private Map active;

    private String userStamp;

    public JenisBankFormDto(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJenisBank() {
        return jenisBank;
    }

    public void setJenisBank(String jenisBank) {
        this.jenisBank = jenisBank;
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
