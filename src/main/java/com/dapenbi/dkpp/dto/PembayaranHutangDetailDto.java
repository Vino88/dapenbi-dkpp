package com.dapenbi.dkpp.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class PembayaranHutangDetailDto {
	private Long idBayarD;
	private Long idBayar;
	private String periodeBayar;
	private Date tglTransaksi;
	private Long nominal;
	private String keterangan;
	private Long idKategoriHutang;
	private String userStamp;
	private String namaKategoriHutang;

	public void setIdBayarD(Long idBayarD){
		this.idBayarD = idBayarD;
	}

	public Long getIdBayarD(){
		return this.idBayarD;
	}

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

	public void setTglTransaksi(Date tglTransaksi){
		this.tglTransaksi = tglTransaksi;
	}

	public Date getTglTransaksi(){
		return this.tglTransaksi;
	}

	public void setNominal(Long nominal){
		this.nominal = nominal;
	}

	public Long getNominal(){
		return this.nominal;
	}

	public void setKeterangan(String keterangan){
		this.keterangan = keterangan;
	}

	public String getKeterangan(){
		return this.keterangan;
	}

	public void setIdKategoriHutang(Long idKategoriHutang){
		this.idKategoriHutang = idKategoriHutang;
	}

	public Long getIdKategoriHutang(){
		return this.idKategoriHutang;
	}

	public void setUserStamp(String userStamp){
		this.userStamp = userStamp;
	}

	public String getUserStamp(){
		return this.userStamp;
	}

	public void setNamaKategoriHutang(String namaKategoriHutang){
		this.namaKategoriHutang = namaKategoriHutang;
	}

	public String getNamaKategoriHutang(){
		return this.namaKategoriHutang;
	}



}