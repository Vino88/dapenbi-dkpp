package com.dapenbi.dkpp.model;


import com.dapenbi.dkpp.dto.SentToPtrDto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "TBL_T_SENT_TO_PTR")
public class SentToPtr extends BaseModel<SentToPtrDto>{
    @Id
    @Column(name = "ID_PTR", length = 22)
    private Long idPtr;

    @Column(name = "TGL_TRANSAKSI", length = 7)
    private Date tglTransaksi;

    @Column(name = "KETERANGAN", length = 500)
    private String keterangan;

    @Column(name = "ID_REF", length = 22)
    private Long idRef;

    @Column(name = "USER_STAMP", length = 100)
    private String userStamp;

    @Column(name = "PERIODE_TRANSAKSI", length = 6)
    private String periodeTransaksi;

    @Column(name = "NOMINAL", length = 22)
    private Long nominal;

    @Column(name = "SUMBER", length = 50)
    private String sumber;

    public void setIdPtr(Long idPtr){
        this.idPtr = idPtr;
    }

    public Long getIdPtr(){
        return this.idPtr;
    }

    public void setTglTransaksi(Date tglTransaksi){
        this.tglTransaksi = tglTransaksi;
    }

    public Date getTglTransaksi(){
        return this.tglTransaksi;
    }

    public void setKeterangan(String keterangan){
        this.keterangan = keterangan;
    }

    public String getKeterangan(){
        return this.keterangan;
    }

    public void setIdRef(Long idRef){
        this.idRef = idRef;
    }

    public Long getIdRef(){
        return this.idRef;
    }

    public void setUserStamp(String userStamp){
        this.userStamp = userStamp;
    }

    public String getUserStamp(){
        return this.userStamp;
    }

    public void setPeriodeTransaksi(String periodeTransaksi){
        this.periodeTransaksi = periodeTransaksi;
    }

    public String getPeriodeTransaksi(){
        return this.periodeTransaksi;
    }

    public void setNominal(Long nominal){
        this.nominal = nominal;
    }

    public Long getNominal(){
        return this.nominal;
    }

    public void setSumber(String sumber){
        this.sumber = sumber;
    }

    public String getSumber(){
        return this.sumber;
    }




    @Override
    public void fromDto(SentToPtrDto dto){
        this.setIdPtr( dto.getIdPtr() );
        this.setTglTransaksi( dto.getTglTransaksi() );
        this.setKeterangan( dto.getKeterangan() );
        this.setIdRef( dto.getIdRef() );
        this.setUserStamp( dto.getUserStamp() );
        this.setPeriodeTransaksi( dto.getPeriodeTransaksi() );
        this.setNominal( dto.getNominal() );
        this.setSumber( dto.getSumber() );
    }

    @Override
    public SentToPtrDto toDto(){
        SentToPtrDto dto = new SentToPtrDto();
        dto.setIdPtr( this.getIdPtr() );
        dto.setTglTransaksi( this.getTglTransaksi() );
        dto.setKeterangan( this.getKeterangan() );
        dto.setIdRef( this.getIdRef() );
        dto.setUserStamp( this.getUserStamp() );
        dto.setPeriodeTransaksi( this.getPeriodeTransaksi() );
        dto.setNominal( this.getNominal() );
        dto.setSumber( this.getSumber() );


        return dto;
    }



}