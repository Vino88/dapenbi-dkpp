package com.dapenbi.dkpp.controller;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.*;
import com.dapenbi.dkpp.dao.ViewModel.DashboardViewDao;
import com.dapenbi.dkpp.dto.ViewModelDto.DashboardViewDto;
import com.dapenbi.dkpp.dto.component.AlertMessageComponentDto;
import com.dapenbi.dkpp.dto.component.CardComponentDto;
import com.dapenbi.dkpp.dto.component.SortableListComponentDto;
import com.dapenbi.dkpp.model.SetupParameter;
import com.dapenbi.dkpp.model.ViewModel.DashboardViewModel;
import com.dapenbi.dkpp.util.ReportUtil;
import com.dapenbi.dkpp.util.StringUtil;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping(PathPrefix.DASHBOARD)
public class DashboardController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private SetupParameterDao setupParameterDao;

    @Autowired
    private ServletContext servletContext;

    @Autowired
    private DashboardViewDao dashboardViewDao;

    @Autowired
    private  MutasiPensiunDao mutasiPensiunDao;

    @GetMapping
    public String index(Map<String, Object> model, Pageable pageable)  {
        //SetupParameter periodeMutasi = setupParameterDao.findByBukaPeriode();
        String periodeMutasi = setupParameterDao.findByBukaPeriode().getPeriode();
        List<CardComponentDto> cards = new ArrayList<>();


        SimpleDateFormat formatter = new SimpleDateFormat("MMM-yyyy", Locale.ENGLISH);
        String textStyle = "text-white";
        String textDescStyle = textStyle + " bold";

        cards.add(new CardComponentDto("person", "500", "Penerima Pensiun Normal", "Updated: <span>12:42 PM</span>", "bg-success-lighter", textStyle, textDescStyle, textStyle));
        cards.add(new CardComponentDto("person", "606", "Penerima Pensiun Dipercepat", "Updated: 12:42 PM", "bg-info-lighter", textStyle, textDescStyle, textStyle));
        cards.add(new CardComponentDto("person", "503", "Penerima Pensiun Cacat", "Updated: 12:42 PM", "bg-orange-lighter", textStyle, textDescStyle, textStyle));
        cards.add(new CardComponentDto("person", "300", "Penerima Pensiun Tunda", "Updated: 12:42 PM", "bg-danger-lighter", textStyle, textDescStyle, textStyle));
        cards.add(new CardComponentDto("person", "300", "Penerima Manfaat Pensiun", "Updated: 12:42 PM", "bg-teal-lighter", textStyle, textDescStyle, textStyle));
        cards.add(new CardComponentDto("person", "300", "Penerima MP Janda", "Updated: 12:42 PM", "bg-pink-lighter", textStyle, textDescStyle, textStyle));
        cards.add(new CardComponentDto("person", "300", "Penerima MP Duda", "Updated: 12:42 PM", "bg-purple-lighter", textStyle, textDescStyle, textStyle));
        cards.add(new CardComponentDto("person", "300", "Penerima MP Anak", "Updated: 12:42 PM", "bg-primary-lighter", textStyle, textDescStyle, textStyle));

        model.put("cards", cards);

        List<SortableListComponentDto> taskList = new ArrayList<>();

        taskList.add(new SortableListComponentDto("10", "bg-danger", "Data Peserta Pensiun yang Belum Dilepaskan"));
        taskList.add(new SortableListComponentDto("4", "bg-danger", "Data Peserta Pensiun Yang Sudah Dilepaskan"));
        taskList.add(new SortableListComponentDto("100", "bg-danger", "Data Pensiun Tunda Jatuh Tempo Dibayar"));
        taskList.add(new SortableListComponentDto("Belum diproses", "bg-danger", "Data Pensiun Tunda Jatuh Tempo Dibayar (OJK)"));
        taskList.add(new SortableListComponentDto("100", "bg-danger", "Mutasi Penerima MP Anak 25 Tahun dan MP Bulan ke-13"));
        taskList.add(new SortableListComponentDto("100", "bg-danger", "Mutasi Lebih Bayar (Angsuran)"));
        taskList.add(new SortableListComponentDto("100", "bg-danger", "Data Penerima MP Belum Punya Rekening/Rekening Tidak Valid"));

        model.put("taskList", taskList);

        List<AlertMessageComponentDto> messages = new ArrayList<>();
        //messages.add(new AlertMessageComponentDto("alert-danger", "Pokonya error aja"));
//        messages.add(new AlertMessageComponentDto("alert-danger", "Lagi-lagi error"));
        //messages.add(new AlertMessageComponentDto("alert-warning", "Kayanya ini bukan error"));

        model.put("messages", messages);

        model.put("users", userDao.findAllActive());

        model.put("periodeMutasi", setupParameterDao.findByBukaPeriode().getPeriode());

        model.put("status", setupParameterDao.findByBukaPeriode().isBukaPeriode());

        DashboardViewModel dashboardViewModel = dashboardViewDao.findByPeriodeMutasi(periodeMutasi);
        DashboardViewDto dashboardViewDto = dashboardViewModel.toDto();
        model.put("jumlahPenerimaYgBlmHer", dashboardViewDto.getJumlahPenerimaYgBlmHer());
        //taskList
        model.put("jumlahYgBelumDilepaskan", dashboardViewDto.getJumlahPesertaBelumDilepas());
        model.put("jumlahYgSudahDilepaskan", dashboardViewDto.getJumlahPesertaSudahDilepas());
        model.put("jumlahPensiunTundaDibayar", dashboardViewDto.getJumlahPensiunTunda());
        model.put("JumlahPtOjk", dashboardViewDto.getJumlahPensiunTundaOjk());
        model.put("jumlahMpAnakBln13", dashboardViewDto.getJumlahMpAnakBulan13());
        model.put("jumlahMutasiLbhBayar", dashboardViewDto.getJumlahMutasiLebihBayar());
        model.put("jumlahBelumPunyaNorek", dashboardViewDto.getBelumPunyaNorek());

        //Dashboard
        model.put("jmlPN", dashboardViewDto.getJumlahPn());
        model.put("jmlPD", dashboardViewDto.getJumlahPd());
        model.put("jmlPC", dashboardViewDto.getJumlahPc());
        model.put("jmlPT", dashboardViewDto.getJumlahPt());
        model.put("jmlPenerima", dashboardViewDto.getJumlahPenerimaMp());
        model.put("jmlJanda", dashboardViewDto.getJumlahPenerimaJanda());
        model.put("jmlDuda", dashboardViewDto.getJumlahPenerimaDuda());
        model.put("jmlAnak", dashboardViewDto.getJumlahPenerimaAnak());
        model.put("update", dashboardViewDto.getUpdateAt());


        return "dashboard";
    }

  /*  @GetMapping("/report")
    public void report(HttpServletResponse httpServletResponse) {
        Map<String, Object> params = new HashMap<>();
        params.put("htmlCode", "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01//EN\">\n" +
                "<html>\n" +
                "<head>\n" +
                "    <title>Sample of html based report</title>\n" +
                "    <style type=\"text/css\">\n" +
                "        body {\n" +
                "            padding-left: 11em;\n" +
                "            font-family: Georgia, \"Times New Roman\",\n" +
                "            Times, serif;\n" +
                "            color: purple;\n" +
                "            background-color: #a5d8da\n" +
                "        }\n" +
                "\n" +
                "        h1 {\n" +
                "            font-family: Helvetica, Geneva, Arial,\n" +
                "            SunSans-Regular, sans-serif\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "<h1>This is a sample of html based report</h1>\n" +
                "\n" +
                "<p>Only minimal html features are supported</p>\n" +
                "\n" +
                "<p>At least images are supported</p>\n" +
                "<br/><br/>\n" +
                "<img src='file:/C:\\images\\smile.png' alt='Smile' height='100' width='100'>\n" +
                "</body>\n" +
                "</html>");

        try {
            String jasperFileName = "reportTest";

            // Set web response output stream
            MediaType mediaType = MediaType.parseMediaType("application/pdf");
            httpServletResponse.setContentType(mediaType.getType());
            httpServletResponse.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + jasperFileName + "-" + new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + ".pdf");

            // Set report
            ReportUtil reportUtil = new ReportUtil("sample/" + jasperFileName, httpServletResponse.getOutputStream());

            reportUtil.setReport(params, new JREmptyDataSource(), new JRPdfExporter());

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
    } */
}
