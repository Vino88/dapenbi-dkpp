package com.dapenbi.dkpp.controller;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.*;
import com.dapenbi.dkpp.dto.component.BreadcrumbHolderComponentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(PathPrefix.PENSIUN_BARU + PathPrefix.MUTASI_PENSIUN_TUNDA)
public class MutasiPensiunTundaController extends MutasiPensiunBaseController {

    @Autowired
    public MutasiPensiunTundaController(
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
        model.put("pensiun_tunda_path_api", PathPrefix.API + PathPrefix.MUTASI_PENSIUN_TUNDA + "/pensiun-tunda");
        model.put("dibayar_path_api", PathPrefix.API + PathPrefix.MUTASI_PENSIUN_TUNDA + "/dibayar");
        model.put("belum_jatuh_tempo_path_api", PathPrefix.API + PathPrefix.MUTASI_PENSIUN_TUNDA + "/belum-jatuh-tempo");
        model.put("entry_mutasi_path", PathPrefix.PENSIUN_BARU + PathPrefix.MUTASI_PENSIUN_TUNDA + "/${nip}/entry");
        model.put("report_path_api", PathPrefix.PENSIUN_BARU + PathPrefix.MUTASI_PENSIUN_TUNDA+ "/report-tunda");
        model.put("periodeMutasi", setupParameterDao.findByBukaPeriode().toDto().getPeriode());
        return "pensiunBaru/mutasi-pensiun-tunda";
    }

    private List<BreadcrumbHolderComponentDto> getBreadcrumbHolderComponentDtos() {
        List<BreadcrumbHolderComponentDto> breadcrumb = new ArrayList<>();
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PENSIUN_BARU, "Pensiun Baru"));
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PENSIUN_BARU + PathPrefix.MUTASI_PENSIUN_TUNDA, "Mutasi Pensiun Tunda"));
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
        return PathPrefix.PENSIUN_BARU + PathPrefix.MUTASI_PENSIUN_TUNDA;
    }

    @Override
    String getIndexPath() {
        return PathPrefix.PENSIUN_BARU + PathPrefix.MUTASI_PENSIUN_TUNDA;
    }

    @Override
    String getApiPath() {
        return PathPrefix.API + PathPrefix.MUTASI_PENSIUN_TUNDA;
    }
}
