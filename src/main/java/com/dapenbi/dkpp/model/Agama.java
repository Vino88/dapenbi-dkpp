package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dto.AgamaDto;

import javax.persistence.*;

@Entity
@Table(name = "TBL_R_AGAMA")
public class Agama extends BaseModel<AgamaDto> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AGAMA_ID_SEQ")
    @SequenceGenerator(sequenceName = "agamaId_seq", allocationSize = 1, name = "AGAMA_ID_SEQ")
    @Column(name = "id_agama")
    private Long id;

    @Column(name = "nama_agama", length = 25)
    private String namaAgama;

    public Agama() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaAgama() {
        return namaAgama;
    }

    public void setNamaAgama(String namaAgama) {
        this.namaAgama = namaAgama;
    }

    @Override
    public void fromDto(AgamaDto dto) {
        this.setId(dto.getId());
        this.setNamaAgama(dto.getNamaAgama());
        this.setActive(dto.isActive());
    }

    @Override
    public AgamaDto toDto() {
        AgamaDto dto = new AgamaDto();

        dto.setId(this.getId());
        dto.setNamaAgama(this.getNamaAgama());
        dto.setActive(this.isActive());

        return dto;
    }
}
