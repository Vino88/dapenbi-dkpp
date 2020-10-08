package com.dapenbi.dkpp.form;

public class HerRegistrasiUpdateFormDto {

    private Long roleId;
    private String compName;
    private String userName;
    private String parTahun ;
    private String parStatusHer;
    private Long parIdValidasi;
    private String parNamaValidasi;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getParTahun() {
        return parTahun;
    }

    public void setParTahun(String parTahun) {
        this.parTahun = parTahun;
    }

    public String getParStatusHer() {
        return parStatusHer;
    }

    public void setParStatusHer(String parStatusHer) {
        this.parStatusHer = parStatusHer;
    }

    public Long getParIdValidasi() {
        return parIdValidasi;
    }

    public void setParIdValidasi(Long parIdValidasi) {
        this.parIdValidasi = parIdValidasi;
    }

    public String getParNamaValidasi() {
        return parNamaValidasi;
    }

    public void setParNamaValidasi(String parNamaValidasi) {
        this.parNamaValidasi = parNamaValidasi;
    }
}
