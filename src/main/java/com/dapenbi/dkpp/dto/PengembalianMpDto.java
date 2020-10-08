package com.dapenbi.dkpp.dto;

import java.util.Date;

public class PengembalianMpDto extends BaseDto {


    private Long id;

    private MPensiunDto nip;

    private String namaPeserta;

    private String periodeMutasi;

    private Date tglMutasi;

    private String idPenerimaMp;

    private String namaPenerimaMp;

    private String kategoriPengembalian;

    private Date tglTransfer;

    private Long nominalTransfer;

    private KategoriCatatanDto idKategoriCatatan;

    private String namaKategoriCatatan;

    private String keterangan;

    private StatusValidasiDto idValidasi;

    private String userValidasi;

    private String namaValidasi;

    private String userStamp;

    private Boolean isActive;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MPensiunDto getNip() {
        return nip;
    }

    public void setNip(MPensiunDto nip) {
        this.nip = nip;
    }

    public String getNamaPeserta() {
        return namaPeserta;
    }

    public void setNamaPeserta(String namaPeserta) {
        this.namaPeserta = namaPeserta;
    }

    public String getPeriodeMutasi() {
        return periodeMutasi;
    }

    public void setPeriodeMutasi(String periodeMutasi) {
        this.periodeMutasi = periodeMutasi;
    }

    public Date getTglMutasi() {
        return tglMutasi;
    }

    public void setTglMutasi(Date tglMutasi) {
        this.tglMutasi = tglMutasi;
    }

    public String getIdPenerimaMp() {
        return idPenerimaMp;
    }

    public void setIdPenerimaMp(String idPenerimaMp) {
        this.idPenerimaMp = idPenerimaMp;
    }

    public String getNamaPenerimaMp() {
        return namaPenerimaMp;
    }

    public void setNamaPenerimaMp(String namaPenerimaMp) {
        this.namaPenerimaMp = namaPenerimaMp;
    }

    public String getKategoriPengembalian() {
        return kategoriPengembalian;
    }

    public void setKategoriPengembalian(String kategoriPengembalian) {
        this.kategoriPengembalian = kategoriPengembalian;
    }

    public Date getTglTransfer() {
        return tglTransfer;
    }

    public void setTglTransfer(Date tglTransfer) {
        this.tglTransfer = tglTransfer;
    }

    public Long getNominalTransfer() {
        return nominalTransfer;
    }

    public void setNominalTransfer(Long nominalTransfer) {
        this.nominalTransfer = nominalTransfer;
    }

    public KategoriCatatanDto getIdKategoriCatatan() {
        return idKategoriCatatan;
    }

    public void setIdKategoriCatatan(KategoriCatatanDto idKategoriCatatan) {
        this.idKategoriCatatan = idKategoriCatatan;
    }

    public String getNamaKategoriCatatan() {
        return namaKategoriCatatan;
    }

    public void setNamaKategoriCatatan(String namaKategoriCatatan) {
        this.namaKategoriCatatan = namaKategoriCatatan;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public StatusValidasiDto getIdValidasi() {
        return idValidasi;
    }

    public void setIdValidasi(StatusValidasiDto idValidasi) {
        this.idValidasi = idValidasi;
    }

    public String getUserValidasi() {
        return userValidasi;
    }

    public void setUserValidasi(String userValidasi) {
        this.userValidasi = userValidasi;
    }

    public String getNamaValidasi() {
        return namaValidasi;
    }

    public void setNamaValidasi(String namaValidasi) {
        this.namaValidasi = namaValidasi;
    }

    public String getUserStamp() {
        return userStamp;
    }

    public void setUserStamp(String userStamp) {
        this.userStamp = userStamp;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
