package com.dapenbi.dkpp.controller.api;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.component.SpreadSheetMapping.RekeningVersiMandiriCellMapping;
import com.dapenbi.dkpp.dao.*;
import com.dapenbi.dkpp.dto.*;
import com.dapenbi.dkpp.dto.component.Select2Default;
import com.dapenbi.dkpp.form.*;
import com.dapenbi.dkpp.model.*;
import com.dapenbi.dkpp.util.*;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRRuntimeException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;
import net.sf.jasperreports.export.SimpleXlsxExporterConfiguration;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.hibernate.sql.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping(PathPrefix.API + PathPrefix.MUTASI_REKENING_PENSIUNAN)
public class MutasiRekeningPensiunanApiController {

    private TMutasiRekeningDao tMutasiRekeningDao;
    private RekeningPenerimaMpDao rekeningPenerimaMpDao;
    private JenisBankDao jenisBankDao;
    private UploadRekVersiMandiriDao uploadRekVersiMandiriDao;
    private RekonsiliasiRekeningDao rekonsiliasiRekeningDao;
    private DataSource dataSource;

    @Value("${file.upload-dir}")
    private String filePath;

    @Autowired
    public MutasiRekeningPensiunanApiController(TMutasiRekeningDao tMutasiRekeningDao, RekeningPenerimaMpDao rekeningPenerimaMpDao, JenisBankDao jenisBankDao, UploadRekVersiMandiriDao uploadRekVersiMandiriDao, RekonsiliasiRekeningDao rekonsiliasiRekeningDao, DataSource dataSource){
        this.tMutasiRekeningDao = tMutasiRekeningDao;
        this.rekeningPenerimaMpDao = rekeningPenerimaMpDao;
        this.jenisBankDao = jenisBankDao;
        this.uploadRekVersiMandiriDao = uploadRekVersiMandiriDao;
        this.rekonsiliasiRekeningDao = rekonsiliasiRekeningDao;
        this.dataSource = dataSource;
    }

    @GetMapping
    public Page<TMutasiRekeningDto> index(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam) {
        Page<TMutasiRekening> uIt = (Page<TMutasiRekening>) tMutasiRekeningDao.findAll(new String[] {"namaPeserta"}, "%" + searchParam + "%", pageRequest);

        Page<TMutasiRekeningDto> tMutasiRekeningDtos = uIt.map(u -> {
            TMutasiRekeningDto dto = u.toDto();
            return dto;
        });

        return tMutasiRekeningDtos;
    }

    @GetMapping("/filter")
    public Page<TMutasiRekeningDto> filter(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam, @RequestParam(name="periode") String periode, @RequestParam(name="startDate") String startDate, @RequestParam(name="endDate") String endDate) {
        Date dStartDate = DateUtil.stringToDate(startDate);
        Date dEndDate = DateUtil.stringToDate(endDate);

        Page<TMutasiRekening> uIt = (Page<TMutasiRekening>) tMutasiRekeningDao.findAllByFilterForm(periode, dStartDate, dEndDate, "%" + searchParam + "%", pageRequest);

        Page<TMutasiRekeningDto> tMutasiRekeningDtos = uIt.map(u -> {
            TMutasiRekeningDto dto = u.toDto();
            return dto;
        });

        return tMutasiRekeningDtos;
    }

    @GetMapping("/get-uploaded-data")
    public Page<UploadRekVersiMandiriDto> getUploadedData(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam) {
        Page<UploadRekVersiMandiri> uIt = (Page<UploadRekVersiMandiri>) uploadRekVersiMandiriDao.findAll(new String[] {"namaPeserta"}, "%" + searchParam + "%", pageRequest);

        Page<UploadRekVersiMandiriDto> uploadRekVersiMandiriDtos = uIt.map(u -> {
            UploadRekVersiMandiriDto dto = u.toDto();
            return dto;
        });

        return uploadRekVersiMandiriDtos;
    }

    @GetMapping("/find-master-penerima-rekening-by-nip")
    public Map getMasterPenerimaMpByNip(@RequestParam(name = "nip") String nip){
        RekeningPenerimaMp rekeningPenerimaMp = this.rekeningPenerimaMpDao.findByNip(nip);

        Map map = new HashMap();
        if(rekeningPenerimaMp == null ){
            map.put("result", false);

        } else {
            map.put("result", true);
            map.put("dto", rekeningPenerimaMp.toDto());
        }
        return map;
    }

    @GetMapping("/get-jenis-bank")
    public List<Select2Default> getJenisBank(){
        List<Select2Default> listSelect2 = new ArrayList<Select2Default>();
        Iterable<JenisBank> jenisBanks = jenisBankDao.findAll(Sort.by(Sort.Direction.ASC, "id" ));
        jenisBanks.forEach(jenisBank -> {
            listSelect2.add(new Select2Default(jenisBank.getId().toString(), jenisBank.getJenisBank()));
        });
        return listSelect2;
    }

    @GetMapping("/get-user-stamp")
    public Map getUserStamp(){
        Map map = new HashMap();
        map.put("userStamp", DkppUserStamp.postModeUserStamp());
        map.put("userValidasi", DkppUserStamp.getUserName());
        return map;
    }

    @PostMapping
    public ResponseEntity<MessageUtil> processMutasi(@ModelAttribute CuspMutasiRekeningPlainDto plainDto){
        DkppUserDetail user = DkppUserStamp.getUserPrincipal();
        RoleDto role = user.getUser().getRoles().get(0);
        CuspMutasiRekeningSPDto spDto = new CuspMutasiRekeningSPDto();
        spDto.fromPlainText(plainDto);
        spDto.setParRoleId(role.getId());
        spDto.setParCompName(DkppUserStamp.getCompName());
        spDto.setParUserName(DkppUserStamp.getUserName());

        Map result = tMutasiRekeningDao.processCuspMutasiRekening(spDto);

        MessageUtil messageUtil;
        HttpStatus httpStatus;
        if (result.get("PAR_STATUS_EKSEKUSI").equals('1') || result.get("PAR_STATUS_EKSEKUSI").equals("1")) {
            messageUtil = new MessageUtil("success", "Data berhasil diproses.", spDto);
            httpStatus = HttpStatus.OK;
        } else {
            messageUtil = new MessageUtil("failed", result.get("PAR_MSG").toString(), spDto);
            httpStatus = HttpStatus.CONFLICT;
        }
        return new ResponseEntity<MessageUtil>(messageUtil, httpStatus);

    }

    @PostMapping("/upload-perbandingan")
    public ResponseEntity<MessageUtil> uploadPotongan(@RequestParam("file") MultipartFile file){
        UploadInfo data = new UploadInfo();
        data.setJumlahData(0);
        try{
            byte[] bytes = file.getBytes();
            Path path = Paths.get(this.filePath,file.getOriginalFilename());
            Files.write(path, bytes);


            ExcelReaderUtil excelReaderUtil = new ExcelReaderUtil(this.filePath + "/" + file.getOriginalFilename());
            excelReaderUtil.getHeaderRow(excelReaderUtil.getFirstSheet());
            Sheet sheet = excelReaderUtil.getFirstSheet();
            excelReaderUtil.close();

            //saveTo
            data = this.saveToTable(sheet);
        } catch (IOException e){
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }


        MessageUtil messageUtil = new MessageUtil("success", "Data berhasil diupload", data);
        return new ResponseEntity<MessageUtil>(messageUtil, HttpStatus.OK);
    }

    private UploadInfo saveToTable(Sheet sheet){
        UploadInfo uploadInfo = new UploadInfo();
        DataFormatter dataFormatter = new DataFormatter();
        Iterator<Row> rowIterator = sheet.rowIterator();
        uploadRekVersiMandiriDao.deleteAll();
        int ctr = 0;
        while(rowIterator.hasNext()){
            Row row = rowIterator.next();
            UploadRekVersiMandiri uploadRekVersiMandiri = new UploadRekVersiMandiri();
            uploadRekVersiMandiri.setNamaPeserta(dataFormatter.formatCellValue(row.getCell(RekeningVersiMandiriCellMapping.NAMA_PESERTA)));
            uploadRekVersiMandiri.setPeriode(dataFormatter.formatCellValue(row.getCell(RekeningVersiMandiriCellMapping.PERIODE)));
            uploadRekVersiMandiri.setNip(dataFormatter.formatCellValue(row.getCell(RekeningVersiMandiriCellMapping.NIP)));
            uploadRekVersiMandiri.setNamaPenerimaMp(dataFormatter.formatCellValue(row.getCell(RekeningVersiMandiriCellMapping.NAMA_PENERIMA_MP)));
            uploadRekVersiMandiri.setIdPenerimaMp(dataFormatter.formatCellValue(row.getCell(RekeningVersiMandiriCellMapping.ID_PENERIMA_MP)));
            uploadRekVersiMandiri.setNomorRekening(dataFormatter.formatCellValue(row.getCell(RekeningVersiMandiriCellMapping.NOMOR_REKENING)));
            uploadRekVersiMandiri.setNamaRekening(dataFormatter.formatCellValue(row.getCell(RekeningVersiMandiriCellMapping.NAMA_REKENING)));
            uploadRekVersiMandiri.setUserStamp(DkppUserStamp.postModeUserStamp());
            uploadRekVersiMandiri.setCreatedAt(DkppUserStamp.getTimeStamp());
            uploadRekVersiMandiri.setTglUpload(DkppUserStamp.getTimeStamp());
            if(row.getRowNum() != 0) {
                uploadRekVersiMandiriDao.save(uploadRekVersiMandiri);

                ctr++;
            }

        }

        uploadInfo.setJumlahData(ctr);
        return uploadInfo;
    }

    @PostMapping("/proses-rekonsiliasi")
    public ResponseEntity<MessageUtil> prosesRekonsiliasi(@ModelAttribute CuspProsesRekonRekeningPlainDto plainDto){
        DkppUserDetail user = DkppUserStamp.getUserPrincipal();
        RoleDto role = user.getUser().getRoles().get(0);
        CuspProsesRekonRekeningSPDto spDto = new CuspProsesRekonRekeningSPDto();
        spDto.setParRoleId(role.getId());
        spDto.setParCompName(DkppUserStamp.getCompName());
        spDto.setParUserName(DkppUserStamp.getUserName());
        spDto.setParPeriode(plainDto.getParPeriode());

        Map result = rekonsiliasiRekeningDao.processCuspProsesRekonRekening(spDto);

        MessageUtil messageUtil;
        HttpStatus httpStatus;
        if (result.get("PAR_STATUS_EKSEKUSI").equals('1') || result.get("PAR_STATUS_EKSEKUSI").equals("1")) {
            spDto.setParMsg("{\"totalData\": " + this.rekonsiliasiRekeningDao.getCount() + "}");
            messageUtil = new MessageUtil("success", "Data berhasil diproses.", spDto);
            httpStatus = HttpStatus.OK;
        } else {
            messageUtil = new MessageUtil("failed", result.get("PAR_MSG").toString(), spDto);
            httpStatus = HttpStatus.CONFLICT;
        }
        return new ResponseEntity<MessageUtil>(messageUtil, httpStatus);

    }

    @GetMapping("/get-data-rekonsiliasi")
    public Page<RekonsiliasiRekeningDto> getReconcileData(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam) {
        Page<RekonsiliasiRekening> uIt = (Page<RekonsiliasiRekening>) rekonsiliasiRekeningDao.findAll(new String[] {"namaPeserta"}, "%" + searchParam + "%", pageRequest);

        Page<RekonsiliasiRekeningDto> uploadRekVersiMandiriDtos = uIt.map(u -> {
            RekonsiliasiRekeningDto dto = u.toDto();
            return dto;
        });

        return uploadRekVersiMandiriDtos;
    }

    @PostMapping("/validasi-data-rekonsiliasi")
    public ResponseEntity<MessageUtil> validasiDataRekonsiliasi(@ModelAttribute CuspValidasiRekonRekeningPlainDto plainDto){
        DkppUserDetail user = DkppUserStamp.getUserPrincipal();
        RoleDto role = user.getUser().getRoles().get(0);
        CuspValidasiRekonRekeningSPDto spDto = new CuspValidasiRekonRekeningSPDto();
        spDto.setParPeriode(plainDto.getParPeriode());
        spDto.setParNip(plainDto.getParNip());
        spDto.setParRoleId(role.getId());
        spDto.setParCompName(DkppUserStamp.getCompName());
        spDto.setParUserName(DkppUserStamp.getUserName());

        Map result = rekonsiliasiRekeningDao.processCuspValidasiRekonRekening(spDto);

        MessageUtil messageUtil;
        HttpStatus httpStatus;
        if (result.get("PAR_STATUS_EKSEKUSI").equals('1') || result.get("PAR_STATUS_EKSEKUSI").equals("1")) {
            messageUtil = new MessageUtil("success", "Data berhasil diproses.", spDto);
            httpStatus = HttpStatus.OK;
        } else {
            messageUtil = new MessageUtil("failed", result.get("PAR_MSG").toString(), spDto);
            httpStatus = HttpStatus.CONFLICT;
        }
        return new ResponseEntity<MessageUtil>(messageUtil, httpStatus);

    }

    @GetMapping("/report-mutasi-rekening")
    public void reportPembayaran(HttpServletResponse httpServletResponse,
                                 @RequestParam("tipeReport") String tipeReport,
                                 @RequestParam("startDate") String startDate,
                                 @RequestParam("endDate") String endDate,
                                 @RequestParam("namaPetugas") String namaPetugas,
                                 @RequestParam("periodeMutasi") String periodeMutasi,
                                 @RequestParam("idKategoriPensiun") String idKategoriPensiun,
                                 @RequestParam("kepalaDivisi") String kepalaDivisi,
                                 @RequestParam("kepalaSeksi") String kepalaSeksi,
                                 @RequestParam(name = "download", required = false) Boolean download){

        String jasperFileName = null;
        HashMap<String, Object> parameters = null;

        try {
            switch (tipeReport){
                case "DaftarDataPerubahanRekening1" :
                    jasperFileName = "DaftarDataPerubahanRekening1";
                    parameters = new HashMap<>();
                    parameters.put("start_date", startDate);
                    parameters.put("end_date", endDate);
                    parameters.put("kepala_divisi", kepalaDivisi);
                    parameters.put("kepala_seksi", kepalaSeksi);
                    break;

                case "rekening_pensiun_baru" :
                    jasperFileName = "DaftarRekeningPensiunBaruYgDibayarkan2";
                    parameters = new HashMap<>();
                    parameters.put("start_date", startDate);
                    parameters.put("end_date", endDate);
                    parameters.put("periode_mutasi", periodeMutasi);
                    parameters.put("id_kategori_pensiun", idKategoriPensiun);
                    parameters.put("kepala_divisi", kepalaDivisi);
                    parameters.put("kepala_seksi", kepalaSeksi);
                    break;

                case "perubahan_rekening_pensiunan" :
                    jasperFileName = "DaftarPerubahanNomorRekening22";
                    parameters = new HashMap<>();
                    parameters.put("start_date", startDate);
                    parameters.put("end_date", endDate);
                    parameters.put("periode_mutasi", periodeMutasi);
                    parameters.put("id_kategori_pensiun", idKategoriPensiun);
                    parameters.put("kepala_divisi", kepalaDivisi);
                    parameters.put("kepala_seksi", kepalaSeksi);
                    break;

                case "cetak_rek_mps_20":
                    jasperFileName = "DaftarRekeningPensiunBaruYgDibayarkan1";
                    parameters = new HashMap<>();
                    parameters.put("start_date", startDate);
                    parameters.put("end_date", endDate);
                    parameters.put("periode_mutasi", periodeMutasi);
                    parameters.put("id_kategori_pensiun", idKategoriPensiun);
                    parameters.put("kepala_divisi", kepalaDivisi);
                    parameters.put("kepala_seksi", kepalaSeksi);
                    break;

                case "cetak_rek_mps_10jt" :
                    jasperFileName = "DaftarRekeningPensiunBaruYgDibayarkanMPS10jt1";
                    parameters = new HashMap<>();
                    parameters.put("start_date", startDate);
                    parameters.put("end_date", endDate);
                    parameters.put("periode_mutasi", periodeMutasi);
                    parameters.put("id_kategori_pensiun", idKategoriPensiun);
                    parameters.put("kepala_divisi", kepalaDivisi);
                    parameters.put("kepala_seksi", kepalaSeksi);
                    break;

                case "cetak_rek_mps100":
                    jasperFileName = "DaftarRekeningPensiunMPS__1_5jt1";
                    parameters = new HashMap<>();
                    parameters.put("start_date", startDate);
                    parameters.put("end_date", endDate);
                    parameters.put("periode_mutasi", periodeMutasi);
                    parameters.put("id_kategori_pensiun", idKategoriPensiun);
                    parameters.put("kepala_divisi", kepalaDivisi);
                    parameters.put("kepala_seksi", kepalaSeksi);
                    break;

                case "cetak_rek_semua":
                    jasperFileName = "DaftarNo_RekMandiriUntukPensiunanBaruDanPerubahan1";
                    parameters = new HashMap<>();
                    parameters.put("start_date", startDate);
                    parameters.put("end_date", endDate);
                    parameters.put("periode_mutasi", periodeMutasi);
                    parameters.put("id_kategori_pensiun", idKategoriPensiun);
                    parameters.put("kepala_divisi", kepalaDivisi);
                    parameters.put("kepala_seksi", kepalaSeksi);
                    break;

                case "cetak_mp_susulan" :
                    jasperFileName = "PembayaranMpSusulanRek";
                    parameters = new HashMap<>();
                    parameters.put("start_date", startDate);
                    parameters.put("end_date", endDate);
                    parameters.put("kepala_divisi", kepalaDivisi);
                    parameters.put("kepala_seksi", kepalaSeksi);
                    break;

                case "cetak_rek_kosong" :
                    jasperFileName = "DaftarPensiunanYgBelumPunyaNo_RekMutasi";
                    parameters = new HashMap<>();
                    parameters.put("periode_mutasi", periodeMutasi);
                    parameters.put("kepala_divisi", kepalaDivisi);
                    parameters.put("kepala_seksi", kepalaSeksi);
                    break;


            }
            if (jasperFileName != null){
                tampilkanReport(httpServletResponse, startDate, download, parameters, jasperFileName);
            }

        }catch(IOException | JRException e){
            e.printStackTrace();
        }

    }

    private void tampilkanReport(HttpServletResponse httpServletResponse, String startDate, Boolean download, Map<String, Object> parameters, String jasperFileName ) throws JRException, IOException {
        try {

            ReportCompiler rc = new ReportCompiler();
            JasperReport jasperReport = rc.compileReport(jasperFileName);
            setReportHeader(httpServletResponse, startDate, jasperFileName, download);
            // Set report
            ReportUtil reportUtil = new ReportUtil(jasperFileName, httpServletResponse.getOutputStream());
            Connection conn = DataSourceUtils.getConnection(dataSource);
            reportUtil.setReport(parameters, conn, new JRPdfExporter());
            SimplePdfReportConfiguration reportConfig = new SimplePdfReportConfiguration();
            reportConfig.setSizePageToContent(true);
            reportConfig.setForceLineBreakPolicy(false);
            reportUtil.getExporter().setConfiguration(reportConfig);
            // write report to output stream
            reportUtil.getExporter().exportReport();
            reportUtil.getOutputStream().flush();
            reportUtil.getOutputStream().close();

        }catch(JRException | IOException | JRRuntimeException e){
            e.printStackTrace();
        }

    }

    private void setReportHeader(HttpServletResponse httpServletResponse, String startDate, String jasperFileName, Boolean download) {
        // Set web response output stream
        MediaType mediaType = MediaType.parseMediaType("application/pdf");
        httpServletResponse.setContentType(mediaType.getType());
        if ((download != null) && (download)) {
            httpServletResponse.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + jasperFileName + "-" + new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + startDate + ".pdf");
        } else {
            httpServletResponse.setHeader(HttpHeaders.CONTENT_TYPE, "application/pdf");
        }
    }


    @GetMapping("/report-proses-data-ppbi-ykkbi")
    public void reportPembayaran(HttpServletResponse httpServletResponse,
                                 @RequestParam("tipeReport") String tipeReport,
                                 @RequestParam("periodeMutasi") String periodeMutasi,
                                 @RequestParam("kepalaDivisi") String kepalaDivisi,
                                 @RequestParam("kepalaSeksi") String kepalaSeksi,
                                 @RequestParam("jenis") String jenis,
                                 @RequestParam(name = "download", required = false) Boolean download){

        String jasperFileName = null;
        HashMap<String, Object> parameters = null;

        try {
            switch (tipeReport){
                case "cetak_proses_ppbi_ykkbi":
                    switch (jenis){
                        case "ppbi" :
                            jasperFileName = "DaftarPengolahanDataBerkalaPPBI1";
                            parameters = new HashMap<>();
                            parameters.put("periode_mutasi", periodeMutasi);
                            parameters.put("kepala_divisi", kepalaDivisi);
                            parameters.put("kepala_seksi", kepalaSeksi);
                            break;
                        case "ykkbi" :
                            jasperFileName = "DaftarPengolahanDataYKKBI1";
                            parameters = new HashMap<>();
                            parameters.put("periode_mutasi", periodeMutasi);
                            parameters.put("kepala_divisi", kepalaDivisi);
                            parameters.put("kepala_seksi", kepalaSeksi);
                            break;
                    }
                    break;
            }
            if (jasperFileName != null){
                tampilkanReportProses(httpServletResponse, periodeMutasi, download, parameters, jasperFileName);
            }

        }catch(IOException | JRException e){
            e.printStackTrace();
        }

    }

    private void tampilkanReportProses(HttpServletResponse httpServletResponse, String periodeMutasi, Boolean download, Map<String, Object> parameters, String jasperFileName ) throws JRException, IOException {
        try {

            ReportCompiler rc = new ReportCompiler();
            JasperReport jasperReport = rc.compileReport(jasperFileName);
            setReportHeaderProses(httpServletResponse, periodeMutasi, jasperFileName, download);
            // Set report
            ReportUtil reportUtil = new ReportUtil(jasperFileName, httpServletResponse.getOutputStream());
            Connection conn = DataSourceUtils.getConnection(dataSource);
            reportUtil.setReport(parameters, conn, new JRXlsxExporter());
            SimpleXlsxExporterConfiguration reportConfig = new SimpleXlsxExporterConfiguration();
            reportConfig.setKeepWorkbookTemplateSheets(true);
            reportConfig.setWorkbookTemplate(String.valueOf(true));
            reportConfig.setMetadataTitle(String.valueOf(true));
            reportConfig.setMetadataApplication(String.valueOf(true));
            reportConfig.setMetadataAuthor(String.valueOf(true));
            reportConfig.setCreateCustomPalette(true);
            reportUtil.getExporter().setConfiguration(reportConfig);
            // write report to output stream
            reportUtil.getExporter().exportReport();
            reportUtil.getOutputStream().flush();
            reportUtil.getOutputStream().close();

        }catch(JRException | IOException | JRRuntimeException e){
            e.printStackTrace();
        }

    }

    private void setReportHeaderProses(HttpServletResponse httpServletResponse, String startDate, String jasperFileName, Boolean download) {
        // Set web response output stream
        MediaType mediaType = MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        httpServletResponse.setContentType(mediaType.getType());
        if ((download != null) && (download)) {
            httpServletResponse.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + jasperFileName + "-" + new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + startDate + ".xlsx");
        } else {
            httpServletResponse.setHeader(HttpHeaders.CONTENT_TYPE, "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        }
    }

}

class UploadInfo extends BaseFormDto {
    private int jumlahData;

    public int getJumlahData() {
        return jumlahData;
    }

    public void setJumlahData(int jumlahData) {
        this.jumlahData = jumlahData;
    }
}