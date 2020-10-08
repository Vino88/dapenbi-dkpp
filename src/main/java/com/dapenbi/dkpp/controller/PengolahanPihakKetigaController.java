package com.dapenbi.dkpp.controller;

import com.dapenbi.dkpp.PathPrefix;
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
@RequestMapping(PathPrefix.PEMBAYARAN + PathPrefix.PENGOLAHAN_PIHAK_KETIGA)
public class PengolahanPihakKetigaController {

    ServletContext servletContext;

    @Autowired
    public PengolahanPihakKetigaController(ServletContext servletContext){
        this.servletContext = servletContext;
    }

    @GetMapping
    public String index(Map<String,Object> model) {
        List<BreadcrumbHolderComponentDto> breadcrumb = new ArrayList<>();
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PEMBAYARAN, "Pembayaran"));
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PEMBAYARAN + PathPrefix.PENGOLAHAN_PIHAK_KETIGA, "  Pengolahan Data Untuk Kebutuhan Pihak ke-3"));
        model.put("breadcrumb", breadcrumb);

        return "pembayaran/pengolahan-pihak-ketiga";
    }
}
