package com.dapenbi.dkpp.dto;


public class KecamatanDto extends BaseDto {
    private Long id;
    private String namaKecamatan;
    private KotaDto kota;
    private boolean isActive;

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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public KotaDto getKota() {
        return kota;
    }

    public void setKota(KotaDto kota) {
        this.kota = kota;
    }
}
