package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dto.AgamaDto;
import com.dapenbi.dkpp.dto.StatusValidasiDto;

import javax.persistence.*;

@Entity
@Table(name = "TBL_R_STATUS_VALIDASI")
public class StatusValidasi extends BaseModel<StatusValidasiDto> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STATUS_VALIDASI_SEQ")
    @SequenceGenerator(sequenceName = "statusValidasi_seq", allocationSize = 1, name = "STATUS_VALIDASI_SEQ")
    @Column(name = "id_validasi")
    private Long id;

    @Column(name = "nama_validasi", length = 20)
    private String namaValidasi;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaValidasi() {
        return namaValidasi;
    }

    public void setNamaValidasi(String namaValidasi) {
        this.namaValidasi = namaValidasi;
    }

    @Override
    public void fromDto(StatusValidasiDto dto) {
        this.setId(dto.getId());
        this.setNamaValidasi(dto.getNamaValidasi());
        this.setActive(dto.isActive());
    }

    @Override
    public StatusValidasiDto toDto() {
        StatusValidasiDto dto = new StatusValidasiDto();

        dto.setId(this.getId());
        dto.setNamaValidasi(this.getNamaValidasi());
        dto.setActive(this.isActive());

        return dto;
    }
}
