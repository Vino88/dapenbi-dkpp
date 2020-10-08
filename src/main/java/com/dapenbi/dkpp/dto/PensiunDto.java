package com.dapenbi.dkpp.dto;

import java.util.Date;

public class PensiunDto extends BaseDto {

    private Long id;

    private String nip;

    private String namaPeserta;

    private String jenisKelamin;

    private Date tglLahir;

    private Date tglKerja;

    private Date tglDPHTPeserta;

    private Date tglHenti;

    private Date tglMeninggal;

    private String tempatMeninggal;

    private GolonganDto golongan;

    private AgamaDto agama;

    private String npwp;

    private long gapok;

    private long upahVeteran;

    private long mkVeteran;

    private Date tglWafat;

    private AlasanHentiDto alasanHenti;

    private PredikatPemberhentianDto predikatPemberhentian;

    private String noSKBI;

    private Date tglSKBI;

    private String alamat;

    private boolean isActive;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
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

    public Date getTglDPHTPeserta() {
        return tglDPHTPeserta;
    }

    public void setTglDPHTPeserta(Date tglDPHTPeserta) {
        this.tglDPHTPeserta = tglDPHTPeserta;
    }

    public Date getTglHenti() {
        return tglHenti;
    }

    public void setTglHenti(Date tglHenti) {
        this.tglHenti = tglHenti;
    }

    public Date getTglMeninggal() {
        return tglMeninggal;
    }

    public void setTglMeninggal(Date tglMeninggal) {
        this.tglMeninggal = tglMeninggal;
    }

    public String getTempatMeninggal() {
        return tempatMeninggal;
    }

    public void setTempatMeninggal(String tempatMeninggal) {
        this.tempatMeninggal = tempatMeninggal;
    }

    public GolonganDto getGolongan() {
        return golongan;
    }

    public void setGolongan(GolonganDto golongan) {
        this.golongan = golongan;
    }

    public AgamaDto getAgama() {
        return agama;
    }

    public void setAgama(AgamaDto agama) {
        this.agama = agama;
    }

    public String getNpwp() {
        return npwp;
    }

    public void setNpwp(String npwp) {
        this.npwp = npwp;
    }

    public long getGapok() {
        return gapok;
    }

    public void setGapok(long gapok) {
        this.gapok = gapok;
    }

    public long getUpahVeteran() {
        return upahVeteran;
    }

    public void setUpahVeteran(long upahVeteran) {
        this.upahVeteran = upahVeteran;
    }

    public long getMkVeteran() {
        return mkVeteran;
    }

    public void setMkVeteran(long mkVeteran) {
        this.mkVeteran = mkVeteran;
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
}
