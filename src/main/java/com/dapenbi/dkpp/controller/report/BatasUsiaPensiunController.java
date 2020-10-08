package com.dapenbi.dkpp.controller.report;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.util.ReportUtil;
import net.sf.jasperreports.engine.*;
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
import java.io.IOException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
public class BatasUsiaPensiunController {

    @Autowired
    private DataSource dataSource;

    public void index(){

    }

    @GetMapping(PathPrefix.REPORT + PathPrefix.BATAS_USIA_PENSIUN)
    public void report(HttpServletResponse httpServletResponse) {
        try {


            String jasperFileName = "MutasiPensiunBaru_BatasUsiaPensiun_A4";


            // Set web response output stream
            MediaType mediaType = MediaType.parseMediaType("application/pdf");
            httpServletResponse.setContentType(mediaType.getType());
            httpServletResponse.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + jasperFileName + "-" + new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + ".pdf");

            // Set report
            ReportUtil reportUtil = new ReportUtil(jasperFileName, httpServletResponse.getOutputStream());
            Connection conn = DataSourceUtils.getConnection(dataSource);
            reportUtil.setReport(null, conn, new JRPdfExporter());

            SimplePdfReportConfiguration reportConfig
                    = new SimplePdfReportConfiguration();
            reportConfig.setSizePageToContent(true);
            reportConfig.setForceLineBreakPolicy(false);

            reportUtil.getExporter().setConfiguration(reportConfig);

            // write report to output stream
            reportUtil.getExporter().exportReport();
            reportUtil.getOutputStream().flush();
        } catch (IOException | JRException e) {
            e.printStackTrace();
        }
    }

}
