package com.dapenbi.dkpp.form;

import java.util.Map;

public class KantorBayarFormDto {

    private String namaKantorBayar;
    private String alamatSurat1;
    private String alamatSurat2;
    private String alamatSurat3;

    public String getAlamatSurat4() {
        return alamatSurat4;
    }

    public void setAlamatSurat4(String alamatSurat4) {
        this.alamatSurat4 = alamatSurat4;
    }

    private String alamatSurat4;
    private Map active;

    public KantorBayarFormDto(){}

    private String id;

    public String getNamaKantorBayar() {
        return namaKantorBayar;
    }

    public void setNamaKantorBayar(String namaKantorBayar) {
        this.namaKantorBayar = namaKantorBayar;
    }

    public String getAlamatSurat1() {
        return alamatSurat1;
    }

    public void setAlamatSurat1(String alamatSurat1) {
        this.alamatSurat1 = alamatSurat1;
    }

    public String getAlamatSurat2() {
        return alamatSurat2;
    }

    public void setAlamatSurat2(String alamatSurat2) {
        this.alamatSurat2 = alamatSurat2;
    }

    public String getAlamatSurat3() {
        return alamatSurat3;
    }

    public void setAlamatSurat3(String alamatSurat3) {
        this.alamatSurat3 = alamatSurat3;
    }

    public Map getActive() {
        return active;
    }

    public void setActive(Map active) {
        this.active = active;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String toString(){
        return "{" +
                "id : '" + this.getId() + "'," +
                "namaKantorBayar: '" + this.getNamaKantorBayar() + "'," +
                "alamatSurat1: '" + this.getAlamatSurat1() + "'," +
                "alamatSurat2: '" + this.getAlamatSurat2() + "'," +
                "alamatSurat3: '" + this.getAlamatSurat3() + "'," +
                "isActive: " + this.getActive() + " " +
                "}";
    }
}
