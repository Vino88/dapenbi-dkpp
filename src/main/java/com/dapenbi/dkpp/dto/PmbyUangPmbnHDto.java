package com.dapenbi.dkpp.dto;

import com.dapenbi.dkpp.model.StatusValidasi;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class PmbyUangPmbnHDto extends BaseDto{
	private Long id;
	private String periodeBayar;
	private Date tglProses;
	private Long nominalPerNip;
	private Long totalPenerima;
	private String keterangan;
	private StatusValidasiDto idValidasi;
	private String namaValidasi;
	private String userValidasi;
	private Character isSentToPtr;
	private Long totalNominal;
	private Long totalJadiHutang;
	private Long totalDiBayarkan;
	private Boolean isActive;
	private String userStamp;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPeriodeBayar() {
		return periodeBayar;
	}

	public void setPeriodeBayar(String periodeBayar) {
		this.periodeBayar = periodeBayar;
	}

	public Date getTglProses() {
		return tglProses;
	}

	public void setTglProses(Date tglProses) {
		this.tglProses = tglProses;
	}

	public Long getNominalPerNip() {
		return nominalPerNip;
	}

	public void setNominalPerNip(Long nominalPerNip) {
		this.nominalPerNip = nominalPerNip;
	}

	public Long getTotalPenerima() {
		return totalPenerima;
	}

	public void setTotalPenerima(Long totalPenerima) {
		this.totalPenerima = totalPenerima;
	}

	public String getKeterangan() {
		return keterangan;
	}

	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}

	public StatusValidasiDto getIdValidasi() {
		return idValidasi;
	}

	public void setIdValidasi(StatusValidasiDto idValidasi) {
		this.idValidasi = idValidasi;
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

	public Character getIsSentToPtr() {
		return isSentToPtr;
	}

	public void setIsSentToPtr(Character isSentToPtr) {
		this.isSentToPtr = isSentToPtr;
	}

	public Long getTotalNominal() {
		return totalNominal;
	}

	public void setTotalNominal(Long totalNominal) {
		this.totalNominal = totalNominal;
	}

	public Long getTotalJadiHutang() {
		return totalJadiHutang;
	}

	public void setTotalJadiHutang(Long totalJadiHutang) {
		this.totalJadiHutang = totalJadiHutang;
	}

	public Long getTotalDiBayarkan() {
		return totalDiBayarkan;
	}

	public void setTotalDiBayarkan(Long totalDiBayarkan) {
		this.totalDiBayarkan = totalDiBayarkan;
	}

	public Boolean getActive() {
		return isActive;
	}

	public void setActive(Boolean active) {
		isActive = active;
	}

	public String getUserStamp() {
		return userStamp;
	}

	public void setUserStamp(String userStamp) {
		this.userStamp = userStamp;
	}
}