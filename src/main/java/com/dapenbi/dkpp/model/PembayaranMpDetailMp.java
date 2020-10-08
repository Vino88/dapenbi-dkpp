package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dto.PembayaranMpDetailMpDto;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TBL_T_PEMBAYARAN_DETAIL_MP")
public class    PembayaranMpDetailMp extends BaseModel<PembayaranMpDetailMpDto> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_PEMBAYARAN_MP_DETAIL_SEQ")
    @SequenceGenerator(sequenceName = "pembayaranDetailId_seq", allocationSize = 1, name = "ID_PEMBAYARAN_MP_DETAIL_SEQ")
    @Column(name = "ID_DETAIL_MP", length = 22)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PEMBAYARAN")
    private PembayaranMp idPembayaran;

    @Column(name = "NIP", length = 10)
    private String nip;

    @Column(name = "NAMA_PESERTA", length = 50)
    private String namaPeserta;

    @Column(name = "JENIS_KELAMIN_PESERTA", length = 1)
    private Character jenisKelaminPeserta;

    @Column(name = "TGL_LAHIR_PESERTA", length = 7)
    private Date tglLahirPeserta;

    @Column(name = "TGL_KERJA_PESERTA", length = 7)
    private Date tglKerjaPeserta;

    @Column(name = "TGL_DPTHT_PESERTA", length = 7)
    private Date tglDpthtPeserta;

    @Column(name = "TGL_HENTI_KERJA_PESERTA", length = 7)
    private Date tglHentiKerjaPeserta;

    @Column(name = "TGL_MENINGGAL_PESERTA", length = 7)
    private Date tglMeninggalPeserta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_GOLONGAN")
    private Golongan idGolongan;

    @Column(name = "GOLONGAN_PANGKAT", length = 100)
    private String golonganPangkat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_KANTOR_BAYAR")
    private KantorBayar idKantorBayar;

    @Column(name = "NAMA_KANTOR_BAYAR", length = 50)
    private String namaKantorBayar;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_KATEGORI_PENSIUN")
    private KategoriPensiun idKategoriPensiun;

    @Column(name = "NAMA_KATEGORI_PENSIUN", length = 50)
    private String namaKategoriPensiun;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USIA_BAYAR")
    private UsiaBayar idUsiaBayar;

    @Column(name = "NAMA_USIA_BAYAR", length = 50)
    private String namaUsiaBayar;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_STATUS_BAYAR")
    private StatusBayar idStatusBayar;

    @Column(name = "NAMA_STATUS_BAYAR", length = 20)
    private String namaStatusBayar;

    @Column(name = "TGL_TUNDA_JATUH_TEMP", length = 7)
    private Date tglTundaJatuhTemp;

    @Column(name = "TGL_AWAL_BAYAR", length = 7)
    private Date tglAwalBayar;

    @Column(name = "TGL_MP_BULAN_KE13", length = 7)
    private Date tglMpBulanKe13;

    @Column(name = "TGL_HENTI_BAYAR", length = 7)
    private Date tglHentiBayar;

    @Column(name = "ID_PENERIMA_MP", length = 20)
    private String idPenerimaMp;

    @Column(name = "NAMA_PENERIMA_MP", length = 50)
    private String namaPenerimaMp;

    @Column(name = "TGL_LAHIR_PENERIMA_MP", length = 7)
    private Date tglLahirPenerimaMp;

    @Column(name = "JENIS_KELAMIN_PENERIMA_MP", length = 1)
    private Character jenisKelaminPenerimaMp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_KATEGORI_PENERIMA_MP")
    private KategoriPenerima idKategoriPenerimaMp;

    @Column(name = "NAMA_KATEGORI_PENERIMA_MP", length = 50)
    private String namaKategoriPenerimaMp;

    @Column(name = "USIA_SAAT_HENTI", length = 6)
    private String usiaSaatHenti;

    @Column(name = "USIA_SAAT_HENTI_BULAT", length = 4)
    private String usiaSaatHentiBulat;

    @Column(name = "USIA_PENERIMA_BAYAR", length = 6)
    private String usiaPenerimaBayar;

    @Column(name = "USIA_PENERIMA_BAYAR_BULAT", length = 4)
    private String usiaPenerimaBayarBulat;

    @Column(name = "MASA_KERJA_TAMBAHAN", length = 6)
    private String masaKerjaTambahan;

    @Column(name = "MASA_KERJA_TAMBAHAN_BULAT", length = 4)
    private String masaKerjaTambahanBulat;

    @Column(name = "MASA_KERJA_VETERAN", length = 6)
    private String masaKerjaVeteran;

    @Column(name = "MASA_KERJA_VETERAN_BULAT", length = 4)
    private String masaKerjaVeteranBulat;

    @Column(name = "MASA_KERJA_MP", length = 4)
    private String masaKerjaMp;

    @Column(name = "MASA_KERJA_HENTI", length = 6)
    private String masaKerjaHenti;

    @Column(name = "MASA_KERJA_HENTI_BULAT", length = 4)
    private String masaKerjaHentiBulat;

    @Column(name = "TOTAL_MASA_KERJA", length = 6)
    private String totalMasaKerja;

    @Column(name = "TOTAL_MASA_KERJA_BULAT", length = 4)
    private String totalMasaKerjaBulat;

    @Column(name = "TOTAL_MASA_KERJA_ADJ", length = 6)
    private String totalMasaKerjaAdj;

    @Column(name = "TOTAL_MASA_KERJA_ADJ_BULAT", length = 4)
    private String totalMasaKerjaAdjBulat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_SUSKEL")
    private Suskel idSuskel;

    @Column(name = "NAMA_SUSKEL", length = 50)
    private String namaSuskel;

    @Column(name = "NPWP", length = 50)
    private String npwp;

    @Column(name = "NIK", length = 50)
    private String nik;

    @Column(name = "PHDP", length = 22)
    private Long phdp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_FAKTOR_FPR")
    private FaktorFPR idFaktorFpr;

    @Column(name = "NAMA_FAKTOR_FPR", length = 50)
    private String namaFaktorFpr;

    @Column(name = "NILAI_FPR", length = 22)
    private Long nilaiFpr;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_FAKTOR_FS")
    private FaktorFs idFaktorFs;

    @Column(name = "NAMA_FAKTOR_FS", length = 50)
    private String namaFaktorFs;

    @Column(name = "NILAI_FS", length = 22)
    private Long nilaiFs;

    @Column(name = "FAKTOR_FS", length = 20)
    private String faktorFs;

    @Column(name = "MP_BULANAN", length = 22)
    private Long mpBulanan;

    @Column(name = "MP_BULANAN_KE13", length = 22)
    private Long mpBulananKe13;

    @Column(name = "MP_BULANAN_BULAT", length = 22)
    private Long mpBulananBulat;

    @Column(name = "MP_BULANAN_KE13_BULAT", length = 22)
    private Long mpBulananKe13Bulat;

    @Column(name = "MPYD", length = 22)
    private Long mpyd;

    @Column(name = "PEMBULATAN", length = 22)
    private Long pembulatan;

    @Column(name = "UPAH_VETERAN", length = 22)
    private Long upahVeteran;

    @Column(name = "POTONGAN_VGA", length = 22)
    private Long potonganVga;

    @Column(name = "POTONGAN_VETERAN", length = 22)
    private Long potonganVeteran;

    @Column(name = "POTONGAN_OLAHRAGA", length = 22)
    private Long potonganOlahraga;

    @Column(name = "KURANG_BAYAR_MP_BULANAN", length = 22)
    private Long kurangBayarMpBulanan;

    @Column(name = "LEBIH_BAYAR_MP_BULANAN", length = 22)
    private Long lebihBayarMpBulanan;

    @Column(name = "RAPEL_KB_MP_BULANAN", length = 22)
    private Long rapelKbMpBulanan;

    @Column(name = "RAPEL_LB_MP_BULANAN", length = 22)
    private Long rapelLbMpBulanan;

    @Column(name = "RAPEL_KB_PHDP", length = 22)
    private Long rapelKbPhdp;

    @Column(name = "RAPEL_KB_KENAIKAN_MP", length = 22)
    private Long rapelKbKenaikanMp;

    @Column(name = "RAPEL_KB_LAIN_LAIN", length = 22)
    private Long rapelKbLainLain;

    @Column(name = "RAPEL_KB_KETERLAMBATAN_DATA", length = 22)
    private Long rapelKbKeterlambatanData;

    @Column(name = "IS_STATUS_HER", length = 1)
    private Character isStatusHer;

    @Column(name = "STATUS_HER_DESC", length = 50)
    private String statusHerDesc;

    @Column(name = "IS_HUTANG", length = 1)
    private Character isHutang;

    @Column(name = "ID_SENT_TO_PTR", length = 22)
    private Long idSentToPtr;

    @Column(name = "IS_SENT_TO_PTR", length = 1)
    private Character isSentToPtr;

    @Column(name = "USER_STAMP", length = 50)
    private String userStamp;

    @Column(name = "NOMOR_REKENING", length = 50)
    private String nomorRekening;

    @Column(name = "JENIS_PENSIUN", length = 2)
    private String jenisPensiun;

    @Column(name = "REASON_HAPUS", length = 2)
    private String reasonHapus;

    @Column(name = "RAPEL_LB_PHDP", length = 22)
    private Long rapelLbPhdp;

    @Column(name = "RAPEL_LB_KENAIKAN_MP", length = 22)
    private Long rapelLbKenaikanMp;

    @Column(name = "RAPEL_LB_LAIN_LAIN", length = 22)
    private Long rapelLbLainLain;

    @Column(name = "RAPEL_LB_KETERLAMBATAN_DATA", length = 22)
    private Long rapelLbKeterlambatanData;

    @Column(name = "MPYD_AKHIR", length = 22)
    private Long mpydAkhir;


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

    public Golongan getIdGolongan() {
        return idGolongan;
    }

    public void setIdGolongan(Golongan idGolongan) {
        this.idGolongan = idGolongan;
    }

    public String getGolonganPangkat() {
        return golonganPangkat;
    }

    public void setGolonganPangkat(String golonganPangkat) {
        this.golonganPangkat = golonganPangkat;
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

    public StatusBayar getIdStatusBayar() {
        return idStatusBayar;
    }

    public void setIdStatusBayar(StatusBayar idStatusBayar) {
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

    public Long getPhdp() {
        return phdp;
    }

    public void setPhdp(Long phdp) {
        this.phdp = phdp;
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

    @Override
    public String getUserStamp() {
        return userStamp;
    }

    @Override
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

    @Override
    public void fromDto(PembayaranMpDetailMpDto dto){
        this.setId( dto.getId() );

        this.setNip( dto.getNip() );
        this.setNamaPeserta( dto.getNamaPeserta() );
        this.setJenisKelaminPeserta( dto.getJenisKelaminPeserta() );
        this.setTglLahirPeserta( dto.getTglLahirPeserta() );
        this.setTglKerjaPeserta( dto.getTglKerjaPeserta() );
        this.setTglDpthtPeserta( dto.getTglDpthtPeserta() );
        this.setTglHentiKerjaPeserta( dto.getTglHentiKerjaPeserta() );
        this.setTglMeninggalPeserta( dto.getTglMeninggalPeserta() );

        this.setGolonganPangkat( dto.getGolonganPangkat() );

        this.setNamaKantorBayar( dto.getNamaKantorBayar() );

        this.setNamaKategoriPensiun( dto.getNamaKategoriPensiun() );

        this.setNamaUsiaBayar( dto.getNamaUsiaBayar() );

        this.setNamaStatusBayar( dto.getNamaStatusBayar() );
        this.setTglTundaJatuhTemp( dto.getTglTundaJatuhTemp() );
        this.setTglAwalBayar( dto.getTglAwalBayar() );
        this.setTglMpBulanKe13( dto.getTglMpBulanKe13() );
        this.setTglHentiBayar( dto.getTglHentiBayar() );
        this.setIdPenerimaMp( dto.getIdPenerimaMp() );
        this.setNamaPenerimaMp( dto.getNamaPenerimaMp() );
        this.setTglLahirPenerimaMp( dto.getTglLahirPenerimaMp() );
        this.setJenisKelaminPenerimaMp( dto.getJenisKelaminPenerimaMp() );

        this.setNamaKategoriPenerimaMp( dto.getNamaKategoriPenerimaMp() );
        this.setUsiaSaatHenti( dto.getUsiaSaatHenti() );
        this.setUsiaSaatHentiBulat( dto.getUsiaSaatHentiBulat() );
        this.setUsiaPenerimaBayar( dto.getUsiaPenerimaBayar() );
        this.setUsiaPenerimaBayarBulat( dto.getUsiaPenerimaBayarBulat() );
        this.setMasaKerjaTambahan( dto.getMasaKerjaTambahan() );
        this.setMasaKerjaTambahanBulat( dto.getMasaKerjaTambahanBulat() );
        this.setMasaKerjaVeteran( dto.getMasaKerjaVeteran() );
        this.setMasaKerjaVeteranBulat( dto.getMasaKerjaVeteranBulat() );
        this.setMasaKerjaMp( dto.getMasaKerjaMp() );
        this.setMasaKerjaHenti( dto.getMasaKerjaHenti() );
        this.setMasaKerjaHentiBulat( dto.getMasaKerjaHentiBulat() );
        this.setTotalMasaKerja( dto.getTotalMasaKerja() );
        this.setTotalMasaKerjaBulat( dto.getTotalMasaKerjaBulat() );
        this.setTotalMasaKerjaAdj( dto.getTotalMasaKerjaAdj() );
        this.setTotalMasaKerjaAdjBulat( dto.getTotalMasaKerjaAdjBulat() );

        this.setNamaSuskel( dto.getNamaSuskel() );
        this.setNpwp( dto.getNpwp() );
        this.setNik( dto.getNik() );
        this.setPhdp( dto.getPhdp() );

        this.setNamaFaktorFpr( dto.getNamaFaktorFpr() );
        this.setNilaiFpr( dto.getNilaiFpr() );

        this.setNamaFaktorFs( dto.getNamaFaktorFs() );
        this.setNilaiFs( dto.getNilaiFs() );
        this.setFaktorFs( dto.getFaktorFs() );
        this.setMpBulanan( dto.getMpBulanan() );
        this.setMpBulananKe13( dto.getMpBulananKe13() );
        this.setMpBulananBulat( dto.getMpBulananBulat() );
        this.setMpBulananKe13Bulat( dto.getMpBulananKe13Bulat() );
        this.setMpyd( dto.getMpyd() );
        this.setPembulatan( dto.getPembulatan() );
        this.setUpahVeteran( dto.getUpahVeteran() );
        this.setPotonganVga( dto.getPotonganVga() );
        this.setPotonganVeteran( dto.getPotonganVeteran() );
        this.setPotonganOlahraga( dto.getPotonganOlahraga() );
        this.setKurangBayarMpBulanan( dto.getKurangBayarMpBulanan() );
        this.setLebihBayarMpBulanan( dto.getLebihBayarMpBulanan() );
        this.setRapelKbMpBulanan( dto.getRapelKbMpBulanan() );
        this.setRapelLbMpBulanan( dto.getRapelLbMpBulanan() );
        this.setRapelKbPhdp( dto.getRapelKbPhdp() );
        this.setRapelKbKenaikanMp( dto.getRapelKbKenaikanMp() );
        this.setRapelKbLainLain( dto.getRapelKbLainLain() );
        this.setRapelKbKeterlambatanData( dto.getRapelKbKeterlambatanData() );
        this.setIsStatusHer( dto.getIsStatusHer() );
        this.setStatusHerDesc( dto.getStatusHerDesc() );
        this.setIsHutang( dto.getIsHutang() );
        this.setIdSentToPtr( dto.getIdSentToPtr() );
        this.setIsSentToPtr( dto.getIsSentToPtr() );
        this.setUserStamp( dto.getUserStamp() );
        this.setNomorRekening( dto.getNomorRekening() );
        this.setJenisPensiun( dto.getJenisPensiun() );
        this.setReasonHapus( dto.getReasonHapus() );
        this.setRapelLbPhdp( dto.getRapelLbPhdp() );
        this.setRapelLbKenaikanMp( dto.getRapelLbKenaikanMp() );
        this.setRapelLbLainLain( dto.getRapelLbLainLain() );
        this.setRapelLbKeterlambatanData( dto.getRapelLbKeterlambatanData() );
        this.setMpydAkhir( dto.getMpydAkhir() );
    }




    @Override
    public PembayaranMpDetailMpDto toDto(){
        PembayaranMpDetailMpDto dto = new PembayaranMpDetailMpDto();
        dto.setId( this.getId() );

        dto.setNip( this.getNip() );
        dto.setNamaPeserta( this.getNamaPeserta() );
        dto.setJenisKelaminPeserta( this.getJenisKelaminPeserta() );
        dto.setTglLahirPeserta( this.getTglLahirPeserta() );
        dto.setTglKerjaPeserta( this.getTglKerjaPeserta() );
        dto.setTglDpthtPeserta( this.getTglDpthtPeserta() );
        dto.setTglHentiKerjaPeserta( this.getTglHentiKerjaPeserta() );
        dto.setTglMeninggalPeserta( this.getTglMeninggalPeserta() );

        dto.setGolonganPangkat( this.getGolonganPangkat() );

        dto.setNamaKantorBayar( this.getNamaKantorBayar() );

        dto.setNamaKategoriPensiun( this.getNamaKategoriPensiun() );

        dto.setNamaUsiaBayar( this.getNamaUsiaBayar() );

        dto.setNamaStatusBayar( this.getNamaStatusBayar() );
        dto.setTglTundaJatuhTemp( this.getTglTundaJatuhTemp() );
        dto.setTglAwalBayar( this.getTglAwalBayar() );
        dto.setTglMpBulanKe13( this.getTglMpBulanKe13() );
        dto.setTglHentiBayar( this.getTglHentiBayar() );
        dto.setIdPenerimaMp( this.getIdPenerimaMp() );
        dto.setNamaPenerimaMp( this.getNamaPenerimaMp() );
        dto.setTglLahirPenerimaMp( this.getTglLahirPenerimaMp() );
        dto.setJenisKelaminPenerimaMp( this.getJenisKelaminPenerimaMp() );

        dto.setNamaKategoriPenerimaMp( this.getNamaKategoriPenerimaMp() );
        dto.setUsiaSaatHenti( this.getUsiaSaatHenti() );
        dto.setUsiaSaatHentiBulat( this.getUsiaSaatHentiBulat() );
        dto.setUsiaPenerimaBayar( this.getUsiaPenerimaBayar() );
        dto.setUsiaPenerimaBayarBulat( this.getUsiaPenerimaBayarBulat() );
        dto.setMasaKerjaTambahan( this.getMasaKerjaTambahan() );
        dto.setMasaKerjaTambahanBulat( this.getMasaKerjaTambahanBulat() );
        dto.setMasaKerjaVeteran( this.getMasaKerjaVeteran() );
        dto.setMasaKerjaVeteranBulat( this.getMasaKerjaVeteranBulat() );
        dto.setMasaKerjaMp( this.getMasaKerjaMp() );
        dto.setMasaKerjaHenti( this.getMasaKerjaHenti() );
        dto.setMasaKerjaHentiBulat( this.getMasaKerjaHentiBulat() );
        dto.setTotalMasaKerja( this.getTotalMasaKerja() );
        dto.setTotalMasaKerjaBulat( this.getTotalMasaKerjaBulat() );
        dto.setTotalMasaKerjaAdj( this.getTotalMasaKerjaAdj() );
        dto.setTotalMasaKerjaAdjBulat( this.getTotalMasaKerjaAdjBulat() );

        dto.setNamaSuskel( this.getNamaSuskel() );
        dto.setNpwp( this.getNpwp() );
        dto.setNik( this.getNik() );
        dto.setPhdp( this.getPhdp() );

        dto.setNamaFaktorFpr( this.getNamaFaktorFpr() );
        dto.setNilaiFpr( this.getNilaiFpr() );

        dto.setNamaFaktorFs( this.getNamaFaktorFs() );
        dto.setNilaiFs( this.getNilaiFs() );
        dto.setFaktorFs( this.getFaktorFs() );
        dto.setMpBulanan( this.getMpBulanan() );
        dto.setMpBulananKe13( this.getMpBulananKe13() );
        dto.setMpBulananBulat( this.getMpBulananBulat() );
        dto.setMpBulananKe13Bulat( this.getMpBulananKe13Bulat() );
        dto.setMpyd( this.getMpyd() );
        dto.setPembulatan( this.getPembulatan() );
        dto.setUpahVeteran( this.getUpahVeteran() );
        dto.setPotonganVga( this.getPotonganVga() );
        dto.setPotonganVeteran( this.getPotonganVeteran() );
        dto.setPotonganOlahraga( this.getPotonganOlahraga() );
        dto.setKurangBayarMpBulanan( this.getKurangBayarMpBulanan() );
        dto.setLebihBayarMpBulanan( this.getLebihBayarMpBulanan() );
        dto.setRapelKbMpBulanan( this.getRapelKbMpBulanan() );
        dto.setRapelLbMpBulanan( this.getRapelLbMpBulanan() );
        dto.setRapelKbPhdp( this.getRapelKbPhdp() );
        dto.setRapelKbKenaikanMp( this.getRapelKbKenaikanMp() );
        dto.setRapelKbLainLain( this.getRapelKbLainLain() );
        dto.setRapelKbKeterlambatanData( this.getRapelKbKeterlambatanData() );
        dto.setIsStatusHer( this.getIsStatusHer() );
        dto.setStatusHerDesc( this.getStatusHerDesc() );
        dto.setIsHutang( this.getIsHutang() );
        dto.setIdSentToPtr( this.getIdSentToPtr() );
        dto.setIsSentToPtr( this.getIsSentToPtr() );
        dto.setUserStamp( this.getUserStamp() );
        dto.setNomorRekening( this.getNomorRekening() );
        dto.setJenisPensiun( this.getJenisPensiun() );
        dto.setReasonHapus( this.getReasonHapus() );
        dto.setRapelLbPhdp( this.getRapelLbPhdp() );
        dto.setRapelLbKenaikanMp( this.getRapelLbKenaikanMp() );
        dto.setRapelLbLainLain( this.getRapelLbLainLain() );
        dto.setRapelLbKeterlambatanData( this.getRapelLbKeterlambatanData() );
        dto.setMpydAkhir( this.getMpydAkhir() );


        return dto;
    }

}
