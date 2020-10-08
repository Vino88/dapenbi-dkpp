package com.dapenbi.dkpp.form;

import java.util.Map;

public class KategoriPenerimaFormDto {

    private Long id;
    private String namaKategoriPenerima;
    private String statusKategoriPenerima;
    private int urutan;
    private Map active;

    public KategoriPenerimaFormDto(){}

    public String getNamaKategoriPenerima() {
        return namaKategoriPenerima;
    }

    public void setNamaKategoriPenerima(String namaKategoriPenerima) {
        this.namaKategoriPenerima = namaKategoriPenerima;
    }

    public String getStatusKategoriPenerima() {
        return statusKategoriPenerima;
    }

    public void setStatusKategoriPenerima(String statusKategoriPenerima) {
        this.statusKategoriPenerima = statusKategoriPenerima;
    }

    public int getUrutan() {
        return urutan;
    }

    public void setUrutan(int urutan) {
        this.urutan = urutan;
    }

    public Map getActive() {
        return active;
    }

    public void setActive(Map active) {
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String toString(){
        return "{" +
                "id : '" + this.getId() + "'," +
                "namaKategoriPenerima: '" + this.getNamaKategoriPenerima() + "'," +
                "statusKategoriPenerima: '" + this.getStatusKategoriPenerima() + "'," +
                "urutan: '" + this.getUrutan() + "'," +
                "isActive: " + this.getActive() + " " +
                "}";
    }
}
