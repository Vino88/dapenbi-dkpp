package com.dapenbi.dkpp.dto;

import com.dapenbi.dkpp.model.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

public class LebihBayarDetailDto extends BaseDto {

    private Long id;
    private MutasiPensiunDto mutasi;
    private Date tanggalMutasi;
    private String periodeMutasi;
    private String nip;
    private String namaPeserta;
    private String penerimaMP;
    private String namaPenerimaMP;
    private KategoriPenerimaDto kategoriPenerima;
    private String namaKategoriPenerimaMP;
    private KantorBayarDto kantorBayar;
    private String namaKantorBayar;
    private BigDecimal kurangBayar;
    private String keterangan;
    private StatusValidasiDto statusValidasi;
    private String namaValidasi;
    private KategoriCatatanDto kategoriCatatan;
    private String namaKategoriCatatan;
    private Long lebihBayarMP;
    private String userStamp;
    private boolean isActive;
    private String userValidasi;
    private Long idAlasanKuranglebihBayar;
    private Long lebihBayarMps20Persen;
    private Long lebihBayarMps10Juta;
    private Long lebihBayarMps100Persen;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MutasiPensiunDto getMutasi() {
        return mutasi;
    }

    public void setMutasi(MutasiPensiunDto mutasi) {
        this.mutasi = mutasi;
    }

    public Date getTanggalMutasi() {
        return tanggalMutasi;
    }

    public void setTanggalMutasi(Date tanggalMutasi) {
        this.tanggalMutasi = tanggalMutasi;
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

    public String getPenerimaMP() {
        return penerimaMP;
    }

    public void setPenerimaMP(String penerimaMP) {
        this.penerimaMP = penerimaMP;
    }

    public String getNamaPenerimaMP() {
        return namaPenerimaMP;
    }

    public void setNamaPenerimaMP(String namaPenerimaMP) {
        this.namaPenerimaMP = namaPenerimaMP;
    }

    public KategoriPenerimaDto getKategoriPenerima() {
        return kategoriPenerima;
    }

    public void setKategoriPenerima(KategoriPenerimaDto kategoriPenerima) {
        this.kategoriPenerima = kategoriPenerima;
    }

    public String getNamaKategoriPenerimaMP() {
        return namaKategoriPenerimaMP;
    }

    public void setNamaKategoriPenerimaMP(String namaKategoriPenerimaMP) {
        this.namaKategoriPenerimaMP = namaKategoriPenerimaMP;
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

    public BigDecimal getKurangBayar() {
        return kurangBayar;
    }

    public void setKurangBayar(BigDecimal kurangBayar) {
        this.kurangBayar = kurangBayar;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
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

    public KategoriCatatanDto getKategoriCatatan() {
        return kategoriCatatan;
    }

    public void setKategoriCatatan(KategoriCatatanDto kategoriCatatan) {
        this.kategoriCatatan = kategoriCatatan;
    }

    public String getNamaKategoriCatatan() {
        return namaKategoriCatatan;
    }

    public void setNamaKategoriCatatan(String namaKategoriCatatan) {
        this.namaKategoriCatatan = namaKategoriCatatan;
    }

    public Long getLebihBayarMP() {
        return lebihBayarMP;
    }

    public void setLebihBayarMP(Long lebihBayarMP) {
        this.lebihBayarMP = lebihBayarMP;
    }

    public String getUserStamp() {
        return userStamp;
    }

    public void setUserStamp(String userStamp) {
        this.userStamp = userStamp;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getUserValidasi() {
        return userValidasi;
    }

    public void setUserValidasi(String userValidasi) {
        this.userValidasi = userValidasi;
    }

    public Long getIdAlasanKuranglebihBayar() {
        return idAlasanKuranglebihBayar;
    }

    public void setIdAlasanKuranglebihBayar(Long idAlasanKuranglebihBayar) {
        this.idAlasanKuranglebihBayar = idAlasanKuranglebihBayar;
    }

    public Long getLebihBayarMps20Persen() {
        return lebihBayarMps20Persen;
    }

    public void setLebihBayarMps20Persen(Long lebihBayarMps20Persen) {
        this.lebihBayarMps20Persen = lebihBayarMps20Persen;
    }

    public Long getLebihBayarMps10Juta() {
        return lebihBayarMps10Juta;
    }

    public void setLebihBayarMps10Juta(Long lebihBayarMps10Juta) {
        this.lebihBayarMps10Juta = lebihBayarMps10Juta;
    }

    public Long getLebihBayarMps100Persen() {
        return lebihBayarMps100Persen;
    }

    public void setLebihBayarMps100Persen(Long lebihBayarMps100Persen) {
        this.lebihBayarMps100Persen = lebihBayarMps100Persen;
    }
}
