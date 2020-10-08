package com.dapenbi.dkpp.model;

import javax.persistence.*;
import com.dapenbi.dkpp.dto.MutasiPerubahanFprFsDto;
import java.util.Date;

@Entity
@Table(name = "TBL_T_MUTASI_PERUBAHAN_FPR_FS")
@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(
				name="MutasiPensiun.processCuspMutasiPerubahanFprFs",
				procedureName="CUSP_MUTASI_PERUBAHAN_FPR_FS",
				parameters = {
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name= "PAR_ROLE_ID"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_COMP_NAME"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_USER_NAME"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name= "PAR_TGL_MUTASI"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_PERIODE_MUTASI"),
						@StoredProcedureParameter(mode = ParameterMode.OUT, type = Character.class, name= "PAR_STATUS_EKSEKUSI"),
						@StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name= "PAR_MSG")
				}
		),
		@NamedStoredProcedureQuery(
				name="MutasiPensiun.processCuspMutasiPrbhnFprFsUpd",
				procedureName="CUSP_MUTASI_PRBHN_FPR_FS_UPD",
				parameters = {
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name= "PAR_ROLE_ID"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_USER_NAME"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_COMP_NAME"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name= "PAR_ID_MUTASI"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_PERIODE_MUTASI"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name= "PAR_TGL_MUTASI"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_KETERANGAN"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name= "PAR_ID_KATEGORI_CATATAN"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_NAMA_KATEGORI_CATATAN"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name= "PAR_ID_VALIDASI"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_NAMA_VALIDASI"),
						@StoredProcedureParameter(mode = ParameterMode.OUT, type = Character.class, name= "PAR_STATUS_EKSEKUSI"),
						@StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name= "PAR_MSG")
				}
		)
})
public class MutasiPerubahanFprFs extends BaseModel<MutasiPerubahanFprFsDto>{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MUTASI_FPRFS_SEQ")
	@SequenceGenerator(sequenceName = "mutasiFprFs_seq", allocationSize = 1, name = "MUTASI_FPRFS_SEQ")
	@Column(name = "ID_MUTASI", length = 22)
	private Long id;

	@Column(name = "TGL_MUTASI", length = 7)
	private Date tglMutasi;

	@Column(name = "PERIODE_MUTASI", length = 6)
	private String periodeMutasi;

	@Column(name = "NIP", length = 50)
	private String nip;

	@Column(name = "NAMA_PESERTA", length = 100)
	private String namaPeserta;

	@Column(name = "JENIS_KELAMIN", length = 1)
	private Character jenisKelamin;

	@Column(name = "TGL_LAHIR", length = 7)
	private Date tglLahir;

	@Column(name = "TGL_MULAI_KERJA", length = 7)
	private Date tglMulaiKerja;

	@Column(name = "TGL_HENTI_KERJA", length = 7)
	private Date tglHentiKerja;

	@Column(name = "USIA_SAAT_HENTI", length = 4)
	private String usiaSaatHenti;

	@Column(name = "MASA_KERJA_TOTAL", length = 4)
	private String masaKerjaTotal;

	@Column(name = "PHDP", length = 22)
	private Long phdp;

	@Column(name = "ID_PENERIMA_MP", length = 50)
	private String idPenerimaMp;

	@Column(name = "NAMA_PENERIMA_MP", length = 100)
	private String namaPenerimaMp;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_KATEGORI_PENERIMA_MP")
	private KategoriPenerima idKategoriPenerimaMp;

	@Column(name = "NAMA_KATEGORI_PENERIMA_MP", length = 100)
	private String namaKategoriPenerimaMp;

	@Column(name = "TGL_LAHIR_PENERIMA_MP", length = 7)
	private Date tglLahirPenerimaMp;

	@Column(name = "USIA_PENERIMA_BAYAR", length = 4)
	private String usiaPenerimaBayar;

	@Column(name = "MPYD_LAMA", length = 22)
	private Long mpydLama;

	@Column(name = "MPYD_BARU", length = 22)
	private Long mpydBaru;

	@Column(name = "KURANG_BAYAR_MPYD", length = 22)
	private Long kurangBayarMpyd;

	@Column(name = "LEBIH_BAYAR_MPYD", length = 22)
	private Long lebihBayarMpyd;

	@Column(name = "MPS_20PERSEN_LAMA", length = 22)
	private Long mps20persenLama;

	@Column(name = "MPS_20PERSEN_BARU", length = 22)
	private Long mps20persenBaru;

	@Column(name = "KURANG_BAYAR_MPS_20PERSEN", length = 22)
	private Long kurangBayarMps20persen;

	@Column(name = "LEBIH_BAYAR_MPS_20PERSEN", length = 22)
	private Long lebihBayarMps20persen;

	@Column(name = "MPS_10JT_LAMA", length = 22)
	private Long mps10jtLama;

	@Column(name = "MPS_10JT_BARU", length = 22)
	private Long mps10jtBaru;

	@Column(name = "KURANG_BAYAR_MPS_10JT", length = 22)
	private Long kurangBayarMps10jt;

	@Column(name = "LEBIH_BAYAR_MPS_10JUT", length = 22)
	private Long lebihBayarMps10jut;

	@Column(name = "MPS_100PERSEN_LAMA", length = 22)
	private Long mps100persenLama;

	@Column(name = "MPS_100PERSEN_BARU", length = 22)
	private Long mps100persenBaru;

	@Column(name = "KURANG_BAYAR_MPS_100PERSEN", length = 22)
	private Long kurangBayarMps100persen;

	@Column(name = "LEBIH_BAYAR_MPS_100PERSEN", length = 22)
	private Long lebihBayarMps100persen;

	@Column(name = "NILAI_FS_LAMA", length = 22)
	private Double nilaiFsLama;

	@Column(name = "NILAI_FS_BARU", length = 22)
	private Double nilaiFsBaru;

	@Column(name = "NILAI_FPR_LAMA", length = 22)
	private Double nilaiFprLama;

	@Column(name = "NILAI_FPR_BARU", length = 22)
	private Double nilaiFprBaru;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_KATEGORI_CATATAN")
	private KategoriCatatan idKategoriCatatan;

	@Column(name = "NAMA_KATEGORI_CATATAN", length = 100)
	private String namaKategoriCatatan;

	@Column(name = "KETERANGAN", length = 500)
	private String keterangan;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_VALIDASI")
	private StatusValidasi idValidasi;

	@Column(name = "NAMA_VALIDASI", length = 100)
	private String namaValidasi;

	@Column(name = "USER_VALIDASI", length = 100)
	private String userValidasi;

	@Column(name = "USER_STAMP", length = 100)
	private String userStamp;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_FAKTOR_FPR_LAMA")
	private FaktorFPR idFaktorFprLama;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_FAKTOR_FPR_BARU")
	private FaktorFPR idFaktorFprBaru;

	@Column(name = "NAMA_FAKTOR_FPR_LAMA", length = 100)
	private String namaFaktorFprLama;

	@Column(name = "NAMA_FAKTOR_FPR_BARU", length = 100)
	private String namaFaktorFprBaru;

	@Column(name = "FAKTOR_FS_LAMA", length = 50)
	private String faktorFsLama;

	@Column(name = "FAKTOR_FS_BARU", length = 50)
	private String faktorFsBaru;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_FAKTOR_FS_LAMA")
	private FaktorFs idFaktorFsLama;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_FAKTOR_FS_BARU")
	private FaktorFs idFaktorFsBaru;

	@Column(name = "NAMA_FAKTOR_FS_LAMA", length = 100)
	private String namaFaktorFsLama;

	@Column(name = "NAMA_FAKTOR_FS_BARU", length = 100)
	private String namaFaktorFsBaru;

	@Column(name = "TGL_DPTHT", length = 7)
	private Date tglDptht;

	@Column(name = "TGL_AWAL_BAYAR", length = 7)
	private Date tglAwalBayar;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_KATEGORI_PENSIUN")
	private KategoriPensiun idKategoriPensiun;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_JENIS_MPS")
	private JenisMps idJenisMps;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_STATUS_KAWIN_PENERIMA_MP")
	private StatusKawin idStatusKawinPenerimaMp;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_USIA_BAYAR")
	private UsiaBayar idUsiaBayar;

	@Column(name = "NAMA_KATEGORI_PENSIUN", length = 100)
	private String namaKategoriPensiun;

	@Column(name = "NAMA_JENIS_MPS", length = 100)
	private String namaJenisMps;

	@Column(name = "NAMA_STATUS_KAWIN_PENERIMA_MP", length = 100)
	private String namaStatusKawinPenerimaMp;

	@Column(name = "NAMA_USIA_BAYAR", length = 100)
	private String namaUsiaBayar;

	@Column(name = "USIA_SAAT_HENTI_BULAT", length = 4)
	private String usiaSaatHentiBulat;

	@Column(name = "USIA_PENERIMA_BAYAR_BULAT", length = 4)
	private String usiaPenerimaBayarBulat;

	@Column(name = "MASA_KERJA_TOTAL_BULAT", length = 4)
	private String masaKerjaTotalBulat;

	@Column(name = "MASA_KERJA_TAMBAHAN", length = 6)
	private String masaKerjaTambahan;

	@Column(name = "MASA_KERJA_TAMBAHAN_BULAT", length = 4)
	private String masaKerjaTambahanBulat;

	@Column(name = "MASA_KERJA_VETERAN", length = 6)
	private String masaKerjaVeteran;

	@Column(name = "MASA_KERJA_VETERAN_BULAT", length = 4)
	private String masaKerjaVeteranBulat;

	@Column(name = "MASA_KERJA_HENTI", length = 6)
	private String masaKerjaHenti;

	@Column(name = "MASA_KERJA_HENTI_BULAT", length = 4)
	private String masaKerjaHentiBulat;

	@Column(name = "MASA_KERJA_TOTAL_ADJ", length = 6)
	private String masaKerjaTotalAdj;

	@Column(name = "MASA_KERJA_TOTAL_ADJ_BULAT", length = 4)
	private String masaKerjaTotalAdjBulat;

	@Column(name = "MASA_KERJA_MP", length = 4)
	private String masaKerjaMp;

	@Column(name = "STATUS_FS", length = 100)
	private String statusFs;

	@Column(name = "MP_PERBULAN_RUMUS", length = 22)
	private Long mpPerbulanRumus;

	@Column(name = "MP_PERBULAN_RUMUS_BARU", length = 22)
	private Long mpPerbulanRumusBaru;

	@Column(name = "MP_PERBULAN_20PERSEN", length = 22)
	private Long mpPerbulan20persen;

	@Column(name = "MP_PERBULAN_10JUTA", length = 22)
	private Long mpPerbulan10juta;

	@Column(name = "MP_BULAN13", length = 22)
	private Long mpBulan13;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_STATUS_BAYAR")
	private StatusBayar idStatusBayar;

	@Column(name = "NAMA_KANTOR_BAYAR", length = 50)
	private String namaKantorBayar;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_KANTOR_BAYAR")
	private KantorBayar idKantorBayar;

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

	public KategoriPenerima getIdKategoriPenerimaMp() {
		return idKategoriPenerimaMp;
	}

	public void setIdKategoriPenerimaMp(KategoriPenerima idKategoriPenerimaMp) {
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

	public KategoriCatatan getIdKategoriCatatan() {
		return idKategoriCatatan;
	}

	public void setIdKategoriCatatan(KategoriCatatan idKategoriCatatan) {
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

	public StatusValidasi getIdValidasi() {
		return idValidasi;
	}

	public void setIdValidasi(StatusValidasi idValidasi) {
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

	public FaktorFPR getIdFaktorFprLama() {
		return idFaktorFprLama;
	}

	public void setIdFaktorFprLama(FaktorFPR idFaktorFprLama) {
		this.idFaktorFprLama = idFaktorFprLama;
	}

	public FaktorFPR getIdFaktorFprBaru() {
		return idFaktorFprBaru;
	}

	public void setIdFaktorFprBaru(FaktorFPR idFaktorFprBaru) {
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

	public FaktorFs getIdFaktorFsLama() {
		return idFaktorFsLama;
	}

	public void setIdFaktorFsLama(FaktorFs idFaktorFsLama) {
		this.idFaktorFsLama = idFaktorFsLama;
	}

	public FaktorFs getIdFaktorFsBaru() {
		return idFaktorFsBaru;
	}

	public void setIdFaktorFsBaru(FaktorFs idFaktorFsBaru) {
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

	public KategoriPensiun getIdKategoriPensiun() {
		return idKategoriPensiun;
	}

	public void setIdKategoriPensiun(KategoriPensiun idKategoriPensiun) {
		this.idKategoriPensiun = idKategoriPensiun;
	}

	public JenisMps getIdJenisMps() {
		return idJenisMps;
	}

	public void setIdJenisMps(JenisMps idJenisMps) {
		this.idJenisMps = idJenisMps;
	}

	public StatusKawin getIdStatusKawinPenerimaMp() {
		return idStatusKawinPenerimaMp;
	}

	public void setIdStatusKawinPenerimaMp(StatusKawin idStatusKawinPenerimaMp) {
		this.idStatusKawinPenerimaMp = idStatusKawinPenerimaMp;
	}

	public UsiaBayar getIdUsiaBayar() {
		return idUsiaBayar;
	}

	public void setIdUsiaBayar(UsiaBayar idUsiaBayar) {
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

	public Long getMpPerbulanRumusBaru() {
		return mpPerbulanRumusBaru;
	}

	public void setMpPerbulanRumusBaru(Long mpPerbulanRumusBaru) {
		this.mpPerbulanRumusBaru = mpPerbulanRumusBaru;
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

	public StatusBayar getIdStatusBayar() {
		return idStatusBayar;
	}

	public void setIdStatusBayar(StatusBayar idStatusBayar) {
		this.idStatusBayar = idStatusBayar;
	}

	public void setNamaKantorBayar(String namaKantorBayar){
	this.namaKantorBayar = namaKantorBayar;
}

public String getNamaKantorBayar(){
	return this.namaKantorBayar;
}

	public KantorBayar getIdKantorBayar() {
		return idKantorBayar;
	}

	public void setIdKantorBayar(KantorBayar idKantorBayar) {
		this.idKantorBayar = idKantorBayar;
	}

	@Override
public void fromDto(MutasiPerubahanFprFsDto dto){
	this.setId( dto.getId() );
	this.setTglMutasi( dto.getTglMutasi() );
	this.setPeriodeMutasi( dto.getPeriodeMutasi() );
	this.setNip( dto.getNip() );
	this.setNamaPeserta( dto.getNamaPeserta() );
	this.setJenisKelamin( dto.getJenisKelamin() );
	this.setTglLahir( dto.getTglLahir() );
	this.setTglMulaiKerja( dto.getTglMulaiKerja() );
	this.setTglHentiKerja( dto.getTglHentiKerja() );
	this.setUsiaSaatHenti( dto.getUsiaSaatHenti() );
	this.setMasaKerjaTotal( dto.getMasaKerjaTotal() );
	this.setPhdp( dto.getPhdp() );
	this.setIdPenerimaMp( dto.getIdPenerimaMp() );
	this.setNamaPenerimaMp( dto.getNamaPenerimaMp() );

	this.setNamaKategoriPenerimaMp( dto.getNamaKategoriPenerimaMp() );
	this.setTglLahirPenerimaMp( dto.getTglLahirPenerimaMp() );
	this.setUsiaPenerimaBayar( dto.getUsiaPenerimaBayar() );
	this.setMpydLama( dto.getMpydLama() );
	this.setMpydBaru( dto.getMpydBaru() );
	this.setKurangBayarMpyd( dto.getKurangBayarMpyd() );
	this.setLebihBayarMpyd( dto.getLebihBayarMpyd() );
	this.setMps20persenLama( dto.getMps20persenLama() );
	this.setMps20persenBaru( dto.getMps20persenBaru() );
	this.setKurangBayarMps20persen( dto.getKurangBayarMps20persen() );
	this.setLebihBayarMps20persen( dto.getLebihBayarMps20persen() );
	this.setMps10jtLama( dto.getMps10jtLama() );
	this.setMps10jtBaru( dto.getMps10jtBaru() );
	this.setKurangBayarMps10jt( dto.getKurangBayarMps10jt() );
	this.setLebihBayarMps10jut( dto.getLebihBayarMps10jut() );
	this.setMps100persenLama( dto.getMps100persenLama() );
	this.setMps100persenBaru( dto.getMps100persenBaru() );
	this.setKurangBayarMps100persen( dto.getKurangBayarMps100persen() );
	this.setLebihBayarMps100persen( dto.getLebihBayarMps100persen() );
	this.setNilaiFsLama( dto.getNilaiFsLama() );
	this.setNilaiFsBaru( dto.getNilaiFsBaru() );
	this.setNilaiFprLama( dto.getNilaiFprLama() );
	this.setNilaiFprBaru( dto.getNilaiFprBaru() );

	this.setNamaKategoriCatatan( dto.getNamaKategoriCatatan() );
	this.setKeterangan( dto.getKeterangan() );

	this.setNamaValidasi( dto.getNamaValidasi() );
	this.setUserValidasi( dto.getUserValidasi() );
	this.setUserStamp( dto.getUserStamp() );

	this.setNamaFaktorFprLama( dto.getNamaFaktorFprLama() );
	this.setNamaFaktorFprBaru( dto.getNamaFaktorFprBaru() );
	this.setFaktorFsLama( dto.getFaktorFsLama() );
	this.setFaktorFsBaru( dto.getFaktorFsBaru() );

	this.setNamaFaktorFsLama( dto.getNamaFaktorFsLama() );
	this.setNamaFaktorFsBaru( dto.getNamaFaktorFsBaru() );
	this.setTglDptht( dto.getTglDptht() );
	this.setTglAwalBayar( dto.getTglAwalBayar() );

	this.setNamaKategoriPensiun( dto.getNamaKategoriPensiun() );
	this.setNamaJenisMps( dto.getNamaJenisMps() );
	this.setNamaStatusKawinPenerimaMp( dto.getNamaStatusKawinPenerimaMp() );
	this.setNamaUsiaBayar( dto.getNamaUsiaBayar() );
	this.setUsiaSaatHentiBulat( dto.getUsiaSaatHentiBulat() );
	this.setUsiaPenerimaBayarBulat( dto.getUsiaPenerimaBayarBulat() );
	this.setMasaKerjaTotalBulat( dto.getMasaKerjaTotalBulat() );
	this.setMasaKerjaTambahan( dto.getMasaKerjaTambahan() );
	this.setMasaKerjaTambahanBulat( dto.getMasaKerjaTambahanBulat() );
	this.setMasaKerjaVeteran( dto.getMasaKerjaVeteran() );
	this.setMasaKerjaVeteranBulat( dto.getMasaKerjaVeteranBulat() );
	this.setMasaKerjaHenti( dto.getMasaKerjaHenti() );
	this.setMasaKerjaHentiBulat( dto.getMasaKerjaHentiBulat() );
	this.setMasaKerjaTotalAdj( dto.getMasaKerjaTotalAdj() );
	this.setMasaKerjaTotalAdjBulat( dto.getMasaKerjaTotalAdjBulat() );
	this.setMasaKerjaMp( dto.getMasaKerjaMp() );
	this.setStatusFs( dto.getStatusFs() );
	this.setMpPerbulanRumus( dto.getMpPerbulanRumus() );
	this.setMpPerbulanRumusBaru( dto.getMpPerbulanRumusBaru() );

	this.setMpPerbulan20persen( dto.getMpPerbulan20persen() );
	this.setMpPerbulan10juta( dto.getMpPerbulan10juta() );
	this.setMpBulan13( dto.getMpBulan13() );

	this.setNamaKantorBayar( dto.getNamaKantorBayar() );

}




@Override
public MutasiPerubahanFprFsDto toDto(){
	MutasiPerubahanFprFsDto dto = new MutasiPerubahanFprFsDto();
	dto.setId( this.getId() );
	dto.setTglMutasi( this.getTglMutasi() );
	dto.setPeriodeMutasi( this.getPeriodeMutasi() );
	dto.setNip( this.getNip() );
	dto.setNamaPeserta( this.getNamaPeserta() );
	dto.setJenisKelamin( this.getJenisKelamin() );
	dto.setTglLahir( this.getTglLahir() );
	dto.setTglMulaiKerja( this.getTglMulaiKerja() );
	dto.setTglHentiKerja( this.getTglHentiKerja() );
	dto.setUsiaSaatHenti( this.getUsiaSaatHenti() );
	dto.setMasaKerjaTotal( this.getMasaKerjaTotal() );
	dto.setPhdp( this.getPhdp() );
	dto.setIdPenerimaMp( this.getIdPenerimaMp() );
	dto.setNamaPenerimaMp( this.getNamaPenerimaMp() );

	dto.setNamaKategoriPenerimaMp( this.getNamaKategoriPenerimaMp() );
	dto.setTglLahirPenerimaMp( this.getTglLahirPenerimaMp() );
	dto.setUsiaPenerimaBayar( this.getUsiaPenerimaBayar() );
	dto.setMpydLama( this.getMpydLama() );
	dto.setMpydBaru( this.getMpydBaru() );
	dto.setKurangBayarMpyd( this.getKurangBayarMpyd() );
	dto.setLebihBayarMpyd( this.getLebihBayarMpyd() );
	dto.setMps20persenLama( this.getMps20persenLama() );
	dto.setMps20persenBaru( this.getMps20persenBaru() );
	dto.setKurangBayarMps20persen( this.getKurangBayarMps20persen() );
	dto.setLebihBayarMps20persen( this.getLebihBayarMps20persen() );
	dto.setMps10jtLama( this.getMps10jtLama() );
	dto.setMps10jtBaru( this.getMps10jtBaru() );
	dto.setKurangBayarMps10jt( this.getKurangBayarMps10jt() );
	dto.setLebihBayarMps10jut( this.getLebihBayarMps10jut() );
	dto.setMps100persenLama( this.getMps100persenLama() );
	dto.setMps100persenBaru( this.getMps100persenBaru() );
	dto.setKurangBayarMps100persen( this.getKurangBayarMps100persen() );
	dto.setLebihBayarMps100persen( this.getLebihBayarMps100persen() );
	dto.setNilaiFsLama( this.getNilaiFsLama() );
	dto.setNilaiFsBaru( this.getNilaiFsBaru() );
	dto.setNilaiFprLama( this.getNilaiFprLama() );
	dto.setNilaiFprBaru( this.getNilaiFprBaru() );

	dto.setNamaKategoriCatatan( this.getNamaKategoriCatatan() );
	dto.setKeterangan( this.getKeterangan() );

	dto.setNamaValidasi( this.getNamaValidasi() );
	dto.setUserValidasi( this.getUserValidasi() );
	dto.setUserStamp( this.getUserStamp() );

	dto.setNamaFaktorFprLama( this.getNamaFaktorFprLama() );
	dto.setNamaFaktorFprBaru( this.getNamaFaktorFprBaru() );
	dto.setFaktorFsLama( this.getFaktorFsLama() );
	dto.setFaktorFsBaru( this.getFaktorFsBaru() );

	dto.setNamaFaktorFsLama( this.getNamaFaktorFsLama() );
	dto.setNamaFaktorFsBaru( this.getNamaFaktorFsBaru() );
	dto.setTglDptht( this.getTglDptht() );
	dto.setTglAwalBayar( this.getTglAwalBayar() );

	dto.setNamaKategoriPensiun( this.getNamaKategoriPensiun() );
	dto.setNamaJenisMps( this.getNamaJenisMps() );
	dto.setNamaStatusKawinPenerimaMp( this.getNamaStatusKawinPenerimaMp() );
	dto.setNamaUsiaBayar( this.getNamaUsiaBayar() );
	dto.setUsiaSaatHentiBulat( this.getUsiaSaatHentiBulat() );
	dto.setUsiaPenerimaBayarBulat( this.getUsiaPenerimaBayarBulat() );
	dto.setMasaKerjaTotalBulat( this.getMasaKerjaTotalBulat() );
	dto.setMasaKerjaTambahan( this.getMasaKerjaTambahan() );
	dto.setMasaKerjaTambahanBulat( this.getMasaKerjaTambahanBulat() );
	dto.setMasaKerjaVeteran( this.getMasaKerjaVeteran() );
	dto.setMasaKerjaVeteranBulat( this.getMasaKerjaVeteranBulat() );
	dto.setMasaKerjaHenti( this.getMasaKerjaHenti() );
	dto.setMasaKerjaHentiBulat( this.getMasaKerjaHentiBulat() );
	dto.setMasaKerjaTotalAdj( this.getMasaKerjaTotalAdj() );
	dto.setMasaKerjaTotalAdjBulat( this.getMasaKerjaTotalAdjBulat() );
	dto.setMasaKerjaMp( this.getMasaKerjaMp() );
	dto.setStatusFs( this.getStatusFs() );
	dto.setMpPerbulanRumus( this.getMpPerbulanRumus() );
	dto.setMpPerbulanRumusBaru( this.getMpPerbulanRumusBaru() );
	dto.setMpPerbulan20persen( this.getMpPerbulan20persen() );
	dto.setMpPerbulan10juta( this.getMpPerbulan10juta() );
	dto.setMpBulan13( this.getMpBulan13() );

	dto.setNamaKantorBayar( this.getNamaKantorBayar() );



	return dto;
}



}