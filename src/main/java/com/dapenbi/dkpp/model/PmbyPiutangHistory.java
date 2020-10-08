package com.dapenbi.dkpp.model;

import javax.persistence.*;
import com.dapenbi.dkpp.dto.PmbyPiutangHistoryDto;
import java.util.Date;

@Entity
@Table(name = "TBL_T_PMBY_PIUTANG_HISTORY")
public class PmbyPiutangHistory extends BaseModel<PmbyPiutangHistoryDto>{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PMBY_PIUTANG_HISTORY_SEQ")
	@SequenceGenerator(sequenceName = "pmbyPiutangHistoryId_seq", allocationSize = 1, name = "PMBY_PIUTANG_HISTORY_SEQ")
	@Column(name = "ID_PIUTANG_HISTORY", length = 22)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PENGEMBALIAN_MP")
	private PengembalianMp idPengembalianMp;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_BAYAR_PIUTANG")
	private Piutang idBayarPiutang;

	@Column(name = "PERIODE_BAYAR", length = 6)
	private String periodeBayar;

	@Column(name = "TGL_BAYAR", length = 7)
	private Date tglBayar;

	@Column(name = "NIP", length = 20)
	private String nip;

	@Column(name = "SALDO_PIUTANG_AWAL", length = 22)
	private Long saldoPiutangAwal;

	@Column(name = "DIBAYAR", length = 22)
	private Long dibayar;

	@Column(name = "SALDO_PIUTANG_AKHIR", length = 22)
	private Long saldoPiutangAkhir;

	@Column(name = "KETERANGAN", length = 500)
	private String keterangan;

	@Column(name = "USER_STAMP", length = 100)
	private String userStamp;

	@Column(name = "USER_VALIDASI", length = 100)
	private String userValidasi;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PengembalianMp getIdPengembalianMp() {
		return idPengembalianMp;
	}

	public void setIdPengembalianMp(PengembalianMp idPengembalianMp) {
		this.idPengembalianMp = idPengembalianMp;
	}

	public Piutang getIdBayarPiutang() {
		return idBayarPiutang;
	}

	public void setIdBayarPiutang(Piutang idBayarPiutang) {
		this.idBayarPiutang = idBayarPiutang;
	}

	public void setPeriodeBayar(String periodeBayar){
	this.periodeBayar = periodeBayar;
}

public String getPeriodeBayar(){
	return this.periodeBayar;
}

public void setTglBayar(Date tglBayar){
	this.tglBayar = tglBayar;
}

public Date getTglBayar(){
	return this.tglBayar;
}

public void setNip(String nip){
	this.nip = nip;
}

public String getNip(){
	return this.nip;
}

public void setSaldoPiutangAwal(Long saldoPiutangAwal){
	this.saldoPiutangAwal = saldoPiutangAwal;
}

public Long getSaldoPiutangAwal(){
	return this.saldoPiutangAwal;
}

public void setDibayar(Long dibayar){
	this.dibayar = dibayar;
}

public Long getDibayar(){
	return this.dibayar;
}

public void setSaldoPiutangAkhir(Long saldoPiutangAkhir){
	this.saldoPiutangAkhir = saldoPiutangAkhir;
}

public Long getSaldoPiutangAkhir(){
	return this.saldoPiutangAkhir;
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

public void setUserValidasi(String userValidasi){
	this.userValidasi = userValidasi;
}

public String getUserValidasi(){
	return this.userValidasi;
}




@Override
public void fromDto(PmbyPiutangHistoryDto dto){
	this.setId( dto.getId() );
	this.setPeriodeBayar( dto.getPeriodeBayar() );
	this.setTglBayar( dto.getTglBayar() );
	this.setNip( dto.getNip() );
	this.setSaldoPiutangAwal( dto.getSaldoPiutangAwal() );
	this.setDibayar( dto.getDibayar() );
	this.setSaldoPiutangAkhir( dto.getSaldoPiutangAkhir() );
	this.setKeterangan( dto.getKeterangan() );
	this.setUserStamp( dto.getUserStamp() );
	this.setUserValidasi( dto.getUserValidasi() );
}




@Override
public PmbyPiutangHistoryDto toDto(){
	PmbyPiutangHistoryDto dto = new PmbyPiutangHistoryDto();
	dto.setId( this.getId() );
	dto.setPeriodeBayar( this.getPeriodeBayar() );
	dto.setTglBayar( this.getTglBayar() );
	dto.setNip( this.getNip() );
	dto.setSaldoPiutangAwal( this.getSaldoPiutangAwal() );
	dto.setDibayar( this.getDibayar() );
	dto.setSaldoPiutangAkhir( this.getSaldoPiutangAkhir() );
	dto.setKeterangan( this.getKeterangan() );
	dto.setUserStamp( this.getUserStamp() );
	dto.setUserValidasi( this.getUserValidasi() );


	return dto;
}



}