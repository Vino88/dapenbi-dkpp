package com.dapenbi.dkpp.form;

public class UserRoleFormDto extends BaseFormDto {

    private Long idUser;
    private Long idRole;

    private Long idUserUpdate;
    private Long idRoleUpdate;

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

    public Long getIdUserUpdate() {
        return idUserUpdate;
    }

    public void setIdUserUpdate(Long idUserUpdate) {
        this.idUserUpdate = idUserUpdate;
    }

    public Long getIdRoleUpdate() {
        return idRoleUpdate;
    }

    public void setIdRoleUpdate(Long idRoleUpdate) {
        this.idRoleUpdate = idRoleUpdate;
    }
}
