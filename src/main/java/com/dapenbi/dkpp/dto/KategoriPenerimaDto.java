package com.dapenbi.dkpp.dto;

public class KategoriPenerimaDto extends BaseDto {
    private Long id;
    private String namaKategoriPenerima;
    private String statusKategoriPenerima;
    private int urutan;
    private boolean active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String toString(){
        return "{" +
                    "id : '" + this.getId() + "'," +
                    "namaKategoriPenerima: '" + this.getNamaKategoriPenerima() + "'," +
                    "statusKategoriPenerima: '" + this.getStatusKategoriPenerima() + "'," +
                    "urutan: '" + this.getUrutan() + "'," +
                    "isActive: '" + this.getActive() + "'" +
                "}";
    }
}
