package com.dapenbi.dkpp.form;

import com.dapenbi.dkpp.util.DateUtil;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class CuspMutasiHapusPensiunNfSPDto extends BaseFormDto  {
    private Long parRoleId;
    private String parCompName;
    private String parUserName;
    private String parPeriodeMutasi;
    private Date parTglMutasi;
    private Long parIdMutasi;
    private String parNip;
    private String parNamaPeserta;
    private String parIdPenerimaMp;
    private String parNamaPenerimaMp;
    private Date parTglMeninggal;
    private String parKeterangan;
    private Long parIdValidasi;
    private Long parIdStatusBayar;
    private String parNamaValidasi;
    private String parStatusEksekusi;
    private String parMsg;

    public void setParRoleId(Long parRoleId){
        this.parRoleId = parRoleId;
    }

    public Long getParRoleId(){
        return this.parRoleId;
    }

    public void setParCompName(String parCompName){
        this.parCompName = parCompName;
    }

    public String getParCompName(){
        return this.parCompName;
    }

    public void setParUserName(String parUserName){
        this.parUserName = parUserName;
    }

    public String getParUserName(){
        return this.parUserName;
    }

    public void setParPeriodeMutasi(String parPeriodeMutasi){
        this.parPeriodeMutasi = parPeriodeMutasi;
    }

    public String getParPeriodeMutasi(){
        return this.parPeriodeMutasi;
    }

    public void setParTglMutasi(Date parTglMutasi){
        this.parTglMutasi = parTglMutasi;
    }

    public Date getParTglMutasi(){
        return this.parTglMutasi;
    }

    public void setParIdMutasi(Long parIdMutasi){
        this.parIdMutasi = parIdMutasi;
    }

    public Long getParIdMutasi(){
        return this.parIdMutasi;
    }

    public void setParNip(String parNip){
        this.parNip = parNip;
    }

    public String getParNip(){
        return this.parNip;
    }

    public void setParNamaPeserta(String parNamaPeserta){
        this.parNamaPeserta = parNamaPeserta;
    }

    public String getParNamaPeserta(){
        return this.parNamaPeserta;
    }

    public void setParIdPenerimaMp(String parIdPenerimaMp){
        this.parIdPenerimaMp = parIdPenerimaMp;
    }

    public String getParIdPenerimaMp(){
        return this.parIdPenerimaMp;
    }

    public void setParNamaPenerimaMp(String parNamaPenerimaMp){
        this.parNamaPenerimaMp = parNamaPenerimaMp;
    }

    public String getParNamaPenerimaMp(){
        return this.parNamaPenerimaMp;
    }

    public void setParTglMeninggal(Date parTglMeninggal){
        this.parTglMeninggal = parTglMeninggal;
    }

    public Date getParTglMeninggal(){
        return this.parTglMeninggal;
    }

    public void setParKeterangan(String parKeterangan){
        this.parKeterangan = parKeterangan;
    }

    public String getParKeterangan(){
        return this.parKeterangan;
    }

    public void setParIdValidasi(Long parIdValidasi){
        this.parIdValidasi = parIdValidasi;
    }

    public Long getParIdValidasi(){
        return this.parIdValidasi;
    }

    public Long getParIdStatusBayar() {
        return parIdStatusBayar;
    }

    public void setParIdStatusBayar(Long parIdStatusBayar) {
        this.parIdStatusBayar = parIdStatusBayar;
    }

    public void setParNamaValidasi(String parNamaValidasi){
        this.parNamaValidasi = parNamaValidasi;
    }

    public String getParNamaValidasi(){
        return this.parNamaValidasi;
    }

    public void fromPlainText(CuspMutasiHapusPensiunNfPlainDto plainDto){
        if(plainDto.getParRoleId() != null && !plainDto.getParRoleId().equals(""))
            this.setParRoleId(Long.valueOf( plainDto.getParRoleId()) );

        this.setParCompName( plainDto.getParCompName());

        this.setParUserName( plainDto.getParUserName());

        this.setParPeriodeMutasi( plainDto.getParPeriodeMutasi());

        if(plainDto.getParTglMutasi() != null && !plainDto.getParTglMutasi().equals(""))
            this.setParTglMutasi(DateUtil.stringToDate( plainDto.getParTglMutasi()));

        if(plainDto.getParIdMutasi() != null && !plainDto.getParIdMutasi().equals(""))
            this.setParIdMutasi(Long.valueOf( plainDto.getParIdMutasi()));

        this.setParNip( plainDto.getParNip());

        this.setParNamaPeserta( plainDto.getParNamaPeserta());

        this.setParIdPenerimaMp( plainDto.getParIdPenerimaMp());

        this.setParNamaPenerimaMp( plainDto.getParNamaPenerimaMp());

        if(plainDto.getParTglMeninggal() != null && !plainDto.getParTglMeninggal().equals(""))
            this.setParTglMeninggal(DateUtil.stringToDate( plainDto.getParTglMeninggal()) );

        this.setParKeterangan( plainDto.getParKeterangan());

        if(plainDto.getParIdValidasi() != null && !plainDto.getParIdValidasi().equals(""))
            this.setParIdValidasi(Long.valueOf( plainDto.getParIdValidasi()));

        if(plainDto.getParIdStatusBayar() != null && !plainDto.getParIdStatusBayar().equals(""))
            this.setParIdStatusBayar(Long.valueOf( plainDto.getParIdStatusBayar()));

        this.setParNamaValidasi( plainDto.getParNamaValidasi());
    }

}
