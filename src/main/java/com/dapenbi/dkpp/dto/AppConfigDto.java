package com.dapenbi.dkpp.dto;

public class AppConfigDto extends BaseDto {
    private Long id;
    private String namaConfig;
    private String nilaiConfig;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaConfig() {
        return namaConfig;
    }

    public void setNamaConfig(String namaConfig) {
        this.namaConfig = namaConfig;
    }

    public String getNilaiConfig() {
        return nilaiConfig;
    }

    public void setNilaiConfig(String nilaiConfig) {
        this.nilaiConfig = nilaiConfig;
    }
}
