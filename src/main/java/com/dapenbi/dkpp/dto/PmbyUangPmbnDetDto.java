package com.dapenbi.dkpp.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class PmbyUangPmbnDetDto extends BaseDto{
	private Long id;
	private String periodeBayar;
	private String nip;
	private String namaPeserta;
	private Long nominal;
	private Long idUangPembinaanH;
	private Long idSentToPtr;
	private String userStamp;
	private Boolean isActive;
	private Character isStatusBayar;
	private Character isHutang;

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

	public Long getNominal() {
		return nominal;
	}

	public void setNominal(Long nominal) {
		this.nominal = nominal;
	}

	public Long getIdUangPembinaanH() {
		return idUangPembinaanH;
	}

	public void setIdUangPembinaanH(Long idUangPembinaanH) {
		this.idUangPembinaanH = idUangPembinaanH;
	}

	public Long getIdSentToPtr() {
		return idSentToPtr;
	}

	public void setIdSentToPtr(Long idSentToPtr) {
		this.idSentToPtr = idSentToPtr;
	}

	public String getUserStamp() {
		return userStamp;
	}

	public void setUserStamp(String userStamp) {
		this.userStamp = userStamp;
	}

	public Boolean getActive() {
		return isActive;
	}

	public void setActive(Boolean active) {
		isActive = active;
	}

	public Character getIsStatusBayar() {
		return isStatusBayar;
	}

	public void setIsStatusBayar(Character isStatusBayar) {
		this.isStatusBayar = isStatusBayar;
	}

	public Character getIsHutang() {
		return isHutang;
	}

	public void setIsHutang(Character isHutang) {
		this.isHutang = isHutang;
	}
}