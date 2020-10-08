package com.dapenbi.dkpp.form;

public class MutasiLebihBayarFormDto extends BaseFormDto {
    private String compName;
    private String userName;
    private String nip;
    private String periodeLebihBayar;
    private Long lebihBayarMp;
    private String jenisPengembalian;
    private String jenisAngsuran;
    private Long tenor;
    private String nominalAngsuran;
    private String periodeMulaiBayar;
    private Long idKategoriCatatan;
    private String keterangan;
    private String idValidasi;
    private String namaValidasi;

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

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getPeriodeLebihBayar() {
        return periodeLebihBayar;
    }

    public void setPeriodeLebihBayar(String periodeLebihBayar) {
        this.periodeLebihBayar = periodeLebihBayar;
    }

    public Long getLebihBayarMp() {
        return lebihBayarMp;
    }

    public void setLebihBayarMp(Long lebihBayarMp) {
        this.lebihBayarMp = lebihBayarMp;
    }

    public String getJenisPengembalian() {
        return jenisPengembalian;
    }

    public void setJenisPengembalian(String jenisPengembalian) {
        this.jenisPengembalian = jenisPengembalian;
    }

    public String getJenisAngsuran() {
        return jenisAngsuran;
    }

    public void setJenisAngsuran(String jenisAngsuran) {
        this.jenisAngsuran = jenisAngsuran;
    }

    public Long getTenor() {
        return tenor;
    }

    public void setTenor(Long tenor) {
        this.tenor = tenor;
    }

    public String getNominalAngsuran() {
        return nominalAngsuran;
    }

    public void setNominalAngsuran(String nominalAngsuran) {
        this.nominalAngsuran = nominalAngsuran;
    }

    public String getPeriodeMulaiBayar() {
        return periodeMulaiBayar;
    }

    public void setPeriodeMulaiBayar(String periodeMulaiBayar) {
        this.periodeMulaiBayar = periodeMulaiBayar;
    }

    public Long getIdKategoriCatatan() {
        return idKategoriCatatan;
    }

    public void setIdKategoriCatatan(Long idKategoriCatatan) {
        this.idKategoriCatatan = idKategoriCatatan;
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
