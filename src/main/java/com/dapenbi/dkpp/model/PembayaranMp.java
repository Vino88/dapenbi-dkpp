package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dto.PembayaranMpDto;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TBL_T_PEMBAYARAN_HEADER")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "PembayaranMp.processCuspPembayaran",
                procedureName = "CUSP_PEMBAYARAN",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_PERIODE_PEMBAYARAN"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "PAR_TGL_DIPROSES"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_DIPROSES_OLEH"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_COMP_NAME"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_USER_NAME"),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, type = Long.class, name = "PAR_ID_PEMBAYARAN"),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, type = Character.class, name = "PAR_STATUS_EKSEKUSI"),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name = "PAR_MSG")
                }
        ),
        @NamedStoredProcedureQuery(
                name="PembayaranMp.processCuspPembayaranSentToPtr",
                procedureName="CUSP_PEMBAYARAN_SENT_TO_PTR",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_COMP_NAME"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_USER_NAME"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_PERIODE"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name= "PAR_TGL_DIPROSES"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name= "PAR_ID_PEMBAYARAN"),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, type = Character.class, name= "PAR_STATUS_EKSEKUSI"),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name= "PAR_MSG")
                }
        )
})
public class PembayaranMp extends BaseModel<PembayaranMpDto>{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_PEMBAYARAN_SEQ")
    @SequenceGenerator(sequenceName = "pembayaranId_seq", allocationSize = 1, name = "ID_PEMBAYARAN_SEQ")
    @Column(name = "ID_PEMBAYARAN", length = 20)
    private Long id;

    @Column(name = "PERIODE_PEMBAYARAN", length = 6)
    private String periodePembayaran;
    @Column(name = "TGL_DIPROSES", length = 7)
    private Date tglDiproses;
    @Column(name = "DIPROSES_OLEH", length = 100)
    private String diprosesOleh;
    @Column(name = "IS_STATUS_BERHASIL", length = 1)
    private Character isStatusBerhasil;
    @Column(name = "KETERANGAN", length = 500)
    private String keterangan;
    @Column(name = "NAMA_STATUS_BERHASIL", length = 10)
    private String namaStatusBerhasil;
    @Column(name = "IS_SENT_TO_PTR", length = 1)
    private Character isSendToPtr;


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

    public Date getTglDiproses() {
        return tglDiproses;
    }

    public void setTglDiproses(Date tglDiproses) {
        this.tglDiproses = tglDiproses;
    }

    public String getDiprosesOleh() {
        return diprosesOleh;
    }

    public void setDiprosesOleh(String diprosesOleh) {
        this.diprosesOleh = diprosesOleh;
    }

    public Character getIsStatusBerhasil() {
        return isStatusBerhasil;
    }

    public void setIsStatusBerhasil(Character isStatusBerhasil) {
        this.isStatusBerhasil = isStatusBerhasil;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Character getIsSendToPtr() {
        return isSendToPtr;
    }

    public void setIsSendToPtr(Character isSendToPtr) {
        this.isSendToPtr = isSendToPtr;
    }

    public String getNamaStatusBerhasil() {
        return namaStatusBerhasil;
    }

    public void setNamaStatusBerhasil(String namaStatusBerhasil) {
        this.namaStatusBerhasil = namaStatusBerhasil;
    }

    @Override
    public void fromDto(PembayaranMpDto dto) {
        this.setId(dto.getId());
        this.setPeriodePembayaran(dto.getPeriodePembayaran());
        this.setTglDiproses(dto.getTglDiproses());
        this.setDiprosesOleh(dto.getDiprosesOleh());
        this.setIsStatusBerhasil(dto.getIsStatusBerhasil());
        this.setKeterangan(dto.getKeterangan());
        this.setNamaStatusBerhasil(dto.getNamaStatusBerhasil());
        this.setIsSendToPtr(dto.getIsSendToPtr());
        this.setUserStamp(dto.getUserStamp());
        this.setActive(dto.getActive());

    }

    @Override
    public PembayaranMpDto toDto() {
        PembayaranMpDto dto = new PembayaranMpDto();
        dto.setId(this.getId());
        dto.setPeriodePembayaran(this.getPeriodePembayaran());
        dto.setTglDiproses(this.getTglDiproses());
        dto.setDiprosesOleh(this.getDiprosesOleh());
        dto.setIsStatusBerhasil(this.getIsStatusBerhasil());
        dto.setKeterangan(this.getKeterangan());
        dto.setNamaStatusBerhasil(this.getNamaStatusBerhasil());
        dto.setIsSendToPtr(this.isSendToPtr);
        dto.setUserStamp(this.getUserStamp());
        dto.setActive(this.isActive);

        return dto;
    }
}
