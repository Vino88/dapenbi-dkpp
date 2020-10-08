package com.dapenbi.dkpp.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MutasiSuskelFormDto extends BaseFormDto {
    private Long roleId;
    private String compName;
    private String userName;
    private Long idMutasiPensiun;
    private String periodeMutasi;
    private Date tglMutasi;
    private String nip;
    private String namaPeserta;
    private String idPenerimaMp;
    private String namaPenerimaMp;
    private Long idKategoriPenerimaMp;
    private String namaKategoriPenerimaMp;
    private Long idSuskel;
    private String namaSuskel;
    private Long idSuskelBaru;
    private String namaSuskelBaru;
    private Long idKategoriCatatan;
    private String namaKategoriCatatan;
    private String keterangan;
    private Long idValidasi;
    private String namaValidasi;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

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

    public String getPeriodeMutasi() {
        return periodeMutasi;
    }

    public void setPeriodeMutasi(String periodeMutasi) {
        this.periodeMutasi = periodeMutasi;
    }

    public Date getTglMutasi() {
        return tglMutasi;
    }

    public void setTglMutasi(Date tglMutasi) {
        this.tglMutasi = tglMutasi;
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

    public Long getIdKategoriPenerimaMp() {
        return idKategoriPenerimaMp;
    }

    public void setIdKategoriPenerimaMp(Long idKategoriPenerimaMp) {
        this.idKategoriPenerimaMp = idKategoriPenerimaMp;
    }

    public String getNamaKategoriPenerimaMp() {
        return namaKategoriPenerimaMp;
    }

    public void setNamaKategoriPenerimaMp(String namaKategoriPenerimaMp) {
        this.namaKategoriPenerimaMp = namaKategoriPenerimaMp;
    }

    public Long getIdSuskel() {
        return idSuskel;
    }

    public void setIdSuskel(Long idSuskel) {
        this.idSuskel = idSuskel;
    }

    public String getNamaSuskel() {
        return namaSuskel;
    }

    public void setNamaSuskel(String namaSuskel) {
        this.namaSuskel = namaSuskel;
    }

    public Long getIdSuskelBaru() {
        return idSuskelBaru;
    }

    public void setIdSuskelBaru(Long idSuskelBaru) {
        this.idSuskelBaru = idSuskelBaru;
    }

    public String getNamaSuskelBaru() {
        return namaSuskelBaru;
    }

    public void setNamaSuskelBaru(String namaSuskelBaru) {
        this.namaSuskelBaru = namaSuskelBaru;
    }

    public Long getIdKategoriCatatan() {
        return idKategoriCatatan;
    }

    public void setIdKategoriCatatan(Long idKategoriCatatan) {
        this.idKategoriCatatan = idKategoriCatatan;
    }

    public String getNamaKategoriCatatan() {
        return namaKategoriCatatan;
    }

    public void setNamaKategoriCatatan(String namaKategoriCatatan) {
        this.namaKategoriCatatan = namaKategoriCatatan;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Long getIdValidasi() {
        return idValidasi;
    }

    public void setIdValidasi(Long idValidasi) {
        this.idValidasi = idValidasi;
    }

    public String getNamaValidasi() {
        return namaValidasi;
    }

    public void setNamaValidasi(String namaValidasi) {
        this.namaValidasi = namaValidasi;
    }

    public void fromPlainText(MutasiSuskelPlainTextFormDto plainDto){
        this.setCompName(plainDto.getCompName());
        this.setUserName(plainDto.getUserName());
        this.setIdMutasiPensiun(plainDto.getIdMutasiPensiun().equals("")?null:Long.valueOf(plainDto.getIdMutasiPensiun()));
        this.setPeriodeMutasi(plainDto.getPeriodeMutasi());
        this.setTglMutasi(stringToDate(plainDto.getTglMutasi()));
        this.setNip(plainDto.getNip());
        this.setNamaPeserta(plainDto.getNamaPeserta());
        this.setIdPenerimaMp(plainDto.getIdPenerimaMp());
        this.setNamaPenerimaMp(plainDto.getNamaPenerimaMp());
        this.setIdKategoriPenerimaMp(plainDto.getIdKategoriPenerimaMp().equals("")?null:Long.valueOf(plainDto.getIdKategoriPenerimaMp()));
        this.setNamaKategoriPenerimaMp(plainDto.getNamaKategoriPenerimaMp());
        this.setIdSuskel(plainDto.getIdSuskel().equals("")?null:Long.valueOf(plainDto.getIdSuskel()));
        this.setNamaSuskel(plainDto.getNamaSuskel());
        this.setIdSuskelBaru(plainDto.getIdSuskelBaru().equals("")?null:Long.valueOf(plainDto.getIdSuskelBaru()));
        this.setNamaSuskelBaru(plainDto.getNamaSuskelBaru());
        this.setIdKategoriCatatan(plainDto.getIdKategoriCatatan().equals("")?null: Long.valueOf(plainDto.getIdKategoriCatatan()));
        this.setNamaKategoriCatatan(plainDto.getNamaKategoriCatatan());
        this.setKeterangan(plainDto.getKeterangan());
        this.setIdValidasi(plainDto.getIdValidasi().equals("")?null:Long.valueOf(plainDto.getIdValidasi()));
        this.setNamaValidasi(plainDto.getNamaValidasi());
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
