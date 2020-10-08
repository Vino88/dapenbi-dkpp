package com.dapenbi.dkpp.model;

import javax.persistence.*;
import com.dapenbi.dkpp.dto.UploadRekVersiMandiriDto;
import com.dapenbi.dkpp.model.CompositeId.RekeningVersiMandiriPK;

import java.util.Date;

@Entity
@Table(name = "TBL_T_UPLOAD_REK_VERSI_MANDIRI")
@IdClass(RekeningVersiMandiriPK.class)
public class UploadRekVersiMandiri extends BaseModel<UploadRekVersiMandiriDto>{
	@Id
	@Column(name = "PERIODE", length = 6)
	private String periode;

	@Id
	@Column(name = "NIP", length = 20)
	private String nip;

	@Column(name = "NAMA_PESERTA", length = 50)
	private String namaPeserta;

	@Column(name = "ID_PENERIMA_MP", length = 20)
	private String idPenerimaMp;

	@Column(name = "NAMA_PENERIMA_MP", length = 50)
	private String namaPenerimaMp;

	@Column(name = "NOMOR_REKENING", length = 20)
	private String nomorRekening;

	@Column(name = "NAMA_REKENING", length = 50)
	private String namaRekening;

	@Column(name = "USER_STAMP", length = 100)
	private String userStamp;

	@Column(name = "TGL_UPLOAD", length = 7)
	private Date tglUpload;

	public void setPeriode(String periode){
		this.periode = periode;
	}

	public String getPeriode(){
		return this.periode;
	}

	public void setNip(String nip){
		this.nip = nip;
	}

	public String getNip(){
		return this.nip;
	}

	public void setNamaPeserta(String namaPeserta){
		this.namaPeserta = namaPeserta;
	}

	public String getNamaPeserta(){
		return this.namaPeserta;
	}

	public void setIdPenerimaMp(String idPenerimaMp){
		this.idPenerimaMp = idPenerimaMp;
	}

	public String getIdPenerimaMp(){
		return this.idPenerimaMp;
	}

	public void setNamaPenerimaMp(String namaPenerimaMp){
		this.namaPenerimaMp = namaPenerimaMp;
	}

	public String getNamaPenerimaMp(){
		return this.namaPenerimaMp;
	}

	public void setNomorRekening(String nomorRekening){
		this.nomorRekening = nomorRekening;
	}

	public String getNomorRekening(){
		return this.nomorRekening;
	}

	public void setNamaRekening(String namaRekening){
		this.namaRekening = namaRekening;
	}

	public String getNamaRekening(){
		return this.namaRekening;
	}

	public void setUserStamp(String userStamp){
		this.userStamp = userStamp;
	}

	public String getUserStamp(){
		return this.userStamp;
	}

	public void setTglUpload(Date tglUpload){
		this.tglUpload = tglUpload;
	}

	public Date getTglUpload(){
		return this.tglUpload;
	}




	@Override
	public void fromDto(UploadRekVersiMandiriDto dto){
		this.setPeriode( dto.getPeriode() );
		this.setNip( dto.getNip() );
		this.setNamaPeserta( dto.getNamaPeserta() );
		this.setIdPenerimaMp( dto.getIdPenerimaMp() );
		this.setNamaPenerimaMp( dto.getNamaPenerimaMp() );
		this.setNomorRekening( dto.getNomorRekening() );
		this.setNamaRekening( dto.getNamaRekening() );
		this.setUserStamp( dto.getUserStamp() );
		this.setTglUpload( dto.getTglUpload() );
	}




	@Override
	public UploadRekVersiMandiriDto toDto(){
		UploadRekVersiMandiriDto dto = new UploadRekVersiMandiriDto();
		dto.setPeriode( this.getPeriode() );
		dto.setNip( this.getNip() );
		dto.setNamaPeserta( this.getNamaPeserta() );
		dto.setIdPenerimaMp( this.getIdPenerimaMp() );
		dto.setNamaPenerimaMp( this.getNamaPenerimaMp() );
		dto.setNomorRekening( this.getNomorRekening() );
		dto.setNamaRekening( this.getNamaRekening() );
		dto.setUserStamp( this.getUserStamp() );
		dto.setTglUpload( this.getTglUpload() );


		return dto;
	}



}