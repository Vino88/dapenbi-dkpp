package com.dapenbi.dkpp.controller;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dto.component.BreadcrumbHolderComponentDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(PathPrefix.PENSIUN_LAMA + PathPrefix.UPLOAD_POTONGAN)
public class UploadPotonganController {

    @GetMapping
    public String index(Map<String, Object> model){
        List<BreadcrumbHolderComponentDto> breadcrumb = new ArrayList<>();
        breadcrumb.add(new BreadcrumbHolderComponentDto(PathPrefix.PENSIUN_LAMA, "Pensiun Lama"));
        breadcrumb.add(new BreadcrumbHolderComponentDto(PathPrefix.PENSIUN_LAMA + PathPrefix.UPLOAD_POTONGAN, "Upload Potongan Kewajiban Pensiun"));
        model.put("uploadPotonganLink", PathPrefix.API + PathPrefix.UPLOAD_POTONGAN);
        model.put("listPeriodeSetupParameter", PathPrefix.API + PathPrefix.SETUPPARAMETER + "/get_periode");

        model.put("breadcrumb", breadcrumb);

        return "pensiunLama/upload-potongan";
    }
}
