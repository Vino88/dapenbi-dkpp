package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dto.PotonganKovetriDto;
import com.dapenbi.dkpp.dto.TempPotonganKovetriDto;
import com.dapenbi.dkpp.util.DkppUserStamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "TBL_TEMP_POTONGAN_KOVETRI")
public class TempPotonganKovetri extends BaseModel<TempPotonganKovetriDto> {

    @Id
    @Column(name="ID_POTONGAN_KOVETRI", unique=true, nullable=false, precision=38)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TEMP_POT_KOVETRI_ID_SEQ")
    @SequenceGenerator(sequenceName = "tempPotKovetriId_seq", allocationSize = 1, name = "TEMP_POT_KOVETRI_ID_SEQ")
    private long id;

    @Column(name = "PERIODE_MUTASI", length = 20)
    private String periodeMutasi;

    @Column(name = "NIP", length = 20)
    private String nip;

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

    public String getPotongan() {
        return potongan;
    }

    public void setPotongan(String potongan) {
        this.potongan = potongan;
    }

    @Override
    public void fromDto(TempPotonganKovetriDto dto) {
        this.setPeriodeMutasi(dto.getPeriodeMutasi());
        this.setNip(dto.getNip());
        this.setPotongan(dto.getPotongan());
    }

    @Override
    public TempPotonganKovetriDto toDto() {
        TempPotonganKovetriDto dto = new TempPotonganKovetriDto();
        dto.setId(this.getId());
        dto.setPeriodeMutasi(this.getPeriodeMutasi());
        dto.setNip(this.getNip());
        dto.setPotongan(this.getPotongan());
        return dto;
    }

    public PotonganKovetri toDestinationTable(){
        PotonganKovetri kovetri = new PotonganKovetri();
        kovetri.setPeriodeMutasi(this.getPeriodeMutasi());
        kovetri.setNip(this.getNip());
        kovetri.setPotongan(Double.valueOf(this.getPotongan()));
        kovetri.setUserStamp(DkppUserStamp.postModeUserStamp());
        kovetri.setTglUpload(new Date());
        kovetri.setCreatedAt(new Date());
        kovetri.setActive(true);
        return kovetri;
    }

    @Override
    public String toString(){
        String str = "";
        str += "\nNIP = " + this.getNip();
        str += "\nPeriode Mutasi = " + this.getPeriodeMutasi();
        str += "\nPotongan = " + this.getPotongan();
        str += "\n";
        return str;
    }

}
