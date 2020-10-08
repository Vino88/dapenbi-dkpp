package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dto.PengolahanDataBerkalaKelDto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "TBL_T_REPORT_DATA_BERKALA_KEL")
public class PengolahanDataBerkalaKel extends BaseModel<PengolahanDataBerkalaKelDto> {
    @Id
    private String nip;
    @Column(name = "PERIODE", length = 6)
    private String periode;
    @Column(name = "ID_KELUARGA", length = 20)
    private String idKeluarga;
    @Column(name = "NAMA_KELUARGA", length = 20)
    private String namaKeluarga;
    @Column(name = "HUBUNGAN", length = 20)
    private String hubungan;
    @Column(name = "JENIS_KELAMIN", length = 1)
    private Character jenisKelamin;
    @Column(name = "TGL_LAHIR", length = 7)
    private Date tglLahir;
    @Column(name = "TGL_MENIKAH", length = 7)
    private Date tglMenikah;
    @Column(name = "TGL_CERAI", length = 7)
    private Date tglCerai;
    @Column(name = "TGL_WAFAT", length = 7)
    private Date tglWafat;
    @Column(name = "REQUEST_BY", length = 20)
    private String requestBy;
    @Column(name = "JENIS_REPORT", length = 22)
    private Long jenisReport;
    @Column(name = "USER_STAMP", length = 100)
    private String userStamp;

    public String getPeriode() {
        return periode;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getIdKeluarga() {
        return idKeluarga;
    }

    public void setIdKeluarga(String idKeluarga) {
        this.idKeluarga = idKeluarga;
    }

    public String getNamaKeluarga() {
        return namaKeluarga;
    }

    public void setNamaKeluarga(String namaKeluarga) {
        this.namaKeluarga = namaKeluarga;
    }

    public String getHubungan() {
        return hubungan;
    }

    public void setHubungan(String hubungan) {
        this.hubungan = hubungan;
    }

    public Character getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(Character jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public Date getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(Date tglLahir) {
        this.tglLahir = tglLahir;
    }

    public Date getTglMenikah() {
        return tglMenikah;
    }

    public void setTglMenikah(Date tglMenikah) {
        this.tglMenikah = tglMenikah;
    }

    public Date getTglCerai() {
        return tglCerai;
    }

    public void setTglCerai(Date tglCerai) {
        this.tglCerai = tglCerai;
    }

    public Date getTglWafat() {
        return tglWafat;
    }

    public void setTglWafat(Date tglWafat) {
        this.tglWafat = tglWafat;
    }

    public String getRequestBy() {
        return requestBy;
    }

    public void setRequestBy(String requestBy) {
        this.requestBy = requestBy;
    }

    public Long getJenisReport() {
        return jenisReport;
    }

    public void setJenisReport(Long jenisReport) {
        this.jenisReport = jenisReport;
    }

    public String getUserStamp() {
        return userStamp;
    }

    public void setUserStamp(String userStamp) {
        this.userStamp = userStamp;
    }

    @Override
    public void fromDto(PengolahanDataBerkalaKelDto dto) {

        this.setPeriode(dto.getPeriode());
        this.setNamaKeluarga(dto.getNamaKeluarga());
        this.setIdKeluarga(dto.getIdKeluarga());
        this.setHubungan(dto.getHubungan());
        this.setJenisKelamin(dto.getJenisKelamin());
        this.setJenisReport(dto.getJenisReport());
        this.setRequestBy(dto.getRequestBy());
        this.setTglLahir(dto.getTglLahir());
        this.setTglMenikah(dto.getTglMenikah());
        this.setTglCerai(dto.getTglCerai());
        this.setTglWafat(dto.getTglWafat());
        this.setUserStamp(dto.getUserStamp());

    }

    @Override
    public PengolahanDataBerkalaKelDto toDto() {
        PengolahanDataBerkalaKelDto dto = new PengolahanDataBerkalaKelDto();

        dto.setPeriode(this.getPeriode());
        dto.setNamaKeluarga(this.getNamaKeluarga());
        dto.setIdKeluarga(this.getIdKeluarga());
        dto.setHubungan(this.getHubungan());
        dto.setJenisKelamin(this.getJenisKelamin());
        dto.setJenisReport(this.getJenisReport());
        dto.setRequestBy(this.getRequestBy());
        dto.setTglLahir(this.getTglLahir());
        dto.setTglMenikah(this.getTglMenikah());
        dto.setTglCerai(this.getTglCerai());
        dto.setTglWafat(this.getTglWafat());
        dto.setUserStamp(this.getUserStamp());
        return dto;
    }

}
