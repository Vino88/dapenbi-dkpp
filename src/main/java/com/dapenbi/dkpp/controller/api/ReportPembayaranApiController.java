package com.dapenbi.dkpp.controller.api;


import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.util.ReportCompiler;
import com.dapenbi.dkpp.util.ReportUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRRuntimeException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;
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
import java.util.Map;

@RestController
@RequestMapping(PathPrefix.API + PathPrefix.LAPORAN_PEMBAYARAN)
public class ReportPembayaranApiController {

    DataSource dataSource;

    public ReportPembayaranApiController(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @GetMapping("/report-pembayaran")
    public void reportPembayaran(HttpServletResponse httpServletResponse,
                                 @RequestParam("tipeReport") String tipeReport,
                                 @RequestParam("periodeMutasi") String periodeMutasi,
                                 @RequestParam("idKategoriPensiun") String idKategoriPensiun,
                                 @RequestParam("idKantorBayar") String idKantorBayar,
                                 @RequestParam("idJenisMps") String idJenisMps,
                                 @RequestParam("nip") String nip,
                                 @RequestParam("startDate") String startDate,
                                 @RequestParam("endDate") String endDate,
                                 @RequestParam("type") String type,
                                 @RequestParam("statusHer") String statusHer,
                                 @RequestParam("tglHenti") String tglHenti,
                                 @RequestParam("tahun") String tahun,
                                 @RequestParam("kantorPusat") String kantorPusat,
                                 @RequestParam(name = "download", required = false) Boolean download){

        String jasperFileName = null;
        HashMap<String, Object> parameters = null;

        try {
                switch (tipeReport){
                    case "01" :
                        jasperFileName = "RekapMutasiBulanan_A4";
                        parameters = new HashMap<>();
                        parameters.put("periode_mutasi", periodeMutasi);
                        break;

                    case "02" :
                        jasperFileName = "rekap_pembayaran_pajak_atas_MP";
                        parameters = new HashMap<>();
                        parameters.put("periode_pembayaran", periodeMutasi);
                        break;

                    case "03" :
                        jasperFileName = "DaftarPenghasilanPensiun";
                        parameters = new HashMap<>();
                        parameters.put("periode_pembayaran", periodeMutasi);
                        parameters.put("id_kantor_bayar", idKantorBayar);
                        break;

                    case "04" :
                        jasperFileName = "RekapitulasiPembayaranManfaatPensiunBulananSeluruhCabang";
                        parameters = new HashMap<>();
                        parameters.put("periode_pembayaran", periodeMutasi);
                        break;

                    case "05" :
                        jasperFileName = "DaftarPembayaranPenghasilanPensiun";
                        parameters = new HashMap<>();
                        parameters.put("periode_pembayaran", periodeMutasi);
                        parameters.put("id_kantor_bayar", idKantorBayar);
                        break;

                    case "06" :
                        jasperFileName = "DaftarPajakManfaatPensiun";
                        parameters = new HashMap<>();
                        parameters.put("periode_pembayaran", periodeMutasi);
                        parameters.put("id_kantor_bayar", idKantorBayar);
                        break;

                    case "07" :
                        jasperFileName = "RekapitulasiPembayaranManfaatPensiunYgBelumHerRegistrasi";
                        parameters = new HashMap<>();
                        parameters.put("periode_pembayaran", periodeMutasi);
                        parameters.put("id_kantor_bayar", idKantorBayar);
                        parameters.put("status_her_desc", statusHer);
                        break;

                    case "08" :
                        jasperFileName = "DaftarPensiunanYgDibayarkanDiKantorDapenbi";
                        parameters = new HashMap<>();
                        parameters.put("periode_pembayaran", periodeMutasi);
                        parameters.put("id_kantor_bayar", idKantorBayar);
                        break;

                    case "09" :
                        switch (idJenisMps){
                            case "1" :
                                jasperFileName = "RekapitulasiPembayaranManfaatPensiunMPS20";
                                parameters = new HashMap<>();
                                parameters.put("periode_pembayaran", periodeMutasi);
                                parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                break;

                            case "2" :
                                jasperFileName = "RekapitulasiPembayaranManfaatPensiunMPS10jt";
                                parameters = new HashMap<>();
                                parameters.put("periode_pembayaran", periodeMutasi);
                                parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                break;
                        }
                        break;

                    case "010" :
                        switch (idJenisMps){
                            case "1" :
                                jasperFileName = "RincianPembayaranMPS20persen";
                                parameters = new HashMap<>();
                                parameters.put("periode_mutasi", periodeMutasi);
                                parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                parameters.put("id_kantor_bayar", idKantorBayar);
                                break;

                            case "2" :
                                jasperFileName = "RincianPembayaranMPS10jt";
                                parameters = new HashMap<>();
                                parameters.put("periode_mutasi", periodeMutasi);
                                parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                parameters.put("id_kantor_bayar", idKantorBayar);
                                break;
                        }
                        break;

                    case "011" :
                        switch (idJenisMps){
                            case "1" :
                                jasperFileName = "RekapPembayaranMPS20persenAll";
                                parameters = new HashMap<>();
                                parameters.put("periode_mutasi", periodeMutasi);
                                parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                parameters.put("id_kantor_bayar", idKantorBayar);
                                break;

                            case "2" :
                                jasperFileName = "RekapPembayaranMPS10jtAll" ;
                                parameters = new HashMap<>();
                                parameters.put("periode_mutasi", periodeMutasi);
                                parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                parameters.put("id_kantor_bayar", idKantorBayar);
                                break;

                        }
                        break;

                    case "012" :
                        jasperFileName = "RincianPenerimaMPNormal_DenganMPS20persen";
                        parameters = new HashMap<>();
                        parameters.put("periode_mutasi", periodeMutasi);
                        parameters.put("id_kategori_pensiun", idKategoriPensiun);
                        parameters.put("id_kantor_bayar", idKantorBayar);
                        break;

                    case "013" :
                        jasperFileName = "RincianPenerimaMPNormal_DenganMPS10juta";
                        parameters = new HashMap<>();
                        parameters.put("periode_mutasi", periodeMutasi);
                        parameters.put("id_kategori_pensiun", idKategoriPensiun);
                        parameters.put("id_kantor_bayar", idKantorBayar);
                        break;

                    case "014" :
                        switch (idJenisMps){
                            case "1" :
                                jasperFileName = "RekapitulasiPembayaranRapelMPS20_MI";
                                parameters = new HashMap<>();
                                parameters.put("periode_mutasi", periodeMutasi);
                                parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                break;
                            case "2" :
                                jasperFileName = "RekapitulasiPembayaranRapelMPS10jt_MI";
                                parameters = new HashMap<>();
                                parameters.put("periode_mutasi", periodeMutasi);
                                parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                break;
                        }
                        break;

                    case "Daftar Penerima Rapel MPS 20% dan MPS 10 Juta Karena Merit Increase" :
                        switch (idJenisMps){
                            case "1" :
                                jasperFileName = "RincianPembayaranMPS_20pMI";
                                parameters = new HashMap<>();
                                parameters.put("periode_mutasi", periodeMutasi);
                                parameters.put("id_kantor_bayar", idKantorBayar);
                                parameters.put("tgl_henti", tglHenti);
                                break;
                            case "2" :
                                jasperFileName = "DaftarRincianPembayaranMPS10jtMeritIncrease";
                                parameters = new HashMap<>();
                                parameters.put("periode_mutasi", periodeMutasi);
                                parameters.put("id_kantor_bayar", idKantorBayar);
                                parameters.put("tgl_henti", tglHenti);
                                break;
                        }
                        break;

                    case "015" :
                        switch (idJenisMps){
                            case "1" :
                                jasperFileName = "RincianPerCabangRapelMPS20persen_MI";
                                parameters = new HashMap<>();
                                parameters.put("perioe_mutasi", periodeMutasi);
                                parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                parameters.put("id_kantor_bayar", idKantorBayar);
                                break;
                            case "2" :
                                jasperFileName = "RincianPerCabangRapelMPS10jt_MI";
                                parameters = new HashMap<>();
                                parameters.put("perioe_mutasi", periodeMutasi);
                                parameters.put("id_kategori_pensiun", idKategoriPensiun);
                                parameters.put("id_kantor_bayar", idKantorBayar);
                                break;
                        }
                        break;

                    case "016" :
                        jasperFileName = "RincianDaftarPembayaranManfaatPensiunBulananPN";
                        parameters = new HashMap<>();
                        parameters.put("periode_pembayaran", periodeMutasi);
                        parameters.put("id_kategori_pensiun", idKategoriPensiun);
                        parameters.put("id_kantor_bayar", idKantorBayar);
                        break;

                    case "017" :
                        jasperFileName = "RekapitulasiPembayaranManfaatPensiunBulananPN";
                        parameters = new HashMap<>();
                        parameters.put("periode_pembayaran", periodeMutasi);
                        parameters.put("id_kategori_pensiun", idKategoriPensiun);
                        parameters.put("id_kantor_bayar", kantorPusat);
                        break;

                    case "018" :
                        jasperFileName = "RekapitulasiPembayaranRapelMPS20_PensiunDipercepat_PC";
                        parameters = new HashMap<>();
                        parameters.put("periode_mutasi", periodeMutasi);
                        parameters.put("id_kategori_pensiun", idKategoriPensiun);
                        parameters.put("id_kantor_bayar", kantorPusat);
                        parameters.put("tgl_henti", tglHenti);
                        break;

                    case "019" :
                        switch (idJenisMps) {
                            case "1":
                                jasperFileName = "RekapPembayaranMI20persen";
                                parameters = new HashMap<>();
                                parameters.put("periode_mutasi", periodeMutasi);
                                parameters.put("id_kantor_bayar", idKantorBayar);
                                parameters.put("tgl_henti", tglHenti);
                                break;

                            case "2":
                                jasperFileName = "RekapPembayaranMI10juta";
                                parameters = new HashMap<>();
                                parameters.put("periode_mutasi", periodeMutasi);
                                parameters.put("id_kantor_bayar", idKantorBayar);
                                parameters.put("tgl_henti", tglHenti);
                                break;
                        }
                        break;

                    case "111" :
                        jasperFileName = "DaftarRekapPembayaranUangPembinaan";
                        parameters = new HashMap<>();
                        parameters.put("periode_bayar", tahun);
                        parameters.put("id_kantor_bayar", idKantorBayar);
                        break;

                    case "112" :
                        jasperFileName = "DaftarPembayaranMP_dan_UangPembinaan";
                        parameters = new HashMap<>();
                        parameters.put("periode_bayar", periodeMutasi);
                        parameters.put("status_her", statusHer);
                        parameters.put("id_kantor_bayar", idKantorBayar);
                        break;

                    case "113" :
                        jasperFileName = "DaftarNamaPenerima_UangPembinaan_1jt";
                        parameters = new HashMap<>();
                        parameters.put("periode_bayar", tahun);
                        parameters.put("id_kantor_bayar", idKantorBayar);
                        break;

                    case "211" :
                        jasperFileName = "RekapRapelMPS20persen_Karena_KenaikanMP";
                        parameters = new HashMap<>();
                        parameters.put("periode_mutasi", periodeMutasi);
                        parameters.put("id_kategori_pensiun", idKategoriPensiun);
                        parameters.put("id_kantor_bayar", idKantorBayar);
                        break;

                    case "212" :
                        jasperFileName = "RekapPembayaranRapelMps10juta";
                        parameters = new HashMap<>();
                        parameters.put("periode_mutasi", periodeMutasi);
                        parameters.put("id_kategori_pensiun", idKategoriPensiun);
                        parameters.put("id_kantor_bayar", idKantorBayar);
                        break;

                    case "213" :
                        jasperFileName = "RincianRapelMPS20persen_kenaikanMP";
                        parameters = new HashMap<>();
                        parameters.put("periode_mutasi", periodeMutasi);
                        parameters.put("id_kategori_pensiun", idKategoriPensiun);
                        parameters.put("id_kantor_bayar", idKantorBayar);
                        break;

                    case "214" :
                        jasperFileName = "RincianRapelMP10jt_PN_kenaikanMP";
                        parameters = new HashMap<>();
                        parameters.put("periode_mutasi", periodeMutasi);
                        parameters.put("id_kategori_pensiun", idKategoriPensiun);
                        parameters.put("id_kantor_bayar", idKantorBayar);
                        break;

                    case "215" :
                        jasperFileName = "DaftarRapelKenaikanMP_3persen";
                        parameters = new HashMap<>();
                        parameters.put("periode_mutasi", periodeMutasi);
                        parameters.put("status_her", statusHer);
                        parameters.put("id_kantor_bayar", idKantorBayar);
                        break;

                    case "216" :
                        jasperFileName = "DaftarPenerimaKenaikanRapelMP_3persen_PensiunHapus";
                        parameters = new HashMap<>();
                        parameters.put("periode_mutasi", periodeMutasi);
                        break;

                    case "217" :
                        jasperFileName = "DaftarPenerimaKenaikanRapelMP_3persen_JandaDudaAnak";
                        parameters = new HashMap<>();
                        parameters.put("periode_mutasi", periodeMutasi);
                        break;

                    case "311" :
                        jasperFileName = "TataUsahaInternalPiutangMP";
                        parameters = new HashMap<>();
                        parameters.put("periode_mutasi", periodeMutasi);
                        break;

                    case "312" :
                        jasperFileName = "PembukuanPiutangMP";
                        parameters = new HashMap<>();
                        parameters.put("periode_mutasi", periodeMutasi);
                        parameters.put("nip", nip);
                        break;

                    case "313" :
                        jasperFileName = "DaftarHutangMP_perPeriod";
                        parameters = new HashMap<>();
                        parameters.put("periode_mutasi", periodeMutasi);
                        break;

                    case "Data Input Rekening Pensiunan" :
                        jasperFileName = "DataInputRekeningPensiunan";
                        parameters = new HashMap<>();
                        parameters.put("start_date", startDate);
                        parameters.put("end_date", endDate);
                        break;

                    case "Daftar Pensiunan Yang Belum Mempunyai No.Rekening" :
                        jasperFileName = "DaftarPensiunanYgBelumPunyaNo_Rek";
                        parameters = new HashMap<>();
                        parameters.put("periode_mutasi", periodeMutasi);
                        parameters.put("id_kantor_bayar", idKantorBayar);
                        break;

                    case "Daftar No.Rekening Mandiri Untuk Pensiun Baru dan Perubahan" :
                        jasperFileName = "DaftarNo_RekMandiriUntukPensiunanBaruDanPerubahan";
                        parameters = new HashMap<>();
                        parameters.put("start_date", startDate);
                        parameters.put("end_date", endDate);
                        break;

                    case "Daftar Data Perubahan Nomor Rekening" :
                        jasperFileName = "DaftarDataPerubahanRekening";
                        parameters = new HashMap<>();
                        parameters.put("start_date", startDate);
                        parameters.put("end_date", endDate);
                        parameters.put("user_validasi", "ASEP");
                        break;

                    case "Daftar Perubahan No.Rekening" :
                        jasperFileName = "DaftarPerubahanNomorRekening";
                        parameters = new HashMap<>();
                        parameters.put("start_date", startDate);
                        parameters.put("end_date", endDate);
                        parameters.put("user_validasi", "ASEP");
                        break;

                    case "Daftar Rekening Pensiun baru MPS 20% Yang dibayarkan" :
                        jasperFileName = "DaftarRekeningPensiunBaruYgDibayarkan";
                        parameters = new HashMap<>();
                        parameters.put("start_date", startDate);
                        parameters.put("end_date", endDate);
                        parameters.put("id_kategori_pensiun", idKategoriPensiun);
                        parameters.put("user_validasi", "AGUS");
                        break;

                    case "Daftar Rekening Pensiun baru MPS > Rp. 10 Juta Yang dibayarkan" :
                        jasperFileName = "DaftarRekeningPensiunBaruYgDibayarkanMPS10jt";
                        parameters = new HashMap<>();
                        parameters.put("start_date", startDate);
                        parameters.put("end_date", endDate);
                        parameters.put("id_kategori_pensiun", idKategoriPensiun);
                        parameters.put("user_validasi", "AGUS");
                        break;

                    case "Daftar Rekening Pensiun baru MPS < 1,5 Juta Yang dibayarkan" :
                        jasperFileName = "DaftarRekeningPensiunMPS__1_5jt";
                        parameters = new HashMap<>();
                        parameters.put("start_date", startDate);
                        parameters.put("end_date", endDate);
                        parameters.put("id_kategori_pensiun", idKategoriPensiun);
                        parameters.put("user_validasi", "AGUS");
                        break;

                    case "511" :
                        jasperFileName = "DaftarPemindahbukuanPembayaranMP_NF";
                        parameters = new HashMap<>();
                        parameters.put("periode_mutasi", periodeMutasi);
                        break;

                    case "611" :
                        switch (type) {
                            case "PL" :
                            jasperFileName = "ProyeksiJumlahPenerimaManfaaPensiunLama";
                            parameters = new HashMap<>();
                            parameters.put("type", type);
                            break;
                            case "PB" :
                            jasperFileName = "ProyeksiJumlahPenerimaManfaaPensiunBaru";
                            parameters = new HashMap<>();
                            parameters.put("type", type);
                            break;
                        }

                        break;

                    case "612" :
                        switch (type) {
                            case "PB" :
                            jasperFileName = "DaftarProyeksiPensiunBaru";
                            parameters = new HashMap<>();
                            parameters.put("type", type);
                            break;

                            case "PL" :
                            jasperFileName = "DaftarProyeksiPensiunLama";
                            parameters = new HashMap<>();
                            parameters.put("type", type);
                            break;
                        }
                        break;

                    case "411" :
                        jasperFileName = "RekapitulasiPerubahanFPR_FS_MPS20_ALL_KP";
                        parameters = new HashMap<>();
                        parameters.put("periode_mutasi", periodeMutasi);
                        parameters.put("id_kategori_pensiun", idKategoriPensiun);
                        break;

                    case "412" :
                        jasperFileName = "RekapitulasiPerubahanFPR_FS_MPS10jt_ALL_KP";
                        parameters = new HashMap<>();
                        parameters.put("periode_mutasi", periodeMutasi);
                        parameters.put("id_kategori_pensiun", idKategoriPensiun);
                        break;

                    case "413" :
                        jasperFileName = "RekapitulasiPerubahanFPR_FS_MPS1_5jt_ALL_KP";
                        parameters = new HashMap<>();
                        parameters.put("periode_mutasi", periodeMutasi);
                        parameters.put("id_kategori_pensiun", idKategoriPensiun);
                        break;

                    case "414" :
                        jasperFileName = "RincianRapelMPS20persen_perubahanFPR_FS_All_KategorPensiuni";
                        parameters = new HashMap<>();
                        parameters.put("periode_mutasi", periodeMutasi);
                        parameters.put("id_kategori_pensiun", idKategoriPensiun);
                        parameters.put("id_kantor_bayar", idKantorBayar);
                        break;

                    case "415" :
                        jasperFileName = "RincianRapelMPS10juta_perubahanFPR_FS_All_KategorPensiun";
                        parameters = new HashMap<>();
                        parameters.put("periode_mutasi", periodeMutasi);
                        parameters.put("id_kategori_pensiun", idKategoriPensiun);
                        parameters.put("id_kantor_bayar", idKantorBayar);
                        break;

                    case "416" :
                        jasperFileName = "RincianRapelMPS_1_5jt_perubahanFPR_FS_All_KategorPensiun";
                        parameters = new HashMap<>();
                        parameters.put("periode_mutasi", periodeMutasi);
                        parameters.put("id_kategori_pensiun", idKategoriPensiun);
                        parameters.put("id_kantor_bayar", idKantorBayar);
                        break;

                }
                if (jasperFileName != null){
                    tampilkanReport(httpServletResponse, periodeMutasi, download, parameters, jasperFileName);
                }

        }catch(IOException | JRException e){
            e.printStackTrace();
        }

    }

    private void tampilkanReport(HttpServletResponse httpServletResponse, String periodeMutasi, Boolean download, Map<String, Object> parameters, String jasperFileName ) throws JRException, IOException {
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
        } catch (IOException | JRException | JRRuntimeException e) {
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

        }catch (JRRuntimeException ex){
            ex.printStackTrace();
        }
    }
}
