package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dto.ProvinsiDto;

import javax.persistence.*;

@Entity
@Table(name = "TBL_M_PROVINSI")
public class Provinsi extends BaseModel<ProvinsiDto> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROVINSI_SEQ")
    @SequenceGenerator(sequenceName = "provinsiId_seq", allocationSize = 1, name = "PROVINSI_SEQ")

    @Column(name = "id_provinsi")
    private Long id;

    @Column(name = "nama_provinsi")
    private String namaProvinsi;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaProvinsi() {
        return namaProvinsi;
    }

    public void setNamaProvinsi(String namaProvinsi) {
        this.namaProvinsi = namaProvinsi;
    }

    @Override
    public void fromDto(ProvinsiDto dto) {
        this.setId(dto.getId());
        this.setNamaProvinsi(dto.getNamaProvinsi());
        this.setActive(dto.isActive());
    }

    @Override
    public ProvinsiDto toDto() {
        ProvinsiDto dto = new ProvinsiDto();
        dto.setId(this.getId());
        dto.setNamaProvinsi(this.getNamaProvinsi());
        dto.setActive(this.isActive());
        return dto;
    }
}
