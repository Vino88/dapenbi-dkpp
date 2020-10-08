package com.dapenbi.dkpp.form;

public class CuspUpdatePiutangBulananSPDto extends BaseFormDto  {
    private Long parRoleId;
    private String parCompName;
    private String parUserName;
    private Long parIdBayarPiutang;
    private String parKeterangan;
    private Long parIdValidasi;
    private String parNamaValidasi;

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

    public void setParIdBayarPiutang(Long parIdBayarPiutang){
        this.parIdBayarPiutang = parIdBayarPiutang;
    }

    public Long getParIdBayarPiutang(){
        return this.parIdBayarPiutang;
    }

    public void setParKeterangan(String parKeterangan){
        this.parKeterangan = parKeterangan;
    }

    public String getParKeterangan(){
        return this.parKeterangan;
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


    public void fromPlainText(CuspUpdatePiutangBulananPlainDto plainDto){
        this.setParCompName( plainDto.getParCompName());
        this.setParUserName( plainDto.getParUserName());
        this.setParIdBayarPiutang( plainDto.getParIdBayarPiutang().equals("")?null:Long.valueOf(plainDto.getParIdBayarPiutang()));
        this.setParKeterangan( plainDto.getParKeterangan());
        this.setParIdValidasi( plainDto.getParIdValidasi().equals("")?null:Long.valueOf(plainDto.getParIdValidasi()));
        this.setParNamaValidasi( plainDto.getParNamaValidasi());

    }

}
