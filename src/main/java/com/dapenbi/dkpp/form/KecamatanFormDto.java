package com.dapenbi.dkpp.form;

import java.util.Map;

public class KecamatanFormDto {

    private Long id;
    private String namaKecamatan;
    private Long idkota;
    private Map active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaKecamatan() {
        return namaKecamatan;
    }

    public void setNamaKecamatan(String namaKecamatan) {
        this.namaKecamatan = namaKecamatan;
    }

    public Long getIdkota() {
        return idkota;
    }

    public void setIdkota(Long idkota) {
        this.idkota = idkota;
    }

    public Map getActive() {
        return active;
    }

    public void setActive(Map active) {
        this.active = active;
    }
}
