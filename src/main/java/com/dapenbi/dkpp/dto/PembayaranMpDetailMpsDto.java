package com.dapenbi.dkpp.dto;

import com.dapenbi.dkpp.model.PembayaranMp;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class PembayaranMpDetailMpsDto {

	private Long id;
	private PembayaranMpDto idPembayaran;
	private String nip;
	private String namaPeserta;
	private KantorBayarDto idKantorBayar;
	private String namaKantorBayar;
	private String idPenerimaMp;
	private String namaPenerimaMp;
	private KategoriPensiunDto idKategoriPensiun;
	private String namaKategoriPensiun;
	private Long nomorRekening;
	private String statusHerDesc;
	private JenisMpsDto idJenisMps;
	private String namaJenisMps;
	private Long mps20persen;
	private Long rapelKbMps20persenPhdp;
	private Long rapelLbMps20persenPhdp;
	private Long mps10juta;
	private Long rapelKbMps10jutaPhdp;
	private Long rapelLbMps10jutaPhdp;
	private Long mps100persen;
	private Long mps100persenBulat;
	private Long rapelKbMps100persenPhdp;
	private Long rapelLbMps100persenPhdp;
	private String userStamp;
	private Character idSentToPtr;
	private Character isStatusHer;
	private Character isHutang;
	private Long mpyd;
	private FaktorFprDto idFaktorFpr;
	private String namaFaktorFpr;
	private Long nilaiFpr;
	private FaktorFsDto idFaktorFs;
	private String namaFaktorFs;
	private Long nilaiFs;
	private GolonganDto idGolongan;
	private String namaGolongan;
	private String pangkat;
	private String jabatan;
	private KategoriPenerimaDto idKategoriPenerimaMp;
	private String namaKategoriPenerimaMp;
	private StatusBayarDto idStatusBayar;
	private String masaKerjaHenti;
	private String masaKerjaHentiBulat;
	private String masaKerjaMp;
	private String masaKerjaTambahan;
	private String masaKerjaTambahanBulat;
	private String masaKerjaVeteran;
	private String masaKerjaVeteranBulat;
	private Long phdp;
	private Date tglAwalBayar;
	private Date tglDpthtPeserta;
	private Date tglHentiBayar;
	private Date tglHentiPesertaKerja;
	private Date tglKerjaPeserta;
	private Date tglLahirPenerimaMp;
	private Date tglLahirPeserta;
	private Date tglMeninggalPeserta;
	private Date tglTundaJatuhTempo;
	private String totalMasaKerja;
	private String totalMasaKerjaBulat;
	private String totalMasaKerjaAdj;
	private String totalMasaKerjaAdjBulat;
	private String usiaPenerimaBayar;
	private String usiaPenerimaBayarBulat;
	private String usiaSaatHenti;
	private String usiaSaatHentiBulat;
	private String faktorFs;
	private Character jenisKelaminPeserta;
	private Character jenisKelaminPenerimaMp;
	private String namaStatusBayar;
	private UsiaBayarDto idUsiaBayar;
	private String namaUsiaBayar;
	private Date tglMpBulanKe13;
	private SuskelDto idSuskel;
	private String namaSuskel;
	private String npwp;
	private String nik;
	private Character isSentToPtr;
	private Long rapelKbMps20persenKenaikan;
	private Long rapelLbMps20persenKenaikan;
	private Long rapelKbMps10jtKenaikan;
	private Long rapelLbMps10jtKenaikan;
	private Long rapelKbMps100persenKenaikan;
	private Long rapelLbMps100persenKenaikan;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PembayaranMpDto getIdPembayaran() {
		return idPembayaran;
	}

	public void setIdPembayaran(PembayaranMpDto idPembayaran) {
		this.idPembayaran = idPembayaran;
	}

	public String getNip() {
		return nip;
	}

	public void setNip(String nip) {
		this.nip = nip;
	}

	public String getNamaPeserta() {
		return namaPeserta;
	}

	public void setNamaPeserta(String namaPeserta) {
		this.namaPeserta = namaPeserta;
	}

	public KantorBayarDto getIdKantorBayar() {
		return idKantorBayar;
	}

	public void setIdKantorBayar(KantorBayarDto idKantorBayar) {
		this.idKantorBayar = idKantorBayar;
	}

	public String getNamaKantorBayar() {
		return namaKantorBayar;
	}

	public void setNamaKantorBayar(String namaKantorBayar) {
		this.namaKantorBayar = namaKantorBayar;
	}

	public String getIdPenerimaMp() {
		return idPenerimaMp;
	}

	public void setIdPenerimaMp(String idPenerimaMp) {
		this.idPenerimaMp = idPenerimaMp;
	}

	public String getNamaPenerimaMp() {
		return namaPenerimaMp;
	}

	public void setNamaPenerimaMp(String namaPenerimaMp) {
		this.namaPenerimaMp = namaPenerimaMp;
	}

	public KategoriPensiunDto getIdKategoriPensiun() {
		return idKategoriPensiun;
	}

	public void setIdKategoriPensiun(KategoriPensiunDto idKategoriPensiun) {
		this.idKategoriPensiun = idKategoriPensiun;
	}

	public String getNamaKategoriPensiun() {
		return namaKategoriPensiun;
	}

	public void setNamaKategoriPensiun(String namaKategoriPensiun) {
		this.namaKategoriPensiun = namaKategoriPensiun;
	}

	public Long getNomorRekening() {
		return nomorRekening;
	}

	public void setNomorRekening(Long nomorRekening) {
		this.nomorRekening = nomorRekening;
	}

	public String getStatusHerDesc() {
		return statusHerDesc;
	}

	public void setStatusHerDesc(String statusHerDesc) {
		this.statusHerDesc = statusHerDesc;
	}

	public JenisMpsDto getIdJenisMps() {
		return idJenisMps;
	}

	public void setIdJenisMps(JenisMpsDto idJenisMps) {
		this.idJenisMps = idJenisMps;
	}

	public String getNamaJenisMps() {
		return namaJenisMps;
	}

	public void setNamaJenisMps(String namaJenisMps) {
		this.namaJenisMps = namaJenisMps;
	}

	public Long getMps20persen() {
		return mps20persen;
	}

	public void setMps20persen(Long mps20persen) {
		this.mps20persen = mps20persen;
	}

	public Long getRapelKbMps20persenPhdp() {
		return rapelKbMps20persenPhdp;
	}

	public void setRapelKbMps20persenPhdp(Long rapelKbMps20persenPhdp) {
		this.rapelKbMps20persenPhdp = rapelKbMps20persenPhdp;
	}

	public Long getRapelLbMps20persenPhdp() {
		return rapelLbMps20persenPhdp;
	}

	public void setRapelLbMps20persenPhdp(Long rapelLbMps20persenPhdp) {
		this.rapelLbMps20persenPhdp = rapelLbMps20persenPhdp;
	}

	public Long getMps10juta() {
		return mps10juta;
	}

	public void setMps10juta(Long mps10juta) {
		this.mps10juta = mps10juta;
	}

	public Long getRapelKbMps10jutaPhdp() {
		return rapelKbMps10jutaPhdp;
	}

	public void setRapelKbMps10jutaPhdp(Long rapelKbMps10jutaPhdp) {
		this.rapelKbMps10jutaPhdp = rapelKbMps10jutaPhdp;
	}

	public Long getRapelLbMps10jutaPhdp() {
		return rapelLbMps10jutaPhdp;
	}

	public void setRapelLbMps10jutaPhdp(Long rapelLbMps10jutaPhdp) {
		this.rapelLbMps10jutaPhdp = rapelLbMps10jutaPhdp;
	}

	public Long getMps100persen() {
		return mps100persen;
	}

	public void setMps100persen(Long mps100persen) {
		this.mps100persen = mps100persen;
	}

	public Long getMps100persenBulat() {
		return mps100persenBulat;
	}

	public void setMps100persenBulat(Long mps100persenBulat) {
		this.mps100persenBulat = mps100persenBulat;
	}

	public Long getRapelKbMps100persenPhdp() {
		return rapelKbMps100persenPhdp;
	}

	public void setRapelKbMps100persenPhdp(Long rapelKbMps100persenPhdp) {
		this.rapelKbMps100persenPhdp = rapelKbMps100persenPhdp;
	}

	public Long getRapelLbMps100persenPhdp() {
		return rapelLbMps100persenPhdp;
	}

	public void setRapelLbMps100persenPhdp(Long rapelLbMps100persenPhdp) {
		this.rapelLbMps100persenPhdp = rapelLbMps100persenPhdp;
	}

	public String getUserStamp() {
		return userStamp;
	}

	public void setUserStamp(String userStamp) {
		this.userStamp = userStamp;
	}

	public Character getIdSentToPtr() {
		return idSentToPtr;
	}

	public void setIdSentToPtr(Character idSentToPtr) {
		this.idSentToPtr = idSentToPtr;
	}

	public Character getIsStatusHer() {
		return isStatusHer;
	}

	public void setIsStatusHer(Character isStatusHer) {
		this.isStatusHer = isStatusHer;
	}

	public Character getIsHutang() {
		return isHutang;
	}

	public void setIsHutang(Character isHutang) {
		this.isHutang = isHutang;
	}

	public Long getMpyd() {
		return mpyd;
	}

	public void setMpyd(Long mpyd) {
		this.mpyd = mpyd;
	}

	public FaktorFprDto getIdFaktorFpr() {
		return idFaktorFpr;
	}

	public void setIdFaktorFpr(FaktorFprDto idFaktorFpr) {
		this.idFaktorFpr = idFaktorFpr;
	}

	public String getNamaFaktorFpr() {
		return namaFaktorFpr;
	}

	public void setNamaFaktorFpr(String namaFaktorFpr) {
		this.namaFaktorFpr = namaFaktorFpr;
	}

	public Long getNilaiFpr() {
		return nilaiFpr;
	}

	public void setNilaiFpr(Long nilaiFpr) {
		this.nilaiFpr = nilaiFpr;
	}

	public FaktorFsDto getIdFaktorFs() {
		return idFaktorFs;
	}

	public void setIdFaktorFs(FaktorFsDto idFaktorFs) {
		this.idFaktorFs = idFaktorFs;
	}

	public String getNamaFaktorFs() {
		return namaFaktorFs;
	}

	public void setNamaFaktorFs(String namaFaktorFs) {
		this.namaFaktorFs = namaFaktorFs;
	}

	public Long getNilaiFs() {
		return nilaiFs;
	}

	public void setNilaiFs(Long nilaiFs) {
		this.nilaiFs = nilaiFs;
	}

	public GolonganDto getIdGolongan() {
		return idGolongan;
	}

	public void setIdGolongan(GolonganDto idGolongan) {
		this.idGolongan = idGolongan;
	}

	public String getNamaGolongan() {
		return namaGolongan;
	}

	public void setNamaGolongan(String namaGolongan) {
		this.namaGolongan = namaGolongan;
	}

	public String getPangkat() {
		return pangkat;
	}

	public void setPangkat(String pangkat) {
		this.pangkat = pangkat;
	}

	public String getJabatan() {
		return jabatan;
	}

	public void setJabatan(String jabatan) {
		this.jabatan = jabatan;
	}

	public KategoriPenerimaDto getIdKategoriPenerimaMp() {
		return idKategoriPenerimaMp;
	}

	public void setIdKategoriPenerimaMp(KategoriPenerimaDto idKategoriPenerimaMp) {
		this.idKategoriPenerimaMp = idKategoriPenerimaMp;
	}

	public String getNamaKategoriPenerimaMp() {
		return namaKategoriPenerimaMp;
	}

	public void setNamaKategoriPenerimaMp(String namaKategoriPenerimaMp) {
		this.namaKategoriPenerimaMp = namaKategoriPenerimaMp;
	}

	public StatusBayarDto getIdStatusBayar() {
		return idStatusBayar;
	}

	public void setIdStatusBayar(StatusBayarDto idStatusBayar) {
		this.idStatusBayar = idStatusBayar;
	}

	public String getMasaKerjaHenti() {
		return masaKerjaHenti;
	}

	public void setMasaKerjaHenti(String masaKerjaHenti) {
		this.masaKerjaHenti = masaKerjaHenti;
	}

	public String getMasaKerjaHentiBulat() {
		return masaKerjaHentiBulat;
	}

	public void setMasaKerjaHentiBulat(String masaKerjaHentiBulat) {
		this.masaKerjaHentiBulat = masaKerjaHentiBulat;
	}

	public String getMasaKerjaMp() {
		return masaKerjaMp;
	}

	public void setMasaKerjaMp(String masaKerjaMp) {
		this.masaKerjaMp = masaKerjaMp;
	}

	public String getMasaKerjaTambahan() {
		return masaKerjaTambahan;
	}

	public void setMasaKerjaTambahan(String masaKerjaTambahan) {
		this.masaKerjaTambahan = masaKerjaTambahan;
	}

	public String getMasaKerjaTambahanBulat() {
		return masaKerjaTambahanBulat;
	}

	public void setMasaKerjaTambahanBulat(String masaKerjaTambahanBulat) {
		this.masaKerjaTambahanBulat = masaKerjaTambahanBulat;
	}

	public String getMasaKerjaVeteran() {
		return masaKerjaVeteran;
	}

	public void setMasaKerjaVeteran(String masaKerjaVeteran) {
		this.masaKerjaVeteran = masaKerjaVeteran;
	}

	public String getMasaKerjaVeteranBulat() {
		return masaKerjaVeteranBulat;
	}

	public void setMasaKerjaVeteranBulat(String masaKerjaVeteranBulat) {
		this.masaKerjaVeteranBulat = masaKerjaVeteranBulat;
	}

	public Long getPhdp() {
		return phdp;
	}

	public void setPhdp(Long phdp) {
		this.phdp = phdp;
	}

	public Date getTglAwalBayar() {
		return tglAwalBayar;
	}

	public void setTglAwalBayar(Date tglAwalBayar) {
		this.tglAwalBayar = tglAwalBayar;
	}

	public Date getTglDpthtPeserta() {
		return tglDpthtPeserta;
	}

	public void setTglDpthtPeserta(Date tglDpthtPeserta) {
		this.tglDpthtPeserta = tglDpthtPeserta;
	}

	public Date getTglHentiBayar() {
		return tglHentiBayar;
	}

	public void setTglHentiBayar(Date tglHentiBayar) {
		this.tglHentiBayar = tglHentiBayar;
	}

	public Date getTglHentiPesertaKerja() {
		return tglHentiPesertaKerja;
	}

	public void setTglHentiPesertaKerja(Date tglHentiPesertaKerja) {
		this.tglHentiPesertaKerja = tglHentiPesertaKerja;
	}

	public Date getTglKerjaPeserta() {
		return tglKerjaPeserta;
	}

	public void setTglKerjaPeserta(Date tglKerjaPeserta) {
		this.tglKerjaPeserta = tglKerjaPeserta;
	}

	public Date getTglLahirPenerimaMp() {
		return tglLahirPenerimaMp;
	}

	public void setTglLahirPenerimaMp(Date tglLahirPenerimaMp) {
		this.tglLahirPenerimaMp = tglLahirPenerimaMp;
	}

	public Date getTglLahirPeserta() {
		return tglLahirPeserta;
	}

	public void setTglLahirPeserta(Date tglLahirPeserta) {
		this.tglLahirPeserta = tglLahirPeserta;
	}

	public Date getTglMeninggalPeserta() {
		return tglMeninggalPeserta;
	}

	public void setTglMeninggalPeserta(Date tglMeninggalPeserta) {
		this.tglMeninggalPeserta = tglMeninggalPeserta;
	}

	public Date getTglTundaJatuhTempo() {
		return tglTundaJatuhTempo;
	}

	public void setTglTundaJatuhTempo(Date tglTundaJatuhTempo) {
		this.tglTundaJatuhTempo = tglTundaJatuhTempo;
	}

	public String getTotalMasaKerja() {
		return totalMasaKerja;
	}

	public void setTotalMasaKerja(String totalMasaKerja) {
		this.totalMasaKerja = totalMasaKerja;
	}

	public String getTotalMasaKerjaBulat() {
		return totalMasaKerjaBulat;
	}

	public void setTotalMasaKerjaBulat(String totalMasaKerjaBulat) {
		this.totalMasaKerjaBulat = totalMasaKerjaBulat;
	}

	public String getTotalMasaKerjaAdj() {
		return totalMasaKerjaAdj;
	}

	public void setTotalMasaKerjaAdj(String totalMasaKerjaAdj) {
		this.totalMasaKerjaAdj = totalMasaKerjaAdj;
	}

	public String getTotalMasaKerjaAdjBulat() {
		return totalMasaKerjaAdjBulat;
	}

	public void setTotalMasaKerjaAdjBulat(String totalMasaKerjaAdjBulat) {
		this.totalMasaKerjaAdjBulat = totalMasaKerjaAdjBulat;
	}

	public String getUsiaPenerimaBayar() {
		return usiaPenerimaBayar;
	}

	public void setUsiaPenerimaBayar(String usiaPenerimaBayar) {
		this.usiaPenerimaBayar = usiaPenerimaBayar;
	}

	public String getUsiaPenerimaBayarBulat() {
		return usiaPenerimaBayarBulat;
	}

	public void setUsiaPenerimaBayarBulat(String usiaPenerimaBayarBulat) {
		this.usiaPenerimaBayarBulat = usiaPenerimaBayarBulat;
	}

	public String getUsiaSaatHenti() {
		return usiaSaatHenti;
	}

	public void setUsiaSaatHenti(String usiaSaatHenti) {
		this.usiaSaatHenti = usiaSaatHenti;
	}

	public String getUsiaSaatHentiBulat() {
		return usiaSaatHentiBulat;
	}

	public void setUsiaSaatHentiBulat(String usiaSaatHentiBulat) {
		this.usiaSaatHentiBulat = usiaSaatHentiBulat;
	}

	public String getFaktorFs() {
		return faktorFs;
	}

	public void setFaktorFs(String faktorFs) {
		this.faktorFs = faktorFs;
	}

	public Character getJenisKelaminPeserta() {
		return jenisKelaminPeserta;
	}

	public void setJenisKelaminPeserta(Character jenisKelaminPeserta) {
		this.jenisKelaminPeserta = jenisKelaminPeserta;
	}

	public Character getJenisKelaminPenerimaMp() {
		return jenisKelaminPenerimaMp;
	}

	public void setJenisKelaminPenerimaMp(Character jenisKelaminPenerimaMp) {
		this.jenisKelaminPenerimaMp = jenisKelaminPenerimaMp;
	}

	public String getNamaStatusBayar() {
		return namaStatusBayar;
	}

	public void setNamaStatusBayar(String namaStatusBayar) {
		this.namaStatusBayar = namaStatusBayar;
	}

	public UsiaBayarDto getIdUsiaBayar() {
		return idUsiaBayar;
	}

	public void setIdUsiaBayar(UsiaBayarDto idUsiaBayar) {
		this.idUsiaBayar = idUsiaBayar;
	}

	public String getNamaUsiaBayar() {
		return namaUsiaBayar;
	}

	public void setNamaUsiaBayar(String namaUsiaBayar) {
		this.namaUsiaBayar = namaUsiaBayar;
	}

	public Date getTglMpBulanKe13() {
		return tglMpBulanKe13;
	}

	public void setTglMpBulanKe13(Date tglMpBulanKe13) {
		this.tglMpBulanKe13 = tglMpBulanKe13;
	}

	public SuskelDto getIdSuskel() {
		return idSuskel;
	}

	public void setIdSuskel(SuskelDto idSuskel) {
		this.idSuskel = idSuskel;
	}

	public String getNamaSuskel() {
		return namaSuskel;
	}

	public void setNamaSuskel(String namaSuskel) {
		this.namaSuskel = namaSuskel;
	}

	public String getNpwp() {
		return npwp;
	}

	public void setNpwp(String npwp) {
		this.npwp = npwp;
	}

	public String getNik() {
		return nik;
	}

	public void setNik(String nik) {
		this.nik = nik;
	}

	public Character getIsSentToPtr() {
		return isSentToPtr;
	}

	public void setIsSentToPtr(Character isSentToPtr) {
		this.isSentToPtr = isSentToPtr;
	}

	public Long getRapelKbMps20persenKenaikan() {
		return rapelKbMps20persenKenaikan;
	}

	public void setRapelKbMps20persenKenaikan(Long rapelKbMps20persenKenaikan) {
		this.rapelKbMps20persenKenaikan = rapelKbMps20persenKenaikan;
	}

	public Long getRapelLbMps20persenKenaikan() {
		return rapelLbMps20persenKenaikan;
	}

	public void setRapelLbMps20persenKenaikan(Long rapelLbMps20persenKenaikan) {
		this.rapelLbMps20persenKenaikan = rapelLbMps20persenKenaikan;
	}

	public Long getRapelKbMps10jtKenaikan() {
		return rapelKbMps10jtKenaikan;
	}

	public void setRapelKbMps10jtKenaikan(Long rapelKbMps10jtKenaikan) {
		this.rapelKbMps10jtKenaikan = rapelKbMps10jtKenaikan;
	}

	public Long getRapelLbMps10jtKenaikan() {
		return rapelLbMps10jtKenaikan;
	}

	public void setRapelLbMps10jtKenaikan(Long rapelLbMps10jtKenaikan) {
		this.rapelLbMps10jtKenaikan = rapelLbMps10jtKenaikan;
	}

	public Long getRapelKbMps100persenKenaikan() {
		return rapelKbMps100persenKenaikan;
	}

	public void setRapelKbMps100persenKenaikan(Long rapelKbMps100persenKenaikan) {
		this.rapelKbMps100persenKenaikan = rapelKbMps100persenKenaikan;
	}

	public Long getRapelLbMps100persenKenaikan() {
		return rapelLbMps100persenKenaikan;
	}

	public void setRapelLbMps100persenKenaikan(Long rapelLbMps100persenKenaikan) {
		this.rapelLbMps100persenKenaikan = rapelLbMps100persenKenaikan;
	}
}