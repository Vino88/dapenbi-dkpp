package com.dapenbi.dkpp.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class TKursDto {
	private String periodeMutasi;
	private Long kursEuro;
	private BigDecimal kursRupiah;
	private Character isActive;
	private String userStamp;

	public void setPeriodeMutasi(String periodeMutasi){
		this.periodeMutasi = periodeMutasi;
	}

	public String getPeriodeMutasi(){
		return this.periodeMutasi;
	}

	public void setKursEuro(Long kursEuro){
		this.kursEuro = kursEuro;
	}

	public Long getKursEuro(){
		return this.kursEuro;
	}

	public void setKursRupiah(BigDecimal kursRupiah){
		this.kursRupiah = kursRupiah;
	}

	public BigDecimal getKursRupiah(){
		return this.kursRupiah;
	}

	public void setIsActive(Character isActive){
		this.isActive = isActive;
	}

	public Character getIsActive(){
		return this.isActive;
	}

	public void setUserStamp(String userStamp){
		this.userStamp = userStamp;
	}

	public String getUserStamp(){
		return this.userStamp;
	}

}