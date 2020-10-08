package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dto.GolonganDto;

import javax.persistence.*;

@Entity
@Table(name = "TBL_R_GOLONGAN")
public class Golongan extends BaseModel<GolonganDto> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GOLONGAN_ID_SEQ")
    @SequenceGenerator(sequenceName = "golonganId_seq", allocationSize = 1, name = "GOLONGAN_ID_SEQ")
    @Column(name = "id_golongan")
    private Long id;

    @Column(name = "no_golongan")
    private String noGolongan;

    @Column(name = "nama_golongan")
    private String namaGolongan;

    @Column(name = "nama_golongan_lama")
    private String namaGolonganLama;

    private String pangkat;

    private String jabatan;

    private String eselon;

    public Golongan() {
        this.isActive = true;
    }

    public Golongan(String noGolongan, String namaGolongan, String namaGolonganLama, String pangkat, String jabatan, String eselon) {
        this.noGolongan = noGolongan;
        this.namaGolongan = namaGolongan;
        this.namaGolonganLama = namaGolonganLama;
        this.pangkat = pangkat;
        this.jabatan = jabatan;
        this.eselon = eselon;
        this.isActive = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNoGolongan() {
        return noGolongan;
    }

    public void setNoGolongan(String noGolongan) {
        this.noGolongan = noGolongan;
    }

    public String getNamaGolongan() {
        return namaGolongan;
    }

    public void setNamaGolongan(String namaGolongan) {
        this.namaGolongan = namaGolongan;
    }

    public String getNamaGolonganLama() {
        return namaGolonganLama;
    }

    public void setNamaGolonganLama(String namaGolonganLama) {
        this.namaGolonganLama = namaGolonganLama;
    }

    public String getPangkat() {
        return pangkat;
    }

    public void setPangkat(String pangkat) {
        this.pangkat = pangkat;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getEselon() {
        return eselon;
    }

    public void setEselon(String eselon) {
        this.eselon = eselon;
    }

    @Override
    public void fromDto(GolonganDto dto) {

        this.setId(dto.getId());
        this.setNoGolongan(dto.getNoGolongan());
        this.setNamaGolongan(dto.getNamaGolongan());
        this.setNamaGolonganLama(dto.getNamaGolonganLama());
        this.setPangkat(dto.getPangkat());
        this.setJabatan(dto.getJabatan());
        this.setEselon(dto.getEselon());
        this.setActive(dto.getActive());
    }

    @Override
    public GolonganDto toDto() {
        GolonganDto dto = new GolonganDto();

        dto.setId(this.getId());
        dto.setNoGolongan(this.getNoGolongan());
        dto.setNamaGolongan(this.getNamaGolongan());
        dto.setNamaGolonganLama(this.getNamaGolonganLama());
        dto.setPangkat(this.getPangkat());
        dto.setJabatan(this.getJabatan());
        dto.setEselon(this.getEselon());
        dto.setActive(this.isActive());
        return dto;
    }

    public void Peserta(Peserta peserta) {
    }
}
