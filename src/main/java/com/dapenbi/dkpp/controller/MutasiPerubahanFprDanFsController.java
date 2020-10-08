package com.dapenbi.dkpp.controller;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dto.DkppUserDetail;
import com.dapenbi.dkpp.dto.RoleDto;
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
@RequestMapping(PathPrefix.PEMBAYARAN + PathPrefix.MUTASI_PERUBAHAN_FPR_FS)
public class MutasiPerubahanFprDanFsController {

    private ServletContext servletContext;

    @Autowired
    public MutasiPerubahanFprDanFsController(ServletContext servletContext){
        this.servletContext = servletContext;
    }

    @GetMapping
    public String index(Map<String,Object> model){
        List<BreadcrumbHolderComponentDto> breadcrumb = new ArrayList<>();
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PEMBAYARAN,"Pembayaran"));
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PEMBAYARAN+PathPrefix.MUTASI_PERUBAHAN_FPR_FS,"Mutasi Perubahan FPR dan FS"));
        DkppUserDetail user = DkppUserStamp.getUserPrincipal();
        RoleDto role = user.getUser().getRoles().get(0);

        model.put("breadcrumb",breadcrumb);
        model.put("isPejabat", role.getName().equals("Pejabat")?true:false );
        model.put("isStaff", role.getName().equals("Staff")?true:false );
        model.put("isAdmin", role.getName().equals("Admin")?true:false );
        model.put("listKategoriCatatan", PathPrefix.API + PathPrefix.KATEGORICATATAN + PathPrefix.DROPDOWN);
        model.put("listPeriodeSetupParameter", PathPrefix.API + PathPrefix.SETUPPARAMETER + "/get_periode");

        return "pembayaran/mutasi-perubahan-fpr-fs";
    }
}
