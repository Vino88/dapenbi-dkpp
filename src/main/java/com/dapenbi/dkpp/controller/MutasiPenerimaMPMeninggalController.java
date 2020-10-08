package com.dapenbi.dkpp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.dapenbi.dkpp.dao.*;
import com.dapenbi.dkpp.dto.*;
import com.dapenbi.dkpp.dto.component.JenisKelaminEnum;
import com.dapenbi.dkpp.form.MutasiPensiunFormDto;
import com.dapenbi.dkpp.model.Agama;
import com.dapenbi.dkpp.model.KategoriPenerima;
import com.dapenbi.dkpp.util.DateUtil;
import com.dapenbi.dkpp.util.DkppUserStamp;
import com.dapenbi.dkpp.util.SelectValueUtil;
import com.dapenbi.dkpp.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dto.component.BreadcrumbHolderComponentDto;
import com.dapenbi.dkpp.model.KategoriCatatan;
import com.dapenbi.dkpp.model.MutasiPensiun;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletContext;

@Controller
@RequestMapping(PathPrefix.PENSIUN_LAMA + PathPrefix.MUTASI_PENERIMA_MP_MENINGGAL_DUNIA)
public class MutasiPenerimaMPMeninggalController {

    private MutasiPensiunDao mutasiPensiunDao;

    private SetupParameterDao setupParameterDao;

    private KategoriCatatanDao kategoriCatatanDao;

    private AgamaDao agamaDao;

    KategoriMutasiDto kategoriMutasiDto;
    ServletContext servletContext;

    private KelurahanDao kelurahanDao;
    private KecamatanDao kecamatanDao;
    private KotaDao kotaDao;
    private ProvinsiDao provinsiDao;

    @Autowired
    public MutasiPenerimaMPMeninggalController(MutasiPensiunDao mutasiPensiunDao,
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
        RoleDto roleDto = DkppUserStamp.getUserRoles();
        if (roleDto.getId() == 43){
            isStaf = roleDto.getId().toString();
            model.put("isStaf",isStaf);
        }
        model.put("periodeMutasi", setupParameterDao.findByBukaPeriode().getPeriode());
        model.put("mutasi_path_api", PathPrefix.API + PathPrefix.MUTASI_PENERIMA_MP_MENINGGAL_DUNIA);
        model.put("entry_mutasi_path", PathPrefix.PENSIUN_LAMA + PathPrefix.MUTASI_PENERIMA_MP_MENINGGAL_DUNIA + "/entry");
        model.put("report_pensiun_lama", PathPrefix.API + PathPrefix.MUTASI_PENERIMA_MP_MENINGGAL_DUNIA + "/report-pensiun-lama");
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() +  PathPrefix.PENSIUN_LAMA, "Pensiun Lama"));
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() +  PathPrefix.PENSIUN_LAMA+PathPrefix.MUTASI_PENERIMA_MP_MENINGGAL_DUNIA, "Mutasi Penerima MP Meninggal Dunia"));
        model.put("breadcrumb", breadcrumb);
        return "pensiunLama/mutasi-penerima-mp-meninggal-dunia";
    }

    @GetMapping("/entry")
    public String entry(Map<String, Object> model,@RequestParam(name = "id", required = false) Long id) {
        List<BreadcrumbHolderComponentDto> breadcrumb = getBreadcrumbHolderComponentDtos();
        String isStaf = "";
        RoleDto roleDto = DkppUserStamp.getUserRoles();
        if (roleDto.getId() == 43){
            isStaf = roleDto.getId().toString();
            model.put("isStaf",isStaf);
        }
        model.put("periodeMutasi", setupParameterDao.findByBukaPeriode().getPeriode());
        //model.put("listPesertaCombo", PathPrefix.API + PathPrefix.MPENSIUN + PathPrefix.DATA + PathPrefix.MPENSIUN);
        model.put("listPesertaCombo", PathPrefix.API + PathPrefix.MPENSIUN + PathPrefix.DATA + "/status-bayar-1");
        model.put("cufnMeninggalSimulation", PathPrefix.API + PathPrefix.MUTASI_PENERIMA_MP_MENINGGAL_DUNIA + "/mpWafatSimulation");
        model.put("listNegaraCombo", PathPrefix.API + PathPrefix.NEGARA + PathPrefix.DROPDOWN);
        model.put("listProvinsiCombo", PathPrefix.API + PathPrefix.PROVINSI + PathPrefix.DROPDOWN);
        model.put("listKotaCombo", PathPrefix.API + PathPrefix.KOTA + PathPrefix.DROPDOWN);
        model.put("listKecamatanCombo", PathPrefix.API + PathPrefix.KECAMATAN + PathPrefix.DROPDOWN);
        model.put("listKelurahanCombo", PathPrefix.API + PathPrefix.KELURAHAN + PathPrefix.DROPDOWN);
        model.put("detailAlamatByKodePos", PathPrefix.API + PathPrefix.MUTASI_PENERIMA_MP_MENINGGAL_DUNIA + "/detail_alamat");
        model.put("detailAlamat", PathPrefix.API + PathPrefix.MUTASI_PENERIMA_MP_JANDA_DUDA_MENIKAH_KEMBALI + "/detail_alamat");
        model.put("listKategoriCatatanCombo", PathPrefix.API + PathPrefix.KATEGORICATATAN + PathPrefix.DROPDOWN);
        model.put("cekSuskel", PathPrefix.API + PathPrefix.MUTASI_PENERIMA_MP_MENINGGAL_DUNIA + "/checksuskel");
        model.put("mutasiMeninggalPathApi", PathPrefix.API + PathPrefix.MUTASI_PENERIMA_MP_MENINGGAL_DUNIA);
        model.put("mutasiMeninggalPath", PathPrefix.PENSIUN_LAMA + PathPrefix.MUTASI_PENERIMA_MP_MENINGGAL_DUNIA);
        model.put("listPeriodeSetupParameter", PathPrefix.API + PathPrefix.SETUPPARAMETER + "/get_periode");
        model.put("kategoriMutasi", StringUtil.objToJson(kategoriMutasiDto));

        if (id != null){
            MutasiPensiun mutasiPensiun = mutasiPensiunDao.findById(id);
            MutasiPensiunFormDto formDto = new MutasiPensiunFormDto();

            AgamaDto agama = mutasiPensiun.getAgama().toDto();
            KelurahanDto kelurahanDto = mutasiPensiun.getKelurahan().toDto();
            KecamatanDto kecamatanDto = mutasiPensiun.getKecamatan().toDto();
            KotaDto kotaDto = mutasiPensiun.getKota().toDto();
            ProvinsiDto provinsiDto = mutasiPensiun.getProvinsi().toDto();
            KantorBayarDto kantorCabang = mutasiPensiun.getKantorBayar().toDto();
            KategoriPenerimaDto kategoriPenerimaDto = mutasiPensiun.getKategoriPenerima().toDto();
            KategoriPenerimaDto kategoriPenerimaBaruDto = new KategoriPenerimaDto();
            KategoriCatatanDto kategoriCatatanDto = mutasiPensiun.getKategoryCatatan().toDto();
            StatusBayarDto statusBayarDto = null;
            if (mutasiPensiun.getStatusBayar() != null ) { statusBayarDto = mutasiPensiun.getStatusBayar().toDto();}
            try {
                kategoriPenerimaBaruDto = mutasiPensiun.getKategoriPenerimaBaru().toDto();
            }catch (Exception ex){
            }
            kategoriMutasiDto = mutasiPensiun.getKategoriMutasi().toDto();
            GolonganDto golongan = mutasiPensiun.getGolongan().toDto();
            model.put("mutasi_data", mutasiPensiun);
            model.put("kategoriCatatanDto", StringUtil.objToJson(kategoriCatatanDto));
            model.put("mutasi_data_nama_jk_peserta", mutasiPensiun.getJenisKelaminPeserta() == 'P'? "Pria": "Wanita");
            model.put("agama_list", agamaDao.findAll());
            model.put("statusBayarDto", statusBayarDto);
            /*model.put("kelurahanList", kelurahanDao.findAll());
            model.put("kecamatanList", kecamatanDao.findAll());
            model.put("kotaList", kotaDao.findAll());
            model.put("provinsiList", provinsiDao.findAll());*/
            model.put("kantorCabang", kantorCabang);
            model.put("golongan", golongan);
            model.put("gender", SelectValueUtil.createGenderSelect());

            //defaultSelect
            model.put("agamaDefaultSelect", agama);
            model.put("kelurahanDefaultSelect", kelurahanDto);
            model.put("kecamatanDefaultSelect", kecamatanDto);
            model.put("kotaDefaultSelect", kotaDto);
            model.put("provinsiDefaultSelect", provinsiDto);
            model.put("kategoriPenerimaDto", kategoriPenerimaDto);
            model.put("kategoriPenerimaBaruDto", kategoriPenerimaBaruDto);
            model.put("kategoriMutasi", StringUtil.objToJson(kategoriMutasiDto));

            //path
            model.put("negaraPathApi", PathPrefix.API + PathPrefix.NEGARA);
            model.put("provinsiPathApi", PathPrefix.API + PathPrefix.PROVINSI);
            model.put("kotaPathApi", PathPrefix.API + PathPrefix.KOTA);
            model.put("kecamatanPathApi", PathPrefix.API + PathPrefix.KECAMATAN);
            model.put("kelurahanPathApi", PathPrefix.API + PathPrefix.KELURAHAN);
            model.put("isEdit", 1);

            model.put("mutasiMeninggalPathEntry", PathPrefix.PENSIUN_LAMA + PathPrefix.MUTASI_PENERIMA_MP_MENINGGAL_DUNIA+"/entry?id="+id);
        }else{
            //MutasiPensiun mutasiPensiun = new MutasiPensiun();
            //model.put("mutasi_data",mutasiPensiun);
            model.put("agama_list", agamaDao.findAll());
            /*model.put("kelurahanList", kelurahanDao.findAll());
            model.put("kecamatanList", kecamatanDao.findAll());
            model.put("kotaList", kotaDao.findAll());
            model.put("provinsiList", provinsiDao.findAll());*/
            model.put("gender", SelectValueUtil.createGenderSelect());
        }
        model.put("breadcrumb", breadcrumb);
        return "pensiunLama/entry-penerima-mp-meninggal-dunia";
    }


    private List<BreadcrumbHolderComponentDto> getBreadcrumbHolderComponentDtos() {
        List<BreadcrumbHolderComponentDto> breadcrumb = new ArrayList<>();
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PENSIUN_LAMA, "Pensiun Lama"));
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PENSIUN_LAMA + PathPrefix.MUTASI_PENERIMA_MP_MENINGGAL_DUNIA, "Mutasi Penerima MP Meninggal Dunia"));
        return breadcrumb;
    }
}
