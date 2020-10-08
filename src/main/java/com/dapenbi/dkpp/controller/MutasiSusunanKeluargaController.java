package com.dapenbi.dkpp.controller;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.*;
import com.dapenbi.dkpp.dto.*;
import com.dapenbi.dkpp.dto.component.BreadcrumbHolderComponentDto;
import com.dapenbi.dkpp.model.MutasiPensiun;
import com.dapenbi.dkpp.util.DkppUserStamp;
import com.dapenbi.dkpp.util.SelectValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(PathPrefix.PENSIUN_LAMA + PathPrefix.MUTASI_SUSUNAN_KELUARGA)
public class MutasiSusunanKeluargaController {

    private MutasiPensiunDao mutasiPensiunDao;

    private SetupParameterDao setupParameterDao;

    private KategoriCatatanDao kategoriCatatanDao;

    private AgamaDao agamaDao;

    ServletContext servletContext;

    private KelurahanDao kelurahanDao;
    private KecamatanDao kecamatanDao;
    private KotaDao kotaDao;
    private ProvinsiDao provinsiDao;

    @Autowired
    public MutasiSusunanKeluargaController(MutasiPensiunDao mutasiPensiunDao,
                                           SetupParameterDao setupParameterDao,
                                           KategoriCatatanDao kategoriCatatanDao,
                                           ServletContext servletContext,
                                           AgamaDao agamaDao,
                                           KelurahanDao kelurahanDao,
                                           KecamatanDao kecamatanDao,
                                           KotaDao kotaDao,
                                           ProvinsiDao provinsiDao) {
        this.mutasiPensiunDao = mutasiPensiunDao;
        this.setupParameterDao = setupParameterDao;
        this.kategoriCatatanDao = kategoriCatatanDao;
        this.servletContext = servletContext;
        this.agamaDao = agamaDao;
        this.kelurahanDao = kelurahanDao;
        this.kecamatanDao = kecamatanDao;
        this.kotaDao = kotaDao;
        this.provinsiDao = provinsiDao;
    }

    @GetMapping
    public String index(Map<String, Object> model) {
        List<BreadcrumbHolderComponentDto> breadcrumb = new ArrayList<>();
        String isStaf = "";
        String notStaf ="";
        RoleDto roleDto = DkppUserStamp.getUserRoles();
        if (roleDto.getId() == 43){
            isStaf = roleDto.getId().toString();
            model.put("role",isStaf);
        }
        if (roleDto.getId() != 43){
            notStaf = roleDto.getId().toString();
            model.put("notrole",notStaf);
        }

        DkppUserDetail user = DkppUserStamp.getUserPrincipal();
        RoleDto role = user.getUser().getRoles().get(0);

        model.put("isPejabat", role.getName().equals("Pejabat")?true:false );
        model.put("isStaff", role.getName().equals("Staff")?true:false );
        model.put("isAdmin", role.getName().equals("Admin")?true:false );

        model.put("periodeMutasi", setupParameterDao.findByBukaPeriode().getPeriode());
        model.put("mutasi_path_api", PathPrefix.API + PathPrefix.MUTASI_SUSUNAN_KELUARGA);
        model.put("listPesertaCombo", PathPrefix.API + PathPrefix.MPENSIUN + PathPrefix.DATA+ PathPrefix.MPENSIUN);
        model.put("listKategoriCatatan", PathPrefix.API + PathPrefix.KATEGORICATATAN + PathPrefix.DROPDOWN);
        model.put("gender", SelectValueUtil.createGenderSelect());
        model.put("kategoriPenerimaPathApi", PathPrefix.API + PathPrefix.KATEGORI_PENERIMA);
        model.put("statusKawinPathApi", PathPrefix.API + PathPrefix.STATUS_KAWIN);
        model.put("report_path_api", PathPrefix.API + PathPrefix.MUTASI_SUSUNAN_KELUARGA + "/report");
//        model.put("entry_mutasi_path", PathPrefix.PENSIUN_LAMA + PathPrefix.MUTASI_SUSUNAN_KELUARGA + "/entry");
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() +  PathPrefix.PENSIUN_LAMA, "Pensiun Lama"));
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() +  PathPrefix.PENSIUN_LAMA+PathPrefix.MUTASI_SUSUNAN_KELUARGA, "Mutasi Susunan Keluarga"));
        model.put("breadcrumb", breadcrumb);


        return "pensiunLama/mutasi-susunan-keluarga";
    }

}
