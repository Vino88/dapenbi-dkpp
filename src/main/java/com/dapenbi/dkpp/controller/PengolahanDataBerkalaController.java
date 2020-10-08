package com.dapenbi.dkpp.controller;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.SetupParameterDao;
import com.dapenbi.dkpp.dto.component.BreadcrumbHolderComponentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(PathPrefix.PEMBAYARAN + PathPrefix.PENGOLAHAN_DATA_BERKALA)
public class PengolahanDataBerkalaController {

    ServletContext servletContext;
    SetupParameterDao setupParameterDao;

    @Autowired
    public PengolahanDataBerkalaController(ServletContext servletContext, SetupParameterDao setupParameterDao){
        this.servletContext = servletContext;
        this.setupParameterDao = setupParameterDao;
    }

    @GetMapping
    public String index(Map<String,Object> model) {
        List<BreadcrumbHolderComponentDto> breadcrumb = new ArrayList<>();
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PEMBAYARAN, "Pembayaran"));
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PEMBAYARAN + PathPrefix.PENGOLAHAN_DATA_BERKALA, "   Pengolahan Data Berkala"));
        model.put("periodeMutasi", setupParameterDao.findByBukaPeriode().getPeriode());
        model.put("data_path_api", PathPrefix.API + PathPrefix.PENGOLAHAN_DATA_BERKALA + "/cuspReportDataBerkala");
        model.put("breadcrumb", breadcrumb);

        return "pembayaran/pengolahan-data-berkala";
    }
}
