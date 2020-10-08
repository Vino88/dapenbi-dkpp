package com.dapenbi.dkpp.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class TempAktuariaFprDto {
	private Long id;
	private String usiaFk;
	private String fkurang;
	private Long isActive;
	private String userStamp;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUsiaFk(String usiaFk){
	this.usiaFk = usiaFk;
}

	public String getUsiaFk(){
	return this.usiaFk;
}

	public void setFkurang(String fkurang){
	this.fkurang = fkurang;
}

	public String getFkurang(){
	return this.fkurang;
}

	public void setIsActive(Long isActive){
	this.isActive = isActive;
}

	public Long getIsActive(){
	return this.isActive;
}

	public void setUserStamp(String userStamp){
	this.userStamp = userStamp;
}

	public String getUserStamp(){
	return this.userStamp;
}



}