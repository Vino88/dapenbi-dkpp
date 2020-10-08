package com.dapenbi.dkpp.controller.api;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.util.ReportCompiler;
import com.dapenbi.dkpp.util.ReportUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JRRuntimeException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;
import org.apache.xmlbeans.impl.jam.internal.javadoc.JavadocClassloadingException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@RestController
@RequestMapping(PathPrefix.API + PathPrefix.REPORT_PENSIUN_LAMA)
public class ReportPensiunLamaApiController {
    private DataSource dataSource;

    public ReportPensiunLamaApiController(DataSource dataSource){
        this.dataSource = dataSource;
    }


    @GetMapping("/report-pensiun-lama")
    public void reportPensiunLama(HttpServletResponse httpServletResponse,@RequestParam("periode_x") String periode_x, @RequestParam("periode_y") String periode_y, @RequestParam("periodeMutasi") String periodeMutasi, @RequestParam("idKantorBayar") String idKantorBayar, @RequestParam("idKategoriPensiun") String idKategoriPensiun, @RequestParam("idJenisMps") String idJenisMps, @RequestParam("tipeReport") String tipeReport, @RequestParam("nip") String nip, @RequestParam(name = "download", required = false) Boolean download){

        String jasperFileName = null;
        HashMap<String, Object> parameters = null;
        Locale locale = new Locale("id", "ID");

        try {

            switch (tipeReport) {

                case "01" :
                    jasperFileName = "MutasiPensiunHapusKarenaMeninggalDunia_D1";
                    parameters = new HashMap<>();
                    parameters.put("periode_mutasi", periodeMutasi);
                    break;


                case "02" :
                    jasperFileName = "MutasiPensiunHapusKarenaMPS_1_5_D2";
                    parameters = new HashMap<>();
                    parameters.put("periode_mutasi", periodeMutasi);
                    break;


                case "03" :
                    jasperFileName = "MutasiMpJandaDudaAnak_E";
                    parameters = new HashMap<>();
                    parameters.put("periode_mutasi", periodeMutasi);
                    break;


                case "04":
                    jasperFileName = "DaftarPenerimaMP_dimutasikanHapus";
                    parameters = new HashMap<>();
                    parameters.put("periode_mutasi", periodeMutasi);
                    parameters.put("id_kantor_bayar", idKantorBayar);
                    break;


                case "05":

                    jasperFileName = "DaftarRincianPenerimaMP_YgDimutasikanHapus";
                    parameters = new HashMap<>();
                    parameters.put("periode_x", periode_x);
                    parameters.put("periode_y", periode_y);
                    break;

                case "06":
                    jasperFileName = "RekakpitulasiPenerimaMP_YgDimutasikanHapus";
                    parameters = new HashMap<>();
                    parameters.put("periode_x", periode_x);
                    parameters.put("periode_y", periode_y);

                    break;

                case "07":

                    jasperFileName = "DaftarMutasiPenerimaJandaDuda";
                    parameters = new HashMap<>();
                    parameters.put("periode_mutasi", periodeMutasi);
                    parameters.put("id_kantor_bayar", idKantorBayar);

                    break;

                case "08" :

                    jasperFileName = "RekapitulasiPenerimaMP_JandaDudaAnak";
                    parameters = new HashMap<>();
                    parameters.put("periode_x", periode_x);
                    parameters.put("periode_y", periode_y);
                    parameters.put("id_kantor_bayar", idKantorBayar);
                break;

                case "09":

                    jasperFileName = "RincianPenerimaMP_JandaDudaAnak";
                    parameters = new HashMap<>();
                    parameters.put("periode_x", periode_x);
                    parameters.put("periode_y", periode_y);

                    break;


                case "010":
                    jasperFileName = "DaftarKelengkapanDokumenPenerimaJandaDudaAnak";
                    parameters = new HashMap<>();
                    parameters.put("nip", nip);

                    break;

                case "011":

                    jasperFileName = "DaftarMutasiPenerimaMP_Anak_JandaDudaMenikahLagi";
                    parameters = new HashMap<>();
                    parameters.put("periode_mutasi", periodeMutasi);
                    parameters.put("id_kategori_pensiun", idKategoriPensiun);
                    parameters.put("id_kantor_bayar", idKantorBayar);

                    break;

                case "012" :

                    jasperFileName = "DaftarMutasiPenerimaMP_Anak_JandaDudaMeninggalDunia";
                    parameters = new HashMap<>();
                    parameters.put("periode_mutasi", periodeMutasi);
                    parameters.put("id_kantor_bayar", idKantorBayar);

                    break;


                case "013":

                    jasperFileName = "DaftarMutasiPenerimaMP_Anak_PesertaMeninggalDunia";
                    parameters = new HashMap<>();
                    parameters.put("periode_mutasi", periodeMutasi);
                    parameters.put("id_kantor_bayar", idKantorBayar);

                    break;


                case "014":

                    jasperFileName = "DaftarMutasiManfaatPensiunSekaligus";
                    parameters = new HashMap<>();
                    parameters.put("periode_mutasi", periodeMutasi);
                    parameters.put("id_kantor_bayar", idKantorBayar);

                    break;


                case "015":

                    jasperFileName = "DaftarPembayaranMPS100persen";
                    parameters = new HashMap<>();
                    parameters.put("periode_mutasi", periodeMutasi);
                    parameters.put("id_kantor_bayar", idKantorBayar);

                    break;


                case "016" :

                    jasperFileName = "RekapitulasiMPS100persen";
                    parameters = new HashMap<>();
                    parameters.put("periode_mutasi", periodeMutasi);
                    parameters.put("id_kantor_bayar", idKantorBayar);

                    break;


                case "017":

                    jasperFileName = "DaftarMutasi80persen_bulan_ke_13";
                    parameters = new HashMap<>();
                    parameters.put("periode_mutasi", periodeMutasi);
                    parameters.put("id_kantor_bayar", idKantorBayar);

                    break;


                case "018":
                    jasperFileName = "DaftarMutasiSuskel";
                    parameters = new HashMap<>();
                    parameters.put("periode_mutasi", periodeMutasi);
                    parameters.put("id_kategori_mutasi", "26");

                    break;


                case "019":

                    jasperFileName = "LaporanDaftarMutasiSuskelAnak25th";
                    parameters = new HashMap<>();
                    parameters.put("periode_mutasi", periodeMutasi);
                    parameters.put("id_kategori_mutasi", "26");

                    break;


                case "020":

                    jasperFileName = "DaftarMutasiPerubahanNamaPenerima";
                    parameters = new HashMap<>();
                    parameters.put("periode_mutasi", periodeMutasi);
                    parameters.put("id_kategori_mutasi", "24");

                    break;


                case "021":
                    jasperFileName = "DaftarMutasiKantorBayar";
                    parameters = new HashMap<>();
                    parameters.put("periode_mutasi", periodeMutasi);
                    break;


                case "022":

                    jasperFileName = "DaftarPensiunanPesertaOlahraga";
                    parameters = new HashMap<>();
                    parameters.put("periode_mutasi", periodeMutasi);

                    break;


                case "023":

                    jasperFileName = "DaftarPotonganPGA";
                    parameters = new HashMap<>();
                    parameters.put("periode_mutasi", periodeMutasi);

                    break;


                case "024":

                    jasperFileName = "DaftarPotonganVeteran_KOVETRI";
                    parameters = new HashMap<>();
                    parameters.put("periode_mutasi", periodeMutasi);

                    break;


                case "025":

                    jasperFileName = "DataHasil_Iuran_Olahraga";
                    parameters = new HashMap<>();
                    parameters.put("periode_mutasi", periodeMutasi);

                    break;


                case "026":

                    jasperFileName = "DataHasil_IuranPGA";
                    parameters = new HashMap<>();
                    parameters.put("periode_mutasi", periodeMutasi);

                    break;


                case "027":

                    jasperFileName = "DataHasil_IuranKovetri";
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
        } catch (IOException | JRException | JRRuntimeException | NullPointerException e) {
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

        }catch (JRRuntimeException | NullPointerException | JavadocClassloadingException ex){
            ex.printStackTrace();
        }
    }
}
