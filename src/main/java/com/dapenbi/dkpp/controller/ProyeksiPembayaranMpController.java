package com.dapenbi.dkpp.controller;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dto.DkppUserDetail;
import com.dapenbi.dkpp.dto.component.BreadcrumbHolderComponentDto;
import com.dapenbi.dkpp.util.DkppUserStamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(PathPrefix.PEMBAYARAN + PathPrefix.PROYEKSI_PEMBAYARAN_MP)
public class ProyeksiPembayaranMpController {
    ServletContext servletContext;

    @Autowired
    public ProyeksiPembayaranMpController(ServletContext servletContext){
        this.servletContext = servletContext;
    }

    @GetMapping
    public String index(Map<String,Object> model) {
        List<BreadcrumbHolderComponentDto> breadcrumb = new ArrayList<>();
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PEMBAYARAN, "Pembayaran"));
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PEMBAYARAN + PathPrefix.PROYEKSI_PEMBAYARAN_MP, "  Proyeksi Pembayaran Pensiun"));
        model.put("breadcrumb", breadcrumb);
        String userStamp = DkppUserStamp.getCompName() + " # " + DkppUserStamp.getUserName() + " # " + DkppUserStamp.getTimeStamp();
        model.put("userStamp", userStamp);
        model.put("proyeksi_master_path", PathPrefix.API + PathPrefix.PEMBAYARAN + PathPrefix.PROYEKSI_PEMBAYARAN_MP + "/master");
        model.put("proyeksi_pensbaru_path", PathPrefix.API + PathPrefix.PEMBAYARAN + PathPrefix.PROYEKSI_PEMBAYARAN_MP + "/pens-baru");

        return "pembayaran/proyeksi-pembayaran-pensiun";
    }
}
