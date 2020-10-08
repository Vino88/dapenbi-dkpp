package com.dapenbi.dkpp.controller.api;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.*;
import com.dapenbi.dkpp.dao.ViewModel.PensLamaMeninggalViewDao;
import com.dapenbi.dkpp.dto.*;
import com.dapenbi.dkpp.dto.ViewModelDto.PensiunLamaMeninggalViewDto;
import com.dapenbi.dkpp.form.*;
import com.dapenbi.dkpp.model.*;
import com.dapenbi.dkpp.model.ViewModel.PensiunLamaMeninggalView;
import com.dapenbi.dkpp.util.*;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping(PathPrefix.API + PathPrefix.MUTASI_SUSUNAN_KELUARGA)
public class MutasiSusunanKeluargaApiController {

    private DataSource dataSource;

    private String idKategoriMutasi;

    @Autowired
    PensLamaMeninggalViewDao pensLamaMeninggalViewDao;

    @Autowired
    MutasiPensiunDao mutasiPensiunDao;

    @Autowired
    SetupParameterDao setupParameterDao;

    @Autowired
    KotaDao kotaDao;

    @Autowired
    AgamaDao agamaDao;

    @Autowired
    ProvinsiDao provinsiDao;

    @Autowired
    KecamatanDao kecamatanDao;

    @Autowired
    KelurahanDao kelurahanDao;

    @Autowired
    MPensiunDao pensiunDao;

    @Autowired
    NegaraDao negaraDao;

    @Autowired
    SuskelDao suskelDao;

    @Autowired
    PesertaDao pesertaDao;

    @Autowired
    MPensiunDao mPensiunDao;

    public MutasiSusunanKeluargaApiController(DataSource dataSource){
        this.dataSource = dataSource;
        this.idKategoriMutasi = "26";
    }

    @GetMapping
    public Page<MutasiPensiunDto> index(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam) {
        String periodeMutasi = setupParameterDao.findByBukaPeriode().getPeriode();
        Page<MutasiPensiun> uIt = mutasiPensiunDao.findByKategoriMutasiAndPeriodeMutasi(idKategoriMutasi, periodeMutasi, searchParam +"%",pageRequest);

                Page<MutasiPensiunDto> result = uIt.map(u -> {
                    MutasiPensiunDto dto = u.toDto();
                    dto.setStatusValidasi(u.getStatusValidasi().toDto());
                    if(u.getKategoryCatatan() != null)
                        dto.setKategoryCatatan(u.getKategoryCatatan().toDto());
                    dto.setKategoriPenerima(u.getKategoriPenerima().toDto());
                    dto.setSuskel((u.getSuskel() != null)?u.getSuskel().toDto():null);
                    dto.setSuskelBaru((u.getSuskelBaru() != null)?u.getSuskelBaru().toDto():null);
            return dto;
        });
        return result;
    }

    @GetMapping("/belum-validasi")
    public Page<MutasiPensiunDto> indexBelumValidasi(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam) {
        String periodeMutasi = setupParameterDao.findByBukaPeriode().getPeriode();
        Page<MutasiPensiun> uIt = mutasiPensiunDao.findByKategoriMutasiAndPeriodeMutasiBelumValidasi(idKategoriMutasi, periodeMutasi, searchParam +"%",pageRequest);

        Page<MutasiPensiunDto> result = uIt.map(u -> {
            MutasiPensiunDto dto = u.toDto();
            dto.setStatusValidasi(u.getStatusValidasi().toDto());
            if(u.getKategoryCatatan() != null)
                dto.setKategoryCatatan(u.getKategoryCatatan().toDto());
            dto.setKategoriPenerima(u.getKategoriPenerima().toDto());
            dto.setSuskel((u.getSuskel() != null)?u.getSuskel().toDto():null);
            dto.setSuskelBaru((u.getSuskelBaru() != null)?u.getSuskelBaru().toDto():null);
            return dto;
        });
        return result;
    }

    @PostMapping("/checksuskel")
    public SuskelDto checksuskel(@ModelAttribute SuskelFormDto suskelFormDto) {
        MPensiun peserta = mPensiunDao.findByNip(suskelFormDto.getNip());
        PesertaFormDto pesertaFormDto = new PesertaFormDto();
        pesertaFormDto.setNip(peserta.getNip());
        if(peserta.getTglMeninggalPeserta() != null) {
            pesertaFormDto.setTglWafat(peserta.getTglMeninggalPeserta().toString());
        }
        if (peserta.getNamaPeserta() !=null){
            pesertaFormDto.setNamaPeserta(peserta.getNamaPeserta());
        }
        if (peserta.getJenisKelaminPeserta() != null){
            pesertaFormDto.setJenisKelamin(peserta.getJenisKelaminPeserta());
        }
        if (peserta.getTglLahirPeserta() != null){
            pesertaFormDto.setTglLahir(peserta.getTglLahirPeserta().toString());
        }
        if (peserta.getTglKerjaPeserta() != null){
            pesertaFormDto.setTglKerja(peserta.getTglKerjaPeserta().toString());
        }
        if (peserta.getTglDhptPeserta() != null){
            pesertaFormDto.setTglPeserta(peserta.getTglDhptPeserta().toString());
        }
        if (peserta.getTglHentiKerjaPeserta() != null){
            pesertaFormDto.setTglHenti(peserta.getTglHentiKerjaPeserta().toString());
        }
        if (peserta.getGolongan().getId() !=null){
            pesertaFormDto.setGolongan(peserta.getGolongan().getId());
        }
        if (peserta.getAgama().getId() != null) {
            pesertaFormDto.setAgama(peserta.getAgama().getId());
        }

        pesertaFormDto.setNpwp("");

        if (peserta.getUpahVeteran()!= null){
            pesertaFormDto.setUpahVeteran(peserta.getUpahVeteran());
        }
        if (peserta.getMasaKerjaVeteran()!=null){
            pesertaFormDto.setMkVeteran(peserta.getMasaKerjaVeteran());
        }
        if (peserta.getAlasanHenti().getId()!=null){
            pesertaFormDto.setAlasanHenti(peserta.getAlasanHenti().getId());
        }
        if (peserta.getPredikatPemberhentian().getId()!=null){
            pesertaFormDto.setPredikatPemberhentian(peserta.getPredikatPemberhentian().getId());
        }
        if (peserta.getNoSkBi()!=null){
            pesertaFormDto.setNoSKBI(peserta.getNoSkBi());
        }
        if (peserta.getTglSkBi()!=null){
            pesertaFormDto.setTglSKBI(peserta.getTglSkBi().toString());
        }
        if (peserta.getAlamatLengkap()!=null){
            pesertaFormDto.setAlamat(peserta.getAlamatLengkap());
        }
        List<KeluargaPesertaFormDto> dataKeluargas = extractkeluarga(suskelFormDto);

        Suskel suskel = new Suskel();
        try {
            suskel = suskelDao.generateSuskel(pesertaFormDto, dataKeluargas);

        } catch (Exception e) {
            e.printStackTrace();
        }

        SuskelDto suskelDto = suskel.toDto();

        return suskelDto;
    }

    @NotNull
    public List<KeluargaPesertaFormDto> extractkeluarga(@ModelAttribute SuskelFormDto formDto) {
        List<KeluargaPesertaFormDto> dataKeluargas = new ArrayList<>();
        if (formDto.getDataKeluarga() != null) {
            for (Map<String, String> keluarga : formDto.getDataKeluarga()) {
                KeluargaPesertaFormDto dataKeluarga = new KeluargaPesertaFormDto();
                if (!keluarga.get("id").startsWith("tmp")) {
                    dataKeluarga.setId(keluarga.get("id"));
                }
                dataKeluarga.setNamaKeluarga(keluarga.get("namaKeluarga"));
                dataKeluarga.setJenisKelamin(keluarga.get("jenisKelamin"));
                try {
                    dataKeluarga.setIdKategoriPenerima(Long.valueOf(keluarga.get("idKategoriPenerima")));
                    dataKeluarga.setTanggalLahir(DateUtil.stringToDate(keluarga.get("tglLahir")));
                    dataKeluarga.setTanggalMenikah(DateUtil.stringToDate(keluarga.get("tglMenikah")));
                    dataKeluarga.setTanggalCerai(DateUtil.stringToDate(keluarga.get("tglCerai")));
                    dataKeluarga.setTanggalWafat(DateUtil.stringToDate(keluarga.get("tglWafat")));
                    dataKeluarga.setTanggalUsia25(DateUtil.stringToDate(keluarga.get("tglUsia25")));
                    dataKeluarga.setStatusKawin(Long.valueOf(keluarga.get("statusKawin")));
                }catch (Exception ex) {

                }
                dataKeluargas.add(dataKeluarga);
            }
        }
        return dataKeluargas;
    }

    @PostMapping("/spmutasisuskel")
    public ResponseEntity<MessageUtil>createMutasiSusunanKeluarga(@ModelAttribute MutasiSuskelPlainTextFormDto plainSuskelDto){
        DkppUserDetail user = DkppUserStamp.getUserPrincipal();
        RoleDto role = user.getUser().getRoles().get(0);
        MutasiSuskelFormDto spDto = new MutasiSuskelFormDto();
        spDto.setRoleId(role.getId());
        spDto.fromPlainText(plainSuskelDto);
        Map result = mutasiPensiunDao.spMutasiSuskel(spDto);

        MessageUtil messageUtil;
        HttpStatus httpStatus;
        if (result.get("PAR_STATUS_EKSEKUSI").equals('1')) {
            spDto.setIdMutasiPensiun(Long.valueOf(result.get("PAR_ID_MUTASI_PENSIUN_VAL").toString()));
            messageUtil = new MessageUtil("success", "Data berhasil diubah.", spDto);
            httpStatus = HttpStatus.OK;
        } else {
            messageUtil = new MessageUtil("failed", result.get("PAR_MSG").toString(), spDto);
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<MessageUtil>(messageUtil, httpStatus);
    }

    @PostMapping("/spmutasisuskeldatakeluarga")
    public ResponseEntity<MessageUtil>createMutasiSusunanKeluargaDataKeluarga(@ModelAttribute MutasiSuskelDataKeluargaPtFormDto plainDtKel){
         MutasiSuskelDataKeluargaFormDto spDto = new MutasiSuskelDataKeluargaFormDto();
         spDto.fromPlainText(plainDtKel);
         Map result = mutasiPensiunDao.spMutasiSuskelDataKeluarga(spDto);

         MessageUtil messageUtil;
         HttpStatus httpStatus;
        if (result.get("PAR_STATUS_EKSEKUSI").equals("1")) {
            messageUtil = new MessageUtil("success", "Data berhasil diubah.", spDto);
            httpStatus = HttpStatus.OK;
        } else {
            messageUtil = new MessageUtil("failed", result.get("PAR_MSG").toString(), spDto);
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<MessageUtil>(messageUtil, httpStatus);
    }

    @GetMapping("/report")
    public void reportMutasiSuskel(HttpServletResponse httpServletResponse, @RequestParam("tipeReport") String tipeReport, @RequestParam("nip") String nip, @RequestParam("periodeMutasi") String periodeMutasi, @RequestParam("idKategoriMutasi") String idKategoriMutasi, @RequestParam(name = "download", required = false) Boolean download){
        String jasperFileName = null;
        String subReport = null;
        HashMap<String, Object> parameters = null;

        try {

                switch (tipeReport){
                    case "formulir_entry_mutasi" :
                        jasperFileName = "EntryMutasiSusKel";
                        parameters = new HashMap<>();
                        parameters.put("nip", nip);
                        parameters.put("periode_mutasi", periodeMutasi);
                        parameters.put("id_kategori_mutasi", "26");
                        break;
                }
                if (jasperFileName != null){
                    createReport(httpServletResponse, nip, download, parameters, jasperFileName, subReport);
                }

        }catch(IOException | JRException e){
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
