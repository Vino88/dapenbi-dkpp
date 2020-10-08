package com.dapenbi.dkpp.model;


import com.dapenbi.dkpp.dto.PredikatPemberhentianDto;

import javax.persistence.*;

@Entity
@Table(name = "TBL_R_PREDIKAT_PEMBERHENTIAN")
public class PredikatPemberhentian extends BaseModel<PredikatPemberhentianDto>{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PREDIKAT_PEMBERHENTIAN_SEQ")
    @SequenceGenerator(sequenceName = "predikatId_seq", allocationSize = 1, name = "PREDIKAT_PEMBERHENTIAN_SEQ")
    @Column(name = "id_predikat")
    private Long id;

    @Column(name = "nama_predikat")
    private String namaPemberhentian;

    public PredikatPemberhentian() {
        this.isActive = true;
    }


    public PredikatPemberhentian(String namaPemberhentian) {
        this.namaPemberhentian = namaPemberhentian;
        this.isActive = true;
    }

//    public PredikatPemberhentian() {
//
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaPemberhentian() {
        return namaPemberhentian;
    }

    public void setNamaPemberhentian(String namaPemberhentian) {
        this.namaPemberhentian = namaPemberhentian;
    }

    @Override
    public void fromDto(PredikatPemberhentianDto dto) {

        this.setId(dto.getId());
        this.setNamaPemberhentian(dto.getNamaPemberhentian());
        this.setActive(dto.isActive());
    }

    @Override
    public PredikatPemberhentianDto toDto() {
        PredikatPemberhentianDto dto = new PredikatPemberhentianDto();

        dto.setId(this.getId());
        dto.setNamaPemberhentian(this.getNamaPemberhentian());
        dto.setActive(this.isActive());

        return dto;
    }
}
