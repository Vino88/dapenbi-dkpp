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
@RequestMapping(PathPrefix.PENSIUN_BARU + PathPrefix.REPORT_MUTASI_PENSIUN_BARU)
public class ReportPensiunBaruController {

    private SetupParameterDao setupParameterDao;
    private ServletContext servletContext;

    public ReportPensiunBaruController(SetupParameterDao setupParameterDao, ServletContext servletContext){
        this.setupParameterDao = setupParameterDao;
        this.servletContext = servletContext;
    }

    @GetMapping
    public String index(Map<String, Object> model) {
        model.put("breadcrumb", getBreadcrumbHolderComponentDtos());
        model.put("laporan_path_api", PathPrefix.API+ PathPrefix.REPORT_MUTASI_PENSIUN_BARU+ "/report-mutasi-pensiun-baru");
        model.put("listPesertaCombo", PathPrefix.API + PathPrefix.MPENSIUN + PathPrefix.DROPDOWN);
        model.put("periodeMutasi", setupParameterDao.findByBukaPeriode().toDto().getPeriode());
        return "pensiunBaru/laporan-mutasi-pensiun-baru";
    }

    private List<BreadcrumbHolderComponentDto> getBreadcrumbHolderComponentDtos() {
        List<BreadcrumbHolderComponentDto> breadcrumb = new ArrayList<>();
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PENSIUN_BARU, "Pensiun Baru"));
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PENSIUN_BARU + PathPrefix.REPORT_MUTASI_PENSIUN_BARU, "Laporan Pensiun Baru"));
        return breadcrumb;
    }
}
