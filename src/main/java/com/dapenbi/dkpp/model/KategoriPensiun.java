package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dto.KategoriPensiunDto;

import javax.persistence.*;

@Entity
@Table(name = "TBL_R_KATEGORI_PENSIUN")
public class KategoriPensiun extends BaseModel<KategoriPensiunDto> {

    @Id
    @Column(name = "id_pensiun", length = 2)
    private String id;

    @Column(name = "nama_kategori_pensiun", length = 30)
    private String namaKategoriPensiun;

    @Column(name = "range_max")
    private Integer rangeMax;

    @Column(name = "range_min")
    private Integer rangeMin;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamaKategoriPensiun() {
        return namaKategoriPensiun;
    }

    public void setNamaKategoriPensiun(String namaKategoriPensiun) {
        this.namaKategoriPensiun = namaKategoriPensiun;
    }

    public Integer getRangeMax() {
        return rangeMax;
    }

    public void setRangeMax(Integer rangeMax) {
        this.rangeMax = rangeMax;
    }

    public Integer getRangeMin() {
        return rangeMin;
    }

    public void setRangeMin(Integer rangeMin) {
        this.rangeMin = rangeMin;
    }

    @Override
    public void fromDto(KategoriPensiunDto dto) {
        this.setId(dto.getId());
        this.setNamaKategoriPensiun(dto.getNamaKategoriPensiun());
        this.setRangeMax(dto.getRangeMax());
        this.setRangeMin(dto.getRangeMin());
        this.setActive(dto.isActive());
    }

    @Override
    public KategoriPensiunDto toDto() {
        KategoriPensiunDto dto = new KategoriPensiunDto();

        dto.setId(this.getId());
        dto.setNamaKategoriPensiun(this.getNamaKategoriPensiun());
        dto.setRangeMax(this.getRangeMax());
        dto.setRangeMin(this.getRangeMin());
        dto.setActive(this.isActive());

        return dto;
    }
}
