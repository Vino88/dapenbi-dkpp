package com.dapenbi.dkpp.dto;

import java.util.Date;

public class HerRegistrasiDetailDto extends BaseDto{

	private String nip;
	private String tahunHer;
	private String nomorHer;
	private String namaPeserta;
	private Date tglHer;
	private String idPenerima ;
	private String namaPenerima;
	private Date tglLahir;
	private Long idKategoriPenerimaMP;
	private String namaKategoriPenerimaMP;
	private String idKantorBayar;
	private String namaKantorBayar;
	private Long idSuskel;
	private String namaSuskel ;
	private String alamatIsDalamNegeri;
	private String alamatLengkap;
	private String rt;
	private String rw;
	private Long idKelurahan;
	private String namaKelurahan;
	private Long idKecamatan;
	private String namaKecamatan;
	private Long idKotaKabNumber;
	private String namaKotaKab;
	private Long idProvinsiNumber; 
	private String namaProvinsi;
	private String kodePos; 
	private Long idNegaraNumber; 
	private String namaNegara;
	private String noHp;
	private String email;
	private String nipPas1Her; 
	private String jenisKelaminPas1Her;
	private String nipPas2Her; 
	private String jenisKelaminPas2Her;
	private Long idPenerimaHer; 
	private String namaPenerimaHer;
	private Date tglLahirPenerimaHer;
	private Date tglMeninggalPenerimaHer;
	private Long idSuskelHer;
	private String namaSuskelHer;
	private Long idKantorBayarHer;
	private String namaKantorBayarHer ; 
	private String alamatIsDalamNegeriHer;
	private String alamatLengkapHer;
	private String rtHer ; 
	private String rwHer ; 
	private Long idKelurahanHer;
	private String namaKelurahanHer;
	private Long idKecamatanHer;
	private String namaKecamatanHer;
	private Long idKotaKabHer;
	private String namaKotaKabHer ; 
	private Long idProvinsiHer;
	private String namaProvinsiHer;
	private String kodePosHer ;
	private Long idNegaraHer;
	private String namaNegaraHer ; 
	private String noTlpRumah;
	private String noTlpRumahHer;
	private String noHpHer;
	private String emailHer;
	private Boolean isNamaPenerimaSama;
	private Boolean isTglLahirSama;
	private Boolean isSuskelSama;
	private Boolean isKantorBayarSama;
	private Boolean isAlamatSama;
	private Boolean isAdaPhoto;
	private Boolean isAdaKtp;
	private Boolean isAdaKk;
	private Boolean isDataLengkap;
	private Boolean isPenerimaMenikahLagi;
	private String tempatMenikah;
	private Date tglMenikah;
	private Long idSerah;
	private String namaSerah;
	private String keteranganSerah;
	private Long idCatatan;
	private String namaCatatan; 
	private String catatan; 
	private Long idValidasi;
	private String namaValidasi;
	private String userStamp;
	private String userValidasi;
	private Boolean isHerOtomatis;
	private Boolean isActive;
	private Boolean isSudahHer;
	private String statusHerDesc;
	public String getNip() {
		return nip;
	}
	public void setNip(String nip) {
		this.nip = nip;
	}
	public String getTahunHer() {
		return tahunHer;
	}
	public void setTahunHer(String tahunHer) {
		this.tahunHer = tahunHer;
	}
	public String getNomorHer() {
		return nomorHer;
	}
	public void setNomorHer(String nomorHer) {
		this.nomorHer = nomorHer;
	}
	public String getNamaPeserta() {
		return namaPeserta;
	}
	public void setNamaPeserta(String namaPeserta) {
		this.namaPeserta = namaPeserta;
	}
	public Date getTglHer() {
		return tglHer;
	}
	public void setTglHer(Date tglHer) {
		this.tglHer = tglHer;
	}
	public String getIdPenerima() {
		return idPenerima;
	}
	public void setIdPenerima(String idPenerima) {
		this.idPenerima = idPenerima;
	}
	public String getNamaPenerima() {
		return namaPenerima;
	}
	public void setNamaPenerima(String namaPenerima) {
		this.namaPenerima = namaPenerima;
	}
	public Date getTglLahir() {
		return tglLahir;
	}
	public void setTglLahir(Date tglLahir) {
		this.tglLahir = tglLahir;
	}
	public Long getIdKategoriPenerimaMP() {
		return idKategoriPenerimaMP;
	}
	public void setIdKategoriPenerimaMP(Long idKategoriPenerimaMP) {
		this.idKategoriPenerimaMP = idKategoriPenerimaMP;
	}
	public String getNamaKategoriPenerimaMP() {
		return namaKategoriPenerimaMP;
	}
	public void setNamaKategoriPenerimaMP(String namaKategoriPenerimaMP) {
		this.namaKategoriPenerimaMP = namaKategoriPenerimaMP;
	}
	public String getIdKantorBayar() {
		return idKantorBayar;
	}
	public void setIdKantorBayar(String idKantorBayar) {
		this.idKantorBayar = idKantorBayar;
	}
	public String getNamaKantorBayar() {
		return namaKantorBayar;
	}
	public void setNamaKantorBayar(String namaKantorBayar) {
		this.namaKantorBayar = namaKantorBayar;
	}
	public Long getIdSuskel() {
		return idSuskel;
	}
	public void setIdSuskel(Long idSuskel) {
		this.idSuskel = idSuskel;
	}
	public String getNamaSuskel() {
		return namaSuskel;
	}
	public void setNamaSuskel(String namaSuskel) {
		this.namaSuskel = namaSuskel;
	}
	public String getAlamatIsDalamNegeri() {
		return alamatIsDalamNegeri;
	}
	public void setAlamatIsDalamNegeri(String alamatIsDalamNegeri) {
		this.alamatIsDalamNegeri = alamatIsDalamNegeri;
	}
	public String getAlamatLengkap() {
		return alamatLengkap;
	}
	public void setAlamatLengkap(String alamatLengkap) {
		this.alamatLengkap = alamatLengkap;
	}
	public String getRt() {
		return rt;
	}
	public void setRt(String rt) {
		this.rt = rt;
	}
	public String getRw() {
		return rw;
	}
	public void setRw(String rw) {
		this.rw = rw;
	}
	public Long getIdKelurahan() {
		return idKelurahan;
	}
	public void setIdKelurahan(Long idKelurahan) {
		this.idKelurahan = idKelurahan;
	}
	public String getNamaKelurahan() {
		return namaKelurahan;
	}
	public void setNamaKelurahan(String namaKelurahan) {
		this.namaKelurahan = namaKelurahan;
	}
	public Long getIdKecamatan() {
		return idKecamatan;
	}
	public void setIdKecamatan(Long idKecamatan) {
		this.idKecamatan = idKecamatan;
	}
	public String getNamaKecamatan() {
		return namaKecamatan;
	}
	public void setNamaKecamatan(String namaKecamatan) {
		this.namaKecamatan = namaKecamatan;
	}
	public Long getIdKotaKabNumber() {
		return idKotaKabNumber;
	}
	public void setIdKotaKabNumber(Long idKotaKabNumber) {
		this.idKotaKabNumber = idKotaKabNumber;
	}
	public String getNamaKotaKab() {
		return namaKotaKab;
	}
	public void setNamaKotaKab(String namaKotaKab) {
		this.namaKotaKab = namaKotaKab;
	}
	public Long getIdProvinsiNumber() {
		return idProvinsiNumber;
	}
	public void setIdProvinsiNumber(Long idProvinsiNumber) {
		this.idProvinsiNumber = idProvinsiNumber;
	}
	public String getNamaProvinsi() {
		return namaProvinsi;
	}
	public void setNamaProvinsi(String namaProvinsi) {
		this.namaProvinsi = namaProvinsi;
	}
	public String getKodePos() {
		return kodePos;
	}
	public void setKodePos(String kodePos) {
		this.kodePos = kodePos;
	}
	public Long getIdNegaraNumber() {
		return idNegaraNumber;
	}
	public void setIdNegaraNumber(Long idNegaraNumber) {
		this.idNegaraNumber = idNegaraNumber;
	}
	public String getNamaNegara() {
		return namaNegara;
	}
	public void setNamaNegara(String namaNegara) {
		this.namaNegara = namaNegara;
	}
	public String getNoHp() {
		return noHp;
	}
	public void setNoHp(String noHp) {
		this.noHp = noHp;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNipPas1Her() {
		return nipPas1Her;
	}
	public void setNipPas1Her(String nipPas1Her) {
		this.nipPas1Her = nipPas1Her;
	}
	public String getJenisKelaminPas1Her() {
		return jenisKelaminPas1Her;
	}
	public void setJenisKelaminPas1Her(String jenisKelaminPas1Her) {
		this.jenisKelaminPas1Her = jenisKelaminPas1Her;
	}
	public String getNipPas2Her() {
		return nipPas2Her;
	}
	public void setNipPas2Her(String nipPas2Her) {
		this.nipPas2Her = nipPas2Her;
	}
	public String getJenisKelaminPas2Her() {
		return jenisKelaminPas2Her;
	}
	public void setJenisKelaminPas2Her(String jenisKelaminPas2Her) {
		this.jenisKelaminPas2Her = jenisKelaminPas2Her;
	}
	public Long getIdPenerimaHer() {
		return idPenerimaHer;
	}
	public void setIdPenerimaHer(Long idPenerimaHer) {
		this.idPenerimaHer = idPenerimaHer;
	}
	public String getNamaPenerimaHer() {
		return namaPenerimaHer;
	}
	public void setNamaPenerimaHer(String namaPenerimaHer) {
		this.namaPenerimaHer = namaPenerimaHer;
	}
	public Date getTglLahirPenerimaHer() {
		return tglLahirPenerimaHer;
	}
	public void setTglLahirPenerimaHer(Date tglLahirPenerimaHer) {
		this.tglLahirPenerimaHer = tglLahirPenerimaHer;
	}
	public Date getTglMeninggalPenerimaHer() {
		return tglMeninggalPenerimaHer;
	}
	public void setTglMeninggalPenerimaHer(Date tglMeninggalPenerimaHer) {
		this.tglMeninggalPenerimaHer = tglMeninggalPenerimaHer;
	}
	public Long getIdSuskelHer() {
		return idSuskelHer;
	}
	public void setIdSuskelHer(Long idSuskelHer) {
		this.idSuskelHer = idSuskelHer;
	}
	public String getNamaSuskelHer() {
		return namaSuskelHer;
	}
	public void setNamaSuskelHer(String namaSuskelHer) {
		this.namaSuskelHer = namaSuskelHer;
	}
	public Long getIdKantorBayarHer() {
		return idKantorBayarHer;
	}
	public void setIdKantorBayarHer(Long idKantorBayarHer) {
		this.idKantorBayarHer = idKantorBayarHer;
	}
	public String getNamaKantorBayarHer() {
		return namaKantorBayarHer;
	}
	public void setNamaKantorBayarHer(String namaKantorBayarHer) {
		this.namaKantorBayarHer = namaKantorBayarHer;
	}
	public String getAlamatIsDalamNegeriHer() {
		return alamatIsDalamNegeriHer;
	}
	public void setAlamatIsDalamNegeriHer(String alamatIsDalamNegeriHer) {
		this.alamatIsDalamNegeriHer = alamatIsDalamNegeriHer;
	}
	public String getAlamatLengkapHer() {
		return alamatLengkapHer;
	}
	public void setAlamatLengkapHer(String alamatLengkapHer) {
		this.alamatLengkapHer = alamatLengkapHer;
	}
	public String getRtHer() {
		return rtHer;
	}
	public void setRtHer(String rtHer) {
		this.rtHer = rtHer;
	}
	public String getRwHer() {
		return rwHer;
	}
	public void setRwHer(String rwHer) {
		this.rwHer = rwHer;
	}
	public Long getIdKelurahanHer() {
		return idKelurahanHer;
	}
	public void setIdKelurahanHer(Long idKelurahanHer) {
		this.idKelurahanHer = idKelurahanHer;
	}
	public String getNamaKelurahanHer() {
		return namaKelurahanHer;
	}
	public void setNamaKelurahanHer(String namaKelurahanHer) {
		this.namaKelurahanHer = namaKelurahanHer;
	}
	public Long getIdKecamatanHer() {
		return idKecamatanHer;
	}
	public void setIdKecamatanHer(Long idKecamatanHer) {
		this.idKecamatanHer = idKecamatanHer;
	}
	public String getNamaKecamatanHer() {
		return namaKecamatanHer;
	}
	public void setNamaKecamatanHer(String namaKecamatanHer) {
		this.namaKecamatanHer = namaKecamatanHer;
	}
	public Long getIdKotaKabHer() {
		return idKotaKabHer;
	}
	public void setIdKotaKabHer(Long idKotaKabHer) {
		this.idKotaKabHer = idKotaKabHer;
	}
	public String getNamaKotaKabHer() {
		return namaKotaKabHer;
	}
	public void setNamaKotaKabHer(String namaKotaKabHer) {
		this.namaKotaKabHer = namaKotaKabHer;
	}
	public Long getIdProvinsiHer() {
		return idProvinsiHer;
	}
	public void setIdProvinsiHer(Long idProvinsiHer) {
		this.idProvinsiHer = idProvinsiHer;
	}
	public String getNamaProvinsiHer() {
		return namaProvinsiHer;
	}
	public void setNamaProvinsiHer(String namaProvinsiHer) {
		this.namaProvinsiHer = namaProvinsiHer;
	}
	public String getKodePosHer() {
		return kodePosHer;
	}
	public void setKodePosHer(String kodePosHer) {
		this.kodePosHer = kodePosHer;
	}
	public Long getIdNegaraHer() {
		return idNegaraHer;
	}
	public void setIdNegaraHer(Long idNegaraHer) {
		this.idNegaraHer = idNegaraHer;
	}
	public String getNamaNegaraHer() {
		return namaNegaraHer;
	}
	public void setNamaNegaraHer(String namaNegaraHer) {
		this.namaNegaraHer = namaNegaraHer;
	}
	public String getNoTlpRumah() {
		return noTlpRumah;
	}
	public void setNoTlpRumah(String noTlpRumah) {
		this.noTlpRumah = noTlpRumah;
	}
	public String getNoTlpRumahHer() {
		return noTlpRumahHer;
	}
	public void setNoTlpRumahHer(String noTlpRumahHer) {
		this.noTlpRumahHer = noTlpRumahHer;
	}
	public String getNoHpHer() {
		return noHpHer;
	}
	public void setNoHpHer(String noHpHer) {
		this.noHpHer = noHpHer;
	}
	public String getEmailHer() {
		return emailHer;
	}
	public void setEmailHer(String emailHer) {
		this.emailHer = emailHer;
	}
	public Boolean getIsNamaPenerimaSama() {
		return isNamaPenerimaSama;
	}
	public void setIsNamaPenerimaSama(Boolean isNamaPenerimaSama) {
		this.isNamaPenerimaSama = isNamaPenerimaSama;
	}
	public Boolean getIsTglLahirSama() {
		return isTglLahirSama;
	}
	public void setIsTglLahirSama(Boolean isTglLahirSama) {
		this.isTglLahirSama = isTglLahirSama;
	}
	public Boolean getIsSuskelSama() {
		return isSuskelSama;
	}
	public void setIsSuskelSama(Boolean isSuskelSama) {
		this.isSuskelSama = isSuskelSama;
	}
	public Boolean getIsKantorBayarSama() {
		return isKantorBayarSama;
	}
	public void setIsKantorBayarSama(Boolean isKantorBayarSama) {
		this.isKantorBayarSama = isKantorBayarSama;
	}
	public Boolean getIsAlamatSama() {
		return isAlamatSama;
	}
	public void setIsAlamatSama(Boolean isAlamatSama) {
		this.isAlamatSama = isAlamatSama;
	}
	public Boolean getIsAdaPhoto() {
		return isAdaPhoto;
	}
	public void setIsAdaPhoto(Boolean isAdaPhoto) {
		this.isAdaPhoto = isAdaPhoto;
	}
	public Boolean getIsAdaKtp() {
		return isAdaKtp;
	}
	public void setIsAdaKtp(Boolean isAdaKtp) {
		this.isAdaKtp = isAdaKtp;
	}
	public Boolean getIsAdaKk() {
		return isAdaKk;
	}
	public void setIsAdaKk(Boolean isAdaKk) {
		this.isAdaKk = isAdaKk;
	}
	public Boolean getIsDataLengkap() {
		return isDataLengkap;
	}
	public void setIsDataLengkap(Boolean isDataLengkap) {
		this.isDataLengkap = isDataLengkap;
	}
	public Boolean getIsPenerimaMenikahLagi() {
		return isPenerimaMenikahLagi;
	}
	public void setIsPenerimaMenikahLagi(Boolean isPenerimaMenikahLagi) {
		this.isPenerimaMenikahLagi = isPenerimaMenikahLagi;
	}
	public String getTempatMenikah() {
		return tempatMenikah;
	}
	public void setTempatMenikah(String tempatMenikah) {
		this.tempatMenikah = tempatMenikah;
	}
	public Date getTglMenikah() {
		return tglMenikah;
	}
	public void setTglMenikah(Date tglMenikah) {
		this.tglMenikah = tglMenikah;
	}
	public Long getIdSerah() {
		return idSerah;
	}
	public void setIdSerah(Long idSerah) {
		this.idSerah = idSerah;
	}
	public String getNamaSerah() {
		return namaSerah;
	}
	public void setNamaSerah(String namaSerah) {
		this.namaSerah = namaSerah;
	}
	public String getKeteranganSerah() {
		return keteranganSerah;
	}
	public void setKeteranganSerah(String keteranganSerah) {
		this.keteranganSerah = keteranganSerah;
	}
	public Long getIdCatatan() {
		return idCatatan;
	}
	public void setIdCatatan(Long idCatatan) {
		this.idCatatan = idCatatan;
	}
	public String getNamaCatatan() {
		return namaCatatan;
	}
	public void setNamaCatatan(String namaCatatan) {
		this.namaCatatan = namaCatatan;
	}
	public String getCatatan() {
		return catatan;
	}
	public void setCatatan(String catatan) {
		this.catatan = catatan;
	}
	public Long getIdValidasi() {
		return idValidasi;
	}
	public void setIdValidasi(Long idValidasi) {
		this.idValidasi = idValidasi;
	}
	public String getNamaValidasi() {
		return namaValidasi;
	}
	public void setNamaValidasi(String namaValidasi) {
		this.namaValidasi = namaValidasi;
	}
	public String getUserStamp() {
		return userStamp;
	}
	public void setUserStamp(String userStamp) {
		this.userStamp = userStamp;
	}
	public String getUserValidasi() {
		return userValidasi;
	}
	public void setUserValidasi(String userValidasi) {
		this.userValidasi = userValidasi;
	}
	public Boolean getIsHerOtomatis() {
		return isHerOtomatis;
	}
	public void setIsHerOtomatis(Boolean isHerOtomatis) {
		this.isHerOtomatis = isHerOtomatis;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public Boolean getIsSudahHer() {
		return isSudahHer;
	}
	public void setIsSudahHer(Boolean isSudahHer) {
		this.isSudahHer = isSudahHer;
	}
	public String getStatusHerDesc() {
		return statusHerDesc;
	}
	public void setStatusHerDesc(String statusHerDesc) {
		this.statusHerDesc = statusHerDesc;
	}
	
	

}
