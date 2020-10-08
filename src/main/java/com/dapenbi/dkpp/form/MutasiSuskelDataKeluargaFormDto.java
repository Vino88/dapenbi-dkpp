package com.dapenbi.dkpp.form;

import com.dapenbi.dkpp.util.DateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MutasiSuskelDataKeluargaFormDto extends BaseFormDto{
    private String compName;
    private String userName;
    private Long idMutasiPensiun;
    private String idKeluarga;
    private String nip;
    private String namaKeluarga;
    private Long idKategoriPenerima;
    private String namaKategoriPenerima;
    private Character jenisKelamin;
    private String tempatLahir;
    private Date tglLahir;
    private Date tglMenikah;
    private Date tglCerai;
    private Date tglUsia25;
    private Date tglWafat;
    private String tempatMenikah;
    private String tempatWafat;
    private Character isPenerimaMp;
    private Long idStKawinPenerimaMp;
    private String namaStKawinPenerimaMp;
    private String action;

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getIdMutasiPensiun() {
        return idMutasiPensiun;
    }

    public void setIdMutasiPensiun(Long idMutasiPensiun) {
        this.idMutasiPensiun = idMutasiPensiun;
    }

    public String getIdKeluarga() {
        return idKeluarga;
    }

    public void setIdKeluarga(String idKeluarga) {
        this.idKeluarga = idKeluarga;
    }

    public Date getTglMenikah() {
        return tglMenikah;
    }

    public void setTglMenikah(Date tglMenikah) {
        this.tglMenikah = tglMenikah;
    }

    public Date getTglCerai() {
        return tglCerai;
    }

    public void setTglCerai(Date tglCerai) {
        this.tglCerai = tglCerai;
    }

    public Date getTglWafat() {
        return tglWafat;
    }

    public void setTglWafat(Date tglWafat) {
        this.tglWafat = tglWafat;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNamaKeluarga() {
        return namaKeluarga;
    }

    public void setNamaKeluarga(String namaKeluarga) {
        this.namaKeluarga = namaKeluarga;
    }

    public Long getIdKategoriPenerima() {
        return idKategoriPenerima;
    }

    public void setIdKategoriPenerima(Long idKategoriPenerima) {
        this.idKategoriPenerima = idKategoriPenerima;
    }

    public String getNamaKategoriPenerima() {
        return namaKategoriPenerima;
    }

    public void setNamaKategoriPenerima(String namaKategoriPenerima) {
        this.namaKategoriPenerima = namaKategoriPenerima;
    }

    public Character getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(Character jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public Date getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(Date tglLahir) {
        this.tglLahir = tglLahir;
    }

    public Date getTglUsia25() {
        return tglUsia25;
    }

    public void setTglUsia25(Date tglUsia25) {
        this.tglUsia25 = tglUsia25;
    }

    public String getTempatMenikah() {
        return tempatMenikah;
    }

    public void setTempatMenikah(String tempatMenikah) {
        this.tempatMenikah = tempatMenikah;
    }

    public String getTempatWafat() {
        return tempatWafat;
    }

    public void setTempatWafat(String tempatWafat) {
        this.tempatWafat = tempatWafat;
    }

    public Character getIsPenerimaMp() {
        return isPenerimaMp;
    }

    public void setIsPenerimaMp(Character isPenerimaMp) {
        this.isPenerimaMp = isPenerimaMp;
    }

    public Long getIdStKawinPenerimaMp() {
        return idStKawinPenerimaMp;
    }

    public void setIdStKawinPenerimaMp(Long idStKawinPenerimaMp) {
        this.idStKawinPenerimaMp = idStKawinPenerimaMp;
    }

    public String getNamaStKawinPenerimaMp() {
        return namaStKawinPenerimaMp;
    }

    public void setNamaStKawinPenerimaMp(String namaStKawinPenerimaMp) {
        this.namaStKawinPenerimaMp = namaStKawinPenerimaMp;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void fromPlainText(MutasiSuskelDataKeluargaPtFormDto plainDto){
        this.setCompName(plainDto.getCompName());
        this.setUserName(plainDto.getUserName());
        this.setIdMutasiPensiun(plainDto.getIdMutasiPensiun().equals("")?null:Long.valueOf(plainDto.getIdMutasiPensiun()));
        this.setIdKategoriPenerima(plainDto.getIdKategoriPenerima().equals("")?null:Long.valueOf(plainDto.getIdKategoriPenerima()));
        this.setIdStKawinPenerimaMp(plainDto.getIdStKawinPenerimaMp().equals("")?null:Long.valueOf(plainDto.getIdStKawinPenerimaMp()));
        this.setIdKeluarga(plainDto.getIdKeluarga());
        this.setNip(plainDto.getNip());
        this.setNamaKeluarga(plainDto.getNamaKeluarga());
        this.setNamaKategoriPenerima(plainDto.getNamaKategoriPenerima());
        this.setJenisKelamin(plainDto.getJenisKelamin());
        this.setTempatLahir(plainDto.getTempatLahir());
        this.setTempatMenikah(plainDto.getTempatMenikah());
        this.setTempatWafat(plainDto.getTempatWafat());
        this.setIsPenerimaMp(plainDto.getIsPenerimaMp());
        this.setNamaStKawinPenerimaMp(plainDto.getNamaStKawinPenerimaMp());
        this.setTglMenikah(DateUtil.stringToDate(plainDto.getTglMenikah(),"dd/MM/yyyy"));
        this.setTglLahir(DateUtil.stringToDate(plainDto.getTglLahir(),"dd/MM/yyyy"));
        this.setTglUsia25(DateUtil.stringToDate(plainDto.getTglUsia25(),"dd/MM/yyyy"));
        this.setTglCerai(DateUtil.stringToDate(plainDto.getTglCerai(),"dd/MM/yyyy"));
        this.setTglWafat(DateUtil.stringToDate(plainDto.getTglWafat(),"dd/MM/yyyy"));
        this.setAction(plainDto.getAction());

    }

    private Date stringToDate(String dateInString){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        try {

            Date date = formatter.parse(dateInString);
            return date;

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
