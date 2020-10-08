package com.dapenbi.dkpp.model;

import javax.persistence.*;
import com.dapenbi.dkpp.dto.HutangDto;
import com.dapenbi.dkpp.model.CompositeId.HutangPK;
import com.dapenbi.dkpp.model.CompositeId.RekonsiliasiRekeningPK;

import java.math.BigDecimal;
import java.util.Date;

@NamedStoredProcedureQueries(
	{
		@NamedStoredProcedureQuery(
			name="MutasiPensiun.processCuspPembayaranHutang",
			procedureName="CUSP_PEMBAYARAN_HUTANG",
			parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_COMP_NAME"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_USER_NAME"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_NIP"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_PERIODE_HUTANG"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_TYPE"),
				@StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name= "PAR_STATUS_EKSEKUSI"),
				@StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name= "PAR_MSG")
			}
		),
		@NamedStoredProcedureQuery(
			name="MutasiPensiun.processCuspPembayaranHutangPtr",
			procedureName="CUSP_PEMBAYARAN_HUTANG_PTR",
			parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_COMP_NAME"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_USER_NAME"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name= "PAR_ID_BAYAR"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_PERIODE_BAYAR"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = BigDecimal.class, name= "PAR_NOMINAL"),
				@StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name= "PAR_STATUS_EKSEKUSI"),
				@StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name= "PAR_MSG")
			}
		)
	}
)
@Entity
@Table(name = "TBL_T_HUTANG")
public class Hutang extends BaseModel<HutangDto>{
	@Id
	@Column(name="ID_HUTANG")
	private Long idHutang;

	@Column(name = "NIP", length = 10)
	private String nip;

	@Column(name = "PERIODE_MUTASI", length = 6)
	private String periodeMutasi;

	@Column(name = "NAMA_PESERTA", length = 100)
	private String namaPeserta;

	@Column(name = "ID_PENERIMA_MP", length = 50)
	private String idPenerimaMp;

	@Column(name = "NAMA_PENERIMA_MP", length = 100)
	private String namaPenerimaMp;

	@Column(name = "ID_KANTOR_BAYAR", length = 50)
	private String idKantorBayar;

	@Column(name = "NAMA_KANTOR_BAYAR", length = 100)
	private String namaKantorBayar;

	@Column(name = "ID_GOLONGAN", length = 22)
	private Long idGolongan;

	@Column(name = "NAMA_GOLONGAN", length = 100)
	private String namaGolongan;

	@Column(name = "NAMA_JABATAN", length = 100)
	private String namaJabatan;

	@Column(name = "TOTAL_HUTANG", length = 22)
	private BigDecimal totalHutang;

	@Column(name = "SUDAH_DIBAYAR", length = 22)
	private BigDecimal sudahDibayar;

	@Column(name = "SISA_HUTANG", length = 22)
	private BigDecimal sisaHutang;

	@Column(name = "KETERANGAN", length = 500)
	private String keterangan;

	@Column(name = "USER_STAMP", length = 100)
	private String userStamp;

	@Column(name = "TYPE", length = 50)
	private String type;

	@Column(name = "IS_PROSES", length = 20)
	private String isProses;

	public Long getIdHutang() {
		return idHutang;
	}

	public void setIdHutang(Long idHutang) {
		this.idHutang = idHutang;
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

	public void setIdKantorBayar(String idKantorBayar){
		this.idKantorBayar = idKantorBayar;
	}

	public String getIdKantorBayar(){
		return this.idKantorBayar;
	}

	public void setNamaKantorBayar(String namaKantorBayar){
		this.namaKantorBayar = namaKantorBayar;
	}

	public String getNamaKantorBayar(){
		return this.namaKantorBayar;
	}

	public void setIdGolongan(Long idGolongan){
		this.idGolongan = idGolongan;
	}

	public Long getIdGolongan(){
		return this.idGolongan;
	}

	public void setNamaGolongan(String namaGolongan){
		this.namaGolongan = namaGolongan;
	}

	public String getNamaGolongan(){
		return this.namaGolongan;
	}

	public void setNamaJabatan(String namaJabatan){
		this.namaJabatan = namaJabatan;
	}

	public String getNamaJabatan(){
		return this.namaJabatan;
	}

	public void setTotalHutang(BigDecimal totalHutang){
		this.totalHutang = totalHutang;
	}

	public BigDecimal getTotalHutang(){
		return this.totalHutang;
	}

	public void setSudahDibayar(BigDecimal sudahDibayar){
		this.sudahDibayar = sudahDibayar;
	}

	public BigDecimal getSudahDibayar(){
		return this.sudahDibayar;
	}

	public void setSisaHutang(BigDecimal sisaHutang){
		this.sisaHutang = sisaHutang;
	}

	public BigDecimal getSisaHutang(){
		return this.sisaHutang;
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

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return this.type;
	}

	public void setIsProses(String isProses){
		this.isProses = isProses;
	}

	public String getIsProses(){
		return this.isProses;
	}


	@Override
	public void fromDto(HutangDto dto){
		this.setIdHutang(dto.getIdHutang());
		this.setNip( dto.getNip() );
		this.setPeriodeMutasi( dto.getPeriodeMutasi() );
		this.setNamaPeserta( dto.getNamaPeserta() );
		this.setIdPenerimaMp( dto.getIdPenerimaMp() );
		this.setNamaPenerimaMp( dto.getNamaPenerimaMp() );
		this.setIdKantorBayar( dto.getIdKantorBayar() );
		this.setNamaKantorBayar( dto.getNamaKantorBayar() );
		this.setIdGolongan( dto.getIdGolongan() );
		this.setNamaGolongan( dto.getNamaGolongan() );
		this.setNamaJabatan( dto.getNamaJabatan() );
		this.setTotalHutang( dto.getTotalHutang() );
		this.setSudahDibayar( dto.getSudahDibayar() );
		this.setSisaHutang( dto.getSisaHutang() );
		this.setKeterangan( dto.getKeterangan() );
		this.setUserStamp( dto.getUserStamp() );
		this.setType( dto.getType() );
		this.setIsProses( dto.getIsProses() );
	}




	@Override
	public HutangDto toDto(){
		HutangDto dto = new HutangDto();
		dto.setIdHutang( this.getIdHutang() );
		dto.setNip( this.getNip() );
		dto.setPeriodeMutasi( this.getPeriodeMutasi() );
		dto.setNamaPeserta( this.getNamaPeserta() );
		dto.setIdPenerimaMp( this.getIdPenerimaMp() );
		dto.setNamaPenerimaMp( this.getNamaPenerimaMp() );
		dto.setIdKantorBayar( this.getIdKantorBayar() );
		dto.setNamaKantorBayar( this.getNamaKantorBayar() );
		dto.setIdGolongan( this.getIdGolongan() );
		dto.setNamaGolongan( this.getNamaGolongan() );
		dto.setNamaJabatan( this.getNamaJabatan() );
		dto.setTotalHutang( this.getTotalHutang() );
		dto.setSudahDibayar( this.getSudahDibayar() );
		dto.setSisaHutang( this.getSisaHutang() );
		dto.setKeterangan( this.getKeterangan() );
		dto.setUserStamp( this.getUserStamp() );
		dto.setType( this.getType() );
		dto.setIsProses( this.getIsProses() );

		return dto;
	}



}