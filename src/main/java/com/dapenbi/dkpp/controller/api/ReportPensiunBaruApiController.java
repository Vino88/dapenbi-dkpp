package com.dapenbi.dkpp.controller.api;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.KantorBayarDao;
import com.dapenbi.dkpp.dao.SetupParameterDao;
import com.dapenbi.dkpp.dto.KantorBayarDto;
import com.dapenbi.dkpp.form.KantorBayarFormDto;
import com.dapenbi.dkpp.model.KantorBayar;
import com.dapenbi.dkpp.util.ReportCompiler;
import com.dapenbi.dkpp.util.ReportUtil;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JRDesignSortField;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.type.SortFieldTypeEnum;
import net.sf.jasperreports.engine.type.SortOrderEnum;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping(PathPrefix.API + PathPrefix.REPORT_MUTASI_PENSIUN_BARU)
public class ReportPensiunBaruApiController {

    private DataSource dataSource;
    KantorBayarDao kantorBayarDao;
    private SetupParameterDao setupParameterDao;

    @Autowired
    public ReportPensiunBaruApiController(DataSource dataSource, KantorBayarDao kantorBayarDao, SetupParameterDao setupParameterDao) {
        this.dataSource = dataSource;
        this.kantorBayarDao = kantorBayarDao;
        this.setupParameterDao = setupParameterDao;
    }

    private KantorBayarDto getKantorBayarDto(KantorBayarFormDto kantorBayarFormDto) {
        KantorBayar kantor = new KantorBayar();

        kantor.setId(kantorBayarFormDto.getId());
        return kantorBayarDao.save(kantor).toDto();
    }

    @GetMapping("/report-mutasi-pensiun-baru")
    public void report(HttpServletResponse httpServletResponse, @RequestParam("periodeMutasi") String periodeMutasi, @RequestParam("idKantorBayar") String idKantorBayar, @RequestParam("idKategoriPensiun") String idKategoriPensiun, @RequestParam("idJenisMps") String idJenisMps, @RequestParam("idKategoriPenerimaMP") String idKategoriPenerimaMP, @RequestParam("tipeReport") String tipeReport, @RequestParam("nip") String nip, @RequestParam("tglHenti") String tglHenti, @RequestParam(name = "download", required = false) Boolean download) {
        String jasperFileName = null;
        HashMap<String, Object> parameters = null;
        Locale locale = new Locale("en", "IN");

        try {

            switch (tipeReport) {
                case "01":
                    jasperFileName = "DaftarRegistrasiPensiunBaru";
                    parameters = new HashMap<>();
                    parameters.put("periode_mutasi", periodeMutasi);

                    break;



                case "02":
                    switch (idKategoriPensiun) {
                        case "PN":

                            jasperFileName = "DaftarRincianPenerimaMPNormal_DenganMPS20persen";
                            parameters = new HashMap<>();
                            parameters.put(JRParameter.REPORT_LOCALE, locale);
                            parameters.put("periode_mutasi", periodeMutasi);
                            parameters.put("id_kantor_bayar", idKantorBayar);
                            parameters.put("id_kategori_pensiun", idKategoriPensiun);
                            parameters.put("id_jenis_mps", "1");

                            break;

                        case "PD":
                            jasperFileName = "DaftarRincianPenerimaMPDipercepat_DenganMPS20persen";
                            parameters = new HashMap<>();
                            parameters.put("periode_mutasi", periodeMutasi);
                            parameters.put("id_kantor_bayar", idKantorBayar);
                            parameters.put("id_kategori_pensiun", idKategoriPensiun);
                            parameters.put("id_jenis_mps", "1");

                            break;

                        case "PC":

                                    jasperFileName = "DaftarRincianPenerimaMPCacat_DenganMPS20persen";
                                    parameters = new HashMap<>();
                                    parameters.put("periode_mutasi", periodeMutasi);
                                    parameters.put("id_kantor_bayar", idKantorBayar);
                                    parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                    parameters.put("id_jenis_mps", "1");

                                    break;

                        case "PM" :

                            jasperFileName = "DaftarRincianPenerimaMPJandaDudaAnak_DenganMPS20persen";
                            parameters = new HashMap<>();
                            parameters.put("periode_mutasi", periodeMutasi);
                            parameters.put("id_kategori_pensiun", "PM");
                            parameters.put("id_kantor_bayar", idKantorBayar);
                            parameters.put("id_jenis_mps", "1");
                            break;
                    }

                break;

                case "03":
                    switch (idKategoriPensiun) {
                        case "PN":

                            jasperFileName = "RekapitulasiMPS20persen_PensiunNormal";
                            parameters = new HashMap<>();
                            parameters.put("periode_mutasi", periodeMutasi);
                            parameters.put("id_kategori_pensiun", idKategoriPensiun);
                            parameters.put("id_kantor_bayar", idKantorBayar);
                            parameters.put("id_jenis_mps", "1");

                            break;

                        case "PD":
                            jasperFileName = "RekapitulasiMPS20persen_PensiunDipercepat";
                            parameters = new HashMap<>();
                            parameters.put("periode_mutasi", periodeMutasi);
                            parameters.put("id_kategori_pensiun", idKategoriPensiun);
                            parameters.put("id_kantor_bayar", idKantorBayar);
                            parameters.put("id_jenis_mps", "1");

                            break;

                        case "PC":

                                    jasperFileName = "RekapitulasiMPS20persen_PensiunCacat";
                                    parameters = new HashMap<>();
                                    parameters.put("periode_mutasi", periodeMutasi);
                                    parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                    parameters.put("id_kantor_bayar", idKantorBayar);
                                    parameters.put("id_jenis_mps", "1");

                                    break;

                        case "PM" :

                            jasperFileName = "RekapitulasiMPS20persen_PensiunJandaDudaAnakLangsung";
                            parameters = new HashMap<>();
                            parameters.put("periode_mutasi", periodeMutasi);
                            parameters.put("id_kategori_pensiun", "PM");
                            parameters.put("id_kantor_bayar", idKantorBayar);
                            parameters.put("id_jenis_mps", "1");

                    }
                    break;


                case "04":

                    switch (idKategoriPensiun) {
                        case "PN":

                            jasperFileName = "DaftarRincianPenerimaMPNormal_DenganMPS10juta";
                            parameters = new HashMap<>();
                            parameters.put("periode_mutasi", periodeMutasi);
                            parameters.put("id_kategori_pensiun", idKategoriPensiun);
                            parameters.put("id_kantor_bayar", idKantorBayar);
                            parameters.put("id_jenis_mps", "2");

                            break;


                        case "PD":

                            jasperFileName = "DaftarRincianPenerimaMPDipercepat_DenganMPS10Jt";
                            parameters = new HashMap<>();
                            parameters.put("periode_mutasi", periodeMutasi);
                            parameters.put("id_kategori_pensiun", idKategoriPensiun);
                            parameters.put("id_kantor_bayar", idKantorBayar);
                            parameters.put("id_jenis_mps", "2");

                            break;


                        case "PC":

                            jasperFileName = "DaftarRincianPenerimaMPCacat_DenganMPS10Jt";
                            parameters = new HashMap<>();
                            parameters.put("periode_mutasi", periodeMutasi);
                            parameters.put("id_kategori_pensiun", idKategoriPensiun);
                            parameters.put("id_kantor_bayar", idKantorBayar);
                            parameters.put("id_jenis_mps", "2");

                            break;


                        case "PM" :

                            jasperFileName = "DaftarRincianPenerimaMPJandaDudaAnak_DenganMPS10Jt";
                            parameters = new HashMap<>();
                            parameters.put("periode_mutasi", periodeMutasi);
                            parameters.put("id_kategori_pensiun", "PM");
                            parameters.put("id_kantor_bayar", idKantorBayar);
                            parameters.put("id_jenis_mps", "2");

                        break;

                    }
                    break;


                case "05":
                    switch (idKategoriPensiun) {
                        case "PN":
                            jasperFileName = "RekapitulasiMPS10Jt_PensiunNormal";
                            parameters = new HashMap<>();
                            parameters.put("periode_mutasi", periodeMutasi);
                            parameters.put("id_kategori_pensiun", idKategoriPensiun);
                            parameters.put("id_kantor_bayar", idKantorBayar);
                            parameters.put("id_jenis_mps", "2");

                            break;


                        case "PD":
                            jasperFileName = "RekapitulasiMPS10Jt_PensiunDipercepat";
                            parameters = new HashMap<>();
                            parameters.put("periode_mutasi", periodeMutasi);
                            parameters.put("id_kategori_pensiun", idKategoriPensiun);
                            parameters.put("id_kantor_bayar", idKantorBayar);
                            parameters.put("id_jenis_mps", "2");

                            break;


                        case "PC":

                            jasperFileName = "RekapitulasiMPS10Jt_PensiunCacat";
                            parameters = new HashMap<>();
                            parameters.put("periode_mutasi", periodeMutasi);
                            parameters.put("id_kategori_pensiun", idKategoriPensiun);
                            parameters.put("id_kantor_bayar", idKantorBayar);
                            parameters.put("id_jenis_mps", "2");

                            break;


                        case "PM":

                            jasperFileName = "RekapitulasiMPS10Jt_PensiunJandaDudaAnakLangsung";
                            parameters = new HashMap<>();
                            parameters.put("periode_mutasi", periodeMutasi);
                            parameters.put("id_kategori_pensiun", "PM");
                            parameters.put("id_kantor_bayar", idKantorBayar);
                            parameters.put("id_jenis_mps", "2");
                            break;


                    }
                    break;


                case "06":

                    switch (idJenisMps) {

                        case "1":

                            jasperFileName = "rekap_manfaat_pensiun";
                            parameters = new HashMap<>();
                            parameters.put("periode_mutasi", periodeMutasi);
                            parameters.put("id_kategori_pensiun", idKategoriPensiun);
                            parameters.put("id_jenis_mps", idJenisMps);
                            parameters.put("nip",nip);

                            break;


                        case "2":
                            jasperFileName = "rekap_manfaat_pensiun10jt";
                            parameters = new HashMap<>();
                            parameters.put("periode_mutasi", periodeMutasi);
                            parameters.put("id_kategori_pensiun", idKategoriPensiun);
                            parameters.put("id_jenis_mps", idJenisMps);
                            parameters.put("nip", nip);
                            break;

                    }
                    break;


                case "07":
                    jasperFileName = "Rekapitulasi_MUTASI_PensiunBaru_B1";
                    parameters = new HashMap<>();
                    parameters.put("periode_mutasi", periodeMutasi);
                    break;



                case "08":
                    jasperFileName = "Daftar_Mutasi_Master_PensiunBI";
                    parameters = new HashMap<>();
                    List<JRSortField> sortList = new ArrayList<JRSortField>();
                    JRDesignSortField sortField = new JRDesignSortField();
                    sortField.setName("NIP");
                    sortField.setOrder(SortOrderEnum.ASCENDING);
                    sortList.add(sortField);
                    parameters.put(JRParameter.SORT_FIELDS, sortList);
                    parameters.put("periode_mutasi", periodeMutasi);
                    break;

                case "09":
                    jasperFileName = "RekaputilasiKurangBayarManfaatPensiun";
                    parameters = new HashMap<>();
                    parameters.put("PERIODE_MUTASI", periodeMutasi);
                    parameters.put("id_kantor_bayar", idKantorBayar);
                    break;

                case "010":

                    jasperFileName = "RekaputilasiLebihBayarManfaatPensiun";
                    parameters = new HashMap<>();
                    parameters.put("PERIODE_MUTASI", periodeMutasi);
                    parameters.put("id_kantor_bayar", idKantorBayar);
                    break;


                case "011":

                    jasperFileName = "RinciangKurangBayarManfaatPensiun";
                    parameters = new HashMap<>();
                    parameters.put("PERIODE_MUTASI", periodeMutasi);
                    parameters.put("ID_KANTOR_BAYAR", idKantorBayar);

                    break;


                case "012":

                    jasperFileName = "RinciangLebihBayarManfaatPensiun";
                    parameters = new HashMap<>();
                    parameters.put("PERIODE_MUTASI", periodeMutasi);
                    parameters.put("id_kantor_bayar", idKantorBayar);

                    break;


                case "013":

                    jasperFileName = "DaftarMutasiManfaatPensiunSekaligus";
                    parameters = new HashMap<>();
                    parameters.put("periode_mutasi", periodeMutasi);
                    parameters.put("id_kantor_bayar", idKantorBayar);
                    break;

                //Report Pensiun Tunda Jatuh Tempo

                case "11":

                    jasperFileName = "Rekapitulasi_MUTASI_PensiunTundaJatuhTempo_B2";
                    parameters = new HashMap<>();
                    parameters.put("periode_mutasi", periodeMutasi);
                    break;

                case "12":

                    jasperFileName = "RekapitulasiMPS20persen_PensiunTundaJatuhTempo";
                    parameters = new HashMap<>();
                    parameters.put("periode_mutasi", periodeMutasi);
                    parameters.put("id_kategori_pensiun", "PT");
                    parameters.put("id_jenis_mps", "1");
                    parameters.put("id_kantor_bayar", idKantorBayar);
                    break;

                case "13":

                    jasperFileName = "DaftarRincianPenerimaMPTundaJatuhTempo_MPS20persen";
                    parameters = new HashMap<>();
                    parameters.put("periode_mutasi", periodeMutasi);
                    parameters.put("id_kategori_pensiun", "PT");
                    parameters.put("id_jenis_mps", "1");
                    parameters.put("id_kantor_bayar", idKantorBayar);
                    break;

                case "14":

                    jasperFileName = "RekapitulasiMPS10Jt_PensiunTundaJatuhTempo";
                    parameters = new HashMap<>();
                    parameters.put("periode_mutasi", periodeMutasi);
                    parameters.put("id_kategori_pensiun", "PT");
                    parameters.put("id_kantor_bayar", idKantorBayar);
                    break;

                case "15":

                    jasperFileName = "DaftarRincianPenerimaMPTundaJatuhTempo_MPS10Jt";
                    parameters = new HashMap<>();
                    parameters.put("periode_mutasi", periodeMutasi);
                    parameters.put("id_kategori_pensiun", "PT");
                    parameters.put("id_kantor_bayar", idKantorBayar);
                    break;


                case "16" :

                    jasperFileName = "DaftarRegistrasiPensiunTundaJatuhTempo";
                    parameters = new HashMap<>();
                    parameters.put("periode_mutasi", periodeMutasi);
                    parameters.put("id_kategori_pensiun", "PT");
                    parameters.put("id_kantor_bayar", idKantorBayar);
                    break;

                case "17" :
                    jasperFileName = "SuratDaftarPengirimanSK";
                    parameters = new HashMap<>();
                    parameters.put("periode_mutasi", periodeMutasi);
                    break;

                // Laporan Phdp / Merit Increase

                case "21" :
                    jasperFileName = "Rekapitulasi_MUTASI_RAPEL_MP_KarenaPerubahanPhDP(MI)_B5";
                    parameters = new HashMap<>();
                    parameters.put("periode_mutasi", periodeMutasi);
                    break;


                case "22" :
                    jasperFileName = "Rekapitulasi_MUTASI_RAPEL_MP_KarenaPerubahanPhDP_BULAN_SEKARANG(MI)_B6";
                    parameters = new HashMap<>();
                    parameters.put("periode_mutasi", periodeMutasi);
                    break;

                case "23" :
                    jasperFileName = "Rekapitulasi_MUTASI_RAPEL_MP_KarenaPerubahanPhDP_BulanLalu_J";
                    parameters = new HashMap<>();
                    parameters.put("periode_mutasi", periodeMutasi);
                    break;


                case "24":

                    jasperFileName = "DaftarRincianPembayaranMPS20PersenMI";
                    parameters = new HashMap<>();
                    parameters.put("periode_mutasi", periodeMutasi);
                    parameters.put("id_kantor_bayar", idKantorBayar);
                    parameters.put("tgl_henti", tglHenti);
                    break;



                case "25":

                    jasperFileName = "DaftarRincianPembayaranMPS10jtMI";
                    parameters = new HashMap<>();
                    parameters.put("periode_mutasi", periodeMutasi);
                    parameters.put("id_kantor_bayar", idKantorBayar);
                    parameters.put("tgl_henti", tglHenti);

                    break;


                case "26":

                    jasperFileName = "RekapitulasiRapelMP20persenMI";
                    parameters = new HashMap<>();
                    parameters.put("periode_mutasi", periodeMutasi);
                    parameters.put("id_kantor_bayar", idKantorBayar);
                    parameters.put("tgl_henti", tglHenti);

                    break;


                case "27":

                    jasperFileName = "RekapitulasiRapelMP10jtMI";
                    parameters = new HashMap<>();
                    parameters.put("periode_mutasi", periodeMutasi);
                    parameters.put("id_kantor_bayar", idKantorBayar);
                    parameters.put("tgl_henti", tglHenti);

                    break;


                case "28":

                    jasperFileName = "DaftarMutasiRapelManfaatPensiun100";
                    parameters = new HashMap<>();
                    parameters.put("periode_mutasi", periodeMutasi);

                    break;

            }
            if (jasperFileName != null) {
                createReport(httpServletResponse, periodeMutasi, download, parameters, jasperFileName);
            }
        } catch (IOException | JRException e1) {
            e1.printStackTrace();
        }
    }

    private void createReport(HttpServletResponse httpServletResponse, String periodeMutasi, Boolean download, Map<String, Object> parameters, String jasperFileName ) throws JRException, IOException {
        try {
            ReportCompiler rc = new ReportCompiler();
            JasperReport jasperReport = rc.compileReport(jasperFileName);
            setReportHeader(httpServletResponse, periodeMutasi, jasperFileName, download);
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
        } catch (JRException | IOException | JRRuntimeException | NullPointerException e) {
            e.printStackTrace();
        }
    }
    private void setReportHeader(HttpServletResponse httpServletResponse, String periodeMutasi, String jasperFileName, Boolean download) {
        // Set web response output stream
        try {

            MediaType mediaType = MediaType.parseMediaType("application/pdf");
            httpServletResponse.setContentType(mediaType.getType());
            if ((download != null) && (download)) {
                httpServletResponse.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + jasperFileName + "-" + new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + periodeMutasi + ".pdf");
            } else {
                httpServletResponse.setHeader(HttpHeaders.CONTENT_TYPE, "application/pdf");
            }

        }catch(JRRuntimeException | NullPointerException ex){
            ex.printStackTrace();
        }
    }
}