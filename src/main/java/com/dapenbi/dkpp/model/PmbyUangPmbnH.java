package com.dapenbi.dkpp.model;

import javax.persistence.*;
import com.dapenbi.dkpp.dto.PmbyUangPmbnHDto;
import java.util.Date;

@Entity
@Table(name = "TBL_T_PMBY_UANG_PMBN_H")
@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(
				name="PmbyUangPmbnH.processCuspPmbyUangPembinaan",
				procedureName="CUSP_PMBY_UANG_PEMBINAAN",
				parameters = {
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name= "PAR_ROLE_ID"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_COMP_NAME"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_USER_NAME"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name= "PAR_ID_UANG_PEMBINAAN_H"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_PERIODE_BAYAR"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name= "PAR_NOMINAL_PER_NIP"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_KETERANGAN"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name= "PAR_ID_VALIDASI"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_NAMA_VALIDASI"),
						@StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name= "PAR_STATUS_EKSEKUSI"),
						@StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name= "PAR_MSG")
				}
		)
})
public class PmbyUangPmbnH extends BaseModel<PmbyUangPmbnHDto>{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PMBY_UANG_PMBN_ID_SEQ")
	@SequenceGenerator(sequenceName = "pmbyUangPmbnId_seq", allocationSize = 1, name = "PMBY_UANG_PMBN_ID_SEQ")
	@Column(name = "ID_UANG_PEMBINAAN_H", length = 22)
	private Long id;

	@Column(name = "PERIODE_BAYAR", length = 6)
	private String periodeBayar;

	@Column(name = "TGL_PROSES", length = 7)
	private Date tglProses;

	@Column(name = "NOMINAL_PER_NIP", length = 22)
	private Long nominalPerNip;

	@Column(name = "TOTAL_PENERIMA", length = 22)
	private Long totalPenerima;

	@Column(name = "KETERANGAN", length = 500)
	private String keterangan;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_VALIDASI")
	private StatusValidasi idValidasi;

	@Column(name = "NAMA_VALIDASI", length = 100)
	private String namaValidasi;

	@Column(name = "USER_VALIDASI", length = 100)
	private String userValidasi;

	@Column(name = "IS_SENT_TO_PTR", length = 1)
	private Character isSentToPtr;

	@Column(name = "TOTAL_NOMINAL", length = 22)
	private Long totalNominal;

	@Column(name = "TOTAL_JADI_HUTANG", length = 22)
	private Long totalJadiHutang;

	@Column(name = "TOTAL_DI_BAYARKAN", length = 22)
	private Long totalDiBayarkan;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPeriodeBayar() {
		return periodeBayar;
	}

	public void setPeriodeBayar(String periodeBayar) {
		this.periodeBayar = periodeBayar;
	}

	public Date getTglProses() {
		return tglProses;
	}

	public void setTglProses(Date tglProses) {
		this.tglProses = tglProses;
	}

	public Long getNominalPerNip() {
		return nominalPerNip;
	}

	public void setNominalPerNip(Long nominalPerNip) {
		this.nominalPerNip = nominalPerNip;
	}

	public Long getTotalPenerima() {
		return totalPenerima;
	}

	public void setTotalPenerima(Long totalPenerima) {
		this.totalPenerima = totalPenerima;
	}

	public String getKeterangan() {
		return keterangan;
	}

	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}

	public StatusValidasi getIdValidasi() {
		return idValidasi;
	}

	public void setIdValidasi(StatusValidasi idValidasi) {
		this.idValidasi = idValidasi;
	}

	public String getNamaValidasi() {
		return namaValidasi;
	}

	public void setNamaValidasi(String namaValidasi) {
		this.namaValidasi = namaValidasi;
	}

	public String getUserValidasi() {
		return userValidasi;
	}

	public void setUserValidasi(String userValidasi) {
		this.userValidasi = userValidasi;
	}

	public Character getIsSentToPtr() {
		return isSentToPtr;
	}

	public void setIsSentToPtr(Character isSentToPtr) {
		this.isSentToPtr = isSentToPtr;
	}

	public Long getTotalNominal() {
		return totalNominal;
	}

	public void setTotalNominal(Long totalNominal) {
		this.totalNominal = totalNominal;
	}

	public Long getTotalJadiHutang() {
		return totalJadiHutang;
	}

	public void setTotalJadiHutang(Long totalJadiHutang) {
		this.totalJadiHutang = totalJadiHutang;
	}

	public Long getTotalDiBayarkan() {
		return totalDiBayarkan;
	}

	public void setTotalDiBayarkan(Long totalDiBayarkan) {
		this.totalDiBayarkan = totalDiBayarkan;
	}

	@Override
	public void fromDto(PmbyUangPmbnHDto dto){
		this.setId( dto.getId() );
		this.setPeriodeBayar( dto.getPeriodeBayar() );
		this.setTglProses( dto.getTglProses() );
		this.setNominalPerNip( dto.getNominalPerNip() );
		this.setTotalPenerima( dto.getTotalPenerima() );
		this.setKeterangan( dto.getKeterangan() );
		this.setNamaValidasi( dto.getNamaValidasi() );
		this.setUserValidasi( dto.getUserValidasi() );
		this.setIsSentToPtr( dto.getIsSentToPtr() );
		this.setTotalNominal( dto.getTotalNominal() );
		this.setTotalJadiHutang( dto.getTotalJadiHutang() );
		this.setTotalDiBayarkan( dto.getTotalDiBayarkan() );
		this.setUserStamp(dto.getUserStamp());
		this.setActive(dto.getActive());
	}




	@Override
	public PmbyUangPmbnHDto toDto(){
		PmbyUangPmbnHDto dto = new PmbyUangPmbnHDto();
		dto.setId( this.id );
		dto.setPeriodeBayar( this.getPeriodeBayar() );
		dto.setTglProses( this.getTglProses() );
		dto.setNominalPerNip( this.getNominalPerNip() );
		dto.setTotalPenerima( this.getTotalPenerima() );
		dto.setKeterangan( this.getKeterangan() );
		dto.setNamaValidasi( this.getNamaValidasi() );
		dto.setUserValidasi( this.getUserValidasi() );
		dto.setIsSentToPtr( this.getIsSentToPtr() );
		dto.setTotalNominal( this.getTotalNominal() );
		dto.setTotalJadiHutang( this.getTotalJadiHutang() );
		dto.setTotalDiBayarkan( this.getTotalDiBayarkan() );
		dto.setUserStamp(this.getUserStamp());
		dto.setActive(this.isActive);


		return dto;
	}



}