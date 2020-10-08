package com.dapenbi.dkpp.model;

import javax.persistence.*;
import com.dapenbi.dkpp.dto.UploadMutasiFprFsDto;
import java.util.Date;

@Entity
@Table(name = "TBL_T_UPLOAD_MUTASI_FPR_FS")
@NamedStoredProcedureQueries(
		@NamedStoredProcedureQuery(
				name="MutasiPensiun.processCuspInsertFaktorFprFs",
				procedureName="CUSP_INSERT_FAKTOR_FPR_FS",
				parameters = {
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name= "PAR_ROLE_ID"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_COMP_NAME"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_USER_NAME"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_NAMA_FAKTOR"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name= "PAR_TGL_AWAL"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name= "PAR_TGL_AKHIR"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_KETERANGAN_FAKTOR"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_FAKTOR"),
						@StoredProcedureParameter(mode = ParameterMode.OUT, type = Character.class, name= "PAR_STATUS_EKSEKUSI"),
						@StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name= "PAR_MSG"),
						@StoredProcedureParameter(mode = ParameterMode.OUT, type = Long.class, name= "PAR_ID_FAKTOR"),
				}
		)
)
public class UploadMutasiFprFs extends BaseModel<UploadMutasiFprFsDto>{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UPLOAD_MUTASI_FPRFS_SEQ")
	@SequenceGenerator(sequenceName = "uploadMutasiFprFs_seq", allocationSize = 1, name = "UPLOAD_MUTASI_FPRFS_SEQ")
	@Column(name="ID", unique=true, nullable=false, precision=38)
	private Long id;

@Column(name = "TGL_MULAI_BERLAKU", length = 7)
private Date tglMulaiBerlaku;

@Column(name = "TGL_UPLOAD", length = 7)
private Date tglUpload;

@Column(name = "PERIODE_MULAI", length = 20)
private String periodeMulai;

@Column(name = "JENIS_FAKTOR", length = 20)
private String jenisFaktor;

@Column(name = "TOTAL_DATA", length = 22)
private Long totalData;

@Column(name = "USER_STAMP", length = 60)
private String userStamp;

	@Column(name = "ID_FS", length = 60)
	private Long idFs;

	@Column(name = "ID_FPR", length = 60)
	private Long idFpr;

	@Column(name = "KETERANGAN_FAKTOR", length = 60)
	private String keteranganFaktor;


	public void setId(Long id){
	this.id = id;
}

public Long getId(){
	return this.id;
}

public void setTglMulaiBerlaku(Date tglMulaiBerlaku){
	this.tglMulaiBerlaku = tglMulaiBerlaku;
}

public Date getTglMulaiBerlaku(){
	return this.tglMulaiBerlaku;
}

public void setTglUpload(Date tglUpload){
	this.tglUpload = tglUpload;
}

public Date getTglUpload(){
	return this.tglUpload;
}

public void setPeriodeMulai(String periodeMulai){
	this.periodeMulai = periodeMulai;
}

public String getPeriodeMulai(){
	return this.periodeMulai;
}

public void setJenisFaktor(String jenisFaktor){
	this.jenisFaktor = jenisFaktor;
}

public String getJenisFaktor(){
	return this.jenisFaktor;
}

public void setTotalData(Long totalData){
	this.totalData = totalData;
}

public Long getTotalData(){
	return this.totalData;
}

public void setUserStamp(String userStamp){
	this.userStamp = userStamp;
}

public String getUserStamp(){
	return this.userStamp;
}

	public Long getIdFs() {
		return idFs;
	}

	public void setIdFs(Long idFs) {
		this.idFs = idFs;
	}

	public Long getIdFpr() {
		return idFpr;
	}

	public void setIdFpr(Long idFpr) {
		this.idFpr = idFpr;
	}

	public String getKeteranganFaktor() {
		return keteranganFaktor;
	}

	public void setKeteranganFaktor(String keteranganFaktor) {
		this.keteranganFaktor = keteranganFaktor;
	}

	@Override
public void fromDto(UploadMutasiFprFsDto dto){
	this.setId( dto.getId() );
	this.setTglMulaiBerlaku( dto.getTglMulaiBerlaku() );
	this.setTglUpload( dto.getTglUpload() );
	this.setPeriodeMulai( dto.getPeriodeMulai() );
	this.setJenisFaktor( dto.getJenisFaktor() );
	this.setTotalData( dto.getTotalData() );
	this.setUserStamp( dto.getUserStamp() );
	this.setIdFs(dto.getIdFs());
	this.setIdFpr(dto.getIdFpr());
	this.setKeteranganFaktor(dto.getKeteranganFaktor());
}




@Override
public UploadMutasiFprFsDto toDto(){
	UploadMutasiFprFsDto dto = new UploadMutasiFprFsDto();
	dto.setId( this.getId() );
	dto.setTglMulaiBerlaku( this.getTglMulaiBerlaku() );
	dto.setTglUpload( this.getTglUpload() );
	dto.setPeriodeMulai( this.getPeriodeMulai() );
	dto.setJenisFaktor( this.getJenisFaktor() );
	dto.setTotalData( this.getTotalData() );
	dto.setUserStamp( this.getUserStamp() );
	dto.setIdFs(this.getIdFs());
	dto.setIdFpr(this.getIdFpr());
	dto.setKeteranganFaktor(this.getKeteranganFaktor());


	return dto;
}



}