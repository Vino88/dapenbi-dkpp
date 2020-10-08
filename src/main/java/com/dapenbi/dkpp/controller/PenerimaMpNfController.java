package com.dapenbi.dkpp.controller;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.SetupParameterDao;
import com.dapenbi.dkpp.dto.DkppUserDetail;
import com.dapenbi.dkpp.dto.RoleDto;
import com.dapenbi.dkpp.dto.component.BreadcrumbHolderComponentDto;
import com.dapenbi.dkpp.util.DkppUserStamp;
import com.dapenbi.dkpp.util.SelectValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletContext;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(PathPrefix.PEMBAYARAN + PathPrefix.PENERIMA_MP_NF)
public class PenerimaMpNfController {
    private ServletContext servletContext;

    @Autowired
    private SetupParameterDao setupParameterDao;

    @Autowired
    public PenerimaMpNfController(ServletContext servletContext){
        this.servletContext = servletContext;
    }

    @GetMapping
    public String index(Map<String,Object> model){
        List<BreadcrumbHolderComponentDto> breadcrumb = new ArrayList<>();
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PEMBAYARAN,"Pembayaran"));
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PEMBAYARAN+PathPrefix.PENERIMA_MP_NF," Penerima Manfaat Pensiun NF"));
        DkppUserDetail user = DkppUserStamp.getUserPrincipal();
        RoleDto role = user.getUser().getRoles().get(0);

        model.put("isPejabat", role.getName().equals("Pejabat")?true:false );
        model.put("isStaff", role.getName().equals("Staff")?true:false );
        model.put("isAdmin", role.getName().equals("Admin")?true:false );
        model.put("username", DkppUserStamp.getUserName());
        model.put("tblMPensiunNfData", servletContext.getContextPath() + PathPrefix.API + PathPrefix.PENERIMA_MP_NF);
        model.put("mPensiunNfUpdateLink", servletContext.getContextPath() + PathPrefix.API + PathPrefix.PENERIMA_MP_NF);
        model.put("mPensiunNfKursLink", servletContext.getContextPath() + PathPrefix.API + PathPrefix.PENERIMA_MP_NF + "/kurs");
        model.put("tblMKeluargaPensiunNfData", servletContext.getContextPath() + PathPrefix.API + PathPrefix.PENERIMA_MP_NF + "/get-keluarga");
        model.put("linkProsesPembayaranMPNF", servletContext.getContextPath() + PathPrefix.API + PathPrefix.PENERIMA_MP_NF + "/proses-pembayaran-mp-nf");
        model.put("linkProsesPembayaranMPNFPTR", servletContext.getContextPath() + PathPrefix.API + PathPrefix.PENERIMA_MP_NF + "/proses-pembayaran-mp-nf-send-ptr");
        model.put("tblPembayaranMpNfLinkData", servletContext.getContextPath() + PathPrefix.API + PathPrefix.PENERIMA_MP_NF + "/data-pembayaran-mp-nf");
        model.put("tblMutasiHapusPenerimaMpNfData", servletContext.getContextPath() + PathPrefix.API + PathPrefix.PENERIMA_MP_NF + "/data-mutasi-hapus-nf");
        model.put("linkPenerimaMpNf", servletContext.getContextPath() + PathPrefix.API + PathPrefix.PENERIMA_MP_NF + "/dropdown");
        model.put("linkHutangPenerimaMpNf", servletContext.getContextPath() + PathPrefix.API + PathPrefix.HUTANG_NF + "/dropdown");
        model.put("linkBankNf", servletContext.getContextPath() + PathPrefix.API + PathPrefix.BANK_NF + "/dropdown");
        model.put("listPeriodeSetupParameter", PathPrefix.API + PathPrefix.SETUPPARAMETER + "/get_periode");
        model.put("listKategoriCatatanCombo", PathPrefix.API + PathPrefix.KATEGORICATATAN + PathPrefix.DROPDOWN);
        model.put("linkInsertMutasiHapus", servletContext.getContextPath() + PathPrefix.API + PathPrefix.PENERIMA_MP_NF + "/insert-mutasi-hapus");
        model.put("tbl_her_registrasi_nf", PathPrefix.API+ PathPrefix.PENERIMA_MP_NF + "/her-registrasi-nf");
        model.put("tbl_her_registrasi_detail_nf",  PathPrefix.PEMBAYARAN+ PathPrefix.PENERIMA_MP_NF + "/her-registrasi-nf-detail");
        model.put("tb_hutang_nf", PathPrefix.API + PathPrefix.PENERIMA_MP_NF + "/hutang-nf");
        model.put("tb_pembayaran_hutang", PathPrefix.API + PathPrefix.PENERIMA_MP_NF + "/pembayaran-hutang-nf");
        model.put("kirim_ke_ptr", PathPrefix.API + PathPrefix.PENERIMA_MP_NF + "/sent-to-ptr-nf");
        model.put("breadcrumb",breadcrumb);
        model.put("gender", SelectValueUtil.createGenderSelect());
        model.put("kategoriPenerimaPathApi", PathPrefix.API + PathPrefix.KATEGORI_PENERIMA);
        model.put("linkPenerimaMpNf", servletContext.getContextPath() + PathPrefix.API + PathPrefix.PENERIMA_MP_NF + "/dropdown");
        model.put("periodeMutasi", setupParameterDao.findByBukaPeriode().getPeriode());
        model.put("checkKursCurrentPeriode", servletContext.getContextPath() + PathPrefix.API + PathPrefix.KURS + "/check-kurs-by-periode");

        return "pembayaran/penerima-mp-nf";
    }

    @GetMapping("/her-registrasi-nf-detail/{tahunHer}")
    public String detailHer(Map<String,Object> model, @PathVariable(value = "tahunHer") String tahunHer){
        List<BreadcrumbHolderComponentDto> breadcrumb = new ArrayList<>();
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PEMBAYARAN,"Pembayaran"));
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PEMBAYARAN+PathPrefix.PENERIMA_MP_NF," Penerima Manfaat Pensiun NF"));
        model.put("tbl_her_registrasi_nf", PathPrefix.API+ PathPrefix.PENERIMA_MP_NF + "/her-registrasi-nf");
        model.put("tbl_her_registrasi_detail_nf",  PathPrefix.API+ PathPrefix.PENERIMA_MP_NF + "/her-registrasi-nf-detail");
        model.put("tahunHer", tahunHer);
        model.put("breadcrumb",breadcrumb);
        model.put("gender", SelectValueUtil.createGenderSelect());
        model.put("kategoriPenerimaPathApi", PathPrefix.API + PathPrefix.KATEGORI_PENERIMA);
        model.put("periodeMutasi", setupParameterDao.findByBukaPeriode().getPeriode());
        model.put("dataHeaderHer", PathPrefix.API+ PathPrefix.PENERIMA_MP_NF + "/data-header-her");

        return "pembayaran/her-registrasi-nf-detail";
    }


}
