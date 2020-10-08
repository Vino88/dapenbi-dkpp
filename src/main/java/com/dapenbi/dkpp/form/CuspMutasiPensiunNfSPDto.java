package com.dapenbi.dkpp.form;

import com.dapenbi.dkpp.util.DateUtil;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class CuspMutasiPensiunNfSPDto extends BaseFormDto  {
    private Long parRoleId;
    private String parCompName;
    private String parUserName;
    private String parNip;
    private String parTempatLahir;
    private Date parTglLahir;
    private String parTempatMenikah;
    private Date parTglMenikah;
    private Date parTglLahirPenerimaMp;
    private Date parTglMeninggal;
    private Long parMpBulananEuro;
    private String parAlamat;
    private String parKota;
    private String parKodePos;
    private String parNomorRekening;
    private String parNamaRekening;
    private Long parIdBankNf;
    private String parSwiftCode;
    private String parIbanCode;
    private String parPersNs;
    private String parKeterangan;
    private String parStatusEksekusi;
    private String parMsg;

    public Long getParRoleId() {
        return parRoleId;
    }

    public void setParRoleId(Long parRoleId) {
        this.parRoleId = parRoleId;
    }

    public String getParCompName() {
        return parCompName;
    }

    public void setParCompName(String parCompName) {
        this.parCompName = parCompName;
    }

    public String getParUserName() {
        return parUserName;
    }

    public void setParUserName(String parUserName) {
        this.parUserName = parUserName;
    }

    public String getParNip() {
        return parNip;
    }

    public void setParNip(String parNip) {
        this.parNip = parNip;
    }

    public String getParTempatLahir() {
        return parTempatLahir;
    }

    public void setParTempatLahir(String parTempatLahir) {
        this.parTempatLahir = parTempatLahir;
    }

    public Date getParTglLahir() {
        return parTglLahir;
    }

    public void setParTglLahir(Date parTglLahir) {
        this.parTglLahir = parTglLahir;
    }

    public String getParTempatMenikah() {
        return parTempatMenikah;
    }

    public void setParTempatMenikah(String parTempatMenikah) {
        this.parTempatMenikah = parTempatMenikah;
    }

    public Date getParTglMenikah() {
        return parTglMenikah;
    }

    public void setParTglMenikah(Date parTglMenikah) {
        this.parTglMenikah = parTglMenikah;
    }

    public Date getParTglLahirPenerimaMp() {
        return parTglLahirPenerimaMp;
    }

    public void setParTglLahirPenerimaMp(Date parTglLahirPenerimaMp) {
        this.parTglLahirPenerimaMp = parTglLahirPenerimaMp;
    }

    public Date getParTglMeninggal() {
        return parTglMeninggal;
    }

    public void setParTglMeninggal(Date parTglMeninggal) {
        this.parTglMeninggal = parTglMeninggal;
    }

    public Long getParMpBulananEuro() {
        return parMpBulananEuro;
    }

    public void setParMpBulananEuro(Long parMpBulananEuro) {
        this.parMpBulananEuro = parMpBulananEuro;
    }

    public String getParAlamat() {
        return parAlamat;
    }

    public void setParAlamat(String parAlamat) {
        this.parAlamat = parAlamat;
    }

    public String getParKota() {
        return parKota;
    }

    public void setParKota(String parKota) {
        this.parKota = parKota;
    }

    public String getParKodePos() {
        return parKodePos;
    }

    public void setParKodePos(String parKodePos) {
        this.parKodePos = parKodePos;
    }

    public String getParNomorRekening() {
        return parNomorRekening;
    }

    public void setParNomorRekening(String parNomorRekening) {
        this.parNomorRekening = parNomorRekening;
    }

    public String getParNamaRekening() {
        return parNamaRekening;
    }

    public void setParNamaRekening(String parNamaRekening) {
        this.parNamaRekening = parNamaRekening;
    }

    public Long getParIdBankNf() {
        return parIdBankNf;
    }

    public void setParIdBankNf(Long parIdBankNf) {
        this.parIdBankNf = parIdBankNf;
    }

    public String getParSwiftCode() {
        return parSwiftCode;
    }

    public void setParSwiftCode(String parSwiftCode) {
        this.parSwiftCode = parSwiftCode;
    }

    public String getParIbanCode() {
        return parIbanCode;
    }

    public void setParIbanCode(String parIbanCode) {
        this.parIbanCode = parIbanCode;
    }

    public String getParPersNs() {
        return parPersNs;
    }

    public void setParPersNs(String parPersNs) {
        this.parPersNs = parPersNs;
    }

    public String getParKeterangan() {
        return parKeterangan;
    }

    public void setParKeterangan(String parKeterangan) {
        this.parKeterangan = parKeterangan;
    }

    public String getParStatusEksekusi() {
        return parStatusEksekusi;
    }

    public void setParStatusEksekusi(String parStatusEksekusi) {
        this.parStatusEksekusi = parStatusEksekusi;
    }

    public String getParMsg() {
        return parMsg;
    }

    public void setParMsg(String parMsg) {
        this.parMsg = parMsg;
    }

    public void fromPlainText(CuspMutasiPensiunNfPlainDto dto){
        this.setParCompName( dto.getParCompName());
        this.setParUserName( dto.getParUserName());
        this.setParNip( dto.getParNip());
        this.setParTempatLahir( dto.getParTempatLahir());
        this.setParTglLahir(DateUtil.stringToDate(dto.getParTglLahir()) );
        this.setParTempatMenikah( dto.getParTempatMenikah());
        this.setParTglMenikah( DateUtil.stringToDate( dto.getParTglMenikah() ));
        this.setParTglLahirPenerimaMp( DateUtil.stringToDate(dto.getParTglLahirPenerimaMp()) );
        this.setParTglMeninggal( DateUtil.stringToDate(dto.getParTglMeninggal()) );
        this.setParMpBulananEuro( Long.valueOf( dto.getParMpBulananEuro() ));
        this.setParAlamat( dto.getParAlamat());
        this.setParKota( dto.getParKota());
        this.setParKodePos( dto.getParKodePos());
        this.setParNomorRekening( dto.getParNomorRekening() );
        this.setParNamaRekening( dto.getParNamaRekening());
        this.setParIdBankNf( Long.valueOf( dto.getParIdBankNf()) );
        this.setParSwiftCode( dto.getParSwiftCode());
        this.setParIbanCode( dto.getParIbanCode());
        this.setParPersNs( dto.getParPersNs());
        this.setParKeterangan( dto.getParKeterangan());
        this.setParStatusEksekusi( dto.getParStatusEksekusi());
        this.setParMsg( dto.getParMsg());
    }

}