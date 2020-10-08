package com.dapenbi.dkpp.dto;

import java.util.List;

public class HerRegistrasiDto extends BaseDto {
	
	private String tahunHer;
	private String jenisHer;
	private String jenisHerDesc;
	private String periodeTerdaftarPeserta;
	private String statusHer;
	private Long totalPusat;
	private Long totalCabang;
	private StatusValidasiDto statusValidasi;
	private String namaValidasi;
	private String userValidasi;
	private Long idCatatan;
	private String kategoriCatatan;
	private String keterangan;
	private String userStamp;
	private List<HerRegistrasiDetailDto> herRegistrasiDetail;
	
	public String getUserStamp() {
		return userStamp;
	}

	public void setUserStamp(String userStamp) {
		this.userStamp = userStamp;
	}

	public List<HerRegistrasiDetailDto> getHerRegistrasiDetail() {
		return herRegistrasiDetail;
	}

	public void setHerRegistrasiDetail(List<HerRegistrasiDetailDto> herRegistrasiDetail) {
		this.herRegistrasiDetail = herRegistrasiDetail;
	}

	public String getTahunHer() {
		return tahunHer;
	}

	public void setTahunHer(String tahunHer) {
		this.tahunHer = tahunHer;
	}

	public String getJenisHer() {
		return jenisHer;
	}

	public void setJenisHer(String jenisHer) {
		this.jenisHer = jenisHer;
	}

	public String getJenisHerDesc() {
		return jenisHerDesc;
	}

	public void setJenisHerDesc(String jenisHerDesc) {
		this.jenisHerDesc = jenisHerDesc;
	}

	public String getPeriodeTerdaftarPeserta() {
		return periodeTerdaftarPeserta;
	}

	public void setPeriodeTerdaftarPeserta(String periodeTerdaftarPeserta) {
		this.periodeTerdaftarPeserta = periodeTerdaftarPeserta;
	}

	public String getStatusHer() {
		return statusHer;
	}

	public void setStatusHer(String statusHer) {
		this.statusHer = statusHer;
	}

	public Long getTotalPusat() {
		return totalPusat;
	}

	public void setTotalPusat(Long totalPusat) {
		this.totalPusat = totalPusat;
	}

	public Long getTotalCabang() {
		return totalCabang;
	}

	public void setTotalCabang(Long totalCabang) {
		this.totalCabang = totalCabang;
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

	public String getUserValidasi() {
		return userValidasi;
	}

	public void setUserValidasi(String userValidasi) {
		this.userValidasi = userValidasi;
	}

	public Long getIdCatatan() {
		return idCatatan;
	}

	public void setIdCatatan(Long idCatatan) {
		this.idCatatan = idCatatan;
	}

	public String getKategoriCatatan() {
		return kategoriCatatan;
	}

	public void setKategoriCatatan(String kategoriCatatan) {
		this.kategoriCatatan = kategoriCatatan;
	}

	public String getKeterangan() {
		return keterangan;
	}

	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}

}
