package com.dapenbi.dkpp.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class MutasiPerubahanFprFsDto {
	private Long id;
	private Date tglMutasi;
	private String periodeMutasi;
	private String nip;
	private String namaPeserta;
	private Character jenisKelamin;
	private Date tglLahir;
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
	private String usiaPenerimaBayar;
	private Long mpydLama;
	private Long mpydBaru;
	private Long kurangBayarMpyd;
	private Long lebihBayarMpyd;
	private Long mps20persenLama;
	private Long mps20persenBaru;
	private Long kurangBayarMps20persen;
	private Long lebihBayarMps20persen;
	private Long mps10jtLama;
	private Long mps10jtBaru;
	private Long kurangBayarMps10jt;
	private Long lebihBayarMps10jut;
	private Long mps100persenLama;
	private Long mps100persenBaru;
	private Long kurangBayarMps100persen;
	private Long lebihBayarMps100persen;
	private Double nilaiFsLama;
	private Double nilaiFsBaru;
	private Double nilaiFprLama;
	private Double nilaiFprBaru;
	private KategoriCatatanDto idKategoriCatatan;
	private String namaKategoriCatatan;
	private String keterangan;
	private StatusValidasiDto idValidasi;
	private String namaValidasi;
	private String userValidasi;
	private String userStamp;
	private FaktorFprDto idFaktorFprLama;
	private FaktorFprDto idFaktorFprBaru;
	private String namaFaktorFprLama;
	private String namaFaktorFprBaru;
	private String faktorFsLama;
	private String faktorFsBaru;
	private FaktorFsDto idFaktorFsLama;
	private FaktorFsDto idFaktorFsBaru;
	private String namaFaktorFsLama;
	private String namaFaktorFsBaru;
	private Date tglDptht;
	private Date tglAwalBayar;
	private KategoriPensiunDto idKategoriPensiun;
	private JenisMpsDto idJenisMps;
	private StatusKawinDto idStatusKawinPenerimaMp;
	private UsiaBayarDto idUsiaBayar;
	private String namaKategoriPensiun;
	private String namaJenisMps;
	private String namaStatusKawinPenerimaMp;
	private String namaUsiaBayar;
	private String usiaSaatHentiBulat;
	private String usiaPenerimaBayarBulat;
	private String masaKerjaTotalBulat;
	private String masaKerjaTambahan;
	private String masaKerjaTambahanBulat;
	private String masaKerjaVeteran;
	private String masaKerjaVeteranBulat;
	private String masaKerjaHenti;
	private String masaKerjaHentiBulat;
	private String masaKerjaTotalAdj;
	private String masaKerjaTotalAdjBulat;
	private String masaKerjaMp;
	private String statusFs;
	private Long mpPerbulanRumus;
	private Long mpPerbulanRumusBaru;
	private Long mpPerbulan20persen;
	private Long mpPerbulan10juta;
	private Long mpBulan13;
	private StatusBayarDto idStatusBayar;
	private String namaKantorBayar;
	private KantorBayarDto idKantorBayar;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTglMutasi(Date tglMutasi){
	this.tglMutasi = tglMutasi;
}

public Date getTglMutasi(){
	return this.tglMutasi;
}

public void setPeriodeMutasi(String periodeMutasi){
	this.periodeMutasi = periodeMutasi;
}

public String getPeriodeMutasi(){
	return this.periodeMutasi;
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

public void setJenisKelamin(Character jenisKelamin){
	this.jenisKelamin = jenisKelamin;
}

public Character getJenisKelamin(){
	return this.jenisKelamin;
}

public void setTglLahir(Date tglLahir){
	this.tglLahir = tglLahir;
}

public Date getTglLahir(){
	return this.tglLahir;
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

public void setUsiaPenerimaBayar(String usiaPenerimaBayar){
	this.usiaPenerimaBayar = usiaPenerimaBayar;
}

public String getUsiaPenerimaBayar(){
	return this.usiaPenerimaBayar;
}

public void setMpydLama(Long mpydLama){
	this.mpydLama = mpydLama;
}

public Long getMpydLama(){
	return this.mpydLama;
}

public void setMpydBaru(Long mpydBaru){
	this.mpydBaru = mpydBaru;
}

public Long getMpydBaru(){
	return this.mpydBaru;
}

public void setKurangBayarMpyd(Long kurangBayarMpyd){
	this.kurangBayarMpyd = kurangBayarMpyd;
}

public Long getKurangBayarMpyd(){
	return this.kurangBayarMpyd;
}

public void setLebihBayarMpyd(Long lebihBayarMpyd){
	this.lebihBayarMpyd = lebihBayarMpyd;
}

public Long getLebihBayarMpyd(){
	return this.lebihBayarMpyd;
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

public void setKurangBayarMps20persen(Long kurangBayarMps20persen){
	this.kurangBayarMps20persen = kurangBayarMps20persen;
}

public Long getKurangBayarMps20persen(){
	return this.kurangBayarMps20persen;
}

public void setLebihBayarMps20persen(Long lebihBayarMps20persen){
	this.lebihBayarMps20persen = lebihBayarMps20persen;
}

public Long getLebihBayarMps20persen(){
	return this.lebihBayarMps20persen;
}

public void setMps10jtLama(Long mps10jtLama){
	this.mps10jtLama = mps10jtLama;
}

public Long getMps10jtLama(){
	return this.mps10jtLama;
}

public void setMps10jtBaru(Long mps10jtBaru){
	this.mps10jtBaru = mps10jtBaru;
}

public Long getMps10jtBaru(){
	return this.mps10jtBaru;
}

public void setKurangBayarMps10jt(Long kurangBayarMps10jt){
	this.kurangBayarMps10jt = kurangBayarMps10jt;
}

public Long getKurangBayarMps10jt(){
	return this.kurangBayarMps10jt;
}

public void setLebihBayarMps10jut(Long lebihBayarMps10jut){
	this.lebihBayarMps10jut = lebihBayarMps10jut;
}

public Long getLebihBayarMps10jut(){
	return this.lebihBayarMps10jut;
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

public void setKurangBayarMps100persen(Long kurangBayarMps100persen){
	this.kurangBayarMps100persen = kurangBayarMps100persen;
}

public Long getKurangBayarMps100persen(){
	return this.kurangBayarMps100persen;
}

public void setLebihBayarMps100persen(Long lebihBayarMps100persen){
	this.lebihBayarMps100persen = lebihBayarMps100persen;
}

public Long getLebihBayarMps100persen(){
	return this.lebihBayarMps100persen;
}

	public Double getNilaiFsLama() {
		return nilaiFsLama;
	}

	public void setNilaiFsLama(Double nilaiFsLama) {
		this.nilaiFsLama = nilaiFsLama;
	}

	public Double getNilaiFsBaru() {
		return nilaiFsBaru;
	}

	public void setNilaiFsBaru(Double nilaiFsBaru) {
		this.nilaiFsBaru = nilaiFsBaru;
	}

	public Double getNilaiFprLama() {
		return nilaiFprLama;
	}

	public void setNilaiFprLama(Double nilaiFprLama) {
		this.nilaiFprLama = nilaiFprLama;
	}

	public Double getNilaiFprBaru() {
		return nilaiFprBaru;
	}

	public void setNilaiFprBaru(Double nilaiFprBaru) {
		this.nilaiFprBaru = nilaiFprBaru;
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

public void setUserStamp(String userStamp){
	this.userStamp = userStamp;
}

public String getUserStamp(){
	return this.userStamp;
}

	public FaktorFprDto getIdFaktorFprLama() {
		return idFaktorFprLama;
	}

	public void setIdFaktorFprLama(FaktorFprDto idFaktorFprLama) {
		this.idFaktorFprLama = idFaktorFprLama;
	}

	public FaktorFprDto getIdFaktorFprBaru() {
		return idFaktorFprBaru;
	}

	public void setIdFaktorFprBaru(FaktorFprDto idFaktorFprBaru) {
		this.idFaktorFprBaru = idFaktorFprBaru;
	}

	public void setNamaFaktorFprLama(String namaFaktorFprLama){
	this.namaFaktorFprLama = namaFaktorFprLama;
}

public String getNamaFaktorFprLama(){
	return this.namaFaktorFprLama;
}

public void setNamaFaktorFprBaru(String namaFaktorFprBaru){
	this.namaFaktorFprBaru = namaFaktorFprBaru;
}

public String getNamaFaktorFprBaru(){
	return this.namaFaktorFprBaru;
}

public void setFaktorFsLama(String faktorFsLama){
	this.faktorFsLama = faktorFsLama;
}

public String getFaktorFsLama(){
	return this.faktorFsLama;
}

public void setFaktorFsBaru(String faktorFsBaru){
	this.faktorFsBaru = faktorFsBaru;
}

public String getFaktorFsBaru(){
	return this.faktorFsBaru;
}

	public FaktorFsDto getIdFaktorFsLama() {
		return idFaktorFsLama;
	}

	public void setIdFaktorFsLama(FaktorFsDto idFaktorFsLama) {
		this.idFaktorFsLama = idFaktorFsLama;
	}

	public FaktorFsDto getIdFaktorFsBaru() {
		return idFaktorFsBaru;
	}

	public void setIdFaktorFsBaru(FaktorFsDto idFaktorFsBaru) {
		this.idFaktorFsBaru = idFaktorFsBaru;
	}

	public void setNamaFaktorFsLama(String namaFaktorFsLama){
	this.namaFaktorFsLama = namaFaktorFsLama;
}

public String getNamaFaktorFsLama(){
	return this.namaFaktorFsLama;
}

public void setNamaFaktorFsBaru(String namaFaktorFsBaru){
	this.namaFaktorFsBaru = namaFaktorFsBaru;
}

public String getNamaFaktorFsBaru(){
	return this.namaFaktorFsBaru;
}

public void setTglDptht(Date tglDptht){
	this.tglDptht = tglDptht;
}

public Date getTglDptht(){
	return this.tglDptht;
}

public void setTglAwalBayar(Date tglAwalBayar){
	this.tglAwalBayar = tglAwalBayar;
}

public Date getTglAwalBayar(){
	return this.tglAwalBayar;
}

	public KategoriPensiunDto getIdKategoriPensiun() {
		return idKategoriPensiun;
	}

	public void setIdKategoriPensiun(KategoriPensiunDto idKategoriPensiun) {
		this.idKategoriPensiun = idKategoriPensiun;
	}

	public JenisMpsDto getIdJenisMps() {
		return idJenisMps;
	}

	public void setIdJenisMps(JenisMpsDto idJenisMps) {
		this.idJenisMps = idJenisMps;
	}

	public StatusKawinDto getIdStatusKawinPenerimaMp() {
		return idStatusKawinPenerimaMp;
	}

	public void setIdStatusKawinPenerimaMp(StatusKawinDto idStatusKawinPenerimaMp) {
		this.idStatusKawinPenerimaMp = idStatusKawinPenerimaMp;
	}

	public UsiaBayarDto getIdUsiaBayar() {
		return idUsiaBayar;
	}

	public void setIdUsiaBayar(UsiaBayarDto idUsiaBayar) {
		this.idUsiaBayar = idUsiaBayar;
	}

	public void setNamaKategoriPensiun(String namaKategoriPensiun){
	this.namaKategoriPensiun = namaKategoriPensiun;
}

public String getNamaKategoriPensiun(){
	return this.namaKategoriPensiun;
}

public void setNamaJenisMps(String namaJenisMps){
	this.namaJenisMps = namaJenisMps;
}

public String getNamaJenisMps(){
	return this.namaJenisMps;
}

public void setNamaStatusKawinPenerimaMp(String namaStatusKawinPenerimaMp){
	this.namaStatusKawinPenerimaMp = namaStatusKawinPenerimaMp;
}

public String getNamaStatusKawinPenerimaMp(){
	return this.namaStatusKawinPenerimaMp;
}

public void setNamaUsiaBayar(String namaUsiaBayar){
	this.namaUsiaBayar = namaUsiaBayar;
}

public String getNamaUsiaBayar(){
	return this.namaUsiaBayar;
}

public void setUsiaSaatHentiBulat(String usiaSaatHentiBulat){
	this.usiaSaatHentiBulat = usiaSaatHentiBulat;
}

public String getUsiaSaatHentiBulat(){
	return this.usiaSaatHentiBulat;
}

public void setUsiaPenerimaBayarBulat(String usiaPenerimaBayarBulat){
	this.usiaPenerimaBayarBulat = usiaPenerimaBayarBulat;
}

public String getUsiaPenerimaBayarBulat(){
	return this.usiaPenerimaBayarBulat;
}

public void setMasaKerjaTotalBulat(String masaKerjaTotalBulat){
	this.masaKerjaTotalBulat = masaKerjaTotalBulat;
}

public String getMasaKerjaTotalBulat(){
	return this.masaKerjaTotalBulat;
}

public void setMasaKerjaTambahan(String masaKerjaTambahan){
	this.masaKerjaTambahan = masaKerjaTambahan;
}

public String getMasaKerjaTambahan(){
	return this.masaKerjaTambahan;
}

public void setMasaKerjaTambahanBulat(String masaKerjaTambahanBulat){
	this.masaKerjaTambahanBulat = masaKerjaTambahanBulat;
}

public String getMasaKerjaTambahanBulat(){
	return this.masaKerjaTambahanBulat;
}

public void setMasaKerjaVeteran(String masaKerjaVeteran){
	this.masaKerjaVeteran = masaKerjaVeteran;
}

public String getMasaKerjaVeteran(){
	return this.masaKerjaVeteran;
}

public void setMasaKerjaVeteranBulat(String masaKerjaVeteranBulat){
	this.masaKerjaVeteranBulat = masaKerjaVeteranBulat;
}

public String getMasaKerjaVeteranBulat(){
	return this.masaKerjaVeteranBulat;
}

public void setMasaKerjaHenti(String masaKerjaHenti){
	this.masaKerjaHenti = masaKerjaHenti;
}

public String getMasaKerjaHenti(){
	return this.masaKerjaHenti;
}

public void setMasaKerjaHentiBulat(String masaKerjaHentiBulat){
	this.masaKerjaHentiBulat = masaKerjaHentiBulat;
}

public String getMasaKerjaHentiBulat(){
	return this.masaKerjaHentiBulat;
}

public void setMasaKerjaTotalAdj(String masaKerjaTotalAdj){
	this.masaKerjaTotalAdj = masaKerjaTotalAdj;
}

public String getMasaKerjaTotalAdj(){
	return this.masaKerjaTotalAdj;
}

public void setMasaKerjaTotalAdjBulat(String masaKerjaTotalAdjBulat){
	this.masaKerjaTotalAdjBulat = masaKerjaTotalAdjBulat;
}

public String getMasaKerjaTotalAdjBulat(){
	return this.masaKerjaTotalAdjBulat;
}

public void setMasaKerjaMp(String masaKerjaMp){
	this.masaKerjaMp = masaKerjaMp;
}

public String getMasaKerjaMp(){
	return this.masaKerjaMp;
}

public void setStatusFs(String statusFs){
	this.statusFs = statusFs;
}

public String getStatusFs(){
	return this.statusFs;
}

public void setMpPerbulanRumus(Long mpPerbulanRumus){
	this.mpPerbulanRumus = mpPerbulanRumus;
}

public Long getMpPerbulanRumus(){
	return this.mpPerbulanRumus;
}

public void setMpPerbulan20persen(Long mpPerbulan20persen){
	this.mpPerbulan20persen = mpPerbulan20persen;
}

public Long getMpPerbulan20persen(){
	return this.mpPerbulan20persen;
}

public void setMpPerbulan10juta(Long mpPerbulan10juta){
	this.mpPerbulan10juta = mpPerbulan10juta;
}

public Long getMpPerbulan10juta(){
	return this.mpPerbulan10juta;
}

public void setMpBulan13(Long mpBulan13){
	this.mpBulan13 = mpBulan13;
}

public Long getMpBulan13(){
	return this.mpBulan13;
}

	public StatusBayarDto getIdStatusBayar() {
		return idStatusBayar;
	}

	public void setIdStatusBayar(StatusBayarDto idStatusBayar) {
		this.idStatusBayar = idStatusBayar;
	}

	public void setNamaKantorBayar(String namaKantorBayar){
	this.namaKantorBayar = namaKantorBayar;
}

public String getNamaKantorBayar(){
	return this.namaKantorBayar;
}

	public KantorBayarDto getIdKantorBayar() {
		return idKantorBayar;
	}

	public void setIdKantorBayar(KantorBayarDto idKantorBayar) {
		this.idKantorBayar = idKantorBayar;
	}

	public Long getMpPerbulanRumusBaru() {
		return mpPerbulanRumusBaru;
	}

	public void setMpPerbulanRumusBaru(Long mpPerbulanRumusBaru) {
		this.mpPerbulanRumusBaru = mpPerbulanRumusBaru;
	}
}