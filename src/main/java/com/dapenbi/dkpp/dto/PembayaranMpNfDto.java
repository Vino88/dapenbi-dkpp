package com.dapenbi.dkpp.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class PembayaranMpNfDto {
	private Long idPembayaran;
	private String periodeMutasi;
	private Date tglMutasi;
	private String nip;
	private String namaPeserta;
	private String idPenerimaMp;
	private String namaPenerimaMp;
	private Long mpEuro;
	private Long mpRupiah;
	private Character statusHer;
	private Long idValidasi;
	private String namaValidasi;
	private Long idKategoriCatatan;
	private String keterangan;
	private String userStamp;
	private String userValidasi;
	private Long isSentToPtr;
	private Long isHutang;

	public void setIdPembayaran(Long idPembayaran){
		this.idPembayaran = idPembayaran;
	}

	public Long getIdPembayaran(){
		return this.idPembayaran;
	}

	public void setPeriodeMutasi(String periodeMutasi){
		this.periodeMutasi = periodeMutasi;
	}

	public String getPeriodeMutasi(){
		return this.periodeMutasi;
	}

	public void setTglMutasi(Date tglMutasi){
		this.tglMutasi = tglMutasi;
	}

	public Date getTglMutasi(){
		return this.tglMutasi;
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

	public void setIdPenerimaMp(String idPenerimaMp){
		this.idPenerimaMp = idPenerimaMp;
	}

	public String getIdPenerimaMp(){
		return this.idPenerimaMp;
	}

	public void setNamaPenerimaMp(String namaPenerimaMp){
		this.namaPenerimaMp = namaPenerimaMp;
	}

	public String getNamaPenerimaMp(){
		return this.namaPenerimaMp;
	}

	public void setMpEuro(Long mpEuro){
		this.mpEuro = mpEuro;
	}

	public Long getMpEuro(){
		return this.mpEuro;
	}

	public void setMpRupiah(Long mpRupiah){
		this.mpRupiah = mpRupiah;
	}

	public Long getMpRupiah(){
		return this.mpRupiah;
	}

	public void setStatusHer(Character statusHer){
		this.statusHer = statusHer;
	}

	public Character getStatusHer(){
		return this.statusHer;
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

	public void setIdKategoriCatatan(Long idKategoriCatatan){
		this.idKategoriCatatan = idKategoriCatatan;
	}

	public Long getIdKategoriCatatan(){
		return this.idKategoriCatatan;
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

	public Long getIsSentToPtr() {
		return isSentToPtr;
	}

	public void setIsSentToPtr(Long isSentToPtr) {
		this.isSentToPtr = isSentToPtr;
	}

	public Long getIsHutang() {
		return isHutang;
	}

	public void setIsHutang(Long isHutang) {
		this.isHutang = isHutang;
	}
}