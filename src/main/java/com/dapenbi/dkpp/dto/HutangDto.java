package com.dapenbi.dkpp.dto;

import com.dapenbi.dkpp.model.RekeningPenerimaMp;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class HutangDto {
	private Long idHutang;
	private String nip;
	private String periodeMutasi;
	private String namaPeserta;
	private String idPenerimaMp;
	private String namaPenerimaMp;
	private String idKantorBayar;
	private String namaKantorBayar;
	private Long idGolongan;
	private String namaGolongan;
	private String namaJabatan;
	private BigDecimal totalHutang;
	private BigDecimal sudahDibayar;
	private BigDecimal sisaHutang;
	private String keterangan;
	private String userStamp;
	private String type;
	private String isProses;

	public Long getIdHutang() {
		return idHutang;
	}

	public void setIdHutang(Long idHutang) {
		this.idHutang = idHutang;
	}

	public RekeningPenerimaMp getRekeningPenerimaMp() {
		return rekeningPenerimaMp;
	}

	public void setRekeningPenerimaMp(RekeningPenerimaMp rekeningPenerimaMp) {
		this.rekeningPenerimaMp = rekeningPenerimaMp;
	}

	private RekeningPenerimaMp rekeningPenerimaMp;



	public void setNip(String nip){
		this.nip = nip;
	}

	public String getNip(){
		return this.nip;
	}

	public void setPeriodeMutasi(String periodeMutasi){
		this.periodeMutasi = periodeMutasi;
	}

	public String getPeriodeMutasi(){
		return this.periodeMutasi;
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

	public void setIdKantorBayar(String idKantorBayar){
		this.idKantorBayar = idKantorBayar;
	}

	public String getIdKantorBayar(){
		return this.idKantorBayar;
	}

	public void setNamaKantorBayar(String namaKantorBayar){
		this.namaKantorBayar = namaKantorBayar;
	}

	public String getNamaKantorBayar(){
		return this.namaKantorBayar;
	}

	public void setIdGolongan(Long idGolongan){
		this.idGolongan = idGolongan;
	}

	public Long getIdGolongan(){
		return this.idGolongan;
	}

	public void setNamaGolongan(String namaGolongan){
		this.namaGolongan = namaGolongan;
	}

	public String getNamaGolongan(){
		return this.namaGolongan;
	}

	public void setNamaJabatan(String namaJabatan){
		this.namaJabatan = namaJabatan;
	}

	public String getNamaJabatan(){
		return this.namaJabatan;
	}

	public void setTotalHutang(BigDecimal totalHutang){
		this.totalHutang = totalHutang;
	}

	public BigDecimal getTotalHutang(){
		return this.totalHutang;
	}

	public void setSudahDibayar(BigDecimal sudahDibayar){
		this.sudahDibayar = sudahDibayar;
	}

	public BigDecimal getSudahDibayar(){
		return this.sudahDibayar;
	}

	public void setSisaHutang(BigDecimal sisaHutang){
		this.sisaHutang = sisaHutang;
	}

	public BigDecimal getSisaHutang(){
		return this.sisaHutang;
	}

	public void setKeterangan(String keterangan){
		this.keterangan = keterangan;
	}

	public String getKeterangan(){
		return this.keterangan;
	}

	public void setUserStamp(String userStamp){
		this.userStamp = userStamp;
	}

	public String getUserStamp(){
		return this.userStamp;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return this.type;
	}

	public void setIsProses(String isProses){
		this.isProses = isProses;
	}

	public String getIsProses(){
		return this.isProses;
	}




}