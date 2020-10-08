package com.dapenbi.dkpp.model;


import com.dapenbi.dkpp.dto.HerRegistrasiMpNFHeaderDto;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TBL_T_HER_REGISTRASI_H_NF")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "HerRegistrasiMpNFHeader.CuspHerRegistrasiNFProses",
                procedureName = "CUSP_HER_REGISTRASI_NF_PROSES",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_COMP_NAME"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_USER_NAME"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_TAHUN_HER"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_STATUS_HER"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Character.class, name = "PAR_ACTION"),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name = "PAR_STATUS_EKSEKUSI"),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name = "PAR_MSG"),
                }
        ),
        @NamedStoredProcedureQuery(
                name = "HerRegistrasiMpNFHeader.CuspHerRegistrasiNFUpdate",
                procedureName = "CUSP_HER_REGISTRASI_NF_UPDATE",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_COMP_NAME"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_USER_NAME"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NIP"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "PAR_TGL_HER_REGIS"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_IS_SUDAH_HER"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_SUDAH_HER_DESC"),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name = "PAR_STATUS_EKSEKUSI"),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name = "PAR_MSG"),
                }
        ),
})
public class HerRegistrasiMpNFHeader extends BaseModel<HerRegistrasiMpNFHeaderDto>{
    @Id
    @Column(name = "TAHUN_HER", length = 4)
    private String tahunHer;
    @Column(name = "STATUS_HER", length = 20)
    private String statusHer;
    @Column(name = "TOTAL_HER", length = 22)
    private Long totalHer;
    @Column(name = "USER_STAMP", length = 100)
    private String userStamp;

    @OneToMany
    @JoinColumn(name = "TAHUN_HER")
    private List<HerRegistrasiMpNFDetail> herRegistrasiMpNFDetails;

    public List<HerRegistrasiMpNFDetail> getHerRegistrasiMpNFDetails() {
        return herRegistrasiMpNFDetails;
    }

    public void setHerRegistrasiMpNFDetails(List<HerRegistrasiMpNFDetail> herRegistrasiMpNFDetails) {
        this.herRegistrasiMpNFDetails = herRegistrasiMpNFDetails;
    }

    public String getTahunHer() {
        return tahunHer;
    }

    public void setTahunHer(String tahunHer) {
        this.tahunHer = tahunHer;
    }

    public String getStatusHer() {
        return statusHer;
    }

    public void setStatusHer(String statusHer) {
        this.statusHer = statusHer;
    }

    public Long getTotalHer() {
        return totalHer;
    }

    public void setTotalHer(Long totalHer) {
        this.totalHer = totalHer;
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
    public void fromDto(HerRegistrasiMpNFHeaderDto dto) {
        this.setTahunHer(dto.getTahunHer());
        this.setStatusHer(dto.getStatusHer());
        this.setTotalHer(dto.getTotalHer());
        this.setUserStamp(dto.getUserStamp());
    }

    @Override
    public HerRegistrasiMpNFHeaderDto toDto() {

        HerRegistrasiMpNFHeaderDto dto = new HerRegistrasiMpNFHeaderDto();
        dto.setTahunHer(this.getTahunHer());
        dto.setStatusHer(this.getStatusHer());
        dto.setTotalHer(this.getTotalHer());
        dto.setUserStamp(this.getUserStamp());

        return dto;
    }
}
