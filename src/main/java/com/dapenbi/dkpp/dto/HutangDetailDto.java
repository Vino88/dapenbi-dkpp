package com.dapenbi.dkpp.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class HutangDetailDto {
	private Long idHutangD;
	private Long idHutang;
	private Date tglMutasi;
	private String periodeMutasi;
	private String nip;
	private String namaPeserta;
	private Date tglTransaksi;
	private Long jumlahHutang;
	private Long idKategoriCatatan;
	private String namaKategoriCatatan;
	private String keterangan;
	private String userStamp;
	private String userValidasi;
	private Character isActive;
	private String refMutasi;
	private Long idValidasi;
	private String namaValidasi;
	private String type;
	private Long idKategoriHutang;
	private String namaKategoriHutang;

	public Long getIdHutangD() {
		return idHutangD;
	}

	public void setIdHutangD(Long idHutangD) {
		this.idHutangD = idHutangD;
	}

	public void setIdHutang(Long idHutang){
		this.idHutang = idHutang;
	}

	public Long getIdHutang(){
		return this.idHutang;
	}

	public void setTglMutasi(Date tglMutasi){
		this.tglMutasi = tglMutasi;
	}

	public Date getTglMutasi(){
		return this.tglMutasi;
	}

	public void setPeriodeMutasi(String periodeMutasi){
		this.periodeMutasi = periodeMutasi;
	}

	public String getPeriodeMutasi(){
		return this.periodeMutasi;
	}

	public void setNip(String nip){
		this.nip = nip;
	}

	public String getNip(){
		return this.nip;
	}

	public void setNamaPeserta(String namaPeserta){
		this.namaPeserta = namaPeserta;
	}

	public String getNamaPeserta(){
		return this.namaPeserta;
	}

	public void setTglTransaksi(Date tglTransaksi){
		this.tglTransaksi = tglTransaksi;
	}

	public Date getTglTransaksi(){
		return this.tglTransaksi;
	}

	public void setJumlahHutang(Long jumlahHutang){
		this.jumlahHutang = jumlahHutang;
	}

	public Long getJumlahHutang(){
		return this.jumlahHutang;
	}

	public void setIdKategoriCatatan(Long idKategoriCatatan){
		this.idKategoriCatatan = idKategoriCatatan;
	}

	public Long getIdKategoriCatatan(){
		return this.idKategoriCatatan;
	}

	public void setNamaKategoriCatatan(String namaKategoriCatatan){
		this.namaKategoriCatatan = namaKategoriCatatan;
	}

	public String getNamaKategoriCatatan(){
		return this.namaKategoriCatatan;
	}

	public void setKeterangan(String keterangan){
		this.keterangan = keterangan;
	}

	public String getKeterangan(){
		return this.keterangan;
	}

	public void setUserStamp(String userStamp){
		this.userStamp = userStamp;
	}

	public String getUserStamp(){
		return this.userStamp;
	}

	public void setUserValidasi(String userValidasi){
		this.userValidasi = userValidasi;
	}

	public String getUserValidasi(){
		return this.userValidasi;
	}

	public void setIsActive(Character isActive){
		this.isActive = isActive;
	}

	public Character getIsActive(){
		return this.isActive;
	}

	public void setRefMutasi(String refMutasi){
		this.refMutasi = refMutasi;
	}

	public String getRefMutasi(){
		return this.refMutasi;
	}

	public void setIdValidasi(Long idValidasi){
		this.idValidasi = idValidasi;
	}

	public Long getIdValidasi(){
		return this.idValidasi;
	}

	public void setNamaValidasi(String namaValidasi){
		this.namaValidasi = namaValidasi;
	}

	public String getNamaValidasi(){
		return this.namaValidasi;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return this.type;
	}

	public void setIdKategoriHutang(Long idKategoriHutang){
		this.idKategoriHutang = idKategoriHutang;
	}

	public Long getIdKategoriHutang(){
		return this.idKategoriHutang;
	}

	public void setNamaKategoriHutang(String namaKategoriHutang){
		this.namaKategoriHutang = namaKategoriHutang;
	}

	public String getNamaKategoriHutang(){
		return this.namaKategoriHutang;
	}

}