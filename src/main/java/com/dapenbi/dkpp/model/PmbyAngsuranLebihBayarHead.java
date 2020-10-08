package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dto.BaseDto;
import com.dapenbi.dkpp.dto.PmbyAngsuranLebihBayarHeadDto;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TBL_T_PMBY_ANG_LEBIH_BAYAR_H")
@NamedStoredProcedureQuery(name = "PmbyAngasuranLebihBayarHead.processPmbyLebihBayar",
        procedureName = "CUSP_PEMBAYARAN_ANG_LBH_BYR",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ROLE_ID"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_COMP_NAME"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_USER_NAME"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_PERIODE_BAYAR"),
                @StoredProcedureParameter(mode = ParameterMode.OUT, type = Character.class, name = "PAR_STATUS_EKSEKUSI"),
                @StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name = "PAR_MSG"),
        }
)
public class PmbyAngsuranLebihBayarHead extends BaseModel<PmbyAngsuranLebihBayarHeadDto> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PMBY_ANG_LEBIH_BAYAR_H_SEQ")
    @SequenceGenerator(sequenceName = "pmbyAngLebihBayarH_seq", allocationSize = 1, name = "PMBY_ANG_LEBIH_BAYAR_H_SEQ")
    @Column(name = "ID_PEMBAYARAN_H")
    private Long id;

    @Column(name = "PERIODE_MUTASI", length = 6)
    private String periodeMutasi;

    @Temporal(TemporalType.DATE)
    @Column(name = "TGL_PEMBAYARAN")
    private Date tglPembayaran;

    @Column(name = "NIP",length = 50)
    private String nip;

    @Column(name = "NAMA_PESERTA",length = 100)
    private String namaPeserta;

    @Column(name = "ID_PENERIMA_MP",length = 50)
    private String idPenerimaMp;

    @Column(name = "NAMA_PENERIMA_MP",length = 100)
    private String namaPenerimaMp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_KANTOR_BAYAR")
    private KantorBayar kantorBayar;

    @Column(name = "NAMA_KANTOR_BAYAR",length = 100)
    private String namaKantorBayar;

    @Column(name = "TOTAL_ANGSURAN",precision = 20,scale = 2)
    private Long totalAngsuran;

    @Column(name = "TOTAL_SALDO_AWAL",precision = 20,scale = 2)
    private Long totalSaldoAwal;

    @Column(name = "TOTAL_SALDO_AKHIR",precision = 20,scale = 2)
    private Long totalSaldoAkhir;

    @Column(name = "is_active")
    protected Boolean isActive;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPeriodeMutasi() {
        return periodeMutasi;
    }

    public void setPeriodeMutasi(String periodeMutasi) {
        this.periodeMutasi = periodeMutasi;
    }

    public Date getTglPembayaran() {
        return tglPembayaran;
    }

    public void setTglPembayaran(Date tglPembayaran) {
        this.tglPembayaran = tglPembayaran;
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

    public KantorBayar getKantorBayar() {
        return kantorBayar;
    }

    public void setKantorBayar(KantorBayar kantorBayar) {
        this.kantorBayar = kantorBayar;
    }

    public String getNamaKantorBayar() {
        return namaKantorBayar;
    }

    public void setNamaKantorBayar(String namaKantorBayar) {
        this.namaKantorBayar = namaKantorBayar;
    }

    public Long getTotalAngsuran() {
        return totalAngsuran;
    }

    public void setTotalAngsuran(Long totalAngsuran) {
        this.totalAngsuran = totalAngsuran;
    }

    public Long getTotalSaldoAwal() {
        return totalSaldoAwal;
    }

    public void setTotalSaldoAwal(Long totalSaldoAwal) {
        this.totalSaldoAwal = totalSaldoAwal;
    }

    public Long getTotalSaldoAkhir() {
        return totalSaldoAkhir;
    }

    public void setTotalSaldoAkhir(Long totalSaldoAkhir) {
        this.totalSaldoAkhir = totalSaldoAkhir;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Override
    public void fromDto(PmbyAngsuranLebihBayarHeadDto dto) {
        this.setId(dto.getId());
        this.setPeriodeMutasi(dto.getPeriodeMutasi());
        this.setTglPembayaran(dto.getTglPembayaran());
        this.setNip(dto.getNip());
        this.setNamaPeserta(dto.getNamaPeserta());
        this.setIdPenerimaMp(dto.getIdPenerimaMp());
        this.setNamaPenerimaMp(dto.getNamaPenerimaMp());
        this.setNamaKantorBayar(dto.getNamaKantorBayar());
        this.setTotalAngsuran(dto.getTotalAngsuran());
        this.setTotalSaldoAwal(dto.getTotalSaldoAwal());
        this.setTotalSaldoAkhir(dto.getTotalSaldoAkhir());
        this.setUserStamp(dto.getUserStamp());

    }

    @Override
    public PmbyAngsuranLebihBayarHeadDto toDto() {
        PmbyAngsuranLebihBayarHeadDto dto = new PmbyAngsuranLebihBayarHeadDto();
        dto.setId(this.getId());
        dto.setPeriodeMutasi(this.getPeriodeMutasi());
        dto.setTglPembayaran(this.getTglPembayaran());
        dto.setNip(this.getNip());
        dto.setNamaPeserta(this.getNamaPeserta());
        dto.setIdPenerimaMp(this.getIdPenerimaMp());
        dto.setNamaPenerimaMp(this.getNamaPenerimaMp());
        dto.setNamaKantorBayar(this.getNamaKantorBayar());
        dto.setTotalAngsuran(this.getTotalAngsuran());
        dto.setTotalSaldoAwal(this.getTotalSaldoAwal());
        dto.setTotalSaldoAkhir(this.getTotalSaldoAkhir());
        dto.setUserStamp(this.getUserStamp());
        return dto;
    }
}
