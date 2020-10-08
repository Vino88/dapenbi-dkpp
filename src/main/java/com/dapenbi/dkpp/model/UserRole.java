package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dto.UserRoleDto;
import com.dapenbi.dkpp.model.CompositeId.AktuariaFprPK;
import com.dapenbi.dkpp.model.CompositeId.UserRolePK;

import javax.persistence.*;

@Entity
@Table(name="TBL_R_USER_ROLE")
@IdClass(UserRolePK.class)
public class UserRole extends BaseModel<UserRoleDto> {

    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="ID_USER", unique=true, nullable=false)
    private User idUser;

    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="ID_ROLE", nullable=false)
    private Role idRole;

    public UserRole(){
        this.idRole = new Role();
        this.idUser = new User();
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    public Role getIdRole() {
        return idRole;
    }

    public void setIdRole(Role idRole) {
        this.idRole = idRole;
    }

    @Override
    public void fromDto(UserRoleDto dto) {

    }

    @Override
    public UserRoleDto toDto() {
        UserRoleDto dto = new UserRoleDto();
        return dto;
    }
}
