package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dto.PengolahanDataBerkalaDto;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TBL_T_REPORT_DATA_BERKALA")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "PengolahanDataBerkala.cuspReportDataBerkala",
                procedureName = "CUSP_REPORT_DATA_BERKALA",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_COMP_NAME"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_USER_NAME"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_PERIODE"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_REQUEST_BY"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_JENIS_REPORT"),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, type = Character.class, name = "PAR_STATUS_EKSEKUSI"),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name = "PAR_MSG"),
                }
        )})
public class PengolahanDataBerkala extends BaseModel<PengolahanDataBerkalaDto>{

    @Id
    private String nip;
    @Column(name = "PERIODE", length = 6)
    private String periode;
    @Column(name = "NAMA_PESERTA", length = 50)
    private String namaPeserta;
    @Column(name = "ID_PENERIMA_MP", length = 20)
    private String idPenerimaMp;
    @Column(name = "NAMA_PENERIMA_MP", length = 50)
    private String namaPenerimaMp;
    @Column(name = "TGL_LAHIR", length = 7)
    private Date tglLahir;
    @Column(name = "TGL_HENTI_KERJA", length = 7)
    private Date tglHentiKerja;
    @Column(name = "ID_GOLONGAN", length = 22)
    private Long idGolongan;
    @Column(name = "PANGKAT_JABATAN", length = 100)
    private String pangkatJabatan;
    @Column(name = "MP_BULANAN", length = 22)
    private Long mpBulanan;
    @Column(name = "ID_KANTOR_BAYAR", length = 20)
    private String idKantorBayar;
    @Column(name = "NAMA_KANTOR_BAYAR", length = 50)
    private String namaKantorBayar;
    @Column(name = "ID_JENIS_BANK", length = 22)
    private Long idJenisBank;
    @Column(name = "JENIS_BANK", length = 20)
    private String jenisBank;
    @Column(name = "NAMA_BANK", length = 50)
    private String namaBank;
    @Column(name = "NAMA_CABANG_BANK", length = 50)
    private String namaCabangBank;
    @Column(name = "NOMOR_REKENING", length = 22)
    private Long nomorRekening;
    @Column(name = "NAMA_REKENING", length = 50)
    private String namaRekening;
    @Column(name = "PERIODE_BAYAR_MP", length = 6)
    private String periodeBayarMp;
    @Column(name = "ID_AGAMA", length = 22)
    private Long idAgama;
    @Column(name = "NAMA_AGAMA", length = 20)
    private String namaAgama;
    @Column(name = "ALAMAT", length = 100)
    private String alamat;
    @Column(name = "TGL_WAFAT_PESERTA", length = 7)
    private Date tglWafatPeserta;
    @Column(name = "TGL_WAFAT_PENERIMA", length = 7)
    private Date tglWafatPenerima;
    @Column(name = "TGL_HENTI_BAYAR", length = 7)
    private Date tglHentiBayar;
    @Column(name = "REQUEST_BY", length = 20)
    private String requestBy;
    @Column(name = "JENIS_REPORT", length = 22)
    private Long jenisReport;
    @Column(name = "USER_STAMP", length = 100)
    private String userStamp;

    public String getPeriode() {
        return periode;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
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

    public Date getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(Date tglLahir) {
        this.tglLahir = tglLahir;
    }

    public Date getTglHentiKerja() {
        return tglHentiKerja;
    }

    public void setTglHentiKerja(Date tglHentiKerja) {
        this.tglHentiKerja = tglHentiKerja;
    }

    public Long getIdGolongan() {
        return idGolongan;
    }

    public void setIdGolongan(Long idGolongan) {
        this.idGolongan = idGolongan;
    }

    public String getPangkatJabatan() {
        return pangkatJabatan;
    }

    public void setPangkatJabatan(String pangkatJabatan) {
        this.pangkatJabatan = pangkatJabatan;
    }

    public Long getMpBulanan() {
        return mpBulanan;
    }

    public void setMpBulanan(Long mpBulanan) {
        this.mpBulanan = mpBulanan;
    }

    public String getIdKantorBayar() {
        return idKantorBayar;
    }

    public void setIdKantorBayar(String idKantorBayar) {
        this.idKantorBayar = idKantorBayar;
    }

    public String getNamaKantorBayar() {
        return namaKantorBayar;
    }

    public void setNamaKantorBayar(String namaKantorBayar) {
        this.namaKantorBayar = namaKantorBayar;
    }

    public Long getIdJenisBank() {
        return idJenisBank;
    }

    public void setIdJenisBank(Long idJenisBank) {
        this.idJenisBank = idJenisBank;
    }

    public String getJenisBank() {
        return jenisBank;
    }

    public void setJenisBank(String jenisBank) {
        this.jenisBank = jenisBank;
    }

    public String getNamaBank() {
        return namaBank;
    }

    public void setNamaBank(String namaBank) {
        this.namaBank = namaBank;
    }

    public String getNamaCabangBank() {
        return namaCabangBank;
    }

    public void setNamaCabangBank(String namaCabangBank) {
        this.namaCabangBank = namaCabangBank;
    }

    public Long getNomorRekening() {
        return nomorRekening;
    }

    public void setNomorRekening(Long nomorRekening) {
        this.nomorRekening = nomorRekening;
    }

    public String getNamaRekening() {
        return namaRekening;
    }

    public void setNamaRekening(String namaRekening) {
        this.namaRekening = namaRekening;
    }

    public String getPeriodeBayarMp() {
        return periodeBayarMp;
    }

    public void setPeriodeBayarMp(String periodeBayarMp) {
        this.periodeBayarMp = periodeBayarMp;
    }

    public Long getIdAgama() {
        return idAgama;
    }

    public void setIdAgama(Long idAgama) {
        this.idAgama = idAgama;
    }

    public String getNamaAgama() {
        return namaAgama;
    }

    public void setNamaAgama(String namaAgama) {
        this.namaAgama = namaAgama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public Date getTglWafatPeserta() {
        return tglWafatPeserta;
    }

    public void setTglWafatPeserta(Date tglWafatPeserta) {
        this.tglWafatPeserta = tglWafatPeserta;
    }

    public Date getTglWafatPenerima() {
        return tglWafatPenerima;
    }

    public void setTglWafatPenerima(Date tglWafatPenerima) {
        this.tglWafatPenerima = tglWafatPenerima;
    }

    public Date getTglHentiBayar() {
        return tglHentiBayar;
    }

    public void setTglHentiBayar(Date tglHentiBayar) {
        this.tglHentiBayar = tglHentiBayar;
    }

    public String getRequestBy() {
        return requestBy;
    }

    public void setRequestBy(String requestBy) {
        this.requestBy = requestBy;
    }

    public Long getJenisReport() {
        return jenisReport;
    }

    public void setJenisReport(Long jenisReport) {
        this.jenisReport = jenisReport;
    }

    public String getUserStamp() {
        return userStamp;
    }

    public void setUserStamp(String userStamp) {
        this.userStamp = userStamp;
    }

    @Override
    public void fromDto(PengolahanDataBerkalaDto dto){
        this.setPeriode(dto.getPeriode());
        this.setNip(dto.getNip());
        this.setNamaPeserta(dto.getNamaPeserta());
        this.setNamaPenerimaMp(dto.getNamaPenerimaMp());
        this.setIdPenerimaMp(dto.getIdPenerimaMp());
        this.setTglLahir(dto.getTglLahir());
        this.setTglHentiKerja(dto.getTglHentiKerja());
        this.setIdGolongan(dto.getIdGolongan());
        this.setPangkatJabatan(dto.getPangkatJabatan());
        this.setMpBulanan(dto.getMpBulanan());
        this.setIdKantorBayar(dto.getIdKantorBayar());
        this.setNamaKantorBayar(dto.getNamaKantorBayar());
        this.setIdJenisBank(dto.getIdJenisBank());
        this.setNamaCabangBank(dto.getNamaCabangBank());
        this.setNamaBank(dto.getNamaBank());
        this.setNomorRekening(dto.getNomorRekening());
        this.setIdAgama(dto.getIdAgama());
        this.setNamaAgama(dto.getNamaAgama());
        this.setTglWafatPeserta(dto.getTglWafatPeserta());
        this.setTglWafatPenerima(dto.getTglWafatPenerima());
        this.setTglHentiBayar(dto.getTglHentiBayar());
        this.setJenisReport(dto.getJenisReport());
        this.setRequestBy(dto.getRequestBy());
        this.setPeriodeBayarMp(dto.getPeriodeBayarMp());
        this.setUserStamp(dto.getUserStamp());
        this.setNamaRekening(dto.getNamaRekening());
    }

    @Override
    public PengolahanDataBerkalaDto toDto() {
        PengolahanDataBerkalaDto dto = new PengolahanDataBerkalaDto();

        dto.setPeriode(this.getPeriode());
        dto.setNip(this.getNip());
        dto.setNamaPeserta(this.getNamaPeserta());
        dto.setNamaPenerimaMp(this.getNamaPenerimaMp());
        dto.setIdPenerimaMp(this.getIdPenerimaMp());
        dto.setTglLahir(this.getTglLahir());
        dto.setTglHentiKerja(this.getTglHentiKerja());
        dto.setIdGolongan(this.getIdGolongan());
        dto.setPangkatJabatan(this.getPangkatJabatan());
        dto.setMpBulanan(this.getMpBulanan());
        dto.setIdKantorBayar(this.getIdKantorBayar());
        dto.setNamaKantorBayar(this.getNamaKantorBayar());
        dto.setIdJenisBank(this.getIdJenisBank());
        dto.setNamaCabangBank(this.getNamaCabangBank());
        dto.setNamaBank(this.getNamaBank());
        dto.setNomorRekening(this.getNomorRekening());
        dto.setIdAgama(this.getIdAgama());
        dto.setNamaAgama(this.getNamaAgama());
        dto.setTglWafatPeserta(this.getTglWafatPeserta());
        dto.setTglWafatPenerima(this.getTglWafatPenerima());
        dto.setTglHentiBayar(this.getTglHentiBayar());
        dto.setJenisReport(this.getJenisReport());
        dto.setRequestBy(this.getRequestBy());
        dto.setPeriodeBayarMp(this.getPeriodeBayarMp());
        dto.setUserStamp(this.getUserStamp());
        dto.setNamaRekening(this.getNamaRekening());

        return dto;
    }
}
