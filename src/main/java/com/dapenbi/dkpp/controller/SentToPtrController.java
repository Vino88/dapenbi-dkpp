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
@RequestMapping(PathPrefix.PEMBAYARAN + PathPrefix.SENT_TO_PTR)
public class SentToPtrController {
    private ServletContext servletContext;

    public SentToPtrController(ServletContext servletContext){
        this.servletContext = servletContext;
    }

    @GetMapping
    public String index(Map<String, Object> model) {
        model.put("breadcrumb", getBreadcrumbHolderComponentDtos());
        model.put("tb_sent_to_ptr", PathPrefix.API + PathPrefix.SENT_TO_PTR + "/sent-to-ptr");
        model.put("tb_sent_to_ptr_nf", PathPrefix.API + PathPrefix.SENT_TO_PTR + "/sent-to-ptr-nf");
        return "pembayaran/penyelesaian-transaksi";
    }

    private List<BreadcrumbHolderComponentDto> getBreadcrumbHolderComponentDtos() {
        List<BreadcrumbHolderComponentDto> breadcrumb = new ArrayList<>();
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PEMBAYARAN, "PEMBAYARAN"));
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PEMBAYARAN + PathPrefix.SENT_TO_PTR, "SENT TO PTR"));
        return breadcrumb;
    }

}
