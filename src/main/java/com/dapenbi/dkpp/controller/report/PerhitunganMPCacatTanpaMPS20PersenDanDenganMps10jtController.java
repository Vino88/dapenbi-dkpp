package com.dapenbi.dkpp.controller.report;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.util.ReportCompiler;
import com.dapenbi.dkpp.util.ReportUtil;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;


@Controller
public class PerhitunganMPCacatTanpaMPS20PersenDanDenganMps10jtController {

    @Autowired
    private DataSource dataSource;

    public void index(){

    }

    @GetMapping(PathPrefix.REPORT + PathPrefix.PERHITUNGAN_MP_CACAT_TANPA20_DENGAN10)
    public void report(HttpServletResponse httpServletResponse) {
        try {
            HashMap<String, Object> parameters = new HashMap<>();
            String jasperFileName = "PerhitunganMPCacat_TanpaMPS20PersenDanDenganMPS_10J_A4";
            String subReport = "keluarga_pensiun_A4";

            //Compile jrxml first
            ReportCompiler rc = new ReportCompiler();
            JasperReport jasperSubReport = rc.compileReport(subReport);
            JasperReport jasperReport = rc.compileReport(jasperFileName);

            // Set web response output stream
            MediaType mediaType = MediaType.parseMediaType("application/pdf");
            httpServletResponse.setContentType(mediaType.getType());
            httpServletResponse.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + jasperFileName + "-" + new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + ".pdf");

            // Set report
            ReportUtil reportUtil = new ReportUtil(jasperFileName, httpServletResponse.getOutputStream());
       //     parameters.put("subReport", reportUtil.getSubReportPath(subReport));
            Connection conn = DataSourceUtils.getConnection(dataSource);
            reportUtil.setReport(parameters, conn, new JRPdfExporter());

            SimplePdfReportConfiguration reportConfig
                    = new SimplePdfReportConfiguration();
            reportConfig.setSizePageToContent(true);
            reportConfig.setForceLineBreakPolicy(false);

            reportUtil.getExporter().setConfiguration(reportConfig);

            // write report to output stream
            reportUtil.getExporter().exportReport();
            reportUtil.getOutputStream().flush();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }


}
