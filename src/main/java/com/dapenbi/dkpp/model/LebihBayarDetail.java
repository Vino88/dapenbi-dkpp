package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dto.KurangBayarDetailDto;
import com.dapenbi.dkpp.dto.LebihBayarDetailDto;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "TBL_T_LEBIH_BAYAR_DETAIL")
public class LebihBayarDetail extends BaseModel<LebihBayarDetailDto> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LEBIH_BAYAR_ID_SEQ")
    @SequenceGenerator(sequenceName = "lebihBayarId_seq", allocationSize = 1, name = "LEBIH_BAYAR_ID_SEQ")
    @Column(name = "ID_LEBIH_BAYAR")
    private Long id;

    @ManyToOne
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

    @Column(name = "id_penerima_mp")
    private String penerimaMP;

    @Column(name = "nama_penerima_mp", length = 50)
    private String namaPenerimaMP;

    @ManyToOne
    @JoinColumn(name = "id_kategori_penerima_mp")
    private KategoriPenerima kategoriPenerima;

    @Column(name = "nama_kategori_penerima_mp", length = 50)
    private String namaKategoriPenerimaMP;

    @ManyToOne
    @JoinColumn(name = "id_kantor_bayar")
    private KantorBayar kantorBayar;

    @Column(name = "nama_kantor_bayar", length = 50)
    private String namaKantorBayar;

    @Column(name = "kurang_bayar_mp", scale = 20, precision = 2)
    private BigDecimal kurangBayar;

    @Column(name = "keterangan", length = 500)
    private String keterangan;

    @ManyToOne
    @JoinColumn(name = "id_validasi")
    private StatusValidasi statusValidasi;

    @Column(name = "nama_validasi", length = 20)
    private String namaValidasi;

    @ManyToOne
    @JoinColumn(name = "id_kategori_catatan")
    private KategoriCatatan kategoriCatatan;

    @Column(name = "nama_kategori_catatan", length = 500)
    private String namaKategoriCatatan;

    @Column(name = "LEBIH_BAYAR_MP", scale = 20, precision = 2)
    private Long lebihBayarMP;

    @Column(name = "USER_VALIDASI", length = 100)
    private String userValidasi;

    @Column(name = "ID_ALASAN_KURANGLEBIH_BAYAR")
    private Long idAlasanKuranglebihBayar;

    @Column(name = "LEBIH_BAYAR_MPS20PERSEN", scale = 20, precision = 2)
    private Long lebihBayarMps20Persen;

    @Column(name = "LEBIH_BAYAR_MPS10JUTA", scale = 20,precision = 2)
    private Long lebihBayarMps10Juta;

    @Column(name = "LEBIH_BAYAR_MPS100PERSEN",scale = 20,precision = 2)
    private Long lebihBayarMps100Persen;

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

    public Long getLebihBayarMP() {
        return lebihBayarMP;
    }

    public void setLebihBayarMP(Long lebihBayarMP) {
        this.lebihBayarMP = lebihBayarMP;
    }

    public String getUserValidasi() {
        return userValidasi;
    }

    public void setUserValidasi(String userValidasi) {
        this.userValidasi = userValidasi;
    }

    public Long getIdAlasanKuranglebihBayar() {
        return idAlasanKuranglebihBayar;
    }

    public void setIdAlasanKuranglebihBayar(Long idAlasanKuranglebihBayar) {
        this.idAlasanKuranglebihBayar = idAlasanKuranglebihBayar;
    }

    public Long getLebihBayarMps20Persen() {
        return lebihBayarMps20Persen;
    }

    public void setLebihBayarMps20Persen(Long lebihBayarMps20Persen) {
        this.lebihBayarMps20Persen = lebihBayarMps20Persen;
    }

    public Long getLebihBayarMps10Juta() {
        return lebihBayarMps10Juta;
    }

    public void setLebihBayarMps10Juta(Long lebihBayarMps10Juta) {
        this.lebihBayarMps10Juta = lebihBayarMps10Juta;
    }

    public Long getLebihBayarMps100Persen() {
        return lebihBayarMps100Persen;
    }

    public void setLebihBayarMps100Persen(Long lebihBayarMps100Persen) {
        this.lebihBayarMps100Persen = lebihBayarMps100Persen;
    }

    @Override
    public void fromDto(LebihBayarDetailDto dto) {
        this.setId(dto.getId());
        this.setTanggalMutasi(dto.getTanggalMutasi());
        this.setPeriodeMutasi(dto.getPeriodeMutasi());
        this.setNip(dto.getNip());
        this.setNamaPeserta(dto.getNamaPeserta());
        this.setPenerimaMP(dto.getPenerimaMP());
        this.setNamaPenerimaMP(dto.getNamaPenerimaMP());
        this.setNamaKategoriPenerimaMP(dto.getNamaKategoriPenerimaMP());
        this.setNamaKantorBayar(dto.getNamaKantorBayar());
        this.setKurangBayar(dto.getKurangBayar());
        this.setKeterangan(dto.getKeterangan());
        this.setNamaValidasi(dto.getNamaValidasi());
        this.setNamaKategoriCatatan(dto.getNamaKategoriCatatan());
        this.setLebihBayarMP(dto.getLebihBayarMP());
        this.setUserStamp(dto.getUserStamp());
        this.setActive(dto.isActive());
        this.setUserValidasi(dto.getUserValidasi());
        this.setIdAlasanKuranglebihBayar(dto.getIdAlasanKuranglebihBayar());
        this.setLebihBayarMps20Persen(dto.getLebihBayarMps20Persen());
        this.setLebihBayarMps10Juta(dto.getLebihBayarMps10Juta());
        this.setLebihBayarMps100Persen(dto.getLebihBayarMps100Persen());
    }

    @Override
    public LebihBayarDetailDto toDto() {
        LebihBayarDetailDto dto = new LebihBayarDetailDto();
        dto.setId(this.getId());
        dto.setTanggalMutasi(this.getTanggalMutasi());
        dto.setPeriodeMutasi(this.getPeriodeMutasi());
        dto.setNip(this.getNip());
        dto.setNamaPeserta(this.getNamaPeserta());
        dto.setPenerimaMP(this.getPenerimaMP());
        dto.setNamaPenerimaMP(this.getNamaPenerimaMP());
        dto.setNamaKategoriPenerimaMP(this.getNamaKategoriPenerimaMP());
        dto.setNamaKantorBayar(this.getNamaKantorBayar());
        dto.setKurangBayar(this.getKurangBayar());
        dto.setKeterangan(this.getKeterangan());
        dto.setNamaValidasi(this.getNamaValidasi());
        dto.setNamaKategoriCatatan(this.getNamaKategoriCatatan());
        dto.setLebihBayarMP(this.getLebihBayarMP());
        dto.setUserStamp(this.getUserStamp());
        dto.setActive(this.isActive());
        dto.setUserValidasi(this.getUserValidasi());
        dto.setIdAlasanKuranglebihBayar(this.getIdAlasanKuranglebihBayar());
        dto.setLebihBayarMps20Persen(this.getLebihBayarMps20Persen());
        dto.setLebihBayarMps10Juta(this.getLebihBayarMps10Juta());
        dto.setLebihBayarMps100Persen(this.getLebihBayarMps100Persen());
        return dto;
    }
}
