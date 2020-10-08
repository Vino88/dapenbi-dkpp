package com.dapenbi.dkpp.model;

import javax.persistence.*;
import com.dapenbi.dkpp.dto.ProyeksiDto;
import java.util.Date;

@Entity
@Table(name = "TBL_T_PROYEKSI_MASTER")
@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(
				name = "Proyeksi.processMasterProyeksi",
				procedureName = "CUSP_MASTER_PROYEKSI",
				parameters = {
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_COMP_NAME"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_USER_NAME"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_PROYEKSI"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "PAR_TGL_INPUT"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_JUMLAH_TAHUN_PROYEKSI"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_BATAS_GOL_I_VI"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_BATAS_GOL_VII_VIII"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_JUMLAH_SIMULASI"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_JENIS_KENAIKAN_MP"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_PERSENTASE_KENAIKAN_MP1"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_PERSENTASE_KENAIKAN_MP2"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_PERSENTASE_KENAIKAN_MP3"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_MINIMAL_KENAIKAN_MP1"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_MINIMAL_KENAIKAN_MP2"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_MINIMAL_KENAIKAN_MP3"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_PERSENTASE_KENAIKAN_PHDP"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_PERSENTASE_KENAIKAN_PHDP2"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_PERSENTASE_KENAIKAN_PHDP3"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Character.class, name = "PAR_ACTION"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_USER_STAMP"),
						@StoredProcedureParameter(mode = ParameterMode.OUT, type = Character.class, name = "PAR_STATUS_EKSEKUSI"),
						@StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name = "PAR_MSG"),
				}
		),
		@NamedStoredProcedureQuery(
				name = "Proyeksi.processProyeksiPensBaru",
				procedureName = "CUSP_PROYEKSI_PENSIUN_BARU",
				parameters = {
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_COMP_NAME"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_USER_NAME"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_TAHUN_PROYEKSI"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Character.class, name = "PAR_UNTUK_PROYEKSI"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_USER_STAMP"),
						@StoredProcedureParameter(mode = ParameterMode.OUT, type = Character.class, name = "PAR_STATUS_EKSEKUSI"),
						@StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name = "PAR_MSG"),
				}
		)
})

public class Proyeksi extends BaseModel<ProyeksiDto>{

	@Id
	@Column(name = "ID_PROYEKSI", length = 22)
	private Long id;

	@Column(name = "TGL_INPUT", length = 7)
	private Date tglInput;

	@Column(name = "JUMLAH_TAHUN_PROYEKSI", length = 22)
	private Long jumlahTahunProyeksi;

	@Column(name = "BATAS_GOL_I_VI", length = 4)
	private String batasGolIVi;

	@Column(name = "BATAS_GOL_VII_VIII", length = 4)
	private String batasGolViiViii;

	@Column(name = "PERSENTASE_KENAIKAN_MP1", length = 22)
	private Long persentaseKenaikanMp1;

	@Column(name = "MINIMAL_KENAIKAN_MP1", length = 22)
	private Long minimalKenaikanMp1;

	@Column(name = "ID_JENIS_KENAIKAN_MP", length = 22)
	private Long idJenisKenaikanMp;

	@Column(name = "PERSENTASE_KENAIKAN_PHDP", length = 22)
	private Long persentaseKenaikanPhdp;

	@Column(name = "USER_STAMP", length = 100)
	private String userStamp;

	@Column(name = "AWAL_TAHUN_PROYEKSI", length = 4)
	private String awalTahunProyeksi;

	@Column(name = "JUMLAH_SIMULASI", length = 22)
	private Long jumlahSimulasi;

	@Column(name = "PERSENTASE_KENAIKAN_MP2", length = 22)
	private Long persentaseKenaikanMp2;

	@Column(name = "PERSENTASE_KENAIKAN_MP3", length = 22)
	private Long persentaseKenaikanMp3;

	@Column(name = "MINIMAL_KENAIKAN_MP2", length = 22)
	private Long minimalKenaikanMp2;

	@Column(name = "MINIMAL_KENAIKAN_MP3", length = 22)
	private Long minimalKenaikanMp3;

	@Column(name = "PERSENTASE_KENAIKAN_PHDP2", length = 22)
	private Long persentaseKenaikanPhdp2;

	@Column(name = "PERSENTASE_KENAIKAN_PHDP3", length = 22)
	private Long persentaseKenaikanPhdp3;

	public void setIdProyeksi(Long idProyeksi){
		this.id = idProyeksi;
	}

	public Long getIdProyeksi(){
		return this.id;
	}

	public void setTglInput(Date tglInput){
		this.tglInput = tglInput;
	}

	public Date getTglInput(){
		return this.tglInput;
	}

	public void setJumlahTahunProyeksi(Long jumlahTahunProyeksi){
		this.jumlahTahunProyeksi = jumlahTahunProyeksi;
	}

	public Long getJumlahTahunProyeksi(){
		return this.jumlahTahunProyeksi;
	}

	public void setBatasGolIVi(String batasGolIVi){
		this.batasGolIVi = batasGolIVi;
	}

	public String getBatasGolIVi(){
		return this.batasGolIVi;
	}

	public void setBatasGolViiViii(String batasGolViiViii){
		this.batasGolViiViii = batasGolViiViii;
	}

	public String getBatasGolViiViii(){
		return this.batasGolViiViii;
	}

	public void setPersentaseKenaikanMp1(Long persentaseKenaikanMp1){
		this.persentaseKenaikanMp1 = persentaseKenaikanMp1;
	}

	public Long getPersentaseKenaikanMp1(){
		return this.persentaseKenaikanMp1;
	}

	public void setMinimalKenaikanMp1(Long minimalKenaikanMp1){
		this.minimalKenaikanMp1 = minimalKenaikanMp1;
	}

	public Long getMinimalKenaikanMp1(){
		return this.minimalKenaikanMp1;
	}

	public void setIdJenisKenaikanMp(Long idJenisKenaikanMp){
		this.idJenisKenaikanMp = idJenisKenaikanMp;
	}

	public Long getIdJenisKenaikanMp(){
		return this.idJenisKenaikanMp;
	}

	public void setPersentaseKenaikanPhdp(Long persentaseKenaikanPhdp){
		this.persentaseKenaikanPhdp = persentaseKenaikanPhdp;
	}

	public Long getPersentaseKenaikanPhdp(){
		return this.persentaseKenaikanPhdp;
	}

	public void setUserStamp(String userStamp){
		this.userStamp = userStamp;
	}

	public String getUserStamp(){
		return this.userStamp;
	}

	public void setAwalTahunProyeksi(String awalTahunProyeksi){
		this.awalTahunProyeksi = awalTahunProyeksi;
	}

	public String getAwalTahunProyeksi(){
		return this.awalTahunProyeksi;
	}

	public void setJumlahSimulasi(Long jumlahSimulasi){
		this.jumlahSimulasi = jumlahSimulasi;
	}

	public Long getJumlahSimulasi(){
		return this.jumlahSimulasi;
	}

	public void setPersentaseKenaikanMp2(Long persentaseKenaikanMp2){
		this.persentaseKenaikanMp2 = persentaseKenaikanMp2;
	}

	public Long getPersentaseKenaikanMp2(){
		return this.persentaseKenaikanMp2;
	}

	public void setPersentaseKenaikanMp3(Long persentaseKenaikanMp3){
		this.persentaseKenaikanMp3 = persentaseKenaikanMp3;
	}

	public Long getPersentaseKenaikanMp3(){
		return this.persentaseKenaikanMp3;
	}

	public void setMinimalKenaikanMp2(Long minimalKenaikanMp2){
		this.minimalKenaikanMp2 = minimalKenaikanMp2;
	}

	public Long getMinimalKenaikanMp2(){
		return this.minimalKenaikanMp2;
	}

	public void setMinimalKenaikanMp3(Long minimalKenaikanMp3){
		this.minimalKenaikanMp3 = minimalKenaikanMp3;
	}

	public Long getMinimalKenaikanMp3(){
		return this.minimalKenaikanMp3;
	}

	public void setPersentaseKenaikanPhdp2(Long persentaseKenaikanPhdp2){
		this.persentaseKenaikanPhdp2 = persentaseKenaikanPhdp2;
	}

	public Long getPersentaseKenaikanPhdp2(){
		return this.persentaseKenaikanPhdp2;
	}

	public void setPersentaseKenaikanPhdp3(Long persentaseKenaikanPhdp3){
		this.persentaseKenaikanPhdp3 = persentaseKenaikanPhdp3;
	}

	public Long getPersentaseKenaikanPhdp3(){
		return this.persentaseKenaikanPhdp3;
	}




	@Override
	public void fromDto(ProyeksiDto dto){
		this.setIdProyeksi( dto.getIdProyeksi() );
		this.setTglInput( dto.getTglInput() );
		this.setJumlahTahunProyeksi( dto.getJumlahTahunProyeksi() );
		this.setBatasGolIVi( dto.getBatasGolIVi() );
		this.setBatasGolViiViii( dto.getBatasGolViiViii() );
		this.setPersentaseKenaikanMp1( dto.getPersentaseKenaikanMp1() );
		this.setMinimalKenaikanMp1( dto.getMinimalKenaikanMp1() );
		this.setIdJenisKenaikanMp( dto.getIdJenisKenaikanMp() );
		this.setPersentaseKenaikanPhdp( dto.getPersentaseKenaikanPhdp() );
		this.setUserStamp( dto.getUserStamp() );
		this.setAwalTahunProyeksi( dto.getAwalTahunProyeksi() );
		this.setJumlahSimulasi( dto.getJumlahSimulasi() );
		this.setPersentaseKenaikanMp2( dto.getPersentaseKenaikanMp2() );
		this.setPersentaseKenaikanMp3( dto.getPersentaseKenaikanMp3() );
		this.setMinimalKenaikanMp2( dto.getMinimalKenaikanMp2() );
		this.setMinimalKenaikanMp3( dto.getMinimalKenaikanMp3() );
		this.setPersentaseKenaikanPhdp2( dto.getPersentaseKenaikanPhdp2() );
		this.setPersentaseKenaikanPhdp3( dto.getPersentaseKenaikanPhdp3() );
	}




	@Override
	public ProyeksiDto toDto(){
		ProyeksiDto dto = new ProyeksiDto();
		dto.setIdProyeksi( this.getIdProyeksi() );
		dto.setTglInput( this.getTglInput() );
		dto.setJumlahTahunProyeksi( this.getJumlahTahunProyeksi() );
		dto.setBatasGolIVi( this.getBatasGolIVi() );
		dto.setBatasGolViiViii( this.getBatasGolViiViii() );
		dto.setPersentaseKenaikanMp1( this.getPersentaseKenaikanMp1() );
		dto.setMinimalKenaikanMp1( this.getMinimalKenaikanMp1() );
		dto.setIdJenisKenaikanMp( this.getIdJenisKenaikanMp() );
		dto.setPersentaseKenaikanPhdp( this.getPersentaseKenaikanPhdp() );
		dto.setUserStamp( this.getUserStamp() );
		dto.setAwalTahunProyeksi( this.getAwalTahunProyeksi() );
		dto.setJumlahSimulasi( this.getJumlahSimulasi() );
		dto.setPersentaseKenaikanMp2( this.getPersentaseKenaikanMp2() );
		dto.setPersentaseKenaikanMp3( this.getPersentaseKenaikanMp3() );
		dto.setMinimalKenaikanMp2( this.getMinimalKenaikanMp2() );
		dto.setMinimalKenaikanMp3( this.getMinimalKenaikanMp3() );
		dto.setPersentaseKenaikanPhdp2( this.getPersentaseKenaikanPhdp2() );
		dto.setPersentaseKenaikanPhdp3( this.getPersentaseKenaikanPhdp3() );


		return dto;
	}



}