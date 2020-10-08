package com.dapenbi.dkpp.controller;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.*;
import com.dapenbi.dkpp.dto.*;
import com.dapenbi.dkpp.dto.component.BreadcrumbHolderComponentDto;
import com.dapenbi.dkpp.form.MutasiPensiunFormDto;
import com.dapenbi.dkpp.model.*;
import com.dapenbi.dkpp.util.DateUtil;
import com.dapenbi.dkpp.util.DkppUserStamp;
import com.dapenbi.dkpp.util.SelectValueUtil;
import com.dapenbi.dkpp.util.StringUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public abstract class MutasiPensiunBaseController extends MasterDataController {

    ServletContext servletContext;

    SetupParameterDao setupParameterDao;

    JenisMpsDao jenisMpsDao;

    PesertaDao pesertaDao;

    KeluargaPesertaDao keluargaPesertaDao;

    MutasiPensiunDao mutasiPensiunDao;

    StatusBayarDao statusBayarDao;

    StatusValidasiDao statusValidasiDao;

    MPensiunDao pensiunDao;

    KategoriMutasiDto kategoriMutasiDto;

    KategoriPenerimaDto kategoriPenerimaDto;

    @GetMapping("/{nip}/entry")
    public String entry(HttpServletRequest request, @PathVariable("nip") String nip, @RequestParam(name = "id", required = false) Long id, @RequestParam(name = "status", required = false) String status,@RequestParam(name = "jatuhTempoDibayar", required = false) Boolean jatuhTempoDibayar, Map<String, Object> model) {
        boolean mutasiValid = true;
        boolean allowSave = true;
        MutasiPensiunFormDto form = new MutasiPensiunFormDto();
        if (request.getRequestURI().contains(PathPrefix.MUTASI_PENSIUN_TUNDA)) {
            form.setIsPensiunTunda(true);
        }

        String keluargaPensiunStr = "{}";
        AgamaDto agamaDto = null;
        GolonganDto golonganDto = null;
        AlasanHentiDto alasanHentiDto = null;
        PredikatPemberhentianDto predikatPemberhentianDto = null;
        KantorBayarDto kantorBayarDto = null;
        KategoriPensiunDto kategoriPensiunDto = null;
        UsiaBayarDto usiaBayarDto = null;
        NegaraDto negaraDto = null;
        ProvinsiDto provinsiDto = null;
        KotaDto kotaDto = null;
        KecamatanDto kecamatanDto = null;
        KelurahanDto kelurahanDto = null;
        KategoriCatatanDto kategoriCatatanDto = null;
        StatusKawinDto statusKawinDto = null;

        if (id == null) {
            if (request.getRequestURI().contains(PathPrefix.MUTASI_PENSIUN_BARU)) {
                Peserta peserta = pesertaDao.findByNip(nip);

                if (peserta != null) {
                    PesertaDto pesertaDto = peserta.toDto();
                    List<KeluargaPeserta> keluargaPeserta = (List<KeluargaPeserta>) keluargaPesertaDao.findByNip(nip);
                    List<KeluargaPesertaDto> keluargaPesertaDtoList = keluargaPeserta.stream().map(kp -> {
                        KeluargaPesertaDto dto = kp.toDto();
                        dto.setKategoriPenerima(kp.getKategoriPenerima().toDto());
                        dto.setStatusKawin(kp.getStatusKawin().toDto());
                        if (dto.getTglUsia25() == null) {
                            Calendar usia25Tahun = Calendar.getInstance();
                            usia25Tahun.setTime(dto.getTglLahir());
                            usia25Tahun.add(Calendar.YEAR, 25);
                            dto.setTglUsia25(usia25Tahun.getTime());
                        }
                        return dto;
                    }).collect(Collectors.toList());

                    SetupParameter setupParameter = setupParameterDao.findByBukaPeriode();
                    if (setupParameter != null) {
                        SetupParameterDto setupParameterDto = setupParameter.toDto();
                        form.setPeriodeMutasi(setupParameterDto.getPeriode());
                    }
                    form.setTanggalInput(DateUtil.dateToString(new Date()));
                    form.setNip(pesertaDto.getNip());
                    form.setNama(pesertaDto.getNamaPeserta());
                    form.setJenisKelamin(pesertaDto.getJenisKelamin());
                    form.setGajiPokokTerakhir(pesertaDto.getGapok());
                    form.setUpahVeteran(pesertaDto.getUpahVeteran() == null ? new BigDecimal(0) : pesertaDto.getUpahVeteran());
                    form.setTglLahir(DateUtil.dateToString(pesertaDto.getTglLahir()));
                    form.setTglDicatatSebagaiPesertaDPHT(DateUtil.dateToString(pesertaDto.getTglPeserta()));
                    form.setTglBekerjaDiBI(DateUtil.dateToString(pesertaDto.getTglKerja()));
                    form.setTglMeninggal(DateUtil.dateToString(pesertaDto.getTglWafat()));
                    form.setTanggalSKBI(DateUtil.dateToString(pesertaDto.getTglSKBI()));
                    form.setNomorSKBI(pesertaDto.getNoSKBI());
                    form.setTglBerhentiBekerjaDiBI(DateUtil.dateToString(pesertaDto.getTglHenti()));
                    form.setAlamatIndonesiaPenerimaMP(pesertaDto.getAlamat());

                    keluargaPensiunStr = StringUtil.objToJson(keluargaPesertaDtoList);
                    agamaDto = peserta.getAgama().toDto();
                    golonganDto = peserta.getGolongan().toDto();
                    // * Change by Irwan Nugraha
                    // -- Adding Condition Alasan Henti = null
                    // -- ini buat antisipasi jika data dari pelepasan peserta baru
                    if (pesertaDto.getAlasanHenti() == null){
                        alasanHentiDto = new AlasanHentiDto();
                    }else {
                        alasanHentiDto = pesertaDto.getAlasanHenti();
                    }
                    predikatPemberhentianDto = peserta.getPredikatPemberhentian().toDto();
                } else {
                    mutasiValid = false;
                }
            } else if (request.getRequestURI().contains(PathPrefix.MUTASI_PENSIUN_TUNDA)) {
                MPensiun pensiun = pensiunDao.findByNip(nip);

                if (pensiun != null) {
                    MPensiunDto pensiunDto = pensiun.toDto();
                    SetupParameter setupParameter = setupParameterDao.findByBukaPeriode();
                    if (setupParameter != null) {
                        SetupParameterDto setupParameterDto = setupParameter.toDto();
                        form.setPeriodeMutasi(setupParameterDto.getPeriode());
                    }
                    form.setIsJatuhTempoDibayar(jatuhTempoDibayar == null ? false : jatuhTempoDibayar);
                    form.setTanggalInput(DateUtil.dateToString(new Date()));
                    form.setNip(pensiunDto.getNip());
                    form.setNama(pensiunDto.getNamaPeserta());
                    form.setJenisKelamin(pensiunDto.getJenisKelaminPeserta());
                    form.setGajiPokokTerakhir(pensiunDto.getPhdp());
                    form.setUpahVeteran(pensiunDto.getUpahVeteran());
                    form.setTanggalSKBI(DateUtil.dateToString(pensiunDto.getTglSkBi()));
                    form.setNomorSKBI(pensiunDto.getNoSkBi());
                    form.setTanggalSuratPengantarBI(DateUtil.dateToString(pensiunDto.getTglSpBi()));
                    form.setNomorSuratPengantarBI(pensiunDto.getNoSpBi());
                    form.setTanggalSKDAPENBI(DateUtil.dateToString(pensiunDto.getTglSkDapenbi()));
                    form.setNomorSKDAPENBI(pensiunDto.getNoSkDapenbi());
                    form.setTglLahir(DateUtil.dateToString(pensiunDto.getTglLahirPeserta()));
                    form.setTglDicatatSebagaiPesertaDPHT(DateUtil.dateToString(pensiunDto.getTglDhptPeserta()));
                    form.setTglBekerjaDiBI(DateUtil.dateToString(pensiunDto.getTglKerjaPeserta()));
                    form.setTglMeninggal(DateUtil.dateToString(pensiunDto.getTglMeninggalPeserta()));
                    form.setTglBerhentiBekerjaDiBI(DateUtil.dateToString(pensiunDto.getTglHentiKerjaPeserta()));
                    form.setAlamatIndonesiaPenerimaMP(pensiunDto.getAlamatLengkap());
                    form.setAlamatLuarNegeriPenerimaMP(pensiunDto.getAlamatLengkap());
                    form.setStatusPengembalianMPS(pensiun.getJenisMps().getId());
                    form.setStatusBayarMP(pensiun.getStatusBayar().getId());
                    form.setTglTundaJatuhTempo(DateUtil.dateToString(pensiunDto.getTglTundaJatuhTempo()));
                    form.setTglAwalBayarMP(DateUtil.dateToString(pensiunDto.getTglAwalBayar()));
                    form.setTglMPBulan13(DateUtil.dateToString(pensiunDto.getTglMpBulananKe13()));
                    form.setTglHentiBayar(DateUtil.dateToString(pensiunDto.getTglHentiBayar()));
                    form.setUserStamp(pensiun.getUserStamp());
                    form.setEmailPenerimaMP(pensiunDto.getEmail());
                    form.setAlamatIndonesiaPenerimaMP(pensiunDto.getAlamatLengkap());
                    form.setRtPenerimaMP(pensiunDto.getRt());
                    form.setRwPenerimaMP(pensiunDto.getRw());
                    form.setKodePosPenerimaMP(pensiunDto.getKodePos());
                    form.setNoHPPenerimaMP(pensiunDto.getNoHp());
                    form.setNoTlpPenerimaMP(pensiunDto.getNoTelp());
                    form.setCatatan(pensiunDto.getKeteranganHenti());

                    List<KeluargaPensiunDto> keluargaPensiun = pensiun.getKeluargaPensiun().stream().map(k -> {
                        KeluargaPensiunDto dto = k.toDto();
                        dto.setKategoriPenerima(k.getKategoriPenerima().toDto());
                        dto.setStatusKawin(k.getStatusKawin().toDto());
                        return dto;
                    }).collect(Collectors.toList());

                    keluargaPensiunStr = StringUtil.objToJson(keluargaPensiun);
                    agamaDto = pensiun.getAgama().toDto();
                    golonganDto = pensiun.getGolongan().toDto();
                    alasanHentiDto = pensiunDto.getAlasanHenti() == null ? new AlasanHentiDto() : pensiunDto.getAlasanHenti();
                    predikatPemberhentianDto = pensiun.getPredikatPemberhentian().toDto();
                    kantorBayarDto = pensiun.getKantorBayar().toDto();
                    kategoriPensiunDto = pensiun.getKategoriPensiun().toDto();
                    usiaBayarDto = pensiun.getUsiaBayar().toDto();
                    negaraDto = null;
                    provinsiDto = null;
                    kotaDto = null;
                    kecamatanDto = null;
                    kelurahanDto = null;
                    statusKawinDto = pensiun.getStatusKawin().toDto();

                    if (!pensiun.getAlamatIsDalamNegeri()) {
                        negaraDto = pensiun.getNegara().toDto();
                    } else {
                        provinsiDto = pensiun.getProvinsi().toDto();
                        kotaDto = pensiun.getKota().toDto();
                        kecamatanDto = pensiun.getKecamatan().toDto();
                        kelurahanDto = pensiun.getKelurahan().toDto();
                    }
                } else {
                    mutasiValid = false;
                }
            }
        } else {
            MutasiPensiun mutasiPensiun = mutasiPensiunDao.findById(id);

            if (mutasiPensiun != null) {
                MutasiPensiunDto mutasiPensiunDto = mutasiPensiun.toDto();
                if (mutasiPensiun.getKategoryCatatan() != null ){ mutasiPensiunDto.setKategoryCatatan(mutasiPensiun.getKategoryCatatan().toDto()); }
                if (mutasiPensiun.getKantorBayar() != null) { mutasiPensiunDto.setKantorBayar(mutasiPensiun.getKantorBayar().toDto()); }
                if (mutasiPensiun.getKantorBayarBaru() != null){mutasiPensiunDto.setKantorBayarBaru(mutasiPensiun.getKantorBayarBaru().toDto());}
                if (mutasiPensiun.getStatusValidasi() != null) {mutasiPensiunDto.setStatusValidasi(mutasiPensiun.getStatusValidasi().toDto());}
                if (mutasiPensiun.getSuskel() != null){ mutasiPensiunDto.setSuskel(mutasiPensiun.getSuskel().toDto());}
                if (mutasiPensiun.getSuskelBaru() != null) { mutasiPensiunDto.setSuskelBaru(mutasiPensiun.getSuskelBaru().toDto()); }
                //if (mutasiPensiun.getFaktorFPR() != null) { mutasiPensiunDto.setFaktorFPR(mutasiPensiun.getFaktorFPR().toDto());}

                SetupParameter setupParameter = setupParameterDao.findByBukaPeriode();
                if (setupParameter != null) {
                    SetupParameterDto setupParameterDto = setupParameter.toDto();
                    form.setPeriodeMutasi(setupParameterDto.getPeriode());
                }
                form.setMutasiId(mutasiPensiunDto.getId());
                form.setIsJatuhTempoDibayar(jatuhTempoDibayar == null ? false : jatuhTempoDibayar);
                form.setTanggalInput(DateUtil.dateToString(new Date()));
                form.setTglMutasi(DateUtil.dateToString(mutasiPensiunDto.getTglMutasi()));
                form.setNip(mutasiPensiunDto.getNip());
                form.setNama(mutasiPensiunDto.getNamaPeserta());
                form.setJenisKelamin(mutasiPensiunDto.getJenisKelaminPeserta());
                form.setGajiPokokTerakhir(mutasiPensiunDto.getPhdpLama());
                form.setUpahVeteran(mutasiPensiunDto.getUpahVeteran());
                form.setTanggalSKBI(DateUtil.dateToString(mutasiPensiunDto.getTglSKBI()));
                form.setNomorSKBI(mutasiPensiunDto.getNoSKBI());
                form.setTanggalSuratPengantarBI(DateUtil.dateToString(mutasiPensiunDto.getTglSPBI()));
                form.setNomorSuratPengantarBI(mutasiPensiunDto.getNoSPBI());
                form.setTanggalSKDAPENBI(DateUtil.dateToString(mutasiPensiunDto.getTglSKDAPENBI()));
                form.setNomorSKDAPENBI(mutasiPensiunDto.getNoSKDAPENBI());
                form.setTglLahir(DateUtil.dateToString(mutasiPensiunDto.getTglLahirPeserta()));
                form.setTglDicatatSebagaiPesertaDPHT(DateUtil.dateToString(mutasiPensiunDto.getTglDPHTPeserta()));
                form.setTglBekerjaDiBI(DateUtil.dateToString(mutasiPensiunDto.getTglKerjaPeserta()));
                form.setTglMeninggal(DateUtil.dateToString(mutasiPensiunDto.getTglMeniggalPeserta()));
                form.setTanggalSKBI(DateUtil.dateToString(mutasiPensiunDto.getTglSKBI()));
                form.setTglBerhentiBekerjaDiBI(DateUtil.dateToString(mutasiPensiunDto.getTglHentiKerjaPeserta()));
                form.setAlamatIndonesiaPenerimaMP(mutasiPensiunDto.getAlamatLengkap());
                form.setAlamatLuarNegeriPenerimaMP(mutasiPensiunDto.getAlamatLengkap());
                form.setStatusPengembalianMPS(mutasiPensiun.getJenisMps().getId());
                form.setStatusBayarMP(mutasiPensiun.getStatusBayar().getId());
                form.setTglTundaJatuhTempo(DateUtil.dateToString(mutasiPensiunDto.getTglTundaJatuhTempo()));
                form.setTglAwalBayarMP(DateUtil.dateToString(mutasiPensiunDto.getTglAwalBayar()));
                form.setTglMPBulan13(DateUtil.dateToString(mutasiPensiunDto.getTglMpBulanKe13()));
                form.setTglHentiBayar(DateUtil.dateToString(mutasiPensiunDto.getTglHentiBayar()));
                form.setUserStamp(mutasiPensiunDto.getUserStamp());
                form.setUserValidasi(mutasiPensiunDto.getUserValidasi());
                form.setEmailPenerimaMP(mutasiPensiunDto.getEmail());
                form.setAlamatIndonesiaPenerimaMP(mutasiPensiunDto.getAlamatLengkap());
                form.setRtPenerimaMP(mutasiPensiunDto.getRt());
                form.setRwPenerimaMP(mutasiPensiunDto.getRw());
                form.setKodePosPenerimaMP(mutasiPensiunDto.getKodePos());
                form.setNoHPPenerimaMP(mutasiPensiunDto.getNoHP());
                form.setNoTlpPenerimaMP(mutasiPensiunDto.getNoTlp());
                form.setStatusCatatan(mutasiPensiunDto.getStatusValidasi().getId());
                form.setCatatan(mutasiPensiunDto.getKeterangan());
                form.setNamaPenerimaMP(mutasiPensiunDto.getNamaPenerimaMP());
                form.setTglLahirPenerimaMP(DateUtil.dateToString(mutasiPensiunDto.getTglLahirPenerimaMP()));
                if (mutasiPensiunDto.getSuskel() != null) {
                    form.setSuskel(mutasiPensiunDto.getSuskel().getId());
                }
                form.setNamaSuskel(mutasiPensiunDto.getNamaSuskel());
                form.setStatusKelPenerimaPenerimaMP(mutasiPensiunDto.getNamaKategoriPenerimaMP());
                if (mutasiPensiunDto.getJenisKelaminPenerimaMP() == 'P') {
                    form.setNamaJenisKelaminPenerimaMP("Pria");
                }else { form.setNamaJenisKelaminPenerimaMP("Wanita");}
                form.setNamaStatusKelPenerimaPenerimaMP(mutasiPensiunDto.getNamaStatusKawinPenerimaMP());
                /*form.setUsiaPesertaSaatBerhenti(mutasiPensiunDto.getUsiaSaatHenti());
                form.setUsiaPesertaSaatBerhentiPembulatan(mutasiPensiunDto.getUsiaSaatHentiBulat());
                form.setUsiaPenerimaSaatDiBayar(mutasiPensiunDto.getUsiaPenerimaBayar());
                form.setUsiaPenerimaSaatDiBayarPembulatan(mutasiPensiunDto.getUsiaPenerimaBayarBulat());
                form.setMasaKerjaSaatHenti(mutasiPensiunDto.getMasaKerjaHenti());
                form.setMasaKerjaSaatHentiPembulatan(mutasiPensiunDto.getMasaKerjaHentiBulat());
                form.setMasaKerjaTambahan(mutasiPensiunDto.getMasaKerjaTambahan());
                form.setMasaKerjaTambahanPembulatan(mutasiPensiunDto.getMasaKerjaTambahanBulat());
                form.setMasaKerjaVeteran(mutasiPensiunDto.getMasaKerjaVeteran());
                form.setMasaKerjaVeteranPembulatan(mutasiPensiunDto.getMasaKerjaVeteranBulat());
                form.setTotalMasaKerja(mutasiPensiunDto.getTotalMasaKerja());
                form.setTotalMasaKerjaPembulatan(mutasiPensiunDto.getTotalMasaKerjaBulat());
                form.setMasaKerjaMP(mutasiPensiunDto.getMasaKerjaMP());
                form.setFaktorPengurang1(mutasiPensiunDto.getFaktorFPR().getNamafaktor());
                form.setFaktorPengurang2(mutasiPensiunDto.getNamaFaktorFPR());
                form.setFaktorNS1(mutasiPensiunDto.getFaktorFS().getNamaFaktorFs());
                form.setFaktorNS2(mutasiPensiunDto.getNamaFaktorFS());
                form.setPhDP1(mutasiPensiunDto.getPhdpLama().toString());
                if (mutasiPensiunDto.getPhdpBaru() != null) {
                    form.setPhDP2(mutasiPensiunDto.getPhdpBaru().toString());
                }
                form.setMpPerbulan(((mutasiPensiunDto.getMpPerbulanRumusLama() == null) ? "" : mutasiPensiunDto.getMpPerbulanRumusLama().toString()));
                form.setMpsPerbulanSetelah20Persen(((mutasiPensiunDto.getMpPerbulan20PersenLama() == null) ? "" : mutasiPensiunDto.getMpPerbulan20PersenLama().toString()));
                form.setMps20persen(((mutasiPensiunDto.getMps20PersenLama() == null) ? "" : mutasiPensiunDto.getMps20PersenLama().toString()));
                form.setMps10Juta(((mutasiPensiunDto.getMps10JutaLama() == null) ? "" : mutasiPensiunDto.getMps10JutaLama().toString()));
                form.setMpsPerbulanSetelah10Juta(((mutasiPensiunDto.getMpPerbulan10JutaLama() == null) ? "" : mutasiPensiunDto.getMpPerbulan10JutaLama().toString()));
                form.setMpyd(((mutasiPensiunDto.getMpydLama() == null) ? "" : mutasiPensiunDto.getMpydLama().toString()));
                form.setMpBulanKe13(((mutasiPensiunDto.getMpBulan13() == null) ? "" : mutasiPensiunDto.getMpBulan13().toString()));
                form.setMpKurangBayar(((mutasiPensiunDto.getKurangBayarMPRumus() == null) ? "" : mutasiPensiunDto.getKurangBayarMPRumus().toString()));*/
                form.setPeriodeMutasiMp(mutasiPensiunDto.getPeriodeMutasi());
                form.setNamaValidasi(mutasiPensiunDto.getNamaValidasi());

                if (Arrays.asList(new Long[]{2L, 4L}).contains(mutasiPensiun.getStatusValidasi().toDto().getId())) {
                    allowSave = false;
                }

                List<MutasiKeluargaPensiunDto> keluargaPensiun = mutasiPensiun.getMutasiKeluargaPensiun().stream().map(k -> {
                    MutasiKeluargaPensiunDto dto = k.toDto();
                    dto.setKategoriPenerima(k.getKategoriPenerima().toDto());
                    dto.setStatusKawin(k.getStatusKawin().toDto());
                    return dto;
                }).collect(Collectors.toList());

                keluargaPensiunStr = StringUtil.objToJson(keluargaPensiun);
                agamaDto = mutasiPensiun.getAgama().toDto();
                golonganDto = mutasiPensiun.getGolongan().toDto();
                alasanHentiDto = mutasiPensiun.getAlasanHenti().toDto();
                predikatPemberhentianDto = mutasiPensiun.getPredikatPemberhentian().toDto();
                kantorBayarDto = mutasiPensiun.getKantorBayar().toDto();
                kategoriPensiunDto = mutasiPensiun.getKategoriPensiun().toDto();
                usiaBayarDto = mutasiPensiun.getUsiaBayar().toDto();
                negaraDto = null;
                provinsiDto = null;
                kotaDto = null;
                kecamatanDto = null;
                kelurahanDto = null;
                kategoriCatatanDto = mutasiPensiun.getKategoryCatatan().toDto();
                statusKawinDto = mutasiPensiun.getStatusKawin().toDto();
                kategoriMutasiDto = mutasiPensiun.getKategoriMutasi().toDto();
                kategoriPenerimaDto = mutasiPensiun.getKategoriPenerima().toDto();

                if (mutasiPensiun.isAlamatIsDalamNegeri()) {
                    provinsiDto = mutasiPensiun.getProvinsi().toDto();
                    kotaDto = mutasiPensiun.getKota().toDto();
                    kecamatanDto = mutasiPensiun.getKecamatan().toDto();
                    kelurahanDto = mutasiPensiun.getKelurahan().toDto();
                } else {
                    negaraDto = mutasiPensiun.getNegara().toDto();
                }
            } else {
                mutasiValid = false;
            }
        }

        if (mutasiValid) {
            model.put("nip", nip);
            model.put("agamaDefaultSelect", StringUtil.objToJson(agamaDto));
            model.put("golonganDefaultSelect", StringUtil.objToJson(golonganDto));
            model.put("alasanHentiDefaultSelect", StringUtil.objToJson(alasanHentiDto));
            model.put("predikatPemberhentianDefaultSelect", StringUtil.objToJson(predikatPemberhentianDto));
            model.put("dataKeluargaPeserta", keluargaPensiunStr);
            model.put("cabangKpwBIDefaultSelect", StringUtil.objToJson(kantorBayarDto));
            model.put("jenisMPDefaultSelect", StringUtil.objToJson(kategoriPensiunDto));
            model.put("pilihanUsiaBayarMPDefaultSelect", StringUtil.objToJson(usiaBayarDto));
            model.put("negaraDefaultSelect", StringUtil.objToJson(negaraDto));
            model.put("provinsiDefaultSelect", StringUtil.objToJson(provinsiDto));
            model.put("kotaDefaultSelect", StringUtil.objToJson(kotaDto));
            model.put("kecamatanDefaultSelect", StringUtil.objToJson(kecamatanDto));
            model.put("kelurahanDefaultSelect", StringUtil.objToJson(kelurahanDto));
            model.put("kategoriCatatanDefaultSelect", StringUtil.objToJson(kategoriCatatanDto));
            model.put("statusKawinDefaultSelect", StringUtil.objToJson(statusKawinDto));
            model.put("kategoriMutasi", StringUtil.objToJson(kategoriMutasiDto));
            model.put("kategoriPenerima", StringUtil.objToJson(kategoriPenerimaDto));
            if(status != null) {
                model.put("statusForm", status);
            }
            model.put("mutasiForm", form);
            model.put("isPensiunTunda", form.getIsPensiunTunda());
            try {
                if (form.getStatusCatatan() != 2){
                    model.put("isBelumValidasi", form.getStatusCatatan());
                }

            }catch (Exception ex){

            }


            model.put("breadcrumb", getBreadcrumbHolderComponentDtos(form.getNip()));
            model.put("isStaff", DkppUserStamp.isStaff());
            model.put("isPejabat", DkppUserStamp.isPejabat());
            model.put("gender", SelectValueUtil.createGenderSelect());
            model.put("jenisMPSRadio", ((List<JenisMps>) jenisMpsDao.findAllActive()).stream().map(JenisMps::toDto).collect(Collectors.toList()));
            model.put("statusBayarMPRadio", ((List<StatusBayar>) statusBayarDao.findAllActive()).stream().map(StatusBayar::toDto).collect(Collectors.toList()));
            model.put("statusValidasiRadio", ((List<StatusValidasi>) statusValidasiDao.findAllActive()).stream().map(StatusValidasi::toDto).collect(Collectors.toList()));

            //mutasi pensiun path
            model.put("mutasiPensiunPathIndex", this.getIndexPath());
            model.put("mutasiPensiunPathApi", this.getApiPath());

            model.put("masterAgamaPathApi", PathPrefix.API + PathPrefix.AGAMA);
            model.put("golonganPathApi", PathPrefix.API + PathPrefix.GOLONGAN);
            model.put("alasanHentiPathApi", PathPrefix.API + PathPrefix.ALASAN_HENTI);
            model.put("predikatPemberhentianPathApi", PathPrefix.API + PathPrefix.PREDIKAT_PEMBERHENTIAN);
            model.put("cabangKpwBIPathApi", PathPrefix.API + PathPrefix.KANTOR_BAYAR);
            model.put("jenisMPPathApi", PathPrefix.API + PathPrefix.KATEGORI_PENSIUN);
            model.put("pilihanUsiaBayarMPPathApi", PathPrefix.API + PathPrefix.USIABAYAR);
            model.put("negaraPathApi", PathPrefix.API + PathPrefix.NEGARA);
            model.put("provinsiPathApi", PathPrefix.API + PathPrefix.PROVINSI);
            model.put("kotaPathApi", PathPrefix.API + PathPrefix.KOTA);
            model.put("kecamatanPathApi", PathPrefix.API + PathPrefix.KECAMATAN);
            model.put("kelurahanPathApi", PathPrefix.API + PathPrefix.KELURAHAN);
            model.put("kategoriCatatanPathApi", PathPrefix.API + PathPrefix.KATEGORICATATAN);
            model.put("kategoriPenerimaPathApi", PathPrefix.API + PathPrefix.KATEGORI_PENERIMA);
            model.put("statusKawinPathApi", PathPrefix.API + PathPrefix.STATUS_KAWIN);
            model.put("listPeriodeSetupParameter", PathPrefix.API + PathPrefix.SETUPPARAMETER + "/get_periode");
            model.put("allowSave", allowSave);

            return "pensiunBaru/entry-mutasi-pensiun";
        }
        return "redirect:" + this.errorRedirect();
    }

    abstract List<BreadcrumbHolderComponentDto> getBreadcrumbHolderComponentDtos(String nip);

    abstract String errorRedirect();

    abstract String getIndexPath();

    abstract String getApiPath();
}
