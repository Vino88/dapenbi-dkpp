package com.dapenbi.dkpp.model.CompositeId;

import com.dapenbi.dkpp.model.Role;
import com.dapenbi.dkpp.model.User;

import java.io.Serializable;

public class UserRolePK implements Serializable {

    protected Long idUser;

    protected Long idRole;

    public UserRolePK(User idUser, Role idRole){
        this.idUser = idUser.getId();
        this.idRole = idRole.getId();
    }

    public UserRolePK() {
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Long getIdRole() {
        return idRole;
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
