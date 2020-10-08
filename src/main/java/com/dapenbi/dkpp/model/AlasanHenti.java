package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dto.AlasanHentiDto;

import javax.persistence.*;

@Entity
@Table(name = "TBL_R_ALASAN_HENTI")
public class AlasanHenti extends BaseModel<AlasanHentiDto> {

    @Id
    @Column(name = "id_henti", length = 2)
    private String id;

    private String keterangan;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public int getUrutan() {
        return urutan;
    }

    public void setUrutan(int urutan) {
        this.urutan = urutan;
    }

    private int urutan;

    public AlasanHenti() {
        this.isActive = true;
    }

    public AlasanHenti(String keterangan, int urutan) {
        this.keterangan = keterangan;
        this.urutan = urutan;
        this.isActive = true;
    }

    @Override
    public void fromDto(AlasanHentiDto dto) {
        this.id = dto.getId();
        this.keterangan = dto.getKeterangan();
        this.urutan = dto.getUrutan();
    }

    @Override
    public AlasanHentiDto toDto() {
        AlasanHentiDto dto = new AlasanHentiDto();
        dto.setId(this.id);
        dto.setIsActive(this.isActive());
        dto.setKeterangan(this.keterangan);
        return dto;
    }
}
