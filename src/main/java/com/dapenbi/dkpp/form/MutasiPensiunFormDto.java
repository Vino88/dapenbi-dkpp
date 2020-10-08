package com.dapenbi.dkpp.form;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class MutasiPensiunFormDto extends BaseFormDto {

    private String idKategoriMutasi;

    private Long mutasiId;

    private String periodeMutasi;

    private String tanggalInput;

    private String nip;

    private String nama;

    private Long agama;

    private String namaAgama;

    private Character jenisKelamin;

    private String namaJenisKelamin;

    private Long statusKawin;

    private Long golongan;

    private BigDecimal gajiPokokTerakhir;

    private BigDecimal upahVeteran;

    private String cabangKpwBI;

    private Map<String, String> penerimaMP;

    private List<Map<String, String>> dataKeluarga;

    private String tanggalSuratPengantarBI;

    private String nomorSuratPengantarBI;

    private String tanggalSKBI;

    private String nomorSKBI;

    private String userStamp;

    private String userValidasi;

    private String tglLahir;

    private String tglDicatatSebagaiPesertaDPHT;

    private String tglBekerjaDiBI;

    private String tglBerhentiBekerjaDiBI;

    private Long predikatPemberhentian;

    private String alasanHenti;

    private String tglMeninggal;

    private Long suskel;

    private String namaSuskel;

    private Long statusPengembalianMPS;

    private String jenisMP;

    private Long statusBayarMP;

    private Long pilihanUsiaBayarMP;

    private String tglTundaJatuhTempo;

    private String tglAwalBayarMP;

    private String tglMPBulan13;

    private String tglHentiBayar;

    private String namaPenerimaMP;

    private String tglLahirPenerimaMP;

    private String jenisKelaminPenerimaMP;

    private String namaJenisKelaminPenerimaMP;

    private String statusKelPenerimaPenerimaMP;

    private String namaStatusKelPenerimaPenerimaMP;

    private String tanggalSKDAPENBI;

    private String nomorSKDAPENBI;

    private Map isDalamNegeri;

    private Long provinsiPenerimaMP;

    private Long kotaPenerimaMP;

    private Long kecamatanPenerimaMP;

    private Long kelurahanPenerimaMP;

    private String kodePosPenerimaMP;

    private String alamatIndonesiaPenerimaMP;

    private String rtPenerimaMP;

    private String rwPenerimaMP;

    private String alamatLuarNegeriPenerimaMP;

    private Long negaraPenerimaMP;

    private String emailPenerimaMP;

    private String noHPPenerimaMP;

    private String noTlpPenerimaMP;

    private Long statusCatatan;

    private Long kategoriCatatan;

    private String catatan;

    private String usiaPesertaSaatBerhenti;

    private String usiaPesertaSaatBerhentiPembulatan;

    private String usiaPenerimaSaatDiBayar;

    private String usiaPenerimaSaatDiBayarPembulatan;

    private String masaKerjaSaatHenti;

    private String masaKerjaSaatHentiPembulatan;

    private String masaKerjaTambahan;

    private String masaKerjaTambahanPembulatan;

    private String masaKerjaVeteran;

    private String masaKerjaVeteranPembulatan;

    private String totalMasaKerja;

    private String totalMasaKerjaPembulatan;

    private String masaKerjaMP;

    private String faktorPengurang1;

    private String faktorPengurang2;

    private String faktorNS1;

    private String faktorNS2;

    private String PhDP1;

    private String PhDP2;

    private boolean typePembayaranMP;

    private String mpPerbulan;

    private String mpsPerbulanSetelah20Persen;

    private String mps20persen;

    private String mpsPerbulanSetelah10Juta;

    private String mps10Juta;

    private String mpyd;

    private String mpBulanKe13;

    private String mpKurangBayar;

    private String periodeMutasiMp;

    private String mps100Persen;

    private String mps100PersenPembulatan;

    private Boolean isJatuhTempoDibayar;

    private String idKategoriPenerimaMp;

    private Boolean isPensiunTunda;

    private String namaValidasi;

    private String tglMutasi;

    public Long getMutasiId() {
        return mutasiId;
    }

    public void setMutasiId(Long mutasiId) {
        this.mutasiId = mutasiId;
    }

    public String getPeriodeMutasi() {
        return periodeMutasi;
    }

    public void setPeriodeMutasi(String periodeMutasi) {
        this.periodeMutasi = periodeMutasi;
    }

    public String getTanggalInput() {
        return tanggalInput;
    }

    public void setTanggalInput(String tanggalInput) {
        this.tanggalInput = tanggalInput;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Long getAgama() {
        return agama;
    }

    public void setAgama(Long agama) {
        this.agama = agama;
    }

    public String getNamaAgama() {
        return namaAgama;
    }

    public void setNamaAgama(String namaAgama) {
        this.namaAgama = namaAgama;
    }

    public Character getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(Character jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getNamaJenisKelamin() {
        return namaJenisKelamin;
    }

    public void setNamaJenisKelamin(String namaJenisKelamin) {
        this.namaJenisKelamin = namaJenisKelamin;
    }

    public Long getStatusKawin() {
        return statusKawin;
    }

    public void setStatusKawin(Long statusKawin) {
        this.statusKawin = statusKawin;
    }

    public Long getGolongan() {
        return golongan;
    }

    public void setGolongan(Long golongan) {
        this.golongan = golongan;
    }

    public BigDecimal getGajiPokokTerakhir() {
        return gajiPokokTerakhir;
    }

    public void setGajiPokokTerakhir(BigDecimal gajiPokokTerakhir) {
        this.gajiPokokTerakhir = gajiPokokTerakhir;
    }

    public BigDecimal getUpahVeteran() {
        return upahVeteran;
    }

    public void setUpahVeteran(BigDecimal upahVeteran) {
        this.upahVeteran = upahVeteran;
    }

    public String getCabangKpwBI() {
        return cabangKpwBI;
    }

    public void setCabangKpwBI(String cabangKpwBI) {
        this.cabangKpwBI = cabangKpwBI;
    }

    public Map<String, String> getPenerimaMP() {
        return penerimaMP;
    }

    public void setPenerimaMP(Map<String, String> penerimaMP) {
        this.penerimaMP = penerimaMP;
    }

    public List<Map<String, String>> getDataKeluarga() {
        return dataKeluarga;
    }

    public void setDataKeluarga(List<Map<String, String>> dataKeluarga) {
        this.dataKeluarga = dataKeluarga;
    }

    public String getTanggalSuratPengantarBI() {
        return tanggalSuratPengantarBI;
    }

    public void setTanggalSuratPengantarBI(String tanggalSuratPengantarBI) {
        this.tanggalSuratPengantarBI = tanggalSuratPengantarBI;
    }

    public String getNomorSuratPengantarBI() {
        return nomorSuratPengantarBI;
    }

    public void setNomorSuratPengantarBI(String nomorSuratPengantarBI) {
        this.nomorSuratPengantarBI = nomorSuratPengantarBI;
    }

    public String getTanggalSKBI() {
        return tanggalSKBI;
    }

    public void setTanggalSKBI(String tanggalSKBI) {
        this.tanggalSKBI = tanggalSKBI;
    }

    public String getNomorSKBI() {
        return nomorSKBI;
    }

    public void setNomorSKBI(String nomorSKBI) {
        this.nomorSKBI = nomorSKBI;
    }

    public String getUserStamp() {
        return userStamp;
    }

    public void setUserStamp(String userStamp) {
        this.userStamp = userStamp;
    }

    public String getUserValidasi() {
        return userValidasi;
    }

    public void setUserValidasi(String userValidasi) {
        this.userValidasi = userValidasi;
    }

    public String getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(String tglLahir) {
        this.tglLahir = tglLahir;
    }

    public String getTglDicatatSebagaiPesertaDPHT() {
        return tglDicatatSebagaiPesertaDPHT;
    }

    public void setTglDicatatSebagaiPesertaDPHT(String tglDicatatSebagaiPesertaDPHT) {
        this.tglDicatatSebagaiPesertaDPHT = tglDicatatSebagaiPesertaDPHT;
    }

    public String getTglBekerjaDiBI() {
        return tglBekerjaDiBI;
    }

    public void setTglBekerjaDiBI(String tglBekerjaDiBI) {
        this.tglBekerjaDiBI = tglBekerjaDiBI;
    }

    public String getTglBerhentiBekerjaDiBI() {
        return tglBerhentiBekerjaDiBI;
    }

    public void setTglBerhentiBekerjaDiBI(String tglBerhentiBekerjaDiBI) {
        this.tglBerhentiBekerjaDiBI = tglBerhentiBekerjaDiBI;
    }

    public Long getPredikatPemberhentian() {
        return predikatPemberhentian;
    }

    public void setPredikatPemberhentian(Long predikatPemberhentian) {
        this.predikatPemberhentian = predikatPemberhentian;
    }

    public String getAlasanHenti() {
        return alasanHenti;
    }

    public void setAlasanHenti(String alasanHenti) {
        this.alasanHenti = alasanHenti;
    }

    public String getTglMeninggal() {
        return tglMeninggal;
    }

    public void setTglMeninggal(String tglMeninggal) {
        this.tglMeninggal = tglMeninggal;
    }

    public Long getSuskel() {
        return suskel;
    }

    public void setSuskel(Long suskel) {
        this.suskel = suskel;
    }

    public String getNamaSuskel() {
        return namaSuskel;
    }

    public void setNamaSuskel(String namaSuskel) {
        this.namaSuskel = namaSuskel;
    }

    public Long getStatusPengembalianMPS() {
        return statusPengembalianMPS;
    }

    public void setStatusPengembalianMPS(Long statusPengembalianMPS) {
        this.statusPengembalianMPS = statusPengembalianMPS;
    }

    public String getJenisMP() {
        return jenisMP;
    }

    public void setJenisMP(String jenisMP) {
        this.jenisMP = jenisMP;
    }

    public Long getStatusBayarMP() {
        return statusBayarMP;
    }

    public void setStatusBayarMP(Long statusBayarMP) {
        this.statusBayarMP = statusBayarMP;
    }

    public Long getPilihanUsiaBayarMP() {
        return pilihanUsiaBayarMP;
    }

    public void setPilihanUsiaBayarMP(Long pilihanUsiaBayarMP) {
        this.pilihanUsiaBayarMP = pilihanUsiaBayarMP;
    }

    public String getTglTundaJatuhTempo() {
        return tglTundaJatuhTempo;
    }

    public void setTglTundaJatuhTempo(String tglTundaJatuhTempo) {
        this.tglTundaJatuhTempo = tglTundaJatuhTempo;
    }

    public String getTglAwalBayarMP() {
        return tglAwalBayarMP;
    }

    public void setTglAwalBayarMP(String tglAwalBayarMP) {
        this.tglAwalBayarMP = tglAwalBayarMP;
    }

    public String getTglMPBulan13() {
        return tglMPBulan13;
    }

    public void setTglMPBulan13(String tglMPBulan13) {
        this.tglMPBulan13 = tglMPBulan13;
    }

    public String getTglHentiBayar() {
        return tglHentiBayar;
    }

    public void setTglHentiBayar(String tglHentiBayar) {
        this.tglHentiBayar = tglHentiBayar;
    }

    public String getNamaPenerimaMP() {
        return namaPenerimaMP;
    }

    public void setNamaPenerimaMP(String namaPenerimaMP) {
        this.namaPenerimaMP = namaPenerimaMP;
    }

    public String getTglLahirPenerimaMP() {
        return tglLahirPenerimaMP;
    }

    public void setTglLahirPenerimaMP(String tglLahirPenerimaMP) {
        this.tglLahirPenerimaMP = tglLahirPenerimaMP;
    }

    public String getJenisKelaminPenerimaMP() {
        return jenisKelaminPenerimaMP;
    }

    public void setJenisKelaminPenerimaMP(String jenisKelaminPenerimaMP) {
        this.jenisKelaminPenerimaMP = jenisKelaminPenerimaMP;
    }

    public String getNamaJenisKelaminPenerimaMP() {
        return namaJenisKelaminPenerimaMP;
    }

    public void setNamaJenisKelaminPenerimaMP(String namaJenisKelaminPenerimaMP) {
        this.namaJenisKelaminPenerimaMP = namaJenisKelaminPenerimaMP;
    }

    public String getStatusKelPenerimaPenerimaMP() {
        return statusKelPenerimaPenerimaMP;
    }

    public void setStatusKelPenerimaPenerimaMP(String statusKelPenerimaPenerimaMP) {
        this.statusKelPenerimaPenerimaMP = statusKelPenerimaPenerimaMP;
    }

    public String getNamaStatusKelPenerimaPenerimaMP() {
        return namaStatusKelPenerimaPenerimaMP;
    }

    public void setNamaStatusKelPenerimaPenerimaMP(String namaStatusKelPenerimaPenerimaMP) {
        this.namaStatusKelPenerimaPenerimaMP = namaStatusKelPenerimaPenerimaMP;
    }

    public String getTanggalSKDAPENBI() {
        return tanggalSKDAPENBI;
    }

    public void setTanggalSKDAPENBI(String tanggalSKDAPENBI) {
        this.tanggalSKDAPENBI = tanggalSKDAPENBI;
    }

    public String getNomorSKDAPENBI() {
        return nomorSKDAPENBI;
    }

    public void setNomorSKDAPENBI(String nomorSKDAPENBI) {
        this.nomorSKDAPENBI = nomorSKDAPENBI;
    }

    public Map getIsDalamNegeri() {
        return isDalamNegeri;
    }

    public void setIsDalamNegeri(Map isDalamNegeri) {
        this.isDalamNegeri = isDalamNegeri;
    }

    public Long getProvinsiPenerimaMP() {
        return provinsiPenerimaMP;
    }

    public void setProvinsiPenerimaMP(Long provinsiPenerimaMP) {
        this.provinsiPenerimaMP = provinsiPenerimaMP;
    }

    public Long getKotaPenerimaMP() {
        return kotaPenerimaMP;
    }

    public void setKotaPenerimaMP(Long kotaPenerimaMP) {
        this.kotaPenerimaMP = kotaPenerimaMP;
    }

    public Long getKecamatanPenerimaMP() {
        return kecamatanPenerimaMP;
    }

    public void setKecamatanPenerimaMP(Long kecamatanPenerimaMP) {
        this.kecamatanPenerimaMP = kecamatanPenerimaMP;
    }

    public Long getKelurahanPenerimaMP() {
        return kelurahanPenerimaMP;
    }

    public void setKelurahanPenerimaMP(Long kelurahanPenerimaMP) {
        this.kelurahanPenerimaMP = kelurahanPenerimaMP;
    }

    public String getKodePosPenerimaMP() {
        return kodePosPenerimaMP;
    }

    public void setKodePosPenerimaMP(String kodePosPenerimaMP) {
        this.kodePosPenerimaMP = kodePosPenerimaMP;
    }

    public String getAlamatIndonesiaPenerimaMP() {
        return alamatIndonesiaPenerimaMP;
    }

    public void setAlamatIndonesiaPenerimaMP(String alamatIndonesiaPenerimaMP) {
        this.alamatIndonesiaPenerimaMP = alamatIndonesiaPenerimaMP;
    }

    public String getRtPenerimaMP() {
        return rtPenerimaMP;
    }

    public void setRtPenerimaMP(String rtPenerimaMP) {
        this.rtPenerimaMP = rtPenerimaMP;
    }

    public String getRwPenerimaMP() {
        return rwPenerimaMP;
    }

    public void setRwPenerimaMP(String rwPenerimaMP) {
        this.rwPenerimaMP = rwPenerimaMP;
    }

    public String getAlamatLuarNegeriPenerimaMP() {
        return alamatLuarNegeriPenerimaMP;
    }

    public void setAlamatLuarNegeriPenerimaMP(String alamatLuarNegeriPenerimaMP) {
        this.alamatLuarNegeriPenerimaMP = alamatLuarNegeriPenerimaMP;
    }

    public Long getNegaraPenerimaMP() {
        return negaraPenerimaMP;
    }

    public void setNegaraPenerimaMP(Long negaraPenerimaMP) {
        this.negaraPenerimaMP = negaraPenerimaMP;
    }

    public String getEmailPenerimaMP() {
        return emailPenerimaMP;
    }

    public void setEmailPenerimaMP(String emailPenerimaMP) {
        this.emailPenerimaMP = emailPenerimaMP;
    }

    public String getNoHPPenerimaMP() {
        return noHPPenerimaMP;
    }

    public void setNoHPPenerimaMP(String noHPPenerimaMP) {
        this.noHPPenerimaMP = noHPPenerimaMP;
    }

    public String getNoTlpPenerimaMP() {
        return noTlpPenerimaMP;
    }

    public void setNoTlpPenerimaMP(String noTlpPenerimaMP) {
        this.noTlpPenerimaMP = noTlpPenerimaMP;
    }

    public Long getStatusCatatan() {
        return statusCatatan;
    }

    public void setStatusCatatan(Long statusCatatan) {
        this.statusCatatan = statusCatatan;
    }

    public Long getKategoriCatatan() {
        return kategoriCatatan;
    }

    public void setKategoriCatatan(Long kategoriCatatan) {
        this.kategoriCatatan = kategoriCatatan;
    }

    public String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }

    public String getUsiaPesertaSaatBerhenti() {
        return usiaPesertaSaatBerhenti;
    }

    public void setUsiaPesertaSaatBerhenti(String usiaPesertaSaatBerhenti) {
        this.usiaPesertaSaatBerhenti = usiaPesertaSaatBerhenti;
    }

    public String getUsiaPesertaSaatBerhentiPembulatan() {
        return usiaPesertaSaatBerhentiPembulatan;
    }

    public void setUsiaPesertaSaatBerhentiPembulatan(String usiaPesertaSaatBerhentiPembulatan) {
        this.usiaPesertaSaatBerhentiPembulatan = usiaPesertaSaatBerhentiPembulatan;
    }

    public String getUsiaPenerimaSaatDiBayar() {
        return usiaPenerimaSaatDiBayar;
    }

    public void setUsiaPenerimaSaatDiBayar(String usiaPenerimaSaatDiBayar) {
        this.usiaPenerimaSaatDiBayar = usiaPenerimaSaatDiBayar;
    }

    public String getUsiaPenerimaSaatDiBayarPembulatan() {
        return usiaPenerimaSaatDiBayarPembulatan;
    }

    public void setUsiaPenerimaSaatDiBayarPembulatan(String usiaPenerimaSaatDiBayarPembulatan) {
        this.usiaPenerimaSaatDiBayarPembulatan = usiaPenerimaSaatDiBayarPembulatan;
    }

    public String getMasaKerjaSaatHenti() {
        return masaKerjaSaatHenti;
    }

    public void setMasaKerjaSaatHenti(String masaKerjaSaatHenti) {
        this.masaKerjaSaatHenti = masaKerjaSaatHenti;
    }

    public String getMasaKerjaSaatHentiPembulatan() {
        return masaKerjaSaatHentiPembulatan;
    }

    public void setMasaKerjaSaatHentiPembulatan(String masaKerjaSaatHentiPembulatan) {
        this.masaKerjaSaatHentiPembulatan = masaKerjaSaatHentiPembulatan;
    }

    public String getMasaKerjaTambahan() {
        return masaKerjaTambahan;
    }

    public void setMasaKerjaTambahan(String masaKerjaTambahan) {
        this.masaKerjaTambahan = masaKerjaTambahan;
    }

    public String getMasaKerjaTambahanPembulatan() {
        return masaKerjaTambahanPembulatan;
    }

    public void setMasaKerjaTambahanPembulatan(String masaKerjaTambahanPembulatan) {
        this.masaKerjaTambahanPembulatan = masaKerjaTambahanPembulatan;
    }

    public String getMasaKerjaVeteran() {
        return masaKerjaVeteran;
    }

    public void setMasaKerjaVeteran(String masaKerjaVeteran) {
        this.masaKerjaVeteran = masaKerjaVeteran;
    }

    public String getMasaKerjaVeteranPembulatan() {
        return masaKerjaVeteranPembulatan;
    }

    public void setMasaKerjaVeteranPembulatan(String masaKerjaVeteranPembulatan) {
        this.masaKerjaVeteranPembulatan = masaKerjaVeteranPembulatan;
    }

    public String getTotalMasaKerja() {
        return totalMasaKerja;
    }

    public void setTotalMasaKerja(String totalMasaKerja) {
        this.totalMasaKerja = totalMasaKerja;
    }

    public String getTotalMasaKerjaPembulatan() {
        return totalMasaKerjaPembulatan;
    }

    public void setTotalMasaKerjaPembulatan(String totalMasaKerjaPembulatan) {
        this.totalMasaKerjaPembulatan = totalMasaKerjaPembulatan;
    }

    public String getMasaKerjaMP() {
        return masaKerjaMP;
    }

    public void setMasaKerjaMP(String masaKerjaMP) {
        this.masaKerjaMP = masaKerjaMP;
    }

    public String getFaktorPengurang1() {
        return faktorPengurang1;
    }

    public void setFaktorPengurang1(String faktorPengurang1) {
        this.faktorPengurang1 = faktorPengurang1;
    }

    public String getFaktorPengurang2() {
        return faktorPengurang2;
    }

    public void setFaktorPengurang2(String faktorPengurang2) {
        this.faktorPengurang2 = faktorPengurang2;
    }

    public String getFaktorNS1() {
        return faktorNS1;
    }

    public void setFaktorNS1(String faktorNS1) {
        this.faktorNS1 = faktorNS1;
    }

    public String getFaktorNS2() {
        return faktorNS2;
    }

    public void setFaktorNS2(String faktorNS2) {
        this.faktorNS2 = faktorNS2;
    }

    public String getPhDP1() {
        return PhDP1;
    }

    public void setPhDP1(String phDP1) {
        PhDP1 = phDP1;
    }

    public String getPhDP2() {
        return PhDP2;
    }

    public void setPhDP2(String phDP2) {
        PhDP2 = phDP2;
    }

    public boolean getIsTypePembayaranMP() {
        return typePembayaranMP;
    }

    public void setIsTypePembayaranMP(boolean typePembayaranMP) {
        this.typePembayaranMP = typePembayaranMP;
    }

    public String getMpPerbulan() {
        return mpPerbulan;
    }

    public void setMpPerbulan(String mpPerbulan) {
        this.mpPerbulan = mpPerbulan;
    }

    public String getMpsPerbulanSetelah20Persen() {
        return mpsPerbulanSetelah20Persen;
    }

    public void setMpsPerbulanSetelah20Persen(String mpsPerbulanSetelah20Persen) {
        this.mpsPerbulanSetelah20Persen = mpsPerbulanSetelah20Persen;
    }

    public String getMps20persen() {
        return mps20persen;
    }

    public void setMps20persen(String mps20persen) {
        this.mps20persen = mps20persen;
    }

    public String getMpsPerbulanSetelah10Juta() {
        return mpsPerbulanSetelah10Juta;
    }

    public void setMpsPerbulanSetelah10Juta(String mpsPerbulanSetelah10Juta) {
        this.mpsPerbulanSetelah10Juta = mpsPerbulanSetelah10Juta;
    }

    public String getMps10Juta() {
        return mps10Juta;
    }

    public void setMps10Juta(String mps10Juta) {
        this.mps10Juta = mps10Juta;
    }

    public String getMpyd() {
        return mpyd;
    }

    public void setMpyd(String mpyd) {
        this.mpyd = mpyd;
    }

    public String getMpBulanKe13() {
        return mpBulanKe13;
    }

    public void setMpBulanKe13(String mpBulanKe13) {
        this.mpBulanKe13 = mpBulanKe13;
    }

    public String getMpKurangBayar() {
        return mpKurangBayar;
    }

    public void setMpKurangBayar(String mpKurangBayar) {
        this.mpKurangBayar = mpKurangBayar;
    }

    public String getPeriodeMutasiMp() {
        return periodeMutasiMp;
    }

    public void setPeriodeMutasiMp(String periodeMutasiMp) {
        this.periodeMutasiMp = periodeMutasiMp;
    }

    public String getMps100Persen() {
        return mps100Persen;
    }

    public void setMps100Persen(String mps100Persen) {
        this.mps100Persen = mps100Persen;
    }

    public String getMps100PersenPembulatan() {
        return mps100PersenPembulatan;
    }

    public void setMps100PersenPembulatan(String mps100PersenPembulatan) {
        this.mps100PersenPembulatan = mps100PersenPembulatan;
    }

    public Boolean getIsJatuhTempoDibayar() {
        return isJatuhTempoDibayar;
    }

    public void setIsJatuhTempoDibayar(Boolean jatuhTempoDibayar) {
        isJatuhTempoDibayar = jatuhTempoDibayar;
    }

    public String getIdKategoriPenerimaMp() {
        return idKategoriPenerimaMp;
    }

    public void setIdKategoriPenerimaMp(String idKategoriPenerimaMp) {
        this.idKategoriPenerimaMp = idKategoriPenerimaMp;
    }
    public Boolean getIsPensiunTunda() {
        return isPensiunTunda;
    }

    public void setIsPensiunTunda(Boolean pensiunTunda) {
        isPensiunTunda = pensiunTunda;
    }

    public String getNamaValidasi() {
        return namaValidasi;
    }

    public void setNamaValidasi(String namaValidasi) {
        this.namaValidasi = namaValidasi;
    }

    public String getIdKategoriMutasi() {
        return idKategoriMutasi;
    }

    public void setIdKategoriMutasi(String idKategoriMutasi) {
        this.idKategoriMutasi = idKategoriMutasi;
    }

    public String getTglMutasi() {
        return tglMutasi;
    }

    public void setTglMutasi(String tglMutasi) {
        this.tglMutasi = tglMutasi;
    }
}
