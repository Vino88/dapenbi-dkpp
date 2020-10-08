package com.dapenbi.dkpp.controller.api;


import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.util.ReportCompiler;
import com.dapenbi.dkpp.util.ReportUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(PathPrefix.API + PathPrefix.REPORT_HER_REGISTRASI)
public class ReportHerRegistrasiApiController {

    private DataSource dataSource;

    public ReportHerRegistrasiApiController(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @GetMapping("/laporan-registrasi")
    public void report(HttpServletResponse httpServletResponse, @RequestParam("tglHer") String tglHer, @RequestParam("tipeReport") String tipeReport, @RequestParam(name="download", required = false) Boolean download){
        String jasperFileName = null;
        Map<String, Object> parameters = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy");

        try {

            switch (tipeReport) {
                case "01":
                    jasperFileName = "LaporanRegistrasiPenerimaManfaatPensiunYangSudahRegistrasi";
                    parameters = new HashMap<>();
                    parameters.put("tgl_her", tglHer);
                    break;

                case "02":
                    jasperFileName = "LaporanRegistrasiPenerimaManfaatPensiunYangBelumRegistrasi2";
                    parameters = new HashMap<>();
                    parameters.put("tanggal_her", tglHer);
                    break;

                case "03":
                    jasperFileName = "RekapitulasiPenerimaMPPesertaJandaDudaAnakSudahRegistrasiUlang";
                    parameters = new HashMap<>();
                    parameters.put("tanggal_her", tglHer);
                    break;

                case "04" :
                    jasperFileName = "RekapitulasiPenerimaMPPesertaJandaDudaAnakBelumRegistrasiUlang2";
                    parameters = new HashMap<>();
                    parameters.put("tanggal_her", tglHer);
                    break;
            }
            if (jasperFileName != null) {
                createReport(httpServletResponse, tglHer, download, parameters, jasperFileName);
            }

        } catch (IOException | JRException e1) {
            e1.printStackTrace();
        }
    }

    private void createReport(HttpServletResponse httpServletResponse, String tglHer, Boolean download, Map<String, Object> parameters, String jasperFileName) throws JRException, IOException {
        ReportCompiler rc = new ReportCompiler();
        JasperReport jasperReport = rc.compileReport(jasperFileName);
        setReportHeader(httpServletResponse, tglHer, jasperFileName, download);
        // Set report
        ReportUtil reportUtil = new ReportUtil(jasperFileName, httpServletResponse.getOutputStream());
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

    private void setReportHeader(HttpServletResponse httpServletResponse, String tglHer, String jasperFileName, Boolean download) {
        // Set web response output stream
        MediaType mediaType = MediaType.parseMediaType("application/pdf");
        httpServletResponse.setContentType(mediaType.getType());
        if ((download != null) && (download)) {
            httpServletResponse.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + jasperFileName + "-" + new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + tglHer + ".pdf");
        } else {
            httpServletResponse.setHeader(HttpHeaders.CONTENT_TYPE, "application/pdf");
        }
    }

}
