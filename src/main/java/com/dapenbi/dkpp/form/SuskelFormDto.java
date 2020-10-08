package com.dapenbi.dkpp.form;

import java.util.List;
import java.util.Map;

public class SuskelFormDto {
    private String nip;
    private List<Map<String, String>> dataKeluarga;

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public List<Map<String, String>> getDataKeluarga() {
        return dataKeluarga;
    }

    public void setDataKeluarga(List<Map<String, String>> dataKeluarga) {
        this.dataKeluarga = dataKeluarga;
    }
}
