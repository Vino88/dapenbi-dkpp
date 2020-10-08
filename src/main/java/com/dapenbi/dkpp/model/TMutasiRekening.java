package com.dapenbi.dkpp.model;

import javax.persistence.*;
import com.dapenbi.dkpp.dto.TMutasiRekeningDto;
import java.util.Date;

@NamedStoredProcedureQueries(
		@NamedStoredProcedureQuery(
				name="MutasiPensiun.processCuspMutasiRekening",
				procedureName="CUSP_MUTASI_REKENING",
				parameters = {
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name= "PAR_ROLE_ID"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_COMP_NAME"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_USER_NAME"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_PERIODE_MUTASI"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name= "PAR_TGL_INPUT"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name= "PAR_ID_MUTASI_REKENING"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_NIP"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_NAMA_PESERTA"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_ID_PENERIMA_MP"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_NAMA_PENERIMA_MP"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_NO_REKENING_LAMA"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_NAMA_REKENING_LAMA"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_NAMA_KET_PERUBAHAN_REK"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_NO_REKENING_BARU"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_NAMA_REKENING_BARU"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name= "PAR_ID_JENIS_BANK"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_JENIS_BANK"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_NAMA_CABANG_BANK"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name= "PAR_ID_VALIDASI"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_NAMA_VALIDASI"),
						@StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name= "PAR_STATUS_EKSEKUSI"),
						@StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name= "PAR_MSG")
				}
		)
)
@Entity
@Table(name = "TBL_T_MUTASI_REKENING")
public class TMutasiRekening extends BaseModel<TMutasiRekeningDto>{

	@Id
	@Column(name = "ID_MUTASI_REKENING", length = 22)
	private Long idMutasiRekening;

	@Column(name = "PERIODE_MUTASI", length = 6)
	private String periodeMutasi;

	@Column(name = "TGL_INPUT", length = 7)
	private Date tglInput;

	@Column(name = "NIP", length = 20)
	private String nip;

	@Column(name = "NAMA_PESERTA", length = 50)
	private String namaPeserta;

	@Column(name = "ID_PENERIMA_MP", length = 20)
	private String idPenerimaMp;

	@Column(name = "NAMA_PENERIMA_MP", length = 50)
	private String namaPenerimaMp;

	@Column(name = "NO_REKENING_LAMA", length = 20)
	private String noRekeningLama;

	@Column(name = "NAMA_REKENING_LAMA", length = 50)
	private String namaRekeningLama;

	@Column(name = "NAMA_KET_PERUBAHAN_REKENING", length = 50)
	private String namaKetPerubahanRekening;

	@Column(name = "NO_REKENING_BARU", length = 20)
	private String noRekeningBaru;

	@Column(name = "NAMA_REKENING_BARU", length = 50)
	private String namaRekeningBaru;

	@Column(name = "ID_JENIS_BANK", length = 22)
	private Long idJenisBank;

	@Column(name = "JENIS_BANK", length = 50)
	private String jenisBank;

	@Column(name = "ID_VALIDASI", length = 22)
	private Long idValidasi;

	@Column(name = "NAMA_VALIDASI", length = 50)
	private String namaValidasi;

	@Column(name = "USER_STAMP", length = 100)
	private String userStamp;

	@Column(name = "USER_VALIDASI", length = 100)
	private String userValidasi;

	@Column(name = "ID_KATEGORI_PENERIMA_MP", length = 22)
	private Long idKategoriPenerimaMp;

	@Column(name = "NAMA_KATEGORI_PENERIMA_MP", length = 20)
	private String namaKategoriPenerimaMp;

	@Column(name = "NAMA_CABANG_BANK", length = 50)
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




	@Override
	public void fromDto(TMutasiRekeningDto dto){
		this.setIdMutasiRekening( dto.getIdMutasiRekening() );
		this.setPeriodeMutasi( dto.getPeriodeMutasi() );
		this.setTglInput( dto.getTglInput() );
		this.setNip( dto.getNip() );
		this.setNamaPeserta( dto.getNamaPeserta() );
		this.setIdPenerimaMp( dto.getIdPenerimaMp() );
		this.setNamaPenerimaMp( dto.getNamaPenerimaMp() );
		this.setNoRekeningLama( dto.getNoRekeningLama() );
		this.setNamaRekeningLama( dto.getNamaRekeningLama() );
		this.setNamaKetPerubahanRekening( dto.getNamaKetPerubahanRekening() );
		this.setNoRekeningBaru( dto.getNoRekeningBaru() );
		this.setNamaRekeningBaru( dto.getNamaRekeningBaru() );
		this.setIdJenisBank( dto.getIdJenisBank() );
		this.setJenisBank( dto.getJenisBank() );
		this.setIdValidasi( dto.getIdValidasi() );
		this.setNamaValidasi( dto.getNamaValidasi() );
		this.setUserStamp( dto.getUserStamp() );
		this.setUserValidasi( dto.getUserValidasi() );
		this.setIdKategoriPenerimaMp( dto.getIdKategoriPenerimaMp() );
		this.setNamaKategoriPenerimaMp( dto.getNamaKategoriPenerimaMp() );
		this.setNamaCabangBank( dto.getNamaCabangBank() );
	}




	@Override
	public TMutasiRekeningDto toDto(){
		TMutasiRekeningDto dto = new TMutasiRekeningDto();
		dto.setIdMutasiRekening( this.getIdMutasiRekening() );
		dto.setPeriodeMutasi( this.getPeriodeMutasi() );
		dto.setTglInput( this.getTglInput() );
		dto.setNip( this.getNip() );
		dto.setNamaPeserta( this.getNamaPeserta() );
		dto.setIdPenerimaMp( this.getIdPenerimaMp() );
		dto.setNamaPenerimaMp( this.getNamaPenerimaMp() );
		dto.setNoRekeningLama( this.getNoRekeningLama() );
		dto.setNamaRekeningLama( this.getNamaRekeningLama() );
		dto.setNamaKetPerubahanRekening( this.getNamaKetPerubahanRekening() );
		dto.setNoRekeningBaru( this.getNoRekeningBaru() );
		dto.setNamaRekeningBaru( this.getNamaRekeningBaru() );
		dto.setIdJenisBank( this.getIdJenisBank() );
		dto.setJenisBank( this.getJenisBank() );
		dto.setIdValidasi( this.getIdValidasi() );
		dto.setNamaValidasi( this.getNamaValidasi() );
		dto.setUserStamp( this.getUserStamp() );
		dto.setUserValidasi( this.getUserValidasi() );
		dto.setIdKategoriPenerimaMp( this.getIdKategoriPenerimaMp() );
		dto.setNamaKategoriPenerimaMp( this.getNamaKategoriPenerimaMp() );
		dto.setNamaCabangBank( this.getNamaCabangBank() );


		return dto;
	}



}