package com.dapenbi.dkpp.form;


public class CuspProsesRekonRekeningSPDto extends BaseFormDto  {
    private Long parRoleId;
    private String parCompName;
    private String parUserName;
    private String parPeriode;
    private String parStatusEksekusi;
    private String parMsg;

    public void setParRoleId(Long parRoleId){
        this.parRoleId = parRoleId;
    }

    public Long getParRoleId(){
        return this.parRoleId;
    }

    public void setParCompName(String parCompName){
        this.parCompName = parCompName;
    }

    public String getParCompName(){
        return this.parCompName;
    }

    public void setParUserName(String parUserName){
        this.parUserName = parUserName;
    }

    public String getParUserName(){
        return this.parUserName;
    }

    public void setParPeriode(String parPeriode){
        this.parPeriode = parPeriode;
    }

    public String getParPeriode(){
        return this.parPeriode;
    }

    public void setParStatusEksekusi(String parStatusEksekusi){
        this.parStatusEksekusi = parStatusEksekusi;
    }

    public String getParStatusEksekusi(){
        return this.parStatusEksekusi;
    }

    public void setParMsg(String parMsg){
        this.parMsg = parMsg;
    }

    public String getParMsg(){
        return this.parMsg;
    }

    public void fromPlainText(CuspProsesRekonRekeningPlainDto plainDto){
        this.setParRoleId( Long.valueOf(plainDto.getParRoleId()) );
        this.setParCompName( plainDto.getParCompName());
        this.setParUserName( plainDto.getParUserName());
        this.setParPeriode( plainDto.getParPeriode());
    }

}
