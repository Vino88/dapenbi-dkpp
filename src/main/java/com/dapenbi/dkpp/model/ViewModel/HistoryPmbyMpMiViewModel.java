package com.dapenbi.dkpp.model.ViewModel;

import com.dapenbi.dkpp.dto.ViewModelDto.HistoryPmbyMpMiViewModelDto;
import com.dapenbi.dkpp.model.BaseModel;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Immutable
@Table(name="VW_HISTORY_PEMBAYARAN_MP_MI")
public class HistoryPmbyMpMiViewModel extends BaseModel<HistoryPmbyMpMiViewModelDto> {

    @Id
    @Column(name = "ID_PEMBAYARAN", length = 22)
    private Long id;
    @Column(name = "PERIODE_PEMBAYARAN", length = 6)
    private String periodePembayaran;
    @Column(name = "NIP", length = 10)
    private String nip;
    @Column(name = "MP_BULANAN", length = 22)
    private BigDecimal mpBulanan;
    @Column(name = "KURANG_BAYAR_MP_BULANAN", length = 22)
    private BigDecimal kurangBayarMpBulanan;
    @Column(name = "LEBIH_BAYAR_MP_BULANAN", length = 22)
    private BigDecimal lebihBayarMpBulanan;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPeriodePembayaran() {
        return periodePembayaran;
    }

    public void setPeriodePembayaran(String periodePembayaran) {
        this.periodePembayaran = periodePembayaran;
    }

    public BigDecimal getMpBulanan() {
        return mpBulanan;
    }

    public void setMpBulanan(BigDecimal mpBulanan) {
        this.mpBulanan = mpBulanan;
    }

    public BigDecimal getKurangBayarMpBulanan() {
        return kurangBayarMpBulanan;
    }

    public void setKurangBayarMpBulanan(BigDecimal kurangBayarMpBulanan) {
        this.kurangBayarMpBulanan = kurangBayarMpBulanan;
    }

    public BigDecimal getLebihBayarMpBulanan() {
        return lebihBayarMpBulanan;
    }

    public void setLebihBayarMpBulanan(BigDecimal lebihBayarMpBulanan) {
        this.lebihBayarMpBulanan = lebihBayarMpBulanan;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    @Override
    public void fromDto(HistoryPmbyMpMiViewModelDto dto) {
        this.setId(dto.getId());
        this.setPeriodePembayaran(dto.getPeriodePembayaran());
        this.setKurangBayarMpBulanan(dto.getKurangBayarMpBulanan());
        this.setLebihBayarMpBulanan(dto.getLebihBayarMpBulanan());
        this.setMpBulanan(dto.getMpBulanan());
        this.setNip(dto.getNip());
    }

    @Override
    public HistoryPmbyMpMiViewModelDto toDto() {
        HistoryPmbyMpMiViewModelDto dto = new HistoryPmbyMpMiViewModelDto();
        dto.setId(this.getId());
        dto.setPeriodePembayaran(this.getPeriodePembayaran());
        dto.setMpBulanan(this.getMpBulanan());
        dto.setKurangBayarMpBulanan(this.getKurangBayarMpBulanan());
        dto.setLebihBayarMpBulanan(this.getLebihBayarMpBulanan());
        dto.setNip(this.nip);
        return dto;
    }
}
