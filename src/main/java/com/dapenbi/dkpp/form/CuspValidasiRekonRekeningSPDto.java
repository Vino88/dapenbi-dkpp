package com.dapenbi.dkpp.form;

public class CuspValidasiRekonRekeningSPDto extends BaseFormDto  {
    private Long parRoleId;
    private String parCompName;
    private String parUserName;
    private String parPeriode;
    private String parNip;
    private Long parIdValidasi;
    private String parNamaValidasi;
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

    public void setParNip(String parNip){
        this.parNip = parNip;
    }

    public String getParNip(){
        return this.parNip;
    }

    public void setParIdValidasi(Long parIdValidasi){
        this.parIdValidasi = parIdValidasi;
    }

    public Long getParIdValidasi(){
        return this.parIdValidasi;
    }

    public void setParNamaValidasi(String parNamaValidasi){
        this.parNamaValidasi = parNamaValidasi;
    }

    public String getParNamaValidasi(){
        return this.parNamaValidasi;
    }

    public void setParStatusEksekusi(String parStatusEksekusi){
        this.parStatusEksekusi = parStatusEksekusi;
    }

    public String getParStatusEksekusi(){
        return this.parStatusEksekusi;
    }


    public void fromPlainText(CuspValidasiRekonRekeningPlainDto plainDto){
        this.setParRoleId( Long.valueOf(plainDto.getParRoleId()) );
        this.setParCompName( plainDto.getParCompName());
        this.setParUserName( plainDto.getParUserName());
        this.setParPeriode( plainDto.getParPeriode());
        this.setParNip( plainDto.getParNip());
        this.setParIdValidasi(Long.valueOf( plainDto.getParIdValidasi() ));
        this.setParNamaValidasi( plainDto.getParNamaValidasi());
    }

}
