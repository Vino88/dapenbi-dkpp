package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dto.RoleDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TBL_R_ROLES")
public class Role extends BaseModel<RoleDto> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROLE_ID_SEQ")
    @SequenceGenerator(sequenceName = "roleId_seq", allocationSize = 1, name = "ROLE_ID_SEQ")
    @Column(name = "id_role")
    private Long id;

    private String name;

    private String code;

    @ManyToMany(mappedBy="roles")
    private List<User> users = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "TBL_R_MENU_ROLE",
            joinColumns = { @JoinColumn(name = "id_role") },
            inverseJoinColumns = { @JoinColumn(name = "id_menu") })
    private List<Menu> menus = new ArrayList<>();

    public Role() {
        super();
    }

    public Role(String name, String code) {
        super();
        this.name = name;
        this.code = code;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    @Override
    public void fromDto(RoleDto dto) {
        this.setId(dto.getId());
        this.setName(dto.getName());
        this.setCode(dto.getCode());
        this.setActive(dto.isActive());
    }

    @Override
    public RoleDto toDto() {
        RoleDto dto = new RoleDto();

        dto.setId(this.getId());
        dto.setName(this.getName());
        dto.setCode(this.getCode());
        dto.setActive(this.isActive());

        return dto;
    }
}
