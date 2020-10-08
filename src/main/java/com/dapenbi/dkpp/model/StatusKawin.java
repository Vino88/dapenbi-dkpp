package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dto.StatusKawinDto;

import javax.persistence.*;

@Entity
@Table(name = "TBL_R_STATUS_KAWIN")
public class StatusKawin extends BaseModel<StatusKawinDto> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STATUS_KAWIN_ID_SEQ")
    @SequenceGenerator(sequenceName = "statusKawinId_seq", allocationSize = 1, name = "STATUS_KAWIN_ID_SEQ")
    @Column(name = "id_status_kawin")
    private Long id;

    @Column(name = "nama_status_kawin")
    private String statusKawin;

    public StatusKawin() {
    }

    public StatusKawin(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatusKawin() {
        return statusKawin;
    }

    public void setStatusKawin(String statusKawin) {
        this.statusKawin = statusKawin;
    }

    @Override
    public void fromDto(StatusKawinDto dto) {
        this.setId(dto.getId());
        this.setStatusKawin(dto.getStatusKawin());
        this.setActive(dto.isActive());
    }

    @Override
    public StatusKawinDto toDto() {
        StatusKawinDto dto = new StatusKawinDto();

        dto.setId(this.getId());
        dto.setStatusKawin(this.getStatusKawin());
        dto.setActive(this.isActive());

        return dto;
    }
}
