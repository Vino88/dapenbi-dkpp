package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dto.AktuariaFsDto;
import com.dapenbi.dkpp.model.CompositeId.AktuariaFsPK;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="TBL_R_AKTUARIA_FS")
@IdClass(AktuariaFsPK.class)
public class AktuariaFs extends BaseModel<AktuariaFsDto>{

    @Id
    @Column(name="USIA_FS", length = 5)
    private String usiaFs;

    @Column(name="FS_PRIAANAK")
    private Double fsPriaanak;

    @Column(name="FS_PRIAKAWIN")
    private Double fsPriakawin;

    @Column(name="FS_PRIALAJANG")
    private Double fsPrialajang;

    @Column(name="FS_WANITAANAK")
    private Double fsWanitaanak;

    @Column(name="FS_WANITAKAWIN")
    private Double fsWanitakawin;

    @Column(name="FS_WANITALAJANG")
    private Double fsWanitalajang;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ID_FAKTOR_FS", referencedColumnName="ID_FAKTOR_FS")
    private FaktorFs faktorFs;

    public AktuariaFs() {
        super();
    }

    public String getUsiaFs() {
        return usiaFs;
    }

    public void setUsiaFs(String usiaFs) {
        this.usiaFs = usiaFs;
    }

    public Double getFsPriaanak() {
        return fsPriaanak;
    }

    public void setFsPriaanak(Double fsPriaanak) {
        this.fsPriaanak = fsPriaanak;
    }

    public Double getFsPriakawin() {
        return fsPriakawin;
    }

    public void setFsPriakawin(Double fsPriakawin) {
        this.fsPriakawin = fsPriakawin;
    }

    public Double getFsPrialajang() {
        return fsPrialajang;
    }

    public void setFsPrialajang(Double fsPrialajang) {
        this.fsPrialajang = fsPrialajang;
    }

    public Double getFsWanitaanak() {
        return fsWanitaanak;
    }

    public void setFsWanitaanak(Double fsWanitaanak) {
        this.fsWanitaanak = fsWanitaanak;
    }

    public Double getFsWanitakawin() {
        return fsWanitakawin;
    }

    public void setFsWanitakawin(Double fsWanitakawin) {
        this.fsWanitakawin = fsWanitakawin;
    }

    public Double getFsWanitalajang() {
        return fsWanitalajang;
    }

    public void setFsWanitalajang(Double fsWanitalajang) {
        this.fsWanitalajang = fsWanitalajang;
    }

    public FaktorFs getFaktorFs() {
        return faktorFs;
    }

    public void setFaktorFs(FaktorFs faktorFs) {
        this.faktorFs = faktorFs;
    }

    public void fromDto(AktuariaFsDto dto) {
        this.setUsiaFs( dto.getUsiaFs() );
        this.setFsPrialajang( dto.getFsPrialajang() );
        this.setFsPriakawin( dto.getFsPriakawin() );
        this.setFsWanitalajang( dto.getFsWanitalajang() );
        this.setFsWanitakawin( dto.getFsWanitakawin() );
        this.setFsPriaanak( dto.getFsPriaanak() );
        this.setFsWanitaanak( dto.getFsWanitaanak() );
        this.setUserStamp(dto.getUserStamp());
    }

    public AktuariaFsDto toDto() {
        AktuariaFsDto dto = new AktuariaFsDto();
        dto.setActive(this.isActive());
        dto.setUsiaFs( this.getUsiaFs() );

        dto.setFsPrialajang( this.getFsPrialajang() );
        dto.setFsPriakawin( this.getFsPriakawin() );
        dto.setFsWanitalajang( this.getFsWanitalajang() );
        dto.setFsWanitakawin( this.getFsWanitakawin() );
        dto.setFsPriaanak( this.getFsPriaanak() );
        dto.setFsWanitaanak( this.getFsWanitaanak() );

        dto.setUserStamp(this.getUserStamp());
        return dto;
    }

    @Override
    public String toString(){
        String str = "";
        str += "\nPria Lajang = " + this.getFsPrialajang();
        str += "\nPria Kawin = " + this.getFsPriakawin();
        return str;
    }
}
