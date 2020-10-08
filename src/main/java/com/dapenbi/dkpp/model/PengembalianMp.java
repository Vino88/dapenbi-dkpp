package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dto.PengembalianMpDto;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TBL_T_PENGEMBALIAN_MP")
@NamedStoredProcedureQueries(
        @NamedStoredProcedureQuery(
                name="PengembalianMp.processCuspMutasiPengembalianMp",
                procedureName="CUSP_MUTASI_PENGEMBALIAN_MP",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name= "PAR_ROLE_ID"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_COMP_NAME"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_USER_NAME"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name= "PAR_ID_PENGEMBALIAN_MP"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_PERIODE_MUTASI"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name= "PAR_TGL_MUTASI"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_NIP"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_NAMA_PESERTA"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_ID_PENERIMA_MP"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_NAMA_PENERIMA_MP"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_KAT_PENGEMBALIAN_MP"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name= "PAR_TGL_TRANSFER"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name= "PAR_NOMINAL_TRANSFER"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_ID_KATEGORI_CATATAN"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_NAMA_KATEGORI_CATATAN"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_KETERANGAN"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name= "PAR_ID_VALIDASI"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_NAMA_VALIDASI"),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, type = Character.class, name= "PAR_STATUS_EKSEKUSI"),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name= "PAR_MSG")
                }
        )
)
public class PengembalianMp extends BaseModel<PengembalianMpDto> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PENGEMBALIAN_MP_ID_SEQ")
    @SequenceGenerator(sequenceName = "pengembalianId_seq", allocationSize = 1, name = "PENGEMBALIAN_MP_ID_SEQ")
    @Column(name = "ID_PENGEMBALIAN_MP", length = 20)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NIP")
    private MPensiun nip;

    @Column(name = "NAMA_PESERTA", length = 50)
    private String namaPeserta;

    @Column(name = "PERIODE_MUTASI", length = 6)
    private String periodeMutasi;

    @Column(name = "TGL_MUTASI", length = 7)
    private Date tglMutasi;

    @Column(name = "ID_PENERIMA_MP", length = 10)
    private String idPenerimaMp;

    @Column(name = "NAMA_PENERIMA_MP", length = 50)
    private String namaPenerimaMp;

    @Column(name = "KATEGORI_PENGEMBALIAN", length = 50)
    private String kategoriPengembalian;

    @Column(name = "TGL_TRANSFER", length = 7)
    private Date tglTransfer;

    @Column(name = "NOMINAL_TRANSFER", length = 22)
    private Long nominalTransfer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_KATEGORI_CATATAN")
    private KategoriCatatan idKategoriCatatan;

    @Column(name = "NAMA_KATEGORI_CATATAN", length = 500)
    private String namaKategoriCatatan;

    @Column(name = "KETERANGAN", length = 500)
    private String keterangan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_VALIDASI")
    private StatusValidasi idValidasi;

    @Column(name = "USER_VALIDASI", length = 100)
    private String userValidasi;

    @Column(name = "NAMA_VALIDASI", length = 50)
    private String namaValidasi;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getKategoriPengembalian() {
        return kategoriPengembalian;
    }

    public void setKategoriPengembalian(String kategoriPengembalian) {
        this.kategoriPengembalian = kategoriPengembalian;
    }

    public Date getTglTransfer() {
        return tglTransfer;
    }

    public void setTglTransfer(Date tglTransfer) {
        this.tglTransfer = tglTransfer;
    }

    public Long getNominalTransfer() {
        return nominalTransfer;
    }

    public void setNominalTransfer(Long nominalTransfer) {
        this.nominalTransfer = nominalTransfer;
    }

    public KategoriCatatan getIdKategoriCatatan() {
        return idKategoriCatatan;
    }

    public void setIdKategoriCatatan(KategoriCatatan idKategoriCatatan) {
        this.idKategoriCatatan = idKategoriCatatan;
    }

    public String getNamaKategoriCatatan() {
        return namaKategoriCatatan;
    }

    public void setNamaKategoriCatatan(String namaKategoriCatatan) {
        this.namaKategoriCatatan = namaKategoriCatatan;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public StatusValidasi getIdValidasi() {
        return idValidasi;
    }

    public void setIdValidasi(StatusValidasi idValidasi) {
        this.idValidasi = idValidasi;
    }

    public String getUserValidasi() {
        return userValidasi;
    }

    public void setUserValidasi(String userValidasi) {
        this.userValidasi = userValidasi;
    }


    public String getNamaValidasi() {
        return namaValidasi;
    }

    public void setNamaValidasi(String namaValidasi) {
        this.namaValidasi = namaValidasi;
    }

    @Override
    public void fromDto(PengembalianMpDto dto) {


        this.setId(dto.getId());

        this.setNamaPeserta(dto.getNamaPeserta());

        this.setPeriodeMutasi(dto.getPeriodeMutasi());

        this.setTglMutasi(dto.getTglMutasi());

        this.setIdPenerimaMp(dto.getIdPenerimaMp());

        this.setNamaPenerimaMp(dto.getNamaPenerimaMp());

        this.setKategoriPengembalian(dto.getKategoriPengembalian());

        this.setTglTransfer(dto.getTglTransfer());

        this.setNominalTransfer(dto.getNominalTransfer());

        this.setNamaKategoriCatatan(dto.getNamaKategoriCatatan());

        this.setKeterangan(dto.getKeterangan());

        this.setUserValidasi(dto.getUserValidasi());

        this.setNamaValidasi(dto.getNamaValidasi());

        this.setActive(dto.getActive());

        this.setUserStamp(dto.getUserStamp());

    }

    @Override
    public PengembalianMpDto toDto() {
        PengembalianMpDto dto = new PengembalianMpDto();


        dto.setId(this.getId());

        dto.setNamaPeserta(this.getNamaPeserta());

        dto.setPeriodeMutasi(this.getPeriodeMutasi());

        dto.setTglMutasi(this.getTglMutasi());

        dto.setIdPenerimaMp(this.getIdPenerimaMp());

        dto.setNamaPenerimaMp(this.getNamaPenerimaMp());

        dto.setKategoriPengembalian(this.getKategoriPengembalian());

        dto.setTglTransfer(this.getTglTransfer());

        dto.setNominalTransfer(this.getNominalTransfer());

        dto.setNamaKategoriCatatan(this.getNamaKategoriCatatan());

        dto.setKeterangan(this.getKeterangan());

        dto.setUserValidasi(this.getUserValidasi());

        dto.setNamaValidasi(this.getNamaValidasi());

        dto.setActive(this.isActive);

        dto.setUserStamp(this.getUserStamp());

        return dto;
    }
}
