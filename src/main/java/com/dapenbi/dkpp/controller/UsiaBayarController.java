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
@RequestMapping(PathPrefix.MASTER_DATA + PathPrefix.USIABAYAR)
public class UsiaBayarController {

    private ServletContext servletContext;

    @Autowired
    public UsiaBayarController(ServletContext servletContext){
        this.servletContext = servletContext;
    }

    @GetMapping
    public String index(Map<String, Object> model){

        List<BreadcrumbHolderComponentDto> breadcrumb = new ArrayList<>();
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath()+"/master-data","Master Data"));
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath()+"/master-data/usiabayar", "Usia Bayar"));

        model.put("breadcrumb", breadcrumb);
        return "masterData/usiabayar";

    }
}
