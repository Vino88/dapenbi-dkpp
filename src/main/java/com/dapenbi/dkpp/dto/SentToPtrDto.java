package com.dapenbi.dkpp.dto;

import java.util.Date;

public class SentToPtrDto extends BaseDto{

        private Long idPtr;
        private Date tglTransaksi;
        private String keterangan;
        private Long idRef;
        private String userStamp;
        private String periodeTransaksi;
        private Long nominal;
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

    }
