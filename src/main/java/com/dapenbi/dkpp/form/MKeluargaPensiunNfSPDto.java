package com.dapenbi.dkpp.form;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class MKeluargaPensiunNfSPDto extends BaseFormDto  {
	private Long idKeluarga;
	private String nip;
	private String nama;
	private String tempatLahir;
	private Date tglLahir;
	private Character jenisKelamin;
	private String hubungan;
	private String userStamp;

public void setIdKeluarga(Long idKeluarga){
	this.idKeluarga = idKeluarga;
}

public Long getIdKeluarga(){
	return this.idKeluarga;
}

public void setNip(String nip){
	this.nip = nip;
}

public String getNip(){
	return this.nip;
}

public void setNama(String nama){
	this.nama = nama;
}

public String getNama(){
	return this.nama;
}

public void setTempatLahir(String tempatLahir){
	this.tempatLahir = tempatLahir;
}

public String getTempatLahir(){
	return this.tempatLahir;
}

public void setTglLahir(Date tglLahir){
	this.tglLahir = tglLahir;
}

public Date getTglLahir(){
	return this.tglLahir;
}

public void setJenisKelamin(Character jenisKelamin){
	this.jenisKelamin = jenisKelamin;
}

public Character getJenisKelamin(){
	return this.jenisKelamin;
}

public void setHubungan(String hubungan){
	this.hubungan = hubungan;
}

public String getHubungan(){
	return this.hubungan;
}

public void setUserStamp(String userStamp){
	this.userStamp = userStamp;
}

public String getUserStamp(){
	return this.userStamp;
}



}