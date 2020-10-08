package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dto.KeluargaPesertaDto;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name= "STG_TBL_M_KELUARGA_PESERTA")
public class KeluargaPeserta extends BaseModel<KeluargaPesertaDto>{

    @Id
    @Column(name = "id_keluarga", length = 20)
    private String id;

    @Column(name = "nip")
    private String nip;

    @Column(name = "nama_keluarga")
    private String namaKeluarga;

    @Column(name = "jenis_kelamin")
    private String jenisKelamin;

    @Column(name = "tempat_lahir")
    private String tempatLahir;

    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_lahir")
    private Date tglLahir;

    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_usia25")
    private Date tglUsia25;

    @Column(name = "tempat_menikah")
    private String tempatMenikah;

    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_menikah")
    private Date tglMenikah;

    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_cerai")
    private Date tglCerai;

    @Column(name = "tempat_wafat")
    private String tempatWafat;

    @Column(name = "tgl_wafat")
    private Date tglWafat;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_kategori_penerima", nullable = false)
    private KategoriPenerima kategoriPenerima;

    @Column(name = "nama_kategori_penerima")
    private String namaKategoriPenerima;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_status_kawin", nullable = false)
    private StatusKawin statusKawin;

    @Column(name = "nama_status_kawin")
    private String namaStatusKawin;

    public KeluargaPeserta () {
        this.kategoriPenerima = new KategoriPenerima();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNamaKeluarga() {
        return namaKeluarga;
    }

    public void setNamaKeluarga(String namaKeluarga) {
        this.namaKeluarga = namaKeluarga;
    }

    public KategoriPenerima getKategoriPenerima() {
        return kategoriPenerima;
    }

    public void setKategoriPenerima(KategoriPenerima kategoriPenerima) {
        this.kategoriPenerima = kategoriPenerima;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
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

    public Date getTglUsia25() {
        return tglUsia25;
    }

    public void setTglUsia25(Date tglUsia25) {
        this.tglUsia25 = tglUsia25;
    }

    public String getTempatMenikah() {
        return tempatMenikah;
    }

    public void setTempatMenikah(String tempatMenikah) {
        this.tempatMenikah = tempatMenikah;
    }

    public String getTempatWafat() {
        return tempatWafat;
    }

    public void setTempatWafat(String tempatWafat) {
        this.tempatWafat = tempatWafat;
    }

    public String getNamaKategoriPenerima() {
        return namaKategoriPenerima;
    }

    public void setNamaKategoriPenerima(String namaKategoriPenerima) {
        this.namaKategoriPenerima = namaKategoriPenerima;
    }

    public StatusKawin getStatusKawin() {
        return statusKawin;
    }

    public void setStatusKawin(StatusKawin statusKawin) {
        this.statusKawin = statusKawin;
    }

    public String getNamaStatusKawin() {
        return namaStatusKawin;
    }

    public void setNamaStatusKawin(String namaStatusKawin) {
        this.namaStatusKawin = namaStatusKawin;
    }

    public void fromDto(KeluargaPesertaDto dto) {
        this.setId(dto.getId());
        this.setNip(dto.getNIP());
        this.setNamaKeluarga(dto.getNamaKeluarga());
        this.setJenisKelamin(dto.getJenisKelamin());
        this.setTglCerai(dto.getTglCerai());
        this.setTglLahir(dto.getTglLahir());
        this.setTglMenikah(dto.getTglMenikah());
        this.setTglWafat(dto.getTglWafat());
        this.setTempatLahir(dto.getTempatLahir());
        this.setTglUsia25(dto.getTglUsia25());
        this.setTempatMenikah(dto.getTempatMenikah());
        this.setTempatWafat(dto.getTempatWafat());
        this.setNamaKategoriPenerima(dto.getNamaKategoriPenerima());
        this.setNamaStatusKawin(dto.getNamaStatusKawin());
    }

    public KeluargaPesertaDto toDto() {
        KeluargaPesertaDto dto = new KeluargaPesertaDto();
        dto.setId(this.getId());
        dto.setNIP(this.getNip());
        dto.setNamaKeluarga(this.getNamaKeluarga());
        dto.setJenisKelamin(this.getJenisKelamin());
        dto.setTglCerai(this.getTglCerai());
        dto.setTglLahir(this.getTglLahir());
        dto.setTglMenikah(this.getTglMenikah());
        dto.setTglWafat(this.getTglWafat());
        dto.setTempatLahir(this.getTempatLahir());
        dto.setActive(this.isActive());
        dto.setTglUsia25(this.getTglUsia25());
        dto.setTempatMenikah(this.getTempatMenikah());
        dto.setTempatWafat(this.getTempatWafat());
        dto.setNamaKategoriPenerima(this.getNamaKategoriPenerima());
        dto.setNamaStatusKawin(this.getNamaStatusKawin());
        dto.setKategoriPenerima(this.getKategoriPenerima().toDto());
        return dto;
    }
}
