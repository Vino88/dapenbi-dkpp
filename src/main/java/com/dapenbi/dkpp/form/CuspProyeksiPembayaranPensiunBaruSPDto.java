package com.dapenbi.dkpp.form;

public class CuspProyeksiPembayaranPensiunBaruSPDto extends BaseFormDto  {
    private String parCompName;
    private String parUserName;
    private String parTahunProyeksi;
    private Character parUntukProyeksi;
    private String parUserStamp;


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

    public void setParTahunProyeksi(String parTahunProyeksi){
        this.parTahunProyeksi = parTahunProyeksi;
    }

    public String getParTahunProyeksi(){
        return this.parTahunProyeksi;
    }

    public void setParUntukProyeksi(Character parUntukProyeksi){
        this.parUntukProyeksi = parUntukProyeksi;
    }

    public Character getParUntukProyeksi(){
        return this.parUntukProyeksi;
    }

    public void setParUserStamp(String parUserStamp){
        this.parUserStamp = parUserStamp;
    }

    public String getParUserStamp(){
        return this.parUserStamp;
    }


    public void fromPlainText(CuspProyeksiPembayaranPensiunBaruPlainDto plainDto){
        this.setParCompName( plainDto.getParCompName());
        this.setParUserName( plainDto.getParUserName());
        this.setParTahunProyeksi( plainDto.getParTahunProyeksi());
        this.setParUntukProyeksi( plainDto.getParUntukProyeksi().charAt(0));
        this.setParUserStamp( plainDto.getParUserStamp());
    }

}
