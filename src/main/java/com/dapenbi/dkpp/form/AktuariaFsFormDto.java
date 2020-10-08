package com.dapenbi.dkpp.form;

import com.dapenbi.dkpp.model.CompositeId.AktuariaFsPK;
import com.dapenbi.dkpp.model.FaktorFs;

import java.util.Date;
import java.util.Map;

public class AktuariaFsFormDto {

    private AktuariaFsPK id;

    private String usiaFs;

    private Long fsPriaanak;

    private Long fsPriakawin;

    private Long fsPrialajang;

    private Long fsWanitaanak;

    private Long fsWanitakawin;

    private Long fsWanitalajang;

    private Long idFaktorFs;

    private String namaFaktorFs;

    private Map active;


    public AktuariaFsFormDto() {
    }

    public AktuariaFsPK getId() {
        return new AktuariaFsPK(this.usiaFs, new FaktorFs(this.idFaktorFs));
    }

    public void setId(AktuariaFsPK id) {
        this.id = id;
    }

    public String getUsiaFs() {
        return usiaFs;
    }

    public void setUsiaFs(String usiaFs) {
        this.usiaFs = usiaFs;
    }

    public Long getFsPriaanak() {
        return fsPriaanak;
    }

    public void setFsPriaanak(Long fsPriaanak) {
        this.fsPriaanak = fsPriaanak;
    }

    public Long getFsPriakawin() {
        return fsPriakawin;
    }

    public void setFsPriakawin(Long fsPriakawin) {
        this.fsPriakawin = fsPriakawin;
    }

    public Long getFsPrialajang() {
        return fsPrialajang;
    }

    public void setFsPrialajang(Long fsPrialajang) {
        this.fsPrialajang = fsPrialajang;
    }

    public Long getFsWanitaanak() {
        return fsWanitaanak;
    }

    public void setFsWanitaanak(Long fsWanitaanak) {
        this.fsWanitaanak = fsWanitaanak;
    }

    public Long getFsWanitakawin() {
        return fsWanitakawin;
    }

    public void setFsWanitakawin(Long fsWanitakawin) {
        this.fsWanitakawin = fsWanitakawin;
    }

    public Long getFsWanitalajang() {
        return fsWanitalajang;
    }

    public void setFsWanitalajang(Long fsWanitalajang) {
        this.fsWanitalajang = fsWanitalajang;
    }

    public Map getActive() {
        return active;
    }

    public void setActive(Map active) {
        this.active = active;
    }

    public Long getIdFaktorFs() {
        return idFaktorFs;
    }

    public void setIdFaktorFs(Long idFaktorFs) {
        this.idFaktorFs = idFaktorFs;
    }

    public String getNamaFaktorFs() {
        return namaFaktorFs;
    }

    public void setNamaFaktorFs(String namaFaktorFs) {
        this.namaFaktorFs = namaFaktorFs;
    }

}
