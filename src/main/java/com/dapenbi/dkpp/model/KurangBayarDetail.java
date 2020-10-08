package com.dapenbi.dkpp.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.dapenbi.dkpp.dto.KurangBayarDetailDto;

@Entity
@Table(name = "TBL_T_KURANG_BAYAR_DETAIL")
public class KurangBayarDetail extends BaseModel<KurangBayarDetailDto> implements Serializable {

	private static final long serialVersionUID = 189492943440952834L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "KURANG_BAYAR_DETAIL_ID_SEQ")
    @SequenceGenerator(sequenceName = "kurangBayarDetailId_seq", allocationSize = 1, name = "KURANG_BAYAR_DETAIL_ID_SEQ")
    @Column(name = "id_kurang_bayar")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ref_id_mutasi")
    private MutasiPensiun mutasi;

    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_mutasi")
    private Date tanggalMutasi;

    @Column(name = "periode_mutasi", length = 6)
    private String periodeMutasi;

    @Column(name = "nip", length = 10)
    private String nip;

    @Column(name = "nama_peserta", length = 50)
    private String namaPeserta;

    @Column(name = "ID_PENERIMA_MP", length = 100)
    private String penerimaMP;

    @Column(name = "nama_penerima_mp", length = 50)
    private String namaPenerimaMP;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_kategori_penerima_mp")
    private KategoriPenerima kategoriPenerima;

    @Column(name = "nama_kategori_penerima_mp", length = 50)
    private String namaKategoriPenerimaMP;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_kantor_bayar")
    private KantorBayar kantorBayar;

    @Column(name = "nama_kantor_bayar", length = 50)
    private String namaKantorBayar;

    @Column(name = "kurang_bayar_mp", scale = 20, precision = 2)
    private BigDecimal kurangBayar;

    @Column(name = "keterangan", length = 500)
    private String keterangan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_validasi")
    private StatusValidasi statusValidasi;

    @Column(name = "nama_validasi", length = 20)
    private String namaValidasi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_kategori_catatan")
    private KategoriCatatan kategoriCatatan;

    @Column(name = "nama_kategori_catatan", length = 500)
    private String namaKategoriCatatan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alasan_kuranglebih_bayar")
    private AlasanKurangLebihBayar alasanKurangLebihBayar;

    @Column(name = "kurang_bayar_mps20persen", scale = 20, precision = 2)
    private BigDecimal kurangBayarMPS20Persen;

    @Column(name = "KURANG_BAYAR_MPS10JUTA", scale = 20, precision = 2)
    private BigDecimal kurangBayarMPS10Juta;

    @Column(name = "KURANG_BAYAR_MPS100PERSEN", scale = 20, precision = 2)
    private BigDecimal kurangBayarMPS100Persen;

    @Column(name = "user_validasi", length = 100)
    private String userValidasi;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MutasiPensiun getMutasi() {
        return mutasi;
    }

    public void setMutasi(MutasiPensiun mutasi) {
        this.mutasi = mutasi;
    }

    public Date getTanggalMutasi() {
        return tanggalMutasi;
    }

    public void setTanggalMutasi(Date tanggalMutasi) {
        this.tanggalMutasi = tanggalMutasi;
    }

    public String getPeriodeMutasi() {
        return periodeMutasi;
    }

    public void setPeriodeMutasi(String periodeMutasi) {
        this.periodeMutasi = periodeMutasi;
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

    public KategoriPenerima getKategoriPenerima() {
        return kategoriPenerima;
    }

    public void setKategoriPenerima(KategoriPenerima kategoriPenerima) {
        this.kategoriPenerima = kategoriPenerima;
    }

    public String getNamaKategoriPenerimaMP() {
        return namaKategoriPenerimaMP;
    }

    public void setNamaKategoriPenerimaMP(String namaKategoriPenerimaMP) {
        this.namaKategoriPenerimaMP = namaKategoriPenerimaMP;
    }

    public KantorBayar getKantorBayar() {
        return kantorBayar;
    }

    public void setKantorBayar(KantorBayar kantorBayar) {
        this.kantorBayar = kantorBayar;
    }

    public String getNamaKantorBayar() {
        return namaKantorBayar;
    }

    public void setNamaKantorBayar(String namaKantorBayar) {
        this.namaKantorBayar = namaKantorBayar;
    }

    public BigDecimal getKurangBayar() {
        return kurangBayar;
    }

    public void setKurangBayar(BigDecimal kurangBayar) {
        this.kurangBayar = kurangBayar;
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

    public String getNamaValidasi() {
        return namaValidasi;
    }

    public void setNamaValidasi(String namaValidasi) {
        this.namaValidasi = namaValidasi;
    }

    public KategoriCatatan getKategoriCatatan() {
        return kategoriCatatan;
    }

    public void setKategoriCatatan(KategoriCatatan kategoriCatatan) {
        this.kategoriCatatan = kategoriCatatan;
    }

    public String getNamaKategoriCatatan() {
        return namaKategoriCatatan;
    }

    public void setNamaKategoriCatatan(String namaKategoriCatatan) {
        this.namaKategoriCatatan = namaKategoriCatatan;
    }

    public String getUserValidasi() {
        return userValidasi;
    }

    public void setUserValidasi(String userValidasi) {
        this.userValidasi = userValidasi;
    }

    public String getPenerimaMP() {
        return penerimaMP;
    }

    public void setPenerimaMP(String penerimaMP) {
        this.penerimaMP = penerimaMP;
    }

    public String getNamaPenerimaMP() {
        return namaPenerimaMP;
    }

    public void setNamaPenerimaMP(String namaPenerimaMP) {
        this.namaPenerimaMP = namaPenerimaMP;
    }

    public AlasanKurangLebihBayar getAlasanKurangLebihBayar() {
        return alasanKurangLebihBayar;
    }

    public void setAlasanKurangLebihBayar(AlasanKurangLebihBayar alasanKurangLebihBayar) {
        this.alasanKurangLebihBayar = alasanKurangLebihBayar;
    }

    public BigDecimal getKurangBayarMPS20Persen() {
        return kurangBayarMPS20Persen;
    }

    public void setKurangBayarMPS20Persen(BigDecimal kurangBayarMPS20Persen) {
        this.kurangBayarMPS20Persen = kurangBayarMPS20Persen;
    }

    public BigDecimal getKurangBayarMPS10Juta() {
        return kurangBayarMPS10Juta;
    }

    public void setKurangBayarMPS10Juta(BigDecimal kurangBayarMPS10Juta) {
        this.kurangBayarMPS10Juta = kurangBayarMPS10Juta;
    }

    public BigDecimal getKurangBayarMPS100Persen() {
        return kurangBayarMPS100Persen;
    }

    public void setKurangBayarMPS100Persen(BigDecimal kurangBayarMPS100Persen) {
        this.kurangBayarMPS100Persen = kurangBayarMPS100Persen;
    }

    @Override
    public void fromDto(KurangBayarDetailDto dto) {
    	this.id = dto.getId();
    	this.tanggalMutasi = dto.getTanggalMutasi();
    	this.periodeMutasi = dto.getPeriodeMutasi();
    	this.nip = dto.getNip();
    	this.namaPeserta = dto.getNamaPeserta();
    	this.namaPenerimaMP = dto.getNamaKategoriPenerimaMP();
    	this.namaKategoriPenerimaMP = dto.getNamaKategoriPenerimaMP();
    	this.namaKantorBayar = dto.getNamaKantorBayar();
    	this.kurangBayar = dto.getKurangBayar();
    	this.keterangan = dto.getKeterangan();
    	this.namaValidasi = dto.getNamaValidasi();
    	this.namaKategoriCatatan = dto.getNamaKategoriCatatan();
    	this.kurangBayarMPS10Juta = dto.getKurangBayarMPS10Juta();
    	this.kurangBayarMPS20Persen = dto.getKurangBayarMPS20Persen();
    	this.kurangBayarMPS100Persen = dto.getKurangBayarMPS100Persen();
    	this.userValidasi = dto.getUserValidasi();

    }

    @Override
    public KurangBayarDetailDto toDto() {
    	KurangBayarDetailDto dto = new KurangBayarDetailDto();
    	dto.setId(this.id);
    	dto.setTanggalMutasi(this.tanggalMutasi);
    	dto.setPeriodeMutasi(this.periodeMutasi);
    	dto.setNip(this.nip);
    	dto.setNamaPeserta(this.namaPeserta);
    	dto.setNamaKategoriPenerimaMP(this.namaPenerimaMP);
    	dto.setNamaKategoriPenerimaMP(this.namaKategoriPenerimaMP);
    	dto.setNamaKantorBayar(this.namaKantorBayar);
    	dto.setKurangBayar(this.kurangBayar);
    	dto.setKeterangan(this.keterangan);
    	dto.setNamaValidasi(this.namaValidasi);
    	dto.setNamaKategoriCatatan(this.namaKategoriCatatan);
    	dto.setKurangBayarMPS10Juta(this.kurangBayarMPS10Juta);
    	dto.setKurangBayarMPS20Persen(this.kurangBayarMPS20Persen);
    	dto.setKurangBayarMPS100Persen(this.kurangBayarMPS100Persen);
    	dto.setUserValidasi(this.userValidasi);
    	dto.setUserStamp(this.userStamp);
    	return dto;
    }
}
