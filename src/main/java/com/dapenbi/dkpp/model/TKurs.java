package com.dapenbi.dkpp.model;

import javax.persistence.*;
import com.dapenbi.dkpp.dto.TKursDto;

import java.math.BigDecimal;
import java.util.Date;

@NamedStoredProcedureQueries(
		@NamedStoredProcedureQuery(
			name="MutasiPensiun.processCuspKurs",
			procedureName="CUSP_KURS",
			parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_COMP_NAME"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_USER_NAME"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_PERIODE_MUTASI"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name= "PAR_KURS_EURO"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = BigDecimal.class, name= "PAR_KURS_RUPIAH"),
				@StoredProcedureParameter(mode = ParameterMode.OUT, type = Character.class, name= "PAR_STATUS_EKSEKUSI"),
				@StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name= "PAR_MSG")
			}
		)
)
@Entity
@Table(name = "TBL_T_KURS")
public class TKurs extends BaseModel<TKursDto>{

	@Id
	@Column(name = "PERIODE_MUTASI", length = 6)
	private String periodeMutasi;

	@Column(name = "KURS_EURO", length = 22)
	private Long kursEuro;

	@Column(name = "KURS_RUPIAH", length = 22)
	private BigDecimal kursRupiah;

	@Column(name = "USER_STAMP", length = 50)
	private String userStamp;

	public void setPeriodeMutasi(String periodeMutasi){
		this.periodeMutasi = periodeMutasi;
	}

	public String getPeriodeMutasi(){
		return this.periodeMutasi;
	}

	public void setKursEuro(Long kursEuro){
		this.kursEuro = kursEuro;
	}

	public Long getKursEuro(){
		return this.kursEuro;
	}

	public void setKursRupiah(BigDecimal kursRupiah){
		this.kursRupiah = kursRupiah;
	}

	public BigDecimal getKursRupiah(){
		return this.kursRupiah;
	}

	public void setUserStamp(String userStamp){
		this.userStamp = userStamp;
	}

	public String getUserStamp(){
		return this.userStamp;
	}

	@Override
	public void fromDto(TKursDto dto){
		this.setPeriodeMutasi( dto.getPeriodeMutasi() );
		this.setKursEuro( dto.getKursEuro() );
		this.setKursRupiah( dto.getKursRupiah() );
		this.setUserStamp( dto.getUserStamp() );
	}

	@Override
	public TKursDto toDto(){
		TKursDto dto = new TKursDto();
		dto.setPeriodeMutasi( this.getPeriodeMutasi() );
		dto.setKursEuro( this.getKursEuro() );
		dto.setKursRupiah( this.getKursRupiah() );
		dto.setUserStamp( this.getUserStamp() );

		return dto;
	}

}