package com.dapenbi.dkpp.controller.api;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.*;
import com.dapenbi.dkpp.dto.*;
import com.dapenbi.dkpp.dto.component.Select2Default;
import com.dapenbi.dkpp.form.*;
import com.dapenbi.dkpp.model.*;
import com.dapenbi.dkpp.util.*;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping(PathPrefix.API + PathPrefix.MUTASI_PENERIMA_MP_JANDA_DUDA_MENIKAH_KEMBALI)
public class MutasiPenerimaMPJandaDudaMenikahKembaliApiController extends MutasiPensiunBaseApiController {

    @Autowired
    MutasiPensiunDao mutasiPensiunDao;

    @Autowired
    MPensiunDao mPensiunDao;

    @Autowired
    SetupParameterDao setupParameterDao;

    @Autowired
    JandaDudaMenikahKembaliViewModelDao jandaDudaMenikahKembaliViewModelDao;

    @Autowired
    SuskelDao suskelDao;
    private DataSource dataSource;

    public MutasiPenerimaMPJandaDudaMenikahKembaliApiController(DataSource dataSource){
        this.dataSource = dataSource;

    }


    @GetMapping
    public Page<JandaDudaMenikahKembaliViewModelDto> index(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam) {
        SetupParameter setupParameter = this.setupParameterDao.findByBukaPeriode();
        Page<JandaDudaMenikahKembaliViewModel> uIt = (Page<JandaDudaMenikahKembaliViewModel>) jandaDudaMenikahKembaliViewModelDao.findAll(new String[]{"nip"},"%" + searchParam + "%", pageRequest);
        Page<JandaDudaMenikahKembaliViewModelDto> result = uIt.map(u -> {
            JandaDudaMenikahKembaliViewModelDto dto = u.toDto();
            return dto;
        });

        return result;
    }

    @GetMapping("/belum-validasi")
    public Page<JandaDudaMenikahKembaliViewModelDto> indexBelumValidasi(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam) {
        SetupParameter setupParameter = this.setupParameterDao.findByBukaPeriode();
        Page<JandaDudaMenikahKembaliViewModel> uIt = (Page<JandaDudaMenikahKembaliViewModel>) jandaDudaMenikahKembaliViewModelDao.indexBelumValidasi("%" + searchParam + "%", pageRequest);
        Page<JandaDudaMenikahKembaliViewModelDto> result = uIt.map(u -> {
            JandaDudaMenikahKembaliViewModelDto dto = u.toDto();
            return dto;
        });

        return result;
    }

    @PostMapping
    public ResponseEntity<MessageUtil> addMutasiPenerimaMpMenikah(@ModelAttribute MenikahKembaliPlainTextFormDto plainDto) {
        DkppUserDetail user = DkppUserStamp.getUserPrincipal();
        RoleDto role = user.getUser().getRoles().get(0);
        MenikahKembaliSPFormDto spDto = new MenikahKembaliSPFormDto();
        spDto.fromPlainText(plainDto);
        spDto.setRoleId(role.getId());
        Map result = jandaDudaMenikahKembaliViewModelDao.processMutasiPenerimaMpMenikah(spDto);

        MessageUtil messageUtil;
        HttpStatus httpStatus;
        if (result.get("PAR_STATUS_EKSEKUSI").equals('1')) {
            messageUtil = new MessageUtil("success", "Data berhasil ditambahkan " + result.get("PAR_MSG").toString(), spDto);
            httpStatus = HttpStatus.OK;
        } else {
            messageUtil = new MessageUtil("failed", result.get("PAR_MSG").toString(), spDto);
            httpStatus = HttpStatus.CONFLICT;
        }

        return new ResponseEntity<MessageUtil>(messageUtil, httpStatus);
    }

    @PutMapping
    public ResponseEntity<MessageUtil> updateMutasiPenerimaMpMenikah(@ModelAttribute MenikahKembaliPlainTextFormDto plainDto) {
        DkppUserDetail user = DkppUserStamp.getUserPrincipal();
        RoleDto role = user.getUser().getRoles().get(0);
        MenikahKembaliSPFormDto spDto = new MenikahKembaliSPFormDto();
        spDto.fromPlainText(plainDto);
        spDto.setRoleId(role.getId());
        Map result = jandaDudaMenikahKembaliViewModelDao.processMutasiPenerimaMpMenikah(spDto);

        MessageUtil messageUtil;
        HttpStatus httpStatus;
        if (result.get("PAR_STATUS_EKSEKUSI").equals('1')) {
            messageUtil = new MessageUtil("success", "Data berhasil diubah.", spDto);
            httpStatus = HttpStatus.OK;
        } else {
            messageUtil = new MessageUtil("failed", result.get("PAR_MSG").toString(), spDto);
            httpStatus = HttpStatus.CONFLICT;
        }
        return new ResponseEntity<MessageUtil>(messageUtil, httpStatus);
    }

    @GetMapping("/get-detail")
    public JandaDudaMenikahKembaliViewModelDto getByNip(@RequestParam(name = "idMutasiPensiun") Long idMutasiPensiun, @RequestParam(name = "nip", required = true) String nip) {
        JandaDudaMenikahKembaliViewModel jandaDudaMenikahKembaliViewModel = this.jandaDudaMenikahKembaliViewModelDao.findFirstByIdAndNip (idMutasiPensiun, nip);

        return jandaDudaMenikahKembaliViewModel.toDto();
    }

    @GetMapping("/detail_alamat")
    public Object getDetailAlamat(@RequestParam(name = "id", required = true) String id){
        return jandaDudaMenikahKembaliViewModelDao.findAlamatByKelurahan(id);
    }


    @GetMapping("/cufn-menikah-simulation")
    public Map cufnMenikahSimulation(@RequestParam(name = "nip") String nip, @RequestParam("tglMenikah") String tglMenikah, @RequestParam("periodeMutasi") String periodeMutasi, @RequestParam("idStatusBayar") Long idStatusBayar){
        return this.jandaDudaMenikahKembaliViewModelDao.cufnMenikahSimulation(nip, periodeMutasi, tglMenikah, idStatusBayar);
    }

    @PostMapping("/cek-suskel")
    public ResponseEntity<MessageUtil> cekSuskel(@ModelAttribute MutasiPensiunFormDto formDto) {
        PesertaFormDto peserta = new PesertaFormDto();
        peserta.setNip(formDto.getNip());

        peserta.setJenisKelamin(formDto.getJenisKelamin());
        peserta.setTglWafat(formDto.getTglMeninggal());
        Suskel suskel = null;
        List<KeluargaPesertaFormDto> dataKeluargas = extractkeluarga(formDto);

        try {
            suskel = suskelDao.generateSuskel(peserta, dataKeluargas, "MENIKAH");
        } catch (Exception e) {
            new ResponseEntity<MessageUtil>(new MessageUtil("error", "Terjadi kesalahan"), HttpStatus.OK);
        }

        SuskelDataDto suskelDataDto = new SuskelDataDto();
        if(suskel != null){
            suskelDataDto.setIdSuskel(suskel.getId());
            suskelDataDto.setNamaSuskel(suskel.getNamaSuskel());
        }

        return new ResponseEntity<MessageUtil>(new MessageUtil("success", "Get Suskel", suskelDataDto), HttpStatus.OK);
    }


    @Override
    Map checkMps100Persen(MutasiPensiunFormDto formDto, Map<String, Date> dateParam) {
        return null;
    }

    @GetMapping("/report")
    public void reportMeninggal(HttpServletResponse httpServletResponse, @RequestParam("tipeReport") String tipeReport, @RequestParam("nip") String nip, @RequestParam("periodeMutasi") String periodeMutasi, @RequestParam("idKategoriMutasi") String idKategorimutasi, @RequestParam("idKategoriPenerimaMpBaru") String idKategoriPenerimaMpBaru, @RequestParam("idMutasiPensiun") String idMutasiPensiun ,@RequestParam(name = "download", required = false) Boolean download){
        String jasperFileName = null;
        String subReport = null;
        HashMap<String,Object> parameters = null;


        try {
            switch (tipeReport) {
                case "formulir_entry_mutasi":

                    jasperFileName = "Entry_Mutasi_PensiunPenerimaSelanjutnya";
                    parameters = new HashMap<>();
                    parameters.put("nip", nip);
                    parameters.put("periode_mutasi", periodeMutasi);
                    parameters.put("id_kategori_mutasi", idKategorimutasi);

                    break;


                case "catatan_perhitungan_manfaat_pensiun" :

                    jasperFileName = "PerhitunganMP_pensiunAanak_JandaDudaNikahLagi";
                    subReport = "keluarga_pensiunMI";
                    parameters = new HashMap<>();
                    parameters.put("nip", nip);
                    parameters.put("periode_mutasi", periodeMutasi);
                    parameters.put("id_kategori_mutasi", idKategorimutasi);
                    break;

                case "surat_pemberitahuan" :
                    switch (idKategoriPenerimaMpBaru) {
                        case "11":
                            jasperFileName = "SuratPembayaranMPS100persen";
                            parameters = new HashMap<>();
                            parameters.put("nip", nip);
                            break;
                        default:
                            jasperFileName = "SuratPemberitahuanHakAtasManfaatPensiunAnak";
                            parameters = new HashMap<>();
                            parameters.put("nip", nip);
                            parameters.put("id_kategori_penerima_mp", idKategoriPenerimaMpBaru);
                            break;
                    }
                    break;

                case "surat_pengantar_mp" :
                    switch (idKategoriPenerimaMpBaru){
                        case "11" :
                            jasperFileName = "SuratPembayaranMPS100persen";
                            parameters = new HashMap<>();
                            parameters.put("nip", nip);
                            break;
                        default:
                            jasperFileName = "SuratPengantarHakAtasManfaatPensiunAnak";
                            parameters = new HashMap<>();
                            parameters.put("nip", nip);
                            parameters.put("id_kategori_penerima_mp", idKategoriPenerimaMpBaru);
                            break;
                    }
                    break;

                case "surat_perubahan_domisili_penerima_mp" :
                    jasperFileName = "SuratPermohonanPerubahanDomisili";
                    parameters = new HashMap<>();
                    parameters.put("nip", nip);
                    parameters.put("id_kategori_mutasi", idKategorimutasi);
                    break;

                case "sk" :
                            jasperFileName = "Keputusan_HakAtasManfaat_PENSIUN__LAMA_ANAK";
                            subReport = "susunan_keluarga_pensiunLama";
                            parameters = new HashMap<>();
                            parameters.put("NIP", nip);
                            parameters.put("id_kategori_mutasi", idKategorimutasi);
                            parameters.put("id_mutasi_pensiun", idMutasiPensiun);
                            break;

                case "kartu" :
                    jasperFileName = "KartuPensiunLama";
                    parameters = new HashMap<>();
                    parameters.put("nip", nip);
                    parameters.put("id_kategori_mutasi", idKategorimutasi);
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

    @Override
    Map saveMutasi(MutasiPensiunFormDto formDto, Map<String, BaseDto> dtoParam, Map<String, Date> dateParam, Map<String, String> alamatParam) {
        return null;
    }
}

class SuskelDataDto extends BaseFormDto {
    private Long idSuskel;
    private String namaSuskel;

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
}
