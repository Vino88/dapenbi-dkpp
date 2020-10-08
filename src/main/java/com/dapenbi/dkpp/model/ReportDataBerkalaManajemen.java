package com.dapenbi.dkpp.model;
import com.dapenbi.dkpp.dto.ReportDataBerkalaManajemenDto;

import javax.persistence.*;

@Entity
@Table(name = "TBL_T_REPORT_DATA_BERKALA_MJN")
            @NamedStoredProcedureQueries({
                    @NamedStoredProcedureQuery(
                            name = "ReportDataBerkalaManajemen.cuspReportManajemen",
                            procedureName = "CUSP_REPORT_MANAJEMEN",

                            parameters = {
                                    @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_COMP_NAME"),
                                    @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_USER_NAME"),
                                    @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_PERIODE_MUTASI"),
                                    @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_KANTOR_BAYAR"),
                                    @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_NOMINAL"),
                                    @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_JENIS_REPORT"),
                                    @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_KRITERIA"),
                                    @StoredProcedureParameter(mode = ParameterMode.OUT, type = Character.class, name = "PAR_STATUS_EKSEKUSI"),
                                    @StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name = "PAR_MSG"),
                            }
                    )

            })

public class ReportDataBerkalaManajemen extends BaseModel<ReportDataBerkalaManajemenDto> {
    @Id
    @Column(name = "NIP", length = 20)
    private String nip;
    @Column(name = "NAMA_PESERTA", length = 50)
    private String namaPeserta;
    @Column(name = "JENIS_KELAMIN_PESERTA", length = 1)
    private Character jenisKelaminPeserta;
    @Column(name = "GOLONGAN_PANGKAT", length = 50)
    private String golonganPangkat;
    @Column(name = "ID_KANTOR_BAYAR", length = 10)
    private String idKantorBayar;
    @Column(name = "NAMA_KANTOR_BAYAR", length = 50)
    private String namaKantorBayar;
    @Column(name = "NAMA_KATEGORI_PENSIUN", length = 50)
    private String namaKategoriPensiun;
    @Column(name = "NAMA_MPS", length = 50)
    private String namaMps;
    @Column(name = "MP_PERBULAN_RUMUS", length = 22)
    private Long mpPerbulanRumus;
    @Column(name = "MP_BULAN13", length = 22, columnDefinition = "0")
    private Long mpBulan13;
    @Column(name = "USER_STAMP", length = 100)
    private String userStamp;
    @Column(name = "PERIODE_MUTASI", length = 6)
    private String periodeMutasi;
    @Column(name = "IS_ACTIVE", length = 22)
    private Long isActive;
    @Column(name = "NAMA_PENERIMA_MP", length = 50)
    private String namaPenerimaMp;
    @Column(name = "JENIS_REPORT", length = 20)
    private String jenisReport;
    @Column(name = "KANTOR_BAYAR", length = 50)
    private String kantorBayar;
    @Column(name = "KRITERIA", length = 22)
    private Long kriteria;

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

    public Character getJenisKelaminPeserta() {
        return jenisKelaminPeserta;
    }

    public void setJenisKelaminPeserta(Character jenisKelaminPeserta) {
        this.jenisKelaminPeserta = jenisKelaminPeserta;
    }

    public String getGolonganPangkat() {
        return golonganPangkat;
    }

    public void setGolonganPangkat(String golonganPangkat) {
        this.golonganPangkat = golonganPangkat;
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

    public String getNamaKategoriPensiun() {
        return namaKategoriPensiun;
    }

    public void setNamaKategoriPensiun(String namaKategoriPensiun) {
        this.namaKategoriPensiun = namaKategoriPensiun;
    }

    public String getNamaMps() {
        return namaMps;
    }

    public void setNamaMps(String namaMps) {
        this.namaMps = namaMps;
    }

    public Long getMpPerbulanRumus() {
        return mpPerbulanRumus;
    }

    public void setMpPerbulanRumus(Long mpPerbulanRumus) {
        this.mpPerbulanRumus = mpPerbulanRumus;
    }

    public Long getMpBulan13() {
        return mpBulan13;
    }

    public void setMpBulan13(Long mpBulan13) {
        this.mpBulan13 = mpBulan13;
    }

    public String getUserStamp() {
        return userStamp;
    }

    public void setUserStamp(String userStamp) {
        this.userStamp = userStamp;
    }

    public String getPeriodeMutasi() {
        return periodeMutasi;
    }

    public void setPeriodeMutasi(String periodeMutasi) {
        this.periodeMutasi = periodeMutasi;
    }

    public Long getIsActive() {
        return isActive;
    }

    public void setIsActive(Long isActive) {
        this.isActive = isActive;
    }

    public String getNamaPenerimaMp() {
        return namaPenerimaMp;
    }

    public void setNamaPenerimaMp(String namaPenerimaMp) {
        this.namaPenerimaMp = namaPenerimaMp;
    }

    public String getJenisReport() {
        return jenisReport;
    }

    public void setJenisReport(String jenisReport) {
        this.jenisReport = jenisReport;
    }

    public String getKantorBayar() {
        return kantorBayar;
    }

    public void setKantorBayar(String kantorBayar) {
        this.kantorBayar = kantorBayar;
    }

    public Long getKriteria() {
        return kriteria;
    }

    public void setKriteria(Long kriteria) {
        this.kriteria = kriteria;
    }

    @Override
    public void fromDto(ReportDataBerkalaManajemenDto dto) {
        this.setNip(dto.getNip());
        this.setNamaPeserta(dto.getNamaPeserta());
        this.setNamaPenerimaMp(dto.getNamaPenerimaMp());
        this.setJenisKelaminPeserta(dto.getJenisKelaminPeserta());
        this.setGolonganPangkat(dto.getGolonganPangkat());
        this.setIdKantorBayar(dto.getIdKantorBayar());
        this.setNamaKantorBayar(dto.getNamaKantorBayar());
        this.setNamaKategoriPensiun(dto.getNamaKategoriPensiun());
        this.setNamaMps(dto.getNamaMps());
        this.setMpPerbulanRumus(dto.getMpPerbulanRumus());
        this.setMpBulan13(dto.getMpBulan13());
        this.setUserStamp(dto.getUserStamp());
        this.setPeriodeMutasi(dto.getPeriodeMutasi());
        this.setKantorBayar(dto.getKantorBayar());
        this.setJenisReport(dto.getJenisReport());
        this.setKriteria(dto.getKriteria());
    }

    @Override
    public ReportDataBerkalaManajemenDto toDto() {
        ReportDataBerkalaManajemenDto dto = new ReportDataBerkalaManajemenDto();

        dto.setNip(this.getNip());
        dto.setNamaPeserta(this.getNamaPeserta());
        dto.setNamaPenerimaMp(this.getNamaPenerimaMp());
        dto.setJenisKelaminPeserta(this.getJenisKelaminPeserta());
        dto.setGolonganPangkat(this.getGolonganPangkat());
        dto.setIdKantorBayar(this.getIdKantorBayar());
        dto.setNamaKantorBayar(this.getNamaKantorBayar());
        dto.setNamaKategoriPensiun(this.getNamaKategoriPensiun());
        dto.setNamaMps(this.getNamaMps());
        dto.setMpPerbulanRumus(this.getMpPerbulanRumus());
        dto.setMpBulan13(this.getMpBulan13());
        dto.setUserStamp(this.getUserStamp());
        dto.setPeriodeMutasi(this.getPeriodeMutasi());
        dto.setKantorBayar(this.getKantorBayar());
        dto.setJenisReport(this.getJenisReport());
        dto.setKriteria(this.getKriteria());
        return dto;
    }
}