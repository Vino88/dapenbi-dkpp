package com.dapenbi.dkpp.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class PembayaranHutangDto {
	private Long idBayar;
	private String periodeBayar;
	private Date tglBayar;
	private String nip;
	private String namaPeserta;
	private String idPenerimaMp;
	private String namaPenerimaMp;
	private Long idGolongan;
	private String namaGolongan;
	private String jabatanPangkat;
	private String idKantorBayar;
	private String statusBayar;
	private Double totalHutang;
	private Double saldoHutang;
	private Character idValidasi;
	private String namaValidasi;
	private String userValidasi;
	private Double totalBayar;
	private String userStamp;
	private String isHutangMp;
	private String isHutangPembinaan;
	private Character isSentToPtr;
	private Long idSentToPtr;
	private String namaKantorBayar;
	private Date tglProses;

	public RekeningPenerimaMpDto getRekeningPenerimaMpDto() {
		return rekeningPenerimaMpDto;
	}

	public void setRekeningPenerimaMpDto(RekeningPenerimaMpDto rekeningPenerimaMpDto) {
		this.rekeningPenerimaMpDto = rekeningPenerimaMpDto;
	}

	private RekeningPenerimaMpDto rekeningPenerimaMpDto;

	public void setIdBayar(Long idBayar){
		this.idBayar = idBayar;
	}

	public Long getIdBayar(){
		return this.idBayar;
	}

	public void setPeriodeBayar(String periodeBayar){
		this.periodeBayar = periodeBayar;
	}

	public String getPeriodeBayar(){
		return this.periodeBayar;
	}

	public void setTglBayar(Date tglBayar){
		this.tglBayar = tglBayar;
	}

	public Date getTglBayar(){
		return this.tglBayar;
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

	public void setIdGolongan(Long idGolongan){
		this.idGolongan = idGolongan;
	}

	public Long getIdGolongan(){
		return this.idGolongan;
	}

	public void setNamaGolongan(String namaGolongan){
		this.namaGolongan = namaGolongan;
	}

	public String getNamaGolongan(){
		return this.namaGolongan;
	}

	public void setJabatanPangkat(String jabatanPangkat){
		this.jabatanPangkat = jabatanPangkat;
	}

	public String getJabatanPangkat(){
		return this.jabatanPangkat;
	}

	public void setIdKantorBayar(String idKantorBayar){
		this.idKantorBayar = idKantorBayar;
	}

	public String getIdKantorBayar(){
		return this.idKantorBayar;
	}

	public void setStatusBayar(String statusBayar){
		this.statusBayar = statusBayar;
	}

	public String getStatusBayar(){
		return this.statusBayar;
	}

	public void setTotalHutang(Double totalHutang){
		this.totalHutang = totalHutang;
	}

	public Double getTotalHutang(){
		return this.totalHutang;
	}

	public void setSaldoHutang(Double saldoHutang){
		this.saldoHutang = saldoHutang;
	}

	public Double getSaldoHutang(){
		return this.saldoHutang;
	}

	public void setIdValidasi(Character idValidasi){
		this.idValidasi = idValidasi;
	}

	public Character getIdValidasi(){
		return this.idValidasi;
	}

	public void setNamaValidasi(String namaValidasi){
		this.namaValidasi = namaValidasi;
	}

	public String getNamaValidasi(){
		return this.namaValidasi;
	}

	public void setUserValidasi(String userValidasi){
		this.userValidasi = userValidasi;
	}

	public String getUserValidasi(){
		return this.userValidasi;
	}

	public void setTotalBayar(Double totalBayar){
		this.totalBayar = totalBayar;
	}

	public Double getTotalBayar(){
		return this.totalBayar;
	}

	public void setUserStamp(String userStamp){
		this.userStamp = userStamp;
	}

	public String getUserStamp(){
		return this.userStamp;
	}

	public void setIsHutangMp(String isHutangMp){
		this.isHutangMp = isHutangMp;
	}

	public String getIsHutangMp(){
		return this.isHutangMp;
	}

	public void setIsHutangPembinaan(String isHutangPembinaan){
		this.isHutangPembinaan = isHutangPembinaan;
	}

	public String getIsHutangPembinaan(){
		return this.isHutangPembinaan;
	}

	public void setIsSentToPtr(Character isSentToPtr){
		this.isSentToPtr = isSentToPtr;
	}

	public Character getIsSentToPtr(){
		return this.isSentToPtr;
	}

	public void setIdSentToPtr(Long idSentToPtr){
		this.idSentToPtr = idSentToPtr;
	}

	public Long getIdSentToPtr(){
		return this.idSentToPtr;
	}

	public void setNamaKantorBayar(String namaKantorBayar){
		this.namaKantorBayar = namaKantorBayar;
	}

	public String getNamaKantorBayar(){
		return this.namaKantorBayar;
	}

	public void setTglProses(Date tglProses){
		this.tglProses = tglProses;
	}

	public Date getTglProses(){
		return this.tglProses;
	}


}