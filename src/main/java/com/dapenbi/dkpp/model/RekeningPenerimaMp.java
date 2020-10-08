package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dto.RekeningPenerimaMpDto;
import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.persistence.*;

@Entity
@Table(name="TBL_M_REKENING_PENERIMA_MP")
public class RekeningPenerimaMp extends BaseModel<RekeningPenerimaMpDto>{

    @Id
    @Column(nullable=false, length=10)
    private String nip;

    @Column(name="JENIS_BANK", nullable=false, length=20)
    private String jenisBank;

    @Column(name="NAMA_CABANG_BANK", nullable=false, length=50)
    private String namaCabangBank;

    @Column(name="NAMA_KATEGORI_PENERIMA", nullable=false, length=50)
    private String namaKategoriPenerima;

    @Column(name="NAMA_PENERIMA_MP", nullable=false, length=50)
    private String namaPenerimaMp;

    @Column(name="NAMA_PESERTA", nullable=false, length=50)
    private String namaPeserta;

    @Column(name="NAMA_REKENING", nullable=false, length=50)
    private String namaRekening;

    @Column(name="NOMOR_REKENING", nullable=false, length=50)
    private String nomorRekening;

    @ManyToOne
    @JoinColumn(name="ID_KATEGORI_PENERIMA", referencedColumnName="ID_KATEGORI_PENERIMA")
    private KategoriPenerima kategoriPenerima;

    @Column(name="ID_PENERIMA_MP", length = 20)
    private String penerimaMP;

    @ManyToOne
    @JoinColumn(name="ID_BANK", referencedColumnName="ID_BANK_NF")
    private BankNF bankNF;

    public RekeningPenerimaMp() {
        super();
    }

    public String getJenisBank() {
        return jenisBank;
    }

    public void setJenisBank(String jenisBank) {
        this.jenisBank = jenisBank;
    }

    public String getNamaCabangBank() {
        return namaCabangBank;
    }

    public void setNamaCabangBank(String namaCabangBank) {
        this.namaCabangBank = namaCabangBank;
    }

    public String getNamaKategoriPenerima() {
        return namaKategoriPenerima;
    }

    public void setNamaKategoriPenerima(String namaKategoriPenerima) {
        this.namaKategoriPenerima = namaKategoriPenerima;
    }

    public String getNamaPenerimaMp() {
        return namaPenerimaMp;
    }

    public void setNamaPenerimaMp(String namaPenerimaMp) {
        this.namaPenerimaMp = namaPenerimaMp;
    }

    public String getNamaPeserta() {
        return namaPeserta;
    }

    public void setNamaPeserta(String namaPeserta) {
        this.namaPeserta = namaPeserta;
    }

    public String getNamaRekening() {
        return namaRekening;
    }

    public void setNamaRekening(String namaRekening) {
        this.namaRekening = namaRekening;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNomorRekening() {
        return nomorRekening;
    }

    public void setNomorRekening(String nomorRekening) {
        this.nomorRekening = nomorRekening;
    }

    public KategoriPenerima getKategoriPenerima() {
        return kategoriPenerima;
    }

    public void setKategoriPenerima(KategoriPenerima kategoriPenerima) {
        this.kategoriPenerima = kategoriPenerima;
    }

    public String getPenerimaMP() {
        return penerimaMP;
    }

    public void setPenerimaMP(String penerimaMP) {
        this.penerimaMP = penerimaMP;
    }

    public BankNF getBankNF() {
        return bankNF;
    }

    public void setBankNF(BankNF bankNF) {
        this.bankNF = bankNF;
    }

    public void fromDto(RekeningPenerimaMpDto dto) {
        this.setNip( dto.getNip() );
        this.setNamaPeserta( dto.getNamaPeserta() );
        this.setNamaPenerimaMp( dto.getNamaPenerimaMp() );
        this.setNamaKategoriPenerima( dto.getNamaKategoriPenerima() );
        this.setJenisBank( dto.getJenisBank() );
        this.setNamaCabangBank( dto.getNamaCabangBank() );
        this.setNamaRekening( dto.getNamaRekening() );
        this.setNomorRekening( dto.getNomorRekening() );
    }

    public RekeningPenerimaMpDto toDto() {
        RekeningPenerimaMpDto dto = new RekeningPenerimaMpDto();
        dto.setNip( this.getNip() );
        dto.setNamaPeserta( this.getNamaPeserta() );
        dto.setIdPenerimaMp( String.valueOf( this.getPenerimaMP()));
        dto.setNamaPenerimaMp( this.getNamaPenerimaMp() );
        dto.setIdKategoriPenerima( this.getKategoriPenerima().getId() );
        dto.setNamaKategoriPenerima( this.getNamaKategoriPenerima() );
        dto.setIdBank( this.getBankNF().getId() );
        dto.setNamaBank(this.getBankNF().getNamaBankNF());
        dto.setJenisBank( this.getJenisBank() );
        dto.setNamaCabangBank( this.getNamaCabangBank() );
        dto.setNamaRekening( this.getNamaRekening() );
        dto.setNomorRekening( this.getNomorRekening() );
        dto.setActive(this.isActive());
        return dto;
    }
}
