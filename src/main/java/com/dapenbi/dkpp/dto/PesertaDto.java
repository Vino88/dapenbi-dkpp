package com.dapenbi.dkpp.dto;

import java.math.BigDecimal;
import java.util.Date;

public class PesertaDto extends BaseDto {

    private String nip;

    private String namaPeserta;

    private AgamaDto agama;

    private GolonganDto golongan;

    private String npwp;

    private BigDecimal gapok;

    private BigDecimal upahVeteran;

    private String mkVeteran;

    private Character jenisKelamin;

    private Date tglLahir;

    private Date tglKerja;

    private Date tglPeserta;

    private Date tglHenti;

    private Date tglWafat;

    private AlasanHentiDto alasanHenti;

    private PredikatPemberhentianDto predikatPemberhentian;

    private String noSKBI;

    private Date tglSKBI;

    private String alamat;

    private boolean isActive;

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

    public AgamaDto getAgama() {
        return agama;
    }

    public void setAgama(AgamaDto agama) {
        this.agama = agama;
    }

    public GolonganDto getGolongan() {
        return golongan;
    }

    public void setGolongan(GolonganDto golongan) {
        this.golongan = golongan;
    }

    public String getNpwp() {
        return npwp;
    }

    public void setNpwp(String npwp) {
        this.npwp = npwp;
    }

    public BigDecimal getGapok() {
        return gapok;
    }

    public void setGapok(BigDecimal gapok) {
        this.gapok = gapok;
    }

    public BigDecimal getUpahVeteran() {
        return upahVeteran;
    }

    public void setUpahVeteran(BigDecimal upahVeteran) {
        this.upahVeteran = upahVeteran;
    }

    public String getMkVeteran() {
        return mkVeteran;
    }

    public void setMkVeteran(String mkVeteran) {
        this.mkVeteran = mkVeteran;
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

    public Date getTglKerja() {
        return tglKerja;
    }

    public void setTglKerja(Date tglKerja) {
        this.tglKerja = tglKerja;
    }

    public Date getTglPeserta() {
        return tglPeserta;
    }

    public void setTglPeserta(Date tglPeserta) {
        this.tglPeserta = tglPeserta;
    }

    public Date getTglHenti() {
        return tglHenti;
    }

    public void setTglHenti(Date tglHenti) {
        this.tglHenti = tglHenti;
    }

    public Date getTglWafat() {
        return tglWafat;
    }

    public void setTglWafat(Date tglWafat) {
        this.tglWafat = tglWafat;
    }

    public AlasanHentiDto getAlasanHenti() {
        return alasanHenti;
    }

    public void setAlasanHenti(AlasanHentiDto alasanHenti) {
        this.alasanHenti = alasanHenti;
    }

    public PredikatPemberhentianDto getPredikatPemberhentian() {
        return predikatPemberhentian;
    }

    public void setPredikatPemberhentian(PredikatPemberhentianDto predikatPemberhentian) {
        this.predikatPemberhentian = predikatPemberhentian;
    }

    public String getNoSKBI() {
        return noSKBI;
    }

    public void setNoSKBI(String noSKBI) {
        this.noSKBI = noSKBI;
    }

    public Date getTglSKBI() {
        return tglSKBI;
    }

    public void setTglSKBI(Date tglSKBI) {
        this.tglSKBI = tglSKBI;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getUserStamp() {
        return userStamp;
    }

    public void setUserStamp(String userStamp) {
        this.userStamp = userStamp;
    }
}
