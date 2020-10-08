package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dto.JenisMutasiDto;

import javax.persistence.*;

@Entity
@Table(name = "TBL_R_JENIS_MUTASI")
public class JenisMutasi extends BaseModel<JenisMutasiDto>{

    @Id
    @Column(name="KODE_MUTASI", unique=true, nullable=false, length=2)
    private String kodeMutasi;

    @Column(name="NAMA_MUTASI", nullable=false, length=20)
    private String namaMutasi;

    public String getKodeMutasi() {
        return kodeMutasi;
    }

    public void setKodeMutasi(String kodeMutasi) {
        this.kodeMutasi = kodeMutasi;
    }

    public String getNamaMutasi() {
        return namaMutasi;
    }

    public void setNamaMutasi(String namaMutasi) {
        this.namaMutasi = namaMutasi;
    }

    @Override
    public void fromDto(JenisMutasiDto dto) {
        this.setKodeMutasi(dto.getKodeMutasi());
        this.setNamaMutasi(dto.getNamaMutasi());
        this.setActive(dto.isActive());
    }

    @Override
    public JenisMutasiDto toDto() {
        JenisMutasiDto dto = new JenisMutasiDto();
        dto.setKodeMutasi(this.getKodeMutasi());
        dto.setNamaMutasi(this.getNamaMutasi());
        dto.setActive(this.isActive());
        return dto;
    }
}
