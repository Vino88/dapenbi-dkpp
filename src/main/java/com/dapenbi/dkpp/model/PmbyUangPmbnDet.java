package com.dapenbi.dkpp.model;

import javax.persistence.*;
import com.dapenbi.dkpp.dto.PmbyUangPmbnDetDto;
import java.util.Date;

@Entity
@Table(name = "TBL_T_PMBY_UANG_PMBN_D")
@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(
				name="PmbyUangPmbnDet.processCuspPmbyUangPembinaanD",
				procedureName="CUSP_PMBY_UANG_PEMBINAAN_D",
				parameters = {
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name= "PAR_ROLE_ID"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_COMP_NAME"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_USER_NAME"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name= "PAR_ID_UANG_PEMBINAAN_D"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name= "PAR_ID_UANG_PEMBINAAN_H"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_PERIODE_BAYAR"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name= "PAR_NOMINAL"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_NIP"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_NAMA_PESERTA"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_ACTION"),
						@StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name= "PAR_STATUS_EKSEKUSI"),
						@StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name= "PAR_MSG"),
//						@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name= "PAR_ID_UANG_PEMBINAAN_D_VAL"),
				}
		),
		@NamedStoredProcedureQuery(
				name="PmbyUangPmbnDet.processCuspPmbyUangPmbnPtr",
				procedureName="CUSP_PMBY_UANG_PMBN_PTR",
				parameters = {
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_COMP_NAME"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_USER_NAME"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name= "PAR_ID_UANG_PEMBINAAN_H"),
						@StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name= "PAR_STATUS_EKSEKUSI"),
						@StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name= "PAR_MSG")
				}
		)
}
)
public class PmbyUangPmbnDet extends BaseModel<PmbyUangPmbnDetDto>{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PMBY_UANG_PMBN_DET_ID_SEQ")
	@SequenceGenerator(sequenceName = "pmbyUangPmbnDetId_seq", allocationSize = 1, name = "PMBY_UANG_PMBN_DET_ID_SEQ")
	@Column(name = "ID_UANG_PEMBINAAN_D", length = 22)
	private Long id;

	@Column(name = "PERIODE_BAYAR", length = 6)
	private String periodeBayar;

	@Column(name = "NIP", length = 20)
	private String nip;

	@Column(name = "NAMA_PESERTA", length = 100)
	private String namaPeserta;

	@Column(name = "NOMINAL", length = 22)
	private Long nominal;

	@Column(name = "ID_UANG_PEMBINAAN_H")
	private Long idUangPembinaanH;

	@Column(name = "ID_SENT_TO_PTR", length = 22)
	private Long idSentToPtr;

	@Column(name = "IS_STATUS_BAYAR", length = 1)
	private Character isStatusBayar;

	@Column(name = "IS_HUTANG", length = 1)
	private Character isHutang;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setPeriodeBayar(String periodeBayar){
	this.periodeBayar = periodeBayar;
}

	public String getPeriodeBayar(){
		return this.periodeBayar;
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

	public void setNominal(Long nominal){
		this.nominal = nominal;
	}

	public Long getNominal(){
	return this.nominal;
}

	public Long getIdUangPembinaanH() {
		return idUangPembinaanH;
	}

	public void setIdUangPembinaanH(Long idUangPembinaanH) {
		this.idUangPembinaanH = idUangPembinaanH;
	}

	public void setUserStamp(String userStamp){
	this.userStamp = userStamp;
}

	public String getUserStamp(){
		return this.userStamp;
	}

	public void setIdSentToPtr(Long idSentToPtr){
		this.idSentToPtr = idSentToPtr;
	}

	public Long getIdSentToPtr(){
	return this.idSentToPtr;
}

	public Character getIsStatusBayar() {
		return isStatusBayar;
	}

	public void setIsStatusBayar(Character isStatusBayar) {
		this.isStatusBayar = isStatusBayar;
	}

	public Character getIsHutang() {
		return isHutang;
	}

	public void setIsHutang(Character isHutang) {
		this.isHutang = isHutang;
	}

	@Override
	public void fromDto(PmbyUangPmbnDetDto dto){
		this.setId( dto.getId() );
		this.setPeriodeBayar( dto.getPeriodeBayar() );
		this.setNip( dto.getNip() );
		this.setNamaPeserta( dto.getNamaPeserta() );
		this.setNominal( dto.getNominal() );
		this.setIdUangPembinaanH(dto.getIdUangPembinaanH());
		this.setActive( dto.getActive() );
		this.setUserStamp( dto.getUserStamp() );
		this.setIdSentToPtr( dto.getIdSentToPtr() );
	}




	@Override
	public PmbyUangPmbnDetDto toDto(){
		PmbyUangPmbnDetDto dto = new PmbyUangPmbnDetDto();
		dto.setId( this.getId() );
		dto.setPeriodeBayar( this.getPeriodeBayar() );
		dto.setNip( this.getNip() );
		dto.setNamaPeserta( this.getNamaPeserta() );
		dto.setIdUangPembinaanH(this.idUangPembinaanH);
		dto.setNominal( this.getNominal() );
		dto.setActive( this.isActive );
		dto.setUserStamp( this.getUserStamp() );
		dto.setIdSentToPtr( this.getIdSentToPtr() );
		return dto;
	}



}