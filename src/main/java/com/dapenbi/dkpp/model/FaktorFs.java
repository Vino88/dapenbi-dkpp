package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dto.FaktorFsDto;
import com.dapenbi.dkpp.dto.KeluargaPensiunDto;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="TBL_R_FAKTOR_FS")
public class FaktorFs extends BaseModel<FaktorFsDto>{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FAKTOR_FS_ID_SEQ")
    @SequenceGenerator(sequenceName = "FaktorFsId_seq", allocationSize = 1, name = "FAKTOR_FS_ID_SEQ")
    @Column(name="ID_FAKTOR_FS")
    private Long id;

    @Column(name="TGL_AWAL")
    private Date tglAwal;

    @Column(name="TGL_AKHIR")
    private Date tglAkhir;

    @Column(name="NAMA_FAKTOR_FS")
    private String namaFaktorFs;

    @Column(name="KETERANGAN_FAKTOR_FS")
    private String keteranganFaktorFs;

    public FaktorFs(Long id) {
        super();
        this.id = id;
    }

    public FaktorFs() {

    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTglAwal() {
        return tglAwal;
    }

    public void setTglAwal(Date tglAwal) {
        this.tglAwal = tglAwal;
    }

    public Date getTglAkhir() {
        return tglAkhir;
    }

    public void setTglAkhir(Date tglAkhir) {
        this.tglAkhir = tglAkhir;
    }

    public String getNamaFaktorFs() {
        return namaFaktorFs;
    }

    public void setNamaFaktorFs(String namaFaktorFs) {
        this.namaFaktorFs = namaFaktorFs;
    }

    public String getKeteranganFaktorFs() {
        return keteranganFaktorFs;
    }

    public void setKeteranganFaktorFs(String keteranganFaktorFs) {
        this.keteranganFaktorFs = keteranganFaktorFs;
    }

    @Override
    public void fromDto(FaktorFsDto dto) {
        this.setId( dto.getId() );
        this.setTglAwal(dto.getTglAwal());
        this.setTglAkhir(dto.getTglAkhir());
        this.setNamaFaktorFs(dto.getNamaFaktorFs());
        this.setKeteranganFaktorFs(dto.getKeteranganFaktorFs());
    }

    @Override
    public FaktorFsDto toDto() {
        FaktorFsDto dto = new FaktorFsDto();
        dto.setId( this.getId() );
        dto.setActive(this.isActive());
        dto.setKeteranganFaktorFs(this.getKeteranganFaktorFs());
        dto.setNamaFaktorFs(this.getNamaFaktorFs());
        dto.setTglAkhir(this.getTglAkhir());
        dto.setTglAwal(this.getTglAwal());
        return dto;
    }
}
