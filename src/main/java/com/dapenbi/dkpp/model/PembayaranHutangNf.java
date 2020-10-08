package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dto.BaseDto;
import com.dapenbi.dkpp.dto.PembayaranHutangNfDto;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TBL_T_PEMBAYARAN_HUTANG_NF")
@NamedStoredProcedureQueries(
        {
                @NamedStoredProcedureQuery(
                        name = "PembayaranHutangNf.cuspPembayaranHutangNf",
                        procedureName = "CUSP_PEMBAYARAN_HUTANG_NF",
                        parameters = {
                                @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ROLE_ID"),
                                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_COMP_NAME"),
                                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_USER_NAME"),
                                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_PERIODE_BAYAR"),
                                @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_BAYAR_NF"),
                                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NIP"),
                                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_PESERTA"),
                                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_ID_PENERIMA_MP"),
                                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_PENERIMA_MP"),
                                @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_NOMINAL_PEMBAYARAN"),
                                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_KETERANGAN"),
                                @StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name = "PAR_STATUS_EKSEKUSI"),
                                @StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name = "PAR_MSG"),
                        }
                ),
                @NamedStoredProcedureQuery(
                        name = "PembayaranHutangNf.cuspPembayaranHutangNfPtr",
                        procedureName = "CUSP_PMBY_HUTANG_NF_PTR",
                        parameters = {
                                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_COMP_NAME"),
                                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_USER_NAME"),
                                @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_BAYAR_HUTANG_NF"),
                                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_MUTASI_BAYAR"),
                                @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_NOMINAL"),
                                @StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name = "PAR_STATUS_EKSEKUSI"),
                                @StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name = "PAR_MSG"),
                        }
                )

        }
)
public class PembayaranHutangNf extends BaseModel<PembayaranHutangNfDto> {
    @Id
    @Column(name = "ID_BAYAR_HUT_NF", length = 22)
    private Long idBayarHutNf;
    @Column(name = "PERIODE_BAYAR", length = 6)
    private String periodeBayar;
    @Column(name = "TGL_BAYAR", length = 7)
    private Date tglBayar;
    @Column(name = "NIP", length = 20)
    private String nip;
    @Column(name = "NAMA_PESERTA", length = 100)
    private String namaPeserta;
    @Column(name = "ID_PENERIMA_MP", length = 20)
    private String idPenerimaMp;
    @Column(name = "NAMA_PENERIMA_MP", length = 100)
    private String namaPenerimaMp;
    @Column(name = "NOMINAL_PEMBAYARAN", length = 22)
    private Long nominalPembayaran;
    @Column(name = "SUDAH_DI_KIRIM_PTR", length = 1)
    private Character sudahDiKirimPtr;
    @Column(name = "ID_KATEGORI_CATATAN", length = 22)
    private Long idKategoriCatatan;
    @Column(name = "KETERANGAN", length = 500)
    private String keterangan;
    @Column(name = "USER_STAMP", length = 100)
    private String userStamp;
    @Column(name = "IS_SENT_TO_PTR", length = 1)
    private Character isSentToPtr;
    @Column(name = "ID_SENT_TO_PTR", length = 22)
    private Long idSentToPtr;

    public Long getIdBayarHutNf() {
        return idBayarHutNf;
    }

    public void setIdBayarHutNf(Long idBayarHutNf) {
        this.idBayarHutNf = idBayarHutNf;
    }

    public String getPeriodeBayar() {
        return periodeBayar;
    }

    public void setPeriodeBayar(String periodeBayar) {
        this.periodeBayar = periodeBayar;
    }

    public Date getTglBayar() {
        return tglBayar;
    }

    public void setTglBayar(Date tglBayar) {
        this.tglBayar = tglBayar;
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

    public Long getNominalPembayaran() {
        return nominalPembayaran;
    }

    public void setNominalPembayaran(Long nominalPembayaran) {
        this.nominalPembayaran = nominalPembayaran;
    }

    public Character getSudahDiKirimPtr() {
        return sudahDiKirimPtr;
    }

    public void setSudahDiKirimPtr(Character sudahDiKirimPtr) {
        this.sudahDiKirimPtr = sudahDiKirimPtr;
    }

    public Long getIdKategoriCatatan() {
        return idKategoriCatatan;
    }

    public void setIdKategoriCatatan(Long idKategoriCatatan) {
        this.idKategoriCatatan = idKategoriCatatan;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getUserStamp() {
        return userStamp;
    }

    public void setUserStamp(String userStamp) {
        this.userStamp = userStamp;
    }

    public Character getIsSentToPtr() {
        return isSentToPtr;
    }

    public void setIsSentToPtr(Character isSentToPtr) {
        this.isSentToPtr = isSentToPtr;
    }

    public Long getIdSentToPtr() {
        return idSentToPtr;
    }

    public void setIdSentToPtr(Long idSentToPtr) {
        this.idSentToPtr = idSentToPtr;
    }

    @Override
    public void fromDto(PembayaranHutangNfDto dto) {
        this.setIdBayarHutNf(dto.getIdBayarHutNf());
        this.setPeriodeBayar(dto.getPeriodeBayar());
        this.setNip(dto.getNip());
        this.setNamaPeserta(dto.getNamaPeserta());
        this.setNamaPenerimaMp(dto.getNamaPenerimaMp());
        this.setIdPenerimaMp(dto.getIdPenerimaMp());
        this.setTglBayar(dto.getTglBayar());
        this.setIdKategoriCatatan(dto.getIdKategoriCatatan());
        this.setNominalPembayaran(dto.getNominalPembayaran());
        this.setKeterangan(dto.getKeterangan());
        this.setIdSentToPtr(dto.getIdSentToPtr());
        this.setIsSentToPtr(dto.getIsSentToPtr());
        this.setSudahDiKirimPtr(dto.getSudahDiKirimPtr());
        this.setUserStamp(dto.getUserStamp());

    }

    @Override
    public PembayaranHutangNfDto toDto() {

        PembayaranHutangNfDto dto = new PembayaranHutangNfDto();

        dto.setIdBayarHutNf(this.getIdBayarHutNf());
        dto.setPeriodeBayar(this.getPeriodeBayar());
        dto.setNip(this.getNip());
        dto.setNamaPeserta(this.getNamaPeserta());
        dto.setNamaPenerimaMp(this.getNamaPenerimaMp());
        dto.setIdPenerimaMp(this.getIdPenerimaMp());
        dto.setTglBayar(this.getTglBayar());
        dto.setIdKategoriCatatan(this.getIdKategoriCatatan());
        dto.setNominalPembayaran(this.getNominalPembayaran());
        dto.setKeterangan(this.getKeterangan());
        dto.setIdSentToPtr(this.getIdSentToPtr());
        dto.setIsSentToPtr(this.getIsSentToPtr());
        dto.setSudahDiKirimPtr(this.getSudahDiKirimPtr());
        dto.setUserStamp(this.getUserStamp());

        return dto;
    }
}
