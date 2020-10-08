package com.dapenbi.dkpp.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.dapenbi.dkpp.model.AlasanKurangLebihBayar;
import com.dapenbi.dkpp.model.MutasiPensiun;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class KurangBayarDetailDto extends BaseDto {
	

	private Long id;
    private MutasiPensiunDto mutasiPensiun;
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
	private AlasanKurangLebihBayar alasanKurangLebihBayar;
	private BigDecimal kurangBayarMPS20Persen;
	private BigDecimal kurangBayarMPS10Juta;
	private BigDecimal kurangBayarMPS100Persen;
    private String userValidasi;
    private String userStamp;
    
    
	public MutasiPensiunDto getMutasiPensiun() {
		return mutasiPensiun;
	}
	public void setMutasiPensiun(MutasiPensiunDto mutasiPensiun) {
		this.mutasiPensiun = mutasiPensiun;
	}
	public String getUserStamp() {
		return userStamp;
	}
	public void setUserStamp(String userStamp) {
		this.userStamp = userStamp;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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

	public AlasanKurangLebihBayar getAlasanKurangLebihBayar() {
		return alasanKurangLebihBayar;
	}

	public void setAlasanKurangLebihBayar(AlasanKurangLebihBayar alasanKurangLebihBayar) {
		this.alasanKurangLebihBayar = alasanKurangLebihBayar;
	}

	public BigDecimal getKurangBayarMPS20Persen() {
		return kurangBayarMPS20Persen;
	}

	public void setKurangBayarMPS20Persen(BigDecimal kurangBayarMPS20Persen) {
		this.kurangBayarMPS20Persen = kurangBayarMPS20Persen;
	}

	public BigDecimal getKurangBayarMPS10Juta() {
		return kurangBayarMPS10Juta;
	}

	public void setKurangBayarMPS10Juta(BigDecimal kurangBayarMPS10Juta) {
		this.kurangBayarMPS10Juta = kurangBayarMPS10Juta;
	}

	public BigDecimal getKurangBayarMPS100Persen() {
		return kurangBayarMPS100Persen;
	}

	public void setKurangBayarMPS100Persen(BigDecimal kurangBayarMPS100Persen) {
		this.kurangBayarMPS100Persen = kurangBayarMPS100Persen;
	}

	public String getUserValidasi() {
		return userValidasi;
	}
	public void setUserValidasi(String userValidasi) {
		this.userValidasi = userValidasi;
	}
    
    
	
}
