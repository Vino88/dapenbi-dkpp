package com.dapenbi.dkpp.dto;

public class UserRoleDto {
    private UserDto idUser;
    private RoleDto idRole;

    public UserDto getIdUser() {
        return idUser;
    }

    public void setIdUser(UserDto idUser) {
        this.idUser = idUser;
    }

    public RoleDto getIdRole() {
        return idRole;
    }

    public void setIdRole(RoleDto idRole) {
        this.idRole = idRole;
    }
}
