package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dto.JenisMpsDto;

import javax.persistence.*;

@Entity
@Table(name = "TBL_R_JENIS_MPS")
public class JenisMps extends BaseModel<JenisMpsDto> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "JENISMPS_SEQ")
    @SequenceGenerator(sequenceName = "jenisMpsId_seq", allocationSize = 1, name = "JENISMPS_SEQ")
    @Column(name = "id_jenis_mps")
    private Long id;

    @Column(name = "nama_mps")
    private String namamps;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamamps() {
        return namamps;
    }

    public void setNamamps(String namamps) {
        this.namamps = namamps;
    }

    @Override
    public void fromDto(JenisMpsDto dto) {
        this.setId(dto.getId());
        this.setNamamps(dto.getNamamps());
        this.setActive(dto.isActive());
    }

    @Override
    public JenisMpsDto toDto() {
        JenisMpsDto dto = new JenisMpsDto();

        dto.setId(this.getId());
        dto.setNamamps(this.getNamamps());
        dto.setActive(this.isActive());

        return dto;

    }


}
