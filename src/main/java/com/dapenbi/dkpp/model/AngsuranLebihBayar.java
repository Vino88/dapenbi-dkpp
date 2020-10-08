package com.dapenbi.dkpp.model;


import com.dapenbi.dkpp.dto.AngsuranLebihBayarDto;
import com.dapenbi.dkpp.dto.KantorBayarDto;
import com.dapenbi.dkpp.dto.KategoriPenerimaDto;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TBL_T_ANGSURAN_LEBIH_BAYAR")
public class AngsuranLebihBayar extends BaseModel<AngsuranLebihBayarDto>{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_ANGSURAN_SEQ")
    @SequenceGenerator(sequenceName = "idAngsuran_seq", allocationSize = 1, name = "ID_ANGSURAN_SEQ")
    @Column(name = "ID_ANGSURAN")
    private Long id;

    @Column(name = "NAMA_PESERTA",length = 50)
    private String namaPeserta;

    @Column(name = "PERIODE_MUTASI",length = 6)
    private String periodeMutasi;

    @Temporal(TemporalType.DATE)
    @Column(name = "TGL_MUTASI")
    private Date tglMutasi;

    @Column(name = "NIP",length = 20)
    private String nip;

    @Column(name = "ID_PENERIMA_MP",length = 20)
    private String idPenerimaMp;

    @Column(name = "NAMA_PENERIMA_MP",length = 100)
    private String namaPenerimaMp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_KATEGORI_PENERIMA_MP")
    private KategoriPenerima kategoriPenerima;

    @Column(name = "NAMA_KATEGORI_PENERIMA_MP",length = 20)
    private String namaKategoriPenerima;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_KANTOR_BAYAR")
    private KantorBayar kantorBayar;

    @Column(name = "NAMA_KANTOR_BAYAR",length = 50)
    private String namaKantorBayar;

    @Column(name = "SALDO_AWAL_LEBIH_BAYAR",precision = 20,scale = 2)
    private Long saldoAwalLebihBayar;

    @Column(name = "ANGSURAN",precision = 20,scale = 2)
    private Long Angsuran;

    @Column(name = "SALDO_AKHIR_LEBIH_BAYAR",precision = 20,scale = 2)
    private Long saldoAkhirLebihBayar;

    @Column(name = "PERIODE_LEBIH_BAYAR",length = 20)
    private String periodeLebihBayar;

    @Column(name = "LEBIH_BAYAR_MP",precision = 20,scale = 2)
    private Long lebihBayarMp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
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

    public KategoriPenerima getKategoriPenerima() {
        return kategoriPenerima;
    }

    public void setKategoriPenerima(KategoriPenerima kategoriPenerima) {
        this.kategoriPenerima = kategoriPenerima;
    }

    public String getNamaKategoriPenerima() {
        return namaKategoriPenerima;
    }

    public void setNamaKategoriPenerima(String namaKategoriPenerima) {
        this.namaKategoriPenerima = namaKategoriPenerima;
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

    public Long getSaldoAwalLebihBayar() {
        return saldoAwalLebihBayar;
    }

    public void setSaldoAwalLebihBayar(Long saldoAwalLebihBayar) {
        this.saldoAwalLebihBayar = saldoAwalLebihBayar;
    }

    public Long getAngsuran() {
        return Angsuran;
    }

    public void setAngsuran(Long angsuran) {
        Angsuran = angsuran;
    }

    public Long getSaldoAkhirLebihBayar() {
        return saldoAkhirLebihBayar;
    }

    public void setSaldoAkhirLebihBayar(Long saldoAkhirLebihBayar) {
        this.saldoAkhirLebihBayar = saldoAkhirLebihBayar;
    }

    public String getPeriodeLebihBayar() {
        return periodeLebihBayar;
    }

    public void setPeriodeLebihBayar(String periodeLebihBayar) {
        this.periodeLebihBayar = periodeLebihBayar;
    }

    public Long getLebihBayarMp() {
        return lebihBayarMp;
    }

    public void setLebihBayarMp(Long lebihBayarMp) {
        this.lebihBayarMp = lebihBayarMp;
    }

    @Override
    public void fromDto(AngsuranLebihBayarDto dto) {
        this.setId(dto.getId());
        this.setNamaPeserta(dto.getNamaPeserta());
        this.setPeriodeMutasi(dto.getPeriodeMutasi());
        this.setTglMutasi(dto.getTglMutasi());
        this.setNip(dto.getNip());
        this.setIdPenerimaMp(dto.getIdPenerimaMp());
        this.setNamaPenerimaMp(dto.getNamaPenerimaMp());
        this.setNamaKategoriPenerima(dto.getNamaKategoriPenerima());
        this.setNamaKantorBayar(dto.getNamaKantorBayar());
        this.setSaldoAwalLebihBayar(dto.getSaldoAwalLebihBayar());
        this.setAngsuran(dto.getAngsuran());
        this.setSaldoAkhirLebihBayar(dto.getSaldoAkhirLebihBayar());
        this.setUserStamp(dto.getUserStamp());
        this.setActive(dto.getActive());
        this.setPeriodeLebihBayar(dto.getPeriodeLebihBayar());
        this.setLebihBayarMp(dto.getLebihBayarMp());

    }

    @Override
    public AngsuranLebihBayarDto toDto() {
        AngsuranLebihBayarDto dto = new AngsuranLebihBayarDto();
        dto.setId(this.getId());
        dto.setNamaPeserta(this.getNamaPeserta());
        dto.setPeriodeMutasi(this.getPeriodeMutasi());
        dto.setTglMutasi(this.getTglMutasi());
        dto.setNip(this.getNip());
        dto.setIdPenerimaMp(this.getIdPenerimaMp());
        dto.setNamaPenerimaMp(this.getNamaPenerimaMp());
        dto.setNamaKategoriPenerima(this.getNamaKategoriPenerima());
        dto.setNamaKantorBayar(this.getNamaKantorBayar());
        dto.setSaldoAwalLebihBayar(this.getSaldoAwalLebihBayar());
        dto.setAngsuran(this.getAngsuran());
        dto.setSaldoAkhirLebihBayar(this.getSaldoAkhirLebihBayar());
        dto.setUserStamp(this.getUserStamp());
        dto.setActive(super.isActive());
        dto.setPeriodeLebihBayar(this.getPeriodeLebihBayar());
        dto.setLebihBayarMp(this.getLebihBayarMp());
        return dto;
    }
}
