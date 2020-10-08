package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dto.UserDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TBL_R_USERS")
public class User extends BaseModel<UserDto> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_ID_SEQ")
    @SequenceGenerator(sequenceName = "userId_seq", allocationSize = 1, name = "USER_ID_SEQ")
    @Column(name = "id_user")
    private Long id;

    private String name;

    private String username;

    private String password;

    private String email;

    @Column(name = "last_login")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;

    @Column(name = "login_retry_count")
    private int loginRetryCount;

    @Column(name = "last_login_ip")
    private String lastLoginIP;

    @Column(name = "confirmation_key")
    private String confirmationKey;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "TBL_R_USER_ROLE",
            joinColumns = { @JoinColumn(name = "id_user") },
            inverseJoinColumns = { @JoinColumn(name = "id_role") })
    private List<Role> roles = new ArrayList<>();

    public User() {
        super();
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public int getLoginRetryCount() {
        return loginRetryCount;
    }

    public void setLoginRetryCount(int loginRetryCount) {
        this.loginRetryCount = loginRetryCount;
    }

    public String getLastLoginIP() {
        return lastLoginIP;
    }

    public void setLastLoginIP(String lastLoginIP) {
        this.lastLoginIP = lastLoginIP;
    }

    public String getConfirmationKey() {
        return confirmationKey;
    }

    public void setConfirmationKey(String confirmationKey) {
        this.confirmationKey = confirmationKey;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public void addRole(Role role) {
        this.roles.add(role);
        role.getUsers().add(this);
    }

    public void removeRole(Role role) {
        this.roles.remove(role);
        role.getUsers().remove(this);
    }

    @Override
    public void fromDto(UserDto dto) {
        this.setId(dto.getId());
        this.setName(dto.getName());
        this.setUsername(dto.getUsername());
        this.setPassword(dto.getPassword());
        this.setEmail(dto.getEmail());
        this.setLastLogin(dto.getLastLogin());
        this.setLastLoginIP(dto.getLastLoginIP());
        this.setLoginRetryCount(dto.getLoginRetryCount());
        this.setActive(dto.isActive());
        this.setConfirmationKey(dto.getConfirmationKey());
    }

    @Override
    public UserDto toDto() {
        UserDto dto = new UserDto();

        dto.setId(this.getId());
        dto.setName(this.getName());
        dto.setUsername(this.getUsername());
        dto.setPassword(this.getPassword());
        dto.setEmail(this.getEmail());
        dto.setLastLogin(this.getLastLogin());
        dto.setLastLoginIP(this.getLastLoginIP());
        dto.setLoginRetryCount(this.getLoginRetryCount());
        dto.setActive(this.isActive());
        dto.setConfirmationKey(this.getConfirmationKey());

        return dto;
    }
}
