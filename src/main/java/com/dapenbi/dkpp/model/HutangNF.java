package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dto.HutangNfDto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "TBL_T_HUTANG_NF")
public class HutangNF extends BaseModel<HutangNfDto>{
    @Id
    @Column(name = "ID_HUTANG", length = 22)
    private Long idHutang;
    @Column(name = "PERIODE_MUTASI", length = 6)
    private String periodeMutasi;
    @Column(name = "TGL_MUTASI", length = 7)
    private Date tglMutasi;
    @Column(name = "NIP", length = 40)
    private String  nip;
    @Column(name = "NAMA_PESERTA", length = 100)
    private String namaPeserta;
    @Column(name = "ID_PENERIMA_MP", length = 20)
    private String idPenerimaMp;
    @Column(name = "NAMA_PENERIMA_MP", length = 100)
    private String namaPenerimaMp;
    @Column(name = "REF_ID_PEMBAYARAN", length = 22)
    private Long refIdPembayaran;
    @Column(name = "SALDO_HUTANG", length = 22)
    private Long saldoHutang;
    @Column(name = "USER_STAMP", length = 100)
    private String userStamp;

    public Long getIdHutang() {
        return idHutang;
    }

    public void setIdHutang(Long idHutang) {
        this.idHutang = idHutang;
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

    public Long getRefIdPembayaran() {
        return refIdPembayaran;
    }

    public void setRefIdPembayaran(Long refIdPembayaran) {
        this.refIdPembayaran = refIdPembayaran;
    }

    public Long getSaldoHutang() {
        return saldoHutang;
    }

    public void setSaldoHutang(Long saldoHutang) {
        this.saldoHutang = saldoHutang;
    }

    public String getUserStamp() {
        return userStamp;
    }

    public void setUserStamp(String userStamp) {
        this.userStamp = userStamp;
    }

    @Override
    public void fromDto(HutangNfDto dto) {
        this.setIdHutang(dto.getIdHutang());
        this.setNip(dto.getNip());
        this.setNamaPeserta(dto.getNamaPeserta());
        this.setIdPenerimaMp(dto.getIdPenerimaMp());
        this.setNamaPenerimaMp(dto.getNamaPenerimaMp());
        this.setPeriodeMutasi(dto.getPeriodeMutasi());
        this.setTglMutasi(dto.getTglMutasi());
        this.setRefIdPembayaran(dto.getRefIdPembayaran());
        this.setSaldoHutang(dto.getSaldoHutang());
        this.setUserStamp(dto.getUserStamp());
    }

    @Override
    public HutangNfDto toDto() {
        HutangNfDto dto = new HutangNfDto();
        dto.setIdHutang(this.getIdHutang());
        dto.setNip(this.getNip());
        dto.setNamaPeserta(this.getNamaPeserta());
        dto.setIdPenerimaMp(this.getIdPenerimaMp());
        dto.setNamaPenerimaMp(this.getNamaPenerimaMp());
        dto.setPeriodeMutasi(this.getPeriodeMutasi());
        dto.setTglMutasi(this.getTglMutasi());
        dto.setRefIdPembayaran(this.getRefIdPembayaran());
        dto.setSaldoHutang(this.getSaldoHutang());
        dto.setUserStamp(this.getUserStamp());

        return dto;
    }
}
