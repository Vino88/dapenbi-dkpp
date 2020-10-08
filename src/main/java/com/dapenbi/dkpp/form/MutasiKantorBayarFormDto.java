package com.dapenbi.dkpp.form;

public class MutasiKantorBayarFormDto {
    private String id;
    private String nip;
    private String namaPeserta;
    private String tglMutasi;
    private String periodeMutasi;
    private String idPenerimaMp;
    private String namaPenerimaMp;
    private String kategoriPenerimaMp;
    private String idKantorBayarLama;
    private String namaKantorBayarLama;
    private String idKantorBayarBaru;
    private String namaKantorBayarBaru;
    private String idKategoriCatatan;
    private String namaKategoriCatatan;
    private String compName;
    private String userName;
    private String keterangan;
    private String idValidasi;
    private String namaValidasi;

    public MutasiKantorBayarFormDto(String nip, String namaPeserta, String tglMutasi, String periodeMutasi, String idPenerimaMp, String namaPenerimaMp, String kategoriPenerimaMp, String idKantorBayarLama, String namaKantorBayarLama, String idKantorBayarBaru, String namaKantorBayarBaru, String idKategoriCatatan, String namaKategoriCatatan) {
        this.nip = nip;
        this.namaPeserta = namaPeserta;
        this.tglMutasi = tglMutasi;
        this.periodeMutasi = periodeMutasi;
        this.idPenerimaMp = idPenerimaMp;
        this.namaPenerimaMp = namaPenerimaMp;
        this.kategoriPenerimaMp = kategoriPenerimaMp;
        this.idKantorBayarLama = idKantorBayarLama;
        this.namaKantorBayarLama = namaKantorBayarLama;
        this.idKantorBayarBaru = idKantorBayarBaru;
        this.namaKantorBayarBaru = namaKantorBayarBaru;
        this.idKategoriCatatan = idKategoriCatatan;
        this.namaKategoriCatatan = namaKategoriCatatan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getTglMutasi() {
        return tglMutasi;
    }

    public void setTglMutasi(String tglMutasi) {
        this.tglMutasi = tglMutasi;
    }

    public String getPeriodeMutasi() {
        return periodeMutasi;
    }

    public void setPeriodeMutasi(String periodeMutasi) {
        this.periodeMutasi = periodeMutasi;
    }

    public String getIdPenerimaMp() {
        return idPenerimaMp;
    }

    public void setIdPenerimaMp(String idPenerimaMp) {
        this.idPenerimaMp = idPenerimaMp;
    }

    public String getNamaPenerimaMp() {
        return namaPenerimaMp;
    }

    public void setNamaPenerimaMp(String namaPenerimaMp) {
        this.namaPenerimaMp = namaPenerimaMp;
    }

    public String getKategoriPenerimaMp() {
        return kategoriPenerimaMp;
    }

    public void setKategoriPenerimaMp(String kategoriPenerimaMp) {
        this.kategoriPenerimaMp = kategoriPenerimaMp;
    }

    public String getIdKantorBayarLama() {
        return idKantorBayarLama;
    }

    public void setIdKantorBayarLama(String idKantorBayarLama) {
        this.idKantorBayarLama = idKantorBayarLama;
    }

    public String getNamaKantorBayarLama() {
        return namaKantorBayarLama;
    }

    public void setNamaKantorBayarLama(String namaKantorBayarLama) {
        this.namaKantorBayarLama = namaKantorBayarLama;
    }

    public String getIdKantorBayarBaru() {
        return idKantorBayarBaru;
    }

    public void setIdKantorBayarBaru(String idKantorBayarBaru) {
        this.idKantorBayarBaru = idKantorBayarBaru;
    }

    public String getNamaKantorBayarBaru() {
        return namaKantorBayarBaru;
    }

    public void setNamaKantorBayarBaru(String namaKantorBayarBaru) {
        this.namaKantorBayarBaru = namaKantorBayarBaru;
    }

    public String getIdKategoriCatatan() {
        return idKategoriCatatan;
    }

    public void setIdKategoriCatatan(String idKategoriCatatan) {
        this.idKategoriCatatan = idKategoriCatatan;
    }

    public String getNamaKategoriCatatan() {
        return namaKategoriCatatan;
    }

    public void setNamaKategoriCatatan(String namaKategoriCatatan) {
        this.namaKategoriCatatan = namaKategoriCatatan;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getIdValidasi() {
        return idValidasi;
    }

    public void setIdValidasi(String idValidasi) {
        this.idValidasi = idValidasi;
    }

    public String getNamaValidasi() {
        return namaValidasi;
    }

    public void setNamaValidasi(String namaValidasi) {
        this.namaValidasi = namaValidasi;
    }
}
