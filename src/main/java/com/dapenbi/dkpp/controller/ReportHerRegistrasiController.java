package com.dapenbi.dkpp.controller;


import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dto.component.BreadcrumbHolderComponentDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(PathPrefix.HERREGISTRASI + PathPrefix.REPORT_HER_REGISTRASI)
public class ReportHerRegistrasiController extends MasterDataController {

    @GetMapping
    public String index(Map<String, Object> model) {
        List<BreadcrumbHolderComponentDto> breadcrumb = new ArrayList<>();
        breadcrumb.add(new BreadcrumbHolderComponentDto(PathPrefix.HERREGISTRASI, "Her-Registrasi"));
        breadcrumb.add(new BreadcrumbHolderComponentDto(PathPrefix.HERREGISTRASI + PathPrefix.REPORT_HER_REGISTRASI, "Laporan Registrasi Ulang"));
        model.put("laporan_path_api", PathPrefix.API+ PathPrefix.REPORT_HER_REGISTRASI+ "/laporan-registrasi");
        model.put("listPesertaCombo", PathPrefix.API + PathPrefix.MPENSIUN + PathPrefix.DROPDOWN);
        model.put("breadcrumb", breadcrumb);

        return "herRegistrasi/laporan-registrasi";
    }
}
