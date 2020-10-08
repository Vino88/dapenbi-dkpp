package com.dapenbi.dkpp.model;

import javax.persistence.*;
import com.dapenbi.dkpp.dto.HutangDetailDto;
import java.util.Date;

@Entity
@Table(name = "TBL_T_HUTANG_DETAIL")
public class HutangDetail extends BaseModel<HutangDetailDto>{
	@Id
	@Column(name = "ID_HUTANG_D", length = 22)
	private Long idHutangD;

	@Column(name = "ID_HUTANG")
	private Long idHutang;

	@Column(name = "TGL_MUTASI", length = 7)
	private Date tglMutasi;

	@Column(name = "PERIODE_MUTASI", length = 6)
	private String periodeMutasi;

	@Column(name = "NIP", length = 10)
	private String nip;

	@Column(name = "NAMA_PESERTA", length = 50)
	private String namaPeserta;

	@Column(name = "TGL_TRANSAKSI", length = 7)
	private Date tglTransaksi;

	@Column(name = "JUMLAH_HUTANG", length = 22)
	private Long jumlahHutang;

	@Column(name = "ID_KATEGORI_CATATAN", length = 22)
	private Long idKategoriCatatan;

	@Column(name = "NAMA_KATEGORI_CATATAN", length = 50)
	private String namaKategoriCatatan;

	@Column(name = "KETERANGAN", length = 500)
	private String keterangan;

	@Column(name = "USER_STAMP", length = 100)
	private String userStamp;

	@Column(name = "USER_VALIDASI", length = 100)
	private String userValidasi;

	@Column(name = "REF_MUTASI", length = 10)
	private String refMutasi;

	@Column(name = "ID_VALIDASI", length = 22)
	private Long idValidasi;

	@Column(name = "NAMA_VALIDASI", length = 50)
	private String namaValidasi;

	@Column(name = "TYPE", length = 50)
	private String type;

	@Column(name = "ID_KATEGORI_HUTANG", length = 22)
	private Long idKategoriHutang;

	@Column(name = "NAMA_KATEGORI_HUTANG", length = 100)
	private String namaKategoriHutang;

	public Long getIdHutangD() {
		return idHutangD;
	}

	public void setIdHutangD(Long idHutangD) {
		this.idHutangD = idHutangD;
	}

	public void setIdHutang(Long idHutang){
		this.idHutang = idHutang;
	}

	public Long getIdHutang(){
		return this.idHutang;
	}

	public void setTglMutasi(Date tglMutasi){
		this.tglMutasi = tglMutasi;
	}

	public Date getTglMutasi(){
		return this.tglMutasi;
	}

	public void setPeriodeMutasi(String periodeMutasi){
		this.periodeMutasi = periodeMutasi;
	}

	public String getPeriodeMutasi(){
		return this.periodeMutasi;
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

	public void setTglTransaksi(Date tglTransaksi){
		this.tglTransaksi = tglTransaksi;
	}

	public Date getTglTransaksi(){
		return this.tglTransaksi;
	}

	public void setJumlahHutang(Long jumlahHutang){
		this.jumlahHutang = jumlahHutang;
	}

	public Long getJumlahHutang(){
		return this.jumlahHutang;
	}

	public void setIdKategoriCatatan(Long idKategoriCatatan){
		this.idKategoriCatatan = idKategoriCatatan;
	}

	public Long getIdKategoriCatatan(){
		return this.idKategoriCatatan;
	}

	public void setNamaKategoriCatatan(String namaKategoriCatatan){
		this.namaKategoriCatatan = namaKategoriCatatan;
	}

	public String getNamaKategoriCatatan(){
		return this.namaKategoriCatatan;
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

	public void setRefMutasi(String refMutasi){
		this.refMutasi = refMutasi;
	}

	public String getRefMutasi(){
		return this.refMutasi;
	}

	public void setIdValidasi(Long idValidasi){
		this.idValidasi = idValidasi;
	}

	public Long getIdValidasi(){
		return this.idValidasi;
	}

	public void setNamaValidasi(String namaValidasi){
		this.namaValidasi = namaValidasi;
	}

	public String getNamaValidasi(){
		return this.namaValidasi;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return this.type;
	}

	public void setIdKategoriHutang(Long idKategoriHutang){
		this.idKategoriHutang = idKategoriHutang;
	}

	public Long getIdKategoriHutang(){
		return this.idKategoriHutang;
	}

	public void setNamaKategoriHutang(String namaKategoriHutang){
		this.namaKategoriHutang = namaKategoriHutang;
	}

	public String getNamaKategoriHutang(){
		return this.namaKategoriHutang;
	}

	@Override
	public void fromDto(HutangDetailDto dto){
		this.setIdHutangD(dto.getIdHutangD() );
		this.setIdHutang( dto.getIdHutang() );
		this.setTglMutasi( dto.getTglMutasi() );
		this.setPeriodeMutasi( dto.getPeriodeMutasi() );
		this.setNip( dto.getNip() );
		this.setNamaPeserta( dto.getNamaPeserta() );
		this.setTglTransaksi( dto.getTglTransaksi() );
		this.setJumlahHutang( dto.getJumlahHutang() );
		this.setIdKategoriCatatan( dto.getIdKategoriCatatan() );
		this.setNamaKategoriCatatan( dto.getNamaKategoriCatatan() );
		this.setKeterangan( dto.getKeterangan() );
		this.setUserStamp( dto.getUserStamp() );
		this.setUserValidasi( dto.getUserValidasi() );
		this.setRefMutasi( dto.getRefMutasi() );
		this.setIdValidasi( dto.getIdValidasi() );
		this.setNamaValidasi( dto.getNamaValidasi() );
		this.setType( dto.getType() );
		this.setIdKategoriHutang( dto.getIdKategoriHutang() );
		this.setNamaKategoriHutang( dto.getNamaKategoriHutang() );
	}


	@Override
	public HutangDetailDto toDto(){
		HutangDetailDto dto = new HutangDetailDto();
		dto.setIdHutangD( this.getIdHutangD() );
		dto.setIdHutang( this.getIdHutang() );
		dto.setTglMutasi( this.getTglMutasi() );
		dto.setPeriodeMutasi( this.getPeriodeMutasi() );
		dto.setNip( this.getNip() );
		dto.setNamaPeserta( this.getNamaPeserta() );
		dto.setTglTransaksi( this.getTglTransaksi() );
		dto.setJumlahHutang( this.getJumlahHutang() );
		dto.setIdKategoriCatatan( this.getIdKategoriCatatan() );
		dto.setNamaKategoriCatatan( this.getNamaKategoriCatatan() );
		dto.setKeterangan( this.getKeterangan() );
		dto.setUserStamp( this.getUserStamp() );
		dto.setUserValidasi( this.getUserValidasi() );
		dto.setRefMutasi( this.getRefMutasi() );
		dto.setIdValidasi( this.getIdValidasi() );
		dto.setNamaValidasi( this.getNamaValidasi() );
		dto.setType( this.getType() );
		dto.setIdKategoriHutang( this.getIdKategoriHutang() );
		dto.setNamaKategoriHutang( this.getNamaKategoriHutang() );

		return dto;
	}



}