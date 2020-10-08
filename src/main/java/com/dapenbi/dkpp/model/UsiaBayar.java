package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dto.AlasanHentiDto;
import com.dapenbi.dkpp.dto.UsiaBayarDto;

import javax.persistence.*;

@Entity
@Table(name = "tbl_r_usia_bayar")
public class UsiaBayar extends BaseModel<UsiaBayarDto> {

    @Id
    @Column(name = "id_usia_bayar")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USIA_BAYAR_ID_SEQ")
    @SequenceGenerator(sequenceName = "usiaBayarId_seq", allocationSize = 1, name = "USIA_BAYAR_ID_SEQ")
    private Long id;

    @Column(name = "nama_usia_bayar", length = 50)
    private String namaUsiaBayar;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaUsiaBayar() {
        return namaUsiaBayar;
    }

    public void setNamaUsiaBayar(String namaUsiaBayar) {
        this.namaUsiaBayar = namaUsiaBayar;
    }

    @Override
    public void fromDto(UsiaBayarDto dto) {
        this.setId(dto.getId());
        this.setNamaUsiaBayar(dto.getNamaUsiaBayar());
        this.setActive(dto.getActive());
    }

    @Override
    public UsiaBayarDto toDto() {
        UsiaBayarDto dto = new UsiaBayarDto();

        dto.setId(this.getId());
        dto.setNamaUsiaBayar(this.getNamaUsiaBayar());
        dto.setActive(this.isActive());

        return dto;
    }
}
