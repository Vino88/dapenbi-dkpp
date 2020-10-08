package com.dapenbi.dkpp.model;

import javax.persistence.*;
import com.dapenbi.dkpp.dto.PembayaranMpNfDto;
import java.util.Date;
@NamedStoredProcedureQueries(
		@NamedStoredProcedureQuery(
				name="MutasiPensiun.processCuspPembayaranMpNfPtr",
				procedureName="CUSP_PEMBAYARAN_MP_NF_PTR",
				parameters = {
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_COMP_NAME"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_USER_NAME"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name= "PAR_ID_PEMBAYARAN"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_MUTASI_BAYAR"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Double.class, name= "PAR_NOMINAL"),
						@StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name= "PAR_STATUS_EKSEKUSI"),
						@StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name= "PAR_MSG")
				}
		)
)
@Entity
@Table(name = "TBL_T_PEMBAYARAN_MP_NF")
public class PembayaranMpNf extends BaseModel<PembayaranMpNfDto>{
	@Id
	@Column(name = "ID_PEMBAYARAN", length = 22)
	private Long idPembayaran;

	@Column(name = "PERIODE_MUTASI", length = 6)
	private String periodeMutasi;

	@Column(name = "TGL_MUTASI", length = 7)
	private Date tglMutasi;

	@Column(name = "NIP", length = 20)
	private String nip;

	@Column(name = "NAMA_PESERTA", length = 100)
	private String namaPeserta;

	@Column(name = "ID_PENERIMA_MP", length = 20)
	private String idPenerimaMp;

	@Column(name = "NAMA_PENERIMA_MP", length = 100)
	private String namaPenerimaMp;

	@Column(name = "MP_EURO", length = 22)
	private Long mpEuro;

	@Column(name = "MP_RUPIAH", length = 22)
	private Long mpRupiah;

	@Column(name = "STATUS_HER", length = 1)
	private Character statusHer;

	@Column(name = "ID_VALIDASI", length = 22)
	private Long idValidasi;

	@Column(name = "NAMA_VALIDASI", length = 50)
	private String namaValidasi;

	@Column(name = "ID_KATEGORI_CATATAN", length = 22)
	private Long idKategoriCatatan;

	@Column(name = "KETERANGAN", length = 500)
	private String keterangan;

	@Column(name = "USER_STAMP", length = 50)
	private String userStamp;

	@Column(name = "USER_VALIDASI", length = 50)
	private String userValidasi;

	@Column(name = "IS_SENT_TO_PTR")
	private Long isSentToPtr;

	@Column(name = "IS_HUTANG")
	private Long isHutang;

	public void setIdPembayaran(Long idPembayaran){
		this.idPembayaran = idPembayaran;
	}

	public Long getIdPembayaran(){
		return this.idPembayaran;
	}

	public void setPeriodeMutasi(String periodeMutasi){
		this.periodeMutasi = periodeMutasi;
	}

	public String getPeriodeMutasi(){
		return this.periodeMutasi;
	}

	public void setTglMutasi(Date tglMutasi){
		this.tglMutasi = tglMutasi;
	}

	public Date getTglMutasi(){
		return this.tglMutasi;
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

	public void setMpEuro(Long mpEuro){
		this.mpEuro = mpEuro;
	}

	public Long getMpEuro(){
		return this.mpEuro;
	}

	public void setMpRupiah(Long mpRupiah){
		this.mpRupiah = mpRupiah;
	}

	public Long getMpRupiah(){
		return this.mpRupiah;
	}

	public void setStatusHer(Character statusHer){
		this.statusHer = statusHer;
	}

	public Character getStatusHer(){
		return this.statusHer;
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

	public void setIdKategoriCatatan(Long idKategoriCatatan){
		this.idKategoriCatatan = idKategoriCatatan;
	}

	public Long getIdKategoriCatatan(){
		return this.idKategoriCatatan;
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

	public Long getIsSentToPtr() {
		return isSentToPtr;
	}

	public void setIsSentToPtr(Long isSentToPtr) {
		this.isSentToPtr = isSentToPtr;
	}

	public Long getIsHutang() {
		return isHutang;
	}

	public void setIsHutang(Long isHutang) {
		this.isHutang = isHutang;
	}

	@Override
	public void fromDto(PembayaranMpNfDto dto){
		this.setIdPembayaran( dto.getIdPembayaran() );
		this.setPeriodeMutasi( dto.getPeriodeMutasi() );
		this.setTglMutasi( dto.getTglMutasi() );
		this.setNip( dto.getNip() );
		this.setNamaPeserta( dto.getNamaPeserta() );
		this.setIdPenerimaMp( dto.getIdPenerimaMp() );
		this.setNamaPenerimaMp( dto.getNamaPenerimaMp() );
		this.setMpEuro( dto.getMpEuro() );
		this.setMpRupiah( dto.getMpRupiah() );
		this.setStatusHer( dto.getStatusHer() );
		this.setIdValidasi( dto.getIdValidasi() );
		this.setNamaValidasi( dto.getNamaValidasi() );
		this.setIdKategoriCatatan( dto.getIdKategoriCatatan() );
		this.setKeterangan( dto.getKeterangan() );
		this.setUserStamp( dto.getUserStamp() );
		this.setUserValidasi( dto.getUserValidasi() );
		this.setIsSentToPtr(dto.getIsSentToPtr());
		this.setIsHutang(dto.getIsHutang());
	}




	@Override
	public PembayaranMpNfDto toDto(){
		PembayaranMpNfDto dto = new PembayaranMpNfDto();
		dto.setIdPembayaran( this.getIdPembayaran() );
		dto.setPeriodeMutasi( this.getPeriodeMutasi() );
		dto.setTglMutasi( this.getTglMutasi() );
		dto.setNip( this.getNip() );
		dto.setNamaPeserta( this.getNamaPeserta() );
		dto.setIdPenerimaMp( this.getIdPenerimaMp() );
		dto.setNamaPenerimaMp( this.getNamaPenerimaMp() );
		dto.setMpEuro( this.getMpEuro() );
		dto.setMpRupiah( this.getMpRupiah() );
		dto.setStatusHer( this.getStatusHer() );
		dto.setIdValidasi( this.getIdValidasi() );
		dto.setNamaValidasi( this.getNamaValidasi() );
		dto.setIdKategoriCatatan( this.getIdKategoriCatatan() );
		dto.setKeterangan( this.getKeterangan() );
		dto.setUserStamp( this.getUserStamp() );
		dto.setUserValidasi( this.getUserValidasi() );
		dto.setIsSentToPtr( this.getIsSentToPtr() );
		dto.setIsHutang(this.getIsHutang());

		return dto;
	}



}