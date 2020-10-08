package com.dapenbi.dkpp.model;

import javax.persistence.*;
import com.dapenbi.dkpp.dto.MKeluargaPensiunNfDto;
import java.util.Date;

@Entity
@Table(name = "TBL_M_KELUARGA_PENSIUN_NF")
public class MKeluargaPensiunNf extends BaseModel<MKeluargaPensiunNfDto>{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "KEL_PENSIUN_NF_ID_SEQ")
	@SequenceGenerator(sequenceName = "kelPensiunNfId_seq", allocationSize = 1, name = "KEL_PENSIUN_NF_ID_SEQ")
	@Column(name = "ID_KELUARGA", length = 22)
	private Long idKeluarga;

	@Column(name = "NIP", length = 20)
	private String nip;

	@Column(name = "NAMA", length = 100)
	private String nama;

	@Column(name = "TEMPAT_LAHIR", length = 100)
	private String tempatLahir;

	@Column(name = "TGL_LAHIR", length = 7)
	private Date tglLahir;

	@Column(name = "JENIS_KELAMIN", length = 1)
	private Character jenisKelamin;

	@Column(name = "HUBUNGAN", length = 100)
	private String hubungan;
	@ManyToOne(fetch = FetchType.LAZY)

	@Column(name = "USER_STAMP", length = 100)
	private String userStamp;

	public void setIdKeluarga(Long idKeluarga){
		this.idKeluarga = idKeluarga;
	}

	public Long getIdKeluarga(){
		return this.idKeluarga;
	}

	public void setNip(String nip){
		this.nip = nip;
	}

	public String getNip(){
		return this.nip;
	}

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return this.nama;
	}

	public void setTempatLahir(String tempatLahir){
		this.tempatLahir = tempatLahir;
	}

	public String getTempatLahir(){
		return this.tempatLahir;
	}

	public void setTglLahir(Date tglLahir){
		this.tglLahir = tglLahir;
	}

	public Date getTglLahir(){
		return this.tglLahir;
	}

	public void setJenisKelamin(Character jenisKelamin){
		this.jenisKelamin = jenisKelamin;
	}

	public Character getJenisKelamin(){
		return this.jenisKelamin;
	}

	public void setHubungan(String hubungan){
		this.hubungan = hubungan;
	}

	public String getHubungan(){
		return this.hubungan;
	}

	public void setUserStamp(String userStamp){
		this.userStamp = userStamp;
	}

	public String getUserStamp(){
		return this.userStamp;
	}




	@Override
	public void fromDto(MKeluargaPensiunNfDto dto){
		this.setIdKeluarga( dto.getIdKeluarga() );
		this.setNip( dto.getNip() );
		this.setNama( dto.getNama() );
		this.setTempatLahir( dto.getTempatLahir() );
		this.setTglLahir( dto.getTglLahir() );
		this.setJenisKelamin( dto.getJenisKelamin() );
		this.setHubungan( dto.getHubungan() );
		this.setUserStamp( dto.getUserStamp() );
	}




	@Override
	public MKeluargaPensiunNfDto toDto(){
		MKeluargaPensiunNfDto dto = new MKeluargaPensiunNfDto();
		if(this.getIdKeluarga()>0)
			dto.setIdKeluarga( this.getIdKeluarga() );
		dto.setNip( this.getNip() );
		dto.setNama( this.getNama() );
		dto.setTempatLahir( this.getTempatLahir() );
		dto.setTglLahir( this.getTglLahir() );
		dto.setJenisKelamin( this.getJenisKelamin() );
		dto.setHubungan( this.getHubungan() );
		dto.setUserStamp( this.getUserStamp() );

		return dto;
	}

}