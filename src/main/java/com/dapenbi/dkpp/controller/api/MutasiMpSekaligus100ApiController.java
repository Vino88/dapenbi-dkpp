package com.dapenbi.dkpp.controller.api;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.MutasiPensiunDao;
import com.dapenbi.dkpp.dao.SetupParameterDao;
import com.dapenbi.dkpp.dao.ViewModel.MutasiMpSekaligus100ViewDao;
import com.dapenbi.dkpp.dto.DkppUserDetail;
import com.dapenbi.dkpp.dto.RoleDto;
import com.dapenbi.dkpp.dto.ViewModelDto.MutasiMpSekaligus100ViewDto;
import com.dapenbi.dkpp.form.MutasiMpSekaligus100FormDto;
import com.dapenbi.dkpp.model.MutasiPensiun;
import com.dapenbi.dkpp.model.ViewModel.MutasiMpSekaligus100View;
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
@RequestMapping(PathPrefix.API + PathPrefix.MUTASI_MANFAAT_PENSIUN_100)
public class MutasiMpSekaligus100ApiController {

    @Autowired
    MutasiMpSekaligus100ViewDao mutasiMpSekaligus100ViewDao;

    @Autowired
    MutasiPensiunDao mutasiPensiunDao;

    @Autowired
    SetupParameterDao setupParameterDao;

    private DataSource dataSource;

    public MutasiMpSekaligus100ApiController(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @GetMapping
    public Page<MutasiMpSekaligus100ViewDto> index(Pageable pageRequest, @RequestParam(name = "searchParam", required = false)String searcParam){

        Page<MutasiMpSekaligus100View> uIt = (Page<MutasiMpSekaligus100View>) mutasiMpSekaligus100ViewDao.findAll(new String[]{"nip"},"%"+ searcParam +"%", pageRequest);
        Page<MutasiMpSekaligus100ViewDto> result = uIt.map(u -> {
            MutasiMpSekaligus100ViewDto dto = u.toDto();
            return dto;
        });

        return result;
    }

    @GetMapping("/belum-validasi")
    public Page<MutasiMpSekaligus100ViewDto> indexBelumValidasi(Pageable pageRequest, @RequestParam(name = "searchParam", required = false)String searcParam){

        Page<MutasiMpSekaligus100View> uIt = (Page<MutasiMpSekaligus100View>) mutasiMpSekaligus100ViewDao.findAllByBelumValidasi("%"+ searcParam +"%", pageRequest);
        Page<MutasiMpSekaligus100ViewDto> result = uIt.map(u -> {
            MutasiMpSekaligus100ViewDto dto = u.toDto();
            return dto;
        });

        return result;
    }

    @GetMapping("/cufn-hitung-mps")
    public Object getHitungMps100(@RequestParam(name = "nip") String nip, @RequestParam(name = "periodeMutasi") String periodeMutasi){
        return mutasiPensiunDao.cufnHitungMps100(nip,periodeMutasi);
    }

    @PostMapping("/addprocess")
    public ResponseEntity<MessageUtil> addprocess(@ModelAttribute MutasiMpSekaligus100FormDto formDto){

        String formatDate = "dd/MM/yyyy";
        DkppUserDetail user = DkppUserStamp.getUserPrincipal();
        RoleDto role = user.getUser().getRoles().get(0);

        Map result = mutasiMpSekaligus100ViewDao.cuspMutasiMps100(formDto.getCompName()
                ,formDto.getUserName()
                ,role.getId()
                ,formDto.getPeriodeMutasi()
                ,null
                ,DateUtil.stringToDate(formDto.getTglMutasi(),formatDate)
                ,formDto.getNip()
                ,DateUtil.stringToDate(formDto.getTglMohonMps100(),formatDate)
                ,DateUtil.stringToDate(formDto.getTglBayarMps100(),formatDate)
                ,formDto.getUsiaPenerimaBayar()
                ,formDto.getUsiaPenerimaBayarBlt()
                ,DateUtil.stringToDate(formDto.getTglHentiBayar(),formatDate)
                ,formDto.getMps100()
                ,formDto.getMps100Bulat()
                ,formDto.getIdAlasanMps100()
                ,formDto.getNamaAlasanMps100()
                ,"1"
                ,"Belum Validasi"
                ,formDto.getIdKategoriCatatan()
                ,formDto.getNamaCatatan()
                ,formDto.getKeterangan()
                ,formDto.getIdFaktorFs()
                ,formDto.getNamaFaktorFs()
                ,formDto.getFaktorFs()
                ,formDto.getNilaiFaktorFs());
        MessageUtil messageUtil;
        HttpStatus httpStatus;
        if (result.get("PAR_STATUS_EKSEKUSI").equals('1')) {
            messageUtil = new MessageUtil("success", "Data berhasil ditambahkan");
            httpStatus = HttpStatus.OK;
        } else {
            messageUtil = new MessageUtil("failed", result.get("PAR_MSG").toString());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<MessageUtil>(messageUtil, httpStatus);
    }

    @PutMapping
    public ResponseEntity<MessageUtil> processupdate(@ModelAttribute MutasiMpSekaligus100FormDto formDto){
        String formatDate = "dd/MM/yyyy";
        DkppUserDetail user = DkppUserStamp.getUserPrincipal();
        RoleDto role = user.getUser().getRoles().get(0);
        Map result = mutasiPensiunDao.cuspMutasiMps100(formDto.getCompName()
                ,formDto.getUserName()
                ,role.getId()
                ,formDto.getPeriodeMutasi()
                ,formDto.getIdMutasi()
                ,DateUtil.stringToDate(formDto.getTglMutasi(),formatDate)
                ,formDto.getNip()
                ,DateUtil.stringToDate(formDto.getTglMohonMps100(),formatDate)
                ,DateUtil.stringToDate(formDto.getTglBayarMps100(),formatDate)
                ,formDto.getUsiaPenerimaBayar()
                ,formDto.getUsiaPenerimaBayarBlt()
                ,DateUtil.stringToDate(formDto.getTglHentiBayar(),formatDate)
                ,formDto.getMps100()
                ,formDto.getMps100Bulat()
                ,formDto.getIdAlasanMps100()
                ,formDto.getNamaAlasanMps100()
                ,formDto.getIdValidasi()
                ,formDto.getNamaValidasi()
                ,formDto.getIdKategoriCatatan()
                ,formDto.getNamaCatatan()
                ,formDto.getKeterangan()
                ,formDto.getIdFaktorFs()
                ,formDto.getNamaFaktorFs()
                ,formDto.getFaktorFs()
                ,formDto.getNilaiFaktorFs());
        MessageUtil messageUtil;
        HttpStatus httpStatus;
        if (result.get("PAR_STATUS_EKSEKUSI").equals('1')) {
            messageUtil = new MessageUtil("success", "Data berhasil ditambahkan");
            httpStatus = HttpStatus.OK;
        } else {
            messageUtil = new MessageUtil("failed", result.get("PAR_MSG").toString());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<MessageUtil>(messageUtil, httpStatus);
    }

    @GetMapping("/report")
    public void reportMps100(HttpServletResponse httpServletResponse, @RequestParam("tipeReport") String tipeReport, @RequestParam("nip") String nip, @RequestParam("periodeMutasi") String periodeMutasi, @RequestParam("idKategoriMutasi") String idKategoriMutasi, @RequestParam(name = "download", required = false) Boolean download){
        String jasperFileName = null;
        String subReport = null;
        HashMap<String, Object> parameters = null;

        try {

                switch (tipeReport){
                    case "formulir_entry_mutasi" :
                        jasperFileName = "Entry_Mutasi_PensiunHapus";
                        parameters = new HashMap<>();
                        parameters.put("nip", nip);
                        parameters.put("periode_mutasi", periodeMutasi);
                        parameters.put("id_kategori_mutasi", idKategoriMutasi);
                        break;

                    case "catatan" :
                        jasperFileName = "PerhitunganMPS_Ketentuan_MENKEU";
                        subReport = "keluarga_pensiunMI";
                        parameters = new HashMap<>();
                        parameters.put("nip", nip);
                        parameters.put("periode_mutasi", periodeMutasi);
                        parameters.put("id_kategori_mutasi", idKategoriMutasi);
                        break;
                }
                if (jasperFileName != null){
                    createReport(httpServletResponse, nip, download, parameters, jasperFileName, subReport);
                }

        }catch (IOException | JRException el){
            el.printStackTrace();
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
