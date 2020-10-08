package com.dapenbi.dkpp.dto;

public class AlasanHentiDto extends BaseDto {
    private String id;
    private boolean isActive;
    private String keterangan;
    private int urutan;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public int getUrutan() {
        return urutan;
    }

    public void setUrutan(int urutan) {
        this.urutan = urutan;
    }

    public String toString(){
        return "{" +
                    "id : '" + this.getId() + "'," +
                    "keterangan: '" + this.getKeterangan() + "'," +
                    "urutan: '" + this.getUrutan() + "'" +
                "}";
    }
}
