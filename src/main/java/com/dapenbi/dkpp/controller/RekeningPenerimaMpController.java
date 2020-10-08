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
@RequestMapping(PathPrefix.MASTER_DATA + PathPrefix.REKENING_PENERIMA_MP)
public class RekeningPenerimaMpController {

    @GetMapping
    public String index(Map<String, Object> model){
        List<BreadcrumbHolderComponentDto> breadcrumb = new ArrayList<>();
        breadcrumb.add(new BreadcrumbHolderComponentDto(PathPrefix.MASTER_DATA, "Master Data"));
        breadcrumb.add(new BreadcrumbHolderComponentDto(PathPrefix.MASTER_DATA + PathPrefix.REKENING_PENERIMA_MP, "Rekening Penerima MP"));
        model.put("breadcrumb", breadcrumb);

        return "masterData/rekening-penerima-mp";
    }
}
