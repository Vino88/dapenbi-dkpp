package com.dapenbi.dkpp.dto;

public class KantorBayarDto extends BaseDto {
    private String id;
    private String namaKantorBayar;
    private String alamatSurat1;
    private String alamatSurat2;
    private String alamatSurat3;
    private String alamatSurat4;
    private boolean active;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getAlamatSurat4() {
        return alamatSurat4;
    }

    public void setAlamatSurat4(String alamatSurat4) {
        this.alamatSurat4 = alamatSurat4;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String toString(){
        return "{" +
                    "id : '" + this.getId() + "'," +
                    "namaKantor: '" + this.getNamaKantorBayar() + "'," +
                    "alamatSurat1: '" + this.getAlamatSurat1() + "'," +
                    "alamatSurat2: '" + this.getAlamatSurat2() + "'," +
                    "alamatSurat3: '" + this.getAlamatSurat3() + "'" +
                "}";
    }
}
