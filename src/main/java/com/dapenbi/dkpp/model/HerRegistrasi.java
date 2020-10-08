package com.dapenbi.dkpp.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.dapenbi.dkpp.dto.HerRegistrasiDto;

@Entity
@Table(name = "TBL_T_HER_REGISTRASI_HEADER")
@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(
	    name = "HerRegistrasi.cuspCreateMasterHerRegis",
	    procedureName = "CUSP_CREATE_MASTER_HER_REGIS",
	    parameters = {
	        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "ROLE_ID"),
	        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "COMP_NAME"),
	        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "USER_NAME"),
	        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_TAHUN_HER"),
	        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class,   name = "PAR_JENIS_HER"),
	        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_JENIS_HER_DESC"),
	        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_PERIODE_TERDAFTAR_PESERTA"),
	        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class,   name = "PAR_ID_VALIDASI"),
	        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_VALIDASI"),
	        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_ID_CATATAN"),
	        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_KATEGORI_CATATAN"),
	        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_KETERANGAN"),
	        @StoredProcedureParameter(mode = ParameterMode.OUT, type = Character.class, name = "PAR_STATUS_EKSEKUSI"),
	        @StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name = "PAR_MSG"),
	    }
	),
	@NamedStoredProcedureQuery(
			name = "HerRegistrasiUpdate.cuspUpdateMasterHerRegis",
			procedureName = "CUSP_UPDATE_MASTER_HER_REGIS",
			parameters = {
					@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ROLE_ID"),
					@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_COMP_NAME"),
					@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_USER_NAME"),
					@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_TAHUN_HER"),
					@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_STATUS_HER"),
					@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class,   name = "PAR_ID_VALIDASI"),
					@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_VALIDASI"),
					@StoredProcedureParameter(mode = ParameterMode.OUT, type = Character.class, name = "PAR_STATUS_EKSEKUSI"),
					@StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name = "PAR_MSG"),}
	),
	@NamedStoredProcedureQuery(
		name="HerRegistrasi.processCuspUpdateHerRegis",
		procedureName="CUSP_UPDATE_HER_REGIS",
		parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name= "ROLE_ID"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "COMP_NAME"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "USER_NAME"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_TAHUN_HER"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_NIP"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_ID_PENERIMA_HER"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_NOMOR_HER"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name= "PAR_TGL_HER"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_NIP_PAS_1_HER"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_JENIS_KELAMIN_PAS_1_HER"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_NIP_PAS_2_HER"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_JENIS_KELAMIN_PAS_2_HER"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_NAMA_PENERIMA_MP_HER"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name= "PAR_TGL_MENINGGAL_PENERIMA_HER"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_ID_KANTOR_BAYAR_HER"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_NAMA_KANTOR_BAYAR_HER"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = Character.class, name= "PAR_ALAMAT_IS_DALAM_NEGERI_HER"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_ALAMAT_LENGKAP_HER"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_RT_HER"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_RW_HER"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name= "PAR_ID_KELURAHAN_HER"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_NAMA_KELURAHAN_HER"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name= "PAR_ID_KECAMATAN_HER"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_NAMA_KECAMATAN_HER"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name= "PAR_ID_KOTA_KAB_HER"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_NAMA_KOTA_KAB_HER"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name= "PAR_ID_PROVINSI_HER"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_NAMA_PROVINSI_HER"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_KODE_POS_HER"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name= "PAR_ID_NEGARA_HER"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_NAMA_NEGARA_HER"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_NO_HP_HER"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_EMAIL_HER"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = Character.class, name= "PAR_IS_NAMA_PENERIMA_SAMA"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = Character.class, name= "PAR_IS_TGL_LAHIR_SAMA"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = Character.class, name= "PAR_IS_SUSKEL_SAMA"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = Character.class, name= "PAR_IS_KANTOR_BAYAR_SAMA"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = Character.class, name= "PAR_IS_ALAMAT_SAMA"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = Character.class, name= "PAR_IS_ADA_PHOTO"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = Character.class, name= "PAR_IS_ADA_KK"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = Character.class, name= "PAR_IS_ADA_KTP"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = Character.class, name= "PAR_IS_DATA_LENGKAP"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = Character.class, name= "PAR_IS_PENERIMA_MENIKAH_LAGI"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_TEMPAT_MENIKAH"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name= "PAR_TGL_MENIKAH"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name= "PAR_ID_SERAH"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_NAMA_SERAH"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_KETERANGAN_SERAH"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name= "PAR_ID_CATATAN"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_NAMA_CATATAN"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_CATATAN"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name= "PAR_ID_VALIDASI"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name= "PAR_NAMA_VALIDASI"),
				@StoredProcedureParameter(mode = ParameterMode.OUT, type = Character.class, name= "PAR_STATUS_EKSEKUSI"),
				@StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name= "PAR_MSG"),
				@StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name= "PAR_NOMOR_REGISTRASI")
		}
	)
})
public class HerRegistrasi extends BaseModel<HerRegistrasiDto> implements Serializable {

	private static final long serialVersionUID = -4076721695989052449L;

	@Id
	@Column(name = "tahun_her", length = 4)
	private String tahunHer;

	@Column(name = "jenis_her", length = 1)
	private String jenisHer;

	@Column(name = "jenis_her_desc", length = 100)
	private String jenisHerDesc;

	@Column(name = "periode_terdaftar_peserta", length = 6)
	private String periodeTerdaftarPeserta;

	@Column(name = "status_her", length = 1)
	private String statusHer;

	@Column(name = "total_pusat")
	private Long totalPusat;

	@Column(name = "total_cabang")
	private Long totalCabang;

	@ManyToOne
	@JoinColumn(name = "id_validasi")
	private StatusValidasi statusValidasi;

	@Column(name = "nama_validasi", length = 50)
	private String namaValidasi;

	@Column(name = "user_validasi", length = 100)
	private String userValidasi;

	@Column(name = "id_catatan")
	private Long idCatatan;

	@Column(name = "kategori_catatan", length = 50)
	private String kategoriCatatan;

	@Column(name = "keterangan", length = 500)
	private String keterangan;
	
	@OneToMany
	@JoinColumn(name = "tahun_her")
	private List<HerRegistrasiDetail> herRegistrasiDetail;
	
	

	public List<HerRegistrasiDetail> getHerRegistrasiDetail() {
		return herRegistrasiDetail;
	}

	public void setHerRegistrasiDetail(List<HerRegistrasiDetail> herRegistrasiDetail) {
		this.herRegistrasiDetail = herRegistrasiDetail;
	}

	public String getTahunHer() {
		return tahunHer;
	}

	public void setTahunHer(String tahunHer) {
		this.tahunHer = tahunHer;
	}

	public String getJenisHer() {
		return jenisHer;
	}

	public void setJenisHer(String jenisHer) {
		this.jenisHer = jenisHer;
	}

	public String getJenisHerDesc() {
		return jenisHerDesc;
	}

	public void setJenisHerDesc(String jenisHerDesc) {
		this.jenisHerDesc = jenisHerDesc;
	}

	public String getPeriodeTerdaftarPeserta() {
		return periodeTerdaftarPeserta;
	}

	public void setPeriodeTerdaftarPeserta(String periodeTerdaftarPeserta) {
		this.periodeTerdaftarPeserta = periodeTerdaftarPeserta;
	}

	public String getStatusHer() {
		return statusHer;
	}

	public void setStatusHer(String statusHer) {
		this.statusHer = statusHer;
	}

	public Long getTotalPusat() {
		return totalPusat;
	}

	public void setTotalPusat(Long totalPusat) {
		this.totalPusat = totalPusat;
	}

	public Long getTotalCabang() {
		return totalCabang;
	}

	public void setTotalCabang(Long totalCabang) {
		this.totalCabang = totalCabang;
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

	public Long getIdCatatan() {
		return idCatatan;
	}

	public void setIdCatatan(Long idCatatan) {
		this.idCatatan = idCatatan;
	}

	public String getKategoriCatatan() {
		return kategoriCatatan;
	}

	public void setKategoriCatatan(String kategoriCatatan) {
		this.kategoriCatatan = kategoriCatatan;
	}

	public String getKeterangan() {
		return keterangan;
	}

	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}
	

	public StatusValidasi getStatusValidasi() {
		return statusValidasi;
	}

	public void setStatusValidasi(StatusValidasi statusValidasi) {
		this.statusValidasi = statusValidasi;
	}

	@Override
	public void fromDto(HerRegistrasiDto dto) {
		this.tahunHer = dto.getTahunHer();
		this.jenisHer = dto.getJenisHer();
		this.jenisHerDesc = dto.getJenisHerDesc();
		this.periodeTerdaftarPeserta = dto.getPeriodeTerdaftarPeserta();
		this.statusHer = dto.getStatusHer();
		this.totalPusat = dto.getTotalPusat();
		this.totalCabang = dto.getTotalCabang();
		this.namaValidasi = dto.getNamaValidasi();
		this.userValidasi = dto.getUserValidasi();
		this.idCatatan = dto.getIdCatatan();
		this.kategoriCatatan = dto.getKategoriCatatan();
		this.keterangan = dto.getKeterangan();
	}

	@Override
	public HerRegistrasiDto toDto() {
		HerRegistrasiDto dto = new HerRegistrasiDto();
		dto.setTahunHer(this.tahunHer);
		dto.setJenisHer(this.jenisHer);
		dto.setJenisHerDesc(this.jenisHerDesc);
		dto.setPeriodeTerdaftarPeserta(this.periodeTerdaftarPeserta);
		dto.setStatusHer(this.statusHer);
		dto.setTotalPusat(this.totalPusat);
		dto.setTotalCabang(this.totalCabang);
		dto.setNamaValidasi(this.namaValidasi);
		dto.setUserValidasi(this.userValidasi);
		dto.setIdCatatan(this.idCatatan);
		dto.setKategoriCatatan(this.kategoriCatatan);
		dto.setKeterangan(this.keterangan);
		dto.setUserStamp(this.userStamp);
		return dto;
	}

}
