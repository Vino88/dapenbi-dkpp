package com.dapenbi.dkpp.model;

import javax.persistence.*;
import com.dapenbi.dkpp.dto.PembayaranHutangDetailDto;
import java.util.Date;

@Entity
@Table(name = "TBL_T_PEMBAYARAN_HUTANG_D")
public class PembayaranHutangDetail extends BaseModel<PembayaranHutangDetailDto>{
	@Id
	@Column(name = "ID_BAYAR_D", length = 22)
	private Long idBayarD;

	@Column(name = "ID_BAYAR", length = 22)
	private Long idBayar;

	@Column(name = "PERIODE_BAYAR", length = 6)
	private String periodeBayar;

	@Column(name = "TGL_TRANSAKSI", length = 7)
	private Date tglTransaksi;

	@Column(name = "NOMINAL", length = 22)
	private Long nominal;

	@Column(name = "KETERANGAN", length = 500)
	private String keterangan;

	@Column(name = "ID_KATEGORI_HUTANG", length = 22)
	private Long idKategoriHutang;

	@Column(name = "USER_STAMP", length = 100)
	private String userStamp;

	public void setIdBayarD(Long idBayarD){
		this.idBayarD = idBayarD;
	}

	public Long getIdBayarD(){
		return this.idBayarD;
	}

	public void setIdBayar(Long idBayar){
		this.idBayar = idBayar;
	}

	public Long getIdBayar(){
		return this.idBayar;
	}

	public void setPeriodeBayar(String periodeBayar){
		this.periodeBayar = periodeBayar;
	}

	public String getPeriodeBayar(){
		return this.periodeBayar;
	}

	public void setTglTransaksi(Date tglTransaksi){
		this.tglTransaksi = tglTransaksi;
	}

	public Date getTglTransaksi(){
		return this.tglTransaksi;
	}

	public void setNominal(Long nominal){
		this.nominal = nominal;
	}

	public Long getNominal(){
		return this.nominal;
	}

	public void setKeterangan(String keterangan){
		this.keterangan = keterangan;
	}

	public String getKeterangan(){
		return this.keterangan;
	}

	public void setIdKategoriHutang(Long idKategoriHutang){
		this.idKategoriHutang = idKategoriHutang;
	}

	public Long getIdKategoriHutang(){
		return this.idKategoriHutang;
	}

	public void setUserStamp(String userStamp){
		this.userStamp = userStamp;
	}

	public String getUserStamp(){
		return this.userStamp;
	}

	@Override
	public void fromDto(PembayaranHutangDetailDto dto){
		this.setIdBayarD( dto.getIdBayarD() );
		this.setIdBayar( dto.getIdBayar() );
		this.setPeriodeBayar( dto.getPeriodeBayar() );
		this.setTglTransaksi( dto.getTglTransaksi() );
		this.setNominal( dto.getNominal() );
		this.setKeterangan( dto.getKeterangan() );
		this.setIdKategoriHutang( dto.getIdKategoriHutang() );
		this.setUserStamp( dto.getUserStamp() );
	}

	@Override
	public PembayaranHutangDetailDto toDto(){
		PembayaranHutangDetailDto dto = new PembayaranHutangDetailDto();
		dto.setIdBayarD( this.getIdBayarD() );
		dto.setIdBayar( this.getIdBayar() );
		dto.setPeriodeBayar( this.getPeriodeBayar() );
		dto.setTglTransaksi( this.getTglTransaksi() );
		dto.setNominal( this.getNominal() );
		dto.setKeterangan( this.getKeterangan() );
		dto.setIdKategoriHutang( this.getIdKategoriHutang() );
		dto.setUserStamp( this.getUserStamp() );
		return dto;
	}



}