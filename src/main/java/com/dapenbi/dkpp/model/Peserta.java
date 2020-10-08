package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dto.PesertaDto;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "STG_TBL_M_PESERTA")
public class Peserta extends BaseModel<PesertaDto> {

    @Id
    private String nip;

    @Column(name = "nama_peserta")
    private String namaPeserta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_agama")
    private Agama agama;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_golongan")
    private Golongan golongan;

    private String npwp;

    private BigDecimal gapok;

    @Column(name = "upah_veteran")
    private BigDecimal upahVeteran;

    @Column(name = "mk_veteran")
    private String mkVeteran;

    @Column(name = "jenis_kelamin")
    private Character jenisKelamin;

    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_lahir")
    private Date tglLahir;

    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_kerja")
    private Date tglKerja;

    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_peserta")
    private Date tglPeserta;

    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_henti")
    private Date tglHenti;

    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_wafat")
    private Date tglWafat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_henti")
    private AlasanHenti alasanHenti;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_predikat")
    private PredikatPemberhentian predikatPemberhentian;

    @Column(name = "no_sk_bi")
    private String noSKBI;

    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_sk_bi")
    private Date tglSKBI;

    private String alamat;

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

    public Agama getAgama() {
        return agama;
    }

    public void setAgama(Agama agama) {
        this.agama = agama;
    }

    public Golongan getGolongan() {
        return golongan;
    }

    public void setGolongan(Golongan golongan) {
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

    public AlasanHenti getAlasanHenti() {
        return alasanHenti;
    }

    public void setAlasanHenti(AlasanHenti alasanHenti) {
        this.alasanHenti = alasanHenti;
    }

    public PredikatPemberhentian getPredikatPemberhentian() {
        return predikatPemberhentian;
    }

    public void setPredikatPemberhentian(PredikatPemberhentian predikatPemberhentian) {
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

    @Override
    public void fromDto(PesertaDto dto) {
        this.setNip(dto.getNip());
        this.setNamaPeserta(dto.getNamaPeserta());
        this.setNpwp(dto.getNpwp());
        this.setGapok(dto.getGapok());
        this.setUpahVeteran(dto.getUpahVeteran());
        this.setMkVeteran(dto.getMkVeteran());
        this.setJenisKelamin(dto.getJenisKelamin());
        this.setTglLahir(dto.getTglLahir());
        this.setTglKerja(dto.getTglKerja());
        this.setTglPeserta(dto.getTglPeserta());
        this.setTglHenti(dto.getTglHenti());
        this.setTglWafat(dto.getTglWafat());
        this.setNoSKBI(dto.getNoSKBI());
        this.setTglSKBI(dto.getTglSKBI());
        this.setAlamat(dto.getAlamat());
        this.setActive(dto.isActive());
        this.setUserStamp(dto.getUserStamp());
    }

    @Override
    public PesertaDto toDto() {
        PesertaDto dto = new PesertaDto();

        dto.setNip(this.getNip());
        dto.setNamaPeserta(this.getNamaPeserta());
        dto.setNpwp(this.getNpwp());
        dto.setGapok(this.getGapok());
        dto.setUpahVeteran(this.getUpahVeteran());
        dto.setMkVeteran(this.getMkVeteran());
        dto.setJenisKelamin(this.getJenisKelamin());
        dto.setTglLahir(this.getTglLahir());
        dto.setTglKerja(this.getTglKerja());
        dto.setTglPeserta(this.getTglPeserta());
        dto.setTglHenti(this.getTglHenti());
        dto.setTglWafat(this.getTglWafat());
        dto.setNoSKBI(this.getNoSKBI());
        dto.setTglSKBI(this.getTglSKBI());
        dto.setAlamat(this.getAlamat());
        dto.setActive(this.isActive());
        dto.setUserStamp(this.getUserStamp());

        return dto;
    }
}
