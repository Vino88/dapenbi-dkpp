package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dto.PensiunDto;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TBL_R_PENSIUN")
public class Pensiun extends BaseModel<PensiunDto> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PENSIUN_ID_SEQ")
    @SequenceGenerator(sequenceName = "pensiunId_seq", allocationSize = 1, name = "PENSIUN_ID_SEQ")
    @Column(name = "id_pensiun")
    private Long id;

    private String nip;

    @Column(name = "nama_peserta")
    private String namaPeserta;

    @Column(name = "jenis_kelamin")
    private String jenisKelamin;

    @Column(name = "tgl_lahir")
    private Date tglLahir;

    @Column(name = "tgl_kerja")
    private Date tglKerja;

    @Column(name = "tgl_dpht_peserta")
    private Date tglDPHTPeserta;

    @Column(name = "tgl_henti")
    private Date tglHenti;

    @Column(name = "tgl_meniggal")
    private Date tglMeninggal;

    @Column(name = "tempat_meninggal")
    private String tempatMeninggal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_golongan")
    private Golongan golongan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_agama")
    private Agama agama;

    private String npwp;

    private Long gapok;

    @Column(name = "upah_veteran")
    private Long upahVeteran;

    @Column(name = "mk_veteran")
    private Long mkVeteran;

    @Column(name = "tgl_wafat")
    private Date tglWafat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alasan_henti")
    private AlasanHenti alasanHenti;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_predikat_pemberhentian")
    private PredikatPemberhentian predikatPemberhentian;

    private String noSKBI;

    private Date tglSKBI;

    private String alamat;

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

    public String getTempatMeninggal() {
        return tempatMeninggal;
    }

    public void setTempatMeninggal(String tempatMeninggal) {
        this.tempatMeninggal = tempatMeninggal;
    }

    public Date getTglMeninggal() {
        return tglMeninggal;
    }

    public void setTglMeninggal(Date tglMeninggal) {
        this.tglMeninggal = tglMeninggal;
    }

    public Golongan getGolongan() {
        return golongan;
    }

    public void setGolongan(Golongan golongan) {
        this.golongan = golongan;
    }

    public Agama getAgama() {
        return agama;
    }

    public void setAgama(Agama agama) {
        this.agama = agama;
    }

    public String getNpwp() {
        return npwp;
    }

    public void setNpwp(String npwp) {
        this.npwp = npwp;
    }

    public Long getGapok() {
        return gapok;
    }

    public void setGapok(Long gapok) {
        this.gapok = gapok;
    }

    public Long getUpahVeteran() {
        return upahVeteran;
    }

    public void setUpahVeteran(Long upahVeteran) {
        this.upahVeteran = upahVeteran;
    }

    public Long getMkVeteran() {
        return mkVeteran;
    }

    public void setMkVeteran(Long mkVeteran) {
        this.mkVeteran = mkVeteran;
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
    public void fromDto(PensiunDto dto) {
        this.setId(dto.getId());
        this.setNip(dto.getNip());
        this.setNamaPeserta(dto.getNamaPeserta());
        this.setJenisKelamin(dto.getJenisKelamin());
        this.setTglLahir(dto.getTglLahir());
        this.setTglKerja(dto.getTglKerja());
        this.setTglDPHTPeserta(dto.getTglDPHTPeserta());
        this.setTglHenti(dto.getTglHenti());
        this.setTempatMeninggal(dto.getTempatMeninggal());
        this.setTglMeninggal(dto.getTglMeninggal());
        this.setNpwp(dto.getNpwp());
        this.setGapok(dto.getGapok());
        this.setUpahVeteran(dto.getUpahVeteran());
        this.setMkVeteran(dto.getMkVeteran());
        this.setTglWafat(dto.getTglWafat());
        this.setNoSKBI(dto.getNoSKBI());
        this.setTglSKBI(dto.getTglSKBI());
        this.setAlamat(dto.getAlamat());
        this.setActive(dto.isActive());
    }

    @Override
    public PensiunDto toDto() {
        PensiunDto dto = new PensiunDto();

        dto.setId(this.getId());
        dto.setNip(this.getNip());
        dto.setNamaPeserta(this.getNamaPeserta());
        dto.setJenisKelamin(this.getJenisKelamin());
        dto.setTglLahir(this.getTglLahir());
        dto.setTglKerja(this.getTglKerja());
        dto.setTglDPHTPeserta(this.getTglDPHTPeserta());
        dto.setTglHenti(this.getTglHenti());
        dto.setTempatMeninggal(this.getTempatMeninggal());
        dto.setTglMeninggal(this.getTglMeninggal());
        dto.setNpwp(this.getNpwp());
        dto.setGapok(this.getGapok());
        dto.setUpahVeteran(this.getUpahVeteran());
        dto.setMkVeteran(this.getMkVeteran());
        dto.setTglWafat(this.getTglWafat());
        dto.setNoSKBI(this.getNoSKBI());
        dto.setTglSKBI(this.getTglSKBI());
        dto.setAlamat(this.getAlamat());
        dto.setActive(this.isActive());
        
        return dto;
    }
}
