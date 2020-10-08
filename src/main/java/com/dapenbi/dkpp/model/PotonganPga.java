package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dto.PotonganPgaDto;
import com.dapenbi.dkpp.model.CompositeId.PotonganPgaPK;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TBL_T_POTONGAN_PGA")
@IdClass(PotonganPgaPK.class)
public class PotonganPga extends BaseModel<PotonganPgaDto> {

    @Id
    @Column(name = "PERIODE_MUTASI", length = 6)
    private String periodeMutasi;

    @Column(name = "TGL_UPLOAD")
    private Date tglUpload;

    @Id
    @Column(name = "NIP", length = 50)
    private String nip;

    @Column(name = "NAMA_PESERTA", length = 100)
    private String namaPeserta;

    @Column(name = "POTONGAN", precision = 20, scale = 2)
    private Long potongan;

    @Id
    @Column(name = "CODE", length = 20)
    private String code;

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

    public String getNamaPeserta() {
        return namaPeserta;
    }

    public void setNamaPeserta(String namaPeserta) {
        this.namaPeserta = namaPeserta;
    }

    public Long getPotongan() {
        return potongan;
    }

    public void setPotongan(Long potongan) {
        this.potongan = potongan;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public void fromDto(PotonganPgaDto dto) {
        this.setPeriodeMutasi(dto.getPeriodeMutasi());
        this.setTglUpload(dto.getTglUpload());
        this.setNip(dto.getNip());
        this.setNip(dto.getNip());
        this.setNamaPeserta(dto.getNamaPeserta());
        this.setPotongan(dto.getPotongan());
        this.setCode(dto.getCode());
    }

    @Override
    public PotonganPgaDto toDto() {
        PotonganPgaDto dto = new PotonganPgaDto();
        dto.setPeriodeMutasi(this.getPeriodeMutasi());
        dto.setTglUpload(this.getTglUpload());
        dto.setNip(this.getNip());
        dto.setNamaPeserta(this.getNamaPeserta());
        dto.setPotongan(this.getPotongan());
        dto.setUserStamp(this.getUserStamp());
        dto.setActive(this.isActive());
        dto.setCode(this.getCode());
        return dto;
    }
}
