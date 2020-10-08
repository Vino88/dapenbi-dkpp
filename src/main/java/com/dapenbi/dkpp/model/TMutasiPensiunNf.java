package com.dapenbi.dkpp.model;

import javax.persistence.*;
import com.dapenbi.dkpp.dto.TMutasiPensiunNfDto;
import java.util.Date;
@NamedStoredProcedureQueries(
		@NamedStoredProcedureQuery(
				name="MutasiPensiun.processCuspMutasiHapusPensiunNf",
				procedureName="CUSP_MUTASI_HAPUS_PENSIUN_NF",
				parameters = {
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name= "PAR_ROLE_ID"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_COMP_NAME"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_USER_NAME"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_PERIODE_MUTASI"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name= "PAR_TGL_MUTASI"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name= "PAR_ID_MUTASI"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_NIP"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_NAMA_PESERTA"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_ID_PENERIMA_MP"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_NAMA_PENERIMA_MP"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name= "PAR_TGL_MENINGGAL"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_KETERANGAN"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name= "PAR_ID_VALIDASI"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name= "PAR_ID_STATUS_BAYAR"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_NAMA_VALIDASI"),
						@StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name= "PAR_STATUS_EKSEKUSI"),
						@StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name= "PAR_MSG")
				}
		)
)
@Entity
@Table(name = "TBL_T_MUTASI_PENSIUN_NF")
public class TMutasiPensiunNf extends BaseModel<TMutasiPensiunNfDto>{
	@Id
	@Column(name = "ID_MUTASI_NF", length = 22)
	private Long idMutasiNf;

	@Column(name = "PERIODE_MUTASI", length = 6)
	private String periodeMutasi;

	@Column(name = "TGL_MUTASI", length = 7)
	private Date tglMutasi;

	@Column(name = "NIP", length = 20)
	private String nip;

	@Column(name = "NAMA_PESERTA", length = 50)
	private String namaPeserta;

	@Column(name = "ID_PENERIMA_MP", length = 20)
	private String idPenerimaMp;

	@Column(name = "NAMA_PENERIMA_MP", length = 50)
	private String namaPenerimaMp;

	@Column(name = "TGL_MENINGGAL", length = 7)
	private Date tglMeninggal;

	@Column(name = "KETERANGAN", length = 500)
	private String keterangan;

	@Column(name = "ID_VALIDASI", length = 22)
	private Long idValidasi;

	@Column(name = "ID_STATUS_BAYAR", length = 22)
	private Long idStatusBayar;

	@Column(name = "NAMA_VALIDASI", length = 50)
	private String namaValidasi;

	@Column(name = "USER_STAMP", length = 100)
	private String userStamp;

	@Column(name = "USER_VALIDASI", length = 100)
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




	@Override
	public void fromDto(TMutasiPensiunNfDto dto){
		this.setIdMutasiNf( dto.getIdMutasiNf() );
		this.setPeriodeMutasi( dto.getPeriodeMutasi() );
		this.setTglMutasi( dto.getTglMutasi() );
		this.setNip( dto.getNip() );
		this.setNamaPeserta( dto.getNamaPeserta() );
		this.setIdPenerimaMp( dto.getIdPenerimaMp() );
		this.setNamaPenerimaMp( dto.getNamaPenerimaMp() );
		this.setTglMeninggal( dto.getTglMeninggal() );
		this.setKeterangan( dto.getKeterangan() );
		this.setIdValidasi( dto.getIdValidasi() );
		this.setIdStatusBayar( dto.getIdStatusBayar() );
		this.setNamaValidasi( dto.getNamaValidasi() );
		this.setUserStamp( dto.getUserStamp() );
		this.setUserValidasi( dto.getUserValidasi() );
	}




	@Override
	public TMutasiPensiunNfDto toDto(){
		TMutasiPensiunNfDto dto = new TMutasiPensiunNfDto();
		dto.setIdMutasiNf( this.getIdMutasiNf() );
		dto.setPeriodeMutasi( this.getPeriodeMutasi() );
		dto.setTglMutasi( this.getTglMutasi() );
		dto.setNip( this.getNip() );
		dto.setNamaPeserta( this.getNamaPeserta() );
		dto.setIdPenerimaMp( this.getIdPenerimaMp() );
		dto.setNamaPenerimaMp( this.getNamaPenerimaMp() );
		dto.setTglMeninggal( this.getTglMeninggal() );
		dto.setKeterangan( this.getKeterangan() );
		dto.setIdValidasi( this.getIdValidasi() );
		dto.setIdStatusBayar( this.getIdStatusBayar() );
		dto.setNamaValidasi( this.getNamaValidasi() );
		dto.setUserStamp( this.getUserStamp() );
		dto.setUserValidasi( this.getUserValidasi() );


		return dto;
	}



}