package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dto.KategoriPenerimaDto;

import javax.persistence.*;

@Entity
@Table(name = "TBL_R_KATEGORI_PENERIMA")
public class KategoriPenerima extends BaseModel<KategoriPenerimaDto> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "KATEGORI_PENERIMA_ID_SEQ")
    @SequenceGenerator(sequenceName = "kategoriPenerimaId_seq", allocationSize = 1, name = "KATEGORI_PENERIMA_ID_SEQ")
    @Column(name = "id_kategori_penerima")
    private Long id;

    @Column(name = "nama_kategori_penerima")
    private String namaKategoriPenerima;

    @Column(name = "status_kategori_penerima")
    private String statusKategoriPenerima;

    private int urutan;

    public KategoriPenerima() {
    }

    public KategoriPenerima(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaKategoriPenerima() {
        return namaKategoriPenerima;
    }

    public void setNamaKategoriPenerima(String namaKategoriPenerima) {
        this.namaKategoriPenerima = namaKategoriPenerima;
    }

    public String getStatusKategoriPenerima() {
        return statusKategoriPenerima;
    }

    public void setStatusKategoriPenerima(String statusKategoriPenerima) {
        this.statusKategoriPenerima = statusKategoriPenerima;
    }

    public int getUrutan() {
        return urutan;
    }

    public void setUrutan(int urutan) {
        this.urutan = urutan;
    }

    @Override
    public void fromDto(KategoriPenerimaDto dto) {
        this.setId(dto.getId());
        this.setNamaKategoriPenerima(dto.getNamaKategoriPenerima());
        this.setUrutan(dto.getUrutan());
        this.setActive(dto.getActive());
        this.setStatusKategoriPenerima(dto.getStatusKategoriPenerima());
    }

    @Override
    public KategoriPenerimaDto toDto() {
        KategoriPenerimaDto dto = new KategoriPenerimaDto();
        dto.setId(this.getId());
        dto.setNamaKategoriPenerima(this.getNamaKategoriPenerima());
        dto.setStatusKategoriPenerima(this.getStatusKategoriPenerima());
        dto.setUrutan(this.getUrutan());
        dto.setActive(this.isActive());
        return dto;
    }
}
