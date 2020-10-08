package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dto.KategoriCatatanDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "TBL_R_KATEGORI_CATATAN")
public class KategoriCatatan extends BaseModel<KategoriCatatanDto> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "KATEGORI_CATATAN_SEQ")
    @SequenceGenerator(sequenceName = "kategoriCatatan_seq", allocationSize = 1, name = "KATEGORI_CATATAN_SEQ")
    @Column(name = "id_kategori_catatan")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_KATEGORI_MUTASI")
    private KategoriMutasi kategoriMutasi;

    @Column(name = "nama_kategori_catatan", length = 20)
    private String namaKategoriCatatan;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaKategoriCatatan() {
        return namaKategoriCatatan;
    }

    public void setNamaKategoriCatatan(String namaKategoriCatatan) {
        this.namaKategoriCatatan = namaKategoriCatatan;
    }

    public KategoriMutasi getKategoriMutasi() {
        return kategoriMutasi;
    }

    public void setKategoriMutasi(KategoriMutasi kategoriMutasi) {
        this.kategoriMutasi = kategoriMutasi;
    }

    @Override
    public void fromDto(KategoriCatatanDto dto) {
        this.setId(dto.getId());
        this.setNamaKategoriCatatan(dto.getNamaKategoriCatatan());
        this.setActive(dto.isActive());
    }

    @Override
    public KategoriCatatanDto toDto() {
        KategoriCatatanDto dto = new KategoriCatatanDto();
        dto.setId(this.getId());
        dto.setNamaKategoriCatatan(this.getNamaKategoriCatatan());
        dto.setActive(this.isActive());
        return dto;
    }
}
