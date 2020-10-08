package com.dapenbi.dkpp.controller.api;


import com.dapenbi.dkpp.dao.MutasiOtomatis25TViewModelDao;
import com.dapenbi.dkpp.dao.MutasiPenerimaAnakTab2Dao;
import com.dapenbi.dkpp.dao.SetupParameterDao;
import com.dapenbi.dkpp.dto.DkppUserDetail;
import com.dapenbi.dkpp.dto.MutasiOtomatis25TViewModelDto;
import com.dapenbi.dkpp.dto.RoleDto;
import com.dapenbi.dkpp.form.MenikahKembaliPlainTextFormDto;
import com.dapenbi.dkpp.form.MenikahKembaliSPFormDto;
import com.dapenbi.dkpp.form.MutasiPensiunOtomatis25TPlainTextFormDto;
import com.dapenbi.dkpp.form.MutasiPensiunOtomatis25TSPFormDto;
import com.dapenbi.dkpp.model.ViewModel.MutasiOtomatis25TViewModel;
import com.dapenbi.dkpp.util.DkppUserStamp;
import com.dapenbi.dkpp.util.MessageUtil;
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
public class MutasiPenerimaAnakTab2ApiController extends MutasiPenerimaAnakApiController {

    @Autowired
    MutasiOtomatis25TViewModelDao mutasiOtomatis25TViewModelDao;
    SetupParameterDao setupParameterDao;
    private DataSource dataSource;

    public MutasiPenerimaAnakTab2ApiController(DataSource dataSource){
        this.dataSource = dataSource;

    }

    @GetMapping("/data-mutasi-25-tahun")
    public Page<MutasiOtomatis25TViewModelDto> index(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam) {
        Page<MutasiOtomatis25TViewModel> uIt = (Page<MutasiOtomatis25TViewModel>) mutasiOtomatis25TViewModelDao.findAll(new String[]{"nip", "namaPeserta", "namaPenerimaMp"},"%" + searchParam + "%", pageRequest);
        Page<MutasiOtomatis25TViewModelDto> result = uIt.map(u -> {
            MutasiOtomatis25TViewModelDto dto = u.toDto();
            return dto;
        });

        return result;
    }

    @GetMapping("/data-mutasi-25-tahun/belum-validasi")
    public Page<MutasiOtomatis25TViewModelDto> indexBelumValidasi(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam) {
        Page<MutasiOtomatis25TViewModel> uIt = (Page<MutasiOtomatis25TViewModel>) mutasiOtomatis25TViewModelDao.findAllByBelumValidasi("%" + searchParam + "%", pageRequest);
        Page<MutasiOtomatis25TViewModelDto> result = uIt.map(u -> {
            MutasiOtomatis25TViewModelDto dto = u.toDto();
            return dto;
        });

        return result;
    }

    @PutMapping("/data-mutasi-25-tahun")
    public ResponseEntity<MessageUtil> updateMutasiPensiunOtomatis25T(@ModelAttribute MutasiPensiunOtomatis25TPlainTextFormDto plainDto) {
        DkppUserDetail user = DkppUserStamp.getUserPrincipal();
        RoleDto role = user.getUser().getRoles().get(0);
        MutasiPensiunOtomatis25TSPFormDto spDto = new MutasiPensiunOtomatis25TSPFormDto();
        spDto.fromPlainText(plainDto);
        Map result = mutasiOtomatis25TViewModelDao.processMutasiOtomatis25T(spDto);

        MessageUtil messageUtil;
        HttpStatus httpStatus;
        if (result.get("PAR_STATUS_EKSEKUSI").equals('1')) {
            messageUtil = new MessageUtil("success", "Data berhasil diubah.", spDto);
            httpStatus = HttpStatus.OK;
        } else {
            messageUtil = new MessageUtil("failed", result.get("PAR_MSG").toString(), spDto);
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<MessageUtil>(messageUtil, httpStatus);
    }

    @GetMapping("/report")
    public void reportAnakUsia25(HttpServletResponse httpServletResponse, @RequestParam("tipeReport") String tipeReport, @RequestParam("periodeMutasi") String periodeMutasi, @RequestParam("nip") String nip, @RequestParam("idKategoriMutasi") String idKategorimutasi, @RequestParam(name = "download", required = false) Boolean download){
        String jasperFileName = null;
        String subReport = null;
        HashMap<String, Object> parameters = null;

        try {
                switch (tipeReport){
                    case "formulir_entry_mutasi" :
                        jasperFileName = "Entry_Mutasi_PensiunPenerimaSelanjutnya";
                        parameters = new HashMap<>();
                        parameters.put("nip", nip);
                        parameters.put("periode_mutasi", periodeMutasi);
                        parameters.put("id_kategori_mutasi", idKategorimutasi);
                        break;

                    case "catatan_perhitungan_manfaat_pensiun" :
                        jasperFileName = "PerhitunganMP_pensiunAanak_AnakUsia25th";
                        subReport = "keluarga_pensiunMI";
                        parameters = new HashMap<>();
                        parameters.put("nip", nip);
                        parameters.put("periode_mutasi", periodeMutasi);
                        parameters.put("id_kategori_mutasi", idKategorimutasi);
                        break;

                    case "sk" :
                            default :
                                jasperFileName = "Keputusan_HakAtasManfaat_PENSIUN__LAMA_ANAK";
                                subReport = "susunan_keluarga_pensiunLama";
                                parameters = new HashMap<>();
                                parameters.put("NIP", nip);
                                parameters.put("id_kategori_mutasi", idKategorimutasi);
                                break;

                    case "kartu" :
                        jasperFileName = "KartuPensiunLama";
                        parameters = new HashMap<>();
                        parameters.put("nip", nip);
                        parameters.put("id_kategori_mutasi", idKategorimutasi);
                        break;

                }
                if (jasperFileName != null){
                    createReport(httpServletResponse, nip, download, parameters, jasperFileName, subReport);
                }

        }catch (IOException | JRException e1) {
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
