package com.dapenbi.dkpp.form;

import com.dapenbi.dkpp.util.DateUtil;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class CuspMutasiRekeningSPDto extends BaseFormDto  {
    private Long parRoleId;
    private String parCompName;
    private String parUserName;
    private String parPeriodeMutasi;
    private Date parTglInput;
    private Long parIdMutasiRekening;
    private String parNip;
    private String parNamaPeserta;
    private String parIdPenerimaMp;
    private String parNamaPenerimaMp;
    private String parNoRekeningLama;
    private String parNamaRekeningLama;
    private String parNamaKetPerubahanRek;
    private String parNoRekeningBaru;
    private String parNamaRekeningBaru;
    private Long parIdJenisBank;
    private String parJenisBank;
    private String parNamaCabangBank;
    private Long parIdValidasi;
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

    public void setParTglInput(Date parTglInput){
        this.parTglInput = parTglInput;
    }

    public Date getParTglInput(){
        return this.parTglInput;
    }

    public void setParIdMutasiRekening(Long parIdMutasiRekening){
        this.parIdMutasiRekening = parIdMutasiRekening;
    }

    public Long getParIdMutasiRekening(){
        return this.parIdMutasiRekening;
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

    public void setParNoRekeningLama(String parNoRekeningLama){
        this.parNoRekeningLama = parNoRekeningLama;
    }

    public String getParNoRekeningLama(){
        return this.parNoRekeningLama;
    }

    public void setParNamaRekeningLama(String parNamaRekeningLama){
        this.parNamaRekeningLama = parNamaRekeningLama;
    }

    public String getParNamaRekeningLama(){
        return this.parNamaRekeningLama;
    }

    public void setParNamaKetPerubahanRek(String parNamaKetPerubahanRek){
        this.parNamaKetPerubahanRek = parNamaKetPerubahanRek;
    }

    public String getParNamaKetPerubahanRek(){
        return this.parNamaKetPerubahanRek;
    }

    public void setParNoRekeningBaru(String parNoRekeningBaru){
        this.parNoRekeningBaru = parNoRekeningBaru;
    }

    public String getParNoRekeningBaru(){
        return this.parNoRekeningBaru;
    }

    public void setParNamaRekeningBaru(String parNamaRekeningBaru){
        this.parNamaRekeningBaru = parNamaRekeningBaru;
    }

    public String getParNamaRekeningBaru(){
        return this.parNamaRekeningBaru;
    }

    public void setParIdJenisBank(Long parIdJenisBank){
        this.parIdJenisBank = parIdJenisBank;
    }

    public Long getParIdJenisBank(){
        return this.parIdJenisBank;
    }

    public void setParJenisBank(String parJenisBank){
        this.parJenisBank = parJenisBank;
    }

    public String getParJenisBank(){
        return this.parJenisBank;
    }

    public void setParNamaCabangBank(String parNamaCabangBank){
        this.parNamaCabangBank = parNamaCabangBank;
    }

    public String getParNamaCabangBank(){
        return this.parNamaCabangBank;
    }

    public void setParIdValidasi(Long parIdValidasi){
        this.parIdValidasi = parIdValidasi;
    }

    public Long getParIdValidasi(){
        return this.parIdValidasi;
    }

    public void setParNamaValidasi(String parNamaValidasi){
        this.parNamaValidasi = parNamaValidasi;
    }

    public String getParNamaValidasi(){
        return this.parNamaValidasi;
    }

    public void setParStatusEksekusi(String parStatusEksekusi){
        this.parStatusEksekusi = parStatusEksekusi;
    }

    public String getParStatusEksekusi(){
        return this.parStatusEksekusi;
    }

    public void setParMsg(String parMsg){
        this.parMsg = parMsg;
    }

    public String getParMsg(){
        return this.parMsg;
    }

    public void fromPlainText(CuspMutasiRekeningPlainDto plainDto){
        if(plainDto.getParRoleId() != null)
            this.setParRoleId( Long.valueOf(plainDto.getParRoleId()) );
        if(plainDto.getParCompName() != null)
            this.setParCompName( plainDto.getParCompName());
        if(plainDto.getParUserName() != null)
            this.setParUserName( plainDto.getParUserName());

        this.setParPeriodeMutasi( plainDto.getParPeriodeMutasi());
        this.setParTglInput( DateUtil.stringToDate(plainDto.getParTglInput()) );
        if(plainDto.getParIdMutasiRekening() != null && !plainDto.getParIdMutasiRekening().equals(""))
            this.setParIdMutasiRekening( Long.valueOf(plainDto.getParIdMutasiRekening()) );
        this.setParNip( plainDto.getParNip());
        this.setParNamaPeserta( plainDto.getParNamaPeserta());
        this.setParIdPenerimaMp( plainDto.getParIdPenerimaMp());
        this.setParNamaPenerimaMp( plainDto.getParNamaPenerimaMp());
        this.setParNoRekeningLama( plainDto.getParNoRekeningLama());
        this.setParNamaRekeningLama( plainDto.getParNamaRekeningLama());
        this.setParNamaKetPerubahanRek( plainDto.getParNamaKetPerubahanRek());
        this.setParNoRekeningBaru( plainDto.getParNoRekeningBaru());
        this.setParNamaRekeningBaru( plainDto.getParNamaRekeningBaru());
        this.setParIdJenisBank( Long.valueOf(plainDto.getParIdJenisBank()) );
        this.setParJenisBank( plainDto.getParJenisBank());
        this.setParNamaCabangBank( plainDto.getParNamaCabangBank());
        if(plainDto.getParIdValidasi() != null)
            this.setParIdValidasi( Long.valueOf(plainDto.getParIdValidasi()) );
        else
            this.setParIdValidasi(Long.valueOf(1));

        if(plainDto.getParNamaValidasi() != null)
            this.setParNamaValidasi( plainDto.getParNamaValidasi());
        else
            this.setParNamaValidasi("Belum Validasi");
    }

}