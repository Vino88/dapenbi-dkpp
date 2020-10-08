package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dto.MutasiKeluargaPensiunDto;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="TBL_T_MUTASI_KELUARGA_PENSIUN")
public class MutasiKeluargaPensiun extends BaseModel<MutasiKeluargaPensiunDto> {

    @Id
    @Column(name="ID_KELUARGA", nullable = false)
    private String id;

    @Column(name="IS_PENERIMA_MP", nullable = false, columnDefinition = "CHAR(1)")
    private String isPenerimaMp;

    @Column(name="JENIS_KELAMIN")
    private Character jenisKelamin;

    @Column(name="NAMA_KATEGORI_PENERIMA")
    private String namaKategoriPenerima;

    @Column(name="NAMA_KELUARGA")
    private String namaKeluarga;

    @Column(name="NAMA_STATUS_KAWIN_PENERIMA_MP")
    private String namaStatusKawinPenerimaMp;

    @Column(name="NIP", nullable = false)
    private String nip;

    @Column(name="TEMPAT_LAHIR")
    private String tempatLahir;

    @Column(name="TEMPAT_MENIKAH")
    private String tempatMenikah;

    @Column(name="TEMPAT_WAFAT")
    private String tempatWafat;

    @Temporal(TemporalType.DATE)
    @Column(name="TGL_CERAI")
    private Date tglCerai;

    @Temporal(TemporalType.DATE)
    @Column(name="TGL_LAHIR")
    private Date tglLahir;

    @Temporal(TemporalType.DATE)
    @Column(name="TGL_MENIKAH")
    private Date tglMenikah;

    @Temporal(TemporalType.DATE)
    @Column(name="TGL_USIA25")
    private Date tglUsia25;

    @Temporal(TemporalType.DATE)
    @Column(name="TGL_WAFAT")
    private Date tglWafat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_kategori_penerima")
    private KategoriPenerima kategoriPenerima;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_status_kawin_penerima_mp")
    private StatusKawin statusKawin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_mutasi_pensiun")
    private MutasiPensiun mutasiPensiun;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String IsPenerimaMp() {
        return isPenerimaMp;
    }

    public void setPenerimaMp(String isPenerimaMp) {
        this.isPenerimaMp = isPenerimaMp;
    }

    public Character getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(Character jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getNamaKategoriPenerima() {
        return namaKategoriPenerima;
    }

    public void setNamaKategoriPenerima(String namaKategoriPenerima) {
        this.namaKategoriPenerima = namaKategoriPenerima;
    }

    public String getNamaKeluarga() {
        return namaKeluarga;
    }

    public void setNamaKeluarga(String namaKeluarga) {
        this.namaKeluarga = namaKeluarga;
    }

    public String getNamaStatusKawinPenerimaMp() {
        return namaStatusKawinPenerimaMp;
    }

    public void setNamaStatusKawinPenerimaMp(String namaStatusKawinPenerimaMp) {
        this.namaStatusKawinPenerimaMp = namaStatusKawinPenerimaMp;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
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

    public Date getTglCerai() {
        return tglCerai;
    }

    public void setTglCerai(Date tglCerai) {
        this.tglCerai = tglCerai;
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

    public Date getTglUsia25() {
        return tglUsia25;
    }

    public void setTglUsia25(Date tglUsia25) {
        this.tglUsia25 = tglUsia25;
    }

    public Date getTglWafat() {
        return tglWafat;
    }

    public void setTglWafat(Date tglWafat) {
        this.tglWafat = tglWafat;
    }

    public KategoriPenerima getKategoriPenerima() {
        return kategoriPenerima;
    }

    public void setKategoriPenerima(KategoriPenerima kategoriPenerima) {
        this.kategoriPenerima = kategoriPenerima;
    }

    public StatusKawin getStatusKawin() {
        return statusKawin;
    }

    public void setStatusKawin(StatusKawin statusKawin) {
        this.statusKawin = statusKawin;
    }

    public String getIsPenerimaMp() {
        return isPenerimaMp;
    }

    public void setIsPenerimaMp(String isPenerimaMp) {
        this.isPenerimaMp = isPenerimaMp;
    }

    public MutasiPensiun getMutasiPensiun() {
        return mutasiPensiun;
    }

    public void setMutasiPensiun(MutasiPensiun mutasiPensiun) {
        this.mutasiPensiun = mutasiPensiun;
    }

    @Override
    public void fromDto(MutasiKeluargaPensiunDto dto) {
        this.setId(dto.getId());
        this.setNamaKeluarga(dto.getNamaKeluarga());
        this.setNip(dto.getNip());
        this.setJenisKelamin(dto.getJenisKelamin());
        this.setTempatLahir(dto.getTempatLahir());
        this.setTglLahir(dto.getTglLahir());
        this.setPenerimaMp(dto.getIsPenerimaMp());
        this.setTempatMenikah(dto.getTempatMenikah());
        this.setTglMenikah(dto.getTglMenikah());
        this.setTglCerai(dto.getTglCerai());
        this.setTglUsia25(dto.getTglUsia25());
        this.setTempatWafat(dto.getTempatWafat());
        this.setTglWafat(dto.getTglWafat());
        this.setActive(dto.isActive());
    }

    @Override
    public MutasiKeluargaPensiunDto toDto() {
        MutasiKeluargaPensiunDto dto = new MutasiKeluargaPensiunDto();

        dto.setId(this.getId());
        dto.setNamaKeluarga(this.getNamaKeluarga());
        dto.setNip(this.getNip());
        dto.setJenisKelamin(this.getJenisKelamin());
        dto.setTempatLahir(this.getTempatLahir());
        dto.setTglLahir(this.getTglLahir());
        dto.setPenerimaMp(this.IsPenerimaMp());
        dto.setTempatMenikah(this.getTempatMenikah());
        dto.setTglMenikah(this.getTglMenikah());
        dto.setTglCerai(this.getTglCerai());
        dto.setTglUsia25(this.getTglUsia25());
        dto.setTempatWafat(this.getTempatWafat());
        dto.setTglWafat(this.getTglWafat());
        dto.setActive(this.isActive());
        return dto;
    }

}
