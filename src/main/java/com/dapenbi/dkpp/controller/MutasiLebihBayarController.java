package com.dapenbi.dkpp.controller;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.KategoriCatatanDao;
import com.dapenbi.dkpp.dao.SetupParameterDao;
import com.dapenbi.dkpp.dto.RoleDto;
import com.dapenbi.dkpp.dto.component.BreadcrumbHolderComponentDto;
import com.dapenbi.dkpp.model.KategoriCatatan;
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
@RequestMapping(PathPrefix.MUTASI_LEBIH_BAYAR)
public class MutasiLebihBayarController {
    private SetupParameterDao setupParameterDao;
    private ServletContext servletContext;
    private KategoriCatatanDao kategoriCatatanDao;


    @Autowired
    public MutasiLebihBayarController(SetupParameterDao setupParameterDao,KategoriCatatanDao kategoriCatatanDao, ServletContext servletContext) {
        this.setupParameterDao = setupParameterDao;
        this.servletContext = servletContext;
        this.kategoriCatatanDao = kategoriCatatanDao;
    }

    @GetMapping
    public String index(Map<String, Object> model) {
        List<BreadcrumbHolderComponentDto> breadcrumb = getBreadcrumbHolderComponentDtos();
        model.put("periodeMutasi", setupParameterDao.findByBukaPeriode().getPeriode());
        model.put("breadcrumb", breadcrumb);
        String isStaf = "";
        RoleDto roleDto = DkppUserStamp.getUserRoles();
        if (roleDto.getId() == 43){
            isStaf = roleDto.getId().toString();
            model.put("isStaf",isStaf);
        }
        List<KategoriCatatan> kcList = kategoriCatatanDao.getListKategoriCatatanLebihBayar();
        model.put("kcList", kcList);

        return "mutasiLebihBayar/mutasi-lebih-bayar";
    }

    public List<BreadcrumbHolderComponentDto> getBreadcrumbHolderComponentDtos() {
        List<BreadcrumbHolderComponentDto> breadcrumb = new ArrayList<>();
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.MUTASI_LEBIH_BAYAR, "Mutasi Lebih Bayar"));
        return breadcrumb;
    }
}
