package com.dapenbi.dkpp.form;

import java.util.Map;

public class UserFormDto {

    private Long id;

    private String name;

    private String username;

    private Map resetLoginCount;

    private String newPassword;

    private Map active;

    public UserFormDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Map isResetLoginCount() {
        return resetLoginCount;
    }

    public void setResetLoginCount(Map resetLoginCount) {
        this.resetLoginCount = resetLoginCount;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public Map getActive() {
        return active;
    }

    public void setActive(Map active) {
        this.active = active;
    }
}
