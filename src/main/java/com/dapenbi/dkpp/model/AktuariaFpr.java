package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dto.AktuariaFprDto;
import com.dapenbi.dkpp.model.CompositeId.AktuariaFprPK;

import javax.persistence.*;

@Entity
@Table(name = "TBL_R_AKTUARIA_FPR")
@IdClass(AktuariaFprPK.class)
public class AktuariaFpr extends BaseModel<AktuariaFprDto> {

    @Id
    @Column(name = "usia_fpr", length = 5)
    private String usia;

    @Column(name = "nilai_fpr")
    private Double nilaifpr;

    public AktuariaFpr(){
        this.faktorFPR = new FaktorFPR();
    }

    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_faktor_fpr", nullable = false)
    private FaktorFPR faktorFPR;

    public String getUsia() {
        return usia;
    }

    public void setUsia(String usia) {
        this.usia = usia;
    }

    public Double getNilaifpr() {
        return nilaifpr;
    }

    public void setNilaifpr(Double nilaifpr) {
        this.nilaifpr = nilaifpr;
    }

    public FaktorFPR getFaktorFPR() {
        return faktorFPR;
    }

    public void setFaktorFPR(FaktorFPR faktorFPR) {
        this.faktorFPR = faktorFPR;
    }

    @Override
    public void fromDto(AktuariaFprDto dto) {
        this.setNilaifpr(dto.getNilaifpr());
        this.setUsia(dto.getUsia());
        this.setActive(dto.isActive());
        this.setUserStamp(dto.getUserStamp());


    }

    @Override
    public AktuariaFprDto toDto() {
        AktuariaFprDto dto = new AktuariaFprDto();
        dto.setUsia(this.getUsia());
        dto.setNilaifpr(this.getNilaifpr());
        dto.setActive(this.isActive());
        dto.setUserStamp(this.getUserStamp());

        return dto;
    }
}
