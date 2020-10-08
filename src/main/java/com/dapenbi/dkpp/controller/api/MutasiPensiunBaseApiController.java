package com.dapenbi.dkpp.controller.api;

import com.dapenbi.dkpp.Constanta;
import com.dapenbi.dkpp.dao.*;
import com.dapenbi.dkpp.dto.*;
import com.dapenbi.dkpp.dto.component.JenisKelaminEnum;
import com.dapenbi.dkpp.form.KeluargaPesertaFormDto;
import com.dapenbi.dkpp.form.MutasiPensiunFormDto;
import com.dapenbi.dkpp.form.PesertaFormDto;
import com.dapenbi.dkpp.model.*;
import com.dapenbi.dkpp.util.DateUtil;
import com.dapenbi.dkpp.util.MessageUtil;
import com.dapenbi.dkpp.util.StringUtil;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;

public abstract class MutasiPensiunBaseApiController {

    MutasiPensiunDao mutasiPensiunDao;

    MutasiKeluargaPensiunDao mutasiKeluargaPensiunDao;

    KategoriPenerimaDao kategoriPenerimaDao;

    GolonganDao golonganDao;

    AgamaDao agamaDao;

    KantorBayarDao kantorBayarDao;

    PredikatPemberhentianDao predikatPemberhentianDao;

    AlasanHentiDao alasanHentiDao;

    JenisMpsDao jenisMpsDao;

    KategoriPensiunDao kategoriPensiunDao;

    UsiaBayarDao usiaBayarDao;

    StatusBayarDao statusBayarDao;

    KategoriCatatanDao kategoriCatatanDao;

    StatusKawinDao statusKawinDao;

    StatusValidasiDao statusValidasiDao;

    KelurahanDao kelurahanDao;

    NegaraDao negaraDao;

    SuskelDao suskelDao;

    KeluargaPensiunDao keluargaPensiunDao;

    KategoriMutasiDao kategoriMutasiDao;

    @Autowired
    AppConfigDao appConfigDao;

    @PostMapping("/validate")
    public ResponseEntity<MessageUtil> validate(@ModelAttribute MutasiPensiunFormDto formDto) {
        String formatDate = "dd/MM/yyyy";
        Date tglLahir = DateUtil.stringToDate(formDto.getTglLahir(), formatDate);
        Date tglMeninggal = DateUtil.stringToDate(formDto.getTglMeninggal(), formatDate);
        Date tglMutasi = DateUtil.stringToDate(formDto.getTglLahir(), formatDate);
        Date tglBekerjaDiBI = DateUtil.stringToDate(formDto.getTglBekerjaDiBI(), formatDate);
        Date tglBerhentiBekerja = DateUtil.stringToDate(formDto.getTglBerhentiBekerjaDiBI(), formatDate);
        Date tglDPHT = DateUtil.stringToDate(formDto.getTglDicatatSebagaiPesertaDPHT(), formatDate);
        Date tglHentiBayar = DateUtil.stringToDate(formDto.getTglHentiBayar(), formatDate);
        Date tglAwalBayarMP = DateUtil.stringToDate(formDto.getTglAwalBayarMP(), formatDate);
        Date tglLahirPenerimaMP = DateUtil.stringToDate(formDto.getTglLahirPenerimaMP(), formatDate);
        Date tglInput = DateUtil.stringToDate(formDto.getTanggalInput(), formatDate);
        Map<String, String> penerimaMP = formDto.getPenerimaMP();
        Long idStatusKawin = formDto.getStatusKawin();
        if (tglMeninggal != null && (Long.valueOf(penerimaMP.get("kategoriPenerima")) == 2 || Long.valueOf(penerimaMP.get("kategoriPenerima")) == 20 || Long.valueOf(penerimaMP.get("kategoriPenerima")) == 21 )){
            if (penerimaMP.get("statusKawin").equals("4")) {
                idStatusKawin = Long.valueOf(3);
            }
            else if (penerimaMP.get("statusKawin").equals("2")) {
                idStatusKawin = Long.valueOf(1);
            }
        }
        Date tglLahirPenerima = DateUtil.stringToDate(penerimaMP.get("tglLahir"), formatDate);

        try {
            Map simulasiMutasi = mutasiPensiunDao.mpSimulation(tglLahir,
                    tglBekerjaDiBI,
                    tglBerhentiBekerja,
                    tglDPHT,
                    Long.valueOf(penerimaMP.get("kategoriPenerima")),
                    tglLahirPenerima,
                    tglAwalBayarMP,
                    formDto.getJenisMP(),
                    formDto.getStatusPengembalianMPS(),
                    idStatusKawin,
                    formDto.getPilihanUsiaBayarMP(),
                    formDto.getGajiPokokTerakhir(),
                    tglInput,
                    formDto.getPeriodeMutasi());

            formDto.setNamaPenerimaMP(penerimaMP.get("namaKeluarga"));
            formDto.setTglLahirPenerimaMP(penerimaMP.get("tglLahir"));
            formDto.setJenisKelaminPenerimaMP(penerimaMP.get("jenisKelamin"));
            formDto.setNamaJenisKelaminPenerimaMP(JenisKelaminEnum.getText(penerimaMP.get("jenisKelamin")));
            formDto.setStatusKelPenerimaPenerimaMP(penerimaMP.get("kategoriPenerima"));
            KategoriPenerima statusKeluarga = kategoriPenerimaDao.findFirstById(Long.valueOf(penerimaMP.get("kategoriPenerima")));
            formDto.setNamaStatusKelPenerimaPenerimaMP(statusKeluarga.getNamaKategoriPenerima());
            formDto.setUsiaPesertaSaatBerhenti(StringUtil.toString(simulasiMutasi.get("usia_henti")));
            formDto.setUsiaPesertaSaatBerhentiPembulatan(StringUtil.toString(simulasiMutasi.get("usia_henti_bulat")));
            formDto.setUsiaPenerimaSaatDiBayar(StringUtil.toString(simulasiMutasi.get("usia_bayar")));
            formDto.setUsiaPenerimaSaatDiBayarPembulatan(StringUtil.toString(simulasiMutasi.get("usia_bayar_bulat")));
            formDto.setMasaKerjaSaatHenti(StringUtil.toString(simulasiMutasi.get("mk_henti")));
            formDto.setMasaKerjaSaatHentiPembulatan(StringUtil.toString(simulasiMutasi.get("mk_henti_bulat")));
            formDto.setMasaKerjaTambahan(StringUtil.toString(simulasiMutasi.get("mk_tambahan")));
            formDto.setMasaKerjaTambahanPembulatan(StringUtil.toString(simulasiMutasi.get("mk_tambahan_bulat")));
            formDto.setMasaKerjaVeteran(StringUtil.toString(simulasiMutasi.get("mk_veteran")));
            formDto.setMasaKerjaVeteranPembulatan(StringUtil.toString(simulasiMutasi.get("mk_veteran_bulat")));
            formDto.setTotalMasaKerja(StringUtil.toString(simulasiMutasi.get("total_mk")));
            formDto.setTotalMasaKerjaPembulatan(StringUtil.toString(simulasiMutasi.get("total_mk_bulat")));
            formDto.setMasaKerjaMP(StringUtil.toString(simulasiMutasi.get("mk_mp")));
            formDto.setFaktorPengurang1(StringUtil.toString(simulasiMutasi.get("fpr")));
            formDto.setFaktorPengurang2(StringUtil.toString(simulasiMutasi.get("fpr_name")));
            formDto.setFaktorNS1(StringUtil.toString(simulasiMutasi.get("fs")));
            formDto.setFaktorNS2(StringUtil.toString(simulasiMutasi.get("fs_name")));
            formDto.setPhDP1(StringUtil.toString(simulasiMutasi.get("phdp")));
            formDto.setMpPerbulan(StringUtil.toString(simulasiMutasi.get("mp_perbulan_rumus")));
            formDto.setMpsPerbulanSetelah20Persen(StringUtil.toString(simulasiMutasi.get("mp_perbulan_mps20persen")));
            formDto.setMps20persen(StringUtil.toString(simulasiMutasi.get("mps_20persen")));
            formDto.setMpsPerbulanSetelah10Juta(StringUtil.toString(simulasiMutasi.get("mp_perbulan_mps10juta")));
            formDto.setMps10Juta(StringUtil.toString(simulasiMutasi.get("mps_10juta")));
            formDto.setMpyd(StringUtil.toString(simulasiMutasi.get("mpyd")));
            formDto.setMpBulanKe13(StringUtil.toString(simulasiMutasi.get("mp_bulanke13")));
            formDto.setMps100Persen(StringUtil.toString(simulasiMutasi.get("mps_100persen")));
            formDto.setMps100PersenPembulatan(StringUtil.toString(simulasiMutasi.get("mps_100persen_bulat")));
            formDto.setMpKurangBayar(StringUtil.toString(simulasiMutasi.get("kurang_bayar_mp")));
            //Change By Irwan Nugraha
            //Ketentuan Validasi pengambilan MPS 100%
            //1. Jika Peserta tidak mempunya keluarga, Penerima MP = Ahli Waris / Pihak yg Ditunjuk
            //2. Jika Peserta Mempunyai keluarga dan MP Bulanan memenuhi value yg diset di AppConfig untuk Pensiun Baru
            AppConfig appConfig = appConfigDao.findById(Constanta.APPCONFIG_PENSIUNBARU);

            if (("11".equals(penerimaMP.get("kategoriPenerima"))) || Float.parseFloat(formDto.getMpPerbulan()) <= Float.parseFloat(appConfig.getNilaiConfig())){
                //-- Otomatis dapat MPS100% --//
                //-- Do Nothing --//
            }
            //if (formDto.getStatusPengembalianMPS().equals(3L) && !"11".equals(penerimaMP.get("kategoriPenerima"))) {
            else if (formDto.getStatusPengembalianMPS().equals(3L)){
                //Cek Validasi MPS 100%
                Map<String, Date> mps100DateParam = new HashMap<>();
                mps100DateParam.put("tglLahir", tglLahir);
                if (tglMeninggal != null) {  mps100DateParam.put("tglMeninggal", tglMeninggal); }
                else {
                    return new ResponseEntity<>(new MessageUtil("error", "Inputan Tgl Meninggal masih kosong, tidak bisa ambil MPS 100%"), HttpStatus.OK);
                }
                mps100DateParam.put("tglMutasi", tglLahir);
                mps100DateParam.put("tglBekerjaDiBI", tglBekerjaDiBI);
                mps100DateParam.put("tglHentiBayar", tglHentiBayar);
                mps100DateParam.put("tglAwalBayarMP", tglAwalBayarMP);
                mps100DateParam.put("tglLahirPenerimaMP", tglLahirPenerimaMP);

                Map mps100PersenValid = this.checkMps100Persen(formDto, mps100DateParam);
                if (StringUtil.toString(mps100PersenValid.get("status")).equals("0")) {
                    return new ResponseEntity<>(new MessageUtil("error", StringUtil.toString(mps100PersenValid.get("remarks"))), HttpStatus.OK);
                }
            }

            /*if (formDto.getStatusCatatan() != null && formDto.getStatusCatatan() != 2){

            }*/


            PesertaFormDto peserta = new PesertaFormDto();
            peserta.setJenisKelamin(formDto.getJenisKelamin());
            peserta.setTglWafat(formDto.getTglMeninggal());

            List<KeluargaPesertaFormDto> dataKeluargas = extractkeluarga(formDto);

            Suskel suskel = suskelDao.generateSuskel(peserta, dataKeluargas);
            if (suskel != null) {
                formDto.setSuskel(suskel.getId());
                formDto.setNamaSuskel(suskel.getNamaSuskel());
            }

            return new ResponseEntity<>(new MessageUtil("success", "Perhitungan berhasil dilakukan", formDto), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new MessageUtil("error", "Terjadi kesalahan: " + ex.getMessage()), HttpStatus.OK);
        }
    }

    @NotNull
    public List<KeluargaPesertaFormDto> extractkeluarga(@ModelAttribute MutasiPensiunFormDto formDto) {
        List<KeluargaPesertaFormDto> dataKeluargas = new ArrayList<>();
        if (formDto.getDataKeluarga() != null) {
            for (Map<String, String> keluarga : formDto.getDataKeluarga()) {
                KeluargaPesertaFormDto dataKeluarga = new KeluargaPesertaFormDto();
                if (!keluarga.get("id").startsWith("tmp")) {
                    dataKeluarga.setId(keluarga.get("id"));
                }
                dataKeluarga.setNamaKeluarga(keluarga.get("namaKeluarga"));
                dataKeluarga.setJenisKelamin(keluarga.get("jenisKelamin"));
                dataKeluarga.setIdKategoriPenerima(Long.valueOf(keluarga.get("kategoriPenerima")));
                dataKeluarga.setTanggalLahir(DateUtil.stringToDate(keluarga.get("tglLahir")));
                dataKeluarga.setTanggalMenikah(DateUtil.stringToDate(keluarga.get("tglMenikah")));
                dataKeluarga.setTanggalCerai(DateUtil.stringToDate(keluarga.get("tglCerai")));
                dataKeluarga.setTanggalWafat(DateUtil.stringToDate(keluarga.get("tglWafat")));
                dataKeluarga.setTanggalUsia25(DateUtil.stringToDate(keluarga.get("tglUsia25")));
                dataKeluarga.setStatusKawin(keluarga.get("statusKawin").equals("")? null :Long.valueOf(keluarga.get("statusKawin")));
                dataKeluargas.add(dataKeluarga);
            }
        }
        return dataKeluargas;
    }

    @PostMapping("/process")
    public ResponseEntity<MessageUtil> process(@ModelAttribute MutasiPensiunFormDto formDto) {
        if (formDto.getMutasiId() != null) {
            MutasiPensiun mutasi = mutasiPensiunDao.findById(formDto.getMutasiId());
            if (Arrays.asList(new Long[]{2L, 4L}).contains(mutasi.getStatusValidasi().toDto().getId())) {
                return new ResponseEntity<>(new MessageUtil("error", "Mutasi Pensiun sudah tidak dapat di rubah lagi"), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        String formatDate = "dd/MM/yyyy";

        Date tglLahir = DateUtil.stringToDate(formDto.getTglLahir(), formatDate);
        Date tglBekerjaDiBI = DateUtil.stringToDate(formDto.getTglBekerjaDiBI(), formatDate);
        Date tglBerhentiBekerja = DateUtil.stringToDate(formDto.getTglBerhentiBekerjaDiBI(), formatDate);
        Date tglDPHT = DateUtil.stringToDate(formDto.getTglDicatatSebagaiPesertaDPHT(), formatDate);
        Date tglMeninggal = DateUtil.stringToDate(formDto.getTglMeninggal(), formatDate);
        Date tglHentiBayar = DateUtil.stringToDate(formDto.getTglHentiBayar(), formatDate);
        Date tglTundaJatuhTempo = DateUtil.stringToDate(formDto.getTglTundaJatuhTempo(), formatDate);
        Date tglAwalBayarMP = DateUtil.stringToDate(formDto.getTglAwalBayarMP(), formatDate);
        Date tglSPBI = DateUtil.stringToDate(formDto.getTanggalSuratPengantarBI(), formatDate);
        Date tglSKBI = DateUtil.stringToDate(formDto.getTanggalSKBI(), formatDate);
        Date tglSKDapenbi = DateUtil.stringToDate(formDto.getTanggalSKDAPENBI(), formatDate);
        Date tglInput = DateUtil.stringToDate(formDto.getTanggalInput(), formatDate);
        Date tglMutasi = DateUtil.stringToDate(formDto.getTglMutasi(),formatDate);
        Date tglMPBulan13 = DateUtil.stringToDate(formDto.getTglMPBulan13(), formatDate);
        Map<String, String> penerimaMP = formDto.getPenerimaMP();
        Date tglLahirPenerima = DateUtil.stringToDate(penerimaMP.get("tglLahir"), formatDate);
        Date tglUsia25 = DateUtil.stringToDate(penerimaMP.get("tglUsia25"), formatDate);

        GolonganDto golongan = golonganDao.findById(formDto.getGolongan()).toDto();
        AgamaDto agama = agamaDao.findById(formDto.getAgama()).toDto();
        KantorBayarDto kantorBayarDto = kantorBayarDao.findById(formDto.getCabangKpwBI()).toDto();
        PredikatPemberhentianDto predikatPemberhentianDto = predikatPemberhentianDao.findById(formDto.getPredikatPemberhentian()).toDto();
        AlasanHentiDto alasanHentiDto = alasanHentiDao.findById(formDto.getAlasanHenti()).toDto();
        JenisMpsDto jenisMpsDto = jenisMpsDao.findById(formDto.getStatusPengembalianMPS()).toDto();
        KategoriPensiunDto kategoriPensiunDto = kategoriPensiunDao.findById(formDto.getJenisMP()).toDto();
        UsiaBayarDto usiaBayarDto = usiaBayarDao.findById(formDto.getPilihanUsiaBayarMP()).toDto();
        StatusBayarDto statusBayarDto = statusBayarDao.findById(formDto.getStatusBayarMP()).toDto();
        KategoriCatatanDto kategoriCatatanDto = kategoriCatatanDao.findById(formDto.getKategoriCatatan()).toDto();
        StatusKawinDto statusKawinDto = statusKawinDao.findById(formDto.getStatusKawin()).toDto();
        StatusKawinDto statusKawinPenerimaDto = statusKawinDao.findById(Long.valueOf(penerimaMP.get("statusKawin"))).toDto();
        KategoriPenerimaDto kategoriPenerimaDto = kategoriPenerimaDao.findById(Long.valueOf(penerimaMP.get("kategoriPenerima"))).toDto();
        StatusValidasiDto statusValidasiDto = statusValidasiDao.findById(formDto.getStatusCatatan()).toDto();
        Boolean isDalamNegeri = formDto.getIsDalamNegeri() != null && formDto.getIsDalamNegeri().size() > 0;

        Map<String, String> alamat = new HashMap<>();
        if (isDalamNegeri) {
            Kelurahan kelurahan = kelurahanDao.findById(formDto.getKelurahanPenerimaMP());
            KelurahanDto kelurahanDto = kelurahan.toDto();
            Kecamatan kecamatan = kelurahan.getKecamatan();
            KecamatanDto kecamatanDto = kecamatan.toDto();
            Kota kota = kecamatan.getKota();
            KotaDto kotaDto = kota.toDto();
            Provinsi provinsi = kota.getProvinsi();
            ProvinsiDto provinsiDto = provinsi.toDto();

            alamat.put("kelurahan", kelurahanDto.getNamaKelurahan());
            alamat.put("kodePos", formDto.getKodePosPenerimaMP());
            alamat.put("kecamatan", kecamatanDto.getNamaKecamatan());
            alamat.put("kota", kotaDto.getNamaKota());
            alamat.put("provinsi", provinsiDto.getNamaProvinsi());
            alamat.put("negara", null);
            alamat.put("alamatLengkap", formDto.getAlamatIndonesiaPenerimaMP());
        } else {
            NegaraDto negaraDto = formDto.getNegaraPenerimaMP() != null ? negaraDao.findById(formDto.getNegaraPenerimaMP()).toDto() : null;

            alamat.put("kelurahan", null);
            alamat.put("kodePos", null);
            alamat.put("kecamatan", null);
            alamat.put("kota", null);
            alamat.put("provinsi", null);
            alamat.put("negara", negaraDto.getNamaNegara());
            alamat.put("alamatLengkap", formDto.getAlamatLuarNegeriPenerimaMP());
        }

        SuskelDto suskelDto = formDto.getSuskel() != null ? suskelDao.findById(formDto.getSuskel()).toDto() : new SuskelDto();

        Map<String, BaseDto> dtoParam = new HashMap();
        dtoParam.put("golongan", golongan);
        dtoParam.put("agama", agama);
        dtoParam.put("kantorBayarDto", kantorBayarDto);
        dtoParam.put("predikatPemberhentianDto", predikatPemberhentianDto);
        dtoParam.put("alasanHentiDto", alasanHentiDto);
        dtoParam.put("jenisMpsDto", jenisMpsDto);
        dtoParam.put("kategoriPensiunDto", kategoriPensiunDto);
        dtoParam.put("usiaBayarDto", usiaBayarDto);
        dtoParam.put("statusBayarDto", statusBayarDto);
        dtoParam.put("kategoriCatatanDto", kategoriCatatanDto);
        dtoParam.put("statusKawinDto", statusKawinDto);
        dtoParam.put("statusKawinPenerimaDto", statusKawinPenerimaDto);
        dtoParam.put("kategoriPenerimaDto", kategoriPenerimaDto);
        dtoParam.put("statusValidasiDto", statusValidasiDto);
        dtoParam.put("suskelDto", suskelDto);

        Map<String, Date> dateParam = new HashMap();
        dateParam.put("tglLahir", tglLahir);
        dateParam.put("tglBekerjaDiBI", tglBekerjaDiBI);
        dateParam.put("tglBerhentiBekerja", tglBerhentiBekerja);
        dateParam.put("tglDPHT", tglDPHT);
        dateParam.put("tglMeninggal", tglMeninggal);
        dateParam.put("tglHentiBayar", tglHentiBayar);
        dateParam.put("tglTundaJatuhTempo", tglTundaJatuhTempo);
        dateParam.put("tglAwalBayarMP", tglAwalBayarMP);
        dateParam.put("tglSPBI", tglSPBI);
        dateParam.put("tglSKBI", tglSKBI);
        dateParam.put("tglSKDapenbi", tglSKDapenbi);
        dateParam.put("tglInput", tglInput);
        dateParam.put("tglMPBulan1x3", tglMPBulan13);
        dateParam.put("tglLahirPenerima", tglLahirPenerima);
        dateParam.put("tglUsia25", tglUsia25);

        Map result = this.saveMutasi(formDto, dtoParam, dateParam, alamat);

        if (result.get("PAR_STATUS_EKSEKUSI").equals('1') && (result.get("PAR_ID_MUTASI_VAL") != null || formDto.getMutasiId() != null)) {
            Long idMutasi = result.get("PAR_ID_MUTASI_VAL") != null ? Long.valueOf(StringUtil.toString(result.get("PAR_ID_MUTASI_VAL"))) : formDto.getMutasiId();
            mutasiKeluargaPensiunDao.deleteByMutasiPensiun(idMutasi);
            if (formDto.getDataKeluarga() != null) {
                int keluargaSeq = 0;
                for (Map<String, String> keluarga : formDto.getDataKeluarga()) {
                    MutasiKeluargaPensiun dataKeluarga = new MutasiKeluargaPensiun();
                    if (!keluarga.get("id").contains("tmp")) {
                        dataKeluarga.setId(keluarga.get("id"));
                        ++keluargaSeq;
                    } else {
                        dataKeluarga.setId(formDto.getNip() + "-" + (++keluargaSeq));
                    }
                    dataKeluarga.setMutasiPensiun(new MutasiPensiun(idMutasi));
                    dataKeluarga.setNamaKeluarga(keluarga.get("namaKeluarga"));
                    dataKeluarga.setJenisKelamin(keluarga.get("jenisKelamin").charAt(0));
                    dataKeluarga.setKategoriPenerima(new KategoriPenerima(Long.valueOf(keluarga.get("kategoriPenerima"))));
                    dataKeluarga.setTglLahir(DateUtil.stringToDate(keluarga.get("tglLahir")));
                    dataKeluarga.setTglMenikah(DateUtil.stringToDate(keluarga.get("tglMenikah")));
                    dataKeluarga.setTglCerai(DateUtil.stringToDate(keluarga.get("tglCerai")));
                    dataKeluarga.setTglWafat(DateUtil.stringToDate(keluarga.get("tglWafat")));
                    dataKeluarga.setTglUsia25(DateUtil.stringToDate(keluarga.get("tglUsia25")));
                    dataKeluarga.setStatusKawin(new StatusKawin(Long.valueOf(keluarga.get("statusKawin"))));
                    dataKeluarga.setIsPenerimaMp(keluarga.get("namaKeluarga").equals(formDto.getNamaPenerimaMP()) ? "1" : "0");
                    dataKeluarga.setNip(formDto.getNip());
                    mutasiKeluargaPensiunDao.save(dataKeluarga);
                }
            }

            if (statusValidasiDto.getId().equals(2L)) {
                if (formDto.getDataKeluarga() != null) {
                    keluargaPensiunDao.deleteByNip(formDto.getNip());
                    int keluargaSeq = 0;
                    for (Map<String, String> keluarga : formDto.getDataKeluarga()) {
                        KeluargaPensiun dataKeluarga = new KeluargaPensiun();
                        dataKeluarga.setId(formDto.getNip() + "-" + (++keluargaSeq));
                        dataKeluarga.setNamaKeluarga(keluarga.get("namaKeluarga"));
                        dataKeluarga.setJenisKelamin(keluarga.get("jenisKelamin"));
                        dataKeluarga.setKategoriPenerima(new KategoriPenerima(Long.valueOf(keluarga.get("kategoriPenerima"))));
                        dataKeluarga.setTglLahir(DateUtil.stringToDate(keluarga.get("tglLahir")));
                        dataKeluarga.setTglMenikah(DateUtil.stringToDate(keluarga.get("tglMenikah")));
                        dataKeluarga.setTglCerai(DateUtil.stringToDate(keluarga.get("tglCerai")));
                        dataKeluarga.setTglWafat(DateUtil.stringToDate(keluarga.get("tglWafat")));
                        dataKeluarga.setTglUsia25(DateUtil.stringToDate(keluarga.get("tglUsia25")));
                        dataKeluarga.setStatusKawin(new StatusKawin(Long.valueOf(keluarga.get("statusKawin"))));
                        dataKeluarga.setNip(formDto.getNip());
                        keluargaPensiunDao.save(dataKeluarga);
                    }
                }
            }

            return new ResponseEntity<>(new MessageUtil("success", StringUtil.toString(result.get("PAR_MSG")), formDto), HttpStatus.OK);
        }

        return new ResponseEntity<>(new MessageUtil("error", result.get("PAR_MSG") == null ? "Terjadi kesalahan" : StringUtil.toString(result.get("PAR_MSG")), formDto), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    abstract Map checkMps100Persen(MutasiPensiunFormDto formDto, Map<String, Date> dateParam);

    abstract Map saveMutasi(MutasiPensiunFormDto formDto, Map<String, BaseDto> dtoParam, Map<String, Date> dateParam, Map<String, String> alamatParam);
}
