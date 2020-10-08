package com.dapenbi.dkpp.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class MutasiKenaikanMpDto {
	private Long id;
	private String nip;
	private String periodeMutasi;
	private KenaikanMpDto idKenaikanMp;
	private Date tglMutasi;
	private String namaPeserta;
	private String jenisKelaminPeserta;
	private Date tglLahirPeserta;
	private Date tglMulaiKerja;
	private Date tglHentiKerja;
	private String usiaSaatHenti;
	private String masaKerjaTotal;
	private Long phdp;
	private String idPenerimaMp;
	private String namaPenerimaMp;
	private KategoriPenerimaDto idKategoriPenerimaMp;
	private String namaKategoriPenerimaMp;
	private Date tglLahirPenerimaMp;
	private String usiaPenerimaSaatDibayar;
	private Long mpBulananLama;
	private Long mpBulananBaru;
	private Long mpBulananRapel;
	private Long mps20persenLama;
	private Long mps20persenBaru;
	private Long mps20persenRapel;
	private Long mps10jutaLama;
	private Long mps10jutaBaru;
	private Long mps10jutaRapel;
	private Long mps100persenLama;
	private Long mps100persenBaru;
	private Long mps100persenRapel;
	private StatusValidasiDto idValidasi;
	private String namaValidasi;
	private String userValidasi;
	private KategoriCatatanDto idKategoriCatatan;
	private String namaKategoriCatatan;
	private String keterangan;
	private String userStamp;
	private KantorBayarDto idKantorBayar;
	private String namaKantorBayar;
	private KategoriPensiunDto idKategoriPensiun;
	private String namaKategoriPensiun;
	private JenisMpsDto idJenisMps;
	private String namaJenisMps;
	private Long kenaikanPersentase;
	private Long kenaikan;
	private Long mpBulan13Lama;
	private Long mpBulan13Baru;
	private Long mpBulan13Rapel;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public KenaikanMpDto getIdKenaikanMp() {
		return idKenaikanMp;
	}

	public void setIdKenaikanMp(KenaikanMpDto idKenaikanMp) {
		this.idKenaikanMp = idKenaikanMp;
	}

	public void setTglMutasi(Date tglMutasi){
	this.tglMutasi = tglMutasi;
}

public Date getTglMutasi(){
	return this.tglMutasi;
}

public void setNamaPeserta(String namaPeserta){
	this.namaPeserta = namaPeserta;
}

public String getNamaPeserta(){
	return this.namaPeserta;
}

public void setJenisKelaminPeserta(String jenisKelaminPeserta){
	this.jenisKelaminPeserta = jenisKelaminPeserta;
}

public String getJenisKelaminPeserta(){
	return this.jenisKelaminPeserta;
}

public void setTglLahirPeserta(Date tglLahirPeserta){
	this.tglLahirPeserta = tglLahirPeserta;
}

public Date getTglLahirPeserta(){
	return this.tglLahirPeserta;
}

public void setTglMulaiKerja(Date tglMulaiKerja){
	this.tglMulaiKerja = tglMulaiKerja;
}

public Date getTglMulaiKerja(){
	return this.tglMulaiKerja;
}

public void setTglHentiKerja(Date tglHentiKerja){
	this.tglHentiKerja = tglHentiKerja;
}

public Date getTglHentiKerja(){
	return this.tglHentiKerja;
}

public void setUsiaSaatHenti(String usiaSaatHenti){
	this.usiaSaatHenti = usiaSaatHenti;
}

public String getUsiaSaatHenti(){
	return this.usiaSaatHenti;
}

public void setMasaKerjaTotal(String masaKerjaTotal){
	this.masaKerjaTotal = masaKerjaTotal;
}

public String getMasaKerjaTotal(){
	return this.masaKerjaTotal;
}

public void setPhdp(Long phdp){
	this.phdp = phdp;
}

public Long getPhdp(){
	return this.phdp;
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

	public KategoriPenerimaDto getIdKategoriPenerimaMp() {
		return idKategoriPenerimaMp;
	}

	public void setIdKategoriPenerimaMp(KategoriPenerimaDto idKategoriPenerimaMp) {
		this.idKategoriPenerimaMp = idKategoriPenerimaMp;
	}

	public void setNamaKategoriPenerimaMp(String namaKategoriPenerimaMp){
	this.namaKategoriPenerimaMp = namaKategoriPenerimaMp;
}

public String getNamaKategoriPenerimaMp(){
	return this.namaKategoriPenerimaMp;
}

public void setTglLahirPenerimaMp(Date tglLahirPenerimaMp){
	this.tglLahirPenerimaMp = tglLahirPenerimaMp;
}

public Date getTglLahirPenerimaMp(){
	return this.tglLahirPenerimaMp;
}

public void setUsiaPenerimaSaatDibayar(String usiaPenerimaSaatDibayar){
	this.usiaPenerimaSaatDibayar = usiaPenerimaSaatDibayar;
}

public String getUsiaPenerimaSaatDibayar(){
	return this.usiaPenerimaSaatDibayar;
}

public void setMpBulananLama(Long mpBulananLama){
	this.mpBulananLama = mpBulananLama;
}

public Long getMpBulananLama(){
	return this.mpBulananLama;
}

public void setMpBulananBaru(Long mpBulananBaru){
	this.mpBulananBaru = mpBulananBaru;
}

public Long getMpBulananBaru(){
	return this.mpBulananBaru;
}

public void setMpBulananRapel(Long mpBulananRapel){
	this.mpBulananRapel = mpBulananRapel;
}

public Long getMpBulananRapel(){
	return this.mpBulananRapel;
}

public void setMps20persenLama(Long mps20persenLama){
	this.mps20persenLama = mps20persenLama;
}

public Long getMps20persenLama(){
	return this.mps20persenLama;
}

public void setMps20persenBaru(Long mps20persenBaru){
	this.mps20persenBaru = mps20persenBaru;
}

public Long getMps20persenBaru(){
	return this.mps20persenBaru;
}

public void setMps20persenRapel(Long mps20persenRapel){
	this.mps20persenRapel = mps20persenRapel;
}

public Long getMps20persenRapel(){
	return this.mps20persenRapel;
}

public void setMps10jutaLama(Long mps10jutaLama){
	this.mps10jutaLama = mps10jutaLama;
}

public Long getMps10jutaLama(){
	return this.mps10jutaLama;
}

public void setMps10jutaBaru(Long mps10jutaBaru){
	this.mps10jutaBaru = mps10jutaBaru;
}

public Long getMps10jutaBaru(){
	return this.mps10jutaBaru;
}

public void setMps10jutaRapel(Long mps10jutaRapel){
	this.mps10jutaRapel = mps10jutaRapel;
}

public Long getMps10jutaRapel(){
	return this.mps10jutaRapel;
}

public void setMps100persenLama(Long mps100persenLama){
	this.mps100persenLama = mps100persenLama;
}

public Long getMps100persenLama(){
	return this.mps100persenLama;
}

public void setMps100persenBaru(Long mps100persenBaru){
	this.mps100persenBaru = mps100persenBaru;
}

public Long getMps100persenBaru(){
	return this.mps100persenBaru;
}

public void setMps100persenRapel(Long mps100persenRapel){
	this.mps100persenRapel = mps100persenRapel;
}

public Long getMps100persenRapel(){
	return this.mps100persenRapel;
}

	public StatusValidasiDto getIdValidasi() {
		return idValidasi;
	}

	public void setIdValidasi(StatusValidasiDto idValidasi) {
		this.idValidasi = idValidasi;
	}

	public void setNamaValidasi(String namaValidasi){
	this.namaValidasi = namaValidasi;
}

public String getNamaValidasi(){
	return this.namaValidasi;
}

public void setUserValidasi(String userValidasi){
	this.userValidasi = userValidasi;
}

public String getUserValidasi(){
	return this.userValidasi;
}

	public KategoriCatatanDto getIdKategoriCatatan() {
		return idKategoriCatatan;
	}

	public void setIdKategoriCatatan(KategoriCatatanDto idKategoriCatatan) {
		this.idKategoriCatatan = idKategoriCatatan;
	}

	public void setNamaKategoriCatatan(String namaKategoriCatatan){
	this.namaKategoriCatatan = namaKategoriCatatan;
}

public String getNamaKategoriCatatan(){
	return this.namaKategoriCatatan;
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

	public KantorBayarDto getIdKantorBayar() {
		return idKantorBayar;
	}

	public void setIdKantorBayar(KantorBayarDto idKantorBayar) {
		this.idKantorBayar = idKantorBayar;
	}

	public void setNamaKantorBayar(String namaKantorBayar){
	this.namaKantorBayar = namaKantorBayar;
}

public String getNamaKantorBayar(){
	return this.namaKantorBayar;
}

	public KategoriPensiunDto getIdKategoriPensiun() {
		return idKategoriPensiun;
	}

	public void setIdKategoriPensiun(KategoriPensiunDto idKategoriPensiun) {
		this.idKategoriPensiun = idKategoriPensiun;
	}

	public void setNamaKategoriPensiun(String namaKategoriPensiun){
	this.namaKategoriPensiun = namaKategoriPensiun;
}

public String getNamaKategoriPensiun(){
	return this.namaKategoriPensiun;
}

	public JenisMpsDto getIdJenisMps() {
		return idJenisMps;
	}

	public void setIdJenisMps(JenisMpsDto idJenisMps) {
		this.idJenisMps = idJenisMps;
	}

	public void setNamaJenisMps(String namaJenisMps){
	this.namaJenisMps = namaJenisMps;
}

public String getNamaJenisMps(){
	return this.namaJenisMps;
}

public void setKenaikanPersentase(Long kenaikanPersentase){
	this.kenaikanPersentase = kenaikanPersentase;
}

public Long getKenaikanPersentase(){
	return this.kenaikanPersentase;
}

public void setKenaikan(Long kenaikan){
	this.kenaikan = kenaikan;
}

public Long getKenaikan(){
	return this.kenaikan;
}

public void setMpBulan13Lama(Long mpBulan13Lama){
	this.mpBulan13Lama = mpBulan13Lama;
}

public Long getMpBulan13Lama(){
	return this.mpBulan13Lama;
}

public void setMpBulan13Baru(Long mpBulan13Baru){
	this.mpBulan13Baru = mpBulan13Baru;
}

public Long getMpBulan13Baru(){
	return this.mpBulan13Baru;
}

public void setMpBulan13Rapel(Long mpBulan13Rapel){
	this.mpBulan13Rapel = mpBulan13Rapel;
}

public Long getMpBulan13Rapel(){
	return this.mpBulan13Rapel;
}



}