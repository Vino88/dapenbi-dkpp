package com.dapenbi.dkpp.dto;

import java.math.BigDecimal;
import java.util.List;

import com.dapenbi.dkpp.model.KurangBayarDetail;

public class KurangBayarDto extends BaseDto {
	
	private String periodeMutasi;
    private String nip;
    private String namaPeserta;
    private String idPenerimaMp;
    private String namaPenerimaMP;
    private KategoriPenerimaDto kategoriPenerima;
    private String namaKategoriPenerimaMP;
    private KantorBayarDto kantorBayar;
    private String namaKantorBayar;
    private BigDecimal saldoAkhirKurangBayar;
    private KurangBayarDetailDto kurangBayarDetail;
    private String userStamp;
 
    
	public String getUserStamp() {
		return userStamp;
	}
	public void setUserStamp(String userStamp) {
		this.userStamp = userStamp;
	}
	public String getIdPenerimaMp() {
		return idPenerimaMp;
	}
	public void setIdPenerimaMp(String idPenerimaMp) {
		this.idPenerimaMp = idPenerimaMp;
	}
	
	public KurangBayarDetailDto getKurangBayarDetail() {
		return kurangBayarDetail;
	}
	public void setKurangBayarDetail(KurangBayarDetailDto kurangBayarDetail) {
		this.kurangBayarDetail = kurangBayarDetail;
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
	
	public String getNamaPenerimaMP() {
		return namaPenerimaMP;
	}
	public void setNamaPenerimaMP(String namaPenerimaMP) {
		this.namaPenerimaMP = namaPenerimaMP;
	}
	public KategoriPenerimaDto getKategoriPenerima() {
		return kategoriPenerima;
	}
	public void setKategoriPenerima(KategoriPenerimaDto kategoriPenerima) {
		this.kategoriPenerima = kategoriPenerima;
	}
	public String getNamaKategoriPenerimaMP() {
		return namaKategoriPenerimaMP;
	}
	public void setNamaKategoriPenerimaMP(String namaKategoriPenerimaMP) {
		this.namaKategoriPenerimaMP = namaKategoriPenerimaMP;
	}
	public KantorBayarDto getKantorBayar() {
		return kantorBayar;
	}
	public void setKantorBayar(KantorBayarDto kantorBayar) {
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
    
	
	
	
}
