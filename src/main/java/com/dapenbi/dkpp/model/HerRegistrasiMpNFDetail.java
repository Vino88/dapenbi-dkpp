package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dto.HerRegistrasiMpNFDetailDto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "TBL_T_HER_REGISTRASI_D_NF")
public class HerRegistrasiMpNFDetail extends BaseModel<HerRegistrasiMpNFDetailDto> {

    @Column(name = "TAHUN_HER", length = 4)
    private String tahunHer;
    @Id
    @Column(name = "NIP", length = 20)
    private String nip;
    @Column(name = "NAMA_PESERTA", length = 50)
    private String namaPeserta;
    @Column(name = "ID_PENERIMA_MP", length = 20)
    private String idPenerimaMp;
    @Column(name = "NAMA_PENERIMA_MP", length = 50)
    private String namaPenerimaMp;
    @Column(name = "USER_STAMP", length = 100)
    private String userStamp;
    @Column(name = "TGL_HER_REGIS", length = 7)
    private Date tglHerRegis;
    @Column(name = "IS_SUDAH_HER", length = 1)
    private Character isSudahHer;
    @Column(name = "SUDAH_HER_DESC", length = 50)
    private String sudahHerDesc;

    public String getTahunHer() {
        return tahunHer;
    }

    public void setTahunHer(String tahunHer) {
        this.tahunHer = tahunHer;
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

    public String getIdPenerimaMp() {
        return idPenerimaMp;
    }

    public void setIdPenerimaMp(String idPenerimaMp) {
        this.idPenerimaMp = idPenerimaMp;
    }

    public String getNamaPenerimaMp() {
        return namaPenerimaMp;
    }

    public void setNamaPenerimaMp(String namaPenerimaMp) {
        this.namaPenerimaMp = namaPenerimaMp;
    }

    public String getUserStamp() {
        return userStamp;
    }

    public void setUserStamp(String userStamp) {
        this.userStamp = userStamp;
    }

    public Date getTglHerRegis() {
        return tglHerRegis;
    }

    public void setTglHerRegis(Date tglHerRegis) {
        this.tglHerRegis = tglHerRegis;
    }

    public Character getIsSudahHer() {
        return isSudahHer;
    }

    public void setIsSudahHer(Character isSudahHer) {
        this.isSudahHer = isSudahHer;
    }

    public String getSudahHerDesc() {
        return sudahHerDesc;
    }

    public void setSudahHerDesc(String sudahHerDesc) {
        this.sudahHerDesc = sudahHerDesc;
    }

    @Override
    public void fromDto(HerRegistrasiMpNFDetailDto dto) {
        this.setTahunHer(dto.getTahunHer());
        this.setNip(dto.getNip());
        this.setNamaPeserta(dto.getNamaPeserta());
        this.setIdPenerimaMp(dto.getIdPenerimaMp());
        this.setNamaPenerimaMp(dto.getNamaPenerimaMp());
        this.setTglHerRegis(dto.getTglHerRegis());
        this.setSudahHerDesc(dto.getSudahHerDesc());
        this.setIsSudahHer(dto.getIsSudahHer());
        this.setUserStamp(dto.getUserStamp());

    }

    @Override
    public HerRegistrasiMpNFDetailDto toDto() {
        HerRegistrasiMpNFDetailDto dto = new HerRegistrasiMpNFDetailDto();

        dto.setTahunHer(this.getTahunHer());
        dto.setNip(this.getNip());
        dto.setNamaPeserta(this.getNamaPeserta());
        dto.setIdPenerimaMp(this.getIdPenerimaMp());
        dto.setNamaPenerimaMp(this.getNamaPenerimaMp());
        dto.setTglHerRegis(this.getTglHerRegis());
        dto.setSudahHerDesc(this.getSudahHerDesc());
        dto.setIsSudahHer(this.getIsSudahHer());
        dto.setUserStamp(this.getUserStamp());
        return dto;
    }

}
