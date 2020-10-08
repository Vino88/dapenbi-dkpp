package com.dapenbi.dkpp.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.dapenbi.dkpp.dto.KurangBayarDto;
import com.dapenbi.dkpp.model.CompositeId.KurangBayarPK;

@Entity
@Table(name = "TBL_T_KURANG_BAYAR")
@IdClass(KurangBayarPK.class)
public class KurangBayar extends BaseModel<KurangBayarDto> implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1719664653101209691L;

	@Id
    @Column(name = "periode_mutasi", length = 6)
    private String periodeMutasi;

    @Id
    @Column(name = "nip", length = 10)
    private String nip;

    @Column(name = "nama_peserta", length = 50)
    private String namaPeserta;

    @Column(name = "id_penerima_mp")
    private String idPenerimaMp;

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


    @Column(name = "saldo_akhir_kurang_bayar", scale = 20, precision = 2)
    private BigDecimal saldoAkhirKurangBayar;
    
    /*@ManyToOne
    @JoinColumns({
        @JoinColumn(name="nip", referencedColumnName="nip", updatable=false, insertable=false),
        @JoinColumn(name="periode_mutasi", referencedColumnName="periode_mutasi", updatable=false, insertable=false)
    })
    private KurangBayarDetail kurangBayarDetail;
      
	public KurangBayarDetail getKurangBayarDetail() {
		return kurangBayarDetail;
	}

	public void setKurangBayarDetail(KurangBayarDetail kurangBayarDetail) {
		this.kurangBayarDetail = kurangBayarDetail;
	} */

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

    public BigDecimal getSaldoAkhirKurangBayar() {
        return saldoAkhirKurangBayar;
    }

    public void setSaldoAkhirKurangBayar(BigDecimal saldoAkhirKurangBayar) {
        this.saldoAkhirKurangBayar = saldoAkhirKurangBayar;
    }

    @Override
    public void fromDto(KurangBayarDto dto) {
    	this.periodeMutasi = dto.getPeriodeMutasi();
		this.nip = dto.getNip();
		this.namaPeserta = dto.getNamaPeserta();
		this.idPenerimaMp = dto.getIdPenerimaMp();
		this.namaPenerimaMP = dto.getNamaPenerimaMP();
		this.namaKategoriPenerimaMP = dto.getNamaKategoriPenerimaMP();
		this.namaKantorBayar = dto.getNamaKantorBayar();
		this.saldoAkhirKurangBayar = dto.getSaldoAkhirKurangBayar();
    }

    @Override
    public KurangBayarDto toDto() {
    	KurangBayarDto dto = new KurangBayarDto();
		dto.setPeriodeMutasi(this.periodeMutasi);
		dto.setNip(this.nip);
		dto.setNamaPeserta(this.namaPeserta);
		dto.setIdPenerimaMp(this.idPenerimaMp);
		dto.setNamaPenerimaMP(this.namaPenerimaMP);
		dto.setNamaKategoriPenerimaMP(this.namaKategoriPenerimaMP);
		dto.setNamaKantorBayar(this.namaKantorBayar);
		dto.setSaldoAkhirKurangBayar(this.saldoAkhirKurangBayar);
		return dto;
    }
}
