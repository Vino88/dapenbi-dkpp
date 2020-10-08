package com.dapenbi.dkpp.model;

import javax.persistence.*;
import com.dapenbi.dkpp.dto.PembayaranHutangDto;
import java.util.Date;

@Entity
@Table(name = "TBL_T_PEMBAYARAN_HUTANG")
public class PembayaranHutang extends BaseModel<PembayaranHutangDto>{
	@Id
	@Column(name = "ID_BAYAR", length = 20)
	private Long idBayar;

	@Column(name = "PERIODE_BAYAR", length = 6)
	private String periodeBayar;

	@Column(name = "TGL_BAYAR", length = 7)
	private Date tglBayar;

	@Column(name = "NIP", length = 10)
	private String nip;

	@Column(name = "NAMA_PESERTA", length = 50)
	private String namaPeserta;

	@Column(name = "ID_PENERIMA_MP", length = 50)
	private String idPenerimaMp;

	@Column(name = "NAMA_PENERIMA_MP", length = 50)
	private String namaPenerimaMp;

	@Column(name = "ID_GOLONGAN", length = 22)
	private Long idGolongan;

	@Column(name = "NAMA_GOLONGAN", length = 100)
	private String namaGolongan;

	@Column(name = "JABATAN_PANGKAT", length = 100)
	private String jabatanPangkat;

	@Column(name = "ID_KANTOR_BAYAR", length = 5)
	private String idKantorBayar;

	@Column(name = "STATUS_BAYAR", length = 10)
	private String statusBayar;

	@Column(name = "TOTAL_HUTANG", length = 22)
	private Double totalHutang;

	@Column(name = "SALDO_HUTANG", length = 22)
	private Double saldoHutang;

	@Column(name = "ID_VALIDASI", length = 1)
	private Character idValidasi;

	@Column(name = "NAMA_VALIDASI", length = 50)
	private String namaValidasi;

	@Column(name = "USER_VALIDASI", length = 100)
	private String userValidasi;

	@Column(name = "TOTAL_BAYAR", length = 22)
	private Double totalBayar;

	@Column(name = "USER_STAMP", length = 100)
	private String userStamp;

	@Column(name = "IS_HUTANG_MP", length = 100)
	private String isHutangMp;

	@Column(name = "IS_HUTANG_PEMBINAAN", length = 100)
	private String isHutangPembinaan;

	@Column(name = "IS_SENT_TO_PTR", length = 1)
	private Character isSentToPtr;

	@Column(name = "ID_SENT_TO_PTR", length = 22)
	private Long idSentToPtr;

	@Column(name = "NAMA_KANTOR_BAYAR", length = 50)
	private String namaKantorBayar;

	@Column(name = "TGL_PROSES", length = 7)
	private Date tglProses;

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

	public void setJabatanPangkat(String jabatanPangkat){
		this.jabatanPangkat = jabatanPangkat;
	}

	public String getJabatanPangkat(){
		return this.jabatanPangkat;
	}

	public void setIdKantorBayar(String idKantorBayar){
		this.idKantorBayar = idKantorBayar;
	}

	public String getIdKantorBayar(){
		return this.idKantorBayar;
	}

	public void setStatusBayar(String statusBayar){
		this.statusBayar = statusBayar;
	}

	public String getStatusBayar(){
		return this.statusBayar;
	}

	public void setTotalHutang(Double totalHutang){
		this.totalHutang = totalHutang;
	}

	public Double getTotalHutang(){
		return this.totalHutang;
	}

	public void setSaldoHutang(Double saldoHutang){
		this.saldoHutang = saldoHutang;
	}

	public Double getSaldoHutang(){
		return this.saldoHutang;
	}

	public void setIdValidasi(Character idValidasi){
		this.idValidasi = idValidasi;
	}

	public Character getIdValidasi(){
		return this.idValidasi;
	}

	public void setNamaValidasi(String namaValidasi){
		this.namaValidasi = namaValidasi;
	}

	public String getNamaValidasi(){
		return this.namaValidasi;
	}

	public void setUserValidasi(String userValidasi){
		this.userValidasi = userValidasi;
	}

	public String getUserValidasi(){
		return this.userValidasi;
	}

	public void setTotalBayar(Double totalBayar){
		this.totalBayar = totalBayar;
	}

	public Double getTotalBayar(){
		return this.totalBayar;
	}

	public void setUserStamp(String userStamp){
		this.userStamp = userStamp;
	}

	public String getUserStamp(){
		return this.userStamp;
	}

	public void setIsHutangMp(String isHutangMp){
		this.isHutangMp = isHutangMp;
	}

	public String getIsHutangMp(){
		return this.isHutangMp;
	}

	public void setIsHutangPembinaan(String isHutangPembinaan){
		this.isHutangPembinaan = isHutangPembinaan;
	}

	public String getIsHutangPembinaan(){
		return this.isHutangPembinaan;
	}

	public void setIsSentToPtr(Character isSentToPtr){
		this.isSentToPtr = isSentToPtr;
	}

	public Character getIsSentToPtr(){
		return this.isSentToPtr;
	}

	public void setIdSentToPtr(Long idSentToPtr){
		this.idSentToPtr = idSentToPtr;
	}

	public Long getIdSentToPtr(){
		return this.idSentToPtr;
	}

	public void setNamaKantorBayar(String namaKantorBayar){
		this.namaKantorBayar = namaKantorBayar;
	}

	public String getNamaKantorBayar(){
		return this.namaKantorBayar;
	}

	public void setTglProses(Date tglProses){
		this.tglProses = tglProses;
	}

	public Date getTglProses(){
		return this.tglProses;
	}



	@Override
	public void fromDto(PembayaranHutangDto dto){
		this.setIdBayar( Long.valueOf(dto.getIdBayar()) );
		this.setPeriodeBayar( dto.getPeriodeBayar() );
		this.setTglBayar( dto.getTglBayar() );
		this.setNip( dto.getNip() );
		this.setNamaPeserta( dto.getNamaPeserta() );
		this.setIdPenerimaMp( dto.getIdPenerimaMp() );
		this.setNamaPenerimaMp( dto.getNamaPenerimaMp() );
		this.setIdGolongan( dto.getIdGolongan() );
		this.setNamaGolongan( dto.getNamaGolongan() );
		this.setJabatanPangkat( dto.getJabatanPangkat() );
		this.setIdKantorBayar( dto.getIdKantorBayar() );
		this.setStatusBayar( dto.getStatusBayar() );
		this.setTotalHutang( dto.getTotalHutang() );
		this.setSaldoHutang( dto.getSaldoHutang() );
		this.setIdValidasi( dto.getIdValidasi() );
		this.setNamaValidasi( dto.getNamaValidasi() );
		this.setUserValidasi( dto.getUserValidasi() );
		this.setTotalBayar( dto.getTotalBayar() );
		this.setUserStamp( dto.getUserStamp() );
		this.setIsHutangMp( dto.getIsHutangMp() );
		this.setIsHutangPembinaan( dto.getIsHutangPembinaan() );
		this.setIsSentToPtr( dto.getIsSentToPtr() );
		this.setIdSentToPtr( dto.getIdSentToPtr() );
		this.setNamaKantorBayar( dto.getNamaKantorBayar() );
		this.setTglProses( dto.getTglProses() );
	}




	@Override
	public PembayaranHutangDto toDto(){
		PembayaranHutangDto dto = new PembayaranHutangDto();
		dto.setIdBayar( Long.valueOf(this.getIdBayar()) );
		dto.setPeriodeBayar( this.getPeriodeBayar() );
		dto.setTglBayar( this.getTglBayar() );
		dto.setNip( this.getNip() );
		dto.setNamaPeserta( this.getNamaPeserta() );
		dto.setIdPenerimaMp( this.getIdPenerimaMp() );
		dto.setNamaPenerimaMp( this.getNamaPenerimaMp() );
		dto.setIdGolongan( this.getIdGolongan() );
		dto.setNamaGolongan( this.getNamaGolongan() );
		dto.setJabatanPangkat( this.getJabatanPangkat() );
		dto.setIdKantorBayar( this.getIdKantorBayar() );
		dto.setStatusBayar( this.getStatusBayar() );
		dto.setTotalHutang( this.getTotalHutang() );
		dto.setSaldoHutang( this.getSaldoHutang() );
		dto.setIdValidasi( this.getIdValidasi() );
		dto.setNamaValidasi( this.getNamaValidasi() );
		dto.setUserValidasi( this.getUserValidasi() );
		dto.setTotalBayar( this.getTotalBayar() );
		dto.setUserStamp( this.getUserStamp() );
		dto.setIsHutangMp( this.getIsHutangMp() );
		dto.setIsHutangPembinaan( this.getIsHutangPembinaan() );
		dto.setIsSentToPtr( this.getIsSentToPtr() );
		dto.setIdSentToPtr( this.getIdSentToPtr() );
		dto.setNamaKantorBayar( this.getNamaKantorBayar() );
		dto.setTglProses( this.getTglProses() );


		return dto;
	}



}