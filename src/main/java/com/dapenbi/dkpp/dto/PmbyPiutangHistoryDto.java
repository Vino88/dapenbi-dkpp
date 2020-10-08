package com.dapenbi.dkpp.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class PmbyPiutangHistoryDto {
	private Long id;
	private PengembalianMpDto idPengembalianMp;
	private PmbyPiutangDto idBayarPiutang;
	private String periodeBayar;
	private Date tglBayar;
	private String nip;
	private Long saldoPiutangAwal;
	private Long dibayar;
	private Long saldoPiutangAkhir;
	private String keterangan;
	private String userStamp;
	private String userValidasi;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PengembalianMpDto getIdPengembalianMp() {
		return idPengembalianMp;
	}

	public void setIdPengembalianMp(PengembalianMpDto idPengembalianMp) {
		this.idPengembalianMp = idPengembalianMp;
	}

	public PmbyPiutangDto getIdBayarPiutang() {
		return idBayarPiutang;
	}

	public void setIdBayarPiutang(PmbyPiutangDto idBayarPiutang) {
		this.idBayarPiutang = idBayarPiutang;
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

public void setSaldoPiutangAwal(Long saldoPiutangAwal){
	this.saldoPiutangAwal = saldoPiutangAwal;
}

public Long getSaldoPiutangAwal(){
	return this.saldoPiutangAwal;
}

public void setDibayar(Long dibayar){
	this.dibayar = dibayar;
}

public Long getDibayar(){
	return this.dibayar;
}

public void setSaldoPiutangAkhir(Long saldoPiutangAkhir){
	this.saldoPiutangAkhir = saldoPiutangAkhir;
}

public Long getSaldoPiutangAkhir(){
	return this.saldoPiutangAkhir;
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



}