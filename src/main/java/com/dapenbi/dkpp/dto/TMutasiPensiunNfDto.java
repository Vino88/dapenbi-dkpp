package com.dapenbi.dkpp.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class TMutasiPensiunNfDto {
	private Long idMutasiNf;
	private String periodeMutasi;
	private Date tglMutasi;
	private String nip;
	private String namaPeserta;
	private String idPenerimaMp;
	private String namaPenerimaMp;
	private Date tglMeninggal;
	private String keterangan;
	private Long idValidasi;
	private Long idStatusBayar;
	private String namaValidasi;
	private String userStamp;
	private String userValidasi;

	public void setIdMutasiNf(Long idMutasiNf){
		this.idMutasiNf = idMutasiNf;
	}

	public Long getIdMutasiNf(){
		return this.idMutasiNf;
	}

	public void setPeriodeMutasi(String periodeMutasi){
		this.periodeMutasi = periodeMutasi;
	}

	public String getPeriodeMutasi(){
		return this.periodeMutasi;
	}

	public void setTglMutasi(Date tglMutasi){
		this.tglMutasi = tglMutasi;
	}

	public Date getTglMutasi(){
		return this.tglMutasi;
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

	public void setTglMeninggal(Date tglMeninggal){
		this.tglMeninggal = tglMeninggal;
	}

	public Date getTglMeninggal(){
		return this.tglMeninggal;
	}

	public void setKeterangan(String keterangan){
		this.keterangan = keterangan;
	}

	public String getKeterangan(){
		return this.keterangan;
	}

	public void setIdValidasi(Long idValidasi){
		this.idValidasi = idValidasi;
	}

	public Long getIdValidasi(){
		return this.idValidasi;
	}

	public Long getIdStatusBayar() {
		return idStatusBayar;
	}

	public void setIdStatusBayar(Long idStatusBayar) {
		this.idStatusBayar = idStatusBayar;
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