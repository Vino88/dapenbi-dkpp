package com.dapenbi.dkpp.model.ViewModel;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.dapenbi.dkpp.dto.ViewModelDto.HerRegistrasiDetailViewDto;
import com.dapenbi.dkpp.model.BaseModel;
import org.hibernate.annotations.Immutable;
@Entity
@Immutable
@Table(name="VW_HER_REGISTRASI_DETAIL")

public class HerRegistrasiDetailView extends BaseModel<HerRegistrasiDetailViewDto> implements Serializable {

    private static final long serialVersionUID = 2636399287318960787L;

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name="jenis_her_desc")
    private String jenisHerDesc;

    @Column(name = "tahun_her", length = 6)
    private String tahunHer;

    @Column(name = "nip", length = 20)
    private String nip;

    @Column(name = "nomor_her", length = 50)
    private String nomorHer;

    @Column(name = "nama_peserta", length = 50)
    private String namaPeserta;

    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_her")
    private Date tglHer;

    @Column(name = "id_penerima", length = 100)
    private String idPenerima;

    @Column(name = "nama_penerima", length = 50)
    private String namaPenerima;

    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_lahir")
    private Date tglLahir;

    @Column(name = "id_kategori_penerima_mp")
    private Long idKategoriPenerimaMP;

    @Column(name = "nama_kategori_penerima_mp")
    private String namaKategoriPenerimaMP;

    @Column(name = "id_kantor_bayar")
    private String idKantorBayar;

    @Column(name = "nama_kantor_bayar")
    private String namaKantorBayar;

    @Column(name = "id_suskel")
    private Long idSuskel;

    @Column(name = "nama_suskel")
    private String namaSuskel;

    @Column(name = "alamat_is_dalam_negeri")
    private String alamatIsDalamNegeri;

    @Column(name = "alamat_lengkap")
    private String alamatLengkap;

    @Column(name = "rt")
    private String rt;

    @Column(name = "rw")
    private String rw;

    @Column(name = "id_kelurahan")
    private Long idKelurahan;

    @Column(name = "nama_kelurahan")
    private String namaKelurahan;

    @Column(name = "id_kecamatan")
    private Long idKecamatan;

    @Column(name = "nama_kecamatan")
    private String namaKecamatan;

    @Column(name = "id_kota_kab")
    private Long idKotaKabNumber;

    @Column(name = "nama_kota_kab")
    private String namaKotaKab;

    @Column(name = "id_provinsi")
    private Long idProvinsiNumber;

    @Column(name = "nama_provinsi")
    private String namaProvinsi;

    @Column(name = "kodepos")
    private String kodePos;

    @Column(name = "id_negara")
    private Long idNegaraNumber;

    @Column(name = "nama_negara")
    private String namaNegara;

    @Column(name = "no_hp")
    private String noHp;

    @Column(name = "email")
    private String email;

    @Column(name = "nip_pas_1_her")
    private String nipPas1Her;

    @Column(name = "jenis_kelamin_pas_1_her")
    private String jenisKelaminPas1Her;

    @Column(name = "nip_pas_2_her")
    private String nipPas2Her;

    @Column(name = "jenis_kelamin_pas_2_her")
    private String jenisKelaminPas2Her;

    @Column(name = "id_penerima_her")
    private Long idPenerimaHer;

    @Column(name = "nama_penerima_her")
    private String namaPenerimaHer;

    @Column(name = "tgl_lehiar_penerima_her")
    private Date tglLahirPenerimaHer;

    @Column(name = "tgl_meninggal_penerima_her")
    private Date tglMeninggalPenerimaHer;

    @Column(name = "id_suskel_her")
    private Long idSuskelHer;

    @Column(name = "nama_suskel_her")
    private String namaSuskelHer;

    @Column(name = "id_kantor_bayar_her")
    private Long idKantorBayarHer;

    @Column(name = "nama_kantor_bayar_her")
    private String namaKantorBayarHer;

    @Column(name = "alamat_is_dalam_negeri_her")
    private String alamatIsDalamNegeriHer;

    @Column(name = "alamat_lengkap_her")
    private String alamatLengkapHer;

    @Column(name = "rt_her")
    private String rtHer;

    @Column(name = "rw_her")
    private String rwHer;

    @Column(name = "id_kelurahan_her")
    private Long idKelurahanHer;

    @Column(name = "nama_kelurahan_her")
    private String namaKelurahanHer;

    @Column(name = "id_kecamatan_her")
    private Long idKecamatanHer;

    @Column(name = "nama_kecamatan_her")
    private String namaKecamatanHer;

    @Column(name = "id_kota_kab_her")
    private Long idKotaKabHer;

    @Column(name = "nama_kota_kab_her")
    private String namaKotaKabHer;

    @Column(name = "id_provinsi_her")
    private Long idProvinsiHer;

    @Column(name = "nama_provinsi_her")
    private String namaProvinsiHer;

    @Column(name = "kode_pos_her")
    private String kodePosHer;

    @Column(name = "id_negara_her")
    private Long idNegaraHer;

    @Column(name = "nama_negara_her")
    private String namaNegaraHer;

    @Column(name = "no_tlp_rumah")
    private String noTlpRumah;

    @Column(name = "no_tlp_rumah_her")
    private String noTlpRumahHer;

    @Column(name = "no_hp_her")
    private String noHpHer;

    @Column(name = "email_her")
    private String emailHer;

    @Column(name = "is_nama_penerima_sama")
    private Boolean isNamaPenerimaSama;

    @Column(name = "is_tgl_lahir_sama")
    private Boolean isTglLahirSama;

    @Column(name = "is_suskel_sama")
    private Boolean isSuskelSama;

    @Column(name = "is_kantor_bayar_sama")
    private Boolean isKantorBayarSama;

    @Column(name = "is_alamat_sama")
    private Boolean isAlamatSama;

    @Column(name = "is_ada_photo")
    private Boolean isAdaPhoto;

    @Column(name = "is_ada_ktp")
    private Boolean isAdaKtp;

    @Column(name = "is_ada_kk")
    private Boolean isAdaKk;

    @Column(name = "is_data_lengkap")
    private Boolean isDataLengkap;

    @Column(name = "is_penerima_menikah_lagi")
    private Boolean isPenerimaMenikahLagi;

    @Column(name = "tempat_menikah")
    private String tempatMenikah;

    @Column(name = "tgl_menikah")
    private Date tglMenikah;

    @Column(name = "id_serah")
    private Long idSerah;

    @Column(name = "nama_serah")
    private String namaSerah;

    @Column(name = "keterangan_serah")
    private String keteranganSerah;

    @Column(name = "id_catatan")
    private Long idCatatan;

    @Column(name = "nama_catatan")
    private String namaCatatan;

    @Column(name = "catatan")
    private String catatan;

    @Column(name = "id_validasi")
    private Long idValidasi;

    @Column(name = "nama_validasi")
    private String namaValidasi;

    @Column(name = "user_stamp")
    private String userStamp;

    @Column(name = "user_validasi")
    private String userValidasi;

    @Column(name = "is_her_otomatis")
    private Boolean isHerOtomatis;

    @Column(name = "is_sudah_her")
    private Boolean isSudahHer;

    @Column(name = "status_her_desc")
    private String statusHerDesc;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getJenisHerDesc() {
        return jenisHerDesc;
    }

    public void setJenisHerDesc(String jenisHerDesc) {
        this.jenisHerDesc = jenisHerDesc;
    }

    public String getTahunHer() {
        return tahunHer;
    }

    public void setTahunHer(String tahunHer) {
        this.tahunHer = tahunHer;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
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

    public Boolean getNamaPenerimaSama() {
        return isNamaPenerimaSama;
    }

    public void setNamaPenerimaSama(Boolean namaPenerimaSama) {
        isNamaPenerimaSama = namaPenerimaSama;
    }

    public Boolean getTglLahirSama() {
        return isTglLahirSama;
    }

    public void setTglLahirSama(Boolean tglLahirSama) {
        isTglLahirSama = tglLahirSama;
    }

    public Boolean getSuskelSama() {
        return isSuskelSama;
    }

    public void setSuskelSama(Boolean suskelSama) {
        isSuskelSama = suskelSama;
    }

    public Boolean getKantorBayarSama() {
        return isKantorBayarSama;
    }

    public void setKantorBayarSama(Boolean kantorBayarSama) {
        isKantorBayarSama = kantorBayarSama;
    }

    public Boolean getAlamatSama() {
        return isAlamatSama;
    }

    public void setAlamatSama(Boolean alamatSama) {
        isAlamatSama = alamatSama;
    }

    public Boolean getAdaPhoto() {
        return isAdaPhoto;
    }

    public void setAdaPhoto(Boolean adaPhoto) {
        isAdaPhoto = adaPhoto;
    }

    public Boolean getAdaKtp() {
        return isAdaKtp;
    }

    public void setAdaKtp(Boolean adaKtp) {
        isAdaKtp = adaKtp;
    }

    public Boolean getAdaKk() {
        return isAdaKk;
    }

    public void setAdaKk(Boolean adaKk) {
        isAdaKk = adaKk;
    }

    public Boolean getDataLengkap() {
        return isDataLengkap;
    }

    public void setDataLengkap(Boolean dataLengkap) {
        isDataLengkap = dataLengkap;
    }

    public Boolean getPenerimaMenikahLagi() {
        return isPenerimaMenikahLagi;
    }

    public void setPenerimaMenikahLagi(Boolean penerimaMenikahLagi) {
        isPenerimaMenikahLagi = penerimaMenikahLagi;
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

    @Override
    public String getUserStamp() {
        return userStamp;
    }

    @Override
    public void setUserStamp(String userStamp) {
        this.userStamp = userStamp;
    }

    public String getUserValidasi() {
        return userValidasi;
    }

    public void setUserValidasi(String userValidasi) {
        this.userValidasi = userValidasi;
    }

    public Boolean getHerOtomatis() {
        return isHerOtomatis;
    }

    public void setHerOtomatis(Boolean herOtomatis) {
        isHerOtomatis = herOtomatis;
    }

    public Boolean getSudahHer() {
        return isSudahHer;
    }

    public void setSudahHer(Boolean sudahHer) {
        isSudahHer = sudahHer;
    }

    public String getStatusHerDesc() {
        return statusHerDesc;
    }

    public void setStatusHerDesc(String statusHerDesc) {
        this.statusHerDesc = statusHerDesc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public void fromDto(HerRegistrasiDetailViewDto dto) {
        this.id = dto.getId();
        this.nip = dto.getNip();
        this.tahunHer = dto.getTahunHer();
        this.nomorHer = dto.getNomorHer();
        this.namaPeserta = dto.getNamaPeserta();
        this.tglHer = dto.getTglHer();
        this.idPenerima = dto.getIdPenerima();
        this.namaPenerima = dto.getNamaPenerima();
        this.tglLahir = dto.getTglLahir();
        this.idKategoriPenerimaMP = dto.getIdKategoriPenerimaMP();
        this.namaKategoriPenerimaMP = dto.getNamaKategoriPenerimaMP();
        this.idKantorBayar = dto.getIdKantorBayar();
        this.namaKantorBayar = dto.getNamaKantorBayar();
        this.idSuskel = dto.getIdSuskel();
        this.namaSuskel = dto.getNamaSuskel();
        this.alamatIsDalamNegeri = dto.getAlamatIsDalamNegeri();
        this.alamatLengkap = dto.getAlamatLengkap();
        this.rt = dto.getRt();
        this.rw = dto.getRw();
        this.idKelurahan = dto.getIdKelurahan();
        this.namaKelurahan = dto.getNamaKelurahan();
        this.idKecamatan = dto.getIdKecamatan();
        this.namaKecamatan = dto.getNamaKecamatan();
        this.idKotaKabNumber = dto.getIdKotaKabNumber();
        this.namaKotaKab = dto.getNamaKotaKab();
        this.idProvinsiNumber = dto.getIdProvinsiHer();
        this.namaProvinsi = dto.getNamaProvinsi();
        this.kodePos = dto.getKodePos();
        this.idNegaraNumber = dto.getIdNegaraHer();
        this.namaNegara = dto.getNamaNegara();
        this.noHp = dto.getNoHp();
        this.email = dto.getEmail();
        this.nipPas1Her = dto.getNipPas1Her();
        this.jenisKelaminPas1Her = dto.getJenisKelaminPas1Her();
        this.nipPas2Her = dto.getNipPas2Her();
        this.jenisKelaminPas2Her = dto.getJenisKelaminPas2Her();
        this.idPenerimaHer = dto.getIdPenerimaHer();
        this.namaPenerimaHer = dto.getNamaPenerimaHer();
        this.tglLahirPenerimaHer = dto.getTglLahirPenerimaHer();
        this.tglMeninggalPenerimaHer = dto.getTglMeninggalPenerimaHer();
        this.idSuskelHer = dto.getIdSuskelHer();
        this.namaSuskelHer = dto.getNamaSuskelHer();
        this.idKantorBayarHer = dto.getIdKantorBayarHer();
        this.namaKantorBayarHer = dto.getNamaKantorBayarHer();
        this.alamatIsDalamNegeriHer = dto.getAlamatIsDalamNegeriHer();
        this.alamatLengkapHer = dto.getAlamatLengkapHer();
        this.rtHer = dto.getRtHer();
        this.rwHer = dto.getRwHer();
        this.idKelurahanHer = dto.getIdKelurahanHer();
        this.namaKelurahanHer = dto.getNamaKelurahanHer();
        this.idKecamatanHer = dto.getIdKecamatanHer();
        this.namaKecamatanHer = dto.getNamaKecamatanHer();
        this.idKotaKabHer = dto.getIdKotaKabHer();
        this.namaKotaKabHer = dto.getNamaKotaKabHer();
        this.idProvinsiHer = dto.getIdProvinsiHer();
        this.namaProvinsiHer = dto.getNamaProvinsiHer();
        this.kodePosHer = dto.getKodePosHer();
        this.idNegaraHer = dto.getIdNegaraHer();
        this.namaNegaraHer = dto.getNamaNegaraHer();
        this.noTlpRumah = dto.getNoTlpRumah();
        this.noTlpRumahHer = dto.getNoTlpRumahHer();
        this.noHpHer = dto.getNoHpHer();
        this.emailHer = dto.getEmailHer();
        this.isNamaPenerimaSama = dto.getIsNamaPenerimaSama();
        this.isTglLahirSama = dto.getIsTglLahirSama();
        this.isSuskelSama = dto.getIsSuskelSama();
        this.isKantorBayarSama = dto.getIsKantorBayarSama();
        this.isAlamatSama = dto.getIsAlamatSama();
        this.isAdaPhoto = dto.getIsAdaPhoto();
        this.isAdaKtp = dto.getIsAdaKtp();
        this.isAdaKk = dto.getIsAdaKk();
        this.isDataLengkap = dto.getIsDataLengkap();
        this.isPenerimaMenikahLagi = dto.getIsPenerimaMenikahLagi();
        this.tempatMenikah = dto.getTempatMenikah();
        this.tglMenikah = dto.getTglMenikah();
        this.idSerah = dto.getIdSerah();
        this.namaSerah = dto.getNamaSerah();
        this.keteranganSerah = dto.getKeteranganSerah();
        this.idCatatan = dto.getIdCatatan();
        this.namaCatatan = dto.getNamaCatatan();
        this.catatan = dto.getCatatan();
        this.idValidasi = dto.getIdValidasi();
        this.namaValidasi = dto.getNamaValidasi();
        this.userStamp = dto.getUserStamp();
        this.userValidasi = dto.getUserValidasi();
        this.isHerOtomatis = dto.getIsHerOtomatis();
        this.isSudahHer = dto.getIsSudahHer();
        this.statusHerDesc = dto.getStatusHerDesc();
        this.jenisHerDesc = dto.getJenisHerDesc();
    }

    @Override
    public HerRegistrasiDetailViewDto toDto() {
        HerRegistrasiDetailViewDto dto = new HerRegistrasiDetailViewDto();
        dto.setId(this.id);
        dto.setNip(this.nip);
        dto.setTahunHer(this.tahunHer);
        dto.setNomorHer(this.nomorHer);
        dto.setNamaPeserta(this.namaPeserta);
        dto.setTglHer(this.tglHer);
        dto.setIdPenerima(this.idPenerima);
        dto.setNamaPenerima(this.namaPenerima);
        dto.setTglLahir(this.tglLahir);
        dto.setIdKategoriPenerimaMP(this.idKategoriPenerimaMP);
        dto.setNamaKategoriPenerimaMP(this.namaKategoriPenerimaMP);
        dto.setIdKantorBayar(this.idKantorBayar);
        dto.setNamaKantorBayar(this.namaKantorBayar);
        dto.setIdSuskel(this.idSuskel);
        dto.setNamaSuskel(this.namaSuskel);
        dto.setAlamatIsDalamNegeri(this.alamatIsDalamNegeri);
        dto.setAlamatLengkap(this.alamatLengkap);
        dto.setRt(this.rt);
        dto.setRw(this.rw);
        dto.setIdKelurahan(this.idKelurahan);
        dto.setNamaKelurahan(this.namaKelurahan);
        dto.setIdKecamatan(this.idKecamatan);
        dto.setNamaKecamatan(this.namaKecamatan);
        dto.setIdKotaKabNumber(this.idKotaKabNumber);
        dto.setNamaKotaKab(this.namaKotaKab);
        dto.setIdProvinsiHer(this.idProvinsiNumber);
        dto.setNamaProvinsi(this.namaProvinsi);
        dto.setKodePos(this.kodePos);
        dto.setIdNegaraHer(this.idNegaraNumber);
        dto.setNamaNegara(this.namaNegara);
        dto.setNoHp(this.noHp);
        dto.setEmail(this.email);
        dto.setNipPas1Her(this.nipPas1Her);
        dto.setJenisKelaminPas1Her(this.jenisKelaminPas1Her);
        dto.setNipPas2Her(this.nipPas2Her);
        dto.setJenisKelaminPas2Her(this.jenisKelaminPas2Her);
        dto.setIdPenerimaHer(this.idPenerimaHer);
        dto.setNamaPenerimaHer(this.namaPenerimaHer);
        dto.setTglLahirPenerimaHer(this.tglLahirPenerimaHer);
        dto.setTglMeninggalPenerimaHer(this.tglMeninggalPenerimaHer);
        dto.setIdSuskelHer(this.idSuskelHer);
        dto.setNamaSuskelHer(this.namaSuskelHer);
        dto.setIdKantorBayarHer(this.idKantorBayarHer);
        dto.setNamaKantorBayarHer(this.namaKantorBayarHer);
        dto.setAlamatIsDalamNegeriHer(this.alamatIsDalamNegeriHer);
        dto.setAlamatLengkapHer(this.alamatLengkapHer);
        dto.setRtHer(this.rtHer);
        dto.setRwHer(this.rwHer);
        dto.setIdKelurahanHer(this.idKelurahanHer);
        dto.setNamaKelurahanHer(this.namaKelurahanHer);
        dto.setIdKecamatanHer(this.idKecamatanHer);
        dto.setNamaKecamatanHer(this.namaKecamatanHer);
        dto.setIdKotaKabHer(this.idKotaKabHer);
        dto.setNamaKotaKabHer(this.namaKotaKabHer);
        dto.setIdProvinsiHer(this.idProvinsiHer);
        dto.setNamaProvinsiHer(this.namaProvinsiHer);
        dto.setKodePosHer(this.kodePosHer);
        dto.setIdNegaraHer(this.idNegaraHer);
        dto.setNamaNegaraHer(this.namaNegaraHer);
        dto.setNoTlpRumah(this.noTlpRumah);
        dto.setNoTlpRumahHer(this.noTlpRumahHer);
        dto.setNoHpHer(this.noHpHer);
        dto.setEmailHer(this.emailHer);
        dto.setIsNamaPenerimaSama(this.isNamaPenerimaSama);
        dto.setIsTglLahirSama(this.isTglLahirSama);
        dto.setIsSuskelSama(this.isSuskelSama);
        dto.setIsKantorBayarSama(this.isKantorBayarSama);
        dto.setIsAlamatSama(this.isAlamatSama);
        dto.setIsAdaPhoto(this.isAdaPhoto);
        dto.setIsAdaKtp(this.isAdaKtp);
        dto.setIsAdaKk(this.isAdaKk);
        dto.setIsDataLengkap(this.isDataLengkap);
        dto.setIsPenerimaMenikahLagi(this.isPenerimaMenikahLagi);
        dto.setTempatMenikah(this.tempatMenikah);
        dto.setTglMenikah(this.tglMenikah);
        dto.setIdSerah(this.idSerah);
        dto.setNamaSerah(this.namaSerah);
        dto.setKeteranganSerah(this.keteranganSerah);
        dto.setIdCatatan(this.idCatatan);
        dto.setNamaCatatan(this.namaCatatan);
        dto.setCatatan(this.catatan);
        dto.setIdValidasi(this.idValidasi);
        dto.setNamaValidasi(this.namaValidasi);
        dto.setUserStamp(this.userValidasi);
        dto.setUserValidasi(this.userValidasi);
        dto.setIsHerOtomatis(this.isHerOtomatis);
        dto.setIsSudahHer(this.isSudahHer);
        dto.setStatusHerDesc(this.statusHerDesc);
        dto.setJenisHerDesc(this.jenisHerDesc);
        return dto;
    }
}
