package com.dapenbi.dkpp.model.ViewModel;

import com.dapenbi.dkpp.dto.ViewModelDto.PensiunLamaMeninggalViewDto;
import com.dapenbi.dkpp.form.MutasiMeninggalSPFormDto;
import com.dapenbi.dkpp.model.BaseModel;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name="VW_MUTASI_PENS_LAMA_MENINGGAL")
public class PensiunLamaMeninggalView extends BaseModel<PensiunLamaMeninggalViewDto> {

    @Column(name="ALAMAT_IS_DALAM_NEGERI")
    private String alamatIsDalamNegeri;

    @Column(name="ALAMAT_LENGKAP")
    private String alamatLengkap;

    @Column(name="CREATED_AT")
    private Timestamp createdAt;

    private String email;

    @Column(name="FAKTOR_FS")
    private String faktorFs;

    @Column(name="GOLONGAN_PANGKAT")
    private String golonganPangkat;

    @Column(name="ID_AGAMA")
    private BigDecimal idAgama;

    @Column(name="ID_ALASAN_MPS_100")
    private BigDecimal idAlasanMps100;

    @Column(name="ID_BANK")
    private BigDecimal idBank;

    @Column(name="ID_FAKTOR_FPR")
    private BigDecimal idFaktorFpr;

    @Column(name="ID_FAKTOR_FS")
    private BigDecimal idFaktorFs;

    @Column(name="ID_GOLONGAN")
    private BigDecimal idGolongan;

    @Column(name="ID_HENTI")
    private String idHenti;

    @Column(name="ID_JENIS_MPS")
    private BigDecimal idJenisMps;

    @Column(name="ID_KANTOR_BAYAR")
    private String idKantorBayar;

    @Column(name="ID_KANTOR_BAYAR_BARU")
    private String idKantorBayarBaru;

    @Column(name="ID_KATEGORI_CATATAN")
    private BigDecimal idKategoriCatatan;

    @Column(name="ID_KATEGORI_MUTASI")
    private String idKategoriMutasi;

    @Column(name="ID_KATEGORI_PENERIMA_MP")
    private BigDecimal idKategoriPenerimaMp;

    @Column(name="ID_KATEGORI_PENERIMA_MP_BARU")
    private BigDecimal idKategoriPenerimaMpBaru;

    @Column(name="ID_KATEGORI_PENSIUN")
    private String idKategoriPensiun;

    @Column(name="ID_KAWIN_PENERIMAMP_BARU")
    private BigDecimal idKawinPenerimampBaru;

    @Column(name="ID_KECAMATAN")
    private BigDecimal idKecamatan;

    @Column(name="ID_KELURAHAN")
    private BigDecimal idKelurahan;

    @Column(name="ID_KOTA_KAB")
    private BigDecimal idKotaKab;

    @Id
    @Column(name="ID_MUTASI_PENSIUN")
    private BigDecimal idMutasiPensiun;

    @Column(name="ID_NEGARA")
    private BigDecimal idNegara;

    @Column(name="ID_PENERIMA_MP")
    private String idPenerimaMp;

    @Column(name="ID_PENERIMA_MP_BARU")
    private String idPenerimaMpBaru;

    @Column(name="ID_PREDIKAT")
    private BigDecimal idPredikat;

    @Column(name="ID_PROVINSI")
    private BigDecimal idProvinsi;

    @Column(name="ID_STATUS_BAYAR")
    private BigDecimal idStatusBayar;

    @Column(name="ID_STATUS_KAWIN_PENERIMA_MP")
    private BigDecimal idStatusKawinPenerimaMp;

    @Column(name="ID_SUSKEL")
    private BigDecimal idSuskel;

    @Column(name="ID_SUSKEL_BARU")
    private BigDecimal idSuskelBaru;

    @Column(name="ID_USIA_BAYAR")
    private BigDecimal idUsiaBayar;

    @Column(name="ID_VALIDASI")
    private BigDecimal idValidasi;

    @Column(name="IS_ACTIVE")
    private Boolean isActive;

    @Column(name="IS_JADI_HUTANG")
    private String isJadiHutang;

    @Column(name="IS_JADI_PIUTANG")
    private String isJadiPiutang;

    @Column(name="IS_REKENING_DAPENBI")
    private String isRekeningDapenbi;

    @Column(name="JENIS_BANK")
    private String jenisBank;

    @Column(name="JENIS_KELAMIN_PENERIMA_MP")
    private String jenisKelaminPenerimaMp;

    @Column(name="JENIS_KELAMIN_PENERIMA_MP_BARU")
    private String jenisKelaminPenerimaMpBaru;

    @Column(name="JENIS_KELAMIN_PESERTA")
    private String jenisKelaminPeserta;

    private String keterangan;

    @Column(name="KETERANGAN_HENTI")
    private String keteranganHenti;

    @Column(name="KETERANGAN_OTOMATIS")
    private String keteranganOtomatis;

    @Column(name="KODE_MUTASI")
    private String kodeMutasi;

    @Column(name="KODE_POS")
    private String kodePos;

    @Column(name="KURANG_BAYAR_MP_RUMUS")
    private BigDecimal kurangBayarMpRumus;

    @Column(name="KURANG_BAYAR_MPS100PERSEN")
    private BigDecimal kurangBayarMps100persen;

    @Column(name="KURANG_BAYAR_MPS10JUTA")
    private BigDecimal kurangBayarMps10juta;

    @Column(name="KURANG_BAYAR_MPS20PERSEN")
    private BigDecimal kurangBayarMps20persen;

    @Column(name="KURANG_BAYAR_MPYD")
    private BigDecimal kurangBayarMpyd;

    @Column(name="LEBIH_BAYAR_JML_BLN_13")
    private BigDecimal lebihBayarJmlBln13;

    @Column(name="LEBIH_BAYAR_JML_BULAN")
    private BigDecimal lebihBayarJmlBulan;

    @Column(name="LEBIH_BAYAR_MP_RUMUS")
    private BigDecimal lebihBayarMpRumus;

    @Column(name="LEBIH_BAYAR_MPS100PERSEN")
    private BigDecimal lebihBayarMps100persen;

    @Column(name="LEBIH_BAYAR_MPS10JUTA")
    private BigDecimal lebihBayarMps10juta;

    @Column(name="LEBIH_BAYAR_MPS20PERSEN")
    private BigDecimal lebihBayarMps20persen;

    @Column(name="LEBIH_BAYAR_MPYD")
    private BigDecimal lebihBayarMpyd;

    @Column(name="LEBIH_BAYAR_NOMINAL")
    private BigDecimal lebihBayarNominal;

    @Column(name="LEBIH_BAYAR_NOMINAL_13")
    private BigDecimal lebihBayarNominal13;

    @Column(name="MASA_KERJA_HENTI")
    private String masaKerjaHenti;

    @Column(name="MASA_KERJA_HENTI_BULAT")
    private String masaKerjaHentiBulat;

    @Column(name="MASA_KERJA_MP")
    private String masaKerjaMp;

    @Column(name="MASA_KERJA_TAMBAHAN")
    private String masaKerjaTambahan;

    @Column(name="MASA_KERJA_TAMBAHAN_BULAT")
    private String masaKerjaTambahanBulat;

    @Column(name="MASA_KERJA_VETERAN")
    private String masaKerjaVeteran;

    @Column(name="MASA_KERJA_VETERAN_BULAT")
    private String masaKerjaVeteranBulat;

    @Column(name="MP_BULAN13")
    private BigDecimal mpBulan13;

    @Column(name="MP_BULAN13_BARU")
    private BigDecimal mpBulan13Baru;

    @Column(name="MP_PERBULAN_10JUTA_BARU")
    private BigDecimal mpPerbulan10jutaBaru;

    @Column(name="MP_PERBULAN_10JUTA_LAMA")
    private BigDecimal mpPerbulan10jutaLama;

    @Column(name="MP_PERBULAN_20PERSEN_BARU")
    private BigDecimal mpPerbulan20persenBaru;

    @Column(name="MP_PERBULAN_20PERSEN_LAMA")
    private BigDecimal mpPerbulan20persenLama;

    @Column(name="MP_PERBULAN_RUMUS_BARU")
    private BigDecimal mpPerbulanRumusBaru;

    @Column(name="MP_PERBULAN_RUMUS_LAMA")
    private BigDecimal mpPerbulanRumusLama;

    @Column(name="MPS_100PERSEN_BARU")
    private BigDecimal mps100persenBaru;

    @Column(name="MPS_100PERSEN_BULAT_BARU")
    private BigDecimal mps100persenBulatBaru;

    @Column(name="MPS_100PERSEN_BULAT_LAMA")
    private BigDecimal mps100persenBulatLama;

    @Column(name="MPS_100PERSEN_LAMA")
    private BigDecimal mps100persenLama;

    @Column(name="MPS_10JUTA_BARU")
    private BigDecimal mps10jutaBaru;

    @Column(name="MPS_10JUTA_LAMA")
    private BigDecimal mps10jutaLama;

    @Column(name="MPS_20PERSEN_BARU")
    private BigDecimal mps20persenBaru;

    @Column(name="MPS_20PERSEN_LAMA")
    private BigDecimal mps20persenLama;

    @Column(name="MPYD_BARU")
    private BigDecimal mpydBaru;

    @Column(name="MPYD_LAMA")
    private BigDecimal mpydLama;

    @Column(name="NAMA_AGAMA")
    private String namaAgama;

    @Column(name="NAMA_ALASAN_MPS_100")
    private String namaAlasanMps100;

    @Column(name="NAMA_CABANG_BANK")
    private String namaCabangBank;

    @Column(name="NAMA_FAKTOR_FPR")
    private String namaFaktorFpr;

    @Column(name="NAMA_FAKTOR_FS")
    private String namaFaktorFs;

    @Column(name="NAMA_KANTOR_BAYAR")
    private String namaKantorBayar;

    @Column(name="NAMA_KANTOR_BAYAR_BARU")
    private String namaKantorBayarBaru;

    @Column(name="NAMA_KATEGORI_PENERIMA_MP")
    private String namaKategoriPenerimaMp;

    @Column(name="NAMA_KATEGORI_PENERIMA_MP_BARU")
    private String namaKategoriPenerimaMpBaru;

    @Column(name="NAMA_KATEGORI_PENSIUN")
    private String namaKategoriPensiun;

    @Column(name="NAMA_KAWIN_PENERIMAMP_BARU")
    private String namaKawinPenerimampBaru;

    @Column(name="NAMA_KECAMATAN")
    private String namaKecamatan;

    @Column(name="NAMA_KELURAHAN")
    private String namaKelurahan;

    @Column(name="NAMA_KOTA_KAB")
    private String namaKotaKab;

    @Column(name="NAMA_MPS")
    private String namaMps;

    @Column(name="NAMA_NEGARA")
    private String namaNegara;

    @Column(name="NAMA_PADA_REK_BANK")
    private String namaPadaRekBank;

    @Column(name="NAMA_PENERIMA_MP")
    private String namaPenerimaMp;

    @Column(name="NAMA_PENERIMA_MP_BARU")
    private String namaPenerimaMpBaru;

    @Column(name="NAMA_PESERTA")
    private String namaPeserta;

    @Column(name="NAMA_PREDIKAT")
    private String namaPredikat;

    @Column(name="NAMA_PROVINSI")
    private String namaProvinsi;

    @Column(name="NAMA_STATUS_KAWIN_PENERIMA_MP")
    private String namaStatusKawinPenerimaMp;

    @Column(name="NAMA_SUSKEL")
    private String namaSuskel;

    @Column(name="NAMA_SUSKEL_BARU")
    private String namaSuskelBaru;

    @Column(name="NAMA_USIA_BAYAR")
    private String namaUsiaBayar;

    @Column(name="NAMA_VALIDASI")
    private String namaValidasi;

    @Column(name="NILAI_FPR")
    private BigDecimal nilaiFpr;

    @Column(name="NILAI_FS")
    private BigDecimal nilaiFs;

    private String nip;

    @Column(name="NO_HP")
    private String noHp;

    @Column(name="NO_SK_BI")
    private String noSkBi;

    @Column(name="NO_SK_DAPENBI")
    private String noSkDapenbi;

    @Column(name="NO_SP_BI")
    private String noSpBi;

    @Column(name="NO_TLP")
    private String noTlp;

    @Column(name="NOMINAL_TERBAYAR")
    private BigDecimal nominalTerbayar;

    @Column(name="NOMOR_HER")
    private String nomorHer;

    @Column(name="NOMOR_REKENING")
    private String nomorRekening;

    @Column(name="PERIODE_MUTASI")
    private String periodeMutasi;

    @Column(name="PHDP_BARU")
    private BigDecimal phdpBaru;

    @Column(name="PHDP_LAMA")
    private BigDecimal phdpLama;

    @Column(name="RAPEL_MPYD_KURANG")
    private BigDecimal rapelMpydKurang;

    @Column(name="RAPEL_MPYD_LEBIH")
    private BigDecimal rapelMpydLebih;

    private String rt;

    private String rw;

    @Column(name="STATUS_BAYAR")
    private String statusBayar;

    @Column(name="TEMPAT_LAHIR_PESERTA")
    private String tempatLahirPeserta;

    @Column(name="TEMPAT_MENINGGAL_PESERTA")
    private String tempatMeninggalPeserta;

    @Temporal(TemporalType.DATE)
    @Column(name="TGL_AWAL_BAYAR")
    private Date tglAwalBayar;

    @Temporal(TemporalType.DATE)
    @Column(name="TGL_DPTHT_PESERTA")
    private Date tglDpthtPeserta;

    @Temporal(TemporalType.DATE)
    @Column(name="TGL_HENTI_BAYAR")
    private Date tglHentiBayar;

    @Temporal(TemporalType.DATE)
    @Column(name="TGL_HENTI_KERJA_PESERTA")
    private Date tglHentiKerjaPeserta;

    @Temporal(TemporalType.DATE)
    @Column(name="TGL_INF_NIKAH_PENERIMAMP_LAMA")
    private Date tglInfNikahPenerimampLama;

    @Temporal(TemporalType.DATE)
    @Column(name="TGL_INF_WFT_PENERIMAMP_LAMA")
    private Date tglInfWftPenerimampLama;

    @Temporal(TemporalType.DATE)
    @Column(name="TGL_KERJA_PESERTA")
    private Date tglKerjaPeserta;

    @Temporal(TemporalType.DATE)
    @Column(name="TGL_LAHIR_PENERIMA_MP")
    private Date tglLahirPenerimaMp;

    @Temporal(TemporalType.DATE)
    @Column(name="TGL_LAHIR_PENERIMA_MP_BARU")
    private Date tglLahirPenerimaMpBaru;

    @Temporal(TemporalType.DATE)
    @Column(name="TGL_LAHIR_PESERTA")
    private Date tglLahirPeserta;

    @Temporal(TemporalType.DATE)
    @Column(name="TGL_MENIKAHLAGI_PENERIMA_MP")
    private Date tglMenikahlagiPenerimaMp;

    @Temporal(TemporalType.DATE)
    @Column(name="TGL_MENINGGAL_PENERIMA_MP")
    private Date tglMeninggalPenerimaMp;

    @Temporal(TemporalType.DATE)
    @Column(name="TGL_MENINGGAL_PESERTA")
    private Date tglMeninggalPeserta;

    @Temporal(TemporalType.DATE)
    @Column(name="TGL_MP_BULAN_KE13")
    private Date tglMpBulanKe13;

    @Temporal(TemporalType.DATE)
    @Column(name="TGL_MULAI_BERLAKU_PHDP_BARU")
    private Date tglMulaiBerlakuPhdpBaru;

    @Temporal(TemporalType.DATE)
    @Column(name="TGL_MUTASI")
    private Date tglMutasi;

    @Temporal(TemporalType.DATE)
    @Column(name="TGL_PERMOHONAN_MPS100")
    private Date tglPermohonanMps100;

    @Temporal(TemporalType.DATE)
    @Column(name="TGL_SK_BI")
    private Date tglSkBi;

    @Temporal(TemporalType.DATE)
    @Column(name="TGL_SK_DAPENBI")
    private Date tglSkDapenbi;

    @Temporal(TemporalType.DATE)
    @Column(name="TGL_SP_BI")
    private Date tglSpBi;

    @Temporal(TemporalType.DATE)
    @Column(name="TGL_TUNDA_JATUH_TEMPO")
    private Date tglTundaJatuhTempo;

    @Temporal(TemporalType.DATE)
    @Column(name="TGL_USIA_25T_PENERIMA_MP")
    private Date tglUsia25tPenerimaMp;

    @Temporal(TemporalType.DATE)
    @Column(name="TGL_USIA_25T_PENERIMA_MP_BARU")
    private Date tglUsia25tPenerimaMpBaru;

    @Column(name="TOTAL_MASA_KERJA")
    private String totalMasaKerja;

    @Column(name="TOTAL_MASA_KERJA_ADJ")
    private String totalMasaKerjaAdj;

    @Column(name="TOTAL_MASA_KERJA_BULAT")
    private String totalMasaKerjaBulat;

    @Column(name="TOTAL_MASA_KERJA_BULAT_ADJ")
    private String totalMasaKerjaBulatAdj;

    @Column(name="UPAH_VETERAN")
    private BigDecimal upahVeteran;

    @Column(name="UPDATED_AT")
    private Timestamp updatedAt;

    @Column(name="USER_STAMP")
    private String userStamp;

    @Column(name="USER_VALIDASI")
    private String userValidasi;

    @Column(name="USIA_PENERIMA_BAYAR")
    private String usiaPenerimaBayar;

    @Column(name="USIA_PENERIMA_BAYAR_BULAT")
    private String usiaPenerimaBayarBulat;

    @Column(name="USIA_SAAT_HENTI")
    private String usiaSaatHenti;

    @Column(name="USIA_SAAT_HENTI_BULAT")
    private String usiaSaatHentiBulat;

    public PensiunLamaMeninggalView() {
    }

    public String getAlamatIsDalamNegeri() {
        return this.alamatIsDalamNegeri;
    }

    public void setAlamatIsDalamNegeri(String alamatIsDalamNegeri) {
        this.alamatIsDalamNegeri = alamatIsDalamNegeri;
    }

    public String getAlamatLengkap() {
        return this.alamatLengkap;
    }

    public void setAlamatLengkap(String alamatLengkap) {
        this.alamatLengkap = alamatLengkap;
    }

    public Timestamp getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFaktorFs() {
        return this.faktorFs;
    }

    public void setFaktorFs(String faktorFs) {
        this.faktorFs = faktorFs;
    }

    public String getGolonganPangkat() {
        return this.golonganPangkat;
    }

    public void setGolonganPangkat(String golonganPangkat) {
        this.golonganPangkat = golonganPangkat;
    }

    public BigDecimal getIdAgama() {
        return this.idAgama;
    }

    public void setIdAgama(BigDecimal idAgama) {
        this.idAgama = idAgama;
    }

    public BigDecimal getIdAlasanMps100() {
        return this.idAlasanMps100;
    }

    public void setIdAlasanMps100(BigDecimal idAlasanMps100) {
        this.idAlasanMps100 = idAlasanMps100;
    }

    public BigDecimal getIdBank() {
        return this.idBank;
    }

    public void setIdBank(BigDecimal idBank) {
        this.idBank = idBank;
    }

    public BigDecimal getIdFaktorFpr() {
        return this.idFaktorFpr;
    }

    public void setIdFaktorFpr(BigDecimal idFaktorFpr) {
        this.idFaktorFpr = idFaktorFpr;
    }

    public BigDecimal getIdFaktorFs() {
        return this.idFaktorFs;
    }

    public void setIdFaktorFs(BigDecimal idFaktorFs) {
        this.idFaktorFs = idFaktorFs;
    }

    public BigDecimal getIdGolongan() {
        return this.idGolongan;
    }

    public void setIdGolongan(BigDecimal idGolongan) {
        this.idGolongan = idGolongan;
    }

    public String getIdHenti() {
        return this.idHenti;
    }

    public void setIdHenti(String idHenti) {
        this.idHenti = idHenti;
    }

    public BigDecimal getIdJenisMps() {
        return this.idJenisMps;
    }

    public void setIdJenisMps(BigDecimal idJenisMps) {
        this.idJenisMps = idJenisMps;
    }

    public String getIdKantorBayar() {
        return this.idKantorBayar;
    }

    public void setIdKantorBayar(String idKantorBayar) {
        this.idKantorBayar = idKantorBayar;
    }

    public String getIdKantorBayarBaru() {
        return this.idKantorBayarBaru;
    }

    public void setIdKantorBayarBaru(String idKantorBayarBaru) {
        this.idKantorBayarBaru = idKantorBayarBaru;
    }

    public BigDecimal getIdKategoriCatatan() {
        return this.idKategoriCatatan;
    }

    public void setIdKategoriCatatan(BigDecimal idKategoriCatatan) {
        this.idKategoriCatatan = idKategoriCatatan;
    }

    public String getIdKategoriMutasi() {
        return this.idKategoriMutasi;
    }

    public void setIdKategoriMutasi(String idKategoriMutasi) {
        this.idKategoriMutasi = idKategoriMutasi;
    }

    public BigDecimal getIdKategoriPenerimaMp() {
        return this.idKategoriPenerimaMp;
    }

    public void setIdKategoriPenerimaMp(BigDecimal idKategoriPenerimaMp) {
        this.idKategoriPenerimaMp = idKategoriPenerimaMp;
    }

    public BigDecimal getIdKategoriPenerimaMpBaru() {
        return this.idKategoriPenerimaMpBaru;
    }

    public void setIdKategoriPenerimaMpBaru(BigDecimal idKategoriPenerimaMpBaru) {
        this.idKategoriPenerimaMpBaru = idKategoriPenerimaMpBaru;
    }

    public String getIdKategoriPensiun() {
        return this.idKategoriPensiun;
    }

    public void setIdKategoriPensiun(String idKategoriPensiun) {
        this.idKategoriPensiun = idKategoriPensiun;
    }

    public BigDecimal getIdKawinPenerimampBaru() {
        return this.idKawinPenerimampBaru;
    }

    public void setIdKawinPenerimampBaru(BigDecimal idKawinPenerimampBaru) {
        this.idKawinPenerimampBaru = idKawinPenerimampBaru;
    }

    public BigDecimal getIdKecamatan() {
        return this.idKecamatan;
    }

    public void setIdKecamatan(BigDecimal idKecamatan) {
        this.idKecamatan = idKecamatan;
    }

    public BigDecimal getIdKelurahan() {
        return this.idKelurahan;
    }

    public void setIdKelurahan(BigDecimal idKelurahan) {
        this.idKelurahan = idKelurahan;
    }

    public BigDecimal getIdKotaKab() {
        return this.idKotaKab;
    }

    public void setIdKotaKab(BigDecimal idKotaKab) {
        this.idKotaKab = idKotaKab;
    }

    public BigDecimal getIdMutasiPensiun() {
        return this.idMutasiPensiun;
    }

    public void setIdMutasiPensiun(BigDecimal idMutasiPensiun) {
        this.idMutasiPensiun = idMutasiPensiun;
    }

    public BigDecimal getIdNegara() {
        return this.idNegara;
    }

    public void setIdNegara(BigDecimal idNegara) {
        this.idNegara = idNegara;
    }

    public String getIdPenerimaMp() {
        return this.idPenerimaMp;
    }

    public void setIdPenerimaMp(String idPenerimaMp) {
        this.idPenerimaMp = idPenerimaMp;
    }

    public String getIdPenerimaMpBaru() {
        return this.idPenerimaMpBaru;
    }

    public void setIdPenerimaMpBaru(String idPenerimaMpBaru) {
        this.idPenerimaMpBaru = idPenerimaMpBaru;
    }

    public BigDecimal getIdPredikat() {
        return this.idPredikat;
    }

    public void setIdPredikat(BigDecimal idPredikat) {
        this.idPredikat = idPredikat;
    }

    public BigDecimal getIdProvinsi() {
        return this.idProvinsi;
    }

    public void setIdProvinsi(BigDecimal idProvinsi) {
        this.idProvinsi = idProvinsi;
    }

    public BigDecimal getIdStatusBayar() {
        return this.idStatusBayar;
    }

    public void setIdStatusBayar(BigDecimal idStatusBayar) {
        this.idStatusBayar = idStatusBayar;
    }

    public BigDecimal getIdStatusKawinPenerimaMp() {
        return this.idStatusKawinPenerimaMp;
    }

    public void setIdStatusKawinPenerimaMp(BigDecimal idStatusKawinPenerimaMp) {
        this.idStatusKawinPenerimaMp = idStatusKawinPenerimaMp;
    }

    public BigDecimal getIdSuskel() {
        return this.idSuskel;
    }

    public void setIdSuskel(BigDecimal idSuskel) {
        this.idSuskel = idSuskel;
    }

    public BigDecimal getIdSuskelBaru() {
        return this.idSuskelBaru;
    }

    public void setIdSuskelBaru(BigDecimal idSuskelBaru) {
        this.idSuskelBaru = idSuskelBaru;
    }

    public BigDecimal getIdUsiaBayar() {
        return this.idUsiaBayar;
    }

    public void setIdUsiaBayar(BigDecimal idUsiaBayar) {
        this.idUsiaBayar = idUsiaBayar;
    }

    public BigDecimal getIdValidasi() {
        return this.idValidasi;
    }

    public void setIdValidasi(BigDecimal idValidasi) {
        this.idValidasi = idValidasi;
    }

    public Boolean getActive() {
        return this.isActive;
    }

    public void setActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getIsJadiHutang() {
        return this.isJadiHutang;
    }

    public void setIsJadiHutang(String isJadiHutang) {
        this.isJadiHutang = isJadiHutang;
    }

    public String getIsJadiPiutang() {
        return this.isJadiPiutang;
    }

    public void setIsJadiPiutang(String isJadiPiutang) {
        this.isJadiPiutang = isJadiPiutang;
    }

    public String getIsRekeningDapenbi() {
        return this.isRekeningDapenbi;
    }

    public void setIsRekeningDapenbi(String isRekeningDapenbi) {
        this.isRekeningDapenbi = isRekeningDapenbi;
    }

    public String getJenisBank() {
        return this.jenisBank;
    }

    public void setJenisBank(String jenisBank) {
        this.jenisBank = jenisBank;
    }

    public String getJenisKelaminPenerimaMp() {
        return this.jenisKelaminPenerimaMp;
    }

    public void setJenisKelaminPenerimaMp(String jenisKelaminPenerimaMp) {
        this.jenisKelaminPenerimaMp = jenisKelaminPenerimaMp;
    }

    public String getJenisKelaminPenerimaMpBaru() {
        return this.jenisKelaminPenerimaMpBaru;
    }

    public void setJenisKelaminPenerimaMpBaru(String jenisKelaminPenerimaMpBaru) {
        this.jenisKelaminPenerimaMpBaru = jenisKelaminPenerimaMpBaru;
    }

    public String getJenisKelaminPeserta() {
        return this.jenisKelaminPeserta;
    }

    public void setJenisKelaminPeserta(String jenisKelaminPeserta) {
        this.jenisKelaminPeserta = jenisKelaminPeserta;
    }

    public String getKeterangan() {
        return this.keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getKeteranganHenti() {
        return this.keteranganHenti;
    }

    public void setKeteranganHenti(String keteranganHenti) {
        this.keteranganHenti = keteranganHenti;
    }

    public String getKeteranganOtomatis() {
        return this.keteranganOtomatis;
    }

    public void setKeteranganOtomatis(String keteranganOtomatis) {
        this.keteranganOtomatis = keteranganOtomatis;
    }

    public String getKodeMutasi() {
        return this.kodeMutasi;
    }

    public void setKodeMutasi(String kodeMutasi) {
        this.kodeMutasi = kodeMutasi;
    }

    public String getKodePos() {
        return this.kodePos;
    }

    public void setKodePos(String kodePos) {
        this.kodePos = kodePos;
    }

    public BigDecimal getKurangBayarMpRumus() {
        return this.kurangBayarMpRumus;
    }

    public void setKurangBayarMpRumus(BigDecimal kurangBayarMpRumus) {
        this.kurangBayarMpRumus = kurangBayarMpRumus;
    }

    public BigDecimal getKurangBayarMps100persen() {
        return this.kurangBayarMps100persen;
    }

    public void setKurangBayarMps100persen(BigDecimal kurangBayarMps100persen) {
        this.kurangBayarMps100persen = kurangBayarMps100persen;
    }

    public BigDecimal getKurangBayarMps10juta() {
        return this.kurangBayarMps10juta;
    }

    public void setKurangBayarMps10juta(BigDecimal kurangBayarMps10juta) {
        this.kurangBayarMps10juta = kurangBayarMps10juta;
    }

    public BigDecimal getKurangBayarMps20persen() {
        return this.kurangBayarMps20persen;
    }

    public void setKurangBayarMps20persen(BigDecimal kurangBayarMps20persen) {
        this.kurangBayarMps20persen = kurangBayarMps20persen;
    }

    public BigDecimal getKurangBayarMpyd() {
        return this.kurangBayarMpyd;
    }

    public void setKurangBayarMpyd(BigDecimal kurangBayarMpyd) {
        this.kurangBayarMpyd = kurangBayarMpyd;
    }

    public BigDecimal getLebihBayarJmlBln13() {
        return this.lebihBayarJmlBln13;
    }

    public void setLebihBayarJmlBln13(BigDecimal lebihBayarJmlBln13) {
        this.lebihBayarJmlBln13 = lebihBayarJmlBln13;
    }

    public BigDecimal getLebihBayarJmlBulan() {
        return this.lebihBayarJmlBulan;
    }

    public void setLebihBayarJmlBulan(BigDecimal lebihBayarJmlBulan) {
        this.lebihBayarJmlBulan = lebihBayarJmlBulan;
    }

    public BigDecimal getLebihBayarMpRumus() {
        return this.lebihBayarMpRumus;
    }

    public void setLebihBayarMpRumus(BigDecimal lebihBayarMpRumus) {
        this.lebihBayarMpRumus = lebihBayarMpRumus;
    }

    public BigDecimal getLebihBayarMps100persen() {
        return this.lebihBayarMps100persen;
    }

    public void setLebihBayarMps100persen(BigDecimal lebihBayarMps100persen) {
        this.lebihBayarMps100persen = lebihBayarMps100persen;
    }

    public BigDecimal getLebihBayarMps10juta() {
        return this.lebihBayarMps10juta;
    }

    public void setLebihBayarMps10juta(BigDecimal lebihBayarMps10juta) {
        this.lebihBayarMps10juta = lebihBayarMps10juta;
    }

    public BigDecimal getLebihBayarMps20persen() {
        return this.lebihBayarMps20persen;
    }

    public void setLebihBayarMps20persen(BigDecimal lebihBayarMps20persen) {
        this.lebihBayarMps20persen = lebihBayarMps20persen;
    }

    public BigDecimal getLebihBayarMpyd() {
        return this.lebihBayarMpyd;
    }

    public void setLebihBayarMpyd(BigDecimal lebihBayarMpyd) {
        this.lebihBayarMpyd = lebihBayarMpyd;
    }

    public BigDecimal getLebihBayarNominal() {
        return this.lebihBayarNominal;
    }

    public void setLebihBayarNominal(BigDecimal lebihBayarNominal) {
        this.lebihBayarNominal = lebihBayarNominal;
    }

    public BigDecimal getLebihBayarNominal13() {
        return this.lebihBayarNominal13;
    }

    public void setLebihBayarNominal13(BigDecimal lebihBayarNominal13) {
        this.lebihBayarNominal13 = lebihBayarNominal13;
    }

    public String getMasaKerjaHenti() {
        return this.masaKerjaHenti;
    }

    public void setMasaKerjaHenti(String masaKerjaHenti) {
        this.masaKerjaHenti = masaKerjaHenti;
    }

    public String getMasaKerjaHentiBulat() {
        return this.masaKerjaHentiBulat;
    }

    public void setMasaKerjaHentiBulat(String masaKerjaHentiBulat) {
        this.masaKerjaHentiBulat = masaKerjaHentiBulat;
    }

    public String getMasaKerjaMp() {
        return this.masaKerjaMp;
    }

    public void setMasaKerjaMp(String masaKerjaMp) {
        this.masaKerjaMp = masaKerjaMp;
    }

    public String getMasaKerjaTambahan() {
        return this.masaKerjaTambahan;
    }

    public void setMasaKerjaTambahan(String masaKerjaTambahan) {
        this.masaKerjaTambahan = masaKerjaTambahan;
    }

    public String getMasaKerjaTambahanBulat() {
        return this.masaKerjaTambahanBulat;
    }

    public void setMasaKerjaTambahanBulat(String masaKerjaTambahanBulat) {
        this.masaKerjaTambahanBulat = masaKerjaTambahanBulat;
    }

    public String getMasaKerjaVeteran() {
        return this.masaKerjaVeteran;
    }

    public void setMasaKerjaVeteran(String masaKerjaVeteran) {
        this.masaKerjaVeteran = masaKerjaVeteran;
    }

    public String getMasaKerjaVeteranBulat() {
        return this.masaKerjaVeteranBulat;
    }

    public void setMasaKerjaVeteranBulat(String masaKerjaVeteranBulat) {
        this.masaKerjaVeteranBulat = masaKerjaVeteranBulat;
    }

    public BigDecimal getMpBulan13() {
        return this.mpBulan13;
    }

    public void setMpBulan13(BigDecimal mpBulan13) {
        this.mpBulan13 = mpBulan13;
    }

    public BigDecimal getMpBulan13Baru() {
        return this.mpBulan13Baru;
    }

    public void setMpBulan13Baru(BigDecimal mpBulan13Baru) {
        this.mpBulan13Baru = mpBulan13Baru;
    }

    public BigDecimal getMpPerbulan10jutaBaru() {
        return this.mpPerbulan10jutaBaru;
    }

    public void setMpPerbulan10jutaBaru(BigDecimal mpPerbulan10jutaBaru) {
        this.mpPerbulan10jutaBaru = mpPerbulan10jutaBaru;
    }

    public BigDecimal getMpPerbulan10jutaLama() {
        return this.mpPerbulan10jutaLama;
    }

    public void setMpPerbulan10jutaLama(BigDecimal mpPerbulan10jutaLama) {
        this.mpPerbulan10jutaLama = mpPerbulan10jutaLama;
    }

    public BigDecimal getMpPerbulan20persenBaru() {
        return this.mpPerbulan20persenBaru;
    }

    public void setMpPerbulan20persenBaru(BigDecimal mpPerbulan20persenBaru) {
        this.mpPerbulan20persenBaru = mpPerbulan20persenBaru;
    }

    public BigDecimal getMpPerbulan20persenLama() {
        return this.mpPerbulan20persenLama;
    }

    public void setMpPerbulan20persenLama(BigDecimal mpPerbulan20persenLama) {
        this.mpPerbulan20persenLama = mpPerbulan20persenLama;
    }

    public BigDecimal getMpPerbulanRumusBaru() {
        return this.mpPerbulanRumusBaru;
    }

    public void setMpPerbulanRumusBaru(BigDecimal mpPerbulanRumusBaru) {
        this.mpPerbulanRumusBaru = mpPerbulanRumusBaru;
    }

    public BigDecimal getMpPerbulanRumusLama() {
        return this.mpPerbulanRumusLama;
    }

    public void setMpPerbulanRumusLama(BigDecimal mpPerbulanRumusLama) {
        this.mpPerbulanRumusLama = mpPerbulanRumusLama;
    }

    public BigDecimal getMps100persenBaru() {
        return this.mps100persenBaru;
    }

    public void setMps100persenBaru(BigDecimal mps100persenBaru) {
        this.mps100persenBaru = mps100persenBaru;
    }

    public BigDecimal getMps100persenBulatBaru() {
        return this.mps100persenBulatBaru;
    }

    public void setMps100persenBulatBaru(BigDecimal mps100persenBulatBaru) {
        this.mps100persenBulatBaru = mps100persenBulatBaru;
    }

    public BigDecimal getMps100persenBulatLama() {
        return this.mps100persenBulatLama;
    }

    public void setMps100persenBulatLama(BigDecimal mps100persenBulatLama) {
        this.mps100persenBulatLama = mps100persenBulatLama;
    }

    public BigDecimal getMps100persenLama() {
        return this.mps100persenLama;
    }

    public void setMps100persenLama(BigDecimal mps100persenLama) {
        this.mps100persenLama = mps100persenLama;
    }

    public BigDecimal getMps10jutaBaru() {
        return this.mps10jutaBaru;
    }

    public void setMps10jutaBaru(BigDecimal mps10jutaBaru) {
        this.mps10jutaBaru = mps10jutaBaru;
    }

    public BigDecimal getMps10jutaLama() {
        return this.mps10jutaLama;
    }

    public void setMps10jutaLama(BigDecimal mps10jutaLama) {
        this.mps10jutaLama = mps10jutaLama;
    }

    public BigDecimal getMps20persenBaru() {
        return this.mps20persenBaru;
    }

    public void setMps20persenBaru(BigDecimal mps20persenBaru) {
        this.mps20persenBaru = mps20persenBaru;
    }

    public BigDecimal getMps20persenLama() {
        return this.mps20persenLama;
    }

    public void setMps20persenLama(BigDecimal mps20persenLama) {
        this.mps20persenLama = mps20persenLama;
    }

    public BigDecimal getMpydBaru() {
        return this.mpydBaru;
    }

    public void setMpydBaru(BigDecimal mpydBaru) {
        this.mpydBaru = mpydBaru;
    }

    public BigDecimal getMpydLama() {
        return this.mpydLama;
    }

    public void setMpydLama(BigDecimal mpydLama) {
        this.mpydLama = mpydLama;
    }

    public String getNamaAgama() {
        return this.namaAgama;
    }

    public void setNamaAgama(String namaAgama) {
        this.namaAgama = namaAgama;
    }

    public String getNamaAlasanMps100() {
        return this.namaAlasanMps100;
    }

    public void setNamaAlasanMps100(String namaAlasanMps100) {
        this.namaAlasanMps100 = namaAlasanMps100;
    }

    public String getNamaCabangBank() {
        return this.namaCabangBank;
    }

    public void setNamaCabangBank(String namaCabangBank) {
        this.namaCabangBank = namaCabangBank;
    }

    public String getNamaFaktorFpr() {
        return this.namaFaktorFpr;
    }

    public void setNamaFaktorFpr(String namaFaktorFpr) {
        this.namaFaktorFpr = namaFaktorFpr;
    }

    public String getNamaFaktorFs() {
        return this.namaFaktorFs;
    }

    public void setNamaFaktorFs(String namaFaktorFs) {
        this.namaFaktorFs = namaFaktorFs;
    }

    public String getNamaKantorBayar() {
        return this.namaKantorBayar;
    }

    public void setNamaKantorBayar(String namaKantorBayar) {
        this.namaKantorBayar = namaKantorBayar;
    }

    public String getNamaKantorBayarBaru() {
        return this.namaKantorBayarBaru;
    }

    public void setNamaKantorBayarBaru(String namaKantorBayarBaru) {
        this.namaKantorBayarBaru = namaKantorBayarBaru;
    }

    public String getNamaKategoriPenerimaMp() {
        return this.namaKategoriPenerimaMp;
    }

    public void setNamaKategoriPenerimaMp(String namaKategoriPenerimaMp) {
        this.namaKategoriPenerimaMp = namaKategoriPenerimaMp;
    }

    public String getNamaKategoriPenerimaMpBaru() {
        return this.namaKategoriPenerimaMpBaru;
    }

    public void setNamaKategoriPenerimaMpBaru(String namaKategoriPenerimaMpBaru) {
        this.namaKategoriPenerimaMpBaru = namaKategoriPenerimaMpBaru;
    }

    public String getNamaKategoriPensiun() {
        return this.namaKategoriPensiun;
    }

    public void setNamaKategoriPensiun(String namaKategoriPensiun) {
        this.namaKategoriPensiun = namaKategoriPensiun;
    }

    public String getNamaKawinPenerimampBaru() {
        return this.namaKawinPenerimampBaru;
    }

    public void setNamaKawinPenerimampBaru(String namaKawinPenerimampBaru) {
        this.namaKawinPenerimampBaru = namaKawinPenerimampBaru;
    }

    public String getNamaKecamatan() {
        return this.namaKecamatan;
    }

    public void setNamaKecamatan(String namaKecamatan) {
        this.namaKecamatan = namaKecamatan;
    }

    public String getNamaKelurahan() {
        return this.namaKelurahan;
    }

    public void setNamaKelurahan(String namaKelurahan) {
        this.namaKelurahan = namaKelurahan;
    }

    public String getNamaKotaKab() {
        return this.namaKotaKab;
    }

    public void setNamaKotaKab(String namaKotaKab) {
        this.namaKotaKab = namaKotaKab;
    }

    public String getNamaMps() {
        return this.namaMps;
    }

    public void setNamaMps(String namaMps) {
        this.namaMps = namaMps;
    }

    public String getNamaNegara() {
        return this.namaNegara;
    }

    public void setNamaNegara(String namaNegara) {
        this.namaNegara = namaNegara;
    }

    public String getNamaPadaRekBank() {
        return this.namaPadaRekBank;
    }

    public void setNamaPadaRekBank(String namaPadaRekBank) {
        this.namaPadaRekBank = namaPadaRekBank;
    }

    public String getNamaPenerimaMp() {
        return this.namaPenerimaMp;
    }

    public void setNamaPenerimaMp(String namaPenerimaMp) {
        this.namaPenerimaMp = namaPenerimaMp;
    }

    public String getNamaPenerimaMpBaru() {
        return this.namaPenerimaMpBaru;
    }

    public void setNamaPenerimaMpBaru(String namaPenerimaMpBaru) {
        this.namaPenerimaMpBaru = namaPenerimaMpBaru;
    }

    public String getNamaPeserta() {
        return this.namaPeserta;
    }

    public void setNamaPeserta(String namaPeserta) {
        this.namaPeserta = namaPeserta;
    }

    public String getNamaPredikat() {
        return this.namaPredikat;
    }

    public void setNamaPredikat(String namaPredikat) {
        this.namaPredikat = namaPredikat;
    }

    public String getNamaProvinsi() {
        return this.namaProvinsi;
    }

    public void setNamaProvinsi(String namaProvinsi) {
        this.namaProvinsi = namaProvinsi;
    }

    public String getNamaStatusKawinPenerimaMp() {
        return this.namaStatusKawinPenerimaMp;
    }

    public void setNamaStatusKawinPenerimaMp(String namaStatusKawinPenerimaMp) {
        this.namaStatusKawinPenerimaMp = namaStatusKawinPenerimaMp;
    }

    public String getNamaSuskel() {
        return this.namaSuskel;
    }

    public void setNamaSuskel(String namaSuskel) {
        this.namaSuskel = namaSuskel;
    }

    public String getNamaSuskelBaru() {
        return this.namaSuskelBaru;
    }

    public void setNamaSuskelBaru(String namaSuskelBaru) {
        this.namaSuskelBaru = namaSuskelBaru;
    }

    public String getNamaUsiaBayar() {
        return this.namaUsiaBayar;
    }

    public void setNamaUsiaBayar(String namaUsiaBayar) {
        this.namaUsiaBayar = namaUsiaBayar;
    }

    public String getNamaValidasi() {
        return this.namaValidasi;
    }

    public void setNamaValidasi(String namaValidasi) {
        this.namaValidasi = namaValidasi;
    }

    public BigDecimal getNilaiFpr() {
        return this.nilaiFpr;
    }

    public void setNilaiFpr(BigDecimal nilaiFpr) {
        this.nilaiFpr = nilaiFpr;
    }

    public BigDecimal getNilaiFs() {
        return this.nilaiFs;
    }

    public void setNilaiFs(BigDecimal nilaiFs) {
        this.nilaiFs = nilaiFs;
    }

    public String getNip() {
        return this.nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNoHp() {
        return this.noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getNoSkBi() {
        return this.noSkBi;
    }

    public void setNoSkBi(String noSkBi) {
        this.noSkBi = noSkBi;
    }

    public String getNoSkDapenbi() {
        return this.noSkDapenbi;
    }

    public void setNoSkDapenbi(String noSkDapenbi) {
        this.noSkDapenbi = noSkDapenbi;
    }

    public String getNoSpBi() {
        return this.noSpBi;
    }

    public void setNoSpBi(String noSpBi) {
        this.noSpBi = noSpBi;
    }

    public String getNoTlp() {
        return this.noTlp;
    }

    public void setNoTlp(String noTlp) {
        this.noTlp = noTlp;
    }

    public BigDecimal getNominalTerbayar() {
        return this.nominalTerbayar;
    }

    public void setNominalTerbayar(BigDecimal nominalTerbayar) {
        this.nominalTerbayar = nominalTerbayar;
    }

    public String getNomorHer() {
        return this.nomorHer;
    }

    public void setNomorHer(String nomorHer) {
        this.nomorHer = nomorHer;
    }

    public String getNomorRekening() {
        return this.nomorRekening;
    }

    public void setNomorRekening(String nomorRekening) {
        this.nomorRekening = nomorRekening;
    }

    public String getPeriodeMutasi() {
        return this.periodeMutasi;
    }

    public void setPeriodeMutasi(String periodeMutasi) {
        this.periodeMutasi = periodeMutasi;
    }

    public BigDecimal getPhdpBaru() {
        return this.phdpBaru;
    }

    public void setPhdpBaru(BigDecimal phdpBaru) {
        this.phdpBaru = phdpBaru;
    }

    public BigDecimal getPhdpLama() {
        return this.phdpLama;
    }

    public void setPhdpLama(BigDecimal phdpLama) {
        this.phdpLama = phdpLama;
    }

    public BigDecimal getRapelMpydKurang() {
        return this.rapelMpydKurang;
    }

    public void setRapelMpydKurang(BigDecimal rapelMpydKurang) {
        this.rapelMpydKurang = rapelMpydKurang;
    }

    public BigDecimal getRapelMpydLebih() {
        return this.rapelMpydLebih;
    }

    public void setRapelMpydLebih(BigDecimal rapelMpydLebih) {
        this.rapelMpydLebih = rapelMpydLebih;
    }

    public String getRt() {
        return this.rt;
    }

    public void setRt(String rt) {
        this.rt = rt;
    }

    public String getRw() {
        return this.rw;
    }

    public void setRw(String rw) {
        this.rw = rw;
    }

    public String getStatusBayar() {
        return this.statusBayar;
    }

    public void setStatusBayar(String statusBayar) {
        this.statusBayar = statusBayar;
    }

    public String getTempatLahirPeserta() {
        return this.tempatLahirPeserta;
    }

    public void setTempatLahirPeserta(String tempatLahirPeserta) {
        this.tempatLahirPeserta = tempatLahirPeserta;
    }

    public String getTempatMeninggalPeserta() {
        return this.tempatMeninggalPeserta;
    }

    public void setTempatMeninggalPeserta(String tempatMeninggalPeserta) {
        this.tempatMeninggalPeserta = tempatMeninggalPeserta;
    }

    public Date getTglAwalBayar() {
        return this.tglAwalBayar;
    }

    public void setTglAwalBayar(Date tglAwalBayar) {
        this.tglAwalBayar = tglAwalBayar;
    }

    public Date getTglDpthtPeserta() {
        return this.tglDpthtPeserta;
    }

    public void setTglDpthtPeserta(Date tglDpthtPeserta) {
        this.tglDpthtPeserta = tglDpthtPeserta;
    }

    public Date getTglHentiBayar() {
        return this.tglHentiBayar;
    }

    public void setTglHentiBayar(Date tglHentiBayar) {
        this.tglHentiBayar = tglHentiBayar;
    }

    public Date getTglHentiKerjaPeserta() {
        return this.tglHentiKerjaPeserta;
    }

    public void setTglHentiKerjaPeserta(Date tglHentiKerjaPeserta) {
        this.tglHentiKerjaPeserta = tglHentiKerjaPeserta;
    }

    public Date getTglInfNikahPenerimampLama() {
        return this.tglInfNikahPenerimampLama;
    }

    public void setTglInfNikahPenerimampLama(Date tglInfNikahPenerimampLama) {
        this.tglInfNikahPenerimampLama = tglInfNikahPenerimampLama;
    }

    public Date getTglInfWftPenerimampLama() {
        return this.tglInfWftPenerimampLama;
    }

    public void setTglInfWftPenerimampLama(Date tglInfWftPenerimampLama) {
        this.tglInfWftPenerimampLama = tglInfWftPenerimampLama;
    }

    public Date getTglKerjaPeserta() {
        return this.tglKerjaPeserta;
    }

    public void setTglKerjaPeserta(Date tglKerjaPeserta) {
        this.tglKerjaPeserta = tglKerjaPeserta;
    }

    public Date getTglLahirPenerimaMp() {
        return this.tglLahirPenerimaMp;
    }

    public void setTglLahirPenerimaMp(Date tglLahirPenerimaMp) {
        this.tglLahirPenerimaMp = tglLahirPenerimaMp;
    }

    public Date getTglLahirPenerimaMpBaru() {
        return this.tglLahirPenerimaMpBaru;
    }

    public void setTglLahirPenerimaMpBaru(Date tglLahirPenerimaMpBaru) {
        this.tglLahirPenerimaMpBaru = tglLahirPenerimaMpBaru;
    }

    public Date getTglLahirPeserta() {
        return this.tglLahirPeserta;
    }

    public void setTglLahirPeserta(Date tglLahirPeserta) {
        this.tglLahirPeserta = tglLahirPeserta;
    }

    public Date getTglMenikahlagiPenerimaMp() {
        return this.tglMenikahlagiPenerimaMp;
    }

    public void setTglMenikahlagiPenerimaMp(Date tglMenikahlagiPenerimaMp) {
        this.tglMenikahlagiPenerimaMp = tglMenikahlagiPenerimaMp;
    }

    public Date getTglMeninggalPenerimaMp() {
        return this.tglMeninggalPenerimaMp;
    }

    public void setTglMeninggalPenerimaMp(Date tglMeninggalPenerimaMp) {
        this.tglMeninggalPenerimaMp = tglMeninggalPenerimaMp;
    }

    public Date getTglMeninggalPeserta() {
        return this.tglMeninggalPeserta;
    }

    public void setTglMeninggalPeserta(Date tglMeninggalPeserta) {
        this.tglMeninggalPeserta = tglMeninggalPeserta;
    }

    public Date getTglMpBulanKe13() {
        return this.tglMpBulanKe13;
    }

    public void setTglMpBulanKe13(Date tglMpBulanKe13) {
        this.tglMpBulanKe13 = tglMpBulanKe13;
    }

    public Date getTglMulaiBerlakuPhdpBaru() {
        return this.tglMulaiBerlakuPhdpBaru;
    }

    public void setTglMulaiBerlakuPhdpBaru(Date tglMulaiBerlakuPhdpBaru) {
        this.tglMulaiBerlakuPhdpBaru = tglMulaiBerlakuPhdpBaru;
    }

    public Date getTglMutasi() {
        return this.tglMutasi;
    }

    public void setTglMutasi(Date tglMutasi) {
        this.tglMutasi = tglMutasi;
    }

    public Date getTglPermohonanMps100() {
        return this.tglPermohonanMps100;
    }

    public void setTglPermohonanMps100(Date tglPermohonanMps100) {
        this.tglPermohonanMps100 = tglPermohonanMps100;
    }

    public Date getTglSkBi() {
        return this.tglSkBi;
    }

    public void setTglSkBi(Date tglSkBi) {
        this.tglSkBi = tglSkBi;
    }

    public Date getTglSkDapenbi() {
        return this.tglSkDapenbi;
    }

    public void setTglSkDapenbi(Date tglSkDapenbi) {
        this.tglSkDapenbi = tglSkDapenbi;
    }

    public Date getTglSpBi() {
        return this.tglSpBi;
    }

    public void setTglSpBi(Date tglSpBi) {
        this.tglSpBi = tglSpBi;
    }

    public Date getTglTundaJatuhTempo() {
        return this.tglTundaJatuhTempo;
    }

    public void setTglTundaJatuhTempo(Date tglTundaJatuhTempo) {
        this.tglTundaJatuhTempo = tglTundaJatuhTempo;
    }

    public Date getTglUsia25tPenerimaMp() {
        return this.tglUsia25tPenerimaMp;
    }

    public void setTglUsia25tPenerimaMp(Date tglUsia25tPenerimaMp) {
        this.tglUsia25tPenerimaMp = tglUsia25tPenerimaMp;
    }

    public Date getTglUsia25tPenerimaMpBaru() {
        return this.tglUsia25tPenerimaMpBaru;
    }

    public void setTglUsia25tPenerimaMpBaru(Date tglUsia25tPenerimaMpBaru) {
        this.tglUsia25tPenerimaMpBaru = tglUsia25tPenerimaMpBaru;
    }

    public String getTotalMasaKerja() {
        return this.totalMasaKerja;
    }

    public void setTotalMasaKerja(String totalMasaKerja) {
        this.totalMasaKerja = totalMasaKerja;
    }

    public String getTotalMasaKerjaAdj() {
        return this.totalMasaKerjaAdj;
    }

    public void setTotalMasaKerjaAdj(String totalMasaKerjaAdj) {
        this.totalMasaKerjaAdj = totalMasaKerjaAdj;
    }

    public String getTotalMasaKerjaBulat() {
        return this.totalMasaKerjaBulat;
    }

    public void setTotalMasaKerjaBulat(String totalMasaKerjaBulat) {
        this.totalMasaKerjaBulat = totalMasaKerjaBulat;
    }

    public String getTotalMasaKerjaBulatAdj() {
        return this.totalMasaKerjaBulatAdj;
    }

    public void setTotalMasaKerjaBulatAdj(String totalMasaKerjaBulatAdj) {
        this.totalMasaKerjaBulatAdj = totalMasaKerjaBulatAdj;
    }

    public BigDecimal getUpahVeteran() {
        return this.upahVeteran;
    }

    public void setUpahVeteran(BigDecimal upahVeteran) {
        this.upahVeteran = upahVeteran;
    }

    public Timestamp getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUserStamp() {
        return this.userStamp;
    }

    public void setUserStamp(String userStamp) {
        this.userStamp = userStamp;
    }

    public String getUserValidasi() {
        return this.userValidasi;
    }

    public void setUserValidasi(String userValidasi) {
        this.userValidasi = userValidasi;
    }

    public String getUsiaPenerimaBayar() {
        return this.usiaPenerimaBayar;
    }

    public void setUsiaPenerimaBayar(String usiaPenerimaBayar) {
        this.usiaPenerimaBayar = usiaPenerimaBayar;
    }

    public String getUsiaPenerimaBayarBulat() {
        return this.usiaPenerimaBayarBulat;
    }

    public void setUsiaPenerimaBayarBulat(String usiaPenerimaBayarBulat) {
        this.usiaPenerimaBayarBulat = usiaPenerimaBayarBulat;
    }

    public String getUsiaSaatHenti() {
        return this.usiaSaatHenti;
    }

    public void setUsiaSaatHenti(String usiaSaatHenti) {
        this.usiaSaatHenti = usiaSaatHenti;
    }

    public String getUsiaSaatHentiBulat() {
        return this.usiaSaatHentiBulat;
    }

    public void setUsiaSaatHentiBulat(String usiaSaatHentiBulat) {
        this.usiaSaatHentiBulat = usiaSaatHentiBulat;
    }

    public void fromDto(PensiunLamaMeninggalViewDto dto){
        this.setMasaKerjaHentiBulat( dto.getMasaKerjaHentiBulat() );
        this.setMasaKerjaTambahan( dto.getMasaKerjaTambahan() );
        this.setMasaKerjaTambahanBulat( dto.getMasaKerjaTambahanBulat() );
        this.setMasaKerjaVeteran( dto.getMasaKerjaVeteran() );
        this.setMasaKerjaVeteranBulat( dto.getMasaKerjaVeteranBulat() );
        this.setTotalMasaKerja( dto.getTotalMasaKerja() );
        this.setTotalMasaKerjaBulat( dto.getTotalMasaKerjaBulat() );
        this.setMasaKerjaMp( dto.getMasaKerjaMp() );
        this.setIdFaktorFpr( dto.getIdFaktorFpr() );
        this.setNamaFaktorFpr( dto.getNamaFaktorFpr() );
        this.setNilaiFpr( dto.getNilaiFpr() );
        this.setIdFaktorFs( dto.getIdFaktorFs() );
        this.setNamaFaktorFs( dto.getNamaFaktorFs() );
        this.setFaktorFs( dto.getFaktorFs() );
        this.setNilaiFs( dto.getNilaiFs() );
        this.setMps20persenLama( dto.getMps20persenLama() );
        this.setMps10jutaLama( dto.getMps10jutaLama() );
        this.setMps100persenLama( dto.getMps100persenLama() );
        this.setMpPerbulanRumusLama( dto.getMpPerbulanRumusLama() );
        this.setMpPerbulan20persenLama( dto.getMpPerbulan20persenLama() );
        this.setMpPerbulan10jutaLama( dto.getMpPerbulan10jutaLama() );
        this.setMpydLama( dto.getMpydLama() );
        this.setMpBulan13( dto.getMpBulan13() );
        this.setMps100persenBulatLama( dto.getMps100persenBulatLama() );
        this.setIdSuskel( dto.getIdSuskel() );
        this.setNamaSuskel( dto.getNamaSuskel() );
        this.setPhdpBaru( dto.getPhdpBaru() );
        this.setTglMulaiBerlakuPhdpBaru( dto.getTglMulaiBerlakuPhdpBaru() );
        this.setKurangBayarMpyd( dto.getKurangBayarMpyd() );
        this.setMps20persenBaru( dto.getMps20persenBaru() );
        this.setMps10jutaBaru( dto.getMps10jutaBaru() );
        this.setMps100persenBaru( dto.getMps100persenBaru() );
        this.setMpPerbulanRumusBaru( dto.getMpPerbulanRumusBaru() );
        this.setMpPerbulan20persenBaru( dto.getMpPerbulan20persenBaru() );
        this.setMpPerbulan10jutaBaru( dto.getMpPerbulan10jutaBaru() );
        this.setMps100persenBulatBaru( dto.getMps100persenBulatBaru() );
        this.setMpydBaru( dto.getMpydBaru() );
        this.setKurangBayarMps20persen( dto.getKurangBayarMps20persen() );
        this.setKurangBayarMps10juta( dto.getKurangBayarMps10juta() );
        this.setKurangBayarMps100persen( dto.getKurangBayarMps100persen() );
        this.setKurangBayarMpRumus( dto.getKurangBayarMpRumus() );
        this.setIsJadiHutang( dto.getIsJadiHutang() );
        this.setLebihBayarMps20persen( dto.getLebihBayarMps20persen() );
        this.setLebihBayarMps10juta( dto.getLebihBayarMps10juta() );
        this.setLebihBayarMps100persen( dto.getLebihBayarMps100persen() );
        this.setLebihBayarMpRumus( dto.getLebihBayarMpRumus() );
        this.setLebihBayarMpyd( dto.getLebihBayarMpyd() );
        this.setIsJadiPiutang( dto.getIsJadiPiutang() );
        this.setIdKategoriCatatan( dto.getIdKategoriCatatan() );
        this.setKeterangan( dto.getKeterangan() );
        this.setIdStatusKawinPenerimaMp( dto.getIdStatusKawinPenerimaMp() );
        this.setNamaStatusKawinPenerimaMp( dto.getNamaStatusKawinPenerimaMp() );
        this.setIsRekeningDapenbi( dto.getIsRekeningDapenbi() );
        this.setIdBank( dto.getIdBank() );
        this.setJenisBank( dto.getJenisBank() );
        this.setNamaCabangBank( dto.getNamaCabangBank() );
        this.setNamaPadaRekBank( dto.getNamaPadaRekBank() );
        this.setNomorRekening( dto.getNomorRekening() );
        this.setNoHp( dto.getNoHp() );
        this.setEmail( dto.getEmail() );
        this.setIdValidasi( dto.getIdValidasi() );
        this.setActive( dto.getActive() );
        this.setUserStamp( dto.getUserStamp() );
        this.setKeteranganOtomatis( dto.getKeteranganOtomatis() );
        this.setUserValidasi( dto.getUserValidasi() );
        this.setNamaValidasi( dto.getNamaValidasi() );
        this.setTotalMasaKerjaAdj( dto.getTotalMasaKerjaAdj() );
        this.setTotalMasaKerjaBulatAdj( dto.getTotalMasaKerjaBulatAdj() );
        this.setMpBulan13Baru( dto.getMpBulan13Baru() );
        this.setRapelMpydKurang( dto.getRapelMpydKurang() );
        this.setRapelMpydLebih( dto.getRapelMpydLebih() );
        this.setNoTlp( dto.getNoTlp() );
        this.setIdPenerimaMpBaru( dto.getIdPenerimaMpBaru() );
        this.setNamaPenerimaMpBaru( dto.getNamaPenerimaMpBaru() );
        this.setIdKategoriPenerimaMpBaru( dto.getIdKategoriPenerimaMpBaru() );
        this.setNamaKategoriPenerimaMpBaru( dto.getNamaKategoriPenerimaMpBaru() );
        this.setIdSuskelBaru( dto.getIdSuskelBaru() );
        this.setNamaSuskelBaru( dto.getNamaSuskelBaru() );
        this.setLebihBayarJmlBulan( dto.getLebihBayarJmlBulan() );
        this.setLebihBayarNominal( dto.getLebihBayarNominal() );
        this.setNominalTerbayar( dto.getNominalTerbayar() );
        this.setTglInfWftPenerimampLama( dto.getTglInfWftPenerimampLama() );
        this.setTglLahirPenerimaMpBaru( dto.getTglLahirPenerimaMpBaru() );
        this.setJenisKelaminPenerimaMpBaru( dto.getJenisKelaminPenerimaMpBaru() );
        this.setIdKawinPenerimampBaru( dto.getIdKawinPenerimampBaru() );
        this.setNamaKawinPenerimampBaru( dto.getNamaKawinPenerimampBaru() );
        this.setTglInfNikahPenerimampLama( dto.getTglInfNikahPenerimampLama() );
        this.setLebihBayarJmlBln13( dto.getLebihBayarJmlBln13() );
        this.setLebihBayarNominal13( dto.getLebihBayarNominal13() );
        this.setIdKantorBayarBaru( dto.getIdKantorBayarBaru() );
        this.setNamaKantorBayarBaru( dto.getNamaKantorBayarBaru() );
        this.setTglUsia25tPenerimaMpBaru( dto.getTglUsia25tPenerimaMpBaru() );
        this.setTglPermohonanMps100( dto.getTglPermohonanMps100() );
        this.setIdAlasanMps100( dto.getIdAlasanMps100() );
        this.setNamaAlasanMps100( dto.getNamaAlasanMps100() );
        this.setCreatedAt( dto.getCreatedAt() );
        this.setUpdatedAt( dto.getUpdatedAt() );
        this.setNomorHer( dto.getNomorHer() );
        this.setIdMutasiPensiun( dto.getIdMutasiPensiun() );
        this.setKodeMutasi( dto.getKodeMutasi() );
        this.setIdKategoriMutasi( dto.getIdKategoriMutasi() );
        this.setPeriodeMutasi( dto.getPeriodeMutasi() );
        this.setTglMutasi( dto.getTglMutasi() );
        this.setNip( dto.getNip() );
        this.setNamaPeserta( dto.getNamaPeserta() );
        this.setJenisKelaminPeserta( dto.getJenisKelaminPeserta() );
        this.setTglLahirPeserta( dto.getTglLahirPeserta() );
        this.setTglKerjaPeserta( dto.getTglKerjaPeserta() );
        this.setTglDpthtPeserta( dto.getTglDpthtPeserta() );
        this.setTglHentiKerjaPeserta( dto.getTglHentiKerjaPeserta() );
        this.setTempatMeninggalPeserta( dto.getTempatMeninggalPeserta() );
        this.setTglMeninggalPeserta( dto.getTglMeninggalPeserta() );
        this.setTempatLahirPeserta( dto.getTempatLahirPeserta() );
        this.setIdGolongan( dto.getIdGolongan() );
        this.setGolonganPangkat( dto.getGolonganPangkat() );
        this.setIdAgama( dto.getIdAgama() );
        this.setNamaAgama( dto.getNamaAgama() );
        this.setIdKantorBayar( dto.getIdKantorBayar() );
        this.setNamaKantorBayar( dto.getNamaKantorBayar() );
        this.setIdPredikat( dto.getIdPredikat() );
        this.setNamaPredikat( dto.getNamaPredikat() );
        this.setIdHenti( dto.getIdHenti() );
        this.setKeteranganHenti( dto.getKeteranganHenti() );
        this.setTglSpBi( dto.getTglSpBi() );
        this.setNoSpBi( dto.getNoSpBi() );
        this.setTglSkBi( dto.getTglSkBi() );
        this.setNoSkBi( dto.getNoSkBi() );
        this.setPhdpLama( dto.getPhdpLama() );
        this.setUpahVeteran( dto.getUpahVeteran() );
        this.setIdJenisMps( dto.getIdJenisMps() );
        this.setNamaMps( dto.getNamaMps() );
        this.setIdKategoriPensiun( dto.getIdKategoriPensiun() );
        this.setNamaKategoriPensiun( dto.getNamaKategoriPensiun() );
        this.setIdUsiaBayar( dto.getIdUsiaBayar() );
        this.setNamaUsiaBayar( dto.getNamaUsiaBayar() );
        this.setIdStatusBayar( dto.getIdStatusBayar() );
        this.setStatusBayar( dto.getStatusBayar() );
        this.setTglTundaJatuhTempo( dto.getTglTundaJatuhTempo() );
        this.setTglAwalBayar( dto.getTglAwalBayar() );
        this.setTglMpBulanKe13( dto.getTglMpBulanKe13() );
        this.setTglHentiBayar( dto.getTglHentiBayar() );
        this.setIdPenerimaMp( dto.getIdPenerimaMp() );
        this.setNamaPenerimaMp( dto.getNamaPenerimaMp() );
        this.setTglLahirPenerimaMp( dto.getTglLahirPenerimaMp() );
        this.setJenisKelaminPenerimaMp( dto.getJenisKelaminPenerimaMp() );
        this.setIdKategoriPenerimaMp( dto.getIdKategoriPenerimaMp() );
        this.setNamaKategoriPenerimaMp( dto.getNamaKategoriPenerimaMp() );
        this.setTglSkDapenbi( dto.getTglSkDapenbi() );
        this.setNoSkDapenbi( dto.getNoSkDapenbi() );
        this.setTglMeninggalPenerimaMp( dto.getTglMeninggalPenerimaMp() );
        this.setTglMenikahlagiPenerimaMp( dto.getTglMenikahlagiPenerimaMp() );
        this.setTglUsia25tPenerimaMp( dto.getTglUsia25tPenerimaMp() );
        this.setAlamatIsDalamNegeri( dto.getAlamatIsDalamNegeri() );
        this.setIdProvinsi( dto.getIdProvinsi() );
        this.setNamaProvinsi( dto.getNamaProvinsi() );
        this.setIdKotaKab( dto.getIdKotaKab() );
        this.setNamaKotaKab( dto.getNamaKotaKab() );
        this.setIdKecamatan( dto.getIdKecamatan() );
        this.setNamaKecamatan( dto.getNamaKecamatan() );
        this.setIdKelurahan( dto.getIdKelurahan() );
        this.setNamaKelurahan( dto.getNamaKelurahan() );
        this.setKodePos( dto.getKodePos() );
        this.setAlamatLengkap( dto.getAlamatLengkap() );
        this.setRt( dto.getRt() );
        this.setRw( dto.getRw() );
        this.setIdNegara( dto.getIdNegara() );
        this.setNamaNegara( dto.getNamaNegara() );
        this.setUsiaSaatHenti( dto.getUsiaSaatHenti() );
        this.setUsiaSaatHentiBulat( dto.getUsiaSaatHentiBulat() );
        this.setUsiaPenerimaBayar( dto.getUsiaPenerimaBayar() );
        this.setUsiaPenerimaBayarBulat( dto.getUsiaPenerimaBayarBulat() );
        this.setMasaKerjaHenti( dto.getMasaKerjaHenti() );
        this.setMpBulan13(dto.getMpBulan13());
    }

    @Override
    public PensiunLamaMeninggalViewDto toDto() {
        PensiunLamaMeninggalViewDto dto = new PensiunLamaMeninggalViewDto();
        dto.setMasaKerjaHentiBulat( this.getMasaKerjaHentiBulat() );
        dto.setMasaKerjaTambahan( this.getMasaKerjaTambahan() );
        dto.setMasaKerjaTambahanBulat( this.getMasaKerjaTambahanBulat() );
        dto.setMasaKerjaVeteran( this.getMasaKerjaVeteran() );
        dto.setMasaKerjaVeteranBulat( this.getMasaKerjaVeteranBulat() );
        dto.setTotalMasaKerja( this.getTotalMasaKerja() );
        dto.setTotalMasaKerjaBulat( this.getTotalMasaKerjaBulat() );
        dto.setMasaKerjaMp( this.getMasaKerjaMp() );
        dto.setIdFaktorFpr( this.getIdFaktorFpr() );
        dto.setNamaFaktorFpr( this.getNamaFaktorFpr() );
        dto.setNilaiFpr( this.getNilaiFpr() );
        dto.setIdFaktorFs( this.getIdFaktorFs() );
        dto.setNamaFaktorFs( this.getNamaFaktorFs() );
        dto.setFaktorFs( this.getFaktorFs() );
        dto.setNilaiFs( this.getNilaiFs() );
        dto.setMps20persenLama( this.getMps20persenLama() );
        dto.setMps10jutaLama( this.getMps10jutaLama() );
        dto.setMps100persenLama( this.getMps100persenLama() );
        dto.setMpPerbulanRumusLama( this.getMpPerbulanRumusLama() );
        dto.setMpPerbulan20persenLama( this.getMpPerbulan20persenLama() );
        dto.setMpPerbulan10jutaLama( this.getMpPerbulan10jutaLama() );
        dto.setMpydLama( this.getMpydLama() );
        dto.setMpBulan13( this.getMpBulan13() );
        dto.setMps100persenBulatLama( this.getMps100persenBulatLama() );
        dto.setIdSuskel( this.getIdSuskel() );
        dto.setNamaSuskel( this.getNamaSuskel() );
        dto.setPhdpBaru( this.getPhdpBaru() );
        dto.setTglMulaiBerlakuPhdpBaru( this.getTglMulaiBerlakuPhdpBaru() );
        dto.setKurangBayarMpyd( this.getKurangBayarMpyd() );
        dto.setMps20persenBaru( this.getMps20persenBaru() );
        dto.setMps10jutaBaru( this.getMps10jutaBaru() );
        dto.setMps100persenBaru( this.getMps100persenBaru() );
        dto.setMpPerbulanRumusBaru( this.getMpPerbulanRumusBaru() );
        dto.setMpPerbulan20persenBaru( this.getMpPerbulan20persenBaru() );
        dto.setMpPerbulan10jutaBaru( this.getMpPerbulan10jutaBaru() );
        dto.setMps100persenBulatBaru( this.getMps100persenBulatBaru() );
        dto.setMpydBaru( this.getMpydBaru() );
        dto.setKurangBayarMps20persen( this.getKurangBayarMps20persen() );
        dto.setKurangBayarMps10juta( this.getKurangBayarMps10juta() );
        dto.setKurangBayarMps100persen( this.getKurangBayarMps100persen() );
        dto.setKurangBayarMpRumus( this.getKurangBayarMpRumus() );
        dto.setIsJadiHutang( this.getIsJadiHutang() );
        dto.setLebihBayarMps20persen( this.getLebihBayarMps20persen() );
        dto.setLebihBayarMps10juta( this.getLebihBayarMps10juta() );
        dto.setLebihBayarMps100persen( this.getLebihBayarMps100persen() );
        dto.setLebihBayarMpRumus( this.getLebihBayarMpRumus() );
        dto.setLebihBayarMpyd( this.getLebihBayarMpyd() );
        dto.setIsJadiPiutang( this.getIsJadiPiutang() );
        dto.setIdKategoriCatatan( this.getIdKategoriCatatan() );
        dto.setKeterangan( this.getKeterangan() );
        dto.setIdStatusKawinPenerimaMp( this.getIdStatusKawinPenerimaMp() );
        dto.setNamaStatusKawinPenerimaMp( this.getNamaStatusKawinPenerimaMp() );
        dto.setIsRekeningDapenbi( this.getIsRekeningDapenbi() );
        dto.setIdBank( this.getIdBank() );
        dto.setJenisBank( this.getJenisBank() );
        dto.setNamaCabangBank( this.getNamaCabangBank() );
        dto.setNamaPadaRekBank( this.getNamaPadaRekBank() );
        dto.setNomorRekening( this.getNomorRekening() );
        dto.setNoHp( this.getNoHp() );
        dto.setEmail( this.getEmail() );
        dto.setIdValidasi( this.getIdValidasi() );
        dto.setActive( this.getActive() );
        dto.setUserStamp( this.getUserStamp() );
        dto.setKeteranganOtomatis( this.getKeteranganOtomatis() );
        dto.setUserValidasi( this.getUserValidasi() );
        dto.setNamaValidasi( this.getNamaValidasi() );
        dto.setTotalMasaKerjaAdj( this.getTotalMasaKerjaAdj() );
        dto.setTotalMasaKerjaBulatAdj( this.getTotalMasaKerjaBulatAdj() );
        dto.setMpBulan13Baru( this.getMpBulan13Baru() );
        dto.setRapelMpydKurang( this.getRapelMpydKurang() );
        dto.setRapelMpydLebih( this.getRapelMpydLebih() );
        dto.setNoTlp( this.getNoTlp() );
        dto.setIdPenerimaMpBaru( this.getIdPenerimaMpBaru() );
        dto.setNamaPenerimaMpBaru( this.getNamaPenerimaMpBaru() );
        dto.setIdKategoriPenerimaMpBaru( this.getIdKategoriPenerimaMpBaru() );
        dto.setNamaKategoriPenerimaMpBaru( this.getNamaKategoriPenerimaMpBaru() );
        dto.setIdSuskelBaru( this.getIdSuskelBaru() );
        dto.setNamaSuskelBaru( this.getNamaSuskelBaru() );
        dto.setLebihBayarJmlBulan( this.getLebihBayarJmlBulan() );
        dto.setLebihBayarNominal( this.getLebihBayarNominal() );
        dto.setNominalTerbayar( this.getNominalTerbayar() );
        dto.setTglInfWftPenerimampLama( this.getTglInfWftPenerimampLama() );
        dto.setTglLahirPenerimaMpBaru( this.getTglLahirPenerimaMpBaru() );
        dto.setJenisKelaminPenerimaMpBaru( this.getJenisKelaminPenerimaMpBaru() );
        dto.setIdKawinPenerimampBaru( this.getIdKawinPenerimampBaru() );
        dto.setNamaKawinPenerimampBaru( this.getNamaKawinPenerimampBaru() );
        dto.setTglInfNikahPenerimampLama( this.getTglInfNikahPenerimampLama() );
        dto.setLebihBayarJmlBln13( this.getLebihBayarJmlBln13() );
        dto.setLebihBayarNominal13( this.getLebihBayarNominal13() );
        dto.setIdKantorBayarBaru( this.getIdKantorBayarBaru() );
        dto.setNamaKantorBayarBaru( this.getNamaKantorBayarBaru() );
        dto.setTglUsia25tPenerimaMpBaru( this.getTglUsia25tPenerimaMpBaru() );
        dto.setTglPermohonanMps100( this.getTglPermohonanMps100() );
        dto.setIdAlasanMps100( this.getIdAlasanMps100() );
        dto.setNamaAlasanMps100( this.getNamaAlasanMps100() );
        dto.setCreatedAt( this.getCreatedAt() );
        dto.setUpdatedAt( this.getUpdatedAt() );
        dto.setNomorHer( this.getNomorHer() );
        dto.setIdMutasiPensiun( this.getIdMutasiPensiun() );
        dto.setKodeMutasi( this.getKodeMutasi() );
        dto.setIdKategoriMutasi( this.getIdKategoriMutasi() );
        dto.setPeriodeMutasi( this.getPeriodeMutasi() );
        dto.setTglMutasi( this.getTglMutasi() );
        dto.setNip( this.getNip() );
        dto.setNamaPeserta( this.getNamaPeserta() );
        dto.setJenisKelaminPeserta( this.getJenisKelaminPeserta() );
        dto.setTglLahirPeserta( this.getTglLahirPeserta() );
        dto.setTglKerjaPeserta( this.getTglKerjaPeserta() );
        dto.setTglDpthtPeserta( this.getTglDpthtPeserta() );
        dto.setTglHentiKerjaPeserta( this.getTglHentiKerjaPeserta() );
        dto.setTempatMeninggalPeserta( this.getTempatMeninggalPeserta() );
        dto.setTglMeninggalPeserta( this.getTglMeninggalPeserta() );
        dto.setTempatLahirPeserta( this.getTempatLahirPeserta() );
        dto.setIdGolongan( this.getIdGolongan() );
        dto.setGolonganPangkat( this.getGolonganPangkat() );
        dto.setIdAgama( this.getIdAgama() );
        dto.setNamaAgama( this.getNamaAgama() );
        dto.setIdKantorBayar( this.getIdKantorBayar() );
        dto.setNamaKantorBayar( this.getNamaKantorBayar() );
        dto.setIdPredikat( this.getIdPredikat() );
        dto.setNamaPredikat( this.getNamaPredikat() );
        dto.setIdHenti( this.getIdHenti() );
        dto.setKeteranganHenti( this.getKeteranganHenti() );
        dto.setTglSpBi( this.getTglSpBi() );
        dto.setNoSpBi( this.getNoSpBi() );
        dto.setTglSkBi( this.getTglSkBi() );
        dto.setNoSkBi( this.getNoSkBi() );
        dto.setPhdpLama( this.getPhdpLama() );
        dto.setUpahVeteran( this.getUpahVeteran() );
        dto.setIdJenisMps( this.getIdJenisMps() );
        dto.setNamaMps( this.getNamaMps() );
        dto.setIdKategoriPensiun( this.getIdKategoriPensiun() );
        dto.setNamaKategoriPensiun( this.getNamaKategoriPensiun() );
        dto.setIdUsiaBayar( this.getIdUsiaBayar() );
        dto.setNamaUsiaBayar( this.getNamaUsiaBayar() );
        dto.setIdStatusBayar( this.getIdStatusBayar() );
        dto.setStatusBayar( this.getStatusBayar() );
        dto.setTglTundaJatuhTempo( this.getTglTundaJatuhTempo() );
        dto.setTglAwalBayar( this.getTglAwalBayar() );
        dto.setTglMpBulanKe13( this.getTglMpBulanKe13() );
        dto.setTglHentiBayar( this.getTglHentiBayar() );
        dto.setIdPenerimaMp( this.getIdPenerimaMp() );
        dto.setNamaPenerimaMp( this.getNamaPenerimaMp() );
        dto.setTglLahirPenerimaMp( this.getTglLahirPenerimaMp() );
        dto.setJenisKelaminPenerimaMp( this.getJenisKelaminPenerimaMp() );
        dto.setIdKategoriPenerimaMp( this.getIdKategoriPenerimaMp() );
        dto.setNamaKategoriPenerimaMp( this.getNamaKategoriPenerimaMp() );
        dto.setTglSkDapenbi( this.getTglSkDapenbi() );
        dto.setNoSkDapenbi( this.getNoSkDapenbi() );
        dto.setTglMeninggalPenerimaMp( this.getTglMeninggalPenerimaMp() );
        dto.setTglMenikahlagiPenerimaMp( this.getTglMenikahlagiPenerimaMp() );
        dto.setTglUsia25tPenerimaMp( this.getTglUsia25tPenerimaMp() );
        dto.setAlamatIsDalamNegeri( this.getAlamatIsDalamNegeri() );
        dto.setIdProvinsi( this.getIdProvinsi() );
        dto.setNamaProvinsi( this.getNamaProvinsi() );
        dto.setIdKotaKab( this.getIdKotaKab() );
        dto.setNamaKotaKab( this.getNamaKotaKab() );
        dto.setIdKecamatan( this.getIdKecamatan() );
        dto.setNamaKecamatan( this.getNamaKecamatan() );
        dto.setIdKelurahan( this.getIdKelurahan() );
        dto.setNamaKelurahan( this.getNamaKelurahan() );
        dto.setKodePos( this.getKodePos() );
        dto.setAlamatLengkap( this.getAlamatLengkap() );
        dto.setRt( this.getRt() );
        dto.setRw( this.getRw() );
        dto.setIdNegara( this.getIdNegara() );
        dto.setNamaNegara( this.getNamaNegara() );
        dto.setUsiaSaatHenti( this.getUsiaSaatHenti() );
        dto.setUsiaSaatHentiBulat( this.getUsiaSaatHentiBulat() );
        dto.setUsiaPenerimaBayar( this.getUsiaPenerimaBayar() );
        dto.setUsiaPenerimaBayarBulat( this.getUsiaPenerimaBayarBulat() );
        dto.setMasaKerjaHenti( this.getMasaKerjaHenti() );
        dto.setMpBulan13(this.getMpBulan13());

        return dto;
    }

    public MutasiMeninggalSPFormDto toSpProses(){
        MutasiMeninggalSPFormDto spFormDto = new MutasiMeninggalSPFormDto();
        spFormDto.setParIdMutasi(this.getIdMutasiPensiun().longValue());
        spFormDto.setParKodeMutasi(this.getKodeMutasi());
        spFormDto.setParPeriodeMutasi(this.getPeriodeMutasi());
        spFormDto.setParTglMutasi(this.getTglMutasi());
        spFormDto.setParNip(this.getNip());
        spFormDto.setParNamaPesertaUpdate(this.getNamaPenerimaMpBaru());
        spFormDto.setParIdAgamaUpdate(this.getIdAgama().longValue());
        spFormDto.setParNamaAgamaUpdate(this.getNamaAgama());
        spFormDto.setParIdGolonganUpdate(this.getIdGolongan().longValue());
        spFormDto.setParNamaGolonganUpdate(this.getGolonganPangkat());
        spFormDto.setParPhdp(this.getPhdpLama());
        spFormDto.setParIdKantorBayarUpdate(this.getIdKantorBayar());
        spFormDto.setParNamaKantorBayarUpdate(this.getNamaKantorBayar());
        spFormDto.setParTglSpBiUpdate(this.getTglSpBi());
        spFormDto.setParNoSpBiUpdate(this.getNoSpBi());
        spFormDto.setParTglSkBiUpdate(this.getTglSkBi());
        spFormDto.setParNoSkBiUpdate(this.getNoSkBi());
        if (this.getAlamatIsDalamNegeri() != null) {
            spFormDto.setParAlmtIsDalamnegeriUpdate(this.getAlamatIsDalamNegeri().charAt(0));
        }else{
            spFormDto.setParAlmtIsDalamnegeriUpdate(null);
        }
        spFormDto.setParIdProvinsiUpdate(this.getIdProvinsi().longValue());
        spFormDto.setParNamaProvinsiUpdate(this.getNamaProvinsi());
        spFormDto.setParIdKotaKabUpdate(this.getIdKotaKab().longValue());
        spFormDto.setParNamaKotaKabUpdate(this.getNamaKotaKab());
        spFormDto.setParIdKecamatanUpdate(this.getIdKecamatan().longValue());
        spFormDto.setParNamaKecamatanUpdate(this.getNamaKecamatan());
        spFormDto.setParIdKelurahanUpdate(this.getIdKelurahan().longValue());
        spFormDto.setParNamaKelurahanUpdate(this.getNamaKelurahan());
        spFormDto.setParKodePosUpdate(this.getKodePos());
        spFormDto.setParAlamatLengkapUpdate(this.getAlamatLengkap());
        spFormDto.setParNoHpUpdate(this.getNoHp());
        spFormDto.setParNoTlpUpdate(this.getNoTlp());
        spFormDto.setParEmailUpdate(this.getEmail());
        spFormDto.setParRtUpdate(this.getRt());
        spFormDto.setParRwUpdate(this.getRw());
        if (this.getIdNegara() != null) {
            spFormDto.setParIdNegaraUpdate(this.getIdNegara().longValue());
        }else {
            spFormDto.setParIdNegaraUpdate(null);
        }
        spFormDto.setParNamaNegaraUpdate(this.getNamaNegara());
        spFormDto.setParIdPenerimampLama(this.getIdPenerimaMp());
        spFormDto.setParNamaPenerimamplamaUpdate(this.getNamaPenerimaMp());
        spFormDto.setParIdKatPenerimampLama(this.getIdKategoriPenerimaMp().longValue());
        spFormDto.setParTglWftPenerimaMpLama(this.getTglMeninggalPenerimaMp());
        spFormDto.setParTglInfWftPenerimaMpLama(this.getTglInfWftPenerimampLama());
        spFormDto.setParIdPenerimaMpBaru(this.getIdPenerimaMpBaru());
        spFormDto.setParNamaPenerimaMpBaru(this.getNamaPenerimaMpBaru());
        if (this.getIdKategoriPenerimaMpBaru()!=null){
            spFormDto.setParIdKatPenerimampBaru(this.getIdKategoriPenerimaMpBaru().longValue());
        }else {

            spFormDto.setParIdKatPenerimampBaru(null);
        }
        spFormDto.setParNamaKatPenerimampBaru(this.getNamaKategoriPenerimaMpBaru());
        if (this.getJenisKelaminPenerimaMpBaru() != null) {
            spFormDto.setParJkPenerimampBaru(this.getJenisKelaminPenerimaMpBaru().charAt(0));
        }else
        {
            spFormDto.setParJkPenerimampBaru(null);
        }
        spFormDto.setParTglLhrPenerimampBaru(this.getTglLahirPenerimaMp());
        if (this.getIdKawinPenerimampBaru() != null) {
            spFormDto.setParIdKawinPenerimampBaru(this.getIdKawinPenerimampBaru().longValue());
        }else {
            spFormDto.setParIdKawinPenerimampBaru(null);
        }
        spFormDto.setParNamaKawinPenerimampBaru(this.getNamaKawinPenerimampBaru());
        spFormDto.setParIdSuskelBaru(this.getIdSuskel().longValue());
        spFormDto.setParNamaSuskelBaru(this.getNamaSuskel());
        spFormDto.setParTglBulan13(this.getTglMpBulanKe13());
        spFormDto.setParLebihBayarNominal(this.getLebihBayarNominal());
        spFormDto.setParLebihBayarJmlBulan(this.getLebihBayarJmlBulan());
        spFormDto.setParLebihBayarNominal13(this.getLebihBayarNominal13());
        spFormDto.setParLebihBayarJmlBulan13(this.getLebihBayarJmlBln13());
        spFormDto.setParNominalTerbayar(this.getNominalTerbayar());
        spFormDto.setParSaldoAkhirLebihBayar(null);
        spFormDto.setParIdStatusBayarUpdate(this.getIdStatusBayar().longValue());
        spFormDto.setParNamaStatusBayarUpdate(this.getStatusBayar());
        spFormDto.setParTglHentiBayarUpdate(this.getTglHentiBayar());
        spFormDto.setParIdKategoriCatatan(this.getIdKategoriCatatan().longValue());
        spFormDto.setParNamaKategoriCatatan(null);
        spFormDto.setParKeterangan(this.getKeterangan());


        return spFormDto;
    }
}
