package com.dapenbi.dkpp.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class UploadRekVersiMandiriDto {
	private String periode;
	private String nip;
	private String namaPeserta;
	private String idPenerimaMp;
	private String namaPenerimaMp;
	private String nomorRekening;
	private String namaRekening;
	private String userStamp;
	private Date tglUpload;

public void setPeriode(String periode){
	this.periode = periode;
}

public String getPeriode(){
	return this.periode;
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

public void setNomorRekening(String nomorRekening){
	this.nomorRekening = nomorRekening;
}

public String getNomorRekening(){
	return this.nomorRekening;
}

public void setNamaRekening(String namaRekening){
	this.namaRekening = namaRekening;
}

public String getNamaRekening(){
	return this.namaRekening;
}

public void setUserStamp(String userStamp){
	this.userStamp = userStamp;
}

public String getUserStamp(){
	return this.userStamp;
}

public void setTglUpload(Date tglUpload){
	this.tglUpload = tglUpload;
}

public Date getTglUpload(){
	return this.tglUpload;
}



}