package com.dapenbi.dkpp.controller.api;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.*;
import com.dapenbi.dkpp.dto.*;
import com.dapenbi.dkpp.form.MutasiPensiunFormDto;
import com.dapenbi.dkpp.model.MutasiPensiun;
import com.dapenbi.dkpp.model.Peserta;
import com.dapenbi.dkpp.util.DkppUserStamp;
import com.dapenbi.dkpp.util.ReportCompiler;
import com.dapenbi.dkpp.util.ReportUtil;
import com.zaxxer.hikari.HikariDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRRuntimeException;
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
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(PathPrefix.API + PathPrefix.MUTASI_PENSIUN_BARU)
public class MutasiPensiunBaruApiController extends MutasiPensiunBaseApiController {
    private PesertaDao pesertaDao;
    private HikariDataSource dataSource;

    @Autowired
    public MutasiPensiunBaruApiController(MutasiPensiunDao mutasiPensiunDao, MutasiKeluargaPensiunDao mutasiKeluargaPensiunDao, KategoriPenerimaDao kategoriPenerimaDao, GolonganDao golonganDao, AgamaDao agamaDao, KantorBayarDao kantorBayarDao, PredikatPemberhentianDao predikatPemberhentianDao, AlasanHentiDao alasanHentiDao, JenisMpsDao jenisMpsDao, KategoriPensiunDao kategoriPensiunDao, UsiaBayarDao usiaBayarDao, StatusBayarDao statusBayarDao, KategoriCatatanDao kategoriCatatanDao, StatusKawinDao statusKawinDao, StatusValidasiDao statusValidasiDao, KelurahanDao kelurahanDao, NegaraDao negaraDao, SuskelDao suskelDao, PesertaDao pesertaDao, KeluargaPensiunDao keluargaPensiunDao, HikariDataSource dataSource) {
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
        this.pesertaDao = pesertaDao;
        this.keluargaPensiunDao = keluargaPensiunDao;
        this.dataSource = dataSource;
    }

    @GetMapping("/peserta")
    public Page<PesertaDto> peserta(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam) {
        Page<Peserta> uIt = (Page<Peserta>) pesertaDao.findDataPelepasanPeserta("%" + searchParam + "%", pageRequest);
        return uIt.map(u -> {
            PesertaDto dto = u.toDto();
            if (u.getGolongan() != null) dto.setGolongan(u.getGolongan().toDto());
            if (u.getAgama() != null) dto.setAgama(u.getAgama().toDto());
            return dto;
        });
    }

    @GetMapping("/mutasi")
    public Page<MutasiPensiunDto> mutasi(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam) {
        Page<MutasiPensiun> uIt = mutasiPensiunDao.findMutasiPensiunBaru("%" + searchParam + "%", pageRequest);
        return uIt.map(u -> {
            MutasiPensiunDto dto = u.toDto();
            if (u.getGolongan() != null) dto.setGolongan(u.getGolongan().toDto());
            if (u.getAgama() != null) dto.setAgama(u.getAgama().toDto());
            if (u.getStatusValidasi() != null) dto.setStatusValidasi(u.getStatusValidasi().toDto());
            if (u.getKategoriPensiun() != null) dto.setKategoriPensiun(u.getKategoriPensiun().toDto());
            if (u.getKategoriPenerima() != null) dto.setKategoriPenerima(u.getKategoriPenerima().toDto());
            if (u.getJenisMps() != null) dto.setJenisMps(u.getJenisMps().toDto());
            return dto;
        });
    }

    @GetMapping("/mutasi/belum-validasi")
    public Page<MutasiPensiunDto> mutasiBelumValidasi(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam) {
        Page<MutasiPensiun> uIt = mutasiPensiunDao.findMutasiPensiunBaruBelumValidasi("%" + searchParam + "%", pageRequest);
        return uIt.map(u -> {
            MutasiPensiunDto dto = u.toDto();
            if (u.getGolongan() != null) dto.setGolongan(u.getGolongan().toDto());
            if (u.getAgama() != null) dto.setAgama(u.getAgama().toDto());
            if (u.getStatusValidasi() != null) dto.setStatusValidasi(u.getStatusValidasi().toDto());
            if (u.getKategoriPensiun() != null) dto.setKategoriPensiun(u.getKategoriPensiun().toDto());
            if (u.getKategoriPenerima() != null) dto.setKategoriPenerima(u.getKategoriPenerima().toDto());
            if (u.getJenisMps() != null) dto.setJenisMps(u.getJenisMps().toDto());
            return dto;
        });
    }

    @Override
    Map checkMps100Persen(MutasiPensiunFormDto formDto, Map<String, Date> dateParam) {
        return mutasiPensiunDao.checkMps100PersenBaru(dateParam.get("tglLahir"), dateParam.get("tglBekerjaDiBI"), dateParam.get("tglHentiBayar"), dateParam.get("tglAwalBayarMP"), dateParam.get("tglLahirPenerimaMP"), formDto.getJenisMP(), formDto.getGajiPokokTerakhir());
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
        Long idStatusKawinPenerimaMpTemp = null;
        String namaStatusKawinPenerimaMpTemp = "";
        if (kategoriPenerimaDto.getId() == 11) {
            idStatusKawinPenerimaMpTemp = statusKawinDto.getId();
            namaStatusKawinPenerimaMpTemp = statusKawinDto.getStatusKawin();
        }
        else {
            idStatusKawinPenerimaMpTemp = statusKawinPenerimaDto.getId();
            namaStatusKawinPenerimaMpTemp = statusKawinPenerimaDto.getStatusKawin();
        }
        return mutasiPensiunDao.processMutasiPensiunBaru(role.getId(), DkppUserStamp.getCompName(), user.getUsername(), formDto.getMutasiId(), null, formDto.getJenisMP(), formDto.getPeriodeMutasi(), dateParam.get("tglInput"), formDto.getNip(), formDto.getNama(), formDto.getJenisKelamin(), dateParam.get("tglLahir"), dateParam.get("tglBekerjaDiBI"), dateParam.get("tglDPHT"), dateParam.get("tglBerhentiBekerja"), null, dateParam.get("tglMeninggal"), null, formDto.getGolongan(), golongan.getPangkat(), formDto.getAgama(), agama.getNamaAgama(), formDto.getCabangKpwBI(), kantorBayarDto.getNamaKantorBayar(), formDto.getPredikatPemberhentian(), predikatPemberhentianDto.getNamaPemberhentian(), formDto.getAlasanHenti(), alasanHentiDto.getKeterangan(), dateParam.get("tglSPBI"), formDto.getNomorSuratPengantarBI(), dateParam.get("tglSKBI"), formDto.getNomorSKBI(), formDto.getGajiPokokTerakhir(), formDto.getUpahVeteran(), formDto.getStatusPengembalianMPS(), jenisMpsDto.getNamamps(), formDto.getJenisMP(), kategoriPensiunDto.getNamaKategoriPensiun(), formDto.getPilihanUsiaBayarMP(), usiaBayarDto.getNamaUsiaBayar(), formDto.getStatusBayarMP(), statusBayarDto.getStatusBayar(), formDto.getStatusKawin(), statusKawinDto.getStatusKawin(), dateParam.get("tglTundaJatuhTempo"), dateParam.get("tglAwalBayarMP"), dateParam.get("tglMPBulan13"), dateParam.get("tglHentiBayar"), penerimaMP.get("id"), penerimaMP.get("namaKeluarga"), dateParam.get("tglLahirPenerima"), penerimaMP.get("jenisKelamin"), kategoriPenerimaDto.getId(), kategoriPenerimaDto.getNamaKategoriPenerima(), dateParam.get("tglSKDapenbi"), formDto.getNomorSKDAPENBI(), dateParam.get("tglUsia25"), isDalamNegeri, formDto.getProvinsiPenerimaMP(), alamat.get("provinisi"), formDto.getKotaPenerimaMP(), alamat.get("kota"), formDto.getKecamatanPenerimaMP(), alamat.get("kecamatan"), formDto.getKelurahanPenerimaMP(), alamat.get("kelurahan"), alamat.get("kodePos"), alamat.get("alamatLengkap"), formDto.getRtPenerimaMP(), formDto.getRwPenerimaMP(), formDto.getNegaraPenerimaMP(), alamat.get("negara"), formDto.getSuskel(), suskelDto.getNamaSuskel(), formDto.getKategoriCatatan(), kategoriCatatanDto.getNamaKategoriCatatan(), idStatusKawinPenerimaMpTemp, namaStatusKawinPenerimaMpTemp, formDto.getNoHPPenerimaMP(), formDto.getNoTlpPenerimaMP(), formDto.getEmailPenerimaMP(), formDto.getStatusCatatan(), statusValidasiDto.getNamaValidasi(), null, null, formDto.getCatatan());
    }

    @GetMapping("/report")
    public void report(HttpServletResponse httpServletResponse, @RequestParam("nip") String nip, @RequestParam("periodeMutasi") String periodeMutasi, @RequestParam("idKategoriMutasi") String idKategoriMutasi, @RequestParam("idKategoriPensiun") String idKategoriPensiun, @RequestParam("idJenisMps") String idJenisMps, @RequestParam("kategoriPenerima") String kategoriPenerima, @RequestParam("tipeReport") String tipeReport, @RequestParam("namaKategoriPenerimaMP") String namaKategoriPenerimaMP, @RequestParam(name = "download", required = false) Boolean download) {
        String jasperFileName = null;
        String subReport = null;
        HashMap<String, Object> parameters = null;

        try {
            System.out.println("Nilai nip: " + nip);
            switch (tipeReport) {
                case "formulir_entry_mutasi":
                    switch (idKategoriPensiun) {
                        case "PN":
                            jasperFileName = "Entry_Mutasi_PensiunNormal";
                            parameters = new HashMap<>();
                            parameters.put("id_jenis_mps", idJenisMps);
                            parameters.put("id_kategori_pensiun", idKategoriPensiun);
                            parameters.put("id_kategori_mutasi", idKategoriMutasi);
                            parameters.put("nip", nip);
                            parameters.put("periode_mutasi", periodeMutasi);

                            // display stack trace in the browser
                            /*StringWriter stringWriter = new StringWriter();
                            PrintWriter printWriter = new PrintWriter(stringWriter);
                            printStackTrace(printWriter);
                            httpServletResponse.setContentType("text/plain");
                            httpServletResponse.getOutputStream().print(stringWriter.toString());
                            */
                            break;

                        case "PD":
                            jasperFileName = "Entry_Mutasi_PensiunDipercepat_A4";
                            parameters = new HashMap<>();
                            parameters.put("id_jenis_mps", idJenisMps);
                            parameters.put("id_kategori_pensiun", idKategoriPensiun);
                            parameters.put("id_kategori_mutasi", idKategoriMutasi);
                            parameters.put("nip", nip);
                            parameters.put("periode_mutasi", periodeMutasi);

                            break;

                        case "PC":
                            jasperFileName = "Entry_Mutasi_PensiunCacat_A4";
                            parameters = new HashMap<>();
                            parameters.put("id_jenis_mps", idJenisMps);
                            parameters.put("id_kategori_pensiun", idKategoriPensiun);
                            parameters.put("id_kategori_mutasi", idKategoriMutasi);
                            parameters.put("nip", nip);
                            parameters.put("periode_mutasi", periodeMutasi);

                            break;

                        case "PM":
                            switch (kategoriPenerima) {
                                case "2":
                                    jasperFileName = "Entry_Mutasi_PensiunJandaDuda_A4";
                                    parameters = new HashMap<>();
                                    parameters.put("id_jenis_mps", idJenisMps);
                                    parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                    parameters.put("id_kategori_mutasi", idKategoriMutasi);
                                    parameters.put("nip", nip);
                                    parameters.put("periode_mutasi", periodeMutasi);
                                    break;

                                case "11":
                                    jasperFileName = "Entry_Mutasi_Pensiun_Sekaligus";
                                    parameters = new HashMap<>();
                                    parameters.put("id_jenis_mps", idJenisMps);
                                    parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                    parameters.put("id_kategori_mutasi", idKategoriMutasi);
                                    parameters.put("nip", nip);
                                    parameters.put("periode_mutasi", periodeMutasi);
                                    break;

                                default:
                                    jasperFileName = "Entry_Mutasi_PensiunAnak_A4";
                                    parameters = new HashMap<>();
                                    parameters.put("id_jenis_mps", idJenisMps);
                                    parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                    parameters.put("id_kategori_mutasi", idKategoriMutasi);
                                    parameters.put("nip", nip);
                                    parameters.put("periode_mutasi", periodeMutasi);
                                    break;
                            }
                            break;

                        case "PS":
                            jasperFileName = "Entry_Mutasi_Pensiun_Sekaligus";
                            parameters = new HashMap<>();
                            parameters.put("id_jenis_mps", idJenisMps);
                            parameters.put("id_kategori_pensiun", idKategoriPensiun);
                            parameters.put("id_kategori_mutasi", idKategoriMutasi);
                            parameters.put("nip", nip);
                            parameters.put("periode_mutasi", periodeMutasi);

                            break;

                        case "PT":
                            jasperFileName = "Entry_Mutasi_PensiunTunda_A4";
                            parameters = new HashMap<>();
                            parameters.put("id_jenis_mps", idJenisMps);
                            parameters.put("id_kategori_pensiun", idKategoriPensiun);
                            parameters.put("nip", nip);
                            parameters.put("periode_mutasi", periodeMutasi);

                            break;
                    }
                    break;

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
                                break;
                            }
                            break;


                        case "PT":
                            jasperFileName = "PerhitunganMP_hak_atas_pensiun_tunda";
                            subReport = "keluarga_pensiun";
                            parameters = new HashMap<>();
                            parameters.put("id_kategori_pensiun", idKategoriPensiun);
                            parameters.put("nip", nip);
                            parameters.put("periode_mutasi", periodeMutasi);
                            parameters.put("id_kategori_mutasi", idKategoriMutasi);

                            break;

                        case "PS":
                            jasperFileName = "PerhitunganMP_Sekaligus_KepadaAhliWaris";
                            subReport = "keluarga_pensiun";
                            parameters = new HashMap<>();
                            parameters.put("id_jenis_mps", idJenisMps);
                            parameters.put("id_kategori_pensiun", idKategoriPensiun);
                            parameters.put("id_kategori_mutasi", idKategoriMutasi);
                            parameters.put("nip", nip);
                            parameters.put("periode_mutasi", periodeMutasi);
                            break;

                    }

                break;
                case "struk_manfaat_pensiun": {
                    jasperFileName = "Perhitungan_MP_Invoice(A5-4)";
                    parameters = new HashMap<>();
                    parameters.put("id_jenis_mps", idJenisMps);
                    parameters.put("id_kategori_pensiun", idKategoriPensiun);
                    parameters.put("id_kategori_mutasi", idKategoriMutasi);
                    parameters.put("nip", nip);
                    parameters.put("periode_mutasi", periodeMutasi);

                    break;
                }
                case "catatan_perhitungan_manfaat": {
                    switch (idKategoriPensiun) {
                        case "PS": {
                            jasperFileName = "PerhitunganMP_Sekaligus_KepadaAhliWaris";
                            subReport = "keluarga_pensiun";
                            parameters = new HashMap<>();
                            parameters.put("id_jenis_mps", idJenisMps);
                            parameters.put("id_kategori_pensiun", idKategoriPensiun);
                            parameters.put("id_kategori_mutasi", idKategoriMutasi);
                            parameters.put("nip", nip);
                            parameters.put("periode_mutasi", periodeMutasi);

                        }
                    }
                    break;
                }

                case "kartu_peserta":
                    jasperFileName = "KartuPensiun";
                    parameters = new HashMap<>();
                    parameters.put("nip", nip);
                    break;

                case "struk_bayangan_mp":
                    jasperFileName = "StrukMPBayangan";
                    parameters = new HashMap<>();
                    parameters.put("nip", nip);
                    parameters.put("id_kategori_pensiun", idKategoriPensiun);
                    parameters.put("id_jenis_mps", idJenisMps);
                    parameters.put("periode_mutasi", periodeMutasi);

                break;

                case "sk_pensiun":
                    switch (idKategoriPensiun) {
                        case "PN":
                            switch (idJenisMps) {
                                case "5":
                                    jasperFileName = "Keputusan_HakAtasManfaat_PENSIUN_NORMAL";
                                    subReport = "susunan_keluarga2";
                                    parameters = new HashMap<>();
                                    parameters.put("nip", nip);
                                    parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                    parameters.put("id_jenis_mps", idJenisMps);
                                    parameters.put("id_kategori_mutasi", idKategoriMutasi);
                                    break;

                                case "1":
                                    jasperFileName = "Keputusan_HakAtasManfaat_PENSIUN_NORMAL_MPS20persen";
                                    subReport = "susunan_keluarga2";
                                    parameters = new HashMap<>();
                                    parameters.put("nip", nip);
                                    parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                    parameters.put("id_jenis_mps", idJenisMps);
                                    parameters.put("id_kategori_mutasi", idKategoriMutasi);
                                    break;

                                case "2":
                                    jasperFileName = "Keputusan_HakAtasManfaat_PENSIUN_NORMAL(Lebih10JUTA)";
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
                                    jasperFileName = "Keputusan_HakAtasManfaat_PENSIUN_20persen_10juta";
                                    subReport = "susunan_keluarga2";
                                    parameters = new HashMap<>();
                                    parameters.put("nip", nip);
                                    parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                    parameters.put("id_jenis_mps", idJenisMps);
                                    parameters.put("id_kategori_mutasi", idKategoriMutasi);
                                    break;
                            }
                            break;

                        case "PD":
                            switch (idJenisMps) {
                                case "5":
                                    jasperFileName = "Keputusan_HakAtasManfaat_PENSIUN_DIPERCEPAT";
                                    subReport = "susunan_keluarga2";
                                    parameters = new HashMap<>();
                                    parameters.put("nip", nip);
                                    parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                    parameters.put("id_jenis_mps", idJenisMps);
                                    parameters.put("id_kategori_mutasi", idKategoriMutasi);
                                    break;

                                case "1":
                                    jasperFileName = "Keputusan_HakAtasManfaat_PENSIUN_DIPERCEPAT_MPS20persen";
                                    subReport = "susunan_keluarga2";
                                    parameters = new HashMap<>();
                                    parameters.put("nip", nip);
                                    parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                    parameters.put("id_jenis_mps", idJenisMps);
                                    parameters.put("id_kategori_mutasi", idKategoriMutasi);
                                    break;

                                case "2":
                                    jasperFileName = "Keputusan_HakAtasManfaat_PENSIUN_DIPERCEPAT10";
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
                                    jasperFileName = "Keputusan_HakAtasManfaat_PENSIUN_DIPERCEPAT_10JUTA";
                                    subReport = "susunan_keluarga2";
                                    parameters = new HashMap<>();
                                    parameters.put("nip", nip);
                                    parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                    parameters.put("id_jenis_mps", idJenisMps);
                                    parameters.put("id_kategori_mutasi", idKategoriMutasi);
                                    break;
                            }
                            break;

                        case "PC":
                            switch (idJenisMps) {
                                case "5":
                                    jasperFileName = "Keputusan_HakAtasManfaat_PENSIUN_CACAT";
                                    subReport = "susunan_keluarga2";
                                    parameters = new HashMap<>();
                                    parameters.put("nip", nip);
                                    parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                    parameters.put("id_jenis_mps", idJenisMps);
                                    parameters.put("id_kategori_mutasi", idKategoriMutasi);
                                    break;
                                case "1":
                                    jasperFileName = "Keputusan_HakAtasManfaat_PENSIUN_CACAT(MPSekaligus20)";
                                    subReport = "susunan_keluarga2";
                                    parameters = new HashMap<>();
                                    parameters.put("nip", nip);
                                    parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                    parameters.put("id_jenis_mps", idJenisMps);
                                    parameters.put("id_kategori_mutasi", idKategoriMutasi);
                                    break;

                                case "2":
                                    jasperFileName = "Keputusan_HakAtasManfaat_PENSIUN_CACAT10JUTA";
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
                                    jasperFileName = "Keputusan_HakAtasManfaat_PENSIUN_CACAT(10JUTA&MPS20)";
                                    subReport = "susunan_keluarga2";
                                    parameters = new HashMap<>();
                                    parameters.put("nip", nip);
                                    parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                    parameters.put("id_jenis_mps", idJenisMps);
                                    parameters.put("id_kategori_mutasi", idKategoriMutasi);
                                    break;
                            }
                            break;

                        case "PM":
                            switch (kategoriPenerima) {
                                case "2":
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

                                case "3":
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

                                case "4":
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

                                case "5":
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

                                case "6":
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

                    case "surat_hak_pt":
                    switch (idKategoriPensiun) {
                        case "PT":
                            jasperFileName = "SP_PENSIUN_NORMAL_KANTOR_CABANG";
                            parameters = new HashMap<>();
                            parameters.put("nip", nip);

                            break;
                    }

                break;

                    case "surat_besaran_mp_jandaDudaAnak":
                    jasperFileName = "Surat_Penyampaian_besaran_MP_selama_setahun_DSDM_BI_PenerimaMPJandaDudaAnakLangsung";
                    parameters = new HashMap<>();
                    parameters.put("nip", nip);

                    break;

                    case "surat_mps100persen":
                    switch (idKategoriPensiun) {
                        case "PS":
                            jasperFileName = "SuratPembayaranMPS100persen";
                            parameters = new HashMap<>();
                            parameters.put("nip", nip);
                            break;
                    }
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
            try{
            Connection conn = DataSourceUtils.getConnection(dataSource);
            reportUtil.setReport(parameters, conn, new JRPdfExporter());
            SimplePdfReportConfiguration reportConfig = new SimplePdfReportConfiguration();
            reportConfig.setSizePageToContent(true);
            reportConfig.setForceLineBreakPolicy(false);
            reportUtil.getExporter().setConfiguration(reportConfig);
            // write report to output stream
            reportUtil.getExporter().exportReport();
            reportUtil.getOutputStream().flush();
            reportUtil.getOutputStream().close();
        }catch( JRException | IOException e){
            e.printStackTrace();
        }
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
