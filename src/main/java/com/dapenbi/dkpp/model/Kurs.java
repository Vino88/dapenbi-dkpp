package com.dapenbi.dkpp.model;


import com.dapenbi.dkpp.dto.KursDto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name="TBL_T_KURS")
public class Kurs extends BaseModel<KursDto>{

    @Id
    @Column(name="PERIODE_MUTASI", unique=true, nullable=false, length=6)
    private String periodeMutasi;

    @Column(name="KURS_EURO", nullable=false, precision=8)
    private BigDecimal kursEuro;

    @Column(name="KURS_RUPIAH", nullable=false, precision=8, scale=2)
    private BigDecimal kursRupiah;

    public Kurs() {
    }

    public String getPeriodeMutasi() {
        return periodeMutasi;
    }

    public void setPeriodeMutasi(String periodeMutasi) {
        this.periodeMutasi = periodeMutasi;
    }

    public BigDecimal getKursEuro() {
        return kursEuro;
    }

    public void setKursEuro(BigDecimal kursEuro) {
        this.kursEuro = kursEuro;
    }

    public BigDecimal getKursRupiah() {
        return kursRupiah;
    }

    public void setKursRupiah(BigDecimal kursRupiah) {
        this.kursRupiah = kursRupiah;
    }

    @Override
    public void fromDto(KursDto dto) {
        this.setPeriodeMutasi(this.getPeriodeMutasi());
        this.setKursEuro(this.getKursEuro());
        this.setKursRupiah(this.getKursRupiah());
        this.setActive(this.isActive());
    }

    @Override
    public KursDto toDto() {
        KursDto dto = new KursDto();
        dto.setPeriodeMutasi(this.getPeriodeMutasi());
        dto.setKursEuro(this.getKursEuro());
        dto.setKursRupiah(this.getKursRupiah());
        dto.setActive(this.isActive());
        return dto;
    }

}
