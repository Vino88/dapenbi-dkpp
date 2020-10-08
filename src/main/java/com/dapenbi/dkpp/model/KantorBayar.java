package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dto.KantorBayarDto;

import javax.persistence.*;

@Entity
@Table(name = "TBL_R_KANTOR_BAYAR")
public class KantorBayar extends BaseModel<KantorBayarDto> {

    @Id
    @Column(name = "id_kantor_bayar", length = 5)
    private String id;

    @Column(name = "nama_kantor_bayar")
    private String namaKantorBayar;

    @Column(name = "alamat_surat1")
    private String alamatSurat1;

    @Column(name = "alamat_surat2")
    private String alamatSurat2;

    @Column(name = "alamat_surat3")
    private String alamatSurat3;

    @Column(name = "alamat_surat4")
    private String alamatSurat4;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamaKantorBayar() {
        return namaKantorBayar;
    }

    public void setNamaKantorBayar(String namaKantorBayar) {
        this.namaKantorBayar = namaKantorBayar;
    }

    public String getAlamatSurat1() {
        return alamatSurat1;
    }

    public void setAlamatSurat1(String alamatSurat1) {
        this.alamatSurat1 = alamatSurat1;
    }

    public String getAlamatSurat2() {
        return alamatSurat2;
    }

    public void setAlamatSurat2(String alamatSurat2) {
        this.alamatSurat2 = alamatSurat2;
    }

    public String getAlamatSurat3() {
        return alamatSurat3;
    }

    public void setAlamatSurat3(String alamatSurat3) {
        this.alamatSurat3 = alamatSurat3;
    }

    public String getAlamatSurat4() {
        return alamatSurat4;
    }

    public void setAlamatSurat4(String alamatSurat4) {
        this.alamatSurat4 = alamatSurat4;
    }

    @Override
    public void fromDto(KantorBayarDto dto) {
        this.setNamaKantorBayar(dto.getNamaKantorBayar());
        this.setAlamatSurat1(dto.getAlamatSurat1());
        this.setAlamatSurat2(dto.getAlamatSurat2());
        this.setAlamatSurat3(dto.getAlamatSurat3());
        this.setAlamatSurat4(dto.getAlamatSurat4());
        this.setActive(dto.getActive());
        this.setId(dto.getId());
    }

    @Override
    public KantorBayarDto toDto() {
        KantorBayarDto dto = new KantorBayarDto();
        dto.setId(this.getId());
        dto.setNamaKantorBayar(this.getNamaKantorBayar());
        dto.setAlamatSurat1(this.getAlamatSurat1());
        dto.setAlamatSurat2(this.getAlamatSurat2());
        dto.setAlamatSurat3(this.getAlamatSurat3());
        dto.setAlamatSurat4(this.getAlamatSurat4());
        dto.setActive(this.isActive());
        return dto;
    }
}
