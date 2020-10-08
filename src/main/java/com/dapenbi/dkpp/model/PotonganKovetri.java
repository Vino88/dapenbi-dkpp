package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dto.PotonganKovetriDto;
import com.dapenbi.dkpp.model.CompositeId.PotonganKovetriPK;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "TBL_T_POTONGAN_KOVETRI")
@IdClass(PotonganKovetriPK.class)
public class PotonganKovetri extends BaseModel<PotonganKovetriDto> {

    @Id
    @Column(name = "PERIODE_MUTASI", length = 6)
    private String periodeMutasi;

    @Column(name = "TGL_UPLOAD")
    private Date tglUpload;

    @Id
    @Column(name = "NIP", length = 50)
    private String nip;

    @Column(name = "POTONGAN", precision = 20, scale = 2)
    private Double potongan;

    public String getPeriodeMutasi() {
        return periodeMutasi;
    }

    public void setPeriodeMutasi(String periodeMutasi) {
        this.periodeMutasi = periodeMutasi;
    }

    public Date getTglUpload() {
        return tglUpload;
    }

    public void setTglUpload(Date tglUpload) {
        this.tglUpload = tglUpload;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public Double getPotongan() {
        return potongan;
    }

    public void setPotongan(Double potongan) {
        this.potongan = potongan;
    }

    @Override
    public void fromDto(PotonganKovetriDto dto) {
        this.setPeriodeMutasi(dto.getPeriodeMutasi());
        this.setTglUpload(dto.getTglUpload());
        this.setNip(dto.getNip());
        this.setNip(dto.getNip());
        this.setPotongan(dto.getPotongan());
    }

    @Override
    public PotonganKovetriDto toDto() {
        PotonganKovetriDto dto = new PotonganKovetriDto();
        dto.setPeriodeMutasi(this.getPeriodeMutasi());
        dto.setTglUpload(this.getTglUpload());
        dto.setNip(this.getNip());
        dto.setPotongan(this.getPotongan());
        dto.setUserStamp(this.getUserStamp());
        dto.setActive(this.isActive());
        return dto;
    }
}
