package com.dapenbi.dkpp.form;

public class CuspPembayaranHutangNfPtr extends BaseFormDto{

    private String parCompName;
    private String parUserName;
    private Long parIdBayarHutangNf;
    private String parMutasiBayar;
    private Long parNominal;

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

    public Long getParIdBayarHutangNf() {
        return parIdBayarHutangNf;
    }

    public void setParIdBayarHutangNf(Long parIdBayarHutangNf) {
        this.parIdBayarHutangNf = parIdBayarHutangNf;
    }

    public String getParMutasiBayar() {
        return parMutasiBayar;
    }

    public void setParMutasiBayar(String parMutasiBayar) {
        this.parMutasiBayar = parMutasiBayar;
    }

    public Long getParNominal() {
        return parNominal;
    }

    public void setParNominal(Long parNominal) {
        this.parNominal = parNominal;
    }

    public void fromPlainText(CuspPembayaranHutangNfPtr plainDto){
        this.setParCompName( plainDto.getParCompName());
        this.setParUserName( plainDto.getParUserName());
        this.setParIdBayarHutangNf( plainDto.getParIdBayarHutangNf());
        this.setParMutasiBayar( plainDto.getParMutasiBayar());
        this.setParNominal( plainDto.getParNominal());

    }
}
