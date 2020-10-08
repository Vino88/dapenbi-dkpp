package com.dapenbi.dkpp.model;

import javax.persistence.*;
import com.dapenbi.dkpp.dto.RekonsiliasiRekeningDto;
import com.dapenbi.dkpp.model.CompositeId.RekonsiliasiRekeningPK;

import java.util.Date;

@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(
				name="MutasiPensiun.processCuspProsesRekonRekening",
				procedureName="CUSP_PROSES_REKON_REKENING",
				parameters = {
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name= "PAR_ROLE_ID"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_COMP_NAME"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_USER_NAME"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_PERIODE"),
						@StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name= "PAR_STATUS_EKSEKUSI"),
						@StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name= "PAR_MSG")
				}
		),
		@NamedStoredProcedureQuery(
				name="MutasiPensiun.processCuspValidasiRekonRekening",
				procedureName="CUSP_VALIDASI_REKON_REKENING",
				parameters = {
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name= "PAR_ROLE_ID"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_COMP_NAME"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_USER_NAME"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_PERIODE"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_NIP"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name= "PAR_ID_VALIDASI"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_NAMA_VALIDASI"),
						@StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name= "PAR_STATUS_EKSEKUSI"),
						@StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name= "PAR_MSG")
				}
		)
})
@Entity
@Table(name = "TBL_T_REKONSILIASI_REKENING")
@IdClass(RekonsiliasiRekeningPK.class)
public class RekonsiliasiRekening extends BaseModel<RekonsiliasiRekeningDto>{

	@Id
	@Column(name = "PERIODE", length = 6)
	private String periode;

	@Id
	@Column(name = "NIP", length = 20)
	private String nip;

	@Column(name = "NAMA_PESERTA", length = 50)
	private String namaPeserta;

	@Column(name = "ID_PENERIMA_MP", length = 20)
	private String idPenerimaMp;

	@Column(name = "NAMA_PENERIMA_MP", length = 50)
	private String namaPenerimaMp;

	@Column(name = "NOMOR_REKENING_MANDIRI", length = 20)
	private String nomorRekeningMandiri;

	@Column(name = "NOMOR_REKENING_DAPENBI", length = 20)
	private String nomorRekeningDapenbi;

	@Column(name = "NAMA_REKENING_MANDIRI", length = 50)
	private String namaRekeningMandiri;

	@Column(name = "NAMA_REKENING_DAPENBI", length = 50)
	private String namaRekeningDapenbi;

	@Column(name = "ID_VALIDASI", length = 22)
	private Long idValidasi;

	@Column(name = "NAMA_VALIDASI", length = 50)
	private String namaValidasi;

	@Column(name = "USER_STAMP", length = 100)
	private String userStamp;

	@Column(name = "USER_VALIDASI", length = 100)
	private String userValidasi;

	public void setPeriode(String periode){
		this.periode = periode;
	}

	public String getPeriode(){
		return this.periode;
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

	public void setNomorRekeningMandiri(String nomorRekeningMandiri){
		this.nomorRekeningMandiri = nomorRekeningMandiri;
	}

	public String getNomorRekeningMandiri(){
		return this.nomorRekeningMandiri;
	}

	public void setNomorRekeningDapenbi(String nomorRekeningDapenbi){
		this.nomorRekeningDapenbi = nomorRekeningDapenbi;
	}

	public String getNomorRekeningDapenbi(){
		return this.nomorRekeningDapenbi;
	}

	public void setNamaRekeningMandiri(String namaRekeningMandiri){
		this.namaRekeningMandiri = namaRekeningMandiri;
	}

	public String getNamaRekeningMandiri(){
		return this.namaRekeningMandiri;
	}

	public void setNamaRekeningDapenbi(String namaRekeningDapenbi){
		this.namaRekeningDapenbi = namaRekeningDapenbi;
	}

	public String getNamaRekeningDapenbi(){
		return this.namaRekeningDapenbi;
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

	@Override
	public void fromDto(RekonsiliasiRekeningDto dto){
		this.setPeriode( dto.getPeriode() );
		this.setNip( dto.getNip() );
		this.setNamaPeserta( dto.getNamaPeserta() );
		this.setIdPenerimaMp( dto.getIdPenerimaMp() );
		this.setNamaPenerimaMp( dto.getNamaPenerimaMp() );
		this.setNomorRekeningMandiri( dto.getNomorRekeningMandiri() );
		this.setNomorRekeningDapenbi( dto.getNomorRekeningDapenbi() );
		this.setNamaRekeningMandiri( dto.getNamaRekeningMandiri() );
		this.setNamaRekeningDapenbi( dto.getNamaRekeningDapenbi() );
		this.setIdValidasi( dto.getIdValidasi() );
		this.setNamaValidasi( dto.getNamaValidasi() );
		this.setUserStamp( dto.getUserStamp() );
		this.setUserValidasi( dto.getUserValidasi() );
	}


	@Override
	public RekonsiliasiRekeningDto toDto(){
		RekonsiliasiRekeningDto dto = new RekonsiliasiRekeningDto();
		dto.setPeriode( this.getPeriode() );
		dto.setNip( this.getNip() );
		dto.setNamaPeserta( this.getNamaPeserta() );
		dto.setIdPenerimaMp( this.getIdPenerimaMp() );
		dto.setNamaPenerimaMp( this.getNamaPenerimaMp() );
		dto.setNomorRekeningMandiri( this.getNomorRekeningMandiri() );
		dto.setNomorRekeningDapenbi( this.getNomorRekeningDapenbi() );
		dto.setNamaRekeningMandiri( this.getNamaRekeningMandiri() );
		dto.setNamaRekeningDapenbi( this.getNamaRekeningDapenbi() );
		dto.setIdValidasi( this.getIdValidasi() );
		dto.setNamaValidasi( this.getNamaValidasi() );
		dto.setUserStamp( this.getUserStamp() );
		dto.setUserValidasi( this.getUserValidasi() );

		return dto;
	}

}