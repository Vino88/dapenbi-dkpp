package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dto.JenisBankDto;

import javax.persistence.*;

@Entity
@Table(name = "TBL_R_JENIS_BANK")
public class JenisBank extends BaseModel<JenisBankDto> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "JENIS_BANK_ID_SEQ")
    @SequenceGenerator(sequenceName = "jenisBankId_seq", allocationSize = 1, name = "JENIS_BANK_ID_SEQ")
    @Column(name = "id_bank")
    private Long id;

    @Column(name = "jenis_bank")
    private String jenisBank;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJenisBank() {
        return jenisBank;
    }

    public void setJenisBank(String jenisBank) {
        this.jenisBank = jenisBank;
    }

    @Override
    public void fromDto(JenisBankDto dto) {
        this.setId(dto.getId());
        this.setJenisBank(dto.getJenisBank());
        this.setActive(dto.isActive());
    }

    @Override
    public JenisBankDto toDto() {
        JenisBankDto dto = new JenisBankDto();

        dto.setId(this.getId());
        dto.setJenisBank(this.getJenisBank());
        dto.setActive(this.isActive());

        return dto;
    }
}
