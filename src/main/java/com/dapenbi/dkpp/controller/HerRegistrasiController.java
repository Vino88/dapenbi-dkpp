package com.dapenbi.dkpp.controller;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.HerRegistrasiDao;
import com.dapenbi.dkpp.dao.KategoriCatatanDao;
import com.dapenbi.dkpp.dao.MenuDao;
import com.dapenbi.dkpp.dao.SetupParameterDao;
import com.dapenbi.dkpp.dto.DkppUserDetail;
import com.dapenbi.dkpp.dto.RoleDto;
import com.dapenbi.dkpp.dto.component.BreadcrumbHolderComponentDto;
import com.dapenbi.dkpp.form.HerRegistrasiFormDto;
import com.dapenbi.dkpp.model.KategoriCatatan;
import com.dapenbi.dkpp.util.DkppUserStamp;
import com.dapenbi.dkpp.util.MenuUtil;
import com.dapenbi.dkpp.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(PathPrefix.HERREGISTRASI)
public class HerRegistrasiController {

    @Autowired
    private MenuDao menuDao;

    @Autowired
    private MenuUtil menuUtil;
    
    @Autowired
    private SetupParameterDao setupParameterDao;

    @Autowired
    private HerRegistrasiDao herRegistrasiDao;

    @Autowired
    private KategoriCatatanDao kategoriCatatanDao;

    @GetMapping
    public String index(Map<String, Object> model) {
        model.put("menuDetail", menuUtil.getList(SecurityContextHolder.getContext(), menuDao, PathPrefix.HERREGISTRASI + "/"));
        model.put("menuTitle","Her Registrasi");
        return "detailMenu";
    }
    
    @GetMapping("/registrasi-ulang-pensiun")
    public String registrasiUlangPensiun(Map<String, Object> model) {
        Integer year = Year.now().getValue();
    	List<BreadcrumbHolderComponentDto> breadcrumb = new ArrayList<>();
    	breadcrumb.add(new BreadcrumbHolderComponentDto("/pensiun-baru", "Pensiun Baru"));
    	breadcrumb.add(new BreadcrumbHolderComponentDto("/her-registrasi", " Registrasi Ulang Pensiunan"));
    	model.put("her_path_api", PathPrefix.API + PathPrefix.HERREGISTRASI);
        model.put("her_header_path_api", PathPrefix.API + PathPrefix.HERREGISTRASI + "/registrasi-ulang-pensiun");
        model.put("her_detail_path_api", PathPrefix.API + PathPrefix.HERREGISTRASI + "/detail" + "/" + String.valueOf(year));
        model.put("report_her_path", PathPrefix.API + PathPrefix.HERREGISTRASI+ "/report-her");
        List<KategoriCatatan> kcList = kategoriCatatanDao.findByKategoriMutasi("30");
        model.put("kcList", kcList);
        model.put("breadcrumb", breadcrumb);
		return "herRegistrasi/registrasi-ulang-pensiun";
    }

}
