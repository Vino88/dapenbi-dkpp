package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dto.PiutangDto;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TBL_T_PIUTANG")
public class Piutang extends BaseModel<PiutangDto> {

    @Id
    @Column(name = "NIP", length = 20)
    private String nip;

    @Column(name= "NAMA_PESERTA", length = 100)
    private String namaPeserta;

    @Column(name= "TOTAL_PIUTANG", length = 22)
    private Long totalPiutang;

    @Column(name= "SUDAH_DIBAYAR", length = 22)
    private Long sudahDibayar;

    @Column(name= "SISA_PIUTANG", length = 22)
    private Long sisaPiutang;

    @Column(name= "ID_PENERIMA_MP", length = 20)
    private String idPenerimaMp;

    @Column(name= "NAMA_PENERIMA_MP", length = 100)
    private String namaPenerimaMp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "ID_KANTOR_BAYAR")
    private KantorBayar idKantorBayar;

    @Column(name= "NAMA_KANTOR_BAYAR", length = 100)
    private String namaKantorBayar;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "ID_KATEGORI_PENERIMA_MP")
    private KategoriPenerima idKategoriPenerimaMp;

    @Column(name= "NAMA_KATEGORI_PENERIMA_MP", length = 100)
    private String namaKategoriPenerimaMp;

    @Column(name= "PERIODE_AWAL_PIUTANG", length = 6)
    private String periodeAwalPiutang;

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

    public Long getTotalPiutang() {
        return totalPiutang;
    }

    public void setTotalPiutang(Long totalPiutang) {
        this.totalPiutang = totalPiutang;
    }

    public Long getSudahDibayar() {
        return sudahDibayar;
    }

    public void setSudahDibayar(Long sudahDibayar) {
        this.sudahDibayar = sudahDibayar;
    }

    public Long getSisaPiutang() {
        return sisaPiutang;
    }

    public void setSisaPiutang(Long sisaPiutang) {
        this.sisaPiutang = sisaPiutang;
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

    public String getPeriodeAwalPiutang() {
        return periodeAwalPiutang;
    }

    public void setPeriodeAwalPiutang(String periodeAwalPiutang) {
        this.periodeAwalPiutang = periodeAwalPiutang;
    }

    @Override
    public void fromDto(PiutangDto dto) {
        this.setNip(dto.getNip());
        this.setNamaPeserta(dto.getNamaPeserta());
        this.setUserStamp(dto.getUserStamp());
        this.setIdPenerimaMp(dto.getIdPenerimaMp());
        this.setNamaPenerimaMp(dto.getNamaPenerimaMp());

        this.setNamaKantorBayar(dto.getNamaKantorBayar());

        this.setNamaKategoriPenerimaMp(dto.getNamaKategoriPenerimaMp());
        this.setTotalPiutang(dto.getTotalPiutang());
        this.setSudahDibayar(dto.getSudahDibayar());
        this.setSisaPiutang(dto.getSisaPiutang());
        this.setPeriodeAwalPiutang(dto.getPeriodeAwalPiutang());
        this.setActive(dto.getActive());
    }

    @Override
    public PiutangDto toDto() {
        PiutangDto dto = new PiutangDto();
        dto.setNip(this.getNip());
        dto.setNamaPeserta(this.getNamaPeserta());
        dto.setUserStamp(this.getUserStamp());
        dto.setIdPenerimaMp(this.getIdPenerimaMp());
        dto.setNamaPenerimaMp(this.getNamaPenerimaMp());

        dto.setNamaKantorBayar(this.getNamaKantorBayar());

        dto.setNamaKategoriPenerimaMp(this.getNamaKategoriPenerimaMp());
        dto.setTotalPiutang(this.getTotalPiutang());
        dto.setSudahDibayar(this.getSudahDibayar());
        dto.setSisaPiutang(this.getSisaPiutang());
        dto.setPeriodeAwalPiutang(dto.getPeriodeAwalPiutang());
        dto.setActive(this.isActive());
        return dto;
    }
}
