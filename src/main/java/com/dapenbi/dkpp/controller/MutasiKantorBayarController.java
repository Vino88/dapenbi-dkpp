package com.dapenbi.dkpp.controller;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.*;
import com.dapenbi.dkpp.dto.DkppUserDetail;
import com.dapenbi.dkpp.dto.RoleDto;
import com.dapenbi.dkpp.dto.component.BreadcrumbHolderComponentDto;
import com.dapenbi.dkpp.util.DkppUserStamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import java.util.*;

@Controller
@RequestMapping(PathPrefix.PENSIUN_LAMA + PathPrefix.MUTASI_KANTOR_BAYAR)
public class MutasiKantorBayarController extends MasterDataController {

    private ServletContext servletContext;

    private SetupParameterDao setupParameterDao;

    @Autowired
    public MutasiKantorBayarController(
            ServletContext servletContext,
            SetupParameterDao setupParameterDao
    ) {
        this.servletContext = servletContext;
        this.setupParameterDao = setupParameterDao;
    }

    @GetMapping
    public String index(Map<String, Object> model) {
        model.put("breadcrumb", getBreadcrumbHolderComponentDtos());
        model.put("periodeMutasi", setupParameterDao.findByBukaPeriode().getPeriode());
        model.put("mutasi_kantor_bayar_api", PathPrefix.API + PathPrefix.MUTASI_KANTOR_BAYAR );
        DkppUserDetail user = DkppUserStamp.getUserPrincipal();
        RoleDto role = user.getUser().getRoles().get(0);
        model.put("isPejabat", role.getName().equals("Pejabat")?true:false );
        model.put("isStaff", role.getName().equals("Staff")?true:false );
        model.put("isAdmin", role.getName().equals("Admin")?true:false );
        model.put("listPesertaCombo", PathPrefix.API + PathPrefix.MPENSIUN + PathPrefix.DATA + PathPrefix.MPENSIUN);
        model.put("listKantorBayarCombo", PathPrefix.API + PathPrefix.KANTOR_BAYAR + PathPrefix.DROPDOWN);
        model.put("listKategoriCatatanCombo", PathPrefix.API + PathPrefix.KATEGORICATATAN + PathPrefix.DROPDOWN);
        model.put("listPeriodeSetupParameter", PathPrefix.API + PathPrefix.SETUPPARAMETER + "/get_periode");
        model.put("report_path_api", PathPrefix.API + PathPrefix.MUTASI_KANTOR_BAYAR + "/report");

        return "pensiunLama/mutasi-kantor-bayar";
    }

    public List<BreadcrumbHolderComponentDto> getBreadcrumbHolderComponentDtos() {
        List<BreadcrumbHolderComponentDto> breadcrumb = new ArrayList<>();
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PENSIUN_LAMA, "Pensiun Lama"));
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PENSIUN_LAMA + PathPrefix.MUTASI_KANTOR_BAYAR, "Mutasi Kantor Bayar"));
        return breadcrumb;
    }


}
