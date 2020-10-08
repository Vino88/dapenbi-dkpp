package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dto.AppConfigDto;

import javax.persistence.*;

@Entity
@Table(name = "TBL_R_APP_CONFIG")
public class AppConfig extends BaseModel<AppConfigDto> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APP_CONFIG_ID_SEQ")
    @SequenceGenerator(sequenceName = "appConfigId_seq", allocationSize = 1, name = "APP_CONFIG_ID_SEQ")
    @Column(name = "id_config")
    private Long id;

    @Column(name = "nama_config", length = 100)
    private String namaConfig;

    @Column(name = "nilai_config", length = 100)
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

    @Override
    public void fromDto(AppConfigDto dto) {

    }

    @Override
    public AppConfigDto toDto() {
        return null;
    }
}
