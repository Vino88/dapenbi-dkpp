package com.dapenbi.dkpp.controller.api;

import com.dapenbi.dkpp.Constanta;
import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.*;
import com.dapenbi.dkpp.dto.*;
import com.dapenbi.dkpp.form.MutasiPensiunFormDto;
import com.dapenbi.dkpp.model.AppConfig;
import com.dapenbi.dkpp.model.MPensiun;
import com.dapenbi.dkpp.model.MutasiPensiun;
import com.dapenbi.dkpp.util.DkppUserStamp;
import com.dapenbi.dkpp.util.ReportCompiler;
import com.dapenbi.dkpp.util.ReportUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(PathPrefix.API + PathPrefix.MUTASI_PENSIUN_TUNDA)
public class MutasiPensiunTundaApiController extends MutasiPensiunBaseApiController {

    private MPensiunDao pensiunDao;

    private DataSource dataSource;

    @Autowired
    private AppConfigDao appConfigDao;

    @Autowired
    public MutasiPensiunTundaApiController(MutasiPensiunDao mutasiPensiunDao, MutasiKeluargaPensiunDao mutasiKeluargaPensiunDao, KategoriPenerimaDao kategoriPenerimaDao, GolonganDao golonganDao, AgamaDao agamaDao, KantorBayarDao kantorBayarDao, PredikatPemberhentianDao predikatPemberhentianDao, AlasanHentiDao alasanHentiDao, JenisMpsDao jenisMpsDao, KategoriPensiunDao kategoriPensiunDao, UsiaBayarDao usiaBayarDao, StatusBayarDao statusBayarDao, KategoriCatatanDao kategoriCatatanDao, StatusKawinDao statusKawinDao, StatusValidasiDao statusValidasiDao, KelurahanDao kelurahanDao, NegaraDao negaraDao, SuskelDao suskelDao, MPensiunDao pensiunDao, KeluargaPensiunDao keluargaPensiunDao, DataSource dataSource) {
        this.mutasiPensiunDao = mutasiPensiunDao;
        this.mutasiKeluargaPensiunDao = mutasiKeluargaPensiunDao;
        this.kategoriPenerimaDao = kategoriPenerimaDao;
        this.golonganDao = golonganDao;
        this.agamaDao = agamaDao;
        this.kantorBayarDao = kantorBayarDao;
        this.predikatPemberhentianDao = predikatPemberhentianDao;
        this.alasanHentiDao = alasanHentiDao;
        this.jenisMpsDao = jenisMpsDao;
        this.kategoriPensiunDao = kategoriPensiunDao;
        this.usiaBayarDao = usiaBayarDao;
        this.statusBayarDao = statusBayarDao;
        this.kategoriCatatanDao = kategoriCatatanDao;
        this.statusKawinDao = statusKawinDao;
        this.statusValidasiDao = statusValidasiDao;
        this.kelurahanDao = kelurahanDao;
        this.negaraDao = negaraDao;
        this.suskelDao = suskelDao;
        this.pensiunDao = pensiunDao;
        this.keluargaPensiunDao = keluargaPensiunDao;
        this.dataSource = dataSource;
    }

    @GetMapping("/pensiun-tunda")
    public Page<MutasiPensiunDto> pensiunTunda(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam) {
        Page<MutasiPensiun> uIt = mutasiPensiunDao.findAllMutasiPensiunTunda("%" + searchParam + "%", pageRequest);
        return uIt.map(u -> {
            MutasiPensiunDto dto = u.toDto();
            dto.setKategoriPenerima(u.getKategoriPenerima().toDto());
            dto.setKantorBayar(u.getKantorBayar().toDto());
            dto.setKategoriPensiun(u.getKategoriPensiun().toDto());
            dto.setJenisMps(u.getJenisMps().toDto());
            if (u.getStatusValidasi() != null) { dto.setStatusValidasi(u.getStatusValidasi().toDto()); }
            if (u.getKategoriMutasi() != null) { dto.setKategoriMutasi(u.getKategoriMutasi().toDto()); }

            return dto;
        });
    }

    @GetMapping("/belum-validasi")
    public Page<MutasiPensiunDto>pensiunTundaBelumValidasi(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam){
        Page<MutasiPensiun> uIt = mutasiPensiunDao.findAllMutasiPensiunTundaBelumValidasi("%" + searchParam + "%", pageRequest);
        return uIt.map(u->{
            MutasiPensiunDto dto = u.toDto();
            dto.setKategoriPenerima(u.getKategoriPenerima().toDto());
            dto.setKantorBayar(u.getKantorBayar().toDto());
            dto.setKategoriPensiun(u.getKategoriPensiun().toDto());
            dto.setJenisMps(u.getJenisMps().toDto());
            if (u.getStatusValidasi() != null) { dto.setStatusValidasi(u.getStatusValidasi().toDto()); }
            if (u.getKategoriMutasi() != null) { dto.setKategoriMutasi(u.getKategoriMutasi().toDto()); }

            return dto;
        });
    }

    @GetMapping("/dibayar")
    public Page<MPensiunDto> dibayar(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam) {
        AppConfig appConfig = appConfigDao.findById(Constanta.APPCONFIG_PENSIUNTUNDA);
        Page<MPensiun> uIt = pensiunDao.findAllPensiunTundaJatuhTempoDiBayar("%" + searchParam + "%",  pageRequest);
        return getPensiunDto(uIt);

        /*Page<MutasiPensiun> uIt = mutasiPensiunDao.findAllMutasiPensiunTundaDibayar("%" + searchParam + "%", pageRequest);
        return uIt.map(u -> {
            MutasiPensiunDto dto = u.toDto();
            dto.setKategoriPenerima(u.getKategoriPenerima().toDto());
            dto.setKantorBayar(u.getKantorBayar().toDto());
            dto.setKategoriPensiun(u.getKategoriPensiun().toDto());
            dto.setJenisMps(u.getJenisMps().toDto());
            if (u.getStatusValidasi() != null) { dto.setStatusValidasi(u.getStatusValidasi().toDto()); }
            if (u.getKategoriMutasi() != null) { dto.setKategoriMutasi(u.getKategoriMutasi().toDto()); }

            return dto;
        });*/
    }

    @GetMapping("/belum-jatuh-tempo")
    public Page<MPensiunDto> belumJatuhTempo(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam) {
        AppConfig appConfig = appConfigDao.findById(Constanta.APPCONFIG_PENSIUNTUNDA);
        Page<MPensiun> uIt = pensiunDao.findAllPensiunTundaJatuhTempo("%" + searchParam + "%",  pageRequest);
        return getPensiunDto(uIt);
    }

    private Page<MPensiunDto> getPensiunDto(Page<MPensiun> uIt) {
        return uIt.map(u -> {
            MPensiunDto dto = u.toDto();
            dto.setKategoriPenerima(u.getKategoriPenerima().toDto());
            dto.setKantorBayar(u.getKantorBayar().toDto());
            dto.setKategoriPensiun(u.getKategoriPensiun().toDto());
            dto.setJenisMps(u.getJenisMps().toDto());

            return dto;
        });
    }

    @Override
    Map checkMps100Persen(MutasiPensiunFormDto formDto, Map<String, Date> dateParam) {
        return mutasiPensiunDao.checkMps100PersenTunda(formDto.getNip(), dateParam.get("tglMutasi"), formDto.getPeriodeMutasi(), dateParam.get("tglAwalBayarMP"), formDto.getJenisMP(), formDto.getIsJatuhTempoDibayar(), dateParam.get("tglMeninggal"));
    }

    @Override
    Map saveMutasi(MutasiPensiunFormDto formDto, Map<String, BaseDto> dtoParam, Map<String, Date> dateParam, Map<String, String> alamat) {
        DkppUserDetail user = DkppUserStamp.getUserPrincipal();
        RoleDto role = user.getUser().getRoles().get(0);
        GolonganDto golongan = (GolonganDto) dtoParam.get("golongan");
        AgamaDto agama = (AgamaDto) dtoParam.get("agama");
        KantorBayarDto kantorBayarDto = (KantorBayarDto) dtoParam.get("kantorBayarDto");
        PredikatPemberhentianDto predikatPemberhentianDto = (PredikatPemberhentianDto) dtoParam.get("predikatPemberhentianDto");
        AlasanHentiDto alasanHentiDto = (AlasanHentiDto) dtoParam.get("alasanHentiDto");
        JenisMpsDto jenisMpsDto = (JenisMpsDto) dtoParam.get("jenisMpsDto");
        KategoriPensiunDto kategoriPensiunDto = (KategoriPensiunDto) dtoParam.get("kategoriPensiunDto");
        UsiaBayarDto usiaBayarDto = (UsiaBayarDto) dtoParam.get("usiaBayarDto");
        StatusBayarDto statusBayarDto = (StatusBayarDto) dtoParam.get("statusBayarDto");
        KategoriCatatanDto kategoriCatatanDto = (KategoriCatatanDto) dtoParam.get("kategoriCatatanDto");
        StatusKawinDto statusKawinDto = (StatusKawinDto) dtoParam.get("statusKawinDto");
        StatusKawinDto statusKawinPenerimaDto = (StatusKawinDto) dtoParam.get("statusKawinPenerimaDto");
        KategoriPenerimaDto kategoriPenerimaDto = (KategoriPenerimaDto) dtoParam.get("kategoriPenerimaDto");
        StatusValidasiDto statusValidasiDto = (StatusValidasiDto) dtoParam.get("statusValidasiDto");
        SuskelDto suskelDto = (SuskelDto) dtoParam.get("suskelDto");
        Map<String, String> penerimaMP = formDto.getPenerimaMP();
        Boolean isDalamNegeri = formDto.getIsDalamNegeri() != null && formDto.getIsDalamNegeri().size() > 0;

        return mutasiPensiunDao.processMutasiPensiunTunda(role.getId(), DkppUserStamp.getCompName(), user.getUsername(), formDto.getMutasiId(), null, formDto.getJenisMP(), formDto.getPeriodeMutasi(), dateParam.get("tglInput"), formDto.getNip(), formDto.getNama(), formDto.getJenisKelamin().toString(), dateParam.get("tglLahir"), dateParam.get("tglBekerjaDiBI"), dateParam.get("tglDPHT"), dateParam.get("tglBerhentiBekerja"), null, dateParam.get("tglMeninggal"), null, formDto.getGolongan(), golongan.getPangkat(), formDto.getAgama(), agama.getNamaAgama(), formDto.getCabangKpwBI(), kantorBayarDto.getNamaKantorBayar(), formDto.getPredikatPemberhentian(), predikatPemberhentianDto.getNamaPemberhentian(), formDto.getAlasanHenti(), alasanHentiDto.getKeterangan(), dateParam.get("tglSPBI"), formDto.getNomorSuratPengantarBI(), dateParam.get("tglSKBI"), formDto.getNomorSKBI(), formDto.getGajiPokokTerakhir(), formDto.getUpahVeteran(), formDto.getStatusPengembalianMPS(), jenisMpsDto.getNamamps(), formDto.getJenisMP(), kategoriPensiunDto.getNamaKategoriPensiun(), formDto.getPilihanUsiaBayarMP(), usiaBayarDto.getNamaUsiaBayar(), formDto.getStatusBayarMP(), statusBayarDto.getStatusBayar(), formDto.getStatusKawin(), statusKawinDto.getStatusKawin(), dateParam.get("tglTundaJatuhTempo"), dateParam.get("tglAwalBayarMP"), dateParam.get("tglMPBulan13"), dateParam.get("tglHentiBayar"), penerimaMP.get("id"), penerimaMP.get("namaKeluarga"), dateParam.get("tglLahirPenerima"), penerimaMP.get("jenisKelamin"), kategoriPenerimaDto.getId(), kategoriPenerimaDto.getNamaKategoriPenerima(), dateParam.get("tglSKDapenbi"), formDto.getNomorSKDAPENBI(), dateParam.get("tglUsia25"), isDalamNegeri, formDto.getProvinsiPenerimaMP(), alamat.get("provinisi"), formDto.getKotaPenerimaMP(), alamat.get("kota"), formDto.getKecamatanPenerimaMP(), alamat.get("kecamatan"), formDto.getKelurahanPenerimaMP(), alamat.get("kelurahan"), alamat.get("kodePos"), alamat.get("alamatLengkap"), formDto.getRtPenerimaMP(), formDto.getRwPenerimaMP(), formDto.getNegaraPenerimaMP(), alamat.get("negara"), formDto.getSuskel(), suskelDto.getNamaSuskel(), formDto.getKategoriCatatan(), kategoriCatatanDto.getNamaKategoriCatatan(), statusKawinPenerimaDto.getId(), statusKawinPenerimaDto.getStatusKawin(), formDto.getNoHPPenerimaMP(), formDto.getNoTlpPenerimaMP(), formDto.getEmailPenerimaMP(), formDto.getStatusCatatan(), statusValidasiDto.getNamaValidasi(), null, null, formDto.getCatatan(), null, null);
    }

    @GetMapping("/report-tunda")
    public void report(HttpServletResponse httpServletResponse, @RequestParam("nip") String nip, @RequestParam("periodeMutasi") String periodeMutasi, @RequestParam("idKategoriPensiun") String idKategoriPensiun, @RequestParam("idJenisMps") String idJenisMps, @RequestParam("idKategoriMutasi") String idKategoriMutasi, @RequestParam("tipeReport") String tipeReport, @RequestParam("kategoriPenerima") String kategoriPenerima, @RequestParam(name = "download", required = false) Boolean download) {
        String jasperFileName = null;
        String subReport = null;
        HashMap<String, Object> parameters = null;

        try {
            switch (tipeReport) {
                case "catatan_perhitungan_manfaat_pensiun":
                    switch (idKategoriPensiun) {
                        case "PN":
                            switch (idJenisMps) {
                                case "5": {
                                    jasperFileName = "PerhitunganMP_NormalTanpaMPS20Persen_A4";
                                    subReport = "keluarga_pensiun";
                                    parameters = new HashMap<>();
                                    parameters.put("id_jenis_mps", idJenisMps);
                                    parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                    parameters.put("id_kategori_mutasi", idKategoriMutasi);
                                    parameters.put("nip", nip);
                                    parameters.put("periode_mutasi", periodeMutasi);

                                    break;
                                }
                                case "1": {
                                    jasperFileName = "PerhitunganMP_NormalDenganMPS20persen_A4";
                                    subReport = "keluarga_pensiun";
                                    parameters = new HashMap<>();
                                    parameters.put("id_jenis_mps", idJenisMps);
                                    parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                    parameters.put("id_kategori_mutasi", idKategoriMutasi);
                                    parameters.put("nip", nip);
                                    parameters.put("periode_mutasi", periodeMutasi);

                                    break;
                                }
                                case "2": {
                                    jasperFileName = "PerhitunganMP_NormalDenganMPS10jt_A4";
                                    subReport = "keluarga_pensiun";
                                    parameters = new HashMap<>();
                                    parameters.put("id_jenis_mps", idJenisMps);
                                    parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                    parameters.put("id_kategori_mutasi", idKategoriMutasi);
                                    parameters.put("nip", nip);
                                    parameters.put("periode_mutasi", periodeMutasi);

                                    break;
                                }
                                case "3" :{
                                    jasperFileName = "PensiunMPS100persen";
                                    subReport = "keluarga_pensiun";
                                    parameters = new HashMap<>();
                                    parameters.put("id_jenis_mps", idJenisMps);
                                    parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                    parameters.put("id_kategori_mutasi", idKategoriMutasi);
                                    parameters.put("nip", nip);
                                    parameters.put("periode_mutasi", periodeMutasi);
                                    break;
                                }

                                case "4": {
                                    jasperFileName = "PerhitunganMP_NormalTanpaMPS20Persen_MPS10jtA4";
                                    subReport = "keluarga_pensiun";
                                    parameters = new HashMap<>();
                                    parameters.put("id_jenis_mps", idJenisMps);
                                    parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                    parameters.put("id_kategori_mutasi", idKategoriMutasi);
                                    parameters.put("nip", nip);
                                    parameters.put("periode_mutasi", periodeMutasi);

                                    break;
                                }
                                default:
                                    break;
                            }
                            break;
                        case "PD":
                            switch (idJenisMps) {
                                case "5":
                                    jasperFileName = "PerhitunganMP_Dipercepat_TanpaMPS20persen_A4";
                                    subReport = "keluarga_pensiun";
                                    parameters = new HashMap<>();
                                    parameters.put("id_jenis_mps", idJenisMps);
                                    parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                    parameters.put("id_kategori_mutasi", idKategoriMutasi);
                                    parameters.put("nip", nip);
                                    parameters.put("periode_mutasi", periodeMutasi);

                                    break;

                                case "1":
                                    jasperFileName = "PerhitunganMP_DipercepatDengan_MPS20persen_A4";
                                    subReport = "keluarga_pensiun";
                                    parameters = new HashMap<>();
                                    parameters.put("id_jenis_mps", idJenisMps);
                                    parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                    parameters.put("id_kategori_mutasi", idKategoriMutasi);
                                    parameters.put("nip", nip);
                                    parameters.put("periode_mutasi", periodeMutasi);

                                    break;

                                case "2":
                                    jasperFileName = "PerhitunganMP_Dipercepat_DenganMPS10jt_A4";
                                    subReport = "keluarga_pensiun";
                                    parameters = new HashMap<>();
                                    parameters.put("id_jenis_mps", idJenisMps);
                                    parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                    parameters.put("id_kategori_mutasi", idKategoriMutasi);
                                    parameters.put("nip", nip);
                                    parameters.put("periode_mutasi", periodeMutasi);

                                    break;

                                case "3" :
                                    jasperFileName = "PensiunMPS100persen";
                                    subReport = "keluarga_pensiun";
                                    parameters = new HashMap<>();
                                    parameters.put("id_jenis_mps", idJenisMps);
                                    parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                    parameters.put("id_kategori_mutasi", idKategoriMutasi);
                                    parameters.put("nip", nip);
                                    parameters.put("periode_mutasi", periodeMutasi);
                                    break;


                                case "4":
                                    jasperFileName = "PerhitunganMP_Dipercepat_DenganMPS20persen_MPS10jt_A4";
                                    subReport = "keluarga_pensiun";
                                    parameters = new HashMap<>();
                                    parameters.put("id_jenis_mps", idJenisMps);
                                    parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                    parameters.put("id_kategori_mutasi", idKategoriMutasi);
                                    parameters.put("nip", nip);
                                    parameters.put("periode_mutasi", periodeMutasi);

                                    break;
                            }
                        default:
                            break;

                        case "PC":
                            switch (idJenisMps) {
                                case "5":
                                    jasperFileName = "PerhitunganMP_CACAT_TanpaMPS20persen_MPS10jt";
                                    subReport = "keluarga_pensiun";
                                    parameters = new HashMap<>();
                                    parameters.put("id_jenis_mps", idJenisMps);
                                    parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                    parameters.put("id_kategori_mutasi", idKategoriMutasi);
                                    parameters.put("nip", nip);
                                    parameters.put("id_kategori_penerima_mp", "1");
                                    parameters.put("periode_mutasi", periodeMutasi);

                                    break;


                                case "1":
                                    jasperFileName = "PerhitunganMP_CACAT_DenganMPS20persen_A4";
                                    subReport = "keluarga_pensiun";
                                    parameters = new HashMap<>();
                                    parameters.put("id_jenis_mps", idJenisMps);
                                    parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                    parameters.put("id_kategori_mutasi", idKategoriMutasi);
                                    parameters.put("nip", nip);
                                    parameters.put("id_kategori_penerima_mp", "1");
                                    parameters.put("periode_mutasi", periodeMutasi);

                                    break;

                                case "2":
                                    jasperFileName = "PerhitunganMP_Cacat_DenganMPS10jt_A4";
                                    subReport = "keluarga_pensiun";
                                    parameters = new HashMap<>();
                                    parameters.put("id_jenis_mps", idJenisMps);
                                    parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                    parameters.put("id_kategori_mutasi", idKategoriMutasi);
                                    parameters.put("nip", nip);
                                    parameters.put("id_kategori_penerima_mp", "1");
                                    parameters.put("periode_mutasi", periodeMutasi);

                                    break;

                                case "3":
                                    jasperFileName = "PensiunMPS100persen";
                                    subReport = "keluarga_pensiun";
                                    parameters = new HashMap<>();
                                    parameters.put("id_jenis_mps", idJenisMps);
                                    parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                    parameters.put("id_kategori_mutasi", idKategoriMutasi);
                                    parameters.put("nip", nip);
                                    parameters.put("periode_mutasi", periodeMutasi);
                                    break;


                                case "4":
                                    jasperFileName = "PerhitunganMP_CACAT_DenganMPS20persen_MPS10jt_A4";
                                    subReport = "keluarga_pensiun";
                                    parameters = new HashMap<>();
                                    parameters.put("id_jenis_mps", idJenisMps);
                                    parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                    parameters.put("id_kategori_mutasi", idKategoriMutasi);
                                    parameters.put("nip", nip);
                                    parameters.put("id_kategori_penerima_mp", "1");
                                    parameters.put("periode_mutasi", periodeMutasi);

                                    break;

                            }

                            break;

                        case "PM":
                            switch (idJenisMps) {
                                case "5": {
                                    switch (kategoriPenerima) {
                                        case "2":

                                            jasperFileName = "PerhitunganMP_jandaDuda_meninggal_tanpa_MPS20";
                                            subReport = "keluarga_pensiun";
                                            parameters = new HashMap<>();
                                            parameters.put("id_jenis_mps", idJenisMps);
                                            parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                            parameters.put("id_kategori_mutasi", idKategoriMutasi);
                                            parameters.put("nip", nip);
                                            parameters.put("id_kategori_penerima_mp", "2");
                                            parameters.put("periode_mutasi", periodeMutasi);

                                            break;

                                        case "11":
                                            jasperFileName = "PerhitunganMP_Sekaligus_KepadaAhliWaris";
                                            subReport = "keluarga_pensiun";
                                            parameters = new HashMap<>();
                                            parameters.put("id_jenis_mps", idJenisMps);
                                            parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                            parameters.put("id_kategori_mutasi", idKategoriMutasi);
                                            parameters.put("nip", nip);
                                            parameters.put("id_kategori_penerima_mp", "11");
                                            parameters.put("periode_mutasi", periodeMutasi);
                                            break;

                                        default:
                                            jasperFileName = "PerhitunganMP_Anak_tanpa_MPS20persen_A4";
                                            subReport = "keluarga_pensiun";
                                            parameters = new HashMap<>();
                                            parameters.put("id_jenis_mps", idJenisMps);
                                            parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                            parameters.put("id_kategori_mutasi", idKategoriMutasi);
                                            parameters.put("nip", nip);
                                            parameters.put("periode_mutasi", periodeMutasi);
                                            break;
                                    }
                                }
                                break;

                                case "1": {
                                    switch (kategoriPenerima) {
                                        case "2":
                                            jasperFileName = "PerhitunganMP_Janda_meninggal_mps20persen";
                                            subReport = "keluarga_pensiun";
                                            parameters = new HashMap<>();
                                            parameters.put("id_jenis_mps", idJenisMps);
                                            parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                            parameters.put("id_kategori_mutasi", idKategoriMutasi);
                                            parameters.put("nip", nip);
                                            parameters.put("id_kategori_penerima_mp", "2");
                                            parameters.put("periode_mutasi", periodeMutasi);
                                            break;

                                        case "11":
                                            jasperFileName = "PerhitunganMP_Sekaligus_KepadaAhliWaris";
                                            subReport = "keluarga_pensiun";
                                            parameters = new HashMap<>();
                                            parameters.put("id_jenis_mps", idJenisMps);
                                            parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                            parameters.put("id_kategori_mutasi", idKategoriMutasi);
                                            parameters.put("nip", nip);
                                            parameters.put("id_kategori_penerima_mp", "11");
                                            parameters.put("periode_mutasi", periodeMutasi);
                                            break;

                                        default:
                                            jasperFileName = "PerhitunganMP_Anak_MPS20persen_A4";
                                            subReport = "keluarga_pensiun";
                                            parameters = new HashMap<>();
                                            parameters.put("id_jenis_mps", idJenisMps);
                                            parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                            parameters.put("id_kategori_mutasi", idKategoriMutasi);
                                            parameters.put("nip", nip);
                                            parameters.put("periode_mutasi", periodeMutasi);

                                            break;
                                    }
                                }
                                break;

                                case "2": {
                                    switch (kategoriPenerima) {
                                        case "2":
                                            jasperFileName = "PerhitunganMP_Janda_meninggal_mps10jt_A4";
                                            subReport = "keluarga_pensiun";
                                            parameters = new HashMap<>();
                                            parameters.put("id_jenis_mps", idJenisMps);
                                            parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                            parameters.put("id_kategori_mutasi", idKategoriMutasi);
                                            parameters.put("nip", nip);
                                            parameters.put("id_kategori_penerima_mp", "2");
                                            parameters.put("periode_mutasi", periodeMutasi);
                                            break;

                                        case "11":
                                            jasperFileName = "PerhitunganMP_Sekaligus_KepadaAhliWaris";
                                            subReport = "keluarga_pensiun";
                                            parameters = new HashMap<>();
                                            parameters.put("id_jenis_mps", idJenisMps);
                                            parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                            parameters.put("id_kategori_mutasi", idKategoriMutasi);
                                            parameters.put("nip", nip);
                                            parameters.put("id_kategori_penerima_mp", "11");
                                            parameters.put("periode_mutasi", periodeMutasi);
                                            break;

                                        default:
                                            jasperFileName = "PerhitunganMP_Anak_MPS10juta_A4";
                                            subReport = "keluarga_pensiun";
                                            parameters = new HashMap<>();
                                            parameters.put("id_jenis_mps", idJenisMps);
                                            parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                            parameters.put("id_kategori_mutasi", idKategoriMutasi);
                                            parameters.put("nip", nip);
                                            parameters.put("periode_mutasi", periodeMutasi);

                                            break;
                                    }
                                }
                                break;
                                case "3": {
                                    jasperFileName = "PensiunMPS100persen";
                                    subReport = "keluarga_pensiun";
                                    parameters = new HashMap<>();
                                    parameters.put("id_jenis_mps", idJenisMps);
                                    parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                    parameters.put("id_kategori_mutasi", idKategoriMutasi);
                                    parameters.put("nip", nip);
                                    parameters.put("periode_mutasi", periodeMutasi);
                                    break;
                                }

                                case "4": {
                                    switch (kategoriPenerima) {
                                        case "2":
                                            jasperFileName = "PerhitunganMP_Janda_meninggal_mps20persen_mps10jt_A4";
                                            subReport = "keluarga_pensiun";
                                            parameters = new HashMap<>();
                                            parameters.put("id_jenis_mps", idJenisMps);
                                            parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                            parameters.put("id_kategori_mutasi", idKategoriMutasi);
                                            parameters.put("nip", nip);
                                            parameters.put("id_kategori_penerima_mp", "2");
                                            parameters.put("periode_mutasi", periodeMutasi);

                                            break;

                                        case "11":
                                            jasperFileName = "PerhitunganMP_Sekaligus_KepadaAhliWaris";
                                            subReport = "keluarga_pensiun";
                                            parameters = new HashMap<>();
                                            parameters.put("id_jenis_mps", idJenisMps);
                                            parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                            parameters.put("id_kategori_mutasi", idKategoriMutasi);
                                            parameters.put("nip", nip);
                                            parameters.put("id_kategori_penerima_mp", "11");
                                            parameters.put("periode_mutasi", periodeMutasi);
                                            break;

                                        default:
                                            jasperFileName = "PerhitunganMP_Anak_MPS20persen_MPS10juta";
                                            subReport = "keluarga_pensiun";
                                            parameters = new HashMap<>();
                                            parameters.put("id_jenis_mps", idJenisMps);
                                            parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                            parameters.put("id_kategori_mutasi", idKategoriMutasi);
                                            parameters.put("nip", nip);
                                            parameters.put("periode_mutasi", periodeMutasi);

                                            break;
                                    }
                                }
                            }
                            break;
                    }
                    break;


                case "kartu_peserta_pensiun":
                    jasperFileName = "KartuPensiun";
                    parameters = new HashMap<>();
                    parameters.put("nip", nip);
                    break;

                case "struk_manfaat_pensiun":
                    jasperFileName = "Perhitungan_MP_Invoice(A5-4)";
                    parameters = new HashMap<>();
                    parameters.put("id_jenis_mps", idJenisMps);
                    parameters.put("id_kategori_pensiun", idKategoriPensiun);
                    parameters.put("id_kategori_mutasi", idKategoriMutasi);
                    parameters.put("nip", nip);
                    parameters.put("periode_mutasi", periodeMutasi);
                    break;

                case "struk_bayangan_mp":
                    jasperFileName = "StrukMPBayangan";
                    parameters = new HashMap<>();
                    parameters.put("id_jenis_mps", idJenisMps);
                    parameters.put("id_kategori_pensiun", idKategoriPensiun);
                    parameters.put("nip", nip);
                    parameters.put("periode_mutasi", periodeMutasi);

                    break;

                case "surat_keputusan":
                    switch (idKategoriPensiun) {
                        case "PN":
                            switch (idJenisMps) {
                                case "5": {
                                    jasperFileName = "Keputusan_HakAtasManfaat_PENSIUN_NORMAL";
                                    subReport = "susunan_keluarga2";
                                    parameters = new HashMap<>();
                                    parameters.put("nip", nip);
                                    parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                    parameters.put("id_jenis_mps", idJenisMps);
                                    parameters.put("id_kategori_mutasi", idKategoriMutasi);
                                }
                                break;
                                case "1": {
                                    jasperFileName = "Keputusan_HakAtasManfaat_PENSIUN_NORMAL_MPS20persen";
                                    subReport = "susunan_keluarga2";
                                    parameters = new HashMap<>();
                                    parameters.put("nip", nip);
                                    parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                    parameters.put("id_jenis_mps", idJenisMps);
                                    parameters.put("id_kategori_mutasi", idKategoriMutasi);

                                }
                                break;
                                case "2": {
                                    jasperFileName = "Keputusan_HakAtasManfaat_PENSIUN_NORMAL(Lebih10JUTA)";
                                    subReport = "susunan_keluarga2";
                                    parameters = new HashMap<>();
                                    parameters.put("nip", nip);
                                    parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                    parameters.put("id_jenis_mps", idJenisMps);
                                    parameters.put("id_kategori_mutasi", idKategoriMutasi);
                                }
                                break;

                                case "3": {
                                    jasperFileName = "SK_MPS_100persen";
                                    subReport = "susunan_keluarga2";
                                    parameters = new HashMap<>();
                                    parameters.put("nip", nip);
                                    parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                    parameters.put("id_jenis_mps", idJenisMps);
                                    parameters.put("id_kategori_mutasi", idKategoriMutasi);
                                    break;
                                }

                                case "4": {
                                    jasperFileName = "Keputusan_HakAtasManfaat_PENSIUN_20persen_10juta";
                                    subReport = "susunan_keluarga2";
                                    parameters = new HashMap<>();
                                    parameters.put("nip", nip);
                                    parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                    parameters.put("id_jenis_mps", idJenisMps);
                                    parameters.put("id_kategori_mutasi", idKategoriMutasi);

                                    break;
                                }
                                default:
                            }
                            break;
                        case "PD":
                            switch (idJenisMps) {
                                case "5": {
                                    jasperFileName = "Keputusan_HakAtasManfaat_PENSIUN_DIPERCEPAT";
                                    subReport = "susunan_keluarga2";
                                    parameters = new HashMap<>();
                                    parameters.put("nip", nip);
                                    parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                    parameters.put("id_jenis_mps", idJenisMps);
                                    parameters.put("id_kategori_mutasi", idKategoriMutasi);

                                }
                                break;
                                case "1": {
                                    jasperFileName = "Keputusan_HakAtasManfaat_PENSIUN_DIPERCEPAT_MPS20persen";
                                    subReport = "susunan_keluarga2";
                                    parameters = new HashMap<>();
                                    parameters.put("nip", nip);
                                    parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                    parameters.put("id_jenis_mps", idJenisMps);
                                    parameters.put("id_kategori_mutasi", idKategoriMutasi);

                                }
                                break;
                                case "2": {
                                    jasperFileName = "Keputusan_HakAtasManfaat_PENSIUN_DIPERCEPAT10";
                                    subReport = "susunan_keluarga2";
                                    parameters = new HashMap<>();
                                    parameters.put("nip", nip);
                                    parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                    parameters.put("id_jenis_mps", idJenisMps);
                                    parameters.put("id_kategori_mutasi", idKategoriMutasi);
                                }
                                break;

                                case "3": {
                                    jasperFileName = "SK_MPS_100persen";
                                    subReport = "susunan_keluarga2";
                                    parameters = new HashMap<>();
                                    parameters.put("nip", nip);
                                    parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                    parameters.put("id_jenis_mps", idJenisMps);
                                    parameters.put("id_kategori_mutasi", idKategoriMutasi);
                                    break;
                                }

                                case "4": {
                                    jasperFileName = "Keputusan_HakAtasManfaat_PENSIUN_DIPERCEPAT_10JUTA";
                                    subReport = "susunan_keluarga2";
                                    parameters = new HashMap<>();
                                    parameters.put("nip", nip);
                                    parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                    parameters.put("id_jenis_mps", idJenisMps);
                                    parameters.put("id_kategori_mutasi", idKategoriMutasi);
                                }
                                break;
                            }
                            break;
                        case "PC":
                            switch (idJenisMps) {
                                case "5": {
                                    jasperFileName = "Keputusan_HakAtasManfaat_PENSIUN_CACAT";
                                    subReport = "susunan_keluarga2";
                                    parameters = new HashMap<>();
                                    parameters.put("nip", nip);
                                    parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                    parameters.put("id_jenis_mps", idJenisMps);
                                    parameters.put("id_kategori_mutasi", idKategoriMutasi);
                                }
                                break;
                                case "1": {
                                    jasperFileName = "Keputusan_HakAtasManfaat_PENSIUN_CACAT(MPSekaligus20)";
                                    subReport = "susunan_keluarga2";
                                    parameters = new HashMap<>();
                                    parameters.put("nip", nip);
                                    parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                    parameters.put("id_jenis_mps", idJenisMps);
                                    parameters.put("id_kategori_mutasi", idKategoriMutasi);
                                }
                                break;
                                case "2": {
                                    jasperFileName = "Keputusan_HakAtasManfaat_PENSIUN_CACAT10JUTA";
                                    subReport = "susunan_keluarga2";
                                    parameters = new HashMap<>();
                                    parameters.put("nip", nip);
                                    parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                    parameters.put("id_jenis_mps", idJenisMps);
                                    parameters.put("id_kategori_mutasi", idKategoriMutasi);
                                }
                                break;

                                case "3": {
                                    jasperFileName = "SK_MPS_100persen";
                                    subReport = "susunan_keluarga2";
                                    parameters = new HashMap<>();
                                    parameters.put("nip", nip);
                                    parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                    parameters.put("id_jenis_mps", idJenisMps);
                                    parameters.put("id_kategori_mutasi", idKategoriMutasi);
                                    break;
                                }

                                case "4": {
                                    jasperFileName = "Keputusan_HakAtasManfaat_PENSIUN_CACAT(10JUTA&MPS20)";
                                    subReport = "susunan_keluarga2";
                                    parameters = new HashMap<>();
                                    parameters.put("nip", nip);
                                    parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                    parameters.put("id_jenis_mps", idJenisMps);
                                    parameters.put("id_kategori_mutasi", idKategoriMutasi);
                                }
                                break;
                            }
                            break;

                        case "PM":
                            switch (kategoriPenerima) {
                                case "2": {
                                    switch (idJenisMps) {
                                        case "5":
                                            jasperFileName = "Keputusan_HakAtasManfaat_PENSIUN_DUDA_JANDA";
                                            subReport = "susunan_keluarga2";
                                            parameters = new HashMap<>();
                                            parameters.put("nip", nip);
                                            parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                            parameters.put("id_jenis_mps", idJenisMps);
                                            parameters.put("id_kategori_mutasi", idKategoriMutasi);

                                            break;
                                        case "1":
                                            jasperFileName = "Keputusan_HakAtasManfaat_PENSIUN_DUDA20persen";
                                            subReport = "susunan_keluarga2";
                                            parameters = new HashMap<>();
                                            parameters.put("nip", nip);
                                            parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                            parameters.put("id_jenis_mps", idJenisMps);
                                            parameters.put("id_kategori_mutasi", idKategoriMutasi);

                                            break;
                                        case "2":
                                            jasperFileName = "Keputusan_HakAtasManfaat_PENSIUN_DUDA_JANDA_10JUTA";
                                            subReport = "susunan_keluarga2";
                                            parameters = new HashMap<>();
                                            parameters.put("nip", nip);
                                            parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                            parameters.put("id_jenis_mps", idJenisMps);
                                            parameters.put("id_kategori_mutasi", idKategoriMutasi);

                                            break;

                                        case "3":
                                            jasperFileName = "SK_MPS_100persen";
                                            subReport = "susunan_keluarga2";
                                            parameters = new HashMap<>();
                                            parameters.put("nip", nip);
                                            parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                            parameters.put("id_jenis_mps", idJenisMps);
                                            parameters.put("id_kategori_mutasi", idKategoriMutasi);
                                            break;

                                        case "4":
                                            jasperFileName = "Keputusan_HakAtasManfaat_PENSIUN_DUDA_MPS20_MPS10jt";
                                            subReport = "susunan_keluarga2";
                                            parameters = new HashMap<>();
                                            parameters.put("nip", nip);
                                            parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                            parameters.put("id_jenis_mps", idJenisMps);
                                            parameters.put("id_kategori_mutasi", idKategoriMutasi);

                                            break;
                                    }
                                    break;
                                }

                                case "3": {
                                    switch (idJenisMps) {
                                        case "5":
                                            jasperFileName = "Keputusan_HakAtasManfaat_PENSIUN_ANAK";
                                            subReport = "susunan_keluarga2";
                                            parameters = new HashMap<>();
                                            parameters.put("NIP", nip);
                                            parameters.put("ID_KATEGORI_PENSIUN", idKategoriPensiun);
                                            parameters.put("ID_JENIS_MPS", idJenisMps);
                                            parameters.put("id_kategori_mutasi", idKategoriMutasi);

                                            break;
                                        case "1":
                                            jasperFileName = "Keputusan_HakAtasManfaat_PENSIUN_ANAK_MPSekaligus20persen";
                                            subReport = "susunan_keluarga2";
                                            parameters = new HashMap<>();
                                            parameters.put("NIP", nip);
                                            parameters.put("ID_KATEGORI_PENSIUN", idKategoriPensiun);
                                            parameters.put("ID_JENIS_MPS", idJenisMps);
                                            parameters.put("id_kategori_mutasi", idKategoriMutasi);

                                            break;
                                        case "2":
                                            jasperFileName = "Keputusan_HakAtasManfaat_PENSIUN_ANAK_10JUTA";
                                            subReport = "susunan_keluarga2";
                                            parameters = new HashMap<>();
                                            parameters.put("NIP", nip);
                                            parameters.put("ID_KATEGORI_PENSIUN", idKategoriPensiun);
                                            parameters.put("ID_JENIS_MPS", idJenisMps);
                                            parameters.put("id_kategori_mutasi", idKategoriMutasi);

                                            break;

                                        case "3":
                                            jasperFileName = "SK_MPS_100persen";
                                            subReport = "susunan_keluarga2";
                                            parameters = new HashMap<>();
                                            parameters.put("nip", nip);
                                            parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                            parameters.put("id_jenis_mps", idJenisMps);
                                            parameters.put("id_kategori_mutasi", idKategoriMutasi);
                                            break;

                                        case "4":
                                            jasperFileName = "Keputusan_HakAtasManfaat_PENSIUN_ANAK_10JUTA_MPS20";
                                            subReport = "susunan_keluarga2";
                                            parameters = new HashMap<>();
                                            parameters.put("NIP", nip);
                                            parameters.put("ID_KATEGORI_PENSIUN", idKategoriPensiun);
                                            parameters.put("ID_JENIS_MPS", idJenisMps);
                                            parameters.put("id_kategori_mutasi", idKategoriMutasi);

                                            break;
                                    }
                                    break;
                                }

                                case "4": {
                                    switch (idJenisMps) {
                                        case "5":
                                            jasperFileName = "Keputusan_HakAtasManfaat_PENSIUN_ANAK";
                                            subReport = "susunan_keluarga2";
                                            parameters = new HashMap<>();
                                            parameters.put("NIP", nip);
                                            parameters.put("ID_KATEGORI_PENSIUN", idKategoriPensiun);
                                            parameters.put("ID_JENIS_MPS", idJenisMps);
                                            parameters.put("id_kategori_mutasi", idKategoriMutasi);

                                            break;

                                        case "1":
                                            jasperFileName = "Keputusan_HakAtasManfaat_PENSIUN_ANAK_MPSekaligus20persen";
                                            subReport = "susunan_keluarga2";
                                            parameters = new HashMap<>();
                                            parameters.put("NIP", nip);
                                            parameters.put("ID_KATEGORI_PENSIUN", idKategoriPensiun);
                                            parameters.put("ID_JENIS_MPS", idJenisMps);
                                            parameters.put("id_kategori_mutasi", idKategoriMutasi);

                                            break;
                                        case "2":
                                            jasperFileName = "Keputusan_HakAtasManfaat_PENSIUN_ANAK_10JUTA";
                                            subReport = "susunan_keluarga2";
                                            parameters = new HashMap<>();
                                            parameters.put("NIP", nip);
                                            parameters.put("ID_KATEGORI_PENSIUN", idKategoriPensiun);
                                            parameters.put("ID_JENIS_MPS", idJenisMps);
                                            parameters.put("id_kategori_mutasi", idKategoriMutasi);

                                            break;

                                        case "3":
                                            jasperFileName = "SK_MPS_100persen";
                                            subReport = "susunan_keluarga2";
                                            parameters = new HashMap<>();
                                            parameters.put("nip", nip);
                                            parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                            parameters.put("id_jenis_mps", idJenisMps);
                                            parameters.put("id_kategori_mutasi", idKategoriMutasi);
                                            break;


                                        case "4":
                                            jasperFileName = "Keputusan_HakAtasManfaat_PENSIUN_ANAK_10JUTA_MPS20";
                                            subReport = "susunan_keluarga2";
                                            parameters = new HashMap<>();
                                            parameters.put("NIP", nip);
                                            parameters.put("ID_KATEGORI_PENSIUN", idKategoriPensiun);
                                            parameters.put("ID_JENIS_MPS", idJenisMps);
                                            parameters.put("id_kategori_mutasi", idKategoriMutasi);
                                            break;
                                    }
                                    break;
                                }

                                case "5": {
                                    switch (idJenisMps) {
                                        case "5":
                                            jasperFileName = "Keputusan_HakAtasManfaat_PENSIUN_ANAK";
                                            subReport = "susunan_keluarga2";
                                            parameters = new HashMap<>();
                                            parameters.put("NIP", nip);
                                            parameters.put("ID_KATEGORI_PENSIUN", idKategoriPensiun);
                                            parameters.put("ID_JENIS_MPS", idJenisMps);
                                            parameters.put("id_kategori_mutasi", idKategoriMutasi);

                                            break;
                                        case "1":
                                            jasperFileName = "Keputusan_HakAtasManfaat_PENSIUN_ANAK_MPSekaligus20persen";
                                            subReport = "susunan_keluarga2";
                                            parameters = new HashMap<>();
                                            parameters.put("NIP", nip);
                                            parameters.put("ID_KATEGORI_PENSIUN", idKategoriPensiun);
                                            parameters.put("ID_JENIS_MPS", idJenisMps);
                                            parameters.put("id_kategori_mutasi", idKategoriMutasi);

                                            break;
                                        case "2":
                                            jasperFileName = "Keputusan_HakAtasManfaat_PENSIUN_ANAK_10JUTA";
                                            subReport = "susunan_keluarga2";
                                            parameters = new HashMap<>();
                                            parameters.put("NIP", nip);
                                            parameters.put("ID_KATEGORI_PENSIUN", idKategoriPensiun);
                                            parameters.put("ID_JENIS_MPS", idJenisMps);
                                            parameters.put("id_kategori_mutasi", idKategoriMutasi);

                                            break;

                                        case "3":
                                            jasperFileName = "SK_MPS_100persen";
                                            subReport = "susunan_keluarga2";
                                            parameters = new HashMap<>();
                                            parameters.put("nip", nip);
                                            parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                            parameters.put("id_jenis_mps", idJenisMps);
                                            parameters.put("id_kategori_mutasi", idKategoriMutasi);
                                            break;

                                        case "4":
                                            jasperFileName = "Keputusan_HakAtasManfaat_PENSIUN_ANAK_10JUTA_MPS20";
                                            subReport = "susunan_keluarga2";
                                            parameters = new HashMap<>();
                                            parameters.put("NIP", nip);
                                            parameters.put("ID_KATEGORI_PENSIUN", idKategoriPensiun);
                                            parameters.put("ID_JENIS_MPS", idJenisMps);
                                            parameters.put("id_kategori_mutasi", idKategoriMutasi);
                                            break;
                                    }
                                    break;
                                }

                                case "6": {
                                    switch (idJenisMps) {
                                        case "5":
                                            jasperFileName = "Keputusan_HakAtasManfaat_PENSIUN_ANAK";
                                            subReport = "susunan_keluarga2";
                                            parameters = new HashMap<>();
                                            parameters.put("NIP", nip);
                                            parameters.put("ID_KATEGORI_PENSIUN", idKategoriPensiun);
                                            parameters.put("ID_JENIS_MPS", idJenisMps);
                                            parameters.put("id_kategori_mutasi", idKategoriMutasi);

                                            break;
                                        case "1":
                                            jasperFileName = "Keputusan_HakAtasManfaat_PENSIUN_ANAK_MPSekaligus20persen";
                                            subReport = "susunan_keluarga2";
                                            parameters = new HashMap<>();
                                            parameters.put("NIP", nip);
                                            parameters.put("ID_KATEGORI_PENSIUN", idKategoriPensiun);
                                            parameters.put("ID_JENIS_MPS", idJenisMps);
                                            parameters.put("id_kategori_mutasi", idKategoriMutasi);

                                            break;
                                        case "2":
                                            jasperFileName = "Keputusan_HakAtasManfaat_PENSIUN_ANAK_10JUTA";
                                            subReport = "susunan_keluarga2";
                                            parameters = new HashMap<>();
                                            parameters.put("NIP", nip);
                                            parameters.put("ID_KATEGORI_PENSIUN", idKategoriPensiun);
                                            parameters.put("ID_JENIS_MPS", idJenisMps);
                                            parameters.put("id_kategori_mutasi", idKategoriMutasi);

                                            break;

                                        case "3":
                                            jasperFileName = "SK_MPS_100persen";
                                            subReport = "susunan_keluarga2";
                                            parameters = new HashMap<>();
                                            parameters.put("nip", nip);
                                            parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                            parameters.put("id_jenis_mps", idJenisMps);
                                            parameters.put("id_kategori_mutasi", idKategoriMutasi);
                                            break;


                                        case "4":
                                            jasperFileName = "Keputusan_HakAtasManfaat_PENSIUN_ANAK_10JUTA_MPS20";
                                            subReport = "susunan_keluarga2";
                                            parameters = new HashMap<>();
                                            parameters.put("NIP", nip);
                                            parameters.put("ID_KATEGORI_PENSIUN", idKategoriPensiun);
                                            parameters.put("ID_JENIS_MPS", idJenisMps);
                                            parameters.put("id_kategori_mutasi", idKategoriMutasi);

                                            break;
                                    }
                                    break;
                                }

                                default :
                                    jasperFileName = "SK_MPS_100persen";
                                    subReport = "susunan_keluarga2";
                                    parameters = new HashMap<>();
                                    parameters.put("nip", nip);
                                    parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                    parameters.put("id_jenis_mps", idJenisMps);
                                    parameters.put("id_kategori_mutasi", idKategoriMutasi);
                                    break;

                            }
                            break;
                    }
                    break;



                case "surat_pengantar_sk":
                    jasperFileName = "SP_PENSIUN_NORMAL";
                    parameters = new HashMap<>();
                    parameters.put("nip", nip);
                    break;
            }

            if (jasperFileName != null) {
                createReport(httpServletResponse, nip, download, parameters, jasperFileName, subReport);
            }
        } catch (IOException | JRException e1) {
            e1.printStackTrace();
        }
    }
    private void createReport(HttpServletResponse httpServletResponse, String nip, Boolean download, Map<String, Object> parameters, String jasperFileName, String subReport) throws JRException, IOException {
        ReportCompiler rc = new ReportCompiler();
        JasperReport jasperReport = rc.compileReport(jasperFileName);
        setReportHeader(httpServletResponse, nip, jasperFileName, download);
        // Set report
        ReportUtil reportUtil = new ReportUtil(jasperFileName, httpServletResponse.getOutputStream());
        if (subReport != null) {
            parameters.put("subReport", reportUtil.getSubReportPath(subReport));
        }
        Connection conn = DataSourceUtils.getConnection(dataSource);
        reportUtil.setReport(parameters, conn, new JRPdfExporter());
        SimplePdfReportConfiguration reportConfig = new SimplePdfReportConfiguration();
        reportConfig.setSizePageToContent(true);
        reportConfig.setForceLineBreakPolicy(false);
        reportUtil.getExporter().setConfiguration(reportConfig);
        // write report to output stream
        reportUtil.getExporter().exportReport();
        reportUtil.getOutputStream().flush();
    }

    private void setReportHeader(HttpServletResponse httpServletResponse, String nip, String jasperFileName, Boolean download) {
        // Set web response output stream
        MediaType mediaType = MediaType.parseMediaType("application/pdf");
        httpServletResponse.setContentType(mediaType.getType());
        if ((download != null) && (download)) {
            httpServletResponse.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + jasperFileName + "-" + new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + nip + ".pdf");
        } else {
            httpServletResponse.setHeader(HttpHeaders.CONTENT_TYPE, "application/pdf");
        }
    }
}