package com.dapenbi.dkpp.controller;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.config.DkppConfig;
import com.dapenbi.dkpp.dao.KategoriCatatanDao;
import com.dapenbi.dkpp.dao.MutasiPensiunDao;
import com.dapenbi.dkpp.dao.SetupParameterDao;
import com.dapenbi.dkpp.dto.DkppUserDetail;
import com.dapenbi.dkpp.dto.KategoriMutasiDto;
import com.dapenbi.dkpp.dto.RoleDto;
import com.dapenbi.dkpp.dto.component.BreadcrumbHolderComponentDto;
import com.dapenbi.dkpp.dto.component.JenisKelaminEnum;
import com.dapenbi.dkpp.util.DkppUserStamp;
import com.dapenbi.dkpp.util.SelectValueUtil;
import com.dapenbi.dkpp.util.StringUtil;
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
@RequestMapping(PathPrefix.PENSIUN_LAMA + PathPrefix.MUTASI_PENERIMA_MP_JANDA_DUDA_MENIKAH_KEMBALI)
public class MutasiPenerimaMPJandaDudaMenikahKembaliController {

    private MutasiPensiunDao mutasiPensiunDao;

    private SetupParameterDao setupParameterDao;

    private KategoriCatatanDao kategoriCatatanDao;

    private ServletContext servletContext;

    private KategoriMutasiDto kategoriMutasiDto;

    @Autowired
    public MutasiPenerimaMPJandaDudaMenikahKembaliController(MutasiPensiunDao mutasiPensiunDao, SetupParameterDao setupParameterDao, KategoriCatatanDao kategoriCatatanDao, ServletContext servletContext) {
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
        model.put("mutasi_path_api", PathPrefix.API + PathPrefix.MUTASI_PENERIMA_MP_JANDA_DUDA_MENIKAH_KEMBALI);
        model.put("entry_mutasi_path", PathPrefix.PENSIUN_LAMA + PathPrefix.MUTASI_PENERIMA_MP_JANDA_DUDA_MENIKAH_KEMBALI + "/${idMutasiPensiun}/${nip}/entry");
        model.put("new_mutasi_path", PathPrefix.PENSIUN_LAMA + PathPrefix.MUTASI_PENERIMA_MP_JANDA_DUDA_MENIKAH_KEMBALI + "/entry");
        model.put("report_janda_duda", PathPrefix.API + PathPrefix.MUTASI_PENERIMA_MP_JANDA_DUDA_MENIKAH_KEMBALI + "/report");
        model.put("periodeMutasi", setupParameterDao.findByBukaPeriode().getPeriode());
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PENSIUN_LAMA, "Pensiun Lama"));
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PENSIUN_LAMA+PathPrefix.MUTASI_PENERIMA_MP_JANDA_DUDA_MENIKAH_KEMBALI, "Mutasi Penerima MP Janda/Duda Menikah Kembali"));
        model.put("breadcrumb", breadcrumb);
        return "pensiunLama/mutasi-penerima-mp-janda-duda-menikah-kembali";
    }

    @GetMapping("/{idMutasiPensiun}/{nip}/entry")
    public String entry(Map<String, Object> model, @PathVariable Long idMutasiPensiun, @PathVariable String nip) {
        List<BreadcrumbHolderComponentDto> breadcrumb = new ArrayList<>();
        RoleDto roleDto = DkppUserStamp.getUserRoles();
        model.put("is_staff", roleDto.getName().toUpperCase().equals("STAFF")? true : false);
        model.put("is_pejabat", roleDto.getName().toUpperCase().equals("PEJABAT")? true : false);
        model.put("periodeMutasi", setupParameterDao.findByBukaPeriode().getPeriode());
        model.put("idMutasiPensiun", idMutasiPensiun);
        model.put("nip", nip);
        model.put("gender", SelectValueUtil.createGenderSelect());
        model.put("listProvinsiCombo", PathPrefix.API + PathPrefix.PROVINSI + PathPrefix.DROPDOWN);
        model.put("listKotaCombo", PathPrefix.API + PathPrefix.KOTA + PathPrefix.DROPDOWN);
        model.put("listKecamatanCombo", PathPrefix.API + PathPrefix.KECAMATAN + PathPrefix.DROPDOWN);
        model.put("listKelurahanCombo", PathPrefix.API + PathPrefix.KELURAHAN + PathPrefix.DROPDOWN);
        model.put("detailAlamat", PathPrefix.API + PathPrefix.MUTASI_PENERIMA_MP_JANDA_DUDA_MENIKAH_KEMBALI + "/detail_alamat");
        model.put("linkCufnMiSimulation", PathPrefix.API + PathPrefix.MUTASI_PENERIMA_MP_JANDA_DUDA_MENIKAH_KEMBALI + "/cufn-mi-simulation" );
        model.put("kategoriPenerimaPathApi", PathPrefix.API + PathPrefix.KATEGORI_PENERIMA);
        model.put("statusKawinPathApi", PathPrefix.API + PathPrefix.STATUS_KAWIN);
        model.put("listKategoriCatatanCombo", PathPrefix.API + PathPrefix.KATEGORICATATAN + PathPrefix.DROPDOWN);
        model.put("listAgamaCombo", PathPrefix.API + PathPrefix.AGAMA + PathPrefix.DROPDOWN);
        model.put("listGolonganCombo", PathPrefix.API + PathPrefix.GOLONGAN + PathPrefix.DROPDOWN);
        model.put("listNegaraCombo", PathPrefix.API + PathPrefix.NEGARA + PathPrefix.DROPDOWN);
        model.put("cufnMenikahSimulation", PathPrefix.API + PathPrefix.MUTASI_PENERIMA_MP_JANDA_DUDA_MENIKAH_KEMBALI + "/cufn-menikah-simulation");
        model.put("cekSuskel", PathPrefix.API + PathPrefix.MUTASI_PENERIMA_MP_JANDA_DUDA_MENIKAH_KEMBALI + "/cek-suskel");
        model.put("listPeriodeSetupParameter", PathPrefix.API + PathPrefix.SETUPPARAMETER + "/get_periode");
        model.put("gridPath", servletContext.getContextPath() + PathPrefix.PENSIUN_LAMA+PathPrefix.MUTASI_PENERIMA_MP_JANDA_DUDA_MENIKAH_KEMBALI);
        model.put("kategoriMutasi", StringUtil.objToJson(kategoriMutasiDto));
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PENSIUN_LAMA, "Pensiun Lama"));
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PENSIUN_LAMA+PathPrefix.MUTASI_PENERIMA_MP_JANDA_DUDA_MENIKAH_KEMBALI, "Mutasi Penerima MP Janda/Duda Menikah Kembali"));
        model.put("breadcrumb", breadcrumb);

        return "pensiunLama/entry-penerima-mp-janda-duda-menikah-kembali";
    }

    @GetMapping("/entry")
    public String newEntry(Map<String, Object> model) {
        List<BreadcrumbHolderComponentDto> breadcrumb = new ArrayList<>();
        RoleDto roleDto = DkppUserStamp.getUserRoles();
        model.put("is_staff", roleDto.getName().toUpperCase().equals("STAFF")? true : false);
        model.put("is_pejabat", roleDto.getName().toUpperCase().equals("PEJABAT")? true : false);
        model.put("listPesertaCombo", PathPrefix.API +PathPrefix.MPENSIUN + PathPrefix.DATA + PathPrefix.MPENSIUN + "/janda-duda");
        model.put("periodeMutasi", setupParameterDao.findByBukaPeriode().getPeriode());
        model.put("gender", SelectValueUtil.createGenderSelect());
        model.put("listProvinsiCombo", PathPrefix.API + PathPrefix.PROVINSI + PathPrefix.DROPDOWN);
        model.put("listKotaCombo", PathPrefix.API + PathPrefix.KOTA + PathPrefix.DROPDOWN);
        model.put("listKecamatanCombo", PathPrefix.API + PathPrefix.KECAMATAN + PathPrefix.DROPDOWN);
        model.put("listKelurahanCombo", PathPrefix.API + PathPrefix.KELURAHAN + PathPrefix.DROPDOWN);
        model.put("detailAlamat", PathPrefix.API + PathPrefix.MUTASI_PENERIMA_MP_JANDA_DUDA_MENIKAH_KEMBALI + "/detail_alamat");
        model.put("linkCufnMiSimulation", PathPrefix.API + PathPrefix.MUTASI_PENERIMA_MP_JANDA_DUDA_MENIKAH_KEMBALI + "/cufn-mi-simulation" );
        model.put("kategoriPenerimaPathApi", PathPrefix.API + PathPrefix.KATEGORI_PENERIMA);
        model.put("statusKawinPathApi", PathPrefix.API + PathPrefix.STATUS_KAWIN);
        model.put("listKategoriCatatanCombo", PathPrefix.API + PathPrefix.KATEGORICATATAN + PathPrefix.DROPDOWN);
        model.put("listAgamaCombo", PathPrefix.API + PathPrefix.AGAMA + PathPrefix.DROPDOWN);
        model.put("listGolonganCombo", PathPrefix.API + PathPrefix.GOLONGAN + PathPrefix.DROPDOWN);
        model.put("listNegaraCombo", PathPrefix.API + PathPrefix.NEGARA + PathPrefix.DROPDOWN);
        model.put("cufnMenikahSimulation", PathPrefix.API + PathPrefix.MUTASI_PENERIMA_MP_JANDA_DUDA_MENIKAH_KEMBALI + "/cufn-menikah-simulation");
        model.put("cekSuskel", PathPrefix.API + PathPrefix.MUTASI_PENERIMA_MP_JANDA_DUDA_MENIKAH_KEMBALI + "/cek-suskel");
        model.put("listPeriodeSetupParameter", PathPrefix.API + PathPrefix.SETUPPARAMETER + "/get_periode");
        model.put("kategoriMutasi", StringUtil.objToJson(kategoriMutasiDto));
        model.put("gridPath", servletContext.getContextPath() + PathPrefix.PENSIUN_LAMA+PathPrefix.MUTASI_PENERIMA_MP_JANDA_DUDA_MENIKAH_KEMBALI);
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PENSIUN_LAMA, "Pensiun Lama"));
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PENSIUN_LAMA+PathPrefix.MUTASI_PENERIMA_MP_JANDA_DUDA_MENIKAH_KEMBALI, "Mutasi Penerima MP Janda/Duda Menikah Kembali"));
        model.put("breadcrumb", breadcrumb);
        return "pensiunLama/entry-penerima-mp-janda-duda-menikah-kembali";
    }
}
