package com.dapenbi.dkpp.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class UploadMutasiFprFsDto {
	private Long id;
	private Date tglMulaiBerlaku;
	private Date tglUpload;
	private String periodeMulai;
	private String jenisFaktor;
	private Long totalData;
	private String userStamp;
	private Long idFs;
	private Long idFpr;
	private String keteranganFaktor;



public void setId(Long id){
	this.id = id;
}

public Long getId(){
	return this.id;
}

public void setTglMulaiBerlaku(Date tglMulaiBerlaku){
	this.tglMulaiBerlaku = tglMulaiBerlaku;
}

public Date getTglMulaiBerlaku(){
	return this.tglMulaiBerlaku;
}

public void setTglUpload(Date tglUpload){
	this.tglUpload = tglUpload;
}

public Date getTglUpload(){
	return this.tglUpload;
}

public void setPeriodeMulai(String periodeMulai){
	this.periodeMulai = periodeMulai;
}

public String getPeriodeMulai(){
	return this.periodeMulai;
}

public void setJenisFaktor(String jenisFaktor){
	this.jenisFaktor = jenisFaktor;
}

public String getJenisFaktor(){
	return this.jenisFaktor;
}

public void setTotalData(Long totalData){
	this.totalData = totalData;
}

public Long getTotalData(){
	return this.totalData;
}

public void setUserStamp(String userStamp){
	this.userStamp = userStamp;
}

public String getUserStamp(){
	return this.userStamp;
}

	public Long getIdFs() {
		return idFs;
	}

	public void setIdFs(Long idFs) {
		this.idFs = idFs;
	}

	public Long getIdFpr() {
		return idFpr;
	}

	public void setIdFpr(Long idFpr) {
		this.idFpr = idFpr;
	}

	public String getKeteranganFaktor() {
		return keteranganFaktor;
	}

	public void setKeteranganFaktor(String keteranganFaktor) {
		this.keteranganFaktor = keteranganFaktor;
	}
}