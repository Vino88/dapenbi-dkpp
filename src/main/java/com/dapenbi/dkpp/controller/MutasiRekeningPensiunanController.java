package com.dapenbi.dkpp.controller;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.JenisBankDao;
import com.dapenbi.dkpp.dao.SetupParameterDao;
import com.dapenbi.dkpp.dto.DkppUserDetail;
import com.dapenbi.dkpp.dto.RoleDto;
import com.dapenbi.dkpp.dto.component.BreadcrumbHolderComponentDto;
import com.dapenbi.dkpp.dto.component.Select2Default;
import com.dapenbi.dkpp.model.JenisBank;
import com.dapenbi.dkpp.util.DateUtil;
import com.dapenbi.dkpp.util.DkppUserStamp;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.sql.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(PathPrefix.PEMBAYARAN + PathPrefix.MUTASI_REKENING_PENSIUNAN)
public class MutasiRekeningPensiunanController {

    private ServletContext servletContext;

    private SetupParameterDao setupParameterDao;

    private JenisBankDao jenisBankDao;

    @Autowired
    public MutasiRekeningPensiunanController(ServletContext servletContext, SetupParameterDao setupParameterDao, JenisBankDao jenisBankDao){
        this.servletContext = servletContext;
        this.setupParameterDao = setupParameterDao;
        this.jenisBankDao = jenisBankDao;
    }

    @GetMapping
    public String index(Map<String,Object> model) {
        DkppUserDetail user = DkppUserStamp.getUserPrincipal();
        RoleDto role = user.getUser().getRoles().get(0);

        List<BreadcrumbHolderComponentDto> breadcrumb = new ArrayList<>();
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PEMBAYARAN,"Pembayaran"));
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PEMBAYARAN+PathPrefix.PEMBAYARAN_MP_BULANAN,"Mutasi Rekening Pensiunan"));
        model.put("breadcrumb",breadcrumb);

        model.put("roleCode", role.getCode());
        model.put("listPesertaCombo", PathPrefix.API +PathPrefix.MPENSIUN + PathPrefix.DATA + "/status-bayar-1");
        model.put("listJenisBank", servletContext.getContextPath() + PathPrefix.API +PathPrefix.MUTASI_REKENING_PENSIUNAN + "/get-jenis-bank");
        model.put("getUserStamp", servletContext.getContextPath() + PathPrefix.API +PathPrefix.MUTASI_REKENING_PENSIUNAN + "/get-user-stamp");
        model.put("saveMutasiRekening", servletContext.getContextPath() + PathPrefix.API +PathPrefix.MUTASI_REKENING_PENSIUNAN);
        model.put("rekeningPensiunanLink", servletContext.getContextPath() + PathPrefix.API + PathPrefix.MUTASI_REKENING_PENSIUNAN);
        model.put("rekeningPensiunanFilterLink", servletContext.getContextPath() + PathPrefix.API + PathPrefix.MUTASI_REKENING_PENSIUNAN + "/filter");
        model.put("linkDataRekeningUpload", servletContext.getContextPath() + PathPrefix.API + PathPrefix.MUTASI_REKENING_PENSIUNAN + "/get-uploaded-data");
        model.put("findMasterPenerimaRekeningByNip", servletContext.getContextPath() + PathPrefix.API + PathPrefix.MUTASI_REKENING_PENSIUNAN + "/find-master-penerima-rekening-by-nip");
        model.put("periodeMutasi", setupParameterDao.findByBukaPeriode().getPeriode());
        model.put("tglUpdate", DateUtil.dateToString(DkppUserStamp.getTimeStamp()) );
        model.put("uploadLink", servletContext.getContextPath() + PathPrefix.API + PathPrefix.MUTASI_REKENING_PENSIUNAN + "/upload-perbandingan");
        model.put("linkProsesRekonsiliasi", servletContext.getContextPath() + PathPrefix.API + PathPrefix.MUTASI_REKENING_PENSIUNAN + "/proses-rekonsiliasi");
        model.put("linkDataRekonsiliasi", servletContext.getContextPath() + PathPrefix.API + PathPrefix.MUTASI_REKENING_PENSIUNAN + "/get-data-rekonsiliasi");
        model.put("linkValidasiRekonsiliasi", servletContext.getContextPath() + PathPrefix.API + PathPrefix.MUTASI_REKENING_PENSIUNAN + "/validasi-data-rekonsiliasi");
        model.put("repot_rekening", PathPrefix.API + PathPrefix.MUTASI_REKENING_PENSIUNAN + "/report-mutasi-rekening");
        model.put("report_excel", PathPrefix.API + PathPrefix.MUTASI_REKENING_PENSIUNAN + "/report-proses-data-ppbi-ykkbi");
        return "pembayaran/mutasi-rekening-pensiunan";
    }


}
