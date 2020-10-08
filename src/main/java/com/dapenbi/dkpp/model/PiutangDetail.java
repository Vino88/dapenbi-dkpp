package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dto.PiutangDetailDto;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TBL_T_PIUTANG_DETAIL")
public class PiutangDetail extends BaseModel<PiutangDetailDto> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PIUTANG_DETAIL_SEQ")
    @SequenceGenerator(sequenceName = "piutangDetailId_seq", allocationSize = 1, name = "PIUTANG_DETAIL_SEQ")
    @Column(name= "ID_PIUTANG", length = 22)
    private Long id;

    @Column(name= "TGL_MUTASI", length = 7)
    private Date tglMutasi;

    @Column(name= "PERIODE_MUTASI", length = 6)
    private String periodeMutasi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "NIP")
    private MPensiun nip;

    @Column(name= "NAMA_PESERTA", length = 100)
    private String namaPeserta;

    @Column(name= "JUMLAH_PIUTANG", length = 22)
    private Long jumlahPiutang;

    @Column(name= "KETERANGAN", length = 500)
    private String keterangan;

    @Column(name= "REF_MUTASI", length = 22)
    private Long refMutasi;

    @Column(name= "ID_PENERIMA_MP", length = 20)
    private String idPenerimaMp;

    @Column(name= "NAMA_PENERIMA_MP", length = 100)
    private String namaPenerimaMp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "ID_KATEGORI_PENERIMA_MP")
    private KategoriPenerima idKategoriPenerimaMp;

    @Column(name= "NAMA_KATEGORI_PENERIMA_MP", length = 50)
    private String namaKategoriPenerimaMp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "ID_KANTOR_BAYAR")
    private KantorBayar idKantorBayar;

    @Column(name= "NAMA_KANTOR_BAYAR", length = 100)
    private String namaKantorBayar;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "ID_VALIDASI")
    private StatusValidasi idValidasi;

    @Column(name= "NAMA_VALIDASI", length = 20)
    private String namaValidasi;

    @Column(name= "USER_VALIDASI", length = 50)
    private String userValidasi;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTglMutasi() {
        return tglMutasi;
    }

    public void setTglMutasi(Date tglMutasi) {
        this.tglMutasi = tglMutasi;
    }

    public String getPeriodeMutasi() {
        return periodeMutasi;
    }

    public void setPeriodeMutasi(String periodeMutasi) {
        this.periodeMutasi = periodeMutasi;
    }

    public MPensiun getNip() {
        return nip;
    }

    public void setNip(MPensiun nip) {
        this.nip = nip;
    }

    public String getNamaPeserta() {
        return namaPeserta;
    }

    public void setNamaPeserta(String namaPeserta) {
        this.namaPeserta = namaPeserta;
    }

    public Long getJumlahPiutang() {
        return jumlahPiutang;
    }

    public void setJumlahPiutang(Long jumlahPiutang) {
        this.jumlahPiutang = jumlahPiutang;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Long getRefMutasi() {
        return refMutasi;
    }

    public void setRefMutasi(Long refMutasi) {
        this.refMutasi = refMutasi;
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

    public KategoriPenerima getIdKategoriPenerimaMp() {
        return idKategoriPenerimaMp;
    }

    public void setIdKategoriPenerimaMp(KategoriPenerima idKategoriPenerimaMp) {
        this.idKategoriPenerimaMp = idKategoriPenerimaMp;
    }

    public String getNamaKategoriPenerimaMp() {
        return namaKategoriPenerimaMp;
    }

    public void setNamaKategoriPenerimaMp(String namaKategoriPenerimaMp) {
        this.namaKategoriPenerimaMp = namaKategoriPenerimaMp;
    }

    public KantorBayar getIdKantorBayar() {
        return idKantorBayar;
    }

    public void setIdKantorBayar(KantorBayar idKantorBayar) {
        this.idKantorBayar = idKantorBayar;
    }

    public String getNamaKantorBayar() {
        return namaKantorBayar;
    }

    public void setNamaKantorBayar(String namaKantorBayar) {
        this.namaKantorBayar = namaKantorBayar;
    }

    public StatusValidasi getIdValidasi() {
        return idValidasi;
    }

    public void setIdValidasi(StatusValidasi idValidasi) {
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

    @Override
    public void fromDto(PiutangDetailDto dto) {
        this.setId(dto.getId());
        this.setTglMutasi(dto.getTglMutasi());
        this.setPeriodeMutasi(dto.getPeriodeMutasi());

        this.setNamaPeserta(dto.getNamaPeserta());
        this.setJumlahPiutang(dto.getJumlahPiutang());
        this.setKeterangan(dto.getKeterangan());
        this.setRefMutasi(dto.getRefMutasi());
        this.setIdPenerimaMp(dto.getIdPenerimaMp());
        this.setNamaPenerimaMp(dto.getNamaPenerimaMp());

        this.setNamaKategoriPenerimaMp(dto.getNamaKategoriPenerimaMp());

        this.setNamaKantorBayar(dto.getNamaKantorBayar());

        this.setNamaValidasi(dto.getNamaValidasi());
        this.setUserValidasi(dto.getUserValidasi());
        this.setActive(dto.getActive());
        this.setUserStamp(dto.getUserStamp());
    }

    @Override
    public PiutangDetailDto toDto() {
        PiutangDetailDto dto = new PiutangDetailDto();
        dto.setId(this.getId());
        dto.setTglMutasi(this.getTglMutasi());
        dto.setPeriodeMutasi(this.getPeriodeMutasi());

        dto.setNamaPeserta(this.getNamaPeserta());
        dto.setJumlahPiutang(this.getJumlahPiutang());
        dto.setKeterangan(this.getKeterangan());
        dto.setRefMutasi(this.getRefMutasi());
        dto.setIdPenerimaMp(this.getIdPenerimaMp());
        dto.setNamaPenerimaMp(this.getNamaPenerimaMp());

        dto.setNamaKategoriPenerimaMp(this.getNamaKategoriPenerimaMp());

        dto.setNamaKantorBayar(this.getNamaKantorBayar());

        dto.setNamaValidasi(this.getNamaValidasi());
        dto.setUserValidasi(this.getUserValidasi());
        dto.setActive(this.isActive());
        dto.setUserStamp(this.getUserStamp());
        return dto;
    }
}
