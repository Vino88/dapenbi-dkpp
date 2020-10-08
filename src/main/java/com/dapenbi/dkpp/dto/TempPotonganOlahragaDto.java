package com.dapenbi.dkpp.dto;

public class TempPotonganOlahragaDto {
    private Long id;
    private String periodeMutasi;
    private String nip;
    private String namaPeserta;
    private String idOlahraga;
    private String namaOlahraga;
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

    public String getIdOlahraga() {
        return idOlahraga;
    }

    public void setIdOlahraga(String idOlahraga) {
        this.idOlahraga = idOlahraga;
    }

    public String getNamaOlahraga() {
        return namaOlahraga;
    }

    public void setNamaOlahraga(String namaOlahraga) {
        this.namaOlahraga = namaOlahraga;
    }

    public String getPotongan() {
        return potongan;
    }

    public void setPotongan(String potongan) {
        this.potongan = potongan;
    }
}
