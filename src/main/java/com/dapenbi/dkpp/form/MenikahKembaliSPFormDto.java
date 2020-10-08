package com.dapenbi.dkpp.form;

import com.dapenbi.dkpp.util.DateUtil;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MenikahKembaliSPFormDto extends BaseFormDto {
    private Long roleId;
    private String compName;
    private String userName;
    private Long parIdMutasi;
    private String parKodeMutasi;
    private String parPeriodeMutasi;
    private Date parTglMutasi;
    private String parNip;
    private String parNamaPesertaUpdate;
    private Long parIdAgamaUpdate;
    private String parNamaAgamaUpdate;
    private Long parIdGolonganUpdate;
    private String parNamaGolonganUpdate;
    private BigDecimal parPhdp;
    private String parIdKantorBayarUpdate;
    private String parNamaKantorBayarUpdate;
    private Date parTglSpBiUpdate;
    private String parNoSpBiUpdate;
    private Date parTglSkBiUpdate;
    private String parNoSkBiUpdate;
    private Character parAlmtIsDalamnegeriUpdate;
    private Long parIdProvinsiUpdate;
    private String parNamaProvinsiUpdate;
    private Long parIdKotaKabUpdate;
    private String parNamaKotaKabUpdate;
    private Long parIdKecamatanUpdate;
    private String parNamaKecamatanUpdate;
    private Long parIdKelurahanUpdate;
    private String parNamaKelurahanUpdate;
    private String parKodePosUpdate;
    private String parAlamatLengkapUpdate;
    private String parNoHpUpdate;
    private String parNoTlpUpdate;
    private String parEmailUpdate;
    private String parRtUpdate;
    private String parRwUpdate;
    private Long parIdNegaraUpdate;
    private String parNamaNegaraUpdate;
    private String parIdPenerimampLama;
    private String parNamaPenerimamplamaUpdate;
    private Long parIdKatPenerimampLama;
    private Date parTglNikahPenerimamplama;
    private Date parTglInfnkhPenerimamplama;
    private String parIdPenerimaMpBaru;
    private String parNamaPenerimaMpBaru;
    private Long parIdKatPenerimampBaru;
    private String parNamaKatPenerimampBaru;
    private Character parJkPenerimampBaru;
    private Date parTglLhrPenerimampBaru;
    private Long parIdKawinPenerimampBaru;
    private String parNamaKawinPenerimampBaru;
    private Long parIdSuskelBaru;
    private String parNamaSuskelBaru;
    private Date parTglBulan13;
    private BigDecimal parLebihBayarNominal;
    private Long parLebihBayarJmlBulan;
    private BigDecimal parLebihBayarNominal13;
    private Long parLebihBayarJmlBulan13;
    private BigDecimal parNominalTerbayar;
    private BigDecimal parSaldoAkhirLebihBayar;
    private Long parIdStatusBayarUpdate;
    private String parNamaStatusBayarUpdate;
    private Date parTglHentiBayarUpdate;
    private Long parIdKategoriCatatan;
    private String parNamaKategoriCatatan;
    private String parKeterangan;
    private Long parIdValidasi;
    private String parNamaValidasi;

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

    public Long getParIdMutasi() {
        return parIdMutasi;
    }

    public void setParIdMutasi(Long parIdMutasi) {
        this.parIdMutasi = parIdMutasi;
    }

    public String getParKodeMutasi() {
        return parKodeMutasi;
    }

    public void setParKodeMutasi(String parKodeMutasi) {
        this.parKodeMutasi = parKodeMutasi;
    }

    public String getParPeriodeMutasi() {
        return parPeriodeMutasi;
    }

    public void setParPeriodeMutasi(String parPeriodeMutasi) {
        this.parPeriodeMutasi = parPeriodeMutasi;
    }

    public Date getParTglMutasi() {
        return parTglMutasi;
    }

    public void setParTglMutasi(Date parTglMutasi) {
        this.parTglMutasi = parTglMutasi;
    }

    public String getParNip() {
        return parNip;
    }

    public void setParNip(String parNip) {
        this.parNip = parNip;
    }

    public String getParNamaPesertaUpdate() {
        return parNamaPesertaUpdate;
    }

    public void setParNamaPesertaUpdate(String parNamaPesertaUpdate) {
        this.parNamaPesertaUpdate = parNamaPesertaUpdate;
    }

    public Long getParIdAgamaUpdate() {
        return parIdAgamaUpdate;
    }

    public void setParIdAgamaUpdate(Long parIdAgamaUpdate) {
        this.parIdAgamaUpdate = parIdAgamaUpdate;
    }

    public String getParNamaAgamaUpdate() {
        return parNamaAgamaUpdate;
    }

    public void setParNamaAgamaUpdate(String parNamaAgamaUpdate) {
        this.parNamaAgamaUpdate = parNamaAgamaUpdate;
    }

    public Long getParIdGolonganUpdate() {
        return parIdGolonganUpdate;
    }

    public void setParIdGolonganUpdate(Long parIdGolonganUpdate) {
        this.parIdGolonganUpdate = parIdGolonganUpdate;
    }

    public String getParNamaGolonganUpdate() {
        return parNamaGolonganUpdate;
    }

    public void setParNamaGolonganUpdate(String parNamaGolonganUpdate) {
        this.parNamaGolonganUpdate = parNamaGolonganUpdate;
    }

    public BigDecimal getParPhdp() {
        return parPhdp;
    }

    public void setParPhdp(BigDecimal parPhdp) {
        this.parPhdp = parPhdp;
    }

    public String getParIdKantorBayarUpdate() {
        return parIdKantorBayarUpdate;
    }

    public void setParIdKantorBayarUpdate(String parIdKantorBayarUpdate) {
        this.parIdKantorBayarUpdate = parIdKantorBayarUpdate;
    }

    public String getParNamaKantorBayarUpdate() {
        return parNamaKantorBayarUpdate;
    }

    public void setParNamaKantorBayarUpdate(String parNamaKantorBayarUpdate) {
        this.parNamaKantorBayarUpdate = parNamaKantorBayarUpdate;
    }

    public Date getParTglSpBiUpdate() {
        return parTglSpBiUpdate;
    }

    public void setParTglSpBiUpdate(Date parTglSpBiUpdate) {
        this.parTglSpBiUpdate = parTglSpBiUpdate;
    }

    public String getParNoSpBiUpdate() {
        return parNoSpBiUpdate;
    }

    public void setParNoSpBiUpdate(String parNoSpBiUpdate) {
        this.parNoSpBiUpdate = parNoSpBiUpdate;
    }

    public Date getParTglSkBiUpdate() {
        return parTglSkBiUpdate;
    }

    public void setParTglSkBiUpdate(Date parTglSkBiUpdate) {
        this.parTglSkBiUpdate = parTglSkBiUpdate;
    }

    public String getParNoSkBiUpdate() {
        return parNoSkBiUpdate;
    }

    public void setParNoSkBiUpdate(String parNoSkBiUpdate) {
        this.parNoSkBiUpdate = parNoSkBiUpdate;
    }

    public Character getParAlmtIsDalamnegeriUpdate() {
        return parAlmtIsDalamnegeriUpdate;
    }

    public void setParAlmtIsDalamnegeriUpdate(Character parAlmtIsDalamnegeriUpdate) {
        this.parAlmtIsDalamnegeriUpdate = parAlmtIsDalamnegeriUpdate;
    }

    public Long getParIdProvinsiUpdate() {
        return parIdProvinsiUpdate;
    }

    public void setParIdProvinsiUpdate(Long parIdProvinsiUpdate) {
        this.parIdProvinsiUpdate = parIdProvinsiUpdate;
    }

    public String getParNamaProvinsiUpdate() {
        return parNamaProvinsiUpdate;
    }

    public void setParNamaProvinsiUpdate(String parNamaProvinsiUpdate) {
        this.parNamaProvinsiUpdate = parNamaProvinsiUpdate;
    }

    public Long getParIdKotaKabUpdate() {
        return parIdKotaKabUpdate;
    }

    public void setParIdKotaKabUpdate(Long parIdKotaKabUpdate) {
        this.parIdKotaKabUpdate = parIdKotaKabUpdate;
    }

    public String getParNamaKotaKabUpdate() {
        return parNamaKotaKabUpdate;
    }

    public void setParNamaKotaKabUpdate(String parNamaKotaKabUpdate) {
        this.parNamaKotaKabUpdate = parNamaKotaKabUpdate;
    }

    public Long getParIdKecamatanUpdate() {
        return parIdKecamatanUpdate;
    }

    public void setParIdKecamatanUpdate(Long parIdKecamatanUpdate) {
        this.parIdKecamatanUpdate = parIdKecamatanUpdate;
    }

    public String getParNamaKecamatanUpdate() {
        return parNamaKecamatanUpdate;
    }

    public void setParNamaKecamatanUpdate(String parNamaKecamatanUpdate) {
        this.parNamaKecamatanUpdate = parNamaKecamatanUpdate;
    }

    public Long getParIdKelurahanUpdate() {
        return parIdKelurahanUpdate;
    }

    public void setParIdKelurahanUpdate(Long parIdKelurahanUpdate) {
        this.parIdKelurahanUpdate = parIdKelurahanUpdate;
    }

    public String getParNamaKelurahanUpdate() {
        return parNamaKelurahanUpdate;
    }

    public void setParNamaKelurahanUpdate(String parNamaKelurahanUpdate) {
        this.parNamaKelurahanUpdate = parNamaKelurahanUpdate;
    }

    public String getParKodePosUpdate() {
        return parKodePosUpdate;
    }

    public void setParKodePosUpdate(String parKodePosUpdate) {
        this.parKodePosUpdate = parKodePosUpdate;
    }

    public String getParAlamatLengkapUpdate() {
        return parAlamatLengkapUpdate;
    }

    public void setParAlamatLengkapUpdate(String parAlamatLengkapUpdate) {
        this.parAlamatLengkapUpdate = parAlamatLengkapUpdate;
    }

    public String getParNoHpUpdate() {
        return parNoHpUpdate;
    }

    public void setParNoHpUpdate(String parNoHpUpdate) {
        this.parNoHpUpdate = parNoHpUpdate;
    }

    public String getParNoTlpUpdate() {
        return parNoTlpUpdate;
    }

    public void setParNoTlpUpdate(String parNoTlpUpdate) {
        this.parNoTlpUpdate = parNoTlpUpdate;
    }

    public String getParEmailUpdate() {
        return parEmailUpdate;
    }

    public void setParEmailUpdate(String parEmailUpdate) {
        this.parEmailUpdate = parEmailUpdate;
    }

    public String getParRtUpdate() {
        return parRtUpdate;
    }

    public void setParRtUpdate(String parRtUpdate) {
        this.parRtUpdate = parRtUpdate;
    }

    public String getParRwUpdate() {
        return parRwUpdate;
    }

    public void setParRwUpdate(String parRwUpdate) {
        this.parRwUpdate = parRwUpdate;
    }

    public Long getParIdNegaraUpdate() {
        return parIdNegaraUpdate;
    }

    public void setParIdNegaraUpdate(Long parIdNegaraUpdate) {
        this.parIdNegaraUpdate = parIdNegaraUpdate;
    }

    public String getParNamaNegaraUpdate() {
        return parNamaNegaraUpdate;
    }

    public void setParNamaNegaraUpdate(String parNamaNegaraUpdate) {
        this.parNamaNegaraUpdate = parNamaNegaraUpdate;
    }

    public String getParIdPenerimampLama() {
        return parIdPenerimampLama;
    }

    public void setParIdPenerimampLama(String parIdPenerimampLama) {
        this.parIdPenerimampLama = parIdPenerimampLama;
    }

    public String getParNamaPenerimamplamaUpdate() {
        return parNamaPenerimamplamaUpdate;
    }

    public void setParNamaPenerimamplamaUpdate(String parNamaPenerimamplamaUpdate) {
        this.parNamaPenerimamplamaUpdate = parNamaPenerimamplamaUpdate;
    }

    public Long getParIdKatPenerimampLama() {
        return parIdKatPenerimampLama;
    }

    public void setParIdKatPenerimampLama(Long parIdKatPenerimampLama) {
        this.parIdKatPenerimampLama = parIdKatPenerimampLama;
    }

    public Date getParTglNikahPenerimamplama() {
        return parTglNikahPenerimamplama;
    }

    public void setParTglNikahPenerimamplama(Date parTglNikahPenerimamplama) {
        this.parTglNikahPenerimamplama = parTglNikahPenerimamplama;
    }

    public Date getParTglInfnkhPenerimamplama() {
        return parTglInfnkhPenerimamplama;
    }

    public void setParTglInfnkhPenerimamplama(Date parTglInfnkhPenerimamplama) {
        this.parTglInfnkhPenerimamplama = parTglInfnkhPenerimamplama;
    }

    public String getParIdPenerimaMpBaru() {
        return parIdPenerimaMpBaru;
    }

    public void setParIdPenerimaMpBaru(String parIdPenerimaMpBaru) {
        this.parIdPenerimaMpBaru = parIdPenerimaMpBaru;
    }

    public String getParNamaPenerimaMpBaru() {
        return parNamaPenerimaMpBaru;
    }

    public void setParNamaPenerimaMpBaru(String parNamaPenerimaMpBaru) {
        this.parNamaPenerimaMpBaru = parNamaPenerimaMpBaru;
    }

    public Long getParIdKatPenerimampBaru() {
        return parIdKatPenerimampBaru;
    }

    public void setParIdKatPenerimampBaru(Long parIdKatPenerimampBaru) {
        this.parIdKatPenerimampBaru = parIdKatPenerimampBaru;
    }

    public String getParNamaKatPenerimampBaru() {
        return parNamaKatPenerimampBaru;
    }

    public void setParNamaKatPenerimampBaru(String parNamaKatPenerimampBaru) {
        this.parNamaKatPenerimampBaru = parNamaKatPenerimampBaru;
    }

    public Character getParJkPenerimampBaru() {
        return parJkPenerimampBaru;
    }

    public void setParJkPenerimampBaru(Character parJkPenerimampBaru) {
        this.parJkPenerimampBaru = parJkPenerimampBaru;
    }

    public Date getParTglLhrPenerimampBaru() {
        return parTglLhrPenerimampBaru;
    }

    public void setParTglLhrPenerimampBaru(Date parTglLhrPenerimampBaru) {
        this.parTglLhrPenerimampBaru = parTglLhrPenerimampBaru;
    }

    public Long getParIdKawinPenerimampBaru() {
        return parIdKawinPenerimampBaru;
    }

    public void setParIdKawinPenerimampBaru(Long parIdKawinPenerimampBaru) {
        this.parIdKawinPenerimampBaru = parIdKawinPenerimampBaru;
    }

    public String getParNamaKawinPenerimampBaru() {
        return parNamaKawinPenerimampBaru;
    }

    public void setParNamaKawinPenerimampBaru(String parNamaKawinPenerimampBaru) {
        this.parNamaKawinPenerimampBaru = parNamaKawinPenerimampBaru;
    }

    public Long getParIdSuskelBaru() {
        return parIdSuskelBaru;
    }

    public void setParIdSuskelBaru(Long parIdSuskelBaru) {
        this.parIdSuskelBaru = parIdSuskelBaru;
    }

    public String getParNamaSuskelBaru() {
        return parNamaSuskelBaru;
    }

    public void setParNamaSuskelBaru(String parNamaSuskelBaru) {
        this.parNamaSuskelBaru = parNamaSuskelBaru;
    }

    public Date getParTglBulan13() {
        return parTglBulan13;
    }

    public void setParTglBulan13(Date parTglBulan13) {
        this.parTglBulan13 = parTglBulan13;
    }

    public BigDecimal getParLebihBayarNominal() {
        return parLebihBayarNominal;
    }

    public void setParLebihBayarNominal(BigDecimal parLebihBayarNominal) {
        this.parLebihBayarNominal = parLebihBayarNominal;
    }

    public Long getParLebihBayarJmlBulan() {
        return parLebihBayarJmlBulan;
    }

    public void setParLebihBayarJmlBulan(Long parLebihBayarJmlBulan) {
        this.parLebihBayarJmlBulan = parLebihBayarJmlBulan;
    }

    public BigDecimal getParLebihBayarNominal13() {
        return parLebihBayarNominal13;
    }

    public void setParLebihBayarNominal13(BigDecimal parLebihBayarNominal13) {
        this.parLebihBayarNominal13 = parLebihBayarNominal13;
    }

    public Long getParLebihBayarJmlBulan13() {
        return parLebihBayarJmlBulan13;
    }

    public void setParLebihBayarJmlBulan13(Long parLebihBayarJmlBulan13) {
        this.parLebihBayarJmlBulan13 = parLebihBayarJmlBulan13;
    }

    public BigDecimal getParNominalTerbayar() {
        return parNominalTerbayar;
    }

    public void setParNominalTerbayar(BigDecimal parNominalTerbayar) {
        this.parNominalTerbayar = parNominalTerbayar;
    }

    public BigDecimal getParSaldoAkhirLebihBayar() {
        return parSaldoAkhirLebihBayar;
    }

    public void setParSaldoAkhirLebihBayar(BigDecimal parSaldoAkhirLebihBayar) {
        this.parSaldoAkhirLebihBayar = parSaldoAkhirLebihBayar;
    }

    public Long getParIdStatusBayarUpdate() {
        return parIdStatusBayarUpdate;
    }

    public void setParIdStatusBayarUpdate(Long parIdStatusBayarUpdate) {
        this.parIdStatusBayarUpdate = parIdStatusBayarUpdate;
    }

    public String getParNamaStatusBayarUpdate() {
        return parNamaStatusBayarUpdate;
    }

    public void setParNamaStatusBayarUpdate(String parNamaStatusBayarUpdate) {
        this.parNamaStatusBayarUpdate = parNamaStatusBayarUpdate;
    }

    public Date getParTglHentiBayarUpdate() {
        return parTglHentiBayarUpdate;
    }

    public void setParTglHentiBayarUpdate(Date parTglHentiBayarUpdate) {
        this.parTglHentiBayarUpdate = parTglHentiBayarUpdate;
    }

    public Long getParIdKategoriCatatan() {
        return parIdKategoriCatatan;
    }

    public void setParIdKategoriCatatan(Long parIdKategoriCatatan) {
        this.parIdKategoriCatatan = parIdKategoriCatatan;
    }

    public String getParNamaKategoriCatatan() {
        return parNamaKategoriCatatan;
    }

    public void setParNamaKategoriCatatan(String parNamaKategoriCatatan) {
        this.parNamaKategoriCatatan = parNamaKategoriCatatan;
    }

    public String getParKeterangan() {
        return parKeterangan;
    }

    public void setParKeterangan(String parKeterangan) {
        this.parKeterangan = parKeterangan;
    }

    public Long getParIdValidasi() {
        return parIdValidasi;
    }

    public void setParIdValidasi(Long parIdValidasi) {
        this.parIdValidasi = parIdValidasi;
    }

    public String getParNamaValidasi() {
        return parNamaValidasi;
    }

    public void setParNamaValidasi(String parNamaValidasi) {
        this.parNamaValidasi = parNamaValidasi;
    }

    public void fromPlainText(MenikahKembaliPlainTextFormDto plainDto){
        this.setCompName(plainDto.getCompName());
        this.setUserName(plainDto.getUserName());
        this.setParIdMutasi(plainDto.getParIdMutasi().equals("") ? null : Long.valueOf(plainDto.getParIdMutasi()) );
        this.setParKodeMutasi(plainDto.getParKodeMutasi());
        this.setParPeriodeMutasi(plainDto.getParPeriodeMutasi());
        this.setParTglMutasi(stringToDate(plainDto.getParTglMutasi()) );
        this.setParNip(plainDto.getParNip());
        this.setParNamaPesertaUpdate(plainDto.getParNamaPesertaUpdate());
        this.setParIdAgamaUpdate(plainDto.getParIdAgamaUpdate().equals("") ? null : Long.valueOf(plainDto.getParIdAgamaUpdate()));
        this.setParNamaAgamaUpdate(plainDto.getParNamaAgamaUpdate());
        this.setParIdGolonganUpdate(plainDto.getParIdGolonganUpdate().equals("") ? null : Long.valueOf(plainDto.getParIdGolonganUpdate()));
        this.setParNamaGolonganUpdate(plainDto.getParNamaGolonganUpdate());
        this.setParPhdp(plainDto.getParPhdp().equals("") ? null : new BigDecimal(plainDto.getParPhdp()));
        this.setParIdKantorBayarUpdate(plainDto.getParIdKantorBayarUpdate());
        this.setParNamaKantorBayarUpdate(plainDto.getParNamaKantorBayarUpdate());
        this.setParTglSpBiUpdate(stringToDate(plainDto.getParTglSpBiUpdate()) );
        this.setParNoSpBiUpdate(plainDto.getParNoSpBiUpdate());
        this.setParTglSkBiUpdate(stringToDate(plainDto.getParTglSkBiUpdate()) );
        this.setParNoSkBiUpdate(plainDto.getParNoSkBiUpdate());
        this.setParAlmtIsDalamnegeriUpdate(plainDto.getParAlmtIsDalamnegeriUpdate());
        this.setParIdProvinsiUpdate( plainDto.getParIdProvinsiUpdate().equals("")? null : Long.valueOf(plainDto.getParIdProvinsiUpdate()));
        this.setParNamaProvinsiUpdate(plainDto.getParNamaProvinsiUpdate());
        this.setParIdKotaKabUpdate(plainDto.getParIdKotaKabUpdate().equals("") ? null : Long.valueOf(plainDto.getParIdKotaKabUpdate()));
        this.setParNamaKotaKabUpdate(plainDto.getParNamaKotaKabUpdate());
        this.setParIdKecamatanUpdate(plainDto.getParIdKecamatanUpdate().equals("")? null : Long.valueOf(plainDto.getParIdKecamatanUpdate()));
        this.setParNamaKecamatanUpdate(plainDto.getParNamaKecamatanUpdate());
        this.setParIdKelurahanUpdate(plainDto.getParIdKelurahanUpdate().equals("")? null :Long.valueOf(plainDto.getParIdKelurahanUpdate()));
        this.setParNamaKelurahanUpdate(plainDto.getParNamaKelurahanUpdate());
        this.setParKodePosUpdate(plainDto.getParKodePosUpdate());
        this.setParAlamatLengkapUpdate(plainDto.getParAlamatLengkapUpdate());
        this.setParNoHpUpdate(plainDto.getParNoHpUpdate());
        this.setParNoTlpUpdate(plainDto.getParNoTlpUpdate());
        this.setParEmailUpdate(plainDto.getParEmailUpdate());
        this.setParRtUpdate(plainDto.getParRtUpdate());
        this.setParRwUpdate(plainDto.getParRwUpdate());
        this.setParIdNegaraUpdate(plainDto.getParIdNegaraUpdate().equals("")? null : Long.valueOf(plainDto.getParIdNegaraUpdate()));
        this.setParNamaNegaraUpdate(plainDto.getParNamaNegaraUpdate());
        this.setParIdPenerimampLama(plainDto.getParIdPenerimampLama());
        this.setParNamaPenerimamplamaUpdate(plainDto.getParNamaPenerimamplamaUpdate());
        this.setParIdKatPenerimampLama(plainDto.getParIdKatPenerimampLama().equals("")? null : Long.valueOf(plainDto.getParIdKatPenerimampLama()));
        this.setParTglNikahPenerimamplama(plainDto.getParTglNikahPenerimamplama().equals("")? null : stringToDate(plainDto.getParTglNikahPenerimamplama()) );
        this.setParTglInfnkhPenerimamplama(plainDto.getParTglInfnkhPenerimamplama().equals("")? null : stringToDate(plainDto.getParTglInfnkhPenerimamplama()) );
        this.setParIdPenerimaMpBaru(plainDto.getParIdPenerimaMpBaru());
        this.setParNamaPenerimaMpBaru(plainDto.getParNamaPenerimaMpBaru());
        this.setParIdKatPenerimampBaru(plainDto.getParIdKatPenerimampBaru().equals("")? null : Long.valueOf(plainDto.getParIdKatPenerimampBaru()));
        this.setParNamaKatPenerimampBaru(plainDto.getParNamaKatPenerimampBaru());
        this.setParJkPenerimampBaru(plainDto.getParJkPenerimampBaru());
        this.setParTglLhrPenerimampBaru(plainDto.getParTglLhrPenerimampBaru().equals("")? null : stringToDate(plainDto.getParTglLhrPenerimampBaru()) );
        this.setParIdKawinPenerimampBaru(plainDto.getParIdKawinPenerimampBaru().equals("")? null : Long.valueOf(plainDto.getParIdKawinPenerimampBaru()));
        this.setParNamaKawinPenerimampBaru(plainDto.getParNamaKawinPenerimampBaru());
        this.setParIdSuskelBaru(plainDto.getParIdSuskelBaru().equals("")? null : Long.valueOf(plainDto.getParIdSuskelBaru()));
        this.setParNamaSuskelBaru(plainDto.getParNamaSuskelBaru());
        this.setParTglBulan13(plainDto.getParTglBulan13().equals("")? null : DateUtil.stringToDate(plainDto.getParTglBulan13()) );
        this.setParLebihBayarNominal(plainDto.getParLebihBayarNominal().equals("")? null : BigDecimal.valueOf( Double.valueOf(plainDto.getParLebihBayarNominal())));
        this.setParLebihBayarJmlBulan(plainDto.getParLebihBayarJmlBulan().equals("")? null : Long.valueOf(plainDto.getParLebihBayarJmlBulan()));
        this.setParLebihBayarNominal13(plainDto.getParLebihBayarNominal13().equals("")? null : BigDecimal.valueOf( Double.valueOf(plainDto.getParLebihBayarNominal13())) );
        this.setParLebihBayarJmlBulan13(plainDto.getParLebihBayarJmlBulan13().equals("")? null : Long.valueOf(plainDto.getParLebihBayarJmlBulan13()));
        this.setParNominalTerbayar(plainDto.getParNominalTerbayar().equals("")? null : BigDecimal.valueOf( Double.valueOf(plainDto.getParNominalTerbayar())) );
        this.setParSaldoAkhirLebihBayar(plainDto.getParSaldoAkhirLebihBayar().equals("")? null : BigDecimal.valueOf(Double.valueOf(plainDto.getParSaldoAkhirLebihBayar())));
        this.setParIdStatusBayarUpdate(plainDto.getParIdStatusBayarUpdate().equals("")? null : Long.valueOf(plainDto.getParIdStatusBayarUpdate()));
        this.setParNamaStatusBayarUpdate(plainDto.getParNamaStatusBayarUpdate());
        this.setParTglHentiBayarUpdate(plainDto.getParTglHentiBayarUpdate().equals("")? null : stringToDate(plainDto.getParTglHentiBayarUpdate()) );
        this.setParIdKategoriCatatan(plainDto.getParIdKategoriCatatan().equals("")? null :Long.valueOf(plainDto.getParIdKategoriCatatan()));
        this.setParNamaKategoriCatatan(plainDto.getParNamaKategoriCatatan());
        this.setParKeterangan(plainDto.getParKeterangan());
        this.setParIdValidasi(plainDto.getParIdValidasi().equals("")? null :Long.valueOf(plainDto.getParIdValidasi()));
        this.setParNamaValidasi(plainDto.getParNamaValidasi());
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
