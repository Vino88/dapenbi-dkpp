package com.dapenbi.dkpp.dto;

public class TempPotonganKovetriDto {
    private Long id;
    private String periodeMutasi;
    private String nip;
    private String namaPeserta;
    private String idKantorBayar;
    private String namaKantorBayar;
    private String potongan;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPeriodeMutasi() {
        return periodeMutasi;
    }

    public void setPeriodeMutasi(String periodeMutasi) {
        this.periodeMutasi = periodeMutasi;
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

    public String getPotongan() {
        return potongan;
    }

    public void setPotongan(String potongan) {
        this.potongan = potongan;
    }
}
