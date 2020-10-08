package com.dapenbi.dkpp.model;


import com.dapenbi.dkpp.dto.PmbyAngsuranLebihBayarDetDto;

import javax.persistence.*;

@Entity
@Table(name = "TBL_T_PMBY_ANG_LEBIH_BAYAR_D")
public class PmbyAngsuranLebihBayarDet extends BaseModel<PmbyAngsuranLebihBayarDetDto>{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PMBY_ANG_LEBIH_BAYAR_D_SEQ")
    @SequenceGenerator(sequenceName = "pmbyAngLebihBayarD_seq", allocationSize = 1, name = "PMBY_ANG_LEBIH_BAYAR_D_SEQ")
    @Column(name = "ID_PEMBAYARAN_D")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ANGSURAN")
    private AngsuranLebihBayar angsuranLebihBayar;

    @Column(name = "PERIODE_PEMBAYARAN",length = 6)
    private String periodePembayaran;

    @Column(name = "LEBIH_BAYAR_MP",precision = 20,scale = 2)
    private Long lebihBayarMp;

    @Column(name = "ANGSURAN",precision = 20,scale = 2)
    private Long angsuran;

    @Column(name = "SALDO_AWAL",precision = 20, scale = 2)
    private Long saldoAwal;

    @Column(name = "SALDO_AKHIR",precision = 20,scale = 2)
    private Long saldoAkhir;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PEMBAYARAN_H")
    private PmbyAngsuranLebihBayarHead pmbyAngsuranLebihBayarHead;

    @Column(name = "is_active")
    protected Boolean isActive;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AngsuranLebihBayar getAngsuranLebihBayar() {
        return angsuranLebihBayar;
    }

    public void setAngsuranLebihBayar(AngsuranLebihBayar angsuranLebihBayar) {
        this.angsuranLebihBayar = angsuranLebihBayar;
    }

    public String getPeriodePembayaran() {
        return periodePembayaran;
    }

    public void setPeriodePembayaran(String periodePembayaran) {
        this.periodePembayaran = periodePembayaran;
    }

    public Long getLebihBayarMp() {
        return lebihBayarMp;
    }

    public void setLebihBayarMp(Long lebihBayarMp) {
        this.lebihBayarMp = lebihBayarMp;
    }

    public Long getAngsuran() {
        return angsuran;
    }

    public void setAngsuran(Long angsuran) {
        this.angsuran = angsuran;
    }

    public Long getSaldoAwal() {
        return saldoAwal;
    }

    public void setSaldoAwal(Long saldoAwal) {
        this.saldoAwal = saldoAwal;
    }

    public Long getSaldoAkhir() {
        return saldoAkhir;
    }

    public void setSaldoAkhir(Long saldoAkhir) {
        this.saldoAkhir = saldoAkhir;
    }

    public PmbyAngsuranLebihBayarHead getPmbyAngsuranLebihBayarHead() {
        return pmbyAngsuranLebihBayarHead;
    }

    public void setPmbyAngsuranLebihBayarHead(PmbyAngsuranLebihBayarHead pmbyAngsuranLebihBayarHead) {
        this.pmbyAngsuranLebihBayarHead = pmbyAngsuranLebihBayarHead;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Override
    public void fromDto(PmbyAngsuranLebihBayarDetDto dto) {
    this.setId(dto.getId());
    this.setPeriodePembayaran(dto.getPeriodePembayaran());
    this.setLebihBayarMp(dto.getLebihBayarMp());
    this.setAngsuran(dto.getAngsuran());
    this.setSaldoAwal(dto.getSaldoAwal());
    this.setSaldoAkhir(dto.getSaldoAkhir());
    this.setUserStamp(dto.getUserStamp());

    }

    @Override
    public PmbyAngsuranLebihBayarDetDto toDto() {
        PmbyAngsuranLebihBayarDetDto dto = new PmbyAngsuranLebihBayarDetDto();
        dto.setId(this.getId());
        dto.setPeriodePembayaran(this.getPeriodePembayaran());
        dto.setLebihBayarMp(this.getLebihBayarMp());
        dto.setAngsuran(this.getAngsuran());
        dto.setSaldoAwal(this.getSaldoAwal());
        dto.setSaldoAkhir(this.getSaldoAkhir());
        dto.setUserStamp(this.getUserStamp());
        return dto;
    }




}
