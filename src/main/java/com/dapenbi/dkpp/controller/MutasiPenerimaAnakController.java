package com.dapenbi.dkpp.controller;


import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.MPensiunDao;
import com.dapenbi.dkpp.dao.SetupParameterDao;
import com.dapenbi.dkpp.dto.DkppUserDetail;
import com.dapenbi.dkpp.dto.MPensiunDto;
import com.dapenbi.dkpp.dto.RoleDto;
import com.dapenbi.dkpp.dto.component.BreadcrumbHolderComponentDto;
import com.dapenbi.dkpp.model.MPensiun;
import com.dapenbi.dkpp.model.SetupParameter;
import com.dapenbi.dkpp.util.DkppUserStamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(PathPrefix.PENSIUN_LAMA + PathPrefix.MUTASI_PENERIMA_ANAK)
public class MutasiPenerimaAnakController extends MasterDataController{

    private MPensiunDao mPensiunDao;
    private SetupParameterDao setupParameterDao;
    private ServletContext servletContext;

    @Autowired
    public MutasiPenerimaAnakController(MPensiunDao mPensiunDao, SetupParameterDao setupParameterDao, ServletContext servletContext){
        this.mPensiunDao = mPensiunDao;
        this.setupParameterDao = setupParameterDao;
        this.servletContext = servletContext;
    }

    @GetMapping
    public String index(Map<String,Object> model){

        List<BreadcrumbHolderComponentDto> breadcrumb = new ArrayList<>();
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PENSIUN_LAMA, "Pensiun Lama"));
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PENSIUN_LAMA + PathPrefix.MUTASI_PENERIMA_ANAK, "Mutasi Otomatis Penerima MP anak 25 Tahun dan MP Bulan Ke-13"));
        DkppUserDetail user = DkppUserStamp.getUserPrincipal();
        RoleDto role = user.getUser().getRoles().get(0);

        model.put("isPejabat", role.getName().equals("Pejabat")?true:false );
        model.put("isStaff", role.getName().equals("Staff")?true:false );
        model.put("isAdmin", role.getName().equals("Admin")?true:false );
        model.put("periode", this.getActivePeriod());
        model.put("breadcrumb", breadcrumb);
        model.put("apiLink", PathPrefix.API + PathPrefix.MUTASI_PENERIMA_ANAK);
        model.put("report_path_api", PathPrefix.API + PathPrefix.MUTASI_PENERIMA_ANAK + "/report");
        model.put("listPeriodeSetupParameter", PathPrefix.API + PathPrefix.SETUPPARAMETER + "/get_periode");
        model.put("listKategoriCatatanCombo", PathPrefix.API + PathPrefix.KATEGORICATATAN + PathPrefix.DROPDOWN);

        return "pensiunLama/mutasi-penerima-anak";
    }

    private String getActivePeriod(){
        SetupParameter setupParameter = setupParameterDao.findByBukaPeriode();
        return setupParameter.getPeriode();
    }


}
