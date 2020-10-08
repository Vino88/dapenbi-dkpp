package com.dapenbi.dkpp.dto;

import java.util.Date;

public class AngsuranLebihBayarDto extends BaseDto {

    private Long id;
    private String namaPeserta;
    private String periodeMutasi;
    private Date tglMutasi;
    private String nip;
    private String idPenerimaMp;
    private String namaPenerimaMp;
    private KategoriPenerimaDto kategoriPenerima;
    private String namaKategoriPenerima;
    private KantorBayarDto kantorBayar;
    private String namaKantorBayar;
    private Long saldoAwalLebihBayar;
    private Long Angsuran;
    private Long saldoAkhirLebihBayar;
    private String userStamp;
    private Boolean isActive;
    private String periodeLebihBayar;
    private Long lebihBayarMp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
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

    public KategoriPenerimaDto getKategoriPenerima() {
        return kategoriPenerima;
    }

    public void setKategoriPenerima(KategoriPenerimaDto kategoriPenerima) {
        this.kategoriPenerima = kategoriPenerima;
    }

    public String getNamaKategoriPenerima() {
        return namaKategoriPenerima;
    }

    public void setNamaKategoriPenerima(String namaKategoriPenerima) {
        this.namaKategoriPenerima = namaKategoriPenerima;
    }

    public KantorBayarDto getKantorBayar() {
        return kantorBayar;
    }

    public void setKantorBayar(KantorBayarDto kantorBayar) {
        this.kantorBayar = kantorBayar;
    }

    public String getNamaKantorBayar() {
        return namaKantorBayar;
    }

    public void setNamaKantorBayar(String namaKantorBayar) {
        this.namaKantorBayar = namaKantorBayar;
    }

    public Long getSaldoAwalLebihBayar() {
        return saldoAwalLebihBayar;
    }

    public void setSaldoAwalLebihBayar(Long saldoAwalLebihBayar) {
        this.saldoAwalLebihBayar = saldoAwalLebihBayar;
    }

    public Long getAngsuran() {
        return Angsuran;
    }

    public void setAngsuran(Long angsuran) {
        Angsuran = angsuran;
    }

    public Long getSaldoAkhirLebihBayar() {
        return saldoAkhirLebihBayar;
    }

    public void setSaldoAkhirLebihBayar(Long saldoAkhirLebihBayar) {
        this.saldoAkhirLebihBayar = saldoAkhirLebihBayar;
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

    public String getPeriodeLebihBayar() {
        return periodeLebihBayar;
    }

    public void setPeriodeLebihBayar(String periodeLebihBayar) {
        this.periodeLebihBayar = periodeLebihBayar;
    }

    public Long getLebihBayarMp() {
        return lebihBayarMp;
    }

    public void setLebihBayarMp(Long lebihBayarMp) {
        this.lebihBayarMp = lebihBayarMp;
    }
}
