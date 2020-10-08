package com.dapenbi.dkpp.model;
import com.dapenbi.dkpp.dto.PengolahanDataBerkalaDto;
import com.dapenbi.dkpp.dto.PengolahanDataBerkalaOjkDto;

import javax.persistence.*;

@Entity
@Table(name = "TBL_T_REPORT_DATA_BERKALA_OJK")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "PengolahanDataBerkalaOJK.cuspReportDataBerkalaOjk",
                procedureName = "CUSP_REPORT_DATA_BERKALA_OJK",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_COMP_NAME"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_USER_NAME"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_PERIODE"),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, type = Character.class, name = "PAR_STATUS_EKSEKUSI"),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name = "PAR_MSG"),
                }
        )

})
public class PengolahanDataBerkalaOJK extends BaseModel<PengolahanDataBerkalaOjkDto>{
    @Id
    @Column(name = "PERIODE", length = 6)
    private String periode;
    @Column(name = "PENERIMA_NORMAL", length = 22)
    private Long penerimaNormal;
    @Column(name = "PENERIMA_NORMAL_MPYD", length = 22)
    private Long penerimaNormalMpyd;
    @Column(name = "PENERIMA_DIPERCEPAT", length = 22)
    private Long penerimaDipercepat;
    @Column(name = "PENERIMA_DIPERCEPAT_MPYD", length = 22)
    private Long penerimaDipercepatMpyd;
    @Column(name = "PENERIMA_CACAT", length = 22)
    private Long penerimaCacat;
    @Column(name = "PENERIMA_CACAT_MPYD", length = 22)
    private Long penerimaCacatMpyd;
    @Column(name = "PENERIMA_JD", length = 22)
    private Long penerimaJd;
    @Column(name = "PENERIMA_JD_MPYD", length = 22)
    private Long penerimaJdMpyd;
    @Column(name = "PENERIMA_ANAK", length = 22)
    private Long penerimaAnak;
    @Column(name = "PENERIMA_ANAK_MPYD", length = 22)
    private Long penerimaAnakMpyd;
    @Column(name = "PENSIUN_TUNDA", length = 22)
    private Long pensiunTunda;
    @Column(name = "PENSIUN_TUNDA_MPYD", length = 22)
    private Long pensiunTundaMpyd;
    @Column(name = "USER_STAMP", length = 100)
    private String userStamp;

    public String getPeriode() {
        return periode;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
    }

    public Long getPenerimaNormal() {
        return penerimaNormal;
    }

    public void setPenerimaNormal(Long penerimaNormal) {
        this.penerimaNormal = penerimaNormal;
    }

    public Long getPenerimaNormalMpyd() {
        return penerimaNormalMpyd;
    }

    public void setPenerimaNormalMpyd(Long penerimaNormalMpyd) {
        this.penerimaNormalMpyd = penerimaNormalMpyd;
    }

    public Long getPenerimaDipercepat() {
        return penerimaDipercepat;
    }

    public void setPenerimaDipercepat(Long penerimaDipercepat) {
        this.penerimaDipercepat = penerimaDipercepat;
    }

    public Long getPenerimaDipercepatMpyd() {
        return penerimaDipercepatMpyd;
    }

    public void setPenerimaDipercepatMpyd(Long penerimaDipercepatMpyd) {
        this.penerimaDipercepatMpyd = penerimaDipercepatMpyd;
    }

    public Long getPenerimaCacat() {
        return penerimaCacat;
    }

    public void setPenerimaCacat(Long penerimaCacat) {
        this.penerimaCacat = penerimaCacat;
    }

    public Long getPenerimaCacatMpyd() {
        return penerimaCacatMpyd;
    }

    public void setPenerimaCacatMpyd(Long penerimaCacatMpyd) {
        this.penerimaCacatMpyd = penerimaCacatMpyd;
    }

    public Long getPenerimaJd() {
        return penerimaJd;
    }

    public void setPenerimaJd(Long penerimaJd) {
        this.penerimaJd = penerimaJd;
    }

    public Long getPenerimaJdMpyd() {
        return penerimaJdMpyd;
    }

    public void setPenerimaJdMpyd(Long penerimaJdMpyd) {
        this.penerimaJdMpyd = penerimaJdMpyd;
    }

    public Long getPenerimaAnak() {
        return penerimaAnak;
    }

    public void setPenerimaAnak(Long penerimaAnak) {
        this.penerimaAnak = penerimaAnak;
    }

    public Long getPenerimaAnakMpyd() {
        return penerimaAnakMpyd;
    }

    public void setPenerimaAnakMpyd(Long penerimaAnakMpyd) {
        this.penerimaAnakMpyd = penerimaAnakMpyd;
    }

    public Long getPensiunTunda() {
        return pensiunTunda;
    }

    public void setPensiunTunda(Long pensiunTunda) {
        this.pensiunTunda = pensiunTunda;
    }

    public Long getPensiunTundaMpyd() {
        return pensiunTundaMpyd;
    }

    public void setPensiunTundaMpyd(Long pensiunTundaMpyd) {
        this.pensiunTundaMpyd = pensiunTundaMpyd;
    }

    @Override
    public String getUserStamp() {
        return userStamp;
    }

    @Override
    public void setUserStamp(String userStamp) {
        this.userStamp = userStamp;
    }

    @Override
    public void fromDto(PengolahanDataBerkalaOjkDto dto){
       this.setPeriode(dto.getPeriode());
       this.setPenerimaNormal(dto.getPenerimaNormal());
       this.setPenerimaDipercepat(dto.getPenerimaDipercepat());
       this.setPenerimaCacat(dto.getPenerimaCacat());
       this.setPenerimaJd(dto.getPenerimaJd());
       this.setPenerimaAnak(dto.getPenerimaAnak());
       this.setPensiunTunda(dto.getPensiunTunda());
       this.setPenerimaNormalMpyd(dto.getPenerimaNormalMpyd());
       this.setPenerimaDipercepatMpyd(dto.getPenerimaDipercepatMpyd());
       this.setPenerimaCacatMpyd(dto.getPenerimaCacatMpyd());
       this.setPensiunTundaMpyd(dto.getPensiunTundaMpyd());
       this.setPenerimaJdMpyd(dto.getPenerimaJdMpyd());
       this.setPenerimaAnakMpyd(dto.getPenerimaAnakMpyd());
       this.setUserStamp(dto.getUserStamp());
    }

    @Override
    public PengolahanDataBerkalaOjkDto toDto() {
        PengolahanDataBerkalaOjkDto dto = new PengolahanDataBerkalaOjkDto();

        dto.setPeriode(this.getPeriode());
        dto.setPenerimaNormal(this.getPenerimaNormal());
        dto.setPenerimaDipercepat(this.getPenerimaDipercepat());
        dto.setPenerimaCacat(this.getPenerimaCacat());
        dto.setPensiunTunda(this.getPensiunTunda());
        dto.setPenerimaJd(this.getPenerimaJd());
        dto.setPenerimaAnak(this.getPenerimaAnak());
        dto.setPenerimaNormalMpyd(this.getPenerimaNormalMpyd());
        dto.setPenerimaDipercepatMpyd(this.getPenerimaDipercepatMpyd());
        dto.setPenerimaCacatMpyd(this.getPenerimaCacatMpyd());
        dto.setPensiunTundaMpyd(this.getPensiunTundaMpyd());
        dto.setPenerimaJdMpyd(this.getPenerimaJdMpyd());
        dto.setPenerimaAnakMpyd(this.getPenerimaAnakMpyd());
        dto.setUserStamp(this.getUserStamp());
        return dto;
    }
}
