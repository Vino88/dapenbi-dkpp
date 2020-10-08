package com.dapenbi.dkpp.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class TMutasiRekeningDto {
	private Long idMutasiRekening;
	private String periodeMutasi;
	private Date tglInput;
	private String nip;
	private String namaPeserta;
	private String idPenerimaMp;
	private String namaPenerimaMp;
	private String noRekeningLama;
	private String namaRekeningLama;
	private String namaKetPerubahanRekening;
	private String noRekeningBaru;
	private String namaRekeningBaru;
	private Long idJenisBank;
	private String jenisBank;
	private Long idValidasi;
	private String namaValidasi;
	private String userStamp;
	private String userValidasi;
	private Long idKategoriPenerimaMp;
	private String namaKategoriPenerimaMp;
	private String namaCabangBank;

public void setIdMutasiRekening(Long idMutasiRekening){
	this.idMutasiRekening = idMutasiRekening;
}

public Long getIdMutasiRekening(){
	return this.idMutasiRekening;
}

public void setPeriodeMutasi(String periodeMutasi){
	this.periodeMutasi = periodeMutasi;
}

public String getPeriodeMutasi(){
	return this.periodeMutasi;
}

public void setTglInput(Date tglInput){
	this.tglInput = tglInput;
}

public Date getTglInput(){
	return this.tglInput;
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

public void setNoRekeningLama(String noRekeningLama){
	this.noRekeningLama = noRekeningLama;
}

public String getNoRekeningLama(){
	return this.noRekeningLama;
}

public void setNamaRekeningLama(String namaRekeningLama){
	this.namaRekeningLama = namaRekeningLama;
}

public String getNamaRekeningLama(){
	return this.namaRekeningLama;
}

public void setNamaKetPerubahanRekening(String namaKetPerubahanRekening){
	this.namaKetPerubahanRekening = namaKetPerubahanRekening;
}

public String getNamaKetPerubahanRekening(){
	return this.namaKetPerubahanRekening;
}

public void setNoRekeningBaru(String noRekeningBaru){
	this.noRekeningBaru = noRekeningBaru;
}

public String getNoRekeningBaru(){
	return this.noRekeningBaru;
}

public void setNamaRekeningBaru(String namaRekeningBaru){
	this.namaRekeningBaru = namaRekeningBaru;
}

public String getNamaRekeningBaru(){
	return this.namaRekeningBaru;
}

public void setIdJenisBank(Long idJenisBank){
	this.idJenisBank = idJenisBank;
}

public Long getIdJenisBank(){
	return this.idJenisBank;
}

public void setJenisBank(String jenisBank){
	this.jenisBank = jenisBank;
}

public String getJenisBank(){
	return this.jenisBank;
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

public void setIdKategoriPenerimaMp(Long idKategoriPenerimaMp){
	this.idKategoriPenerimaMp = idKategoriPenerimaMp;
}

public Long getIdKategoriPenerimaMp(){
	return this.idKategoriPenerimaMp;
}

public void setNamaKategoriPenerimaMp(String namaKategoriPenerimaMp){
	this.namaKategoriPenerimaMp = namaKategoriPenerimaMp;
}

public String getNamaKategoriPenerimaMp(){
	return this.namaKategoriPenerimaMp;
}

public void setNamaCabangBank(String namaCabangBank){
	this.namaCabangBank = namaCabangBank;
}

public String getNamaCabangBank(){
	return this.namaCabangBank;
}



}