package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dto.NegaraDto;

import javax.persistence.*;

@Entity
@Table(name = "TBL_M_NEGARA")

public class Negara extends BaseModel<NegaraDto> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NEGARA_ID_SEQ")
    @SequenceGenerator(sequenceName = "negaraId_seq", allocationSize = 1, name = "NEGARA_ID_SEQ")
    @Column(name = "id_negara")
    private Long id;

    @Column(name = "nama_negara", length = 50)
    private String namaNegara;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaNegara() {
        return namaNegara;
    }

    public void setNamaNegara(String namaNegara) {
        this.namaNegara = namaNegara;
    }

    @Override
    public void fromDto(NegaraDto dto) {
        this.setId(dto.getId());
        this.setNamaNegara(dto.getNamaNegara());
        this.setActive(dto.getActive());
    }

    @Override
    public NegaraDto toDto() {
        NegaraDto dto = new NegaraDto();

        dto.setId(this.getId());
        dto.setNamaNegara(this.getNamaNegara());
        dto.setActive(this.isActive());

        return dto;
    }
}
