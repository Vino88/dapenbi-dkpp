package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dto.TempPotonganOlahragaDto;
import com.dapenbi.dkpp.util.DkppUserStamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TBL_TEMP_POTONGAN_OLAHRAGA")
public class TempPotonganOlahraga extends BaseModel<TempPotonganOlahragaDto> {

    @Id
    @Column(name="ID_POTONGAN_OLAHRAGA", unique=true, nullable=false, precision=38)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TEMP_POT_OLAHRAGA_ID_SEQ")
    @SequenceGenerator(sequenceName = "tempPotOlahragaId_seq", allocationSize = 1, name = "TEMP_POT_OLAHRAGA_ID_SEQ")
    private long id;

    @Column(name = "PERIODE_MUTASI", length = 20)
    private String periodeMutasi;

    @Column(name = "NIP", length = 10)
    private String nip;

    @Column(name = "NAMA_PESERTA", length = 200)
    private String namaPeserta;

    @Column(name = "ID_OLAHRAGA", length = 20)
    private String idOlahraga;

    @Column(name = "NAMA_OLAHRAGA", length = 200)
    private String namaOlahraga;

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

    public String getNamaPeserta() {
        return namaPeserta;
    }

    public void setNamaPeserta(String namaPeserta) {
        this.namaPeserta = namaPeserta;
    }

    public String getIdOlahraga() {
        return idOlahraga;
    }

    public void setIdOlahraga(String idOlahraga) {
        this.idOlahraga = idOlahraga;
    }

    public String getNamaOlahraga() {
        return namaOlahraga;
    }

    public void setNamaOlahraga(String namaOlahraga) {
        this.namaOlahraga = namaOlahraga;
    }

    public String getPotongan() {
        return potongan;
    }

    public void setPotongan(String potongan) {
        this.potongan = potongan;
    }

    @Override
    public void fromDto(TempPotonganOlahragaDto dto) {
        this.setPeriodeMutasi(dto.getPeriodeMutasi());
        this.setNip(dto.getNip());
        this.setNamaPeserta(dto.getNamaPeserta());
        this.setIdOlahraga(dto.getIdOlahraga());
        this.setNamaOlahraga(dto.getNamaOlahraga());
        this.setPotongan(dto.getPotongan());
    }

    @Override
    public TempPotonganOlahragaDto toDto() {
        TempPotonganOlahragaDto dto = new TempPotonganOlahragaDto();
        dto.setId(this.getId());
        dto.setPeriodeMutasi(this.getPeriodeMutasi());
        dto.setNip(this.getNip());
        dto.setNamaPeserta(this.getNamaPeserta());
        dto.setIdOlahraga(this.getIdOlahraga());
        dto.setNamaOlahraga(this.getNamaOlahraga());
        dto.setPotongan(this.getPotongan());
        return dto;
    }

    public PotonganOlahraga toDestinationTable(){
        PotonganOlahraga olahraga = new PotonganOlahraga();
        olahraga.setPeriodeMutasi(this.getPeriodeMutasi());
        olahraga.setNip(this.getNip());
        olahraga.setNamaPeserta(this.getNamaPeserta());
        olahraga.setIdOlahraga(Long.valueOf(this.getIdOlahraga()));
        olahraga.setNamaOlahraga(this.getNamaOlahraga());
        olahraga.setPotongan(Double.valueOf(this.getPotongan()));
        olahraga.setUserStamp(DkppUserStamp.postModeUserStamp());
        olahraga.setTglUpload(new Date());
        olahraga.setCreatedAt(new Date());
        olahraga.setActive(true);
        return olahraga;
    }
}
