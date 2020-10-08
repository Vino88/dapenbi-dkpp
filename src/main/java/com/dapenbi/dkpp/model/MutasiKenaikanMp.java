package com.dapenbi.dkpp.model;

import javax.persistence.*;
import com.dapenbi.dkpp.dto.MutasiKenaikanMpDto;
import java.util.Date;

@Entity
@Table(name = "TBL_T_MUTASI_KENAIKAN_MP")
@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(
				name = "MutasiPensiun.processCuspMutasiKenaikanMp",
				procedureName = "CUSP_MUTASI_KENAIKAN_MP",
				parameters = {
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ROLE_ID"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_COMP_NAME"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_USER_NAME"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_PERIODE_MUTASI"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "PAR_TGL_MUTASI"),
						@StoredProcedureParameter(mode = ParameterMode.OUT, type = Character.class, name = "PAR_STATUS_EKSEKUSI"),
						@StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name = "PAR_MSG")
				}
		),
		@NamedStoredProcedureQuery(
				name="MutasiPensiun.processCuspMutasiKenaikanMpValid",
				procedureName="CUSP_MUTASI_KENAIKAN_MP_VALID",
				parameters = {
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_COMP_NAME"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_USER_NAME"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name= "PAR_ID_MUTASI"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name= "PAR_ID_KATEGORI_CATATAN"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_NAMA_KATEGORI_CATATAN"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_KETERANGAN"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name= "PAR_ID_VALIDASI"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_NAMA_VALIDASI"),
						@StoredProcedureParameter(mode = ParameterMode.OUT, type = Character.class, name= "PAR_STATUS_EKSEKUSI"),
						@StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name= "PAR_MSG"),

				}
		)

})
public class MutasiKenaikanMp extends BaseModel<MutasiKenaikanMpDto>{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MUTASI_KENAIKAN_MP_SEQ")
	@SequenceGenerator(sequenceName = "mutasiKenaikanMp_seq", allocationSize = 1, name = "MUTASI_KENAIKAN_MP_SEQ")
	@Column(name = "ID_MUTASI")
	private Long id;

@Column(name = "NIP", length = 20)
private String nip;

@Column(name = "PERIODE_MUTASI", length = 6)
private String periodeMutasi;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_KENAIKAN_MP")
	private KenaikanMp idKenaikanMp;

@Column(name = "TGL_MUTASI", length = 7)
private Date tglMutasi;

@Column(name = "NAMA_PESERTA", length = 50)
private String namaPeserta;

@Column(name = "JENIS_KELAMIN_PESERTA", length = 1)
private String jenisKelaminPeserta;

@Column(name = "TGL_LAHIR_PESERTA", length = 7)
private Date tglLahirPeserta;

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

@Column(name = "ID_PENERIMA_MP", length = 20)
private String idPenerimaMp;

@Column(name = "NAMA_PENERIMA_MP", length = 50)
private String namaPenerimaMp;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_KATEGORI_PENERIMA_MP")
	private KategoriPenerima idKategoriPenerimaMp;

@Column(name = "NAMA_KATEGORI_PENERIMA_MP", length = 50)
private String namaKategoriPenerimaMp;

@Column(name = "TGL_LAHIR_PENERIMA_MP", length = 7)
private Date tglLahirPenerimaMp;

@Column(name = "USIA_PENERIMA_SAAT_DIBAYAR", length = 4)
private String usiaPenerimaSaatDibayar;

@Column(name = "MP_BULANAN_LAMA", length = 22)
private Long mpBulananLama;

@Column(name = "MP_BULANAN_BARU", length = 22)
private Long mpBulananBaru;

@Column(name = "MP_BULANAN_RAPEL", length = 22)
private Long mpBulananRapel;

@Column(name = "MPS_20PERSEN_LAMA", length = 22)
private Long mps20persenLama;

@Column(name = "MPS_20PERSEN_BARU", length = 22)
private Long mps20persenBaru;

@Column(name = "MPS_20PERSEN_RAPEL", length = 22)
private Long mps20persenRapel;

@Column(name = "MPS_10JUTA_LAMA", length = 22)
private Long mps10jutaLama;

@Column(name = "MPS_10JUTA_BARU", length = 22)
private Long mps10jutaBaru;

@Column(name = "MPS_10JUTA_RAPEL", length = 22)
private Long mps10jutaRapel;

@Column(name = "MPS_100PERSEN_LAMA", length = 22)
private Long mps100persenLama;

@Column(name = "MPS_100PERSEN_BARU", length = 22)
private Long mps100persenBaru;

@Column(name = "MPS_100PERSEN_RAPEL", length = 22)
private Long mps100persenRapel;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_VALIDASI")
	private StatusValidasi idValidasi;

@Column(name = "NAMA_VALIDASI", length = 50)
private String namaValidasi;

@Column(name = "USER_VALIDASI", length = 50)
private String userValidasi;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_KATEGORI_CATATAN")
	private KategoriCatatan idKategoriCatatan;

@Column(name = "NAMA_KATEGORI_CATATAN", length = 50)
private String namaKategoriCatatan;

@Column(name = "KETERANGAN", length = 500)
private String keterangan;

@Column(name = "USER_STAMP", length = 50)
private String userStamp;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_KANTOR_BAYAR")
	private KantorBayar idKantorBayar;

@Column(name = "NAMA_KANTOR_BAYAR", length = 50)
private String namaKantorBayar;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_KATEGORI_PENSIUN")
	private KategoriPensiun idKategoriPensiun;

@Column(name = "NAMA_KATEGORI_PENSIUN", length = 50)
private String namaKategoriPensiun;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_JENIS_MPS")
	private JenisMps idJenisMps;

@Column(name = "NAMA_JENIS_MPS", length = 50)
private String namaJenisMps;

@Column(name = "KENAIKAN_PERSENTASE", length = 22)
private Long kenaikanPersentase;

@Column(name = "KENAIKAN", length = 22)
private Long kenaikan;

@Column(name = "MP_BULAN13_LAMA", length = 22)
private Long mpBulan13Lama;

@Column(name = "MP_BULAN13_BARU", length = 22)
private Long mpBulan13Baru;

@Column(name = "MP_BULAN13_RAPEL", length = 22)
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

	public KenaikanMp getIdKenaikanMp() {
		return idKenaikanMp;
	}

	public void setIdKenaikanMp(KenaikanMp idKenaikanMp) {
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

public void setUserStamp(String userStamp){
	this.userStamp = userStamp;
}

public String getUserStamp(){
	return this.userStamp;
}

	public KantorBayar getIdKantorBayar() {
		return idKantorBayar;
	}

	public void setIdKantorBayar(KantorBayar idKantorBayar) {
		this.idKantorBayar = idKantorBayar;
	}

	public void setNamaKantorBayar(String namaKantorBayar){
	this.namaKantorBayar = namaKantorBayar;
}

public String getNamaKantorBayar(){
	return this.namaKantorBayar;
}

	public KategoriPensiun getIdKategoriPensiun() {
		return idKategoriPensiun;
	}

	public void setIdKategoriPensiun(KategoriPensiun idKategoriPensiun) {
		this.idKategoriPensiun = idKategoriPensiun;
	}

	public void setNamaKategoriPensiun(String namaKategoriPensiun){
	this.namaKategoriPensiun = namaKategoriPensiun;
}

public String getNamaKategoriPensiun(){
	return this.namaKategoriPensiun;
}

	public JenisMps getIdJenisMps() {
		return idJenisMps;
	}

	public void setIdJenisMps(JenisMps idJenisMps) {
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





@Override
public void fromDto(MutasiKenaikanMpDto dto){
		this.setId(dto.getId());
	this.setNip( dto.getNip() );
	this.setPeriodeMutasi( dto.getPeriodeMutasi() );

	this.setTglMutasi( dto.getTglMutasi() );
	this.setNamaPeserta( dto.getNamaPeserta() );
	this.setJenisKelaminPeserta( dto.getJenisKelaminPeserta() );
	this.setTglLahirPeserta( dto.getTglLahirPeserta() );
	this.setTglMulaiKerja( dto.getTglMulaiKerja() );
	this.setTglHentiKerja( dto.getTglHentiKerja() );
	this.setUsiaSaatHenti( dto.getUsiaSaatHenti() );
	this.setMasaKerjaTotal( dto.getMasaKerjaTotal() );
	this.setPhdp( dto.getPhdp() );
	this.setIdPenerimaMp( dto.getIdPenerimaMp() );
	this.setNamaPenerimaMp( dto.getNamaPenerimaMp() );

	this.setNamaKategoriPenerimaMp( dto.getNamaKategoriPenerimaMp() );
	this.setTglLahirPenerimaMp( dto.getTglLahirPenerimaMp() );
	this.setUsiaPenerimaSaatDibayar( dto.getUsiaPenerimaSaatDibayar() );
	this.setMpBulananLama( dto.getMpBulananLama() );
	this.setMpBulananBaru( dto.getMpBulananBaru() );
	this.setMpBulananRapel( dto.getMpBulananRapel() );
	this.setMps20persenLama( dto.getMps20persenLama() );
	this.setMps20persenBaru( dto.getMps20persenBaru() );
	this.setMps20persenRapel( dto.getMps20persenRapel() );
	this.setMps10jutaLama( dto.getMps10jutaLama() );
	this.setMps10jutaBaru( dto.getMps10jutaBaru() );
	this.setMps10jutaRapel( dto.getMps10jutaRapel() );
	this.setMps100persenLama( dto.getMps100persenLama() );
	this.setMps100persenBaru( dto.getMps100persenBaru() );
	this.setMps100persenRapel( dto.getMps100persenRapel() );

	this.setNamaValidasi( dto.getNamaValidasi() );
	this.setUserValidasi( dto.getUserValidasi() );

	this.setNamaKategoriCatatan( dto.getNamaKategoriCatatan() );
	this.setKeterangan( dto.getKeterangan() );
	this.setUserStamp( dto.getUserStamp() );

	this.setNamaKantorBayar( dto.getNamaKantorBayar() );

	this.setNamaKategoriPensiun( dto.getNamaKategoriPensiun() );

	this.setNamaJenisMps( dto.getNamaJenisMps() );
	this.setKenaikanPersentase( dto.getKenaikanPersentase() );
	this.setKenaikan( dto.getKenaikan() );
	this.setMpBulan13Lama( dto.getMpBulan13Lama() );
	this.setMpBulan13Baru( dto.getMpBulan13Baru() );
	this.setMpBulan13Rapel( dto.getMpBulan13Rapel() );

}




@Override
public MutasiKenaikanMpDto toDto(){
	MutasiKenaikanMpDto dto = new MutasiKenaikanMpDto();
	dto.setId(this.getId());
	dto.setNip( this.getNip() );
	dto.setPeriodeMutasi( this.getPeriodeMutasi() );
	dto.setTglMutasi( this.getTglMutasi() );
	dto.setNamaPeserta( this.getNamaPeserta() );
	dto.setJenisKelaminPeserta( this.getJenisKelaminPeserta() );
	dto.setTglLahirPeserta( this.getTglLahirPeserta() );
	dto.setTglMulaiKerja( this.getTglMulaiKerja() );
	dto.setTglHentiKerja( this.getTglHentiKerja() );
	dto.setUsiaSaatHenti( this.getUsiaSaatHenti() );
	dto.setMasaKerjaTotal( this.getMasaKerjaTotal() );
	dto.setPhdp( this.getPhdp() );
	dto.setIdPenerimaMp( this.getIdPenerimaMp() );
	dto.setNamaPenerimaMp( this.getNamaPenerimaMp() );

	dto.setNamaKategoriPenerimaMp( this.getNamaKategoriPenerimaMp() );
	dto.setTglLahirPenerimaMp( this.getTglLahirPenerimaMp() );
	dto.setUsiaPenerimaSaatDibayar( this.getUsiaPenerimaSaatDibayar() );
	dto.setMpBulananLama( this.getMpBulananLama() );
	dto.setMpBulananBaru( this.getMpBulananBaru() );
	dto.setMpBulananRapel( this.getMpBulananRapel() );
	dto.setMps20persenLama( this.getMps20persenLama() );
	dto.setMps20persenBaru( this.getMps20persenBaru() );
	dto.setMps20persenRapel( this.getMps20persenRapel() );
	dto.setMps10jutaLama( this.getMps10jutaLama() );
	dto.setMps10jutaBaru( this.getMps10jutaBaru() );
	dto.setMps10jutaRapel( this.getMps10jutaRapel() );
	dto.setMps100persenLama( this.getMps100persenLama() );
	dto.setMps100persenBaru( this.getMps100persenBaru() );
	dto.setMps100persenRapel( this.getMps100persenRapel() );

	dto.setNamaValidasi( this.getNamaValidasi() );
	dto.setUserValidasi( this.getUserValidasi() );

	dto.setNamaKategoriCatatan( this.getNamaKategoriCatatan() );
	dto.setKeterangan( this.getKeterangan() );
	dto.setUserStamp( this.getUserStamp() );

	dto.setNamaKantorBayar( this.getNamaKantorBayar() );

	dto.setNamaKategoriPensiun( this.getNamaKategoriPensiun() );
	dto.setNamaJenisMps( this.getNamaJenisMps() );
	dto.setKenaikanPersentase( this.getKenaikanPersentase() );
	dto.setKenaikan( this.getKenaikan() );
	dto.setMpBulan13Lama( this.getMpBulan13Lama() );
	dto.setMpBulan13Baru( this.getMpBulan13Baru() );
	dto.setMpBulan13Rapel( this.getMpBulan13Rapel() );



	return dto;
}



}