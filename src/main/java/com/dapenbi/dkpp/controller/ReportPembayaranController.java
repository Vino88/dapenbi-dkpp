package com.dapenbi.dkpp.controller;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.SetupParameterDao;
import com.dapenbi.dkpp.dto.component.BreadcrumbHolderComponentDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(PathPrefix.PEMBAYARAN + PathPrefix.LAPORAN_PEMBAYARAN)
public class ReportPembayaranController {

    SetupParameterDao setupParameterDao;
    ServletContext servletContext;

    public ReportPembayaranController(SetupParameterDao setupParameterDao, ServletContext servletContext){
        this.setupParameterDao = setupParameterDao;
        this.servletContext = servletContext;
    }

    @GetMapping
    public String index(Map<String, Object> model){
        model.put("breadcrumb", getBreadcrumbHolderComponentDtos());
        model.put("report_pembayaran", PathPrefix.API + PathPrefix.LAPORAN_PEMBAYARAN + "/report-pembayaran");
        model.put("listPesertaCombo", PathPrefix.API + PathPrefix.MPENSIUN + PathPrefix.DROPDOWN);
        model.put("periodeMutasi", setupParameterDao.findByBukaPeriode().getPeriode());
        return "pembayaran/laporan";
    }

    private List<BreadcrumbHolderComponentDto> getBreadcrumbHolderComponentDtos() {
        List<BreadcrumbHolderComponentDto> breadcrumb = new ArrayList<>();
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PEMBAYARAN, "Pembayaran"));
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PEMBAYARAN + PathPrefix.LAPORAN_PEMBAYARAN, "Laporan Pembayaran"));
        return breadcrumb;
    }
}