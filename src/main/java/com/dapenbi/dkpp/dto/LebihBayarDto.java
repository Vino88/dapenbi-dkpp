package com.dapenbi.dkpp.dto;

import com.dapenbi.dkpp.model.KantorBayar;
import com.dapenbi.dkpp.model.LebihBayarDetail;

import java.util.Date;

public class LebihBayarDto extends BaseDto{

    private String periodeMutasi;

    private String nip;

    private String namaPeserta;

    private String idPenerimaMp;

    private String namaPenerimaMp;

    private KategoriPenerimaDto kategoriPenerima;

    private String namaKategoriPenerimaMp;

    private KantorBayarDto kantorBayar;

    private String namaKantorBayar;

    private Long saldoLebihBayar;

    private Date tglLebihBayar;

    private String jenisPengembalian;

    private String jenisAngsuran;

    private Long tenorBulan;

    private Long nominalAngsuaran;

    private Date tglProsesCicilan;

    private String periodeMulaiBayar;

    private Long telahDibayar;

    private Long sisaLebihBayar;

    private KategoriCatatanDto kategoriCatatan;

    private String namaCatatan;

    private String keterangan;

    private String userValidasi;

    private StatusValidasiDto statusValidasi;

    private String namaValidasi;

    private String keteranganOtomatis;

    private boolean isActive;

    private LebihBayarDetailDto lebihBayarDetail;


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

    public KategoriPenerimaDto getKategoriPenerima() {
        return kategoriPenerima;
    }

    public void setKategoriPenerima(KategoriPenerimaDto kategoriPenerima) {
        this.kategoriPenerima = kategoriPenerima;
    }

    public String getNamaKategoriPenerimaMp() {
        return namaKategoriPenerimaMp;
    }

    public void setNamaKategoriPenerimaMp(String namaKategoriPenerimaMp) {
        this.namaKategoriPenerimaMp = namaKategoriPenerimaMp;
    }

    public KantorBayarDto getKantorBayar() {
        return kantorBayar;
    }

    public void setKantorBayar(KantorBayarDto kantorBayar) {
        this.kantorBayar = kantorBayar;
    }

    public String getNamaKantorBayar() {
        return namaKantorBayar;
    }

    public void setNamaKantorBayar(String namaKantorBayar) {
        this.namaKantorBayar = namaKantorBayar;
    }

    public Long getSaldoLebihBayar() {
        return saldoLebihBayar;
    }

    public void setSaldoLebihBayar(Long saldoLebihBayar) {
        this.saldoLebihBayar = saldoLebihBayar;
    }

    public Date getTglLebihBayar() {
        return tglLebihBayar;
    }

    public void setTglLebihBayar(Date tglLebihBayar) {
        this.tglLebihBayar = tglLebihBayar;
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

    public Long getTenorBulan() {
        return tenorBulan;
    }

    public void setTenorBulan(Long tenorBulan) {
        this.tenorBulan = tenorBulan;
    }

    public Long getNominalAngsuaran() {
        return nominalAngsuaran;
    }

    public void setNominalAngsuaran(Long nominalAngsuaran) {
        this.nominalAngsuaran = nominalAngsuaran;
    }

    public Date getTglProsesCicilan() {
        return tglProsesCicilan;
    }

    public void setTglProsesCicilan(Date tglProsesCicilan) {
        this.tglProsesCicilan = tglProsesCicilan;
    }

    public String getPeriodeMulaiBayar() {
        return periodeMulaiBayar;
    }

    public void setPeriodeMulaiBayar(String periodeMulaiBayar) {
        this.periodeMulaiBayar = periodeMulaiBayar;
    }

    public Long getTelahDibayar() {
        return telahDibayar;
    }

    public void setTelahDibayar(Long telahDibayar) {
        this.telahDibayar = telahDibayar;
    }

    public Long getSisaLebihBayar() {
        return sisaLebihBayar;
    }

    public void setSisaLebihBayar(Long sisaLebihBayar) {
        this.sisaLebihBayar = sisaLebihBayar;
    }

    public KategoriCatatanDto getKategoriCatatan() {
        return kategoriCatatan;
    }

    public void setKategoriCatatan(KategoriCatatanDto kategoriCatatan) {
        this.kategoriCatatan = kategoriCatatan;
    }

    public String getNamaCatatan() {
        return namaCatatan;
    }

    public void setNamaCatatan(String namaCatatan) {
        this.namaCatatan = namaCatatan;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getUserValidasi() {
        return userValidasi;
    }

    public void setUserValidasi(String userValidasi) {
        this.userValidasi = userValidasi;
    }

    public StatusValidasiDto getStatusValidasi() {
        return statusValidasi;
    }

    public void setStatusValidasi(StatusValidasiDto statusValidasi) {
        this.statusValidasi = statusValidasi;
    }

    public String getNamaValidasi() {
        return namaValidasi;
    }

    public void setNamaValidasi(String namaValidasi) {
        this.namaValidasi = namaValidasi;
    }

    public String getKeteranganOtomatis() {
        return keteranganOtomatis;
    }

    public void setKeteranganOtomatis(String keteranganOtomatis) {
        this.keteranganOtomatis = keteranganOtomatis;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public LebihBayarDetailDto getLebihBayarDetail() {
        return lebihBayarDetail;
    }

    public void setLebihBayarDetail(LebihBayarDetailDto lebihBayarDetail) {
        this.lebihBayarDetail = lebihBayarDetail;
    }
}
