package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dto.OlahragaDto;
import com.dapenbi.dkpp.dto.RekeningPenerimaMpDto;

import javax.persistence.*;

@Entity
@Table(name="TBL_R_OLAHRAGA")
public class Olahraga extends BaseModel<OlahragaDto>{

    @Id
    @Column(name="ID_OLAHRAGA", unique=true, nullable=false, precision=38)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OLAHRAGA_ID_SEQ")
    @SequenceGenerator(sequenceName = "olahragaId_seq", allocationSize = 1, name = "OLAHRAGA_ID_SEQ")
    private long id;

    @Column(name="NAMA_OLAHRAGA", nullable=false, length=20)
    private String namaOlahraga;
    public Olahraga() {
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNamaOlahraga() {
        return namaOlahraga;
    }

    public void setNamaOlahraga(String namaOlahraga) {
        this.namaOlahraga = namaOlahraga;
    }

    public void fromDto(OlahragaDto dto) {
        this.setId(dto.getId());
        this.setNamaOlahraga(dto.getNamaOlahraga());
    }

    public OlahragaDto toDto() {
        OlahragaDto dto = new OlahragaDto();
        dto.setId(this.getId());
        dto.setNamaOlahraga(this.getNamaOlahraga());
        dto.setActive(this.isActive());
        return dto;
    }
}
