package com.dapenbi.dkpp.dto;

import com.dapenbi.dkpp.model.KantorBayar;

import java.util.Date;

public class PmbyPiutangDto extends BaseDto {

    private Long id;
    private Date tglProses;
    private String periodeMutasi;
    private String nip;
    private String namaPeserta;
    private String idPenerimaMp;
    private String namaPenerimaMp;
    private KantorBayarDto idKantorBayar;
    private String namaKantorBayar;
    private Long saldoAwalPiutang;
    private Long dibayarkanPeriodeIni;
    private Long saldoAkhirPiutang;
    private Boolean status;
    private String keterangan;
    private String userStamp;
    private StatusValidasiDto idValidasi;
    private String namaValidasi;
    private String userValidasi;
    private Date tglBayar;
    private Long idPengembalianMp;
    private Boolean isActive;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTglProses() {
        return tglProses;
    }

    public void setTglProses(Date tglProses) {
        this.tglProses = tglProses;
    }

    public String getPeriodeMutasi() {
        return periodeMutasi;
    }

    public void setPeriodeMutasi(String periodeMutasi) {
        this.periodeMutasi = periodeMutasi;
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

    public Long getSaldoAwalPiutang() {
        return saldoAwalPiutang;
    }

    public void setSaldoAwalPiutang(Long saldoAwalPiutang) {
        this.saldoAwalPiutang = saldoAwalPiutang;
    }

    public Long getDibayarkanPeriodeIni() {
        return dibayarkanPeriodeIni;
    }

    public void setDibayarkanPeriodeIni(Long dibayarkanPeriodeIni) {
        this.dibayarkanPeriodeIni = dibayarkanPeriodeIni;
    }

    public Long getSaldoAkhirPiutang() {
        return saldoAkhirPiutang;
    }

    public void setSaldoAkhirPiutang(Long saldoAkhirPiutang) {
        this.saldoAkhirPiutang = saldoAkhirPiutang;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getUserStamp() {
        return userStamp;
    }

    public void setUserStamp(String userStamp) {
        this.userStamp = userStamp;
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

    public Date getTglBayar() {
        return tglBayar;
    }

    public void setTglBayar(Date tglBayar) {
        this.tglBayar = tglBayar;
    }

    public Long getIdPengembalianMp() {
        return idPengembalianMp;
    }

    public void setIdPengembalianMp(Long idPengembalianMp) {
        this.idPengembalianMp = idPengembalianMp;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
