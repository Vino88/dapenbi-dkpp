package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dto.KategoriMutasiDto;

import javax.persistence.*;

@Entity
@Table(name="TBL_R_KATEGORI_MUTASI")
public class KategoriMutasi extends BaseModel<KategoriMutasiDto> {

    @Id
    @Column(name="ID_KATEGORI_MUTASI", unique=true, nullable=false, length=2)
    private String id;

    @Column(name="NAMA_KATEGORI_MUTASI", length=100)
    private String namaKategoriMutasi;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamaKategoriMutasi() {
        return namaKategoriMutasi;
    }

    public void setNamaKategoriMutasi(String namaKategoriMutasi) {
        this.namaKategoriMutasi = namaKategoriMutasi;
    }

    @Override
    public void fromDto(KategoriMutasiDto dto) {
        this.setId(dto.getId());
        this.setNamaKategoriMutasi(dto.getNamaKategoriMutasi());
        this.setActive(dto.isActive());
    }

    @Override
    public KategoriMutasiDto toDto() {
        KategoriMutasiDto dto = new KategoriMutasiDto();
        dto.setId(this.getId());
        dto.setNamaKategoriMutasi(this.getNamaKategoriMutasi());
        dto.setActive(this.isActive());
        return dto;
    }
}
