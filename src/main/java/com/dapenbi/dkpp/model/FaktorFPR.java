package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dto.FaktorFprDto;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TBL_R_FAKTOR_FPR")
public class FaktorFPR extends BaseModel<FaktorFprDto> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FAKTOR_FPR_ID_SEQ")
    @SequenceGenerator(sequenceName = "faktorFprId_seq", allocationSize = 1, name = "FAKTOR_FPR_ID_SEQ")
    @Column(name = "id_faktor_fpr")
    private Long id;

    @Column(name = "tgl_awal")
    private Date tglawal;

    @Column(name = "tgl_akhir")
    private Date tglakhir;

    @Column(name = "nama_faktor_fpr")
    private String namafaktor;

    @Column(name = "keterangan_faktor_fpr")
    private String keteranganfaktor;


    public FaktorFPR(Long id) {
        this.id = id;
    }

    public FaktorFPR() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTglawal() {
        return tglawal;
    }

    public void setTglawal(Date tglawal) {
        this.tglawal = tglawal;
    }

    public Date getTglakhir() {
        return tglakhir;
    }

    public void setTglakhir(Date tglakhir) {
        this.tglakhir = tglakhir;
    }

    public String getNamafaktor() {
        return namafaktor;
    }

    public void setNamafaktor(String namafaktor) {
        this.namafaktor = namafaktor;
    }

    public String getKeteranganfaktor() {
        return keteranganfaktor;
    }

    public void setKeteranganfaktor(String keteranganfaktor) {
        this.keteranganfaktor = keteranganfaktor;
    }

    @Override
    public void fromDto(FaktorFprDto dto) {
        this.setId(dto.getId());
        this.setTglawal(dto.getTglawal());
        this.setTglakhir(dto.getTglakhir());
        this.setNamafaktor(dto.getNamafaktor());
        this.setKeteranganfaktor(dto.getKeteranganfaktor());
        this.setActive(dto.isActive());
    }

    @Override
    public FaktorFprDto toDto() {
        FaktorFprDto dto = new FaktorFprDto();
        dto.setId(this.getId());
        dto.setTglawal(this.getTglawal());
        dto.setTglakhir(this.getTglakhir());
        dto.setNamafaktor(this.getNamafaktor());
        dto.setActive(this.isActive());
        dto.setKeteranganfaktor(this.getKeteranganfaktor());
        return dto;
    }
}
