package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dto.AlasanKurangLebihBayarDto;

import javax.persistence.*;

@Entity
@Table(name = "TBL_R_ALASAN_KURANGLEBIH_BAYAR")
public class AlasanKurangLebihBayar extends BaseModel<AlasanKurangLebihBayarDto> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_ALASAN_KURANGLEBIH_SEQ")
    @SequenceGenerator(sequenceName = "idAlasanKurangLebih_seq", allocationSize = 1, name = "ID_ALASAN_KURANGLEBIH_SEQ")
    @Column(name = "id_alasan_kuranglebih")
    private Long id;

    @Column(name = "nama_alasan_kuranglebih")
    private String namaAlasanKurangLebih;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaAlasanKurangLebih() {
        return namaAlasanKurangLebih;
    }

    public void setNamaAlasanKurangLebih(String namaAlasanKurangLebih) {
        this.namaAlasanKurangLebih = namaAlasanKurangLebih;
    }

    @Override
    public void fromDto(AlasanKurangLebihBayarDto dto) {
        this.setId(dto.getId());
        this.setNamaAlasanKurangLebih(dto.getNamaAlasanKurangLebih());
        this.setActive(dto.getActive());
    }

    @Override
    public AlasanKurangLebihBayarDto toDto() {
        AlasanKurangLebihBayarDto dto = new AlasanKurangLebihBayarDto();

        dto.setId(this.getId());
        dto.setNamaAlasanKurangLebih(this.getNamaAlasanKurangLebih());
        dto.setActive(this.isActive());

        return dto;
    }
}
