package com.dapenbi.dkpp.model;

import javax.persistence.*;
import com.dapenbi.dkpp.dto.MPensiunNfDto;
import java.util.Date;

@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(
				name = "MutasiPensiun.processCuspMutasiPensiunNf",
				procedureName = "CUSP_MUTASI_PENSIUN_NF",
				parameters = {
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ROLE_ID"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_COMP_NAME"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_USER_NAME"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NIP"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_TEMPAT_LAHIR"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "PAR_TGL_LAHIR"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_TEMPAT_MENIKAH"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "PAR_TGL_MENIKAH"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "PAR_TGL_LAHIR_PENERIMA_MP"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "PAR_TGL_MENINGGAL"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_MP_BULANAN_EURO"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_ALAMAT"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_KOTA"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_KODE_POS"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NOMOR_REKENING"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_REKENING"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_BANK_NF"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_SWIFT_CODE"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_IBAN_CODE"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_PERS_NS"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_KETERANGAN"),
						@StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name = "PAR_STATUS_EKSEKUSI"),
						@StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name = "PAR_MSG")
				}
		),
		@NamedStoredProcedureQuery(
				name="MutasiPensiun.processCuspPembayaranMpNf",
				procedureName="CUSP_PEMBAYARAN_MP_NF",
				parameters = {
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name= "PAR_ROLE_ID"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_COMP_NAME"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_USER_NAME"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_PERIODE_MUTASI"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name= "PAR_ID_PEMBAYARAN"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_NIP"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_STATUS_HER"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name= "PAR_ID_KATEGORI_CATATAN"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_KETERANGAN"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name= "PAR_ID_VALIDASI"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_NAMA_VALIDASI"),
						@StoredProcedureParameter(mode = ParameterMode.OUT, type = Character.class, name= "PAR_STATUS_EKSEKUSI"),
						@StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name= "PAR_MSG"),
						@StoredProcedureParameter(mode = ParameterMode.OUT, type = Long.class, name= "PAR_ID_PEMBAYARAN_VAL")
				}
		)
})
@Entity
@Table(name = "TBL_M_PENSIUN_NF")
public class MPensiunNf extends BaseModel<MPensiunNfDto>{

	@Id
	@Column(name = "NIP", length = 20)
	private String nip;

	@Column(name = "NAMA_PESERTA", length = 100)
	private String namaPeserta;

	@Column(name = "TEMPAT_LAHIR", length = 100)
	private String tempatLahir;

	@Column(name = "TGL_LAHIR", length = 7)
	private Date tglLahir;

	@Column(name = "JENIS_KELAMIN", length = 1)
	private Character jenisKelamin;

	@Column(name = "TEMPAT_MENIKAH", length = 100)
	private String tempatMenikah;

	@Column(name = "TGL_MENIKAH", length = 7)
	private Date tglMenikah;

	@Column(name = "TGL_MULAI_KERJA", length = 7)
	private Date tglMulaiKerja;

	@Column(name = "TGL_BERHENTI_KERJA", length = 7)
	private Date tglBerhentiKerja;

	@Column(name = "ALAMAT", length = 500)
	private String alamat;

	@Column(name = "KOTA", length = 100)
	private String kota;

	@Column(name = "KODE_POS", length = 6)
	private String kodePos;

	@Column(name = "ID_PENERIMA_MP", length = 20)
	private String idPenerimaMp;

	@Column(name = "NAMA_PENERIMA_MP", length = 100)
	private String namaPenerimaMp;

	@Column(name = "JENIS_KELAMIN_PENERIMA_MP", length = 1)
	private Character jenisKelaminPenerimaMp;

	@Column(name = "TGL_LAHIR_PENERIMA_MP", length = 7)
	private Date tglLahirPenerimaMp;

	@Column(name = "TGL_MENIKAH_PENERIMA_MP", length = 7)
	private Date tglMenikahPenerimaMp;

	@Column(name = "MP_BULANAN_EURO", length = 22)
	private Long mpBulananEuro;

	@Column(name = "ID_STATUS_BAYAR", length = 22)
	private Long idStatusBayar;

	@Column(name = "NOMOR_REKENING", length = 20)
	private String nomorRekening;

	@Column(name = "NAMA_REKENING", length = 100)
	private String namaRekening;

	@Column(name = "ID_BANK_NF", length = 22)
	private Long idBankNf;

	@Column(name = "SWIFT_CODE", length = 100)
	private String swiftCode;

	@Column(name = "IBAN_CODE", length = 100)
	private String ibanCode;

	@Column(name = "KETERANGAN_HENTI", length = 500)
	private String keteranganHenti;

	@Column(name = "USER_STAMP", length = 100)
	private String userStamp;

	@Column(name = "TGL_MENINGGAL", length = 7)
	private Date tglMeninggal;

	@Column(name = "PERS_NS", length = 50)
	private String persNs;

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

	public void setTempatMenikah(String tempatMenikah){
		this.tempatMenikah = tempatMenikah;
	}

	public String getTempatMenikah(){
		return this.tempatMenikah;
	}

	public void setTglMenikah(Date tglMenikah){
		this.tglMenikah = tglMenikah;
	}

	public Date getTglMenikah(){
		return this.tglMenikah;
	}

	public void setTglMulaiKerja(Date tglMulaiKerja){
		this.tglMulaiKerja = tglMulaiKerja;
	}

	public Date getTglMulaiKerja(){
		return this.tglMulaiKerja;
	}

	public void setTglBerhentiKerja(Date tglBerhentiKerja){
		this.tglBerhentiKerja = tglBerhentiKerja;
	}

	public Date getTglBerhentiKerja(){
		return this.tglBerhentiKerja;
	}

	public void setAlamat(String alamat){
		this.alamat = alamat;
	}

	public String getAlamat(){
		return this.alamat;
	}

	public void setKota(String kota){
		this.kota = kota;
	}

	public String getKota(){
		return this.kota;
	}

	public void setKodePos(String kodePos){
		this.kodePos = kodePos;
	}

	public String getKodePos(){
		return this.kodePos;
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

	public void setJenisKelaminPenerimaMp(Character jenisKelaminPenerimaMp){
		this.jenisKelaminPenerimaMp = jenisKelaminPenerimaMp;
	}

	public Character getJenisKelaminPenerimaMp(){
		return this.jenisKelaminPenerimaMp;
	}

	public void setTglLahirPenerimaMp(Date tglLahirPenerimaMp){
		this.tglLahirPenerimaMp = tglLahirPenerimaMp;
	}

	public Date getTglLahirPenerimaMp(){
		return this.tglLahirPenerimaMp;
	}

	public void setTglMenikahPenerimaMp(Date tglMenikahPenerimaMp){
		this.tglMenikahPenerimaMp = tglMenikahPenerimaMp;
	}

	public Date getTglMenikahPenerimaMp(){
		return this.tglMenikahPenerimaMp;
	}

	public void setMpBulananEuro(Long mpBulananEuro){
		this.mpBulananEuro = mpBulananEuro;
	}

	public Long getMpBulananEuro(){
		return this.mpBulananEuro;
	}

	public void setIdStatusBayar(Long idStatusBayar){
		this.idStatusBayar = idStatusBayar;
	}

	public Long getIdStatusBayar(){
		return this.idStatusBayar;
	}

	public void setNomorRekening(String nomorRekening){
		this.nomorRekening = nomorRekening;
	}

	public String getNomorRekening(){
		return this.nomorRekening;
	}

	public void setNamaRekening(String namaRekening){
		this.namaRekening = namaRekening;
	}

	public String getNamaRekening(){
		return this.namaRekening;
	}

	public void setIdBankNf(Long idBankNf){
		this.idBankNf = idBankNf;
	}

	public Long getIdBankNf(){
		return this.idBankNf;
	}

	public void setSwiftCode(String swiftCode){
		this.swiftCode = swiftCode;
	}

	public String getSwiftCode(){
		return this.swiftCode;
	}

	public void setIbanCode(String ibanCode){
		this.ibanCode = ibanCode;
	}

	public String getIbanCode(){
		return this.ibanCode;
	}

	public void setKeteranganHenti(String keteranganHenti){
		this.keteranganHenti = keteranganHenti;
	}

	public String getKeteranganHenti(){
		return this.keteranganHenti;
	}

	public void setUserStamp(String userStamp){
		this.userStamp = userStamp;
	}

	public String getUserStamp(){
		return this.userStamp;
	}

	public void setTglMeninggal(Date tglMeninggal){
		this.tglMeninggal = tglMeninggal;
	}

	public Date getTglMeninggal(){
		return this.tglMeninggal;
	}

	public void setPersNs(String persNs){
		this.persNs = persNs;
	}

	public String getPersNs(){
		return this.persNs;
	}


@Override
public void fromDto(MPensiunNfDto dto){
	this.setNip( dto.getNip() );
	this.setNamaPeserta( dto.getNamaPeserta() );
	this.setTempatLahir( dto.getTempatLahir() );
	this.setTglLahir( dto.getTglLahir() );
	this.setJenisKelamin( dto.getJenisKelamin() );
	this.setTempatMenikah( dto.getTempatMenikah() );
	this.setTglMenikah( dto.getTglMenikah() );
	this.setTglMulaiKerja( dto.getTglMulaiKerja() );
	this.setTglBerhentiKerja( dto.getTglBerhentiKerja() );
	this.setAlamat( dto.getAlamat() );
	this.setKota( dto.getKota() );
	this.setKodePos( dto.getKodePos() );
	this.setIdPenerimaMp( dto.getIdPenerimaMp() );
	this.setNamaPenerimaMp( dto.getNamaPenerimaMp() );
	this.setJenisKelaminPenerimaMp( dto.getJenisKelaminPenerimaMp() );
	this.setTglLahirPenerimaMp( dto.getTglLahirPenerimaMp() );
	this.setTglMenikahPenerimaMp( dto.getTglMenikahPenerimaMp() );
	this.setMpBulananEuro( dto.getMpBulananEuro() );
	this.setIdStatusBayar( dto.getIdStatusBayar() );
	this.setNomorRekening( dto.getNomorRekening() );
	this.setNamaRekening( dto.getNamaRekening() );
	this.setIdBankNf( dto.getIdBankNf() );
	this.setSwiftCode( dto.getSwiftCode() );
	this.setIbanCode( dto.getIbanCode() );
	this.setKeteranganHenti( dto.getKeteranganHenti() );
	this.setUserStamp( dto.getUserStamp() );
	this.setTglMeninggal( dto.getTglMeninggal() );
	this.setPersNs( dto.getPersNs() );
}




@Override
public MPensiunNfDto toDto(){
	MPensiunNfDto dto = new MPensiunNfDto();
	dto.setNip( this.getNip() );
	dto.setNamaPeserta( this.getNamaPeserta() );
	dto.setTempatLahir( this.getTempatLahir() );
	dto.setTglLahir( this.getTglLahir() );
	dto.setJenisKelamin( this.getJenisKelamin() );
	dto.setTempatMenikah( this.getTempatMenikah() );
	dto.setTglMenikah( this.getTglMenikah() );
	dto.setTglMulaiKerja( this.getTglMulaiKerja() );
	dto.setTglBerhentiKerja( this.getTglBerhentiKerja() );
	dto.setAlamat( this.getAlamat() );
	dto.setKota( this.getKota() );
	dto.setKodePos( this.getKodePos() );
	dto.setIdPenerimaMp( this.getIdPenerimaMp() );
	dto.setNamaPenerimaMp( this.getNamaPenerimaMp() );
	dto.setJenisKelaminPenerimaMp( this.getJenisKelaminPenerimaMp() );
	dto.setTglLahirPenerimaMp( this.getTglLahirPenerimaMp() );
	dto.setTglMenikahPenerimaMp( this.getTglMenikahPenerimaMp() );
	dto.setMpBulananEuro( this.getMpBulananEuro() );
	dto.setIdStatusBayar( this.getIdStatusBayar() );
	dto.setNomorRekening( this.getNomorRekening() );
	dto.setNamaRekening( this.getNamaRekening() );
	dto.setIdBankNf( this.getIdBankNf() );
	dto.setSwiftCode( this.getSwiftCode() );
	dto.setIbanCode( this.getIbanCode() );
	dto.setKeteranganHenti( this.getKeteranganHenti() );
	dto.setUserStamp( this.getUserStamp() );
	dto.setTglMeninggal( this.getTglMeninggal() );
	dto.setPersNs( this.getPersNs() );


	return dto;
}



}