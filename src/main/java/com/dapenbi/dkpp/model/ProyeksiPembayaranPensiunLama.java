package com.dapenbi.dkpp.model;

import javax.persistence.*;
import com.dapenbi.dkpp.dto.ProyeksiPembayaranPensiunLamaDto;
import java.util.Date;

@Entity
@Table(name = "TBL_T_PROYEKSI_PENSIUN_LAMA")
@NamedStoredProcedureQueries(
		@NamedStoredProcedureQuery(
				name="MutasiPensiun.processCuspProyeksiPensiunLama",
				procedureName="CUSP_PROYEKSI_PENSIUN_LAMA",
				parameters = {
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_COMP_NAME"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_USER_NAME"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_TAHUN_PROYEKSI"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Character.class, name= "PAR_UNTUK_PROYEKSI"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name= "PAR_USER_STAMP"),
						@StoredProcedureParameter(mode = ParameterMode.OUT, type = Character.class, name= "PAR_STATUS_EKSEKUSI"),
						@StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name= "PAR_MSG")
				}
		)
)
public class ProyeksiPembayaranPensiunLama extends BaseModel<ProyeksiPembayaranPensiunLamaDto>{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROYEKSI_PENSIUN_LAMA_SEQ")
	@SequenceGenerator(sequenceName = "proyeksiPensiunLama_seq", allocationSize = 1, name = "PROYEKSI_PENSIUN_LAMA_SEQ")
@Column(name = "ID_PROYEKSI_DETAIL", length = 22)
private Long idProyeksiDetail;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PROYEKSI")
	private Proyeksi idProyeksi;

@Column(name = "NIP", length = 20)
private String nip;

@Column(name = "NAMA_PESERTA", length = 100)
private String namaPeserta;

@Column(name = "ID_PENERIMA_MP", length = 20)
private String idPenerimaMp;

@Column(name = "NAMA_PENERIMA_MP", length = 100)
private String namaPenerimaMp;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_GOLONGAN")
	private Golongan idGolongan;

@Column(name = "PANGKAT_JABATAN", length = 100)
private String pangkatJabatan;

@Column(name = "JENIS_KELAMIN", length = 1)
private Character jenisKelamin;

@Column(name = "TGL_LAHIR", length = 7)
private Date tglLahir;

@Column(name = "TGL_KEPESERTAAN", length = 7)
private Date tglKepesertaan;

@Column(name = "TGL_HENTI", length = 7)
private Date tglHenti;

@Column(name = "MASA_KERJA", length = 4)
private String masaKerja;

@Column(name = "PHDP_AWAL", length = 22)
private Long phdpAwal;

@Column(name = "MPS20PESEN_AWAL", length = 22)
private Long mps20pesenAwal;

@Column(name = "MPS10JUTA_AWAL", length = 22)
private Long mps10jutaAwal;

@Column(name = "MPS20PRSN10JT_AWAL", length = 22)
private Long mps20prsn10jtAwal;

@Column(name = "MPS100PERSEN_AWAL", length = 22)
private Long mps100persenAwal;

@Column(name = "MP_BULANAN", length = 22)
private Long mpBulanan;

@Column(name = "MP_BULANAN_20PERSEN", length = 22)
private Long mpBulanan20persen;

@Column(name = "MP_BULANAN_10JUTA", length = 22)
private Long mpBulanan10juta;

@Column(name = "MP_BULANAN_20PERSEN20JUTA", length = 22)
private Long mpBulanan20persen20juta;

@Column(name = "KENAIKAN_MP1", length = 22)
private Long kenaikanMp1;

@Column(name = "KENAIKAN_PHDP1", length = 22)
private Long kenaikanPhdp1;

@Column(name = "MP_BULANAN_BARU1", length = 22)
private Long mpBulananBaru1;

@Column(name = "TYPE_PENSIUNAN", length = 2)
private String typePensiunan;

@Column(name = "PERIODE_PROYEKSI", length = 6)
private String periodeProyeksi;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_STATUS_KAWIN")
	private StatusKawin idStatusKawin;

@Column(name = "NAMA_STATUS_KAWIN", length = 100)
private String namaStatusKawin;

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

@Column(name = "PHDP_BARU1", length = 22)
private Long phdpBaru1;

@Column(name = "MPS20PERSEN_BARU1", length = 22)
private Long mps20persenBaru1;

@Column(name = "MPS20PERSEN_BARU2", length = 22)
private Long mps20persenBaru2;

@Column(name = "MPS20PERSEN_BARU3", length = 22)
private Long mps20persenBaru3;

@Column(name = "MPS10JUTA_BARU1", length = 22)
private Long mps10jutaBaru1;

@Column(name = "MPS10JUTA_BARU2", length = 22)
private Long mps10jutaBaru2;

@Column(name = "MPS10JUTA_BARU3", length = 22)
private Long mps10jutaBaru3;

@Column(name = "MPS20PRSN10JT_BARU1", length = 22)
private Long mps20prsn10jtBaru1;

@Column(name = "MPS20PRSN10JT_BARU2", length = 22)
private Long mps20prsn10jtBaru2;

@Column(name = "MPS20PRSN10JT_BARU3", length = 22)
private Long mps20prsn10jtBaru3;

@Column(name = "KENAIKAN_MP2", length = 22)
private Long kenaikanMp2;

@Column(name = "KENAIKAN_MP3", length = 22)
private Long kenaikanMp3;

@Column(name = "KENAIKAN_PHDP2", length = 22)
private Long kenaikanPhdp2;

@Column(name = "KENAIKAN_PHDP3", length = 22)
private Long kenaikanPhdp3;

@Column(name = "MP_BULANAN_BARU2", length = 22)
private Long mpBulananBaru2;

@Column(name = "MP_BULANAN_BARU3", length = 22)
private Long mpBulananBaru3;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_JENIS_MPS")
	private JenisMps idJenisMps;

@Column(name = "JENIS_MPS", length = 100)
private String jenisMps;

@Column(name = "TGL_AWAL_BAYAR", length = 7)
private Date tglAwalBayar;

@Column(name = "USER_STAMP", length = 60)
private String userStamp;

	@Column(name = "TAHUN_PROYEKSI", length = 4)
	private String tahunProyeksi;

public void setIdProyeksiDetail(Long idProyeksiDetail){
	this.idProyeksiDetail = idProyeksiDetail;
}

public Long getIdProyeksiDetail(){
	return this.idProyeksiDetail;
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

public void setPangkatJabatan(String pangkatJabatan){
	this.pangkatJabatan = pangkatJabatan;
}

public String getPangkatJabatan(){
	return this.pangkatJabatan;
}

public void setJenisKelamin(Character jenisKelamin){
	this.jenisKelamin = jenisKelamin;
}

public Character getJenisKelamin(){
	return this.jenisKelamin;
}

public void setTglLahir(Date tglLahir){
	this.tglLahir = tglLahir;
}

public Date getTglLahir(){
	return this.tglLahir;
}

public void setTglKepesertaan(Date tglKepesertaan){
	this.tglKepesertaan = tglKepesertaan;
}

public Date getTglKepesertaan(){
	return this.tglKepesertaan;
}

public void setTglHenti(Date tglHenti){
	this.tglHenti = tglHenti;
}

public Date getTglHenti(){
	return this.tglHenti;
}

public void setMasaKerja(String masaKerja){
	this.masaKerja = masaKerja;
}

public String getMasaKerja(){
	return this.masaKerja;
}

public void setPhdpAwal(Long phdpAwal){
	this.phdpAwal = phdpAwal;
}

public Long getPhdpAwal(){
	return this.phdpAwal;
}

public void setMps20pesenAwal(Long mps20pesenAwal){
	this.mps20pesenAwal = mps20pesenAwal;
}

public Long getMps20pesenAwal(){
	return this.mps20pesenAwal;
}

public void setMps10jutaAwal(Long mps10jutaAwal){
	this.mps10jutaAwal = mps10jutaAwal;
}

public Long getMps10jutaAwal(){
	return this.mps10jutaAwal;
}

public void setMps20prsn10jtAwal(Long mps20prsn10jtAwal){
	this.mps20prsn10jtAwal = mps20prsn10jtAwal;
}

public Long getMps20prsn10jtAwal(){
	return this.mps20prsn10jtAwal;
}

public void setMps100persenAwal(Long mps100persenAwal){
	this.mps100persenAwal = mps100persenAwal;
}

public Long getMps100persenAwal(){
	return this.mps100persenAwal;
}

public void setMpBulanan(Long mpBulanan){
	this.mpBulanan = mpBulanan;
}

public Long getMpBulanan(){
	return this.mpBulanan;
}

public void setMpBulanan20persen(Long mpBulanan20persen){
	this.mpBulanan20persen = mpBulanan20persen;
}

public Long getMpBulanan20persen(){
	return this.mpBulanan20persen;
}

public void setMpBulanan10juta(Long mpBulanan10juta){
	this.mpBulanan10juta = mpBulanan10juta;
}

public Long getMpBulanan10juta(){
	return this.mpBulanan10juta;
}

public void setMpBulanan20persen20juta(Long mpBulanan20persen20juta){
	this.mpBulanan20persen20juta = mpBulanan20persen20juta;
}

public Long getMpBulanan20persen20juta(){
	return this.mpBulanan20persen20juta;
}

public void setKenaikanMp1(Long kenaikanMp1){
	this.kenaikanMp1 = kenaikanMp1;
}

public Long getKenaikanMp1(){
	return this.kenaikanMp1;
}

public void setKenaikanPhdp1(Long kenaikanPhdp1){
	this.kenaikanPhdp1 = kenaikanPhdp1;
}

public Long getKenaikanPhdp1(){
	return this.kenaikanPhdp1;
}

public void setMpBulananBaru1(Long mpBulananBaru1){
	this.mpBulananBaru1 = mpBulananBaru1;
}

public Long getMpBulananBaru1(){
	return this.mpBulananBaru1;
}

public void setTypePensiunan(String typePensiunan){
	this.typePensiunan = typePensiunan;
}

public String getTypePensiunan(){
	return this.typePensiunan;
}

public void setPeriodeProyeksi(String periodeProyeksi){
	this.periodeProyeksi = periodeProyeksi;
}

public String getPeriodeProyeksi(){
	return this.periodeProyeksi;
}

public void setNamaStatusKawin(String namaStatusKawin){
	this.namaStatusKawin = namaStatusKawin;
}

public String getNamaStatusKawin(){
	return this.namaStatusKawin;
}

public void setNamaFaktorFpr(String namaFaktorFpr){
	this.namaFaktorFpr = namaFaktorFpr;
}

public String getNamaFaktorFpr(){
	return this.namaFaktorFpr;
}

public void setNilaiFpr(Long nilaiFpr){
	this.nilaiFpr = nilaiFpr;
}

public Long getNilaiFpr(){
	return this.nilaiFpr;
}

public void setNamaFaktorFs(String namaFaktorFs){
	this.namaFaktorFs = namaFaktorFs;
}

public String getNamaFaktorFs(){
	return this.namaFaktorFs;
}

public void setNilaiFs(Long nilaiFs){
	this.nilaiFs = nilaiFs;
}

public Long getNilaiFs(){
	return this.nilaiFs;
}

public void setPhdpBaru1(Long phdpBaru1){
	this.phdpBaru1 = phdpBaru1;
}

public Long getPhdpBaru1(){
	return this.phdpBaru1;
}

public void setMps20persenBaru1(Long mps20persenBaru1){
	this.mps20persenBaru1 = mps20persenBaru1;
}

public Long getMps20persenBaru1(){
	return this.mps20persenBaru1;
}

public void setMps20persenBaru2(Long mps20persenBaru2){
	this.mps20persenBaru2 = mps20persenBaru2;
}

public Long getMps20persenBaru2(){
	return this.mps20persenBaru2;
}

public void setMps20persenBaru3(Long mps20persenBaru3){
	this.mps20persenBaru3 = mps20persenBaru3;
}

public Long getMps20persenBaru3(){
	return this.mps20persenBaru3;
}

public void setMps10jutaBaru1(Long mps10jutaBaru1){
	this.mps10jutaBaru1 = mps10jutaBaru1;
}

public Long getMps10jutaBaru1(){
	return this.mps10jutaBaru1;
}

public void setMps10jutaBaru2(Long mps10jutaBaru2){
	this.mps10jutaBaru2 = mps10jutaBaru2;
}

public Long getMps10jutaBaru2(){
	return this.mps10jutaBaru2;
}

public void setMps10jutaBaru3(Long mps10jutaBaru3){
	this.mps10jutaBaru3 = mps10jutaBaru3;
}

public Long getMps10jutaBaru3(){
	return this.mps10jutaBaru3;
}

public void setMps20prsn10jtBaru1(Long mps20prsn10jtBaru1){
	this.mps20prsn10jtBaru1 = mps20prsn10jtBaru1;
}

public Long getMps20prsn10jtBaru1(){
	return this.mps20prsn10jtBaru1;
}

public void setMps20prsn10jtBaru2(Long mps20prsn10jtBaru2){
	this.mps20prsn10jtBaru2 = mps20prsn10jtBaru2;
}

public Long getMps20prsn10jtBaru2(){
	return this.mps20prsn10jtBaru2;
}

public void setMps20prsn10jtBaru3(Long mps20prsn10jtBaru3){
	this.mps20prsn10jtBaru3 = mps20prsn10jtBaru3;
}

public Long getMps20prsn10jtBaru3(){
	return this.mps20prsn10jtBaru3;
}

public void setKenaikanMp2(Long kenaikanMp2){
	this.kenaikanMp2 = kenaikanMp2;
}

public Long getKenaikanMp2(){
	return this.kenaikanMp2;
}

public void setKenaikanMp3(Long kenaikanMp3){
	this.kenaikanMp3 = kenaikanMp3;
}

public Long getKenaikanMp3(){
	return this.kenaikanMp3;
}

public void setKenaikanPhdp2(Long kenaikanPhdp2){
	this.kenaikanPhdp2 = kenaikanPhdp2;
}

public Long getKenaikanPhdp2(){
	return this.kenaikanPhdp2;
}

public void setKenaikanPhdp3(Long kenaikanPhdp3){
	this.kenaikanPhdp3 = kenaikanPhdp3;
}

public Long getKenaikanPhdp3(){
	return this.kenaikanPhdp3;
}

public void setMpBulananBaru2(Long mpBulananBaru2){
	this.mpBulananBaru2 = mpBulananBaru2;
}

public Long getMpBulananBaru2(){
	return this.mpBulananBaru2;
}

public void setMpBulananBaru3(Long mpBulananBaru3){
	this.mpBulananBaru3 = mpBulananBaru3;
}

public Long getMpBulananBaru3(){
	return this.mpBulananBaru3;
}

public void setJenisMps(String jenisMps){
	this.jenisMps = jenisMps;
}

public String getJenisMps(){
	return this.jenisMps;
}

public void setTglAwalBayar(Date tglAwalBayar){
	this.tglAwalBayar = tglAwalBayar;
}

public Date getTglAwalBayar(){
	return this.tglAwalBayar;
}

public void setUserStamp(String userStamp){
	this.userStamp = userStamp;
}

public String getUserStamp(){
	return this.userStamp;
}

	public Proyeksi getIdProyeksi() {
		return idProyeksi;
	}

	public void setIdProyeksi(Proyeksi idProyeksi) {
		this.idProyeksi = idProyeksi;
	}

	public Golongan getIdGolongan() {
		return idGolongan;
	}

	public void setIdGolongan(Golongan idGolongan) {
		this.idGolongan = idGolongan;
	}

	public StatusKawin getIdStatusKawin() {
		return idStatusKawin;
	}

	public void setIdStatusKawin(StatusKawin idStatusKawin) {
		this.idStatusKawin = idStatusKawin;
	}

	public FaktorFPR getIdFaktorFpr() {
		return idFaktorFpr;
	}

	public void setIdFaktorFpr(FaktorFPR idFaktorFpr) {
		this.idFaktorFpr = idFaktorFpr;
	}

	public FaktorFs getIdFaktorFs() {
		return idFaktorFs;
	}

	public void setIdFaktorFs(FaktorFs idFaktorFs) {
		this.idFaktorFs = idFaktorFs;
	}

	public JenisMps getIdJenisMps() {
		return idJenisMps;
	}

	public void setIdJenisMps(JenisMps idJenisMps) {
		this.idJenisMps = idJenisMps;
	}

	public String getTahunProyeksi() {
		return tahunProyeksi;
	}

	public void setTahunProyeksi(String tahunProyeksi) {
		this.tahunProyeksi = tahunProyeksi;
	}

	@Override
public void fromDto(ProyeksiPembayaranPensiunLamaDto dto){
	this.setIdProyeksiDetail( dto.getIdProyeksiDetail() );
	this.setNip( dto.getNip() );
	this.setNamaPeserta( dto.getNamaPeserta() );
	this.setIdPenerimaMp( dto.getIdPenerimaMp() );
	this.setNamaPenerimaMp( dto.getNamaPenerimaMp() );
	this.setPangkatJabatan( dto.getPangkatJabatan() );
	this.setJenisKelamin( dto.getJenisKelamin() );
	this.setTglLahir( dto.getTglLahir() );
	this.setTglKepesertaan( dto.getTglKepesertaan() );
	this.setTglHenti( dto.getTglHenti() );
	this.setMasaKerja( dto.getMasaKerja() );
	this.setPhdpAwal( dto.getPhdpAwal() );
	this.setMps20pesenAwal( dto.getMps20pesenAwal() );
	this.setMps10jutaAwal( dto.getMps10jutaAwal() );
	this.setMps20prsn10jtAwal( dto.getMps20prsn10jtAwal() );
	this.setMps100persenAwal( dto.getMps100persenAwal() );
	this.setMpBulanan( dto.getMpBulanan() );
	this.setMpBulanan20persen( dto.getMpBulanan20persen() );
	this.setMpBulanan10juta( dto.getMpBulanan10juta() );
	this.setMpBulanan20persen20juta( dto.getMpBulanan20persen20juta() );
	this.setKenaikanMp1( dto.getKenaikanMp1() );
	this.setKenaikanPhdp1( dto.getKenaikanPhdp1() );
	this.setMpBulananBaru1( dto.getMpBulananBaru1() );
	this.setTypePensiunan( dto.getTypePensiunan() );
	this.setPeriodeProyeksi( dto.getPeriodeProyeksi() );
	this.setNamaStatusKawin( dto.getNamaStatusKawin() );
	this.setNamaFaktorFpr( dto.getNamaFaktorFpr() );
	this.setNilaiFpr( dto.getNilaiFpr() );
	this.setNamaFaktorFs( dto.getNamaFaktorFs() );
	this.setNilaiFs( dto.getNilaiFs() );
	this.setPhdpBaru1( dto.getPhdpBaru1() );
	this.setMps20persenBaru1( dto.getMps20persenBaru1() );
	this.setMps20persenBaru2( dto.getMps20persenBaru2() );
	this.setMps20persenBaru3( dto.getMps20persenBaru3() );
	this.setMps10jutaBaru1( dto.getMps10jutaBaru1() );
	this.setMps10jutaBaru2( dto.getMps10jutaBaru2() );
	this.setMps10jutaBaru3( dto.getMps10jutaBaru3() );
	this.setMps20prsn10jtBaru1( dto.getMps20prsn10jtBaru1() );
	this.setMps20prsn10jtBaru2( dto.getMps20prsn10jtBaru2() );
	this.setMps20prsn10jtBaru3( dto.getMps20prsn10jtBaru3() );
	this.setKenaikanMp2( dto.getKenaikanMp2() );
	this.setKenaikanMp3( dto.getKenaikanMp3() );
	this.setKenaikanPhdp2( dto.getKenaikanPhdp2() );
	this.setKenaikanPhdp3( dto.getKenaikanPhdp3() );
	this.setMpBulananBaru2( dto.getMpBulananBaru2() );
	this.setMpBulananBaru3( dto.getMpBulananBaru3() );
	this.setJenisMps( dto.getJenisMps() );
	this.setTglAwalBayar( dto.getTglAwalBayar() );
	this.setUserStamp( dto.getUserStamp() );
		this.setTahunProyeksi( dto.getTahunProyeksi() );

}




@Override
public ProyeksiPembayaranPensiunLamaDto toDto(){
	ProyeksiPembayaranPensiunLamaDto dto = new ProyeksiPembayaranPensiunLamaDto();
	dto.setIdProyeksiDetail( this.getIdProyeksiDetail() );
	dto.setNip( this.getNip() );
	dto.setNamaPeserta( this.getNamaPeserta() );
	dto.setIdPenerimaMp( this.getIdPenerimaMp() );
	dto.setNamaPenerimaMp( this.getNamaPenerimaMp() );
	dto.setPangkatJabatan( this.getPangkatJabatan() );
	dto.setJenisKelamin( this.getJenisKelamin() );
	dto.setTglLahir( this.getTglLahir() );
	dto.setTglKepesertaan( this.getTglKepesertaan() );
	dto.setTglHenti( this.getTglHenti() );
	dto.setMasaKerja( this.getMasaKerja() );
	dto.setPhdpAwal( this.getPhdpAwal() );
	dto.setMps20pesenAwal( this.getMps20pesenAwal() );
	dto.setMps10jutaAwal( this.getMps10jutaAwal() );
	dto.setMps20prsn10jtAwal( this.getMps20prsn10jtAwal() );
	dto.setMps100persenAwal( this.getMps100persenAwal() );
	dto.setMpBulanan( this.getMpBulanan() );
	dto.setMpBulanan20persen( this.getMpBulanan20persen() );
	dto.setMpBulanan10juta( this.getMpBulanan10juta() );
	dto.setMpBulanan20persen20juta( this.getMpBulanan20persen20juta() );
	dto.setKenaikanMp1( this.getKenaikanMp1() );
	dto.setKenaikanPhdp1( this.getKenaikanPhdp1() );
	dto.setMpBulananBaru1( this.getMpBulananBaru1() );
	dto.setTypePensiunan( this.getTypePensiunan() );
	dto.setPeriodeProyeksi( this.getPeriodeProyeksi() );
	dto.setNamaStatusKawin( this.getNamaStatusKawin() );
	dto.setNamaFaktorFpr( this.getNamaFaktorFpr() );
	dto.setNilaiFpr( this.getNilaiFpr() );
	dto.setNamaFaktorFs( this.getNamaFaktorFs() );
	dto.setNilaiFs( this.getNilaiFs() );
	dto.setPhdpBaru1( this.getPhdpBaru1() );
	dto.setMps20persenBaru1( this.getMps20persenBaru1() );
	dto.setMps20persenBaru2( this.getMps20persenBaru2() );
	dto.setMps20persenBaru3( this.getMps20persenBaru3() );
	dto.setMps10jutaBaru1( this.getMps10jutaBaru1() );
	dto.setMps10jutaBaru2( this.getMps10jutaBaru2() );
	dto.setMps10jutaBaru3( this.getMps10jutaBaru3() );
	dto.setMps20prsn10jtBaru1( this.getMps20prsn10jtBaru1() );
	dto.setMps20prsn10jtBaru2( this.getMps20prsn10jtBaru2() );
	dto.setMps20prsn10jtBaru3( this.getMps20prsn10jtBaru3() );
	dto.setKenaikanMp2( this.getKenaikanMp2() );
	dto.setKenaikanMp3( this.getKenaikanMp3() );
	dto.setKenaikanPhdp2( this.getKenaikanPhdp2() );
	dto.setKenaikanPhdp3( this.getKenaikanPhdp3() );
	dto.setMpBulananBaru2( this.getMpBulananBaru2() );
	dto.setMpBulananBaru3( this.getMpBulananBaru3() );
	dto.setJenisMps( this.getJenisMps() );
	dto.setTglAwalBayar( this.getTglAwalBayar() );
	dto.setUserStamp( this.getUserStamp() );
	dto.setTahunProyeksi( this.getTahunProyeksi() );


	return dto;
}



}