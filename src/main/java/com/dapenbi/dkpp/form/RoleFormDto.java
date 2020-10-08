package com.dapenbi.dkpp.form;

import java.util.Map;

public class RoleFormDto {

    private Long idRole;
    private Map isActive;
    private String userStamp;
    private String code;
    private String name;

    public Long getIdRole() {
        return idRole;
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }

    public Map getIsActive() {
        return isActive;
    }

    public void setIsActive(Map isActive) {
        this.isActive = isActive;
    }

    public String getUserStamp() {
        return userStamp;
    }

    public void setUserStamp(String userStamp) {
        this.userStamp = userStamp;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
