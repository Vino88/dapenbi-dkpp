package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dto.StatusBayarDto;

import javax.persistence.*;

@Entity
@Table(name = "TBL_R_STATUS_BAYAR")
public class StatusBayar extends BaseModel<StatusBayarDto> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STATUS_BAYAR_ID_SEQ")
    @SequenceGenerator(sequenceName = "statusBayarId_seq", allocationSize = 1, name = "STATUS_BAYAR_ID_SEQ")
    @Column(name = "id_status_bayar")
    private Long id;

    @Column(name = "status_bayar")
    private String statusBayar;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatusBayar() {
        return statusBayar;
    }

    public void setStatusBayar(String statusBayar) {
        this.statusBayar = statusBayar;
    }

    @Override
    public void fromDto(StatusBayarDto dto) {
        this.setId(dto.getId());
        this.setStatusBayar(dto.getStatusBayar());
        this.setActive(dto.isActive());
    }


    @Override
    public StatusBayarDto toDto() {
        StatusBayarDto dto = new StatusBayarDto();

        dto.setId(this.getId());
        dto.setStatusBayar(this.getStatusBayar());
        dto.setActive(this.isActive());
        return dto;
    }
}
