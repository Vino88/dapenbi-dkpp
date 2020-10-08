package com.dapenbi.dkpp.controller.report;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dto.KeluargaPensiunDto;
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
public class PerhitunganMPNormalTanpaMPS20PersenController {

    @Autowired
    private DataSource dataSource;

    public void index(){

    }






}
