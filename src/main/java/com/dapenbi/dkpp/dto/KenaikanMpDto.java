package com.dapenbi.dkpp.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class KenaikanMpDto {
	private Long id;
	private Date tglInput;
	private Long idJenisKenaikanMp;
	private String namaJenisKenaikanMp;
	private String operatorTglAwalBayar;
	private Date tglAwalBayar;
	private Long persentase;
	private Long minNominal;
	private String periodeMutasiDiproses;
	private String userStamp;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTglInput(Date tglInput){
	this.tglInput = tglInput;
}

public Date getTglInput(){
	return this.tglInput;
}

public void setIdJenisKenaikanMp(Long idJenisKenaikanMp){
	this.idJenisKenaikanMp = idJenisKenaikanMp;
}

public Long getIdJenisKenaikanMp(){
	return this.idJenisKenaikanMp;
}

public void setNamaJenisKenaikanMp(String namaJenisKenaikanMp){
	this.namaJenisKenaikanMp = namaJenisKenaikanMp;
}

public String getNamaJenisKenaikanMp(){
	return this.namaJenisKenaikanMp;
}

public void setOperatorTglAwalBayar(String operatorTglAwalBayar){
	this.operatorTglAwalBayar = operatorTglAwalBayar;
}

public String getOperatorTglAwalBayar(){
	return this.operatorTglAwalBayar;
}

public void setTglAwalBayar(Date tglAwalBayar){
	this.tglAwalBayar = tglAwalBayar;
}

public Date getTglAwalBayar(){
	return this.tglAwalBayar;
}

public void setPersentase(Long persentase){
	this.persentase = persentase;
}

public Long getPersentase(){
	return this.persentase;
}

public void setMinNominal(Long minNominal){
	this.minNominal = minNominal;
}

public Long getMinNominal(){
	return this.minNominal;
}

public void setPeriodeMutasiDiproses(String periodeMutasiDiproses){
	this.periodeMutasiDiproses = periodeMutasiDiproses;
}

public String getPeriodeMutasiDiproses(){
	return this.periodeMutasiDiproses;
}

public void setUserStamp(String userStamp){
	this.userStamp = userStamp;
}

public String getUserStamp(){
	return this.userStamp;
}



}