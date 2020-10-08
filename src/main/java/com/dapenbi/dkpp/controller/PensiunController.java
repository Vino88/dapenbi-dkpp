package com.dapenbi.dkpp.controller;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dto.component.BreadcrumbHolderComponentDto;
import com.dapenbi.dkpp.dto.component.JenisKelaminEnum;
import com.dapenbi.dkpp.dto.component.Select2Default;
import com.dapenbi.dkpp.util.SelectValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(PathPrefix.PENSIUN)
public class PensiunController extends MasterDataController {

    @Autowired
    private ServletContext servletContext;

    @GetMapping
    public String index(Map<String, Object> model) {

        List<BreadcrumbHolderComponentDto> breadcrumb = new ArrayList<>();
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + "/master-data", "Master Data"));
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + "/master-data/pensiun", "Master Pensiun"));

        model.put("breadcrumb", breadcrumb);
        model.put("gender", SelectValueUtil.createGenderSelect());
        model.put("pensiunPathApi", PathPrefix.API + PathPrefix.PENSIUN);
        model.put("masterAgamaPathApi", PathPrefix.API + PathPrefix.AGAMA);
        model.put("golonganPathApi", PathPrefix.API + PathPrefix.GOLONGAN);
        model.put("predikatPemberhentianPathApi", PathPrefix.API + PathPrefix.PREDIKAT_PEMBERHENTIAN);
        model.put("alasanHentiPathApi", PathPrefix.API + PathPrefix.ALASAN_HENTI);
        return "masterData/pensiun";
    }
}
