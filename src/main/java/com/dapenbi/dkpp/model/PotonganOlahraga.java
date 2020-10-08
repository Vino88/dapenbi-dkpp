package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dto.PotonganOlahragaDto;
import com.dapenbi.dkpp.model.CompositeId.PotonganOlahragaPK;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "TBL_T_POTONGAN_OLAHRAGA")
@IdClass(PotonganOlahragaPK.class)
public class PotonganOlahraga extends BaseModel<PotonganOlahragaDto> {

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

    @Column(name = "ID_OLAHRAGA", length = 20)
    private Long idOlahraga;

    @Column(name = "NAMA_OLAHRAGA", length = 100)
    private String namaOlahraga;

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

    public String getNamaPeserta() {
        return namaPeserta;
    }

    public void setNamaPeserta(String namaPeserta) {
        this.namaPeserta = namaPeserta;
    }

    public Long getIdOlahraga() {
        return idOlahraga;
    }

    public void setIdOlahraga(Long idOlahraga) {
        this.idOlahraga = idOlahraga;
    }

    public String getNamaOlahraga() {
        return namaOlahraga;
    }

    public void setNamaOlahraga(String namaOlahraga) {
        this.namaOlahraga = namaOlahraga;
    }

    public Double getPotongan() {
        return potongan;
    }

    public void setPotongan(Double potongan) {
        this.potongan = potongan;
    }

    @Override
    public void fromDto(PotonganOlahragaDto dto) {
        this.setPeriodeMutasi(dto.getPeriodeMutasi());
        this.setTglUpload(dto.getTglUpload());
        this.setNip(dto.getNip());
        this.setNip(dto.getNip());
        this.setNamaPeserta(dto.getNamaPeserta());
        this.setIdOlahraga(dto.getIdOlahraga());
        this.setNamaOlahraga(dto.getNamaOlahraga());
        this.setPotongan(dto.getPotongan());
    }

    @Override
    public PotonganOlahragaDto toDto() {
        PotonganOlahragaDto dto = new PotonganOlahragaDto();
        dto.setPeriodeMutasi(this.getPeriodeMutasi());
        dto.setTglUpload(this.getTglUpload());
        dto.setNip(this.getNip());
        dto.setNamaPeserta(this.getNamaPeserta());
        dto.setIdOlahraga(this.getIdOlahraga());
        dto.setNamaOlahraga(this.getNamaOlahraga());
        dto.setPotongan(this.getPotongan());
        dto.setUserStamp(this.getUserStamp());
        dto.setActive(this.isActive());
        return dto;
    }
}
