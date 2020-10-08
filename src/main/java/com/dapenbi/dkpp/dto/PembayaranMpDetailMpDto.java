package com.dapenbi.dkpp.dto;

import java.util.Date;

public class PembayaranMpDetailMpDto {
    private Long id;
    private PembayaranMpDto idPembayaran;
    private String nip;
    private String namaPeserta;
    private Character jenisKelaminPeserta;
    private Date tglLahirPeserta;
    private Date tglKerjaPeserta;
    private Date tglDpthtPeserta;
    private Date tglHentiKerjaPeserta;
    private Date tglMeninggalPeserta;
    private GolonganDto idGolongan;
    private String golonganPangkat;
    private KantorBayarDto idKantorBayar;
    private String namaKantorBayar;
    private KategoriPensiunDto idKategoriPensiun;
    private String namaKategoriPensiun;
    private UsiaBayarDto idUsiaBayar;
    private String namaUsiaBayar;
    private StatusBayarDto idStatusBayar;
    private String namaStatusBayar;
    private Date tglTundaJatuhTemp;
    private Date tglAwalBayar;
    private Date tglMpBulanKe13;
    private Date tglHentiBayar;
    private String idPenerimaMp;
    private String namaPenerimaMp;
    private Date tglLahirPenerimaMp;
    private Character jenisKelaminPenerimaMp;
    private KategoriPenerimaDto idKategoriPenerimaMp;
    private String namaKategoriPenerimaMp;
    private String usiaSaatHenti;
    private String usiaSaatHentiBulat;
    private String usiaPenerimaBayar;
    private String usiaPenerimaBayarBulat;
    private String masaKerjaTambahan;
    private String masaKerjaTambahanBulat;
    private String masaKerjaVeteran;
    private String masaKerjaVeteranBulat;
    private String masaKerjaMp;
    private String masaKerjaHenti;
    private String masaKerjaHentiBulat;
    private String totalMasaKerja;
    private String totalMasaKerjaBulat;
    private String totalMasaKerjaAdj;
    private String totalMasaKerjaAdjBulat;
    private SuskelDto idSuskel;
    private String namaSuskel;
    private String npwp;
    private String nik;
    private Long phdp;
    private FaktorFprDto idFaktorFpr;
    private String namaFaktorFpr;
    private Long nilaiFpr;
    private FaktorFsDto idFaktorFs;
    private String namaFaktorFs;
    private Long nilaiFs;
    private String faktorFs;
    private Long mpBulanan;
    private Long mpBulananKe13;
    private Long mpBulananBulat;
    private Long mpBulananKe13Bulat;
    private Long mpyd;
    private Long pembulatan;
    private Long upahVeteran;
    private Long potonganVga;
    private Long potonganVeteran;
    private Long potonganOlahraga;
    private Long kurangBayarMpBulanan;
    private Long lebihBayarMpBulanan;
    private Long rapelKbMpBulanan;
    private Long rapelLbMpBulanan;
    private Long rapelKbPhdp;
    private Long rapelKbKenaikanMp;
    private Long rapelKbLainLain;
    private Long rapelKbKeterlambatanData;
    private Character isStatusHer;
    private String statusHerDesc;
    private Character isHutang;
    private Long idSentToPtr;
    private Character isSentToPtr;
    private String userStamp;
    private String nomorRekening;
    private String jenisPensiun;
    private String reasonHapus;
    private Long rapelLbPhdp;
    private Long rapelLbKenaikanMp;
    private Long rapelLbLainLain;
    private Long rapelLbKeterlambatanData;
    private Long mpydAkhir;

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

    public Character getJenisKelaminPeserta() {
        return jenisKelaminPeserta;
    }

    public void setJenisKelaminPeserta(Character jenisKelaminPeserta) {
        this.jenisKelaminPeserta = jenisKelaminPeserta;
    }

    public Date getTglLahirPeserta() {
        return tglLahirPeserta;
    }

    public void setTglLahirPeserta(Date tglLahirPeserta) {
        this.tglLahirPeserta = tglLahirPeserta;
    }

    public Date getTglKerjaPeserta() {
        return tglKerjaPeserta;
    }

    public void setTglKerjaPeserta(Date tglKerjaPeserta) {
        this.tglKerjaPeserta = tglKerjaPeserta;
    }

    public Date getTglDpthtPeserta() {
        return tglDpthtPeserta;
    }

    public void setTglDpthtPeserta(Date tglDpthtPeserta) {
        this.tglDpthtPeserta = tglDpthtPeserta;
    }

    public Date getTglHentiKerjaPeserta() {
        return tglHentiKerjaPeserta;
    }

    public void setTglHentiKerjaPeserta(Date tglHentiKerjaPeserta) {
        this.tglHentiKerjaPeserta = tglHentiKerjaPeserta;
    }

    public Date getTglMeninggalPeserta() {
        return tglMeninggalPeserta;
    }

    public void setTglMeninggalPeserta(Date tglMeninggalPeserta) {
        this.tglMeninggalPeserta = tglMeninggalPeserta;
    }

    public GolonganDto getIdGolongan() {
        return idGolongan;
    }

    public void setIdGolongan(GolonganDto idGolongan) {
        this.idGolongan = idGolongan;
    }

    public String getGolonganPangkat() {
        return golonganPangkat;
    }

    public void setGolonganPangkat(String golonganPangkat) {
        this.golonganPangkat = golonganPangkat;
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

    public StatusBayarDto getIdStatusBayar() {
        return idStatusBayar;
    }

    public void setIdStatusBayar(StatusBayarDto idStatusBayar) {
        this.idStatusBayar = idStatusBayar;
    }

    public String getNamaStatusBayar() {
        return namaStatusBayar;
    }

    public void setNamaStatusBayar(String namaStatusBayar) {
        this.namaStatusBayar = namaStatusBayar;
    }

    public Date getTglTundaJatuhTemp() {
        return tglTundaJatuhTemp;
    }

    public void setTglTundaJatuhTemp(Date tglTundaJatuhTemp) {
        this.tglTundaJatuhTemp = tglTundaJatuhTemp;
    }

    public Date getTglAwalBayar() {
        return tglAwalBayar;
    }

    public void setTglAwalBayar(Date tglAwalBayar) {
        this.tglAwalBayar = tglAwalBayar;
    }

    public Date getTglMpBulanKe13() {
        return tglMpBulanKe13;
    }

    public void setTglMpBulanKe13(Date tglMpBulanKe13) {
        this.tglMpBulanKe13 = tglMpBulanKe13;
    }

    public Date getTglHentiBayar() {
        return tglHentiBayar;
    }

    public void setTglHentiBayar(Date tglHentiBayar) {
        this.tglHentiBayar = tglHentiBayar;
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

    public Date getTglLahirPenerimaMp() {
        return tglLahirPenerimaMp;
    }

    public void setTglLahirPenerimaMp(Date tglLahirPenerimaMp) {
        this.tglLahirPenerimaMp = tglLahirPenerimaMp;
    }

    public Character getJenisKelaminPenerimaMp() {
        return jenisKelaminPenerimaMp;
    }

    public void setJenisKelaminPenerimaMp(Character jenisKelaminPenerimaMp) {
        this.jenisKelaminPenerimaMp = jenisKelaminPenerimaMp;
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

    public String getMasaKerjaMp() {
        return masaKerjaMp;
    }

    public void setMasaKerjaMp(String masaKerjaMp) {
        this.masaKerjaMp = masaKerjaMp;
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

    public Long getPhdp() {
        return phdp;
    }

    public void setPhdp(Long phdp) {
        this.phdp = phdp;
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

    public String getFaktorFs() {
        return faktorFs;
    }

    public void setFaktorFs(String faktorFs) {
        this.faktorFs = faktorFs;
    }

    public Long getMpBulanan() {
        return mpBulanan;
    }

    public void setMpBulanan(Long mpBulanan) {
        this.mpBulanan = mpBulanan;
    }

    public Long getMpBulananKe13() {
        return mpBulananKe13;
    }

    public void setMpBulananKe13(Long mpBulananKe13) {
        this.mpBulananKe13 = mpBulananKe13;
    }

    public Long getMpBulananBulat() {
        return mpBulananBulat;
    }

    public void setMpBulananBulat(Long mpBulananBulat) {
        this.mpBulananBulat = mpBulananBulat;
    }

    public Long getMpBulananKe13Bulat() {
        return mpBulananKe13Bulat;
    }

    public void setMpBulananKe13Bulat(Long mpBulananKe13Bulat) {
        this.mpBulananKe13Bulat = mpBulananKe13Bulat;
    }

    public Long getMpyd() {
        return mpyd;
    }

    public void setMpyd(Long mpyd) {
        this.mpyd = mpyd;
    }

    public Long getPembulatan() {
        return pembulatan;
    }

    public void setPembulatan(Long pembulatan) {
        this.pembulatan = pembulatan;
    }

    public Long getUpahVeteran() {
        return upahVeteran;
    }

    public void setUpahVeteran(Long upahVeteran) {
        this.upahVeteran = upahVeteran;
    }

    public Long getPotonganVga() {
        return potonganVga;
    }

    public void setPotonganVga(Long potonganVga) {
        this.potonganVga = potonganVga;
    }

    public Long getPotonganVeteran() {
        return potonganVeteran;
    }

    public void setPotonganVeteran(Long potonganVeteran) {
        this.potonganVeteran = potonganVeteran;
    }

    public Long getPotonganOlahraga() {
        return potonganOlahraga;
    }

    public void setPotonganOlahraga(Long potonganOlahraga) {
        this.potonganOlahraga = potonganOlahraga;
    }

    public Long getKurangBayarMpBulanan() {
        return kurangBayarMpBulanan;
    }

    public void setKurangBayarMpBulanan(Long kurangBayarMpBulanan) {
        this.kurangBayarMpBulanan = kurangBayarMpBulanan;
    }

    public Long getLebihBayarMpBulanan() {
        return lebihBayarMpBulanan;
    }

    public void setLebihBayarMpBulanan(Long lebihBayarMpBulanan) {
        this.lebihBayarMpBulanan = lebihBayarMpBulanan;
    }

    public Long getRapelKbMpBulanan() {
        return rapelKbMpBulanan;
    }

    public void setRapelKbMpBulanan(Long rapelKbMpBulanan) {
        this.rapelKbMpBulanan = rapelKbMpBulanan;
    }

    public Long getRapelLbMpBulanan() {
        return rapelLbMpBulanan;
    }

    public void setRapelLbMpBulanan(Long rapelLbMpBulanan) {
        this.rapelLbMpBulanan = rapelLbMpBulanan;
    }

    public Long getRapelKbPhdp() {
        return rapelKbPhdp;
    }

    public void setRapelKbPhdp(Long rapelKbPhdp) {
        this.rapelKbPhdp = rapelKbPhdp;
    }

    public Long getRapelKbKenaikanMp() {
        return rapelKbKenaikanMp;
    }

    public void setRapelKbKenaikanMp(Long rapelKbKenaikanMp) {
        this.rapelKbKenaikanMp = rapelKbKenaikanMp;
    }

    public Long getRapelKbLainLain() {
        return rapelKbLainLain;
    }

    public void setRapelKbLainLain(Long rapelKbLainLain) {
        this.rapelKbLainLain = rapelKbLainLain;
    }

    public Long getRapelKbKeterlambatanData() {
        return rapelKbKeterlambatanData;
    }

    public void setRapelKbKeterlambatanData(Long rapelKbKeterlambatanData) {
        this.rapelKbKeterlambatanData = rapelKbKeterlambatanData;
    }

    public Character getIsStatusHer() {
        return isStatusHer;
    }

    public void setIsStatusHer(Character isStatusHer) {
        this.isStatusHer = isStatusHer;
    }

    public String getStatusHerDesc() {
        return statusHerDesc;
    }

    public void setStatusHerDesc(String statusHerDesc) {
        this.statusHerDesc = statusHerDesc;
    }

    public Character getIsHutang() {
        return isHutang;
    }

    public void setIsHutang(Character isHutang) {
        this.isHutang = isHutang;
    }

    public Long getIdSentToPtr() {
        return idSentToPtr;
    }

    public void setIdSentToPtr(Long idSentToPtr) {
        this.idSentToPtr = idSentToPtr;
    }

    public Character getIsSentToPtr() {
        return isSentToPtr;
    }

    public void setIsSentToPtr(Character isSentToPtr) {
        this.isSentToPtr = isSentToPtr;
    }

    public String getUserStamp() {
        return userStamp;
    }

    public void setUserStamp(String userStamp) {
        this.userStamp = userStamp;
    }

    public String getNomorRekening() {
        return nomorRekening;
    }

    public void setNomorRekening(String nomorRekening) {
        this.nomorRekening = nomorRekening;
    }

    public String getJenisPensiun() {
        return jenisPensiun;
    }

    public void setJenisPensiun(String jenisPensiun) {
        this.jenisPensiun = jenisPensiun;
    }

    public String getReasonHapus() {
        return reasonHapus;
    }

    public void setReasonHapus(String reasonHapus) {
        this.reasonHapus = reasonHapus;
    }

    public Long getRapelLbPhdp() {
        return rapelLbPhdp;
    }

    public void setRapelLbPhdp(Long rapelLbPhdp) {
        this.rapelLbPhdp = rapelLbPhdp;
    }

    public Long getRapelLbKenaikanMp() {
        return rapelLbKenaikanMp;
    }

    public void setRapelLbKenaikanMp(Long rapelLbKenaikanMp) {
        this.rapelLbKenaikanMp = rapelLbKenaikanMp;
    }

    public Long getRapelLbLainLain() {
        return rapelLbLainLain;
    }

    public void setRapelLbLainLain(Long rapelLbLainLain) {
        this.rapelLbLainLain = rapelLbLainLain;
    }

    public Long getRapelLbKeterlambatanData() {
        return rapelLbKeterlambatanData;
    }

    public void setRapelLbKeterlambatanData(Long rapelLbKeterlambatanData) {
        this.rapelLbKeterlambatanData = rapelLbKeterlambatanData;
    }

    public Long getMpydAkhir() {
        return mpydAkhir;
    }

    public void setMpydAkhir(Long mpydAkhir) {
        this.mpydAkhir = mpydAkhir;
    }
}
