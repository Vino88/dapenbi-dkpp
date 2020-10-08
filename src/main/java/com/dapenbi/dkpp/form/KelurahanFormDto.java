package com.dapenbi.dkpp.form;

import java.util.Map;

public class KelurahanFormDto {

    private Long id;
    private String namaKelurahan;
    private Long idKecamatan;
    private Map active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaKelurahan() {
        return namaKelurahan;
    }

    public void setNamaKelurahan(String namaKelurahan) {
        this.namaKelurahan = namaKelurahan;
    }

    public Long getIdKecamatan() {
        return idKecamatan;
    }

    public void setIdKecamatan(Long idKecamatan) {
        this.idKecamatan = idKecamatan;
    }

    public Map getActive() {
        return active;
    }

    public void setActive(Map active) {
        this.active = active;
    }
}
