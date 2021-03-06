package com.dapenbi.dkpp.controller;


import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.SetupParameterDao;
import com.dapenbi.dkpp.dto.DkppUserDetail;
import com.dapenbi.dkpp.dto.RoleDto;
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
@RequestMapping(PathPrefix.PENSIUN_LAMA + PathPrefix.MUTASI_PERUBAHAN_NAMA_PENERIMA_MP)
public class MutasiPerubahanNamaPenerimaMpController {
    @Autowired
    ServletContext servletContext;

    @Autowired
    SetupParameterDao setupParameterDao;

    @GetMapping
    public String index(Map<String, Object> model){
        List<BreadcrumbHolderComponentDto> breadcrumb = new ArrayList<>();
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PENSIUN_LAMA, "Pensiun Lama"));
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PENSIUN_LAMA + PathPrefix.MUTASI_PERUBAHAN_NAMA_PENERIMA_MP, "Mutasi Perubahan Nama Penerima MP"));
        DkppUserDetail user = DkppUserStamp.getUserPrincipal();
        RoleDto role = user.getUser().getRoles().get(0);

        model.put("isPejabat", role.getName().equals("Pejabat")?true:false );
        model.put("isStaff", role.getName().equals("Staff")?true:false );
        model.put("isAdmin", role.getName().equals("Admin")?true:false );
        model.put("breadcrumb", breadcrumb);
        model.put("periodeMutasi",setupParameterDao.findByBukaPeriode().getPeriode());
        model.put("listPesertaCombo", PathPrefix.API + PathPrefix.MPENSIUN + PathPrefix.DROPDOWN);
        model.put("listKategoriCatatan", PathPrefix.API + PathPrefix.KATEGORICATATAN + PathPrefix.DROPDOWN);
        model.put("listPenerimaMpCombo", PathPrefix.API + PathPrefix.PENERIMA + PathPrefix.DROPDOWN);
        model.put("report_path_api", PathPrefix.API + PathPrefix.MUTASI_PERUBAHAN_NAMA_PENERIMA_MP + "/report");
        return "pensiunLama/mutasiperubahannamapenerimamp";
    }
}
