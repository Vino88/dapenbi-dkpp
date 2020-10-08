package com.dapenbi.dkpp.model;

import javax.persistence.*;
import com.dapenbi.dkpp.dto.PembayaranMpDetailMpsDto;

import java.util.Date;

@Entity
@Table(name = "TBL_T_PEMBAYARAN_DETAIL_MPS")
public class PembayaranMpDetailMps extends BaseModel<PembayaranMpDetailMpsDto>{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_PEMBAYARAN_DETAIL_MPS_SEQ")
	@SequenceGenerator(sequenceName = "pembayaranId_seq", allocationSize = 1, name = "ID_PEMBAYARAN_DETAIL_MPS_SEQ")
	@Column(name = "ID_DETAIL_MPS", length = 22)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PEMBAYARAN")
	private PembayaranMp idPembayaran;

	@Column(name = "NIP", length = 10)
	private String nip;

	@Column(name = "NAMA_PESERTA", length = 50)
	private String namaPeserta;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_KANTOR_BAYAR")
	private KantorBayar idKantorBayar;


	@Column(name = "NAMA_KANTOR_BAYAR", length = 50)
	private String namaKantorBayar;

	@Column(name = "ID_PENERIMA_MP", length = 50)
	private String idPenerimaMp;

	@Column(name = "NAMA_PENERIMA_MP", length = 50)
	private String namaPenerimaMp;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_KATEGORI_PENSIUN")
	private KategoriPensiun idKategoriPensiun;

	@Column(name = "NAMA_KATEGORI_PENSIUN", length = 50)
	private String namaKategoriPensiun;

	@Column(name = "NOMOR_REKENING", length = 22)
	private Long nomorRekening;

	@Column(name = "STATUS_HER_DESC", length = 50)
	private String statusHerDesc;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_JENIS_MPS")
	private JenisMps idJenisMps;

	@Column(name = "NAMA_JENIS_MPS", length = 50)
	private String namaJenisMps;

	@Column(name = "MPS20PERSEN", length = 22)
	private Long mps20persen;

	@Column(name = "RAPEL_KB_MPS20PERSEN_PHDP", length = 22)
	private Long rapelKbMps20persenPhdp;

	@Column(name = "RAPEL_LB_MPS20PERSEN_PHDP", length = 22)
	private Long rapelLbMps20persenPhdp;

	@Column(name = "MPS10JUTA", length = 22)
	private Long mps10juta;

	@Column(name = "RAPEL_KB_MPS10JUTA_PHDP", length = 22)
	private Long rapelKbMps10jutaPhdp;

	@Column(name = "RAPEL_LB_MPS10JUTA_PHDP", length = 22)
	private Long rapelLbMps10jutaPhdp;

	@Column(name = "MPS100PERSEN", length = 22)
	private Long mps100persen;

	@Column(name = "MPS100PERSEN_BULAT", length = 22)
	private Long mps100persenBulat;

	@Column(name = "RAPEL_KB_MPS100PERSEN_PHDP", length = 22)
	private Long rapelKbMps100persenPhdp;

	@Column(name = "RAPEL_LB_MPS100PERSEN_PHDP", length = 22)
	private Long rapelLbMps100persenPhdp;

	@Column(name = "USER_STAMP", length = 50)
	private String userStamp;

	@Column(name = "ID_SENT_TO_PTR", length = 1)
	private Character idSentToPtr;

	@Column(name = "IS_STATUS_HER", length = 1)
	private Character isStatusHer;

	@Column(name = "IS_HUTANG", length = 1)
	private Character isHutang;

	@Column(name = "MPYD", length = 22)
	private Long mpyd;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_FAKTOR_FPR")
	private FaktorFPR idFaktorFpr;

	@Column(name = "NAMA_FAKTOR_FPR", length = 100)
	private String namaFaktorFpr;

	@Column(name = "NILAI_FPR", length = 22)
	private Long nilaiFpr;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_FAKTOR_FS")
	private FaktorFs idFaktorFs;

	@Column(name = "NAMA_FAKTOR_FS", length = 100)
	private String namaFaktorFs;

	@Column(name = "NILAI_FS", length = 22)
	private Long nilaiFs;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_GOLONGAN")
	private Golongan idGolongan;

	@Column(name = "NAMA_GOLONGAN", length = 100)
	private String namaGolongan;

	@Column(name = "PANGKAT", length = 100)
	private String pangkat;

	@Column(name = "JABATAN", length = 100)
	private String jabatan;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_KATEGORI_PENERIMA_MP")
	private KategoriPenerima idKategoriPenerimaMp;

	@Column(name = "NAMA_KATEGORI_PENERIMA_MP", length = 50)
	private String namaKategoriPenerimaMp;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_STATUS_BAYAR")
	private StatusBayar idStatusBayar;

	@Column(name = "MASA_KERJA_HENTI", length = 6)
	private String masaKerjaHenti;

	@Column(name = "MASA_KERJA_HENTI_BULAT", length = 4)
	private String masaKerjaHentiBulat;

	@Column(name = "MASA_KERJA_MP", length = 4)
	private String masaKerjaMp;

	@Column(name = "MASA_KERJA_TAMBAHAN", length = 6)
	private String masaKerjaTambahan;

	@Column(name = "MASA_KERJA_TAMBAHAN_BULAT", length = 4)
	private String masaKerjaTambahanBulat;

	@Column(name = "MASA_KERJA_VETERAN", length = 6)
	private String masaKerjaVeteran;

	@Column(name = "MASA_KERJA_VETERAN_BULAT", length = 4)
	private String masaKerjaVeteranBulat;

	@Column(name = "PHDP", length = 22)
	private Long phdp;

	@Column(name = "TGL_AWAL_BAYAR", length = 7)
	private Date tglAwalBayar;

	@Column(name = "TGL_DPTHT_PESERTA", length = 7)
	private Date tglDpthtPeserta;

	@Column(name = "TGL_HENTI_BAYAR", length = 7)
	private Date tglHentiBayar;

	@Column(name = "TGL_HENTI_PESERTA_KERJA", length = 7)
	private Date tglHentiPesertaKerja;

	@Column(name = "TGL_KERJA_PESERTA", length = 7)
	private Date tglKerjaPeserta;

	@Column(name = "TGL_LAHIR_PENERIMA_MP", length = 7)
	private Date tglLahirPenerimaMp;

	@Column(name = "TGL_LAHIR_PESERTA", length = 7)
	private Date tglLahirPeserta;

	@Column(name = "TGL_MENINGGAL_PESERTA", length = 7)
	private Date tglMeninggalPeserta;

	@Column(name = "TGL_TUNDA_JATUH_TEMPO", length = 7)
	private Date tglTundaJatuhTempo;

	@Column(name = "TOTAL_MASA_KERJA", length = 6)
	private String totalMasaKerja;

	@Column(name = "TOTAL_MASA_KERJA_BULAT", length = 4)
	private String totalMasaKerjaBulat;

	@Column(name = "TOTAL_MASA_KERJA_ADJ", length = 6)
	private String totalMasaKerjaAdj;

	@Column(name = "TOTAL_MASA_KERJA_ADJ_BULAT", length = 4)
	private String totalMasaKerjaAdjBulat;

	@Column(name = "USIA_PENERIMA_BAYAR", length = 6)
	private String usiaPenerimaBayar;

	@Column(name = "USIA_PENERIMA_BAYAR_BULAT", length = 4)
	private String usiaPenerimaBayarBulat;

	@Column(name = "USIA_SAAT_HENTI", length = 6)
	private String usiaSaatHenti;

	@Column(name = "USIA_SAAT_HENTI_BULAT", length = 4)
	private String usiaSaatHentiBulat;

	@Column(name = "FAKTOR_FS")
	private String faktorFs;

	@Column(name = "JENIS_KELAMIN_PESERTA", length = 1)
	private Character jenisKelaminPeserta;

	@Column(name = "JENIS_KELAMIN_PENERIMA_MP", length = 1)
	private Character jenisKelaminPenerimaMp;

	@Column(name = "NAMA_STATUS_BAYAR", length = 50)
	private String namaStatusBayar;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_USIA_BAYAR")
	private UsiaBayar idUsiaBayar;

	@Column(name = "NAMA_USIA_BAYAR", length = 50)
	private String namaUsiaBayar;

	@Column(name = "TGL_MP_BULAN_KE13", length = 7)
	private Date tglMpBulanKe13;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_SUSKEL")
	private Suskel idSuskel;

	@Column(name = "NAMA_SUSKEL", length = 20)
	private String namaSuskel;

	@Column(name = "NPWP", length = 50)
	private String npwp;

	@Column(name = "NIK", length = 50)
	private String nik;

	@Column(name = "IS_SENT_TO_PTR", length = 1)
	private Character isSentToPtr;

	@Column(name = "RAPEL_KB_MPS20PERSEN_KENAIKAN", length = 22)
	private Long rapelKbMps20persenKenaikan;

	@Column(name = "RAPEL_LB_MPS20PERSEN_KENAIKAN", length = 22)
	private Long rapelLbMps20persenKenaikan;

	@Column(name = "RAPEL_KB_MPS10JT_KENAIKAN", length = 22)
	private Long rapelKbMps10jtKenaikan;

	@Column(name = "RAPEL_LB_MPS10JT_KENAIKAN", length = 22)
	private Long rapelLbMps10jtKenaikan;

	@Column(name = "RAPEL_KB_MPS100PERSEN_KENAIKAN", length = 22)
	private Long rapelKbMps100persenKenaikan;

	@Column(name = "RAPEL_LB_MPS100PERSEN_KENAIKAN", length = 22)
	private Long rapelLbMps100persenKenaikan;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PembayaranMp getIdPembayaran() {
		return idPembayaran;
	}

	public void setIdPembayaran(PembayaranMp idPembayaran) {
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

	public KantorBayar getIdKantorBayar() {
		return idKantorBayar;
	}

	public void setIdKantorBayar(KantorBayar idKantorBayar) {
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

	public KategoriPensiun getIdKategoriPensiun() {
		return idKategoriPensiun;
	}

	public void setIdKategoriPensiun(KategoriPensiun idKategoriPensiun) {
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

	public JenisMps getIdJenisMps() {
		return idJenisMps;
	}

	public void setIdJenisMps(JenisMps idJenisMps) {
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

	@Override
	public String getUserStamp() {
		return userStamp;
	}

	@Override
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

	public FaktorFPR getIdFaktorFpr() {
		return idFaktorFpr;
	}

	public void setIdFaktorFpr(FaktorFPR idFaktorFpr) {
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

	public FaktorFs getIdFaktorFs() {
		return idFaktorFs;
	}

	public void setIdFaktorFs(FaktorFs idFaktorFs) {
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

	public Golongan getIdGolongan() {
		return idGolongan;
	}

	public void setIdGolongan(Golongan idGolongan) {
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

	public KategoriPenerima getIdKategoriPenerimaMp() {
		return idKategoriPenerimaMp;
	}

	public void setIdKategoriPenerimaMp(KategoriPenerima idKategoriPenerimaMp) {
		this.idKategoriPenerimaMp = idKategoriPenerimaMp;
	}

	public String getNamaKategoriPenerimaMp() {
		return namaKategoriPenerimaMp;
	}

	public void setNamaKategoriPenerimaMp(String namaKategoriPenerimaMp) {
		this.namaKategoriPenerimaMp = namaKategoriPenerimaMp;
	}

	public StatusBayar getIdStatusBayar() {
		return idStatusBayar;
	}

	public void setIdStatusBayar(StatusBayar idStatusBayar) {
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

	public UsiaBayar getIdUsiaBayar() {
		return idUsiaBayar;
	}

	public void setIdUsiaBayar(UsiaBayar idUsiaBayar) {
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

	public Suskel getIdSuskel() {
		return idSuskel;
	}

	public void setIdSuskel(Suskel idSuskel) {
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


	@Override
	public void fromDto(PembayaranMpDetailMpsDto dto){
		this.setId( dto.getId() );

		this.setNip( dto.getNip() );
		this.setNamaPeserta( dto.getNamaPeserta() );

		this.setNamaKantorBayar( dto.getNamaKantorBayar() );
		this.setIdPenerimaMp( dto.getIdPenerimaMp() );
		this.setNamaPenerimaMp( dto.getNamaPenerimaMp() );

		this.setNamaKategoriPensiun( dto.getNamaKategoriPensiun() );
		this.setNomorRekening( dto.getNomorRekening() );
		this.setStatusHerDesc( dto.getStatusHerDesc() );

		this.setNamaJenisMps( dto.getNamaJenisMps() );
		this.setMps20persen( dto.getMps20persen() );
		this.setRapelKbMps20persenPhdp( dto.getRapelKbMps20persenPhdp() );
		this.setRapelLbMps20persenPhdp( dto.getRapelLbMps20persenPhdp() );
		this.setMps10juta( dto.getMps10juta() );
		this.setRapelKbMps10jutaPhdp( dto.getRapelKbMps10jutaPhdp() );
		this.setRapelLbMps10jutaPhdp( dto.getRapelLbMps10jutaPhdp() );
		this.setMps100persen( dto.getMps100persen() );
		this.setMps100persenBulat( dto.getMps100persenBulat() );
		this.setRapelKbMps100persenPhdp( dto.getRapelKbMps100persenPhdp() );
		this.setRapelLbMps100persenPhdp( dto.getRapelLbMps100persenPhdp() );
		this.setUserStamp( dto.getUserStamp() );
		this.setIdSentToPtr( dto.getIdSentToPtr() );
		this.setIsStatusHer( dto.getIsStatusHer() );
		this.setIsHutang( dto.getIsHutang() );
		this.setMpyd( dto.getMpyd() );

		this.setNamaFaktorFpr( dto.getNamaFaktorFpr() );
		this.setNilaiFpr( dto.getNilaiFpr() );

		this.setNamaFaktorFs( dto.getNamaFaktorFs() );
		this.setNilaiFs( dto.getNilaiFs() );

		this.setNamaGolongan( dto.getNamaGolongan() );
		this.setPangkat( dto.getPangkat() );
		this.setJabatan( dto.getJabatan() );

		this.setNamaKategoriPenerimaMp( dto.getNamaKategoriPenerimaMp() );

		this.setMasaKerjaHenti( dto.getMasaKerjaHenti() );
		this.setMasaKerjaHentiBulat( dto.getMasaKerjaHentiBulat() );
		this.setMasaKerjaMp( dto.getMasaKerjaMp() );
		this.setMasaKerjaTambahan( dto.getMasaKerjaTambahan() );
		this.setMasaKerjaTambahanBulat( dto.getMasaKerjaTambahanBulat() );
		this.setMasaKerjaVeteran( dto.getMasaKerjaVeteran() );
		this.setMasaKerjaVeteranBulat( dto.getMasaKerjaVeteranBulat() );
		this.setPhdp( dto.getPhdp() );
		this.setTglAwalBayar( dto.getTglAwalBayar() );
		this.setTglDpthtPeserta( dto.getTglDpthtPeserta() );
		this.setTglHentiBayar( dto.getTglHentiBayar() );
		this.setTglHentiPesertaKerja( dto.getTglHentiPesertaKerja() );
		this.setTglKerjaPeserta( dto.getTglKerjaPeserta() );
		this.setTglLahirPenerimaMp( dto.getTglLahirPenerimaMp() );
		this.setTglLahirPeserta( dto.getTglLahirPeserta() );
		this.setTglMeninggalPeserta( dto.getTglMeninggalPeserta() );
		this.setTglTundaJatuhTempo( dto.getTglTundaJatuhTempo() );
		this.setTotalMasaKerja( dto.getTotalMasaKerja() );
		this.setTotalMasaKerjaBulat( dto.getTotalMasaKerjaBulat() );
		this.setTotalMasaKerjaAdj( dto.getTotalMasaKerjaAdj() );
		this.setTotalMasaKerjaAdjBulat( dto.getTotalMasaKerjaAdjBulat() );
		this.setUsiaPenerimaBayar( dto.getUsiaPenerimaBayar() );
		this.setUsiaPenerimaBayarBulat( dto.getUsiaPenerimaBayarBulat() );
		this.setUsiaSaatHenti( dto.getUsiaSaatHenti() );
		this.setUsiaSaatHentiBulat( dto.getUsiaSaatHentiBulat() );
		this.setFaktorFs( dto.getFaktorFs() );
		this.setJenisKelaminPeserta( dto.getJenisKelaminPeserta() );
		this.setJenisKelaminPenerimaMp( dto.getJenisKelaminPenerimaMp() );
		this.setNamaStatusBayar( dto.getNamaStatusBayar() );

		this.setNamaUsiaBayar( dto.getNamaUsiaBayar() );
		this.setTglMpBulanKe13( dto.getTglMpBulanKe13() );

		this.setNamaSuskel( dto.getNamaSuskel() );
		this.setNpwp( dto.getNpwp() );
		this.setNik( dto.getNik() );
		this.setIsSentToPtr( dto.getIsSentToPtr() );
		this.setRapelKbMps20persenKenaikan( dto.getRapelKbMps20persenKenaikan() );
		this.setRapelLbMps20persenKenaikan( dto.getRapelLbMps20persenKenaikan() );
		this.setRapelKbMps10jtKenaikan( dto.getRapelKbMps10jtKenaikan() );
		this.setRapelLbMps10jtKenaikan( dto.getRapelLbMps10jtKenaikan() );
		this.setRapelKbMps100persenKenaikan( dto.getRapelKbMps100persenKenaikan() );
		this.setRapelLbMps100persenKenaikan( dto.getRapelLbMps100persenKenaikan() );
	}




	@Override
	public PembayaranMpDetailMpsDto toDto(){
		PembayaranMpDetailMpsDto dto = new PembayaranMpDetailMpsDto();
		dto.setId( this.getId() );

		dto.setNip( this.getNip() );
		dto.setNamaPeserta( this.getNamaPeserta() );

		dto.setNamaKantorBayar( this.getNamaKantorBayar() );
		dto.setIdPenerimaMp( this.getIdPenerimaMp() );
		dto.setNamaPenerimaMp( this.getNamaPenerimaMp() );

		dto.setNamaKategoriPensiun( this.getNamaKategoriPensiun() );
		dto.setNomorRekening( this.getNomorRekening() );
		dto.setStatusHerDesc( this.getStatusHerDesc() );

		dto.setNamaJenisMps( this.getNamaJenisMps() );
		dto.setMps20persen( this.getMps20persen() );
		dto.setRapelKbMps20persenPhdp( this.getRapelKbMps20persenPhdp() );
		dto.setRapelLbMps20persenPhdp( this.getRapelLbMps20persenPhdp() );
		dto.setMps10juta( this.getMps10juta() );
		dto.setRapelKbMps10jutaPhdp( this.getRapelKbMps10jutaPhdp() );
		dto.setRapelLbMps10jutaPhdp( this.getRapelLbMps10jutaPhdp() );
		dto.setMps100persen( this.getMps100persen() );
		dto.setMps100persenBulat( this.getMps100persenBulat() );
		dto.setRapelKbMps100persenPhdp( this.getRapelKbMps100persenPhdp() );
		dto.setRapelLbMps100persenPhdp( this.getRapelLbMps100persenPhdp() );
		dto.setUserStamp( this.getUserStamp() );
		dto.setIdSentToPtr( this.getIdSentToPtr() );
		dto.setIsStatusHer( this.getIsStatusHer() );
		dto.setIsHutang( this.getIsHutang() );
		dto.setMpyd( this.getMpyd() );

		dto.setNamaFaktorFpr( this.getNamaFaktorFpr() );
		dto.setNilaiFpr( this.getNilaiFpr() );

		dto.setNamaFaktorFs( this.getNamaFaktorFs() );
		dto.setNilaiFs( this.getNilaiFs() );

		dto.setNamaGolongan( this.getNamaGolongan() );
		dto.setPangkat( this.getPangkat() );
		dto.setJabatan( this.getJabatan() );

		dto.setNamaKategoriPenerimaMp( this.getNamaKategoriPenerimaMp() );

		dto.setMasaKerjaHenti( this.getMasaKerjaHenti() );
		dto.setMasaKerjaHentiBulat( this.getMasaKerjaHentiBulat() );
		dto.setMasaKerjaMp( this.getMasaKerjaMp() );
		dto.setMasaKerjaTambahan( this.getMasaKerjaTambahan() );
		dto.setMasaKerjaTambahanBulat( this.getMasaKerjaTambahanBulat() );
		dto.setMasaKerjaVeteran( this.getMasaKerjaVeteran() );
		dto.setMasaKerjaVeteranBulat( this.getMasaKerjaVeteranBulat() );
		dto.setPhdp( this.getPhdp() );
		dto.setTglAwalBayar( this.getTglAwalBayar() );
		dto.setTglDpthtPeserta( this.getTglDpthtPeserta() );
		dto.setTglHentiBayar( this.getTglHentiBayar() );
		dto.setTglHentiPesertaKerja( this.getTglHentiPesertaKerja() );
		dto.setTglKerjaPeserta( this.getTglKerjaPeserta() );
		dto.setTglLahirPenerimaMp( this.getTglLahirPenerimaMp() );
		dto.setTglLahirPeserta( this.getTglLahirPeserta() );
		dto.setTglMeninggalPeserta( this.getTglMeninggalPeserta() );
		dto.setTglTundaJatuhTempo( this.getTglTundaJatuhTempo() );
		dto.setTotalMasaKerja( this.getTotalMasaKerja() );
		dto.setTotalMasaKerjaBulat( this.getTotalMasaKerjaBulat() );
		dto.setTotalMasaKerjaAdj( this.getTotalMasaKerjaAdj() );
		dto.setTotalMasaKerjaAdjBulat( this.getTotalMasaKerjaAdjBulat() );
		dto.setUsiaPenerimaBayar( this.getUsiaPenerimaBayar() );
		dto.setUsiaPenerimaBayarBulat( this.getUsiaPenerimaBayarBulat() );
		dto.setUsiaSaatHenti( this.getUsiaSaatHenti() );
		dto.setUsiaSaatHentiBulat( this.getUsiaSaatHentiBulat() );
		dto.setFaktorFs( this.getFaktorFs() );
		dto.setJenisKelaminPeserta( this.getJenisKelaminPeserta() );
		dto.setJenisKelaminPenerimaMp( this.getJenisKelaminPenerimaMp() );
		dto.setNamaStatusBayar( this.getNamaStatusBayar() );

		dto.setNamaUsiaBayar( this.getNamaUsiaBayar() );
		dto.setTglMpBulanKe13( this.getTglMpBulanKe13() );

		dto.setNamaSuskel( this.getNamaSuskel() );
		dto.setNpwp( this.getNpwp() );
		dto.setNik( this.getNik() );
		dto.setIsSentToPtr( this.getIsSentToPtr() );
		dto.setRapelKbMps20persenKenaikan( this.getRapelKbMps20persenKenaikan() );
		dto.setRapelLbMps20persenKenaikan( this.getRapelLbMps20persenKenaikan() );
		dto.setRapelKbMps10jtKenaikan( this.getRapelKbMps10jtKenaikan() );
		dto.setRapelLbMps10jtKenaikan( this.getRapelLbMps10jtKenaikan() );
		dto.setRapelKbMps100persenKenaikan( this.getRapelKbMps100persenKenaikan() );
		dto.setRapelLbMps100persenKenaikan( this.getRapelLbMps100persenKenaikan() );


		return dto;
	}

}