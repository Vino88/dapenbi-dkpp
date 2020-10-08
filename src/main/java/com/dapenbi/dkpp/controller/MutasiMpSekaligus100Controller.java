package com.dapenbi.dkpp.controller;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.AlasanMps100Dao;
import com.dapenbi.dkpp.dao.KategoriCatatanDao;
import com.dapenbi.dkpp.dao.MutasiPensiunDao;
import com.dapenbi.dkpp.dao.SetupParameterDao;
import com.dapenbi.dkpp.dto.DkppUserDetail;
import com.dapenbi.dkpp.dto.RoleDto;
import com.dapenbi.dkpp.dto.component.BreadcrumbHolderComponentDto;
import com.dapenbi.dkpp.model.AlasanMps100;
import com.dapenbi.dkpp.model.KategoriCatatan;
import com.dapenbi.dkpp.util.DkppUserStamp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(PathPrefix.PENSIUN_LAMA + PathPrefix.MUTASI_MANFAAT_PENSIUN_100)
public class MutasiMpSekaligus100Controller  {

    private MutasiPensiunDao mutasiPensiunDao;

    private SetupParameterDao setupParameterDao;

    private KategoriCatatanDao kategoriCatatanDao;

    private AlasanMps100Dao alasanMps100Dao;

    private ServletContext servletContext;


    public MutasiMpSekaligus100Controller(MutasiPensiunDao mutasiPensiunDao, SetupParameterDao setupParameterDao, KategoriCatatanDao kategoriCatatanDao, AlasanMps100Dao alasanMps100Dao, ServletContext servletContext) {
        this.mutasiPensiunDao = mutasiPensiunDao;
        this.setupParameterDao = setupParameterDao;
        this.kategoriCatatanDao = kategoriCatatanDao;
        this.alasanMps100Dao = alasanMps100Dao;
        this.servletContext = servletContext;
    }

    @GetMapping
    public String index(Map<String,Object> model){
        model.put("breadcrumb", getBreadcrumbHolderComponentDtos());
        DkppUserDetail user = DkppUserStamp.getUserPrincipal();
        RoleDto role = user.getUser().getRoles().get(0);

        model.put("isPejabat", role.getName().equals("Pejabat")?true:false );
        model.put("isStaff", role.getName().equals("Staff")?true:false );
        model.put("isAdmin", role.getName().equals("Admin")?true:false );
        List<KategoriCatatan> kcList = kategoriCatatanDao.getListKategoriCatatanMutasiMpSekaligus();
        model.put("kcList", kcList);
        List<AlasanMps100> amp100 = alasanMps100Dao.getListAlasanMps100MutasiMpSekaligus();
        model.put("amp100",amp100);
        model.put("periodeMutasi", setupParameterDao.findByBukaPeriode().getPeriode());
        model.put("mutasi_mp_100_api", PathPrefix.API + PathPrefix.MUTASI_MANFAAT_PENSIUN_100);
        model.put("listPesertaCombo", PathPrefix.API + PathPrefix.MPENSIUN + PathPrefix.DROPDOWN);
        model.put("listKategoriCatatan", PathPrefix.API + PathPrefix.KATEGORICATATAN + PathPrefix.DROPDOWN);
        model.put("report_path_api", PathPrefix.API + PathPrefix.MUTASI_MANFAAT_PENSIUN_100 + "/report");

        return "pensiunLama/mutasi-manfaat-pensiun-sekaligus-100";
    }

    private List<BreadcrumbHolderComponentDto> getBreadcrumbHolderComponentDtos() {
        List<BreadcrumbHolderComponentDto> breadcrumb = new ArrayList<>();
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PENSIUN_LAMA, "Pensiun Lama"));
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PENSIUN_LAMA + PathPrefix.MUTASI_MANFAAT_PENSIUN_100, "Mutasi Manfaat Pensiun Sekaligus 100%"));
        return breadcrumb;
    }

}
