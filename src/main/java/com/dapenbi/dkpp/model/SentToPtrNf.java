package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dto.SentToPtrNfDto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "TBL_T_SENT_TO_PTR_NF")
public class SentToPtrNf extends BaseModel<SentToPtrNfDto> {
    @Id
    @Column(name = "ID_PTR_NF", length = 22)
    private Long idPtrNf;
    @Column(name = "TGL_TRANSAKSI", length = 7)
    private Date tglTransaksi;
    @Column(name = "PERIODE_TRANSAKSI", length = 6)
    private String periodeTransaksi;
    @Column(name = "ID_REF", length = 22)
    private Long idRef;
    @Column(name = "NOMINAL", length = 22)
    private Long nominal;
    @Column(name = "KETERANGAN", length = 100)
    private String keterangan;
    @Column(name = "SUMBER", length = 20)
    private String sumber;
    @Column(name = "USER_STAMP", length = 100)
    private String userStamp;


    public Long getIdPtrNf() {
        return idPtrNf;
    }

    public void setIdPtrNf(Long idPtrNf) {
        this.idPtrNf = idPtrNf;
    }

    public Date getTglTransaksi() {
        return tglTransaksi;
    }

    public void setTglTransaksi(Date tglTransaksi) {
        this.tglTransaksi = tglTransaksi;
    }

    public String getPeriodeTransaksi() {
        return periodeTransaksi;
    }

    public void setPeriodeTransaksi(String periodeTransaksi) {
        this.periodeTransaksi = periodeTransaksi;
    }

    public Long getIdRef() {
        return idRef;
    }

    public void setIdRef(Long idRef) {
        this.idRef = idRef;
    }

    public Long getNominal() {
        return nominal;
    }

    public void setNominal(Long nominal) {
        this.nominal = nominal;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getSumber() {
        return sumber;
    }

    public void setSumber(String sumber) {
        this.sumber = sumber;
    }

    public String getUserStamp() {
        return userStamp;
    }

    public void setUserStamp(String userStamp) {
        this.userStamp = userStamp;
    }

    @Override
    public void fromDto(SentToPtrNfDto dto) {
        this.setIdPtrNf(dto.getIdPtrNf());
        this.setIdRef(dto.getIdRef());
        this.setPeriodeTransaksi(dto.getPeriodeTransaksi());
        this.setNominal(dto.getNominal());
        this.setKeterangan(dto.getKeterangan());
        this.setTglTransaksi(dto.getTglTransaksi());
        this.setSumber(dto.getSumber());
        this.setUserStamp(dto.getUserStamp());
    }

    @Override
    public SentToPtrNfDto toDto() {
    SentToPtrNfDto dto = new SentToPtrNfDto();

        dto.setIdPtrNf(this.getIdPtrNf());
        dto.setIdRef(this.getIdRef());
        dto.setPeriodeTransaksi(this.getPeriodeTransaksi());
        dto.setNominal(this.getNominal());
        dto.setKeterangan(this.getKeterangan());
        dto.setTglTransaksi(this.getTglTransaksi());
        dto.setSumber(this.getSumber());
        dto.setUserStamp(this.getUserStamp());

        return dto;
    }
}