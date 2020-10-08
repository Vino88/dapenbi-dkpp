package com.dapenbi.dkpp.model.ViewModel;

import com.dapenbi.dkpp.dto.ViewModelDto.DashboardViewDto;
import com.dapenbi.dkpp.model.BaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "VW_DASHBOARD")
public class DashboardViewModel extends BaseModel<DashboardViewDto> {
    @Id
    @Column(name = "PERIODE_MUTASI", length = 6)
    private String periodeMutasi;
    @Column(name = "JUMLAH_PESERTA_BELUM_DILEPAS", length = 22)
    private Long jumlahPesertaBelumDilepas;
    @Column(name = "JUMLAH_PESERTA_SUDAH_DILEPAS", length = 22)
    private Long jumlahPesertaSudahDilepas;
    @Column(name = "JUMLAH_PENSIUN_TUNDA", length = 22)
    private Long jumlahPensiunTunda;
    @Column(name = "JUMLAH_PENSIUN_TUNDA_OJK", length = 22)
    private Long jumlahPensiunTundaOjk;
    @Column(name = "JUMLAH_MP_ANAK_BULAN13", length = 22)
    private Long jumlahMpAnakBulan13;
    @Column(name = "JUMLAH_MUTASI_LEBIH_BAYAR", length = 22)
    private Long jumlahMutasiLebihBayar;
    @Column(name = "JUMLAH_PENERIMA_YG_BLM_HER", length = 22)
    private Long jumlahPenerimaYgBlmHer;
    @Column(name = "JUMLAH_PN", length = 22)
    private Long jumlahPn;
    @Column(name = "JUMLAH_PD", length = 22)
    private Long jumlahPd;
    @Column(name = "JUMLAH_PC", length = 22)
    private Long jumlahPc;
    @Column(name = "JUMLAH_PT", length = 22)
    private Long jumlahPt;
    @Column(name = "JUMLAH_PENERIMA_MP", length = 22)
    private Long jumlahPenerimaMp;
    @Column(name = "JUMLAH_PENERIMA_JANDA", length = 22)
    private Long jumlahPenerimaJanda;
    @Column(name = "JUMLAH_PENERIMA_DUDA", length = 22)
    private Long jumlahPenerimaDuda;
    @Column(name = "JUMLAH_PENERIMA_ANAK", length = 22)
    private Long jumlahPenerimaAnak;
    @Column(name = "BELUM_PUNYA_NO_REK", length = 22)
    private Long belumPunyaNorek;


    public String getPeriodeMutasi() {
        return periodeMutasi;
    }

    public void setPeriodeMutasi(String periodeMutasi) {
        this.periodeMutasi = periodeMutasi;
    }

    public Long getJumlahPesertaBelumDilepas() {
        return jumlahPesertaBelumDilepas;
    }

    public void setJumlahPesertaBelumDilepas(Long jumlahPesertaBelumDilepas) {
        this.jumlahPesertaBelumDilepas = jumlahPesertaBelumDilepas;
    }

    public Long getJumlahPesertaSudahDilepas() {
        return jumlahPesertaSudahDilepas;
    }

    public void setJumlahPesertaSudahDilepas(Long jumlahPesertaSudahDilepas) {
        this.jumlahPesertaSudahDilepas = jumlahPesertaSudahDilepas;
    }

    public Long getJumlahPensiunTunda() {
        return jumlahPensiunTunda;
    }

    public void setJumlahPensiunTunda(Long jumlahPensiunTunda) {
        this.jumlahPensiunTunda = jumlahPensiunTunda;
    }

    public Long getJumlahPensiunTundaOjk() {
        return jumlahPensiunTundaOjk;
    }

    public void setJumlahPensiunTundaOjk(Long jumlahPensiunTundaOjk) {
        this.jumlahPensiunTundaOjk = jumlahPensiunTundaOjk;
    }

    public Long getJumlahMpAnakBulan13() {
        return jumlahMpAnakBulan13;
    }

    public void setJumlahMpAnakBulan13(Long jumlahMpAnakBulan13) {
        this.jumlahMpAnakBulan13 = jumlahMpAnakBulan13;
    }

    public Long getJumlahMutasiLebihBayar() {
        return jumlahMutasiLebihBayar;
    }

    public void setJumlahMutasiLebihBayar(Long jumlahMutasiLebihBayar) {
        this.jumlahMutasiLebihBayar = jumlahMutasiLebihBayar;
    }

    public Long getJumlahPenerimaYgBlmHer() {
        return jumlahPenerimaYgBlmHer;
    }

    public void setJumlahPenerimaYgBlmHer(Long jumlahPenerimaYgBlmHer) {
        this.jumlahPenerimaYgBlmHer = jumlahPenerimaYgBlmHer;
    }

    public Long getJumlahPn() {
        return jumlahPn;
    }

    public void setJumlahPn(Long jumlahPn) {
        this.jumlahPn = jumlahPn;
    }

    public Long getJumlahPd() {
        return jumlahPd;
    }

    public void setJumlahPd(Long jumlahPd) {
        this.jumlahPd = jumlahPd;
    }

    public Long getJumlahPc() {
        return jumlahPc;
    }

    public void setJumlahPc(Long jumlahPc) {
        this.jumlahPc = jumlahPc;
    }

    public Long getJumlahPt() {
        return jumlahPt;
    }

    public void setJumlahPt(Long jumlahPt) {
        this.jumlahPt = jumlahPt;
    }

    public Long getJumlahPenerimaMp() {
        return jumlahPenerimaMp;
    }

    public void setJumlahPenerimaMp(Long jumlahPenerimaMp) {
        this.jumlahPenerimaMp = jumlahPenerimaMp;
    }

    public Long getJumlahPenerimaJanda() {
        return jumlahPenerimaJanda;
    }

    public void setJumlahPenerimaJanda(Long jumlahPenerimaJanda) {
        this.jumlahPenerimaJanda = jumlahPenerimaJanda;
    }

    public Long getJumlahPenerimaDuda() {
        return jumlahPenerimaDuda;
    }

    public void setJumlahPenerimaDuda(Long jumlahPenerimaDuda) {
        this.jumlahPenerimaDuda = jumlahPenerimaDuda;
    }

    public Long getJumlahPenerimaAnak() {
        return jumlahPenerimaAnak;
    }

    public void setJumlahPenerimaAnak(Long jumlahPenerimaAnak) {
        this.jumlahPenerimaAnak = jumlahPenerimaAnak;
    }

    @Override
    public Date getCreatedAt() {
        return createdAt;
    }

    @Override
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public Date getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getBelumPunyaNorek() {
        return belumPunyaNorek;
    }

    public void setBelumPunyaNorek(Long belumPunyaNorek) {
        this.belumPunyaNorek = belumPunyaNorek;
    }

    @Override
    public void fromDto(DashboardViewDto dto) {
        this.setPeriodeMutasi(dto.getPeriodeMutasi());
        this.setJumlahPesertaBelumDilepas(dto.getJumlahPesertaBelumDilepas());
        this.setJumlahPesertaSudahDilepas(dto.getJumlahPesertaSudahDilepas());
        this.setJumlahPensiunTunda(dto.getJumlahPensiunTunda());
        this.setJumlahPensiunTundaOjk(dto.getJumlahPensiunTundaOjk());
        this.setJumlahMpAnakBulan13(dto.getJumlahMpAnakBulan13());
        this.setJumlahMutasiLebihBayar(dto.getJumlahMutasiLebihBayar());
        this.setJumlahPenerimaYgBlmHer(dto.getJumlahPenerimaYgBlmHer());
        this.setJumlahPn(dto.getJumlahPn());
        this.setJumlahPd(dto.getJumlahPd());
        this.setJumlahPc(dto.getJumlahPc());
        this.setJumlahPt(dto.getJumlahPt());
        this.setJumlahPenerimaMp(dto.getJumlahPenerimaMp());
        this.setJumlahPenerimaJanda(dto.getJumlahPenerimaJanda());
        this.setJumlahPenerimaDuda(dto.getJumlahPenerimaDuda());
        this.setJumlahPenerimaAnak(dto.getJumlahPenerimaAnak());
        this.setCreatedAt(dto.getCreatedAt());
        this.setUpdatedAt(dto.getUpdateAt());
        this.setBelumPunyaNorek(dto.getBelumPunyaNorek());
    }

    @Override
    public DashboardViewDto toDto() {

        DashboardViewDto dto = new DashboardViewDto();
        dto.setPeriodeMutasi(this.getPeriodeMutasi());
        dto.setJumlahPesertaBelumDilepas(this.getJumlahPesertaBelumDilepas());
        dto.setJumlahPesertaSudahDilepas(this.getJumlahPesertaSudahDilepas());
        dto.setJumlahPensiunTunda(this.getJumlahPensiunTunda());
        dto.setJumlahPensiunTundaOjk(this.getJumlahPensiunTundaOjk());
        dto.setJumlahMpAnakBulan13(this.getJumlahMpAnakBulan13());
        dto.setJumlahMutasiLebihBayar(this.getJumlahMutasiLebihBayar());
        dto.setJumlahPenerimaYgBlmHer(this.getJumlahPenerimaYgBlmHer());
        dto.setJumlahPn(this.getJumlahPn());
        dto.setJumlahPd(this.getJumlahPd());
        dto.setJumlahPc(this.getJumlahPc());
        dto.setJumlahPt(this.getJumlahPt());
        dto.setJumlahPenerimaMp(this.getJumlahPenerimaMp());
        dto.setJumlahPenerimaJanda(this.getJumlahPenerimaJanda());
        dto.setJumlahPenerimaDuda(this.getJumlahPenerimaDuda());
        dto.setJumlahPenerimaAnak(this.getJumlahPenerimaAnak());
        dto.setCreatedAt(this.getCreatedAt());
        dto.setUpdateAt(this.getUpdatedAt());
        dto.setBelumPunyaNorek(this.getBelumPunyaNorek());

        return dto;
    }
}
