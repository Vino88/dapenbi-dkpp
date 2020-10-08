package com.dapenbi.dkpp.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class ProyeksiPembayaranPensiunBaruDto {
    private Long idProyeksiDetail;
    private ProyeksiDto idProyeksi;
    private String nip;
    private String namaPeserta;
    private String idPenerimaMp;
    private String namaPenerimaMp;
    private GolonganDto idGolongan;
    private String pangkatJabatan;
    private Character jenisKelamin;
    private Date tglLahir;
    private Date tglKepesertaan;
    private Date tglHenti;
    private String masaKerja;
    private Long phdpAwal;
    private Long mps20pesenAwal;
    private Long mps10jutaAwal;
    private Long mps20prsn10jtAwal;
    private Long mps100persenAwal;
    private Long mpBulanan;
    private Long mpBulanan20persen;
    private Long mpBulanan10juta;
    private Long mpBulanan20persen20juta;
    private Long kenaikanMp1;
    private Long kenaikanPhdp1;
    private Long mpBulananBaru1;
    private String typePensiunan;
    private String periodeProyeksi;
    private StatusKawinDto idStatusKawin;
    private String namaStatusKawin;
    private FaktorFprDto idFaktorFpr;
    private String namaFaktorFpr;
    private Long nilaiFpr;
    private FaktorFsDto idFaktorFs;
    private String namaFaktorFs;
    private Long nilaiFs;
    private Long phdpBaru1;
    private Long mps20persenBaru1;
    private Long mps20persenBaru2;
    private Long mps20persenBaru3;
    private Long mps10jutaBaru1;
    private Long mps10jutaBaru2;
    private Long mps10jutaBaru3;
    private Long mps20prsn10jtBaru1;
    private Long mps20prsn10jtBaru2;
    private Long mps20prsn10jtBaru3;
    private Long kenaikanMp2;
    private Long kenaikanMp3;
    private Long kenaikanPhdp2;
    private Long kenaikanPhdp3;
    private Long mpBulananBaru2;
    private Long mpBulananBaru3;
    private JenisMpsDto idJenisMps;
    private String jenisMps;
    private Date tglAwalBayar;
    private Long mpBulanan20persen1;
    private Long mpBulanan20persen2;
    private Long mpBulanan20persen3;
    private Long phdpBaru2;
    private Long phdpBaru3;
    private Long mpBulanan10jutaBaru1;
    private Long mpBulanan10jutaBaru2;
    private Long mpBulanan10jutaBaru3;
    private String tahunProyeksi;
    private String userStamp;

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

    public void setMpBulanan20persen1(Long mpBulanan20persen1){
        this.mpBulanan20persen1 = mpBulanan20persen1;
    }

    public Long getMpBulanan20persen1(){
        return this.mpBulanan20persen1;
    }

    public void setMpBulanan20persen2(Long mpBulanan20persen2){
        this.mpBulanan20persen2 = mpBulanan20persen2;
    }

    public Long getMpBulanan20persen2(){
        return this.mpBulanan20persen2;
    }

    public void setMpBulanan20persen3(Long mpBulanan20persen3){
        this.mpBulanan20persen3 = mpBulanan20persen3;
    }

    public Long getMpBulanan20persen3(){
        return this.mpBulanan20persen3;
    }

    public void setPhdpBaru2(Long phdpBaru2){
        this.phdpBaru2 = phdpBaru2;
    }

    public Long getPhdpBaru2(){
        return this.phdpBaru2;
    }

    public void setPhdpBaru3(Long phdpBaru3){
        this.phdpBaru3 = phdpBaru3;
    }

    public Long getPhdpBaru3(){
        return this.phdpBaru3;
    }

    public void setMpBulanan10jutaBaru1(Long mpBulanan10jutaBaru1){
        this.mpBulanan10jutaBaru1 = mpBulanan10jutaBaru1;
    }

    public Long getMpBulanan10jutaBaru1(){
        return this.mpBulanan10jutaBaru1;
    }

    public void setMpBulanan10jutaBaru2(Long mpBulanan10jutaBaru2){
        this.mpBulanan10jutaBaru2 = mpBulanan10jutaBaru2;
    }

    public Long getMpBulanan10jutaBaru2(){
        return this.mpBulanan10jutaBaru2;
    }

    public void setMpBulanan10jutaBaru3(Long mpBulanan10jutaBaru3){
        this.mpBulanan10jutaBaru3 = mpBulanan10jutaBaru3;
    }

    public Long getMpBulanan10jutaBaru3(){
        return this.mpBulanan10jutaBaru3;
    }

    public void setTahunProyeksi(String tahunProyeksi){
        this.tahunProyeksi = tahunProyeksi;
    }

    public String getTahunProyeksi(){
        return this.tahunProyeksi;
    }

    public void setUserStamp(String userStamp){
        this.userStamp = userStamp;
    }

    public String getUserStamp(){
        return this.userStamp;
    }

    public ProyeksiDto getIdProyeksi() {
        return idProyeksi;
    }

    public void setIdProyeksi(ProyeksiDto idProyeksi) {
        this.idProyeksi = idProyeksi;
    }

    public GolonganDto getIdGolongan() {
        return idGolongan;
    }

    public void setIdGolongan(GolonganDto idGolongan) {
        this.idGolongan = idGolongan;
    }

    public StatusKawinDto getIdStatusKawin() {
        return idStatusKawin;
    }

    public void setIdStatusKawin(StatusKawinDto idStatusKawin) {
        this.idStatusKawin = idStatusKawin;
    }

    public FaktorFprDto getIdFaktorFpr() {
        return idFaktorFpr;
    }

    public void setIdFaktorFpr(FaktorFprDto idFaktorFpr) {
        this.idFaktorFpr = idFaktorFpr;
    }

    public FaktorFsDto getIdFaktorFs() {
        return idFaktorFs;
    }

    public void setIdFaktorFs(FaktorFsDto idFaktorFs) {
        this.idFaktorFs = idFaktorFs;
    }

    public JenisMpsDto getIdJenisMps() {
        return idJenisMps;
    }

    public void setIdJenisMps(JenisMpsDto idJenisMps) {
        this.idJenisMps = idJenisMps;
    }
}