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
@RequestMapping(PathPrefix.PENSIUN_LAMA + PathPrefix.REPORT_PENSIUN_LAMA)
public class ReportPensiunLamaController {

    private SetupParameterDao setupParameterDao;
    private ServletContext servletContext;

    public ReportPensiunLamaController(SetupParameterDao setupParameterDao, ServletContext servletContext){
        this.setupParameterDao = setupParameterDao;
        this.servletContext = servletContext;
    }

    @GetMapping
    public String index (Map<String, Object> model) {
        model.put("breadcrumb", getBreadcrumbHolderComponentDtos());
        model.put("laporan_path_api", PathPrefix.API + PathPrefix.REPORT_PENSIUN_LAMA + "/report-pensiun-lama");
        model.put("listPesertaCombo", PathPrefix.API + PathPrefix.MPENSIUN + PathPrefix.DATA + "/status-bayar-1");
        model.put("periodeMutasi", setupParameterDao.findByBukaPeriode().toDto().getPeriode());
        return "pensiunLama/laporan-pensiun-lama";
    }

    private List<BreadcrumbHolderComponentDto> getBreadcrumbHolderComponentDtos() {
        List<BreadcrumbHolderComponentDto> breadcrumb = new ArrayList<>();
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PENSIUN_LAMA, "Pensiun Lama"));
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PENSIUN_LAMA + PathPrefix.REPORT_PENSIUN_LAMA, "Laporan Pensiun Lama"));
        return breadcrumb;
    }
}
