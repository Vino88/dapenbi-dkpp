package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dto.MenuDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TBL_R_MENUS")
public class Menu extends BaseModel<MenuDto> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MENU_ID_SEQ")
    @SequenceGenerator(sequenceName = "menuId_seq", allocationSize = 1, name = "MENU_ID_SEQ")
    @Column(name = "id_menu")
    private Long id;

    private Long parent;

    @Column(name = "menu_order")
    private int menuOrder;

    private String title;

    private String path;

    private String icon;

    private String style;

    private Boolean sidebar;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "TBL_R_MENU_ROLE",
            joinColumns = { @JoinColumn(name = "id_menu") },
            inverseJoinColumns = { @JoinColumn(name = "id_role") })
    private List<Role> roles = new ArrayList<>();

    public Menu() {
        super();
    }

    public Menu(int menuOrder, String title, Boolean sidebar) {
        super();
        this.menuOrder = menuOrder;
        this.title = title;
        this.sidebar = sidebar;
    }

    public Menu(int menuOrder, String title, String path, String icon, String style, Boolean sidebar) {
        super();
        this.menuOrder = menuOrder;
        this.title = title;
        this.path = path;
        this.icon = icon;
        this.style = style;
        this.sidebar = sidebar;
    }

    public Menu(Long parent, int menuOrder, String title, String path, String icon, String style, Boolean sidebar) {
        super();
        this.parent = parent;
        this.menuOrder = menuOrder;
        this.title = title;
        this.path = path;
        this.icon = icon;
        this.style = style;
        this.sidebar = sidebar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParent() {
        return parent;
    }

    public void setParent(Long parent) {
        this.parent = parent;
    }

    public int getMenuOrder() {
        return menuOrder;
    }

    public void setMenuOrder(int menuOrder) {
        this.menuOrder = menuOrder;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public Boolean isSidebar() {
        return sidebar;
    }

    public void setSidebar(Boolean sidebar) {
        this.sidebar = sidebar;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void addRole(Role role) {
        this.roles.add(role);
        role.getMenus().add(this);
    }

    public void removeRole(Role role) {
        this.roles.remove(role);
        role.getMenus().remove(this);
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public void fromDto(MenuDto dto) {
        this.setId(dto.getId());
        this.setParent(dto.getParent());
        this.setMenuOrder(dto.getMenuOrder());
        this.setTitle(dto.getTitle());
        this.setPath(dto.getPath());
        this.setIcon(dto.getIcon());
        this.setStyle(dto.getStyle());
        this.setActive(dto.isActive());
    }

    @Override
    public MenuDto toDto() {
        MenuDto dto = new MenuDto();

        dto.setId(this.getId());
        dto.setParent(this.getParent());
        dto.setMenuOrder(this.getMenuOrder());
        dto.setTitle(this.getTitle());
        dto.setPath(this.getPath());
        dto.setIcon(this.getIcon());
        dto.setStyle(this.getStyle());
        dto.setActive(this.isActive());

        return dto;
    }
}
