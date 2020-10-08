package com.dapenbi.dkpp.form;

public class CuspKenaikanMpValidSPDto extends BaseFormDto  {
    private String parCompName;
    private String parUserName;
    private Long parIdMutasi;
    private Long parIdKategoriCatatan;
    private String parNamaKategoriCatatan;
    private String parKeterangan;
    private Long parIdValidasi;
    private String parNamaValidasi;


    public String getParCompName() {
        return parCompName;
    }

    public void setParCompName(String parCompName) {
        this.parCompName = parCompName;
    }

    public String getParUserName() {
        return parUserName;
    }

    public void setParUserName(String parUserName) {
        this.parUserName = parUserName;
    }

    public Long getParIdMutasi() {
        return parIdMutasi;
    }

    public void setParIdMutasi(Long parIdMutasi) {
        this.parIdMutasi = parIdMutasi;
    }

    public Long getParIdKategoriCatatan() {
        return parIdKategoriCatatan;
    }

    public void setParIdKategoriCatatan(Long parIdKategoriCatatan) {
        this.parIdKategoriCatatan = parIdKategoriCatatan;
    }

    public String getParNamaKategoriCatatan() {
        return parNamaKategoriCatatan;
    }

    public void setParNamaKategoriCatatan(String parNamaKategoriCatatan) {
        this.parNamaKategoriCatatan = parNamaKategoriCatatan;
    }

    public String getParKeterangan() {
        return parKeterangan;
    }

    public void setParKeterangan(String parKeterangan) {
        this.parKeterangan = parKeterangan;
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



    public void fromPlainText(CuspKenaikanMpValidPlainDto plainDto){
        this.setParCompName( plainDto.getParCompName());
        this.setParUserName( plainDto.getParUserName());
        this.setParIdMutasi( plainDto.getParIdMutasi()!=null?Long.valueOf(plainDto.getParIdMutasi()):null);
        this.setParIdKategoriCatatan( plainDto.getParIdKategoriCatatan()!=null?Long.valueOf(plainDto.getParIdKategoriCatatan()):null);
        this.setParNamaKategoriCatatan( plainDto.getParNamaKategoriCatatan());
        this.setParKeterangan( plainDto.getParKeterangan());
        this.setParIdValidasi( plainDto.getParIdValidasi()!=null?Long.valueOf(plainDto.getParIdValidasi()):null);
        this.setParNamaValidasi( plainDto.getParNamaValidasi());

    }

}
