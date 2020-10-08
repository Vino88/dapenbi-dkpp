package com.dapenbi.dkpp.controller.api;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.*;
import com.dapenbi.dkpp.dto.*;
import com.dapenbi.dkpp.form.MutasiKantorBayarFormDto;
import com.dapenbi.dkpp.model.*;
import com.dapenbi.dkpp.util.*;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(PathPrefix.API + PathPrefix.MUTASI_KANTOR_BAYAR)
public class MutasiKantorBayarApiController {

    private MutasiPensiunDao mutasiPensiunDao;

    private KategoriPenerimaDao kategoriPenerimaDao;

    private KantorBayarDao kantorBayarDao;

    private KategoriCatatanDao kategoriCatatanDao;

    private String idKategoriMutasi;

    private DataSource dataSource;

    private SetupParameterDao setupParameterDao;

    @Autowired
    public MutasiKantorBayarApiController(PesertaDao pesertaDao, MutasiPensiunDao mutasiPensiunDao, KategoriPenerimaDao kategoriPenerimaDao, KantorBayarDao kantorBayarDao, KategoriCatatanDao kategoriCatatanDao, SetupParameterDao setupParameterDao, DataSource dataSource) {
        this.mutasiPensiunDao = mutasiPensiunDao;
        this.kategoriPenerimaDao = kategoriPenerimaDao;
        this.kantorBayarDao = kantorBayarDao;
        this.kategoriCatatanDao = kategoriCatatanDao;
        this.idKategoriMutasi = "23";
        this.setupParameterDao = setupParameterDao;
        this.dataSource = dataSource;
    }

    @GetMapping
    public Page<MutasiPensiunDto> index(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam) {
        String periodeMutasi = setupParameterDao.findByBukaPeriode().getPeriode();
        Page<MutasiPensiun> uIt = mutasiPensiunDao.findByKategoriMutasiAndPeriodeMutasi(idKategoriMutasi, periodeMutasi,searchParam+"%", pageRequest);
        Page<MutasiPensiunDto> mutasiPensiunDto = uIt.map(u -> {
            MutasiPensiunDto dto =  u.toDto();
            dto.setStatusValidasi(u.getStatusValidasi().toDto());
            if (u.getKategoriPenerima() != null ) { dto.setKategoriPenerima(u.getKategoriPenerima().toDto()); }
            if (u.getKategoriMutasi() != null ) { dto.setKategoriMutasi(u.getKategoriMutasi().toDto()); }
            if (u.getKantorBayar() != null ) { dto.setKantorBayar(u.getKantorBayar().toDto()); }
            if (u.getKantorBayarBaru() != null ) { dto.setKantorBayarBaru(u.getKantorBayarBaru().toDto()); }
            if (u.getAgama() != null ) { dto.setAgama(u.getAgama().toDto()); }
            if (u.getAlasanHenti() != null ) { dto.setAlasanHenti(u.getAlasanHenti().toDto()); }
            if (u.getKategoryCatatan() != null) {dto.setKategoriCatatan(u.getKategoryCatatan().toDto());}
            return dto;
        });
        return mutasiPensiunDto;
    }

    @GetMapping("/belum-validasi")
    public Page<MutasiPensiunDto> indexBelumValidasi(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam) {
        String periodeMutasi = setupParameterDao.findByBukaPeriode().getPeriode();
        Page<MutasiPensiun> uIt = mutasiPensiunDao.findByKategoriMutasiAndPeriodeMutasiBelumValidasi(idKategoriMutasi, periodeMutasi,searchParam+"%", pageRequest);
        Page<MutasiPensiunDto> result = uIt.map(u -> {
            MutasiPensiunDto dto =  u.toDto();
            dto.setStatusValidasi(u.getStatusValidasi().toDto());
            if (u.getKategoriPenerima() != null ) { dto.setKategoriPenerima(u.getKategoriPenerima().toDto()); }
            if (u.getKategoriMutasi() != null ) { dto.setKategoriMutasi(u.getKategoriMutasi().toDto()); }
            if (u.getKantorBayar() != null ) { dto.setKantorBayar(u.getKantorBayar().toDto()); }
            if (u.getKantorBayarBaru() != null ) { dto.setKantorBayarBaru(u.getKantorBayarBaru().toDto()); }
            if (u.getAgama() != null ) { dto.setAgama(u.getAgama().toDto()); }
            if (u.getAlasanHenti() != null ) { dto.setAlasanHenti(u.getAlasanHenti().toDto()); }
            if (u.getKategoryCatatan() != null) {dto.setKategoriCatatan(u.getKategoryCatatan().toDto());}
            return dto;
        });
        return result;
    }

    @PostMapping
    public ResponseEntity<MessageUtil> addMutasiKantorBayar(@ModelAttribute MutasiKantorBayarFormDto form) {
        DkppUserDetail user = DkppUserStamp.getUserPrincipal();
        RoleDto role = user.getUser().getRoles().get(0);
        Map result = mutasiPensiunDao.processMutasiKantorBayar(role.getId()
                , form.getCompName()
                , form.getUserName()
                , null
                , "23"
                , form.getIdKategoriCatatan()
                , form.getPeriodeMutasi()
                , DateUtil.stringToDate(form.getTglMutasi(), "dd/MM/yyyy")
                , form.getNip()
                , form.getNamaPeserta()
                , form.getIdKantorBayarLama()
                , form.getNamaKantorBayarLama()
                , form.getIdKantorBayarBaru()
                , form.getNamaKantorBayarBaru()
                , Long.valueOf(form.getIdKategoriCatatan())
                , form.getKeterangan()
                , "1"
                , "Belum Validasi");

        MessageUtil messageUtil;
        HttpStatus httpStatus;
        if (result.get("PAR_STATUS_EKSEKUSI").equals('1') && result.get("PAR_ID_MUTASI_VAL") != null) {
            messageUtil = new MessageUtil("success", "Data berhasil ditambahkan");
            httpStatus = HttpStatus.OK;
        } else {
            messageUtil = new MessageUtil("failed", result.get("PAR_MSG").toString());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<MessageUtil>(messageUtil, httpStatus);
    }

    @PutMapping
    public ResponseEntity<MessageUtil> updateMutasiKantorBayar(@ModelAttribute MutasiKantorBayarFormDto form) {
        DkppUserDetail user = DkppUserStamp.getUserPrincipal();
        RoleDto role = user.getUser().getRoles().get(0);
        Map result = mutasiPensiunDao.processMutasiKantorBayar(role.getId(),
                form.getCompName(),
                form.getUserName(),
                Long.valueOf(form.getId()),
                "23",
                form.getIdKategoriCatatan(),
                form.getPeriodeMutasi(),
                DateUtil.stringToDate(form.getTglMutasi(), "DD/MM/YYYY"),
                form.getNip(),
                form.getNamaPeserta(),
                form.getIdKantorBayarLama(),
                form.getNamaKantorBayarLama(),
                form.getIdKantorBayarBaru(),
                form.getNamaKantorBayarBaru(),
                Long.valueOf(form.getIdKategoriCatatan()),
                form.getKeterangan(),
                form.getIdValidasi(),
                form.getNamaValidasi());

        MessageUtil messageUtil;
        HttpStatus httpStatus;
        if (result.get("PAR_STATUS_EKSEKUSI").equals('1') && result.get("PAR_ID_MUTASI_VAL") != null) {
            messageUtil = new MessageUtil("success", "Data berhasil ditambahkan");
            httpStatus = HttpStatus.OK;
        } else {
            messageUtil = new MessageUtil("failed", result.get("PAR_MSG").toString());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<MessageUtil>(messageUtil, httpStatus);

    }

    @GetMapping("/report")
    public void reportMutasiKantorBayar(HttpServletResponse httpServletResponse, @RequestParam("tipeReport") String tipeReport, @RequestParam("nip") String nip, @RequestParam("periodeMutasi") String periodeMutasi, @RequestParam("idKategoriMutasi") String idKategoriMutasi, @RequestParam(name = "download", required = false) Boolean download) {
        String jasperFileName = null;
        String subReport = null;
        HashMap<String, Object> parameters = null;

        try{

                switch (tipeReport){
                    case "formulir_entry_mutasi" :
                        jasperFileName = "EntryMutasiKantorBayar";
                        parameters = new HashMap<>();
                        parameters.put("nip", nip);
                        parameters.put("periode_mutasi", periodeMutasi);
                        parameters.put("id_kategori_mutasi", idKategoriMutasi);
                        break;
                }
                if(jasperFileName != null){
                    createReport(httpServletResponse, nip, download, parameters, jasperFileName, subReport);
                }
        }catch(IOException | JRException e){
            e.printStackTrace();
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