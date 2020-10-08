package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dto.KeluargaPensiunDto;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TBL_M_KELUARGA_PENSIUN")
public class KeluargaPensiun extends BaseModel<KeluargaPensiunDto> {

    @Id
    @Column(name = "ID_KELUARGA")
    private String id;

    @Column(name = "IS_PENERIMA_MP", nullable = false, columnDefinition = "CHAR(1)")
    private String isPenerimaMp;

    @Column(name = "JENIS_KELAMIN")
    private String jenisKelamin;

    @Column(name = "NAMA_KELUARGA")
    private String namaKeluarga;

    private String nip;

    @Column(name = "TEMPAT_LAHIR")
    private String tempatLahir;

    @Column(name = "TEMPAT_MENIKAH")
    private String tempatMenikah;

    @Column(name = "TEMPAT_WAFAT")
    private String tempatWafat;

    @Temporal(TemporalType.DATE)
    @Column(name = "TGL_CERAI")
    private Date tglCerai;

    @Temporal(TemporalType.DATE)
    @Column(name = "TGL_LAHIR")
    private Date tglLahir;

    @Temporal(TemporalType.DATE)
    @Column(name = "TGL_MENIKAH")
    private Date tglMenikah;

    @Temporal(TemporalType.DATE)
    @Column(name = "TGL_USIA25")
    private Date tglUsia25;

    @Temporal(TemporalType.DATE)
    @Column(name = "TGL_WAFAT")
    private Date tglWafat;

    @Column(name = "USER_STAMP")
    private String userStamp;

    //bi-directional many-to-one association to KategoriPenerima
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_KATEGORI_PENERIMA")
    private KategoriPenerima kategoriPenerima;

    @Column(name = "NAMA_KATEGORI_PENERIMA")
    private String namaKategoriPenerima;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_STATUS_KAWIN")
    private StatusKawin statusKawin;

    @Column(name = "NAMA_STATUS_KAWIN")
    private String namaStatusKawin;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "nip",insertable=false, updatable=false)
    private MPensiun pensiun;

    public KeluargaPensiun() {
        super();
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String isPenerimaMp() {
        return this.isPenerimaMp;
    }

    public void setPenerimaMp(String isPenerimaMp) {
        this.isPenerimaMp = isPenerimaMp;
    }

    public String getJenisKelamin() {
        return this.jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getNamaKeluarga() {
        return this.namaKeluarga;
    }

    public void setNamaKeluarga(String namaKeluarga) {
        this.namaKeluarga = namaKeluarga;
    }

    public String getNip() {
        return this.nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getTempatLahir() {
        return this.tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public String getTempatMenikah() {
        return this.tempatMenikah;
    }

    public void setTempatMenikah(String tempatMenikah) {
        this.tempatMenikah = tempatMenikah;
    }

    public String getTempatWafat() {
        return this.tempatWafat;
    }

    public void setTempatWafat(String tempatWafat) {
        this.tempatWafat = tempatWafat;
    }

    public Date getTglCerai() {
        return this.tglCerai;
    }

    public void setTglCerai(Date tglCerai) {
        this.tglCerai = tglCerai;
    }

    public Date getTglLahir() {
        return this.tglLahir;
    }

    public void setTglLahir(Date tglLahir) {
        this.tglLahir = tglLahir;
    }

    public Date getTglMenikah() {
        return this.tglMenikah;
    }

    public void setTglMenikah(Date tglMenikah) {
        this.tglMenikah = tglMenikah;
    }

    public Date getTglUsia25() {
        return this.tglUsia25;
    }

    public void setTglUsia25(Date tglUsia25) {
        this.tglUsia25 = tglUsia25;
    }

    public Date getTglWafat() {
        return this.tglWafat;
    }

    public void setTglWafat(Date tglWafat) {
        this.tglWafat = tglWafat;
    }

    public String getUserStamp() {
        return this.userStamp;
    }

    public void setUserStamp(String userStamp) {
        this.userStamp = userStamp;
    }

    public KategoriPenerima getKategoriPenerima() {
        return this.kategoriPenerima;
    }

    public void setKategoriPenerima(KategoriPenerima tblRKategoriPenerima) {
        this.kategoriPenerima = tblRKategoriPenerima;
    }

    public String getNamaKategoriPenerima() {
        return namaKategoriPenerima;
    }

    public void setNamaKategoriPenerima(String namaKategoriPenerima) {
        this.namaKategoriPenerima = namaKategoriPenerima;
    }

    public MPensiun getPensiun() {
        return pensiun;
    }

    public void setPensiun(MPensiun pensiun) {
        this.pensiun = pensiun;
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

    public void fromDto(KeluargaPensiunDto dto) {
        this.setId(dto.getId());
        this.setNip(dto.getNip());
        this.setNamaKeluarga(dto.getNamaKeluarga());
        this.setJenisKelamin(dto.getJenisKelamin());
        this.setTempatLahir(dto.getTempatLahir());
        this.setTglLahir(dto.getTglLahir());
        this.setTglMenikah(dto.getTglMenikah());
        this.setTglCerai(dto.getTglCerai());
        this.setTglUsia25(dto.getTglUsia25());
        this.setTglWafat(dto.getTglWafat());
        this.setTempatMenikah(dto.getTempatMenikah());
        this.setTempatWafat(dto.getTempatWafat());
        this.setPenerimaMp(dto.isPenerimaMp());
        this.setUserStamp(dto.getUserStamp());
        this.setNamaStatusKawin(dto.getNamaStatusKawin());
        this.setNamaKategoriPenerima(dto.getNamaKategoriPenerima());
    }

    public KeluargaPensiunDto toDto() {
        KeluargaPensiunDto dto = new KeluargaPensiunDto();
        dto.setId(this.getId());
        dto.setNip(this.getNip());
        dto.setNamaKeluarga(this.getNamaKeluarga());
        dto.setJenisKelamin(this.getJenisKelamin());
        dto.setTempatLahir(this.getTempatLahir());
        dto.setTglLahir(this.getTglLahir());
        dto.setTglMenikah(this.getTglMenikah());
        dto.setTglCerai(this.getTglCerai());
        dto.setTglUsia25(this.getTglUsia25());
        dto.setTglWafat(this.getTglWafat());
        dto.setTempatMenikah(this.getTempatMenikah());
        dto.setTempatWafat(this.getTempatWafat());
        dto.setPenerimaMp(this.isPenerimaMp());
        dto.setIsActive(this.isActive());
        dto.setUserStamp(this.getUserStamp());
        dto.setNamaStatusKawin(this.getNamaStatusKawin());
        dto.setNamaKategoriPenerima(this.getNamaKategoriPenerima());
        return dto;
    }
}
