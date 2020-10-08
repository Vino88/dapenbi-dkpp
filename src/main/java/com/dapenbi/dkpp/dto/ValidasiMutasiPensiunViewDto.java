package com.dapenbi.dkpp.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class ValidasiMutasiPensiunViewDto {
	private Long no;
	private String periodeMutasi;
	private String namaMutasi;
	private Long jumlahDataMutasi;
	private Long jumlahBelumValidasi;
	private Long jumlahSudahValidasi;
	private Long jumlahBatalKoreksi;
	private Long jumlahBatalData;

public void setNo(Long no){
	this.no = no;
}

public Long getNo(){
	return this.no;
}

public void setPeriodeMutasi(String periodeMutasi){
	this.periodeMutasi = periodeMutasi;
}

public String getPeriodeMutasi(){
	return this.periodeMutasi;
}

public void setNamaMutasi(String namaMutasi){
	this.namaMutasi = namaMutasi;
}

public String getNamaMutasi(){
	return this.namaMutasi;
}

public void setJumlahDataMutasi(Long jumlahDataMutasi){
	this.jumlahDataMutasi = jumlahDataMutasi;
}

public Long getJumlahDataMutasi(){
	return this.jumlahDataMutasi;
}

public void setJumlahBelumValidasi(Long jumlahBelumValidasi){
	this.jumlahBelumValidasi = jumlahBelumValidasi;
}

public Long getJumlahBelumValidasi(){
	return this.jumlahBelumValidasi;
}

public void setJumlahSudahValidasi(Long jumlahSudahValidasi){
	this.jumlahSudahValidasi = jumlahSudahValidasi;
}

public Long getJumlahSudahValidasi(){
	return this.jumlahSudahValidasi;
}

public void setJumlahBatalKoreksi(Long jumlahBatalKoreksi){
	this.jumlahBatalKoreksi = jumlahBatalKoreksi;
}

public Long getJumlahBatalKoreksi(){
	return this.jumlahBatalKoreksi;
}

public void setJumlahBatalData(Long jumlahBatalData){
	this.jumlahBatalData = jumlahBatalData;
}

public Long getJumlahBatalData(){
	return this.jumlahBatalData;
}



}