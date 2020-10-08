package com.dapenbi.dkpp.dto;

import java.util.Date;

public class PiutangDetailDto {

    private Long id;
    private Date tglMutasi;
    private String periodeMutasi;
    private MPensiunDto nip;
    private String namaPeserta;
    private Long jumlahPiutang;
    private String keterangan;
    private Long refMutasi;
    private String idPenerimaMp;
    private String namaPenerimaMp;
    private KategoriPenerimaDto idKategoriPenerimaMp;
    private String namaKategoriPenerimaMp;
    private KantorBayarDto idKantorBayar;
    private String namaKantorBayar;
    private StatusValidasiDto idValidasi;
    private String namaValidasi;
    private String userValidasi;
    private Boolean isActive;
    private String userStamp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTglMutasi() {
        return tglMutasi;
    }

    public void setTglMutasi(Date tglMutasi) {
        this.tglMutasi = tglMutasi;
    }

    public String getPeriodeMutasi() {
        return periodeMutasi;
    }

    public void setPeriodeMutasi(String periodeMutasi) {
        this.periodeMutasi = periodeMutasi;
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

    public Long getJumlahPiutang() {
        return jumlahPiutang;
    }

    public void setJumlahPiutang(Long jumlahPiutang) {
        this.jumlahPiutang = jumlahPiutang;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Long getRefMutasi() {
        return refMutasi;
    }

    public void setRefMutasi(Long refMutasi) {
        this.refMutasi = refMutasi;
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

    public KategoriPenerimaDto getIdKategoriPenerimaMp() {
        return idKategoriPenerimaMp;
    }

    public void setIdKategoriPenerimaMp(KategoriPenerimaDto idKategoriPenerimaMp) {
        this.idKategoriPenerimaMp = idKategoriPenerimaMp;
    }

    public String getNamaKategoriPenerimaMp() {
        return namaKategoriPenerimaMp;
    }

    public void setNamaKategoriPenerimaMp(String namaKategoriPenerimaMp) {
        this.namaKategoriPenerimaMp = namaKategoriPenerimaMp;
    }

    public KantorBayarDto getIdKantorBayar() {
        return idKantorBayar;
    }

    public void setIdKantorBayar(KantorBayarDto idKantorBayar) {
        this.idKantorBayar = idKantorBayar;
    }

    public String getNamaKantorBayar() {
        return namaKantorBayar;
    }

    public void setNamaKantorBayar(String namaKantorBayar) {
        this.namaKantorBayar = namaKantorBayar;
    }

    public StatusValidasiDto getIdValidasi() {
        return idValidasi;
    }

    public void setIdValidasi(StatusValidasiDto idValidasi) {
        this.idValidasi = idValidasi;
    }

    public String getNamaValidasi() {
        return namaValidasi;
    }

    public void setNamaValidasi(String namaValidasi) {
        this.namaValidasi = namaValidasi;
    }

    public String getUserValidasi() {
        return userValidasi;
    }

    public void setUserValidasi(String userValidasi) {
        this.userValidasi = userValidasi;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getUserStamp() {
        return userStamp;
    }

    public void setUserStamp(String userStamp) {
        this.userStamp = userStamp;
    }
}
