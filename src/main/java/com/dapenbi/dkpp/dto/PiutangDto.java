package com.dapenbi.dkpp.dto;

import com.dapenbi.dkpp.model.KategoriPenerima;

import java.util.Date;

public class PiutangDto {

    private String nip;
    private String namaPeserta;
    private Long totalPiutang;
    private Long sudahDibayar;
    private Long sisaPiutang;
    private String idPenerimaMp;
    private String namaPenerimaMp;
    private KantorBayarDto idKantorBayar;
    private String namaKantorBayar;
    private KategoriPenerimaDto idKategoriPenerimaMp;
    private String namaKategoriPenerimaMp;
    private String periodeAwalPiutang;
    private Boolean isActive;
    private String userStamp;

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

    public Long getTotalPiutang() {
        return totalPiutang;
    }

    public void setTotalPiutang(Long totalPiutang) {
        this.totalPiutang = totalPiutang;
    }

    public Long getSudahDibayar() {
        return sudahDibayar;
    }

    public void setSudahDibayar(Long sudahDibayar) {
        this.sudahDibayar = sudahDibayar;
    }

    public Long getSisaPiutang() {
        return sisaPiutang;
    }

    public void setSisaPiutang(Long sisaPiutang) {
        this.sisaPiutang = sisaPiutang;
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

    public String getPeriodeAwalPiutang() {
        return periodeAwalPiutang;
    }

    public void setPeriodeAwalPiutang(String periodeAwalPiutang) {
        this.periodeAwalPiutang = periodeAwalPiutang;
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
