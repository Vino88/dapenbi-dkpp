package com.dapenbi.dkpp.form;

public class CuspPmbyUangPembinaanHeadSPDto extends BaseFormDto  {
    private Long parRoleId;
    private String parCompName;
    private String parUserName;
    private Long parIdUangPembinaanH;
    private String parPeriodeBayar;
    private Long parNominalPerNip;
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

    public void setParIdUangPembinaanH(Long parIdUangPembinaanH){
        this.parIdUangPembinaanH = parIdUangPembinaanH;
    }

    public Long getParIdUangPembinaanH(){
        return this.parIdUangPembinaanH;
    }

    public void setParPeriodeBayar(String parPeriodeBayar){
        this.parPeriodeBayar = parPeriodeBayar;
    }

    public String getParPeriodeBayar(){
        return this.parPeriodeBayar;
    }

    public void setParNominalPerNip(Long parNominalPerNip){
        this.parNominalPerNip = parNominalPerNip;
    }

    public Long getParNominalPerNip(){
        return this.parNominalPerNip;
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



    public void fromPlainText(CuspPmbyUangPembinaanHeadPlainDto plainDto){
        this.setParCompName( plainDto.getParCompName());
        this.setParUserName( plainDto.getParUserName());
        this.setParIdUangPembinaanH( plainDto.getParIdUangPembinaanH().equals("")? null:Long.valueOf(plainDto.getParIdUangPembinaanH()));
        this.setParPeriodeBayar( plainDto.getParPeriodeBayar());
        this.setParNominalPerNip( plainDto.getParNominalPerNip() == null?null:Long.valueOf(plainDto.getParNominalPerNip()));
        this.setParKeterangan( plainDto.getParKeterangan());
        this.setParIdValidasi( plainDto.getParIdValidasi()== null?null:Long.valueOf(plainDto.getParIdValidasi()));
        this.setParNamaValidasi( plainDto.getParNamaValidasi());

    }

}
