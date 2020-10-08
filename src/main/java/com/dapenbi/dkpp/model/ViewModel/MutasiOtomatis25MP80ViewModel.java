package com.dapenbi.dkpp.model.ViewModel;

import com.dapenbi.dkpp.dto.MutasiOtomatis25TViewModelDto;
import com.dapenbi.dkpp.dto.ViewModelDto.MutasiOtomatis25MP80ViewModelDto;
import com.dapenbi.dkpp.model.BaseModel;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name="VW_MUTASI_OTOM_ANK25MP80")
@NamedStoredProcedureQueries(
        @NamedStoredProcedureQuery(
                name = "MutasiPensiun.processMutasiOtomatis25MP80",
                procedureName = "CUSP_MUTASI_OTOM_ANAK25MP80",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "COMP_NAME"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "USER_NAME"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_PERIODE_MUTASI"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "PAR_TGL_MUTASI"),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, type = Character.class, name = "PAR_STATUS_EKSEKUSI"),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name = "PAR_MSG")
                }
        )
)
public class MutasiOtomatis25MP80ViewModel extends BaseModel<MutasiOtomatis25MP80ViewModelDto> {

    @Id
    @Column(name="ID")
    private Long id;

    @Column(name="TGL_PROSES")
    private Date tglProses;

    @Column(name="PERIODE_MUTASI")
    private String periodeMutasi;

    @Column(name="NAMA_KATEGORI_MUTASI")
    private String namaKategoriMutasi;

    @Column(name="TOTAL_DATA")
    private Long totalData;

    @Column(name="BELUM_VALIDASI")
    private Long belumValidasi;

    @Column(name="SUDAH_VALIDASI")
    private Long sudahValidasi;

    @Column(name="BATAL_VALIDASI")
    private Long batalValidasi;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTglProses() {
        return tglProses;
    }

    public void setTglProses(Date tglProses) {
        this.tglProses = tglProses;
    }

    public String getPeriodeMutasi() {
        return periodeMutasi;
    }

    public void setPeriodeMutasi(String periodeMutasi) {
        this.periodeMutasi = periodeMutasi;
    }

    public String getNamaKategoriMutasi() {
        return namaKategoriMutasi;
    }

    public void setNamaKategoriMutasi(String namaKategoriMutasi) {
        this.namaKategoriMutasi = namaKategoriMutasi;
    }

    public Long getTotalData() {
        return totalData;
    }

    public void setTotalData(Long totalData) {
        this.totalData = totalData;
    }

    public Long getBelumValidasi() {
        return belumValidasi;
    }

    public void setBelumValidasi(Long belumValidasi) {
        this.belumValidasi = belumValidasi;
    }

    public Long getSudahValidasi() {
        return sudahValidasi;
    }

    public void setSudahValidasi(Long sudahValidasi) {
        this.sudahValidasi = sudahValidasi;
    }

    public Long getBatalValidasi() {
        return batalValidasi;
    }

    public void setBatalValidasi(Long batalValidasi) {
        this.batalValidasi = batalValidasi;
    }

    @Override
    public void fromDto(MutasiOtomatis25MP80ViewModelDto dto) {
        this.setTglProses(dto.getTglProses());
        this.setPeriodeMutasi(dto.getPeriodeMutasi());
        this.setNamaKategoriMutasi(dto.getNamaKategoriMutasi());
        this.setTotalData(dto.getTotalData());
        this.setBelumValidasi(dto.getBelumValidasi());
        this.setSudahValidasi(dto.getSudahValidasi());
        this.setBatalValidasi(dto.getBatalValidasi());
    }

    @Override
    public MutasiOtomatis25MP80ViewModelDto toDto() {
        MutasiOtomatis25MP80ViewModelDto dto = new MutasiOtomatis25MP80ViewModelDto();
        dto.setTglProses(this.getTglProses());
        dto.setPeriodeMutasi(this.getPeriodeMutasi());
        dto.setNamaKategoriMutasi(this.getNamaKategoriMutasi());
        dto.setTotalData(this.getTotalData());
        dto.setBelumValidasi(this.getBelumValidasi());
        dto.setSudahValidasi(this.getSudahValidasi());
        dto.setBatalValidasi(this.getBatalValidasi());
        return dto;
    }
}
