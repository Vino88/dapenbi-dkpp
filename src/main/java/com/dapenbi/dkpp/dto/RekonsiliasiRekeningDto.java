package com.dapenbi.dkpp.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class RekonsiliasiRekeningDto {
	private String periode;
	private String nip;
	private String namaPeserta;
	private String idPenerimaMp;
	private String namaPenerimaMp;
	private String nomorRekeningMandiri;
	private String nomorRekeningDapenbi;
	private String namaRekeningMandiri;
	private String namaRekeningDapenbi;
	private Long idValidasi;
	private String namaValidasi;
	private String userStamp;
	private String userValidasi;

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

public void setNomorRekeningMandiri(String nomorRekeningMandiri){
	this.nomorRekeningMandiri = nomorRekeningMandiri;
}

public String getNomorRekeningMandiri(){
	return this.nomorRekeningMandiri;
}

public void setNomorRekeningDapenbi(String nomorRekeningDapenbi){
	this.nomorRekeningDapenbi = nomorRekeningDapenbi;
}

public String getNomorRekeningDapenbi(){
	return this.nomorRekeningDapenbi;
}

public void setNamaRekeningMandiri(String namaRekeningMandiri){
	this.namaRekeningMandiri = namaRekeningMandiri;
}

public String getNamaRekeningMandiri(){
	return this.namaRekeningMandiri;
}

public void setNamaRekeningDapenbi(String namaRekeningDapenbi){
	this.namaRekeningDapenbi = namaRekeningDapenbi;
}

public String getNamaRekeningDapenbi(){
	return this.namaRekeningDapenbi;
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