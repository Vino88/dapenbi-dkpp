package com.dapenbi.dkpp.form;

import java.util.Map;

public class GolonganFormDto {

    private Long id;

    private String noGolongan;

    private String namaGolongan;

    private String namaGolonganLama;

    private String pangkat;

    private String jabatan;

    private String eselon;

    private Map active;

    private String userStamp;

    public GolonganFormDto(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNoGolongan() {
        return noGolongan;
    }

    public void setNoGolongan(String noGolongan) {
        this.noGolongan = noGolongan;
    }

    public String getNamaGolongan() {
        return namaGolongan;
    }

    public void setNamaGolongan(String namaGolongan) {
        this.namaGolongan = namaGolongan;
    }

    public String getNamaGolonganLama() {
        return namaGolonganLama;
    }

    public void setNamaGolonganLama(String namaGolonganLama) {
        this.namaGolonganLama = namaGolonganLama;
    }

    public String getPangkat() {
        return pangkat;
    }

    public void setPangkat(String pangkat) {
        this.pangkat = pangkat;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getEselon() {
        return eselon;
    }

    public void setEselon(String eselon) {
        this.eselon = eselon;
    }

    public Map getActive() {
        return active;
    }

    public void setActive(Map active) {
        this.active = active;
    }

    public String getUserStamp() {
        return userStamp;
    }

    public void setUserStamp(String userStamp) {
        this.userStamp = userStamp;
    }
}
