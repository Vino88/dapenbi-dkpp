package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dto.SuskelDto;

import javax.persistence.*;

@Entity
@Table(name = "tbl_r_suskel")
public class Suskel extends BaseModel<SuskelDto> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SUSKEL_ID_SEQ")
    @SequenceGenerator(sequenceName = "suskelId_seq", allocationSize = 1, name = "SUSKEL_ID_SEQ")
    @Column(name = "id_suskel")
    private Long id;

    @Column(name = "nama_suskel", length = 50)
    private String namaSuskel;

    @Column(name = "kode_suskel", length = 20)
    private String kodeSuskel;

    @Column(length = 2)
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaSuskel() {
        return namaSuskel;
    }

    public void setNamaSuskel(String namaSuskel) {
        this.namaSuskel = namaSuskel;
    }

    public String getKodeSuskel() {
        return kodeSuskel;
    }

    public void setKodeSuskel(String kodeSuskel) {
        this.kodeSuskel = kodeSuskel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public void fromDto(SuskelDto dto) {
        this.setId(dto.getId());
        this.setNamaSuskel(dto.getNamaSuskel());
        this.setKodeSuskel(dto.getKodeSuskel());
        this.setStatus(dto.getStatus());
        this.setActive(dto.getActive());
    }

    @Override
    public SuskelDto toDto() {
        SuskelDto dto = new SuskelDto();
        dto.setId(this.getId());
        dto.setNamaSuskel(this.getNamaSuskel());
        dto.setKodeSuskel(this.getKodeSuskel());
        dto.setStatus(this.getStatus());
        dto.setActive(this.isActive());
        return dto;
    }
}
