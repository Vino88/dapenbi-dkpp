package com.dapenbi.dkpp.controller;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.KategoriCatatanDao;
import com.dapenbi.dkpp.dao.MutasiPensiunDao;
import com.dapenbi.dkpp.dao.SetupParameterDao;
import com.dapenbi.dkpp.dto.RoleDto;
import com.dapenbi.dkpp.dto.component.BreadcrumbHolderComponentDto;
import com.dapenbi.dkpp.util.DkppUserStamp;
import com.dapenbi.dkpp.util.SelectValueUtil;
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
@RequestMapping(PathPrefix.VALIDASI_MUTASI_PENSIUN)
public class ValidasiMutasiPensiunController {

    private MutasiPensiunDao mutasiPensiunDao;

    private SetupParameterDao setupParameterDao;

    private KategoriCatatanDao kategoriCatatanDao;

    private ServletContext servletContext;

    @Autowired
    public ValidasiMutasiPensiunController(MutasiPensiunDao mutasiPensiunDao, SetupParameterDao setupParameterDao, KategoriCatatanDao kategoriCatatanDao, ServletContext servletContext) {
        this.mutasiPensiunDao = mutasiPensiunDao;
        this.setupParameterDao = setupParameterDao;
        this.kategoriCatatanDao = kategoriCatatanDao;
        this.servletContext = servletContext;
    }

    @GetMapping
    public String index(Map<String, Object> model) {
        List<BreadcrumbHolderComponentDto> breadcrumb = new ArrayList<>();
        String isStaf = "";
        RoleDto roleDto = DkppUserStamp.getUserRoles();
        if (roleDto.getId() == 43){
            isStaf = roleDto.getId().toString();
            model.put("role",isStaf);
        }
        model.put("is_staff", roleDto.getName().toUpperCase().equals("STAFF")? true : false);
        model.put("is_pejabat", roleDto.getName().toUpperCase().equals("PEJABAT")? true : false);
        //model.put("periodeMutasi", setupParameterDao.findByBukaPeriode().getPeriode());
        model.put("mutasi_path_api", PathPrefix.API + PathPrefix.VALIDASI_MUTASI_PENSIUN);
        model.put("entry_mutasi_path", PathPrefix.PENSIUN_LAMA + PathPrefix.MUTASI_PENERIMA_MP_JANDA_DUDA_MENIKAH_KEMBALI + "/${idMutasiPensiun}/${nip}/entry");
        model.put("new_mutasi_path", PathPrefix.PENSIUN_LAMA + PathPrefix.MUTASI_PENERIMA_MP_JANDA_DUDA_MENIKAH_KEMBALI + "/entry");
        model.put("report_janda_duda", PathPrefix.API + PathPrefix.MUTASI_PENERIMA_MP_JANDA_DUDA_MENIKAH_KEMBALI + "/report");
        model.put("periodeMutasi", setupParameterDao.findByBukaPeriode().getPeriode());
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.VALIDASI_MUTASI_PENSIUN, "Validasi Mutasi Pensiun"));
        model.put("breadcrumb", breadcrumb);
        return "validasiMutasi/validasi-mutasi-pensiun";
    }


}
