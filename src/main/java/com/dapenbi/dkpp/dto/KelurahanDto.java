package com.dapenbi.dkpp.dto;

public class KelurahanDto extends BaseDto {
    private Long id;
    private String namaKelurahan;
    private String kodePos;
    private boolean isActive;
    private KecamatanDto kecamatan;

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

    public String getKodePos() {
        return kodePos;
    }

    public void setKodePos(String kodePos) {
        this.kodePos = kodePos;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public KecamatanDto getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(KecamatanDto kecamatan) {
        this.kecamatan = kecamatan;
    }
}
