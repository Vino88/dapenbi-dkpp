package com.dapenbi.dkpp.controller.api;


import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.MutasiPensiunDao;
import com.dapenbi.dkpp.dao.SetupParameterDao;
import com.dapenbi.dkpp.dto.*;
import com.dapenbi.dkpp.form.MutasiPerubahanNamaPenerimaFormDto;
import com.dapenbi.dkpp.model.KategoriCatatan;
import com.dapenbi.dkpp.model.KategoriPenerima;
import com.dapenbi.dkpp.model.MutasiPensiun;
import com.dapenbi.dkpp.model.StatusValidasi;
import com.dapenbi.dkpp.util.*;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(PathPrefix.API + PathPrefix.MUTASI_PERUBAHAN_NAMA_PENERIMA_MP)
public class MutasiPerubahanNamaApiController {

    private MutasiPensiunDao mutasiPensiunDao;
    private DataSource dataSource;
    private SetupParameterDao setupParameterDao;
    private String idKategoriMutasi;

    @Autowired
    public MutasiPerubahanNamaApiController(MutasiPensiunDao mutasiPensiunDao, DataSource dataSource, SetupParameterDao setupParameterDao){
        this.mutasiPensiunDao = mutasiPensiunDao;
        this.dataSource = dataSource;
        this.setupParameterDao = setupParameterDao;
        this.idKategoriMutasi = "24";
    }

    @GetMapping
    public Page<MutasiPensiunDto> index(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam){
        String periodeMutasi = setupParameterDao.findByBukaPeriode().getPeriode();
        Page<MutasiPensiun> uIt = mutasiPensiunDao.findByKategoriMutasiAndPeriodeMutasi(idKategoriMutasi,periodeMutasi, searchParam +"%",pageRequest);
        Page<MutasiPensiunDto> mutasiPensiunDto = uIt.map(u ->{
           MutasiPensiunDto dto = u.toDto();
            KategoriPenerima kategoriPenerima = u.getKategoriPenerima();
            KategoriPenerimaDto kategoriPenerimaDto = kategoriPenerima.toDto();
            StatusValidasi statusValidasi = u.getStatusValidasi();
            StatusValidasiDto statusValidasiDto = statusValidasi.toDto();
            KategoriCatatan kategoriCatatan = u.getKategoryCatatan();
            KategoriCatatanDto kategoriCatatanDto = kategoriCatatan.toDto();
            

            dto.setKategoryCatatan(kategoriCatatanDto);
            dto.setStatusValidasi(statusValidasiDto);
            dto.setKategoriPenerima(kategoriPenerimaDto);
            return dto;
        } );
        return mutasiPensiunDto;
    }

    @GetMapping("/belum-validasi")
    public Page<MutasiPensiunDto> indexBelumValidasi(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam){
        String periodeMutasi = setupParameterDao.findByBukaPeriode().getPeriode();
        Page<MutasiPensiun> uIt = mutasiPensiunDao.findByKategoriMutasiAndPeriodeMutasiBelumValidasi(idKategoriMutasi,periodeMutasi, searchParam +"%",pageRequest);
        Page<MutasiPensiunDto> mutasiPensiunDto = uIt.map(u ->{
            MutasiPensiunDto dto = u.toDto();
            KategoriPenerima kategoriPenerima = u.getKategoriPenerima();
            KategoriPenerimaDto kategoriPenerimaDto = kategoriPenerima.toDto();
            StatusValidasi statusValidasi = u.getStatusValidasi();
            StatusValidasiDto statusValidasiDto = statusValidasi.toDto();
            KategoriCatatan kategoriCatatan = u.getKategoryCatatan();
            KategoriCatatanDto kategoriCatatanDto = kategoriCatatan.toDto();


            dto.setKategoryCatatan(kategoriCatatanDto);
            dto.setStatusValidasi(statusValidasiDto);
            dto.setKategoriPenerima(kategoriPenerimaDto);
            return dto;
        } );
        return mutasiPensiunDto;
    }

    @PostMapping
    public ResponseEntity<MessageUtil> process(@ModelAttribute MutasiPerubahanNamaPenerimaFormDto formDto){
        DkppUserDetail user = DkppUserStamp.getUserPrincipal();
        RoleDto role = user.getUser().getRoles().get(0);

        Map result =  mutasiPensiunDao.processMutasiPerubahanNamaPenerimaMp(role.getId()
                ,formDto.getCompName()
                ,formDto.getUserName()
                ,null
                ,"03"
                ,"24"
                ,formDto.getPeriodeMutasi()
                ,DateUtil.stringToDate(formDto.getTglMutasi(),"dd/MM/yyyy")
                ,formDto.getNip()
                ,formDto.getNamaPeserta()
                ,formDto.getIdPenerimaMp()
                ,formDto.getNamaPenerimaMp()
                ,formDto.getIdKategoriPenerimaMp()
                ,formDto.getNamaKategoriPenerimaMp()
                ,DateUtil.stringToDate(formDto.getTglLahirPenerimaMp(),"DD-MM-YYYY")
                ,formDto.getJenis_kelaminPenerimaMp()
                ,formDto.getIdPenerimaMpBaru()
                ,formDto.getNamaPenerimaMpBaru()
                ,formDto.getIdKtgoriPenerimaMpBaru()
                ,formDto.getNmKtgoripenerimaMpBaru()
                ,DateUtil.stringToDate(formDto.getTglLahirPenerimaMpBaru(),"DD-MM-YYYY")
                ,formDto.getJkPenerimaMpBaru()
                ,formDto.getIdKategoriCatatan()
                ,formDto.getKeterangan()
                ,"1"
                ,"Belum Validasi");

        MessageUtil messageUtil;
        HttpStatus httpStatus;
        if (result.get("PAR_STATUS_EKSEKUSI").equals('1') && result.get("PAR_ID_MUTASI_VAL") != null) {
            messageUtil = new MessageUtil("success", "Data berhasil ditambahkan");
            httpStatus = HttpStatus.OK;
        } else {
            messageUtil = new MessageUtil("failed", result.get("PAR_MSG").toString());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<MessageUtil>(messageUtil, httpStatus);
    }

    @PutMapping
    public ResponseEntity<MessageUtil> processupdate(@ModelAttribute MutasiPerubahanNamaPenerimaFormDto formDto){

        DkppUserDetail user = DkppUserStamp.getUserPrincipal();
        RoleDto role = user.getUser().getRoles().get(0);

        Map result =  mutasiPensiunDao.processMutasiPerubahanNamaPenerimaMp(role.getId()
                ,formDto.getCompName()
                ,formDto.getUserName()
                ,formDto.getId()
                ,"03"
                ,"24"
                ,formDto.getPeriodeMutasi()
                ,DateUtil.stringToDate(formDto.getTglMutasi(),"dd/MM/yyyy")
                ,formDto.getNip()
                ,formDto.getNamaPeserta()
                ,formDto.getIdPenerimaMp()
                ,formDto.getNamaPenerimaMp()
                ,formDto.getIdKategoriPenerimaMp()
                ,formDto.getNamaKategoriPenerimaMp()
                ,DateUtil.stringToDate(formDto.getTglLahirPenerimaMp(),"DD-MM-YYYY")
                ,formDto.getJenis_kelaminPenerimaMp()
                ,formDto.getIdPenerimaMpBaru()
                ,formDto.getNamaPenerimaMpBaru()
                ,formDto.getIdKtgoriPenerimaMpBaru()
                ,formDto.getNmKtgoripenerimaMpBaru()
                ,DateUtil.stringToDate(formDto.getTglLahirPenerimaMpBaru(),"DD-MM-YYYY")
                ,formDto.getJkPenerimaMpBaru()
                ,formDto.getIdKategoriCatatan()
                ,formDto.getKeterangan()
                ,formDto.getIdValidasi()
                ,formDto.getNamaValidasi());

        MessageUtil messageUtil;
        HttpStatus httpStatus;
        if (result.get("PAR_STATUS_EKSEKUSI").equals('1') && result.get("PAR_ID_MUTASI_VAL") != null) {
            messageUtil = new MessageUtil("success", "Data berhasil ditambahkan");
            httpStatus = HttpStatus.OK;
        } else {
            messageUtil = new MessageUtil("failed", result.get("PAR_MSG").toString());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<MessageUtil>(messageUtil, httpStatus);
    }

    @GetMapping("/report")
    public void reportMutasiPerubahanNamaPenerimaMP(HttpServletResponse httpServletResponse, @RequestParam("tipeReport") String tipeReport, @RequestParam("nip") String nip, @RequestParam("periodeMutasi") String periodeMutasi, @RequestParam("idKategoriMutasi") String idKategoriMutasi, @RequestParam(name = "download", required = false) Boolean download){

        String jasperFileName = null;
        String subReport = null;
        HashMap<String, Object> parameters = null;

        try {
                switch (tipeReport){
                    case "formulir_entry_mutasi" :
                        jasperFileName = "EntryMutasiPerubahanNamaPesertaPenerima";
                        parameters = new HashMap<>();
                        parameters.put("nip", nip);
                        parameters.put("periode_mutasi", periodeMutasi);
                        parameters.put("id_kategori_mutasi", idKategoriMutasi);
                        break;
                }
                if (jasperFileName != null){
                    createReport(httpServletResponse, nip, download, parameters, jasperFileName, subReport);
                }

        }catch (IOException | JRException e){
            e.printStackTrace();
        }
    }

    private void createReport(HttpServletResponse httpServletResponse, String nip, Boolean download, Map<String, Object> parameters, String jasperFileName, String subReport) throws JRException, IOException {
        ReportCompiler rc = new ReportCompiler();
        JasperReport jasperReport = rc.compileReport(jasperFileName);
        setReportHeader(httpServletResponse, nip, jasperFileName, download);
        // Set report
        ReportUtil reportUtil = new ReportUtil(jasperFileName, httpServletResponse.getOutputStream());
        if (subReport != null) {
            parameters.put("subReport", reportUtil.getSubReportPath(subReport));
        }
        Connection conn = DataSourceUtils.getConnection(dataSource);
        reportUtil.setReport(parameters, conn, new JRPdfExporter());
        SimplePdfReportConfiguration reportConfig = new SimplePdfReportConfiguration();
        reportConfig.setSizePageToContent(true);
        reportConfig.setForceLineBreakPolicy(false);
        reportUtil.getExporter().setConfiguration(reportConfig);
        // write report to output stream
        reportUtil.getExporter().exportReport();
        reportUtil.getOutputStream().flush();
    }

    private void setReportHeader(HttpServletResponse httpServletResponse, String nip, String jasperFileName, Boolean download) {
        // Set web response output stream
        MediaType mediaType = MediaType.parseMediaType("application/pdf");
        httpServletResponse.setContentType(mediaType.getType());
        if ((download != null) && (download)) {
            httpServletResponse.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + jasperFileName + "-" + new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + nip + ".pdf");
        } else {
            httpServletResponse.setHeader(HttpHeaders.CONTENT_TYPE, "application/pdf");
        }
    }

}
