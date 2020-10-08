package com.dapenbi.dkpp.model;

import javax.persistence.*;
import com.dapenbi.dkpp.dto.KenaikanMpDto;
import java.util.Date;

@Entity
@Table(name = "TBL_T_KENAIKAN_MP")
@NamedStoredProcedureQueries(
		@NamedStoredProcedureQuery(
				name="KenaikanMp.processCuspKenaikanMp",
				procedureName="CUSP_KENAIKAN_MP",
				parameters = {
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_COMP_NAME"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_USER_NAME"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name= "PAR_ID_KENAIKAN_MP"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name= "PAR_TGL_INPUT"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name= "PAR_ID_JENIS_KENAIKAN_MP"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_NAMA_JENIS_KENAIKAN_MP"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_OPERATOR"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name= "PAR_TGL_AWAL_BAYAR"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name= "PAR_PERSENTASE"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name= "PAR_MIN_NOMINAL"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_PERIODE_MUTASI_DIPROSES"),
						@StoredProcedureParameter(mode = ParameterMode.OUT, type = Character.class, name= "PAR_STATUS_EKSEKUSI"),
						@StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name= "PAR_MSG")
				}
		)
)
public class KenaikanMp extends BaseModel<KenaikanMpDto>{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "KENAIKAN_MP_SEQ")
	@SequenceGenerator(sequenceName = "kenaikanMpId_seq", allocationSize = 1, name = "KENAIKAN_MP_SEQ")
	@Column(name = "ID_KENAIKAN_MP", length = 22)
	private Long id;

	@Column(name = "TGL_INPUT", length = 7)
	private Date tglInput;

	@Column(name = "ID_JENIS_KENAIKAN_MP", length = 22)
	private Long idJenisKenaikanMp;

	@Column(name = "NAMA_JENIS_KENAIKAN_MP", length = 50)
	private String namaJenisKenaikanMp;

	@Column(name = "OPERATOR_TGL_AWAL_BAYAR", length = 20)
	private String operatorTglAwalBayar;

	@Column(name = "TGL_AWAL_BAYAR", length = 7)
	private Date tglAwalBayar;

	@Column(name = "PERSENTASE", length = 22)
	private Long persentase;

	@Column(name = "MIN_NOMINAL", length = 22)
	private Long minNominal;

	@Column(name = "PERIODE_MUTASI_DIPROSES", length = 6)
	private String periodeMutasiDiproses;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTglInput(Date tglInput){
		this.tglInput = tglInput;
	}

	public Date getTglInput(){
		return this.tglInput;
	}

	public void setIdJenisKenaikanMp(Long idJenisKenaikanMp){
		this.idJenisKenaikanMp = idJenisKenaikanMp;
	}

	public Long getIdJenisKenaikanMp(){
		return this.idJenisKenaikanMp;
	}

	public void setNamaJenisKenaikanMp(String namaJenisKenaikanMp){
		this.namaJenisKenaikanMp = namaJenisKenaikanMp;
	}

	public String getNamaJenisKenaikanMp(){
		return this.namaJenisKenaikanMp;
	}

	public void setOperatorTglAwalBayar(String operatorTglAwalBayar){
		this.operatorTglAwalBayar = operatorTglAwalBayar;
	}

	public String getOperatorTglAwalBayar(){
		return this.operatorTglAwalBayar;
	}

	public void setTglAwalBayar(Date tglAwalBayar){
		this.tglAwalBayar = tglAwalBayar;
	}

	public Date getTglAwalBayar(){
		return this.tglAwalBayar;
	}

	public void setPersentase(Long persentase){
		this.persentase = persentase;
	}

	public Long getPersentase(){
		return this.persentase;
	}

	public void setMinNominal(Long minNominal){
		this.minNominal = minNominal;
	}

	public Long getMinNominal(){
		return this.minNominal;
	}

	public void setPeriodeMutasiDiproses(String periodeMutasiDiproses){
		this.periodeMutasiDiproses = periodeMutasiDiproses;
	}

	public String getPeriodeMutasiDiproses(){
		return this.periodeMutasiDiproses;
	}





	@Override
	public void fromDto(KenaikanMpDto dto){
		this.setId( dto.getId() );
		this.setTglInput( dto.getTglInput() );
		this.setIdJenisKenaikanMp( dto.getIdJenisKenaikanMp() );
		this.setNamaJenisKenaikanMp( dto.getNamaJenisKenaikanMp() );
		this.setOperatorTglAwalBayar( dto.getOperatorTglAwalBayar() );
		this.setTglAwalBayar( dto.getTglAwalBayar() );
		this.setPersentase( dto.getPersentase() );
		this.setMinNominal( dto.getMinNominal() );
		this.setPeriodeMutasiDiproses( dto.getPeriodeMutasiDiproses() );
		this.setUserStamp( dto.getUserStamp() );
	}




	@Override
	public KenaikanMpDto toDto(){
		KenaikanMpDto dto = new KenaikanMpDto();
		dto.setId( this.getId() );
		dto.setTglInput( this.getTglInput() );
		dto.setIdJenisKenaikanMp( this.getIdJenisKenaikanMp() );
		dto.setNamaJenisKenaikanMp( this.getNamaJenisKenaikanMp() );
		dto.setOperatorTglAwalBayar( this.getOperatorTglAwalBayar() );
		dto.setTglAwalBayar( this.getTglAwalBayar() );
		dto.setPersentase( this.getPersentase() );
		dto.setMinNominal( this.getMinNominal() );
		dto.setPeriodeMutasiDiproses( this.getPeriodeMutasiDiproses() );
		dto.setUserStamp( this.getUserStamp() );


		return dto;
	}



}