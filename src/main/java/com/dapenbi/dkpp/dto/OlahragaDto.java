package com.dapenbi.dkpp.dto;

public class OlahragaDto extends BaseDto {

    boolean active;

    private long id;

    private String namaOlahraga;


    public OlahragaDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNamaOlahraga() {
        return namaOlahraga;
    }

    public void setNamaOlahraga(String namaOlahraga) {
        this.namaOlahraga = namaOlahraga;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean getActive() {
        return active;
    }
}
