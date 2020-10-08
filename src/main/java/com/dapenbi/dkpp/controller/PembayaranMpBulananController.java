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
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(PathPrefix.PEMBAYARAN + PathPrefix.PEMBAYARAN_MP_BULANAN)
public class PembayaranMpBulananController {

    private ServletContext servletContext;

    @Autowired
    public PembayaranMpBulananController(ServletContext servletContext){
        this.servletContext = servletContext;
    }

    @GetMapping
    public String index(Map<String,Object>model){
        List<BreadcrumbHolderComponentDto> breadcrumb = new ArrayList<>();
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PEMBAYARAN,"Pembayaran"));
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PEMBAYARAN+PathPrefix.PEMBAYARAN_MP_BULANAN,"Pembayaran MP Bulanan"));
        DkppUserDetail user = DkppUserStamp.getUserPrincipal();
        RoleDto role = user.getUser().getRoles().get(0);

        model.put("isPejabat", role.getName().equals("Pejabat")?true:false );
        model.put("isStaff", role.getName().equals("Staff")?true:false );
        model.put("isAdmin", role.getName().equals("Admin")?true:false );
        model.put("detailMp",servletContext.getContextPath() + PathPrefix.PEMBAYARAN+PathPrefix.PEMBAYARAN_MP_BULANAN+"/pembayaran-mp-bulanan-detail" );
        model.put("detailMps", servletContext.getContextPath() + PathPrefix.PEMBAYARAN + PathPrefix.PEMBAYARAN_MPS_BULANAN_DETAIL + "/pembayaran");
        model.put("breadcrumb",breadcrumb);
        return "pembayaran/pembayaran-mp-bulanan";
    }

    @GetMapping("/pembayaran-mp-bulanan-detail")
    public String pembayaranMpBulananDetail(Map<String,Object> model, @RequestParam(name="id_pembayaran") String idPembayaran){
        List<BreadcrumbHolderComponentDto> breadcrumb = new ArrayList<>();
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath()+PathPrefix.PEMBAYARAN,"Pembayaran"));
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PEMBAYARAN+PathPrefix.PEMBAYARAN_MP_BULANAN,"Pembayaran MP Bulanan"));
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath()+PathPrefix.PEMBAYARAN+ PathPrefix.PEMBAYARAN_MP_BULANAN+PathPrefix.PEMBAYARAN_MP_BULANAN_DETAIL+"?id_pembayaran="+idPembayaran,"Rincian Pembayaran MP Bulanan"));
        model.put("idPembayaran",idPembayaran);
        model.put("breadcrumb",breadcrumb);
        return "pembayaran/pembayaran-mp-bulanan-detail";
    }
}
