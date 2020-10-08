package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dto.LebihBayarDto;
import com.dapenbi.dkpp.model.CompositeId.LebihBayarPK;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="TBL_T_LEBIH_BAYAR")
@IdClass(LebihBayarPK.class)
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "LebihBayar.processMutasiLebihBayar",
                procedureName = "CUSP_MUTASI_LEBIH_BAYAR_UPD",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ROLE_ID"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_COMP_NAME"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_USER_NAME"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NIP"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_PERIODE_LEBIH_BAYAR"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_LEBIH_BAYAR_MP"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_JENIS_PENGEMBALIAN"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_JENIS_ANGSURAN"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_TENOR"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Double.class, name = "PAR_NOMINAL_ANGSURAN"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_PERIODE_MULAI_BAYAR"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_KATEGORI_CATATAN"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_KETERANGAN"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_ID_VALIDASI"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_VALIDASI"),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, type = Character.class, name = "PAR_STATUS_EKSEKUSI"),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name = "PAR_MSG"),
                }
        )
})
public class LebihBayar extends BaseModel<LebihBayarDto> implements Serializable {

    @Id
    @Column(name = "periode_mutasi", length = 6)
    private String periodeMutasi;

    @Id
    @Column(name = "NIP", length=20)
    private String nip;

    @Column(name = "NAMA_PESERTA", length=50)
    private String namaPeserta;

    @Column(name = "ID_PENERIMA_MP", length = 100)
    private String idPenerimaMp;

    @Column(name = "NAMA_PENERIMA_MP", length = 50)
    private String namaPenerimaMp;

    @ManyToOne
    @JoinColumn(name = "ID_KATEGORI_PENERIMA_MP")
    private KategoriPenerima kategoriPenerima;

    @Column(name = "NAMA_KATEGORI_PENERIMA_MP", length = 20)
    private String namaKategoriPenerimaMp;

    @ManyToOne
    @JoinColumn(name = "id_kantor_bayar")
    private KantorBayar kantorBayar;

    @Column(name = "NAMA_KANTOR_BAYAR", length = 50)
    private String namaKantorBayar;

    @Column(name = "SALDO_LEBIH_BAYAR", scale = 20, precision = 2)
    private Long saldoLebihBayar;

    @Temporal(TemporalType.DATE)
    @Column(name = "TGL_LEBIH_BAYAR")
    private Date tglLebihBayar;

    @Column(name = "JENIS_PENGEMBALIAN", length = 50)
    private String jenisPengembalian;

    @Column(name = "JENIS_ANGSURAN", length = 50)
    private String jenisAngsuran;

    @Column(name = "TENOR_BULAN")
    private Long tenorBulan;

    @Column(name = "NOMINAL_ANGSURAN", scale = 20, precision = 2)
    private Long nominalAngsuaran;

    @Temporal(TemporalType.DATE)
    @Column(name = "TGL_PROSES_CICILAN")
    private Date tglProsesCicilan;

    @Column(name = "PERIODE_MULAI_BAYAR", length = 6)
    private String periodeMulaiBayar;

    @Column(name = "TELAH_DIBAYAR", scale = 20, precision = 2)
    private Long telahDibayar;

    @Column(name = "SISA_LEBIH_BAYAR", scale = 20, precision = 2)
    private Long sisaLebihBayar;

    @ManyToOne
    @JoinColumn(name = "ID_CATATAN")
    private KategoriCatatan kategoriCatatan;

    @Column(name = "NAMA_CATATAN", length = 50)
    private String namaCatatan;

    @Column(name = "KETERANGAN", length = 500)
    private String keterangan;

    @Column(name = "USER_VALIDASI", length = 100)
    private String userValidasi;

    @ManyToOne
    @JoinColumn(name = "ID_VALIDASI")
    private StatusValidasi statusValidasi;

    @Column(name = "NAMA_VALIDASI", length = 50)
    private String namaValidasi;

    @Column(name = "KETERANGAN_OTOMATIS", length = 500)
    private String keteranganOtomatis;

    /*@ManyToOne
    @JoinColumns({
            @JoinColumn(name="nip", referencedColumnName="nip", updatable=false, insertable=false),
            @JoinColumn(name="periode_mutasi", referencedColumnName="periode_mutasi", updatable=false, insertable=false)
    })
    private LebihBayarDetail lebihBayarDetail;*/


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

    public KategoriPenerima getKategoriPenerima() {
        return kategoriPenerima;
    }

    public void setKategoriPenerima(KategoriPenerima kategoriPenerima) {
        this.kategoriPenerima = kategoriPenerima;
    }

    public String getNamaKategoriPenerimaMp() {
        return namaKategoriPenerimaMp;
    }

    public void setNamaKategoriPenerimaMp(String namaKategoriPenerimaMp) {
        this.namaKategoriPenerimaMp = namaKategoriPenerimaMp;
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

    public Long getSaldoLebihBayar() {
        return saldoLebihBayar;
    }

    public void setSaldoLebihBayar(Long saldoLebihBayar) {
        this.saldoLebihBayar = saldoLebihBayar;
    }

    public Date getTglLebihBayar() {
        return tglLebihBayar;
    }

    public void setTglLebihBayar(Date tglLebihBayar) {
        this.tglLebihBayar = tglLebihBayar;
    }

    public String getJenisPengembalian() {
        return jenisPengembalian;
    }

    public void setJenisPengembalian(String jenisPengembalian) {
        this.jenisPengembalian = jenisPengembalian;
    }

    public String getJenisAngsuran() {
        return jenisAngsuran;
    }

    public void setJenisAngsuran(String jenisAngsuran) {
        this.jenisAngsuran = jenisAngsuran;
    }

    public Long getTenorBulan() {
        return tenorBulan;
    }

    public void setTenorBulan(Long tenorBulan) {
        this.tenorBulan = tenorBulan;
    }

    public Long getNominalAngsuaran() {
        return nominalAngsuaran;
    }

    public void setNominalAngsuaran(Long nominalAngsuaran) {
        this.nominalAngsuaran = nominalAngsuaran;
    }

    public Date getTglProsesCicilan() {
        return tglProsesCicilan;
    }

    public void setTglProsesCicilan(Date tglProsesCicilan) {
        this.tglProsesCicilan = tglProsesCicilan;
    }

    public String getPeriodeMulaiBayar() {
        return periodeMulaiBayar;
    }

    public void setPeriodeMulaiBayar(String periodeMulaiBayar) {
        this.periodeMulaiBayar = periodeMulaiBayar;
    }

    public Long getTelahDibayar() {
        return telahDibayar;
    }

    public void setTelahDibayar(Long telahDibayar) {
        this.telahDibayar = telahDibayar;
    }

    public Long getSisaLebihBayar() {
        return sisaLebihBayar;
    }

    public void setSisaLebihBayar(Long sisaLebihBayar) {
        this.sisaLebihBayar = sisaLebihBayar;
    }

    public KategoriCatatan getKategoriCatatan() {
        return kategoriCatatan;
    }

    public void setKategoriCatatan(KategoriCatatan kategoriCatatan) {
        this.kategoriCatatan = kategoriCatatan;
    }

    public String getNamaCatatan() {
        return namaCatatan;
    }

    public void setNamaCatatan(String namaCatatan) {
        this.namaCatatan = namaCatatan;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getUserValidasi() {
        return userValidasi;
    }

    public void setUserValidasi(String userValidasi) {
        this.userValidasi = userValidasi;
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

    public String getKeteranganOtomatis() {
        return keteranganOtomatis;
    }

    public void setKeteranganOtomatis(String keteranganOtomatis) {
        this.keteranganOtomatis = keteranganOtomatis;
    }

    /*public LebihBayarDetail getLebihBayarDetail() {
        return lebihBayarDetail;
    }

    public void setLebihBayarDetail(LebihBayarDetail lebihBayarDetail) {
        this.lebihBayarDetail = lebihBayarDetail;
    }*/

    @Override
    public void fromDto(LebihBayarDto dto) {
        this.setPeriodeMutasi(dto.getPeriodeMutasi());
        this.setNip(dto.getNip());
        this.setNamaPeserta(dto.getNamaPeserta());
        this.setIdPenerimaMp(dto.getIdPenerimaMp());
        this.setNamaPenerimaMp(dto.getNamaPenerimaMp());
        this.setNamaKategoriPenerimaMp(dto.getNamaKategoriPenerimaMp());
        this.setNamaKantorBayar(dto.getNamaKantorBayar());
        this.setSaldoLebihBayar(dto.getSaldoLebihBayar());
        this.setTglLebihBayar(dto.getTglLebihBayar());
        this.setJenisPengembalian(dto.getJenisPengembalian());
        this.setJenisAngsuran(dto.getJenisAngsuran());
        this.setTenorBulan(dto.getTenorBulan());
        this.setNominalAngsuaran(dto.getNominalAngsuaran());
        this.setTglProsesCicilan(dto.getTglProsesCicilan());
        this.setPeriodeMulaiBayar(dto.getPeriodeMulaiBayar());
        this.setTelahDibayar(dto.getTelahDibayar());
        this.setSisaLebihBayar(dto.getSisaLebihBayar());
        this.setNamaCatatan(dto.getNamaCatatan());
        this.setKeterangan(dto.getKeterangan());
        this.setUserValidasi(dto.getUserValidasi());
        this.setNamaValidasi(dto.getNamaValidasi());
        this.setActive(dto.isActive());

    }

    @Override
    public LebihBayarDto toDto() {
        LebihBayarDto dto = new LebihBayarDto();
        dto.setPeriodeMutasi(this.getPeriodeMutasi());
        dto.setNip(this.getNip());
        dto.setNamaPeserta(this.getNamaPeserta());
        dto.setIdPenerimaMp(this.getIdPenerimaMp());
        dto.setNamaPenerimaMp(this.getNamaPenerimaMp());
        dto.setNamaKategoriPenerimaMp(this.getNamaKategoriPenerimaMp());
        dto.setNamaKantorBayar(this.getNamaKantorBayar());
        dto.setSaldoLebihBayar(this.getSaldoLebihBayar());
        dto.setTglLebihBayar(this.getTglLebihBayar());
        dto.setJenisPengembalian(this.getJenisPengembalian());
        dto.setJenisAngsuran(this.getJenisAngsuran());
        dto.setTenorBulan(this.getTenorBulan());
        dto.setNominalAngsuaran(this.getNominalAngsuaran());
        dto.setTglProsesCicilan(this.getTglProsesCicilan());
        dto.setPeriodeMulaiBayar(this.getPeriodeMulaiBayar());
        dto.setTelahDibayar(this.getTelahDibayar());
        dto.setSisaLebihBayar(this.getSisaLebihBayar());
        dto.setNamaCatatan(this.getNamaCatatan());
        dto.setKeterangan(this.getKeterangan());
        dto.setUserValidasi(this.getUserValidasi());
        dto.setNamaValidasi(this.getNamaValidasi());
        dto.setActive(this.isActive());
        return dto;
    }
}
