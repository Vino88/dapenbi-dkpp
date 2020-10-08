package com.dapenbi.dkpp.controller;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.*;
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
@RequestMapping(PathPrefix.PENSIUN_BARU + PathPrefix.MUTASI_PENSIUN_BARU)
public class MutasiPensiunBaruController extends MutasiPensiunBaseController {

    @Autowired
    public MutasiPensiunBaruController(
            ServletContext servletContext,
            SetupParameterDao setupParameterDao,
            JenisMpsDao jenisMpsDao,
            PesertaDao pesertaDao,
            KeluargaPesertaDao keluargaPesertaDao,
            MutasiPensiunDao mutasiPensiunDao,
            StatusBayarDao statusBayarDao,
            StatusValidasiDao statusValidasiDao,
            MPensiunDao pensiunDao
    ) {
        this.servletContext = servletContext;
        this.setupParameterDao = setupParameterDao;
        this.jenisMpsDao = jenisMpsDao;
        this.pesertaDao = pesertaDao;
        this.keluargaPesertaDao = keluargaPesertaDao;
        this.mutasiPensiunDao = mutasiPensiunDao;
        this.statusBayarDao = statusBayarDao;
        this.statusValidasiDao = statusValidasiDao;
        this.pensiunDao = pensiunDao;
    }

    @GetMapping
    public String index(Map<String, Object> model) {
        model.put("breadcrumb", getBreadcrumbHolderComponentDtos());
        model.put("peserta_path_api", PathPrefix.API + PathPrefix.MUTASI_PENSIUN_BARU + "/peserta");
        model.put("mutasi_path_api", PathPrefix.API + PathPrefix.MUTASI_PENSIUN_BARU + "/mutasi");
        model.put("report_path_api", PathPrefix.API+ PathPrefix.MUTASI_PENSIUN_BARU+ "/report");
        model.put("entry_mutasi_path", PathPrefix.PENSIUN_BARU + PathPrefix.MUTASI_PENSIUN_BARU + "/${nip}/entry");
        model.put("periodeMutasi", setupParameterDao.findByBukaPeriode().toDto().getPeriode());
        model.put("listPeriodeSetupParameter", PathPrefix.API + PathPrefix.SETUPPARAMETER + "/get_periode");
        model.put("isStaff", DkppUserStamp.isStaff());
        model.put("isPejabat", DkppUserStamp.isPejabat());
        return "pensiunBaru/mutasi-pensiun-baru";
    }

    private List<BreadcrumbHolderComponentDto> getBreadcrumbHolderComponentDtos() {
        List<BreadcrumbHolderComponentDto> breadcrumb = new ArrayList<>();
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PENSIUN_BARU, "Pensiun Baru"));
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PENSIUN_BARU + PathPrefix.MUTASI_PENSIUN_BARU, "Mutasi Pensiun Baru"));
        return breadcrumb;
    }

    @Override
    protected List<BreadcrumbHolderComponentDto> getBreadcrumbHolderComponentDtos(String nip) {
        List<BreadcrumbHolderComponentDto> breadcrumb = this.getBreadcrumbHolderComponentDtos();
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PENSIUN_BARU + PathPrefix.MUTASI_PENSIUN_TUNDA + "/" + nip + "/entry", nip));
        return breadcrumb;
    }

    @Override
    protected String errorRedirect() {
        return PathPrefix.PENSIUN_BARU + PathPrefix.MUTASI_PENSIUN_BARU;
    }

    @Override
    String getIndexPath() {
        return PathPrefix.PENSIUN_BARU + PathPrefix.MUTASI_PENSIUN_BARU;
    }

    @Override
    String getApiPath() {
        return PathPrefix.API + PathPrefix.MUTASI_PENSIUN_BARU;
    }
}
