package com.dapenbi.dkpp.form;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class MKeluargaPensiunNfPlainDto {
	private String idKeluarga;
	private String nip;
	private String nama;
	private String tempatLahir;
	private String tglLahir;
	private String jenisKelamin;
	private String hubungan;
	private String userStamp;

public void setIdKeluarga(String idKeluarga){
	this.idKeluarga = idKeluarga;
}

public String getIdKeluarga(){
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

public void setTglLahir(String tglLahir){
	this.tglLahir = tglLahir;
}

public String getTglLahir(){
	return this.tglLahir;
}

public void setJenisKelamin(String jenisKelamin){
	this.jenisKelamin = jenisKelamin;
}

public String getJenisKelamin(){
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