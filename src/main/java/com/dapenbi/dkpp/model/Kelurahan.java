package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dto.KelurahanDto;

import javax.persistence.*;

@Entity
@Table(name = "TBL_M_KELURAHAN")
public class Kelurahan extends BaseModel<KelurahanDto>{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "KELURAHAN_SEQ")
    @SequenceGenerator(sequenceName = "kelurahanId_seq", allocationSize = 1, name = "KELURAHAN_SEQ")

    @Column(name = "id_kelurahan")
    private Long id;

    @Column(name = "nama_kelurahan", length = 80)
    private String namaKelurahan;

    @Column(name = "kode_pos", length = 10)
    private String kodePos;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_kecamatan", nullable = false)
    private Kecamatan kecamatan;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaKelurahan() {
        return namaKelurahan;
    }

    public void setNamaKelurahan(String namaKelurahan) {
        this.namaKelurahan = namaKelurahan;
    }

    public String getKodePos() {
        return kodePos;
    }

    public void setKodePos(String kodePos) {
        this.kodePos = kodePos;
    }

    public Kecamatan getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(Kecamatan kecamatan) {
        this.kecamatan = kecamatan;
    }

    @Override
    public void fromDto(KelurahanDto dto) {
        this.setId(dto.getId());
        this.setNamaKelurahan(dto.getNamaKelurahan());
        this.setKodePos(dto.getKodePos());
        this.setActive(dto.isActive());
    }

    @Override
    public KelurahanDto toDto() {
        KelurahanDto dto = new KelurahanDto();
        dto.setId(this.getId());
        dto.setNamaKelurahan(this.getNamaKelurahan());
        dto.setKodePos(this.getKodePos());
        dto.setActive(this.isActive());
//        try {
//            dto.setIdkecamatan(this.getKecamatan().getId());
//            dto.setNamaKecamatan(this.getKecamatan().getNamaKecamatan());
//        }catch (Exception ex){
//            dto.setIdkecamatan(new Long(-1));
//            dto.setNamaKecamatan("-");
//        }
        return dto;
    }


}
