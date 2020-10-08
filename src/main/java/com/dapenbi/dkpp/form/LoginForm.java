package com.dapenbi.dkpp.form;

import javax.validation.constraints.NotEmpty;

public class LoginForm {

    @NotEmpty(message = "Username can't be empty")
    private String username;

    @NotEmpty(message = "Password can't be empty")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
