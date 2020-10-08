package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dto.PmbyPiutangDto;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TBL_T_PMBY_PIUTANG")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name="PmbyPiutang.processCuspUpdatePiutangBulanan",
                procedureName="CUSP_UPDATE_PIUTANG_BULANAN",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name= "PAR_ROLE_ID"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_COMP_NAME"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_USER_NAME"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name= "PAR_ID_BAYAR_PIUTANG"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_KETERANGAN"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name= "PAR_ID_VALIDASI"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_NAMA_VALIDASI"),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, type = Character.class, name= "PAR_STATUS_EKSEKUSI"),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name= "PAR_MSG")
                }
        ),
        @NamedStoredProcedureQuery(
                name = "PmbyPiutang.processCuspProsesPiutangBulanan",
                procedureName = "CUSP_PROSES_PIUTANG_BULANAN",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_COMP_NAME"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_USER_NAME"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_PERIODE_MUTASI"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name= "PAR_TGL_PROSES"),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, type = Character.class, name= "PAR_STATUS_EKSEKUSI"),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name= "PAR_MSG")
                }
        )
        })

public class PmbyPiutang extends BaseModel<PmbyPiutangDto> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PMBY_PIUTANG_ID_SEQ")
    @SequenceGenerator(sequenceName = "pmbyId_seq", allocationSize = 1, name = "PMBY_PIUTANG_ID_SEQ")
    @Column(name = "ID_BAYAR_PIUTANG", length = 22)
    private Long id;

    @Column(name = "TGL_PROSES", length = 7)
    private Date tglProses;

    @Column(name = "PERIODE_MUTASI", length = 6)
    private String periodeMutasi;

    @Column(name = "NIP", length = 20)
    private String nip;

    @Column(name = "NAMA_PESERTA", length = 50)
    private String namaPeserta;

    @Column(name = "ID_PENERIMA_MP", length = 20)
    private String idPenerimaMp;

    @Column(name = "NAMA_PENERIMA_MP", length = 50)
    private String namaPenerimaMp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_KANTOR_BAYAR")
    private KantorBayar idKantorBayar;

    @Column(name = "NAMA_KANTOR_BAYAR", length = 50)
    private String namaKantorBayar;

    @Column(name = "SALDO_AWAL_PIUTANG", length = 22)
    private Long saldoAwalPiutang;

    @Column(name = "DIBAYARKAN_PERIODE_INI", length = 22)
    private Long dibayarkanPeriodeIni;

    @Column(name = "SALDO_AKHIR_PIUTANG", length = 22)
    private Long saldoAkhirPiutang;

    @Column(name = "STATUS", length = 1)
    private Boolean status;

    @Column(name = "KETERANGAN", length = 500)
    private String keterangan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_VALIDASI")
    private StatusValidasi idValidasi;

    @Column(name = "NAMA_VALIDASI", length = 50)
    private String namaValidasi;

    @Column(name = "USER_VALIDASI", length = 100)
    private String userValidasi;

    @Column(name = "TGL_BAYAR", length = 7)
    private Date tglBayar;

    @Column(name = "ID_PENGEMBALIAN_MP", length = 22)
    private Long idPengembalianMp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTglProses() {
        return tglProses;
    }

    public void setTglProses(Date tglProses) {
        this.tglProses = tglProses;
    }

    public String getPeriodeMutasi() {
        return periodeMutasi;
    }

    public void setPeriodeMutasi(String periodeMutasi) {
        this.periodeMutasi = periodeMutasi;
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

    public Long getSaldoAwalPiutang() {
        return saldoAwalPiutang;
    }

    public void setSaldoAwalPiutang(Long saldoAwalPiutang) {
        this.saldoAwalPiutang = saldoAwalPiutang;
    }

    public Long getDibayarkanPeriodeIni() {
        return dibayarkanPeriodeIni;
    }

    public void setDibayarkanPeriodeIni(Long dibayarkanPeriodeIni) {
        this.dibayarkanPeriodeIni = dibayarkanPeriodeIni;
    }

    public Long getSaldoAkhirPiutang() {
        return saldoAkhirPiutang;
    }

    public void setSaldoAkhirPiutang(Long saldoAkhirPiutang) {
        this.saldoAkhirPiutang = saldoAkhirPiutang;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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

    public Date getTglBayar() {
        return tglBayar;
    }

    public void setTglBayar(Date tglBayar) {
        this.tglBayar = tglBayar;
    }

    public Long getIdPengembalianMp() {
        return idPengembalianMp;
    }

    public void setIdPengembalianMp(Long idPengembalianMp) {
        this.idPengembalianMp = idPengembalianMp;
    }

    @Override
    public void fromDto(PmbyPiutangDto dto) {
        this.setId(dto.getId());

        this.setTglProses(dto.getTglProses());

        this.setPeriodeMutasi(dto.getPeriodeMutasi());

        this.setNip(dto.getNip());

        this.setNamaPeserta(dto.getNamaPeserta());

        this.setIdPenerimaMp(dto.getIdPenerimaMp());

        this.setNamaPenerimaMp(dto.getNamaPenerimaMp());

        this.setNamaKantorBayar(dto.getNamaKantorBayar());

        this.setSaldoAwalPiutang(dto.getSaldoAwalPiutang());

        this.setDibayarkanPeriodeIni(dto.getDibayarkanPeriodeIni());

        this.setSaldoAkhirPiutang(dto.getSaldoAkhirPiutang());

        this.setStatus(dto.getStatus());

        this.setKeterangan(dto.getKeterangan());

        this.setNamaValidasi(dto.getNamaValidasi());

        this.setUserValidasi(dto.getUserValidasi());

        this.setTglBayar(dto.getTglBayar());

        this.setActive(dto.getActive());

        this.setUserStamp(dto.getUserStamp());

        this.setIdPengembalianMp(dto.getIdPengembalianMp());

    }

    @Override
    public PmbyPiutangDto toDto() {
        PmbyPiutangDto dto = new PmbyPiutangDto();

        dto.setId(this.getId());

        dto.setTglProses(this.getTglProses());

        dto.setPeriodeMutasi(this.getPeriodeMutasi());

        dto.setNip(this.getNip());

        dto.setNamaPeserta(this.getNamaPeserta());

        dto.setIdPenerimaMp(this.getIdPenerimaMp());

        dto.setNamaPenerimaMp(this.getNamaPenerimaMp());

        dto.setNamaKantorBayar(this.getNamaKantorBayar());

        dto.setSaldoAwalPiutang(this.getSaldoAwalPiutang());

        dto.setDibayarkanPeriodeIni(this.getDibayarkanPeriodeIni());

        dto.setSaldoAkhirPiutang(this.getSaldoAkhirPiutang());

        dto.setStatus(this.getStatus());

        dto.setKeterangan(this.getKeterangan());

        dto.setNamaValidasi(this.getNamaValidasi());

        dto.setUserValidasi(this.getUserValidasi());

        dto.setTglBayar(this.getTglBayar());

        dto.setActive(this.isActive());

        dto.setUserStamp(this.getUserStamp());

        dto.setIdPengembalianMp(this.getIdPengembalianMp());

        return dto;
    }
}
