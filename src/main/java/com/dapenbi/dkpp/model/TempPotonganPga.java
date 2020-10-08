package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dto.TempPotonganOlahragaDto;
import com.dapenbi.dkpp.dto.TempPotonganPgaDto;
import com.dapenbi.dkpp.util.DkppUserStamp;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedGrantedAuthoritiesUserDetailsService;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TBL_TEMP_POTONGAN_PGA")
public class TempPotonganPga extends BaseModel<TempPotonganPgaDto> {

    @Id
    @Column(name="ID_POTONGAN_PGA", unique=true, nullable=false, precision=38)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TEMP_POT_PGA_ID_SEQ")
    @SequenceGenerator(sequenceName = "tempPotPgaId_seq", allocationSize = 1, name = "TEMP_POT_PGA_ID_SEQ")
    private long id;

    @Column(name = "PERIODE_MUTASI", length = 20)
    private String periodeMutasi;

    @Column(name = "NIP", length = 20)
    private String nip;

    @Column(name = "CODE", length = 20)
    private String code;

    @Column(name = "NAMA_PESERTA", length = 200)
    private String namaPeserta;

    @Column(name = "POTONGAN", length = 40)
    private String potongan;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPeriodeMutasi() {
        return periodeMutasi;
    }

    public void setPeriodeMutasi(String periodeMutasi) {
        this.periodeMutasi = periodeMutasi;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public void setNamaPeserta(String namaPeserta){
        this.namaPeserta = namaPeserta;
    }

    public String getNamaPeserta() {
        return namaPeserta;
    }

    public String getPotongan() {
        return potongan;
    }

    public void setPotongan(String potongan) {
        this.potongan = potongan;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public void fromDto(TempPotonganPgaDto dto) {
        this.setPeriodeMutasi(dto.getPeriodeMutasi());
        this.setNip(dto.getNip());
        this.setNamaPeserta(dto.getNamaPeserta());
        this.setPotongan(dto.getPotongan());
        this.setCode(dto.getCode());
    }

    @Override
    public TempPotonganPgaDto toDto() {
        TempPotonganPgaDto dto = new TempPotonganPgaDto();
        dto.setId(this.getId());
        dto.setPeriodeMutasi(this.getPeriodeMutasi());
        dto.setNip(this.getNip());
        dto.setNamaPeserta(this.getNamaPeserta());
        dto.setPotongan(this.getPotongan());
        dto.setCode(this.getCode());
        return dto;
    }

    public PotonganPga toDestinationTable(){
        PotonganPga pga = new PotonganPga();
        pga.setPeriodeMutasi(this.getPeriodeMutasi());
        pga.setNip(this.getNip());
        pga.setCode(this.getCode());
        pga.setNamaPeserta(this.getNamaPeserta());
        pga.setPotongan(Long.valueOf(this.getPotongan()));
        pga.setUserStamp(DkppUserStamp.postModeUserStamp());
        pga.setTglUpload(new Date());
        pga.setCreatedAt(new Date());
        pga.setActive(true);
        return pga;
    }

    @Override
    public String toString(){
        String out = "\n";
        out += "\nNIP : " + this.getNip();
        out += "\nNAMA PESERTA : " + this.getNamaPeserta();
        out += "\nPERIODE : " + this.getPeriodeMutasi();
        out += "\nPOTONGAN : " + this.getPotongan();
        out += "\n";
        return out;
    }
}
