package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dto.AlasanMps100Dto;

import javax.persistence.*;

@Entity
@Table(name = "TBL_R_ALASAN_MPS100")
public class AlasanMps100 extends BaseModel<AlasanMps100Dto> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_ALASAN_MPS100_SEQ")
    @SequenceGenerator(sequenceName = "idAlasanMps100_seq", allocationSize = 1, name = "ID_ALASAN_MPS100_SEQ")
    @Column(name = "ID_ALASAN_MPS_100", length = 2)
    private Long idAlasanMps100;

    @Column(name = "NAMA_ALASAN_MPS_100", length = 500)
    private String namaAlasanMps100;

    public Long getIdAlasanMps100() {
        return idAlasanMps100;
    }

    public void setIdAlasanMps100(Long idAlasanMps100) {
        this.idAlasanMps100 = idAlasanMps100;
    }

    public String getNamaAlasanMps100() {
        return namaAlasanMps100;
    }

    public void setNamaAlasanMps100(String namaAlasanMps100) {
        this.namaAlasanMps100 = namaAlasanMps100;
    }

    @Override
    public void fromDto(AlasanMps100Dto dto) {
        this.setIdAlasanMps100(dto.getIdAlasanMps100());
        this.setNamaAlasanMps100(dto.getNamaAlasanMps100());
        this.setActive(dto.isActive());
        this.setUserStamp(dto.getUserStamp());
    }

    @Override
    public AlasanMps100Dto toDto() {
        AlasanMps100Dto dto = new AlasanMps100Dto();
        dto.setIdAlasanMps100(this.getIdAlasanMps100());
        dto.setNamaAlasanMps100(this.getNamaAlasanMps100());
        dto.setActive(this.isActive());
        dto.setUserStamp(this.getUserStamp());
        return dto ;
    }
}
