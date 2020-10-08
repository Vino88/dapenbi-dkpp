package com.dapenbi.dkpp.controller;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dto.component.BreadcrumbHolderComponentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(PathPrefix.PEMBAYARAN + PathPrefix.PEMBAYARAN_MPS_BULANAN_DETAIL)
public class PembayaranMpDetailMpsController {

    private ServletContext servletContext;

    @Autowired
    public PembayaranMpDetailMpsController(ServletContext servletContext){
        this.servletContext = servletContext;
    }

    @GetMapping("/pembayaran")
    public String index(Map<String,Object> model, @RequestParam(name="id_pembayaran") String idPembayaran){
        List<BreadcrumbHolderComponentDto> breadcrumb = new ArrayList<>();
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath()+ PathPrefix.PEMBAYARAN,"Pembayaran"));
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PEMBAYARAN+PathPrefix.PEMBAYARAN_MP_BULANAN,"Pembayaran MP Bulanan"));
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath()+PathPrefix.PEMBAYARAN+PathPrefix.PEMBAYARAN_MPS_BULANAN_DETAIL+"/pembayaran"+"?id_pembayaran="+idPembayaran,"Rincian Pembayaran MP Sekaligus"));
        model.put("idPembayaran", idPembayaran);
        model.put("breadcrumb",breadcrumb);
        return "pembayaran/pembayaran-mp-bulanan-detail-sekaligus";
    }
}
