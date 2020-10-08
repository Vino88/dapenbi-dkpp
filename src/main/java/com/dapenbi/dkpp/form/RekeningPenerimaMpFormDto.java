package com.dapenbi.dkpp.form;

import java.util.Collection;
import java.util.Map;

public class RekeningPenerimaMpFormDto {

    public Map getActive() {
        return active;
    }

    public void setActive(Map active) {
        this.active = active;
    }

    private Map active;
    private String nip;
    private String nomorRekening;
    private String namaRekening;
    private String namaPeserta;
    private String idPenerimaMp;
    private String namaPenerimaMp;
    private Long idKategoriPenerima;
    private String namaKategoriPenerima;
    private Long idBank;
    private String jenisBank;
    private String namaCabangBank;


    public RekeningPenerimaMpFormDto() {
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

    public Long getIdBank() {
        return idBank;
    }

    public void setIdBank(Long idBank) {
        this.idBank = idBank;
    }

    public String getJenisBank() {
        return jenisBank;
    }

    public void setJenisBank(String jenisBank) {
        this.jenisBank = jenisBank;
    }

    public String getNamaCabangBank() {
        return namaCabangBank;
    }

    public void setNamaCabangBank(String namaCabangBank) {
        this.namaCabangBank = namaCabangBank;
    }

    public String getNamaRekening() {
        return namaRekening;
    }

    public void setNamaRekening(String namaRekening) {
        this.namaRekening = namaRekening;
    }

    public String getNomorRekening() {
        return nomorRekening;
    }

    public void setNomorRekening(String nomorRekening) {
        this.nomorRekening = nomorRekening;
    }

}
