package com.dapenbi.dkpp.model;

import javax.persistence.*;
import com.dapenbi.dkpp.dto.ValidasiMutasiPensiunViewDto;

import java.util.Date;

@Entity
@Table(name = "VW_VALIDASI_MUTASI_PENSIUN")
public class ValidasiMutasiPensiunView extends BaseModel<ValidasiMutasiPensiunViewDto>{

	@Id
	@Column(name = "NO", length = 22)
	private Long no;

	@Column(name = "PERIODE_MUTASI", length = 6)
	private String periodeMutasi;

	@Column(name = "NAMA_MUTASI", length = 46)
	private String namaMutasi;

	@Column(name = "JUMLAH_DATA_MUTASI", length = 22)
	private Long jumlahDataMutasi;

	@Column(name = "JUMLAH_BELUM_VALIDASI", length = 22)
	private Long jumlahBelumValidasi;

	@Column(name = "JUMLAH_SUDAH_VALIDASI", length = 22)
	private Long jumlahSudahValidasi;

	@Column(name = "JUMLAH_BATAL_KOREKSI", length = 22)
	private Long jumlahBatalKoreksi;

	@Column(name = "JUMLAH_BATAL_DATA", length = 22)
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




	@Override
	public void fromDto(ValidasiMutasiPensiunViewDto dto){
		this.setNo( dto.getNo() );
		this.setPeriodeMutasi( dto.getPeriodeMutasi() );
		this.setNamaMutasi( dto.getNamaMutasi() );
		this.setJumlahDataMutasi( dto.getJumlahDataMutasi() );
		this.setJumlahBelumValidasi( dto.getJumlahBelumValidasi() );
		this.setJumlahSudahValidasi( dto.getJumlahSudahValidasi() );
		this.setJumlahBatalKoreksi( dto.getJumlahBatalKoreksi() );
		this.setJumlahBatalData( dto.getJumlahBatalData() );
	}




	@Override
	public ValidasiMutasiPensiunViewDto toDto(){
		ValidasiMutasiPensiunViewDto dto = new ValidasiMutasiPensiunViewDto();
		dto.setNo( this.getNo() );
		dto.setPeriodeMutasi( this.getPeriodeMutasi() );
		dto.setNamaMutasi( this.getNamaMutasi() );
		dto.setJumlahDataMutasi( this.getJumlahDataMutasi() );
		dto.setJumlahBelumValidasi( this.getJumlahBelumValidasi() );
		dto.setJumlahSudahValidasi( this.getJumlahSudahValidasi() );
		dto.setJumlahBatalKoreksi( this.getJumlahBatalKoreksi() );
		dto.setJumlahBatalData( this.getJumlahBatalData() );


		return dto;
	}



}