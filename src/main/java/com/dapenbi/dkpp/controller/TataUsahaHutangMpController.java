package com.dapenbi.dkpp.controller;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dto.component.BreadcrumbHolderComponentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(PathPrefix.PEMBAYARAN + PathPrefix.TATAUSAHA_HUTANG_MP)
public class TataUsahaHutangMpController {

    ServletContext servletContext;

    @Autowired
    public TataUsahaHutangMpController(ServletContext servletContext){
        this.servletContext = servletContext;
    }

    @GetMapping
    public String index(Map<String,Object> model){
        List<BreadcrumbHolderComponentDto> breadcrumb = new ArrayList<>();
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PEMBAYARAN,"Pembayaran"));
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PEMBAYARAN+PathPrefix.TATAUSAHA_HUTANG_MP," Tata Usaha Hutang (Uang Pembinaan dan Manfaat Pensiun)"));
        model.put("breadcrumb",breadcrumb);
        model.put("linkDataHutang", servletContext.getContextPath() + PathPrefix.API + PathPrefix.TATAUSAHA_HUTANG_MP);
        model.put("linkDataHutangPembinaan", servletContext.getContextPath() + PathPrefix.API + PathPrefix.TATAUSAHA_HUTANG_MP + "/pembinaan");
        model.put("linkDataPembayaranHutang", servletContext.getContextPath() + PathPrefix.API + PathPrefix.TATAUSAHA_HUTANG_MP + "/pembayaran");
        model.put("linkDataPembayaranHutangPembinaan", servletContext.getContextPath() + PathPrefix.API + PathPrefix.TATAUSAHA_HUTANG_MP + "/pembayaran-pembinaan");
        model.put("entryHutangMp",servletContext.getContextPath() + PathPrefix.PEMBAYARAN+PathPrefix.TATAUSAHA_HUTANG_MP +"/entry-mutasi-hutang");
        model.put("entryPembayaranHutangMp",servletContext.getContextPath() + PathPrefix.PEMBAYARAN+PathPrefix.TATAUSAHA_HUTANG_MP +"/entry-pembayaran-hutang-mp");
        model.put("entryHutangMpPembinaan",servletContext.getContextPath() + PathPrefix.PEMBAYARAN+PathPrefix.TATAUSAHA_HUTANG_MP +"/entry-mutasi-hutang-uang-pembinaan");
        model.put("entryPembayaranHutangMpPembinaan",servletContext.getContextPath() + PathPrefix.PEMBAYARAN+PathPrefix.TATAUSAHA_HUTANG_MP +"/entry-pembayaran-hutang-uang-pembinaan");
        model.put("linkCallSpPembayaran", servletContext.getContextPath() + PathPrefix.API + PathPrefix.TATAUSAHA_HUTANG_MP + "/process-call-sp");
        model.put("linkCallSpPembayaranPtr", servletContext.getContextPath() + PathPrefix.API + PathPrefix.TATAUSAHA_HUTANG_MP + "/process-call-sp-ptr");
        model.put("linkBack", servletContext.getContextPath() + PathPrefix.PEMBAYARAN+PathPrefix.TATAUSAHA_HUTANG_MP);
        return "pembayaran/tata-usaha-hutang-mp";
    }

    @GetMapping("/detail/{id_hutang}")
    public String entryMutasiHutang(Map<String,Object>model, @PathVariable(name="id_hutang") Long idHutang){
        List<BreadcrumbHolderComponentDto> breadcrumb = new ArrayList<>();
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PEMBAYARAN,"Pembayaran"));
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PEMBAYARAN+PathPrefix.TATAUSAHA_HUTANG_MP," Tata Usaha Hutang (Uang Pembinaan dan Manfaat Pensiun)"));
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PEMBAYARAN+PathPrefix.TATAUSAHA_HUTANG_MP +"/entry-mutasi-hutang","Entry Hutang MP"));
        model.put("breadcrumb", breadcrumb);
        model.put("idHutang", idHutang);
        model.put("linkHeaderHutang", servletContext.getContextPath() + PathPrefix.API + PathPrefix.TATAUSAHA_HUTANG_MP + "/get-header/" + idHutang );
        model.put("detailHutangLink", servletContext.getContextPath() + PathPrefix.API + PathPrefix.TATAUSAHA_HUTANG_MP + "/get-detail/" + idHutang );
        return "pembayaran/entry-mutasi-hutang";
    }

    @GetMapping("/detail-pembinaan/{id_hutang}")
    public String entryMutasiHutangPembinaan(Map<String,Object>model, @PathVariable("id_hutang") String idHutang){
        List<BreadcrumbHolderComponentDto> breadcrumb = new ArrayList<>();
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PEMBAYARAN,"Pembayaran"));
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PEMBAYARAN+PathPrefix.TATAUSAHA_HUTANG_MP," Tata Usaha Hutang (Uang Pembinaan dan Manfaat Pensiun)"));
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PEMBAYARAN+PathPrefix.TATAUSAHA_HUTANG_MP +"/entry-mutasi-hutang","Entry Hutang MP"));
        model.put("breadcrumb", breadcrumb);
        model.put("idHutang", idHutang);
        model.put("linkHeaderHutang", servletContext.getContextPath() + PathPrefix.API + PathPrefix.TATAUSAHA_HUTANG_MP + "/get-header/" + idHutang );
        model.put("detailHutangLink", servletContext.getContextPath() + PathPrefix.API + PathPrefix.TATAUSAHA_HUTANG_MP + "/get-detail/" + idHutang );
        return "pembayaran/entry-mutasi-hutang";
    }

    @GetMapping("/detail-pembayaran-mp/{id}")
    public String entryPembayaranHutang(Map<String,Object>model, @PathVariable(name = "id") Long id){
        List<BreadcrumbHolderComponentDto> breadcrumb = new ArrayList<>();
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PEMBAYARAN,"Pembayaran"));
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PEMBAYARAN+PathPrefix.TATAUSAHA_HUTANG_MP," Tata Usaha Hutang (Uang Pembinaan dan Manfaat Pensiun)"));
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PEMBAYARAN+PathPrefix.TATAUSAHA_HUTANG_MP +"/entry-pembayaran-hutang-mp","Entry Pembayaran Hutang MP"));
        model.put("breadcrumb", breadcrumb);
        model.put("linkHeaderPembayaranHutang", servletContext.getContextPath() + PathPrefix.API + PathPrefix.TATAUSAHA_HUTANG_MP + "/get-header-pembayaran/" + id );
        model.put("linkDetailPembayaranHutang", servletContext.getContextPath() + PathPrefix.API + PathPrefix.TATAUSAHA_HUTANG_MP + "/detail-pembayaran-mp/" + id );
        return "pembayaran/entry-pembayaran-hutang";
    }

    @GetMapping("/detail-pembayaran-pembinaan/{id}")
    public String entryPembayaranHutangPembinaan(Map<String,Object>model, @PathVariable(name = "id") Long id){
        List<BreadcrumbHolderComponentDto> breadcrumb = new ArrayList<>();
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PEMBAYARAN,"Pembayaran"));
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PEMBAYARAN+PathPrefix.TATAUSAHA_HUTANG_MP," Tata Usaha Hutang (Uang Pembinaan dan Manfaat Pensiun)"));
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PEMBAYARAN+PathPrefix.TATAUSAHA_HUTANG_MP +"/entry-pembayaran-hutang-pembinaan"," Entry Pembayaran Hutang Uang Pembinaan"));
        model.put("breadcrumb", breadcrumb);
        model.put("linkHeaderPembayaranHutangPembinaan", servletContext.getContextPath() + PathPrefix.API + PathPrefix.TATAUSAHA_HUTANG_MP + "/get-header-pembayaran/" + id );
        model.put("linkDetailPembayaranHutangPembinaan", servletContext.getContextPath() + PathPrefix.API + PathPrefix.TATAUSAHA_HUTANG_MP + "/detail-pembayaran-pembinaan/" + id );
        return "pembayaran/entry-pembayaran-hutang-pembinaan";
    }

    @GetMapping("/entry-mutasi-hutang-uang-pembinaan")
    public String entryHutangPembinaan(Map<String,Object>model){
        List<BreadcrumbHolderComponentDto> breadcrumb = new ArrayList<>();
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PEMBAYARAN,"Pembayaran"));
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PEMBAYARAN+PathPrefix.TATAUSAHA_HUTANG_MP," Tata Usaha Hutang (Uang Pembinaan dan Manfaat Pensiun)"));
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PEMBAYARAN+PathPrefix.TATAUSAHA_HUTANG_MP +"/entry-mutasi-hutang-uang-pembinaan","Entry Hutang Uang Pembinaan"));
        model.put("breadcrumb", breadcrumb);
        return "pembayaran/entry-mutasi-hutang-pembinaan";
    }

    @GetMapping("/entry-pembayaran-hutang-uang-pembinaan")
    public String entryPembayaranHutangPembinaan(Map<String,Object>model){
        List<BreadcrumbHolderComponentDto> breadcrumb = new ArrayList<>();
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PEMBAYARAN,"Pembayaran"));
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PEMBAYARAN+PathPrefix.TATAUSAHA_HUTANG_MP," Tata Usaha Hutang (Uang Pembinaan dan Manfaat Pensiun)"));
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PEMBAYARAN+PathPrefix.TATAUSAHA_HUTANG_MP +"/entry-pembayaran-hutang-uang-pembinaan"," Entry Pembayaran Hutang Uang Pembinaan"));
        model.put("breadcrumb", breadcrumb);
        return "pembayaran/entry-mutasi-hutang-pembinaan";
    }

}
