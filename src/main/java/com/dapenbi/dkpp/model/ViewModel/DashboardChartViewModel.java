package com.dapenbi.dkpp.model.ViewModel;

import com.dapenbi.dkpp.dto.BaseDto;
import com.dapenbi.dkpp.dto.ViewModelDto.DashboardChartViewDto;
import com.dapenbi.dkpp.model.BaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "VW_DASHBOARD_CHART")
public class DashboardChartViewModel extends BaseModel<DashboardChartViewDto> {

    @Column(name = "JUMLAH_PENERIMA", length = 22)
    private Long jumlahPenerima;

    @Id
    @Column(name = "NAMA_KANTOR_BAYAR", length = 50)
    private String namaKantorBayar;

    @Column(name = "PERIODE_MUTASI", length = 6)
    private String periodeMutasi;

    @Column(name = "USER_STAMP", length = 0)
    private Character userStamp;

    @Column(name = "CREATED_AT", length = 8)
    private Date createdAt;

    @Column(name = "UPDATED_AT", length = 8)
    private Date updatedAt;

    public Long getJumlahPenerima() {
        return jumlahPenerima;
    }

    public void setJumlahPenerima(Long jumlahPenerima) {
        this.jumlahPenerima = jumlahPenerima;
    }

    public String getNamaKantorBayar() {
        return namaKantorBayar;
    }

    public void setNamaKantorBayar(String namaKantorBayar) {
        this.namaKantorBayar = namaKantorBayar;
    }

    public String getPeriodeMutasi() {
        return periodeMutasi;
    }

    public void setPeriodeMutasi(String periodeMutasi) {
        this.periodeMutasi = periodeMutasi;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }


    @Override
    public void fromDto(DashboardChartViewDto dto) {
        this.setPeriodeMutasi(dto.getPeriodeMutasi());
        this.setNamaKantorBayar(dto.getNamaKantorBayar());
        this.setJumlahPenerima(dto.getJumlahPenerima());
        this.setCreatedAt(dto.getCreatedAt());
        this.setUpdatedAt(dto.getUpdatedAt());
    }

    @Override
    public DashboardChartViewDto toDto() {
        DashboardChartViewDto dto = new DashboardChartViewDto();

        dto.setPeriodeMutasi(this.getPeriodeMutasi());
        dto.setNamaKantorBayar(this.getNamaKantorBayar());
        dto.setJumlahPenerima(this.getJumlahPenerima());
        dto.setCreatedAt(this.getCreatedAt());
        dto.setUpdatedAt(this.getUpdatedAt());
        return dto;
    }
}
